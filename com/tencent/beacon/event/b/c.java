package com.tencent.beacon.event.b;

import android.support.annotation.Nullable;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.open.BeaconEvent;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private c f77900a;

    abstract BeaconEvent a(BeaconEvent beaconEvent);

    public void a(c cVar) {
        this.f77900a = cVar;
    }

    @Nullable
    public final EventBean b(BeaconEvent beaconEvent) {
        BeaconEvent a16 = a(beaconEvent);
        c cVar = this.f77900a;
        if (cVar != null) {
            return cVar.b(a16);
        }
        return com.tencent.beacon.event.c.a.a(a16);
    }
}
