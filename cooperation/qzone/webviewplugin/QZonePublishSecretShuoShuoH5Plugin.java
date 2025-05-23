package cooperation.qzone.webviewplugin;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.RecordAndChangeVoiceService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZonePublishSecretShuoShuoH5Plugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    public static final int NOTIFY_EDIT_LEFT = 3;
    public static final int NOTIFY_EDIT_RIGHT = 4;
    public static final int NOTIFY_H5_CANCEL = 6;
    public static final int NOTIFY_H5_OK = 1;
    public static final int NOTIFY_RIGHT_BTN = 2;
    public static final String TAG = "QZonePublishSecretShuoShuoH5Plugin";

    /* renamed from: my, reason: collision with root package name */
    public static QZonePublishSecretShuoShuoH5Plugin f390872my;
    private BroadcastReceiver msgBrocastReceiver = new BroadcastReceiver() { // from class: cooperation.qzone.webviewplugin.QZonePublishSecretShuoShuoH5Plugin.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RecordAndChangeVoiceService.BROADCAST_SYNC_SECRET_SHUOSHUO_MESSAGE)) {
                QZonePublishSecretShuoShuoH5Plugin.this.dispatchTasks(intent.getIntExtra(RecordAndChangeVoiceService.ACTION_TYPE, 0));
            }
        }
    };

    private void registerReceiver() {
        try {
            this.parentPlugin.mRuntime.a().registerReceiver(this.msgBrocastReceiver, new IntentFilter(RecordAndChangeVoiceService.BROADCAST_SYNC_SECRET_SHUOSHUO_MESSAGE));
        } catch (Exception e16) {
            QLog.w(TAG, 1, "registerMsgReceiver----", e16);
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        int i3 = 0;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            String str4 = "";
            if (str3.equalsIgnoreCase("getMoodVoiceRecordTime")) {
                try {
                    str4 = new JSONObject(strArr[0]).optString("callback");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                RecordAndChangeVoiceService.getInstance().getMoodVoiceRecordTime(str4, this);
                return true;
            }
            if (str3.equalsIgnoreCase("playMoodVoice")) {
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    str4 = jSONObject.optString("callback");
                    i3 = jSONObject.optInt("voiceID");
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
                RecordAndChangeVoiceService.getInstance().playMoodVoice(str4, i3, this);
                return true;
            }
            if (str3.equalsIgnoreCase("getMoodVoiceData")) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strArr[0]);
                    str4 = jSONObject2.optString("callback");
                    i3 = jSONObject2.optInt("voiceID");
                } catch (JSONException e18) {
                    e18.printStackTrace();
                }
                RecordAndChangeVoiceService.getInstance().getMoodVoiceData(str4, i3, this);
                return true;
            }
            if (str3.equalsIgnoreCase("stopPlayingMoodVoice")) {
                RecordAndChangeVoiceService.getInstance().stopPlayingMoodVoice();
                return true;
            }
            if (str3.equalsIgnoreCase("didPublishMoodVoice")) {
                ComponentCallbacks2 a16 = this.parentPlugin.mRuntime.a();
                if (a16 instanceof QZonePublishVoiceShuoShuoH5PluginInterface) {
                    ((QZonePublishVoiceShuoShuoH5PluginInterface) a16).didPushMoodVoice();
                }
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void initRuntime(WebViewPlugin webViewPlugin) {
        super.initRuntime(webViewPlugin);
        registerReceiver();
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (b16 != 6) {
            return;
        }
        if (i3 == -1) {
            RecordAndChangeVoiceService.getInstance().onReceiveRecordData(intent, 0);
        } else {
            onNotifyH5RecordCancel();
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        try {
            this.parentPlugin.mRuntime.a().unregisterReceiver(this.msgBrocastReceiver);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public void onEditLeftButtonClick() {
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin != null) {
            webViewPlugin.callJs("window.secret.onEditLeftButtonClick()");
        }
    }

    public void onEditRightButtonClick() {
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin != null) {
            webViewPlugin.callJs("window.secret.onEditRightButtonClick()");
        }
    }

    public void onNotifyH5RecordCancel() {
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin != null) {
            webViewPlugin.callJs("try { window.QZMoodVoiceJSInterface.onRecordCancel() } catch (error) {}");
        }
    }

    public void onNotifyH5RecordOk() {
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin != null) {
            webViewPlugin.callJs("window.QZMoodVoiceJSInterface.onRecordDone()");
        }
    }

    public void onReplyGetMoodVoiceData(String str, String str2) {
        WebViewPlugin.b bVar;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "callback is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", 0);
            jSONObject.put("voiceData", str2);
            jSONObject.put("voiceFormat", "amr");
            String jSONObject2 = jSONObject.toString();
            WebViewPlugin webViewPlugin = this.parentPlugin;
            if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || bVar.e() == null) {
                return;
            }
            this.parentPlugin.mRuntime.e().callJs(str, jSONObject2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    public void onReplyGetMoodVoiceRecordTime(String str, long j3) {
        WebViewPlugin.b bVar;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "callback is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", 0);
            jSONObject.put("voiceTime", j3);
            String jSONObject2 = jSONObject.toString();
            WebViewPlugin webViewPlugin = this.parentPlugin;
            if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || bVar.e() == null) {
                return;
            }
            this.parentPlugin.mRuntime.e().callJs(str, jSONObject2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    public void onReplyPlayMoodVoice(String str, long j3) {
        WebViewPlugin.b bVar;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "callback is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", 0);
            jSONObject.put("voiceTime", j3);
            String jSONObject2 = jSONObject.toString();
            WebViewPlugin webViewPlugin = this.parentPlugin;
            if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || bVar.e() == null) {
                return;
            }
            this.parentPlugin.mRuntime.e().callJs(str, jSONObject2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    public void onRightButtonClick() {
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin != null) {
            webViewPlugin.callJs("window.secret.onRightButtonClick()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchTasks(int i3) {
        if (i3 == 1) {
            onNotifyH5RecordOk();
            return;
        }
        if (i3 == 2) {
            onRightButtonClick();
            return;
        }
        if (i3 == 3) {
            onEditLeftButtonClick();
        } else if (i3 == 4) {
            onEditRightButtonClick();
        } else {
            if (i3 != 6) {
                return;
            }
            onNotifyH5RecordCancel();
        }
    }
}
