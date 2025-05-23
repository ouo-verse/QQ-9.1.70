package com.tencent.mobileqq.zplan.share.report;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/report/d;", "Lcom/tencent/mobileqq/zplan/share/report/a;", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "", "", "", tl.h.F, "d", "Ljava/util/Map;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/Map;", "setExtraMapParam", "(Ljava/util/Map;)V", "extraMapParam", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> extraMapParam = new LinkedHashMap();

    public d() {
        l(new ShareReportCommonInfo("pg_zplan_xiaowo_meeting_share", SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE, "ev_zplan_xiaowo_meeting_share_success", SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "zplan_share_channel"));
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a
    public Map<String, Object> h(ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        return this.extraMapParam;
    }

    public final Map<String, Object> m() {
        return this.extraMapParam;
    }
}
