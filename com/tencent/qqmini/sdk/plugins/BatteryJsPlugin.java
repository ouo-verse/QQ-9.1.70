package com.tencent.qqmini.sdk.plugins;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class BatteryJsPlugin extends BaseJsPlugin {
    public static final String EVENT_GET_BATTERY = "getBatteryInfo";
    public static final String EVENT_GET_BATTERY_SYNC = "getBatteryInfoSync";
    private static final String TAG = "BatteryJsPlugin";
    private PowerConnectionReceiver mPowerConnectionReceiver = new PowerConnectionReceiver();
    private float batteryPct = 0.0f;
    private boolean isCharging = false;
    private int chargePlug = -1;

    /* loaded from: classes23.dex */
    public class PowerConnectionReceiver extends BroadcastReceiver {
        public PowerConnectionReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z16;
            intent.getIntExtra("status", -1);
            BatteryJsPlugin batteryJsPlugin = BatteryJsPlugin.this;
            if (intent.getIntExtra("plugged", -1) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            batteryJsPlugin.isCharging = z16;
            BatteryJsPlugin.this.batteryPct = intent.getIntExtra("level", 0) / intent.getIntExtra("scale", 0);
            BatteryJsPlugin.this.chargePlug = intent.getIntExtra("plugged", -1);
        }
    }

    @JsEvent({"getBatteryInfo", EVENT_GET_BATTERY_SYNC})
    public String getBatteryInfo(RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", (int) (this.batteryPct * 100.0f));
            jSONObject.put("isCharging", this.isCharging);
            String jSONObject2 = ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString();
            if ("getBatteryInfo".equals(requestEvent.event)) {
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, jSONObject2);
            }
            return jSONObject2;
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
            if ("getBatteryInfo".equals(requestEvent.event)) {
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(requestEvent.event, null).toString());
                return "";
            }
            return "";
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        this.mContext.registerReceiver(this.mPowerConnectionReceiver, intentFilter);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        try {
            this.mContext.unregisterReceiver(this.mPowerConnectionReceiver);
        } catch (Throwable th5) {
            QMLog.e(TAG, "unregisterReceiver exception.", th5);
        }
    }
}
