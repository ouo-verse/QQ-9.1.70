package com.google.android.exoplayer2.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* loaded from: classes2.dex */
public final class PesReader implements TsPayloadReader {
    private static final int HEADER_SIZE = 9;
    private static final int MAX_HEADER_EXTENSION_SIZE = 10;
    private static final int PES_SCRATCH_SIZE = 10;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_BODY = 3;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_HEADER_EXTENSION = 2;
    private static final String TAG = "PesReader";
    private int bytesRead;
    private boolean dataAlignmentIndicator;
    private boolean dtsFlag;
    private int extendedHeaderLength;
    private int payloadSize;
    private boolean ptsFlag;
    private final ElementaryStreamReader reader;
    private boolean seenFirstDts;
    private long timeUs;
    private TimestampAdjuster timestampAdjuster;
    private final ParsableBitArray pesScratch = new ParsableBitArray(new byte[10]);
    private int state = 0;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        this.reader = elementaryStreamReader;
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i3) {
        int min = Math.min(parsableByteArray.bytesLeft(), i3 - this.bytesRead);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.skipBytes(min);
        } else {
            parsableByteArray.readBytes(bArr, this.bytesRead, min);
        }
        int i16 = this.bytesRead + min;
        this.bytesRead = i16;
        if (i16 == i3) {
            return true;
        }
        return false;
    }

    private boolean parseHeader() {
        this.pesScratch.setPosition(0);
        int readBits = this.pesScratch.readBits(24);
        if (readBits != 1) {
            Log.w(TAG, "Unexpected start code prefix: " + readBits);
            this.payloadSize = -1;
            return false;
        }
        this.pesScratch.skipBits(8);
        int readBits2 = this.pesScratch.readBits(16);
        this.pesScratch.skipBits(5);
        this.dataAlignmentIndicator = this.pesScratch.readBit();
        this.pesScratch.skipBits(2);
        this.ptsFlag = this.pesScratch.readBit();
        this.dtsFlag = this.pesScratch.readBit();
        this.pesScratch.skipBits(6);
        int readBits3 = this.pesScratch.readBits(8);
        this.extendedHeaderLength = readBits3;
        if (readBits2 == 0) {
            this.payloadSize = -1;
        } else {
            this.payloadSize = ((readBits2 + 6) - 9) - readBits3;
        }
        return true;
    }

    private void parseHeaderExtension() {
        this.pesScratch.setPosition(0);
        this.timeUs = -9223372036854775807L;
        if (this.ptsFlag) {
            this.pesScratch.skipBits(4);
            this.pesScratch.skipBits(1);
            this.pesScratch.skipBits(1);
            long readBits = (this.pesScratch.readBits(3) << 30) | (this.pesScratch.readBits(15) << 15) | this.pesScratch.readBits(15);
            this.pesScratch.skipBits(1);
            if (!this.seenFirstDts && this.dtsFlag) {
                this.pesScratch.skipBits(4);
                this.pesScratch.skipBits(1);
                this.pesScratch.skipBits(1);
                this.pesScratch.skipBits(1);
                this.timestampAdjuster.adjustTsTimestamp((this.pesScratch.readBits(3) << 30) | (this.pesScratch.readBits(15) << 15) | this.pesScratch.readBits(15));
                this.seenFirstDts = true;
            }
            this.timeUs = this.timestampAdjuster.adjustTsTimestamp(readBits);
        }
    }

    private void setState(int i3) {
        this.state = i3;
        this.bytesRead = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void consume(ParsableByteArray parsableByteArray, boolean z16) throws ParserException {
        if (z16) {
            int i3 = this.state;
            if (i3 != 2) {
                if (i3 == 3) {
                    if (this.payloadSize != -1) {
                        Log.w(TAG, "Unexpected start indicator: expected " + this.payloadSize + " more bytes");
                    }
                    this.reader.packetFinished();
                }
            } else {
                Log.w(TAG, "Unexpected start indicator reading extended header");
            }
            setState(1);
        }
        while (parsableByteArray.bytesLeft() > 0) {
            int i16 = this.state;
            if (i16 != 0) {
                int i17 = 0;
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 == 3) {
                            int bytesLeft = parsableByteArray.bytesLeft();
                            int i18 = this.payloadSize;
                            if (i18 != -1) {
                                i17 = bytesLeft - i18;
                            }
                            if (i17 > 0) {
                                bytesLeft -= i17;
                                parsableByteArray.setLimit(parsableByteArray.getPosition() + bytesLeft);
                            }
                            this.reader.consume(parsableByteArray);
                            int i19 = this.payloadSize;
                            if (i19 != -1) {
                                int i26 = i19 - bytesLeft;
                                this.payloadSize = i26;
                                if (i26 == 0) {
                                    this.reader.packetFinished();
                                    setState(1);
                                }
                            }
                        }
                    } else {
                        if (continueRead(parsableByteArray, this.pesScratch.data, Math.min(10, this.extendedHeaderLength)) && continueRead(parsableByteArray, null, this.extendedHeaderLength)) {
                            parseHeaderExtension();
                            this.reader.packetStarted(this.timeUs, this.dataAlignmentIndicator);
                            setState(3);
                        }
                    }
                } else if (continueRead(parsableByteArray, this.pesScratch.data, 9)) {
                    if (parseHeader()) {
                        i17 = 2;
                    }
                    setState(i17);
                }
            } else {
                parsableByteArray.skipBytes(parsableByteArray.bytesLeft());
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.timestampAdjuster = timestampAdjuster;
        this.reader.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.seenFirstDts = false;
        this.reader.seek();
    }
}
