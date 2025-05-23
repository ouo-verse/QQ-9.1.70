package com.tencent.mobileqq.startup.step;

import com.tencent.image.SharpSoLoader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements SharpSoLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static c f289752e;

    /* renamed from: d, reason: collision with root package name */
    private boolean f289753d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements OnLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f289754a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ URLDrawableHandler f289755b;

        a(long j3, URLDrawableHandler uRLDrawableHandler) {
            this.f289754a = j3;
            this.f289755b = uRLDrawableHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, Long.valueOf(j3), uRLDrawableHandler);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
                return;
            }
            QLog.i("QQSharpPSoLoader", 2, "load sharp so resCode = " + i3 + " cost time " + (System.currentTimeMillis() - this.f289754a));
            if (i3 == 0) {
                c.this.f289753d = true;
                URLDrawableHandler uRLDrawableHandler = this.f289755b;
                if (uRLDrawableHandler != null) {
                    uRLDrawableHandler.onFileDownloadSucceed(0L);
                    return;
                }
                return;
            }
            URLDrawableHandler uRLDrawableHandler2 = this.f289755b;
            if (uRLDrawableHandler2 != null) {
                uRLDrawableHandler2.onFileDownloadFailed(i3);
            }
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f289753d = false;
        }
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (f289752e == null) {
                f289752e = new c();
            }
            cVar = f289752e;
        }
        return cVar;
    }

    @Override // com.tencent.image.SoLoader
    public boolean isLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f289753d;
    }

    @Override // com.tencent.image.SoLoader
    public void load(URLDrawableHandler uRLDrawableHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawableHandler);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (uRLDrawableHandler != null) {
            uRLDrawableHandler.onFileDownloadStarted();
        }
        com.tencent.qqsharpP.a.f(new a(currentTimeMillis, uRLDrawableHandler));
    }
}
