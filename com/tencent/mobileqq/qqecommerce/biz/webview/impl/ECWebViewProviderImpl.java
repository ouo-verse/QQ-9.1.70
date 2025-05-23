package com.tencent.mobileqq.qqecommerce.biz.webview.impl;

import android.app.Activity;
import com.tencent.mobileqq.qqecommerce.biz.webview.ECWebViewActivity;
import com.tencent.mobileqq.qqecommerce.biz.webview.IECWebViewProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/webview/impl/ECWebViewProviderImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/webview/IECWebViewProvider;", "()V", "getWebViewActivity", "Ljava/lang/Class;", "Landroid/app/Activity;", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ECWebViewProviderImpl implements IECWebViewProvider {
    @Override // com.tencent.mobileqq.qqecommerce.biz.webview.IECWebViewProvider
    public Class<? extends Activity> getWebViewActivity() {
        return ECWebViewActivity.class;
    }
}
