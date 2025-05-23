package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report;

import android.os.Handler;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.GetStaggeredListReq;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.QFSPublicAccountStaggeredRepo;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.QFSPublishAccountStaggeredTechReporter$reportPageExposure$1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleAttaReporter;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qqecommerce.biz.report.api.IQQECDataReport;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.report.QCircleReporter;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007J(\u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0007J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\u0016\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ2\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/report/QFSPublishAccountStaggeredTechReporter;", "", "", "costTimeMills", "", "isFirstExposure", "isCacheData", "", "Le30/b;", "feedDataList", "", "g", "errCode", "", "cardCount", "hasCacheData", "requestType", "c", "i", "(I)Ljava/lang/Integer;", "", "errMsg", tl.h.F, "cmd", "scene", "size", "e", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublishAccountStaggeredTechReporter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSPublishAccountStaggeredTechReporter f87043a = new QFSPublishAccountStaggeredTechReporter();

    QFSPublishAccountStaggeredTechReporter() {
    }

    @JvmStatic
    public static final void c(long errCode, int cardCount, boolean hasCacheData, int requestType) {
        final Map mutableMapOf;
        Integer i3 = f87043a.i(requestType);
        if (i3 != null) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("error_code", Long.valueOf(errCode)), TuplesKt.to("count", Integer.valueOf(cardCount)), TuplesKt.to("has_cache_data", Integer.valueOf(hasCacheData ? 1 : 0)), TuplesKt.to("request_scene", Integer.valueOf(i3.intValue())));
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.s
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPublishAccountStaggeredTechReporter.d(mutableMapOf);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Map reportParams) {
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        ((IQCircleAttaReporter) QRoute.api(IQCircleAttaReporter.class)).report("ev_xsj_public_account_stagger_network_response", reportParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Map reportParams) {
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        ((IQQECDataReport) QRoute.api(IQQECDataReport.class)).dataReport("ev_xsj_public_account_quality_succ_rate_proto", reportParams);
    }

    @JvmStatic
    public static final void g(long costTimeMills, boolean isFirstExposure, boolean isCacheData, @Nullable final List<e30.b> feedDataList) {
        final Map mutableMapOf;
        final IQCirclePublicAccountMessageService iQCirclePublicAccountMessageService;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("card_exposure_cost", Long.valueOf(costTimeMills)), TuplesKt.to("is_first_exposure", Integer.valueOf(isFirstExposure ? 1 : 0)), TuplesKt.to("cache_type", Integer.valueOf(isCacheData ? 1 : 0)));
        AppInterface appInterface = QCircleServiceImpl.getAppInterface();
        if (appInterface != null && (iQCirclePublicAccountMessageService = (IQCirclePublicAccountMessageService) appInterface.getRuntimeService(IQCirclePublicAccountMessageService.class, "")) != null) {
            iQCirclePublicAccountMessageService.hasUnReadMessage(new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.QFSPublishAccountStaggeredTechReporter$reportPageExposure$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "messageInfo", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.QFSPublishAccountStaggeredTechReporter$reportPageExposure$1$1, reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends Lambda implements Function1<QCirclePublicAccountMessageInfo, Unit> {
                    final /* synthetic */ List<e30.b> $feedDataList;
                    final /* synthetic */ Map<String, Object> $reportParams;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(List<e30.b> list, Map<String, Object> map) {
                        super(1);
                        this.$feedDataList = list;
                        this.$reportParams = map;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void b(Map reportParams) {
                        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
                        ((IQCircleAttaReporter) QRoute.api(IQCircleAttaReporter.class)).report("ev_xsj_public_account_stagger_open_cost", reportParams);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                        invoke2(qCirclePublicAccountMessageInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                        List<e30.b> list;
                        PBStringField pBStringField;
                        if (qCirclePublicAccountMessageInfo != null && (list = this.$feedDataList) != null) {
                            List<e30.b> list2 = list;
                            int i3 = 1;
                            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                                Iterator<T> it = list2.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    FeedCloudMeta$StFeed g16 = ((e30.b) it.next()).g();
                                    if (Intrinsics.areEqual((g16 == null || (pBStringField = g16.f398449id) == null) ? null : pBStringField.get(), qCirclePublicAccountMessageInfo.getId())) {
                                        i3 = 0;
                                        break;
                                    }
                                }
                            }
                            this.$reportParams.put("red_dot_card_flag", Integer.valueOf(i3));
                        }
                        Handler reportHandler = QCircleReporter.getInstance().getReportHandler();
                        final Map<String, Object> map = this.$reportParams;
                        reportHandler.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.t
                            @Override // java.lang.Runnable
                            public final void run() {
                                QFSPublishAccountStaggeredTechReporter$reportPageExposure$1.AnonymousClass1.b(map);
                            }
                        });
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    mutableMapOf.put("red_dot_flag", Integer.valueOf(z16 ? 1 : 0));
                    iQCirclePublicAccountMessageService.fetchLastMessageInfo(new AnonymousClass1(feedDataList, mutableMapOf));
                }
            });
        }
    }

    private final Integer i(int requestType) {
        if (requestType == QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH.ordinal()) {
            return 1;
        }
        if (requestType == QFSPublicAccountStaggeredRepo.RequestType.REFRESH.ordinal()) {
            return 2;
        }
        if (requestType == QFSPublicAccountStaggeredRepo.RequestType.LOAD_MORE.ordinal()) {
            return 3;
        }
        return null;
    }

    public final void e(@NotNull String cmd, long errCode, @NotNull String errMsg, int scene, int size) {
        final Map mutableMapOf;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cmd", cmd), TuplesKt.to("result_code", Long.valueOf(errCode)), TuplesKt.to("result_msg", errMsg), TuplesKt.to("scene", Integer.valueOf(scene)), TuplesKt.to("size", Integer.valueOf(size)));
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.r
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublishAccountStaggeredTechReporter.f(mutableMapOf);
            }
        });
    }

    public final void h(long errCode, @NotNull String errMsg, int requestType, int cardCount) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Integer i3 = i(requestType);
        if (i3 != null) {
            e(GetStaggeredListReq.CMD, errCode, errMsg, i3.intValue(), cardCount);
        }
    }
}
