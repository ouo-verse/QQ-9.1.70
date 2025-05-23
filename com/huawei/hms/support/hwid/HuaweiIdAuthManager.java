package com.huawei.hms.support.hwid;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.x;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.common.HuaweiIdAuthException;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthServiceImpl;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class HuaweiIdAuthManager {
    private static Intent a(Activity activity, List<Scope> list) {
        return getService(activity, x.a(list)).getSignInIntent();
    }

    public static void addAuthScopes(Activity activity, int i3, HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        if (huaweiIdAuthExtendedParams != null) {
            addAuthScopes(activity, i3, huaweiIdAuthExtendedParams.getExtendedScopes());
            return;
        }
        throw new NullPointerException("HuaweiIdAuthExtendedParams should not be null");
    }

    public static boolean containScopes(AuthHuaweiId authHuaweiId, HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        if (huaweiIdAuthExtendedParams == null) {
            return false;
        }
        return containScopes(authHuaweiId, huaweiIdAuthExtendedParams.getExtendedScopes());
    }

    public static AuthHuaweiId getAuthResult() {
        return x.b();
    }

    public static AuthHuaweiId getAuthResultWithScopes(List<Scope> list) throws HuaweiIdAuthException {
        if (!ap.a(list).booleanValue()) {
            AuthHuaweiId b16 = x.b();
            if (b16 == null) {
                b16 = new AuthHuaweiId();
            }
            b16.requestExtraScopes(list);
            return b16;
        }
        throw new HuaweiIdAuthException("ScopeList should not be empty");
    }

    public static AuthHuaweiId getExtendedAuthResult(HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        if (huaweiIdAuthExtendedParams != null) {
            List<Scope> extendedScopes = huaweiIdAuthExtendedParams.getExtendedScopes();
            AuthHuaweiId b16 = x.b();
            if (b16 == null) {
                b16 = new AuthHuaweiId();
            }
            return b16.requestExtraScopes(extendedScopes);
        }
        throw new NullPointerException("HuaweiIdAuthExtendedParams should not be null");
    }

    public static HuaweiIdAuthService getService(Context context, HuaweiIdAuthParams huaweiIdAuthParams) {
        return new HuaweiIdAuthServiceImpl(context, huaweiIdAuthParams, 60400300);
    }

    public static Task<AuthHuaweiId> parseAuthResultFromIntent(Intent intent) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        HuaweiIdAuthResult a16 = x.a(intent);
        if (a16 == null) {
            taskCompletionSource.setException(new ApiException(new Status(8)));
        } else if (a16.isSuccess() && a16.getHuaweiId() != null) {
            taskCompletionSource.setResult(a16.getHuaweiId());
        } else {
            taskCompletionSource.setException(new ApiException(a16.getStatus()));
        }
        return taskCompletionSource.getTask();
    }

    public static HuaweiIdAuthService getService(Activity activity, HuaweiIdAuthParams huaweiIdAuthParams) {
        return new HuaweiIdAuthServiceImpl(activity, huaweiIdAuthParams, 60400300);
    }

    public static boolean containScopes(AuthHuaweiId authHuaweiId, List<Scope> list) {
        if (authHuaweiId == null) {
            return false;
        }
        if (ap.a(list).booleanValue()) {
            return true;
        }
        return authHuaweiId.getAuthorizedScopes().containsAll(list);
    }

    public static void addAuthScopes(Fragment fragment, int i3, HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        if (huaweiIdAuthExtendedParams != null) {
            addAuthScopes(fragment, i3, huaweiIdAuthExtendedParams.getExtendedScopes());
            return;
        }
        throw new NullPointerException("HuaweiIdAuthExtendedParams should not be null");
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
