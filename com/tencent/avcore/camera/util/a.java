package com.tencent.avcore.camera.util;

import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f77469c;

    /* renamed from: d, reason: collision with root package name */
    static int f77470d;

    /* renamed from: a, reason: collision with root package name */
    private C0781a[] f77471a;

    /* renamed from: b, reason: collision with root package name */
    private Object f77472b;

    /* compiled from: P */
    /* renamed from: com.tencent.avcore.camera.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0781a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public byte[] f77473a;

        /* renamed from: b, reason: collision with root package name */
        public int f77474b;

        public C0781a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            } else {
                this.f77473a = null;
                this.f77474b = 0;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13451);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f77470d = 0;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f77471a = new C0781a[4];
            this.f77472b = new Object();
        }
    }

    public static a d() {
        if (f77469c == null) {
            synchronized (a.class) {
                if (f77469c == null) {
                    f77469c = new a();
                }
            }
        }
        return f77469c;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AVCoreLog.printAllUserLog("FrameBufMgr", "clear.");
        synchronized (this.f77472b) {
            int i3 = 0;
            while (true) {
                C0781a[] c0781aArr = this.f77471a;
                if (i3 < c0781aArr.length) {
                    C0781a c0781a = c0781aArr[i3];
                    if (c0781a != null) {
                        c0781a.f77473a = null;
                        c0781a.f77474b = 0;
                    }
                    i3++;
                }
            }
        }
    }

    public byte[] b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        synchronized (this.f77472b) {
            int i16 = 0;
            while (true) {
                C0781a[] c0781aArr = this.f77471a;
                if (i16 < c0781aArr.length) {
                    C0781a c0781a = c0781aArr[i16];
                    if (c0781a.f77474b == i3) {
                        return c0781a.f77473a;
                    }
                    i16++;
                } else {
                    AVCoreLog.printAllUserLog("FrameBufMgr", "getFrameBufByState failed. state = " + i3);
                    return null;
                }
            }
        }
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f77471a.length;
    }

    public boolean e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        AVCoreLog.printAllUserLog("FrameBufMgr", "init. bufSize = " + i3);
        synchronized (this.f77472b) {
            int i16 = 0;
            while (true) {
                C0781a[] c0781aArr = this.f77471a;
                if (i16 < c0781aArr.length) {
                    if (c0781aArr[i16] == null) {
                        c0781aArr[i16] = new C0781a();
                    }
                    C0781a c0781a = this.f77471a[i16];
                    byte[] bArr = c0781a.f77473a;
                    if (bArr == null || bArr.length != i3) {
                        c0781a.f77473a = new byte[i3];
                    }
                    c0781a.f77474b = 0;
                    i16++;
                }
            }
        }
        return true;
    }

    public void f(int i3, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        synchronized (this.f77472b) {
            z16 = false;
            while (true) {
                C0781a[] c0781aArr = this.f77471a;
                if (i17 >= c0781aArr.length) {
                    break;
                }
                C0781a c0781a = c0781aArr[i17];
                if (c0781a.f77474b == i3) {
                    c0781a.f77474b = i16;
                    z16 = true;
                }
                i17++;
            }
        }
        if (!z16) {
            AVCoreLog.printAllUserLog("FrameBufMgr", "setFrameBufState failed. oldState = " + i3 + ", newState = " + i16);
        }
    }

    public void g(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr, i3);
            return;
        }
        synchronized (this.f77472b) {
            int i16 = 0;
            while (true) {
                C0781a[] c0781aArr = this.f77471a;
                if (i16 < c0781aArr.length) {
                    C0781a c0781a = c0781aArr[i16];
                    if (c0781a.f77473a == bArr) {
                        c0781a.f77474b = i3;
                        return;
                    }
                    i16++;
                } else {
                    AVCoreLog.printAllUserLog("FrameBufMgr", "setFrameBufState failed. dataBuf = " + bArr + ", state = " + i3);
                    return;
                }
            }
        }
    }
}
