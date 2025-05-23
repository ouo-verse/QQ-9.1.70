package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.magicface.model.f;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.IQzoneGiftFullScreenViewController;
import cooperation.qzone.QzoneGiftFullScreenActionManager;
import cooperation.qzone.QzoneGiftFullScreenViewController;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZoneGiftFullScreenJsPlugin extends QzoneInternalWebViewPlugin implements WebEventListener {
    public static final String NAMESPACE = "Qzone";
    public static final String QZONE_GIFTDETAILPAGE_URL = "https://h5.qzone.qq.com/gift/detail?_wv=2097155&uin={uin}&ugcid={ugcid}";
    private static final String TAG = "QZoneGiftFullScreenJsPlugin";
    private String downloadCMD = "";
    private QzoneGiftFullScreenViewController giftController = null;

    private void checkGift(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String[] strArr) {
        String str;
        JSONObject jSONObject;
        String str2 = "";
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int i3 = 0;
        if (strArr[0] != null) {
            try {
                jSONObject = new JSONObject(strArr[0]);
                str = jSONObject.getString("giftid");
            } catch (JSONException e16) {
                e = e16;
                str = "";
            }
            try {
                str2 = jSONObject.getString("callback");
            } catch (JSONException e17) {
                e = e17;
                e.printStackTrace();
                if (TextUtils.isEmpty(str)) {
                    return;
                } else {
                    return;
                }
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            File file = new File(QzoneGiftFullScreenActionManager.getGiftFullScreenFolderPath(str) + f.d());
            if (file.exists() && file.isDirectory()) {
                i3 = 1;
            }
            if (this.parentPlugin != null) {
                this.parentPlugin.callJs("window." + str2 + "({checkGift:" + i3 + "})");
            }
        }
    }

    private void downloadGift(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, final String[] strArr) {
        bVar.b().getHandler(QzoneDeviceTagJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin.1
            /* JADX WARN: Type inference failed for: r4v17 */
            /* JADX WARN: Type inference failed for: r4v22 */
            /* JADX WARN: Type inference failed for: r4v23 */
            /* JADX WARN: Type inference failed for: r4v24 */
            /* JADX WARN: Type inference failed for: r4v25 */
            /* JADX WARN: Type inference failed for: r4v5, types: [boolean] */
            /* JADX WARN: Type inference failed for: r4v6 */
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String str2;
                String str3;
                String str4;
                String string;
                String str5 = "";
                String[] strArr2 = strArr;
                if (strArr2 == null || strArr2.length <= 0 || strArr2[0] == null) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    str3 = jSONObject.getString("giftid");
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("giftZipUrl");
                        ?? equals = f.d().equals("sbig");
                        try {
                            if (equals != 0) {
                                String string2 = jSONObject2.getString("androidZipUrlSBig");
                                string = jSONObject2.getString("androidMd5SBig");
                                equals = string2;
                            } else if (f.d().equals("xbig")) {
                                String string3 = jSONObject2.getString("androidZipUrlXBig");
                                string = jSONObject2.getString("androidMd5XBig");
                                equals = string3;
                            } else if (f.d().equals(NtFaceConstant.SMALL)) {
                                String string4 = jSONObject2.getString("androidZipUrlSmall");
                                string = jSONObject2.getString("androidMd5Small");
                                equals = string4;
                            } else {
                                String string5 = jSONObject2.getString("androidZipUrlBig");
                                string = jSONObject2.getString("androidMd5Big");
                                equals = string5;
                            }
                            str = string;
                            str5 = equals;
                            try {
                                QZoneGiftFullScreenJsPlugin.this.downloadCMD = jSONObject.getString("callback");
                            } catch (JSONException e16) {
                                e = e16;
                                str4 = str5;
                                str5 = str3;
                                str2 = str4;
                                e.printStackTrace();
                                str3 = str5;
                                str5 = str2;
                                if (TextUtils.isEmpty(str3)) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        } catch (JSONException e17) {
                            e = e17;
                            str = str5;
                            str4 = equals;
                        }
                    } catch (JSONException e18) {
                        e = e18;
                        str = "";
                        str4 = str;
                    }
                } catch (JSONException e19) {
                    e = e19;
                    str = "";
                    str2 = str;
                }
                if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str5) || TextUtils.isEmpty(str) || TextUtils.isEmpty(QZoneGiftFullScreenJsPlugin.this.downloadCMD)) {
                    return;
                }
                RemoteHandleManager.getInstance().getSender().downloadGift(str3, str5, str);
            }
        });
    }

    private void playGift(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String[] strArr) {
        String str;
        JSONObject jSONObject;
        final String str2 = "";
        if (strArr == null || strArr.length <= 0 || strArr[0] == null) {
            return;
        }
        try {
            jSONObject = new JSONObject(strArr[0]);
            str = jSONObject.getString("giftid");
        } catch (JSONException e16) {
            e = e16;
            str = "";
        }
        try {
            str2 = jSONObject.getString("callback");
        } catch (JSONException e17) {
            e = e17;
            e.printStackTrace();
            if (TextUtils.isEmpty(str)) {
                return;
            } else {
                return;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String giftFullScreenFolderPath = QzoneGiftFullScreenActionManager.getGiftFullScreenFolderPath(str);
        File file = new File(giftFullScreenFolderPath);
        if (file.exists() && file.isDirectory()) {
            this.giftController = new QzoneGiftFullScreenViewController(this.parentPlugin.mRuntime.a());
            if (QzoneGiftFullScreenViewController.isSupportMagicface()) {
                this.giftController.playMaigcface(str, giftFullScreenFolderPath, new IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener() { // from class: cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin.2
                    @Override // cooperation.qzone.IQzoneGiftFullScreenViewController.GiftFullScreenPlayListener
                    public void giftFullScreenPlayEnd() {
                        if (QZoneGiftFullScreenJsPlugin.this.parentPlugin != null) {
                            QZoneGiftFullScreenJsPlugin.this.parentPlugin.callJs("window." + str2 + "({playFinish:1})");
                        }
                    }
                });
            }
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if ("Qzone".equals(str2) && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (QZoneJsConstants.METHOD_CHECKGIFT.equalsIgnoreCase(str3)) {
                WebViewPlugin webViewPlugin2 = this.parentPlugin;
                checkGift(webViewPlugin2, webViewPlugin2.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_DOWNLOADGIFT.equalsIgnoreCase(str3)) {
                RemoteHandleManager.getInstance().addWebEventListener(this);
                WebViewPlugin webViewPlugin3 = this.parentPlugin;
                downloadGift(webViewPlugin3, webViewPlugin3.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_PLAYGIFT.equalsIgnoreCase(str3)) {
                WebViewPlugin webViewPlugin4 = this.parentPlugin;
                playGift(webViewPlugin4, webViewPlugin4.mRuntime, strArr);
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        String str2;
        if (bundle == null || !bundle.containsKey("data")) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "call js function,bundle is empty");
                return;
            }
            return;
        }
        if (RemoteHandleConst.CMD_DOWNLOADGIFT.equals(str)) {
            int i3 = bundle2.getInt(RemoteHandleConst.PARAM_FULLSCREEN_GIFT_DOWNLOADPROGRESS);
            if (i3 <= 0) {
                str2 = "-1";
            } else if (i3 < 100) {
                str2 = String.format("%.1f", Double.valueOf(i3 * 0.01d));
            } else {
                str2 = "1";
            }
            if (this.parentPlugin == null || TextUtils.isEmpty(this.downloadCMD)) {
                return;
            }
            this.parentPlugin.callJs("window." + this.downloadCMD + "({downloadGift:" + str2 + "})");
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        int indexOf;
        QzoneGiftFullScreenViewController qzoneGiftFullScreenViewController;
        if (j3 == 8589934601L) {
            String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_GIFTDETAILPAGE, "https://h5.qzone.qq.com/gift/detail?_wv=2097155&uin={uin}&ugcid={ugcid}");
            if (!TextUtils.isEmpty(config) && (indexOf = config.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) != -1) {
                String substring = config.substring(0, indexOf);
                if (!TextUtils.isEmpty(str) && str.startsWith(substring) && (qzoneGiftFullScreenViewController = this.giftController) != null) {
                    qzoneGiftFullScreenViewController.onBackEvent();
                }
            }
        }
        return super.handleEvent(str, j3, map);
    }
}
