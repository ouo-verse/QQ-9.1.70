package com.tencent.mobileqq.mini.share;

import NS_COMM.COMM;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare$StTemplateInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.Constants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.mini.appbrand.utils.DangerousPersonToastUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniProgramShareUtils {
    public static final String MINI_APP_SHARE_APPID = "miniAppShareAppid";
    public static final String MINI_APP_SHARE_APP_TYPE = "miniAppShareAppType";
    public static final String MINI_APP_SHARE_CALLBACK_ID = "miniAppShareCallbackId";
    public static final String MINI_APP_SHARE_DEST_ID = "miniAppShareDestId";
    public static final String MINI_APP_SHARE_DEST_TYPE = "miniAppShareDestType";
    public static final String MINI_APP_SHARE_EVENT = "miniAppShareEvent";
    public static final String MINI_APP_SHARE_FROM = "miniAppShareFrom";
    public static final int MINI_APP_SHARE_FROM_DETAIL = 10;
    public static final int MINI_APP_SHARE_FROM_INNER_BUTTON = 11;
    public static final int MINI_APP_SHARE_FROM_MORE_BUTTON = 12;
    public static final int MINI_APP_SHARE_FROM_PAY = 13;
    public static final String MINI_APP_SHARE_IS_COMPLETE = "miniAppShareIsComplete";
    public static final String MINI_APP_SHARE_SCENE = "miniAppShareScene";
    public static final String MINI_APP_SHARE_SUB_SCENE = "miniAppShareSubScene";
    public static final String MINI_APP_SHARE_TEMPLATE_ID = "miniAppShareTemplateId";
    public static final String MINI_APP_SHARE_TYPE = "miniAppShareType";
    public static final String MINI_APP_SHARE_UPDATABLE_MSG_FROM = "miniAppShareUpdatableMsgFrom";
    public static final long SHARE_APPID_MISMATCHING = -1000710003;
    public static final long SHARE_DANGEROUS_PERSON = -100070016;
    public static final long SHARE_OUT_OF_LIMIT = -100070004;
    private static final String SHARE_PATH_DETAIL = "openMiniApp/detail";
    private static final String SHARE_SCHEME = "miniapp";
    public static final int SHARE_TARGET_QQ = 0;
    public static final int SHARE_TARGET_QQ_DIRECTLY = 2;
    public static final int SHARE_TARGET_QZONE = 1;
    public static final int SHARE_TARGET_SHARE_CHAT = 5;
    public static final int SHARE_TARGET_TO_FRIEND_LIST = 6;
    public static final int SHARE_TARGET_TO_GUILD = 8;
    public static final int SHARE_TARGET_WECHAT_FRIEND = 3;
    public static final int SHARE_TARGET_WECHAT_MOMENTS = 4;
    public static final int SHARE_UPDATABLE_MSG = 7;
    private static final String TAG = "MiniProgramShareUtils [miniappArkShare]";

    /* loaded from: classes33.dex */
    public interface OnShareListener {
        void onShared(boolean z16, boolean z17);
    }

    MiniProgramShareUtils() {
    }

    public static String getLocalImagePathFromArkMeta(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject((String) jSONObject.names().get(0));
            if (optJSONObject != null) {
                return optJSONObject.optString("preview");
            }
            return null;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getLocalImagePathFromArkMeta get an exception: " + str + ",e:" + e16);
            e16.printStackTrace();
            return null;
        }
    }

    public static MiniProgramShare$StAdaptShareInfoReq newShareInfoRequest(String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4, String str5, String str6, String str7, COMM.StCommonExt stCommonExt, int i19, String str8, int i26, boolean z16, String str9, String str10, String str11, String str12, String str13, int i27) {
        MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq = new MiniProgramShare$StAdaptShareInfoReq();
        if (str != null) {
            miniProgramShare$StAdaptShareInfoReq.appid.set(str);
        }
        if (str2 != null) {
            miniProgramShare$StAdaptShareInfoReq.title.set(str2);
        }
        if (str3 != null) {
            miniProgramShare$StAdaptShareInfoReq.desc.set(str3);
        }
        miniProgramShare$StAdaptShareInfoReq.time.set(i3);
        miniProgramShare$StAdaptShareInfoReq.scene.set(i16);
        miniProgramShare$StAdaptShareInfoReq.templetType.set(i17);
        miniProgramShare$StAdaptShareInfoReq.businessType.set(i18);
        if (str4 != null) {
            miniProgramShare$StAdaptShareInfoReq.picUrl.set(str4);
        }
        if (str5 != null) {
            miniProgramShare$StAdaptShareInfoReq.vidUrl.set(str5);
        }
        if (str6 != null) {
            miniProgramShare$StAdaptShareInfoReq.jumpUrl.set(str6);
        }
        if (str7 != null) {
            miniProgramShare$StAdaptShareInfoReq.iconUrl.set(str7);
        }
        if (stCommonExt != null) {
            miniProgramShare$StAdaptShareInfoReq.extInfo.set(stCommonExt);
        }
        miniProgramShare$StAdaptShareInfoReq.verType.set(i19);
        if (str8 != null) {
            miniProgramShare$StAdaptShareInfoReq.versionId.set(str8);
        }
        miniProgramShare$StAdaptShareInfoReq.shareType.set(i26);
        miniProgramShare$StAdaptShareInfoReq.withShareTicket.set(z16 ? 1 : 0);
        if (str9 != null) {
            miniProgramShare$StAdaptShareInfoReq.webURL.set(str9);
        }
        if (str10 != null) {
            miniProgramShare$StAdaptShareInfoReq.appidRich.set(str10);
        }
        if (str11 != null && str12 != null) {
            MiniProgramShare$StTemplateInfo miniProgramShare$StTemplateInfo = new MiniProgramShare$StTemplateInfo();
            miniProgramShare$StTemplateInfo.templateId.set(str11);
            miniProgramShare$StTemplateInfo.templateData.set(str12);
            miniProgramShare$StAdaptShareInfoReq.template.set(miniProgramShare$StTemplateInfo);
        }
        if (i26 == 5) {
            miniProgramShare$StAdaptShareInfoReq.rcvOpenId.set(str13);
        }
        miniProgramShare$StAdaptShareInfoReq.origin.set(i27);
        return miniProgramShare$StAdaptShareInfoReq;
    }

    public static void shareToChatDirectly(Activity activity, Bundle bundle, int i3, String str, String str2, int i16, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "shareToChatDirectly, chatType: " + i3 + ",uin: " + str + ",name: " + str2);
        }
        if (bundle == null) {
            QLog.e(TAG, 1, "shareToChatDirectly shareDataBundle is null ");
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) TroopCreateLogicActivity.class);
        intent.putExtra(AppConstants.Key.KEY_SHARE_FROM_SCREEN_SHOT_NEED_FINISH, true);
        if (z16) {
            intent.putExtra("type", 9);
        } else {
            intent.putExtra("type", 10);
        }
        bundle.putInt("uintype", i3);
        bundle.putString("uin", String.valueOf(str));
        bundle.putString("uinname", str2);
        bundle.putInt("miniAppShareDestType", i3);
        bundle.putString("miniAppShareDestId", str);
        intent.putExtras(bundle);
        if (i16 != -1) {
            activity.startActivityForResult(intent, i16);
        } else {
            activity.startActivity(intent);
        }
    }

    public static void shareUpdatableMsg(Context context, String str, int i3, String str2, String str3, int i16, int i17) {
        Intent intent = new Intent(context, (Class<?>) ForwardRecentActivity.class);
        intent.putExtra("forward_type", 44);
        intent.putExtra("miniAppShareAppid", str);
        intent.putExtra("miniAppShareUpdatableMsgFrom", i3);
        intent.putExtra("miniAppShareTemplateId", str2);
        intent.putExtra("miniAppShareEvent", str3);
        intent.putExtra("miniAppShareCallbackId", i16);
        intent.putExtra("miniAppShareSubScene", i17);
        ForwardBaseOption.startForwardActivity(context, intent);
    }

    public static String updateImagePathToArkMeta(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray names = jSONObject.names();
            JSONObject optJSONObject = jSONObject.optJSONObject((String) names.get(0));
            if (optJSONObject != null) {
                optJSONObject.put("preview", str2);
                jSONObject.put((String) names.get(0), optJSONObject);
                str = jSONObject.toString();
            }
            QLog.d(TAG, 2, "updateImagePathToArkMeta: " + str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateImagePathToArkMeta get an exception: " + str + ",e:" + e16);
            e16.printStackTrace();
        }
        return str;
    }

    private static Bundle buildShareBundle(Activity activity, String str, int i3, MiniArkShareModel miniArkShareModel, JSONObject jSONObject, boolean z16) {
        String jSONObject2;
        int miniAppShareFrom = miniArkShareModel.getMiniAppShareFrom();
        String optString = jSONObject.optString("appName");
        if (TextUtils.isEmpty(optString)) {
            optString = jSONObject.optString("app");
        }
        String str2 = optString;
        String optString2 = jSONObject.optString(QQCustomArkDialogUtil.APP_VIEW);
        if (TextUtils.isEmpty(optString2)) {
            optString2 = jSONObject.optString("view");
        }
        String str3 = optString2;
        String optString3 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
        String optString4 = jSONObject.optString("ver");
        jSONObject.optString("desc");
        if (TextUtils.isEmpty(optString4)) {
            optString4 = Constants.DEFAULT_MIN_APP_VERSION;
        }
        String str4 = optString4;
        JSONObject optJSONObject = jSONObject.optJSONObject(QQCustomArkDialogUtil.META_DATA);
        if (optJSONObject == null) {
            optJSONObject = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
        }
        String jSONObject3 = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
        if (optJSONObject2 == null) {
            try {
                optJSONObject2 = new JSONObject().put("type", "normal").put("width", 253).put("height", "intro".equals(str3) ? 140 : 272).put("forward", 1).put("autoSize", 0);
            } catch (JSONException e16) {
                QLog.e(TAG, 2, "performShareAsArkMessage", e16);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_ark_display_share", true);
        bundle.putString("forward_ark_app_name", str2);
        bundle.putString("forward_ark_app_view", str3);
        bundle.putString("forward_ark_biz_src", optString3);
        bundle.putString("forward_ark_app_prompt", str);
        bundle.putString("forward_ark_app_meta", jSONObject3);
        bundle.putString("forward_ark_app_ver", str4);
        if (optJSONObject2 == null) {
            jSONObject2 = "";
        } else {
            jSONObject2 = optJSONObject2.toString();
        }
        bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, jSONObject2);
        bundle.putBoolean("needShareCallBack", z16);
        bundle.putBoolean("miniAppNeedOnlyPreview", i3 == 5);
        bundle.putInt("miniAppShareFrom", miniAppShareFrom);
        bundle.putAll(QQCustomArkDialog.b.a(str2, str3, optString3, str4, jSONObject3, activity.getResources().getDisplayMetrics().scaledDensity, null, null));
        bundle.putInt("forward_type", 27);
        bundle.putBoolean("forwardDirect", true);
        bundle.putString("miniAppShareAppid", miniArkShareModel.getAppId());
        bundle.putInt("miniAppShareAppType", miniArkShareModel.getShareBusinessType());
        bundle.putInt("miniAppShareScene", miniAppShareFrom);
        bundle.putInt("miniAppShareType", miniArkShareModel.getShareTarget());
        return bundle;
    }

    public static String getArkPrompt(Activity activity, MiniArkShareModel miniArkShareModel, JSONObject jSONObject) {
        String optString = jSONObject != null ? jSONObject.optString("prompt") : null;
        if (!TextUtils.isEmpty(optString) || activity == null || miniArkShareModel == null) {
            return optString;
        }
        int shareBusinessType = miniArkShareModel.getShareBusinessType();
        if (shareBusinessType == 0) {
            return activity.getString(R.string.xxd);
        }
        if (shareBusinessType == 1) {
            return activity.getString(R.string.xxe);
        }
        return shareBusinessType == 2 ? activity.getString(R.string.xxf) : optString;
    }

    public static void performShareArkAsMessageFailed(int i3, int i16, JSONObject jSONObject) {
        boolean optBoolean = jSONObject != null ? jSONObject.optBoolean("needShareCallBack", false) : false;
        if (i3 == 5) {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_DIRECT_SHARE_FAIL_CALLBACK, null, null);
        } else if (optBoolean) {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_FAIL_CALLBACK, null, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_mini_report_event_action_type", "user_click");
        switch (i16) {
            case 10:
                bundle.putString("key_mini_report_event_sub_action_type", "more_about");
                break;
            case 11:
                bundle.putString("key_mini_report_event_sub_action_type", "custom_button");
                break;
            case 12:
                bundle.putString("key_mini_report_event_sub_action_type", "more_button");
                break;
        }
        bundle.putString("key_mini_report_event_reserves", "share_QQ");
        bundle.putString("key_mini_report_event_reserves2", "fail");
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_REPORT_EVENT, bundle, null);
        DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, -1000710003L, HardCodeUtil.qqStr(R.string.hix), 0);
    }

    public static boolean performShareAsArkMessage(Activity activity, String str, MiniArkShareModel miniArkShareModel, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            QLog.e(TAG, 2, "performShareAsArkMessage jsonObject null");
            performShareArkAsMessageFailed(i3, miniArkShareModel.getMiniAppShareFrom(), jSONObject);
            return false;
        }
        boolean z16 = (jSONObject.isNull("appName") || jSONObject.isNull(QQCustomArkDialogUtil.APP_VIEW) || jSONObject.isNull(QQCustomArkDialogUtil.META_DATA)) ? false : true;
        if (!jSONObject.isNull("app") && !jSONObject.isNull("view") && !jSONObject.isNull(PublicAccountMessageUtilImpl.META_NAME)) {
            z16 = true;
        }
        if (!z16) {
            QLog.e(TAG, 2, "performShareAsArkMessage Param Error!");
            performShareArkAsMessageFailed(i3, miniArkShareModel.getMiniAppShareFrom(), jSONObject);
            return false;
        }
        boolean optBoolean = jSONObject.optBoolean("needShareCallBack", false);
        if (!optBoolean && i3 != 5) {
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_SUC_CALLBACK, null, null);
        }
        Bundle buildShareBundle = buildShareBundle(activity, str, i3, miniArkShareModel, jSONObject, optBoolean);
        EntryModel entryModel = miniArkShareModel.getEntryModel();
        ShareChatModel shareChatModel = miniArkShareModel.getShareChatModel();
        int shareTarget = miniArkShareModel.getShareTarget();
        int miniAppShareFrom = miniArkShareModel.getMiniAppShareFrom();
        int shareRequestCode = miniArkShareModel.getShareRequestCode();
        if (shareTarget == 6) {
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtras(buildShareBundle);
            if (shareRequestCode < 0) {
                PublicFragmentActivity.b.a(activity, intent, PublicTransFragmentActivity.class, MiniShareQuicklySendPanelFragment.class);
            } else {
                PublicFragmentActivity.b.d(activity, intent, PublicTransFragmentActivity.class, MiniShareQuicklySendPanelFragment.class, shareRequestCode);
            }
        } else if (shareTarget == 8) {
            Intent intent2 = new Intent();
            intent2.putExtras(buildShareBundle);
            intent2.putExtra("call_by_forward", true);
            intent2.putExtra("is_multi_selection", false);
            intent2.putExtra("only_single_selection", true);
            intent2.putParcelableArrayListExtra("selected_target_list", new ArrayList<>());
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent2, shareRequestCode);
        } else if (entryModel != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_mini_report_event_action_type", "user_click");
            bundle.putString("key_mini_report_event_sub_action_type", "custom_button");
            bundle.putString("key_mini_report_event_reserves", "share_QQfast");
            bundle.putString("key_mini_report_event_reserves2", "success");
            QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_REPORT_EVENT, bundle, null);
            shareToChatDirectly(activity, buildShareBundle, entryModel.type, String.valueOf(entryModel.uin), entryModel.name, shareRequestCode, true);
        } else if (shareChatModel != null) {
            shareToChatDirectly(activity, buildShareBundle, shareChatModel.type, String.valueOf(shareChatModel.uin), shareChatModel.name, shareRequestCode, true);
        } else {
            Intent intent3 = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
            intent3.putExtra(ForwardRecentActivity.KEY_REQUEST_ORIENTATION, 1);
            intent3.putExtras(buildShareBundle);
            intent3.putExtra("key_guild_success_action", miniArkShareModel.getGuildSuccessAction());
            if (miniAppShareFrom == 12) {
                if (shareRequestCode < 0) {
                    ForwardBaseOption.startForwardActivity(activity, intent3, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "applet");
                } else {
                    ForwardBaseOption.startForwardActivityForResult(activity, intent3, (Class<?>) ForwardRecentActivity.class, shareRequestCode, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "applet");
                }
            } else if (shareRequestCode < 0) {
                ForwardBaseOption.startForwardActivity(activity, intent3);
            } else {
                ForwardBaseOption.startForwardActivityForResult(activity, intent3, shareRequestCode);
            }
        }
        return true;
    }

    public static MiniProgramShare$StAdaptShareInfoReq newShareInfoRequest(MiniArkShareModel miniArkShareModel, int i3, int i16) {
        String appId = miniArkShareModel.getAppId();
        String title = miniArkShareModel.getTitle();
        String description = miniArkShareModel.getDescription();
        int shareScene = miniArkShareModel.getShareScene();
        int shareTemplateType = miniArkShareModel.getShareTemplateType();
        int shareBusinessType = miniArkShareModel.getShareBusinessType();
        String picUrl = miniArkShareModel.getPicUrl();
        String vidUrl = miniArkShareModel.getVidUrl();
        String jumpUrl = miniArkShareModel.getJumpUrl();
        String iconUrl = miniArkShareModel.getIconUrl();
        COMM.StCommonExt extInfo = miniArkShareModel.getExtInfo();
        int versionType = miniArkShareModel.getVersionType();
        String versionId = miniArkShareModel.getVersionId();
        boolean isWithShareTicket = miniArkShareModel.isWithShareTicket();
        String webURL = miniArkShareModel.getWebURL();
        String appidRich = miniArkShareModel.getAppidRich();
        String templateId = miniArkShareModel.getTemplateId();
        String templateData = miniArkShareModel.getTemplateData();
        String rcvOpenId = miniArkShareModel.getRcvOpenId();
        int shareOrigin = miniArkShareModel.getShareOrigin();
        MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq = new MiniProgramShare$StAdaptShareInfoReq();
        if (appId != null) {
            miniProgramShare$StAdaptShareInfoReq.appid.set(appId);
        }
        if (title != null) {
            miniProgramShare$StAdaptShareInfoReq.title.set(title);
        }
        if (description != null) {
            miniProgramShare$StAdaptShareInfoReq.desc.set(description);
        }
        miniProgramShare$StAdaptShareInfoReq.time.set(i3);
        miniProgramShare$StAdaptShareInfoReq.scene.set(shareScene);
        miniProgramShare$StAdaptShareInfoReq.templetType.set(shareTemplateType);
        miniProgramShare$StAdaptShareInfoReq.businessType.set(shareBusinessType);
        if (picUrl != null) {
            miniProgramShare$StAdaptShareInfoReq.picUrl.set(picUrl);
        }
        if (vidUrl != null) {
            miniProgramShare$StAdaptShareInfoReq.vidUrl.set(vidUrl);
        }
        if (jumpUrl != null) {
            miniProgramShare$StAdaptShareInfoReq.jumpUrl.set(jumpUrl);
        }
        if (iconUrl != null) {
            miniProgramShare$StAdaptShareInfoReq.iconUrl.set(iconUrl);
        }
        if (extInfo != null) {
            miniProgramShare$StAdaptShareInfoReq.extInfo.set(extInfo);
        }
        miniProgramShare$StAdaptShareInfoReq.verType.set(versionType);
        if (versionId != null) {
            miniProgramShare$StAdaptShareInfoReq.versionId.set(versionId);
        }
        miniProgramShare$StAdaptShareInfoReq.shareType.set(i16);
        miniProgramShare$StAdaptShareInfoReq.withShareTicket.set(isWithShareTicket ? 1 : 0);
        if (webURL != null) {
            miniProgramShare$StAdaptShareInfoReq.webURL.set(webURL);
        }
        if (appidRich != null) {
            miniProgramShare$StAdaptShareInfoReq.appidRich.set(appidRich);
        }
        if (templateId != null && templateData != null) {
            MiniProgramShare$StTemplateInfo miniProgramShare$StTemplateInfo = new MiniProgramShare$StTemplateInfo();
            miniProgramShare$StTemplateInfo.templateId.set(templateId);
            miniProgramShare$StTemplateInfo.templateData.set(templateData);
            miniProgramShare$StAdaptShareInfoReq.template.set(miniProgramShare$StTemplateInfo);
        }
        if (i16 == 5) {
            miniProgramShare$StAdaptShareInfoReq.rcvOpenId.set(rcvOpenId);
        }
        miniProgramShare$StAdaptShareInfoReq.origin.set(shareOrigin);
        return miniProgramShare$StAdaptShareInfoReq;
    }

    public static void shareAsQzoneFeeds(String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, String str7, int i18, String str8, String str9, int i19, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().getShareInfo(newShareInfoRequest(str, str2, str3, (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), i3, i16, i17, str4, str5, str6, str7, null, i18, str8, 1, false, null, str9, null, null, "", i19), miniAppCmdInterface);
    }

    public static void shareAsWeChatMsg(String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, String str7, int i18, String str8, String str9, int i19, int i26, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().getShareInfo(newShareInfoRequest(str, str2, str3, (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), i3, i16, i17, str4, str5, str6, str7, null, i18, str8, i19, false, null, str9, null, null, "", i26), miniAppCmdInterface);
    }
}
