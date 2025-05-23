package com.tencent.mobileqq.minigame.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.biz.qqcircle.widgets.a;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.data.MiniGameQCircleShareInfo;
import com.tencent.mobileqq.minigame.widget.MiniGameShareQCircleDialog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.net.URL;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameQCircleShareHelper {
    public static final String KEY_Q_CIRCLE_SHARE_INFO_APP_ID = "key_q_circle_share_info_app_id";
    public static final String KEY_Q_CIRCLE_SHARE_INFO_TAGS = "key_q_circle_share_info_tags";
    public static final String KEY_Q_CIRCLE_SHARE_INFO_TEXT = "key_q_circle_share_info_text";
    public static final String KEY_Q_CIRCLE_SHARE_INFO_VIDEO_PATH = "key_q_circle_share_info_video_path";
    public static final String TAG = "MiniGameQCircleShareHelper";
    private a qCirclePublishCallback;
    private int shareToQCircleCallbackId = -1;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface Callback {
        void onComplete(int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class ShareToQCircleEIPCResultCallback implements EIPCResultCallback {
        private final EIPCResultCallback callback;

        public ShareToQCircleEIPCResultCallback(EIPCResultCallback eIPCResultCallback) {
            this.callback = eIPCResultCallback;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            this.callback.onCallback(eIPCResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void callShareToQCircle(MiniGameShareQCircleDialog miniGameShareQCircleDialog, MiniGameQCircleShareInfo miniGameQCircleShareInfo, EIPCResultCallback eIPCResultCallback) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_Q_CIRCLE_SHARE_INFO_APP_ID, miniGameQCircleShareInfo.getMiniAppInfo() == null ? null : miniGameQCircleShareInfo.getMiniAppInfo().appId);
        bundle.putString(KEY_Q_CIRCLE_SHARE_INFO_VIDEO_PATH, miniGameQCircleShareInfo.getVideoPath());
        bundle.putString(KEY_Q_CIRCLE_SHARE_INFO_TEXT, miniGameQCircleShareInfo.getText());
        bundle.putString(KEY_Q_CIRCLE_SHARE_INFO_TAGS, miniGameQCircleShareInfo.getTag());
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_SHARE_TO_Q_CIRCLE, bundle, new ShareToQCircleEIPCResultCallback(eIPCResultCallback));
        miniGameShareQCircleDialog.dismiss();
    }

    private void checkAndRegisterQCircleCallback(final Callback callback) {
        if (this.qCirclePublishCallback == null) {
            this.qCirclePublishCallback = new a() { // from class: com.tencent.mobileqq.minigame.ui.MiniGameQCircleShareHelper.3
                @Override // com.tencent.biz.qqcircle.widgets.a
                public void onTaskStateChanged(TaskInfo taskInfo) {
                    QLog.d(MiniGameQCircleShareHelper.TAG, 1, "onTaskStateChanged: taskid:" + taskInfo.getTaskId() + " missionID:" + taskInfo.getMissionId() + " state:" + taskInfo.getState() + " progress:" + taskInfo.getUploadProgress() + " exportprogress:" + taskInfo.getExportProgress());
                    Bundle transParams = taskInfo.getTransParams();
                    int i3 = 2;
                    if (transParams != null && !transParams.isEmpty()) {
                        if (QCircleScheme.AttrQQPublish.BUSINESS_QQ_MINI_GAME.equals(transParams.getString("taskid"))) {
                            int i16 = MiniGameQCircleShareHelper.this.shareToQCircleCallbackId;
                            if (i16 == -1) {
                                QLog.w(MiniGameQCircleShareHelper.TAG, 2, "callbackId invalid");
                                return;
                            }
                            int state = taskInfo.getState();
                            if (state == 3) {
                                i3 = 0;
                            } else if (state != 5) {
                                if (state != 2) {
                                    return;
                                } else {
                                    i3 = 1;
                                }
                            }
                            try {
                                callback.onComplete(i16, i3);
                                QCirclePublishCallbackHelper.f93064a.v(this);
                                MiniGameQCircleShareHelper.this.shareToQCircleCallbackId = -1;
                                return;
                            } catch (Throwable th5) {
                                QLog.e(MiniGameQCircleShareHelper.TAG, 1, "notifyShareResult throw t:", th5);
                                return;
                            }
                        }
                        return;
                    }
                    QLog.w(MiniGameQCircleShareHelper.TAG, 2, "transParams invalid");
                }
            };
        }
        QCirclePublishCallbackHelper.f93064a.i(this.qCirclePublishCallback, true);
    }

    private static String getCacheFileByUrl(MiniAppFileManager miniAppFileManager, String str, String str2) {
        String str3;
        try {
            str3 = new URL(str2).getPath();
        } catch (Throwable th5) {
            QMLog.e(TAG, "getSuffixByPath error", th5);
            str3 = null;
        }
        if (TextUtils.isEmpty(str3)) {
            return miniAppFileManager.getTmpPathByUrl(str2);
        }
        return MiniAppFileManager.getPreCacheFilePath(str, str3);
    }

    public static boolean isLocalResourceExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static void showShareToQCircleDialog(Activity activity, IMiniAppContext iMiniAppContext, String str, final EIPCResultCallback eIPCResultCallback) {
        final MiniGameQCircleShareInfo structureShareInfo = structureShareInfo(str, iMiniAppContext);
        if (structureShareInfo == null) {
            QMLog.e(TAG, "showShareToQCircleDialog gameQCircleShareInfo is null");
            eIPCResultCallback.onCallback(EIPCResult.createResult(1, null));
            return;
        }
        final MiniGameShareQCircleDialog miniGameShareQCircleDialog = MiniGameShareQCircleDialog.getInstance(structureShareInfo);
        miniGameShareQCircleDialog.setNegativeClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.ui.MiniGameQCircleShareHelper.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EIPCResultCallback.this.onCallback(EIPCResult.createResult(2, null));
                miniGameShareQCircleDialog.dismiss();
            }
        });
        miniGameShareQCircleDialog.setPositiveClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.ui.MiniGameQCircleShareHelper.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MiniGameQCircleShareHelper.callShareToQCircle(MiniGameShareQCircleDialog.this, structureShareInfo, eIPCResultCallback);
            }
        });
        if ((activity instanceof QBaseActivity) && !activity.isFinishing() && !activity.isDestroyed()) {
            miniGameShareQCircleDialog.show(((QBaseActivity) activity).getSupportFragmentManager(), MiniGameShareQCircleDialog.TAG);
        } else {
            eIPCResultCallback.onCallback(EIPCResult.createResult(1, null));
        }
    }

    private static MiniGameQCircleShareInfo structureShareInfo(String str, IMiniAppContext iMiniAppContext) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MiniGameQCircleShareInfo miniGameQCircleShareInfo = new MiniGameQCircleShareInfo();
        miniGameQCircleShareInfo.setMiniAppInfo(iMiniAppContext.getMiniAppInfo());
        try {
            QLog.d(TAG, 4, "req.jsonParams: " + str);
            JSONObject jSONObject = new JSONObject(str);
            miniGameQCircleShareInfo.setText(jSONObject.optString("title"));
            miniGameQCircleShareInfo.setTag(jSONObject.optString("tagList"));
            miniGameQCircleShareInfo.setCover(jSONObject.optString("coverUrl"));
            String optString = jSONObject.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
            miniGameQCircleShareInfo.setVideo(optString);
            boolean isNetworkUrl = URLUtil.isNetworkUrl(optString);
            MiniAppFileManager miniAppFileManager = (MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class);
            int i3 = 1;
            if (!isNetworkUrl) {
                String absolutePath = miniAppFileManager.getAbsolutePath(optString);
                if (isLocalResourceExist(absolutePath)) {
                    miniGameQCircleShareInfo.setVideoPath(absolutePath);
                } else {
                    QMLog.e(TAG, "shareToQQCircle video not network url but video not exist, video:" + optString + ", abs path:" + absolutePath);
                    return null;
                }
            } else {
                String cacheFileByUrl = getCacheFileByUrl(miniAppFileManager, iMiniAppContext.getMiniAppInfo().appId, optString);
                miniGameQCircleShareInfo.setVideoPath(cacheFileByUrl);
                if (!new File(cacheFileByUrl).exists()) {
                    i3 = 2;
                }
            }
            miniGameQCircleShareInfo.setVideoState(i3);
            miniGameQCircleShareInfo.setLandscape(jSONObject.optBoolean(MiniChatConstants.MINI_APP_LANDSCAPE));
        } catch (Throwable th5) {
            QMLog.e(TAG, "structureShareInfo throw t:", th5);
        }
        return miniGameQCircleShareInfo;
    }

    public boolean doShareToQCircle(Bundle bundle, int i3, Callback callback) {
        if (bundle == null) {
            return false;
        }
        this.shareToQCircleCallbackId = i3;
        checkAndRegisterQCircleCallback(callback);
        String string = bundle.getString(KEY_Q_CIRCLE_SHARE_INFO_APP_ID);
        String string2 = bundle.getString(KEY_Q_CIRCLE_SHARE_INFO_VIDEO_PATH);
        String string3 = bundle.getString(KEY_Q_CIRCLE_SHARE_INFO_TEXT);
        String str = "mqqapi://qcircle/openqqpublish?&mediapath=" + string2 + ContainerUtils.FIELD_DELIMITER + "tag" + ContainerUtils.KEY_VALUE_DELIMITER + bundle.getString(KEY_Q_CIRCLE_SHARE_INFO_TAGS) + ContainerUtils.FIELD_DELIMITER + "target" + ContainerUtils.KEY_VALUE_DELIMITER + "4" + ContainerUtils.FIELD_DELIMITER + QCircleScheme.AttrQQPublish.MINI_GAME_ID + ContainerUtils.KEY_VALUE_DELIMITER + string + ContainerUtils.FIELD_DELIMITER + "content" + ContainerUtils.KEY_VALUE_DELIMITER + string3 + ContainerUtils.FIELD_DELIMITER + "taskid" + ContainerUtils.KEY_VALUE_DELIMITER + QCircleScheme.AttrQQPublish.BUSINESS_QQ_MINI_GAME + ContainerUtils.FIELD_DELIMITER + QCircleScheme.AttrQQPublish.BUSINESS_TASK_SHOW_BACK_DIALOG + ContainerUtils.KEY_VALUE_DELIMITER + "1" + ContainerUtils.FIELD_DELIMITER + QCircleScheme.AttrQQPublish.BUSINESS_TASK_NAME + "=\u5c0f\u6e38\u620f&xsj_operation_activity_id" + ContainerUtils.KEY_VALUE_DELIMITER + QCircleScheme.AttrQQPublish.BUSINESS_QQ_MINI_GAME + "&xsj_activity_id=" + QCircleScheme.AttrQQPublish.BUSINESS_QQ_MINI_GAME + "&appid=" + string;
        QLog.d(TAG, 4, "doShareToQCircle schema:" + str);
        QCircleSchemeLauncher.d(BaseApplication.getContext(), str);
        return true;
    }
}
