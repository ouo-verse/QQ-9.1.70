package com.tencent.mobileqq.contactsync.authenticator;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends AbstractAccountAuthenticator {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f203000a;

    public a(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f203000a = context;
        }
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) throws NetworkErrorException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bundle) iPatchRedirector.redirect((short) 3, this, accountAuthenticatorResponse, str, str2, strArr, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Authenticator", 2, "addAccount");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("errorCode", 6);
        bundle2.putString("errorMessage", "Manually add account is unsupported");
        return bundle2;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) throws NetworkErrorException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, this, accountAuthenticatorResponse, account, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Authenticator", 2, "onfirmCredentials");
            return null;
        }
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this, (Object) accountAuthenticatorResponse, (Object) str);
        }
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account) throws NetworkErrorException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bundle) iPatchRedirector.redirect((short) 9, (Object) this, (Object) accountAuthenticatorResponse, (Object) account);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Authenticator", 2, "getAccountRemovalAllowed");
        }
        if ("Success".equals(MobileQQ.sInjectResult)) {
            QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (qQAppInterface != null) {
                ((IContactSyncService) qQAppInterface.getRuntimeService(IContactSyncService.class)).markAccountDeleteByUser(qQAppInterface, account);
            } else {
                QLog.d("ContactSync.Authenticator", 1, "getAccountRemovalAllowed| app == null");
            }
        }
        return super.getAccountRemovalAllowed(accountAuthenticatorResponse, account);
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bundle) iPatchRedirector.redirect((short) 5, this, accountAuthenticatorResponse, account, str, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Authenticator", 2, "getAuthToken");
            return null;
        }
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public String getAuthTokenLabel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Authenticator", 2, "getAuthTokenLabel");
            return "QQ\u901a\u8baf\u5f55\u540c\u6b65@Authenticator";
        }
        return "QQ\u901a\u8baf\u5f55\u540c\u6b65@Authenticator";
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) throws NetworkErrorException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bundle) iPatchRedirector.redirect((short) 8, this, accountAuthenticatorResponse, account, strArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Authenticator", 2, "hasFeatures");
            return null;
        }
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) throws NetworkErrorException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bundle) iPatchRedirector.redirect((short) 7, this, accountAuthenticatorResponse, account, str, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ContactSync.Authenticator", 2, "getAuthToken");
            return null;
        }
        return null;
    }
}
