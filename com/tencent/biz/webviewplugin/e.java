package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "document";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("downloadFile".equals(str3)) {
            QLog.i("docPlugin", 1, "downloadFile called");
            if (strArr == null || strArr.length <= 0) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString(ShortVideoConstants.FILE_UUID);
                String optString2 = jSONObject.optString("file_name");
                String optString3 = jSONObject.optString("file_url");
                long optLong = jSONObject.optLong("file_size");
                if (QLog.isColorLevel()) {
                    QLog.i("docPlugin", 1, "downloadFile fileUrl is " + optString3);
                }
                Bundle bundle = new Bundle();
                bundle.putString(WadlProxyConsts.PARAM_FILENAME, optString2);
                bundle.putString("fileUrl", optString3);
                bundle.putString("fileUid", optString);
                bundle.putLong("fileSize", optLong);
                BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "FileDownIPCModule", "ACTION_DOWNLOAD_FILE", bundle);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
    }
}
