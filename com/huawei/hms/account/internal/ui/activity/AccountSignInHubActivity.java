package com.huawei.hms.account.internal.ui.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.hwid.a;
import com.huawei.hms.hwid.ao;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.ar;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.b;
import com.huawei.hms.hwid.f;
import com.huawei.hms.hwid.g;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.account.AccountSignInRequest;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.utils.HMSPackageManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AccountSignInHubActivity extends Activity {

    /* renamed from: e, reason: collision with root package name */
    private b f36608e;

    /* renamed from: f, reason: collision with root package name */
    private int f36609f;

    /* renamed from: a, reason: collision with root package name */
    private String f36604a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f36605b = false;

    /* renamed from: c, reason: collision with root package name */
    private AccountSignInRequest f36606c = null;

    /* renamed from: d, reason: collision with root package name */
    private AccountAuthResult f36607d = null;

    /* renamed from: g, reason: collision with root package name */
    private String f36610g = CommonNaming.signinIntent;

    private void b() {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "checkMinVersion start.", true);
        a.a(this, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.account.internal.ui.activity.AccountSignInHubActivity.1
            @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
            public void onComplete(int i3) {
                if (i3 == 0) {
                    as.b("[ACCOUNTSDK]AccountSignInHubActivity", "version check ok", true);
                    AccountSignInHubActivity.this.c();
                } else {
                    as.b("[ACCOUNTSDK]AccountSignInHubActivity", "version check failed", true);
                    AccountSignInHubActivity.this.a(i3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i3;
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "startSignInActivity", true);
        Intent d16 = d();
        try {
            if (this.f36609f == 1) {
                i3 = 16588;
            } else {
                i3 = 16587;
            }
            startActivityForResult(d16, i3);
        } catch (ActivityNotFoundException e16) {
            this.f36605b = true;
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "Launch sign in Intent failed. hms is probably being updated\uff1a" + e16.getClass().getSimpleName(), true);
            a(17);
        }
    }

    private Intent d() {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "getJosSignInIntent", true);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("HUAWEIID_CP_CLIENTINFO");
        String stringExtra2 = intent.getStringExtra("HUAWEIID_SIGNIN_REQUEST");
        String action = intent.getAction();
        try {
            b a16 = b.a(stringExtra);
            ForegroundIntentBuilder kitSdkVersion = new ForegroundIntentBuilder(this).setAction(action).setRequestBody(stringExtra2).setKitSdkVersion(60400300);
            if (a16.c() != null) {
                kitSdkVersion.setSubAppId(a16.c());
            }
            if (this.f36609f == 1) {
                as.b("[ACCOUNTSDK]AccountSignInHubActivity", "setApiLevel is 11", true);
                kitSdkVersion.setApiLevel(11);
            }
            if (e().booleanValue()) {
                as.b("[ACCOUNTSDK]AccountSignInHubActivity", "setApiLevel is 13", true);
                kitSdkVersion.setApiLevel(13);
            }
            Intent build = kitSdkVersion.build();
            as.b("[ACCOUNTSDK]AccountSignInHubActivity", "get package name of hms is " + HMSPackageManager.getInstance(this).getHMSPackageName(), true);
            as.b("[ACCOUNTSDK]AccountSignInHubActivity", "current package name is " + getPackageName(), true);
            build.setPackage(getPackageName());
            return build;
        } catch (Exception e16) {
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "getSignInIntent failed because:" + e16.getClass().getSimpleName(), true);
            return new Intent();
        }
    }

    private Boolean e() {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "checkCarrierIdPermission begin", true);
        AccountAuthParams accountAuthParams = this.f36606c.getAccountAuthParams();
        if (accountAuthParams == null) {
            return Boolean.FALSE;
        }
        List<PermissionInfo> permissionInfos = accountAuthParams.getPermissionInfos();
        if (ap.b(permissionInfos).booleanValue()) {
            Iterator<PermissionInfo> it = permissionInfos.iterator();
            while (it.hasNext()) {
                String permission = it.next().getPermission();
                if (permission != null && permission.equals(CommonConstant.LocalPermission.CARRIER_ID)) {
                    as.b("[ACCOUNTSDK]AccountSignInHubActivity", "permissioninfos contain carrierId", true);
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        SafeIntent safeIntent;
        String stringExtra;
        int i17;
        b bVar;
        super.onActivityResult(i3, i16, intent);
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "onActivityResult: requestCode\uff1a" + i3 + " , resultCode\uff1a" + i16, true);
        if (intent != null) {
            safeIntent = new SafeIntent(intent);
        } else {
            safeIntent = null;
        }
        if (!this.f36605b) {
            if (i3 == 16587 || i3 == 16588) {
                int i18 = 8;
                if (safeIntent != null && (stringExtra = intent.getStringExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID)) != null) {
                    try {
                        this.f36607d = new AccountAuthResult().fromJson(stringExtra);
                        if (i3 == 16587) {
                            g.a().a(this.f36607d.getAccount(), this.f36606c.getAccountAuthParams());
                        }
                        i17 = this.f36607d.getStatus().getStatusCode();
                    } catch (JSONException unused) {
                        this.f36607d = null;
                        as.d("[ACCOUNTSDK]AccountSignInHubActivity", "onActivityResult: JsonException", true);
                        i17 = 8;
                    }
                    String str = this.f36604a;
                    if (str != null && (bVar = this.f36608e) != null) {
                        HiAnalyticsClient.reportExit(this, this.f36610g, str, bVar.a(), ar.a(i17), i17, (int) this.f36608e.b());
                    }
                    setResult(i16, safeIntent);
                    finish();
                    return;
                }
                if (i16 > 0) {
                    i18 = i16;
                }
                a(i18);
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "onCreate", true);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (a(intent)) {
            a(0, "invalid intent");
        }
        a(intent.getBooleanExtra("intent.extra.isfullscreen", false));
        String action = intent.getAction();
        if (!TextUtils.equals("com.huawei.hms.jos.signIn", action) && !TextUtils.equals("com.huawei.hms.account.signIn", action) && !TextUtils.equals("com.huawei.hms.account.picker.signIn", action)) {
            String str = "unknow Action:";
            if (action != null) {
                str = "unknow Action:" + action;
            }
            a(0, str);
        }
        String stringExtra = intent.getStringExtra("HUAWEIID_CP_CLIENTINFO");
        try {
            this.f36606c = AccountSignInRequest.fromJson(intent.getStringExtra("HUAWEIID_SIGNIN_REQUEST"));
        } catch (JSONException unused) {
            this.f36606c = null;
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "onCreate: JsonException", true);
        }
        if (TextUtils.isEmpty(stringExtra)) {
            a(0, "Activity started with invalid cp client info");
            return;
        }
        try {
            this.f36608e = b.a(stringExtra);
        } catch (JSONException unused2) {
            this.f36608e = null;
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "onCreate: JsonException", true);
        }
        if (this.f36606c != null && this.f36608e != null) {
            if (!a()) {
                a(2003);
                return;
            }
            int intExtra = intent.getIntExtra("INDEPENDENT_SIGN_IN_FLAG", 0);
            this.f36609f = intExtra;
            if (intExtra == 1 && !b(intent).booleanValue()) {
                return;
            }
            ao.a(this);
            if (bundle != null) {
                restoreInstanceState(bundle);
                return;
            } else {
                this.f36604a = HiAnalyticsClient.reportEntry(this, this.f36610g, 60400300);
                b();
                return;
            }
        }
        a(0, "Activity started with invalid sign in request info");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "onSaveInstanceState start", true);
        String str = this.f36604a;
        if (str != null && bundle != null) {
            bundle.putString("HiAnalyticsTransId", str);
        }
    }

    protected void restoreInstanceState(Bundle bundle) {
        if (bundle != null) {
            this.f36604a = bundle.getString("HiAnalyticsTransId");
        }
    }

    private boolean a() {
        AccountAuthParams accountAuthParams = this.f36606c.getAccountAuthParams();
        if (accountAuthParams == null) {
            return false;
        }
        try {
            int optInt = new JSONObject(accountAuthParams.getSignInParams()).optInt(CommonConstant.RequestParams.KEY_ID_TOKEN_SIGN_ALG, 2);
            return optInt == 1 || optInt == 2;
        } catch (JSONException e16) {
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "JSONException:" + e16.getClass().getSimpleName(), true);
            return false;
        }
    }

    private Boolean b(Intent intent) {
        String stringExtra = intent.getStringExtra("ACCESS_TOKEN");
        AccountAuthParams accountAuthParams = this.f36606c.getAccountAuthParams();
        if (accountAuthParams == null) {
            a("accountAuthParams is null");
            return Boolean.FALSE;
        }
        List<Scope> requestScopeList = accountAuthParams.getRequestScopeList();
        if (!TextUtils.isEmpty(stringExtra) && !ap.a(requestScopeList).booleanValue() && requestScopeList.size() == 1) {
            this.f36610g = CommonNaming.independentsigninIntent;
            return Boolean.TRUE;
        }
        a("independent sign in params error");
        return Boolean.FALSE;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        */
    private boolean a(android.content.Intent r3) {
        /*
            r2 = this;
            r0 = 1
            if (r3 != 0) goto L4
            goto Lb
        L4:
            java.lang.String r1 = "ANYTHING"
            r3.getStringExtra(r1)     // Catch: java.lang.Exception -> Lb
            r0 = 0
        Lb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.account.internal.ui.activity.AccountSignInHubActivity.a(android.content.Intent):boolean");
    }

    private void a(int i3, String str) {
        as.d("[ACCOUNTSDK]AccountSignInHubActivity", "errMessage is: " + str, true);
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3) {
        b bVar;
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "onSignInAccountFailed: retCode\uff1a" + i3, true);
        String str = this.f36604a;
        if (str != null && (bVar = this.f36608e) != null) {
            HiAnalyticsClient.reportExit(this, this.f36610g, str, bVar.a(), ar.a(i3), i3, (int) this.f36608e.b());
        }
        Status status = new Status(i3);
        AccountAuthResult accountAuthResult = new AccountAuthResult();
        accountAuthResult.setStatus(status);
        Intent intent = new Intent();
        try {
            intent.putExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID, accountAuthResult.toJson());
        } catch (JSONException unused) {
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "convert result to json failed", true);
        }
        setResult(0, intent);
        finish();
    }

    private void a(String str) {
        as.d("[ACCOUNTSDK]AccountSignInHubActivity", "onIndependentSignInFailed errMessage:" + str, true);
        Status status = new Status(2003, str);
        AccountAuthResult accountAuthResult = new AccountAuthResult();
        accountAuthResult.setStatus(status);
        Intent intent = new Intent();
        try {
            intent.putExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID, accountAuthResult.toJson());
        } catch (JSONException unused) {
            as.d("[ACCOUNTSDK]AccountSignInHubActivity", "convert result to json failed", true);
        }
        setResult(0, intent);
        finish();
    }

    private void a(boolean z16) {
        as.b("[ACCOUNTSDK]AccountSignInHubActivity", "isActivityFullScreen is :" + z16, true);
        if (z16) {
            f.a(getWindow());
            getWindow().setFlags(1024, 1024);
        } else {
            f.a(this);
        }
    }
}
