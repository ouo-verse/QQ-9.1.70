package com.google.android.exoplayer2.text.cea;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.text.Typography;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Cea708Decoder extends CeaDecoder {
    private static final int CC_VALID_FLAG = 4;
    private static final int CHARACTER_BIG_CARONS = 42;
    private static final int CHARACTER_BIG_OE = 44;
    private static final int CHARACTER_BOLD_BULLET = 53;
    private static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
    private static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
    private static final int CHARACTER_DIAERESIS_Y = 63;
    private static final int CHARACTER_ELLIPSIS = 37;
    private static final int CHARACTER_FIVE_EIGHTHS = 120;
    private static final int CHARACTER_HORIZONTAL_BORDER = 125;
    private static final int CHARACTER_LOWER_LEFT_BORDER = 124;
    private static final int CHARACTER_LOWER_RIGHT_BORDER = 126;
    private static final int CHARACTER_MN = 127;
    private static final int CHARACTER_NBTSP = 33;
    private static final int CHARACTER_ONE_EIGHTH = 118;
    private static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
    private static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
    private static final int CHARACTER_SEVEN_EIGHTHS = 121;
    private static final int CHARACTER_SM = 61;
    private static final int CHARACTER_SMALL_CARONS = 58;
    private static final int CHARACTER_SMALL_OE = 60;
    private static final int CHARACTER_SOLID_BLOCK = 48;
    private static final int CHARACTER_THREE_EIGHTHS = 119;
    private static final int CHARACTER_TM = 57;
    private static final int CHARACTER_TSP = 32;
    private static final int CHARACTER_UPPER_LEFT_BORDER = 127;
    private static final int CHARACTER_UPPER_RIGHT_BORDER = 123;
    private static final int CHARACTER_VERTICAL_BORDER = 122;
    private static final int COMMAND_BS = 8;
    private static final int COMMAND_CLW = 136;
    private static final int COMMAND_CR = 13;
    private static final int COMMAND_CW0 = 128;
    private static final int COMMAND_CW1 = 129;
    private static final int COMMAND_CW2 = 130;
    private static final int COMMAND_CW3 = 131;
    private static final int COMMAND_CW4 = 132;
    private static final int COMMAND_CW5 = 133;
    private static final int COMMAND_CW6 = 134;
    private static final int COMMAND_CW7 = 135;
    private static final int COMMAND_DF0 = 152;
    private static final int COMMAND_DF1 = 153;
    private static final int COMMAND_DF2 = 154;
    private static final int COMMAND_DF3 = 155;
    private static final int COMMAND_DF4 = 156;
    private static final int COMMAND_DF5 = 157;
    private static final int COMMAND_DF6 = 158;
    private static final int COMMAND_DF7 = 159;
    private static final int COMMAND_DLC = 142;
    private static final int COMMAND_DLW = 140;
    private static final int COMMAND_DLY = 141;
    private static final int COMMAND_DSW = 137;
    private static final int COMMAND_ETX = 3;
    private static final int COMMAND_EXT1 = 16;
    private static final int COMMAND_EXT1_END = 23;
    private static final int COMMAND_EXT1_START = 17;
    private static final int COMMAND_FF = 12;
    private static final int COMMAND_HCR = 14;
    private static final int COMMAND_HDW = 138;
    private static final int COMMAND_NUL = 0;
    private static final int COMMAND_P16_END = 31;
    private static final int COMMAND_P16_START = 24;
    private static final int COMMAND_RST = 143;
    private static final int COMMAND_SPA = 144;
    private static final int COMMAND_SPC = 145;
    private static final int COMMAND_SPL = 146;
    private static final int COMMAND_SWA = 151;
    private static final int COMMAND_TGW = 139;
    private static final int DTVCC_PACKET_DATA = 2;
    private static final int DTVCC_PACKET_START = 3;
    private static final int GROUP_C0_END = 31;
    private static final int GROUP_C1_END = 159;
    private static final int GROUP_C2_END = 31;
    private static final int GROUP_C3_END = 159;
    private static final int GROUP_G0_END = 127;
    private static final int GROUP_G1_END = 255;
    private static final int GROUP_G2_END = 127;
    private static final int GROUP_G3_END = 255;
    private static final int NUM_WINDOWS = 8;
    private static final String TAG = "Cea708Decoder";
    private final CueBuilder[] cueBuilders;
    private List<Cue> cues;
    private CueBuilder currentCueBuilder;
    private DtvCcPacket currentDtvCcPacket;
    private int currentWindow;
    private List<Cue> lastCues;
    private final int selectedServiceNumber;
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final ParsableBitArray serviceBlockPacket = new ParsableBitArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class CueBuilder {
        private static final int BORDER_AND_EDGE_TYPE_NONE = 0;
        private static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
        public static final int COLOR_SOLID_BLACK;
        public static final int COLOR_SOLID_WHITE = getArgbColorFromCeaColor(2, 2, 2, 0);
        public static final int COLOR_TRANSPARENT;
        private static final int DEFAULT_PRIORITY = 4;
        private static final int DIRECTION_BOTTOM_TO_TOP = 3;
        private static final int DIRECTION_LEFT_TO_RIGHT = 0;
        private static final int DIRECTION_RIGHT_TO_LEFT = 1;
        private static final int DIRECTION_TOP_TO_BOTTOM = 2;
        private static final int HORIZONTAL_SIZE = 209;
        private static final int JUSTIFICATION_CENTER = 2;
        private static final int JUSTIFICATION_FULL = 3;
        private static final int JUSTIFICATION_LEFT = 0;
        private static final int JUSTIFICATION_RIGHT = 1;
        private static final int MAXIMUM_ROW_COUNT = 15;
        private static final int PEN_FONT_STYLE_DEFAULT = 0;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
        private static final int PEN_OFFSET_NORMAL = 1;
        private static final int PEN_SIZE_STANDARD = 1;
        private static final int[] PEN_STYLE_BACKGROUND;
        private static final int[] PEN_STYLE_EDGE_TYPE;
        private static final int[] PEN_STYLE_FONT_STYLE;
        private static final int RELATIVE_CUE_SIZE = 99;
        private static final int VERTICAL_SIZE = 74;
        private static final int[] WINDOW_STYLE_FILL;
        private static final int[] WINDOW_STYLE_JUSTIFICATION;
        private static final int[] WINDOW_STYLE_PRINT_DIRECTION;
        private static final int[] WINDOW_STYLE_SCROLL_DIRECTION;
        private static final boolean[] WINDOW_STYLE_WORD_WRAP;
        private int anchorId;
        private int backgroundColor;
        private int backgroundColorStartPosition;
        private boolean defined;
        private int foregroundColor;
        private int foregroundColorStartPosition;
        private int horizontalAnchor;
        private int italicsStartPosition;
        private int justification;
        private int penStyleId;
        private int priority;
        private boolean relativePositioning;
        private int row;
        private int rowCount;
        private boolean rowLock;
        private int underlineStartPosition;
        private int verticalAnchor;
        private boolean visible;
        private int windowFillColor;
        private int windowStyleId;
        private final List<SpannableString> rolledUpCaptions = new LinkedList();
        private final SpannableStringBuilder captionStringBuilder = new SpannableStringBuilder();

        static {
            int argbColorFromCeaColor = getArgbColorFromCeaColor(0, 0, 0, 0);
            COLOR_SOLID_BLACK = argbColorFromCeaColor;
            int argbColorFromCeaColor2 = getArgbColorFromCeaColor(0, 0, 0, 3);
            COLOR_TRANSPARENT = argbColorFromCeaColor2;
            WINDOW_STYLE_JUSTIFICATION = new int[]{0, 0, 0, 0, 0, 2, 0};
            WINDOW_STYLE_PRINT_DIRECTION = new int[]{0, 0, 0, 0, 0, 0, 2};
            WINDOW_STYLE_SCROLL_DIRECTION = new int[]{3, 3, 3, 3, 3, 3, 1};
            WINDOW_STYLE_WORD_WRAP = new boolean[]{false, false, false, true, true, true, false};
            WINDOW_STYLE_FILL = new int[]{argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor, argbColorFromCeaColor};
            PEN_STYLE_FONT_STYLE = new int[]{0, 1, 2, 3, 4, 3, 4};
            PEN_STYLE_EDGE_TYPE = new int[]{0, 0, 0, 0, 0, 3, 3};
            PEN_STYLE_BACKGROUND = new int[]{argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor, argbColorFromCeaColor2, argbColorFromCeaColor2};
        }

        public CueBuilder() {
            reset();
        }

        public static int getArgbColorFromCeaColor(int i3, int i16, int i17) {
            return getArgbColorFromCeaColor(i3, i16, i17, 0);
        }

        public void append(char c16) {
            if (c16 == '\n') {
                this.rolledUpCaptions.add(buildSpannableString());
                this.captionStringBuilder.clear();
                if (this.italicsStartPosition != -1) {
                    this.italicsStartPosition = 0;
                }
                if (this.underlineStartPosition != -1) {
                    this.underlineStartPosition = 0;
                }
                if (this.foregroundColorStartPosition != -1) {
                    this.foregroundColorStartPosition = 0;
                }
                if (this.backgroundColorStartPosition != -1) {
                    this.backgroundColorStartPosition = 0;
                }
                while (true) {
                    if ((this.rowLock && this.rolledUpCaptions.size() >= this.rowCount) || this.rolledUpCaptions.size() >= 15) {
                        this.rolledUpCaptions.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.captionStringBuilder.append(c16);
            }
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Cea708Cue build() {
            Layout.Alignment alignment;
            float f16;
            float f17;
            int i3;
            int i16;
            int i17;
            int i18;
            if (isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            boolean z16 = false;
            for (int i19 = 0; i19 < this.rolledUpCaptions.size(); i19++) {
                spannableStringBuilder.append((CharSequence) this.rolledUpCaptions.get(i19));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) buildSpannableString());
            int i26 = this.justification;
            if (i26 != 0) {
                if (i26 != 1) {
                    if (i26 != 2) {
                        if (i26 != 3) {
                            throw new IllegalArgumentException("Unexpected justification value: " + this.justification);
                        }
                    } else {
                        alignment = Layout.Alignment.ALIGN_CENTER;
                    }
                } else {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                }
                Layout.Alignment alignment2 = alignment;
                if (!this.relativePositioning) {
                    f16 = this.horizontalAnchor / 99.0f;
                    f17 = this.verticalAnchor / 99.0f;
                } else {
                    f16 = this.horizontalAnchor / 209.0f;
                    f17 = this.verticalAnchor / 74.0f;
                }
                float f18 = (f16 * 0.9f) + 0.05f;
                float f19 = (f17 * 0.9f) + 0.05f;
                i3 = this.anchorId;
                if (i3 % 3 != 0) {
                    i16 = 0;
                } else if (i3 % 3 == 1) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
                if (i3 / 3 != 0) {
                    i17 = 0;
                } else if (i3 / 3 == 1) {
                    i17 = 1;
                } else {
                    i17 = 2;
                }
                i18 = this.windowFillColor;
                if (i18 != COLOR_SOLID_BLACK) {
                    z16 = true;
                }
                return new Cea708Cue(spannableStringBuilder, alignment2, f19, 0, i16, f18, i17, Float.MIN_VALUE, z16, i18, this.priority);
            }
            alignment = Layout.Alignment.ALIGN_NORMAL;
            Layout.Alignment alignment22 = alignment;
            if (!this.relativePositioning) {
            }
            float f182 = (f16 * 0.9f) + 0.05f;
            float f192 = (f17 * 0.9f) + 0.05f;
            i3 = this.anchorId;
            if (i3 % 3 != 0) {
            }
            if (i3 / 3 != 0) {
            }
            i18 = this.windowFillColor;
            if (i18 != COLOR_SOLID_BLACK) {
            }
            return new Cea708Cue(spannableStringBuilder, alignment22, f192, 0, i16, f182, i17, Float.MIN_VALUE, z16, i18, this.priority);
        }

        public SpannableString buildSpannableString() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.italicsStartPosition != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, length, 33);
                }
                if (this.underlineStartPosition != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, length, 33);
                }
                if (this.foregroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, length, 33);
                }
                if (this.backgroundColorStartPosition != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void clear() {
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.italicsStartPosition = -1;
            this.underlineStartPosition = -1;
            this.foregroundColorStartPosition = -1;
            this.backgroundColorStartPosition = -1;
            this.row = 0;
        }

        public void defineWindow(boolean z16, boolean z17, boolean z18, int i3, boolean z19, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            this.defined = true;
            this.visible = z16;
            this.rowLock = z17;
            this.priority = i3;
            this.relativePositioning = z19;
            this.verticalAnchor = i16;
            this.horizontalAnchor = i17;
            this.anchorId = i26;
            int i29 = i18 + 1;
            if (this.rowCount != i29) {
                this.rowCount = i29;
                while (true) {
                    if ((!z17 || this.rolledUpCaptions.size() < this.rowCount) && this.rolledUpCaptions.size() < 15) {
                        break;
                    } else {
                        this.rolledUpCaptions.remove(0);
                    }
                }
            }
            if (i27 != 0 && this.windowStyleId != i27) {
                this.windowStyleId = i27;
                int i36 = i27 - 1;
                setWindowAttributes(WINDOW_STYLE_FILL[i36], COLOR_TRANSPARENT, WINDOW_STYLE_WORD_WRAP[i36], 0, WINDOW_STYLE_PRINT_DIRECTION[i36], WINDOW_STYLE_SCROLL_DIRECTION[i36], WINDOW_STYLE_JUSTIFICATION[i36]);
            }
            if (i28 != 0 && this.penStyleId != i28) {
                this.penStyleId = i28;
                int i37 = i28 - 1;
                setPenAttributes(0, 1, 1, false, false, PEN_STYLE_EDGE_TYPE[i37], PEN_STYLE_FONT_STYLE[i37]);
                setPenColor(COLOR_SOLID_WHITE, PEN_STYLE_BACKGROUND[i37], COLOR_SOLID_BLACK);
            }
        }

        public boolean isDefined() {
            return this.defined;
        }

        public boolean isEmpty() {
            if (isDefined() && (!this.rolledUpCaptions.isEmpty() || this.captionStringBuilder.length() != 0)) {
                return false;
            }
            return true;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void reset() {
            clear();
            this.defined = false;
            this.visible = false;
            this.priority = 4;
            this.relativePositioning = false;
            this.verticalAnchor = 0;
            this.horizontalAnchor = 0;
            this.anchorId = 0;
            this.rowCount = 15;
            this.rowLock = true;
            this.justification = 0;
            this.windowStyleId = 0;
            this.penStyleId = 0;
            int i3 = COLOR_SOLID_BLACK;
            this.windowFillColor = i3;
            this.foregroundColor = COLOR_SOLID_WHITE;
            this.backgroundColor = i3;
        }

        public void setPenAttributes(int i3, int i16, int i17, boolean z16, boolean z17, int i18, int i19) {
            if (this.italicsStartPosition != -1) {
                if (!z16) {
                    this.captionStringBuilder.setSpan(new StyleSpan(2), this.italicsStartPosition, this.captionStringBuilder.length(), 33);
                    this.italicsStartPosition = -1;
                }
            } else if (z16) {
                this.italicsStartPosition = this.captionStringBuilder.length();
            }
            if (this.underlineStartPosition != -1) {
                if (!z17) {
                    this.captionStringBuilder.setSpan(new UnderlineSpan(), this.underlineStartPosition, this.captionStringBuilder.length(), 33);
                    this.underlineStartPosition = -1;
                    return;
                }
                return;
            }
            if (z17) {
                this.underlineStartPosition = this.captionStringBuilder.length();
            }
        }

        public void setPenColor(int i3, int i16, int i17) {
            if (this.foregroundColorStartPosition != -1 && this.foregroundColor != i3) {
                this.captionStringBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i3 != COLOR_SOLID_WHITE) {
                this.foregroundColorStartPosition = this.captionStringBuilder.length();
                this.foregroundColor = i3;
            }
            if (this.backgroundColorStartPosition != -1 && this.backgroundColor != i16) {
                this.captionStringBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, this.captionStringBuilder.length(), 33);
            }
            if (i16 != COLOR_SOLID_BLACK) {
                this.backgroundColorStartPosition = this.captionStringBuilder.length();
                this.backgroundColor = i16;
            }
        }

        public void setPenLocation(int i3, int i16) {
            if (this.row != i3) {
                append('\n');
            }
            this.row = i3;
        }

        public void setVisibility(boolean z16) {
            this.visible = z16;
        }

        public void setWindowAttributes(int i3, int i16, boolean z16, int i17, int i18, int i19, int i26) {
            this.windowFillColor = i3;
            this.justification = i26;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0026  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getArgbColorFromCeaColor(int i3, int i16, int i17, int i18) {
            int i19;
            Assertions.checkIndex(i3, 0, 4);
            Assertions.checkIndex(i16, 0, 4);
            Assertions.checkIndex(i17, 0, 4);
            Assertions.checkIndex(i18, 0, 4);
            if (i18 != 0 && i18 != 1) {
                if (i18 == 2) {
                    i19 = 127;
                } else if (i18 == 3) {
                    i19 = 0;
                }
                return Color.argb(i19, i3 <= 1 ? 255 : 0, i16 <= 1 ? 255 : 0, i17 > 1 ? 255 : 0);
            }
            i19 = 255;
            return Color.argb(i19, i3 <= 1 ? 255 : 0, i16 <= 1 ? 255 : 0, i17 > 1 ? 255 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class DtvCcPacket {
        int currentIndex = 0;
        public final byte[] packetData;
        public final int packetSize;
        public final int sequenceNumber;

        public DtvCcPacket(int i3, int i16) {
            this.sequenceNumber = i3;
            this.packetSize = i16;
            this.packetData = new byte[(i16 * 2) - 1];
        }
    }

    public Cea708Decoder(int i3) {
        this.selectedServiceNumber = i3 == -1 ? 1 : i3;
        this.cueBuilders = new CueBuilder[8];
        for (int i16 = 0; i16 < 8; i16++) {
            this.cueBuilders[i16] = new CueBuilder();
        }
        this.currentCueBuilder = this.cueBuilders[0];
        resetCueBuilders();
    }

    private void finalizeCurrentPacket() {
        if (this.currentDtvCcPacket == null) {
            return;
        }
        processCurrentPacket();
        this.currentDtvCcPacket = null;
    }

    private List<Cue> getDisplayCues() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 8; i3++) {
            if (!this.cueBuilders[i3].isEmpty() && this.cueBuilders[i3].isVisible()) {
                arrayList.add(this.cueBuilders[i3].build());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void handleC0Command(int i3) {
        if (i3 != 0) {
            if (i3 != 3) {
                if (i3 != 8) {
                    switch (i3) {
                        case 12:
                            resetCueBuilders();
                            return;
                        case 13:
                            this.currentCueBuilder.append('\n');
                            return;
                        case 14:
                            return;
                        default:
                            if (i3 >= 17 && i3 <= 23) {
                                Log.w(TAG, "Currently unsupported COMMAND_EXT1 Command: " + i3);
                                this.serviceBlockPacket.skipBits(8);
                                return;
                            }
                            if (i3 >= 24 && i3 <= 31) {
                                Log.w(TAG, "Currently unsupported COMMAND_P16 Command: " + i3);
                                this.serviceBlockPacket.skipBits(16);
                                return;
                            }
                            Log.w(TAG, "Invalid C0 command: " + i3);
                            return;
                    }
                }
                this.currentCueBuilder.backspace();
                return;
            }
            this.cues = getDisplayCues();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
    private void handleC1Command(int i3) {
        int i16 = 1;
        switch (i3) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                int i17 = i3 - 128;
                if (this.currentWindow != i17) {
                    this.currentWindow = i17;
                    this.currentCueBuilder = this.cueBuilders[i17];
                    return;
                }
                return;
            case 136:
                while (i16 <= 8) {
                    if (this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - i16].clear();
                    }
                    i16++;
                }
                return;
            case 137:
                for (int i18 = 1; i18 <= 8; i18++) {
                    if (this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - i18].setVisibility(true);
                    }
                }
                return;
            case 138:
                while (i16 <= 8) {
                    if (this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - i16].setVisibility(false);
                    }
                    i16++;
                }
                return;
            case 139:
                for (int i19 = 1; i19 <= 8; i19++) {
                    if (this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - i19].setVisibility(!r0.isVisible());
                    }
                }
                return;
            case 140:
                while (i16 <= 8) {
                    if (this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - i16].reset();
                    }
                    i16++;
                }
                return;
            case 141:
                this.serviceBlockPacket.skipBits(8);
                return;
            case 142:
                return;
            case 143:
                resetCueBuilders();
                return;
            case 144:
                if (!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(16);
                    return;
                } else {
                    handleSetPenAttributes();
                    return;
                }
            case 145:
                if (!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(24);
                    return;
                } else {
                    handleSetPenColor();
                    return;
                }
            case 146:
                if (!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(16);
                    return;
                } else {
                    handleSetPenLocation();
                    return;
                }
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                Log.w(TAG, "Invalid C1 command: " + i3);
                return;
            case 151:
                if (!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(32);
                    return;
                } else {
                    handleSetWindowAttributes();
                    return;
                }
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i26 = i3 - 152;
                handleDefineWindow(i26);
                if (this.currentWindow != i26) {
                    this.currentWindow = i26;
                    this.currentCueBuilder = this.cueBuilders[i26];
                    return;
                }
                return;
        }
    }

    private void handleC2Command(int i3) {
        if (i3 > 7) {
            if (i3 <= 15) {
                this.serviceBlockPacket.skipBits(8);
            } else if (i3 <= 23) {
                this.serviceBlockPacket.skipBits(16);
            } else if (i3 <= 31) {
                this.serviceBlockPacket.skipBits(24);
            }
        }
    }

    private void handleC3Command(int i3) {
        if (i3 <= 135) {
            this.serviceBlockPacket.skipBits(32);
            return;
        }
        if (i3 <= 143) {
            this.serviceBlockPacket.skipBits(40);
        } else if (i3 <= 159) {
            this.serviceBlockPacket.skipBits(2);
            this.serviceBlockPacket.skipBits(this.serviceBlockPacket.readBits(6) * 8);
        }
    }

    private void handleDefineWindow(int i3) {
        CueBuilder cueBuilder = this.cueBuilders[i3];
        this.serviceBlockPacket.skipBits(2);
        boolean readBit = this.serviceBlockPacket.readBit();
        boolean readBit2 = this.serviceBlockPacket.readBit();
        boolean readBit3 = this.serviceBlockPacket.readBit();
        int readBits = this.serviceBlockPacket.readBits(3);
        boolean readBit4 = this.serviceBlockPacket.readBit();
        int readBits2 = this.serviceBlockPacket.readBits(7);
        int readBits3 = this.serviceBlockPacket.readBits(8);
        int readBits4 = this.serviceBlockPacket.readBits(4);
        int readBits5 = this.serviceBlockPacket.readBits(4);
        this.serviceBlockPacket.skipBits(2);
        int readBits6 = this.serviceBlockPacket.readBits(6);
        this.serviceBlockPacket.skipBits(2);
        cueBuilder.defineWindow(readBit, readBit2, readBit3, readBits, readBit4, readBits2, readBits3, readBits5, readBits6, readBits4, this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
    }

    private void handleG0Character(int i3) {
        if (i3 == 127) {
            this.currentCueBuilder.append('\u266b');
        } else {
            this.currentCueBuilder.append((char) (i3 & 255));
        }
    }

    private void handleG1Character(int i3) {
        this.currentCueBuilder.append((char) (i3 & 255));
    }

    private void handleG2Character(int i3) {
        if (i3 != 32) {
            if (i3 != 33) {
                if (i3 != 37) {
                    if (i3 != 42) {
                        if (i3 != 44) {
                            if (i3 != 63) {
                                if (i3 != 57) {
                                    if (i3 != 58) {
                                        if (i3 != 60) {
                                            if (i3 != 61) {
                                                switch (i3) {
                                                    case 48:
                                                        this.currentCueBuilder.append('\u2588');
                                                        return;
                                                    case 49:
                                                        this.currentCueBuilder.append(Typography.leftSingleQuote);
                                                        return;
                                                    case 50:
                                                        this.currentCueBuilder.append(Typography.rightSingleQuote);
                                                        return;
                                                    case 51:
                                                        this.currentCueBuilder.append(Typography.leftDoubleQuote);
                                                        return;
                                                    case 52:
                                                        this.currentCueBuilder.append(Typography.rightDoubleQuote);
                                                        return;
                                                    case 53:
                                                        this.currentCueBuilder.append(Typography.bullet);
                                                        return;
                                                    default:
                                                        switch (i3) {
                                                            case 118:
                                                                this.currentCueBuilder.append('\u215b');
                                                                return;
                                                            case 119:
                                                                this.currentCueBuilder.append('\u215c');
                                                                return;
                                                            case 120:
                                                                this.currentCueBuilder.append('\u215d');
                                                                return;
                                                            case 121:
                                                                this.currentCueBuilder.append('\u215e');
                                                                return;
                                                            case 122:
                                                                this.currentCueBuilder.append('\u2502');
                                                                return;
                                                            case 123:
                                                                this.currentCueBuilder.append('\u2510');
                                                                return;
                                                            case 124:
                                                                this.currentCueBuilder.append('\u2514');
                                                                return;
                                                            case 125:
                                                                this.currentCueBuilder.append('\u2500');
                                                                return;
                                                            case 126:
                                                                this.currentCueBuilder.append('\u2518');
                                                                return;
                                                            case 127:
                                                                this.currentCueBuilder.append('\u250c');
                                                                return;
                                                            default:
                                                                Log.w(TAG, "Invalid G2 character: " + i3);
                                                                return;
                                                        }
                                                }
                                            }
                                            this.currentCueBuilder.append('\u2120');
                                            return;
                                        }
                                        this.currentCueBuilder.append('\u0153');
                                        return;
                                    }
                                    this.currentCueBuilder.append('\u0161');
                                    return;
                                }
                                this.currentCueBuilder.append(Typography.tm);
                                return;
                            }
                            this.currentCueBuilder.append('\u0178');
                            return;
                        }
                        this.currentCueBuilder.append('\u0152');
                        return;
                    }
                    this.currentCueBuilder.append('\u0160');
                    return;
                }
                this.currentCueBuilder.append(Typography.ellipsis);
                return;
            }
            this.currentCueBuilder.append(Typography.nbsp);
            return;
        }
        this.currentCueBuilder.append(TokenParser.SP);
    }

    private void handleG3Character(int i3) {
        if (i3 == 160) {
            this.currentCueBuilder.append('\u33c4');
            return;
        }
        Log.w(TAG, "Invalid G3 character: " + i3);
        this.currentCueBuilder.append(util.base64_pad_url);
    }

    private void handleSetPenAttributes() {
        this.currentCueBuilder.setPenAttributes(this.serviceBlockPacket.readBits(4), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBit(), this.serviceBlockPacket.readBit(), this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
    }

    private void handleSetPenColor() {
        int argbColorFromCeaColor = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        int argbColorFromCeaColor2 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        this.serviceBlockPacket.skipBits(2);
        this.currentCueBuilder.setPenColor(argbColorFromCeaColor, argbColorFromCeaColor2, CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2)));
    }

    private void handleSetPenLocation() {
        this.serviceBlockPacket.skipBits(4);
        int readBits = this.serviceBlockPacket.readBits(4);
        this.serviceBlockPacket.skipBits(2);
        this.currentCueBuilder.setPenLocation(readBits, this.serviceBlockPacket.readBits(6));
    }

    private void handleSetWindowAttributes() {
        int argbColorFromCeaColor = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        int readBits = this.serviceBlockPacket.readBits(2);
        int argbColorFromCeaColor2 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        if (this.serviceBlockPacket.readBit()) {
            readBits |= 4;
        }
        boolean readBit = this.serviceBlockPacket.readBit();
        int readBits2 = this.serviceBlockPacket.readBits(2);
        int readBits3 = this.serviceBlockPacket.readBits(2);
        int readBits4 = this.serviceBlockPacket.readBits(2);
        this.serviceBlockPacket.skipBits(8);
        this.currentCueBuilder.setWindowAttributes(argbColorFromCeaColor, argbColorFromCeaColor2, readBit, readBits, readBits2, readBits3, readBits4);
    }

    private void processCurrentPacket() {
        DtvCcPacket dtvCcPacket = this.currentDtvCcPacket;
        int i3 = dtvCcPacket.currentIndex;
        if (i3 != (dtvCcPacket.packetSize * 2) - 1) {
            Log.w(TAG, "DtvCcPacket ended prematurely; size is " + ((this.currentDtvCcPacket.packetSize * 2) - 1) + ", but current index is " + this.currentDtvCcPacket.currentIndex + " (sequence number " + this.currentDtvCcPacket.sequenceNumber + "); ignoring packet");
            return;
        }
        this.serviceBlockPacket.reset(dtvCcPacket.packetData, i3);
        int readBits = this.serviceBlockPacket.readBits(3);
        int readBits2 = this.serviceBlockPacket.readBits(5);
        if (readBits == 7) {
            this.serviceBlockPacket.skipBits(2);
            readBits += this.serviceBlockPacket.readBits(6);
        }
        if (readBits2 == 0) {
            if (readBits != 0) {
                Log.w(TAG, "serviceNumber is non-zero (" + readBits + ") when blockSize is 0");
                return;
            }
            return;
        }
        if (readBits != this.selectedServiceNumber) {
            return;
        }
        boolean z16 = false;
        while (this.serviceBlockPacket.bitsLeft() > 0) {
            int readBits3 = this.serviceBlockPacket.readBits(8);
            if (readBits3 != 16) {
                if (readBits3 <= 31) {
                    handleC0Command(readBits3);
                } else {
                    if (readBits3 <= 127) {
                        handleG0Character(readBits3);
                    } else if (readBits3 <= 159) {
                        handleC1Command(readBits3);
                    } else if (readBits3 <= 255) {
                        handleG1Character(readBits3);
                    } else {
                        Log.w(TAG, "Invalid base command: " + readBits3);
                    }
                    z16 = true;
                }
            } else {
                int readBits4 = this.serviceBlockPacket.readBits(8);
                if (readBits4 <= 31) {
                    handleC2Command(readBits4);
                } else {
                    if (readBits4 <= 127) {
                        handleG2Character(readBits4);
                    } else if (readBits4 <= 159) {
                        handleC3Command(readBits4);
                    } else if (readBits4 <= 255) {
                        handleG3Character(readBits4);
                    } else {
                        Log.w(TAG, "Invalid extended command: " + readBits4);
                    }
                    z16 = true;
                }
            }
        }
        if (z16) {
            this.cues = getDisplayCues();
        }
    }

    private void resetCueBuilders() {
        for (int i3 = 0; i3 < 8; i3++) {
            this.cueBuilders[i3].reset();
        }
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected Subtitle createSubtitle() {
        List<Cue> list = this.cues;
        this.lastCues = list;
        return new CeaSubtitle(list);
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder
    protected void decode(SubtitleInputBuffer subtitleInputBuffer) {
        boolean z16;
        this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
        while (this.ccData.bytesLeft() >= 3) {
            int readUnsignedByte = this.ccData.readUnsignedByte() & 7;
            int i3 = readUnsignedByte & 3;
            boolean z17 = false;
            if ((readUnsignedByte & 4) == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            byte readUnsignedByte2 = (byte) this.ccData.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.ccData.readUnsignedByte();
            if (i3 == 2 || i3 == 3) {
                if (z16) {
                    if (i3 == 3) {
                        finalizeCurrentPacket();
                        int i16 = (readUnsignedByte2 & 192) >> 6;
                        int i17 = readUnsignedByte2 & 63;
                        if (i17 == 0) {
                            i17 = 64;
                        }
                        DtvCcPacket dtvCcPacket = new DtvCcPacket(i16, i17);
                        this.currentDtvCcPacket = dtvCcPacket;
                        byte[] bArr = dtvCcPacket.packetData;
                        int i18 = dtvCcPacket.currentIndex;
                        dtvCcPacket.currentIndex = i18 + 1;
                        bArr[i18] = readUnsignedByte3;
                    } else {
                        if (i3 == 2) {
                            z17 = true;
                        }
                        Assertions.checkArgument(z17);
                        DtvCcPacket dtvCcPacket2 = this.currentDtvCcPacket;
                        if (dtvCcPacket2 == null) {
                            Log.e(TAG, "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = dtvCcPacket2.packetData;
                            int i19 = dtvCcPacket2.currentIndex;
                            int i26 = i19 + 1;
                            bArr2[i19] = readUnsignedByte2;
                            dtvCcPacket2.currentIndex = i26 + 1;
                            bArr2[i26] = readUnsignedByte3;
                        }
                    }
                    DtvCcPacket dtvCcPacket3 = this.currentDtvCcPacket;
                    if (dtvCcPacket3.currentIndex == (dtvCcPacket3.packetSize * 2) - 1) {
                        finalizeCurrentPacket();
                    }
                }
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
        this.currentWindow = 0;
        this.currentCueBuilder = this.cueBuilders[0];
        resetCueBuilders();
        this.currentDtvCcPacket = null;
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        return TAG;
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

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.decoder.Decoder
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // com.google.android.exoplayer2.text.cea.CeaDecoder, com.google.android.exoplayer2.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j3) {
        super.setPositionUs(j3);
    }
}
