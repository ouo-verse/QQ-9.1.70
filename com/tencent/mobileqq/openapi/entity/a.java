package com.tencent.mobileqq.openapi.entity;

import com.tencent.mobileqq.openapi.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f256912a;

    /* renamed from: b, reason: collision with root package name */
    public String f256913b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f256914c;

    /* renamed from: d, reason: collision with root package name */
    public long f256915d;

    /* renamed from: e, reason: collision with root package name */
    public long f256916e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f256917f;

    /* renamed from: g, reason: collision with root package name */
    public int f256918g;

    /* renamed from: h, reason: collision with root package name */
    private int f256919h;

    /* renamed from: i, reason: collision with root package name */
    private int f256920i;

    /* renamed from: j, reason: collision with root package name */
    private int f256921j;

    /* renamed from: k, reason: collision with root package name */
    private int f256922k;

    /* renamed from: l, reason: collision with root package name */
    private Cryptor f256923l;

    /* renamed from: m, reason: collision with root package name */
    public String f256924m;

    public a(a.C8192a c8192a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c8192a);
            return;
        }
        this.f256916e = 0L;
        this.f256912a = c8192a.f256900a;
        this.f256913b = c8192a.f256902c;
        this.f256918g = c8192a.f256904e;
        this.f256921j = c8192a.f256905f;
        this.f256922k = c8192a.f256906g;
        if (c8192a.f256909j) {
            this.f256915d = c8192a.f256911l;
            this.f256914c = a(c8192a.f256910k);
            this.f256916e = c8192a.f256908i;
            this.f256917f = a(c8192a.f256907h);
            return;
        }
        this.f256915d = c8192a.f256908i;
        this.f256914c = a(c8192a.f256907h);
    }

    private byte[] a(long j3) {
        byte[] bArr;
        String str = this.f256912a;
        while (str.length() < 16) {
            str = str + str;
        }
        byte[] bytes = str.getBytes();
        byte[] bytes2 = String.valueOf(j3).getBytes();
        if (bytes.length > bytes2.length) {
            bArr = bytes;
        } else {
            bArr = bytes2;
        }
        for (int i3 = 0; i3 < Math.min(bytes.length, bytes2.length); i3++) {
            bArr[i3] = (byte) (bytes[i3] ^ bytes2[i3]);
        }
        if (this.f256923l == null) {
            Cryptor cryptor = new Cryptor();
            this.f256923l = cryptor;
            cryptor.enableResultRandom(false);
        }
        return bArr;
    }

    public String b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        try {
            return new String(this.f256923l.decrypt(HexUtil.hexStr2Bytes(str), this.f256914c));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("OpenApi.App", 2, "decrypt", e16);
            }
            return null;
        }
    }

    public String c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        try {
            return new String(this.f256923l.decrypt(HexUtil.hexStr2Bytes(str), this.f256917f));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("OpenApi.App", 2, "decryptLastData", e16);
            }
            return null;
        }
    }

    public String d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        try {
            return HexUtil.bytes2HexStr(this.f256923l.encrypt(str.getBytes(), this.f256914c));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("OpenApi.App", 2, "encrypt", e16);
            }
            return null;
        }
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f256919h;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f256920i;
    }

    public boolean g(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if ((i3 & this.f256920i) > 0 && (this.f256919h & i16) > 0) {
            return true;
        }
        return false;
    }

    public boolean h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        if ((i3 & this.f256920i) > 0 && (this.f256919h & 1073741824) > 0) {
            return true;
        }
        return false;
    }

    public boolean i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if ((i3 & this.f256918g) > 0) {
            return true;
        }
        return false;
    }

    public boolean j(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if ((i3 & this.f256922k) > 0 && (this.f256921j & i16) > 0) {
            return true;
        }
        return false;
    }

    public boolean k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        if ((i3 & this.f256922k) > 0) {
            return true;
        }
        return false;
    }

    public void l(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f256919h = i3 & this.f256921j;
            this.f256920i = this.f256922k & i16;
        }
    }
}
