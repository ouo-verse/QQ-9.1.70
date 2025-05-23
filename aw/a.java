package aw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.smallscreen.b;
import com.tencent.av.utils.at;
import com.tencent.av.utils.e;
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
public class a extends b implements DialogInterface.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    private QQCustomDialog f27022e;

    /* renamed from: f, reason: collision with root package name */
    private QQCustomDialog f27023f;

    /* renamed from: h, reason: collision with root package name */
    BroadcastReceiver f27024h;

    /* compiled from: P */
    /* renamed from: aw.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0073a extends BroadcastReceiver {
        C0073a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("tencent.video.v2q.SmallScreenState")) {
                int intExtra = intent.getIntExtra("SmallScreenState", -1);
                long a16 = at.a(intent);
                boolean r16 = SmallScreenUtils.r(((b) a.this).f74591d);
                if (e.k() || r16) {
                    QLog.w("FloatWindowPrivacyModel", 1, "Receiver ACTION_SMALL_SCREEN_STATE, isFloatWindowOpAllowed[" + r16 + "], state[" + intExtra + "], seq[" + a16 + "]");
                }
                if (r16) {
                    ((b) a.this).f74591d.finish();
                }
            }
        }
    }

    public a(BaseActivity baseActivity) {
        super(baseActivity);
        this.f27022e = null;
        this.f27023f = null;
        this.f27024h = new C0073a();
    }

    static boolean i() {
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(ah.C())) {
            return false;
        }
        return true;
    }

    private QQCustomDialog j() {
        QLog.d("FloatWindowPrivacyModel", 1, "getDialog_gotoSystemSettings", new Throwable());
        if (this.f27023f == null) {
            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this.f74591d, 230).setMessage(R.string.f17821362).setPositiveButton(R.string.ddx, this);
            this.f27023f = positiveButton;
            positiveButton.setCancelable(false);
            this.f27023f.setCanceledOnTouchOutside(false);
        }
        return this.f27023f;
    }

    private QQCustomDialog k() {
        int i3;
        if (this.f27022e == null) {
            QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this.f74591d, 230).setMessage(R.string.f171262dk2).setNegativeButton(R.string.cancel, this);
            if (l()) {
                i3 = R.string.dk6;
            } else {
                i3 = R.string.dkg;
            }
            QQCustomDialog positiveButton = negativeButton.setPositiveButton(i3, this);
            this.f27022e = positiveButton;
            positiveButton.setTitle(R.string.f171263dk4);
            this.f27022e.setCancelable(false);
            this.f27022e.setCanceledOnTouchOutside(false);
        }
        return this.f27022e;
    }

    private boolean l() {
        boolean z16;
        if (!SmallScreenUtils.t(this.f74591d, "miui.intent.action.APP_PERM_EDITOR") && !SmallScreenUtils.t(this.f74591d, "com.meizu.safe.security.SHOW_APPSEC") && !SmallScreenUtils.t(this.f74591d, "huawei.intent.action.NOTIFICATIONMANAGER") && !SmallScreenUtils.t(this.f74591d, "android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return q();
        }
        return z16;
    }

    private boolean m(boolean z16, String str, StringBuilder sb5) {
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

    private boolean n(boolean z16, String str, StringBuilder sb5) {
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

    private boolean o(boolean z16, String str, StringBuilder sb5) {
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

    private boolean p(boolean z16, String str, StringBuilder sb5) {
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
        QLog.d("FloatWindowPrivacyModel", 1, "onCreate");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("tencent.video.v2q.SmallScreenState");
        this.f74591d.registerReceiver(this.f27024h, intentFilter);
        if (SmallScreenUtils.r(this.f74591d)) {
            this.f74591d.finish();
        }
        QLog.d("FloatWindowPrivacyModel", 1, "onCreate end.");
    }

    @Override // com.tencent.av.smallscreen.b
    public void b() {
        this.f74591d.unregisterReceiver(this.f27024h);
    }

    @Override // com.tencent.av.smallscreen.b
    public void d() {
        QLog.d("FloatWindowPrivacyModel", 1, "onResume");
        if (SmallScreenUtils.u(this.f74591d)) {
            QLog.w("FloatWindowPrivacyModel", 1, "\u9501\u5c4f\u4e2d\uff0c\u4e0d\u5f391");
            this.f74591d.finish();
        } else {
            if (!SmallScreenUtils.r(this.f74591d)) {
                if (this.f27022e == null) {
                    k();
                    f("onResume.1", this.f27022e);
                    return;
                } else {
                    j();
                    f("onResume.1", this.f27023f);
                    return;
                }
            }
            QLog.w("FloatWindowPrivacyModel", 1, "onResume, finish");
            this.f74591d.finish();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        if (dialogInterface.equals(this.f27022e)) {
            if (i3 != 0) {
                if (i3 == 1) {
                    if (l()) {
                        r();
                        return;
                    } else {
                        j();
                        f("WHICH_POSITIVE", this.f27023f);
                        return;
                    }
                }
                return;
            }
            boolean booleanExtra = this.f74591d.getIntent().getBooleanExtra("is_video", false);
            String currentAccountUin = this.f74591d.getAppRuntime().getCurrentAccountUin();
            SmallScreenUtils.C(currentAccountUin, SmallScreenUtils.k(currentAccountUin, booleanExtra) + 1, booleanExtra);
            this.f74591d.finish();
            return;
        }
        if (dialogInterface.equals(this.f27023f) && i3 == 1) {
            this.f74591d.finish();
        }
    }

    boolean q() {
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

    void r() {
        String packageName = this.f74591d.getPackageName();
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        if (i() && SmallScreenUtils.t(this.f74591d, "android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
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
        boolean m3 = m(p(n(o(z16, packageName, sb5), packageName, sb5), packageName, sb5), packageName, sb5);
        QLog.w("FloatWindowPrivacyModel", 1, "openPermissionActivity, openSuccess[" + m3 + "], code[" + sb5.toString() + "]");
        if (!m3) {
            j();
            f("openPermissionActivity", this.f27023f);
        }
    }

    @Override // com.tencent.av.smallscreen.b
    public void c() {
    }

    @Override // com.tencent.av.smallscreen.b
    public void e() {
    }
}
