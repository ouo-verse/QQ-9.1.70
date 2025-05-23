package com.tencent.mobileqq.zplan.web;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.impl.SchemeApiImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/g;", "Lcom/tencent/mobileqq/webview/swift/d;", "Landroid/content/Intent;", "intent", "Landroid/app/Activity;", "hostActivity", "", "url", "", "navigateToAnotherActivity", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "needSwitchFragment", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g implements com.tencent.mobileqq.webview.swift.d {
    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean needSwitchFragment(Intent intent, Activity activity, String url) {
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean navigateToAnotherActivity(Intent intent, Activity hostActivity, String url) {
        if ((url == null || url.length() == 0) || intent == null || hostActivity == null) {
            return false;
        }
        return SchemeApiImpl.INSTANCE.a(hostActivity, url);
    }
}
