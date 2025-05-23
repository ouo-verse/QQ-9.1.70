package com.tencent.mobileqq.zplan.share.report;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/report/g;", "Lcom/tencent/mobileqq/zplan/share/report/a;", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "", "", "", tl.h.F, "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends a {
    public g() {
        l(new ShareReportCommonInfo("pg_zplan_xiaowo_photo_share", SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE, "ev_zplan_xiaowo_photo_share_success", SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "zplan_share_channel"));
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a
    public Map<String, Object> h(ZPlanShareLaunchParam launchParam) {
        Object obj;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(i().getKeyExternalEntrance(), ah.b(launchParam.getSource()));
        Map<String, Object> bizExtraParams = launchParam.getBizExtraParams();
        if (bizExtraParams == null || (obj = bizExtraParams.get(ZPlanShareLaunchParam.KEY_BIZ_SMALL_HOME_SCENE)) == null) {
            obj = "0";
        }
        pairArr[1] = TuplesKt.to("zplan_xiaowo_photo_from", obj);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }
}
