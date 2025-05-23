package com.tencent.mobileqq.Doraemon.impl.webview;

import android.app.Activity;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tencent.mobileqq.Doraemon.manifest.a;
import com.tencent.mobileqq.miniapp.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends com.tencent.mobileqq.Doraemon.impl.a {
    static IPatchRedirector $redirector_;

    /* renamed from: u, reason: collision with root package name */
    protected String f154212u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f154213v;

    /* renamed from: w, reason: collision with root package name */
    public String f154214w;

    /* renamed from: x, reason: collision with root package name */
    public String f154215x;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.Doraemon.impl.webview.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C7082a implements DefaultDoraemonAppInfoHelper.g {
        static IPatchRedirector $redirector_;

        C7082a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.g
        public void a(d dVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ((com.tencent.mobileqq.Doraemon.impl.a) a.this).f154128q = dVar;
                a.this.r(i3);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, i3);
            }
        }
    }

    public a(Activity activity, int i3, String str, String str2) {
        super(activity, i3, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, Integer.valueOf(i3), str, str2);
        } else {
            this.f154212u = str2;
        }
    }

    public boolean G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f154075g == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.Doraemon.impl.a, com.tencent.mobileqq.Doraemon.DoraemonAPIManager
    protected Map<String, com.tencent.mobileqq.Doraemon.b> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.C7084a.b.a();
    }

    @Override // com.tencent.mobileqq.Doraemon.impl.a, com.tencent.mobileqq.Doraemon.DoraemonAPIManager
    protected void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            DefaultDoraemonAppInfoHelper.h().g(this.f154072d, this.f154070b, this.f154071c, this.f154212u, new C7082a());
        }
    }
}
