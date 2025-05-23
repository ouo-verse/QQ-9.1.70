package com.tencent.liteav.videoproducer2.capture;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.rtmp.video.BaseBridge;
import com.tencent.rtmp.video.VirtualDisplayListener;
import com.tencent.rtmp.video.VirtualDisplayManagerProxy;
import com.tencent.rtmp.video.VirtualDisplayWrapper;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class j {

    /* renamed from: d, reason: collision with root package name */
    private static BaseBridge.BaseBridgeCallback f119744d;

    /* renamed from: a, reason: collision with root package name */
    int f119745a;

    /* renamed from: b, reason: collision with root package name */
    int f119746b;

    /* renamed from: c, reason: collision with root package name */
    VirtualDisplayWrapper f119747c;

    /* renamed from: e, reason: collision with root package name */
    private Surface f119748e;

    /* renamed from: f, reason: collision with root package name */
    private MediaProjection f119749f;

    /* renamed from: g, reason: collision with root package name */
    private NativeScreenCaptureListener f119750g;

    /* renamed from: h, reason: collision with root package name */
    private VirtualDisplayListener f119751h = new VirtualDisplayListener() { // from class: com.tencent.liteav.videoproducer2.capture.j.1
        @Override // com.tencent.rtmp.video.VirtualDisplayListener
        public final void onCaptureError() {
            if (j.this.f119750g != null) {
                j.this.f119750g.onCaptureError();
            }
        }

        @Override // com.tencent.rtmp.video.VirtualDisplayListener
        public final void onStartFinish(boolean z16, boolean z17) {
            if (j.this.f119750g != null) {
                j.this.f119750g.onStartFinish(z16, z17);
            }
        }

        @Override // com.tencent.rtmp.video.VirtualDisplayListener
        public final void onVirtualDisplayCreate(VirtualDisplayWrapper virtualDisplayWrapper) {
            j.this.f119747c = virtualDisplayWrapper;
        }
    };

    static {
        a aVar = new a();
        f119744d = aVar;
        BaseBridge.setBaseBridgeCallback(aVar);
    }

    public j(Surface surface, int i3, int i16, MediaProjection mediaProjection, NativeScreenCaptureListener nativeScreenCaptureListener) {
        this.f119748e = surface;
        this.f119749f = mediaProjection;
        this.f119750g = nativeScreenCaptureListener;
        this.f119745a = i3;
        this.f119746b = i16;
    }

    public final void b() {
        VirtualDisplayWrapper virtualDisplayWrapper = this.f119747c;
        if (virtualDisplayWrapper != null) {
            virtualDisplayWrapper.release();
            this.f119747c = null;
        }
        VirtualDisplayManagerProxy.getInstance().stopVirtualDisplaySync(this.f119748e);
    }

    public final void a() {
        VirtualDisplayManagerProxy.getInstance().startVirtualDisplaySync(this.f119748e, this.f119745a, this.f119746b, this.f119749f, this.f119751h);
    }
}
