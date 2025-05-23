package com.tencent.beacon.event;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.event.immediate.Beacon2MsfTransferArgs;
import com.tencent.beacon.event.immediate.Beacon2WnsTransferArgs;
import com.tencent.beacon.event.immediate.BeaconTransferArgs;
import com.tencent.beacon.event.open.EventResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d implements h, com.tencent.beacon.a.a.d {

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.beacon.event.a.a f77942b;

    /* renamed from: c, reason: collision with root package name */
    private final g f77943c;

    /* renamed from: d, reason: collision with root package name */
    private final g f77944d;

    /* renamed from: e, reason: collision with root package name */
    private long f77945e = 2000;

    /* renamed from: f, reason: collision with root package name */
    private long f77946f = 5000;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f77941a = com.tencent.beacon.a.b.a.a().a(3000);

    public d() {
        com.tencent.beacon.event.a.a a16 = com.tencent.beacon.event.a.a.a();
        this.f77942b = a16;
        this.f77943c = new g(2000, a16, true);
        this.f77944d = new g(1000, a16, false);
        com.tencent.beacon.a.a.b.a().a(11, this);
        com.tencent.beacon.a.a.b.a().a(2, this);
    }

    @Override // com.tencent.beacon.event.h
    public EventResult b(@Nullable String str, @NonNull EventBean eventBean) {
        boolean a16 = a(new a(this, eventBean));
        com.tencent.beacon.base.util.c.a("[EventModule]", 1, "event: %s. go in EventManager(%s). offer: %s", eventBean.getEventCode(), eventBean.getAppKey(), Boolean.valueOf(a16));
        if (a16) {
            if (TextUtils.isEmpty(str)) {
                str = "-1";
            }
            return EventResult.a.a(Long.parseLong(str));
        }
        return EventResult.a.a(103);
    }

    @Override // com.tencent.beacon.event.h
    public void c() {
        com.tencent.beacon.a.b.a.a().a(2000, false);
        com.tencent.beacon.a.b.a.a().a(1000, false);
    }

    @Override // com.tencent.beacon.event.h
    public EventResult a(String str, @NonNull EventBean eventBean) {
        com.tencent.beacon.base.util.c.a("[EventManager]", "eventName is %s, logID is %s", eventBean.getEventCode(), str);
        com.tencent.beacon.a.b.a.a().a(new b(this, eventBean, str));
        if (TextUtils.isEmpty(str)) {
            str = "-1";
        }
        return EventResult.a.a(Long.parseLong(str));
    }

    public void a(EventBean eventBean, String str) {
        Map<String, String> eventValue = eventBean.getEventValue();
        eventValue.put("A156", "N");
        eventBean.setEventValue(eventValue);
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventBean);
        com.tencent.beacon.base.net.c.c().b(com.tencent.beacon.event.c.d.a((List<EventBean>) arrayList, true)).a(new c(this, eventBean, str), com.tencent.beacon.a.b.a.b());
    }

    @Override // com.tencent.beacon.event.h
    public void b() {
        com.tencent.beacon.a.b.a.a().b(2000);
        com.tencent.beacon.a.b.a.a().b(1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BeaconTransferArgs a(byte[] bArr, EventBean eventBean) {
        if (eventBean.getEventType() == 3) {
            return new Beacon2MsfTransferArgs(bArr);
        }
        Beacon2WnsTransferArgs beacon2WnsTransferArgs = new Beacon2WnsTransferArgs(bArr);
        beacon2WnsTransferArgs.setAppkey(eventBean.getAppKey());
        beacon2WnsTransferArgs.setEventCode(eventBean.getEventCode());
        return beacon2WnsTransferArgs;
    }

    @Override // com.tencent.beacon.event.h
    public void a(boolean z16) {
        if (z16) {
            this.f77944d.run();
            this.f77943c.run();
        } else {
            com.tencent.beacon.a.b.a.a().a(this.f77944d);
            com.tencent.beacon.a.b.a.a().a(this.f77943c);
        }
    }

    @Override // com.tencent.beacon.event.h
    public void a() {
        com.tencent.beacon.a.b.a.a().a(2000, 0L, this.f77945e, this.f77943c);
        com.tencent.beacon.a.b.a.a().a(1000, 0L, this.f77946f, this.f77944d);
    }

    @Override // com.tencent.beacon.event.h
    public boolean a(Runnable runnable) {
        return this.f77941a.post(runnable);
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        int i3 = cVar.f77584a;
        if (i3 == 2) {
            Map map = (Map) cVar.f77585b.get("d_m");
            if (map != null) {
                if (this.f77945e == 2000) {
                    this.f77945e = com.tencent.beacon.base.util.b.a((String) map.get("realtimePollingTime"), this.f77945e, 1000L, 10000L);
                }
                if (this.f77946f == 5000) {
                    this.f77946f = com.tencent.beacon.base.util.b.a((String) map.get("normalPollingTime"), this.f77946f, 2000L, 3600000L);
                }
            }
        } else if (i3 == 11) {
            Object obj = cVar.f77585b.get("u_c_r_p");
            if (obj != null) {
                long longValue = ((Long) obj).longValue();
                if (longValue >= 1000 && longValue <= 10000) {
                    this.f77945e = longValue;
                }
            }
            Object obj2 = cVar.f77585b.get("u_c_n_p");
            if (obj2 != null) {
                long longValue2 = ((Long) obj2).longValue();
                if (longValue2 >= 2000 && longValue2 <= 3600000) {
                    this.f77946f = longValue2;
                }
            }
        }
        com.tencent.beacon.base.util.c.a("[EventManager]", "pollingTime maybe change, realtime: %s normal: %s", Long.valueOf(this.f77945e), Long.valueOf(this.f77946f));
    }
}
