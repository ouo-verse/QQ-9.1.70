package com.tencent.ecommerce.biz.consumer;

import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mh0.c;
import mh0.d;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ECGoodsReportManager;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Lorg/json/JSONObject;", CacheTable.TABLE_NAME, "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lmh0/c;", "Lmh0/d;", "callback", "", "b", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECGoodsReportManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Lazy f101586a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ECGoodsReportManager$a;", "", "Lcom/tencent/ecommerce/biz/consumer/ECGoodsReportManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/ecommerce/biz/consumer/ECGoodsReportManager;", "INSTANCE", "", "METHOD", "Ljava/lang/String;", "SERVICE", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.consumer.ECGoodsReportManager$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final ECGoodsReportManager a() {
            return (ECGoodsReportManager) ECGoodsReportManager.f101586a.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECGoodsReportManager>() { // from class: com.tencent.ecommerce.biz.consumer.ECGoodsReportManager$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECGoodsReportManager invoke() {
                return new ECGoodsReportManager();
            }
        });
        f101586a = lazy;
    }

    public final void b(String requestId, JSONObject reportInfo, IECNetworkCallback<c, d> callback) {
        if (requestId == null) {
            cg0.a.a("QQECCGoodsReportManager", "report", "request id is null");
        } else {
            com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.report_server.ReportServer", "/trpc.ecom.report_server.ReportServer/Report", new c(requestId, reportInfo), new d(), callback);
        }
    }
}
