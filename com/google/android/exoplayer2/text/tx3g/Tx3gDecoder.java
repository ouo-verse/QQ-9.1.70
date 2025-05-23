package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import cooperation.qzone.QZoneHelper;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private static final char BOM_UTF16_BE = '\ufeff';
    private static final char BOM_UTF16_LE = '\ufffe';
    private static final int DEFAULT_COLOR = -1;
    private static final int DEFAULT_FONT_FACE = 0;
    private static final String DEFAULT_FONT_FAMILY = "sans-serif";
    private static final float DEFAULT_VERTICAL_PLACEMENT = 0.85f;
    private static final int FONT_FACE_BOLD = 1;
    private static final int FONT_FACE_ITALIC = 2;
    private static final int FONT_FACE_UNDERLINE = 4;
    private static final int SIZE_ATOM_HEADER = 8;
    private static final int SIZE_BOM_UTF16 = 2;
    private static final int SIZE_SHORT = 2;
    private static final int SIZE_STYLE_RECORD = 12;
    private static final int SPAN_PRIORITY_HIGH = 0;
    private static final int SPAN_PRIORITY_LOW = 16711680;
    private static final String TX3G_SERIF = "Serif";
    private static final int TYPE_STYL = Util.getIntegerCodeForString("styl");
    private static final int TYPE_TBOX = Util.getIntegerCodeForString("tbox");
    private int calculatedVideoTrackHeight;
    private boolean customVerticalPlacement;
    private int defaultColorRgba;
    private int defaultFontFace;
    private String defaultFontFamily;
    private float defaultVerticalPlacement;
    private final ParsableByteArray parsableByteArray;

    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        this.parsableByteArray = new ParsableByteArray();
        decodeInitializationData(list);
    }

    private void applyStyleRecord(ParsableByteArray parsableByteArray, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        boolean z16;
        if (parsableByteArray.bytesLeft() >= 12) {
            z16 = true;
        } else {
            z16 = false;
        }
        assertTrue(z16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int readInt = parsableByteArray.readInt();
        attachFontFace(spannableStringBuilder, readUnsignedByte, this.defaultFontFace, readUnsignedShort, readUnsignedShort2, 0);
        attachColor(spannableStringBuilder, readInt, this.defaultColorRgba, readUnsignedShort, readUnsignedShort2, 0);
    }

    private static void assertTrue(boolean z16) throws SubtitleDecoderException {
        if (z16) {
        } else {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void attachColor(SpannableStringBuilder spannableStringBuilder, int i3, int i16, int i17, int i18, int i19) {
        if (i3 != i16) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i3 >>> 8) | ((i3 & 255) << 24)), i17, i18, i19 | 33);
        }
    }

    private static void attachFontFace(SpannableStringBuilder spannableStringBuilder, int i3, int i16, int i17, int i18, int i19) {
        boolean z16;
        boolean z17;
        if (i3 != i16) {
            int i26 = i19 | 33;
            boolean z18 = true;
            if ((i3 & 1) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((i3 & 2) != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16) {
                if (z17) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i17, i18, i26);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i17, i18, i26);
                }
            } else if (z17) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i17, i18, i26);
            }
            if ((i3 & 4) == 0) {
                z18 = false;
            }
            if (z18) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i17, i18, i26);
            }
            if (!z18 && !z16 && !z17) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i17, i18, i26);
            }
        }
    }

    private static void attachFontFamily(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i3, int i16, int i17) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i3, i16, i17 | 33);
        }
    }

    private void decodeInitializationData(List<byte[]> list) {
        String str = "sans-serif";
        boolean z16 = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.defaultFontFace = bArr[24];
            this.defaultColorRgba = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            if (TX3G_SERIF.equals(new String(bArr, 43, bArr.length - 43))) {
                str = C.SERIF_NAME;
            }
            this.defaultFontFamily = str;
            int i3 = bArr[25] * QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA;
            this.calculatedVideoTrackHeight = i3;
            if ((bArr[0] & 32) != 0) {
                z16 = true;
            }
            this.customVerticalPlacement = z16;
            if (z16) {
                float f16 = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i3;
                this.defaultVerticalPlacement = f16;
                this.defaultVerticalPlacement = Util.constrainValue(f16, 0.0f, 0.95f);
                return;
            }
            this.defaultVerticalPlacement = 0.85f;
            return;
        }
        this.defaultFontFace = 0;
        this.defaultColorRgba = -1;
        this.defaultFontFamily = "sans-serif";
        this.customVerticalPlacement = false;
        this.defaultVerticalPlacement = 0.85f;
    }

    private static String readSubtitleText(ParsableByteArray parsableByteArray) throws SubtitleDecoderException {
        boolean z16;
        char peekChar;
        if (parsableByteArray.bytesLeft() >= 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        assertTrue(z16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        if (readUnsignedShort == 0) {
            return "";
        }
        if (parsableByteArray.bytesLeft() >= 2 && ((peekChar = parsableByteArray.peekChar()) == '\ufeff' || peekChar == '\ufffe')) {
            return parsableByteArray.readString(readUnsignedShort, Charset.forName("UTF-16"));
        }
        return parsableByteArray.readString(readUnsignedShort, Charset.forName("UTF-8"));
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected Subtitle decode(byte[] bArr, int i3, boolean z16) throws SubtitleDecoderException {
        this.parsableByteArray.reset(bArr, i3);
        String readSubtitleText = readSubtitleText(this.parsableByteArray);
        if (readSubtitleText.isEmpty()) {
            return Tx3gSubtitle.EMPTY;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(readSubtitleText);
        attachFontFace(spannableStringBuilder, this.defaultFontFace, 0, 0, spannableStringBuilder.length(), 16711680);
        attachColor(spannableStringBuilder, this.defaultColorRgba, -1, 0, spannableStringBuilder.length(), 16711680);
        attachFontFamily(spannableStringBuilder, this.defaultFontFamily, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float f16 = this.defaultVerticalPlacement;
        while (this.parsableByteArray.bytesLeft() >= 8) {
            int position = this.parsableByteArray.getPosition();
            int readInt = this.parsableByteArray.readInt();
            int readInt2 = this.parsableByteArray.readInt();
            boolean z17 = true;
            if (readInt2 == TYPE_STYL) {
                if (this.parsableByteArray.bytesLeft() < 2) {
                    z17 = false;
                }
                assertTrue(z17);
                int readUnsignedShort = this.parsableByteArray.readUnsignedShort();
                for (int i16 = 0; i16 < readUnsignedShort; i16++) {
                    applyStyleRecord(this.parsableByteArray, spannableStringBuilder);
                }
            } else if (readInt2 == TYPE_TBOX && this.customVerticalPlacement) {
                if (this.parsableByteArray.bytesLeft() < 2) {
                    z17 = false;
                }
                assertTrue(z17);
                f16 = Util.constrainValue(this.parsableByteArray.readUnsignedShort() / this.calculatedVideoTrackHeight, 0.0f, 0.95f);
            }
            this.parsableByteArray.setPosition(position + readInt);
        }
        return new Tx3gSubtitle(new Cue(spannableStringBuilder, null, f16, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }
}
