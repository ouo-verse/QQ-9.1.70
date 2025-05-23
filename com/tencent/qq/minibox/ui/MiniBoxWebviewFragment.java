package com.tencent.qq.minibox.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MiniBoxWebviewFragment extends WebViewFragment {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(com.tencent.mobileqq.webview.swift.utils.t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public boolean interceptStartLoadUrl() {
            return super.interceptStartLoadUrl();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            QLog.d("MiniBoxWebviewFragment_", 1, "url:", str);
            if (MiniBoxWebviewFragment.this.isDestroyed() || ((WebViewFragment) MiniBoxWebviewFragment.this).webView == null) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && str.startsWith("tencentymzxcommon://qqmusic/h5login")) {
                Activity hostActivity = MiniBoxWebviewFragment.this.getHostActivity();
                if (hostActivity != null) {
                    hostActivity.finish();
                }
                String qh5 = MiniBoxWebviewFragment.this.qh(str);
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                intent.setData(Uri.parse(qh5));
                QLog.i("MiniBoxWebviewFragment_", 1, "on qq music auth, start callback scheme=" + qh5);
                MiniBoxWebviewFragment.this.startActivity(intent);
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.d("MiniBoxWebviewFragment_", 1, "onCreate");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        QLog.d("MiniBoxWebviewFragment_", 1, "onCreateView");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    public String qh(String str) {
        try {
            return "mqqapi://minibox/qqmusic_auth_callback?".concat("callbackUrl").concat(ContainerUtils.KEY_VALUE_DELIMITER).concat(URLEncoder.encode(str, "utf-8")).concat(ContainerUtils.FIELD_DELIMITER).concat("minibox_pid").concat(ContainerUtils.KEY_VALUE_DELIMITER).concat(String.valueOf(getIntent().getIntExtra("minibox_pid", 0)));
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
