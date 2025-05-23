package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.cookie.IQQLiveCookiePlanterApi;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.room.hourrank.IHourRank;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.cookie.CookieDataCallback;
import com.tencent.timi.game.api.cookie.IQQLiveCookieStrategyApi;
import com.tencent.timi.game.api.cookie.QQLiveCookieStrategyType;
import cooperation.ilive.util.ILiveEntranceUtilApi;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import q05.a;

/* loaded from: classes35.dex */
public class QQIliveJsPlugin extends VasWebviewJsPluginV2 {
    private static final String ACTION_NOTIFY_FOLLOW_CHANGE = "action_follow_change";
    public static final String ACTION_QQ_LIVE_WEB_FOLLOW_STATE = "ACTION_QQ_LIVE_WEB_FOLLOW_STATE";
    public static final String BUSINESS_NAME = "vaslive";
    public static final String KEY_FOLLOWED_UID = "followedUid";
    private static final String KEY_FOLLOW_STATE = "key_follow_state";
    public static final String KEY_IS_FOLLOWED = "isFollowed";
    private static final String KEY_RET = "ret";
    public static final String KEY_ROOM_ID = "roomId";
    public static final String KEY_UID = "uid";
    private static final int RET_CODE_GET_COOKIE_FAILED = 1;
    private static final int RET_CODE_GET_COOKIE_SUCCESS = 0;
    private static final String TAG = "QQIliveJsPlugin";
    public static final String VALUE_NULL = "null";
    public static final String WX_APPID_DEBUG = "wx76a769350165bcff";
    public static final String WX_APPID_RELEASE = "wxf0a80d0ac2e82aa7";
    private String mCloseCallbackId;
    private QQCustomDialog qqCustomDialog;
    private IWXAPI api = null;
    private boolean mH5LoadFinish = false;
    private HashMap<Long, Integer> mOptionMap = new HashMap<>();
    private boolean isSpecialAnchor = false;
    private a.InterfaceC11050a mObserver = new a.InterfaceC11050a() { // from class: com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.3
        @Override // q05.a.InterfaceC11050a
        public boolean onCall(String str, Bundle bundle) {
            if (!str.equals("ACTION_WEBVIEW_SHOW_GIFT_ICON_EVENT")) {
                return false;
            }
            QQIliveJsPlugin.this.notifyShowGiftIcon();
            return false;
        }
    };

    private void callNeedShowGiftIcon(int i3, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", i3);
        bundle.putString("message", str);
        bundle.putString(QWalletMixJsPlugin.PARAMS_CALLBACK_ID, str2);
        QLog.e(TAG, 1, "callNeedShowGiftIcon code:" + i3 + ", msg:" + str);
        q05.a.b().a("ACTION_WEBVIEW_NEED_SHOW_GIFT_ICON", bundle);
    }

    private LiveUserInfo getLoginInfo() {
        IQQLiveModuleLogin loginModule;
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        if (sDKImpl == null || (loginModule = sDKImpl.getLoginModule()) == null) {
            return null;
        }
        return loginModule.getUserInfo();
    }

    private long getRoomId() {
        return 0L;
    }

    private Activity getTopActivity() {
        return Foreground.getTopActivity();
    }

    private String getWXAppId() {
        return "wxf0a80d0ac2e82aa7";
    }

