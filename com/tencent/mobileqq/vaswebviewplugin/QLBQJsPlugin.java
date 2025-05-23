package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes35.dex */
public class QLBQJsPlugin extends VasWebviewJsPlugin {
    public static final String NAME_SPACE = "qlbq";
    private static final String TAG = "QLBQJsPlugin";

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return NAME_SPACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (TextUtils.isEmpty(str) || !NAME_SPACE.equals(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest qlbqjs, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        try {
            if (!"openGroupEmotion".equals(str3)) {
                return true;
            }
            QPublicFragmentActivity.start(this.mRuntime.a(), EmoticonGroupStoreFragment.class);
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "handleJsRequest exception url=" + str + ", pkgName=" + str2 + ", methodName=" + str3 + ", msg=" + th5.getMessage());
            return true;
        }
    }
}
