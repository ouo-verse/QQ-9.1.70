package com.tencent.mobileqq.qqecommerce.biz.webview;

import android.os.Bundle;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import mg2.i;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/webview/ECWebViewActivity;", "Lcom/tencent/mobileqq/activity/QQTranslucentBrowserActivity;", "Lmg2/i;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "getFragmentClass", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "l0", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECWebViewActivity extends QQTranslucentBrowserActivity implements i {
    public ECWebViewActivity() {
        this.mFragmentClass = getFragmentClass();
    }

    private final Class<? extends WebViewFragment> getFragmentClass() {
        return ECSlideFloatWebViewFragment.class;
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity, com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        getIntent().putExtra(QQWinkConstants.WEB_COLOR_NOTE_TYPE, 2);
        return super.doOnCreate(savedInstanceState);
    }

    @Override // mg2.i
    public boolean l0() {
        return false;
    }
}
