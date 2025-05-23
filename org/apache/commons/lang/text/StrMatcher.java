package org.apache.commons.lang.text;

import java.util.Arrays;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class StrMatcher {
    private static final StrMatcher COMMA_MATCHER = new CharMatcher(',');
    private static final StrMatcher TAB_MATCHER = new CharMatcher('\t');
    private static final StrMatcher SPACE_MATCHER = new CharMatcher(TokenParser.SP);
    private static final StrMatcher SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
    private static final StrMatcher TRIM_MATCHER = new TrimMatcher();
    private static final StrMatcher SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
    private static final StrMatcher DOUBLE_QUOTE_MATCHER = new CharMatcher('\"');
    private static final StrMatcher QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
    private static final StrMatcher NONE_MATCHER = new NoMatcher();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class CharMatcher extends StrMatcher {

        /* renamed from: ch, reason: collision with root package name */
        private final char f423536ch;

        CharMatcher(char c16) {
            this.f423536ch = c16;
        }

        @Override // org.apache.commons.lang.text.StrMatcher
        public int isMatch(char[] cArr, int i3, int i16, int i17) {
            if (this.f423536ch == cArr[i3]) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class CharSetMatcher extends StrMatcher {
        private final char[] chars;

        CharSetMatcher(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.chars = cArr2;
            Arrays.sort(cArr2);
        }

        @Override // org.apache.commons.lang.text.StrMatcher
        public int isMatch(char[] cArr, int i3, int i16, int i17) {
            if (Arrays.binarySearch(this.chars, cArr[i3]) >= 0) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class NoMatcher extends StrMatcher {
        NoMatcher() {
        }

        @Override // org.apache.commons.lang.text.StrMatcher
        public int isMatch(char[] cArr, int i3, int i16, int i17) {
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class StringMatcher extends StrMatcher {
        private final char[] chars;

        StringMatcher(String str) {
            this.chars = str.toCharArray();
        }

        @Override // org.apache.commons.lang.text.StrMatcher
        public int isMatch(char[] cArr, int i3, int i16, int i17) {
            int length = this.chars.length;
            if (i3 + length > i17) {
                return 0;
            }
            int i18 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i18 < cArr2.length) {
                    if (cArr2[i18] != cArr[i3]) {
                        return 0;
                    }
                    i18++;
                    i3++;
                } else {
                    return length;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class TrimMatcher extends StrMatcher {
        TrimMatcher() {
        }

        @Override // org.apache.commons.lang.text.StrMatcher
        public int isMatch(char[] cArr, int i3, int i16, int i17) {
            if (cArr[i3] <= ' ') {
                return 1;
            }
            return 0;
        }
    }

    protected StrMatcher() {
    }

    public static StrMatcher charMatcher(char c16) {
        return new CharMatcher(c16);
    }

    public static StrMatcher charSetMatcher(char[] cArr) {
        if (cArr != null && cArr.length != 0) {
            if (cArr.length == 1) {
                return new CharMatcher(cArr[0]);
            }
            return new CharSetMatcher(cArr);
        }
        return NONE_MATCHER;
    }

    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public static StrMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    public static StrMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    public static StrMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public static StrMatcher stringMatcher(String str) {
        if (str != null && str.length() != 0) {
            return new StringMatcher(str);
        }
        return NONE_MATCHER;
    }

    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }

    public int isMatch(char[] cArr, int i3) {
        return isMatch(cArr, i3, 0, cArr.length);
    }

    public abstract int isMatch(char[] cArr, int i3, int i16, int i17);

    public static StrMatcher charSetMatcher(String str) {
        if (str != null && str.length() != 0) {
            if (str.length() == 1) {
                return new CharMatcher(str.charAt(0));
            }
            return new CharSetMatcher(str.toCharArray());
        }
        return NONE_MATCHER;
    }
}
