package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneWanbaJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String ACTION_NOTIFY_ADV_PLAY = "QZONE.ACTION_NOTIFY_ADV_PLAY";
    public static final String BROADCAST_PERMISSION = "com.tencent.msg.permission.pushnotify";
    public static final String KEY_CALLBACK = "callback";
    public static final String KEY_RESULT = "ret";
    private static final String TAG = "QzoneWanbaJsPlugin";
    private volatile boolean mReceiverRegistered = false;
    BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: cooperation.qzone.webviewplugin.QzoneWanbaJsPlugin.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("callback");
                int intExtra = intent.getIntExtra("ret", 1);
                QZLog.i(QzoneWanbaJsPlugin.TAG, "\u6536\u5230\u5e7f\u64ad\u6d88\u606f callback=" + stringExtra + ",ret=" + intExtra);
                QzoneWanbaJsPlugin.this.parentPlugin.callJs(stringExtra, "{'ret':" + intExtra + "}");
            } catch (Exception e16) {
                QZLog.e(QzoneWanbaJsPlugin.TAG, "callback error", e16);
            }
        }
    };

    private void registerBroadcast() {
        if (this.mReceiverRegistered) {
            return;
        }
        try {
            QZLog.i(TAG, "registerBroadcast");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("QZONE.ACTION_NOTIFY_ADV_PLAY");
            Activity a16 = this.parentPlugin.mRuntime.a();
            if (!this.mReceiverRegistered) {
                try {
                    a16.registerReceiver(this.mReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", null);
                    this.mReceiverRegistered = true;
                } catch (Exception e16) {
                    QZLog.e(TAG, "regist receiver error:", e16);
                }
            }
        } catch (Exception e17) {
            QZLog.e(TAG, "registerBroadcast error", e17);
        }
    }

    private void removeBroadcast() {
        try {
            if (this.mReceiverRegistered) {
                QZLog.i(TAG, "removeBroadcast");
                try {
                    this.parentPlugin.mRuntime.a().unregisterReceiver(this.mReceiver);
                } catch (Exception e16) {
                    QZLog.e(TAG, "unregisterReceiver error ", e16);
                }
                this.mReceiverRegistered = false;
            }
        } catch (Exception e17) {
            QZLog.e(TAG, "removeBroadcast error", e17);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f A[Catch: Exception -> 0x006a, TryCatch #2 {Exception -> 0x006a, blocks: (B:9:0x0018, B:11:0x001b, B:13:0x0022, B:16:0x0025, B:18:0x002a, B:19:0x0039, B:21:0x003f, B:23:0x0046, B:27:0x0036), top: B:8:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046 A[Catch: Exception -> 0x006a, TRY_LEAVE, TryCatch #2 {Exception -> 0x006a, blocks: (B:9:0x0018, B:11:0x001b, B:13:0x0022, B:16:0x0025, B:18:0x002a, B:19:0x0039, B:21:0x003f, B:23:0x0046, B:27:0x0036), top: B:8:0x0018 }] */
    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        if (!"Qzone".equals(str2) || !"OpenGDTVideoPage".equals(str3)) {
            return false;
        }
        try {
        } catch (Exception e16) {
            QZLog.e(TAG, "OpenGDTVideoPage error", e16);
        }
        if (strArr.length < 1) {
            QZLog.e(TAG, "OpenGDTVideoPage \u53c2\u6570\u9519\u8bef");
            return true;
        }
        String str4 = strArr[0];
        String str5 = null;
        try {
            jSONObject = new JSONObject(str4);
        } catch (JSONException e17) {
            e = e17;
            jSONObject = null;
        }
        try {
            str5 = jSONObject.optString("callback");
        } catch (JSONException e18) {
            e = e18;
            e.printStackTrace();
            if (!TextUtils.isEmpty(str5)) {
            }
        }
        if (!TextUtils.isEmpty(str5)) {
            QZLog.e(TAG, "OpenGDTVideoPage not have callback");
            return true;
        }
        QZLog.i(TAG, "OpenGDTVideoPage js param=" + jSONObject);
        registerBroadcast();
        QZoneHelper.launchQZoneEncourageAdvActivity(this.parentPlugin.mRuntime.a(), str4);
        return true;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        removeBroadcast();
        super.onDestroy();
    }
}
