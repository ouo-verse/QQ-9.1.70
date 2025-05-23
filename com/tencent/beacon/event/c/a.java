package com.tencent.beacon.event.c;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.open.BeaconEvent;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {
    @Nullable
    public static EventBean a(BeaconEvent beaconEvent) {
        Map<String, String> a16 = com.tencent.beacon.base.net.b.d.a(beaconEvent.getCode(), beaconEvent.getParams());
        if (a16 == null) {
            return null;
        }
        EventBean eventBean = new EventBean();
        String code = beaconEvent.getCode();
        eventBean.setEventCode(code);
        eventBean.setAppKey(beaconEvent.getAppKey());
        eventBean.setApn(com.tencent.beacon.a.c.e.l().r());
        eventBean.setSrcIp(com.tencent.beacon.a.c.c.c().a());
        eventBean.setEventCode(code);
        eventBean.setValueType(0);
        eventBean.setEventValue(a16);
        String str = beaconEvent.getParams().get("A34");
        if (!TextUtils.isEmpty(str)) {
            eventBean.setEventTime(Long.parseLong(str));
        }
        eventBean.setEventResult(beaconEvent.isSucceed());
        eventBean.setEventType(d.a(beaconEvent.getType()));
        eventBean.setReserved("");
        return eventBean;
    }
}
