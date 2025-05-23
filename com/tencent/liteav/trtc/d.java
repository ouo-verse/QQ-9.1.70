package com.tencent.liteav.trtc;

import android.graphics.Bitmap;
import com.tencent.trtc.TRTCCloudListener;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final TRTCCloudListener.TRTCSnapshotListener f119200a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f119201b;

    d(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        this.f119200a = tRTCSnapshotListener;
        this.f119201b = bitmap;
    }

    public static Runnable a(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        return new d(tRTCSnapshotListener, bitmap);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrtcCloudJni.lambda$onSnapshotComplete$2(this.f119200a, this.f119201b);
    }
}
