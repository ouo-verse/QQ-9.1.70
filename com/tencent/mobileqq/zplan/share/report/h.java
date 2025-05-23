package com.tencent.mobileqq.zplan.share.report;

import android.view.View;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000 \b2\u00020\u0001:\u0001\u0019B\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/report/h;", "Lcom/tencent/mobileqq/zplan/share/report/a;", "", "channelID", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "", "e", "d", "g", "Landroid/view/View;", "view", "f", "", "", "", tl.h.F, "I", "getSource", "()I", "setSource", "(I)V", "source", "<init>", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int source;

    public h(int i3) {
        this.source = i3;
        l(new ShareReportCommonInfo(SquareReportConst.PageId.PAGE_ID_POSTER_SHARE, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE, "ev_zplan_posters_share_success", SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "zplan_share_channel"));
    }

    private final int m(int channelID) {
        if (channelID != 0) {
            int i3 = 1;
            if (channelID == 1) {
                return 2;
            }
            if (channelID == 2) {
                return 3;
            }
            if (channelID != 3) {
                if (channelID != 6) {
                    i3 = 7;
                    if (channelID == 7) {
                        return 6;
                    }
                    if (channelID != 8) {
                        return -1;
                    }
                }
                return i3;
            }
            return 4;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a, com.tencent.mobileqq.zplan.share.report.c
    public void d(int channelID, ZPlanShareLaunchParam launchParam) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        id3.d dtReporter = getDtReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to("zplan_square_posters_share_channel", Integer.valueOf(m(channelID))), TuplesKt.to("zplan_square_posters_share_from", Integer.valueOf(this.source)));
        dtReporter.d("ev_zplan_posters_share_success", mutableMapOf);
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a, com.tencent.mobileqq.zplan.share.report.c
    public void e(int channelID, ZPlanShareLaunchParam launchParam) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        id3.d dtReporter = getDtReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"), TuplesKt.to("zplan_square_posters_share_from", Integer.valueOf(this.source)), TuplesKt.to("zplan_square_posters_share_channel", Integer.valueOf(m(channelID))));
        dtReporter.d("ev_zplan_posters_share_window", mutableMapOf);
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a, com.tencent.mobileqq.zplan.share.report.c
    public void f(View view, ZPlanShareLaunchParam launchParam) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        id3.d dtReporter = getDtReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to("zplan_square_posters_share_channel", 5), TuplesKt.to("zplan_square_posters_share_from", Integer.valueOf(this.source)));
        dtReporter.d("ev_zplan_posters_share_success", mutableMapOf);
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a, com.tencent.mobileqq.zplan.share.report.c
    public void g(int channelID, ZPlanShareLaunchParam launchParam) {
        int i3;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        if (channelID == 0) {
            i3 = 0;
        } else if (channelID == 1) {
            i3 = 2;
        } else if (channelID == 2) {
            i3 = 3;
        } else if (channelID != 3) {
            i3 = 6;
            if (channelID == 6) {
                i3 = 1;
            } else if (channelID != 7) {
                i3 = channelID != 8 ? -1 : 7;
            }
        } else {
            i3 = 4;
        }
        id3.d dtReporter = getDtReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to("zplan_square_posters_share_channel", Integer.valueOf(i3)), TuplesKt.to("zplan_square_posters_share_from", Integer.valueOf(this.source)));
        dtReporter.d("ev_zplan_posters_share_window", mutableMapOf);
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a
    public Map<String, Object> h(ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        return new LinkedHashMap();
    }
}
