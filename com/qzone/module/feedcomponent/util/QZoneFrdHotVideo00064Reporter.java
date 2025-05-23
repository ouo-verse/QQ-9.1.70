package com.qzone.module.feedcomponent.util;

import com.qzone.reborn.runtime.QZoneRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\rH\u0007J\u0006\u0010\u0018\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/module/feedcomponent/util/QZoneFrdHotVideo00064Reporter;", "", "()V", "ACTION_TYPE", "", "RESERVES_FEED_CLK", "RESERVES_FEED_COMPLETE_EXP", "RESERVES_FEED_LIST_EXP", "RESERVES_FEED_START_EXP", "RESERVES_NEGATIVE_FEEDBACK", "RESERVES_RIGHT_MENU_CLK", "SUB_ACTION_TYPE", "TAG", "", "getSessionId", "reportFeedClick", "", "feedId", com.tencent.luggage.wxa.c8.c.G, "reportFeedCompleteExposure", "reportFeedListExposure", "reportFeedStartExposure", "reportNegativeFeedbackClick", "wording", "reportRightMenuClick", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class QZoneFrdHotVideo00064Reporter {
    private static final int ACTION_TYPE = 800;
    public static final QZoneFrdHotVideo00064Reporter INSTANCE = new QZoneFrdHotVideo00064Reporter();
    private static final int RESERVES_FEED_CLK = 4;
    private static final int RESERVES_FEED_COMPLETE_EXP = 3;
    private static final int RESERVES_FEED_LIST_EXP = 1;
    private static final int RESERVES_FEED_START_EXP = 2;
    private static final int RESERVES_NEGATIVE_FEEDBACK = 6;
    private static final int RESERVES_RIGHT_MENU_CLK = 5;
    private static final int SUB_ACTION_TYPE = 4;
    private static final String TAG = "QZoneFrdHotVideo00064Reporter";

    QZoneFrdHotVideo00064Reporter() {
    }

    private final String getSessionId() {
        String k3 = QZoneRuntime.j().k();
        Intrinsics.checkNotNullExpressionValue(k3, "g().qZoneSession");
        return k3;
    }

    @JvmStatic
    public static final void reportNegativeFeedbackClick(String wording) {
        Intrinsics.checkNotNullParameter(wording, "wording");
        QLog.i(TAG, 1, "reportNegativeFeedbackClick\uff0creserve3=" + wording);
        LpReportInfo_pf00064.allReport(800, 4, 6, "", wording);
    }

    public final void reportFeedClick(String feedId, int pos) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        String valueOf = String.valueOf(pos);
        String sessionId = getSessionId();
        QLog.i(TAG, 1, "reportFeedClick, reserve3=" + feedId + ", reserve4=" + valueOf + ", reserve5=" + sessionId);
        LpReportInfo_pf00064.allReport(800, 4, 4, "", feedId, valueOf, sessionId);
    }

    public final void reportFeedCompleteExposure(String feedId, int pos) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        String valueOf = String.valueOf(pos);
        String sessionId = getSessionId();
        QLog.i(TAG, 1, "reportFeedCompleteExposure, reserve3=" + feedId + ", reserve4=" + valueOf + ", reserve5=" + sessionId);
        LpReportInfo_pf00064.allReport(800, 4, 3, "", feedId, valueOf, sessionId);
    }

    public final void reportFeedListExposure() {
        String sessionId = getSessionId();
        QLog.i(TAG, 1, "reportFeedListExposure, reserves5=" + sessionId);
        LpReportInfo_pf00064.allReport(800, 4, 1, "", "", "", sessionId);
    }

    public final void reportFeedStartExposure(String feedId, int pos) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        String valueOf = String.valueOf(pos);
        String sessionId = getSessionId();
        QLog.i(TAG, 1, "reportFeedStartExposure, reserve3=" + feedId + ", reserve4=" + valueOf + ", reserve5=" + sessionId);
        LpReportInfo_pf00064.allReport(800, 4, 2, "", feedId, valueOf, sessionId);
    }

    public final void reportRightMenuClick() {
        QLog.i(TAG, 1, "reportRightMenuClick");
        LpReportInfo_pf00064.allReport(800, 4, 5);
    }
}
