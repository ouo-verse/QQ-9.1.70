package com.tencent.beacon.event;

import com.tencent.beacon.a.b.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventBean f77878a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f77879b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar, EventBean eventBean) {
        this.f77879b = dVar;
        this.f77878a = eventBean;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.event.a.a aVar;
        com.tencent.beacon.event.a.a aVar2;
        aVar = this.f77879b.f77942b;
        if (!aVar.a(this.f77878a.getEventType())) {
            aVar2 = this.f77879b.f77942b;
            boolean a16 = aVar2.a(this.f77878a);
            com.tencent.beacon.base.util.c.a("[EventModule]", 2, "event: %s. insert to DB %s", this.f77878a.getEventCode(), Boolean.valueOf(a16));
            if (a16) {
                this.f77879b.b();
                return;
            }
            return;
        }
        i.e().a("602", "type: " + com.tencent.beacon.event.c.d.a(this.f77878a.getEventType()) + " max db count!");
        com.tencent.beacon.base.util.c.a("[EventModule]", 2, "event: %s. insert to DB false. reason: DB count max!", this.f77878a.getEventCode());
    }
}
