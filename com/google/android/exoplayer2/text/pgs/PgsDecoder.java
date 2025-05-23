package com.google.android.exoplayer2.text.pgs;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class PgsDecoder extends SimpleSubtitleDecoder {
    private static final int SECTION_TYPE_BITMAP_PICTURE = 21;
    private static final int SECTION_TYPE_END = 128;
    private static final int SECTION_TYPE_IDENTIFIER = 22;
    private static final int SECTION_TYPE_PALETTE = 20;
    private final ParsableByteArray buffer;
    private final CueBuilder cueBuilder;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class CueBuilder {
        private int bitmapHeight;
        private int bitmapWidth;
        private int bitmapX;
        private int bitmapY;
        private boolean colorsSet;
        private int planeHeight;
        private int planeWidth;
        private final ParsableByteArray bitmapData = new ParsableByteArray();
        private final int[] colors = new int[256];

        /* JADX INFO: Access modifiers changed from: private */
        public void parseBitmapSection(ParsableByteArray parsableByteArray, int i3) {
            boolean z16;
            int readUnsignedInt24;
            if (i3 < 4) {
                return;
            }
            parsableByteArray.skipBytes(3);
            if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i16 = i3 - 4;
            if (z16) {
                if (i16 < 7 || (readUnsignedInt24 = parsableByteArray.readUnsignedInt24()) < 4) {
                    return;
                }
                this.bitmapWidth = parsableByteArray.readUnsignedShort();
                this.bitmapHeight = parsableByteArray.readUnsignedShort();
                this.bitmapData.reset(readUnsignedInt24 - 4);
                i16 -= 7;
            }
            int position = this.bitmapData.getPosition();
            int limit = this.bitmapData.limit();
            if (position < limit && i16 > 0) {
                int min = Math.min(i16, limit - position);
                parsableByteArray.readBytes(this.bitmapData.data, position, min);
                this.bitmapData.setPosition(position + min);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parseIdentifierSection(ParsableByteArray parsableByteArray, int i3) {
            if (i3 < 19) {
                return;
            }
            this.planeWidth = parsableByteArray.readUnsignedShort();
            this.planeHeight = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(11);
            this.bitmapX = parsableByteArray.readUnsignedShort();
            this.bitmapY = parsableByteArray.readUnsignedShort();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parsePaletteSection(ParsableByteArray parsableByteArray, int i3) {
            if (i3 % 5 != 2) {
                return;
            }
            parsableByteArray.skipBytes(2);
            Arrays.fill(this.colors, 0);
            int i16 = i3 / 5;
            for (int i17 = 0; i17 < i16; i17++) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                double d16 = readUnsignedByte2;
                double d17 = readUnsignedByte3 - 128;
                double d18 = readUnsignedByte4 - 128;
                this.colors[readUnsignedByte] = (Util.constrainValue((int) ((d16 - (0.34414d * d18)) - (d17 * 0.71414d)), 0, 255) << 8) | (parsableByteArray.readUnsignedByte() << 24) | (Util.constrainValue((int) ((1.402d * d17) + d16), 0, 255) << 16) | Util.constrainValue((int) (d16 + (d18 * 1.772d)), 0, 255);
            }
            this.colorsSet = true;
        }

        public Cue build() {
            int i3;
            int readUnsignedByte;
            int i16;
            if (this.planeWidth != 0 && this.planeHeight != 0 && this.bitmapWidth != 0 && this.bitmapHeight != 0 && this.bitmapData.limit() != 0 && this.bitmapData.getPosition() == this.bitmapData.limit() && this.colorsSet) {
                this.bitmapData.setPosition(0);
                int i17 = this.bitmapWidth * this.bitmapHeight;
                int[] iArr = new int[i17];
                int i18 = 0;
                while (i18 < i17) {
                    int readUnsignedByte2 = this.bitmapData.readUnsignedByte();
                    if (readUnsignedByte2 != 0) {
                        i3 = i18 + 1;
                        iArr[i18] = this.colors[readUnsignedByte2];
                    } else {
                        int readUnsignedByte3 = this.bitmapData.readUnsignedByte();
                        if (readUnsignedByte3 != 0) {
                            if ((readUnsignedByte3 & 64) == 0) {
                                readUnsignedByte = readUnsignedByte3 & 63;
                            } else {
                                readUnsignedByte = ((readUnsignedByte3 & 63) << 8) | this.bitmapData.readUnsignedByte();
                            }
                            if ((readUnsignedByte3 & 128) == 0) {
                                i16 = 0;
                            } else {
                                i16 = this.colors[this.bitmapData.readUnsignedByte()];
                            }
                            i3 = readUnsignedByte + i18;
                            Arrays.fill(iArr, i18, i3, i16);
                        }
                    }
                    i18 = i3;
                }
                Bitmap createBitmap = Bitmap.createBitmap(iArr, this.bitmapWidth, this.bitmapHeight, Bitmap.Config.ARGB_8888);
                float f16 = this.bitmapX;
                int i19 = this.planeWidth;
                float f17 = f16 / i19;
                float f18 = this.bitmapY;
                int i26 = this.planeHeight;
                return new Cue(createBitmap, f17, 0, f18 / i26, 0, this.bitmapWidth / i19, this.bitmapHeight / i26);
            }
            return null;
        }

        public void reset() {
            this.planeWidth = 0;
            this.planeHeight = 0;
            this.bitmapX = 0;
            this.bitmapY = 0;
            this.bitmapWidth = 0;
            this.bitmapHeight = 0;
            this.bitmapData.reset(0);
            this.colorsSet = false;
        }
    }

    public PgsDecoder() {
        super("PgsDecoder");
        this.buffer = new ParsableByteArray();
        this.cueBuilder = new CueBuilder();
    }

    private static Cue readNextSection(ParsableByteArray parsableByteArray, CueBuilder cueBuilder) {
        int limit = parsableByteArray.limit();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition() + readUnsignedShort;
        Cue cue = null;
        if (position > limit) {
            parsableByteArray.setPosition(limit);
            return null;
        }
        if (readUnsignedByte != 128) {
            switch (readUnsignedByte) {
                case 20:
                    cueBuilder.parsePaletteSection(parsableByteArray, readUnsignedShort);
                    break;
                case 21:
                    cueBuilder.parseBitmapSection(parsableByteArray, readUnsignedShort);
                    break;
                case 22:
                    cueBuilder.parseIdentifierSection(parsableByteArray, readUnsignedShort);
                    break;
            }
        } else {
            cue = cueBuilder.build();
            cueBuilder.reset();
        }
        parsableByteArray.setPosition(position);
        return cue;
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected Subtitle decode(byte[] bArr, int i3, boolean z16) throws SubtitleDecoderException {
        this.buffer.reset(bArr, i3);
        this.cueBuilder.reset();
        ArrayList arrayList = new ArrayList();
        while (this.buffer.bytesLeft() >= 3) {
            Cue readNextSection = readNextSection(this.buffer, this.cueBuilder);
            if (readNextSection != null) {
                arrayList.add(readNextSection);
            }
        }
        return new PgsSubtitle(Collections.unmodifiableList(arrayList));
    }
}
