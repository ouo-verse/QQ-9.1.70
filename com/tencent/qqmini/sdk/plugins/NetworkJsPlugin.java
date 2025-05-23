package com.tencent.qqmini.sdk.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin(lazyLoad = false)
/* loaded from: classes23.dex */
public class NetworkJsPlugin extends BaseJsPlugin {
    public static final String EVENT_NETWORK_STATE_CHANGE = "onNetworkStatusChange";
    private static final String TAG = "NetworkJsPlugin";
    private ConnectionChangeReceiver mReceiver;
    private boolean mRegister = false;
    private String mLastNetworkType = "none";

    /* loaded from: classes23.dex */
    class ConnectionChangeReceiver extends BroadcastReceiver {
        ConnectionChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                JSONObject jSONObject = new JSONObject();
                String currentTypeDesc = NetworkJsPlugin.this.getCurrentTypeDesc();
                jSONObject.put(DKEngine.GlobalKey.NET_WORK_TYPE, currentTypeDesc);
                if ("none".equals(currentTypeDesc)) {
                    jSONObject.put("isConnected", false);
                } else {
                    jSONObject.put("isConnected", true);
                }
                NetworkJsPlugin.this.callBackStatusChange(jSONObject);
                ((RequestStrategyProxy) ProxyManager.get(RequestStrategyProxy.class)).notifyNetWorkStatusChange();
            } catch (Exception e16) {
                QMLog.e(NetworkJsPlugin.TAG, "fail on network change", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackStatusChange(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(DKEngine.GlobalKey.NET_WORK_TYPE) && !this.mLastNetworkType.equals(jSONObject.optString(DKEngine.GlobalKey.NET_WORK_TYPE))) {
            this.mLastNetworkType = jSONObject.optString(DKEngine.GlobalKey.NET_WORK_TYPE);
            sendSubscribeEvent(EVENT_NETWORK_STATE_CHANGE, jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentTypeDesc() {
        int activeNetworkType = NetworkUtil.getActiveNetworkType(this.mContext);
        if (activeNetworkType != 0) {
            if (activeNetworkType != 1) {
                if (activeNetworkType != 2) {
                    if (activeNetworkType != 3) {
                        if (activeNetworkType != 4) {
                            return UploadVideoObject.VODEO_FORMAT_UNKNOW;
                        }
                        return QADNetStatus.G_4;
                    }
                    return QADNetStatus.G_3;
                }
                return QADNetStatus.G_2;
            }
            return "wifi";
        }
        return "none";
    }

    @JsEvent({"getNetworkType"})
    public String getNetworkType(RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DKEngine.GlobalKey.NET_WORK_TYPE, getCurrentTypeDesc());
            String jSONObject2 = ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString();
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, jSONObject2);
            return jSONObject2;
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null).toString());
            return "";
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        if (this.mContext != null && !this.mRegister) {
            ConnectionChangeReceiver connectionChangeReceiver = new ConnectionChangeReceiver();
            this.mReceiver = connectionChangeReceiver;
            this.mContext.registerReceiver(connectionChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.mRegister = true;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        ConnectionChangeReceiver connectionChangeReceiver;
        if (this.mRegister && (connectionChangeReceiver = this.mReceiver) != null) {
            try {
                this.mContext.unregisterReceiver(connectionChangeReceiver);
                this.mReceiver = null;
                this.mRegister = false;
            } catch (Throwable th5) {
                QMLog.e(TAG, "fail unregisterReceiver", th5);
            }
        }
        super.onDestroy();
    }
}
