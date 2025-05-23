package com.tencent.ecommerce.base.network.service;

import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J.\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/base/network/service/c;", "", "", "method", "", "spanNum", "c", "", "d", "service", "reqParamsLength", "Lcom/tencent/ecommerce/base/network/api/e;", "remoteResponse", "a", "b", "Lhg0/b;", "Lhg0/b;", "networkSpan", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f100861b = new c();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static hg0.b networkSpan = new hg0.b();

    c() {
    }

    private final String c(String method, int spanNum) {
        return method + util.base64_pad_url + spanNum;
    }

    public final void a(String service, String method, int reqParamsLength, ECRemoteResponse remoteResponse, int spanNum) {
        Map<String, String> mapOf;
        if (eg0.a.f396236c.b(method)) {
            return;
        }
        hg0.b bVar = networkSpan;
        String c16 = c(method, spanNum);
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.to("network.request.service", service);
        pairArr[1] = TuplesKt.to("network.request.method", method);
        pairArr[2] = TuplesKt.to("network.request.req_len", String.valueOf(reqParamsLength));
        pairArr[3] = TuplesKt.to("network.response.ch_code", String.valueOf(remoteResponse.getChannelCode()));
        pairArr[4] = TuplesKt.to("network.response.ch_msg", remoteResponse.getChannelMsg());
        pairArr[5] = TuplesKt.to("network.response.biz_code", String.valueOf(remoteResponse.getCode()));
        pairArr[6] = TuplesKt.to("network.response.biz_msg", remoteResponse.getMsg());
        byte[] data = remoteResponse.getData();
        pairArr[7] = TuplesKt.to("network.response.rsp_len", String.valueOf(data != null ? Integer.valueOf(data.length) : null));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        bVar.d(c16, mapOf);
        networkSpan.b(c(method, spanNum), remoteResponse.getCode());
    }

    public final String b(String method, int spanNum) {
        if (eg0.a.f396236c.b(method)) {
            return "";
        }
        return networkSpan.c(c(method, spanNum));
    }

    public final void d(String method, int spanNum) {
        if (eg0.a.f396236c.b(method)) {
            return;
        }
        hg0.b.f(networkSpan, c(method, spanNum), null, 2, null);
    }
}
