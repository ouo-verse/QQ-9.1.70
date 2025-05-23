package com.tencent.mobileqq.unusedcodecheck.dexparse;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;
import org.jf.dexlib2.analysis.RegisterType;
import org.jf.util.Hex;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class c implements Closeable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private char[] f306146d;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f306146d = new char[256];
        }
    }

    private String d(int i3, int i16) throws DexParseException {
        throw new DexParseException("bad utf-8 byte " + Hex.u1(i3) + " at offset " + Hex.u4(i16));
    }

    private String e(int i3, int i16) throws DexParseException {
        char c16;
        char[] cArr = this.f306146d;
        if (cArr.length < i16) {
            cArr = new char[i16];
            this.f306146d = cArr;
        }
        int i17 = 0;
        while (i16 > 0) {
            int a16 = a(i3) & 255;
            switch (a16 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if (a16 == 0) {
                        return d(a16, i3);
                    }
                    c16 = (char) a16;
                    i3++;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    return d(a16, i3);
                case 12:
                case 13:
                    int i18 = i3 + 1;
                    int a17 = a(i18) & 255;
                    if ((a17 & 192) != 128) {
                        return d(a17, i18);
                    }
                    int i19 = ((a16 & 31) << 6) | (a17 & 63);
                    if (i19 != 0 && i19 < 128) {
                        return d(a17, i18);
                    }
                    c16 = (char) i19;
                    i3 += 2;
                    break;
                case 14:
                    int i26 = i3 + 1;
                    int a18 = a(i26) & 255;
                    if ((a18 & 192) != 128) {
                        return d(a18, i26);
                    }
                    int i27 = i3 + 2;
                    int a19 = a(i27) & 255;
                    if ((a19 & 192) != 128) {
                        return d(a19, i27);
                    }
                    int i28 = ((a16 & 15) << 12) | ((a18 & 63) << 6) | (a19 & 63);
                    if (i28 < 2048) {
                        return d(a19, i27);
                    }
                    c16 = (char) i28;
                    i3 += 3;
                    break;
            }
            cArr[i17] = c16;
            i17++;
            i16--;
        }
        return new String(cArr, 0, i17);
    }

    abstract byte a(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i3) throws DexParseException {
        int a16 = (a(i3 + 3) << 24) | (a(i3) & 255) | ((a(i3 + 1) & 255) << 8) | ((a(i3 + 2) & 255) << 16);
        if (a16 >= 0) {
            return a16;
        }
        throw new DexParseException("Encountered small uint that is out of range at offset");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c(boolean z16, int i3) throws DexParseException {
        int i16 = i3 + 1;
        int a16 = a(i3) & 255;
        if (a16 > 127) {
            int i17 = i16 + 1;
            int a17 = a(i16) & 255;
            a16 = (a16 & 127) | ((a17 & 127) << 7);
            if (a17 > 127) {
                i16 = i17 + 1;
                int a18 = a(i17) & 255;
                a16 |= (a18 & 127) << 14;
                if (a18 > 127) {
                    i17 = i16 + 1;
                    int a19 = a(i16) & 255;
                    a16 |= (a19 & 127) << 21;
                    if (a19 > 127) {
                        i16 = i17 + 1;
                        byte a26 = a(i17);
                        if (a26 >= 0) {
                            if ((a26 & RegisterType.DOUBLE_HI) > 7 && !z16) {
                                throw new DexParseException("Encountered valid uleb128 that is out of range at offset");
                            }
                            a16 |= a26 << 28;
                        } else {
                            throw new DexParseException("Invalid uleb128 integer encountered at offset");
                        }
                    }
                }
            }
            i16 = i17;
        }
        return e(i16, a16);
    }
}
