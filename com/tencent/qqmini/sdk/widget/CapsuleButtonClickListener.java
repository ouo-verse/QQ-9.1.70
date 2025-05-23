package com.tencent.qqmini.sdk.widget;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.action.HideInputAction;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NavigateBackUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.widget.CapsuleButton;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CapsuleButtonClickListener implements CapsuleButton.CapsuleBtnClickListener {
    static final String TAG = "CapsuleButton";
    protected IMiniAppContext mMiniAppContext;
    protected DialogInterface.OnClickListener mDialogCloseListener = new a();
    protected ShareProxy mShareProxy = (ShareProxy) ProxyManager.get(ShareProxy.class);

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            CapsuleButtonClickListener.this.doClose();
        }
    }

    public CapsuleButtonClickListener(IMiniAppContext iMiniAppContext) {
        this.mMiniAppContext = iMiniAppContext;
        preloadConvertSDK2QQConfig();
    }

    private void preloadConvertSDK2QQConfig() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null) {
            ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).synchConvertSDK2QQConfig(this.mMiniAppContext);
            QMLog.i("CapsuleButton", "preloadConvertSDK2QQConfig");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doClose() {
        MiniAppInfo miniAppInfo;
        LaunchParam launchParam;
        QMLog.i("CapsuleButton", "do close activity: " + this.mMiniAppContext.getAttachActivity());
        com.tencent.qqmini.sdk.utils.a.b(this.mMiniAppContext, MiniAppConst.RuntimeCloseType.CLOSE_BUTTON);
        if (this.mMiniAppContext.isMiniGame() && (miniAppInfo = this.mMiniAppContext.getMiniAppInfo()) != null && (launchParam = miniAppInfo.launchParam) != null && !TextUtils.isEmpty(launchParam.fromMiniAppId)) {
            NavigateBackUtils.writeTagAppid(miniAppInfo.launchParam.fromMiniAppId);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.CapsuleButton.CapsuleBtnClickListener
    public void onCloseClick() {
        QMLog.i("CapsuleButton", "onClose cllick: " + this.mMiniAppContext);
        if (this.mMiniAppContext.getMiniAppInfo() != null) {
            boolean onCapsuleButtonCloseClick = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonCloseClick(this.mMiniAppContext, this.mDialogCloseListener);
            QMLog.i("CapsuleButton", "do close handle: " + onCapsuleButtonCloseClick);
            if (!onCapsuleButtonCloseClick) {
                doClose();
            }
        }
        HideInputAction.hideInput(this.mMiniAppContext);
    }

    @Override // com.tencent.qqmini.sdk.widget.CapsuleButton.CapsuleBtnClickListener
    public void onMoreClick() {
        QMLog.i("CapsuleButton", "on more click");
        if (TextUtils.isEmpty(LoginManager.getInstance().getAccount())) {
            QMLog.e("CapsuleButton", "uin is empty, not show MoreClick. ");
            return;
        }
        ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
        if (obtain != null) {
            obtain.launchFrom = 0;
            obtain.stagingJsonParams = null;
        }
        this.mShareProxy.showSharePanel(this.mMiniAppContext);
        if (this.mMiniAppContext.getMiniAppInfo() != null) {
            ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).onCapsuleButtonMoreClick(this.mMiniAppContext);
        }
    }
}
