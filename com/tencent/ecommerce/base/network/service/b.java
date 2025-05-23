package com.tencent.ecommerce.base.network.service;

import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/base/network/service/b;", "", "", "method", "", "a", "Lcom/tencent/ecommerce/base/network/api/e;", "remoteResponse", "", "c", "service", "", PreDownloadConstants.RPORT_KEY_REQ_TIME, "b", "", "Ljava/util/List;", "defaultBlackCmdList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final List<String> defaultBlackCmdList;

    /* renamed from: b, reason: collision with root package name */
    public static final b f100859b = new b();

    static {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("/trpc.ecom.report_server.ReportServer/Report", "/trpc.ecom.realtime_reportsvr.RealtimeReportsvr/Report");
        defaultBlackCmdList = mutableListOf;
    }

    b() {
    }

    private final boolean a(String method) {
        return defaultBlackCmdList.contains(method);
    }

    public final void b(String service, String method, long reqTime, ECRemoteResponse remoteResponse) {
        Map mapOf;
        if (a(method)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - reqTime;
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cmd", method), TuplesKt.to("result_msg", remoteResponse.getMsg()), TuplesKt.to("result_code", Integer.valueOf(remoteResponse.getCode())), TuplesKt.to("channel_code", Integer.valueOf(remoteResponse.getChannelCode())), TuplesKt.to("cost_time", Long.valueOf(currentTimeMillis)));
        IECDataReport.a.a(bVar, "ec_quality_succ_rate_proto", mapOf, false, 4, null);
    }

    public final void c(String method, ECRemoteResponse remoteResponse) {
        Map mapOf;
        if (a(method) || remoteResponse.getCompressType() == 0) {
            return;
        }
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cmd", method), TuplesKt.to("type", Integer.valueOf(remoteResponse.getCompressType())), TuplesKt.to("ratio", remoteResponse.getCompressRatio()), TuplesKt.to("result_code", Integer.valueOf(remoteResponse.getUnCompressSucceed())), TuplesKt.to("cost_time", Long.valueOf(remoteResponse.getUnCompressTimeCost())));
        IECDataReport.a.a(bVar, "ec_quality_network_rsp_unzip_cost_time", mapOf, false, 4, null);
    }
}
