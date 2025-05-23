package com.tencent.beacon.event.immediate;

import com.tencent.beacon.a.b.i;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.call.f;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.d;
import com.tencent.beacon.pack.ResponsePackageV2;
import com.tencent.beacon.pack.a;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BeaconImmediateReportCallback implements f<BeaconTransferResult> {

    /* renamed from: a, reason: collision with root package name */
    private d f77970a;

    /* renamed from: b, reason: collision with root package name */
    private EventBean f77971b;

    /* renamed from: c, reason: collision with root package name */
    private String f77972c;

    /* renamed from: d, reason: collision with root package name */
    private long f77973d = new Date().getTime();

    public BeaconImmediateReportCallback(d dVar, EventBean eventBean, String str) {
        this.f77970a = dVar;
        this.f77971b = eventBean;
        this.f77972c = str;
    }

    private void a(com.tencent.beacon.base.net.d dVar) {
        c.a("[BeaconImmediateReportCallback]", dVar.toString(), new Object[0]);
        i.e().a(dVar.f77778b, dVar.f77780d, dVar.f77781e);
        this.f77970a.a(this.f77971b, this.f77972c);
    }

    public void onResponse(BeaconTransferResult beaconTransferResult) {
        if (beaconTransferResult == null) {
            a(new com.tencent.beacon.base.net.d(RequestType.LONG_CONNECTION.name(), "462", -1, "response fail! result is null"));
            return;
        }
        boolean z16 = beaconTransferResult.getCode() == 0 && beaconTransferResult.getBizCode() == 0;
        c.a("[BeaconImmediateReportCallback]", "result=%s, eventName=%s , logID=%s", beaconTransferResult.toString(), this.f77971b.getEventCode(), this.f77972c);
        if (!z16) {
            a(new com.tencent.beacon.base.net.d(RequestType.LONG_CONNECTION.name(), "463", beaconTransferResult.getCode(), c.c("response fail! result = %s", beaconTransferResult.toString())));
            return;
        }
        byte[] bizBuffer = beaconTransferResult.getBizBuffer();
        ResponsePackageV2 responsePackageV2 = new ResponsePackageV2();
        try {
            responsePackageV2.readFrom(new a(bizBuffer));
            com.tencent.beacon.base.net.b.d.a(this.f77973d, responsePackageV2.serverTime, responsePackageV2.srcGatewayIp);
        } catch (Throwable th5) {
            c.a(th5);
            a(new com.tencent.beacon.base.net.d(RequestType.LONG_CONNECTION.name(), "463", beaconTransferResult.getCode(), th5.getMessage(), th5));
        }
    }
}
