package com.tencent.liteav.trtc;

import com.tencent.trtc.TRTCCloudDef;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final TrtcCloudJni f119197a;

    /* renamed from: b, reason: collision with root package name */
    private final TRTCCloudDef.TRTCScreenShareParams f119198b;

    b(TrtcCloudJni trtcCloudJni, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.f119197a = trtcCloudJni;
        this.f119198b = tRTCScreenShareParams;
    }

    public static Runnable a(TrtcCloudJni trtcCloudJni, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        return new b(trtcCloudJni, tRTCScreenShareParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119197a.showFloatingWindow(this.f119198b.floatingView);
    }
}
