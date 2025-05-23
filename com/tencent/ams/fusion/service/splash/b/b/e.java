package com.tencent.ams.fusion.service.splash.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.tencent.ams.fusion.service.splash.b.b.a.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import nt.g;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e implements kt.b<nt.f, g> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private nt.f f70387a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.ams.fusion.service.splash.data.a f70388b;

    /* renamed from: c, reason: collision with root package name */
    private long f70389c;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private b.f a(int i3) {
        int i16;
        b.f fVar = new b.f();
        fVar.d(false);
        fVar.a(i3);
        fVar.b(System.currentTimeMillis() - this.f70389c);
        if (i3 == 2) {
            i16 = 422;
        } else {
            i16 = 421;
        }
        g(i16, i3, this.f70389c);
        return fVar;
    }

    private void g(int i3, long j3, long j16) {
        nt.d.b(this.f70387a, i3, j3, System.currentTimeMillis() - j16, Integer.MIN_VALUE);
    }

    @Override // kt.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "PreloadSaveRawDataTask";
    }

    @Override // kt.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public g c() {
        nt.f fVar;
        StringBuilder sb5;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (g) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f70389c = currentTimeMillis;
        g(420, 0L, currentTimeMillis);
        Context f16 = com.tencent.ams.fusion.service.b.b().f();
        if (f16 != null && this.f70388b != null && (fVar = this.f70387a) != null) {
            String b16 = fVar.b();
            boolean a16 = this.f70387a.a();
            if (a16) {
                sb5 = new StringBuilder();
                sb5.append(b16);
                str = "key_preload_request_hot";
            } else {
                sb5 = new StringBuilder();
                sb5.append(b16);
                str = "key_preload_request_cold";
            }
            sb5.append(str);
            Object a17 = this.f70388b.a(sb5.toString());
            if (a17 == null) {
                return a(8);
            }
            if (TextUtils.isEmpty(this.f70387a.b())) {
                return a(16);
            }
            if (a16) {
                str2 = "hot";
            } else {
                str2 = TGSplashFileUtil.PRELOAD_CACHE_DIR_COLD;
            }
            StringBuilder sb6 = new StringBuilder(this.f70387a.b());
            String str3 = File.separator;
            sb6.append(str3);
            sb6.append(str2);
            sb6.append(str3);
            sb6.append("preload");
            boolean q16 = com.tencent.ams.fusion.a.b.q(new File(f16.getDir(TGSplashFileUtil.ADNET, 0), sb6.toString()), a17);
            com.tencent.ams.fusion.a.f.j("PreloadSaveRawDataTask", " writeObj2FileWithLock :" + q16);
            if (!q16) {
                i3 = 4;
            }
            return a(i3);
        }
        return a(1);
    }

    public void h(com.tencent.ams.fusion.service.splash.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.f70388b = aVar;
        }
    }

    public void i(nt.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
        } else {
            this.f70387a = fVar;
        }
    }
}
