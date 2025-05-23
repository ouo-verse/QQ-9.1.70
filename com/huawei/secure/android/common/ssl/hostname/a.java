package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f37951a;

    /* renamed from: b, reason: collision with root package name */
    private final int f37952b;

    /* renamed from: c, reason: collision with root package name */
    private int f37953c;

    /* renamed from: d, reason: collision with root package name */
    private int f37954d;

    /* renamed from: e, reason: collision with root package name */
    private int f37955e;

    /* renamed from: f, reason: collision with root package name */
    private int f37956f;

    /* renamed from: g, reason: collision with root package name */
    private char[] f37957g;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f37951a = name;
        this.f37952b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        return new java.lang.String(r1, r2, r8.f37956f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a() {
        char[] cArr;
        int i3;
        int i16;
        char c16;
        int i17 = this.f37953c;
        this.f37954d = i17;
        this.f37955e = i17;
        while (true) {
            int i18 = this.f37953c;
            if (i18 >= this.f37952b) {
                char[] cArr2 = this.f37957g;
                int i19 = this.f37954d;
                return new String(cArr2, i19, this.f37955e - i19);
            }
            cArr = this.f37957g;
            char c17 = cArr[i18];
            if (c17 == ' ') {
                int i26 = this.f37955e;
                this.f37956f = i26;
                this.f37953c = i18 + 1;
                this.f37955e = i26 + 1;
                cArr[i26] = TokenParser.SP;
                while (true) {
                    i3 = this.f37953c;
                    i16 = this.f37952b;
                    if (i3 >= i16) {
                        break;
                    }
                    char[] cArr3 = this.f37957g;
                    if (cArr3[i3] != ' ') {
                        break;
                    }
                    int i27 = this.f37955e;
                    this.f37955e = i27 + 1;
                    cArr3[i27] = TokenParser.SP;
                    this.f37953c = i3 + 1;
                }
                if (i3 == i16 || (c16 = this.f37957g[i3]) == ',' || c16 == '+' || c16 == ';') {
                    break;
                }
            } else {
                if (c17 == ';') {
                    break;
                }
                if (c17 == '\\') {
                    int i28 = this.f37955e;
                    this.f37955e = i28 + 1;
                    cArr[i28] = b();
                    this.f37953c++;
                } else {
                    if (c17 == '+' || c17 == ',') {
                        break;
                    }
                    int i29 = this.f37955e;
                    this.f37955e = i29 + 1;
                    cArr[i29] = c17;
                    this.f37953c = i18 + 1;
                }
            }
        }
        int i36 = this.f37954d;
        return new String(cArr, i36, this.f37955e - i36);
    }

    private char b() {
        int i3 = this.f37953c + 1;
        this.f37953c = i3;
        if (i3 != this.f37952b) {
            char c16 = this.f37957g[i3];
            if (c16 == ' ' || c16 == '%' || c16 == '\\' || c16 == '_' || c16 == '\"' || c16 == '#') {
                return c16;
            }
            switch (c16) {
                case '*':
                case '+':
                case ',':
                    return c16;
                default:
                    switch (c16) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            return c16;
                        default:
                            return c();
                    }
            }
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f37951a);
    }

    private char c() {
        int i3;
        int i16;
        int a16 = a(this.f37953c);
        this.f37953c++;
        if (a16 < 128) {
            return (char) a16;
        }
        if (a16 < 192 || a16 > 247) {
            return '?';
        }
        if (a16 <= 223) {
            i3 = a16 & 31;
            i16 = 1;
        } else if (a16 <= 239) {
            i3 = a16 & 15;
            i16 = 2;
        } else {
            i3 = a16 & 7;
            i16 = 3;
        }
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = this.f37953c + 1;
            this.f37953c = i18;
            if (i18 == this.f37952b || this.f37957g[i18] != '\\') {
                return '?';
            }
            int i19 = i18 + 1;
            this.f37953c = i19;
            int a17 = a(i19);
            this.f37953c++;
            if ((a17 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (a17 & 63);
        }
        return (char) i3;
    }

    private String d() {
        int i3;
        char[] cArr;
        char c16;
        int i16 = this.f37953c;
        if (i16 + 4 < this.f37952b) {
            this.f37954d = i16;
            this.f37953c = i16 + 1;
            while (true) {
                i3 = this.f37953c;
                if (i3 == this.f37952b || (c16 = (cArr = this.f37957g)[i3]) == '+' || c16 == ',' || c16 == ';') {
                    break;
                }
                if (c16 == ' ') {
                    this.f37955e = i3;
                    this.f37953c = i3 + 1;
                    while (true) {
                        int i17 = this.f37953c;
                        if (i17 >= this.f37952b || this.f37957g[i17] != ' ') {
                            break;
                        }
                        this.f37953c = i17 + 1;
                    }
                } else {
                    if (c16 >= 'A' && c16 <= 'F') {
                        cArr[i3] = (char) (c16 + TokenParser.SP);
                    }
                    this.f37953c = i3 + 1;
                }
            }
            this.f37955e = i3;
            int i18 = this.f37955e;
            int i19 = this.f37954d;
            int i26 = i18 - i19;
            if (i26 >= 5 && (i26 & 1) != 0) {
                int i27 = i26 / 2;
                byte[] bArr = new byte[i27];
                int i28 = i19 + 1;
                for (int i29 = 0; i29 < i27; i29++) {
                    bArr[i29] = (byte) a(i28);
                    i28 += 2;
                }
                return new String(this.f37957g, this.f37954d, i26);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f37951a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f37951a);
    }

    private String e() {
        int i3;
        int i16;
        int i17;
        int i18;
        char c16;
        char c17;
        char c18;
        int i19;
        int i26;
        char c19;
        char c26;
        while (true) {
            i3 = this.f37953c;
            i16 = this.f37952b;
            if (i3 >= i16 || this.f37957g[i3] != ' ') {
                break;
            }
            this.f37953c = i3 + 1;
        }
        if (i3 == i16) {
            return null;
        }
        this.f37954d = i3;
        this.f37953c = i3 + 1;
        while (true) {
            i17 = this.f37953c;
            i18 = this.f37952b;
            if (i17 >= i18 || (c26 = this.f37957g[i17]) == '=' || c26 == ' ') {
                break;
            }
            this.f37953c = i17 + 1;
        }
        if (i17 < i18) {
            this.f37955e = i17;
            if (this.f37957g[i17] == ' ') {
                while (true) {
                    i19 = this.f37953c;
                    i26 = this.f37952b;
                    if (i19 >= i26 || (c19 = this.f37957g[i19]) == '=' || c19 != ' ') {
                        break;
                    }
                    this.f37953c = i19 + 1;
                }
                if (this.f37957g[i19] != '=' || i19 == i26) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f37951a);
                }
            }
            this.f37953c++;
            while (true) {
                int i27 = this.f37953c;
                if (i27 >= this.f37952b || this.f37957g[i27] != ' ') {
                    break;
                }
                this.f37953c = i27 + 1;
            }
            int i28 = this.f37955e;
            int i29 = this.f37954d;
            if (i28 - i29 > 4) {
                char[] cArr = this.f37957g;
                if (cArr[i29 + 3] == '.' && (((c16 = cArr[i29]) == 'O' || c16 == 'o') && (((c17 = cArr[i29 + 1]) == 'I' || c17 == 'i') && ((c18 = cArr[i29 + 2]) == 'D' || c18 == 'd')))) {
                    this.f37954d = i29 + 4;
                }
            }
            char[] cArr2 = this.f37957g;
            int i36 = this.f37954d;
            return new String(cArr2, i36, i28 - i36);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f37951a);
    }

    private String f() {
        int i3 = this.f37953c + 1;
        this.f37953c = i3;
        this.f37954d = i3;
        this.f37955e = i3;
        while (true) {
            int i16 = this.f37953c;
            if (i16 != this.f37952b) {
                char[] cArr = this.f37957g;
                char c16 = cArr[i16];
                if (c16 == '\"') {
                    this.f37953c = i16 + 1;
                    while (true) {
                        int i17 = this.f37953c;
                        if (i17 >= this.f37952b || this.f37957g[i17] != ' ') {
                            break;
                        }
                        this.f37953c = i17 + 1;
                    }
                    char[] cArr2 = this.f37957g;
                    int i18 = this.f37954d;
                    return new String(cArr2, i18, this.f37955e - i18);
                }
                if (c16 == '\\') {
                    cArr[this.f37955e] = b();
                } else {
                    cArr[this.f37955e] = c16;
                }
                this.f37953c++;
                this.f37955e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f37951a);
            }
        }
    }

    public List<String> b(String str) {
        String f16;
        this.f37953c = 0;
        this.f37954d = 0;
        this.f37955e = 0;
        this.f37956f = 0;
        this.f37957g = this.f37951a.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String e16 = e();
        if (e16 == null) {
            return emptyList;
        }
        do {
            int i3 = this.f37953c;
            if (i3 < this.f37952b) {
                char c16 = this.f37957g[i3];
                if (c16 == '\"') {
                    f16 = f();
                } else if (c16 != '#') {
                    f16 = (c16 == '+' || c16 == ',' || c16 == ';') ? "" : a();
                } else {
                    f16 = d();
                }
                if (str.equalsIgnoreCase(e16)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(f16);
                }
                int i16 = this.f37953c;
                if (i16 < this.f37952b) {
                    char c17 = this.f37957g[i16];
                    if (c17 != ',' && c17 != ';' && c17 != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.f37951a);
                    }
                    this.f37953c = i16 + 1;
                    e16 = e();
                }
            }
            return emptyList;
        } while (e16 != null);
        throw new IllegalStateException("Malformed DN: " + this.f37951a);
    }

    private int a(int i3) {
        int i16;
        int i17;
        int i18 = i3 + 1;
        if (i18 < this.f37952b) {
            char[] cArr = this.f37957g;
            char c16 = cArr[i3];
            if (c16 >= '0' && c16 <= '9') {
                i16 = c16 - '0';
            } else if (c16 >= 'a' && c16 <= 'f') {
                i16 = c16 - 'W';
            } else {
                if (c16 < 'A' || c16 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f37951a);
                }
                i16 = c16 - '7';
            }
            char c17 = cArr[i18];
            if (c17 >= '0' && c17 <= '9') {
                i17 = c17 - '0';
            } else if (c17 >= 'a' && c17 <= 'f') {
                i17 = c17 - 'W';
            } else {
                if (c17 < 'A' || c17 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f37951a);
                }
                i17 = c17 - '7';
            }
            return (i16 << 4) + i17;
        }
        throw new IllegalStateException("Malformed DN: " + this.f37951a);
    }

    public String a(String str) {
        String f16;
        this.f37953c = 0;
        this.f37954d = 0;
        this.f37955e = 0;
        this.f37956f = 0;
        this.f37957g = this.f37951a.toCharArray();
        String e16 = e();
        if (e16 == null) {
            return null;
        }
        do {
            int i3 = this.f37953c;
            if (i3 == this.f37952b) {
                return null;
            }
            char c16 = this.f37957g[i3];
            if (c16 == '\"') {
                f16 = f();
            } else if (c16 != '#') {
                f16 = (c16 == '+' || c16 == ',' || c16 == ';') ? "" : a();
            } else {
                f16 = d();
            }
            if (str.equalsIgnoreCase(e16)) {
                return f16;
            }
            int i16 = this.f37953c;
            if (i16 >= this.f37952b) {
                return null;
            }
            char c17 = this.f37957g[i16];
            if (c17 != ',' && c17 != ';' && c17 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f37951a);
            }
            this.f37953c = i16 + 1;
            e16 = e();
        } while (e16 != null);
        throw new IllegalStateException("Malformed DN: " + this.f37951a);
    }
}
