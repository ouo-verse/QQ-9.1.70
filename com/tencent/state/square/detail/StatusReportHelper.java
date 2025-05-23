package com.tencent.state.square.detail;

import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/detail/StatusReportHelper;", "", "()V", "reportEndMultiDialogClick", "", "isConfirm", "", "isFromArk", "reportEndMultiDialogExposure", "reportExpiredMultiDialogClick", "reportExpiredMultiDialogExposure", "reportPublishSuccess", "scene", "Lcom/tencent/state/square/detail/StatusReportHelper$PublishScene;", "PublishScene", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class StatusReportHelper {
    public static final StatusReportHelper INSTANCE = new StatusReportHelper();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/detail/StatusReportHelper$PublishScene;", "", "(Ljava/lang/String;I)V", "SINGLE", "MULTI", "INVITE", "CONTINUE", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public enum PublishScene {
        SINGLE,
        MULTI,
        INVITE,
        CONTINUE
    }

    StatusReportHelper() {
    }

    public final void reportEndMultiDialogClick(boolean isConfirm, boolean isFromArk) {
        Map<String, Object> mutableMapOf;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, Integer.valueOf(isConfirm ? 1 : 0)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_SQUARE_POPUP_WINDOW_SOURCE, Integer.valueOf(isFromArk ? 1 : 0)));
        squareReporter.reportEvent("ev_zplan_double_pose_end_popup_window", mutableMapOf);
    }

    public final void reportEndMultiDialogExposure(boolean isFromArk) {
        Map<String, Object> mutableMapOf;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, 0), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_SQUARE_POPUP_WINDOW_SOURCE, Integer.valueOf(isFromArk ? 1 : 0)));
        squareReporter.reportEvent("ev_zplan_double_pose_end_popup_window", mutableMapOf);
    }

    public final void reportExpiredMultiDialogClick(boolean isConfirm, boolean isFromArk) {
        Map<String, Object> mutableMapOf;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, Integer.valueOf(isConfirm ? 1 : 0)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_SQUARE_POPUP_WINDOW_SOURCE, Integer.valueOf(isFromArk ? 1 : 0)));
        squareReporter.reportEvent("ev_zplan_double_pose_expired_popup_window", mutableMapOf);
    }

    public final void reportExpiredMultiDialogExposure(boolean isFromArk) {
        Map<String, Object> mutableMapOf;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, 0), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_SQUARE_POPUP_WINDOW_SOURCE, Integer.valueOf(isFromArk ? 1 : 0)));
        squareReporter.reportEvent("ev_zplan_double_pose_expired_popup_window", mutableMapOf);
    }

    public final void reportPublishSuccess(PublishScene scene) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(scene, "scene");
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_state_publish_succeed_type", Integer.valueOf(scene.ordinal())));
        squareReporter.reportEvent("ev_zplan_publish_succeed_tips", mutableMapOf);
    }
}
