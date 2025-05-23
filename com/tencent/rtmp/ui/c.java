package com.tencent.rtmp.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
final /* synthetic */ class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final TXCloudVideoView f368812a;

    /* renamed from: b, reason: collision with root package name */
    private final int f368813b;

    /* renamed from: c, reason: collision with root package name */
    private final int f368814c;

    /* renamed from: d, reason: collision with root package name */
    private final int f368815d;

    /* renamed from: e, reason: collision with root package name */
    private final int f368816e;

    c(TXCloudVideoView tXCloudVideoView, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tXCloudVideoView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f368812a = tXCloudVideoView;
        this.f368813b = i3;
        this.f368814c = i16;
        this.f368815d = i17;
        this.f368816e = i18;
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView, int i3, int i16, int i17, int i18) {
        return new c(tXCloudVideoView, i3, i16, i17, i18);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f368812a.showFocusViewInternal(this.f368813b, this.f368814c, this.f368815d, this.f368816e);
    }
}
