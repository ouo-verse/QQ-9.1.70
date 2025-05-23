package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconBusiness;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class QQLevelJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "levelicon";
    private static final String TAG = "QQLevelJsPlugin";

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str == null || !BUSINESS_NAME.equals(str2) || str3 == null) {
            return false;
        }
        try {
            jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        } catch (Throwable th5) {
            QLog.e(TAG, 2, th5.getMessage(), th5);
        }
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
        final String optString = jsonFromJSBridge.optString("callback");
        if ("download".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "edit " + jsonFromJSBridge.toString());
            }
            int optInt = jsonFromJSBridge.optInt("id");
            QQLevelIconBusiness qQLevelIconBusiness = (QQLevelIconBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(QQLevelIconBusiness.class);
            qQLevelIconBusiness.addDownLoadListener(optInt, new IDownLoadListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.QQLevelJsPlugin.1
                @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                public void onLoadFail(UpdateListenerParams updateListenerParams) {
                    QQLevelJsPlugin.this.callJs(optString, "{'result':" + updateListenerParams.mErrorCode + "}");
                }

                @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
                public void onLoadSuccess(UpdateListenerParams updateListenerParams) {
                    QQLevelJsPlugin.this.callJs(optString, "{'result':0}");
                }
            });
            qQLevelIconBusiness.startDownload(optInt);
        }
        return true;
    }
}