    private void handleOpenVideoGiftPanel(int i3) {
        WebViewPlugin.b bVar;
        QLog.i(TAG, 1, "[handleOpenVideoGiftPanel] subSceneId=" + i3);
        Activity topActivity = getTopActivity();
        if (topActivity == null && (bVar = this.mRuntime) != null) {
            topActivity = bVar.a();
        }
        if (topActivity == null) {
            QLog.e(TAG, 1, "[handleOpenGiftPanel] topActivity is null");
        } else if (((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId()) != null) {
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).openGiftPanelFragmentFromActivity(i3, getTopActivity());
        } else {
            QLog.e(TAG, 1, "handleOpenGiftPanel giftSDK is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyShowGiftIcon() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "notifyShowGiftIcon");
        }
        needShowGiftIcon("showQlivGiftIconEvent");
    }

    private void onIdentifyError(int i3, String str) {
        Activity topActivity = getTopActivity();
        if (topActivity == null) {
            QLog.e(TAG, 1, "onIdentifyError identifyFinish failed, topActivity is null");
            return;
        }
        QLog.e(TAG, 1, "onIdentifyError identifyFinish failed, code:" + i3 + ", message:" + str);
        if (i3 == -11153) {
            QLog.e(TAG, 1, "\u7528\u6237\u672a\u5b9e\u540d\u8ba4\u8bc1\uff0c\u4f46\u4e0d\u62e6\u622a\u9001\u793c\u9762\u677f");
        } else if (i3 == -11154) {
            showDialog(topActivity, str);
        } else {
            QLog.e(TAG, 1, "\u672a\u77e5\u9519\u8bef\uff0c\u4f46\u4e0d\u62e6\u622a\u9001\u793c\u9762\u677f");
        }
    }

    private void showDialog(Activity activity, String str) {
        if (this.qqCustomDialog == null) {
            this.qqCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, str, (String) null, "\u786e\u8ba4", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            }, (DialogInterface.OnClickListener) null);
        }
        if (this.qqCustomDialog.isShowing()) {
            return;
        }
        this.qqCustomDialog.show();
    }

    private void showToast(MqqHandler mqqHandler, final int i3) {
        mqqHandler.post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(MobileQQ.sMobileQQ, 0, i3, 0).show();
            }
        });
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "source|type|back", method = "enterLivePreparePage")
    public void enterLivePreparePage(String str, String str2, String str3) {
        if (this.mRuntime != null) {
            QLog.d(TAG, 1, "enterLivePreparePage... source:" + str + " roomType:" + str2 + " backTo:" + str3);
            Activity a16 = this.mRuntime.a();
            Intent intent = new Intent();
            if (!TextUtils.isEmpty(str) && !str.equals("null")) {
                intent.putExtra("source", Integer.parseInt(str));
            }
            if (!TextUtils.isEmpty(str2) && !str2.equals("null")) {
                intent.putExtra("room_type", Integer.parseInt(str2));
            }
            if (!TextUtils.isEmpty(str3) && !str3.equals("null")) {
                intent.putExtra("clear_top", str3);
            }
            if (a16 != null && !a16.isFinishing()) {
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterAnchorPrepareFragment(a16, intent);
                return;
            } else {
                QLog.d(TAG, 1, "the activity is null or is Destroyed");
                return;
            }
        }
        QLog.d(TAG, 1, "the runtime is null");
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = AudienceReportConst.ROOM_ID, method = "enterRoom")
    public void enterRoom(long j3) {
        ((IHourRank) QRoute.api(IHourRank.class)).enterRoom(j3);
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|p_uin|type", method = "followAnchor")
    public void followAnchor(final String str, String str2, final Object obj) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(VasLiveIPCModule.KEY_ANCHOR_UIN, str2);
            bundle.putInt(VasLiveIPCModule.KEY_FOLLOW_TYPE, ((Integer) obj).intValue());
            QIPCClientHelper.getInstance().getClient().callServer(VasLiveIPCModule.NAME, VasLiveIPCModule.ACTION_FOLLOW_ACCOUNT, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.1
                @Override // eipc.EIPCResultCallback
                public void onCallback(EIPCResult eIPCResult) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        Bundle bundle2 = eIPCResult.data;
                        int i3 = bundle2 != null ? bundle2.getInt("ret") : 0;
                        jSONObject.put("ret", i3);
                        QLog.i(QQIliveJsPlugin.TAG, 1, "followAnchor ret = " + i3 + " type = " + obj);
                        QQIliveJsPlugin.this.callJs(str, jSONObject.toString());
                        if (i3 == 0) {
                            Intent intent = new Intent();
                            intent.setAction(QQIliveJsPlugin.ACTION_NOTIFY_FOLLOW_CHANGE);
                            intent.putExtra(QQIliveJsPlugin.KEY_FOLLOW_STATE, (Integer) obj);
                            BaseApplicationImpl.getApplication().sendBroadcast(intent);
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            });
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "getCurrentRoomId")
    public void getCurrentRoomId(String str) {
        QLog.e(TAG, 1, "getCurrentRoomId callback = " + str);
        Bundle bundle = new Bundle();
        bundle.putString(QWalletMixJsPlugin.PARAMS_CALLBACK_ID, str);
        q05.a.b().a("ACTION_WEBVIEW_GET_CURRENT_ROOM_ID", bundle);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "getUserInfo")
    public void getUserInfo(String str) {
        QLog.i(TAG, 1, "getUserInfo");
        try {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime == null) {
                QLog.e(TAG, 1, "appInterface is null");
                callJsOnError(str, "appInterface is null");
                return;
            }
            if (!waitAppRuntime.isLogin()) {
                QLog.e(TAG, 1, "not login");
                callJsOnError(str, "not login");
                return;
            }
            String currentAccountUin = waitAppRuntime.getCurrentAccountUin();
            HashMap hashMap = new HashMap();
            hashMap.put("uin", currentAccountUin);
            hashMap.put("nick", (String) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_NICK, ""));
            hashMap.put("gender", String.valueOf(((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_GENDER, (Object) (-1))).intValue() - 1));
            hashMap.put("age", String.valueOf(((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_AGE, (Object) (-1))).intValue()));
            addCookies(hashMap, str, false);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            callJsOnError(str, "exception:" + th5.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "ma_name|ma_path|ma_type|ma_ext|callback", method = "linkToWxStore")
    public void linkToWxStore(String str, String str2, int i3, String str3, String str4) {
        QLog.w(TAG, 1, "launchMiniProgram. name:" + str + " path:" + str2 + " type:" + i3 + " ext:" + str3);
        if (this.api == null) {
            String wXAppId = getWXAppId();
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(BaseApplication.context, wXAppId, true);
            this.api = createWXAPI;
            createWXAPI.registerApp(wXAppId);
        }
        try {
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            if (!this.api.isWXAppInstalled()) {
                showToast(uIHandler, R.string.f170986w14);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ret", 1);
                callJs(str4, jSONObject.toString());
                return;
            }
            if (this.api.getWXAppSupportAPI() < 621086464) {
                showToast(uIHandler, R.string.f170987w15);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ret", 1);
                callJs(str4, jSONObject2.toString());
                return;
            }
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = str;
            req.miniprogramType = i3;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    req.path = URLDecoder.decode(str2, "UTF-8");
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "linkWxToStore: ", th5);
                }
            }
            if (str3 != null) {
                req.extData = str3;
            }
            this.api.sendReq(req);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ret", 0);
            callJs(str4, jSONObject3.toString());
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "linkWxToStore error: ", e16);
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = NodeProps.VISIBLE, method = "notifyVisibility")
    public void notifyVisibility(int i3) {
        QLog.e(TAG, 1, "notifyVisibility visible = " + i3);
        Bundle bundle = new Bundle();
        bundle.putBoolean("webview_visible", i3 == 1);
        q05.a.b().a("ACTION_WEBVIEW_VISIBILITY", bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        q05.a.b().c(this.mObserver);
        this.qqCustomDialog = null;
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "", method = "openGiftPanel")
    public void openGiftPanel() {
        openGiftPanel(0);
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|uin", method = "openGroupAioOrProfile")
    public void openGroupAioOrProfile(String str, String str2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("groupUin", str2);
            QIPCClientHelper.getInstance().getClient().callServer(VasLiveIPCModule.NAME, VasLiveIPCModule.ACTION_ENTER_GROUP, bundle, null);
            super.callJs(str);
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "url|height", method = "openHalfUrl")
    public void openHalfUrl(String str, int i3) {
        if (this.mRuntime != null) {
            QLog.i(TAG, 1, "openHalfUrl url=" + str + ",height=" + i3);
            Activity a16 = this.mRuntime.a();
            if (a16 != null && !a16.isFinishing()) {
                Bundle bundle = new Bundle();
                bundle.putInt("height_web_dialog", i3);
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(a16, str, bundle);
                return;
            }
            QLog.d(TAG, 1, "the activity is null or is Destroyed");
            return;
        }
        QLog.d(TAG, 1, "the runtime is null");
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "roomid", method = "switchLiveRoom")
    public void switchLiveRoom(String str) {
        ((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).enterRoom(new n05.a(BaseApplication.getContext(), "", str, "", false, null, "", 99));
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "switchRoomListener")
    public void switchRoomListener(String str) {
        QLog.e(TAG, 1, "switchRoomListener callback = " + str);
        Bundle bundle = new Bundle();
        bundle.putString(QWalletMixJsPlugin.PARAMS_CALLBACK_ID, str);
        q05.a.b().a("ACTION_WEBVIEW_SET_SWITCH", bundle);
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "uid|followedUid|isFollowed|roomId", method = "syncFollowState")
    public void syncFollowState(long j3, long j16, int i3, String str) {
        Intent intent = new Intent();
        intent.setAction("ACTION_QQ_LIVE_WEB_FOLLOW_STATE");
        intent.putExtra("uid", j3);
        intent.putExtra("followedUid", j16);
        intent.putExtra("isFollowed", i3);
        intent.putExtra("roomId", str);
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "[syncFollowState]:,uid:" + j3 + ",followedUid:" + j16 + ",isFollowed:" + i3 + ",roomId:" + str);
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "updateLoginInfo")
    public void updateLoginInfo(String str) {
        QLog.i(TAG, 1, "updateLoginInfo");
        try {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime == null) {
                QLog.e(TAG, 1, "appInterface is null");
                callJsOnError(str, "appInterface is null");
            } else if (!waitAppRuntime.isLogin()) {
                QLog.e(TAG, 1, "not login");
                callJsOnError(str, "not login");
            } else {
                addCookies(new HashMap(), str, true);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            callJsOnError(str, "exception:" + th5.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|roomId", method = "getLiveRoomIndex")
    public void getLiveRoomIndex(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("index", 0);
            jSONObject.put("count", 0);
            callJs(str, jSONObject.toString());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error getLiveRoomIndex " + e16);
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "", method = "loadH5Finish")
    public void loadH5Finish() {
        this.mH5LoadFinish = true;
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "qqlive_subscene_id", method = "openGiftPanel")
    public void openGiftPanel(int i3) {
        handleOpenVideoGiftPanel(i3);
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "url", method = DKWebViewController.DKHippyWebviewFunction.RELOAD)
    public void reload(String str) {
        QLog.e(TAG, 1, DKWebViewController.DKHippyWebviewFunction.RELOAD);
        Bundle bundle = new Bundle();
        bundle.putString("reload_url", str);
        q05.a.b().a("ACTION_WEBVIEW_RELOAD", bundle);
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "", method = "showGuide")
    public void showGuide() {
        QLog.e("IliveGuideModule", 1, "showGuide js");
        q05.a.b().a("ACTION_SHOW_GUIDE", null);
    }

    private void addCookies(final Map<String, String> map, final String str, boolean z16) {
        QQLiveCookieStrategyType qQLiveCookieStrategyType;
        if (z16) {
            qQLiveCookieStrategyType = QQLiveCookieStrategyType.FULL_NO_CACHE;
        } else {
            qQLiveCookieStrategyType = QQLiveCookieStrategyType.FULL;
        }
        ((IQQLiveCookieStrategyApi) QRoute.api(IQQLiveCookieStrategyApi.class)).getCookieStrategy(qQLiveCookieStrategyType).buildAsync(new CookieDataCallback() { // from class: com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.2
            private void callJsWithResult(int i3, Map<String, String> map2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    map.putAll(map2);
                    jSONObject.put("retCode", i3);
                    jSONObject.put("data", new JSONObject(map));
                    QQIliveJsPlugin.this.callJs(str, jSONObject.toString());
                    if (QLog.isColorLevel()) {
                        QLog.d(QQIliveJsPlugin.TAG, 2, "addCookies, rsp: " + jSONObject.toString());
                    }
                    QLog.i(QQIliveJsPlugin.TAG, 1, "addCookies retCode=" + i3);
                } catch (JSONException e16) {
                    QLog.e(QQIliveJsPlugin.TAG, 1, e16, new Object[0]);
                    QQIliveJsPlugin.this.callJs(str, jSONObject.toString());
                }
            }

            @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
            public void onFailed(int i3, String str2) {
                callJsWithResult(1, new HashMap());
            }

            @Override // com.tencent.timi.game.api.cookie.CookieDataCallback
            public void onSuccess(Map<String, String> map2) {
                ((IQQLiveCookiePlanterApi) QRoute.api(IQQLiveCookiePlanterApi.class)).plantCookies(map2);
                callJsWithResult(0, map2);
            }
        });
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "saveType", method = "closeAnchorLive")
    public void closeAnchorLive(int i3) {
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "needShowGiftIcon")
    public void needShowGiftIcon(String str) {
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "OperType", method = "notifyLiveMessage")
    public void notifyLiveMessage(int i3) {
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "registerCloseCallbackListener")
    public void registerCloseCallbackListener(String str) {
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "roomId|programId|status", method = "notifyStatus")
    public void notifyStatus(String str, String str2, String str3) {
    }
}
