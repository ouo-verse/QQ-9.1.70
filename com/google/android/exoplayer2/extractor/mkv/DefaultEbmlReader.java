package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes2.dex */
final class DefaultEbmlReader implements EbmlReader {
    private static final int ELEMENT_STATE_READ_CONTENT = 2;
    private static final int ELEMENT_STATE_READ_CONTENT_SIZE = 1;
    private static final int ELEMENT_STATE_READ_ID = 0;
    private static final int MAX_ID_BYTES = 4;
    private static final int MAX_INTEGER_ELEMENT_SIZE_BYTES = 8;
    private static final int MAX_LENGTH_BYTES = 8;
    private static final int VALID_FLOAT32_ELEMENT_SIZE_BYTES = 4;
    private static final int VALID_FLOAT64_ELEMENT_SIZE_BYTES = 8;
    private long elementContentSize;
    private int elementId;
    private int elementState;
    private EbmlReaderOutput output;
    private final byte[] scratch = new byte[8];
    private final Stack<MasterElement> masterElementsStack = new Stack<>();
    private final VarintReader varintReader = new VarintReader();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class MasterElement {
        private final long elementEndPosition;
        private final int elementId;

        MasterElement(int i3, long j3) {
            this.elementId = i3;
            this.elementEndPosition = j3;
        }
    }

    private long maybeResyncToNextLevel1Element(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.resetPeekPosition();
        while (true) {
            extractorInput.peekFully(this.scratch, 0, 4);
            int parseUnsignedVarintLength = VarintReader.parseUnsignedVarintLength(this.scratch[0]);
            if (parseUnsignedVarintLength != -1 && parseUnsignedVarintLength <= 4) {
                int assembleVarint = (int) VarintReader.assembleVarint(this.scratch, parseUnsignedVarintLength, false);
                if (this.output.isLevel1Element(assembleVarint)) {
                    extractorInput.skipFully(parseUnsignedVarintLength);
                    return assembleVarint;
                }
            }
            extractorInput.skipFully(1);
        }
    }

    private double readFloat(ExtractorInput extractorInput, int i3) throws IOException, InterruptedException {
        long readInteger = readInteger(extractorInput, i3);
        if (i3 == 4) {
            return Float.intBitsToFloat((int) readInteger);
        }
        return Double.longBitsToDouble(readInteger);
    }

    private long readInteger(ExtractorInput extractorInput, int i3) throws IOException, InterruptedException {
        extractorInput.readFully(this.scratch, 0, i3);
        long j3 = 0;
        for (int i16 = 0; i16 < i3; i16++) {
            j3 = (j3 << 8) | (this.scratch[i16] & 255);
        }
        return j3;
    }

    private String readString(ExtractorInput extractorInput, int i3) throws IOException, InterruptedException {
        if (i3 == 0) {
            return "";
        }
        byte[] bArr = new byte[i3];
        extractorInput.readFully(bArr, 0, i3);
        return new String(bArr);
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void init(EbmlReaderOutput ebmlReaderOutput) {
        this.output = ebmlReaderOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public boolean read(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z16;
        if (this.output != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        while (true) {
            if (!this.masterElementsStack.isEmpty() && extractorInput.getPosition() >= this.masterElementsStack.peek().elementEndPosition) {
                this.output.endMasterElement(this.masterElementsStack.pop().elementId);
                return true;
            }
            if (this.elementState == 0) {
                long readUnsignedVarint = this.varintReader.readUnsignedVarint(extractorInput, true, false, 4);
                if (readUnsignedVarint == -2) {
                    readUnsignedVarint = maybeResyncToNextLevel1Element(extractorInput);
                }
                if (readUnsignedVarint == -1) {
                    return false;
                }
                this.elementId = (int) readUnsignedVarint;
                this.elementState = 1;
            }
            if (this.elementState == 1) {
                this.elementContentSize = this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
                this.elementState = 2;
            }
            int elementType = this.output.getElementType(this.elementId);
            if (elementType != 0) {
                if (elementType != 1) {
                    if (elementType != 2) {
                        if (elementType != 3) {
                            if (elementType != 4) {
                                if (elementType == 5) {
                                    long j3 = this.elementContentSize;
                                    if (j3 != 4 && j3 != 8) {
                                        throw new ParserException("Invalid float size: " + this.elementContentSize);
                                    }
                                    this.output.floatElement(this.elementId, readFloat(extractorInput, (int) j3));
                                    this.elementState = 0;
                                    return true;
                                }
                                throw new ParserException("Invalid element type " + elementType);
                            }
                            this.output.binaryElement(this.elementId, (int) this.elementContentSize, extractorInput);
                            this.elementState = 0;
                            return true;
                        }
                        long j16 = this.elementContentSize;
                        if (j16 <= TTL.MAX_VALUE) {
                            this.output.stringElement(this.elementId, readString(extractorInput, (int) j16));
                            this.elementState = 0;
                            return true;
                        }
                        throw new ParserException("String element size: " + this.elementContentSize);
                    }
                    long j17 = this.elementContentSize;
                    if (j17 <= 8) {
                        this.output.integerElement(this.elementId, readInteger(extractorInput, (int) j17));
                        this.elementState = 0;
                        return true;
                    }
                    throw new ParserException("Invalid integer size: " + this.elementContentSize);
                }
                long position = extractorInput.getPosition();
                this.masterElementsStack.add(new MasterElement(this.elementId, this.elementContentSize + position));
                this.output.startMasterElement(this.elementId, position, this.elementContentSize);
                this.elementState = 0;
                return true;
            }
            extractorInput.skipFully((int) this.elementContentSize);
            this.elementState = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void reset() {
        this.elementState = 0;
        this.masterElementsStack.clear();
        this.varintReader.reset();
    }
}
