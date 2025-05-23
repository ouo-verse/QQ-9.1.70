package com.tencent.turingcam;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class G2SZT implements sWkeo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public sWkeo f381829a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ShGzN {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final G2SZT f381830a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15948);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f381830a = new G2SZT(null);
            }
        }
    }

    public /* synthetic */ G2SZT(spXPg spxpg) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) spxpg);
    }

    public static G2SZT b() {
        return ShGzN.f381830a;
    }

    @Override // com.tencent.turingcam.sWkeo
    public void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f381829a.a(context);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }

    G2SZT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f381829a = new d9yDk();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.turingcam.sWkeo
    public void a(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f381829a.a(str, str2, str3);
        } else {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3);
        }
    }

    @Override // com.tencent.turingcam.sWkeo
    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f381829a.a(str, j3);
        } else {
            iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3));
        }
    }

    @Override // com.tencent.turingcam.sWkeo
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f381829a.a();
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
