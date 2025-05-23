package com.tencent.mobileqq.phonecontact;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/* loaded from: classes16.dex */
public class PermissionPageUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static String f258341c;

    /* renamed from: a, reason: collision with root package name */
    private Context f258342a;

    /* renamed from: b, reason: collision with root package name */
    private String f258343b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73531);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f258341c = null;
        }
    }

    public PermissionPageUtil(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            return;
        }
        this.f258342a = context;
        this.f258343b = str;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.phonecontact.PermissionPageUtil.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PermissionPageUtil.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String str3 = Build.MANUFACTURER;
                if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equals(str3)) {
                    str2 = PermissionPageUtil.b();
                } else {
                    str2 = null;
                }
                PermissionPageUtil.g(String.format("PermissionPageUtil init [%s, %s]", str3, str2));
            }
        }, 16, null, true);
        g(String.format("PermissionPageUtil [%s]", str));
    }

    private void a(String str) {
        PackageInfo packageInfo;
        ResolveInfo resolveInfo = null;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(this.f258342a.getPackageManager(), str, 0);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            c();
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(packageInfo.packageName);
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(this.f258342a.getPackageManager(), intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            resolveInfo = queryIntentActivities.get(0);
        }
        if (resolveInfo != null) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            String str2 = activityInfo.packageName;
            String str3 = activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str2, str3));
            i(intent2);
            return;
        }
        c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
    
        if (com.tencent.mobileqq.phonecontact.PermissionPageUtil.f258341c == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
    
        g(java.lang.String.format("getMiuiVersion [%s]", com.tencent.mobileqq.phonecontact.PermissionPageUtil.f258341c));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0077, code lost:
    
        return com.tencent.mobileqq.phonecontact.PermissionPageUtil.f258341c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
    
        com.tencent.mobileqq.phonecontact.PermissionPageUtil.f258341c = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        if (com.tencent.mobileqq.phonecontact.PermissionPageUtil.f258341c != null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        BufferedReader bufferedReader;
        String str = f258341c;
        if (str != null) {
            return str;
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "getprop ro.miui.ui.version.name").getInputStream()), 1024);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            f258341c = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        } catch (Throwable th7) {
            th = th7;
            bufferedReader2 = bufferedReader;
            try {
                th.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
            } finally {
            }
        }
    }

    private void c() {
        g("goIntentSetting");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f258342a.getPackageName(), null));
        Context context = this.f258342a;
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 9999);
        } else {
            context.startActivity(intent);
        }
    }

    private void e() {
        Intent intent = new Intent(this.f258343b);
        intent.setFlags(268435456);
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        i(intent);
    }

    private void f() {
        String b16 = b();
        if (!"V6".equals(b16) && !"V7".equals(b16)) {
            if (!"V8".equals(b16) && !"V9".equals(b16) && !"V12".equals(b16)) {
                c();
                return;
            }
            Intent intent = new Intent();
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", this.f258343b);
            i(intent);
            return;
        }
        Intent intent2 = new Intent();
        intent2.setAction("miui.intent.action.APP_PERM_EDITOR");
        intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent2.putExtra("extra_pkgname", this.f258343b);
        i(intent2);
    }

    public static void g(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("PermissionPageUtil", 2, str);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String str = Build.MANUFACTURER;
        g(String.format("jumpPermissionPage [brand: %s, model: %s, manufacture: %s]", Build.BRAND, DeviceInfoMonitor.getModel(), str));
        if ("HUAWEI".equals(str)) {
            e();
            return;
        }
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equals(str)) {
            a("com.bairenkeji.icaller");
            return;
        }
        if ("OPPO".equals(str)) {
            a("com.coloros.safecenter");
        } else if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equals(str)) {
            f();
        } else {
            c();
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Intent intent = new Intent(this.f258342a, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("url", "https://kf.qq.com/touch/faq/120307IVnEni150407eEv2IF.html?platform=14&_wv=0");
        Context context = this.f258342a;
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 9999);
        } else {
            context.startActivity(intent);
        }
        if (QLog.isColorLevel()) {
            QLog.i("PermissionPageUtil", 2, "openDefaultGuide");
        }
    }

    public void i(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        try {
            Context context = this.f258342a;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 9999);
            } else {
                context.startActivity(intent);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            g(String.format("doStartApplicationWithPackageName [%s]", th5.getMessage()));
            c();
        }
    }
}
