package com.tencent.mobileqq.minigame.api;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.minigame.manager.GameReportManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.exception.ErrorSeverity;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/QQMiniErrorListener;", "Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "context", "Landroid/content/Context;", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "gameReportManager", "Lcom/tencent/mobileqq/minigame/manager/GameReportManager;", "(Landroid/content/Context;Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;Lcom/tencent/mobileqq/minigame/manager/GameReportManager;)V", "onError", "", "message", "", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "onScriptError", "stack", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQMiniErrorListener implements ErrorCallback {
    private static final int JS_ERROR = 23;
    private static final String TAG = "MiniErrorListener";
    private final Context context;
    private final GameReportManager gameReportManager;
    private final MiniAppConfig miniAppInfo;

    public QQMiniErrorListener(Context context, MiniAppConfig miniAppInfo, GameReportManager gameReportManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        Intrinsics.checkNotNullParameter(gameReportManager, "gameReportManager");
        this.context = context;
        this.miniAppInfo = miniAppInfo;
        this.gameReportManager = gameReportManager;
    }

    @Override // com.tencent.mobileqq.triton.statistic.ErrorCallback
    public void onError(String message, TritonException exception) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(exception, "exception");
        GameLog.getInstance().e(TAG, "On TritonError " + message, exception);
        if (exception.getError().getSeverity().compareTo(ErrorSeverity.SEVER) < 0 || !GameWnsUtils.getGameErrorDialogEnable() || GameWnsUtils.getGameErrorDialogIsBlack()) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.context, 230, (String) null, GameWnsUtils.getGameErrorDialogContent(), HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.ket), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.api.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQMiniErrorListener.onError$lambda$0(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.api.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQMiniErrorListener.onError$lambda$1(dialogInterface, i3);
            }
        });
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.show();
        MiniReportManager.reportEventType(this.miniAppInfo, 1024, "1");
    }

    @Override // com.tencent.mobileqq.triton.statistic.ErrorCallback
    public void onScriptError(String message, String stack) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(stack, "stack");
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 23, message + stack, "1");
        this.gameReportManager.onJsError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onError$lambda$0(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onError$lambda$1(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
