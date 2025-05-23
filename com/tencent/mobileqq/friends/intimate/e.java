package com.tencent.mobileqq.friends.intimate;

import com.tencent.mobileqq.activity.aio.intimate.MainIntimateView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<MainIntimateView> f211784d;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f211784d = new WeakReference<>(null);
        }
    }

    public void a(MainIntimateView mainIntimateView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mainIntimateView);
        } else {
            this.f211784d = new WeakReference<>(mainIntimateView);
        }
    }
}
