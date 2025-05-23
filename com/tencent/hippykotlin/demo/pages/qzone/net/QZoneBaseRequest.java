package com.tencent.hippykotlin.demo.pages.qzone.net;

import c45.e;
import c45.i;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kuikly.NS_QWEB_PROTOCAL.c;
import kuikly.NS_QWEB_PROTOCAL.d;
import oicq.wlogin_sdk.tools.util;
import zz0.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class QZoneBaseRequest<BusiReq extends e, BusiRsp extends e> extends BasePbRequest<c, d> {
    public static long seq;
    public String traceId;

    public QZoneBaseRequest(String str) {
        this.traceId = str;
    }

    public boolean checkFinish(BusiRsp busirsp) {
        return true;
    }

    public abstract BusiRsp decodeBusiRsp(byte[] bArr);

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final d decodeResponse(byte[] bArr) {
        return (d) i.a(d.f413153m, bArr);
    }

    public abstract BusiReq getBusiReq();

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public /* synthetic */ QZoneBaseRequest(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("");
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c getRequest() {
        String str;
        List mutableListOf;
        String traceId = getTraceId();
        if (traceId == null || traceId.length() == 0) {
            setTraceId(QQKuiklyPlatformApi.Companion.getUin() + util.base64_pad_url + a.f453719a.a());
        }
        QZoneComposePlatformModule qZoneComposePlatformModule = QZoneComposePlatformModule.Companion.get();
        if (qZoneComposePlatformModule == null || (str = qZoneComposePlatformModule.syncToNativeMethod("getQUA", (com.tencent.kuikly.core.nvi.serialization.json.e) null, (Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit>) null)) == null) {
            str = "";
        }
        String str2 = str;
        c45.a aVar = new c45.a(i.d(getBusiReq()));
        MapsKt__MapsKt.emptyMap();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new kuikly.NS_COMM.a(QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_KEY, "101"));
        String syncCallNativeMethod = ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).syncCallNativeMethod("getDeviceInfo", null, null);
        String traceId2 = getTraceId();
        long j3 = seq;
        seq = 1 + j3;
        Long valueOf = Long.valueOf(j3);
        MapsKt__MapsKt.emptyMap();
        return new c(valueOf, str2, syncCallNativeMethod, aVar, traceId2, null, null, null, null, mutableListOf);
    }
}
