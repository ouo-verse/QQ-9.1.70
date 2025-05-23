package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneInterActiveVideoPlugin extends QzoneInternalWebViewPlugin {
    private static final String ACTION_HIDE_INNER_WEBVIEW = "com.tencent.mobileqq.action.ACTION_HIDE_INNER_WEBVIEW";
    private static final String ACTION_LIVEVIDEO_AUTHENTICATION = "com.cooperation.cooperation.qzone.webviewplugin.QzoneInterActiveVideoPlugin.getAuthenticationResults";
    private static final String ACTION_LIVE_MUSIC_SELECT = "com.qzone.module.browser.plugin.QzLivePlugin.liveMusicSelect";
    private static final String ACTION_NOTIFY_PAGE_READY = "com.tencent.mobileqq.action.ACTION_NOTIFY_PAGE_READY";
    private static final String ACTION_NOTIFY_QZ_LIVE_VIDEO_EVENT = "com.tencent.mobileqq.action.ACTION_QZ_LIVE_DISPATCH_EVENT";
    private static final String ACTION_OPEN_USER_INFO_CARD = "com.tencent.mobileqq.action.ACTION_OPEN_USER_INFO_CARD";
    private static final String EXTRA_NAME_LIVE_MUSIC_SONG_MID = "get_live_music_song_mid";
    private static final String METHOD_NAME_OF_AUTHENTICATION = "getAuthenticationResults";
    private static final String NOTIFY_VIDEO_DIALOG_PERMISSION = "com.tencent.msg.permission.pushnotify";
    private static final String QZ_LIVE_DISPATCH_EVENT_PARAMS_DATA = "data";
    private static final String QZ_LIVE_DISPATCH_EVENT_PARAMS_EVENT = "event";
    private static final String TAG = "QzoneInternalWebViewPlugin";
    private static JSONObject liveMusicUrlData;

    private static void notifyOpenUserInfoCard(String str) {
        QLog.i(TAG, 2, "saxon@ openUserInfoCard uin is " + str);
        try {
            Intent intent = new Intent(ACTION_OPEN_USER_INFO_CARD);
            intent.putExtra("uin", str);
            BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "saxon@ notifyOpenUserInfoCard exception", th5);
        }
    }

    public boolean dispatchOldPattern(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("getLiveMusicUrl".equals(str3)) {
            if (strArr != null) {
                try {
                    if (strArr.length == 1) {
                        JSONObject jSONObject = new JSONObject(strArr[0]);
                        liveMusicUrlData = jSONObject;
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        optJSONObject.getString("file_mid");
                        String string = optJSONObject.getString("song_mid");
                        Intent intent = new Intent(ACTION_LIVE_MUSIC_SELECT);
                        intent.putExtra(EXTRA_NAME_LIVE_MUSIC_SONG_MID, string);
                        BaseApplicationImpl.getApplication().sendBroadcast(intent);
                        WebViewPlugin.b bVar = this.parentPlugin.mRuntime;
                        if (bVar != null && bVar.a() != null) {
                            this.parentPlugin.mRuntime.a().finish();
                        }
                        return true;
                    }
                } catch (Exception e16) {
                    QLog.w(TAG, 1, "getLiveMusicUrl Exception" + e16.toString());
                }
            }
        } else if (METHOD_NAME_OF_AUTHENTICATION.equals(str3)) {
            if (strArr != null) {
                try {
                    if (strArr.length > 0) {
                        JSONObject jSONObject2 = new JSONObject(strArr[0]);
                        int i3 = jSONObject2.getInt("result");
                        int i16 = jSONObject2.getInt("from");
                        Intent intent2 = new Intent(ACTION_LIVEVIDEO_AUTHENTICATION);
                        intent2.putExtra("result", i3);
                        intent2.putExtra("from", i16);
                        BaseApplicationImpl.getApplication().sendBroadcast(intent2);
                        WebViewPlugin.b bVar2 = this.parentPlugin.mRuntime;
                        if (bVar2 != null && bVar2.a() != null) {
                            this.parentPlugin.mRuntime.a().finish();
                        } else if (this.parentPlugin.mRuntime == null) {
                            QLog.i(TAG, 1, " the parentPlugin.mRuntime is null");
                        } else {
                            QLog.i(TAG, 1, " parentPlugin.mRuntime.getActivity() is null");
                        }
                        QLog.i(TAG, 1, "result is " + i3 + ",from is " + i16);
                        return true;
                    }
                } catch (Exception e17) {
                    QLog.w(TAG, 1, "doAuthentication catch an exception in handleJsRequest", e17);
                }
            }
        } else if ("openUserInfoCard".equals(str3)) {
            if (strArr != null) {
                try {
                    if (strArr.length > 0) {
                        String optString = new JSONObject(strArr[0]).optString("uin");
                        if (optString != null && optString.length() != 0) {
                            notifyOpenUserInfoCard(optString);
                            return true;
                        }
                        QLog.w(TAG, 1, "openUserInfoCard uin is empty");
                        return true;
                    }
                } catch (Exception e18) {
                    QLog.w(TAG, 1, "openUserInfoCard Exception" + e18);
                }
            }
        } else {
            if ("hideInnerWebview".equals(str3)) {
                notifyHideInnerWebview();
                return true;
            }
            if ("onPageReady".equals(str3)) {
                notifyPageReadyInnerWebview();
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!QZoneJsConstants.PKGNAME_QZONE_INTERACTIVE_VIDEO.equals(str2) || this.parentPlugin == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        QLog.i(TAG, 2, "qz_livevideo_jsbridge, dispatch method callback linkchain, " + str3);
        boolean dispatchOldPattern = dispatchOldPattern(jsBridgeListener, str, str2, str3, strArr);
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
            return dispatchOldPattern;
        }
    }

    private static void notifyHideInnerWebview() {
        QLog.i(TAG, 2, "saxon@ hideInnerWebview running");
        try {
            BaseApplication.getContext().sendBroadcast(new Intent(ACTION_HIDE_INNER_WEBVIEW), "com.tencent.msg.permission.pushnotify");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "saxon@ notifyHideInnerWebview exception", th5);
        }
    }

    private static void notifyPageReadyInnerWebview() {
        QLog.i(TAG, 2, "saxon@ onPageReady running");
        try {
            BaseApplication.getContext().sendBroadcast(new Intent(ACTION_NOTIFY_PAGE_READY), "com.tencent.msg.permission.pushnotify");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "saxon@ notifyPageReadyInnerWebview exception", th5);
        }
    }
}
