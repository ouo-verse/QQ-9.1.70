package com.tencent.open.agent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.t;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.protofile.sdkauthorize.SdkAuthorize$GetAuthApiListResponse;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AuthorityActivity extends QBaseActivity implements View.OnClickListener, ep3.g {

    /* renamed from: a0, reason: collision with root package name */
    private long f339535a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f339536b0;

    /* renamed from: c0, reason: collision with root package name */
    private QQProgressDialog f339537c0;

    /* renamed from: d0, reason: collision with root package name */
    private CardContainer f339538d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f339539e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f339540f0;

    /* renamed from: g0, reason: collision with root package name */
    private ep3.f f339541g0;

    /* renamed from: h0, reason: collision with root package name */
    private Handler f339542h0 = new Handler(Looper.getMainLooper());

    /* renamed from: i0, reason: collision with root package name */
    private Runnable f339543i0 = new Runnable() { // from class: com.tencent.open.agent.AuthorityActivity.3

        /* compiled from: P */
        /* renamed from: com.tencent.open.agent.AuthorityActivity$3$a */
        /* loaded from: classes22.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AuthorityActivity.this.dismissProgressDialog();
            AuthorityActivity.this.H7(true);
            AuthorityActivity.this.f339541g0.j();
            AuthorityActivity authorityActivity = AuthorityActivity.this;
            AuthUIUtil.f(authorityActivity, authorityActivity.getResources().getString(R.string.f171155cp4), new a());
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements AuthorityAccountView.d {
        a() {
        }

        @Override // com.tencent.open.agent.AuthorityAccountView.d
        public void b() {
            AuthorityActivity.this.f339541g0.b();
        }
    }

    private void I2() {
        ((ImmersiveTitleBar2) this.f339538d0.findViewById(R.id.jq6)).resetBkColor(0);
        this.f339538d0.findViewById(R.id.ivTitleBtnLeft).setOnClickListener(this);
        TextView textView = (TextView) this.f339538d0.findViewById(R.id.ivTitleName);
        this.f339539e0 = textView;
        textView.setText(R.string.cok);
        TextView textView2 = (TextView) this.f339538d0.findViewById(R.id.ivTitleBtnRightText);
        this.f339540f0 = textView2;
        textView2.setText(R.string.cancel);
        this.f339540f0.setOnClickListener(this);
    }

    private void J2(Bundle bundle) {
        Activity activity;
        this.f339536b0 = (Button) super.findViewById(R.id.fds);
        CardContainer cardContainer = (CardContainer) super.findViewById(R.id.arb);
        this.f339538d0 = cardContainer;
        cardContainer.setDeleteLastAccountListener(new a());
        I2();
        if (com.tencent.open.agent.util.c.b(getIntent(), "internal_authority", false)) {
            this.f339538d0.setTag(Boolean.TRUE);
            this.f339538d0.findViewById(R.id.f9a).setVisibility(8);
            this.f339538d0.setVisibility(4);
        }
        this.f339536b0.setOnClickListener(this);
        H7(false);
        AuthUIUtil.a((MaxHeightScrollView) findViewById(R.id.arc), this);
        if (com.tencent.open.agent.util.c.m(getIntent())) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, 0, R.layout.b18, 17);
            this.f339537c0 = qQProgressDialog;
            qQProgressDialog.setHeightParams(-1);
        } else {
            if (isChild()) {
                activity = getParent();
            } else {
                activity = this;
            }
            this.f339537c0 = new QQProgressDialog(activity, getTitleBarHeight());
        }
        String i3 = com.tencent.open.agent.util.c.i(bundle, "oauth_app_name");
        if (!TextUtils.isEmpty(i3)) {
            p0(i3, null);
        }
    }

    private void K2(Bundle bundle) {
        CardContainer cardContainer;
        AuthorityAccountView authorityAccountView;
        if (!com.tencent.open.agent.util.c.a(bundle, "key_login_by_qr_scan", false) || (authorityAccountView = (cardContainer = this.f339538d0).P) == null) {
            return;
        }
        cardContainer.l();
        TextView textView = (TextView) authorityAccountView.findViewById(R.id.f163850ac);
        textView.setVisibility(0);
        textView.setText(AuthUIUtil.d(bundle));
    }

    @Override // ep3.g
    public void G1(String str, String str2, Bitmap bitmap) {
        this.f339538d0.q(str, str2, bitmap);
    }

    public void H2(String str, boolean z16) {
        this.f339541g0.d(str, z16);
    }

    @Override // ep3.c
    public void H7(boolean z16) {
        this.f339536b0.setEnabled(z16);
    }

    public void L2() {
        TextView textView = this.f339539e0;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.f157443pk));
            this.f339539e0.setText("");
        }
        TextView textView2 = this.f339540f0;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColorStateList(R.color.f157443pk));
        }
    }

    @Override // ep3.g
    public boolean X5(SdkAuthorize$GetAuthApiListResponse sdkAuthorize$GetAuthApiListResponse, String str) {
        return this.f339538d0.n(sdkAuthorize$GetAuthApiListResponse, str);
    }

    @Override // ep3.g
    public void Xa(ep3.f fVar) {
        this.f339541g0 = fVar;
    }

    @Override // ep3.c
    public void dismissProgressDialog() {
        AuthUIUtil.c(this, this.f339537c0);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        t.b("AuthorityActivity", "--onActivityResult, requestCode: " + i3 + " | resultCode:" + i16);
        if (i3 == 100) {
            this.f339541g0.f(i16, intent);
            return;
        }
        dismissProgressDialog();
        if (i16 == 0) {
            this.f339541g0.a(i16, intent);
        } else {
            if (-1 != i16 || intent == null || com.tencent.open.agent.util.g.M(this, intent)) {
                return;
            }
            this.f339542h0.post(new Runnable() { // from class: com.tencent.open.agent.AuthorityActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    AuthorityActivity.this.f339538d0.P.r();
                }
            });
            this.f339541g0.a(i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        t.b("AuthorityActivity", "doOnBackPressed");
        super.doOnBackPressed();
        this.f339541g0.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        this.mNeedStatusTrans = false;
        t.b("AuthorityActivity", "doOnCreate");
        return super.doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        t.b("AuthorityActivity", "doOnDestroy");
        super.doOnDestroy();
        dismissProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        this.f339541g0.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        this.f339541g0.doOnResume();
        String str = Build.MANUFACTURER + DeviceInfoMonitor.getModel();
        t.b("AuthorityActivity", "doOnResume manu=", str);
        if (!str.equals("MeizuPRO 7-S") && !str.equalsIgnoreCase("MeizuM711C")) {
            ImmersiveUtils.trySetImmersiveStatusBar(getWindow());
        } else {
            ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        }
        ImmersiveUtils.setStatusTextColor(true, getWindow());
    }

    @Override // ep3.c
    public Object fe(int i3) {
        if (i3 != 3) {
            if (i3 != 4) {
                return null;
            }
            return this.f339538d0.o();
        }
        return this;
    }

    @Override // ep3.c
    public void ld(long j3) {
        p2();
        this.f339542h0.postDelayed(this.f339543i0, j3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f339540f0) {
            this.f339541g0.k();
        } else if (view.getId() == R.id.a0v) {
            this.f339541g0.l();
            this.f339538d0.m();
        } else if (view == this.f339536b0) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (view) {
                if (currentTimeMillis - this.f339535a0 >= 500) {
                    this.f339535a0 = currentTimeMillis;
                    if (!NetworkUtil.isNetworkAvailable(this)) {
                        t.b("AuthorityActivity", "mAuthorizeBtn click, network not available ");
                        this.f339542h0.removeCallbacks(this.f339543i0);
                        this.f339542h0.post(this.f339543i0);
                    } else {
                        this.f339541g0.c();
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t.b("AuthorityActivity", "-->onCreate--");
        if (!(super.getAppRuntime() instanceof AbstractOpenSdkAppInterface)) {
            return;
        }
        super.setContentView(R.layout.f168458wp);
        Bundle d16 = com.tencent.open.agent.util.c.d(getIntent(), "key_params");
        J2(d16);
        ep3.a.c(this, this);
        if (this.f339541g0.onCreate(d16)) {
            return;
        }
        q2(com.tencent.open.agent.util.c.i(d16, CommonConstant.ReqAccessTokenParam.CLIENT_ID));
        K2(d16);
    }

    @Override // ep3.c
    public void p0(String str, Bitmap bitmap) {
        this.f339538d0.p(str, bitmap);
    }

    @Override // ep3.g
    public void p2() {
        this.f339542h0.removeCallbacks(this.f339543i0);
    }

    @Override // ep3.g
    public void q2(String str) {
        this.f339538d0.r(1, str);
    }

    @Override // ep3.c
    public void showProgressDialog(int i3) {
        this.f339537c0.setMessage(getResources().getString(i3));
        AuthUIUtil.k(this, this.f339537c0, 0);
    }
}
