package com.huawei.hms.support.account;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.f;
import com.huawei.hms.support.account.common.AccountAuthException;
import com.huawei.hms.support.account.request.AccountAuthExtendedParams;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;
import com.huawei.hms.support.account.service.AccountAuthServiceImpl;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class AccountAuthManager {
    private static Intent a(Activity activity, List<Scope> list) {
        return getService(activity, f.a(list)).getSignInIntent();
    }

    public static void addAuthScopes(Activity activity, int i3, AccountAuthExtendedParams accountAuthExtendedParams) {
        if (accountAuthExtendedParams != null) {
            addAuthScopes(activity, i3, accountAuthExtendedParams.getExtendedScopes());
            return;
        }
        throw new NullPointerException("AccountAuthExtendedParams should not be null");
    }

    public static boolean containScopes(AuthAccount authAccount, AccountAuthExtendedParams accountAuthExtendedParams) {
        if (accountAuthExtendedParams == null) {
            return false;
        }
        return containScopes(authAccount, accountAuthExtendedParams.getExtendedScopes());
    }

    public static AuthAccount getAuthResult() {
        return f.b();
    }

    public static AuthAccount getAuthResultWithScopes(List<Scope> list) throws AccountAuthException {
        if (!ap.a(list).booleanValue()) {
            AuthAccount b16 = f.b();
            if (b16 == null) {
                b16 = new AuthAccount();
            }
            b16.requestExtraScopes(list);
            return b16;
        }
        throw new AccountAuthException("ScopeList should not be empty");
    }

    public static AuthAccount getExtendedAuthResult(AccountAuthExtendedParams accountAuthExtendedParams) {
        if (accountAuthExtendedParams != null) {
            List<Scope> extendedScopes = accountAuthExtendedParams.getExtendedScopes();
            AuthAccount b16 = f.b();
            if (b16 == null) {
                b16 = new AuthAccount();
            }
            return b16.requestExtraScopes(extendedScopes);
        }
        throw new NullPointerException("AccountAuthExtendedParams should not be null");
    }

    public static AccountAuthService getService(Context context, AccountAuthParams accountAuthParams) {
        return new AccountAuthServiceImpl(context, accountAuthParams, 60400300);
    }

    public static Task<AuthAccount> parseAuthResultFromIntent(Intent intent) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        AccountAuthResult a16 = f.a(intent);
        if (a16 == null) {
            taskCompletionSource.setException(new ApiException(new Status(8)));
        } else if (a16.isSuccess() && a16.getAccount() != null) {
            taskCompletionSource.setResult(a16.getAccount());
        } else {
            taskCompletionSource.setException(new ApiException(a16.getStatus()));
        }
        return taskCompletionSource.getTask();
    }

    public static AccountAuthService getService(Activity activity, AccountAuthParams accountAuthParams) {
        return new AccountAuthServiceImpl(activity, accountAuthParams, 60400300);
    }

    public static boolean containScopes(AuthAccount authAccount, List<Scope> list) {
        if (authAccount == null) {
            return false;
        }
        if (ap.a(list).booleanValue()) {
            return true;
        }
        return authAccount.getAuthorizedScopes().containsAll(list);
    }

    public static void addAuthScopes(Fragment fragment, int i3, AccountAuthExtendedParams accountAuthExtendedParams) {
        if (accountAuthExtendedParams != null) {
            addAuthScopes(fragment, i3, accountAuthExtendedParams.getExtendedScopes());
            return;
        }
        throw new NullPointerException("AccountAuthExtendedParams should not be null");
    }

    public static void addAuthScopes(Activity activity, int i3, List<Scope> list) {
        if (activity == null) {
            throw new NullPointerException("Activity should not be null");
        }
        if (list != null) {
            activity.startActivityForResult(a(activity, list), i3);
            return;
        }
        throw new NullPointerException("ScopeList should not be null");
    }

    public static void addAuthScopes(Fragment fragment, int i3, List<Scope> list) {
        if (fragment == null) {
            throw new NullPointerException("Fragment should not be null");
        }
        if (list != null) {
            fragment.startActivityForResult(a(fragment.getActivity(), list), i3);
            return;
        }
        throw new NullPointerException("ScopeList should not be null");
    }
}
