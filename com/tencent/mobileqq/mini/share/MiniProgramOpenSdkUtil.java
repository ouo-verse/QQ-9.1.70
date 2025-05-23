package com.tencent.mobileqq.mini.share;

import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.ark.Constants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.appbrand.utils.DangerousPersonToastUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniProgramOpenSdkUtil {
    public static final String ATTR_SHARE_APPID_RICH = "share_id";
    public static final String ATTR_SHARE_TO_QQ_MINI_PROGRAM_APPID = "mini_program_appid";
    public static final String ATTR_SHARE_TO_QQ_MINI_PROGRAM_PATH = "mini_program_path";
    public static final String ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE = "mini_program_type";
    public static final String ATTR_SHARE_TO_QQ_MINI_PROGRAM_WEBURL = "url";
    public static final String KEY_MINI_PROGRAM_ARK_JSON = "KEY_MINI_PROGRAM_ARK_JSON";
    public static final String KEY_MINI_PROGRAM_SHARE_OBJ = "KEY_MINI_PROGRAM_SHARE_OBJ";
    private static final String TAG = "MiniProgramOpenSdkUtil";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil$3, reason: invalid class name */
    /* loaded from: classes33.dex */
    public class AnonymousClass3 implements IMiniCallback {
        final /* synthetic */ Context val$context;
        final /* synthetic */ HashMap val$forwardAttrs;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ TimeOutInfo val$outInfo;
        final /* synthetic */ Runnable val$showLoadingRunnable;
        final /* synthetic */ Runnable val$timeoutRunnable;

        AnonymousClass3(HashMap hashMap, TimeOutInfo timeOutInfo, Runnable runnable, Runnable runnable2, Context context, Intent intent) {
            this.val$forwardAttrs = hashMap;
            this.val$outInfo = timeOutInfo;
            this.val$timeoutRunnable = runnable;
            this.val$showLoadingRunnable = runnable2;
            this.val$context = context;
            this.val$intent = intent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onCallbackResult$0(TimeOutInfo timeOutInfo, Runnable runnable, Runnable runnable2, HashMap hashMap, MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq, Context context, Intent intent, boolean z16, JSONObject jSONObject) {
            MiniProgramOpenSdkUtil.setUIHandlerEvents(timeOutInfo, runnable, runnable2);
            if (timeOutInfo.isTimeout) {
                QLog.e(MiniProgramOpenSdkUtil.TAG, 1, "forwardShare failed timeout");
                return;
            }
            jSONObject.remove("desc");
            if (z16) {
                MiniProgramOpenSdkUtil.avoidHighFrequentForwardActivity(context, intent, jSONObject, MiniProgramOpenSdkUtil.initOpenSdkShareModel(hashMap, jSONObject, miniProgramShare$StAdaptShareInfoReq.appidRich.get()));
            } else {
                MiniProgramOpenSdkUtil.setShareFailedEvent(context, jSONObject);
            }
            ForwardStatisticsReporter.c("KEY_STAGE_1_GET_SHARE_INFO");
            QLog.d(MiniProgramOpenSdkUtil.TAG, 1, "arkShareJson:", jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.mini.api.IMiniCallback
        public void onCallbackResult(boolean z16, Bundle bundle) {
            QLog.d(MiniProgramOpenSdkUtil.TAG, 2, "onCmdResult() called with: succ = [" + z16 + "], bundle = [" + bundle + "]");
            ForwardStatisticsReporter.k("KEY_STAGE_1_UPLOAD_IMAGE", z16);
            String str = "";
            if (z16 && bundle != null) {
                str = bundle.getString("imageUrl", "").replaceFirst("https*://", "");
            }
            this.val$forwardAttrs.put("image_url", str);
            final MiniProgramShare$StAdaptShareInfoReq buildShareInfoRequest = MiniProgramOpenSdkUtil.buildShareInfoRequest(MiniProgramOpenSdkUtil.buildMiniArkShareModel(this.val$forwardAttrs));
            final TimeOutInfo timeOutInfo = this.val$outInfo;
            final Runnable runnable = this.val$timeoutRunnable;
            final Runnable runnable2 = this.val$showLoadingRunnable;
            final HashMap hashMap = this.val$forwardAttrs;
            final Context context = this.val$context;
            final Intent intent = this.val$intent;
            MiniAppCmdUtil.getInstance().getShareInfo(buildShareInfoRequest, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.share.c
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public final void onCmdListener(boolean z17, JSONObject jSONObject) {
                    MiniProgramOpenSdkUtil.AnonymousClass3.lambda$onCallbackResult$0(MiniProgramOpenSdkUtil.TimeOutInfo.this, runnable, runnable2, hashMap, buildShareInfoRequest, context, intent, z17, jSONObject);
                }
            });
            ForwardStatisticsReporter.m("KEY_STAGE_1_GET_SHARE_INFO");
            QLog.d(MiniProgramOpenSdkUtil.TAG, 1, "forwardShare");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class TimeOutInfo {
        boolean isTimeout;
        QQProgressDialog progressDialog;

        TimeOutInfo() {
        }
    }

    public static boolean asyncShareMiniProgram(ax axVar) {
        return isSharingMiniProgram(axVar.f307441f) && !"to_qzone".equals(axVar.f307440e);
    }

    private static JSONObject buildArkConfig(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            try {
                optJSONObject.put("type", "normal");
                optJSONObject.put("width", 253);
                optJSONObject.put("height", "intro".equals(str) ? 140 : 272);
                optJSONObject.put("forward", 1);
                optJSONObject.put("autoSize", 0);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return optJSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MiniArkShareModel buildMiniArkShareModel(HashMap<String, String> hashMap) {
        int i3;
        String base64Decode = toBase64Decode(hashMap.get(ATTR_SHARE_TO_QQ_MINI_PROGRAM_APPID));
        String base64Decode2 = toBase64Decode(hashMap.get("title"));
        String base64Decode3 = toBase64Decode(hashMap.get("description"));
        String base64Decode4 = toBase64Decode(hashMap.get(ATTR_SHARE_TO_QQ_MINI_PROGRAM_PATH));
        String base64Decode5 = toBase64Decode(hashMap.get("url"));
        String str = hashMap.get(ATTR_SHARE_APPID_RICH);
        try {
            i3 = Integer.parseInt(toBase64Decode(hashMap.get(ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE)));
        } catch (NumberFormatException unused) {
            i3 = 3;
        }
        return new MiniArkShareModelBuilder().setAppId(base64Decode).setTitle(base64Decode2).setDescription(base64Decode3).setShareScene(3).setShareTemplateType(1).setShareBusinessType(0).setPicUrl(hashMap.get("image_url")).setVidUrl(null).setJumpUrl(base64Decode4).setVersionType(i3).setWebURL(base64Decode5).setAppidRich(str).createMiniArkShareModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MiniProgramShare$StAdaptShareInfoReq buildShareInfoRequest(MiniArkShareModel miniArkShareModel) {
        return MiniProgramShareUtils.newShareInfoRequest(miniArkShareModel.getAppId(), miniArkShareModel.getTitle(), miniArkShareModel.getDescription(), (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), miniArkShareModel.getShareScene(), miniArkShareModel.getShareTemplateType(), miniArkShareModel.getShareBusinessType(), miniArkShareModel.getPicUrl(), miniArkShareModel.getVidUrl(), miniArkShareModel.getJumpUrl(), miniArkShareModel.getIconUrl(), null, miniArkShareModel.getVersionType(), miniArkShareModel.getVersionId(), 0, false, miniArkShareModel.getWebURL(), miniArkShareModel.getAppidRich(), miniArkShareModel.getTemplateId(), miniArkShareModel.getTemplateData(), "", miniArkShareModel.getShareOrigin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void finishPreviousActivity(Context context) {
        ILoginRegisterApi iLoginRegisterApi = (ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class);
        if (((context instanceof JumpActivity) || iLoginRegisterApi.getLoginActivityClass().isInstance(context)) && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (activity.isFinishing()) {
                return;
            }
            activity.finish();
        }
    }

    public static void forwardShare(final Context context, final HashMap<String, String> hashMap, Bundle bundle, final Intent intent) {
        if ((context instanceof JumpActivity) && ((JumpActivity) context).isFinishing()) {
            QLog.e(TAG, 1, "((JumpActivity)context).isFinishing()");
            return;
        }
        final TimeOutInfo timeOutInfo = new TimeOutInfo();
        final Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Context context2 = context;
                    if (!(context2 instanceof JumpActivity) || ((JumpActivity) context2).isFinishing()) {
                        return;
                    }
                    timeOutInfo.progressDialog = new QQProgressDialog(context, 0, R.layout.f167664dn, 17);
                    timeOutInfo.progressDialog.setMessage(context.getString(R.string.f170468s3));
                    timeOutInfo.progressDialog.getWindow().setDimAmount(0.0f);
                    timeOutInfo.progressDialog.setCanceledOnTouchOutside(true);
                    timeOutInfo.progressDialog.show();
                } catch (Throwable th5) {
                    QLog.e(MiniProgramOpenSdkUtil.TAG, 1, "forwardShare showLoadingRunnable has Exception" + th5.getMessage());
                }
            }
        };
        final Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.2
            @Override // java.lang.Runnable
            public void run() {
                TimeOutInfo timeOutInfo2 = TimeOutInfo.this;
                timeOutInfo2.isTimeout = true;
                try {
                    QQProgressDialog qQProgressDialog = timeOutInfo2.progressDialog;
                    if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                        TimeOutInfo.this.progressDialog.dismiss();
                    }
                    QQToast.makeText(context, HardCodeUtil.qqStr(R.string.io7), 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    MiniProgramOpenSdkUtil.finishPreviousActivity(context);
                } catch (Throwable th5) {
                    QLog.e(MiniProgramOpenSdkUtil.TAG, 1, "forwardShare timeoutRunnable has Exception" + th5.getMessage());
                }
            }
        };
        ThreadManager.getUIHandler().postDelayed(runnable, 500L);
        ThreadManager.getUIHandler().postDelayed(runnable2, 7000L);
        intent.putExtras(bundle);
        if (isLocalMiniAppArkSharePicture(hashMap)) {
            MiniArkShareAsyncManager.performUploadArkShareImage(toBase64Decode(hashMap.get("file_data")), new AnonymousClass3(hashMap, timeOutInfo, runnable2, runnable, context, intent));
            return;
        }
        hashMap.put("image_url", toBase64Decode(hashMap.get("image_url")).replaceFirst("https*://", ""));
        final MiniProgramShare$StAdaptShareInfoReq buildShareInfoRequest = buildShareInfoRequest(buildMiniArkShareModel(hashMap));
        MiniAppCmdUtil.getInstance().getShareInfo(buildShareInfoRequest, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.share.a
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniProgramOpenSdkUtil.lambda$forwardShare$0(MiniProgramOpenSdkUtil.TimeOutInfo.this, runnable2, runnable, hashMap, buildShareInfoRequest, context, intent, z16, jSONObject);
            }
        });
        ForwardStatisticsReporter.m("KEY_STAGE_1_GET_SHARE_INFO");
        QLog.d(TAG, 1, "forwardShare");
    }

    public static void forwardShareWithTryCatch(Context context, HashMap<String, String> hashMap, Bundle bundle, Intent intent) {
        try {
            forwardShare(context, hashMap, bundle, intent);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "forwardShare has Exception" + th5.getMessage());
        }
    }

    private static String getPictureUrl(HashMap<String, String> hashMap) {
        String base64Decode = toBase64Decode(hashMap.get("image_url"));
        String base64Decode2 = toBase64Decode(hashMap.get("file_data"));
        return TextUtils.isEmpty(base64Decode2) ? base64Decode : base64Decode2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OpenSdkShareModel initOpenSdkShareModel(HashMap<String, String> hashMap, JSONObject jSONObject, String str) {
        OpenSdkShareModel openSdkShareModel = new OpenSdkShareModel();
        openSdkShareModel.miniAppAppid = toBase64Decode(hashMap.get(ATTR_SHARE_TO_QQ_MINI_PROGRAM_APPID));
        openSdkShareModel.miniAppPath = toBase64Decode(hashMap.get(ATTR_SHARE_TO_QQ_MINI_PROGRAM_PATH));
        openSdkShareModel.miniAppType = toBase64Decode(hashMap.get(ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE));
        openSdkShareModel.webPageUrl = toBase64Decode(hashMap.get("url"));
        openSdkShareModel.appRichId = str;
        openSdkShareModel.title = toBase64Decode(hashMap.get("title"));
        openSdkShareModel.desc = toBase64Decode(hashMap.get("description"));
        transformArkShareJson(jSONObject);
        openSdkShareModel.imageUrl = toBase64Decode(hashMap.get("image_url"));
        openSdkShareModel.jsonStr = jSONObject.toString();
        return openSdkShareModel;
    }

    private static boolean isLocalMiniAppArkSharePicture(HashMap<String, String> hashMap) {
        String base64Decode = toBase64Decode(hashMap.get("file_data"));
        return (TextUtils.isEmpty(base64Decode) || URLUtil.isHttpUrl(base64Decode) || URLUtil.isHttpsUrl(base64Decode)) ? false : true;
    }

    public static boolean isSharingMiniProgram(HashMap<String, String> hashMap) {
        return (TextUtils.isEmpty(toBase64Decode(hashMap.get(ATTR_SHARE_TO_QQ_MINI_PROGRAM_APPID))) || TextUtils.isEmpty(toBase64Decode(hashMap.get(ATTR_SHARE_TO_QQ_MINI_PROGRAM_PATH)))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$forwardShare$0(TimeOutInfo timeOutInfo, Runnable runnable, Runnable runnable2, HashMap hashMap, MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq, Context context, Intent intent, boolean z16, JSONObject jSONObject) {
        setUIHandlerEvents(timeOutInfo, runnable, runnable2);
        if (timeOutInfo.isTimeout) {
            QLog.e(TAG, 1, "forwardShare failed timeout");
            return;
        }
        jSONObject.remove("desc");
        OpenSdkShareModel initOpenSdkShareModel = initOpenSdkShareModel(hashMap, jSONObject, miniProgramShare$StAdaptShareInfoReq.appidRich.get());
        if (z16) {
            avoidHighFrequentForwardActivity(context, intent, jSONObject, initOpenSdkShareModel);
        } else {
            startForwardActivityForFailed(context, intent, initOpenSdkShareModel);
        }
        ForwardStatisticsReporter.c("KEY_STAGE_1_GET_SHARE_INFO");
        QLog.d(TAG, 1, "arkShareJson:", jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setShareFailedEvent(final Context context, JSONObject jSONObject) {
        QLog.e(TAG, 1, "getShareInfo - failed,  miniProgramJson: " + jSONObject);
        final int optInt = jSONObject.optInt("retCode");
        final String optString = jSONObject.optString("errMsg");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.4
            @Override // java.lang.Runnable
            public void run() {
                DangerousPersonToastUtils.shareErrorToast(context, optInt, optString, 0);
            }
        });
        finishPreviousActivity(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setUIHandlerEvents(final TimeOutInfo timeOutInfo, Runnable runnable, Runnable runnable2) {
        ThreadManager.getUIHandler().removeCallbacks(runnable);
        ThreadManager.getUIHandler().removeCallbacks(runnable2);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QQProgressDialog qQProgressDialog = TimeOutInfo.this.progressDialog;
                    if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
                        return;
                    }
                    TimeOutInfo.this.progressDialog.dismiss();
                } catch (Throwable th5) {
                    QLog.e(MiniProgramOpenSdkUtil.TAG, 1, "forwardShare onCmdListener dialog dismiss has Exception", th5);
                }
            }
        });
    }

    private static void startForwardActivityForFailed(final Context context, final Intent intent, final OpenSdkShareModel openSdkShareModel) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.6
            @Override // java.lang.Runnable
            public void run() {
                intent.putExtra("KEY_MINI_PROGRAM_SHARE_OBJ", openSdkShareModel);
                ForwardBaseOption.startForwardActivity(context, intent);
                MiniProgramOpenSdkUtil.finishPreviousActivity(context);
            }
        });
    }

    public static String toBase64Decode(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        if (str.length() != 0) {
            try {
            } catch (Exception unused) {
                return "";
            }
        }
        return new String(PluginBaseInfoHelper.Base64Helper.decode(str, 0));
    }

    private static void transformArkShareJson(JSONObject jSONObject) {
        Object opt = jSONObject.opt("appName");
        Object opt2 = jSONObject.opt(QQCustomArkDialogUtil.APP_VIEW);
        Object opt3 = jSONObject.opt(QQCustomArkDialogUtil.META_DATA);
        try {
            jSONObject.put("app", opt);
            jSONObject.put("view", opt2);
            jSONObject.put(PublicAccountMessageUtilImpl.META_NAME, opt3);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        jSONObject.remove("appName");
        jSONObject.remove(QQCustomArkDialogUtil.APP_VIEW);
        jSONObject.remove(QQCustomArkDialogUtil.META_DATA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startForwardActivityOfArk(Context context, Intent intent, JSONObject jSONObject, OpenSdkShareModel openSdkShareModel) {
        QLog.d(TAG, 1, "startForwardActivityOfArk: invoked. arkJson: ", jSONObject);
        String optString = jSONObject.optString("app");
        String optString2 = jSONObject.optString("view");
        String optString3 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
        String optString4 = jSONObject.optString("title");
        if (jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME) != null) {
            String jSONObject2 = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME).toString();
            buildArkConfig(jSONObject, optString2);
            intent.putExtra("is_ark_display_share", true).putExtra("forward_ark_app_name", optString).putExtra("forward_ark_app_view", optString2).putExtra("forward_ark_biz_src", optString3).putExtra("forward_ark_app_prompt", optString4).putExtra("forward_ark_app_ver", Constants.DEFAULT_MIN_APP_VERSION).putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, jSONObject.optJSONObject(DownloadInfo.spKey_Config).toString()).putExtra("forward_type", 11).putExtra("forwardDirect", true);
            if (!intent.hasExtra(KEY_MINI_PROGRAM_ARK_JSON)) {
                intent.putExtra(KEY_MINI_PROGRAM_ARK_JSON, jSONObject.toString());
            }
            intent.putExtra("forward_ark_app_name", optString);
            intent.putExtra(AppConstants.Key.SHARE_FLAG, true);
            intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 2147483646);
            intent.putExtra(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, true);
            com.tencent.mobileqq.phonecontact.constant.b.f258441a = true;
            if (!intent.hasExtra("KEY_MINI_PROGRAM_SHARE_OBJ")) {
                intent.putExtra("KEY_MINI_PROGRAM_SHARE_OBJ", openSdkShareModel);
            }
            intent.putExtra("forward_ark_app_meta", jSONObject2);
            intent.putExtras(QQCustomArkDialog.b.a(optString, optString2, optString3, Constants.DEFAULT_MIN_APP_VERSION, jSONObject2, BaseApplication.context.getResources().getDisplayMetrics().scaledDensity, null, null));
            ForwardBaseOption.startForwardActivity(context, intent);
            finishPreviousActivity(context);
            return;
        }
        QLog.e(TAG, 1, "arkJson.optJSONObject(meta) is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void avoidHighFrequentForwardActivity(final Context context, final Intent intent, final JSONObject jSONObject, final OpenSdkShareModel openSdkShareModel) {
        if (fb0.a.b(TAG, 1000L)) {
            QLog.d(TAG, 1, "avoidHighFrequentForwardActivity\uff01");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.share.b
                @Override // java.lang.Runnable
                public final void run() {
                    MiniProgramOpenSdkUtil.startForwardActivityOfArk(context, intent, jSONObject, openSdkShareModel);
                }
            });
        }
    }
}
