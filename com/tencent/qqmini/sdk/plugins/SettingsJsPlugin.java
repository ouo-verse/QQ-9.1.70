package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.AuthStateItem;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.auth.SubscribeMessage;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class SettingsJsPlugin extends BaseJsPlugin {
    private static final String ACTION_RETURN_ADDRESS_TO_MINIAPP = "action_return_address_to_miniapp";
    private static final String KEY_MINIAPP_ADDRESS_INFO = "key_miniapp_address_info";
    private static final String TAG = "SettingsJsPlugin";
    private ChannelProxy mProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
    private boolean receiverRegistered = false;
    private RequestEvent addressReq = null;
    private BroadcastReceiver addressReceiver = new BroadcastReceiver() { // from class: com.tencent.qqmini.sdk.plugins.SettingsJsPlugin.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (QMLog.isColorLevel()) {
                QMLog.d(SettingsJsPlugin.TAG, String.format("receiver.onReceive action=%s", action));
            }
            if ("action_return_address_to_miniapp".equals(action)) {
                String stringExtra = intent.getStringExtra("key_miniapp_address_info");
                if (SettingsJsPlugin.this.addressReq != null) {
                    SettingsJsPlugin settingsJsPlugin = SettingsJsPlugin.this;
                    settingsJsPlugin.callbackChooseAddress(stringExtra, settingsJsPlugin.addressReq);
                    SettingsJsPlugin.this.addressReq = null;
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackChooseAddress(String str, RequestEvent requestEvent) {
        try {
            requestEvent.ok(new JSONObject(str));
        } catch (Throwable th5) {
            QMLog.e(TAG, "callbackChooseAddress get an error.", th5);
            requestEvent.fail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callbackSettingEvent(RequestEvent requestEvent) {
        boolean optBoolean;
        AuthState authSate = MiniAppEnv.g().getAuthSate(this.mApkgInfo.appId);
        if (!TextUtils.isEmpty(requestEvent.jsonParams)) {
            try {
                optBoolean = new JSONObject(requestEvent.jsonParams).optBoolean("withSubscriptions");
            } catch (JSONException e16) {
                QMLog.e(TAG, "openSetting parse jsonParams exception", e16);
            }
            if (!optBoolean) {
                requestAuthList(optBoolean, requestEvent, this.mApkgInfo.appId, authSate);
                return;
            } else {
                callbackSettingEvent(authSate, requestEvent, optBoolean, null);
                return;
            }
        }
        optBoolean = false;
        if (!optBoolean) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getInteractiveSubscribeList(List<SubscribeMessage> list) {
        if (list != null && list.size() != 0) {
            HashMap hashMap = new HashMap();
            for (SubscribeMessage subscribeMessage : list) {
                int i3 = subscribeMessage.authState;
                if (i3 != 0) {
                    String str = subscribeMessage.templateId;
                    if (i3 == 1) {
                        hashMap.put(str, "accept");
                    } else if (i3 == 2) {
                        hashMap.put(str, "reject");
                    } else if (i3 == 3) {
                        hashMap.put(str, "ban");
                    }
                }
            }
            return hashMap;
        }
        return null;
    }

    private void launchChooseAddressH5(String str) {
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("webStyle", "noBottomBar");
        miniAppProxy.startBrowserActivity(this.mMiniAppContext.getAttachActivity(), intent);
    }

    @JsEvent({"openAddress"})
    private void openAddress(RequestEvent requestEvent) {
        String config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_CHOOSE_ADDRESS_URL, WnsConfig.MINI_APP_CHOOSE_ADDRESS_DEFAULT_URL);
        this.addressReq = requestEvent;
        registerChooseAddressReceiver();
        launchChooseAddressH5(config);
    }

    private void openSettingActivity(Activity activity, ApkgInfo apkgInfo) {
        if (apkgInfo == null) {
            QMLog.e(TAG, "openSettingActivity, appInfo:" + apkgInfo);
            return;
        }
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).openPermissionSettingsActivity(activity, apkgInfo.appId, apkgInfo.apkgName);
    }

    private void registerChooseAddressReceiver() {
        if (this.receiverRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_return_address_to_miniapp");
        this.mMiniAppContext.getAttachActivity().registerReceiver(this.addressReceiver, intentFilter);
        this.receiverRegistered = true;
    }

    private void requestAuthList(final boolean z16, final RequestEvent requestEvent, String str, final AuthState authState) {
        this.mProxy.getAuthList(str, new ChannelProxy.AuthListResult() { // from class: com.tencent.qqmini.sdk.plugins.SettingsJsPlugin.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult
            public void onReceiveResult(boolean z17, List<UserAuthInfo> list, List<UserSettingInfo> list2) {
                if (z17) {
                    authState.updateAuthStateList(null, list2);
                    authState.setSynchronized();
                    HashMap hashMap = new HashMap();
                    if (z16) {
                        for (UserSettingInfo userSettingInfo : list2) {
                            if ("setting.sysMsgSubscribed".equals(userSettingInfo.settingItem) || "setting.onceMsgSubscribed".equals(userSettingInfo.settingItem)) {
                                Map interactiveSubscribeList = SettingsJsPlugin.this.getInteractiveSubscribeList(userSettingInfo.subItems);
                                if (interactiveSubscribeList != null) {
                                    hashMap.putAll(interactiveSubscribeList);
                                }
                            }
                        }
                    }
                    if (hashMap.size() > 0) {
                        authState.updateIsSysSubMsgMaintain(true);
                    }
                    SettingsJsPlugin.this.callbackSettingEvent(authState, requestEvent, z16, hashMap);
                    return;
                }
                QMLog.e(SettingsJsPlugin.TAG, "getSetting-getAuthStateList failed");
                SettingsJsPlugin.this.callbackSettingEvent(authState, requestEvent, z16, null);
            }
        });
    }

    private void unregisterChooseAddressReceiver() {
        if (this.receiverRegistered && this.addressReceiver != null) {
            this.mMiniAppContext.getAttachActivity().unregisterReceiver(this.addressReceiver);
            this.receiverRegistered = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    @JsEvent(isSync = false, value = {"getSetting"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getSetting(RequestEvent requestEvent) {
        boolean optBoolean;
        String str = this.mApkgInfo.appId;
        AuthState authSate = MiniAppEnv.g().getAuthSate(str);
        if (authSate == null) {
            QMLog.e(TAG, "getSetting, but authorizeCenter is null?!");
            return;
        }
        if (!TextUtils.isEmpty(requestEvent.jsonParams)) {
            try {
                optBoolean = new JSONObject(requestEvent.jsonParams).optBoolean("withSubscriptions");
            } catch (JSONException e16) {
                QMLog.e(TAG, "getSetting parse jsonParams exception", e16);
            }
            if (!authSate.isSynchronized()) {
                if (optBoolean) {
                    requestAuthList(optBoolean, requestEvent, str, authSate);
                    return;
                } else {
                    callbackSettingEvent(authSate, requestEvent, optBoolean, null);
                    return;
                }
            }
            requestAuthList(optBoolean, requestEvent, str, authSate);
            return;
        }
        optBoolean = false;
        if (!authSate.isSynchronized()) {
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        unregisterChooseAddressReceiver();
        super.onDestroy();
    }

    @JsEvent({"openSetting"})
    public void openSetting(final RequestEvent requestEvent) {
        ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.sdk.plugins.SettingsJsPlugin.2
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                QMLog.d(SettingsJsPlugin.TAG, "doOnActivityResult requestCode=" + i3 + ",resultCode=" + i16 + ",data=" + intent);
                if (i3 == 5) {
                    SettingsJsPlugin.this.callbackSettingEvent(requestEvent);
                    ActivityResultManager.g().removeActivityResultListener(this);
                    return true;
                }
                return false;
            }
        });
        openSettingActivity(this.mMiniAppContext.getAttachActivity(), this.mApkgInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackSettingEvent(AuthState authState, RequestEvent requestEvent, boolean z16, Map<String, String> map) {
        if (authState == null) {
            requestEvent.fail();
            return;
        }
        List<AuthStateItem> authStateList = authState.getAuthStateList(6);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (AuthStateItem authStateItem : authStateList) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scope", authStateItem.scopeName);
                jSONObject2.put("state", authStateItem.authFlag == 2 ? 1 : 0);
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("authSetting", jSONArray);
            if (z16) {
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                if (map != null && map.size() > 0) {
                    for (String str : map.keySet()) {
                        jSONObject4.put(str, map.get(str));
                    }
                }
                jSONObject3.put("itemSettings", jSONObject4);
                jSONObject.put("subscriptionsSetting", jSONObject3);
            }
            requestEvent.ok(jSONObject);
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
            requestEvent.fail();
        }
    }
}
