package com.tencent.qqmini.minigame.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.auth.a;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.widget.AppCloseDialog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.CapsuleButtonClickListener;
import java.io.Closeable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameCapsuleButtonClickListener extends CapsuleButtonClickListener {
    public static final String REPORT_ACTION_CLICK = "click";
    public static final String REPORT_ACTION_EXPO = "expo";
    public static final String REPORT_ACTION_TYPE = "sdk_popup";
    public static final String REPORT_SUB_ACTION_ACTION = "action";
    public static final String REPORT_SUB_ACTION_CLOSE = "close";
    public static final String REPORT_SUB_ACTION_POPUP = "popup";
    private static final String TAG = "GameCapsuleButton";

    public GameCapsuleButtonClickListener(IMiniAppContext iMiniAppContext) {
        super(iMiniAppContext);
    }

    private boolean checkIfShowAddRecentViewedColorPage() {
        a authChecker;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if ((iMiniAppContext instanceof GameRuntime) && (authChecker = ((GameRuntime) iMiniAppContext).getAuthChecker()) != null && authChecker.a(this)) {
            return authChecker.e();
        }
        return false;
    }

    public static boolean showAppCloseDialog(IMiniAppContext iMiniAppContext, final OnAppCloseAction onAppCloseAction) {
        Context attachActivity = iMiniAppContext.getAttachActivity();
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        if (attachActivity == null || miniAppInfo == null) {
            return false;
        }
        AppCloseDialog createAppCloseDialog = DialogUtil.createAppCloseDialog(attachActivity);
        FrameLayout frameLayout = new FrameLayout(attachActivity);
        View contentView = onAppCloseAction.getContentView(attachActivity, createAppCloseDialog);
        if (contentView != null) {
            frameLayout.addView(contentView, contentView.getLayoutParams());
        }
        createAppCloseDialog.setCancelable(false);
        createAppCloseDialog.setTitle((String) null).addView(frameLayout, new LinearLayout.LayoutParams(-1, -2));
        if (!TextUtils.isEmpty(onAppCloseAction.positiveButtonText)) {
            SDKMiniProgramLpReportDC04239.report(REPORT_ACTION_TYPE, "action", "expo", onAppCloseAction.positiveButtonExpoReportStr, null, null, false);
            createAppCloseDialog.setPositiveButton(onAppCloseAction.positiveButtonText, onAppCloseAction.positiveButtonColor, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.minigame.widget.GameCapsuleButtonClickListener.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    DialogInterface.OnClickListener onClickListener = OnAppCloseAction.this.positiveButtonListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(dialogInterface, i3);
                    }
                    SDKMiniProgramLpReportDC04239.report(GameCapsuleButtonClickListener.REPORT_ACTION_TYPE, "action", "click", OnAppCloseAction.this.positiveButtonClickReportStr, null, null, false);
                }
            });
        }
        if (!TextUtils.isEmpty(onAppCloseAction.negativeButtonText)) {
            SDKMiniProgramLpReportDC04239.report(REPORT_ACTION_TYPE, "close", "expo", onAppCloseAction.negativeButtonExpoReportStr, null, null, false);
            createAppCloseDialog.setNegativeButton(onAppCloseAction.negativeButtonText, onAppCloseAction.negativeButtonColor, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.minigame.widget.GameCapsuleButtonClickListener.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    DialogInterface.OnClickListener onClickListener = OnAppCloseAction.this.negativeButtonListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(dialogInterface, i3);
                    }
                    SDKMiniProgramLpReportDC04239.report(GameCapsuleButtonClickListener.REPORT_ACTION_TYPE, "close", "click", OnAppCloseAction.this.negativeButtonClickReportStr, null, null, false);
                }
            });
        }
        if (createAppCloseDialog.getWindow() != null) {
            createAppCloseDialog.getWindow().setLayout(onAppCloseAction.dialogWidth, onAppCloseAction.dialogHeight);
        }
        OnAppCloseAction.Action action = onAppCloseAction.appCloseAction;
        if (action != null) {
            action.onAppCloseClicked(createAppCloseDialog);
        }
        if (onAppCloseAction.appCloseActionType == 1) {
            SDKMiniProgramLpReportDC04239.report("page_view", "expo", "4001", null, null, null, false);
        }
        return true;
    }

    @Override // com.tencent.qqmini.sdk.widget.CapsuleButtonClickListener, com.tencent.qqmini.sdk.widget.CapsuleButton.CapsuleBtnClickListener
    public void onCloseClick() {
        QMLog.i(TAG, "on close click");
        if (checkIfShowAddRecentViewedColorPage()) {
            return;
        }
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        OnAppCloseAction onAppClose = miniAppProxy.onAppClose(this.mMiniAppContext.getMiniAppInfo(), new Closeable() { // from class: com.tencent.qqmini.minigame.widget.GameCapsuleButtonClickListener.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                GameCapsuleButtonClickListener.this.doClose();
            }
        });
        if (onAppClose != null) {
            SDKMiniProgramLpReportDC04239.report(REPORT_ACTION_TYPE, "popup", "expo", onAppClose.appCloseExpoReportStr, null, null, false);
            showAppCloseDialog(this.mMiniAppContext, onAppClose);
        } else if (this.mMiniAppContext.getMiniAppInfo() != null && !miniAppProxy.onCapsuleButtonCloseClick(this.mMiniAppContext, this.mDialogCloseListener)) {
            doClose();
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.CapsuleButtonClickListener, com.tencent.qqmini.sdk.widget.CapsuleButton.CapsuleBtnClickListener
    public void onMoreClick() {
        View findViewById;
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (attachActivity != null && (findViewById = attachActivity.findViewById(R.id.screen_record_entry_guide_bubble)) != null) {
            findViewById.setVisibility(8);
        }
        super.onMoreClick();
    }
}
