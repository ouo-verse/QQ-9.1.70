package com.tencent.mobileqq.adapter;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
class BaseWhatASmoothAdapter$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ View f187005d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f187006e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f187007f;
    final /* synthetic */ d this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            d.a(null, this.f187005d, this.f187006e, this.f187007f, null);
        }
    }
}
