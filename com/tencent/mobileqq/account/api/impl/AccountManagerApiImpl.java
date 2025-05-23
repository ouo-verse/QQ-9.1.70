package com.tencent.mobileqq.account.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.account.api.IAccountManagerApi;
import com.tencent.mobileqq.account.fragment.AccountManagerFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/account/api/impl/AccountManagerApiImpl;", "Lcom/tencent/mobileqq/account/api/IAccountManagerApi;", "()V", "startAccountManagerFragment", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class AccountManagerApiImpl implements IAccountManagerApi {
    static IPatchRedirector $redirector_;

    public AccountManagerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.account.api.IAccountManagerApi
    public void startAccountManagerFragment(@Nullable Context context, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
        } else {
            QPublicFragmentActivity.start(context, intent, AccountManagerFragment.class);
        }
    }
}
