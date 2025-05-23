package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tj extends Handler {

    /* renamed from: a, reason: collision with root package name */
    static final int f150497a = 0;

    /* renamed from: b, reason: collision with root package name */
    static final int f150498b = 1;

    /* renamed from: c, reason: collision with root package name */
    static final int f150499c = 2;

    /* renamed from: d, reason: collision with root package name */
    private final tr f150500d;

    public tj(tr trVar, Looper looper) {
        super(looper);
        this.f150500d = trVar;
        lc.a(lb.X, trVar.f147934f);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        M m3;
        CameraPosition a16;
        super.handleMessage(message);
        tr trVar = this.f150500d;
        if (trVar == null || (m3 = trVar.e_) == 0 || !((VectorMap) m3).a() || (a16 = trVar.a()) == null) {
            return;
        }
        if (message.what == 2) {
            trVar.al();
            lc.c(lb.X, trVar.f147934f);
        }
        int i3 = message.what;
        if (i3 == 0) {
            trVar.onCameraChange(a16);
        } else if (i3 == 1) {
            trVar.f151128az = true;
            TencentMapGestureListenerList tencentMapGestureListenerList = trVar.f151123au;
            if (tencentMapGestureListenerList != null && trVar.f151124av) {
                tencentMapGestureListenerList.onMapStable();
            }
            trVar.onCameraChangeFinished(a16);
        }
        trVar.af();
    }
}
