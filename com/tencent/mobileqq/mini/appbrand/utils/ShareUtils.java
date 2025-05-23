package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.utils.ShareUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.minigame.share.MiniGameGetShareArkRequest;
import com.tencent.mobileqq.minigame.share.MiniGameShareGamePicWithTailRequest;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareQQArkHelper;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import com.tencent.qzonehub.api.IQzoneShareApi;
import cooperation.qzone.QZoneHelper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.ByteArrayOutputStream;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ShareUtils {
    public static final String KEY_MINI_REPORT_EVENT_ACTION_TYPE = "key_mini_report_event_action_type";
    public static final String KEY_MINI_REPORT_EVENT_RESERVES = "key_mini_report_event_reserves";
    public static final String KEY_MINI_REPORT_EVENT_RESERVES2 = "key_mini_report_event_reserves2";
    public static final String KEY_MINI_REPORT_EVENT_SUB_ACTION_TYPE = "key_mini_report_event_sub_action_type";
    private static final int REQ_CODE_SHARE_PIC_TO_QQ = 1010;
    public static final int REQ_CODE_SHARE_PIC_WITH_TAIL_TO_QQ = 1011;
    public static final String TAG = "ShareUtils";
    private static QQProgressDialog sGameStructShareLoadingDialog;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class EIPCResultCallbackListener implements EIPCResultCallback {
        private WeakReference<Activity> mActivity;
        private AsyncResult mAsyncResult;
        private WeakReference<InnerShareData> mShareData;

        public EIPCResultCallbackListener(Activity activity, InnerShareData innerShareData, AsyncResult asyncResult) {
            this.mActivity = new WeakReference<>(activity);
            this.mShareData = new WeakReference<>(innerShareData);
            this.mAsyncResult = asyncResult;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            String string = eIPCResult.data.getString("preview");
            QLog.d(ShareUtils.TAG, 1, "shareGameStructMsgToQQ upload newImagePath=", string);
            InnerShareData innerShareData = this.mShareData.get();
            if (TextUtils.isEmpty(string) || this.mActivity.get() == null || innerShareData == null) {
                ShareUtils.dismissGameStructShareProgressDialog();
                DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, -1000710003L, HardCodeUtil.qqStr(R.string.hix), 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errMsg", "\u56fe\u7247\u4e0a\u4f20\u5931\u8d25\u3002");
                    this.mAsyncResult.onReceiveResult(false, jSONObject);
                    return;
                } catch (Exception e16) {
                    QLog.e(ShareUtils.TAG, 1, "shareGameStructMsgToQQ resultJsonObj exception=", e16);
                    return;
                }
            }
            innerShareData.sharePicPath = "https://" + string;
            ShareUtils.shareGameStructMessageToQQFromArkJson(this.mActivity.get(), innerShareData, this.mAsyncResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface ShareSimpleCallback {
        void notifyShareResult(int i3);

        void onReceiverChoice(String str);
    }

    private static void choiceFriend(Activity activity, ResultReceiver resultReceiver) {
        Parcel obtain = Parcel.obtain();
        resultReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        intent.putExtra("forward_type", 15);
        intent.putExtra("choose_friend_title", "\u53d1\u9001\u7ed9");
        intent.putExtra("choose_friend_is_qqfriends", true);
        intent.putExtra("choose_friend_is_contacts", true);
        intent.putExtra("choose_friend_is_groupchats", true);
        intent.putExtra("choose_friend_is_create_group_chat", true);
        intent.putExtra("choose_friend_callback", resultReceiver2);
        ICommonManager commonManager = AppLoaderFactory.g().getCommonManager();
        if (commonManager != null) {
            commonManager.addActivityResultListener(new IActivityResultListener(resultReceiver) { // from class: com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.3
                private final WeakReference<ResultReceiver> reference;
                final /* synthetic */ ResultReceiver val$chooseFriendReceiver;

                {
                    this.val$chooseFriendReceiver = resultReceiver;
                    this.reference = new WeakReference<>(resultReceiver);
                }

                @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
                public boolean doOnActivityResult(int i3, int i16, Intent intent2) {
                    if (i3 != 1011) {
                        return false;
                    }
                    ResultReceiver resultReceiver3 = this.reference.get();
                    if (i16 == 0 && resultReceiver3 != null) {
                        resultReceiver3.send(-1, null);
                    }
                    QLog.i(ShareUtils.TAG, 2, "share game pic with tail on act result:" + i16);
                    ICommonManager commonManager2 = AppLoaderFactory.g().getCommonManager();
                    if (commonManager2 == null) {
                        return true;
                    }
                    commonManager2.removeActivityResultListener(this);
                    return true;
                }
            });
        }
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, 1011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dismissGameStructShareProgressDialog() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.l
            @Override // java.lang.Runnable
            public final void run() {
                ShareUtils.lambda$dismissGameStructShareProgressDialog$5();
            }
        });
    }

    public static String getFileUri(Context context, String str) {
        File file = new File(str);
        Uri uri = null;
        if (!file.exists()) {
            return null;
        }
        try {
            uri = FileProvider.getUriForFile(context, "com.tencent.mobileqq.fileprovider", file);
            context.grantUriPermission("com.tencent.mm", uri, 1);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getFileUri failed with exception:", e16);
            e16.printStackTrace();
        }
        return uri != null ? uri.toString() : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dismissGameStructShareProgressDialog$5() {
        try {
            QQProgressDialog qQProgressDialog = sGameStructShareLoadingDialog;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
                sGameStructShareLoadingDialog = null;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "dismissGameStructShareProgressDialog exception=", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$shareGamePicWithTail2QQ$0(Activity activity, ShareSimpleCallback shareSimpleCallback, final String str, EIPCResult eIPCResult) {
        final String str2 = "https://" + eIPCResult.data.getString("preview");
        QLog.d(TAG, 1, "shareGamePicWithTail upload imagePath=", str2);
        choiceFriend(activity, new ChooseSingleFriendReceiver(shareSimpleCallback, null, activity) { // from class: com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.2
            @Override // com.tencent.mobileqq.mini.appbrand.utils.ChooseSingleFriendReceiver
            public void onShareReceiverObtain(ShareSimpleCallback shareSimpleCallback2, ShareReceiver shareReceiver) {
                ShareLoadingUtils.dismissShareProgressDialog();
                if (shareSimpleCallback2 != null) {
                    shareSimpleCallback2.onReceiverChoice(null);
                }
                if (shareReceiver != null) {
                    ShareUtils.shareGamePicWithTailRequest(str, str2, shareReceiver, shareSimpleCallback2);
                    safeToastResult(true);
                } else if (shareSimpleCallback2 != null) {
                    shareSimpleCallback2.notifyShareResult(1);
                    safeToastResult(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$shareGamePicWithTail2QQ$1(String str, String str2, ShareReceiver shareReceiver, ShareSimpleCallback shareSimpleCallback, EIPCResult eIPCResult) {
        QLog.d(TAG, 1, "shareGamePicWithTail upload imagePath=", "https://" + eIPCResult.data.getString("preview"));
        shareGamePicWithTailRequest(str, str2, shareReceiver, shareSimpleCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$shareGamePicWithTailRequest$2(ShareSimpleCallback shareSimpleCallback, MiniGameShareGamePicWithTailRequest miniGameShareGamePicWithTailRequest, Boolean bool, Boolean bool2) {
        int i3 = 1;
        QLog.i(TAG, 1, "shareGamePicWithTailRequest reqSuccess:" + bool + ", sendSuccess:" + bool2);
        if (bool.booleanValue() && bool2.booleanValue()) {
            i3 = 0;
        }
        shareSimpleCallback.notifyShareResult(i3);
        miniGameShareGamePicWithTailRequest.setListener(null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showGameStructShareProgressDialog$4(Activity activity) {
        try {
            QQProgressDialog qQProgressDialog = sGameStructShareLoadingDialog;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            QQProgressDialog qQProgressDialog2 = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            sGameStructShareLoadingDialog = qQProgressDialog2;
            qQProgressDialog2.setMessage(R.string.pe_);
            sGameStructShareLoadingDialog.show();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "showGameStructShareProgressDialog exception=", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startLinkToWeChat$8(String str, boolean z16, String str2, String str3, String str4) {
        try {
            Bitmap compressBitmapForWXShare = compressBitmapForWXShare(ImageUtil.getLocalBitmap(str));
            if (z16) {
                WXShareHelper.b0().M0(String.valueOf(System.currentTimeMillis()), str2, compressBitmapForWXShare, str3, str4);
            } else {
                WXShareHelper.b0().N0(String.valueOf(System.currentTimeMillis()), str2, compressBitmapForWXShare, str3, str4);
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "startLinkToWeChat exception:", e16);
        }
    }

    public static void shareGamePicWithTail2QQ(final Activity activity, final String str, String str2, final ShareSimpleCallback shareSimpleCallback) {
        ShareLoadingUtils.showShareProgressDialog(activity);
        Bundle bundle = new Bundle();
        bundle.putString("preview", str2);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_UPLOAD_IMAGE, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.mini.appbrand.utils.o
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                ShareUtils.lambda$shareGamePicWithTail2QQ$0(activity, shareSimpleCallback, str, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void shareGamePicWithTailRequest(String str, String str2, ShareReceiver shareReceiver, final ShareSimpleCallback shareSimpleCallback) {
        final MiniGameShareGamePicWithTailRequest miniGameShareGamePicWithTailRequest = new MiniGameShareGamePicWithTailRequest();
        if (shareSimpleCallback != null) {
            miniGameShareGamePicWithTailRequest.setListener(new Function2() { // from class: com.tencent.mobileqq.mini.appbrand.utils.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda$shareGamePicWithTailRequest$2;
                    lambda$shareGamePicWithTailRequest$2 = ShareUtils.lambda$shareGamePicWithTailRequest$2(ShareUtils.ShareSimpleCallback.this, miniGameShareGamePicWithTailRequest, (Boolean) obj, (Boolean) obj2);
                    return lambda$shareGamePicWithTailRequest$2;
                }
            });
        }
        miniGameShareGamePicWithTailRequest.shareGamePicWithTail(str, str2, shareReceiver.getScene(), shareReceiver.getReceiver());
    }

    public static void shareGamePicture2QQ(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        bundle.putBoolean("key_flag_from_plugin", true);
        bundle.putBoolean("forward_photo_shortvideo_is_edited", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentActivity.class, 1010, -1, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void shareGameStructMessageToQQFromArkJson(final Activity activity, final InnerShareData innerShareData, final AsyncResult asyncResult) {
        final MiniAppInfo miniAppInfo = innerShareData.getMiniAppInfo();
        if (miniAppInfo == null) {
            QLog.d(TAG, 1, "shareGameStructMessageToQQFromArkJson miniAppInfo null");
            return;
        }
        final String str = miniAppInfo.appId;
        final MiniGameGetShareArkRequest miniGameGetShareArkRequest = new MiniGameGetShareArkRequest();
        miniGameGetShareArkRequest.setListener(new Function2() { // from class: com.tencent.mobileqq.mini.appbrand.utils.g
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit lambda$shareGameStructMessageToQQFromArkJson$3;
                lambda$shareGameStructMessageToQQFromArkJson$3 = ShareUtils.lambda$shareGameStructMessageToQQFromArkJson$3(MiniGameGetShareArkRequest.this, asyncResult, activity, str, innerShareData, miniAppInfo, (Boolean) obj, (String) obj2);
                return lambda$shareGameStructMessageToQQFromArkJson$3;
            }
        });
        miniGameGetShareArkRequest.getArkJson(str, innerShareData.title, innerShareData.summary, innerShareData.targetUrl, innerShareData.sharePicPath);
    }

    public static void shareGameStructMsgToQQ(Activity activity, InnerShareData innerShareData, AsyncResult asyncResult) {
        showGameStructShareProgressDialog(activity);
        Bundle bundle = new Bundle();
        bundle.putString("preview", innerShareData.sharePicPath);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_UPLOAD_IMAGE, bundle, new EIPCResultCallbackListener(activity, innerShareData, asyncResult));
    }

    private static void showGameStructShareProgressDialog(final Activity activity) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.n
            @Override // java.lang.Runnable
            public final void run() {
                ShareUtils.lambda$showGameStructShareProgressDialog$4(activity);
            }
        });
    }

    public static void startSharePicToQQ(Activity activity, String str) {
        startSharePicToQQ(activity, str, null);
    }

    public static void startSharePicToQzone(Activity activity, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startSharePicToQzone. localPicPath=" + str);
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        QZoneHelper.forwardToPublishMood(activity, userInfo, str, str2, "", -1);
        Bundle bundle = new Bundle();
        bundle.putString("key_mini_report_event_action_type", "user_click");
        bundle.putString("key_mini_report_event_sub_action_type", "custom_button");
        bundle.putString("key_mini_report_event_reserves", "share_QZ");
        bundle.putString("key_mini_report_event_reserves2", "success");
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_REPORT_EVENT, bundle, null);
    }

    public static void startSharePicToWeChat(final Activity activity, String str, boolean z16) {
        if (!WXShareHelper.b0().e0()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.4
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(activity, 0, R.string.f173257ih1, 1).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            });
            return;
        }
        if (!WXShareHelper.b0().f0()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.5
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(activity, 0, R.string.f173258ih2, 1).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            if (z16) {
                WXShareHelper.b0().u0(str, decodeFile, 0);
            } else {
                WXShareHelper.b0().u0(str, decodeFile, 1);
            }
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$shareGameStructMessageToQQFromArkJson$3(MiniGameGetShareArkRequest miniGameGetShareArkRequest, AsyncResult asyncResult, Activity activity, String str, InnerShareData innerShareData, MiniAppInfo miniAppInfo, Boolean bool, String str2) {
        JSONObject jSONObject;
        QLog.d(TAG, 1, "shareGameStructMessageToQQFromArkJson get ark json result=", bool);
        dismissGameStructShareProgressDialog();
        miniGameGetShareArkRequest.setListener(null);
        if (!bool.booleanValue()) {
            DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, -1000710003L, HardCodeUtil.qqStr(R.string.hix), 0);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errMsg", "\u83b7\u53d6Ark Json\u5931\u8d25\u3002");
                asyncResult.onReceiveResult(false, jSONObject2);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "shareGameStructMessageToQQFromArkJson resultJsonObj exception=", e16);
            }
            return null;
        }
        try {
            jSONObject = new JSONObject(str2);
            try {
                jSONObject.put("needShareCallBack", true);
            } catch (Exception e17) {
                e = e17;
                QLog.e(TAG, 1, "shareGameStructMessageToQQFromArkJson resultJsonObj exception2=", e);
                if (jSONObject == null) {
                }
                QLog.d(TAG, 1, "shareGameStructMessageToQQFromArkJson arkJsonObj null");
                DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, -1000710003L, HardCodeUtil.qqStr(R.string.hix), 0);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("errMsg", "\u89e3\u6790Ark Json\u5931\u8d25\u3002");
                    asyncResult.onReceiveResult(false, jSONObject3);
                } catch (Exception e18) {
                    QLog.e(TAG, 1, "shareGameStructMessageToQQFromArkJson resultJsonObj exception3=", e18);
                }
                return null;
            }
        } catch (Exception e19) {
            e = e19;
            jSONObject = null;
        }
        if (jSONObject == null && activity != null) {
            ShareQQArkHelper.l(activity, new MiniArkShareModelBuilder().setAppId(str).setTitle(innerShareData.title).setDescription(innerShareData.summary).setShareScene(innerShareData.shareScene).setShareTemplateType(1).setShareBusinessType(miniAppInfo.getReportType()).setPicUrl(innerShareData.sharePicPath).setVidUrl(null).setJumpUrl(innerShareData.targetUrl).setIconUrl(miniAppInfo.iconUrl).setVersionType(miniAppInfo.verType).setVersionId(miniAppInfo.versionId).setWebURL(innerShareData.webURL).setTemplateId(innerShareData.templateId).setTemplateData(innerShareData.templateData).setShareTarget(innerShareData.shareTarget).setRcvOpenId(innerShareData.recvOpenId).setWithShareTicket(innerShareData.withShareTicket).setMiniAppShareFrom(innerShareData.shareSource).setExtInfo(innerShareData.extInfo).createMiniArkShareModel(), jSONObject, innerShareData.shareTarget);
            asyncResult.onReceiveResult(true, null);
        } else {
            QLog.d(TAG, 1, "shareGameStructMessageToQQFromArkJson arkJsonObj null");
            DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, -1000710003L, HardCodeUtil.qqStr(R.string.hix), 0);
            JSONObject jSONObject32 = new JSONObject();
            jSONObject32.put("errMsg", "\u89e3\u6790Ark Json\u5931\u8d25\u3002");
            asyncResult.onReceiveResult(false, jSONObject32);
        }
        return null;
    }

    public static void startSharePicToQQ(final Activity activity, String str, ShareChatModel shareChatModel) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startSharePicToQQ. localPicPath=" + str);
        }
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, str);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        AppLoaderFactory.g().getCommonManager().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.1
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                AppLoaderFactory.g().getCommonManager().removeActivityResultListener(this);
                return ShareUtils.doOnSharePicActivityResult(activity, i3, i16, intent);
            }
        });
        if (shareChatModel == null) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            ForwardBaseOption.startForwardActivityForResult(activity, intent, 1010);
            return;
        }
        MiniProgramShareUtils.shareToChatDirectly(activity, bundle, shareChatModel.type, String.valueOf(shareChatModel.uin), shareChatModel.name, 1010, true);
    }

    public static void startLinkToWeChat(final Activity activity, final String str, final String str2, final String str3, final String str4, final boolean z16) {
        QLog.d(TAG, 1, "startLinkToWeChat activity=", activity, ", title=", str, ", desc=", str2, ", localPicPath=", str3, ", link=", str4, ", toSession=", Boolean.valueOf(z16));
        if (!WXShareHelper.b0().e0()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.i
                @Override // java.lang.Runnable
                public final void run() {
                    ShareUtils.lambda$startLinkToWeChat$6(activity);
                }
            });
        } else if (!WXShareHelper.b0().f0()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.j
                @Override // java.lang.Runnable
                public final void run() {
                    ShareUtils.lambda$startLinkToWeChat$7(activity);
                }
            });
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.k
                @Override // java.lang.Runnable
                public final void run() {
                    ShareUtils.lambda$startLinkToWeChat$8(str3, z16, str, str2, str4);
                }
            }, 64, null, true);
        }
    }

    public static void startShareToQzone(Activity activity, String str, String str2, String str3, ApkgInfo apkgInfo, boolean z16) {
        String str4;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startShareToQzone. content=");
            str4 = str;
            sb5.append(str4);
            sb5.append(",sharePicPath=");
            sb5.append(str2);
            sb5.append(",entryPath=");
            sb5.append(str3);
            QLog.d(TAG, 2, sb5.toString());
        } else {
            str4 = str;
        }
        String str5 = TextUtils.isEmpty(str) ? apkgInfo.appConfig.config.desc : str4;
        IQzoneShareApi iQzoneShareApi = (IQzoneShareApi) QRoute.api(IQzoneShareApi.class);
        com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo = apkgInfo.appConfig.config;
        String str6 = miniAppInfo.appId;
        String str7 = apkgInfo.apkgName;
        int reportType = miniAppInfo.getReportType();
        String str8 = apkgInfo.iconUrl;
        com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo2 = apkgInfo.appConfig.config;
        iQzoneShareApi.shareQzoneForMini(activity, str6, str7, str5, 1, 1, reportType, str2, str3, str8, miniAppInfo2.verType, miniAppInfo2.versionId, z16, 0);
    }

    public static Bitmap compressBitmapForWXShare(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        QLog.d(TAG, 1, "compressBitmapForWXShare. ImageUtil.drawableToBitmap, out.toByteArray().length original:" + byteArray.length);
        Bitmap bitmap2 = bitmap;
        int i3 = 0;
        while (i3 < 10 && byteArray.length > 32768) {
            Matrix matrix = new Matrix();
            matrix.setScale(0.7f, 0.7f);
            bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
            byteArray = byteArrayOutputStream2.toByteArray();
            i3++;
            QLog.d(TAG, 1, "compressBitmapForWXShare. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:" + byteArray.length);
        }
        QLog.d(TAG, 1, "compressBitmapForWXShare. ImageUtil.drawableToBitmap, out.toByteArray().length done:" + byteArray.length);
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static void shareGamePicWithTail2QQ(final String str, final String str2, final ShareReceiver shareReceiver, final ShareSimpleCallback shareSimpleCallback) {
        Bundle bundle = new Bundle();
        bundle.putString("preview", str2);
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_UPLOAD_IMAGE, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.mini.appbrand.utils.h
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                ShareUtils.lambda$shareGamePicWithTail2QQ$1(str, str2, shareReceiver, shareSimpleCallback, eIPCResult);
            }
        });
    }

    public static void startShareToWeChat(final Activity activity, String str, final String str2, String str3, final int i3, final ApkgInfo apkgInfo) {
        String str4;
        if (!WXShareHelper.b0().e0()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.6
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(activity, 0, R.string.f173257ih1, 1).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            });
            return;
        }
        if (!WXShareHelper.b0().f0()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.7
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(activity, 0, R.string.f173258ih2, 1).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startShareToWeChat. content=");
            str4 = str;
            sb5.append(str4);
            sb5.append(",sharePicPath=");
            sb5.append(str2);
            sb5.append(",entryPath=");
            sb5.append(str3);
            QLog.d(TAG, 2, sb5.toString());
        } else {
            str4 = str;
        }
        if (apkgInfo == null) {
            QLog.e(TAG, 1, "startShareToWeChat. apkgInfo is null!");
            return;
        }
        String str5 = TextUtils.isEmpty(str) ? apkgInfo.appConfig.config.desc : str4;
        com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo = apkgInfo.appConfig.config;
        String str6 = miniAppInfo.appId;
        String str7 = apkgInfo.apkgName;
        int reportType = miniAppInfo.getReportType();
        String str8 = apkgInfo.iconUrl;
        com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo2 = apkgInfo.appConfig.config;
        final String str9 = str5;
        MiniProgramShareUtils.shareAsWeChatMsg(str6, str7, str5, 1, 1, reportType, str2, null, str3, str8, miniAppInfo2.verType, miniAppInfo2.versionId, null, i3, 0, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.8
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                final long j3;
                final String str10;
                Bitmap drawableToBitmap;
                QLog.d(ShareUtils.TAG, 1, "startShareToWeChat. isSuc:" + z16);
                boolean z17 = false;
                if (z16 && jSONObject != null) {
                    String optString = jSONObject.optString("jump_url");
                    if (jSONObject.optBoolean("needShareCallBack", false)) {
                        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK, null, null);
                    }
                    try {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        Activity activity2 = activity;
                        if (activity2 != null) {
                            obtain.mFailedDrawable = activity2.getResources().getDrawable(R.drawable.n1m);
                        }
                        drawableToBitmap = ImageUtil.drawableToBitmap(URLDrawable.getDrawable(str2, obtain).getCurrDrawable());
                        if (drawableToBitmap != null) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            drawableToBitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            QLog.d(ShareUtils.TAG, 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length original:" + byteArray.length);
                            Bitmap bitmap = drawableToBitmap;
                            int i16 = 0;
                            while (i16 < 10 && byteArray.length > 32768) {
                                Matrix matrix = new Matrix();
                                matrix.setScale(0.7f, 0.7f);
                                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                createBitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                                i16++;
                                QLog.d(ShareUtils.TAG, 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length compressTo:" + byteArray2.length);
                                bitmap = createBitmap;
                                byteArray = byteArray2;
                            }
                            QLog.d(ShareUtils.TAG, 1, "startShareToWeChat. ImageUtil.drawableToBitmap, out.toByteArray().length done:" + byteArray.length);
                            drawableToBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        }
                    } catch (Exception e16) {
                        QLog.e(ShareUtils.TAG, 1, "startShareToWeChat. get an exception when handling URLbmp:" + e16);
                        drawableToBitmap = ImageUtil.drawableToBitmap(activity.getResources().getDrawable(R.drawable.n1m));
                    }
                    Bitmap bitmap2 = drawableToBitmap;
                    int i17 = i3;
                    if (i17 == 3) {
                        WXShareHelper.b0().M0(String.valueOf(System.currentTimeMillis()), str9, bitmap2, "QQ\u5c0f\u7a0b\u5e8f \u00b7 " + apkgInfo.apkgName, optString);
                    } else if (i17 == 4) {
                        WXShareHelper.b0().N0(String.valueOf(System.currentTimeMillis()), "QQ\u5c0f\u7a0b\u5e8f \u00b7 " + apkgInfo.apkgName + MsgSummary.STR_COLON + str9, bitmap2, "", optString);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("MiniAppInfoForQQ", apkgInfo.appConfig.config);
                    bundle.putParcelable("MiniAppLaunchParamForQQ", apkgInfo.appConfig.launchParam);
                    BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "MiniAppTransferModule", MiniAppTransferModule.ACTION_MINI_RECORD_WX_SHARE_MINIAPP_FOR_QQ, bundle);
                    return;
                }
                if (jSONObject != null) {
                    z17 = jSONObject.optBoolean("needShareCallBack", false);
                    j3 = jSONObject.optLong("retCode");
                    str10 = jSONObject.optString("errMsg");
                } else {
                    j3 = -1;
                    str10 = null;
                }
                if (!z17) {
                    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK, null, null);
                }
                if (activity == null) {
                    QLog.e(ShareUtils.TAG, 1, "startShareToWe activity is null?!!");
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long j16 = j3;
                            if (j16 == -100070004 || j16 == -1000710003) {
                                Activity activity3 = activity;
                                DialogUtil.createCustomDialog(activity3, 233, activity3.getString(R.string.hix), str10, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.appbrand.utils.ShareUtils.8.1.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i18) {
                                        QLog.e(ShareUtils.TAG, 1, "dialog click ");
                                    }
                                }, null).show();
                            } else if (j16 == -100070016) {
                                DangerousPersonToastUtils.shareErrorToast(activity, j16, str10);
                            } else {
                                Activity activity4 = activity;
                                DangerousPersonToastUtils.shareErrorToast(activity4, j16, activity4.getString(R.string.c_y));
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startLinkToWeChat$6(Activity activity) {
        QQToast.makeText(activity, 0, R.string.f173257ih1, 1).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startLinkToWeChat$7(Activity activity) {
        QQToast.makeText(activity, 0, R.string.f173258ih2, 1).show(activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean doOnSharePicActivityResult(Activity activity, int i3, int i16, Intent intent) {
        if (i3 != 1010 || i16 != -1 || activity == null || activity.isFinishing()) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_mini_report_event_action_type", "user_click");
        bundle.putString("key_mini_report_event_sub_action_type", "custom_button");
        bundle.putString("key_mini_report_event_reserves", "share_QQ");
        bundle.putString("key_mini_report_event_reserves2", "success");
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_REPORT_EVENT, bundle, null);
        if (intent == null) {
            return true;
        }
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_FORWARD_PIC, intent.getExtras(), null);
        return true;
    }
}
