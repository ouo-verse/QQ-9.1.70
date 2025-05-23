package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.smallscreen.adelie.AdelieSmallScreenPermissionActivity;
import com.tencent.av.smallscreen.api.ISmallScreenUtilsApi;
import com.tencent.av.utils.ad;
import com.tencent.avcore.util.ArrayUtils;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SmallScreenUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f74522a = {"vivo Y51A", "2014011", "vivo Y67"};

    /* renamed from: b, reason: collision with root package name */
    static int f74523b = -1;

    /* renamed from: c, reason: collision with root package name */
    static int f74524c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static int f74525d = 0;

    /* renamed from: e, reason: collision with root package name */
    static String[] f74526e = {"com.qzone.preview.BasePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QzonePictureViewer", QZoneHelper.GALLERY_VIEWER, "com.qzone.preview.QZoneVideoFloatActivity", "com.qzone.preview.QzonePictureSelectViewer", "com.tencent.mobileqq.activity.FriendProfileImageActivity", "com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity", "com.tencent.mobileqq.activity.photo.PhotoPreviewActivity", "com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity", "com.tencent.av.gaudio.GaInviteDialogActivity", "com.tencent.av.ui.MultiIncomingCallsActivity", "com.tencent.av.ui.GAudioMembersCtrlActivity", "com.tencent.av.ui.VideoInviteActivity", "com.tencent.mobileqq.activity.selectmember.SelectMemberActivity", "com.tencent.av.utils.PopupDialog", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity", "com.miui.permcenter.permissions.AppPermissionsEditorActivity", "com.meizu.safe.security.AppSecActivity", "com.android.settings.Settings$AppDrawOverlaySettingsActivity", "com.tencent.biz.qrcode.activity.QRDisplayActivity", "com.tencent.mobileqq.activity.ForwardRecentActivity", "cooperation.qzone.share.QZoneShareActivity"};

    public static void A(final Context context, boolean z16) {
        final Intent intent = new Intent("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
        intent.setPackage(context.getPackageName());
        intent.putExtra("isResume", z16);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.smallscreen.SmallScreenUtils.1
            @Override // java.lang.Runnable
            public void run() {
                context.sendBroadcast(intent);
            }
        }, 16, null, true);
        if (QLog.isColorLevel()) {
            QLog.d("SmallScreenUtils", 2, "sendHideSmallScreenBroadcast:" + z16);
        }
    }

    public static boolean B(long j3, BaseVideoAppInterface baseVideoAppInterface, int i3) {
        return ((ISmallScreenUtilsApi) QRoute.api(ISmallScreenUtilsApi.class)).sendSmallScreenStateBroadcast(j3, baseVideoAppInterface, i3);
    }

    public static void C(String str, int i3, boolean z16) {
        String str2;
        SharedPreferences.Editor edit = l(str).edit();
        if (z16) {
            str2 = "pref_show_dialog_video";
        } else {
            str2 = "pref_show_dialog_audio";
        }
        edit.putInt(str2, i3).commit();
        if (QLog.isColorLevel()) {
            QLog.e("SmallScreenUtils", 2, "setPrefShowDialog value = " + i3);
        }
    }

    public static boolean D(Context context, boolean z16, String str, boolean z17) {
        return G(context, z16, str, z17, AdelieSmallScreenPermissionActivity.class);
    }

    public static void E(View view, boolean z16, boolean z17) {
        ((ISmallScreenUtilsApi) QRoute.api(ISmallScreenUtilsApi.class)).startSetVisibleAnimation(view, z16, z17);
    }

    public static boolean F(Context context, boolean z16, String str, boolean z17) {
        return G(context, z16, str, z17, SmallScreenDialogActivity.class);
    }

    public static boolean G(Context context, boolean z16, String str, boolean z17, Class<?> cls) {
        boolean z18;
        int i3;
        if (!z16) {
            i3 = 1;
            z18 = true;
        } else {
            z18 = false;
            if (q()) {
                i3 = 7;
            } else if (r(context)) {
                i3 = 2;
            } else if (ad.h(context)) {
                i3 = 3;
            } else if (i(context)) {
                i3 = 5;
            } else if (!TextUtils.isEmpty(str) && k(str, z17) >= 5) {
                i3 = 6;
            } else {
                Intent intent = new Intent(context, cls);
                intent.addFlags(268435456);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                intent.addFlags(131072);
                intent.putExtra("is_video", z17);
                context.startActivity(intent);
                i3 = 100;
                z18 = true;
            }
        }
        if (com.tencent.av.utils.e.k()) {
            QLog.w("SmallScreenUtils", 1, "startSmallScreenDialogActivity, ret[" + z18 + "], code[" + i3 + "]");
        }
        return z18;
    }

    public static boolean H() {
        for (String str : f74522a) {
            if (DeviceInfoMonitor.getModel().equals(str)) {
                QLog.w("SmallScreenUtils", 1, "useTypeToast, model[" + DeviceInfoMonitor.getModel() + "]");
                return true;
            }
        }
        return false;
    }

    public static void a(long j3, int i3, Context context) {
        ((ISmallScreenUtilsApi) QRoute.api(ISmallScreenUtilsApi.class)).actionOff(j3, i3, context);
    }

    public static void b(long j3, int i3, Context context, boolean z16, String str, boolean z17) {
        c(j3, i3, context, z16, str, z17, false);
    }

    public static void c(long j3, int i3, Context context, boolean z16, String str, boolean z17, boolean z18) {
        f74525d = i3;
        ((ISmallScreenUtilsApi) QRoute.api(ISmallScreenUtilsApi.class)).actionOn(j3, i3, context, z16, str, z17, z18);
    }

    @TargetApi(23)
    static boolean d() {
        if (f74523b == -1) {
            f74523b = 0;
            if (Build.VERSION.SDK_INT >= 28) {
                f74523b = 1;
            }
        }
        if (f74523b != 1) {
            return false;
        }
        return true;
    }

    public static boolean e() {
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            return true;
        }
        return false;
    }

    public static boolean f(Context context, int i3, boolean z16) {
        int g16;
        if (q()) {
            return false;
        }
        if (e()) {
            g16 = h(context, i3);
        } else {
            g16 = g(context, i3);
            if (!z16 && g16 != 0) {
                g16 = z() ? 0 : 2;
            }
        }
        if (g16 != 0) {
            return false;
        }
        return true;
    }

    @TargetApi(23)
    public static int g(Context context, int i3) {
        int i16 = 0;
        try {
            if (d()) {
                if (!Settings.canDrawOverlays(context)) {
                    return 2;
                }
            } else {
                Object systemService = context.getSystemService("appops");
                Class<?> cls = Class.forName("android.app.AppOpsManager");
                Class<?> cls2 = Integer.TYPE;
                Object invoke = cls.getMethod("checkOp", cls2, cls2, String.class).invoke(systemService, Integer.valueOf(i3), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName());
                if (invoke != null) {
                    i16 = ((Integer) invoke).intValue();
                }
                if (QLog.isColorLevel()) {
                    QLog.w("SmallScreenUtils", 1, "checkOp_Common suc, op[" + i3 + "], mode[" + i16 + "], result[" + i16 + "]");
                }
            }
        } catch (InvocationTargetException e16) {
            if (!QLog.isColorLevel()) {
                return 2;
            }
            QLog.e("SmallScreenUtils", 2, "checkOp_Common InvocationTargetException", e16);
            return 2;
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e("SmallScreenUtils", 2, "checkOp_Common Exception", e17);
            }
        }
        return i16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005f, code lost:
    
        if (r3 == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0061, code lost:
    
        com.tencent.qphone.base.util.QLog.w("SmallScreenUtils", 1, "checkOp_Vivo suc, result[" + r3 + "]");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x007c, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        if (r2 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int h(Context context, int i3) {
        int g16;
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), Uri.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps"), new String[]{"currentmode"}, "pkgname='" + context.getPackageName() + "'", null, null);
            g16 = 0;
            if (cursor != null && cursor.moveToFirst()) {
                if (cursor.getInt(0) != 0) {
                    g16 = 2;
                }
            }
        } catch (Throwable th5) {
            try {
                QLog.w("SmallScreenUtils", 1, "checkOp_Vivo, Exception", th5);
                g16 = g(context, i3);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public static boolean i(Context context) {
        ComponentName componentName;
        if (context == null) {
            return false;
        }
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                componentName = runningTasks.get(0).topActivity;
            } else {
                componentName = null;
            }
            if (componentName == null) {
                return false;
            }
            boolean contains = ArrayUtils.contains(f74526e, componentName.getClassName());
            if (QLog.isDevelopLevel()) {
                QLog.w("SmallScreenUtils", 1, "checkTopActivityHideSmallScreen, topActivity[" + componentName.getClassName() + "], check[" + contains + "]");
            }
            return contains;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int j(int i3) {
        return ((ISmallScreenUtilsApi) QRoute.api(ISmallScreenUtilsApi.class)).getFinishAnimId(i3);
    }

    public static int k(String str, boolean z16) {
        String str2;
        SharedPreferences l3 = l(str);
        if (z16) {
            str2 = "pref_show_dialog_video";
        } else {
            str2 = "pref_show_dialog_audio";
        }
        int i3 = l3.getInt(str2, 0);
        if (QLog.isColorLevel()) {
            QLog.e("SmallScreenUtils", 2, "getPrefShowDialog result = " + i3);
        }
        return i3;
    }

    static SharedPreferences l(String str) {
        return BaseApplication.getContext().getSharedPreferences("com.tencent.av.smallscreen" + str, 0);
    }

    public static void m() {
        if (QLog.isColorLevel()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int length = stackTrace.length;
            String str = "";
            for (int i3 = 0; i3 < length; i3++) {
                str = str + "ste[" + i3 + "]" + stackTrace[i3].toString() + "\n";
            }
            QLog.d("SmallScreenUtils", 2, str);
        }
    }

    public static void n(String str) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        String str2 = "getTrace[" + str + "]\n";
        for (int i3 = 1; i3 < length; i3++) {
            str2 = str2 + "ste[" + i3 + "]" + stackTrace[i3].toString() + "\n";
        }
        QLog.d("SmallScreenUtils", 1, str2);
    }

    public static boolean o() {
        boolean z16;
        if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            return false;
        }
        try {
            z16 = ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception unused) {
            z16 = false;
        }
        String str = Build.DEVICE;
        if (str.equals("mx2")) {
            return true;
        }
        if (str.equals("mx") || str.equals("m9")) {
            return false;
        }
        return z16;
    }

    public static boolean p(Context context) {
        ComponentName componentName;
        boolean z16;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                componentName = runningTasks.get(0).topActivity;
            } else {
                componentName = null;
            }
            if (componentName != null && componentName.getPackageName().startsWith(packageName)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("SmallScreenUtils", 2, "isAppOnForeground componentName = " + componentName);
                }
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
                if (runningAppProcesses == null) {
                    return false;
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith(packageName)) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("SmallScreenUtils", 2, "isAppOnForeground appProcess.processName = " + runningAppProcessInfo.processName);
                        }
                        return true;
                    }
                }
                return false;
            }
            return z16;
        } catch (Throwable th5) {
            if (!QLog.isDevelopLevel()) {
                return false;
            }
            QLog.d("SmallScreenUtils", 2, "isAppOnForeground e = " + th5);
            return false;
        }
    }

    public static boolean q() {
        return false;
    }

    public static boolean r(Context context) {
        if (!f(context, 24, false) && !H()) {
            return false;
        }
        return true;
    }

    public static boolean s(Context context) {
        if (f(context, 24, true) || H()) {
            return true;
        }
        return false;
    }

    public static boolean t(Context context, String str) {
        ActivityInfo resolveActivityInfo;
        if (context == null || TextUtils.isEmpty(str) || (resolveActivityInfo = new Intent(str).resolveActivityInfo(context.getPackageManager(), 65536)) == null || !resolveActivityInfo.exported) {
            return false;
        }
        return true;
    }

    public static boolean u(Context context) {
        return ((ISmallScreenUtilsApi) QRoute.api(ISmallScreenUtilsApi.class)).isLock(context);
    }

    public static boolean v() {
        return ((ISmallScreenUtilsApi) QRoute.api(ISmallScreenUtilsApi.class)).isShareToastShow();
    }

    public static boolean w() {
        return ((ISmallScreenUtilsApi) QRoute.api(ISmallScreenUtilsApi.class)).isSupportSmallScreen();
    }

    public static boolean x() {
        return ((ISmallScreenUtilsApi) QRoute.api(ISmallScreenUtilsApi.class)).isSupportSmallScreenAudio();
    }

    public static boolean y() {
        return ((ISmallScreenUtilsApi) QRoute.api(ISmallScreenUtilsApi.class)).isSupportSmallScreenVideo();
    }

    static boolean z() {
        if (f74524c == -1) {
            f74524c = 0;
            if (Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) && !"vivo X6D".equalsIgnoreCase(DeviceInfoMonitor.getModel()) && !"vivo X6D".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                f74524c = 1;
            }
        }
        if (f74524c != 1) {
            return false;
        }
        return true;
    }
}
