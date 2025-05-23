package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.open.agent.quickauth.QuickAuthApp;
import com.tencent.open.agent.quickauth.QuickAuthAppInfo;
import com.tencent.open.agent.quickauth.WebQuickAuthHandler;
import com.tencent.open.agent.quickauth.ac;
import com.tencent.open.agent.quickauth.ad;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.u;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.base.http.d;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QuickLoginAuthorityActivity extends QBaseActivity implements View.OnClickListener, d.a, com.tencent.open.agent.quickauth.i {

    /* renamed from: c0, reason: collision with root package name */
    protected View f339990c0;

    /* renamed from: d0, reason: collision with root package name */
    protected View f339991d0;

    /* renamed from: e0, reason: collision with root package name */
    protected Button f339992e0;

    /* renamed from: f0, reason: collision with root package name */
    protected Bundle f339993f0;

    /* renamed from: g0, reason: collision with root package name */
    protected QQProgressDialog f339994g0;

    /* renamed from: h0, reason: collision with root package name */
    protected SharedPreferences f339995h0;

    /* renamed from: i0, reason: collision with root package name */
    protected List<String> f339996i0;

    /* renamed from: k0, reason: collision with root package name */
    protected OpenCardContainer f339998k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f339999l0;

    /* renamed from: m0, reason: collision with root package name */
    private ImmersiveTitleBar2 f340000m0;

    /* renamed from: n0, reason: collision with root package name */
    private TextView f340001n0;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f340002o0;

    /* renamed from: p0, reason: collision with root package name */
    private String f340003p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f340004q0;

    /* renamed from: a0, reason: collision with root package name */
    protected String f339988a0 = null;

    /* renamed from: b0, reason: collision with root package name */
    protected String f339989b0 = null;

    /* renamed from: j0, reason: collision with root package name */
    protected String f339997j0 = null;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f340005r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f340006s0 = false;

    /* renamed from: t0, reason: collision with root package name */
    private com.tencent.open.agent.quickauth.j f340007t0 = null;

    /* renamed from: u0, reason: collision with root package name */
    protected Handler f340008u0 = new b(ThreadManagerV2.getSubThreadLooper());

    /* renamed from: v0, reason: collision with root package name */
    protected Handler f340009v0 = new c(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bitmap q16;
            int i3 = message.what;
            if (i3 != 1000) {
                if (i3 != 1001) {
                    if (i3 == 1005) {
                        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "--> handler message GET_ACCOUNT_LIST");
                        OpenAuthorityAccountView openAuthorityAccountView = QuickLoginAuthorityActivity.this.f339998k0.H;
                        if (openAuthorityAccountView != null) {
                            openAuthorityAccountView.k();
                            Message obtain = Message.obtain();
                            obtain.what = 1006;
                            QuickLoginAuthorityActivity.this.f340009v0.sendMessage(obtain);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String str = (String) message.obj;
                if (!TextUtils.isEmpty(str) && (q16 = com.tencent.open.agent.util.g.q(str)) != null) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 1003;
                    obtain2.obj = q16;
                    QuickLoginAuthorityActivity.this.f340009v0.sendMessage(obtain2);
                    return;
                }
                return;
            }
            Bitmap bitmap = (Bitmap) message.obj;
            if (bitmap != null) {
                Bitmap s16 = com.tencent.open.agent.util.g.s(QuickLoginAuthorityActivity.this, bitmap, 50, 50);
                Message obtain3 = Message.obtain();
                obtain3.what = 1002;
                obtain3.obj = s16;
                QuickLoginAuthorityActivity.this.f340009v0.sendMessage(obtain3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OpenAuthorityAccountView openAuthorityAccountView;
            int i3 = message.what;
            if (i3 != 1003) {
                if (i3 == 1006 && (openAuthorityAccountView = QuickLoginAuthorityActivity.this.f339998k0.H) != null) {
                    openAuthorityAccountView.s();
                    return;
                }
                return;
            }
            Bitmap bitmap = (Bitmap) message.obj;
            if (bitmap != null) {
                QuickLoginAuthorityActivity.this.f339998k0.u("", bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f340013a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f340014b;

        d(boolean z16, String str) {
            this.f340013a = z16;
            this.f340014b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16, boolean z17, String str) {
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "-->login--has aone");
                }
                if (z17) {
                    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "changeAccountLogin, auto login is true, account is " + str + " ;currentAccount is" + QuickLoginAuthorityActivity.this.f339988a0);
                    QuickLoginAuthorityActivity quickLoginAuthorityActivity = QuickLoginAuthorityActivity.this;
                    quickLoginAuthorityActivity.f339989b0 = quickLoginAuthorityActivity.f339988a0;
                    quickLoginAuthorityActivity.L2(str);
                    return;
                }
                QuickLoginAuthorityActivity.this.M2(str);
                QuickLoginAuthorityActivity.this.f339989b0 = null;
                return;
            }
            QuickLoginAuthorityActivity.this.F0(str);
        }

        @Override // com.tencent.open.agent.util.u
        public void onResult(final boolean z16, String str) {
            QuickLoginAuthorityActivity quickLoginAuthorityActivity = QuickLoginAuthorityActivity.this;
            final boolean z17 = this.f340013a;
            final String str2 = this.f340014b;
            quickLoginAuthorityActivity.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.m
                @Override // java.lang.Runnable
                public final void run() {
                    QuickLoginAuthorityActivity.d.this.b(z16, z17, str2);
                }
            });
        }
    }

    private void J2() {
        this.f340000m0 = (ImmersiveTitleBar2) this.f339998k0.findViewById(R.id.jq6);
        TextView textView = (TextView) this.f339998k0.findViewById(R.id.ivTitleBtnRightText);
        this.f340001n0 = textView;
        textView.setOnClickListener(this);
        this.f340001n0.setText(R.string.cancel);
        this.f340000m0.resetBkColor(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(String str, Bitmap bitmap) {
        OpenCardContainer openCardContainer = this.f339998k0;
        if (openCardContainer != null) {
            openCardContainer.u(str, bitmap);
        }
    }

    @Override // com.tencent.open.agent.quickauth.i
    public void F0(String str) {
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->showLoginActivity--uin = *" + com.tencent.open.agent.util.g.C(str));
        Intent intent = new Intent();
        if (str != null) {
            intent.putExtra("param_uin", str);
        }
        com.tencent.open.agent.quickauth.j jVar = this.f340007t0;
        if (jVar != null) {
            jVar.m(intent);
        }
        intent.putExtra("is_open_sdk_add_account", true);
        intent.putExtra("loginFragmentType", 5);
        intent.putExtra("key_login_page_entrance", 4);
        intent.putExtra("key_login_page_title", BaseApplication.getContext().getString(R.string.f9p));
        RouteUtils.startActivityForResult(this, intent, RouterConstants.UI_ROUTER_LOGIN, 1);
    }

    protected void G2(String str) {
        String string;
        ArrayList arrayList = new ArrayList();
        String[] strArr = null;
        if (this.f339995h0.getString("accList", null) != null && (string = this.f339995h0.getString("accList", null)) != null) {
            strArr = string.split(",");
        }
        if (strArr != null) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (!arrayList.contains(str)) {
            arrayList.add(str);
        } else {
            arrayList.remove(str);
            arrayList.add(str);
        }
        Iterator it = arrayList.iterator();
        String str3 = "";
        while (it.hasNext()) {
            str3 = str3 + "," + ((String) it.next());
        }
        SharedPreferences.Editor edit = this.f339995h0.edit();
        edit.putString("last_account", str);
        edit.putString("accList", str3);
        edit.commit();
    }

    public void H2(String str, boolean z16) {
        com.tencent.open.agent.util.g.g(str, new d(z16, str));
    }

    protected boolean I2() {
        if (super.getIntent() == null) {
            QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, " checkIntentValidity() [[[return false]]] intent = null activity=" + this);
            return false;
        }
        Bundle bundleExtra = super.getIntent().getBundleExtra("key_params");
        this.f339993f0 = bundleExtra;
        if (bundleExtra == null) {
            QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, " checkIntentValidity() [[[return false]]] mParams = null, activity=" + this);
            return false;
        }
        com.tencent.open.agent.quickauth.j a16 = ac.a(super.getIntent().getStringExtra("key_action"), this.f339993f0, this, this);
        this.f340007t0 = a16;
        if (a16 == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.open.agent.quickauth.i
    public void L() {
        QQProgressDialog qQProgressDialog;
        if (!super.isFinishing() && (qQProgressDialog = this.f339994g0) != null && qQProgressDialog.isShowing()) {
            try {
                this.f339994g0.dismiss();
            } catch (Exception e16) {
                QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "dismissDialogProgress exception", e16);
            }
        }
    }

    protected void L2(String str) {
        boolean z16;
        up3.b.b(str);
        String a16 = com.tencent.mobileqq.login.account.b.a(str);
        this.f339988a0 = a16;
        com.tencent.open.agent.quickauth.j jVar = this.f340007t0;
        if (jVar != null) {
            jVar.n(a16);
        }
        if (this.f339996i0.contains(a16)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
            }
            z16 = true;
        } else {
            z16 = false;
        }
        this.f339998k0.w(this.f339988a0);
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + z16);
            }
            G2(this.f339988a0);
        }
    }

    protected void M2(String str) {
        boolean z16;
        up3.b.b(str);
        String a16 = com.tencent.mobileqq.login.account.b.a(str);
        this.f339988a0 = a16;
        com.tencent.open.agent.quickauth.j jVar = this.f340007t0;
        if (jVar != null) {
            jVar.n(a16);
        }
        if (this.f339996i0.contains(a16)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
            }
            z16 = true;
        } else {
            z16 = false;
        }
        this.f339998k0.w(this.f339988a0);
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + z16);
            }
            G2(this.f339988a0);
        }
    }

    protected void N2() {
        this.f339995h0 = super.getSharedPreferences("accountList", 4);
        login();
    }

    protected void P2(String str) {
        QuickAuthApp quickAuthApp;
        QuickAuthAppInfo quickAuthAppInfo;
        if (!TextUtils.isEmpty(str) && !str.equals("0")) {
            this.f339998k0.w(str);
            com.tencent.open.agent.quickauth.j jVar = this.f340007t0;
            if (jVar != null) {
                quickAuthApp = jVar.e();
            } else {
                quickAuthApp = null;
            }
            QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "quickAuthApp: " + quickAuthApp);
            if (quickAuthApp == null) {
                return;
            }
            p0(quickAuthApp.getAppName(), null);
            try {
                quickAuthAppInfo = ad.c(quickAuthApp.getPackageName());
            } catch (NumberFormatException e16) {
                QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "Long.parseLong(uin) has NumberFormatException:", e16);
                quickAuthAppInfo = null;
            }
            if (quickAuthAppInfo == null) {
                QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "showLocalInfo() return for loginInfo == null");
                return;
            }
            QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "showLocalInfo() loginInfo.iconUrl=", quickAuthAppInfo.getIconUrl() + ", adUrl=", quickAuthAppInfo.getAdUrl());
            if (!TextUtils.isEmpty(quickAuthAppInfo.getIconUrl())) {
                this.f340005r0 = true;
                Message obtain = Message.obtain();
                obtain.what = 1001;
                obtain.obj = quickAuthAppInfo.getIconUrl();
                this.f340008u0.sendMessage(obtain);
            }
            String adUrl = quickAuthAppInfo.getAdUrl();
            if (!TextUtils.isEmpty(adUrl)) {
                this.f339998k0.j(null, adUrl.replaceFirst("http[s]?", ProtocolDownloaderConstants.PROTOCOL_GAMEAD));
                return;
            }
            return;
        }
        QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "showLocalInfo() return for uin invalid");
    }

    public void Q2() {
        ColorStateList colorStateList = getResources().getColorStateList(R.color.f157443pk);
        TextView textView = this.f340001n0;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
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
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onActivityResult: resultcode:");
            sb5.append(i16);
            sb5.append("requestCode:");
            sb5.append(i3);
            sb5.append("data null?");
            if (intent == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, sb5.toString());
        }
        if (i3 == 100) {
            if (i16 == -1) {
                if (intent != null) {
                    this.f339997j0 = intent.getStringExtra("uin");
                }
                N2();
                return;
            }
            n1(null);
            return;
        }
        L();
        if (i16 == 0) {
            if (this.f339988a0 == null) {
                n1(intent);
                return;
            }
            if (this.f339989b0 != null) {
                QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onActivityResult cancel , current account is : " + this.f339988a0 + ", preAccount is : " + this.f339989b0);
                String str = this.f339989b0;
                this.f339988a0 = str;
                P2(str);
                this.f339989b0 = null;
                return;
            }
            return;
        }
        if (-1 == i16 && intent != null) {
            String stringExtra = intent.getStringExtra("last_account");
            this.f339988a0 = stringExtra;
            com.tencent.open.agent.quickauth.j jVar = this.f340007t0;
            if (jVar != null && stringExtra != null) {
                jVar.n(stringExtra);
            }
            boolean booleanExtra = intent.getBooleanExtra(QAdLoginDefine$LoginStatus.IS_LOGIN, false);
            this.f339998k0.w(this.f339988a0);
            if (booleanExtra) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "isLogin:" + booleanExtra);
                }
                G2(this.f339988a0);
            }
            q0();
            Message obtain = Message.obtain();
            obtain.what = 1005;
            this.f340008u0.sendMessage(obtain);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onBackPressed");
        n1(null);
        com.tencent.open.agent.quickauth.j jVar = this.f340007t0;
        if (jVar != null) {
            jVar.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        this.mNeedStatusTrans = false;
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->doOnCreate--");
        return super.doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        StringBuilder sb5 = new StringBuilder();
        String str = Build.MANUFACTURER;
        sb5.append(str);
        sb5.append(DeviceInfoMonitor.getModel());
        String sb6 = sb5.toString();
        if (QLog.isColorLevel()) {
            QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 2, "MANUFACTURER = " + str + ", MODEL = " + DeviceInfoMonitor.getModel());
        }
        if (sb6 != null && (sb6.equals("MeizuPRO 7-S") || sb6.equalsIgnoreCase("MeizuM711C"))) {
            ImmersiveUtils.clearCoverForStatus(getWindow(), true);
        } else {
            ImmersiveUtils.trySetImmersiveStatusBar(getActivity().getWindow());
        }
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }

    protected void login() {
        if (getAppRuntime() == null) {
            u0();
            return;
        }
        if (!TextUtils.isEmpty(this.f339997j0)) {
            this.f339988a0 = this.f339997j0;
            if (QLog.isColorLevel()) {
                QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "login mAccountString :" + this.f339997j0);
            }
            com.tencent.open.agent.quickauth.j jVar = this.f340007t0;
            if (jVar != null) {
                jVar.n(this.f339988a0);
            }
        }
        P2(this.f339988a0);
        if (!TextUtils.isEmpty(this.f339988a0)) {
            com.tencent.open.agent.quickauth.j jVar2 = this.f340007t0;
            if (jVar2 != null) {
                jVar2.b();
                return;
            }
            return;
        }
        u0();
    }

    @Override // com.tencent.open.agent.quickauth.i
    public void n1(Intent intent) {
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setResultCancel data=" + intent);
        if (intent == null) {
            super.setResult(0);
        } else {
            super.setResult(0, intent);
        }
        super.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (((WtloginManager) getAppRuntime().getManager(1)) != null) {
            if (view == this.f340001n0) {
                n1(null);
                com.tencent.open.agent.quickauth.j jVar = this.f340007t0;
                if (jVar != null) {
                    jVar.l();
                }
            } else if (view == this.f339992e0) {
                String str3 = "1";
                if (this.f340006s0) {
                    str = "1";
                } else {
                    str = "2";
                }
                if (this.f340005r0) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                if (TextUtils.isEmpty(getAppRuntime().getAccount()) || this.f339988a0.equals(getAppRuntime().getAccount())) {
                    str3 = "2";
                }
                ReportController.o(null, "dc00898", "", "", "0X800A7BE", "0X800A7BE", this.f340004q0, 0, str3, str, str2, "");
                QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 1, "report-dc00898-0X800A7BE-fromType=", Integer.valueOf(this.f340004q0), ",changeaccount=", str3, ", hasGetName=", str, ", hasGetIcon=", str2);
                if (!NetworkUtil.isNetworkAvailable(this)) {
                    L();
                    AuthUIUtil.h(this, getResources().getString(R.string.f171155cp4));
                } else {
                    com.tencent.open.agent.quickauth.j jVar2 = this.f340007t0;
                    if (jVar2 != null) {
                        jVar2.a();
                    }
                    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onClick login have");
                    com.tencent.open.agent.util.g.O("0X800BA84");
                }
            } else if (view.getId() == R.id.a0v) {
                F0(this.f339988a0);
                OpenCardContainer openCardContainer = this.f339998k0;
                if (openCardContainer != null) {
                    openCardContainer.p();
                }
            } else if (view == this.f340002o0) {
                QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onClick showAccountSheet");
                this.f339998k0.H.o();
                com.tencent.open.agent.util.g.O("0X800BA78");
                com.tencent.open.agent.util.g.O("0X800BA7B");
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
        Activity activity;
        List<String> list;
        super.onCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        if (bundle != null) {
            QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onCreate return for savedInstanceState is not null");
            n1(null);
            return;
        }
        if (!I2()) {
            QQToast.makeText(MobileQQ.sMobileQQ, HardCodeUtil.qqStr(R.string.f172505rf3), 0).show();
            n1(null);
            return;
        }
        this.f339999l0 = com.tencent.open.agent.util.c.m(getIntent());
        String string = this.f339993f0.getString("schemacallback");
        String string2 = this.f339993f0.getString("packagename");
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "onCreate()=> mFromSdkLoginAuthority=" + this.f339999l0 + "\n schemacallback=" + string + "\n packageName=" + string2 + "\n action=" + super.getIntent().getStringExtra("key_action") + "\n urlPraram=" + this.f339993f0.getString("p"));
        super.setContentView(R.layout.f168459wq);
        this.f339998k0 = (OpenCardContainer) super.findViewById(R.id.arb);
        super.findViewById(R.id.f114836ue).setVisibility(8);
        J2();
        this.f339990c0 = findViewById(R.id.root);
        this.f339991d0 = findViewById(R.id.agk);
        TextView textView = (TextView) this.f339990c0.findViewById(R.id.asz);
        this.f340002o0 = textView;
        textView.setOnClickListener(this);
        Button button = (Button) super.findViewById(R.id.fds);
        this.f339992e0 = button;
        button.setOnClickListener(this);
        if (this.f339999l0) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, 0, R.layout.b18, 17);
            this.f339994g0 = qQProgressDialog;
            qQProgressDialog.setHeightParams(-1);
        } else {
            if (isChild()) {
                activity = getParent();
            } else {
                activity = this;
            }
            this.f339994g0 = new QQProgressDialog(activity, super.getTitleBarHeight());
        }
        this.f340004q0 = 1;
        if (!TextUtils.isEmpty(string2)) {
            this.f340004q0 = 3;
        } else if (!TextUtils.isEmpty(string) && string.contains("weixin://")) {
            this.f340004q0 = 2;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A7BC", "0X800A7BC", this.f340004q0, 0, "", "", "", "");
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "report-dc00898-0X800A7BC-fromType=" + this.f340004q0);
        this.f339998k0.setAccountEventListener(new a());
        this.f339994g0.setCanceledOnTouchOutside(false);
        this.f339996i0 = up3.b.j();
        if (getAppRuntime().isLogin()) {
            this.f339988a0 = getAppRuntime().getAccount();
        }
        if (this.f339988a0 == null && (list = this.f339996i0) != null) {
            this.f339988a0 = list.get(0);
        }
        String stringExtra = getIntent().getStringExtra("login_success_uin");
        this.f340003p0 = stringExtra;
        if (!TextUtils.isEmpty(stringExtra) && !this.f340003p0.equals(this.f339988a0)) {
            this.f339988a0 = this.f340003p0;
        }
        com.tencent.open.agent.quickauth.j jVar = this.f340007t0;
        if (jVar != null) {
            jVar.n(this.f339988a0);
        }
        com.tencent.open.agent.util.g.O("0X800BA83");
        if (com.tencent.open.agent.util.p.l(this)) {
            QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onCreate--has gesture password, will start unlock activity");
            this.f339997j0 = super.getAppRuntime().getAccount();
            com.tencent.open.agent.util.g.I(this);
            return;
        }
        N2();
        com.tencent.open.agent.quickauth.j jVar2 = this.f340007t0;
        if (jVar2 != null) {
            if (jVar2.k()) {
                this.f340002o0.setVisibility(0);
            } else {
                this.f340002o0.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, "ondestroy");
        L();
    }

    @Override // com.tencent.open.agent.quickauth.i
    public void p0(final String str, final Bitmap bitmap) {
        QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 4, "showAppInfo appName: " + str);
        runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.l
            @Override // java.lang.Runnable
            public final void run() {
                QuickLoginAuthorityActivity.this.K2(str, bitmap);
            }
        });
    }

    @Override // com.tencent.open.agent.quickauth.i
    public void q0() {
        long j3;
        if (TextUtils.isEmpty(this.f339988a0)) {
            QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "updateViews() return for empry account");
            return;
        }
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "updateViews()");
        com.tencent.open.agent.quickauth.j jVar = this.f340007t0;
        if (jVar != null) {
            j3 = jVar.getMThirdAppId();
        } else {
            j3 = 0;
        }
        AvatarUpdateService.a().c(this, this.f339988a0, String.valueOf(j3), this);
    }

    @Override // com.tencent.open.agent.quickauth.i
    public void r0(int i3, byte[] bArr, String str, String str2) {
        String str3;
        String str4;
        Intent intent = new Intent();
        intent.putExtra("quicklogin_errmsg", str2);
        intent.putExtra("quicklogin_uin", str);
        intent.putExtra("quicklogin_ret", i3);
        intent.putExtra("quicklogin_buff", bArr);
        super.setResult(-1, intent);
        L();
        super.finish();
        QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult:error:" + str2);
        if (this.f339999l0) {
            try {
                ReportCenter f16 = ReportCenter.f();
                String str5 = this.f339988a0;
                if (i3 == 0) {
                    str3 = "0";
                } else {
                    str3 = "1";
                }
                f16.q(str5, "", "", "1", "9", str3, true, true);
            } catch (Exception e16) {
                QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult report exception1:", e16);
            }
        }
        try {
            if (!TextUtils.isEmpty(getAppRuntime().getAccount()) && !this.f339988a0.equals(getAppRuntime().getAccount())) {
                ReportCenter f17 = ReportCenter.f();
                String str6 = this.f339988a0;
                if (i3 == 0) {
                    str4 = "0";
                } else {
                    str4 = "1";
                }
                f17.q(str6, "", "", "1", "10", str4, true, true);
            }
        } catch (Exception e17) {
            QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "setSdkResult report exception2:", e17);
        }
    }

    @Override // com.tencent.open.base.http.d.a
    public void r1(String str, Bitmap bitmap) {
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("-->onTaskCompleted--identifier = ");
            sb5.append(str);
            sb5.append("bitmap = null ? ");
            if (bitmap == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("Q.quicklogin.QuickLoginAuthorityActivity", 2, sb5.toString());
        }
        if (str.equals(this.f339988a0)) {
            runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.QuickLoginAuthorityActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    QuickLoginAuthorityActivity quickLoginAuthorityActivity = QuickLoginAuthorityActivity.this;
                    quickLoginAuthorityActivity.f339998k0.w(quickLoginAuthorityActivity.f339988a0);
                }
            });
        }
    }

    @Override // com.tencent.open.agent.quickauth.i
    public void s0(String str) {
        Message obtain = Message.obtain();
        obtain.what = 1001;
        obtain.obj = str;
        this.f340008u0.sendMessage(obtain);
    }

    @Override // com.tencent.open.agent.quickauth.i
    public void showProgress(String str) {
        if (str != null) {
            this.f339994g0.setMessage(str);
        }
        this.f339994g0.show();
    }

    @Override // com.tencent.open.agent.quickauth.i
    public void u0() {
        int i3;
        int i16;
        List<String> list = this.f339996i0;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (i3 > 1) {
            Intent intent = new Intent();
            String str = this.f339988a0;
            if (str != null) {
                intent.putExtra("param_uin", str);
            }
            if (this.f340007t0 instanceof WebQuickAuthHandler) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            intent.putExtra("key_req_src", i16);
            RouteUtils.startActivityForResult(this, intent, RouterConstants.UI_ROUTER_SWITCH_ACCOUNT, 1);
            return;
        }
        F0(this.f339988a0);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements OpenCardContainer.c {
        a() {
        }

        @Override // com.tencent.open.agent.OpenCardContainer.c
        public void b() {
            QuickLoginAuthorityActivity quickLoginAuthorityActivity = QuickLoginAuthorityActivity.this;
            quickLoginAuthorityActivity.F0(quickLoginAuthorityActivity.f339988a0);
            OpenCardContainer openCardContainer = QuickLoginAuthorityActivity.this.f339998k0;
            if (openCardContainer != null) {
                openCardContainer.p();
            }
        }

        @Override // com.tencent.open.agent.OpenCardContainer.c
        public String getCurrentAccount() {
            return null;
        }

        @Override // com.tencent.open.agent.OpenCardContainer.c
        public void a() {
        }

        @Override // com.tencent.open.agent.OpenCardContainer.c
        public void c(String str, boolean z16) {
        }
    }
}
