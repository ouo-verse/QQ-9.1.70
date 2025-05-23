package com.tencent.mobileqq.minigame.va.ui;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate;
import com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0017\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00101\u001a\u00020%\u00a2\u0006\u0004\b2\u00103J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/ui/MiniBoxVADownloadTipsDelegate;", "Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate;", "Lcom/tencent/qqmini/minigame/yungame/va/VAFloatDownloadTips$a;", "", "isWifi", "", VirtualAppProxy.KEY_GAME_ID, "", "showDownloadView", "Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate$a;", "clickListener", "setOperateClickListener", "updateWifiState", "", "state", "updateState", "resetDownloadProcess", "process", "", "downloadedSize", VirtualAppProxy.KEY_PKG_SIZE, "updateDownloadProcess", "getProcess", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "visibility", "updateVisibility", "getVisibility", "versionCode", "setGameVersionCode", "onCancelClick", "onContinueClick", "onRestartClick", "onRetryClick", "onStartDownloadClick", "onStopClick", "onDualChannelSwitch", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "gameActRef", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/minigame/va/ui/MiniBoxVAFloatDownloadTips;", "tipsView", "Lcom/tencent/mobileqq/minigame/va/ui/MiniBoxVAFloatDownloadTips;", "Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate$a;", "Lcom/tencent/mobileqq/minigame/va/ui/RestartConfirmHandler;", "restartConfirmHandler", "Lcom/tencent/mobileqq/minigame/va/ui/RestartConfirmHandler;", "Landroid/content/Context;", "hostContext", "gameActivity", "<init>", "(Landroid/content/Context;Landroid/app/Activity;)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniBoxVADownloadTipsDelegate implements IMiniBoxVADownloadTipsDelegate, VAFloatDownloadTips.a {
    private static final String TAG = "MiniBoxVADownloadTipsDelegate";
    private IMiniBoxVADownloadTipsDelegate.a clickListener;
    private final WeakReference<Activity> gameActRef;
    private RestartConfirmHandler restartConfirmHandler;
    private final MiniBoxVAFloatDownloadTips tipsView;

    public MiniBoxVADownloadTipsDelegate(Context hostContext, Activity gameActivity) {
        WindowManager windowManager;
        Intrinsics.checkNotNullParameter(hostContext, "hostContext");
        Intrinsics.checkNotNullParameter(gameActivity, "gameActivity");
        this.gameActRef = new WeakReference<>(gameActivity);
        MiniBoxVAFloatDownloadTips miniBoxVAFloatDownloadTips = new MiniBoxVAFloatDownloadTips(hostContext, gameActivity);
        this.tipsView = miniBoxVAFloatDownloadTips;
        miniBoxVAFloatDownloadTips.setOperateClickListener(this);
        miniBoxVAFloatDownloadTips.enableDualChannelTask(false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.x = DisplayUtil.dip2px(hostContext, 116.0f);
        layoutParams.y = DisplayUtil.dip2px(hostContext, 16.0f);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 8388661;
        layoutParams.flags = 1576;
        layoutParams.flags = 1576 | Integer.MIN_VALUE;
        layoutParams.format = 1;
        try {
            Window window = gameActivity.getWindow();
            if (window == null || (windowManager = window.getWindowManager()) == null) {
                return;
            }
            windowManager.addView(miniBoxVAFloatDownloadTips, layoutParams);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "windowManager add tips view throw:", th5);
        }
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public int getProcess() {
        return this.tipsView.getProcess();
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public int getVisibility() {
        return this.tipsView.getVisibility();
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onCancelClick() {
        IMiniBoxVADownloadTipsDelegate.a aVar = this.clickListener;
        if (aVar != null) {
            aVar.onCancelClick();
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onContinueClick() {
        IMiniBoxVADownloadTipsDelegate.a aVar = this.clickListener;
        if (aVar != null) {
            aVar.onContinueClick();
        }
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public void onDestroy() {
        Window window;
        WindowManager windowManager;
        this.tipsView.onDestroy();
        this.tipsView.setVisibility(8);
        try {
            Activity activity = this.gameActRef.get();
            if (activity != null && (window = activity.getWindow()) != null && (windowManager = window.getWindowManager()) != null) {
                windowManager.removeView(this.tipsView);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "windowManager remove tips view throw:", th5);
        }
        RestartConfirmHandler restartConfirmHandler = this.restartConfirmHandler;
        if (restartConfirmHandler != null) {
            restartConfirmHandler.onDestroy();
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onRestartClick() {
        Activity activity = this.gameActRef.get();
        if (activity != null) {
            if (this.restartConfirmHandler == null) {
                this.restartConfirmHandler = new RestartConfirmHandler();
            }
            RestartConfirmHandler restartConfirmHandler = this.restartConfirmHandler;
            if (restartConfirmHandler != null) {
                restartConfirmHandler.showConfirmDialog(activity, new RestartConfirmHandler.ConfirmDialogListener() { // from class: com.tencent.mobileqq.minigame.va.ui.MiniBoxVADownloadTipsDelegate$onRestartClick$1
                    @Override // com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler.ConfirmDialogListener
                    public void onNegativeClick() {
                        IMiniBoxVADownloadTipsDelegate.a aVar;
                        QLog.i("MiniBoxVADownloadTipsDelegate", 1, "onNegativeClick");
                        aVar = MiniBoxVADownloadTipsDelegate.this.clickListener;
                        if (aVar != null) {
                            aVar.onRestartClick();
                        }
                    }

                    @Override // com.tencent.mobileqq.minigame.va.ui.RestartConfirmHandler.ConfirmDialogListener
                    public void onPositiveClick() {
                        QLog.i("MiniBoxVADownloadTipsDelegate", 1, "onPositiveClick");
                    }
                });
                return;
            }
            return;
        }
        IMiniBoxVADownloadTipsDelegate.a aVar = this.clickListener;
        if (aVar != null) {
            aVar.onRestartClick();
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onRetryClick() {
        IMiniBoxVADownloadTipsDelegate.a aVar = this.clickListener;
        if (aVar != null) {
            aVar.onRetryClick();
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onStartDownloadClick() {
        IMiniBoxVADownloadTipsDelegate.a aVar = this.clickListener;
        if (aVar != null) {
            aVar.onStartDownloadClick();
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onStopClick() {
        IMiniBoxVADownloadTipsDelegate.a aVar = this.clickListener;
        if (aVar != null) {
            aVar.onStopClick();
        }
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public void resetDownloadProcess() {
        this.tipsView.resetDownloadProcess();
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public void setGameVersionCode(String versionCode) {
        this.tipsView.setGameVersionCode(versionCode);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public void setOperateClickListener(IMiniBoxVADownloadTipsDelegate.a clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public void showDownloadView(boolean isWifi, String gameId) {
        this.tipsView.bringToFront();
        this.tipsView.show(isWifi, null, gameId);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public void updateDownloadProcess(int process, long downloadedSize, long pkgSize) {
        this.tipsView.updateDownloadProcess(process, downloadedSize, pkgSize);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public void updateState(int state) {
        this.tipsView.updateState(state);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public void updateVisibility(int visibility) {
        this.tipsView.setVisibility(visibility);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public void updateWifiState(boolean isWifi) {
        this.tipsView.updateWifiState(isWifi);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate
    public void updateDownloadProcess(int process) {
        this.tipsView.updateDownloadProcess(process);
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips.a
    public void onDualChannelSwitch() {
    }
}
