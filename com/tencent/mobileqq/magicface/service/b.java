package com.tencent.mobileqq.magicface.service;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder;
import com.tencent.mobileqq.magicface.model.c;
import com.tencent.mobileqq.magicface.model.d;
import com.tencent.mobileqq.magicface.model.e;
import com.tencent.mobileqq.magicface.model.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private f f243509a;

    /* renamed from: b, reason: collision with root package name */
    private MagicfaceDecoder f243510b;

    /* renamed from: c, reason: collision with root package name */
    private MagicfaceDecoder.b f243511c;

    /* renamed from: d, reason: collision with root package name */
    private SoundPoolUtil f243512d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f243513e;

    /* renamed from: f, reason: collision with root package name */
    private c f243514f;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f243513e = ar.b("anzaihuang", "2024-05-09", "vas_qzone_full_screen_switch").isEnable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f243510b.d();
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicfacePlayManager", 2, "func init begins, magicfaceDecoder:" + this.f243510b);
        }
        try {
            if (this.f243510b == null) {
                boolean r06 = ah.r0();
                long min = Math.min(ah.x(), ah.w());
                if (r06 && min >= 720) {
                    this.f243510b = new MagicFaceSuperBigDecoder();
                    if (QLog.isColorLevel()) {
                        QLog.d("MagicfacePlayManager", 2, "func init, use [SuperBigDecoder]");
                    }
                } else if ("xbig".equalsIgnoreCase(f.d())) {
                    this.f243510b = new MagicfaceXBigDecoder();
                    if (QLog.isColorLevel()) {
                        QLog.d("MagicfacePlayManager", 2, "func init, use [XBigDecoder]");
                    }
                } else {
                    this.f243510b = new d();
                    if (QLog.isColorLevel()) {
                        QLog.d("MagicfacePlayManager", 2, "func init, use [FFMepgDecoder]");
                    }
                }
            }
            this.f243510b.h(this.f243511c);
            if (QLog.isColorLevel()) {
                QLog.d("MagicfacePlayManager", 2, "func init ends.");
            }
        } catch (Throwable th5) {
            QLog.e("MagicfacePlayManager", 1, "create MagicFaceSuperBigDecoder error" + th5);
        }
    }

    public void d(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) eVar);
            return;
        }
        c cVar = this.f243514f;
        if (cVar == null || !eVar.f243457c.equalsIgnoreCase(cVar.f243435a)) {
            c g16 = this.f243509a.g(eVar.f243457c, eVar.f243458d);
            this.f243514f = g16;
            g16.f243435a = eVar.f243457c;
            g16.f243436b = eVar.f243458d;
        }
        this.f243510b.g(this.f243514f);
        this.f243510b.i();
    }

    public void e(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
            return;
        }
        SoundPoolUtil soundPoolUtil = this.f243512d;
        if (soundPoolUtil != null) {
            soundPoolUtil.a(this.f243509a.c(str), i3, 3);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        MagicfaceDecoder magicfaceDecoder = this.f243510b;
        if (magicfaceDecoder != null) {
            if (this.f243513e) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.magicface.service.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.c();
                    }
                }, 16, null, false);
            } else {
                magicfaceDecoder.d();
            }
        }
    }

    public void g(SoundPoolUtil soundPoolUtil) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) soundPoolUtil);
        } else {
            this.f243512d = soundPoolUtil;
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        MagicfaceDecoder magicfaceDecoder = this.f243510b;
        if (magicfaceDecoder != null) {
            magicfaceDecoder.e(i3);
        }
    }

    public void i(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
        } else {
            this.f243509a = fVar;
        }
    }

    public void j(MagicfaceDecoder.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
            return;
        }
        MagicfaceDecoder magicfaceDecoder = this.f243510b;
        if (magicfaceDecoder != null) {
            magicfaceDecoder.f(aVar);
        }
    }

    public void k(MagicfaceDecoder.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
        } else {
            this.f243511c = bVar;
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        MagicfaceDecoder magicfaceDecoder = this.f243510b;
        if (magicfaceDecoder != null) {
            magicfaceDecoder.j();
        }
    }

    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        SoundPoolUtil soundPoolUtil = this.f243512d;
        if (soundPoolUtil != null) {
            soundPoolUtil.d(this.f243509a.c(str));
        }
    }
}
