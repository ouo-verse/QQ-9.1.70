package com.huawei.hms.support.hwid.service;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.hwid.AddressResult;
import com.huawei.hms.support.api.hwid.SignInResult;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;

/* loaded from: classes2.dex */
public interface HuaweiIdAuthAPIService {
    public static final String EXTRA_AUTH_HUAWEI_ID = "HUAWEIID_SIGNIN_RESULT";

    PendingResult<Status> cancelAuthorization(HuaweiApiClient huaweiApiClient);

    SignInResult getHwIdSignInResultFromIntent(Intent intent);

    @Deprecated
    Intent getSignInIntent(HuaweiApiClient huaweiApiClient);

    HuaweiIdAuthResult parseHuaweiIdFromIntent(Intent intent);

    PendingResult<AddressResult> queryShippingAddress(HuaweiApiClient huaweiApiClient, AuthHuaweiId authHuaweiId);

    PendingResult<SignInResult> signIn(Activity activity, HuaweiApiClient huaweiApiClient);

    PendingResult<SignInResult> signInBackend(HuaweiApiClient huaweiApiClient);

    PendingResult<Status> signOut(HuaweiApiClient huaweiApiClient);

    OptionalPendingResult<HuaweiIdAuthResult> silentSignIn(HuaweiApiClient huaweiApiClient);
}
