package com.tencent.mobileqq.ark.setting;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAuthorityInfoActivity extends IphoneTitleBarActivity {

    /* renamed from: b0, reason: collision with root package name */
    private static final String[] f199627b0 = {IArkModuleAPIAuthority.ARK_AUTHORITY_API_USER_INFO, IArkModuleAPIAuthority.ARK_AUTHORITY_API_LOCATION, IArkModuleAPIAuthority.ARK_AUTHORITY_API_RELATIONSHIP, IArkModuleAPIAuthority.ARK_AUTHORITY_API_LOGIN, IArkModuleAPIAuthority.ARK_AUTHORITY_API_PHONENUMBER};

    /* renamed from: a0, reason: collision with root package name */
    private String f199628a0;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f199629d;

        a(int i3) {
            this.f199629d = i3;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            int i3;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IArkModuleAPIAuthority iArkModuleAPIAuthority = (IArkModuleAPIAuthority) QRoute.api(IArkModuleAPIAuthority.class);
            String str = ArkAuthorityInfoActivity.this.f199628a0;
            String str2 = ArkAuthorityInfoActivity.f199627b0[this.f199629d];
            String currentAccountUin = ArkAuthorityInfoActivity.this.app.getCurrentAccountUin();
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            iArkModuleAPIAuthority.updateArkAuthorityInfo(str, str2, currentAccountUin, i3);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        boolean z16;
        super.doOnCreate(bundle);
        setContentView(R.layout.f167661dk);
        super.setTitle(R.string.f170432qo);
        this.f199628a0 = getIntent().getStringExtra("intent_extra_authority_app_name");
        ((TextView) super.findViewById(R.id.f164454yd)).setText(getString(R.string.f170438r0, this.f199628a0));
        int[] iArr = {R.id.f164450y9, R.id.f164446y5, R.id.f164449y8, R.id.f164447y6, R.id.f164448y7};
        int i3 = 0;
        while (true) {
            String[] strArr = f199627b0;
            if (i3 >= strArr.length) {
                return true;
            }
            FormSwitchItem formSwitchItem = (FormSwitchItem) super.findViewById(iArr[i3]);
            int arkAuthorityInfo = ((IArkModuleAPIAuthority) QRoute.api(IArkModuleAPIAuthority.class)).getArkAuthorityInfo(this.f199628a0, strArr[i3], this.app.getCurrentAccountUin());
            if (arkAuthorityInfo == 0) {
                formSwitchItem.setVisibility(8);
            } else {
                formSwitchItem.setVisibility(0);
                if (1 == arkAuthorityInfo) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                formSwitchItem.setChecked(z16);
                formSwitchItem.setOnCheckedChangeListener(new a(i3));
            }
            i3++;
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
