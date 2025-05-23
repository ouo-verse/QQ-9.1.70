package com.tencent.map.lib.models;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ky;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;

/* compiled from: P */
/* loaded from: classes9.dex */
public class OverlayListenerInfo {
    private VectorOverlay.OnVectorOverlayLoadListener innerListener = new VectorOverlay.OnVectorOverlayLoadListener() { // from class: com.tencent.map.lib.models.OverlayListenerInfo.1
        @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay.OnVectorOverlayLoadListener
        public final void onVectorOverlayLoaded(final boolean z16) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.map.lib.models.OverlayListenerInfo.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    VectorOverlay.OnVectorOverlayLoadListener onVectorOverlayLoadListener = OverlayListenerInfo.this.outterVectorOverlayLoadListener;
                    if (onVectorOverlayLoadListener != null) {
                        onVectorOverlayLoadListener.onVectorOverlayLoaded(z16);
                        LogUtil.b(ky.f149119y, "TMS vetorOverlay loaded status: " + z16);
                    }
                }
            });
        }
    };
    protected VectorOverlay.OnVectorOverlayClickListener outterVectorOverlayClickListener;
    protected VectorOverlay.OnVectorOverlayLoadListener outterVectorOverlayLoadListener;

    public VectorOverlay.OnVectorOverlayClickListener getOutterVectorOverlayClickListener() {
        return this.outterVectorOverlayClickListener;
    }

    public void setOutterVectorOverlayClickListener(VectorOverlay.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        this.outterVectorOverlayClickListener = onVectorOverlayClickListener;
    }

    public void setOutterVectorOverlayLoadListener(VectorOverlay.OnVectorOverlayLoadListener onVectorOverlayLoadListener) {
        this.outterVectorOverlayLoadListener = onVectorOverlayLoadListener;
    }
}
