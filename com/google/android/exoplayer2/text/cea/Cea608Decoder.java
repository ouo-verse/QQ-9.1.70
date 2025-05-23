package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.internal.view.SupportMenu;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.tencent.component.media.MtpConstants;
import java.util.ArrayList;
import java.util.List;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Cea608Decoder extends CeaDecoder {
    private static final int CC_FIELD_FLAG = 1;
    private static final byte CC_IMPLICIT_DATA_HEADER = -4;
    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int CC_TYPE_FLAG = 2;
    private static final int CC_VALID_608_ID = 4;
    private static final int CC_VALID_FLAG = 4;
    private static final byte CTRL_BACKSPACE = 33;
    private static final byte CTRL_CARRIAGE_RETURN = 45;
    private static final byte CTRL_DELETE_TO_END_OF_ROW = 36;
    private static final byte CTRL_END_OF_CAPTION = 47;
    private static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
    private static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
    private static final byte CTRL_RESUME_CAPTION_LOADING = 32;
    private static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
    private static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
    private static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
    private static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    private static final int NTSC_CC_FIELD_1 = 0;
    private static final int NTSC_CC_FIELD_2 = 1;
    private int captionMode;
    private int captionRowCount;
    private List<Cue> cues;
    private List<Cue> lastCues;
    private final int packetLength;
    private byte repeatableControlCc1;
    private byte repeatableControlCc2;
    private boolean repeatableControlSet;
    private final int selectedField;
    private static final int[] ROW_INDICES = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] COLUMN_INDICES = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] COLORS = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, -256, -65281};
    private static final int[] BASIC_CHARACTER_SET = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] SPECIAL_CHARACTER_SET = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] SPECIAL_ES_FR_CHARACTER_SET = {193, 201, 211, 218, 220, 252, MtpConstants.RESPONSE_CAPTURE_ALREADY_TERMINATED, 161, 42, 39, MtpConstants.RESPONSE_SPECIFICATION_BY_FORMAT_UNSUPPORTED, 169, 8480, 8226, MtpConstants.RESPONSE_INVALID_DEVICE_PROP_VALUE, MtpConstants.RESPONSE_INVALID_PARAMETER, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] SPECIAL_PT_DE_CHARACTER_SET = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final ArrayList<CueBuilder> cueBuilders = new ArrayList<>();
    private CueBuilder currentCueBuilder = new CueBuilder(0, 4);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class CueBuilder {
        private static final int BASE_ROW = 15;
        private static final int POSITION_UNSET = -1;
        private static final int SCREEN_CHARWIDTH = 32;
        private int captionMode;
        private int captionRowCount;
        private int indent;
        private int row;
        private int tabOffset;
        private int underlineStartPosition;
        private final List<CharacterStyle> preambleStyles = new ArrayList();
        private final List<CueStyle> midrowStyles = new ArrayList();
        private final List<SpannableString> rolledUpCaptions = new ArrayList();
        private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class CueStyle {
            public final int nextStyleIncrement;
            public final int start;
            public final CharacterStyle style;

            public CueStyle(CharacterStyle characterStyle, int i3, int i16) {
                this.style = characterStyle;
                this.start = i3;
                this.nextStyleIncrement = i16;
            }
        }

        public CueBuilder(int i3, int i16) {
            reset(i3);
            setCaptionRowCount(i16);
        }

        public void append(char c16) {
            this.captionStringBuilder.append(c16);
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
            }
        }

        public Cue build() {
            int i3;
            float f16;
            int i16;
            int i17;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i18 = 0; i18 < this.rolledUpCaptions.size(); i18++) {
                spannableStringBuilder.append((CharSequence) this.rolledUpCaptions.get(i18));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) buildSpannableString());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i19 = this.indent + this.tabOffset;
            int length = (32 - i19) - spannableStringBuilder.length();
            int i26 = i19 - length;
            if (this.captionMode == 2 && (Math.abs(i26) < 3 || length < 0)) {
                f16 = 0.5f;
                i3 = 1;
            } else if (this.captionMode == 2 && i26 > 0) {
                f16 = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i3 = 2;
            } else {
                i3 = 0;
                f16 = ((i19 / 32.0f) * 0.8f) + 0.1f;
            }
            if (this.captionMode != 1 && (i16 = this.row) <= 7) {
                i17 = 0;
            } else {
                i16 = (this.row - 15) - 2;
                i17 = 2;
            }
            return new Cue(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i16, 1, i17, f16, i3, Float.MIN_VALUE);
        }

        public SpannableString buildSpannableString() {
            int i3;
            int length = this.captionStringBuilder.length();
            for (int i16 = 0; i16 < this.preambleStyles.size(); i16++) {
                this.captionStringBuilder.setSpan(this.preambleStyles.get(i16), 0, length, 33);
            }
            for (int i17 = 0; i17 < this.midrowStyles.size(); i17++) {
                CueStyle cueStyle = this.midrowStyles.get(i17);
                int size = this.midrowStyles.size();
                int i18 = cueStyle.nextStyleIncrement;
                if (i17 < size - i18) {
                    i3 = this.midrowStyles.get(i18 + i17).start;
                } else {
                    i3 = length;
                }
                this.captionStringBuilder.setSpan(cueStyle.style, cueStyle.start, i3, 33);
            }
            if (this.underlineStartPosition != -1) {
                this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, length, 33);
            }
            return new SpannableString(this.captionStringBuilder);
        }

        public int getRow() {
            return this.row;
        }

        public boolean isEmpty() {
            if (this.preambleStyles.isEmpty() && this.midrowStyles.isEmpty() && this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0) {
                return true;
            }
            return false;
        }

        public void reset(int i3) {
            this.captionMode = i3;
            this.preambleStyles.clear();
            this.midrowStyles.clear();
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.row = 15;
            this.indent = 0;
            this.tabOffset = 0;
            this.underlineStartPosition = -1;
        }

        public void rollUp() {
            this.rolledUpCaptions.add(buildSpannableString());
            this.captionStringBuilder.clear();
            this.preambleStyles.clear();
            this.midrowStyles.clear();
            this.underlineStartPosition = -1;
            int min = Math.min(this.captionRowCount, this.row);
            while (this.rolledUpCaptions.size() >= min) {
                this.rolledUpCaptions.remove(0);
            }
        }

        public void setCaptionRowCount(int i3) {
            this.captionRowCount = i3;
        }

        public void setIndent(int i3) {
            this.indent = i3;
        }

        public void setMidrowStyle(CharacterStyle characterStyle, int i3) {
            this.midrowStyles.add(new CueStyle(characterStyle, this.captionStringBuilder.length(), i3));
        }

        public void setPreambleStyle(CharacterStyle characterStyle) {
            this.preambleStyles.add(characterStyle);
        }

        public void setRow(int i3) {
            this.row = i3;
        }

        public void setTab(int i3) {
            this.tabOffset = i3;
        }

        public void setUnderline(boolean z16) {
            if (z16) {
                this.underlineStartPosition = this.captionStringBuilder.length();
            } else if (this.underlineStartPosition != -1) {
                this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
                this.underlineStartPosition = -1;
            }
        }

        public String toString() {
            return this.captionStringBuilder.toString();
        }
    }

    public Cea608Decoder(String str, int i3) {
        int i16;
        if ("application/x-mp4-cea-608".equals(str)) {
            i16 = 2;
        } else {
            i16 = 3;
        }
        this.packetLength = i16;
        if (i3 != 3 && i3 != 4) {
            this.selectedField = 1;
        } else {
            this.selectedField = 2;
        }
        setCaptionMode(0);
        resetCueBuilders();
    }

    private static char getChar(byte b16) {
        return (char) BASIC_CHARACTER_SET[(b16 & Byte.MAX_VALUE) - 32];
    }

    private List<Cue> getDisplayCues() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.cueBuilders.size(); i3++) {
            Cue build = this.cueBuilders.get(i3).build();
            if (build != null) {
                arrayList.add(build);
            }
        }
        return arrayList;
    }

    private static char getExtendedEsFrChar(byte b16) {
        return (char) SPECIAL_ES_FR_CHARACTER_SET[b16 & 31];
    }

    private static char getExtendedPtDeChar(byte b16) {
        return (char) SPECIAL_PT_DE_CHARACTER_SET[b16 & 31];
    }

    private static char getSpecialChar(byte b16) {
        return (char) SPECIAL_CHARACTER_SET[b16 & RegisterType.DOUBLE_HI];
    }

    private boolean handleCtrl(byte b16, byte b17) {
        boolean isRepeatable = isRepeatable(b16);
        if (isRepeatable) {
            if (this.repeatableControlSet && this.repeatableControlCc1 == b16 && this.repeatableControlCc2 == b17) {
                this.repeatableControlSet = false;
                return true;
            }
            this.repeatableControlSet = true;
            this.repeatableControlCc1 = b16;
            this.repeatableControlCc2 = b17;
        }
        if (isMidrowCtrlCode(b16, b17)) {
            handleMidrowCtrl(b17);
        } else if (isPreambleAddressCode(b16, b17)) {
            handlePreambleAddressCode(b16, b17);
        } else if (isTabCtrlCode(b16, b17)) {
            this.currentCueBuilder.setTab(b17 - 32);
        } else if (isMiscCode(b16, b17)) {
            handleMiscCode(b17);
        }
        return isRepeatable;
    }

    private void handleMidrowCtrl(byte b16) {
        boolean z16;
        if ((b16 & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.currentCueBuilder.setUnderline(z16);
        int i3 = (b16 >> 1) & 15;
        if (i3 == 7) {
            this.currentCueBuilder.setMidrowStyle(new StyleSpan(2), 2);
            this.currentCueBuilder.setMidrowStyle(new ForegroundColorSpan(-1), 1);
        } else {
            this.currentCueBuilder.setMidrowStyle(new ForegroundColorSpan(COLORS[i3]), 1);
        }
    }

    private void handleMiscCode(byte b16) {
        if (b16 != 32) {
            if (b16 != 41) {
                switch (b16) {
                    case 37:
                        setCaptionMode(1);
                        setCaptionRowCount(2);
                        return;
                    case 38:
                        setCaptionMode(1);
                        setCaptionRowCount(3);
                        return;
                    case 39:
                        setCaptionMode(1);
                        setCaptionRowCount(4);
                        return;
                    default:
                        int i3 = this.captionMode;
                        if (i3 == 0) {
                            return;
                        }
                        if (b16 != 33) {
                            switch (b16) {
                                case 44:
                                    this.cues = null;
                                    if (i3 == 1 || i3 == 3) {
                                        resetCueBuilders();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i3 == 1 && !this.currentCueBuilder.isEmpty()) {
                                        this.currentCueBuilder.rollUp();
                                        return;
                                    }
                                    return;
                                case 46:
                                    resetCueBuilders();
                                    return;
                                case 47:
                                    this.cues = getDisplayCues();
                                    resetCueBuilders();
                                    return;
                                default:
                                    return;
                            }
                        }
                        this.currentCueBuilder.backspace();
                        return;
                }
            }
            setCaptionMode(3);
            return;
        }
        setCaptionMode(2);
    }

    private void handlePreambleAddressCode(byte b16, byte b17) {
        boolean z16;
        int i3 = ROW_INDICES[b16 & 7];
        if ((b17 & CTRL_RESUME_CAPTION_LOADING) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3++;
        }
        if (i3 != this.currentCueBuilder.getRow()) {
            if (this.captionMode != 1 && !this.currentCueBuilder.isEmpty()) {
                CueBuilder cueBuilder = new CueBuilder(this.captionMode, this.captionRowCount);
                this.currentCueBuilder = cueBuilder;
                this.cueBuilders.add(cueBuilder);
            }
            this.currentCueBuilder.setRow(i3);
        }
        if ((b17 & 1) == 1) {
            this.currentCueBuilder.setPreambleStyle(new UnderlineSpan());
        }
        int i16 = (b17 >> 1) & 15;
        if (i16 <= 7) {
            if (i16 == 7) {
                this.currentCueBuilder.setPreambleStyle(new StyleSpan(2));
                this.currentCueBuilder.setPreambleStyle(new ForegroundColorSpan(-1));
                return;
            } else {
                this.currentCueBuilder.setPreambleStyle(new ForegroundColorSpan(COLORS[i16]));
                return;
            }
        }
        this.currentCueBuilder.setIndent(COLUMN_INDICES[i16 & 7]);
    }

    private static boolean isMidrowCtrlCode(byte b16, byte b17) {
        if ((b16 & 247) == 17 && (b17 & 240) == 32) {
            return true;
        }
        return false;
    }

    private static boolean isMiscCode(byte b16, byte b17) {
        if ((b16 & 247) == 20 && (b17 & 240) == 32) {
            return true;
        }
        return false;
    }

    private static boolean isPreambleAddressCode(byte b16, byte b17) {
        if ((b16 & 240) == 16 && (b17 & 192) == 64) {
            return true;
        }
        return false;
    }

    private static boolean isRepeatable(byte b16) {
        if ((b16 & 240) == 16) {
            return true;
        }
        return false;
    }

    private static boolean isTabCtrlCode(byte b16, byte b17) {
        if ((b16 & 247) == 23 && b17 >= 33 && b17 <= 35) {
            return true;
        }
        return false;
    }

    private void resetCueBuilders() {
        this.currentCueBuilder.reset(this.captionMode);
        this.cueBuilders.clear();
        this.cueBuilders.add(this.currentCueBuilder);
    }

    private void setCaptionMode(int i3) {
        int i16 = this.captionMode;
        if (i16 == i3) {
            return;
        }
        this.captionMode = i3;
        resetCueBuilders();
        if (i16 == 3 || i3 == 1 || i3 == 0) {
            this.cues = null;
        }
    }

    private void setCaptionRowCount(int i3) {
        this.captionRowCount = i3;
        this.currentCueBuilder.setCaptionRowCount(i3);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected Subtitle createSubtitle() {
        List<Cue> list = this.cues;
        this.lastCues = list;
        return new CeaSubtitle(list);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected void decode(SubtitleInputBuffer subtitleInputBuffer) {
        byte readUnsignedByte;
        int i3;
        this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
        boolean z16 = false;
        boolean z17 = false;
        while (true) {
            int bytesLeft = this.ccData.bytesLeft();
            int i16 = this.packetLength;
            if (bytesLeft < i16) {
                break;
            }
            if (i16 == 2) {
                readUnsignedByte = CC_IMPLICIT_DATA_HEADER;
            } else {
                readUnsignedByte = (byte) this.ccData.readUnsignedByte();
            }
            byte readUnsignedByte2 = (byte) (this.ccData.readUnsignedByte() & 127);
            byte readUnsignedByte3 = (byte) (this.ccData.readUnsignedByte() & 127);
            if ((readUnsignedByte & 6) == 4 && ((i3 = this.selectedField) != 1 || (readUnsignedByte & 1) == 0)) {
                if (i3 != 2 || (readUnsignedByte & 1) == 1) {
                    if (readUnsignedByte2 != 0 || readUnsignedByte3 != 0) {
                        if ((readUnsignedByte2 & 247) == 17 && (readUnsignedByte3 & 240) == 48) {
                            this.currentCueBuilder.append(getSpecialChar(readUnsignedByte3));
                        } else if ((readUnsignedByte2 & 246) == 18 && (readUnsignedByte3 & 224) == 32) {
                            this.currentCueBuilder.backspace();
                            if ((readUnsignedByte2 & 1) == 0) {
                                this.currentCueBuilder.append(getExtendedEsFrChar(readUnsignedByte3));
                            } else {
                                this.currentCueBuilder.append(getExtendedPtDeChar(readUnsignedByte3));
                            }
                        } else if ((readUnsignedByte2 & 224) == 0) {
                            z17 = handleCtrl(readUnsignedByte2, readUnsignedByte3);
                        } else {
                            this.currentCueBuilder.append(getChar(readUnsignedByte2));
                            if ((readUnsignedByte3 & 224) != 0) {
                                this.currentCueBuilder.append(getChar(readUnsignedByte3));
                            }
                        }
                        z16 = true;
                    }
                }
            }
        }
        if (z16) {
            if (!z17) {
                this.repeatableControlSet = false;
            }
            int i17 = this.captionMode;
            if (i17 == 1 || i17 == 3) {
                this.cues = getDisplayCues();
            }
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        setCaptionMode(0);
        setCaptionRowCount(4);
        resetCueBuilders();
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = (byte) 0;
        this.repeatableControlCc2 = (byte) 0;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return "Cea608Decoder";
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected boolean isNewSubtitleDataAvailable() {
        if (this.cues != this.lastCues) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j3) {
        super.setPositionUs(j3);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public void release() {
    }
}
