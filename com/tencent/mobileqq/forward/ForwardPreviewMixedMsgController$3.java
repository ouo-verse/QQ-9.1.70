package com.tencent.mobileqq.forward;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
class ForwardPreviewMixedMsgController$3 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ImageView f210751d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ URLDrawable f210752e;
    final /* synthetic */ n this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f210751d.setImageDrawable(this.f210752e);
            this.this$0.n();
        }
    }
}
