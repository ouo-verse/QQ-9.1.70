package com.tencent.rtmp.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class a implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final TXCloudVideoView f368806a;

    a(TXCloudVideoView tXCloudVideoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tXCloudVideoView);
        } else {
            this.f368806a = tXCloudVideoView;
        }
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView) {
        return new a(tXCloudVideoView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f368806a.hideIndicatorView();
    }
}
