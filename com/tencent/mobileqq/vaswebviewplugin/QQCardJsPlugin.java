package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes35.dex */
public class QQCardJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "qqcard";
    private static final String TAG = "QQCardJsPlugin";

    private boolean openQQCard() {
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleJsRequest pkgName=" + str2 + " method=" + str3);
            }
            if (!BUSINESS_NAME.equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "can not handle objectname:" + str2);
                }
                return false;
            }
            if ("openQQCard".equals(str3)) {
                return openQQCard();
            }
        }
        return false;
    }
}
