package com.tencent.mobileqq.zplan.easteregg.report;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.easteregg.u;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import t74.l;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J0\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/report/EasterEggDaTongReport;", "Lcom/tencent/mobileqq/zplan/easteregg/u;", "", "eventId", "", "", "params", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "", "d", "Lcom/tencent/mobileqq/zplan/easteregg/u$a;", "reportParam", "a", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlin/Lazy;", "c", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "enableReport", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class EasterEggDaTongReport implements u {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy enableReport;

    public EasterEggDaTongReport() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AtomicBoolean>() { // from class: com.tencent.mobileqq.zplan.easteregg.report.EasterEggDaTongReport$enableReport$2
            @Override // kotlin.jvm.functions.Function0
            public final AtomicBoolean invoke() {
                return new AtomicBoolean(((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableReportEasterEgg());
            }
        });
        this.enableReport = lazy;
    }

    private final AtomicBoolean c() {
        return (AtomicBoolean) this.enableReport.getValue();
    }

    private final void d(final String eventId, final Map<String, ? extends Object> params, final String senderUin) {
        l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.report.a
            @Override // java.lang.Runnable
            public final void run() {
                EasterEggDaTongReport.e(senderUin, this, eventId, params);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String str, EasterEggDaTongReport this$0, String eventId, Map params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(eventId, "$eventId");
        Intrinsics.checkNotNullParameter(params, "$params");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        if (str == null || str.length() == 0) {
            return;
        }
        if (!(currentUin == null || currentUin.length() == 0) && Intrinsics.areEqual(currentUin, str) && this$0.c().get()) {
            VideoReport.reportEvent(eventId, params);
            if (QLog.isColorLevel()) {
                QLog.i("EasterEggDaTongReport", 2, "report " + eventId + " -> " + params);
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.u
    public void a(u.EasterEggReportParam reportParam) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(reportParam, "reportParam");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair("zplan_caidan_id", Integer.valueOf(reportParam.getPortraitId())), new Pair("zplan_caidan_name", reportParam.getPortraitName()), new Pair("zplan_is_friend_or_group", Integer.valueOf(reportParam.getSessionType())), new Pair("zplan_other_user_qq", reportParam.getFriendUin()));
        d("ev_zplan_trigger_avatar_caidan", mutableMapOf, reportParam.getSenderUin());
    }

    public void f(u.EasterEggReportParam reportParam) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(reportParam, "reportParam");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair("zplan_caidan_id", Integer.valueOf(reportParam.getPortraitId())), new Pair("zplan_caidan_name", reportParam.getPortraitName()), new Pair("zplan_is_friend_or_group", Integer.valueOf(reportParam.getSessionType())), new Pair("zplan_other_user_qq", reportParam.getFriendUin()), new Pair("zplan_total_time", Long.valueOf(reportParam.getTimeCost())), new Pair("zplan_is_start_recording", Integer.valueOf(reportParam.getIsRecorded() ? 1 : 0)));
        d("ev_zplan_play_caidan_success", mutableMapOf, reportParam.getSenderUin());
    }
}
