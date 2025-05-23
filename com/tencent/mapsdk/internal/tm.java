package com.tencent.mapsdk.internal;

import android.os.Handler;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tm implements bc {

    /* renamed from: a, reason: collision with root package name */
    private final tr f150993a;

    public tm(tr trVar) {
        this.f150993a = trVar;
    }

    @Override // com.tencent.mapsdk.internal.bc
    public final void a(v vVar) {
        tr trVar = this.f150993a;
        if (trVar == null) {
            return;
        }
        if (vVar != null) {
            trVar.a(((VectorMap) trVar.e_).f151351o.f149410w.a());
        }
        tr trVar2 = this.f150993a;
        Handler handler = trVar2.f151068y;
        if (handler != null && handler.getLooper().getThread().isAlive()) {
            CameraPosition a16 = trVar2.a();
            CameraPosition cameraPosition = trVar2.f151069z;
            if (cameraPosition == null || !cameraPosition.equals(a16)) {
                trVar2.f151068y.sendEmptyMessage(0);
                trVar2.f151069z = a16;
            }
        }
    }
}
