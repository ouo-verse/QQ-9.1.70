package com.tencent.mobileqq.api.impl;

import android.content.Context;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.api.ISettingMePreloadProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.webbundle.sdk.WebBundleConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/api/impl/SettingMePreloadProviderImpl;", "Lcom/tencent/mobileqq/api/ISettingMePreloadProvider;", "()V", WebBundleConstants.EVENT_TYPE_OF_PRELOAD_VIEW, "", "context", "Landroid/content/Context;", "preLoader", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "drawer-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class SettingMePreloadProviderImpl implements ISettingMePreloadProvider {
    static IPatchRedirector $redirector_;

    public SettingMePreloadProviderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.api.ISettingMePreloadProvider
    public void preloadView(@NotNull Context context, @NotNull RFWLayoutPreLoader preLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) preLoader);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preLoader, "preLoader");
        preLoader.preloadView(context, R.layout.qq_setting_me_item, 14);
        preLoader.preloadView(context, R.layout.qq_setting_me_item_v9, 14);
        preLoader.preloadView(context, R.layout.qq_setting_me, 1);
        preLoader.preloadView(context, R.layout.qq_setting_me_v9, 1);
        preLoader.preloadView(context, R.layout.qq_setting_me_v9_content, 1);
    }
}
