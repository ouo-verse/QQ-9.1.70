package com.tencent.mobileqq.upgrade.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.YybUpgradeDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ak;
import com.tencent.mobileqq.utils.dx;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UpgradeActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: o0, reason: collision with root package name */
    private static long f306225o0;

    /* renamed from: a0, reason: collision with root package name */
    private String f306226a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f306227b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f306228c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f306229d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f306230e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f306231f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f306232g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f306233h0;

    /* renamed from: i0, reason: collision with root package name */
    String f306234i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f306235j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f306236k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f306237l0;

    /* renamed from: m0, reason: collision with root package name */
    private UpgradeDetailWrapper f306238m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f306239n0;

    public UpgradeActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f306226a0 = null;
        this.f306227b0 = null;
        this.f306228c0 = null;
        this.f306229d0 = null;
        this.f306230e0 = null;
        this.f306231f0 = null;
        this.f306232g0 = null;
        this.f306233h0 = null;
        this.f306234i0 = null;
        this.f306235j0 = 0;
        this.f306236k0 = 0;
        this.f306239n0 = false;
    }

    private void U2() {
        Y2();
        s3();
        try {
            int i3 = this.f306236k0;
            if (i3 != 2 && i3 != 1 && i3 != 3) {
                QLog.w("UpgradeController_Activity", 1, "upgradeType param fail");
                finish();
            }
            showDialog(i3);
        } catch (Exception e16) {
            QLog.w("UpgradeController_Activity", 4, "doNotifyUpgrade error: ", e16);
            finish();
        }
    }

    private void V2() {
        if (com.tencent.mobileqq.upgrade.banner.b.j(true)) {
            com.tencent.mobileqq.upgrade.k.m().h();
        } else {
            UpgradeDetailActivity.Y2(this, com.tencent.mobileqq.upgrade.k.i().j(), false, true, true);
        }
    }

    private void W2() {
        finish();
        this.app.exit(false);
    }

    private void Y2() {
        boolean z16;
        this.f306226a0 = getIntent().getStringExtra("StrTitle");
        this.f306228c0 = getIntent().getStringExtra("StrNewTitle");
        this.f306229d0 = getIntent().getStringExtra("StrUpgradeDesc");
        this.f306227b0 = getIntent().getStringExtra("StrVersion");
        this.f306234i0 = getIntent().getStringExtra("StrUrl");
        this.f306232g0 = getIntent().getStringExtra("strDesc");
        this.f306233h0 = getIntent().getStringExtra("rBtnText");
        this.f306235j0 = getIntent().getIntExtra("iTipsType", 0);
        if (getIntent().hasExtra("strConfirmBtnText")) {
            this.f306230e0 = getIntent().getStringExtra("strConfirmBtnText");
        }
        if (getIntent().hasExtra("strCancelButtonDesc")) {
            this.f306231f0 = getIntent().getStringExtra("strCancelButtonDesc");
        }
        if (com.tencent.mobileqq.upgrade.k.i().k() == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f306237l0 = z16;
        this.f306236k0 = getIntent().getIntExtra("upgradeType", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z2(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b3(DialogInterface dialogInterface, int i3) {
        com.tencent.open.base.f.e("UpgradeController_Activity", np3.b.a(10010, 1, 2, 200));
        np3.a.g().j(17, np3.b.a(10010, 1, 2, 200));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c3(DialogInterface dialogInterface, int i3) {
        com.tencent.open.base.f.e("UpgradeController_Activity", np3.b.a(10010, 1, 3, 200));
        np3.a.g().j(17, np3.b.a(10010, 1, 3, 200));
        if (!MyAppApi.G()) {
            ToastUtil.a().e(HardCodeUtil.qqStr(R.string.uuh));
        } else {
            YybUpgradeDialog.j0(this);
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.upgrade.activity.f
            @Override // java.lang.Runnable
            public final void run() {
                UpgradeActivity.this.finish();
            }
        }, 16, null, false, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d3(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e3(YybUpgradeDialog yybUpgradeDialog, int i3, DialogInterface dialogInterface, int i16) {
        yybUpgradeDialog.n0();
        dx.g(true);
        dx.h(i3);
        UpgradeDetailActivity.Y2(this, com.tencent.mobileqq.upgrade.k.i().j(), false, true, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f3(DialogInterface dialogInterface, int i3) {
        V2();
        q.b("0X8004DA1", 0, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g3(DialogInterface dialogInterface, int i3) {
        q.b("0X8004DA2", 0, "0");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean h3(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            finish();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        q.a("0X800417F");
        if (this.f306237l0) {
            q.a("0X800714D");
        }
        q.b("0X8004DA2", 2, "0");
        com.tencent.mobileqq.upgrade.banner.b.j(false);
        finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        q.a("0X800417E");
        if (this.f306237l0) {
            q.a("0X800714C");
        }
        V2();
        q.b("0X8004DA1", 2, "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l3(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        q.e("0X800C668");
        com.tencent.mobileqq.upgrade.n.k(com.tencent.mobileqq.upgrade.k.i().j());
        finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n3(DialogInterface dialogInterface, int i3) {
        V2();
        q.b("0X8004DA1", 0, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p3(DialogInterface dialogInterface, int i3) {
        q.b("0X8004DA2", 0, "");
        W2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean r3(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            W2();
            return false;
        }
        return false;
    }

    private void s3() {
        UpgradeInfo upgradeInfo;
        UpgradeDetailWrapper upgradeDetailWrapper = this.f306238m0;
        if (upgradeDetailWrapper != null && (upgradeInfo = upgradeDetailWrapper.f306170d) != null) {
            if (this.f306226a0 == null) {
                this.f306226a0 = upgradeInfo.strTitle;
                QLog.d("UpgradeController_Activity", 4, "=wrapper\u624b\u52a8\u8d4b\u503c:strTitle: " + this.f306226a0);
            }
            if (this.f306228c0 == null) {
                this.f306228c0 = this.f306238m0.f306170d.strNewTitle;
                QLog.d("UpgradeController_Activity", 4, "wrapper\u624b\u52a8\u8d4b\u503c:strNewTitle: " + this.f306228c0);
            }
            if (this.f306229d0 == null) {
                this.f306229d0 = this.f306238m0.f306170d.strUpgradeDesc;
                QLog.d("UpgradeController_Activity", 4, "wrapper\u624b\u52a8\u8d4b\u503c:strUpgradeDesc: " + this.f306229d0);
            }
            if (this.f306227b0 == null) {
                this.f306227b0 = com.tencent.mobileqq.upgrade.m.P(this.f306238m0.f306170d.strProgressName);
            }
            UpgradeInfo upgradeInfo2 = this.f306238m0.f306170d;
            this.f306236k0 = upgradeInfo2.iUpgradeType;
            this.f306235j0 = upgradeInfo2.iTipsType;
        }
    }

    private Dialog t3(Dialog dialog) {
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.upgrade.activity.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UpgradeActivity.this.Z2(dialogInterface);
            }
        });
        return dialog;
    }

    private Dialog u3() {
        UpgradeInfo upgradeInfo;
        UpgradeDetailWrapper j3 = com.tencent.mobileqq.upgrade.k.i().j();
        if (j3 != null && j3.f306173h != null && (upgradeInfo = j3.f306170d) != null) {
            this.f306226a0 = upgradeInfo.strTitle;
            this.f306228c0 = upgradeInfo.strNewTitle;
            String str = upgradeInfo.strUpgradeDesc;
            this.f306229d0 = str;
            try {
                this.f306229d0 = String.format(str, new Object[0]);
            } catch (Exception e16) {
                QLog.d("UpgradeController_Activity", 2, "parse dialog wording error!", e16);
            }
            long j16 = j3.f306173h.f306177b;
            dx.j(true);
            final int i3 = j3.f306173h.f306179d;
            dx.f(i3);
            if (MyAppApi.G()) {
                QQCustomDialog c16 = ak.c(this, this.f306226a0, j16, this.f306229d0, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        UpgradeActivity.this.b3(dialogInterface, i16);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        UpgradeActivity.this.c3(dialogInterface, i16);
                    }
                });
                c16.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.upgrade.activity.h
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        UpgradeActivity.this.d3(dialogInterface);
                    }
                });
                com.tencent.open.base.f.e("UpgradeController_Activity", np3.b.a(10010, 1, 1, 100));
                com.tencent.open.base.f.e("UpgradeController_Activity", np3.b.a(10010, 1, 2, 100));
                com.tencent.open.base.f.e("UpgradeController_Activity", np3.b.a(10010, 1, 3, 100));
                np3.a.g().j(16, np3.b.a(10010, 1, 1, 100));
                np3.a.g().j(16, np3.b.a(10010, 1, 2, 100));
                np3.a.g().j(16, np3.b.a(10010, 1, 3, 100));
                return c16;
            }
            this.f306239n0 = true;
            MyAppApi.z().h0(false);
            final YybUpgradeDialog e17 = ak.e(this, this.f306226a0, j16, this.f306229d0, "");
            e17.s0(new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    UpgradeActivity.this.e3(e17, i3, dialogInterface, i16);
                }
            }, true);
            return e17;
        }
        ToastUtil.a().e(HardCodeUtil.qqStr(R.string.uuq));
        finish();
        return null;
    }

    private Dialog v3() {
        String qqStr;
        int i3;
        int i16 = this.f306235j0;
        if (i16 == 0) {
            q.b("0X8004DA0", 0, "");
            QQCustomDialog message = DialogUtil.createCustomDialog(this, 230).setTitle(this.f306226a0).setMessage(this.f306229d0);
            if (com.tencent.mobileqq.upgrade.k.i().k() == 4) {
                i3 = R.string.f171039by0;
            } else {
                i3 = R.string.iaw;
            }
            message.setPositiveButton(i3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i17) {
                    UpgradeActivity.this.f3(dialogInterface, i17);
                }
            }).setNegativeButton(R.string.iav, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i17) {
                    UpgradeActivity.this.g3(dialogInterface, i17);
                }
            }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mobileqq.upgrade.activity.o
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i17, KeyEvent keyEvent) {
                    boolean h36;
                    h36 = UpgradeActivity.this.h3(dialogInterface, i17, keyEvent);
                    return h36;
                }
            });
            return t3(message);
        }
        if (i16 == 2) {
            q.b("0X8004DA0", 2, "");
            q.a("0X800417D");
            try {
                this.f306229d0 = String.format(this.f306229d0, new Object[0]);
            } catch (Exception e16) {
                QLog.d("UpgradeController_Activity", 2, "parse dialog wording error!", e16);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpgradeActivity.this.i3(view);
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpgradeActivity.this.j3(view);
                }
            };
            if (this.f306237l0) {
                String str = this.f306233h0;
                if (str != null && !str.isEmpty()) {
                    qqStr = this.f306233h0;
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.uui);
                }
            } else {
                String str2 = this.f306230e0;
                if (str2 != null && !str2.isEmpty()) {
                    qqStr = this.f306230e0;
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.uun);
                }
            }
            com.tencent.mobileqq.upgrade.n.l(this.f306237l0);
            QLog.d("UpgradeController_Activity", 4, "UpgradeActivity, strTitle: ", this.f306226a0, ", strNewTitle: ", this.f306228c0, ", strUpgradeDesc:", this.f306229d0);
            com.tencent.mobileqq.upgrade.m O = com.tencent.mobileqq.upgrade.m.O(this, this.f306228c0, this.f306227b0, this.f306229d0, qqStr, this.f306232g0, onClickListener2, onClickListener);
            O.W(this.f306231f0, new View.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpgradeActivity.this.l3(view);
                }
            });
            return t3(O);
        }
        return null;
    }

    private Dialog w3() {
        q.b("0X8004DA0", 0, "");
        QQCustomDialog message = DialogUtil.createCustomDialog(this, 230).setTitle(this.f306226a0).setMessage(this.f306229d0);
        message.setPositiveButton(R.string.iaw, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                UpgradeActivity.this.n3(dialogInterface, i3);
            }
        }).setNegativeButton(R.string.g3m, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.upgrade.activity.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                UpgradeActivity.this.p3(dialogInterface, i3);
            }
        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mobileqq.upgrade.activity.l
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                boolean r36;
                r36 = UpgradeActivity.this.r3(dialogInterface, i3, keyEvent);
                return r36;
            }
        });
        return t3(message);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        UpgradeInfo upgradeInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        UpgradeDetailWrapper j3 = com.tencent.mobileqq.upgrade.k.i().j();
        this.f306238m0 = j3;
        if (j3 != null && (upgradeInfo = j3.f306170d) != null && upgradeInfo.iUpgradeType > 0) {
            getWindow().setBackgroundDrawableResource(R.color.ajr);
            if (getIntent().getIntExtra("activity_type", 4096) != 4096) {
                QLog.w("UpgradeController_Activity", 1, "activityType param fail");
                finish();
                return true;
            }
            U2();
            return true;
        }
        QLog.w("UpgradeController_Activity", 1, "wrapper.mUpgradeInfo param fail");
        Intent intent = new Intent();
        UpgradeDetailWrapper upgradeDetailWrapper = this.f306238m0;
        if (upgradeDetailWrapper != null && upgradeDetailWrapper.f306170d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        intent.putExtra("getUpgradeInfo", z16);
        setResult(-1, intent);
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        if (this.f306239n0 && MyAppApi.G()) {
            if (!MyAppApi.z().H()) {
                YybUpgradeDialog.j0(this);
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onAccountChanged();
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Dialog) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f306225o0 <= 1000) {
            finish();
            return null;
        }
        f306225o0 = currentTimeMillis;
        QLog.i("UpgradeController_Activity", 1, "onCreateDialog, " + i3);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return null;
                }
                return u3();
            }
            return w3();
        }
        return v3();
    }
}
