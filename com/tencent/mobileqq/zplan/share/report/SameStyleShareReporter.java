package com.tencent.mobileqq.zplan.share.report;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.event.api.Event;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/report/SameStyleShareReporter;", "Lcom/tencent/mobileqq/zplan/share/report/a;", "", "channelID", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "", DomainData.DOMAIN_NAME, "d", "", "", "", tl.h.F, "Lec3/b;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lec3/b;", "apiReport", "<init>", "()V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SameStyleShareReporter extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy apiReport;

    public SameStyleShareReporter() {
        Lazy lazy;
        l(new ShareReportCommonInfo("pg_zplan_samestyle_share", SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, "em_zplan_samestyle_share_channel", "ev_zplan_samestyle_share_success", SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "zplan_share_channel"));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ec3.b>() { // from class: com.tencent.mobileqq.zplan.share.report.SameStyleShareReporter$apiReport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ec3.b invoke() {
                return new ec3.b();
            }
        });
        this.apiReport = lazy;
    }

    private final ec3.b m() {
        return (ec3.b) this.apiReport.getValue();
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a, com.tencent.mobileqq.zplan.share.report.c
    public void d(int channelID, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        super.d(channelID, launchParam);
        n(channelID, launchParam);
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a
    public Map<String, Object> h(ZPlanShareLaunchParam launchParam) {
        Object obj;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(i().getKeyExternalEntrance(), ah.b(launchParam.getSource()));
        Map<String, Object> bizExtraParams = launchParam.getBizExtraParams();
        if (bizExtraParams == null || (obj = bizExtraParams.get(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID)) == null) {
            obj = -1;
        }
        pairArr[1] = TuplesKt.to(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, obj.toString());
        pairArr[2] = TuplesKt.to("zplan_samestyle_type", String.valueOf(launchParam.getContentType()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final void n(int channelID, ZPlanShareLaunchParam launchParam) {
        Object obj;
        HashMap hashMapOf;
        Object obj2;
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to(i().getKeyExternalEntrance(), ah.b(launchParam.getSource()));
        Map<String, Object> bizExtraParams = launchParam.getBizExtraParams();
        Object obj3 = -1;
        if (bizExtraParams == null || (obj = bizExtraParams.get(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID)) == null) {
            obj = obj3;
        }
        pairArr[1] = TuplesKt.to(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, obj.toString());
        pairArr[2] = TuplesKt.to("zplan_samestyle_type", String.valueOf(launchParam.getContentType()));
        pairArr[3] = TuplesKt.to("zplan_share_channel", String.valueOf(channelID));
        Map<String, Object> bizExtraParams2 = launchParam.getBizExtraParams();
        if (bizExtraParams2 != null && (obj2 = bizExtraParams2.get(ZPlanShareLaunchParam.KEY_BIZ_TEMPLATE_TAB)) != null) {
            obj3 = obj2;
        }
        pairArr[4] = TuplesKt.to(ZPlanShareLaunchParam.KEY_BIZ_TEMPLATE_TAB, obj3.toString());
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        Event event = new Event(i().getEvIdShareSuccess(), 1, 0, null, hashMapOf, 12, null);
        QLog.i("SameStylReport", 1, "share event " + hashMapOf);
        m().a(event);
    }
}
