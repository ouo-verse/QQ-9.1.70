package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback;
import com.tencent.mobileqq.mini.server.MiniAppSSORequestClient;
import com.tencent.mobileqq.mini.server.MiniAppSSOResponse;
import com.tencent.mobileqq.mini.server.request.PCGuideConfirmRequest;
import com.tencent.mobileqq.minigame.report.MiniGamePCInstructionReport;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogForMiniGame;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import common.config.service.QzoneConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class GamePCInstructionManager {
    private static final int INSTRUCTION_DIALOG_BTN_HEIGHT_LANDSCAPE = 45;
    private static final int INSTRUCTION_DIALOG_BTN_HEIGHT_PORTRAIT = 52;
    private static final int INSTRUCTION_DIALOG_CONTENT_HEIGHT = 284;
    private static final int INSTRUCTION_DIALOG_CONTENT_WIDTH = 296;
    private static final String TAG = "GamePCInstructionManager";

    public static void handlePCInstructionConfirm(final Activity activity, final MiniAppInfo miniAppInfo, String str, String str2, final Boolean bool, final AsyncResult asyncResult) {
        MiniAppSSORequestClient.INSTANCE.sendReq(new PCGuideConfirmRequest(miniAppInfo.appId, str, str2, bool.booleanValue()), new MiniAppSSOReqCallback() { // from class: com.tencent.mobileqq.minigame.manager.p
            @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
            public final void onResponse(MiniAppSSOResponse miniAppSSOResponse) {
                GamePCInstructionManager.lambda$handlePCInstructionConfirm$0(AsyncResult.this, activity, miniAppInfo, bool, miniAppSSOResponse);
            }
        });
    }

    private static void initBtnLayout(QQCustomDialog qQCustomDialog, boolean z16) {
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_LEFT_BTN_BACKGROUND_URL, QzoneConfig.DEFAULT_VALUE_MINI_GAME_RETAIN_LEFT_BTN_BACKGROUND_URL);
        String config2 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_RIGHT_BTN_BACKGROUND_URL, QzoneConfig.DEFAULT_VALUE_MINI_GAME_RETAIN_RIGHT_BTN_BACKGROUND_URL);
        qQCustomDialog.getBtnight().setTypeface(Typeface.DEFAULT, 0);
        qQCustomDialog.getBtnight().setTextSize(1, 16.0f);
        qQCustomDialog.getBtnight().setTextColor(-1);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{MiniAppUtils.getDrawable(config, null), MiniAppUtils.getDrawable(config2, null)});
        layerDrawable.setLayerInset(0, 0, 0, ViewUtils.dpToPx(147.0f), 0);
        layerDrawable.setLayerInset(1, ViewUtils.dpToPx(147.0f), 0, 0, 0);
        qQCustomDialog.getBtnight().setBackground(layerDrawable);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) qQCustomDialog.getBtnight().getLayoutParams();
        layoutParams.height = ViewUtils.dpToPx(z16 ? 45 : 52);
        qQCustomDialog.getBtnight().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handlePCInstructionConfirm$0(AsyncResult asyncResult, final Activity activity, final MiniAppInfo miniAppInfo, final Boolean bool, MiniAppSSOResponse miniAppSSOResponse) {
        JSONObject jSONObject = new JSONObject();
        if (miniAppSSOResponse == null) {
            asyncResult.onReceiveResult(false, jSONObject);
            return;
        }
        boolean z16 = true;
        QLog.e(TAG, 1, "[pc instruction] PCGuideConfirmRequest retcode" + miniAppSSOResponse.getRetCode() + ", errMsg:" + miniAppSSOResponse.getErrMsg());
        try {
            if (miniAppSSOResponse.getRetCode() != 0) {
                z16 = false;
            }
            if (z16) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.GamePCInstructionManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GamePCInstructionManager.showPCInstructionSendSuccessDialog(activity, miniAppInfo, bool, null);
                        MiniGamePCInstructionReport.reportPCDialogSendResult(miniAppInfo, bool.booleanValue(), "1");
                    }
                });
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.GamePCInstructionManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(activity, 1, R.string.xz5, 0).show();
                        MiniGamePCInstructionReport.reportPCDialogSendResult(miniAppInfo, bool.booleanValue(), "2");
                    }
                });
            }
            jSONObject.put("errCode", miniAppSSOResponse.getRetCode());
            jSONObject.put("errMsg", miniAppSSOResponse.getErrMsg());
            asyncResult.onReceiveResult(z16, jSONObject);
        } catch (JSONException e16) {
            QMLog.e(TAG, "SignToSRsp: json exception:", e16);
            asyncResult.onReceiveResult(false, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showPCInstructionSendDialog$1(MiniAppInfo miniAppInfo, Boolean bool, DialogInterface.OnClickListener onClickListener, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        MiniGamePCInstructionReport.reportPCDialogEvent(miniAppInfo, "em_click", bool.booleanValue(), "3");
        dialogInterface.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(qQCustomDialog, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showPCInstructionSendSuccessDialog$2(MiniAppInfo miniAppInfo, Boolean bool, DialogInterface.OnClickListener onClickListener, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        MiniGamePCInstructionReport.reportPCDialogEvent(miniAppInfo, "em_click", bool.booleanValue(), "3");
        dialogInterface.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(qQCustomDialog, 1);
        }
    }

    public static void showPCInstructionDialog(Activity activity, MiniAppInfo miniAppInfo, Boolean bool, Boolean bool2, DialogInterface.OnClickListener onClickListener) {
        QLog.e(TAG, 1, "[pc instruction] showPCInstructionDialog hasSend:" + bool);
        if (bool.booleanValue()) {
            showPCInstructionSendSuccessDialog(activity, miniAppInfo, bool2, onClickListener);
        } else {
            showPCInstructionSendDialog(activity, miniAppInfo, bool2, onClickListener);
        }
    }

    private static void showPCInstructionSendDialog(Activity activity, final MiniAppInfo miniAppInfo, final Boolean bool, final DialogInterface.OnClickListener onClickListener) {
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_BACKGROUND_URL, QzoneConfig.DEFAULT_VALUE_MINI_GAME_RETAIN_BACKGROUND_URL);
        final QQCustomDialogForMiniGame qQCustomDialogForMiniGame = new QQCustomDialogForMiniGame(activity, R.style.ayi);
        qQCustomDialogForMiniGame.setContentView(R.layout.fi8);
        qQCustomDialogForMiniGame.setBodyLayoutNoMargin();
        qQCustomDialogForMiniGame.setBackground(R.drawable.f161087k05);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dk8, (ViewGroup) null, false);
        inflate.findViewById(R.id.rec).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GamePCInstructionManager.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QQCustomDialog.this.dismiss();
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(QQCustomDialog.this, 0);
                }
                MiniGamePCInstructionReport.reportPCDialogEvent(miniAppInfo, "em_click", bool.booleanValue(), "1");
            }
        });
        int requestedOrientation = activity.getRequestedOrientation();
        boolean z16 = requestedOrientation == 0 || requestedOrientation == 8 || requestedOrientation == 6 || requestedOrientation == 11;
        inflate.setBackground(MiniAppUtils.getDrawable(config, null));
        ((TextView) inflate.findViewById(R.id.rlu)).setText(R.string.xz7);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ri6);
        linearLayout.removeAllViews();
        linearLayout.setBackgroundResource(R.drawable.iq_);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(296.0f), ViewUtils.dpToPx(210.0f));
        layoutParams.gravity = 17;
        qQCustomDialogForMiniGame.setCancelable(false);
        qQCustomDialogForMiniGame.setTitle((String) null).setMessage((CharSequence) null).addView(inflate, layoutParams).setPositiveButton(R.string.f169856xz4, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GamePCInstructionManager.lambda$showPCInstructionSendDialog$1(MiniAppInfo.this, bool, onClickListener, qQCustomDialogForMiniGame, dialogInterface, i3);
            }
        }, false);
        initBtnLayout(qQCustomDialogForMiniGame, z16);
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        qQCustomDialogForMiniGame.show();
        MiniGamePCInstructionReport.reportPCDialogEvent(miniAppInfo, "em_expo", bool.booleanValue(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showPCInstructionSendSuccessDialog(Activity activity, final MiniAppInfo miniAppInfo, final Boolean bool, final DialogInterface.OnClickListener onClickListener) {
        String config = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_BACKGROUND_URL, QzoneConfig.DEFAULT_VALUE_MINI_GAME_RETAIN_BACKGROUND_URL);
        final QQCustomDialogForMiniGame qQCustomDialogForMiniGame = new QQCustomDialogForMiniGame(activity, R.style.ayi);
        qQCustomDialogForMiniGame.setContentView(R.layout.fi8);
        qQCustomDialogForMiniGame.setBodyLayoutNoMargin();
        qQCustomDialogForMiniGame.setBackground(R.drawable.f161087k05);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dk8, (ViewGroup) null, false);
        inflate.findViewById(R.id.rec).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.GamePCInstructionManager.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                QQCustomDialog.this.dismiss();
                DialogInterface.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(QQCustomDialog.this, 0);
                }
                MiniGamePCInstructionReport.reportPCDialogEvent(miniAppInfo, "em_click", bool.booleanValue(), "1");
            }
        });
        int requestedOrientation = activity.getRequestedOrientation();
        boolean z16 = requestedOrientation == 0 || requestedOrientation == 8 || requestedOrientation == 6 || requestedOrientation == 11;
        inflate.setBackground(MiniAppUtils.getDrawable(config, null));
        ((TextView) inflate.findViewById(R.id.rlu)).setText(R.string.xz6);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(296.0f), ViewUtils.dpToPx(284.0f));
        layoutParams.gravity = 17;
        qQCustomDialogForMiniGame.setCancelable(false);
        qQCustomDialogForMiniGame.setTitle((String) null).setMessage((CharSequence) null).addView(inflate, layoutParams).setPositiveButton(R.string.f169856xz4, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.minigame.manager.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GamePCInstructionManager.lambda$showPCInstructionSendSuccessDialog$2(MiniAppInfo.this, bool, onClickListener, qQCustomDialogForMiniGame, dialogInterface, i3);
            }
        }, false);
        initBtnLayout(qQCustomDialogForMiniGame, z16);
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        qQCustomDialogForMiniGame.show();
        MiniGamePCInstructionReport.reportPCDialogEvent(miniAppInfo, "em_expo", bool.booleanValue(), null);
    }
}
