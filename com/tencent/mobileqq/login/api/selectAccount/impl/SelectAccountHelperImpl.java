package com.tencent.mobileqq.login.api.selectAccount.impl;

import android.content.Context;
import com.tencent.mobileqq.login.api.selectAccount.ISelectAccountHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.bh;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/login/api/selectAccount/impl/SelectAccountHelperImpl;", "Lcom/tencent/mobileqq/login/api/selectAccount/ISelectAccountHelper;", "()V", "gotoPhoneBindAccountManager", "", "context", "Landroid/content/Context;", "phoneNum", "", "countryCode", "requestCode", "", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class SelectAccountHelperImpl implements ISelectAccountHelper {
    static IPatchRedirector $redirector_;

    public SelectAccountHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.login.api.selectAccount.ISelectAccountHelper
    public void gotoPhoneBindAccountManager(@NotNull Context context, @NotNull String phoneNum, @Nullable String countryCode, int requestCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, phoneNum, countryCode, Integer.valueOf(requestCode));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(phoneNum, "phoneNum");
        bh.f306610a.r(context, phoneNum, countryCode, requestCode);
    }
}
