package com.huawei.hms.support.hwid.service;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.x;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.api.entity.hwid.QueryShippingAddressReq;
import com.huawei.hms.support.api.entity.hwid.QueryShippingAddressResp;
import com.huawei.hms.support.api.entity.hwid.RevokeAccessResp;
import com.huawei.hms.support.api.entity.hwid.ShippingAddressInfo;
import com.huawei.hms.support.api.entity.hwid.ShippingAddressParcelable;
import com.huawei.hms.support.api.entity.hwid.SignInReq;
import com.huawei.hms.support.api.entity.hwid.SignInResp;
import com.huawei.hms.support.api.entity.hwid.SignOutReq;
import com.huawei.hms.support.api.entity.hwid.SignOutResp;
import com.huawei.hms.support.api.hwid.AddressResult;
import com.huawei.hms.support.api.hwid.SignInResult;
import com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.Util;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class HuaweiIdAuthAPIServiceImpl implements HuaweiIdAuthAPIService {

    /* renamed from: a, reason: collision with root package name */
    private HuaweiApiClient f37601a = null;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f37602b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class SignOutNoConnectPendingResult extends PendingResultImpl<Status, SignOutResp> {

        /* renamed from: a, reason: collision with root package name */
        private ResultCallback f37607a;

        public SignOutNoConnectPendingResult(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        public ResultCallback getCallback() {
            return this.f37607a;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl, com.huawei.hms.support.api.client.PendingResult
        public void setResultCallback(ResultCallback<Status> resultCallback) {
            this.f37607a = resultCallback;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public Status onComplete(SignOutResp signOutResp) {
            Status status = new Status(0);
            as.b("HuaweiIdAuthAPIServiceImpl", "signOut onComplete", true);
            return status;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class SignOutOnCompleteListener implements OnCompleteListener<Void> {

        /* renamed from: a, reason: collision with root package name */
        private final SignOutNoConnectPendingResult f37608a;

        public SignOutOnCompleteListener(SignOutNoConnectPendingResult signOutNoConnectPendingResult) {
            this.f37608a = signOutNoConnectPendingResult;
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(Task<Void> task) {
            as.b("HuaweiIdAuthAPIServiceImpl", "SignOutOnCompleteListener onComplete", true);
            if (this.f37608a == null) {
                as.d("HuaweiIdAuthAPIServiceImpl", "signOutResultPendingResult is null", true);
                return;
            }
            Status status = Status.FAILURE;
            if (task.isSuccessful()) {
                status = Status.SUCCESS;
            } else {
                Exception exception = task.getException();
                if (exception != null && (exception instanceof ApiException)) {
                    status = new Status(((ApiException) exception).getStatusCode());
                } else {
                    as.d("HuaweiIdAuthAPIServiceImpl", "wrong exception while failed", true);
                }
            }
            ResultCallback callback = this.f37608a.getCallback();
            if (callback != null) {
                callback.onResult(status);
            } else {
                as.d("HuaweiIdAuthAPIServiceImpl", "set Result callback after signOut completed", true);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class a implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        a() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            if (resolveResult != null && resolveResult.getStatus().isSuccess() && (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) != null && value.getStatusCode() == 0) {
                as.a("HuaweiIdAuthAPIServiceImpl", "get notice has intent.", true);
                Activity validActivity = Util.getValidActivity((Activity) HuaweiIdAuthAPIServiceImpl.this.f37602b.get(), HuaweiIdAuthAPIServiceImpl.this.f37601a.getTopActivity());
                if (validActivity == null) {
                    as.d("HuaweiIdAuthAPIServiceImpl", "showNotice no valid activity!", true);
                    return;
                }
                try {
                    validActivity.startActivity(noticeIntent);
                } catch (Exception e16) {
                    as.d("HuaweiIdAuthAPIServiceImpl", "startActivity exception" + e16.getClass().getSimpleName(), true);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static class b extends PendingResultImpl<AddressResult, QueryShippingAddressResp> {
        public b(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AddressResult onComplete(QueryShippingAddressResp queryShippingAddressResp) {
            Bundle extras;
            if (queryShippingAddressResp == null) {
                as.d("HuaweiIdAuthAPIServiceImpl", "queryShippingAddressResp is invalid.", true);
                return new AddressResult(new Status(2005));
            }
            as.b("HuaweiIdAuthAPIServiceImpl", "QueryShippingAddress.ResultCode:" + queryShippingAddressResp.getRetCode(), true);
            int retCode = queryShippingAddressResp.getRetCode();
            AddressResult addressResult = new AddressResult();
            addressResult.setStatus(queryShippingAddressResp.getCommonStatus());
            ArrayList<ShippingAddressInfo> arrayList = null;
            if (retCode == 0) {
                Intent data = queryShippingAddressResp.getData();
                if (data != null && (extras = data.getExtras()) != null) {
                    extras.setClassLoader(getClass().getClassLoader());
                    ShippingAddressParcelable shippingAddressParcelable = (ShippingAddressParcelable) extras.getParcelable(CommonConstant.RETKEY.SHIPPING_ADDRESS);
                    if (shippingAddressParcelable != null) {
                        arrayList = shippingAddressParcelable.getShippingAddressInfoList();
                    } else {
                        as.d("HuaweiIdAuthAPIServiceImpl", "shippingAddressParcelable is null", true);
                    }
                } else {
                    as.d("HuaweiIdAuthAPIServiceImpl", "data or bundle is null", true);
                }
            } else {
                as.d("HuaweiIdAuthAPIServiceImpl", "retCode is not ok", true);
            }
            addressResult.setShippingAddressInfoList(arrayList);
            return addressResult;
        }
    }

    /* loaded from: classes2.dex */
    static class c extends PendingResultImpl<Status, RevokeAccessResp> {
        public c(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status onComplete(RevokeAccessResp revokeAccessResp) {
            as.b("HuaweiIdAuthAPIServiceImpl", "RevokeAccessPendingResult onComplete", true);
            return new Status(revokeAccessResp.getRetCode());
        }
    }

    /* loaded from: classes2.dex */
    static class d extends PendingResultImpl<Status, SignOutResp> {
        public d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status onComplete(SignOutResp signOutResp) {
            Status status = new Status(0);
            as.b("HuaweiIdAuthAPIServiceImpl", "signOut onComplete", true);
            return status;
        }
    }

    private int c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            as.d("HuaweiIdAuthAPIServiceImpl", "parse homeZone error.", true);
            return 0;
        }
    }

    protected static int conversionGender(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "-1";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    protected static int conversionHomeZone(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static HashSet<Scope> conversionScopes(String str) {
        HashSet<Scope> hashSet = new HashSet<>();
        if (str != null) {
            for (String str2 : str.split(" ")) {
                hashSet.add(new Scope(str2));
            }
        }
        return hashSet;
    }

    protected static int conversionStatus(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private PendingResult<Status> d(HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signOutNoConnected", true);
        Task<Void> signOut = HuaweiIdAuthManager.getService(huaweiApiClient.getContext(), getSignInOption(huaweiApiClient)).signOut();
        SignOutNoConnectPendingResult signOutNoConnectPendingResult = new SignOutNoConnectPendingResult(huaweiApiClient, CommonNaming.signout, new SignOutReq());
        signOut.addOnCompleteListener(new SignOutOnCompleteListener(signOutNoConnectPendingResult));
        return signOutNoConnectPendingResult;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<Status> cancelAuthorization(HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter cancelAuthorization", true);
        this.f37601a = huaweiApiClient;
        return new c(huaweiApiClient, CommonNaming.revokeAccess, c(huaweiApiClient));
    }

    public HuaweiIdAuthResult getHuaweiIdSignInResultFromIntent(Intent intent) {
        Status status;
        Bundle extras;
        HuaweiIdAuthResult huaweiIdAuthResult = new HuaweiIdAuthResult();
        if (intent != null && (extras = intent.getExtras()) != null) {
            int i3 = extras.getInt(CommonConstant.RETKEY.RETCODE, 0);
            status = new Status(i3);
            if (i3 == 0) {
                huaweiIdAuthResult.setAuthHuaweiId(a(extras));
                as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult success", true);
            } else {
                as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult fail", true);
            }
        } else {
            status = new Status(2003);
            as.d("HuaweiIdAuthAPIServiceImpl", "getSignInResult error", true);
        }
        huaweiIdAuthResult.setStatus(status);
        return huaweiIdAuthResult;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public SignInResult getHwIdSignInResultFromIntent(Intent intent) {
        Bundle extras;
        PendingIntent activity;
        if (intent != null && (extras = intent.getExtras()) != null) {
            int i3 = extras.getInt(CommonConstant.RETKEY.RETCODE, 0);
            if (i3 == 0) {
                String string = extras.getString(CommonConstant.RETKEY.GENDER);
                String string2 = extras.getString(CommonConstant.RETKEY.USERID, "");
                String string3 = extras.getString(CommonConstant.RETKEY.STATUS);
                String string4 = extras.getString(CommonConstant.RETKEY.SCOPE);
                String string5 = extras.getString(CommonConstant.RETKEY.ID_TOKEN);
                String string6 = extras.getString(CommonConstant.RETKEY.EMAIL);
                String string7 = extras.getString(CommonConstant.RETKEY.FAMILY_NAME);
                String string8 = extras.getString(CommonConstant.RETKEY.GIVEN_NAME);
                String string9 = extras.getString(CommonConstant.RETKEY.AGE_RANGE);
                String string10 = extras.getString(CommonConstant.RETKEY.HOME_ZONE);
                AuthHuaweiId build = AuthHuaweiId.build(extras.getString(CommonConstant.RETKEY.OPENID, ""), string2, extras.getString(CommonConstant.RETKEY.DISPLAYNAME, ""), extras.getString(CommonConstant.RETKEY.PHOTOURL), extras.getString(CommonConstant.RETKEY.ACCESS_TOKEN, ""), extras.getString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, ""), conversionStatus(string3), conversionGender(string), conversionScopes(string4), extras.getString(CommonConstant.RETKEY.SERVICEAUTHCODE, ""), extras.getString(CommonConstant.RETKEY.UNIONID, ""), extras.getString(CommonConstant.RETKEY.COUNTRYCODE, ""));
                build.setIdToken(string5);
                build.setEmail(string6);
                build.setFamilyName(string7);
                build.setGivenName(string8);
                build.setAgeRange(string9);
                build.setHomeZone(conversionHomeZone(string10));
                Status status = new Status(i3);
                SignInResult signInResult = new SignInResult(status);
                signInResult.setStatus(status);
                signInResult.setAuthHuaweiId(build);
                as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult success", true);
                return signInResult;
            }
            if (i3 != 2002 && i3 != 2004) {
                activity = null;
            } else {
                Random random = new Random();
                as.b("HuaweiIdAuthAPIServiceImpl", "SDK version >= 23", true);
                activity = PendingIntent.getActivity(this.f37601a.getContext(), random.nextInt(), intent, 67108864);
            }
            Status status2 = new Status(i3, (String) null, activity);
            SignInResult signInResult2 = new SignInResult(status2);
            signInResult2.setStatus(status2);
            signInResult2.setData(intent);
            as.b("HuaweiIdAuthAPIServiceImpl", "getSignInResult fail", true);
            return signInResult2;
        }
        SignInResult signInResult3 = new SignInResult(new Status(2003));
        as.d("HuaweiIdAuthAPIServiceImpl", "getSignInResult error", true);
        return signInResult3;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public Intent getSignInIntent(HuaweiApiClient huaweiApiClient) {
        Context context = huaweiApiClient.getContext();
        HuaweiIdAuthParams signInOption = getSignInOption(huaweiApiClient);
        String str = null;
        if (signInOption == null) {
            return null;
        }
        if (huaweiApiClient.getSubAppInfo() != null) {
            str = huaweiApiClient.getSubAppInfo().getSubAppID();
        }
        return x.a(context, signInOption, str);
    }

    protected HuaweiIdAuthParams getSignInOption(HuaweiApiClient huaweiApiClient) {
        Api.ApiOptions apiOptions;
        Map<Api<?>, Api.ApiOptions> apiMap = huaweiApiClient.getApiMap();
        if (apiMap != null && (apiOptions = apiMap.get(HuaweiIdAuthAPIManager.HUAWEI_OAUTH_API)) != null && (apiOptions instanceof HuaweiIdAuthParams)) {
            return (HuaweiIdAuthParams) apiOptions;
        }
        return null;
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public HuaweiIdAuthResult parseHuaweiIdFromIntent(Intent intent) {
        return x.a(intent);
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<AddressResult> queryShippingAddress(HuaweiApiClient huaweiApiClient, AuthHuaweiId authHuaweiId) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter queryShippingAddress", true);
        return new b(huaweiApiClient, CommonNaming.queryShippingAddress, new QueryShippingAddressReq(authHuaweiId));
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<SignInResult> signIn(Activity activity, HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signIn", true);
        Checker.checkNonNull(activity, "Activity must not be null.");
        Checker.checkNonNull(huaweiApiClient, "HuaweiApiClient must not be null.");
        List<Scope> a16 = a(huaweiApiClient);
        List<PermissionInfo> b16 = b(huaweiApiClient);
        HashSet hashSet = new HashSet();
        Iterator<Scope> it = a16.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getScopeUri());
        }
        HashSet hashSet2 = new HashSet();
        Iterator<PermissionInfo> it5 = b16.iterator();
        while (it5.hasNext()) {
            hashSet2.add(it5.next().getPermission());
        }
        SignInReq signInReq = new SignInReq(hashSet, hashSet2);
        this.f37601a = huaweiApiClient;
        this.f37602b = new WeakReference<>(activity);
        return new PendingResultImpl<SignInResult, SignInResp>(huaweiApiClient, CommonNaming.signin, signInReq) { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.1
            @Override // com.huawei.hms.support.api.PendingResultImpl
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SignInResult onComplete(SignInResp signInResp) {
                as.b("HuaweiIdAuthAPIServiceImpl", "signIn onComplete:" + signInResp.getRetCode(), true);
                HuaweiIdAuthAPIServiceImpl.this.a(signInResp.getRetCode());
                Intent data = signInResp.getData();
                data.putExtra(CommonConstant.RETKEY.RETCODE, signInResp.getRetCode());
                return HuaweiIdAuthAPIServiceImpl.this.getHwIdSignInResultFromIntent(data);
            }
        };
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<SignInResult> signInBackend(HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signInBackend", true);
        Checker.checkNonNull(huaweiApiClient, "HuaweiApiClient must not be null.");
        this.f37601a = huaweiApiClient;
        List<Scope> a16 = a(huaweiApiClient);
        List<PermissionInfo> b16 = b(huaweiApiClient);
        HashSet hashSet = new HashSet();
        Iterator<Scope> it = a16.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getScopeUri());
        }
        HashSet hashSet2 = new HashSet();
        Iterator<PermissionInfo> it5 = b16.iterator();
        while (it5.hasNext()) {
            hashSet2.add(it5.next().getPermission());
        }
        return new PendingResultImpl<SignInResult, SignInResp>(huaweiApiClient, CommonNaming.singinbackend, new SignInReq(hashSet, hashSet2)) { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.2
            @Override // com.huawei.hms.support.api.PendingResultImpl
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SignInResult onComplete(SignInResp signInResp) {
                as.b("HuaweiIdAuthAPIServiceImpl", "signInBackend onComplete:" + signInResp.getRetCode(), true);
                Intent data = signInResp.getData();
                data.putExtra(CommonConstant.RETKEY.RETCODE, signInResp.getRetCode());
                return HuaweiIdAuthAPIServiceImpl.this.getHwIdSignInResultFromIntent(data);
            }
        };
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public PendingResult<Status> signOut(HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter signOut", true);
        if (!huaweiApiClient.isConnected()) {
            return d(huaweiApiClient);
        }
        return new d(huaweiApiClient, CommonNaming.signout, new SignOutReq());
    }

    @Override // com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService
    public OptionalPendingResult<HuaweiIdAuthResult> silentSignIn(HuaweiApiClient huaweiApiClient) {
        as.b("HuaweiIdAuthAPIServiceImpl", "Enter silentSignIn", true);
        Checker.checkNonNull(huaweiApiClient, "HuaweiApiClient must not be null.");
        this.f37601a = huaweiApiClient;
        return new OptionalPendingResultImpl(new PendingResultImpl<HuaweiIdAuthResult, SignInResp>(huaweiApiClient, CommonNaming.singinbackend, c(huaweiApiClient)) { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.3
            @Override // com.huawei.hms.support.api.PendingResultImpl
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HuaweiIdAuthResult onComplete(SignInResp signInResp) {
                as.b("HuaweiIdAuthAPIServiceImpl", "signInBackend onComplete:" + signInResp.getRetCode(), true);
                Intent data = signInResp.getData();
                data.putExtra(CommonConstant.RETKEY.RETCODE, signInResp.getRetCode());
                return HuaweiIdAuthAPIServiceImpl.this.getHuaweiIdSignInResultFromIntent(data);
            }
        });
    }

    static List<PermissionInfo> b(HuaweiApiClient huaweiApiClient) {
        return ((HuaweiApiClientImpl) huaweiApiClient).getPermissionInfos();
    }

    static List<Scope> a(HuaweiApiClient huaweiApiClient) {
        return ((HuaweiApiClientImpl) huaweiApiClient).getScopes();
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private AuthHuaweiId a(Bundle bundle) {
        int i3;
        if (bundle == null) {
            as.b("HuaweiIdAuthAPIServiceImpl", "bd is null", true);
            return new AuthHuaweiId();
        }
        String string = bundle.getString(CommonConstant.RETKEY.ACCESS_TOKEN, "");
        String string2 = bundle.getString(CommonConstant.RETKEY.SERVICEAUTHCODE, "");
        String string3 = bundle.getString(CommonConstant.RETKEY.DISPLAYNAME, "");
        String string4 = bundle.getString(CommonConstant.RETKEY.USERID, "");
        String string5 = bundle.getString(CommonConstant.RETKEY.OPENID, "");
        String string6 = bundle.getString(CommonConstant.RETKEY.PHOTOURL);
        String string7 = bundle.getString(CommonConstant.RETKEY.SERVICECOUNTRYCODE, "");
        String string8 = bundle.getString(CommonConstant.RETKEY.COUNTRYCODE, "");
        String string9 = bundle.getString(CommonConstant.RETKEY.UNIONID, "");
        int a16 = a(bundle.getString(CommonConstant.RETKEY.GENDER));
        int b16 = b(bundle.getString(CommonConstant.RETKEY.STATUS));
        int c16 = c(bundle.getString(CommonConstant.RETKEY.HOME_ZONE));
        String string10 = bundle.getString(CommonConstant.RETKEY.SCOPE);
        HashSet hashSet = new HashSet();
        if (string10 != null) {
            String[] split = string10.split(" ");
            int length = split.length;
            i3 = c16;
            int i16 = 0;
            while (i16 < length) {
                hashSet.add(new Scope(split[i16]));
                i16++;
                length = length;
                split = split;
            }
        } else {
            i3 = c16;
        }
        AuthHuaweiId build = AuthHuaweiId.build(string5, string4, string3, string6, string, string7, b16, a16, hashSet, string2, string9, string8);
        build.setIdToken(bundle.getString(CommonConstant.RETKEY.ID_TOKEN));
        build.setEmail(bundle.getString(CommonConstant.RETKEY.EMAIL));
        build.setFamilyName(bundle.getString(CommonConstant.RETKEY.FAMILY_NAME));
        build.setGivenName(bundle.getString(CommonConstant.RETKEY.GIVEN_NAME));
        build.setAgeRange(bundle.getString(CommonConstant.RETKEY.AGE_RANGE));
        build.setHomeZone(i3);
        return build;
    }

    private SignInReq c(HuaweiApiClient huaweiApiClient) {
        List<Scope> a16 = a(huaweiApiClient);
        List<PermissionInfo> b16 = b(huaweiApiClient);
        HashSet hashSet = new HashSet();
        Iterator<Scope> it = a16.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getScopeUri());
        }
        HashSet hashSet2 = new HashSet();
        Iterator<PermissionInfo> it5 = b16.iterator();
        while (it5.hasNext()) {
            hashSet2.add(it5.next().getPermission());
        }
        return new SignInReq(hashSet, hashSet2);
    }

    private int a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "-1";
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        if (i3 == 0 && HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.f37601a.getContext()) == 0) {
            new BaseTimer().schedule(new TimerTask() { // from class: com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIServiceImpl.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ConnectService.getNotice(HuaweiIdAuthAPIServiceImpl.this.f37601a, 1, "6.4.0.302").setResultCallback(new a());
                }
            }, 200L);
        }
    }
}
