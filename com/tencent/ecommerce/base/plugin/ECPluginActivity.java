package com.tencent.ecommerce.base.plugin;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.permission.api.IPermission;
import com.tencent.ecommerce.base.plugin.ECPluginApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0015J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0014J\b\u0010\f\u001a\u00020\u0006H\u0014J\"\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J/\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/ECPluginActivity;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "F2", "Landroid/os/Bundle;", "outState", "", "onSaveInstanceState", Constants.FILE_INSTANCE_STATE, "onCreate", "finish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onBackPressed", "toString", "a0", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "fragment", "Landroid/view/View;", "b0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "()V", "c0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public class ECPluginActivity extends FragmentActivity {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ECBaseFragment fragment;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    private final ECBaseFragment F2() {
        Object newInstance;
        String stringExtra = getIntent().getStringExtra("public_fragment_class");
        if (stringExtra != null) {
            try {
                newInstance = Class.forName(stringExtra).newInstance();
            } catch (Exception e16) {
                cg0.a.a("ECPluginActivity", "createFragment", e16.toString());
                return null;
            }
        } else {
            newInstance = null;
        }
        if (newInstance != null) {
            ECBaseFragment eCBaseFragment = (ECBaseFragment) newInstance;
            eCBaseFragment.setArguments(getIntent().getExtras());
            return eCBaseFragment;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.base.fragment.ECBaseFragment");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void finish() {
        boolean z16;
        super.finish();
        Intent intent = getIntent();
        if (!Intrinsics.areEqual(intent != null ? intent.getStringExtra("no_exit_anim") : null, "1")) {
            Intent intent2 = getIntent();
            if (!Intrinsics.areEqual(intent2 != null ? intent2.getStringExtra(KuiklyLaunchParams.PARAM_MODAL_MODE) : null, "1")) {
                z16 = false;
                if (z16) {
                    return;
                }
                overridePendingTransition(0, 0);
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ECBaseFragment eCBaseFragment = this.fragment;
        if (eCBaseFragment != null) {
            eCBaseFragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ECBaseFragment eCBaseFragment = this.fragment;
        if (eCBaseFragment == null || !eCBaseFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        if (!qQEcommerceSdk.getHasInited()) {
            Log.e("ECPluginActivity", "onCreate: QQEcommerceSdk have not inited");
            super.onCreate(savedInstanceState);
            finish();
            return;
        }
        ECPluginApplication.Companion companion = ECPluginApplication.INSTANCE;
        if (!companion.b()) {
            companion.c(getApplication());
        }
        Window window = getWindow();
        boolean z16 = true;
        if (window != null) {
            window.requestFeature(1);
        }
        Intent intent = getIntent();
        boolean areEqual = Intrinsics.areEqual(intent != null ? intent.getStringExtra("is_appcompat_style") : null, "1");
        Intent intent2 = getIntent();
        boolean z17 = Intrinsics.areEqual(intent2 != null ? intent2.getStringExtra("is_trans_activity") : null, "1") || Intrinsics.areEqual(getIntent().getStringExtra(KuiklyLaunchParams.PARAM_MODAL_MODE), "1");
        if (areEqual) {
            if (z17) {
                setTheme(R.style.f243117);
            } else {
                setTheme(R.style.f243106);
            }
        }
        IECActivityDelegate activityDelegate = qQEcommerceSdk.getGlobalInternalSdk().getActivityDelegate();
        if (activityDelegate != null) {
            activityDelegate.beforeCreate(this);
        }
        if (!Intrinsics.areEqual(getIntent().getStringExtra("no_enter_anim"), "1") && !Intrinsics.areEqual(getIntent().getStringExtra(KuiklyLaunchParams.PARAM_MODAL_MODE), "1")) {
            z16 = false;
        }
        if (z16) {
            overridePendingTransition(0, 0);
        }
        super.onCreate(savedInstanceState);
        IECActivityDelegate activityDelegate2 = qQEcommerceSdk.getGlobalInternalSdk().getActivityDelegate();
        if (activityDelegate2 != null) {
            activityDelegate2.onCreate(this);
        }
        ECBaseFragment F2 = F2();
        this.fragment = F2;
        if (F2 == null) {
            finish();
            return;
        }
        setContentView(R.layout.f167342ct0);
        View findViewById = findViewById(R.id.nx_);
        this.rootView = findViewById;
        if (z17) {
            if (findViewById == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            }
            findViewById.setBackground(new ColorDrawable(0));
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        ECBaseFragment eCBaseFragment = this.fragment;
        if (eCBaseFragment != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.nx_, eCBaseFragment);
            beginTransaction.commitAllowingStateLoss();
        }
        cg0.a.b("ECPluginActivity", "onCreate isPluginMode: false, sdkVersion: master-3318, launch " + this.fragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        if (!qQEcommerceSdk.getHasInited()) {
            Log.e("ECPluginActivity", "onDestroy: QQEcommerceSdk have not inited");
            super.onDestroy();
            return;
        }
        cg0.a.b("ECPluginActivity", "onDestroy " + this.fragment);
        super.onDestroy();
        IECActivityDelegate activityDelegate = qQEcommerceSdk.getGlobalInternalSdk().getActivityDelegate();
        if (activityDelegate != null) {
            activityDelegate.onDestroy(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        IPermission permission = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPermission();
        if (permission != null) {
            permission.onRequestPermissionResult(requestCode, permissions, grantResults);
            return;
        }
        ECBaseFragment eCBaseFragment = this.fragment;
        if (eCBaseFragment != null) {
            eCBaseFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IECActivityDelegate activityDelegate = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getActivityDelegate();
        if (activityDelegate != null) {
            activityDelegate.onResume(this);
        }
    }

    public String toString() {
        String activity = super.toString();
        ECBaseFragment eCBaseFragment = this.fragment;
        if (eCBaseFragment != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(activity);
            sb5.append("#");
            sb5.append(eCBaseFragment.getClass().getName());
            sb5.append("@");
            ECBaseFragment eCBaseFragment2 = this.fragment;
            sb5.append(Integer.toHexString(eCBaseFragment2 != null ? eCBaseFragment2.hashCode() : 0));
            String sb6 = sb5.toString();
            String businessDescription = eCBaseFragment.getBusinessDescription();
            if (TextUtils.isEmpty(businessDescription)) {
                return sb6;
            }
            int length = businessDescription.length() - 1;
            int i3 = 0;
            boolean z16 = false;
            while (i3 <= length) {
                boolean z17 = Intrinsics.compare((int) businessDescription.charAt(!z16 ? i3 : length), 32) <= 0;
                if (z16) {
                    if (!z17) {
                        break;
                    }
                    length--;
                } else if (z17) {
                    i3++;
                } else {
                    z16 = true;
                }
            }
            String obj = businessDescription.subSequence(i3, length + 1).toString();
            if (obj.length() > 50) {
                obj = obj.substring(0, 50);
                Intrinsics.checkNotNullExpressionValue(obj, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            }
            return sb6 + '{' + obj + '}';
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append(activity);
        sb7.append("#");
        Intent intent = getIntent();
        sb7.append(intent != null ? intent.getStringExtra("public_fragment_class") : null);
        return sb7.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
    }
}
