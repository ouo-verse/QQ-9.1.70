package cooperation.qzone.webviewplugin;

import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes38.dex */
public class QZonePublishVoiceShuoShuoH5Plugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    public static final String TAG = "QZonePublishVoiceShuoShuoH5Plugin";
    private static int count;

    /* renamed from: my, reason: collision with root package name */
    public static QZonePublishVoiceShuoShuoH5Plugin f390873my;
    private String voicePanelCallback = null;

    public QZonePublishVoiceShuoShuoH5Plugin() {
        f390873my = this;
    }

    public static void onDeleteAudioVoice(String str) {
        QZonePublishVoiceShuoShuoH5Plugin qZonePublishVoiceShuoShuoH5Plugin = f390873my;
        if (qZonePublishVoiceShuoShuoH5Plugin == null || qZonePublishVoiceShuoShuoH5Plugin.parentPlugin == null) {
            return;
        }
        QLog.d(TAG, 2, "onDeleteAudioVoice");
        f390873my.parentPlugin.callJs("window.moodVoice.onVoiceDelete('" + str + "')");
    }

    public static void onNotifyH5CutCancel() {
        QZonePublishVoiceShuoShuoH5Plugin qZonePublishVoiceShuoShuoH5Plugin = f390873my;
        if (qZonePublishVoiceShuoShuoH5Plugin == null || qZonePublishVoiceShuoShuoH5Plugin.parentPlugin == null) {
            return;
        }
        QLog.d(TAG, 2, "onNotifyH5CutCancel");
        f390873my.parentPlugin.callJs("window.moodVoice.cutCancel()");
    }

    public static void onNotifyH5RecordOk() {
        WebViewPlugin webViewPlugin;
        QZonePublishVoiceShuoShuoH5Plugin qZonePublishVoiceShuoShuoH5Plugin = f390873my;
        if (qZonePublishVoiceShuoShuoH5Plugin == null || (webViewPlugin = qZonePublishVoiceShuoShuoH5Plugin.parentPlugin) == null) {
            return;
        }
        webViewPlugin.callJs("window.QZMoodVoiceJSInterface.notifyGetVoiceRecordTime()");
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        f390873my = null;
    }
}
