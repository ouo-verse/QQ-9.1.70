package com.tencent.qimei.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.b.d;
import com.tencent.qimei.c.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements com.tencent.qimei.a.b, a.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.qimei.a.a f343219a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.qimei.c.a f343220b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f343221c;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.qimei.c.a aVar = c.this.f343220b;
            if (aVar != null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
                aVar.f343214e = aVar.f343210a.bindService(intent, aVar.f343212c, 1);
                if (!aVar.f343214e && (bVar = aVar.f343211b) != null) {
                    ((c) bVar).b();
                }
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f343221c = new a();
        }
    }

    @Override // com.tencent.qimei.a.b
    public void a(Context context, com.tencent.qimei.a.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f343219a = aVar;
            this.f343220b = new com.tencent.qimei.c.a(context, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        if (r2 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.qimei.a.a aVar = this.f343219a;
        if (aVar != null) {
            boolean a16 = a();
            String str2 = null;
            String str3 = "";
            if (a()) {
                com.tencent.qimei.c.a aVar2 = this.f343220b;
                Context context = aVar2.f343210a;
                if (context != null) {
                    String packageName = context.getPackageName();
                    if (!TextUtils.isEmpty(packageName)) {
                        try {
                            b bVar = aVar2.f343213d;
                            if (bVar != null) {
                                str = bVar.a(packageName);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    str = null;
                } else {
                    throw new IllegalArgumentException("Context is null, must be new SxCore first");
                }
            }
            str = "";
            if (a()) {
                com.tencent.qimei.c.a aVar3 = this.f343220b;
                Context context2 = aVar3.f343210a;
                if (context2 != null) {
                    String packageName2 = context2.getPackageName();
                    if (!TextUtils.isEmpty(packageName2)) {
                        try {
                            b bVar2 = aVar3.f343213d;
                            if (bVar2 != null) {
                                str2 = bVar2.b(packageName2);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                    if (str2 != null) {
                        str3 = str2;
                    }
                } else {
                    throw new IllegalArgumentException("Context is null, must be new SxCore first");
                }
            }
            aVar.callbackOaid(a16, str, str3, false);
        }
    }

    @Override // com.tencent.qimei.a.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qimei.a.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            d.f343207e.a(this.f343221c);
        }
    }

    @Override // com.tencent.qimei.a.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.qimei.c.a aVar = this.f343220b;
        if (aVar != null && aVar.f343210a != null && aVar.f343214e) {
            try {
                aVar.f343210a.unbindService(aVar.f343212c);
            } catch (Exception unused) {
            } catch (Throwable th5) {
                aVar.f343214e = false;
                aVar.f343213d = null;
                throw th5;
            }
            aVar.f343214e = false;
            aVar.f343213d = null;
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        com.tencent.qimei.c.a aVar = this.f343220b;
        return (aVar == null || aVar.f343213d == null) ? false : true;
    }
}
