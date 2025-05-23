package o01;

import com.tencent.mobileqq.text.EmotcationConstants;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends j {
    @Override // o01.j
    public final int a() {
        return this.f421689b.length();
    }

    @Override // o01.j
    public final void b(a aVar) {
        int length = this.f421689b.length();
        int i3 = 0;
        while (true) {
            int i16 = i3 + 1;
            if (i16 >= length) {
                break;
            }
            aVar.a(c(this.f421689b.charAt(i16)) + (c(this.f421689b.charAt(i3)) * 45), 11);
            i3 += 2;
        }
        if (i3 < length) {
            aVar.a(c(this.f421689b.charAt(i3)), 6);
        }
    }

    public d(String str) {
        super(2, str);
    }

    public final int c(char c16) {
        if ('0' <= c16 && c16 < ':') {
            return c16 - '0';
        }
        if ('A' <= c16 && c16 < '[') {
            return (c16 - EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET) + 10;
        }
        int i3 = 36;
        if (c16 != ' ') {
            int i16 = 37;
            if (c16 != '$') {
                if (c16 == '%') {
                    return 38;
                }
                i16 = 42;
                if (c16 == '*') {
                    return 39;
                }
                i3 = 43;
                if (c16 == '+') {
                    return 40;
                }
                if (c16 == '-') {
                    return 41;
                }
                if (c16 != '.') {
                    if (c16 != '/') {
                        if (c16 == ':') {
                            return 44;
                        }
                        throw new IllegalArgumentException("Illegal character: " + c16);
                    }
                }
            }
            return i16;
        }
        return i3;
    }
}
