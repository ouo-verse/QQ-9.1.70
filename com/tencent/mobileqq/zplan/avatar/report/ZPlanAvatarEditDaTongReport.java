package com.tencent.mobileqq.zplan.avatar.report;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.avatar.b;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t74.l;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0013H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/report/ZPlanAvatarEditDaTongReport;", "Lcom/tencent/mobileqq/zplan/avatar/b;", "", "eventId", "", "", "params", "", "c", "Lcom/tencent/mobileqq/zplan/avatar/b$b;", "param", "g", "f", "Lcom/tencent/mobileqq/zplan/avatar/b$d;", "i", h.F, "Lcom/tencent/mobileqq/zplan/avatar/b$c;", "k", "j", "Lcom/tencent/mobileqq/zplan/avatar/b$a;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Lkotlin/Lazy;", "b", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "enableReport", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarEditDaTongReport implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy enableReport;

    public ZPlanAvatarEditDaTongReport() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AtomicBoolean>() { // from class: com.tencent.mobileqq.zplan.avatar.report.ZPlanAvatarEditDaTongReport$enableReport$2
            @Override // kotlin.jvm.functions.Function0
            public final AtomicBoolean invoke() {
                return new AtomicBoolean(((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableReportZPlanAvatar());
            }
        });
        this.enableReport = lazy;
    }

    private final AtomicBoolean b() {
        return (AtomicBoolean) this.enableReport.getValue();
    }

    private final void c(final String eventId, final Map<String, ? extends Object> params) {
        l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.report.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarEditDaTongReport.d(ZPlanAvatarEditDaTongReport.this, eventId, params);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ZPlanAvatarEditDaTongReport this$0, String eventId, Map params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(eventId, "$eventId");
        Intrinsics.checkNotNullParameter(params, "$params");
        if (this$0.b().get()) {
            VideoReport.reportEvent(eventId, params);
            if (QLog.isColorLevel()) {
                QLog.i("ZPlanAvatarEditDaTongReport", 2, "report " + eventId + " -> " + params);
            }
        }
    }

    public void e(b.AvatarEditLeaveParam param) {
        String str;
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(param, "param");
        Pair[] pairArr = new Pair[9];
        pairArr[0] = new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        pairArr[1] = new Pair("zplan_avatar_edit_entrance", param.getEntranceType());
        pairArr[2] = new Pair("zplan_avatar_loaded_cnt", param.getLoadedCnt());
        pairArr[3] = new Pair("zplan_cloud_recording_cnt", param.getCloudCacheCnt());
        pairArr[4] = new Pair("zplan_local_recording_cnt", param.getLocalRecordCnt());
        pairArr[5] = new Pair("zplan_cache_cnt", param.getLocalCacheCnt());
        pairArr[6] = new Pair("zplan_dress_up_key", param.getDressUpKey());
        if (Intrinsics.areEqual(param.getIsDefaultAppearance(), Boolean.TRUE)) {
            str = "0";
        } else {
            str = "1";
        }
        pairArr[7] = new Pair("zplan_is_dress_up_user", str);
        pairArr[8] = new Pair("zplan_is_the_first_time_enter", param.getFirstEntryType());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        c("ev_leave_avatar_edit", mutableMapOf);
    }

    public void f(b.AvatarLoadingReportParam param) {
        String str;
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(param, "param");
        Pair[] pairArr = new Pair[10];
        pairArr[0] = new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        pairArr[1] = new Pair("zplan_loading_lvtm", param.getLoadingLvtm());
        pairArr[2] = new Pair(SquareReportConst.Key.KEY_ZPLAN_FAIL_REASON, param.getFailReason());
        pairArr[3] = new Pair("zplan_avatar_edit_entrance", param.getEntranceType());
        pairArr[4] = new Pair("zplan_cloud_recording_cnt", param.getCloudCacheCnt());
        pairArr[5] = new Pair("zplan_local_recording_cnt", param.getLocalRecordCnt());
        pairArr[6] = new Pair("zplan_cache_cnt", param.getLocalCacheCnt());
        pairArr[7] = new Pair("zplan_dress_up_key", param.getDressUpKey());
        if (Intrinsics.areEqual(param.getIsDefaultAppearance(), Boolean.TRUE)) {
            str = "0";
        } else {
            str = "1";
        }
        pairArr[8] = new Pair("zplan_is_dress_up_user", str);
        pairArr[9] = new Pair("zplan_is_the_first_time_enter", param.getFirstEntryType());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        c("ev_pg_zplan_avatar_edit_loading_fail", mutableMapOf);
    }

    public void g(b.AvatarLoadingReportParam param) {
        String str;
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(param, "param");
        Pair[] pairArr = new Pair[9];
        pairArr[0] = new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        pairArr[1] = new Pair("zplan_loading_lvtm", param.getLoadingLvtm());
        pairArr[2] = new Pair("zplan_avatar_edit_entrance", param.getEntranceType());
        pairArr[3] = new Pair("zplan_cloud_recording_cnt", param.getCloudCacheCnt());
        pairArr[4] = new Pair("zplan_local_recording_cnt", param.getLocalRecordCnt());
        pairArr[5] = new Pair("zplan_cache_cnt", param.getLocalCacheCnt());
        pairArr[6] = new Pair("zplan_dress_up_key", param.getDressUpKey());
        if (Intrinsics.areEqual(param.getIsDefaultAppearance(), Boolean.TRUE)) {
            str = "0";
        } else {
            str = "1";
        }
        pairArr[7] = new Pair("zplan_is_dress_up_user", str);
        pairArr[8] = new Pair("zplan_is_the_first_time_enter", param.getFirstEntryType());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        c("ev_pg_zplan_avatar_edit_loading_suc", mutableMapOf);
    }

    public void h(b.AvatarSaveReportParam param) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(param, "param");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair(SquareReportConst.Key.KEY_ACTION_ID, param.getActionId()), new Pair("zplan_background_url", param.getBackgroundUrl()), new Pair("zplan_profile_save_fail_reason", param.getFailReason()), new Pair("zplan_avatar_edit_entrance", param.getEntranceType()), new Pair("zplan_avatar_mark", param.getAvatarMark()));
        c("ev_zplan_save_avatar_fail", mutableMapOf);
    }

    public void i(b.AvatarSaveReportParam param) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(param, "param");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair(SquareReportConst.Key.KEY_ACTION_ID, param.getActionId()), new Pair("zplan_background_url", param.getBackgroundUrl()), new Pair("zplan_avatar_edit_entrance", param.getEntranceType()), new Pair("zplan_avatar_mark", param.getAvatarMark()));
        c("ev_zplan_save_avatar_suc", mutableMapOf);
    }

    public void j(b.AvatarRenewReportParam param) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(param, "param");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair(SquareReportConst.Key.KEY_ACTION_ID, param.getActionId()), new Pair("zplan_background_url", param.getBackgroundUrl()), new Pair("zplan_profile_update_fail_reason", param.getFailReason()), new Pair("zplan_avatar_mark", param.getAvatarMark()), new Pair("zplan_avatar_change_source", param.getChangeSource()), new Pair("zplan_profile_update_elapse", param.getFollowDressElapse()));
        c("ev_zplan_renew_avatar_fail", mutableMapOf);
    }

    public void k(b.AvatarRenewReportParam param) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(param, "param");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair(SquareReportConst.Key.KEY_ACTION_ID, param.getActionId()), new Pair("zplan_background_url", param.getBackgroundUrl()), new Pair("zplan_avatar_mark", param.getAvatarMark()), new Pair("zplan_avatar_change_source", param.getChangeSource()), new Pair("zplan_profile_update_elapse", param.getFollowDressElapse()));
        c("ev_zplan_renew_avatar_suc", mutableMapOf);
    }
}
