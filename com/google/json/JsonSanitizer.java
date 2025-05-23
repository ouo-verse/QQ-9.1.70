package com.google.json;

import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.math.BigInteger;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class JsonSanitizer {

    /* renamed from: g, reason: collision with root package name */
    private static final UnbracketedComma f35228g;

    /* renamed from: h, reason: collision with root package name */
    private static final char[] f35229h;

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f35230i;

    /* renamed from: a, reason: collision with root package name */
    private final int f35231a;

    /* renamed from: b, reason: collision with root package name */
    private final String f35232b;

    /* renamed from: c, reason: collision with root package name */
    private int f35233c;

    /* renamed from: d, reason: collision with root package name */
    private boolean[] f35234d;

    /* renamed from: e, reason: collision with root package name */
    private StringBuilder f35235e;

    /* renamed from: f, reason: collision with root package name */
    private int f35236f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum State {
        START_ARRAY,
        BEFORE_ELEMENT,
        AFTER_ELEMENT,
        START_MAP,
        BEFORE_KEY,
        AFTER_KEY,
        BEFORE_VALUE,
        AFTER_VALUE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class UnbracketedComma extends Exception {
        private static final long serialVersionUID = 783239978717247850L;

        UnbracketedComma() {
        }

        /* synthetic */ UnbracketedComma(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35237a;

        static {
            int[] iArr = new int[State.values().length];
            f35237a = iArr;
            try {
                iArr[State.BEFORE_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35237a[State.BEFORE_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35237a[State.BEFORE_KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35237a[State.AFTER_KEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35237a[State.START_MAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35237a[State.START_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35237a[State.AFTER_ELEMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35237a[State.AFTER_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        UnbracketedComma unbracketedComma = new UnbracketedComma(null);
        f35228g = unbracketedComma;
        unbracketedComma.setStackTrace(new StackTraceElement[0]);
        f35229h = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f35230i = new int[]{-1, -1, 63, 39, 31, 27, 24, 22, 21, 19, 18, 18, 17, 17, 16, 16, 15};
    }

    JsonSanitizer(String str, int i3) {
        this.f35231a = Math.min(Math.max(1, i3), 4096);
        this.f35232b = str == null ? "null" : str;
    }

    private void a(int i3, int i16) {
        int i17;
        while (true) {
            i16--;
            if (i16 >= 0) {
                int i18 = (i3 >>> (i16 * 4)) & 15;
                StringBuilder sb5 = this.f35235e;
                if (i18 < 10) {
                    i17 = 48;
                } else {
                    i17 = 87;
                }
                sb5.append((char) (i18 + i17));
            } else {
                return;
            }
        }
    }

    private boolean b(int i3, int i16) {
        d(i3, i3);
        int length = this.f35235e.length();
        q(i3, i16);
        d(i16, i16);
        return c(this.f35235e, length, this.f35235e.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
    
        if ('.' == r18.charAt(r6)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r6 >= r20) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r10 = r18.charAt(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if ('0' > r10) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r10 <= '9') goto L94;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean c(StringBuilder sb5, int i3, int i16) {
        int i17;
        int i18;
        int parseInt;
        int i19;
        int i26;
        char c16;
        char charAt;
        char c17 = '-';
        if (sb5.charAt(i3) == '-') {
            i17 = 1;
        } else {
            i17 = 0;
        }
        int i27 = i3 + i17;
        int i28 = i27;
        while (i28 < i16 && '0' <= (charAt = sb5.charAt(i28)) && charAt <= '9') {
            i28++;
        }
        if (i28 != i16) {
        }
        if (i28 == i16) {
            i18 = i16;
        } else {
            i18 = i28 + 1;
            if (sb5.charAt(i18) == '+') {
                i18++;
            }
        }
        if (i16 == i18) {
            parseInt = 0;
        } else {
            try {
                parseInt = Integer.parseInt(sb5.substring(i18, i16), 10);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        int i29 = i27;
        int i36 = i29;
        boolean z16 = false;
        int i37 = 0;
        boolean z17 = true;
        while (i29 < i28) {
            char charAt2 = sb5.charAt(i29);
            if (charAt2 == '.') {
                if (z17) {
                    i37 = 0;
                }
                z16 = true;
            } else {
                if ((!z17 || charAt2 != '0') && !z16) {
                    parseInt++;
                }
                if (charAt2 == '0') {
                    i37++;
                } else {
                    if (z17) {
                        if (z16) {
                            parseInt -= i37;
                        }
                        i19 = parseInt;
                        i26 = 0;
                    } else {
                        int i38 = i37;
                        i19 = parseInt;
                        i26 = i38;
                    }
                    while (true) {
                        if (i26 == 0 && charAt2 == 0) {
                            break;
                        }
                        if (i26 == 0) {
                            c16 = 0;
                        } else {
                            i26--;
                            c16 = charAt2;
                            charAt2 = '0';
                        }
                        sb5.setCharAt(i36, charAt2);
                        charAt2 = c16;
                        i36++;
                    }
                    z17 = false;
                    int i39 = i19;
                    i37 = i26;
                    parseInt = i39;
                }
            }
            i29++;
        }
        sb5.setLength(i36);
        int i46 = i36 - i27;
        if (z17) {
            sb5.setLength(i3);
            sb5.append('0');
            return true;
        }
        if (i46 <= parseInt && parseInt <= 21) {
            while (i46 < parseInt) {
                sb5.append('0');
                i46++;
            }
        } else if (parseInt > 0 && parseInt <= 21) {
            sb5.insert(i27 + parseInt, '.');
        } else if (-6 < parseInt && parseInt <= 0) {
            sb5.insert(i27, "0.000000".substring(0, 2 - parseInt));
        } else {
            if (i46 != 1) {
                sb5.insert(i27 + 1, '.');
            }
            int i47 = parseInt - 1;
            sb5.append('e');
            if (i47 >= 0) {
                c17 = '+';
            }
            sb5.append(c17);
            sb5.append(Math.abs(i47));
        }
        return true;
    }

    private void d(int i3, int i16) {
        if (this.f35235e == null) {
            this.f35235e = new StringBuilder(this.f35232b.length() + 16);
        }
        this.f35235e.append((CharSequence) this.f35232b, this.f35236f, i3);
        this.f35236f = i16;
    }

    private void e(int i3) {
        while (true) {
            i3--;
            if (i3 >= this.f35236f) {
                char charAt = this.f35232b.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                    if (charAt == ',') {
                        d(i3, i3 + 1);
                        return;
                    }
                    throw new AssertionError("" + this.f35232b.charAt(i3));
                }
            } else {
                int length = this.f35235e.length();
                while (true) {
                    length--;
                    if (length >= 0) {
                        char charAt2 = this.f35235e.charAt(length);
                        if (charAt2 != '\t' && charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ') {
                            if (charAt2 == ',') {
                                this.f35235e.setLength(length);
                                return;
                            }
                            throw new AssertionError("" + this.f35235e.charAt(length));
                        }
                    } else {
                        throw new AssertionError("Trailing comma not found in " + this.f35232b + " or " + ((Object) this.f35235e));
                    }
                }
            }
        }
    }

    private int f(int i3, int i16) {
        while (i3 < i16) {
            char charAt = this.f35232b.charAt(i3);
            if ('0' <= charAt && charAt <= '9') {
                i3++;
            } else {
                return i3;
            }
        }
        return i16;
    }

    private static int g(String str, int i3) {
        int i16;
        char charAt = str.charAt(i3);
        int i17 = i3;
        do {
            i17 = str.indexOf(charAt, i17 + 1);
            if (i17 >= 0) {
                i16 = i17;
                while (i16 > i3 && str.charAt(i16 - 1) == '\\') {
                    i16--;
                }
            } else {
                return str.length();
            }
        } while (((i17 - i16) & 1) != 0);
        return i17 + 1;
    }

    private static int h(char c16) {
        int i3;
        int i16 = c16 | TokenParser.SP;
        if (i16 <= 57) {
            i3 = 48;
        } else {
            i3 = 87;
        }
        return i16 - i3;
    }

    private void i(int i3, char c16) {
        r(i3, i3, c16);
    }

    private void j(int i3, String str) {
        s(i3, i3, str);
    }

    private static boolean k(char c16) {
        if ('0' <= c16 && c16 <= '9') {
            return true;
        }
        int i3 = c16 | TokenParser.SP;
        if (97 <= i3 && i3 <= 102) {
            return true;
        }
        return false;
    }

    private boolean l(int i3) {
        return k(this.f35232b.charAt(i3));
    }

    private boolean m(int i3) {
        char charAt = this.f35232b.charAt(i3);
        if (charAt <= ' ' || charAt == '\"' || charAt == ',' || charAt == ':' || charAt == '[' || charAt == ']' || charAt == '{' || charAt == '}') {
            return true;
        }
        return false;
    }

    private boolean n(int i3, int i16) {
        int i17 = i16 - i3;
        if (i17 == 5) {
            return "false".regionMatches(0, this.f35232b, i3, i17);
        }
        if (i17 != 4) {
            return false;
        }
        if (!"null".regionMatches(0, this.f35232b, i3, i17) && !"true".regionMatches(0, this.f35232b, i3, i17)) {
            return false;
        }
        return true;
    }

    private static boolean o(char c16) {
        if ('0' <= c16 && c16 <= '7') {
            return true;
        }
        return false;
    }

    private boolean p(int i3) {
        return o(this.f35232b.charAt(i3));
    }

    private void q(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        char charAt;
        if (i3 < i16) {
            char charAt2 = this.f35232b.charAt(i3);
            if (charAt2 != '+') {
                if (charAt2 == '-') {
                    i3++;
                }
            } else {
                int i27 = i3 + 1;
                d(i3, i27);
                i3 = i27;
            }
        }
        int f16 = f(i3, i16);
        if (i3 == f16) {
            i(i3, '0');
        } else if ('0' == this.f35232b.charAt(i3)) {
            int i28 = f16 - i3;
            int i29 = 16;
            int i36 = 0;
            boolean z16 = true;
            if (i28 == 1 && f16 < i16 && 120 == (this.f35232b.charAt(f16) | TokenParser.SP)) {
                int i37 = f16 + 1;
                int i38 = i37;
                while (i38 < i16) {
                    char charAt3 = this.f35232b.charAt(i38);
                    if ('0' <= charAt3 && charAt3 <= '9') {
                        i26 = charAt3 - '0';
                    } else {
                        char c16 = (char) (charAt3 | TokenParser.SP);
                        if ('a' > c16 || c16 > 'f') {
                            break;
                        } else {
                            i26 = c16 - 'W';
                        }
                    }
                    i36 = Math.max(i26, i36);
                    i38++;
                }
                i18 = i36;
                i19 = 16;
                int i39 = i38;
                i17 = i37;
                f16 = i39;
            } else if (i28 > 1) {
                for (int i46 = i3; i46 < f16; i46++) {
                    int charAt4 = this.f35232b.charAt(i46) - '0';
                    if (charAt4 < 0) {
                        break;
                    }
                    i36 = Math.max(charAt4, i36);
                }
                i18 = i36;
                i19 = 8;
                i17 = i3;
            } else {
                i17 = -1;
                z16 = false;
                i18 = 0;
                i19 = 10;
            }
            if (z16) {
                d(i3, f16);
                String substring = this.f35232b.substring(i17, f16);
                int length = substring.length();
                if (i19 > i18) {
                    i29 = i19;
                } else if (i18 <= 10) {
                    i29 = 10;
                }
                if (length == 0) {
                    this.f35235e.append('0');
                } else if (f35230i[i29] >= length) {
                    this.f35235e.append(Long.parseLong(substring, i29));
                } else {
                    this.f35235e.append(new BigInteger(substring, i29));
                }
            }
        }
        if (f16 < i16 && this.f35232b.charAt(f16) == '.') {
            int i47 = f16 + 1;
            int f17 = f(i47, i16);
            if (f17 == i47) {
                i(i47, '0');
            }
            f16 = f17;
        }
        if (f16 < i16 && 101 == (this.f35232b.charAt(f16) | TokenParser.SP)) {
            int i48 = f16 + 1;
            if (i48 < i16 && ((charAt = this.f35232b.charAt(i48)) == '+' || charAt == '-')) {
                i48++;
            }
            int f18 = f(i48, i16);
            if (f18 == i48) {
                i(i48, '0');
            }
            f16 = f18;
        }
        if (f16 != i16) {
            d(f16, i16);
        }
    }

    private void r(int i3, int i16, char c16) {
        d(i3, i16);
        this.f35235e.append(c16);
    }

    private void s(int i3, int i16, String str) {
        d(i3, i16);
        this.f35235e.append(str);
    }

    private State t(int i3, State state, boolean z16) throws UnbracketedComma {
        switch (a.f35237a[state.ordinal()]) {
            case 1:
                return State.AFTER_VALUE;
            case 2:
            case 6:
                return State.AFTER_ELEMENT;
            case 3:
            case 5:
                if (z16) {
                    return State.AFTER_KEY;
                }
                j(i3, "\"\":");
                return State.AFTER_VALUE;
            case 4:
                i(i3, ':');
                return State.AFTER_VALUE;
            case 7:
                if (this.f35233c != 0) {
                    i(i3, ',');
                    return State.AFTER_ELEMENT;
                }
                throw f35228g;
            case 8:
                if (z16) {
                    i(i3, ',');
                    return State.AFTER_KEY;
                }
                j(i3, ",\"\":");
                return State.AFTER_VALUE;
            default:
                throw new AssertionError();
        }
    }

    public static String u(String str) {
        return v(str, 64);
    }

    public static String v(String str, int i3) {
        JsonSanitizer jsonSanitizer = new JsonSanitizer(str, i3);
        jsonSanitizer.w();
        return jsonSanitizer.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        if (java.lang.Character.isLowSurrogate(r17.f35232b.charAt(r6)) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0129, code lost:
    
        if (l(r6) != false) goto L39;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:78:0x00f2. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:79:0x00f5. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void x(int i3, int i16) {
        int i17;
        int i18 = i3;
        boolean z16 = false;
        while (i18 < i16) {
            char charAt = this.f35232b.charAt(i18);
            if (charAt != '\t') {
                if (charAt != '\n') {
                    if (charAt != '\r') {
                        if (charAt != '\"' && charAt != '\'') {
                            if (charAt != '<') {
                                if (charAt != '>') {
                                    if (charAt != '\\') {
                                        if (charAt != ']') {
                                            if (charAt != '\u2028') {
                                                if (charAt != '\u2029') {
                                                    if (charAt >= ' ') {
                                                        if (charAt >= '\ud800') {
                                                            if (charAt < '\ue000') {
                                                                if (Character.isHighSurrogate(charAt)) {
                                                                    i17 = i18 + 1;
                                                                    if (i17 < i16) {
                                                                    }
                                                                }
                                                            } else if (charAt <= '\ufffd') {
                                                            }
                                                        }
                                                    }
                                                    s(i18, i18 + 1, "\\u");
                                                    int i19 = 4;
                                                    while (true) {
                                                        i19--;
                                                        if (i19 >= 0) {
                                                            this.f35235e.append(f35229h[(charAt >>> (i19 << 2)) & 15]);
                                                        }
                                                    }
                                                } else {
                                                    s(i18, i18 + 1, "\\u2029");
                                                }
                                            } else {
                                                s(i18, i18 + 1, "\\u2028");
                                            }
                                        } else if (i18 + 2 < i16) {
                                            int i26 = i18 + 1;
                                            char y16 = (char) y(this.f35232b, (int) (i26 + (r11 >>> 16)));
                                            if (']' == ((char) y(this.f35232b, i26)) && '>' == y16) {
                                                s(i18, i26, "\\u005d");
                                            }
                                        }
                                    } else {
                                        int i27 = i18 + 1;
                                        if (i27 == i16) {
                                            d(i18, i27);
                                        } else {
                                            char charAt2 = this.f35232b.charAt(i27);
                                            if (charAt2 != '\"' && charAt2 != '\\' && charAt2 != 'b' && charAt2 != 'f' && charAt2 != 'n' && charAt2 != 'r') {
                                                if (charAt2 != 'x') {
                                                    switch (charAt2) {
                                                        case '/':
                                                            break;
                                                        case '0':
                                                        case '1':
                                                        case '2':
                                                        case '3':
                                                        case '4':
                                                        case '5':
                                                        case '6':
                                                        case '7':
                                                            int i28 = i27 + 1;
                                                            if (i28 < i16 && p(i28)) {
                                                                i28++;
                                                                if (charAt2 <= '3' && i28 < i16 && p(i28)) {
                                                                    i28++;
                                                                }
                                                            }
                                                            int i29 = 0;
                                                            for (int i36 = i27; i36 < i28; i36++) {
                                                                i29 = (i29 << 3) | (this.f35232b.charAt(i36) - '0');
                                                            }
                                                            s(i27, i28, "u00");
                                                            a(i29, 2);
                                                            i18 = i28 - 1;
                                                            break;
                                                        default:
                                                            switch (charAt2) {
                                                                case 't':
                                                                    break;
                                                                case 'u':
                                                                    if (i18 + 6 < i16 && l(i18 + 2) && l(i18 + 3) && l(i18 + 4)) {
                                                                        i17 = i18 + 5;
                                                                        break;
                                                                    }
                                                                    d(i18, i27);
                                                                    break;
                                                                case 'v':
                                                                    s(i18, i18 + 2, "\\u0008");
                                                                    break;
                                                                default:
                                                                    d(i18, i27);
                                                                    break;
                                                            }
                                                    }
                                                } else {
                                                    if (i18 + 4 < i16) {
                                                        int i37 = i18 + 2;
                                                        if (l(i37)) {
                                                            int i38 = i18 + 3;
                                                            if (l(i38)) {
                                                                s(i18, i37, "\\u00");
                                                                i18 = i38;
                                                            }
                                                        }
                                                    }
                                                    d(i18, i27);
                                                }
                                            }
                                            i18 = i27;
                                        }
                                    }
                                } else if (i18 - 2 >= i3) {
                                    int i39 = i18 - 1;
                                    int z17 = z(this.f35232b, i39);
                                    char c16 = (char) z17;
                                    if ('-' == ((char) z(this.f35232b, i39 - (z17 >>> 16))) && '-' == c16) {
                                        s(i18, i18 + 1, "\\u003e");
                                    }
                                }
                            } else if (i18 + 3 < i16) {
                                int i46 = i18 + 1;
                                int y17 = y(this.f35232b, i46);
                                char c17 = (char) y17;
                                char y18 = (char) y(this.f35232b, (y17 >>> 16) + i46);
                                int i47 = i18;
                                char y19 = (char) y(this.f35232b, (int) (r7 + (r14 >>> 16)));
                                char c18 = (char) (c17 | TokenParser.SP);
                                char c19 = (char) (y18 | TokenParser.SP);
                                char c26 = (char) (y19 | TokenParser.SP);
                                if ((c17 == '!' && y18 == '-' && y19 == '-') || ((c18 == 's' && c19 == 'c' && c26 == 'r') || (c17 == '/' && c19 == 's' && c26 == 'c'))) {
                                    i18 = i47;
                                    s(i18, i46, "\\u003c");
                                } else {
                                    i18 = i47;
                                }
                            }
                        } else if (i18 == i3) {
                            if (charAt == '\'') {
                                r(i18, i18 + 1, '\"');
                            }
                        } else {
                            int i48 = i18 + 1;
                            if (i48 == i16) {
                                char charAt3 = this.f35232b.charAt(i3);
                                if (charAt3 != '\'') {
                                    charAt3 = '\"';
                                }
                                if (charAt3 == charAt) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                            }
                            if (z16) {
                                if (charAt == '\'') {
                                    r(i18, i48, '\"');
                                }
                            } else if (charAt == '\"') {
                                i(i18, '\\');
                            }
                        }
                    } else {
                        s(i18, i18 + 1, "\\r");
                    }
                } else {
                    s(i18, i18 + 1, RedTouch.NEWLINE_CHAR);
                }
            } else {
                s(i18, i18 + 1, "\\t");
            }
            i18++;
        }
        if (!z16) {
            i(i16, '\"');
        }
    }

    private static int y(String str, int i3) {
        int length = str.length();
        int i16 = 0;
        if (i3 >= length) {
            return 0;
        }
        char charAt = str.charAt(i3);
        if (charAt == '\\') {
            int i17 = i3 + 1;
            if (i17 == length) {
                return 65536;
            }
            char charAt2 = str.charAt(i17);
            if (charAt2 == 'b') {
                return 131080;
            }
            if (charAt2 != 'f') {
                if (charAt2 != 'n') {
                    if (charAt2 != 'r') {
                        if (charAt2 != 'x') {
                            switch (charAt2) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                    int i18 = i17 + 1;
                                    if (i18 < length && o(str.charAt(i18))) {
                                        i18++;
                                        if (charAt2 <= '3' && i18 < length && o(str.charAt(i18))) {
                                            i18++;
                                        }
                                    }
                                    while (i17 < i18) {
                                        i16 = (i16 << 3) | (str.charAt(i17) - '0');
                                        i17++;
                                    }
                                    return ((i18 - i3) << 16) | i16;
                                default:
                                    switch (charAt2) {
                                        case 't':
                                            return 131081;
                                        case 'u':
                                            int i19 = i3 + 5;
                                            if (i19 < length) {
                                                char charAt3 = str.charAt(i3 + 2);
                                                char charAt4 = str.charAt(i3 + 3);
                                                char charAt5 = str.charAt(i3 + 4);
                                                char charAt6 = str.charAt(i19);
                                                if (k(charAt3) && k(charAt4) && k(charAt5) && k(charAt6)) {
                                                    return h(charAt6) | (h(charAt5) << 4) | (h(charAt3) << 12) | 24576 | (h(charAt4) << 8);
                                                }
                                            }
                                            break;
                                        case 'v':
                                            return 131080;
                                    }
                            }
                        } else {
                            int i26 = i3 + 3;
                            if (i26 < length) {
                                char charAt7 = str.charAt(i3 + 2);
                                char charAt8 = str.charAt(i26);
                                if (k(charAt7) && k(charAt8)) {
                                    return h(charAt8) | (h(charAt7) << 4) | 16384;
                                }
                            }
                        }
                        return 0 | charAt2;
                    }
                    return 131085;
                }
                return 131082;
            }
            return 131084;
        }
        return charAt | 0;
    }

    private static int z(String str, int i3) {
        int i16;
        if (i3 < 0) {
            return 0;
        }
        int i17 = 1;
        while (true) {
            if (i17 >= 6 || (i16 = i3 - i17) < 0) {
                break;
            }
            if (str.charAt(i16) == '\\') {
                int i18 = 1;
                while (true) {
                    int i19 = i16 - i18;
                    if (i19 < 0 || str.charAt(i19) != '\\') {
                        break;
                    }
                    i18++;
                }
                if ((1 & i18) == 0) {
                    int y16 = y(str, i16);
                    if ((y16 >>> 16) == i17) {
                        return y16;
                    }
                }
            } else {
                i17++;
            }
        }
        return str.charAt(i3) | 0;
    }

    public String toString() {
        StringBuilder sb5 = this.f35235e;
        if (sb5 != null) {
            return sb5.toString();
        }
        return this.f35232b;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x0052. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db A[Catch: UnbracketedComma -> 0x0234, TryCatch #1 {UnbracketedComma -> 0x0234, blocks: (B:5:0x0020, B:26:0x0052, B:30:0x0062, B:35:0x008a, B:53:0x0095, B:57:0x009c, B:62:0x00b0, B:68:0x00bf, B:70:0x00c6, B:74:0x00cb, B:76:0x00d5, B:78:0x00d7, B:80:0x00db, B:82:0x00e2, B:83:0x00fd, B:84:0x00e9, B:86:0x00ef, B:88:0x00f5, B:101:0x0100, B:103:0x021c, B:153:0x010d, B:182:0x0111, B:155:0x011c, B:164:0x013b, B:168:0x014d, B:169:0x0152, B:171:0x0156, B:174:0x015f, B:176:0x0162, B:178:0x0130, B:179:0x0134, B:180:0x0138, B:184:0x0166, B:186:0x016e, B:189:0x0179, B:191:0x0185, B:192:0x0188, B:194:0x018b, B:196:0x0190, B:197:0x0195, B:199:0x019c, B:201:0x01a1, B:205:0x01ae, B:207:0x01b2, B:215:0x01c9, B:218:0x01e5, B:224:0x01cc, B:226:0x01d0, B:227:0x01d2, B:229:0x01db, B:234:0x01e9, B:236:0x01ef, B:238:0x01f4, B:239:0x01fc, B:242:0x0200, B:244:0x0203, B:246:0x0206, B:248:0x020c, B:250:0x0212, B:253:0x0218, B:254:0x021a), top: B:4:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void w() {
        char c16;
        boolean z16;
        State state;
        int i3;
        boolean z17;
        char c17;
        State state2;
        boolean z18;
        boolean z19;
        char charAt;
        boolean z26 = false;
        this.f35236f = 0;
        this.f35233c = 0;
        this.f35235e = null;
        State state3 = State.START_ARRAY;
        int length = this.f35232b.length();
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                try {
                    char charAt2 = this.f35232b.charAt(i16);
                    if (charAt2 != '\t' && charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ') {
                        try {
                            if (charAt2 != '\"') {
                                if (charAt2 != ',') {
                                    if (charAt2 != '/') {
                                        if (charAt2 != ':') {
                                            if (charAt2 != '[') {
                                                if (charAt2 != ']') {
                                                    if (charAt2 != '{') {
                                                        if (charAt2 != '}') {
                                                            switch (charAt2) {
                                                                case '\'':
                                                                    z16 = false;
                                                                    break;
                                                                case '(':
                                                                case ')':
                                                                    d(i16, i16 + 1);
                                                                    z16 = false;
                                                                    break;
                                                                default:
                                                                    int i17 = i16;
                                                                    while (i17 < length && (('a' <= (charAt = this.f35232b.charAt(i17)) && charAt <= 'z') || (('0' <= charAt && charAt <= '9') || charAt == '+' || charAt == '-' || charAt == '.' || (('A' <= charAt && charAt <= 'Z') || charAt == '_' || charAt == '$')))) {
                                                                        i17++;
                                                                    }
                                                                    if (i17 == i16) {
                                                                        d(i16, i16 + 1);
                                                                    } else {
                                                                        state3 = t(i16, state3, true);
                                                                        if (('0' > charAt2 || charAt2 > '9') && charAt2 != '.' && charAt2 != '+' && charAt2 != '-') {
                                                                            z18 = false;
                                                                            if (z18 && n(i16, i17)) {
                                                                                z19 = true;
                                                                            } else {
                                                                                z19 = false;
                                                                            }
                                                                            if (!z18 && !z19) {
                                                                                while (i17 < length && !m(i17)) {
                                                                                    i17++;
                                                                                }
                                                                                if (i17 < length && this.f35232b.charAt(i17) == '\"') {
                                                                                    i17++;
                                                                                }
                                                                            }
                                                                            if (state3 != State.AFTER_KEY) {
                                                                                i(i16, '\"');
                                                                                if (z18) {
                                                                                    b(i16, i17);
                                                                                    i(i17, '\"');
                                                                                } else {
                                                                                    x(i16, i17);
                                                                                }
                                                                            } else if (z18) {
                                                                                q(i16, i17);
                                                                            } else if (!z19) {
                                                                                i(i16, '\"');
                                                                                x(i16, i17);
                                                                            }
                                                                            i16 = i17 - 1;
                                                                        }
                                                                        z18 = true;
                                                                        if (z18) {
                                                                        }
                                                                        z19 = false;
                                                                        if (!z18) {
                                                                            while (i17 < length) {
                                                                                i17++;
                                                                            }
                                                                            if (i17 < length) {
                                                                                i17++;
                                                                            }
                                                                        }
                                                                        if (state3 != State.AFTER_KEY) {
                                                                        }
                                                                        i16 = i17 - 1;
                                                                    }
                                                                    z16 = false;
                                                                    break;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (this.f35233c == 0) {
                                                    d(i16, this.f35232b.length());
                                                } else {
                                                    int i18 = a.f35237a[state3.ordinal()];
                                                    if (i18 != 1) {
                                                        if (i18 != 2 && i18 != 3) {
                                                            if (i18 == 4) {
                                                                j(i16, ":null");
                                                            }
                                                        } else {
                                                            e(i16);
                                                        }
                                                    } else {
                                                        j(i16, "null");
                                                    }
                                                    int i19 = this.f35233c - 1;
                                                    this.f35233c = i19;
                                                    if (this.f35234d[i19]) {
                                                        c17 = '}';
                                                    } else {
                                                        c17 = ']';
                                                    }
                                                    if (charAt2 != c17) {
                                                        r(i16, i16 + 1, c17);
                                                    }
                                                    int i26 = this.f35233c;
                                                    if (i26 != 0 && this.f35234d[i26 - 1]) {
                                                        state2 = State.AFTER_VALUE;
                                                        state3 = state2;
                                                        z16 = false;
                                                    }
                                                    state2 = State.AFTER_ELEMENT;
                                                    state3 = state2;
                                                    z16 = false;
                                                }
                                            }
                                            z16 = false;
                                            t(i16, state3, false);
                                            if (this.f35234d == null) {
                                                this.f35234d = new boolean[this.f35231a];
                                            }
                                            if (charAt2 == '{') {
                                                z17 = true;
                                            } else {
                                                z17 = false;
                                            }
                                            boolean[] zArr = this.f35234d;
                                            int i27 = this.f35233c;
                                            zArr[i27] = z17;
                                            this.f35233c = i27 + 1;
                                            if (z17) {
                                                state = State.START_MAP;
                                            } else {
                                                state = State.START_ARRAY;
                                            }
                                            state3 = state;
                                        } else {
                                            z16 = z26;
                                            if (state3 == State.AFTER_KEY) {
                                                state = State.BEFORE_VALUE;
                                                state3 = state;
                                            } else {
                                                d(i16, i16 + 1);
                                            }
                                        }
                                    } else {
                                        z16 = z26;
                                        int i28 = i16 + 1;
                                        if (i28 < length) {
                                            char charAt3 = this.f35232b.charAt(i28);
                                            if (charAt3 != '*') {
                                                if (charAt3 == '/') {
                                                    i3 = i16 + 2;
                                                    while (i3 < length) {
                                                        char charAt4 = this.f35232b.charAt(i3);
                                                        if (charAt4 != '\n' && charAt4 != '\r' && charAt4 != '\u2028' && charAt4 != '\u2029') {
                                                            i3++;
                                                        }
                                                        i28 = i3 + 1;
                                                    }
                                                    i28 = length;
                                                }
                                            } else {
                                                if (i16 + 3 < length) {
                                                    i3 = i16 + 2;
                                                    do {
                                                        i3 = this.f35232b.indexOf(47, i3 + 1);
                                                        if (i3 >= 0) {
                                                        }
                                                    } while (this.f35232b.charAt(i3 - 1) != '*');
                                                    i28 = i3 + 1;
                                                }
                                                i28 = length;
                                            }
                                        }
                                        d(i16, i28);
                                        i16 = i28 - 1;
                                    }
                                } else {
                                    z16 = z26;
                                    if (this.f35233c != 0) {
                                        switch (a.f35237a[state3.ordinal()]) {
                                            case 1:
                                                j(i16, "null");
                                                state3 = State.BEFORE_KEY;
                                                break;
                                            case 2:
                                            case 6:
                                                j(i16, "null");
                                                state3 = State.BEFORE_ELEMENT;
                                                break;
                                            case 3:
                                            case 4:
                                            case 5:
                                                d(i16, i16 + 1);
                                                break;
                                            case 7:
                                                state3 = State.BEFORE_ELEMENT;
                                                break;
                                            case 8:
                                                state3 = State.BEFORE_KEY;
                                                break;
                                        }
                                    } else {
                                        throw f35228g;
                                    }
                                }
                            } else {
                                z16 = z26;
                            }
                            int g16 = g(this.f35232b, i16);
                            x(i16, g16);
                            i16 = g16 - 1;
                            state3 = state;
                        } catch (UnbracketedComma unused) {
                            state3 = state;
                            d(i16, this.f35232b.length());
                            if (state3 == State.START_ARRAY && this.f35233c == 0) {
                                j(length, "null");
                                state3 = State.AFTER_ELEMENT;
                            }
                            StringBuilder sb5 = this.f35235e;
                            if ((sb5 != null && sb5.length() != 0) || this.f35236f != 0 || this.f35233c != 0) {
                                if (this.f35235e == null) {
                                    this.f35235e = new StringBuilder(this.f35233c + length);
                                }
                                this.f35235e.append((CharSequence) this.f35232b, this.f35236f, length);
                                this.f35236f = length;
                                int i29 = a.f35237a[state3.ordinal()];
                                if (i29 != 1) {
                                    if (i29 != 2 && i29 != 3) {
                                        if (i29 == 4) {
                                            this.f35235e.append(":null");
                                        }
                                    } else {
                                        e(length);
                                    }
                                } else {
                                    this.f35235e.append("null");
                                }
                                while (true) {
                                    int i36 = this.f35233c;
                                    if (i36 != 0) {
                                        StringBuilder sb6 = this.f35235e;
                                        boolean[] zArr2 = this.f35234d;
                                        int i37 = i36 - 1;
                                        this.f35233c = i37;
                                        if (zArr2[i37]) {
                                            c16 = '}';
                                        } else {
                                            c16 = ']';
                                        }
                                        sb6.append(c16);
                                    } else {
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                        state = t(i16, state3, true);
                    } else {
                        z16 = z26;
                    }
                    i16++;
                    z26 = z16;
                } catch (UnbracketedComma unused2) {
                }
            }
        }
    }
}
