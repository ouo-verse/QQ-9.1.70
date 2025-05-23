package com.tencent.qqmini.sdk.plugins.engine;

import NS_MINI_INTERFACE.INTERFACE$StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.re.h;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqmini.sdk.action.PhoneNumberAction;
import com.tencent.qqmini.sdk.auth.AuthFilterList;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionManager;
import com.tencent.qqmini.sdk.auth.parser.LocalPermissionParser;
import com.tencent.qqmini.sdk.auth.parser.RemotePermissionParser;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.AuthRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public abstract class BaseJsPluginEngine implements IJsPluginEngine {
    public static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String APP_IN_BACKGROUND_HINT = "Cannot show subscribe message UI";
    public static final String APP_IS_BANNED_HINT = "This mini program was banned from subscribing messages";
    private static final String CM_AVATAR_TYPE_2D = "2D";
    private static final String CM_AVATAR_TYPE_3D = "3D";
    private static final String CM_KEY_AVATAR_TYPE = "avatarType";
    private static final String CM_SCOPE_PERMISSION_2D = "scope.cmshowInfo2d";
    private static final String CM_SCOPE_PERMISSION_3D = "scope.cmshowInfo3d";
    public static final String EMPTY_PARAM_LIST_HINT = "msgTypeList can't be empty";
    public static final int ERROR_APP_IN_BACKGROUND = 10005;
    public static final int ERROR_APP_IS_BANNED = 20005;
    public static final int ERROR_EMPTY_PARAM_LIST = 10001;
    public static final int ERROR_INVALID_TEMPLATE_ID = 10004;
    public static final int ERROR_MAIN_SWITCH_OFF = 20004;
    public static final int ERROR_REQUEST_LIST_FAIL = 10002;
    public static final int ERROR_REQUEST_SUBSCRIBE_FAIL = 10003;
    private static final String EVENT_AUTHORIZE = "authorize";
    private static final String EVENT_GET_PHONE_NUMBER = "getPhoneNumber";
    private static final String EVENT_OPERATE_WXDATA = "operateWXData";
    private static final String EVENT_SUBSCRIBE_APP_MSG = "subscribeAppMsg";
    private static final String EVENT_SUBSCRIBE_ONCE_APP_MSG = "subscribeOnceAppMsg";
    private static final String EVENT_SUBSCRIBE_SYS_MSG = "requestSubscribeSystemMessage";
    public static final String INVALID_TEMPLATE_ID_HINT = "Invalid template id";
    private static final String KEY_API_NAME = "api_name";
    public static final String KEY_APPID = "key_appid";
    private static final String KEY_CALLBACK_ID = "key_callback_id";
    private static final String KEY_EVENT_NAME = "key_event_name";
    public static final String KEY_ONCE_SUB_RSP_DATA = "key_once_sub_rsp_data";
    private static final String KEY_PARAMS = "key_params";
    private static final String KEY_SCOPE_NAME = "key_scope_name";
    private static final String KEY_SETTING_ITEM = "key_setting_item";
    public static final String MAIN_SWITCH_OFF_HINT = "The main switch is switched off";
    public static final String REQUEST_LIST_FAIL_HINT = "Request list fail";
    public static final String REQUEST_SUBSCRIBE_FAIL_HINT = "Request subscribe fail";
    private static final String SCOPE_EXPAND_USER_INFO = "scope.expandUserInfo";
    private static final String SCOPE_NEARBY_USER_INFO = "scope.nearbyUserInfo";
    private static final String SCOPE_USER_INFO = "scope.userInfo";
    public static final String SETTING_APP_MSG_SUBSCRIBED = "setting.appMsgSubscribed";
    public static final String SETTING_APP_ONCE_MSG_SUBSCRIBED = "setting.onceMsgSubscribed";
    public static final String SETTING_SHARE_FRIENDSHIP = "setting.shareFriendship";
    public static final String SETTING_SYS_MSG_SUBSCRIBED = "setting.sysMsgSubscribed";
    private static final int SUBSCRIBE_CODE_FAIL_OTHER = -2;
    private static final int SUBSCRIBE_CODE_REJECT = -1;
    private static final int SUBSCRIBE_CODE_REJECT_FIRST = 0;
    private static final int SUBSCRIBE_CODE_SUC = 1;
    private static final String TAG = "JsPluginEngine[AuthGuard]";
    private static final int WHAT_NOTIFY_SCOPE_PERMISSION_QUEUE = 1;
    private static final int WHAT_SHOW_AUTH_DIALOG = 2;
    private RequestEvent curScopeEvent;
    private boolean isFirstTimeRequestAuth;
    protected IMiniAppContext mMiniAppContext;
    private RequestEvent onceSubMsgReq;
    private boolean isFirstShowFriendshipDialog = true;
    private AuthJsProxy mAuthJsProxy = (AuthJsProxy) ProxyManager.get(AuthJsProxy.class);
    DialogInterface.OnDismissListener onceSubDismissListener = new DialogInterface.OnDismissListener() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.1
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Bundle authDialogBundleData = BaseJsPluginEngine.this.mAuthJsProxy.getAuthDialogBundleData();
            boolean isAuthConfirm = BaseJsPluginEngine.this.mAuthJsProxy.isAuthConfirm();
            boolean isAuthRefuse = BaseJsPluginEngine.this.mAuthJsProxy.isAuthRefuse();
            if (authDialogBundleData != null) {
                boolean z16 = authDialogBundleData.getBoolean("key_once_sub_cb_maintain");
                if ("requestSubscribeSystemMessage".equals(authDialogBundleData.getString(BaseJsPluginEngine.KEY_EVENT_NAME))) {
                    z16 = true;
                }
                boolean z17 = z16;
                boolean z18 = authDialogBundleData.getBoolean("key_once_sub_cb1");
                boolean z19 = authDialogBundleData.getBoolean("key_once_sub_cb2");
                boolean z26 = authDialogBundleData.getBoolean("key_once_sub_cb3");
                byte[] byteArray = authDialogBundleData.getByteArray("key_once_sub_rsp_data");
                INTERFACE$StGetUserSettingRsp iNTERFACE$StGetUserSettingRsp = new INTERFACE$StGetUserSettingRsp();
                if (byteArray != null) {
                    try {
                        iNTERFACE$StGetUserSettingRsp.mergeFrom(byteArray);
                    } catch (Throwable th5) {
                        QMLog.e(BaseJsPluginEngine.TAG, "onceSubDismissListner - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", th5);
                    }
                }
                if (iNTERFACE$StGetUserSettingRsp.setting != null) {
                    BaseJsPluginEngine.this.handleSubMsgDialogDismiss(authDialogBundleData.getString(BaseJsPluginEngine.KEY_SETTING_ITEM), z17, z18, z19, z26, isAuthConfirm, isAuthRefuse, iNTERFACE$StGetUserSettingRsp);
                } else {
                    BaseJsPluginEngine baseJsPluginEngine = BaseJsPluginEngine.this;
                    baseJsPluginEngine.onceSubMsgCallbackFail(baseJsPluginEngine.onceSubMsgReq, BaseJsPluginEngine.REQUEST_LIST_FAIL_HINT, 10002);
                }
            }
            if (isAuthConfirm) {
                BaseJsPluginEngine.this.mAuthJsProxy.reportMiniAppEvent("click");
            } else {
                BaseJsPluginEngine.this.mAuthJsProxy.reportMiniAppEvent("cancel");
            }
            BaseJsPluginEngine.this.onPermissionDialogDismissed();
        }
    };
    private Map<Integer, PhoneNumberAction.PhoneNumberActionCallback> mPhoneNumberActionCallbackMap = new ConcurrentHashMap();
    private DialogInterface.OnDismissListener dismissListener = new DialogInterface.OnDismissListener() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.3
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            String str;
            int i3;
            String str2;
            PhoneNumberAction.PhoneNumberActionCallback phoneNumberActionCallback;
            Bundle authDialogBundleData = BaseJsPluginEngine.this.mAuthJsProxy.getAuthDialogBundleData();
            if (authDialogBundleData != null) {
                str = authDialogBundleData.getString(BaseJsPluginEngine.KEY_EVENT_NAME);
                str2 = authDialogBundleData.getString(BaseJsPluginEngine.KEY_PARAMS);
                i3 = authDialogBundleData.getInt("key_callback_id");
            } else {
                str = null;
                i3 = -1;
                str2 = null;
            }
            String requestScopePermission = BaseJsPluginEngine.this.getRequestScopePermission(str, str2);
            if (TextUtils.isEmpty(requestScopePermission) && authDialogBundleData != null) {
                requestScopePermission = authDialogBundleData.getString(BaseJsPluginEngine.KEY_SCOPE_NAME);
            }
            boolean isAuthConfirm = BaseJsPluginEngine.this.mAuthJsProxy.isAuthConfirm();
            boolean isAuthRefuse = BaseJsPluginEngine.this.mAuthJsProxy.isAuthRefuse();
            QMLog.d(BaseJsPluginEngine.TAG, "onDismiss eventName=" + str + ",scopeName=" + requestScopePermission + ",isConfirm=" + isAuthConfirm + ",isRefuse=" + isAuthRefuse);
            Message obtainMessage = BaseJsPluginEngine.this.mHandler.obtainMessage(1);
            if (isAuthConfirm) {
                obtainMessage.arg1 = 1;
                BaseJsPluginEngine.this.setScopePermissionAuthState(requestScopePermission, true);
                BaseJsPluginEngine.this.mAuthJsProxy.reportMiniAppEvent("click");
            } else if (isAuthRefuse) {
                obtainMessage.arg1 = 2;
                obtainMessage.obj = requestScopePermission;
                BaseJsPluginEngine.this.setScopePermissionAuthState(requestScopePermission, false);
                BaseJsPluginEngine.this.mAuthJsProxy.reportMiniAppEvent("cancel");
            } else {
                obtainMessage.arg1 = 3;
                obtainMessage.obj = requestScopePermission;
                BaseJsPluginEngine.this.mAuthJsProxy.reportMiniAppEvent("cancel");
            }
            if (i3 != -1 && BaseJsPluginEngine.this.mPhoneNumberActionCallbackMap.containsKey(Integer.valueOf(i3)) && (phoneNumberActionCallback = (PhoneNumberAction.PhoneNumberActionCallback) BaseJsPluginEngine.this.mPhoneNumberActionCallbackMap.remove(Integer.valueOf(i3))) != null) {
                phoneNumberActionCallback.onGetAuthDialogRet(isAuthConfirm, BaseJsPluginEngine.this.mAuthJsProxy.getSelectPhoneNumber());
            }
            obtainMessage.sendToTarget();
            BaseJsPluginEngine.this.mAuthJsProxy.setAuthDialogToNull();
            BaseJsPluginEngine.this.onPermissionDialogDismissed();
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.4
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                BaseJsPluginEngine.this.notifyScopePermissionQueue(message);
                return false;
            }
            if (i3 == 2) {
                BaseJsPluginEngine.this.showAuthDialog(message.getData());
                return false;
            }
            return false;
        }
    });
    ConcurrentLinkedQueue<AuthRequestEvent> scopePermissionQueue = new ConcurrentLinkedQueue<>();
    private final f mPermissionReqApi = createPermissionReqImpl();

    public BaseJsPluginEngine(Context context) {
        initPermissionParser(context);
    }

    private String checkRequestScopePermission(RequestEvent requestEvent) {
        String str = requestEvent.event;
        String str2 = requestEvent.jsonParams;
        if ("subscribeAppMsg".equals(str)) {
            return reqGrantSubscribeApiPermission(requestEvent);
        }
        if ("subscribeOnceAppMsg".equals(str)) {
            reqGrantOnceSubscribeApiPermission(requestEvent);
            return "";
        }
        if ("requestSubscribeSystemMessage".equals(str)) {
            reqGrantSystemSubscribeApiPermission(requestEvent);
            return "";
        }
        String appId = getAppId();
        AuthState authSate = MiniAppEnv.g().getAuthSate(appId);
        String requestScopePermission = getRequestScopePermission(str, str2);
        if (isGrantedAuthorize(str, str2, appId, authSate, requestScopePermission)) {
            if ("authorize".equals(requestEvent.event)) {
                return handleAuthorizeEvent(requestEvent);
            }
            return dispatchRequestEvent(requestEvent);
        }
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        MiniAppInfo miniAppInfo = this.mMiniAppContext.getMiniAppInfo();
        if (!TextUtils.isEmpty(requestScopePermission) && isShowAuthDialog(requestScopePermission, str, str2) && !checkPrivacyAgreementAgreed(appId, str) && attachActivity != null && miniAppInfo != null) {
            showUserAgreementDialog(attachActivity, miniAppInfo, requestEvent, authSate, requestScopePermission);
        } else {
            showRequestPermissionDialog(requestEvent, requestScopePermission);
        }
        return "";
    }

    private boolean checkSelfPermission(Activity activity, String str, String str2) {
        boolean z16;
        boolean z17;
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str2)) {
            if (activity.checkSelfPermission(str2) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
            if (activity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && !"authorize".equals(str)) {
                return true;
            }
            return false;
        }
        if (activity.checkSelfPermission(str2) == 0) {
            return true;
        }
        return false;
    }

    private void doShowAuthDialog(String str, String str2, String str3) {
        String str4;
        BaseJsPluginEngine baseJsPluginEngine;
        String str5;
        String str6;
        String str7;
        JSONObject optJSONObject;
        PermissionInfo scopePermission = PermissionManager.g().getScopePermission(str2);
        if (scopePermission != null) {
            str4 = scopePermission.name;
            str6 = scopePermission.description;
            String str8 = scopePermission.rejectDescription;
            str5 = scopePermission.reportSubAction;
            baseJsPluginEngine = this;
            str7 = str8;
        } else {
            str4 = "";
            baseJsPluginEngine = this;
            str5 = "";
            str6 = str5;
            str7 = str6;
        }
        Context context = baseJsPluginEngine.mMiniAppContext.getContext();
        ApkgInfo apkgInfo = getApkgInfo();
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (apkgInfo == null) {
            return;
        }
        String str9 = apkgInfo.iconUrl;
        String str10 = apkgInfo.apkgName;
        JSONObject jSONObject = apkgInfo.mAppConfigInfo.permissionInfo;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(str2)) != null) {
            str6 = optJSONObject.optString("desc", str6);
        }
        String str11 = str6;
        if (!"scope.userInfo".equals(str2) && !"scope.expandUserInfo".equals(str2) && !"scope.nearbyUserInfo".equals(str2)) {
            showDefaultAuthDialog(str, str4, str11, str7, str5, context, miniAppProxy, str9, str10, str3);
        } else {
            showScopeUserInfoAuthDialog(str4, str11, str7, str5, context, apkgInfo, channelProxy, miniAppProxy, str9, str10, str3);
        }
    }

    private static String extractApiNameInJsonParams(String str) {
        if (str == null) {
            return "";
        }
        try {
            if (!str.contains("api_name")) {
                return "";
            }
            String optString = new JSONObject(str).optString("api_name");
            if (!TextUtils.isEmpty(optString)) {
                return optString.trim();
            }
            return optString;
        } catch (Throwable unused) {
            return "";
        }
    }

    private JSONArray extractPhoneNumberList(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("getPhoneNumber");
            if (optJSONObject != null && optJSONObject.has("phoneLists")) {
                return optJSONObject.optJSONArray("phoneLists");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "get phoneNumberList error,", th5);
        }
        return null;
    }

    private static String extractScopeNameInJsonParams(String str) {
        try {
            String string = new JSONObject(str).optJSONArray("scope").getString(0);
            if (!TextUtils.isEmpty(string)) {
                return string.trim();
            }
            return string;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    private int getAuthDialogType(String str, String str2) {
        if ("getPhoneNumber".equals(str)) {
            return 2;
        }
        if ("subscribeOnceAppMsg".equals(str)) {
            return 3;
        }
        if ("requestSubscribeSystemMessage".equals(str)) {
            return 4;
        }
        if (!"scope.userInfo".equals(str2) && !"scope.expandUserInfo".equals(str2) && !"scope.nearbyUserInfo".equals(str2)) {
            return 1;
        }
        return 5;
    }

    private static String getCMShowInfoScopeName(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("scope");
            if (!TextUtils.isEmpty(optString)) {
                str3 = optString;
            }
            String optString2 = jSONObject.optString(CM_KEY_AVATAR_TYPE);
            if (CM_AVATAR_TYPE_2D.equals(optString2)) {
                str2 = CM_SCOPE_PERMISSION_2D;
            } else if (CM_AVATAR_TYPE_3D.equals(optString2)) {
                str2 = CM_SCOPE_PERMISSION_3D;
            } else {
                return str3;
            }
            return str2;
        } catch (Exception e16) {
            e16.printStackTrace();
            return str3;
        }
    }

    private static String getRequestSystemPermission(String str, String str2) {
        if ("authorize".equals(str)) {
            return PermissionManager.g().getEventRequestSystemPermission(PermissionManager.g().getEventByScopePermission(extractScopeNameInJsonParams(str2)));
        }
        return PermissionManager.g().getEventRequestSystemPermission(str);
    }

    private int getScopePermissionAuthFlag(String str) {
        return getScopePermissionAuthFlag(str, null);
    }

    public static String getScopePluginSetauthName(String str, String str2) {
        return "scope.plugin.setauth." + str + "." + str2;
    }

    @NotNull
    private AsyncResult getUpdateOnceSubMsgListener(final boolean z16, final boolean z17, final List<INTERFACE$StSubscribeMessage> list, final List<INTERFACE$StSubscribeMessage> list2, final List<INTERFACE$StSubscribeMessage> list3) {
        return new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z18, JSONObject jSONObject) {
                if (z18 && BaseJsPluginEngine.this.onceSubMsgReq != null) {
                    if (z16) {
                        BaseJsPluginEngine baseJsPluginEngine = BaseJsPluginEngine.this;
                        baseJsPluginEngine.onceSubMsgCallbackSuc(baseJsPluginEngine.onceSubMsgReq, list, list2, list3, false);
                        BaseJsPluginEngine.this.mAuthJsProxy.setAuthDialogToNull();
                        return;
                    } else if (z17) {
                        BaseJsPluginEngine baseJsPluginEngine2 = BaseJsPluginEngine.this;
                        baseJsPluginEngine2.onceSubMsgCallbackSuc(baseJsPluginEngine2.onceSubMsgReq, list, list2, list3, true);
                        BaseJsPluginEngine.this.mAuthJsProxy.setAuthDialogToNull();
                        return;
                    } else {
                        BaseJsPluginEngine baseJsPluginEngine3 = BaseJsPluginEngine.this;
                        baseJsPluginEngine3.onceSubMsgCallbackSuc(baseJsPluginEngine3.onceSubMsgReq, list);
                        BaseJsPluginEngine.this.mAuthJsProxy.setAuthDialogToNull();
                        return;
                    }
                }
                if (BaseJsPluginEngine.this.onceSubMsgReq != null) {
                    BaseJsPluginEngine baseJsPluginEngine4 = BaseJsPluginEngine.this;
                    baseJsPluginEngine4.onceSubMsgCallbackFail(baseJsPluginEngine4.onceSubMsgReq, BaseJsPluginEngine.REQUEST_SUBSCRIBE_FAIL_HINT, 10003);
                }
            }
        };
    }

    private void grantSubscribePermissionSilent(AuthState authState, String str, final RequestEvent requestEvent) {
        authState.setAuthState(str, true, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.8
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    requestEvent.ok();
                } else {
                    requestEvent.fail(jSONObject, null);
                }
            }
        });
    }

    private void handleAuthRefuse(Message message, Iterator<AuthRequestEvent> it) {
        String str = (String) message.obj;
        QMLog.e(TAG, "handleAuthRefuse, scopeName:" + str);
        if (!TextUtils.isEmpty(str) && !str.equals("setting.appMsgSubscribed")) {
            if (str.equals(AuthorizeCenter.SCOPE_CAMERA)) {
                this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(h.NAME, null, 0));
            }
            RequestEvent requestEvent = this.curScopeEvent;
            if (requestEvent != null && str.equals(getRequestScopePermission(requestEvent.event, requestEvent.jsonParams))) {
                this.curScopeEvent.fail("auth deny");
            }
            while (it.hasNext()) {
                AuthRequestEvent next = it.next();
                if (str.equals(getRequestScopePermission(next.event, next.jsonParams))) {
                    it.remove();
                    next.fail("auth deny");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String handleAuthorizeEvent(RequestEvent requestEvent) {
        return handleAuthorizeEvent(requestEvent, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnceSubscribeResponse(RequestEvent requestEvent, boolean z16, JSONObject jSONObject) {
        if (z16) {
            try {
                String optString = jSONObject.optString("settingItem");
                Object opt = jSONObject.opt("originalData");
                INTERFACE$StGetUserSettingRsp iNTERFACE$StGetUserSettingRsp = new INTERFACE$StGetUserSettingRsp();
                if (opt instanceof byte[]) {
                    byte[] bArr = (byte[]) opt;
                    iNTERFACE$StGetUserSettingRsp.mergeFrom(bArr);
                    List<INTERFACE$StSubscribeMessage> list = iNTERFACE$StGetUserSettingRsp.setting.subItems.get();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = list.get(i3);
                        if (iNTERFACE$StSubscribeMessage.authState.get() == 0) {
                            arrayList.add(iNTERFACE$StSubscribeMessage);
                        } else if (iNTERFACE$StSubscribeMessage.authState.get() == 1) {
                            arrayList2.add(iNTERFACE$StSubscribeMessage);
                        } else if (iNTERFACE$StSubscribeMessage.authState.get() == 2) {
                            arrayList3.add(iNTERFACE$StSubscribeMessage);
                        }
                    }
                    AuthState authSate = MiniAppEnv.g().getAuthSate(getAppId());
                    recordIfNeedMaintain(optString, arrayList2, arrayList3, authSate);
                    if (arrayList.size() > 0 && arrayList.size() <= 3) {
                        if (AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo())) {
                            grantOnceSubscribeApiPermissionSilent(optString, requestEvent, bArr);
                            return;
                        } else {
                            onceSubscribeRequestEnqueue(optString, requestEvent, bArr);
                            return;
                        }
                    }
                    if ("setting.onceMsgSubscribed".equals(optString) && arrayList2.size() > 0) {
                        updateOnceMsgSubscribedItem(requestEvent, optString, list, arrayList2, authSate);
                        return;
                    } else {
                        onceSubMsgCallbackSuc(requestEvent, list);
                        return;
                    }
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "handleOnceSubscribeResponse get an Error:", th5);
            }
        }
        onceSubMsgCallbackFail(requestEvent, jSONObject);
    }

    private static String handleOperateWXDataScopeName(String str, String str2) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            String optString = optJSONObject.optString("api_name");
            if (AuthorizeCenter.KEY_API_NAME_PLUGIN_LOGIN.equals(optString) || AuthorizeCenter.KEY_API_NAME_PLUGIN_GETUSERINFO.equals(optString)) {
                String optString2 = optJSONObject.optJSONObject("data").optString("miniprogram_appid");
                String optString3 = optJSONObject.optString("plugin_appid");
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    return getScopePluginSetauthName(optString2, optString3);
                }
                return str2;
            }
            return str2;
        } catch (Throwable th5) {
            th5.printStackTrace();
            QMLog.e(TAG, "handleOperateWXDataScopeName " + th5.getMessage(), th5);
            return str2;
        }
    }

    @RequiresApi(api = 23)
    private void handleRequestSystemPermission(final RequestEvent requestEvent, final String str, final String str2, String str3, Activity activity) {
        this.mPermissionReqApi.a(activity, str3, new e() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.5
            @Override // com.tencent.qqmini.sdk.plugins.engine.e
            public void onFailed() {
                QMLog.d(BaseJsPluginEngine.TAG, "request system permission user denied");
                requestEvent.fail("system permission denied");
            }

            @Override // com.tencent.qqmini.sdk.plugins.engine.e
            public void onPartialGrant() {
                QMLog.d(BaseJsPluginEngine.TAG, "request system permission user partial granted");
                BaseJsPluginEngine.this.setScopePermissionAuthState(BaseJsPluginEngine.this.getRequestScopePermission(str, str2), true);
                if ("authorize".equals(requestEvent.event)) {
                    BaseJsPluginEngine.this.handleAuthorizeEvent(requestEvent);
                } else {
                    BaseJsPluginEngine.this.dispatchRequestEvent(requestEvent);
                }
            }

            @Override // com.tencent.qqmini.sdk.plugins.engine.e
            public void onSucceed() {
                QMLog.d(BaseJsPluginEngine.TAG, "request system permission user granted");
                BaseJsPluginEngine.this.setScopePermissionAuthState(BaseJsPluginEngine.this.getRequestScopePermission(str, str2), true);
                if ("authorize".equals(requestEvent.event)) {
                    BaseJsPluginEngine.this.handleAuthorizeEvent(requestEvent);
                } else {
                    BaseJsPluginEngine.this.dispatchRequestEvent(requestEvent);
                }
            }
        });
    }

    private void handleSubMsgAuthListData(boolean z16, boolean z17, boolean z18, boolean z19, List<INTERFACE$StSubscribeMessage> list, List<INTERFACE$StSubscribeMessage> list2) {
        int size = list.size();
        if (size != 1) {
            if (size != 2) {
                if (size == 3) {
                    INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = list.get(0);
                    INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage2 = list.get(1);
                    INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage3 = list.get(2);
                    if (!judgeOnceSubMsgState(z16, z17, iNTERFACE$StSubscribeMessage)) {
                        list.remove(iNTERFACE$StSubscribeMessage);
                        list2.add(iNTERFACE$StSubscribeMessage);
                    }
                    if (!judgeOnceSubMsgState(z16, z18, iNTERFACE$StSubscribeMessage2)) {
                        list.remove(iNTERFACE$StSubscribeMessage2);
                        list2.add(iNTERFACE$StSubscribeMessage2);
                    }
                    if (!judgeOnceSubMsgState(z16, z19, iNTERFACE$StSubscribeMessage3)) {
                        list.remove(iNTERFACE$StSubscribeMessage3);
                        list2.add(iNTERFACE$StSubscribeMessage3);
                        return;
                    }
                    return;
                }
                return;
            }
            INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage4 = list.get(0);
            INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage5 = list.get(1);
            if (!judgeOnceSubMsgState(z16, z17, iNTERFACE$StSubscribeMessage4)) {
                list.remove(iNTERFACE$StSubscribeMessage4);
                list2.add(iNTERFACE$StSubscribeMessage4);
            }
            if (!judgeOnceSubMsgState(z16, z18, iNTERFACE$StSubscribeMessage5)) {
                list.remove(iNTERFACE$StSubscribeMessage5);
                list2.add(iNTERFACE$StSubscribeMessage5);
                return;
            }
            return;
        }
        INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage6 = list.get(0);
        if (!judgeOnceSubMsgState(z16, z17, iNTERFACE$StSubscribeMessage6)) {
            list.remove(iNTERFACE$StSubscribeMessage6);
            list2.add(iNTERFACE$StSubscribeMessage6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSubMsgDialogDismiss(String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, INTERFACE$StGetUserSettingRsp iNTERFACE$StGetUserSettingRsp) {
        List<INTERFACE$StSubscribeMessage> list = iNTERFACE$StGetUserSettingRsp.setting.subItems.get();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = list.get(i3);
            if (iNTERFACE$StSubscribeMessage.authState.get() == 0) {
                arrayList.add(iNTERFACE$StSubscribeMessage);
                setAuthMsgData(arrayList3, iNTERFACE$StSubscribeMessage, z16, z26);
            }
        }
        AsyncResult updateOnceSubMsgListener = getUpdateOnceSubMsgListener(z26, z27, list, arrayList, arrayList2);
        AuthState authSate = MiniAppEnv.g().getAuthSate(getAppId());
        if (z26) {
            handleSubMsgAuthListData(z16, z17, z18, z19, arrayList, arrayList2);
            authSate.updateOnceSubMsgSetting(str, true, arrayList3, updateOnceSubMsgListener);
            if (arrayList3.size() > 0 && "setting.sysMsgSubscribed".equals(str)) {
                authSate.updateIsSysSubMsgMaintain(true);
                return;
            }
            return;
        }
        if (z27) {
            if (z16) {
                for (int i16 = 0; i16 < arrayList.size(); i16++) {
                    arrayList.get(i16).authState.set(2);
                }
                authSate.updateOnceSubMsgSetting(str, false, arrayList, updateOnceSubMsgListener);
            } else {
                updateOnceSubMsgListener.onReceiveResult(true, null);
            }
            if ("setting.sysMsgSubscribed".equals(str)) {
                authSate.updateIsSysSubMsgMaintain(true);
                return;
            }
            return;
        }
        updateOnceSubMsgListener.onReceiveResult(true, null);
    }

    private void initAuthDialog(Bundle bundle, Activity activity, int i3) {
        if (!this.mAuthJsProxy.isAuthDialogInit() || this.mAuthJsProxy.getAuthDialogType() != i3) {
            AuthJsProxy.AuthDialogResConfig authDialogResConfig = new AuthJsProxy.AuthDialogResConfig();
            authDialogResConfig.dialogType = i3;
            authDialogResConfig.miniAppContext = this.mMiniAppContext;
            this.mAuthJsProxy.setAuthDialogBundleData(bundle);
            this.mAuthJsProxy.initAuthDialog(activity, authDialogResConfig);
            if (i3 != 3 && i3 != 4) {
                this.mAuthJsProxy.setOnDismissListener(this.dismissListener);
            } else {
                this.mAuthJsProxy.setOnDismissListener(this.onceSubDismissListener);
            }
        }
    }

    private boolean isGrantedAuthorize(String str, String str2, String str3, AuthState authState, String str4) {
        boolean z16;
        boolean z17 = true;
        if ((AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo()) || AuthFilterList.isAppInWhiteList(str3)) && authState.getAuthFlag(str4) == 1) {
            setScopePermissionAuthState(str4, true);
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && isOpenDataEvent(str, str2)) {
            z16 = true;
        }
        if (!z16 && str4 == null) {
            z16 = true;
        }
        if (!z16 && getScopePermissionAuthFlag(str4, str2) == 2) {
            z16 = true;
        }
        if (z16 && shouldAskEveryTime(str4)) {
            z16 = false;
        }
        if (z16 || !isMakeReuqestFirstEvent(str)) {
            z17 = z16;
        }
        if (!z17) {
            QMLog.e(TAG, "checkRequestScopePermission granted=" + z17 + ",eventName=" + str);
        }
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        MiniAppInfo miniAppInfo = this.mMiniAppContext.getMiniAppInfo();
        if (attachActivity != null && miniAppInfo != null && !TextUtils.isEmpty(str4) && isShowAuthDialog(str4, str, str2) && !checkPrivacyAgreementAgreed(str3, str)) {
            QMLog.e(TAG, "checkRequestScopePermission privacy agreement not agreed, eventName=" + str);
            return false;
        }
        return z17;
    }

    private boolean isMakeReuqestFirstEvent(String str) {
        if ("getPhoneNumber".equals(str)) {
            return true;
        }
        return false;
    }

    private static boolean isOpenDataApi(String str) {
        if (!AuthorizeCenter.KEY_API_NAME_GET_USER_INFO_OPEN_DATA.equals(str) && !AuthorizeCenter.KEY_API_NAME_GET_ADVERT.equals(str) && !AuthorizeCenter.KEY_API_NAME_RUN_STEP_HISTORY.equals(str) && !AuthorizeCenter.KEY_API_NAME_CLICK_ADVERT.equals(str) && !AuthorizeCenter.KEY_API_NAME_GET_BLOCK_AD.equals(str) && !AuthorizeCenter.KEY_API_NAME_GET_NAVIGATE_WX_APPINFO.equals(str) && !AuthorizeCenter.KEY_API_NAME_PLUGIN_SETAUTH.equals(str)) {
            return false;
        }
        return true;
    }

    private static boolean isOpenDataEvent(String str, String str2) {
        if ("operateWXData".equals(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject("data");
                String optString = optJSONObject.optString("api_name");
                if (isOpenDataApi(optString)) {
                    return true;
                }
                if (AuthorizeCenter.KEY_API_NAME_PLUGIN_LOGIN.equals(optString) || AuthorizeCenter.KEY_API_NAME_PLUGIN_GETUSERINFO.equals(optString)) {
                    String optString2 = optJSONObject.optJSONObject("data").optString("miniprogram_appid");
                    String optString3 = optJSONObject.optString("plugin_appid");
                    String allowPluginScopeName = AuthState.getAllowPluginScopeName();
                    if (allowPluginScopeName != null) {
                        if (allowPluginScopeName.equals(getScopePluginSetauthName(optString2, optString3))) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private static boolean isScopePermissionValid(String str) {
        return PermissionManager.g().isScopePermissionValid(str);
    }

    private boolean isShowAuthDialog(String str, String str2, String str3) {
        boolean z16 = false;
        if (!isOpenDataEvent(str2, str3) && getScopePermissionAuthFlag(str) == 4) {
            z16 = true;
        }
        QMLog.d(TAG, "isShowAuthDialog hasRefused=" + z16);
        return needShowAuthDialog(str, str2, str3, z16);
    }

    private boolean judgeOnceSubMsgState(boolean z16, boolean z17, INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage) {
        if (z16) {
            if (z17) {
                iNTERFACE$StSubscribeMessage.authState.set(1);
            } else {
                iNTERFACE$StSubscribeMessage.authState.set(2);
            }
        } else {
            if (!z17) {
                return false;
            }
            iNTERFACE$StSubscribeMessage.authState.set(0);
        }
        return true;
    }

    private boolean needShowAuthDialog(String str, String str2, String str3, boolean z16) {
        boolean z17;
        boolean z18 = true;
        if (z16 && !shouldAskEveryTime(str)) {
            z17 = false;
        } else {
            z17 = true;
        }
        try {
            if ("operateWXData".equals(str2)) {
                JSONObject optJSONObject = new JSONObject(str3).optJSONObject("data");
                String optString = optJSONObject.optString("api_name");
                if (!AuthorizeCenter.KEY_API_NAME_GET_USER_INFO.equals(optString) && !AuthorizeCenter.KEY_API_NAME_GET_SUBJECT_ALTER_INFO.equals(optString) && !AuthorizeCenter.KEY_API_NAME_WXA_SUBSCRIBE_BIZ.endsWith(optString)) {
                    if (AuthorizeCenter.KEY_API_NAME_PLUGIN_LOGIN.equals(optString) || AuthorizeCenter.KEY_API_NAME_PLUGIN_GETUSERINFO.equals(optString) || AuthorizeCenter.KEY_API_NAME_PLUGIN_SETAUTH.equals(optString)) {
                        z17 = false;
                    }
                }
                z17 = optJSONObject.optBoolean(AuthorizeCenter.KEY_IS_REQUEST_USER_INFO_AUTH_BY_USER);
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, Log.getStackTraceString(th5));
        }
        if (z16) {
            if (!z17 && !shouldAskEveryTimeWhenRejected(str)) {
                z18 = false;
            }
            z17 = z18;
        }
        if (AuthFilterList.isEventInFriendshipBlackList(str2)) {
            if (!this.isFirstShowFriendshipDialog) {
                return false;
            }
            this.isFirstShowFriendshipDialog = false;
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyScopePermissionQueue(Message message) {
        boolean z16;
        RequestEvent requestEvent;
        if (this.mAuthJsProxy.isAuthDialogShow()) {
            QMLog.e(TAG, "notifyScopePermissionQueue fail, already showing a dialog");
            return;
        }
        int i3 = message.arg1;
        Iterator<AuthRequestEvent> it = this.scopePermissionQueue.iterator();
        if (i3 != 3 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QMLog.e(TAG, "notifyScopePermissionQueue AUTH_FLAG_CANCEL / AUTH_FLAG_REFUSE");
            handleAuthRefuse(message, it);
        } else {
            RequestEvent requestEvent2 = this.curScopeEvent;
            if (requestEvent2 != null && "authorize".equals(requestEvent2.event) && i3 == 1) {
                this.curScopeEvent.ok();
                QMLog.e(TAG, "notifyScopePermissionQueue AUTH_FLAG_GRANT && EVENT_AUTHORIZE");
                handleNextScopeReq();
                return;
            }
        }
        RequestEvent requestEvent3 = this.curScopeEvent;
        if (requestEvent3 != null && "subscribeAppMsg".equals(requestEvent3.event)) {
            if (i3 == 3) {
                RequestEvent requestEvent4 = this.curScopeEvent;
                setScopePermissionAuthState(getRequestScopePermission(requestEvent4.event, requestEvent4.jsonParams), false);
            }
            reqGrantSubscribeApiPermission(this.curScopeEvent);
        } else if (!z16 && (requestEvent = this.curScopeEvent) != null && !"getPhoneNumber".equals(requestEvent.event)) {
            dispatchRequestEvent(this.curScopeEvent);
        }
        handleNextScopeReq();
    }

    private void recordIfNeedMaintain(String str, List<INTERFACE$StSubscribeMessage> list, List<INTERFACE$StSubscribeMessage> list2, AuthState authState) {
        if (list.size() > 0 || list2.size() > 0) {
            if ("setting.sysMsgSubscribed".equals(str)) {
                authState.updateIsSysSubMsgMaintain(true);
            } else if ("setting.onceMsgSubscribed".equals(str)) {
                authState.updateIsOnceSubMsgMaintain(true);
            }
        }
    }

    private void removeAllMessage() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    private void reqGrantOnceSubscribeApiPermission(final RequestEvent requestEvent) {
        try {
            JSONArray optJSONArray = new JSONObject(requestEvent.jsonParams).optJSONArray("tmplIds");
            if (optJSONArray != null) {
                ArrayList<String> arrayList = new ArrayList<>();
                if (optJSONArray.length() > 3) {
                    onceSubMsgCallbackFail(requestEvent, "Templates count out of max bounds", 20003);
                    return;
                }
                if (optJSONArray.length() == 0) {
                    onceSubMsgCallbackFail(requestEvent, "TmplIds can't be empty", 10001);
                    return;
                }
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add(optJSONArray.getString(i3));
                }
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getUserSetting(getAppId(), "", "setting.onceMsgSubscribed", arrayList, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.9
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        BaseJsPluginEngine.this.handleOnceSubscribeResponse(requestEvent, z16, jSONObject);
                    }
                });
                return;
            }
            QMLog.e(TAG, "reqGrantOnceSubscribeApiPermission: tmplIdJsonArr is null!");
            onceSubMsgCallbackFail(requestEvent, "TmplIds can't be empty", 10001);
        } catch (Exception e16) {
            QMLog.e(TAG, "reqGrantOnceSubscribeApiPermission get an Exception:" + e16);
        }
    }

    private void reqGrantSystemSubscribeApiPermission(final RequestEvent requestEvent) {
        QMLog.i(TAG, "reqGrantSystemSubscribeApiPermission jsonParams: " + requestEvent.jsonParams);
        try {
            JSONArray optJSONArray = new JSONObject(requestEvent.jsonParams).optJSONArray("msgTypeList");
            if (optJSONArray != null && optJSONArray.length() <= 3) {
                if (optJSONArray.length() == 0) {
                    onceSubMsgCallbackFail(requestEvent, EMPTY_PARAM_LIST_HINT, 10001);
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add(optJSONArray.getString(i3));
                }
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getUserSetting(getAppId(), "", "setting.sysMsgSubscribed", arrayList, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.7
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        BaseJsPluginEngine.this.handleOnceSubscribeResponse(requestEvent, z16, jSONObject);
                    }
                });
                return;
            }
            onceSubMsgCallbackFail(requestEvent, INVALID_TEMPLATE_ID_HINT, 10004);
        } catch (Exception e16) {
            QMLog.e(TAG, "reqGrantSystemSubscribeApiPermission get an Exception:" + e16);
            onceSubMsgCallbackFail(requestEvent, INVALID_TEMPLATE_ID_HINT, 10004);
        }
    }

    private void setAuthMsgData(List<INTERFACE$StSubscribeMessage> list, INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage, boolean z16, boolean z17) {
        if (z17 && z16) {
            iNTERFACE$StSubscribeMessage.authState.set(1);
        } else if (z17) {
            iNTERFACE$StSubscribeMessage.authState.set(0);
        } else if (z16) {
            iNTERFACE$StSubscribeMessage.authState.set(2);
        } else {
            return;
        }
        list.add(iNTERFACE$StSubscribeMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScopePermissionAuthState(String str, boolean z16) {
        MiniAppEnv.g().getAuthSate(getAppId()).setAuthState(str, z16);
    }

    private boolean shouldAskEveryTime(String str) {
        return MiniAppEnv.g().getAuthSate(getAppId()).shouldAskEveryTime(str);
    }

    private boolean shouldAskEveryTimeWhenRejected(String str) {
        return MiniAppEnv.g().getAuthSate(getAppId()).shouldAskEveryTimeWhenRejected(str);
    }

    private void showDefaultAuthDialog(String str, String str2, String str3, String str4, String str5, Context context, MiniAppProxy miniAppProxy, String str6, String str7, String str8) {
        if (this.mAuthJsProxy.isAuthDialogInit()) {
            AuthJsProxy.AuthDialogResConfig authDialogResConfig = new AuthJsProxy.AuthDialogResConfig();
            if (this.mAuthJsProxy.getAuthDialogResConfig() != null) {
                authDialogResConfig = this.mAuthJsProxy.getAuthDialogResConfig();
            }
            authDialogResConfig.miniAppIconUrl = miniAppProxy.getDrawable(context, str6, 0, 0, null);
            authDialogResConfig.miniAppName = str7;
            authDialogResConfig.authTitle = str2;
            authDialogResConfig.authDesc = str3;
            authDialogResConfig.reportSubAction = str5;
            authDialogResConfig.miniAppInfo = this.mMiniAppContext.getMiniAppInfo();
            authDialogResConfig.eventName = str8;
            authDialogResConfig.leftBtnText = str4;
            authDialogResConfig.rightBtnText = "\u5141\u8bb8";
            JSONArray extractPhoneNumberList = extractPhoneNumberList(str);
            if (extractPhoneNumberList != null && extractPhoneNumberList.length() > 0) {
                authDialogResConfig.phoneNumberList = extractPhoneNumberList;
            }
            this.mAuthJsProxy.showAuthDialog(authDialogResConfig);
        }
    }

    private void showScopeUserInfoAuthDialog(final String str, final String str2, final String str3, final String str4, final Context context, ApkgInfo apkgInfo, ChannelProxy channelProxy, final MiniAppProxy miniAppProxy, final String str5, final String str6, final String str7) {
        channelProxy.getUserInfo(apkgInfo.appId, false, "en", new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.11
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                String str8;
                final String str9;
                final String str10;
                String str11 = null;
                if (z16) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(ITVKPlayerEventListener.KEY_USER_INFO);
                        str8 = jSONObject2.getString("nickName");
                        try {
                            str11 = jSONObject2.getString(PhotoCategorySummaryInfo.AVATAR_URL);
                        } catch (Throwable th5) {
                            th = th5;
                            QMLog.e(BaseJsPluginEngine.TAG, "call getUserInfo failed. " + Log.getStackTraceString(th));
                            str9 = str8;
                            str10 = str11;
                            final int dpToPx = ViewUtils.dpToPx(26.0f);
                            final int dpToPx2 = ViewUtils.dpToPx(40.0f);
                            BaseJsPluginEngine.this.mHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.11.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!BaseJsPluginEngine.this.mAuthJsProxy.isAuthDialogInit()) {
                                        return;
                                    }
                                    AuthJsProxy.AuthDialogResConfig authDialogResConfig = new AuthJsProxy.AuthDialogResConfig();
                                    if (BaseJsPluginEngine.this.mAuthJsProxy.getAuthDialogResConfig() != null) {
                                        authDialogResConfig = BaseJsPluginEngine.this.mAuthJsProxy.getAuthDialogResConfig();
                                    }
                                    AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                                    MiniAppProxy miniAppProxy2 = miniAppProxy;
                                    Context context2 = context;
                                    String str12 = str5;
                                    int i3 = dpToPx;
                                    authDialogResConfig.miniAppIconUrl = miniAppProxy2.getDrawable(context2, str12, i3, i3, null);
                                    AnonymousClass11 anonymousClass112 = AnonymousClass11.this;
                                    authDialogResConfig.miniAppName = str6;
                                    authDialogResConfig.authTitle = str;
                                    MiniAppProxy miniAppProxy3 = miniAppProxy;
                                    Context context3 = context;
                                    String str13 = str10;
                                    int i16 = dpToPx2;
                                    authDialogResConfig.userIconUrl = miniAppProxy3.getDrawable(context3, str13, i16, i16, null);
                                    authDialogResConfig.userName = str9;
                                    AnonymousClass11 anonymousClass113 = AnonymousClass11.this;
                                    authDialogResConfig.authDesc = str2;
                                    authDialogResConfig.reportSubAction = str4;
                                    authDialogResConfig.miniAppInfo = BaseJsPluginEngine.this.mMiniAppContext.getMiniAppInfo();
                                    AnonymousClass11 anonymousClass114 = AnonymousClass11.this;
                                    authDialogResConfig.leftBtnText = str3;
                                    authDialogResConfig.rightBtnText = "\u5141\u8bb8";
                                    authDialogResConfig.eventName = str7;
                                    authDialogResConfig.canceledOnTouchOutside = false;
                                    BaseJsPluginEngine.this.mAuthJsProxy.showAuthDialog(authDialogResConfig);
                                }
                            });
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        str8 = null;
                    }
                    str9 = str8;
                    str10 = str11;
                } else {
                    QMLog.d(BaseJsPluginEngine.TAG, "call getUserInfo failed. ");
                    str10 = null;
                    str9 = null;
                }
                final int dpToPx3 = ViewUtils.dpToPx(26.0f);
                final int dpToPx22 = ViewUtils.dpToPx(40.0f);
                BaseJsPluginEngine.this.mHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!BaseJsPluginEngine.this.mAuthJsProxy.isAuthDialogInit()) {
                            return;
                        }
                        AuthJsProxy.AuthDialogResConfig authDialogResConfig = new AuthJsProxy.AuthDialogResConfig();
                        if (BaseJsPluginEngine.this.mAuthJsProxy.getAuthDialogResConfig() != null) {
                            authDialogResConfig = BaseJsPluginEngine.this.mAuthJsProxy.getAuthDialogResConfig();
                        }
                        AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                        MiniAppProxy miniAppProxy2 = miniAppProxy;
                        Context context2 = context;
                        String str12 = str5;
                        int i3 = dpToPx3;
                        authDialogResConfig.miniAppIconUrl = miniAppProxy2.getDrawable(context2, str12, i3, i3, null);
                        AnonymousClass11 anonymousClass112 = AnonymousClass11.this;
                        authDialogResConfig.miniAppName = str6;
                        authDialogResConfig.authTitle = str;
                        MiniAppProxy miniAppProxy3 = miniAppProxy;
                        Context context3 = context;
                        String str13 = str10;
                        int i16 = dpToPx22;
                        authDialogResConfig.userIconUrl = miniAppProxy3.getDrawable(context3, str13, i16, i16, null);
                        authDialogResConfig.userName = str9;
                        AnonymousClass11 anonymousClass113 = AnonymousClass11.this;
                        authDialogResConfig.authDesc = str2;
                        authDialogResConfig.reportSubAction = str4;
                        authDialogResConfig.miniAppInfo = BaseJsPluginEngine.this.mMiniAppContext.getMiniAppInfo();
                        AnonymousClass11 anonymousClass114 = AnonymousClass11.this;
                        authDialogResConfig.leftBtnText = str3;
                        authDialogResConfig.rightBtnText = "\u5141\u8bb8";
                        authDialogResConfig.eventName = str7;
                        authDialogResConfig.canceledOnTouchOutside = false;
                        BaseJsPluginEngine.this.mAuthJsProxy.showAuthDialog(authDialogResConfig);
                    }
                });
            }
        });
    }

    private void updateOnceMsgSubscribedItem(final RequestEvent requestEvent, String str, final List<INTERFACE$StSubscribeMessage> list, List<INTERFACE$StSubscribeMessage> list2, AuthState authState) {
        authState.updateOnceSubMsgSetting(str, true, list2, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.10
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    BaseJsPluginEngine.this.onceSubMsgCallbackSuc(requestEvent, list);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void authDialogRequestEnqueue(RequestEvent requestEvent, String str) {
        this.scopePermissionQueue.offer(AuthRequestEvent.obtain(requestEvent, str, null, null));
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine
    public String checkAuthorization(RequestEvent requestEvent) {
        String str;
        String str2 = requestEvent.event;
        String str3 = requestEvent.jsonParams;
        if (!AuthFilterList.isEventInSecondaryApiList(str2)) {
            str = "";
        } else {
            str = extractApiNameInJsonParams(str3);
        }
        if (!this.mMiniAppContext.isContainer() && !AuthFilterList.isEventNameRight(this.mMiniAppContext.getMiniAppInfo(), str2, str)) {
            QMLog.e(TAG, "eventname : " + str2 + "; apiName : " + str + " request failed.");
            if (str2.endsWith("Sync")) {
                return ApiUtil.wrapCallbackFail(str2, null, "no permission").toString();
            }
            requestEvent.fail("no permission");
            return "";
        }
        String requestSystemPermission = getRequestSystemPermission(str2, str3);
        if (!StringUtil.isEmpty(requestSystemPermission)) {
            Activity attachActivity = this.mMiniAppContext.getAttachActivity();
            if (attachActivity == null) {
                QMLog.w(TAG, "Activity is null. Ignore event " + str2);
                return "";
            }
            if (!checkSelfPermission(attachActivity, str2, requestSystemPermission)) {
                handleRequestSystemPermission(requestEvent, str2, str3, requestSystemPermission, attachActivity);
                return "";
            }
            return checkRequestScopePermission(requestEvent);
        }
        return checkRequestScopePermission(requestEvent);
    }

    protected boolean checkPrivacyAgreementAgreed(String str, String str2) {
        return true;
    }

    @NonNull
    protected abstract f createPermissionReqImpl();

    /* JADX INFO: Access modifiers changed from: protected */
    public RequestEvent createRequestEvent(String str, String str2, IJsService iJsService, int i3) {
        return new RequestEvent.Builder().setEvent(str).setJsonParams(str2).setJsService(iJsService).setCallbackId(i3).build();
    }

    protected abstract String dispatchRequestEvent(RequestEvent requestEvent);

    protected ApkgInfo getApkgInfo() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null) {
            return (ApkgInfo) this.mMiniAppContext.getMiniAppInfo().apkgInfo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getAppId() {
        if (getApkgInfo() != null) {
            return getApkgInfo().appId;
        }
        return null;
    }

    protected Bundle getAuthDialogBundle(AuthRequestEvent authRequestEvent) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_EVENT_NAME, authRequestEvent.event);
        bundle.putString(KEY_PARAMS, authRequestEvent.jsonParams);
        bundle.putString(KEY_SCOPE_NAME, authRequestEvent.scopePermission);
        bundle.putInt("key_callback_id", authRequestEvent.callbackId);
        bundle.putString("key_appid", getAppId());
        bundle.putString(KEY_SETTING_ITEM, authRequestEvent.settingItem);
        bundle.putByteArray("key_once_sub_rsp_data", authRequestEvent.originalDataBytes);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getRequestScopePermission(String str, String str2) {
        String str3;
        if ("authorize".equals(str)) {
            String extractScopeNameInJsonParams = extractScopeNameInJsonParams(str2);
            if (isScopePermissionValid(extractScopeNameInJsonParams)) {
                return extractScopeNameInJsonParams;
            }
        }
        if (AuthFilterList.isEventInFriendshipBlackList(str)) {
            return "setting.shareFriendship";
        }
        String extractApiNameInJsonParams = extractApiNameInJsonParams(str2);
        if (TextUtils.isEmpty(extractApiNameInJsonParams)) {
            str3 = str;
        } else {
            str3 = str + "." + extractApiNameInJsonParams;
        }
        String scopePermissionByEvent = PermissionManager.g().getScopePermissionByEvent(str3);
        if ("operateWXData".equals(str) && TextUtils.isEmpty(extractApiNameInJsonParams)) {
            return handleOperateWXDataScopeName(str2, scopePermissionByEvent);
        }
        if (PluginConst.CMShowJsPluginConst.API_GET_CM_SHOW_INFO.equalsIgnoreCase(str)) {
            return getCMShowInfoScopeName(str2);
        }
        return scopePermissionByEvent;
    }

    protected void grantOnceSubscribeApiPermissionSilent(String str, RequestEvent requestEvent, byte[] bArr) {
        this.onceSubMsgReq = requestEvent;
        INTERFACE$StGetUserSettingRsp iNTERFACE$StGetUserSettingRsp = new INTERFACE$StGetUserSettingRsp();
        if (bArr != null) {
            try {
                iNTERFACE$StGetUserSettingRsp.mergeFrom(bArr);
            } catch (Throwable th5) {
                QMLog.e(TAG, "onceSubDismissListner - rsp.mergeFrom(onceSubRspByteArr) get a Throwable", th5);
            }
        }
        handleSubMsgDialogDismiss(str, false, true, true, true, true, false, iNTERFACE$StGetUserSettingRsp);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine
    public String handleNativeRequest(String str, String str2, IJsService iJsService, int i3, int i16) {
        if (this.mMiniAppContext == null) {
            return "";
        }
        RequestEvent createRequestEvent = createRequestEvent(str, str2, iJsService, i3);
        createRequestEvent.webViewId = i16;
        return checkAuthorization(createRequestEvent);
    }

    protected void handleNextScopeReq() {
        AuthRequestEvent poll = this.scopePermissionQueue.poll();
        if (poll != null && poll.isOnceSubscribeReq()) {
            this.onceSubMsgReq = poll;
        } else {
            this.curScopeEvent = poll;
        }
        if (poll != null) {
            QMLog.e(TAG, "handleNextScopeReq, event : " + poll.event + "; jsonParams : " + poll.jsonParams);
            showAuthDialog(getAuthDialogBundle(poll));
        }
    }

    public void initPermissionParser(Context context) {
        PermissionManager.g().startParse(new LocalPermissionParser(context), new RemotePermissionParser(context));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        this.mMiniAppContext = iMiniAppContext;
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        if (miniAppInfo != null) {
            AuthFilterList.updateEventRemoteList(miniAppInfo.blackList, miniAppInfo.whiteList);
            AuthFilterList.updateEventSecondaryApiList(miniAppInfo.secondApiRightInfoList);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        QMLog.i(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        AuthFilterList.reset();
        this.scopePermissionQueue.clear();
        if (this.mAuthJsProxy.isAuthDialogNotNull()) {
            this.mAuthJsProxy.setOnDismissListener(null);
            this.mAuthJsProxy.dismissAuthDialog();
            this.mAuthJsProxy.setAuthDialogToNull();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onPause() {
        QMLog.i(TAG, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        removeAllMessage();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
        QMLog.i(TAG, "onResume");
        if (this.mAuthJsProxy.isAuthDialogShow()) {
            return;
        }
        QMLog.i(TAG, "onResume - WHAT_NOTIFY_SCOPE_PERMISSION_QUEUE");
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    public void onceSubMsgCallbackFail(RequestEvent requestEvent, String str, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", i3);
        } catch (JSONException e16) {
            QMLog.e(TAG, "onceSubMsgCallbackFail get a JSONException:", e16);
        }
        if (requestEvent != null) {
            requestEvent.fail(jSONObject, str);
        }
    }

    public void onceSubMsgCallbackSuc(RequestEvent requestEvent, List<INTERFACE$StSubscribeMessage> list) {
        JSONObject jSONObject = new JSONObject();
        for (int i3 = 0; i3 < list.size(); i3++) {
            try {
                INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = list.get(i3);
                jSONObject.put(iNTERFACE$StSubscribeMessage.templateId.get(), iNTERFACE$StSubscribeMessage.authState.get() == 1 ? "accept" : "reject");
            } catch (Exception e16) {
                QMLog.e(TAG, "onceSubMsgCallbackSuc get a Exception:", e16);
            }
        }
        if (requestEvent != null) {
            requestEvent.ok(jSONObject);
        }
    }

    protected void onceSubscribeRequestEnqueue(String str, RequestEvent requestEvent, byte[] bArr) {
        AuthRequestEvent obtain = AuthRequestEvent.obtain(requestEvent, null, str, bArr);
        obtain.setOnceSubscribe(true);
        this.scopePermissionQueue.offer(obtain);
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    protected String reqGrantSubscribeApiPermission(RequestEvent requestEvent) {
        AuthState authSate = MiniAppEnv.g().getAuthSate(getAppId());
        String requestScopePermission = getRequestScopePermission(requestEvent.event, requestEvent.jsonParams);
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "reqGrantSubscribeApiPermission scopePermission=" + requestScopePermission);
        }
        if (!QUAUtil.isQQApp() && !QUAUtil.isDemoApp()) {
            QMLog.w(TAG, "Invalid SDK host, reject all subscribeAppMsg");
            authSate.setAuthState(requestScopePermission, false);
            requestEvent.fail("Invalid SDK host, no permission");
            return "";
        }
        if (AuthFilterList.apiAuthoritySilent(this.mMiniAppContext.getMiniAppInfo())) {
            grantSubscribePermissionSilent(authSate, requestScopePermission, requestEvent);
            return "";
        }
        if (authSate.getAuthFlag(requestScopePermission) == 1) {
            this.isFirstTimeRequestAuth = true;
            authDialogRequestEnqueue(requestEvent, requestScopePermission);
        } else if (authSate.isPermissionGranted(requestScopePermission)) {
            this.isFirstTimeRequestAuth = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("subscribeAppMsgCode", 1);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            requestEvent.ok(jSONObject);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (this.isFirstTimeRequestAuth) {
                    jSONObject2.put("subscribeAppMsgCode", 0);
                } else {
                    jSONObject2.put("subscribeAppMsgCode", -1);
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
            requestEvent.fail(jSONObject2, "no permission");
            this.isFirstTimeRequestAuth = false;
        }
        return "";
    }

    protected void showAuthDialog(Bundle bundle) {
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (attachActivity != null && !attachActivity.isFinishing()) {
            String string = bundle.getString(KEY_EVENT_NAME, "");
            String string2 = bundle.getString(KEY_PARAMS, "");
            QMLog.d(TAG, "showAuthDialog, event: " + string + ";params : " + string2);
            String string3 = bundle.getString(KEY_SCOPE_NAME, "");
            initAuthDialog(bundle, attachActivity, getAuthDialogType(string, string3));
            if (string3 != null) {
                doShowAuthDialog(string2, string3, string);
                return;
            }
            return;
        }
        QMLog.w(TAG, "showAuthDialog(). Do nothing, activity is null or finishing");
    }

    public void showRequestPermissionDialog(RequestEvent requestEvent, PhoneNumberAction.PhoneNumberActionCallback phoneNumberActionCallback) {
        this.mPhoneNumberActionCallbackMap.put(Integer.valueOf(requestEvent.callbackId), phoneNumberActionCallback);
        showRequestPermissionDialog(requestEvent, getRequestScopePermission(requestEvent.event, requestEvent.jsonParams));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getScopePermissionAuthFlag(String str, String str2) {
        String optString;
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (str2 != null) {
            try {
                optString = new JSONObject(str2).optJSONObject("data").optJSONObject("data").optString("miniprogram_appid");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (TextUtils.isEmpty(optString)) {
                optString = getAppId();
            }
            return MiniAppEnv.g().getAuthSate(optString).getAuthFlag(str);
        }
        optString = null;
        if (TextUtils.isEmpty(optString)) {
        }
        return MiniAppEnv.g().getAuthSate(optString).getAuthFlag(str);
    }

    private String handleAuthorizeEvent(final RequestEvent requestEvent, boolean z16) {
        try {
            final String appId = getAppId();
            final AuthState authSate = MiniAppEnv.g().getAuthSate(appId);
            final String extractScopeNameInJsonParams = extractScopeNameInJsonParams(requestEvent.jsonParams);
            if (authSate != null && isScopePermissionValid(extractScopeNameInJsonParams)) {
                boolean isSynchronized = authSate.isSynchronized();
                if (extractScopeNameInJsonParams.startsWith("setting") && !isSynchronized) {
                    ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAuthList(appId, new ChannelProxy.AuthListResult() { // from class: com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.6
                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult
                        public void onReceiveResult(boolean z17, List<UserAuthInfo> list, List<UserSettingInfo> list2) {
                            if (z17) {
                                authSate.updateAuthStateList(list, list2);
                                authSate.setSynchronized();
                                boolean isPermissionGranted = authSate.isPermissionGranted(extractScopeNameInJsonParams);
                                if (AuthFilterList.isAppInWhiteList(appId)) {
                                    isPermissionGranted = true;
                                }
                                if (isPermissionGranted) {
                                    requestEvent.ok();
                                    return;
                                } else {
                                    BaseJsPluginEngine.this.authDialogRequestEnqueue(requestEvent, extractScopeNameInJsonParams);
                                    return;
                                }
                            }
                            QMLog.e(BaseJsPluginEngine.TAG, "getSetting-getAuthStateList failed");
                        }
                    });
                } else {
                    boolean isPermissionGranted = authSate.isPermissionGranted(extractScopeNameInJsonParams);
                    if (AuthFilterList.isAppInWhiteList(appId)) {
                        isPermissionGranted = true;
                    }
                    if (!isPermissionGranted) {
                        authDialogRequestEnqueue(requestEvent, extractScopeNameInJsonParams);
                    } else if (z16) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("isOnlyGrantCoarse", true);
                        requestEvent.ok(jSONObject);
                    } else {
                        requestEvent.ok();
                    }
                }
            } else {
                QMLog.w(TAG, "handleAuthorizeEvent, authState is null or scope invalid, scope = " + extractScopeNameInJsonParams);
                requestEvent.fail();
            }
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
            requestEvent.fail();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showRequestPermissionDialog(RequestEvent requestEvent, String str) {
        boolean isShowAuthDialog = isShowAuthDialog(str, requestEvent.event, requestEvent.jsonParams);
        QMLog.d(TAG, "handleNativeRequest showAuthDialog=" + isShowAuthDialog);
        if (isShowAuthDialog) {
            authDialogRequestEnqueue(requestEvent, str);
            return;
        }
        QMLog.d(TAG, "handleNativeRequest callbackJsEventFail");
        requestEvent.fail("auth deny");
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    public void onceSubMsgCallbackFail(RequestEvent requestEvent, JSONObject jSONObject) {
        if (requestEvent != null) {
            requestEvent.fail(jSONObject, null);
        }
    }

    public void onceSubMsgCallbackSuc(RequestEvent requestEvent, List<INTERFACE$StSubscribeMessage> list, List<INTERFACE$StSubscribeMessage> list2, List<INTERFACE$StSubscribeMessage> list3, boolean z16) {
        JSONObject jSONObject = new JSONObject();
        int i3 = 0;
        try {
            if (z16) {
                while (i3 < list.size()) {
                    INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = list.get(i3);
                    jSONObject.put(iNTERFACE$StSubscribeMessage.templateId.get(), iNTERFACE$StSubscribeMessage.authState.get() == 1 ? "accept" : "reject");
                    i3++;
                }
            } else {
                for (int i16 = 0; i16 < list.size(); i16++) {
                    INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage2 = list.get(i16);
                    if (iNTERFACE$StSubscribeMessage2.authState.get() == 1) {
                        jSONObject.put(iNTERFACE$StSubscribeMessage2.templateId.get(), "accept");
                    } else if (iNTERFACE$StSubscribeMessage2.authState.get() == 2) {
                        jSONObject.put(iNTERFACE$StSubscribeMessage2.templateId.get(), "reject");
                    }
                }
                for (int i17 = 0; i17 < list2.size(); i17++) {
                    INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage3 = list2.get(i17);
                    jSONObject.put(iNTERFACE$StSubscribeMessage3.templateId.get(), iNTERFACE$StSubscribeMessage3.authState.get() == 2 ? "reject" : "accept");
                }
                while (i3 < list3.size()) {
                    jSONObject.put(list3.get(i3).templateId.get(), "reject");
                    i3++;
                }
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "onceSubMsgCallbackSuc get a Exception:", e16);
        }
        if (requestEvent != null) {
            requestEvent.ok(jSONObject);
        }
    }

    protected void onPermissionDialogDismissed() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onRestart() {
    }

    protected void showUserAgreementDialog(Activity activity, MiniAppInfo miniAppInfo, RequestEvent requestEvent, AuthState authState, String str) {
    }
}
