package com.huawei.hms.hihealth.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.huawei.hms.health.aaba;
import com.huawei.hms.health.aabf;
import com.huawei.hms.health.aabg;
import com.huawei.hms.health.aabz;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthKitMainActivity extends FragmentActivity {
    public static final String HEALTH_FRAGMENT_CODE = "FragmentName";
    public static final int HEALTH_TRANSPARENT_CODE = 1;
    public static final int PRIVACY_TRANS_PARENT_ACTIVITY_CODE = 2;
    private static final String TAG = "HealthKitMainActivity";

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.x9c, fragment);
        beginTransaction.commit();
    }

    private void replaceWebviewFragment(Fragment fragment, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString("authUrl", intent.getStringExtra("authUrl"));
        bundle.putInt("flag", intent.getIntExtra("flag", 0));
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        fragment.setArguments(bundle);
        beginTransaction.replace(R.id.x9c, fragment);
        beginTransaction.commit();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public void finish() {
        String str;
        try {
            aabz.aabb(TAG, "to finish HealthKitMainActivity");
            super.finish();
            overridePendingTransition(0, 0);
        } catch (IllegalArgumentException unused) {
            str = "finish has IllegalArgumentException";
            aabz.aab(TAG, str);
        } catch (Exception unused2) {
            str = "finish has exception";
            aabz.aab(TAG, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        aabz.aabb(TAG, "onActivityResult requestCode:" + i3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        aabz.aabb(TAG, "HealthKitMainActivity onCreate");
        super.onCreate(bundle);
        try {
            setContentView(R.layout.dqq);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(getResources().getColor(R.color.f157171bv0));
            int intExtra = getIntent().getIntExtra(HEALTH_FRAGMENT_CODE, 0);
            if (intExtra == 1) {
                getSupportFragmentManager().beginTransaction().replace(R.id.x9c, new aabf()).addToBackStack(null).commit();
            } else if (intExtra == 2) {
                replaceWebviewFragment(new aabg(), getIntent());
            } else {
                replaceFragment(new aaba());
            }
        } catch (Throwable unused) {
            aabz.aab(TAG, "onCreate has exception");
        }
    }
}
