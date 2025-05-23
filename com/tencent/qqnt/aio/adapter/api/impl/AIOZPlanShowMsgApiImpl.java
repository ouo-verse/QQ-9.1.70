package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi;
import com.tencent.state.report.SquareReportConst;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOZPlanShowMsgApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOZPlanShowMsgApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "onEnterAIO", "onExitAIO", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "onMsgClick", "onPlayAction", "Lcom/tencent/mobileqq/zplan/api/IZPlanShowGuideApi;", "zPlanShowGuideApi$delegate", "Lkotlin/Lazy;", "getZPlanShowGuideApi", "()Lcom/tencent/mobileqq/zplan/api/IZPlanShowGuideApi;", "zPlanShowGuideApi", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOZPlanShowMsgApiImpl implements IAIOZPlanShowMsgApi {
    public static final String TAG = "AIOZPlanShowMsgApiImpl";

    /* renamed from: zPlanShowGuideApi$delegate, reason: from kotlin metadata */
    private final Lazy zPlanShowGuideApi;

    public AIOZPlanShowMsgApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IZPlanShowGuideApi>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.AIOZPlanShowMsgApiImpl$zPlanShowGuideApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IZPlanShowGuideApi invoke() {
                QRouteApi api = QRoute.api(IZPlanShowGuideApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanShowGuideApi::class.java)");
                return (IZPlanShowGuideApi) api;
            }
        });
        this.zPlanShowGuideApi = lazy;
    }

    private final IZPlanShowGuideApi getZPlanShowGuideApi() {
        return (IZPlanShowGuideApi) this.zPlanShowGuideApi.getValue();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi
    public void onEnterAIO(com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        getZPlanShowGuideApi().onEnterAIO(aioContext);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi
    public void onExitAIO() {
        getZPlanShowGuideApi().onExitAIO();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi
    public void onMsgClick(AIOMsgItem msgItem) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getCoupleAvatarSwitchConfig().getEnable()) {
            QLog.i(TAG, 1, "onMsgClick, coupleSwitchConfig false, return.");
            return;
        }
        String valueOf = String.valueOf(msgItem.getMsgRecord().peerUin);
        if (getZPlanShowGuideApi().onNeedShowDialog(valueOf)) {
            getZPlanShowGuideApi().onShowDialog(msgItem);
        } else {
            getZPlanShowGuideApi().onPlayAvatarAnimation(msgItem);
        }
        try {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_action_type", "click"), TuplesKt.to("zplan_to_uin", valueOf));
            VideoReport.reportEvent("ev_zplan_super_text", mapOf);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "onMsgClick\uff1areport error = " + e16);
            }
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi
    public void onPlayAction(AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getCoupleAvatarSwitchConfig().getEnable()) {
            QLog.i(TAG, 1, "onPlayAction, coupleSwitchConfig false, return.");
        } else {
            getZPlanShowGuideApi().onPlayAvatarAnimation(msgItem);
        }
    }
}
