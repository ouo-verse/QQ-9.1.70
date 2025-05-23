package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AuthDevEnableCompleteActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private Button f174980a0;

    /* renamed from: b0, reason: collision with root package name */
    private LinearLayout f174981b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f174982c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f174983d0;

    /* renamed from: e0, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.antiphing.b> f174984e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f174985f0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevEnableCompleteActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ImageView imageView = (ImageView) view.findViewById(R.id.dce);
                if (imageView != null) {
                    if (imageView.getVisibility() == 0) {
                        i3 = 4;
                    } else {
                        i3 = 0;
                    }
                    imageView.setVisibility(i3);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AuthDevEnableCompleteActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f174980a0 = null;
        this.f174981b0 = null;
        this.f174982c0 = null;
        this.f174983d0 = 0;
        this.f174984e0 = null;
        this.f174985f0 = false;
    }

    private View G2(String str, String str2, boolean z16, boolean z17, boolean z18) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            View inflate = getLayoutInflater().inflate(R.layout.f168797au1, (ViewGroup) this.f174981b0, false);
            if (inflate != null && this.f174981b0 != null) {
                inflate.setOnClickListener(new a());
                ImageView imageView = (ImageView) inflate.findViewById(R.id.check);
                TextView textView = (TextView) inflate.findViewById(R.id.f5e);
                TextView textView2 = (TextView) inflate.findViewById(R.id.jkl);
                TextView textView3 = (TextView) inflate.findViewById(R.id.info);
                if (imageView != null && textView != null && textView2 != null && textView3 != null) {
                    imageView.setVisibility(0);
                    textView.setText(str);
                    textView2.setText(getString(R.string.ayy));
                    textView3.setText(str2);
                    return inflate;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "some controls are invalide!");
                }
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " view initialization failed!");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " parameter is Wrong!");
        }
        return null;
    }

    private void initUI() {
        boolean z16;
        boolean z17;
        boolean z18;
        super.setContentView(R.layout.atw);
        setTitle(R.string.azi);
        this.f174980a0 = (Button) findViewById(R.id.ah7);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ip8);
        this.f174981b0 = linearLayout;
        if (this.f174980a0 != null && linearLayout != null) {
            TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
            if (textView != null) {
                textView.setVisibility(8);
            }
            this.f174980a0.setOnClickListener(this);
            ArrayList<com.tencent.mobileqq.antiphing.b> B = EquipmentLockImpl.o().B();
            this.f174984e0 = B;
            int size = B.size();
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                com.tencent.mobileqq.antiphing.b bVar = this.f174984e0.get(i16);
                if (bVar != null) {
                    int i17 = bVar.f194365g;
                    if (i17 != 1 && i17 != 2) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    byte[] bArr = bVar.f194361c;
                    if ((bArr != null && bArr.equals(com.tencent.mobileqq.guid.c.f213821a.c())) || bVar.f194365g == 1) {
                        bVar.f194366h = true;
                        z18 = false;
                        z17 = true;
                    } else {
                        z17 = z16;
                        z18 = true;
                    }
                    View G2 = G2(bVar.f194359a, bVar.f194360b, z17, z18, bVar.f194366h);
                    if (G2 != null) {
                        bVar.f194367i = i3;
                        i3++;
                        RelativeLayout relativeLayout = (RelativeLayout) G2.findViewById(R.id.dq8);
                        if (size == 1) {
                            relativeLayout.setBackgroundResource(R.drawable.common_strip_setting_bg);
                        } else if (i3 == 1) {
                            relativeLayout.setBackgroundResource(R.drawable.common_strip_setting_top);
                        } else if (i16 == size - 1) {
                            relativeLayout.setBackgroundResource(R.drawable.common_strip_setting_bottom);
                        } else {
                            relativeLayout.setBackgroundResource(R.drawable.common_strip_setting_middle);
                        }
                        this.f174981b0.addView(G2);
                    }
                }
            }
            try {
                EquipmentLockImpl.o().C(null, this.app.getCurrentAccountUin(), 10);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "one or more controls is null in AuthDevEnableCompleteActivity! ");
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
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (AuthDevOpenUgActivity.getIsH5Jump() && this.f174985f0) {
            finish();
            ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startAccountSecurityPage(this, new Intent(), -1);
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View childAt;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ah7) {
                if (QLog.isColorLevel()) {
                    QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "click confirm mobile phone button! ");
                }
                try {
                    EquipmentLockImpl.o().C(null, this.app.getCurrentAccountUin(), 11);
                } catch (Exception unused) {
                }
                ArrayList<com.tencent.mobileqq.antiphing.b> arrayList = this.f174984e0;
                if (arrayList != null && this.f174981b0 != null) {
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        com.tencent.mobileqq.antiphing.b bVar = this.f174984e0.get(i3);
                        int i16 = bVar.f194367i;
                        if (i16 >= 0 && (childAt = this.f174981b0.getChildAt(i16)) != null) {
                            if (((ImageView) childAt.findViewById(R.id.check)).getVisibility() == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                if (bVar.f194365g == 0) {
                                    bVar.f194365g = 3;
                                }
                            } else {
                                bVar.f194365g = 0;
                            }
                        }
                    }
                }
                EquipmentLockImpl.o().O(this.app, this.f174984e0);
                Intent intent = new Intent();
                intent.putExtra(AuthDevOpenUgActivity.KEY_AUTH_DEV_OPEN, true);
                if (this.f174982c0 != null) {
                    intent.putExtra("country_code", this.f174983d0);
                    intent.putExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM, this.f174982c0);
                }
                RouteUtils.startActivity(this, intent, RouterConstants.UI_ROUTE_AUTH_DEV_ACTIVITY);
                overridePendingTransition(0, R.anim.f154458a7);
                EquipmentLockImpl.o().j();
                finish();
            } else if (id5 == R.id.ivTitleBtnRightText) {
                if (QLog.isColorLevel()) {
                    QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "onClick right cancel button! ");
                }
                finish();
                overridePendingTransition(0, R.anim.f154458a7);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        Intent intent = getIntent();
        if (intent == null) {
            super.onCreate(bundle);
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            super.onCreate(bundle);
            finish();
            return;
        }
        this.f174985f0 = extras.getBoolean("h5_flag");
        this.f174982c0 = extras.getString(AuthDevOpenUgActivity.KEY_PHONE_NUM);
        this.f174983d0 = extras.getInt("country_code");
        if (QLog.isColorLevel()) {
            QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "on Create AuthDevEnableCompleteActivity\uff01");
        }
        super.onCreate(bundle);
        initUI();
    }
}
