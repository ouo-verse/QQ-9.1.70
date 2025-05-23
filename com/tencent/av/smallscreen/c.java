package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.av.utils.at;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends b implements DialogInterface.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    BaseVideoAppInterface f74592e;

    /* renamed from: f, reason: collision with root package name */
    private QQCustomDialog f74593f;

    /* renamed from: h, reason: collision with root package name */
    private QQCustomDialog f74594h;

    /* renamed from: i, reason: collision with root package name */
    BroadcastReceiver f74595i;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("tencent.video.v2q.SmallScreenState")) {
                int intExtra = intent.getIntExtra("SmallScreenState", -1);
                long a16 = at.a(intent);
                boolean r16 = SmallScreenUtils.r(c.this.f74592e.getApp());
                if (com.tencent.av.utils.e.k() || r16) {
                    QLog.w("FloatWindowPrivacyModel", 1, "Receiver ACTION_SMALL_SCREEN_STATE, isFloatWindowOpAllowed[" + r16 + "], state[" + intExtra + "], seq[" + a16 + "]");
                }
                if (r16) {
                    c.this.f74591d.finish();
                }
            }
        }
    }

    public c(BaseActivity baseActivity) {
        super(baseActivity);
        this.f74593f = null;
        this.f74594h = null;
        this.f74595i = new a();
    }

    static boolean g() {
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(ah.C())) {
            return false;
        }
        return true;
    }

    private QQCustomDialog h() {
        if (this.f74594h == null) {
            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this.f74591d, 230).setMessage(R.string.f17821362).setPositiveButton(R.string.ddx, this);
            this.f74594h = positiveButton;
            positiveButton.setCancelable(false);
            this.f74594h.setCanceledOnTouchOutside(false);
        }
        return this.f74594h;
    }

    private QQCustomDialog i() {
        int i3;
        if (this.f74593f == null) {
            QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this.f74591d, 230).setMessage(R.string.f171262dk2).setNegativeButton(R.string.cancel, this);
            if (j()) {
                i3 = R.string.dk6;
            } else {
                i3 = R.string.dkg;
            }
            QQCustomDialog positiveButton = negativeButton.setPositiveButton(i3, this);
            this.f74593f = positiveButton;
            positiveButton.setTitle(R.string.f171263dk4);
            this.f74593f.setCancelable(false);
            this.f74593f.setCanceledOnTouchOutside(false);
        }
        return this.f74593f;
    }

    private boolean j() {
        boolean z16;
        if (!SmallScreenUtils.t(this.f74591d, "miui.intent.action.APP_PERM_EDITOR") && !SmallScreenUtils.t(this.f74591d, "com.meizu.safe.security.SHOW_APPSEC") && !SmallScreenUtils.t(this.f74591d, "huawei.intent.action.NOTIFICATIONMANAGER") && !SmallScreenUtils.t(this.f74591d, "android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return o();
        }
        return z16;
    }

    private boolean k(boolean z16, String str, StringBuilder sb5) {
        boolean z17;
        if (!z16 && SmallScreenUtils.t(this.f74591d, "huawei.intent.action.NOTIFICATIONMANAGER")) {
            Intent intent = new Intent();
            intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
            try {
                this.f74591d.startActivity(intent);
                sb5.append("ACTION_HUAWEI_1");
                z17 = true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", e16);
                }
                z17 = false;
            }
            if (!z17) {
                try {
                    this.f74591d.startActivity(new Intent("huawei.intent.action.NOTIFICATIONMANAGER"));
                    sb5.append("ACTION_HUAWEI_2");
                    return true;
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", e17);
                    }
                    return false;
                }
            }
            return z17;
        }
        return z16;
    }

    private boolean l(boolean z16, String str, StringBuilder sb5) {
        if (!z16 && SmallScreenUtils.t(this.f74591d, "com.meizu.safe.security.SHOW_APPSEC")) {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
            intent.putExtra("packageName", str);
            try {
                this.f74591d.startActivity(intent);
                sb5.append("ACTION_MEIZU");
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", e16);
                }
                return false;
            }
        }
        return z16;
    }

    private boolean m(boolean z16, String str, StringBuilder sb5) {
        if (!z16 && SmallScreenUtils.t(this.f74591d, "miui.intent.action.APP_PERM_EDITOR")) {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", str);
            try {
                this.f74591d.startActivity(intent);
                sb5.append("ACTION_MIUI");
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", e16);
                }
                return false;
            }
        }
        return z16;
    }

    private boolean n(boolean z16, String str, StringBuilder sb5) {
        if (!z16 && CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(ah.C()) && SmallScreenUtils.t(this.f74591d, "permission.intent.action.softPermissionDetail")) {
            Intent intent = new Intent("permission.intent.action.softPermissionDetail");
            try {
                intent.putExtra("packagename", str);
                this.f74591d.startActivity(intent);
                sb5.append("ACTION_VIVO");
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", e16);
                }
                return false;
            }
        }
        return z16;
    }

    @Override // com.tencent.av.smallscreen.b
    public void a(Bundle bundle) {
        this.f74592e = (BaseVideoAppInterface) this.f74591d.getAppRuntime();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("tencent.video.v2q.SmallScreenState");
        this.f74591d.registerReceiver(this.f74595i, intentFilter);
        if (SmallScreenUtils.r(this.f74592e.getApp())) {
            this.f74591d.finish();
        }
    }

    @Override // com.tencent.av.smallscreen.b
    public void b() {
        this.f74591d.unregisterReceiver(this.f74595i);
    }

    @Override // com.tencent.av.smallscreen.b
    public void d() {
        if (SmallScreenUtils.u(this.f74591d)) {
            QLog.w("FloatWindowPrivacyModel", 1, "\u9501\u5c4f\u4e2d\uff0c\u4e0d\u5f391");
            this.f74591d.finish();
        } else {
            if (!SmallScreenUtils.r(this.f74592e.getApp())) {
                if (this.f74593f == null) {
                    i();
                    f("onResume.1", this.f74593f);
                    return;
                } else {
                    h();
                    f("onResume.1", this.f74594h);
                    return;
                }
            }
            QLog.w("FloatWindowPrivacyModel", 1, "onResume, finish");
            this.f74591d.finish();
        }
    }

    boolean o() {
        String str = Build.MANUFACTURER;
        boolean z16 = false;
        if ((!str.equalsIgnoreCase("OPPO") || !DeviceInfoMonitor.getModel().equalsIgnoreCase("PCKM80")) && ((!str.equalsIgnoreCase("VIVO") || (!DeviceInfoMonitor.getModel().equalsIgnoreCase("V1838A") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("V1936A") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("vivo X9s L"))) && ((!str.equalsIgnoreCase("HUAWEI") || !DeviceInfoMonitor.getModel().equalsIgnoreCase("H60-L01")) && (!str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) || !DeviceInfoMonitor.getModel().equalsIgnoreCase("MI 5X"))))) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FloatWindowPrivacyModel", 2, "isSupport, manufacturer[" + str + "], model[" + DeviceInfoMonitor.getModel() + "], bSupport[" + z16 + "]");
        }
        return z16;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        if (dialogInterface.equals(this.f74593f)) {
            if (i3 != 0) {
                if (i3 == 1) {
                    if (j()) {
                        p();
                        return;
                    } else {
                        h();
                        f("WHICH_POSITIVE", this.f74594h);
                        return;
                    }
                }
                return;
            }
            boolean booleanExtra = this.f74591d.getIntent().getBooleanExtra("is_video", false);
            String currentAccountUin = this.f74592e.getCurrentAccountUin();
            SmallScreenUtils.C(currentAccountUin, SmallScreenUtils.k(currentAccountUin, booleanExtra) + 1, booleanExtra);
            this.f74591d.finish();
            return;
        }
        if (dialogInterface.equals(this.f74594h) && i3 == 1) {
            this.f74591d.finish();
        }
    }

    void p() {
        String packageName = this.f74591d.getPackageName();
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        if (g() && SmallScreenUtils.t(this.f74591d, "android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            try {
                this.f74591d.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + packageName)));
                sb5.append("ACTION_ANDROID");
                z16 = true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("FloatWindowPrivacyModel", 2, "openPermissionActivity Exception", e16);
                }
                sb5.append("Exception:");
                sb5.append(e16.getMessage());
            }
        }
        boolean k3 = k(n(l(m(z16, packageName, sb5), packageName, sb5), packageName, sb5), packageName, sb5);
        QLog.w("FloatWindowPrivacyModel", 1, "openPermissionActivity, openSuccess[" + k3 + "], code[" + sb5.toString() + "]");
        if (!k3) {
            h();
            f("openPermissionActivity", this.f74594h);
        }
    }

    @Override // com.tencent.av.smallscreen.b
    public void c() {
    }

    @Override // com.tencent.av.smallscreen.b
    public void e() {
    }
}
