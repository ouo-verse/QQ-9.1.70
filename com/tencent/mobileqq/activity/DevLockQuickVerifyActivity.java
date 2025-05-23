package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DevLockQuickVerifyActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.api.qrlogin.IQrLoginApi;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.ScanQrRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.ScanScene;
import com.tencent.qqnt.kernel.nativeinterface.SwitchOperation;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DevLockQuickVerifyActivity extends QBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private String f175497a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f175498b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f175499c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f175500d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f175501e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f175502f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f175503g0;

    /* renamed from: h0, reason: collision with root package name */
    private byte[] f175504h0;

    /* renamed from: i0, reason: collision with root package name */
    private Dialog f175505i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f175506j0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f175507k0;

    /* renamed from: l0, reason: collision with root package name */
    private ImageView f175508l0;

    /* renamed from: m0, reason: collision with root package name */
    private TextView f175509m0;

    /* renamed from: n0, reason: collision with root package name */
    private LinearLayout f175510n0;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f175511o0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f175512p0;

    /* renamed from: q0, reason: collision with root package name */
    private QUIButton f175513q0;

    /* renamed from: r0, reason: collision with root package name */
    private QUIButton f175514r0;

    /* renamed from: s0, reason: collision with root package name */
    private QUICheckBox f175515s0;

    /* renamed from: t0, reason: collision with root package name */
    private AppRuntime f175516t0;

    /* renamed from: u0, reason: collision with root package name */
    private com.tencent.mobileqq.loginregister.servlet.a f175517u0;

    /* renamed from: v0, reason: collision with root package name */
    private final CompoundButton.OnCheckedChangeListener f175518v0;

    /* renamed from: w0, reason: collision with root package name */
    private final f72.a f175519w0;

    /* renamed from: x0, reason: collision with root package name */
    private final com.tencent.mobileqq.loginregister.servlet.h f175520x0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.DevLockQuickVerifyActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class DialogInterfaceOnClickListenerC7097a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnClickListenerC7097a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    ReportController.y(DevLockQuickVerifyActivity.this.f175516t0, "0X800C35E");
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    DevLockQuickVerifyActivity.this.f175515s0.setChecked(false);
                    ReportController.y(DevLockQuickVerifyActivity.this.f175516t0, "0X800C35F");
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DevLockQuickVerifyActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            String string;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else {
                ReportController.y(DevLockQuickVerifyActivity.this.f175516t0, "0X800C35C");
                if (z16 && !DevLockQuickVerifyActivity.this.isFinishing()) {
                    String string2 = DevLockQuickVerifyActivity.this.getResources().getString(R.string.f211185k5);
                    if (!TextUtils.isEmpty(DevLockQuickVerifyActivity.this.f175500d0)) {
                        string = DevLockQuickVerifyActivity.this.f175500d0;
                    } else {
                        string = DevLockQuickVerifyActivity.this.getResources().getString(R.string.f211175k4);
                    }
                    DialogUtil.createCustomDialog(DevLockQuickVerifyActivity.this, 230, string2, string, R.string.cancel, R.string.f211165k3, new DialogInterfaceOnClickListenerC7097a(), new b()).show();
                    ReportController.y(DevLockQuickVerifyActivity.this.f175516t0, "0X800C35D");
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements f72.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DevLockQuickVerifyActivity.this);
            }
        }

        private void e() {
            SwitchOperation switchOperation;
            if (DevLockQuickVerifyActivity.this.f175515s0.isChecked()) {
                switchOperation = SwitchOperation.KOPDEFAULTOPEN;
            } else {
                switchOperation = SwitchOperation.KOPDEFAULTCLOSE;
            }
            DevLockQuickVerifyActivity.this.f175517u0.f(switchOperation, this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(int i3) {
            DevLockQuickVerifyActivity.this.hideLoading();
            if (DevLockQuickVerifyActivity.this.isFinishing()) {
                return;
            }
            if (i3 != 0) {
                DevLockQuickVerifyActivity.this.W2();
                return;
            }
            QQToast.makeText(DevLockQuickVerifyActivity.this.getApplicationContext(), 2, R.string.f170898b03, 0).show();
            DevLockQuickVerifyActivity.this.finish();
            DevLockQuickVerifyActivity.this.overridePendingTransition(0, R.anim.f154458a7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(int i3) {
            if (DevLockQuickVerifyActivity.this.isFinishing()) {
                DevLockQuickVerifyActivity.this.hideLoading();
            } else if (i3 != 0) {
                DevLockQuickVerifyActivity.this.hideLoading();
                DevLockQuickVerifyActivity.this.W2();
            } else {
                e();
            }
        }

        @Override // f72.a
        public void a(final int i3, @Nullable String str, @Nullable ScanQrRspInfo scanQrRspInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, scanQrRspInfo);
                return;
            }
            QLog.i("DevLockQuickVerifyActivity", 1, "mQrLoginCallback onVerifyCode result=" + i3 + "errorMsg=" + str + "handleScanQrRspInfo: info = " + scanQrRspInfo);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.bp
                @Override // java.lang.Runnable
                public final void run() {
                    DevLockQuickVerifyActivity.b.this.g(i3);
                }
            });
        }

        @Override // f72.a
        public void b(final int i3, @Nullable String str, @Nullable String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                return;
            }
            QLog.d("DevLockQuickVerifyActivity", 1, "mQrLoginCallback onCloseCode result=" + i3 + " errMsg=" + str);
            DevLockQuickVerifyActivity.this.f175517u0 = null;
            DevLockQuickVerifyActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.bo
                @Override // java.lang.Runnable
                public final void run() {
                    DevLockQuickVerifyActivity.b.this.f(i3);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DevLockQuickVerifyActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void E(String str, byte[] bArr, long j3, ArrayList<String> arrayList, byte[] bArr2, int i3, ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, bArr, Long.valueOf(j3), arrayList, bArr2, Integer.valueOf(i3), errMsg);
                return;
            }
            QLog.d("DevLockQuickVerifyActivity", 1, "OnVerifyCode userAccount=" + str + " ret=" + i3);
            if (DevLockQuickVerifyActivity.this.isFinishing()) {
                DevLockQuickVerifyActivity.this.hideLoading();
                return;
            }
            if (i3 != 0) {
                DevLockQuickVerifyActivity.this.hideLoading();
                DevLockQuickVerifyActivity.this.W2();
                QLog.d("DevLockQuickVerifyActivity", 1, "onCloseCode, error = " + new String(bArr2, StandardCharsets.UTF_8));
                return;
            }
            DevLockQuickVerifyActivity.this.M2();
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void h(String str, byte[] bArr, long j3, WUserSigInfo wUserSigInfo, byte[] bArr2, int i3, ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, bArr, Long.valueOf(j3), wUserSigInfo, bArr2, Integer.valueOf(i3), errMsg);
                return;
            }
            QLog.d("DevLockQuickVerifyActivity", 1, "OnCloseCode userAccount=" + str + " ret=" + i3 + " time=" + j3);
            DevLockQuickVerifyActivity.this.hideLoading();
            if (DevLockQuickVerifyActivity.this.isFinishing()) {
                return;
            }
            if (i3 != 0) {
                DevLockQuickVerifyActivity.this.W2();
                QLog.d("DevLockQuickVerifyActivity", 1, "onCloseCode, error = " + new String(bArr2, StandardCharsets.UTF_8));
                return;
            }
            QQToast.makeText(DevLockQuickVerifyActivity.this.getApplicationContext(), 2, R.string.f170898b03, 0).show();
            DevLockQuickVerifyActivity.this.finish();
            DevLockQuickVerifyActivity.this.overridePendingTransition(0, R.anim.f154458a7);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void j(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
                return;
            }
            QLog.d("DevLockQuickVerifyActivity", 1, "onException, e = " + str);
            DevLockQuickVerifyActivity.this.hideLoading();
            DevLockQuickVerifyActivity.this.W2();
        }
    }

    public DevLockQuickVerifyActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175506j0 = false;
        this.f175517u0 = null;
        this.f175518v0 = new a();
        this.f175519w0 = new b();
        this.f175520x0 = new c();
    }

    private long N2() {
        int value;
        if (T2()) {
            value = ((IOnlineStatusService) this.f175516t0.getRuntimeService(IOnlineStatusService.class, "all")).getOnlineStatus().getValue();
        } else {
            value = AppRuntime.Status.offline.getValue();
        }
        return value;
    }

    private String P2(String str) {
        String property = MobileQQ.sMobileQQ.getProperty(Constants.PropertiesKey.uinDisplayName.toString() + str);
        if (property != null && property.length() != 0) {
            return property;
        }
        return str;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void Q2() {
        if (this.f175502f0 == 1600001602) {
            this.f175508l0.setImageDrawable(getResources().getDrawable(R.drawable.qui_equipment_mac));
        } else {
            this.f175508l0.setImageDrawable(getResources().getDrawable(R.drawable.qui_equipment_windows));
        }
    }

    private void R2() {
        if (TextUtils.isEmpty(this.f175498b0)) {
            this.f175510n0.setVisibility(8);
            QLog.d("DevLockQuickVerifyActivity", 1, "initDeviceName, deviceName is empty.");
        } else {
            this.f175509m0.setText(this.f175498b0);
        }
    }

    private void S2() {
        if (TextUtils.isEmpty(this.f175501e0)) {
            this.f175501e0 = "App";
        }
        this.f175511o0.setText(getResources().getString(R.string.f211195k6, this.f175501e0));
    }

    private boolean T2() {
        if (this.f175516t0.getAccount() != null && this.f175516t0.isLogin()) {
            return true;
        }
        return false;
    }

    private void U2() {
        QLog.d("DevLockQuickVerifyActivity", 1, "onClickConfirmLogin, isBadQr = " + this.f175506j0);
        if (this.f175506j0) {
            finish();
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, getString(R.string.b3j), 0).show();
            return;
        }
        if (this.f175516t0 != null && !TextUtils.isEmpty(this.f175497a0)) {
            showLoading();
            Z2();
            ReportController.y(this.f175516t0, "0X800C361");
        } else {
            QLog.d("DevLockQuickVerifyActivity", 1, "requestQRLogin qrCodeString is empty");
            QQToast.makeText(this, 1, getResources().getString(R.string.f170897b02), 0).show();
            finish();
        }
    }

    private void V2() {
        QLog.d("DevLockQuickVerifyActivity", 1, "onClickRejectLogin, isBadQr = " + this.f175506j0);
        if (this.f175506j0) {
            finish();
            return;
        }
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, getString(R.string.b3j), 0).show();
            return;
        }
        if (this.f175516t0 != null && !TextUtils.isEmpty(this.f175497a0)) {
            com.tencent.mobileqq.loginregister.servlet.a aVar = this.f175517u0;
            if (aVar != null) {
                aVar.h();
                finish();
                return;
            } else {
                ((ILoginServletService) this.f175516t0.getRuntimeService(ILoginServletService.class, "all")).cancelCode(getCurrentAccountUin(), 16L, this.f175504h0, com.tencent.open.agent.util.q.c(this.f175516t0, 3, true).toByteArray());
                QLog.d("DevLockQuickVerifyActivity", 1, "onClickRejectLogin, cancelCode success.");
                finish();
                return;
            }
        }
        QLog.d("DevLockQuickVerifyActivity", 1, "requestRejectLogin qrCodeString is empty");
        QQToast.makeText(this, 1, getResources().getString(R.string.f170897b02), 0).show();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2() {
        if (isFinishing()) {
            return;
        }
        String string = getResources().getString(R.string.f211375kn);
        this.f175512p0.setVisibility(0);
        this.f175515s0.setEnabled(false);
        this.f175512p0.setText(string);
        this.f175506j0 = true;
        this.f175513q0.setText(getResources().getString(R.string.f171151ok));
        this.f175514r0.setVisibility(8);
    }

    private void Y2() {
        try {
            int indexOf = this.f175497a0.indexOf("?k=") + 3;
            String substring = this.f175497a0.substring(indexOf, indexOf + 32);
            this.f175504h0 = com.tencent.open.agent.util.q.a(substring.getBytes(), substring.length());
        } catch (Exception e16) {
            QLog.e("DevLockQuickVerifyActivity", 1, "qrCodeString illegal, qrCode: ", this.f175497a0, " exception: ", e16.getMessage());
            W2();
        }
    }

    private void Z2() {
        QLog.d("DevLockQuickVerifyActivity", 1, "confirmLogin start verifyCode..");
        if (!this.f175497a0.contains("&n=1") && !MobileQQ.sMobileQQ.isLoginByNT()) {
            this.f175517u0 = null;
            Bundle bundle = new Bundle();
            bundle.putByteArray(BaseConstants.ATTRIBUTE_KEY_EXTRA_DEVICE_INFO, com.tencent.open.agent.util.q.b(this.f175516t0, 3, this.f175515s0.isChecked()).toByteArray());
            ((ILoginServletService) this.f175516t0.getRuntimeService(ILoginServletService.class, "all")).verifyCode(getCurrentAccountUin(), 16L, true, this.f175504h0, new int[]{3, 5}, 1, this.f175520x0, bundle);
            return;
        }
        this.f175517u0 = ((IQrLoginApi) QRoute.api(IQrLoginApi.class)).getQrLoginManager();
        int indexOf = this.f175497a0.indexOf("?k=") + 3;
        this.f175517u0.i(ScanScene.KNEWDEVAUTH, this.f175497a0.substring(indexOf, indexOf + 32).getBytes(), this.f175519w0);
    }

    private String getCurrentAccountUin() {
        AppRuntime appRuntime = this.f175516t0;
        if (appRuntime == null) {
            return "";
        }
        if (appRuntime instanceof AppInterface) {
            return ((AppInterface) appRuntime).getCurrentAccountUin();
        }
        return appRuntime.getAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        Dialog dialog = this.f175505i0;
        if (dialog != null && dialog.isShowing()) {
            try {
                this.f175505i0.dismiss();
            } catch (Exception e16) {
                QLog.w("DevLockQuickVerifyActivity", 1, "dismiss dialog exception", e16);
            }
        }
    }

    private void initData(Intent intent) {
        if (intent == null) {
            QLog.d("DevLockQuickVerifyActivity", 1, "initData, intent is null.");
            return;
        }
        this.f175506j0 = false;
        this.f175497a0 = intent.getStringExtra("qrcode");
        this.f175502f0 = intent.getIntExtra("appid", 0);
        this.f175498b0 = intent.getStringExtra("deviceName");
        this.f175499c0 = intent.getStringExtra("deviceType");
        this.f175500d0 = intent.getStringExtra("autoRenewTips");
        this.f175501e0 = intent.getStringExtra("appName");
        this.f175503g0 = intent.getBooleanExtra("supportAutoLogin", false);
        QLog.d("DevLockQuickVerifyActivity", 1, "initData, appid = " + this.f175502f0 + ", deviceType = " + this.f175499c0 + ", deviceName = " + this.f175498b0 + ", appName = " + this.f175501e0 + ", supportAutoLogin = " + this.f175503g0);
    }

    private void initUI() {
        super.setContentView(R.layout.hbx);
        try {
            this.f175507k0 = (TextView) findViewById(R.id.f74523wh);
            this.f175510n0 = (LinearLayout) findViewById(R.id.yu6);
            this.f175508l0 = (ImageView) findViewById(R.id.uh5);
            this.f175509m0 = (TextView) findViewById(R.id.yu5);
            this.f175511o0 = (TextView) findViewById(R.id.yuc);
            this.f175513q0 = (QUIButton) findViewById(R.id.u4f);
            this.f175514r0 = (QUIButton) findViewById(R.id.f72573r8);
            View findViewById = findViewById(R.id.f164297sm2);
            this.f175515s0 = (QUICheckBox) findViewById(R.id.f164533t05);
            if (this.f175503g0) {
                findViewById.setVisibility(0);
                this.f175515s0.setEnabled(true);
            } else {
                findViewById.setVisibility(4);
                this.f175515s0.setEnabled(false);
            }
            this.f175512p0 = (TextView) findViewById(R.id.uxr);
            this.f175513q0.setOnClickListener(this);
            this.f175514r0.setOnClickListener(this);
            this.f175507k0.setOnClickListener(this);
            this.f175515s0.setOnCheckedChangeListener(this.f175518v0);
            if (!TextUtils.isEmpty(this.f175498b0)) {
                this.f175510n0.setVisibility(0);
                this.f175509m0.setText(this.f175498b0);
            }
            ReportController.y(this.f175516t0, "0X800C360");
            ReportController.y(this.f175516t0, "0X800C35B");
            Q2();
            S2();
            R2();
        } catch (NullPointerException e16) {
            QLog.e("DevLockQuickVerifyActivity", 1, "initUI error: ", e16);
            finish();
        }
    }

    private void showLoading() {
        if (!isFinishing()) {
            Dialog dialog = this.f175505i0;
            if (dialog == null || !dialog.isShowing()) {
                Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(this, getString(R.string.f211365km), false);
                this.f175505i0 = showLoadingDialog;
                try {
                    showLoadingDialog.show();
                } catch (Exception e16) {
                    QLog.w("DevLockQuickVerifyActivity", 1, "show dialog exception", e16);
                }
            }
        }
    }

    void M2() {
        byte[] d16 = com.tencent.open.agent.util.q.d(N2());
        ByteBuffer allocate = ByteBuffer.allocate(d16.length + 4);
        allocate.putShort((short) 2);
        allocate.putShort((short) d16.length);
        allocate.put(d16);
        byte[] array = allocate.array();
        String currentAccountUin = this.f175516t0.getCurrentAccountUin();
        String P2 = P2(currentAccountUin);
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(P2) && !P2.equals(currentAccountUin)) {
            byte[] bytes = P2.getBytes();
            ByteBuffer allocate2 = ByteBuffer.allocate(bytes.length + 4);
            allocate2.putShort((short) 1);
            allocate2.putShort((short) bytes.length);
            allocate2.put(bytes);
            byte[] array2 = allocate2.array();
            ByteBuffer allocate3 = ByteBuffer.allocate(array2.length + 4);
            allocate3.putShort((short) 4);
            allocate3.putShort((short) array2.length);
            allocate3.put(array2);
            byte[] array3 = allocate3.array();
            arrayList.add(HexUtil.bytes2HexStr(array));
            arrayList.add(HexUtil.bytes2HexStr(array3));
        } else {
            arrayList.add(HexUtil.bytes2HexStr(array));
        }
        ByteBuffer allocate4 = ByteBuffer.allocate(8);
        allocate4.putShort((short) 21);
        allocate4.putShort((short) 4);
        allocate4.putInt(0);
        arrayList.add(HexUtil.bytes2HexStr(allocate4.array()));
        QLog.d("DevLockQuickVerifyActivity", 1, "confirmLogin start CloseCode..");
        Bundle bundle = new Bundle();
        bundle.putByteArray(BaseConstants.ATTRIBUTE_KEY_EXTRA_DEVICE_INFO, com.tencent.open.agent.util.q.b(this.f175516t0, 3, this.f175515s0.isChecked()).toByteArray());
        ((ILoginServletService) this.f175516t0.getRuntimeService(ILoginServletService.class, "all")).closeCode(currentAccountUin, 16L, this.f175504h0, 1, arrayList, this.f175520x0, bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        super.setTheme(R.style.f173949nq);
        super.doOnCreate(bundle);
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), getWindow());
        this.f175516t0 = getAppRuntime();
        initData(getIntent());
        initUI();
        Y2();
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            this.f175517u0 = ((IQrLoginApi) QRoute.api(IQrLoginApi.class)).getQrLoginManager();
            int indexOf = this.f175497a0.indexOf("?k=") + 3;
            this.f175517u0.k(this.f175497a0.substring(indexOf, indexOf + 32).getBytes());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        QLog.i("DevLockQuickVerifyActivity", 1, "doOnNewIntent.");
        if (intent != null) {
            initData(intent);
            initUI();
            Y2();
            return;
        }
        QLog.i("DevLockQuickVerifyActivity", 1, "doOnNewIntent, intent is null.");
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(0, R.anim.f154458a7);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (!this.f175506j0) {
            com.tencent.mobileqq.loginregister.servlet.a aVar = this.f175517u0;
            if (aVar != null) {
                aVar.g();
            } else {
                ((ILoginServletService) this.f175516t0.getRuntimeService(ILoginServletService.class, "all")).cancelCode(getCurrentAccountUin(), 16L, this.f175504h0, com.tencent.open.agent.util.q.c(this.f175516t0, 3, false).toByteArray());
            }
        }
        finish();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.u4f) {
                U2();
            } else if (id5 == R.id.f74523wh) {
                onBackEvent();
            } else if (id5 == R.id.f72573r8) {
                V2();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).notifyDevLockVerifyOpen();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else {
            super.onNewIntent(intent);
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).notifyDevLockVerifyOpen();
        }
    }
}
