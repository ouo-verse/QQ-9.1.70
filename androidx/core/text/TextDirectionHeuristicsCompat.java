package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE;
    public static final TextDirectionHeuristicCompat LTR = new TextDirectionHeuristicInternal(null, false);
    public static final TextDirectionHeuristicCompat RTL = new TextDirectionHeuristicInternal(null, true);
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class AnyStrong implements TextDirectionAlgorithm {
        static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
        private final boolean mLookForRtl;

        AnyStrong(boolean z16) {
            this.mLookForRtl = z16;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence charSequence, int i3, int i16) {
            int i17 = i16 + i3;
            boolean z16 = false;
            while (i3 < i17) {
                int isRtlText = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(charSequence.charAt(i3)));
                if (isRtlText != 0) {
                    if (isRtlText == 1) {
                        if (!this.mLookForRtl) {
                            return 1;
                        }
                    } else {
                        continue;
                        i3++;
                        z16 = z16;
                    }
                } else if (this.mLookForRtl) {
                    return 0;
                }
                z16 = true;
                i3++;
                z16 = z16;
            }
            if (z16) {
                return this.mLookForRtl ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class FirstStrong implements TextDirectionAlgorithm {
        static final FirstStrong INSTANCE = new FirstStrong();

        FirstStrong() {
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence charSequence, int i3, int i16) {
            int i17 = i16 + i3;
            int i18 = 2;
            while (i3 < i17 && i18 == 2) {
                i18 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(charSequence.charAt(i3)));
                i3++;
            }
            return i18;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface TextDirectionAlgorithm {
        int checkRtl(CharSequence charSequence, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.mAlgorithm = textDirectionAlgorithm;
        }

        private boolean doCheck(CharSequence charSequence, int i3, int i16) {
            int checkRtl = this.mAlgorithm.checkRtl(charSequence, i3, i16);
            if (checkRtl == 0) {
                return true;
            }
            if (checkRtl != 1) {
                return defaultIsRtl();
            }
            return false;
        }

        protected abstract boolean defaultIsRtl();

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] cArr, int i3, int i16) {
            return isRtl(CharBuffer.wrap(cArr), i3, i16);
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence charSequence, int i3, int i16) {
            if (charSequence != null && i3 >= 0 && i16 >= 0 && charSequence.length() - i16 >= i3) {
                if (this.mAlgorithm == null) {
                    return defaultIsRtl();
                }
                return doCheck(charSequence, i3, i16);
            }
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z16) {
            super(textDirectionAlgorithm);
            this.mDefaultIsRtl = z16;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();

        TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean defaultIsRtl() {
            if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static {
        FirstStrong firstStrong = FirstStrong.INSTANCE;
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(firstStrong, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(firstStrong, true);
        ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
        LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }

    TextDirectionHeuristicsCompat() {
    }

    static int isRtlText(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 != 1 && i3 != 2) {
            return 2;
        }
        return 0;
    }

    static int isRtlTextOrFormat(int i3) {
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2) {
                return 0;
            }
            switch (i3) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
