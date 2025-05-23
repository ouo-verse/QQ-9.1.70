package com.tencent.ecommerce.base.router.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "", "getIntent", "Landroid/content/Intent;", "packageContext", "Landroid/content/Context;", "cls", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "launch", "", "launchForResult", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "launchFragmentClz", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface IECRouterLauncher {
    Intent getIntent(Context packageContext, Class<? extends Fragment> cls, Bundle bundle);

    boolean launch(Context packageContext, Class<? extends Fragment> cls, Bundle bundle);

    boolean launchForResult(Activity activity, int requestCode, Class<? extends Fragment> cls, Bundle bundle);

    Class<? extends Fragment> launchFragmentClz();
}
