package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rx {

    /* renamed from: a, reason: collision with root package name */
    public long f150155a = SystemClock.elapsedRealtime();

    /* renamed from: b, reason: collision with root package name */
    public LatLngBounds f150156b;

    /* renamed from: c, reason: collision with root package name */
    public List<Detail> f150157c;

    public rx(LatLngBounds latLngBounds, List<Detail> list) {
        this.f150156b = latLngBounds;
        this.f150157c = list;
    }

    public final String toString() {
        return "EventData{updateTime=" + this.f150155a + ", mBound=" + this.f150156b + ", mEvents=" + this.f150157c + '}';
    }
}
