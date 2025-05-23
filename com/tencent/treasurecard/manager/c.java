package com.tencent.treasurecard.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.treasurecard.FtConstants;
import com.tencent.mobileqq.vaswebviewplugin.TreasureCardJsPlugin;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public to4.b f381206a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements to4.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.treasurecard.manager.d f381207a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ to4.a f381208b;

        a(com.tencent.treasurecard.manager.d dVar, to4.a aVar) {
            this.f381207a = dVar;
            this.f381208b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, dVar, aVar);
            }
        }

        @Override // to4.a
        public void a(int i3, Object obj) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, obj);
                return;
            }
            if (i3 == 0 && (obj instanceof Integer)) {
                i16 = ((Integer) obj).intValue();
                this.f381207a.h().c(i16);
            } else {
                i16 = -1;
            }
            c.this.d(this.f381207a, this.f381208b, i3, i16);
            com.tencent.treasurecard.report.a.a().f(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            com.tencent.treasurecard.report.a.a().g(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, i16);
            String string = com.tencent.treasurecard.util.d.c().e().getString(FtConstants.TC_ACTIVE_URL + com.tencent.treasurecard.util.a.f381233a, "");
            if (!TextUtils.isEmpty(com.tencent.treasurecard.report.a.a().f381231f) && !TextUtils.isEmpty(string)) {
                string = string + "&from=$from";
            }
            com.tencent.treasurecard.report.a.a().f("B");
            com.tencent.treasurecard.report.a.a().e("B", string);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements to4.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ to4.a f381210a;

        b(to4.a aVar) {
            this.f381210a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) aVar);
            }
        }

        @Override // to4.a
        public void a(int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, obj);
            } else {
                this.f381210a.a(i3, obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.treasurecard.manager.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C10022c implements to4.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ to4.a f381212a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.treasurecard.manager.d f381213b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ to4.a f381214c;

        C10022c(to4.a aVar, com.tencent.treasurecard.manager.d dVar, to4.a aVar2) {
            this.f381212a = aVar;
            this.f381213b = dVar;
            this.f381214c = aVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, aVar, dVar, aVar2);
            }
        }

        @Override // to4.a
        public void a(int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, obj);
                return;
            }
            if (i3 != 0) {
                this.f381212a.a(i3, "pcIdRequest is failed");
            } else {
                if (!(obj instanceof String)) {
                    this.f381212a.a(i3, "pcId is error");
                    return;
                }
                String str = (String) obj;
                this.f381213b.h().d(str);
                c.this.f381206a.a(str, this.f381214c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements to4.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ to4.a f381216a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ to4.a f381217b;

        d(to4.a aVar, to4.a aVar2) {
            this.f381216a = aVar;
            this.f381217b = aVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, aVar, aVar2);
            }
        }

        @Override // to4.a
        public void a(int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, obj);
                return;
            }
            if (i3 != 0) {
                this.f381216a.a(i3, "signRequest is failed");
            } else if (!(obj instanceof String)) {
                this.f381216a.a(i3, "url is error");
            } else {
                c.this.f381206a.d((String) obj, this.f381217b);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean b(String str) {
        if (this.f381206a == null) {
            Log.e("TcSdkManager", str + " mRequestImpl is null");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.tencent.treasurecard.manager.d dVar, to4.a aVar, int i3, int i16) {
        dVar.f(i3, i16);
        if (aVar != null) {
            aVar.a(i3, Integer.valueOf(i16));
        }
        dVar.j().h();
    }

    private boolean f() {
        if (com.tencent.treasurecard.util.a.b() == 1) {
            return true;
        }
        return false;
    }

    private boolean g(Context context) {
        return com.tencent.treasurecard.util.a.c(context);
    }

    private void j(to4.a aVar) {
        com.tencent.treasurecard.manager.d dVar = (com.tencent.treasurecard.manager.d) com.tencent.treasurecard.manager.d.i();
        b bVar = new b(aVar);
        d dVar2 = new d(aVar, new C10022c(aVar, dVar, bVar));
        String b16 = dVar.h().b();
        if (!TextUtils.isEmpty(b16)) {
            this.f381206a.a(b16, bVar);
        } else {
            this.f381206a.e(dVar2);
        }
    }

    public boolean c(Context context) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context)).booleanValue();
        }
        so4.b i3 = com.tencent.treasurecard.manager.d.i();
        i3.b();
        com.tencent.treasurecard.util.d.c().a(context);
        if (!g(context) && f()) {
            i3.c(null);
            z16 = true;
        } else {
            z16 = false;
        }
        Log.d(TreasureCardJsPlugin.BUSINESS_NAME, "clearCacheAndRequest " + z16);
        return z16;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!b("isLimitReq") && !this.f381206a.c()) {
            return false;
        }
        return true;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (b("queryActiveInfo")) {
                return;
            }
            this.f381206a.f();
        }
    }

    public void i(to4.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        if (b("queryCardInfo")) {
            return;
        }
        com.tencent.treasurecard.manager.d dVar = (com.tencent.treasurecard.manager.d) com.tencent.treasurecard.manager.d.i();
        if (!this.f381206a.b()) {
            d(dVar, aVar, 1002, 0);
            Log.e("TcSdkManager", "not mobile operator On Request");
        } else if (e()) {
            d(dVar, aVar, 0, dVar.h().a().f381151a);
        } else {
            j(new a(dVar, aVar));
        }
    }

    public void k(to4.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f381206a = bVar;
        }
    }
}
