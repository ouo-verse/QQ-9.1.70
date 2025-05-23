package com.tencent.mobileqq.colornote.smallscreen;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteSmallScreenUtil {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f201653a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f201654b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Point f201655c = new Point(-1, -1);

    public static void a(TextView textView, String str, int i3, TextUtils.TruncateAt truncateAt, String str2, int i16) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            float f16 = i3 - i16;
            if (f16 >= textView.getPaint().measureText(str)) {
                textView.setText(str);
                return;
            }
            if (truncateAt == TextUtils.TruncateAt.END) {
                CharSequence ellipsize = TextUtils.ellipsize(str, textView.getPaint(), f16, truncateAt);
                float measureText = textView.getPaint().measureText((String) ellipsize);
                float measureText2 = textView.getPaint().measureText("\u7684");
                if (f16 - measureText > measureText2 / 2.0f && i16 != 0) {
                    textView.setMaxWidth((int) (i3 + measureText2));
                    ellipsize = TextUtils.ellipsize(str, textView.getPaint(), (int) (f16 + measureText2), truncateAt);
                }
                textView.setText(ellipsize);
                return;
            }
            if (truncateAt == TextUtils.TruncateAt.MIDDLE && !TextUtils.isEmpty(str2)) {
                int lastIndexOf = str.lastIndexOf(str2);
                if (lastIndexOf == -1) {
                    textView.setText(str);
                    return;
                }
                String substring = str.substring(0, lastIndexOf);
                String str3 = "\u2026" + str.substring(lastIndexOf);
                float measureText3 = textView.getPaint().measureText(substring);
                float measureText4 = textView.getPaint().measureText(str3);
                if (measureText4 > f16) {
                    textView.setText(str);
                    return;
                }
                while (f16 - measureText3 < measureText4) {
                    substring = substring.substring(0, substring.length() - 1);
                    measureText3 = textView.getPaint().measureText(substring);
                }
                textView.setText(substring + str3);
                return;
            }
            textView.setEllipsize(truncateAt);
        }
    }

    public static SharedPreferences b(Context context, String str) {
        return context.getSharedPreferences("color_note_" + str, 4);
    }

    public static Point c(AppRuntime appRuntime) {
        Point point = f201655c;
        if (point.x == -1 || point.y == -1) {
            SharedPreferences b16 = b(appRuntime.getApp(), appRuntime.getCurrentUin());
            int i3 = b16.getInt("colornote_windows_x", -1);
            int i16 = b16.getInt("colornote_windows_y", -1);
            if (i3 == -1 || i16 == -1) {
                int screenWidth = ViewUtils.getScreenWidth() - ViewUtils.dip2px(25.0f);
                i3 = screenWidth;
                i16 = ViewUtils.dip2px(25.0f) + (ViewUtils.getScreenHeight() / 2);
            }
            Point point2 = f201655c;
            point2.x = i3;
            point2.y = i16;
        }
        return f201655c;
    }

    public static int d(ColorNote colorNote) {
        if (colorNote != null && com.tencent.mobileqq.colornote.data.a.x(colorNote)) {
            return 2;
        }
        if (com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
            return 3;
        }
        return 1;
    }

    public static UpComingMsgModel e(ColorNote colorNote) {
        if (colorNote != null && colorNote.getServiceType() == 17235968) {
            String str = new String(colorNote.getReserve());
            UpComingMsgModel upComingMsgModel = new UpComingMsgModel();
            upComingMsgModel.parseFromJson(str);
            return upComingMsgModel;
        }
        return new UpComingMsgModel();
    }

    public static int f(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("@")) != null && split.length > 0) {
            String str2 = split[0];
            if (!TextUtils.isEmpty(str2)) {
                return Integer.parseInt(str2);
            }
        }
        return -1;
    }

    public static boolean g() {
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

    public static synchronized void h(Context context) {
        synchronized (ColorNoteSmallScreenUtil.class) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenUtil", 1, "hideColorNoteSmallScreen sHasServiceExit = " + f201653a);
            }
            Intent intent = new Intent(context, (Class<?>) ColorNoteSmallScreenService.class);
            try {
                f201653a = false;
                context.stopService(intent);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ColorNoteSmallScreenUtil", 2, "actionOff e = " + e16);
                }
            }
        }
    }

    public static boolean i() {
        if (QLog.isDevelopLevel()) {
            QLog.d("ColorNoteSmallScreenUtil", 2, "isAfterSyncMsg() " + f201654b);
        }
        return f201654b;
    }

    public static boolean j(Context context) {
        ComponentName componentName;
        boolean z16;
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
                    QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground componentName = " + componentName);
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
                            QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground appProcess.processName = " + runningAppProcessInfo.processName);
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
            QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground e = " + th5);
            return false;
        }
    }

    private static boolean k(Context context) {
        ComponentName componentName;
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
            if (runningTasks != null && !runningTasks.isEmpty()) {
                componentName = runningTasks.get(0).topActivity;
                if (componentName == null) {
                    QLog.e("ColorNoteSmallScreenUtil", 1, "isQQStillInForeground topActivity is null");
                    return false;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("FSReceiver", 4, "currTopPkg:", componentName.getPackageName());
                }
                if (componentName.getPackageName().equals(context.getPackageName())) {
                    return true;
                }
            }
        } catch (Throwable th5) {
            QLog.e("ColorNoteSmallScreenUtil", 1, "isQQStillInForeground exception", th5);
        }
        return false;
    }

    private static void l(final Context context, final Intent intent) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    context.sendBroadcast(intent);
                }
            }, 16, null, true);
        } else {
            context.sendBroadcast(intent);
        }
    }

    public static void m(Context context, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenUtil", 1, "sendUpdateSmallScreenStateBroadcast sHasServiceExit = " + f201653a + ", from = " + i3 + ", shouldShow = " + z16);
        }
        if (context == null) {
            QLog.d("ColorNoteSmallScreenUtil", 1, "sendUpdateSmallScreenStateBroadcast context == null");
            return;
        }
        Intent intent = new Intent("action_update_cn_smallscreen_state");
        intent.setPackage(context.getPackageName());
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, i3);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 == 6) {
                        intent.putExtra("param_custom_night_mode", z16);
                    }
                } else {
                    if (z16) {
                        try {
                            context.startService(new Intent(context, (Class<?>) ColorNoteSmallScreenService.class));
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + e16);
                            }
                        }
                    }
                    intent.putExtra("param_is_app_foreground", z16);
                }
            } else {
                intent.putExtra("param_shoule_show_smallscreen", z16);
            }
        } else {
            intent.putExtra("param_not_in_colornote_list", z16);
        }
        l(context, intent);
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenUtil", 2, "sendUpdateSmallScreenStateBroadcast:" + z16);
        }
    }

    public static synchronized void n(boolean z16) {
        synchronized (ColorNoteSmallScreenUtil.class) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                peekAppRuntime.getRuntimeService(IColorNoteDataService.class, "");
            }
            f201654b = z16;
            if (QLog.isDevelopLevel()) {
                QLog.d("ColorNoteSmallScreenUtil", 2, "setAfterSyncMsg " + f201654b);
            }
            Intent intent = new Intent("key_after_sync_msg");
            intent.putExtra("extra_after_sync_msg", f201654b);
            BaseApplication.getContext().sendBroadcast(intent);
        }
    }

    public static void o(AppRuntime appRuntime, boolean z16) {
        if (!z16 && k(BaseApplication.getContext())) {
            z16 = true;
        }
        if (z16 && f201654b) {
            IColorNoteDataService iColorNoteDataService = (IColorNoteDataService) appRuntime.getRuntimeService(IColorNoteDataService.class, "all");
            if (appRuntime.isLogin() && iColorNoteDataService.getCurrentColorNoteCount() > 0) {
                p(appRuntime, false, true);
            }
        }
    }

    public static synchronized void p(AppRuntime appRuntime, boolean z16, boolean z17) {
        synchronized (ColorNoteSmallScreenUtil.class) {
            q(appRuntime, z16, z17, null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:3|4|(1:6)|7|(1:10)|11|(2:15|16)|19|20|21|16) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        com.tencent.qphone.base.util.QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil.f201653a = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void q(AppRuntime appRuntime, boolean z16, boolean z17, ColorNote colorNote) {
        synchronized (ColorNoteSmallScreenUtil.class) {
            BaseApplication app = appRuntime.getApp();
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenUtil", 1, "showColorNoteSmallScreen , idAdd = " + z16 + ", sHasServiceExit = " + f201653a + ", force = " + z17);
            }
            int d16 = d(colorNote);
            if (!b.d(app) && z16) {
                t(appRuntime, d16);
            }
            if (f201653a && !z17) {
                m(app, 3, true);
            }
            f201653a = true;
            app.startService(new Intent(app, (Class<?>) ColorNoteSmallScreenService.class));
        }
    }

    public static void r(Context context, boolean z16) {
        Intent intent = new Intent(context, (Class<?>) ColorNoteSmallScreenService.class);
        intent.putExtra("KEY_CMD_SHOW_LIST", 1);
        intent.putExtra("KEY_SHOW_LIST_LAND", z16);
        context.startService(intent);
    }

    public static void s(Context context, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenUtil", 2, "[showListFromAddTodo], is called");
        }
        Intent intent = new Intent(context, (Class<?>) ColorNoteSmallScreenService.class);
        intent.putExtra("KEY_CMD_SHOW_LIST", 1);
        intent.putExtra("key_upcoming_notify", 2);
        intent.putExtra("KEY_SHOW_LIST_LAND", z16);
        context.startService(intent);
    }

    private static void t(AppRuntime appRuntime, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("ColorNoteSmallScreenUtil", 2, "showPermissionDialog in");
        }
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("key_permission_from", i3);
        if ((i3 != 3 || !com.tencent.mobileqq.colornote.e.b(appRuntime)) && !ColorNoteSmallScreenPermissionDialogFragment.C) {
            QPublicFragmentActivity.b.d(intent, QPublicTransFragmentActivity.class, ColorNoteSmallScreenPermissionDialogFragment.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void u(int i3, int i16) {
        Point point = f201655c;
        point.x = i3;
        point.y = i16;
    }

    public static void v(Context context) {
        if (!f201653a) {
            f201653a = true;
            try {
                context.startService(new Intent(context, (Class<?>) ColorNoteSmallScreenService.class));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + e16);
                }
                f201653a = false;
            }
        }
        m(context, 3, true);
    }
}
