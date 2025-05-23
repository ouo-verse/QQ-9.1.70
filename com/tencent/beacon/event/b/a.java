package com.tencent.beacon.event.b;

import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.EventType;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends c {
    @Override // com.tencent.beacon.event.b.c
    protected BeaconEvent a(BeaconEvent beaconEvent) {
        EventType type = beaconEvent.getType();
        if (type == EventType.DT_REALTIME || type == EventType.DT_NORMAL) {
            Map<String, String> params = beaconEvent.getParams();
            e l3 = e.l();
            f e16 = f.e();
            params.put("dt_imei2", "" + e16.c());
            params.put("dt_meid", "" + e16.g());
            params.put("dt_mf", "" + l3.o());
            beaconEvent.setParams(params);
        }
        return beaconEvent;
    }
}
