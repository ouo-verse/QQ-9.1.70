package com.tencent.mobileqq.qqecommerce.shell.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.plugin.b;
import com.tencent.ecommerce.base.plugin.c;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qqecommerce.shell.IQQEcommerceShell;
import com.tencent.mobileqq.qqecommerce.shell.impl.QQEcommerceShellImpl;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u0016J,\u0010\t\u001a\u00020\u00042\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u0016J4\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/shell/impl/QQEcommerceShellImpl;", "Lcom/tencent/mobileqq/qqecommerce/shell/IQQEcommerceShell;", "()V", "callLogicInNative", "", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "callService", "reportEnter", "pluginVersion", "qqecommerce_shell_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class QQEcommerceShellImpl implements IQQEcommerceShell {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportEnter$lambda$0(String pluginVersion, HashMap params) {
        Intrinsics.checkNotNullParameter(pluginVersion, "$pluginVersion");
        Intrinsics.checkNotNullParameter(params, "$params");
        c.f100897c.e(pluginVersion, params);
    }

    @Override // com.tencent.mobileqq.qqecommerce.shell.IQQEcommerceShell
    public void callLogicInNative(HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).initSdkConfigInSubProcess();
        b bVar = b.f100883a;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
        bVar.e(application, params);
    }

    @Override // com.tencent.mobileqq.qqecommerce.shell.IQQEcommerceShell
    public void callService(HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).iniSdkConfig();
        QQEcommerceSdk.callServiceInNative(params);
    }

    @Override // com.tencent.mobileqq.qqecommerce.shell.IQQEcommerceShell
    public void reportEnter(final String pluginVersion, final HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(pluginVersion, "pluginVersion");
        Intrinsics.checkNotNullParameter(params, "params");
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).iniSdkConfig();
        ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).executeOnSubThread(new Runnable() { // from class: qg2.a
            @Override // java.lang.Runnable
            public final void run() {
                QQEcommerceShellImpl.reportEnter$lambda$0(pluginVersion, params);
            }
        });
    }
}
