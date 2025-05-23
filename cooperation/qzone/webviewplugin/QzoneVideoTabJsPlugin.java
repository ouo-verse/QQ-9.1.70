package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.QZonePermission;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneVideoTabJsPlugin extends QzoneInternalWebViewPlugin implements WebEventListener {
    public static final String NAMESPACE = "Qzone";
    private String TAG = QzoneVideoTabJsPlugin.class.getSimpleName();
    private String downloadVideoCallback;
    private String getProxyCallback;

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadVideo(String str) {
        AppRuntime c16;
        AppRuntime onGetSubRuntime;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString("url");
            String string = jSONObject.getString("callback");
            final Bundle bundle = new Bundle();
            if (jSONObject.has("silence")) {
                bundle.putString(RemoteHandleConst.FORBIDDEN_TOAST, jSONObject.getString("silence"));
            }
            if (!TextUtils.isEmpty(string)) {
                this.downloadVideoCallback = string;
            }
            AppInterface b16 = this.parentPlugin.mRuntime.b();
            if (b16 == null && (c16 = this.parentPlugin.mRuntime.c()) != null && (c16 instanceof ToolRuntimePeak) && (onGetSubRuntime = ((ToolRuntimePeak) c16).onGetSubRuntime("peak")) != null) {
                b16 = (AppInterface) onGetSubRuntime;
            }
            if (b16 != null) {
                b16.getHandler(QzoneVideoTabJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.5
                    @Override // java.lang.Runnable
                    public void run() {
                        WebViewPlugin.b bVar;
                        Activity a16;
                        WebViewPlugin webViewPlugin = QzoneVideoTabJsPlugin.this.parentPlugin;
                        if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || (a16 = bVar.a()) == null) {
                            return;
                        }
                        if (!com.tencent.mobileqq.startup.permission.a.f(a16)) {
                            QQPermissionFactory.getQQPermission(a16, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.5.1
                                @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                                public void onAllGranted() {
                                    super.onAllGranted();
                                    RemoteRequestSender sender = RemoteHandleManager.getInstance().getSender();
                                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                    sender.downloadVideo(optString, bundle);
                                }
                            });
                        } else {
                            RemoteHandleManager.getInstance().getSender().downloadVideo(optString, bundle);
                        }
                    }
                });
            } else {
                QLog.e(this.TAG, 1, "downloadVideo failed, appInterface is null");
            }
        } catch (JSONException e16) {
            QLog.e(this.TAG, 1, e16, new Object[0]);
        }
    }

    private void getLocalProxyUrl(String str) {
        try {
            QLog.i(this.TAG, 1, "getLocalProxyUrl. json=" + str);
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("playList");
            String string = jSONObject.getString("callback");
            if (!TextUtils.isEmpty(string)) {
                this.getProxyCallback = string;
            }
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.getJSONObject(i3).getString("url"));
                arrayList2.add(jSONArray.getJSONObject(i3).getString("vid"));
            }
            if (arrayList.size() > 0) {
                this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteHandleManager.getInstance().getSender().getVideoLocalProxyUrl(arrayList, arrayList2);
                    }
                });
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void setPlayState(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("state");
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                arrayList.add(jSONObject.getString("url"));
                arrayList2.add(jSONObject.getString("state"));
            }
            if (arrayList.size() > 0) {
                this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.3
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteHandleManager.getInstance().getSender().setVideoState(arrayList, arrayList2);
                    }
                });
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void stopAll() {
        this.parentPlugin.mRuntime.b().getHandler(QzoneVideoTabJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().stopAllVideo();
            }
        });
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, final String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if ("videoProxyGetLocalProxyURL".equals(str3) && strArr != null && strArr.length >= 1) {
                RemoteHandleManager.getInstance().addWebEventListener(this);
                getLocalProxyUrl(strArr[0]);
                return true;
            }
            if ("videoProxySetPlayState".equals(str3) && strArr != null && strArr.length >= 1) {
                RemoteHandleManager.getInstance().addWebEventListener(this);
                setPlayState(strArr[0]);
                return true;
            }
            if ("videoProxyStopAll".equals(str3)) {
                RemoteHandleManager.getInstance().addWebEventListener(this);
                stopAll();
                return true;
            }
            if ("videoProxySaveVideoToAlbum".equals(str3)) {
                RemoteHandleManager.getInstance().addWebEventListener(this);
                Activity a16 = this.parentPlugin.mRuntime.a();
                if (a16 != null && QZonePermission.requestStoragePermission(a16, new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.1
                    @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                    public void onAllGranted() {
                        super.onAllGranted();
                        QzoneVideoTabJsPlugin.this.downloadVideo(strArr[0]);
                    }
                }, QQPermissionConstants.Business.SCENE.QQ_QZONE_JS_DOWNLOAD_FILE)) {
                    downloadVideo(strArr[0]);
                }
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        RemoteHandleManager.getInstance().removeWebEventListener(this);
        super.onDestroy();
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        if (bundle == null || !bundle.containsKey("data")) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            QLog.e(this.TAG, 1, "call js function,bundle is empty");
            return;
        }
        if (RemoteHandleConst.CMD_VIDEO_GET_LOCAL_PROXY_URL.equals(str)) {
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(RemoteHandleConst.PARAM_VIDEO_LOCAL_URLS);
            ArrayList<String> stringArrayList2 = bundle2.getStringArrayList(RemoteHandleConst.PARAM_VIDEO_ID);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (stringArrayList != null && stringArrayList2 != null) {
                try {
                    if (stringArrayList.size() == stringArrayList2.size()) {
                        for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                            String str2 = stringArrayList.get(i3);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("vid", stringArrayList2.get(i3));
                            jSONObject2.put("url", str2);
                            jSONArray.mo162put(jSONObject2);
                        }
                    }
                } catch (JSONException e16) {
                    QLog.w(this.TAG, 2, "getLocalProxyUrl result is invalid.", e16);
                }
            }
            jSONObject.put("proxyList", jSONArray);
            QLog.i(this.TAG, 1, "getLocalProxyUrl result=" + jSONObject);
            if (TextUtils.isEmpty(this.getProxyCallback)) {
                return;
            }
            this.parentPlugin.callJs(this.getProxyCallback, jSONObject.toString());
            return;
        }
        if (RemoteHandleConst.CMD_VIDEO_DOWNLOAD.equals(str)) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("code", bundle2.getInt("code"));
                jSONObject3.put("msg", bundle2.getString("msg"));
            } catch (JSONException e17) {
                QLog.w(this.TAG, 2, "download video result is invalid.", e17);
            }
            if (TextUtils.isEmpty(this.downloadVideoCallback)) {
                return;
            }
            this.parentPlugin.callJs(this.downloadVideoCallback, jSONObject3.toString());
        }
    }

    private static Activity getRealActivity(Activity activity) {
        if (activity == null) {
            return null;
        }
        return activity instanceof BasePluginActivity ? ((BasePluginActivity) activity).getOutActivity() : activity;
    }
}
