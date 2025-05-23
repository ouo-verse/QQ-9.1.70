package com.tencent.beacon.event;

import com.tencent.beacon.a.b.i;
import com.tencent.beacon.event.immediate.BeaconImmediateReportCallback;
import com.tencent.beacon.event.immediate.BeaconTransferArgs;
import com.tencent.beacon.event.immediate.IBeaconImmediateReport;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.pack.RequestPackageV2;

/* compiled from: P */
/* loaded from: classes2.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventBean f77895a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f77896b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f77897c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, EventBean eventBean, String str) {
        this.f77897c = dVar;
        this.f77895a = eventBean;
        this.f77896b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        BeaconTransferArgs a16;
        try {
            RequestPackageV2 a17 = com.tencent.beacon.event.c.d.a(this.f77895a);
            IBeaconImmediateReport immediateReport = BeaconReport.getInstance().getImmediateReport();
            a16 = this.f77897c.a(a17.toByteArray(), this.f77895a);
            immediateReport.reportImmediate(a16, new BeaconImmediateReportCallback(this.f77897c, this.f77895a, this.f77896b));
        } catch (Throwable th5) {
            com.tencent.beacon.base.util.c.b("[immediate] report error!", new Object[0]);
            com.tencent.beacon.base.util.c.a(th5);
            this.f77897c.a(this.f77895a, this.f77896b);
            i.e().a("515", "immediate report error!", th5);
        }
    }
}
