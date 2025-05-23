package com.tencent.theme;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int[] f376090a;

    /* renamed from: b, reason: collision with root package name */
    private String[] f376091b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f376092c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f376093d;

    /* renamed from: e, reason: collision with root package name */
    private int f376094e;

    /* renamed from: f, reason: collision with root package name */
    private ByteBuffer f376095f;

    q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public static q c(ByteBuffer byteBuffer) throws IOException {
        int i3;
        a.b(byteBuffer, 1835009);
        int i16 = byteBuffer.getInt();
        int i17 = byteBuffer.getInt();
        int i18 = byteBuffer.getInt();
        int i19 = byteBuffer.getInt();
        int i26 = byteBuffer.getInt();
        int i27 = byteBuffer.getInt();
        q qVar = new q();
        qVar.f376090a = a.c(byteBuffer, i17);
        if (i18 != 0) {
            qVar.f376092c = a.c(byteBuffer, i18);
        }
        int position = byteBuffer.position();
        qVar.f376094e = i19;
        if (i27 == 0) {
            i3 = i16;
        } else {
            i3 = i27;
        }
        int i28 = i3 - i26;
        if (i28 % 4 == 0) {
            ByteBuffer wrap = ByteBuffer.wrap(byteBuffer.array(), position, i28);
            wrap.order(byteBuffer.order());
            qVar.f376095f = wrap;
            qVar.f376091b = new String[i17];
            a.d(byteBuffer, i28);
            if (i19 != 0 && i19 != 256) {
                throw new IOException("Unknow version xml file: version: " + i19);
            }
            if (i27 != 0) {
                int i29 = i16 - i27;
                if (i29 % 4 == 0) {
                    qVar.f376093d = a.c(byteBuffer, i29 / 4);
                } else {
                    throw new IOException("Style data size is not multiple of 4 (" + i29 + ").");
                }
            }
            return qVar;
        }
        throw new IOException("String data size is not multiple of 4 (" + i28 + ").");
    }

    public int a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).intValue();
        }
        if (str == null) {
            return -1;
        }
        int i3 = 0;
        while (true) {
            String[] strArr = this.f376091b;
            if (i3 >= strArr.length) {
                return -1;
            }
            String str2 = strArr[i3];
            if (str2 == null) {
                str2 = b(i3);
            }
            if (str.equals(str2)) {
                return i3;
            }
            i3++;
        }
    }

    public String b(int i3) {
        int[] iArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (i3 >= 0 && (iArr = this.f376090a) != null && i3 < iArr.length) {
            String str = this.f376091b[i3];
            if (str == null) {
                int i16 = iArr[i3];
                this.f376095f.mark();
                a.d(this.f376095f, i16);
                if (this.f376094e == 0) {
                    int i17 = this.f376095f.getShort();
                    char[] cArr = new char[i17];
                    for (int i18 = 0; i18 < i17; i18++) {
                        cArr[i18] = this.f376095f.getChar();
                    }
                    str = new String(cArr);
                } else {
                    byte b16 = this.f376095f.get();
                    this.f376095f.get();
                    str = new String(a.a(this.f376095f, b16));
                }
                this.f376091b[i3] = str;
                this.f376095f.reset();
            }
            return str;
        }
        return null;
    }
}
