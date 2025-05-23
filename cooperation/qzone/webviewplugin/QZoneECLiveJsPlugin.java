package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZoneECLiveJsPlugin extends QzoneInternalWebViewPlugin {
    private static final String ACTION_NOTIFY_QZ_LIVE_VIDEO_EVENT = "com.tencent.mobileqq.action.ACTION_EC_LIVE_DISPATCH_EVENT";
    private static final String EC_LIVE_DISPATCH_EVENT_PARAMS_DATA = "data";
    private static final String EC_LIVE_DISPATCH_EVENT_PARAMS_EVENT = "event";
    private static final String NOTIFY_VIDEO_DIALOG_PERMISSION = "com.tencent.msg.permission.pushnotify";
    private static final String TAG = "QZoneECLiveJsPlugin";

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!str2.equals(QZoneJsConstants.PKGNAME_QZONE_EC_LIVE) || this.parentPlugin == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        QLog.i(TAG, 2, "ec_live_jsbridge, dispatch method callback linkchain, " + str3);
        try {
            Intent intent = new Intent(ACTION_NOTIFY_QZ_LIVE_VIDEO_EVENT);
            intent.putExtra("event", str3);
            if (strArr != null && strArr.length > 0) {
                intent.putExtra("data", new JSONObject(strArr[0]).toString());
            }
            BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "qz_livevideo_jsbridge, dispatch method callback linkchain exception", th5);
            return false;
        }
    }
}
