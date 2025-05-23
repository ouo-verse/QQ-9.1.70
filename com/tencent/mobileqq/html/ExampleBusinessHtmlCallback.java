package com.tencent.mobileqq.html;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.html.impl.DefaultHtmlCallback;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/html/ExampleBusinessHtmlCallback;", "Lcom/tencent/mobileqq/webview/html/impl/DefaultHtmlCallback;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "url", "Landroid/content/Intent;", "intent", "", "c", "<init>", "()V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ExampleBusinessHtmlCallback extends DefaultHtmlCallback {
    @Override // com.tencent.mobileqq.webview.html.impl.DefaultHtmlCallback, com.tencent.mobileqq.webview.html.j
    public boolean c(Activity activity, String url, Intent intent) {
        Intrinsics.checkNotNullParameter(url, "url");
        return false;
    }
}
