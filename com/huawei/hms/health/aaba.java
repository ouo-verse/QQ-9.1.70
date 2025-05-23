package com.huawei.hms.health;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hihealth.HiHealthStatusCodes;
import com.huawei.hms.hihealth.HuaweiHiHealth;
import com.huawei.hms.hihealth.SettingController;
import com.huawei.hms.hihealth.result.HealthKitAuthResult;
import com.huawei.hms.support.account.AccountAuthManager;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import java.util.ArrayList;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aaba extends ReportAndroidXFragment {
    private View aab;
    private Activity aaba;
    private SettingController aabb;
    private AuthAccount aabc;
    private String[] aabd;
    private boolean aabe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aab implements OnFailureListener {
        final /* synthetic */ AccountAuthService aab;

        aab(AccountAuthService accountAuthService) {
            this.aab = accountAuthService;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            try {
                aabz.aabb("HealthKitAuthHubFragment", "silentSignIn failure on exception");
                aaba.this.startActivityForResult(this.aab.getSignInIntent(), 1002);
            } catch (Throwable unused) {
                aabz.aab("HealthKitAuthHubFragment", "authHuaweiIdTask signInIntent has exception");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.huawei.hms.health.aaba$aaba, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0261aaba implements OnSuccessListener<AuthAccount> {
        C0261aaba() {
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public void onSuccess(AuthAccount authAccount) {
            AuthAccount authAccount2 = authAccount;
            try {
                if (authAccount2 == null) {
                    aabz.aabc("HealthKitAuthHubFragment", "silentSignIn result is null");
                    aaba.this.aab(HiHealthStatusCodes.HUAWEI_ID_SIGNIN_ERROR);
                } else {
                    aabz.aabb("HealthKitAuthHubFragment", "silentSignIn success");
                    aaba.this.aabc = authAccount2;
                    if (!aaba.this.aabe) {
                        aaba.this.aab();
                    } else {
                        aaba.this.aab(true);
                    }
                }
            } catch (Throwable unused) {
                aabz.aab("HealthKitAuthHubFragment", "authHuaweiIdTask has exception");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabb implements OnFailureListener {
        final /* synthetic */ PopupWindow aab;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class aab implements Runnable {
            final /* synthetic */ Exception aab;

            aab(Exception exc) {
                this.aab = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                aaba aabaVar;
                int aab;
                try {
                    aabb.this.aab.dismiss();
                    if (this.aab != null) {
                        aabz.aabb("HealthKitAuthHubFragment", "checkOrAuthorizeHealth has exception");
                        aabaVar = aaba.this;
                        aab = aabaVar.aab(this.aab.getMessage());
                    } else {
                        aabz.aabb("HealthKitAuthHubFragment", "checkOrAuthorizeHealth Failure");
                        aabaVar = aaba.this;
                        aab = aabaVar.aab((String) null);
                    }
                    aabaVar.aab(aab);
                } catch (Throwable unused) {
                    aabz.aab("HealthKitAuthHubFragment", "checkAuthorizeHealth fail run has exception");
                }
            }
        }

        aabb(PopupWindow popupWindow) {
            this.aab = popupWindow;
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            try {
                aaba.this.aaba.getWindow().getDecorView().post(new aab(exc));
            } catch (Throwable unused) {
                aabz.aab("HealthKitAuthHubFragment", "checkAuthorizeHealth fail run has exception");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class aabc implements OnSuccessListener<Boolean> {
        final /* synthetic */ PopupWindow aab;
        final /* synthetic */ boolean aaba;

        aabc(PopupWindow popupWindow, boolean z16) {
            this.aab = popupWindow;
            this.aaba = z16;
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public void onSuccess(Boolean bool) {
            try {
                aaba.this.aaba.getWindow().getDecorView().post(new com.huawei.hms.health.aabb(this, bool));
            } catch (Throwable unused) {
                aabz.aab("HealthKitAuthHubFragment", "checkAuthorizeHealth success has exception");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class aabd implements Runnable {
        private PopupWindow aab;
        private View aaba;

        aabd(PopupWindow popupWindow, View view) {
            this.aab = popupWindow;
            this.aaba = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                this.aab.showAtLocation(this.aaba, 17, 0, 0);
            } catch (WindowManager.BadTokenException unused) {
                str = "PopupWindow show failed BadTokenException";
                aabz.aabc("HealthKitAuthHubFragment", str);
            } catch (Throwable unused2) {
                str = "PopupWindow show failed Exception";
                aabz.aabc("HealthKitAuthHubFragment", str);
            }
        }
    }

    private void aaba() {
        try {
            Intent intent = this.aaba.getIntent();
            if (intent != null) {
                this.aabd = intent.getStringArrayExtra("scopes");
                this.aabe = intent.getBooleanExtra("enableHealthAuth", false);
                aabz.aabb("HealthKitAuthHubFragment", "init params success, to enable auth is " + this.aabe);
            }
            if (this.aabd == null) {
                aabz.aabc("HealthKitAuthHubFragment", "scopes params is null");
                this.aabd = new String[0];
            }
        } catch (IllegalArgumentException unused) {
            aabz.aab("HealthKitAuthHubFragment", "IllegalArgumentException error");
            this.aabd = new String[0];
        } catch (Throwable unused2) {
            aabz.aab("HealthKitAuthHubFragment", "initParams error");
            this.aabd = new String[0];
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        aabz.aabb("HealthKitAuthHubFragment", "onActivityResult requestCode:" + i3);
        try {
            aab(i3, intent);
            if (i3 == 1003) {
                aabz.aabb("HealthKitAuthHubFragment", "handleHealthAuthResult to checkAuthorizeHealth" + i16);
                if (i16 == -1) {
                    aab();
                } else {
                    aab(HiHealthStatusCodes.HEALTH_APP_NOT_AUTHORISED);
                }
            }
            if (i3 == 1004) {
                aab(false);
            }
        } catch (Throwable unused) {
            aabz.aabc("HealthKitAuthHubFragment", "onActivityResult has throwable");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        aabz.aabb("HealthKitAuthHubFragment", "HealthKitAuthHubActivity onCreate");
        try {
            super.onCreate(bundle);
            aabz.aabb("HealthKitAuthHubFragment", "HiHealthKitClient connect to service");
            FragmentActivity activity = getActivity();
            this.aaba = activity;
            this.aabb = HuaweiHiHealth.getSettingController((Activity) activity);
            aaba();
            aabb();
        } catch (IllegalArgumentException unused) {
            str = "finish has IllegalArgumentException";
            aabz.aab("HealthKitAuthHubFragment", str);
        } catch (Throwable unused2) {
            str = "finish has exception";
            aabz.aab("HealthKitAuthHubFragment", str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.aab == null) {
            this.aab = layoutInflater.inflate(R.layout.e_7, viewGroup, false);
        }
        View view = this.aab;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aab(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains(String.valueOf(HiHealthStatusCodes.NON_HEALTH_USER))) {
                return HiHealthStatusCodes.NON_HEALTH_USER;
            }
            if (str.contains(String.valueOf(HiHealthStatusCodes.UNTRUST_COUNTRY_CODE))) {
                return HiHealthStatusCodes.UNTRUST_COUNTRY_CODE;
            }
            if (str.contains(String.valueOf(HiHealthStatusCodes.NO_NETWORK))) {
                return HiHealthStatusCodes.NO_NETWORK;
            }
            if (str.contains(String.valueOf(50005))) {
                return 50005;
            }
            if (str.contains(String.valueOf(HiHealthStatusCodes.HEALTH_APP_NOT_ENABLED))) {
                return HiHealthStatusCodes.HEALTH_APP_NOT_ENABLED;
            }
        }
        return 50011;
    }

    private void aabb() {
        aabz.aabb("HealthKitAuthHubFragment", "on signInHwId click");
        ArrayList arrayList = new ArrayList();
        String[] strArr = this.aabd;
        if (strArr != null) {
            for (String str : strArr) {
                arrayList.add(new Scope(str));
            }
        }
        arrayList.toString();
        AccountAuthService service = AccountAuthManager.getService(this.aaba, new AccountAuthParamsHelper().setScopeList(arrayList).createParams());
        service.silentSignIn().addOnSuccessListener(new C0261aaba()).addOnFailureListener(new aab(service));
    }

    private void aab(int i3, Intent intent) {
        String str;
        if (i3 != 1002) {
            return;
        }
        aabz.aabb("HealthKitAuthHubFragment", "HMS handleSignInResult");
        if (intent == null) {
            str = "HMS SignInResult data is null";
        } else {
            Task<AuthAccount> parseAuthResultFromIntent = AccountAuthManager.parseAuthResultFromIntent(intent);
            if (parseAuthResultFromIntent != null) {
                if (!parseAuthResultFromIntent.isSuccessful()) {
                    aabz.aabc("HealthKitAuthHubFragment", "HMS SignInResult result is fail");
                    aab(((ApiException) parseAuthResultFromIntent.getException()).getStatusCode());
                    return;
                }
                aabz.aabb("HealthKitAuthHubFragment", "handleSignInResult isSuccess");
                this.aabc = parseAuthResultFromIntent.getResult();
                if (this.aabe) {
                    aab(true);
                    return;
                } else {
                    aab();
                    return;
                }
            }
            str = "HMS SignInResult result is null";
        }
        aabz.aabc("HealthKitAuthHubFragment", str);
        aab(HiHealthStatusCodes.HUAWEI_ID_SIGNIN_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaba(String str) {
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                aab(HiHealthStatusCodes.HEALTH_APP_NOT_AUTHORISED);
                return;
            }
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            Bundle bundle = new Bundle();
            HealthKitAuthResult healthKitAuthResult = new HealthKitAuthResult();
            healthKitAuthResult.setAuthAccount(this.aabc);
            try {
                str2 = healthKitAuthResult.toJson();
            } catch (JSONException unused) {
                str2 = "";
            }
            bundle.putString("HEALTHKIT_AUTH_RESULT", str2);
            bundle.putString("authUrl", str);
            aabg aabgVar = new aabg();
            aabgVar.setArguments(bundle);
            beginTransaction.addToBackStack(null).replace(R.id.x9c, aabgVar).show(aabgVar).commit();
        } catch (Throwable unused2) {
            aabz.aab("HealthKitAuthHubFragment", "startCloudAuth has exception");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaba(boolean z16) {
        if (z16) {
            try {
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("huaweischeme://healthapp/achievement?module=kit"));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.setSelector(null);
                intent.setPackage("com.huawei.health");
                if (intent.resolveActivity(this.aaba.getPackageManager()) == null || !aacu.aab(this.aaba, "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "com.huawei.health")) {
                    aabz.aabb("HealthKitAuthHubFragment", "handleCheckAuthFail begin to open H5");
                    this.aabb.getAuthUrl().addOnSuccessListener(new com.huawei.hms.health.aabd(this)).addOnFailureListener(new com.huawei.hms.health.aabc(this));
                } else {
                    aabz.aabb("HealthKitAuthHubFragment", "handleCheckAuthFail begin to open activity from health app");
                    startActivityForResult(intent, 1004);
                }
                return;
            } catch (IllegalArgumentException unused) {
                aabz.aabb("HealthKitAuthHubFragment", "handleCheckAuthFail is IllegalArgumentException");
            }
        }
        aab(HiHealthStatusCodes.HEALTH_APP_NOT_AUTHORISED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab(int i3) {
        aabz.aabb("HealthKitAuthHubFragment", "auth fail with errorCode is " + i3);
        this.aaba.setResult(-1, aacu.aab(i3, this.aabc));
        this.aaba.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab() {
        aabz.aabb("HealthKitAuthHubFragment", "auth success");
        this.aaba.setResult(-1, aacu.aab(0, this.aabc));
        this.aaba.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aab(boolean z16) {
        aabz.aabb("HealthKitAuthHubFragment", "begint to checkOrAuthorizeHealth");
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setHeight(-2);
        popupWindow.setWidth(-2);
        popupWindow.setFocusable(true);
        View inflate = LayoutInflater.from(this.aaba).inflate(R.layout.f_u, (ViewGroup) null);
        popupWindow.setContentView(inflate);
        this.aaba.getWindow().getDecorView().post(new aabd(popupWindow, inflate));
        this.aabb.getHealthAppAuthorization().addOnSuccessListener(new aabc(popupWindow, z16)).addOnFailureListener(new aabb(popupWindow));
    }
}
