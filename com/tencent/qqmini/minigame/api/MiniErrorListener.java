package com.tencent.qqmini.minigame.api;

import android.content.Context;
import com.tencent.mobileqq.triton.exception.ErrorSeverity;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqmini/minigame/api/MiniErrorListener;", "Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "context", "Landroid/content/Context;", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "(Landroid/content/Context;Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;)V", "notifyExit", "", "onError", "message", "", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "onScriptError", "stack", "Companion", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public abstract class MiniErrorListener implements ErrorCallback {
    private static final int JS_ERROR = 23;
    private static final String TAG = "TritonError";
    private final Context context;
    private final MiniAppInfo miniAppInfo;

    public MiniErrorListener(@NotNull Context context, @NotNull MiniAppInfo miniAppInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        this.context = context;
        this.miniAppInfo = miniAppInfo;
    }

    public abstract void notifyExit();

    @Override // com.tencent.mobileqq.triton.statistic.ErrorCallback
    public void onError(@NotNull String message, @NotNull TritonException exception) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        QMLog.e(TAG, "On TritonError " + message, exception);
        if (exception.getError().getSeverity().compareTo(ErrorSeverity.SEVER) >= 0 && GameWnsUtils.getGameErrorDialogEnable() && !GameWnsUtils.getGameErrorDialogIsBlack()) {
            ThreadManager.getUIHandler().post(new MiniErrorListener$onError$1(this));
            MiniReportManager.reportEventType(this.miniAppInfo, 1024, "1");
        }
    }

    @Override // com.tencent.mobileqq.triton.statistic.ErrorCallback
    public void onScriptError(@NotNull String message, @NotNull String stack) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(stack, "stack");
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 23, message + stack, "1");
        QMLog.e(TAG, "onScriptError: message=" + message + ", stack=" + stack);
    }
}
