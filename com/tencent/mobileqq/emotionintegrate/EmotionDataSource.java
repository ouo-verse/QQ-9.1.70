package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class EmotionDataSource {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void m5();

        void sg(List<p> list, p pVar);
    }

    public EmotionDataSource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract int a();

    public abstract boolean b();

    public abstract List<p> c(boolean z16);

    public void d(a aVar, p pVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, aVar, pVar, Boolean.valueOf(z16));
        } else {
            ThreadManagerV2.excute(new Runnable(z16, aVar, pVar) { // from class: com.tencent.mobileqq.emotionintegrate.EmotionDataSource.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f205154d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ a f205155e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ p f205156f;

                {
                    this.f205154d = z16;
                    this.f205155e = aVar;
                    this.f205156f = pVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, EmotionDataSource.this, Boolean.valueOf(z16), aVar, pVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    List<p> c16 = EmotionDataSource.this.c(this.f205154d);
                    a aVar2 = this.f205155e;
                    if (aVar2 != null) {
                        aVar2.sg(c16, this.f205156f);
                    }
                }
            }, 64, null, true);
        }
    }

    public abstract void e();
}
