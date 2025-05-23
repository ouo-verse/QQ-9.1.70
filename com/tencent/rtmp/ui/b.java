package com.tencent.rtmp.ui;

import android.graphics.Color;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
final /* synthetic */ class b implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final TXCloudVideoView f368807a;

    /* renamed from: b, reason: collision with root package name */
    private final int f368808b;

    /* renamed from: c, reason: collision with root package name */
    private final int f368809c;

    /* renamed from: d, reason: collision with root package name */
    private final int f368810d;

    /* renamed from: e, reason: collision with root package name */
    private final int f368811e;

    b(TXCloudVideoView tXCloudVideoView, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tXCloudVideoView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f368807a = tXCloudVideoView;
        this.f368808b = i3;
        this.f368809c = i16;
        this.f368810d = i17;
        this.f368811e = i18;
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView, int i3, int i16, int i17, int i18) {
        return new b(tXCloudVideoView, i3, i16, i17, i18);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f368807a.setBackgroundColor(Color.argb(this.f368808b, this.f368809c, this.f368810d, this.f368811e));
    }
}
