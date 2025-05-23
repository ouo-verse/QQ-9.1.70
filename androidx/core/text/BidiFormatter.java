package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    static final BidiFormatter DEFAULT_LTR_INSTANCE;
    static final BidiFormatter DEFAULT_RTL_INSTANCE;
    static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '\u202a';
    private static final char LRM = '\u200e';
    private static final String LRM_STRING;
    private static final char PDF = '\u202c';
    private static final char RLE = '\u202b';
    private static final char RLM = '\u200f';
    private static final String RLM_STRING;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class DirectionalityEstimator {
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private static final byte[] DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];

        static {
            for (int i3 = 0; i3 < DIR_TYPE_CACHE_SIZE; i3++) {
                DIR_TYPE_CACHE[i3] = Character.getDirectionality(i3);
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z16) {
            this.text = charSequence;
            this.isHtml = z16;
            this.length = charSequence.length();
        }

        private static byte getCachedDirectionality(char c16) {
            if (c16 < DIR_TYPE_CACHE_SIZE) {
                return DIR_TYPE_CACHE[c16];
            }
            return Character.getDirectionality(c16);
        }

        private byte skipEntityBackward() {
            char charAt;
            int i3 = this.charIndex;
            do {
                int i16 = this.charIndex;
                if (i16 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i17 = i16 - 1;
                this.charIndex = i17;
                charAt = charSequence.charAt(i17);
                this.lastChar = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.charIndex = i3;
            this.lastChar = ';';
            return (byte) 13;
        }

        private byte skipEntityForward() {
            char charAt;
            do {
                int i3 = this.charIndex;
                if (i3 < this.length) {
                    CharSequence charSequence = this.text;
                    this.charIndex = i3 + 1;
                    charAt = charSequence.charAt(i3);
                    this.lastChar = charAt;
                } else {
                    return (byte) 12;
                }
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte skipTagBackward() {
            char charAt;
            int i3 = this.charIndex;
            while (true) {
                int i16 = this.charIndex;
                if (i16 <= 0) {
                    break;
                }
                CharSequence charSequence = this.text;
                int i17 = i16 - 1;
                this.charIndex = i17;
                char charAt2 = charSequence.charAt(i17);
                this.lastChar = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i18 = this.charIndex;
                        if (i18 > 0) {
                            CharSequence charSequence2 = this.text;
                            int i19 = i18 - 1;
                            this.charIndex = i19;
                            charAt = charSequence2.charAt(i19);
                            this.lastChar = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.charIndex = i3;
            this.lastChar = Typography.greater;
            return (byte) 13;
        }

        private byte skipTagForward() {
            char charAt;
            int i3 = this.charIndex;
            while (true) {
                int i16 = this.charIndex;
                if (i16 < this.length) {
                    CharSequence charSequence = this.text;
                    this.charIndex = i16 + 1;
                    char charAt2 = charSequence.charAt(i16);
                    this.lastChar = charAt2;
                    if (charAt2 == '>') {
                        return (byte) 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i17 = this.charIndex;
                            if (i17 < this.length) {
                                CharSequence charSequence2 = this.text;
                                this.charIndex = i17 + 1;
                                charAt = charSequence2.charAt(i17);
                                this.lastChar = charAt;
                            }
                        } while (charAt != charAt2);
                    }
                } else {
                    this.charIndex = i3;
                    this.lastChar = Typography.less;
                    return (byte) 13;
                }
            }
        }

        byte dirTypeBackward() {
            char charAt = this.text.charAt(this.charIndex - 1);
            this.lastChar = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                char c16 = this.lastChar;
                if (c16 == '>') {
                    return skipTagBackward();
                }
                if (c16 == ';') {
                    return skipEntityBackward();
                }
                return cachedDirectionality;
            }
            return cachedDirectionality;
        }

        byte dirTypeForward() {
            char charAt = this.text.charAt(this.charIndex);
            this.lastChar = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte cachedDirectionality = getCachedDirectionality(this.lastChar);
            if (this.isHtml) {
                char c16 = this.lastChar;
                if (c16 == '<') {
                    return skipTagForward();
                }
                if (c16 == '&') {
                    return skipEntityForward();
                }
                return cachedDirectionality;
            }
            return cachedDirectionality;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:46:0x0045. Please report as an issue. */
        int getEntryDir() {
            this.charIndex = 0;
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (this.charIndex < this.length && i3 == 0) {
                byte dirTypeForward = dirTypeForward();
                if (dirTypeForward != 0) {
                    if (dirTypeForward != 1 && dirTypeForward != 2) {
                        if (dirTypeForward != 9) {
                            switch (dirTypeForward) {
                                case 14:
                                case 15:
                                    i17++;
                                    i16 = -1;
                                    continue;
                                case 16:
                                case 17:
                                    i17++;
                                    i16 = 1;
                                    continue;
                                case 18:
                                    i17--;
                                    i16 = 0;
                                    continue;
                            }
                        }
                    } else if (i17 == 0) {
                        return 1;
                    }
                } else if (i17 == 0) {
                    return -1;
                }
                i3 = i17;
            }
            if (i3 == 0) {
                return 0;
            }
            if (i16 != 0) {
                return i16;
            }
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case 14:
                    case 15:
                        if (i3 == i17) {
                            return -1;
                        }
                        i17--;
                    case 16:
                    case 17:
                        if (i3 == i17) {
                            return 1;
                        }
                        i17--;
                    case 18:
                        i17++;
                }
            }
            return 0;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:33:0x001c. Please report as an issue. */
        int getExitDir() {
            this.charIndex = this.length;
            int i3 = 0;
            while (true) {
                int i16 = i3;
                while (this.charIndex > 0) {
                    byte dirTypeBackward = dirTypeBackward();
                    if (dirTypeBackward != 0) {
                        if (dirTypeBackward != 1 && dirTypeBackward != 2) {
                            if (dirTypeBackward != 9) {
                                switch (dirTypeBackward) {
                                    case 14:
                                    case 15:
                                        if (i16 == i3) {
                                            return -1;
                                        }
                                        i3--;
                                        break;
                                    case 16:
                                    case 17:
                                        if (i16 == i3) {
                                            return 1;
                                        }
                                        i3--;
                                        break;
                                    case 18:
                                        i3++;
                                        break;
                                    default:
                                        if (i16 != 0) {
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } else {
                                continue;
                            }
                        } else {
                            if (i3 == 0) {
                                return 1;
                            }
                            if (i16 == 0) {
                                break;
                            }
                        }
                    } else {
                        if (i3 == 0) {
                            return -1;
                        }
                        if (i16 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        DEFAULT_TEXT_DIRECTION_HEURISTIC = textDirectionHeuristicCompat;
        LRM_STRING = Character.toString(LRM);
        RLM_STRING = Character.toString(RLM);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    BidiFormatter(boolean z16, int i3, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z16;
        this.mFlags = i3;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    private static int getEntryDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getEntryDir();
    }

    private static int getExitDir(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    static boolean isRtlLocale(Locale locale) {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1) {
            return true;
        }
        return false;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (isRtl || getExitDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (this.mIsRtlContext) {
            if (!isRtl || getExitDir(charSequence) == -1) {
                return RLM_STRING;
            }
            return "";
        }
        return "";
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (isRtl || getEntryDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (this.mIsRtlContext) {
            if (!isRtl || getEntryDir(charSequence) == -1) {
                return RLM_STRING;
            }
            return "";
        }
        return "";
    }

    public boolean getStereoReset() {
        if ((this.mFlags & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z16) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z16).toString();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z16) {
            if (z16) {
                return BidiFormatter.DEFAULT_RTL_INSTANCE;
            }
            return BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean z16) {
            this.mIsRtlContext = z16;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public BidiFormatter build() {
            if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                return getDefaultInstanceFromContext(this.mIsRtlContext);
            }
            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z16) {
            if (z16) {
                this.mFlags |= 2;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }

        public Builder(boolean z16) {
            initialize(z16);
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }
    }

    public static BidiFormatter getInstance(boolean z16) {
        return new Builder(z16).build();
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z16) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z16) {
            spannableStringBuilder.append((CharSequence) markBefore(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            spannableStringBuilder.append(isRtl ? RLE : LRE);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(PDF);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z16) {
            spannableStringBuilder.append((CharSequence) markAfter(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z16) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z16);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z16) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z16);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }
}
