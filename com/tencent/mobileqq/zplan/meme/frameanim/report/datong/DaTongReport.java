package com.tencent.mobileqq.zplan.meme.frameanim.report.datong;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import cooperation.qzone.util.QZLog;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0002J&\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004J.\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\nJ\u001e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J&\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/report/datong/DaTongReport;", "", "", "businessId", "", "isSelf", "e", "d", "change", "b", "", "eventId", "", "params", "", "f", "uin", "", "sessionId", "updateToDate", "k", "code", "msg", h.F, "j", "totalTime", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlin/Lazy;", "c", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "enableReport", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DaTongReport {

    /* renamed from: a, reason: collision with root package name */
    public static final DaTongReport f334065a = new DaTongReport();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy enableReport;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AtomicBoolean>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.report.datong.DaTongReport$enableReport$2
            @Override // kotlin.jvm.functions.Function0
            public final AtomicBoolean invoke() {
                return new AtomicBoolean(((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableReportDynamicAvatarToDaTong());
            }
        });
        enableReport = lazy;
    }

    DaTongReport() {
    }

    private final AtomicBoolean c() {
        return (AtomicBoolean) enableReport.getValue();
    }

    private final int d(int businessId) {
        if (businessId != 3) {
            if (businessId != 4) {
                return -1;
            }
            return 0;
        }
        return 1;
    }

    private final int e(int businessId, boolean isSelf) {
        if (businessId != 2) {
            return businessId != 3 ? 0 : 0;
        }
        if (!isSelf) {
            return 2;
        }
        return 1;
    }

    private final void f(final String eventId, final Map<String, ? extends Object> params) {
        l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.report.datong.a
            @Override // java.lang.Runnable
            public final void run() {
                DaTongReport.g(eventId, params);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String eventId, Map params) {
        Intrinsics.checkNotNullParameter(eventId, "$eventId");
        Intrinsics.checkNotNullParameter(params, "$params");
        if (f334065a.c().get()) {
            VideoReport.reportEvent(eventId, params);
            if (QZLog.isColorLevel()) {
                QZLog.i("DaTongReport", 2, "report " + eventId + " -> " + params);
            }
        }
    }

    public final void h(String uin, int businessId, long sessionId, int code, String msg2) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair("zplan_dongtai_ziliao_type", Integer.valueOf(e(businessId, bb.f335811a.r(uin)))), new Pair("zplan_dongtai_pg_mode", Integer.valueOf(d(businessId))), new Pair("zplan_banner_avatar_sessionid", Long.valueOf(sessionId)), new Pair("zplan_error_code", Integer.valueOf(code)), new Pair("zplan_error_msg", msg2));
        f("ev_zplan_avatar_error_bubble", mutableMapOf);
    }

    public final void i(String uin, int businessId, long sessionId, long totalTime) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair("zplan_dongtai_ziliao_type", Integer.valueOf(e(businessId, bb.f335811a.r(uin)))), new Pair("zplan_dongtai_pg_mode", Integer.valueOf(d(businessId))), new Pair("zplan_banner_avatar_sessionid", Long.valueOf(sessionId)), new Pair("zplan_total_time", Long.valueOf(totalTime)));
        f("ev_zplan_avatar_loading_end", mutableMapOf);
    }

    public final void j(String uin, int businessId, long sessionId) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair("zplan_dongtai_ziliao_type", Integer.valueOf(e(businessId, bb.f335811a.r(uin)))), new Pair("zplan_dongtai_pg_mode", Integer.valueOf(d(businessId))), new Pair("zplan_banner_avatar_sessionid", Long.valueOf(sessionId)));
        f("ev_zplan_avatar_loading_start", mutableMapOf);
    }

    public final void k(String uin, int businessId, long sessionId, boolean updateToDate) {
        Map<String, ? extends Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), new Pair("zplan_dongtai_ziliao_type", Integer.valueOf(e(businessId, bb.f335811a.r(uin)))), new Pair("zplan_dongtai_pg_mode", Integer.valueOf(d(businessId))), new Pair("zplan_banner_avatar_sessionid", Long.valueOf(sessionId)), new Pair("zplan_costume_is_new", Integer.valueOf(b(updateToDate))));
        f("ev_zplan_avatar_static_picture", mutableMapOf);
    }

    private final int b(boolean change) {
        return change ? 1 : 0;
    }
}
