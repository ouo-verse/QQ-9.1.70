package com.tencent.mobileqq.vaswebviewplugin;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.h;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class LocalDataJsPlugin extends VasWebviewJsPlugin {
    private static final String[] FILE_PATH_WHITE_LIST = {AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT};
    public static final String NAME_SPACE = "localData";
    private static final String TAG = "LocalDataJsPlugin";
    private BrowserAppInterface browserApp;
    com.tencent.mobileqq.vip.f sigTplResDownloadListener = new com.tencent.mobileqq.vip.f() { // from class: com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin.1
        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            super.onDone(gVar);
            if (QLog.isColorLevel()) {
                QLog.d(LocalDataJsPlugin.TAG, 2, "sigTplResDownloadListener.onDone| task:" + gVar);
            }
            Bundle h16 = gVar.h();
            if (h16 == null) {
                QLog.e(LocalDataJsPlugin.TAG, 1, "sigTplResDownloadListener.onDone error no params: " + gVar);
                return;
            }
            String string = h16.getString("callbackId");
            String string2 = h16.getString("itemId");
            String string3 = h16.getString("localRules");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && TextUtils.isDigitsOnly(string2)) {
                if (3 != gVar.i() && gVar.i() != 0) {
                    QLog.e(LocalDataJsPlugin.TAG, 1, "sigTpl download fail status = " + gVar.i() + " itemId = " + string2);
                    return;
                }
                if (DownloaderFactory.X(new File(SignatureTemplateConfig.getSignatureFilePath(string2, "temp.zip")), new File(SignatureTemplateConfig.getSignatureFilePath(string2, "dynamic_aio")), true)) {
                    JSONObject jSONObject = null;
                    try {
                        if (!TextUtils.isEmpty(string3)) {
                            jSONObject = new JSONObject(string3);
                        }
                    } catch (Exception e16) {
                        QLog.e(LocalDataJsPlugin.TAG, 1, "sigTplResDownloadListener error: " + e16.getMessage());
                    }
                    LocalDataJsPlugin.this.handleSignatureRequest(string, Integer.parseInt(string2), gVar.f313011i, jSONObject);
                    return;
                }
                return;
            }
            QLog.e(LocalDataJsPlugin.TAG, 1, "sigTplResDownloadListener.onDone error : callbackId = " + string + " itemId = " + string2);
        }
    };

    private boolean existDynamicSource(String str) {
        String signatureFilePath = SignatureTemplateConfig.getSignatureFilePath(str, "dynamic_aio");
        File file = new File(signatureFilePath);
        return file.exists() && file.isDirectory() && FileUtils.getChildFiles(signatureFilePath).size() > 0;
    }

    private boolean hasInterceptRight(String str) {
        String str2;
        AuthorizeConfig y16 = AuthorizeConfig.y();
        SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) super.getBrowserComponent(-2);
        if (swiftBrowserStatistics == null) {
            QLog.e(TAG, 1, "hasInterceptRight SwiftBrowserStatistics = null");
            return false;
        }
        if (swiftBrowserStatistics.I0.size() > 0) {
            List<String> list = swiftBrowserStatistics.I0;
            str2 = list.get(list.size() - 1);
        } else {
            str2 = swiftBrowserStatistics.A0;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (y16.F(str2, "localData.getFileInfo")) {
                for (String str3 : FILE_PATH_WHITE_LIST) {
                    if (str.startsWith(str3)) {
                        return true;
                    }
                }
                QLog.e(TAG, 1, "hasInterceptRight file path invalid: " + str);
            } else {
                QLog.e(TAG, 1, "hasInterceptRight url has no Right");
                return false;
            }
        } else {
            QLog.e(TAG, 1, "hasInterceptRight url is empty");
        }
        return false;
    }

    private WebResourceResponse shouldInterceptRequest(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "shouldInterceptRequest url = " + str);
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("local")) {
            Uri parse = Uri.parse(str);
            String str2 = parse.getAuthority() + parse.getPath();
            if (!hasInterceptRight(str2)) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "shouldInterceptRequest filePath = " + str2);
            }
            File file = new File(str2);
            if (file.exists()) {
                try {
                    return new WebResourceResponse("image/*", "UTF-8", new BufferedInputStream(new FileInputStream(file)));
                } catch (FileNotFoundException e16) {
                    QLog.e(TAG, 1, "shouldInterceptRequest error: ", e16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "shouldInterceptRequest filePath = " + str2 + " file not exists");
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return NAME_SPACE;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        int i3;
        int i16;
        if (TextUtils.isEmpty(str) || !NAME_SPACE.equals(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest signjs, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        try {
            jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        } catch (Exception e16) {
            QLog.e(TAG, 2, "handleJsRequest exception url=" + str + ", pkgName=" + str2 + ", methodName=" + str3 + ", msg=" + e16.getMessage());
            if (!TextUtils.isEmpty(null)) {
                super.callJs(null, "{\"result\": -1}");
            }
        }
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        String optString = jsonFromJSBridge.optString("callback");
        if (TextUtils.isEmpty(optString)) {
            QLog.e(TAG, 1, "callback id is null, so return");
            return true;
        }
        if ("getFileInfo".equals(str3)) {
            JSONObject optJSONObject = jsonFromJSBridge.optJSONObject("localRules");
            if (optJSONObject != null) {
                i3 = optJSONObject.optInt("appId");
                i16 = optJSONObject.optInt("itemId");
            } else {
                i3 = -1;
                i16 = -1;
            }
            String optString2 = jsonFromJSBridge.optString("fileUrl");
            if (TextUtils.isEmpty(optString2)) {
                QLog.e(TAG, 1, "handleJsRequest itemUrl is empty");
                super.callJs(optString, "{\"result\": -1}");
            }
            if (i3 != 9) {
                super.callJs(optString, "{\"result\": -1}");
                QLog.e(TAG, 1, "handleJsRequest can not handle appid " + i3);
            } else {
                handleSignatureRequest(optString, i16, optString2, optJSONObject);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        AppInterface b16 = this.mRuntime.b();
        if (b16 instanceof BrowserAppInterface) {
            this.browserApp = (BrowserAppInterface) b16;
        } else if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "ERROR!!! LocalDataJsPlugin is not running in web process!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSignatureRequest(String str, int i3, String str2, JSONObject jSONObject) {
        String num = Integer.toString(i3);
        if (existDynamicSource(num)) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (File file : new File(SignatureTemplateConfig.getSignatureFilePath(num, "dynamic_aio")).listFiles()) {
                if (file.getAbsolutePath().endsWith(".png")) {
                    jSONArray.mo162put(file.getAbsolutePath());
                }
            }
            try {
                jSONObject3.put("filePath", jSONArray);
                if (jSONObject != null) {
                    jSONObject3.put("localRules", jSONObject);
                }
                jSONObject2.put("data", jSONObject3);
                jSONObject2.put("result", 0);
                super.callJs(str, jSONObject2.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleSignatureRequest callbackId = " + str + " result = " + jSONObject2.toString());
                    return;
                }
                return;
            } catch (JSONException unused) {
                super.callJs(str, "{\"result\": -1}");
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleSignatureRequest file not exist, start download");
        }
        h u16 = ((DownloaderFactory) this.browserApp.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str2, new File(SignatureTemplateConfig.getSignatureFilePath(num, "temp.zip")));
        Bundle bundle = new Bundle();
        bundle.putString("callbackId", str);
        bundle.putString("itemId", num);
        if (jSONObject != null) {
            bundle.putString("localRules", jSONObject.toString());
        }
        u16.startDownload(gVar, this.sigTplResDownloadListener, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        if (j3 == 8) {
            return shouldInterceptRequest(str);
        }
        return null;
    }
}
