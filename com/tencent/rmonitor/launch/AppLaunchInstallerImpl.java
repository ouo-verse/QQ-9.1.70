package com.tencent.rmonitor.launch;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.common.utils.GcInfoStatHelper;
import com.tencent.bugly.common.utils.ReflectUtil;
import com.tencent.bugly.library.R;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class AppLaunchInstallerImpl {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f365602a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final AppLaunchInstallerImpl f365603a = new AppLaunchInstallerImpl();
    }

    private void a(Application application, Class cls) {
        boolean z16;
        if (application != null && cls != null) {
            try {
                Field field = ReflectUtil.getField(cls, "rmonitor_app_launch_monitor_activity_before_landing");
                String[] strArr = null;
                if (field != null) {
                    strArr = application.getResources().getStringArray(((Integer) field.get(null)).intValue());
                }
                AppLaunchMonitor appLaunchMonitor = AppLaunchMonitor.getInstance();
                int i3 = 0;
                if (strArr != null && strArr.length > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                appLaunchMonitor.enableCheckActivityBeforeLanding(z16);
                while (strArr != null) {
                    if (i3 < strArr.length) {
                        AppLaunchMonitor.getInstance().addActivityNameBeforeLanding(strArr[i3]);
                        i3++;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th5) {
                Logger.f365497g.b("RMonitor_launch_installer", "get rmonitor config fail ", th5);
            }
        }
    }

    private void b(Application application, Class cls) {
        if (application != null && cls != null) {
            try {
                Field field = ReflectUtil.getField(cls, "rmonitor_app_launch_monitor_landing_activity");
                String[] strArr = null;
                if (field != null) {
                    strArr = application.getResources().getStringArray(((Integer) field.get(null)).intValue());
                }
                int i3 = 0;
                while (strArr != null) {
                    if (i3 < strArr.length) {
                        AppLaunchMonitor.getInstance().addLandingActivityName(strArr[i3]);
                        i3++;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th5) {
                Logger.f365497g.b("RMonitor_launch_installer", "get rmonitor config fail ", th5);
            }
        }
    }

    private void c(Application application) {
        if (isLaunchMonitorEnabled()) {
            setLaunchMonitorEnabled(false);
            m();
            j(application);
        }
    }

    private void d(String str) {
        Context f16 = f();
        boolean z16 = false;
        if (f16 != null) {
            try {
                File file = new File(f16.getFilesDir() + File.separator + str);
                if (!file.exists()) {
                    z16 = file.createNewFile();
                }
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_launch_installer", th5);
            }
        }
        l("createFile", str, z16, f16);
    }

    private void e(String str) {
        Context f16 = f();
        boolean z16 = false;
        if (f16 != null) {
            try {
                File file = new File(f16.getFilesDir() + File.separator + str);
                if (file.exists()) {
                    z16 = file.delete();
                }
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_launch_installer", th5);
            }
        }
        l("deleteFile", str, z16, f16);
    }

    private Context f() {
        Context context;
        WeakReference<Context> weakReference = this.f365602a;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (context == null) {
            return ContextUtil.getGlobalContext();
        }
        return context;
    }

    private int g() {
        SharedPreferences i3 = i();
        if (i3 == null) {
            return 0;
        }
        return i3.getInt(SPKey.KEY_LAUNCHER_NOT_SAFE_COUNT, 0);
    }

    public static AppLaunchInstallerImpl getInstance() {
        return a.f365603a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Class h() {
        if (R.array.class != 0) {
            return R.array.class;
        }
        try {
            return Class.forName("com.tencent.bugly.common.R$array");
        } catch (Throwable unused) {
            return null;
        }
    }

    private SharedPreferences i() {
        Context f16 = f();
        if (f16 != null) {
            return f16.getSharedPreferences(SPKey.SP_NAME, 0);
        }
        return null;
    }

    public static void install(Context context) {
        Context context2;
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        if (context2 == null) {
            context2 = context;
        }
        if (context2 instanceof Application) {
            Application application = (Application) context2;
            getInstance().initContextRef(application);
            getInstance().c(application);
        } else {
            Logger.f365497g.e("RMonitor_launch_installer", "install fail for application context is null, context: " + context);
        }
        GcInfoStatHelper.getInstance().startGCStat("launch");
    }

    private void j(Application application) {
        if (AndroidVersion.isOverJellyBeanMr2()) {
            Class h16 = h();
            b(application, h16);
            a(application, h16);
            AppLaunchMonitor.getInstance().startOnApplicationOnCreate(application);
            return;
        }
        Logger.f365497g.i("RMonitor_launch_installer", "installAppLaunchMonitor fail for api level below JellyBeanMr2.");
    }

    private boolean k(String str) {
        boolean z16;
        Context f16 = f();
        if (f16 != null) {
            z16 = new File(f16.getFilesDir() + File.separator + str).exists();
        } else {
            z16 = false;
        }
        l("isFileExist", str, z16, f16);
        return z16;
    }

    private void l(String str, String str2, boolean z16, Context context) {
        String str3 = "null";
        if (!z16) {
            Logger logger = Logger.f365497g;
            String[] strArr = new String[8];
            strArr[0] = "RMonitor_launch_installer";
            strArr[1] = str;
            strArr[2] = ", fileName: ";
            strArr[3] = str2;
            strArr[4] = ", ret: ";
            strArr[5] = String.valueOf(z16);
            strArr[6] = ", context: ";
            if (context != null) {
                str3 = "not null";
            }
            strArr[7] = str3;
            logger.w(strArr);
            return;
        }
        Logger logger2 = Logger.f365497g;
        String[] strArr2 = new String[8];
        strArr2[0] = "RMonitor_launch_installer";
        strArr2[1] = str;
        strArr2[2] = ", fileName: ";
        strArr2[3] = str2;
        strArr2[4] = ", ret: ";
        strArr2[5] = String.valueOf(z16);
        strArr2[6] = ", context: ";
        if (context != null) {
            str3 = "not null";
        }
        strArr2[7] = str3;
        logger2.d(strArr2);
    }

    private void m() {
        if (isProtectCheckEnabled()) {
            ThreadManager.runInMainThread(new Runnable() { // from class: com.tencent.rmonitor.launch.AppLaunchInstallerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    AppLaunchInstallerImpl.this.setLauncherSafe(true);
                }
            }, 20000L);
        }
    }

    private void n(int i3) {
        SharedPreferences i16 = i();
        if (i16 != null) {
            i16.edit().putInt(SPKey.KEY_LAUNCHER_NOT_SAFE_COUNT, i3).commit();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean checkLastLauncherUnsafe() {
        boolean z16;
        ?? r06 = 1;
        try {
            if (isLauncherSafe()) {
                n(0);
                r06 = 0;
            } else {
                int g16 = g() + 1;
                if (g16 > 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                n(g16);
                r06 = z16;
            }
        } catch (Throwable th5) {
            Logger logger = Logger.f365497g;
            String[] strArr = new String[2];
            strArr[0] = "RMonitor_launch_installer";
            strArr[r06] = "isLastLaunchMonitorUnSafe, t: " + th5;
            logger.e(strArr);
        }
        return r06;
    }

    public void initContextRef(Context context) {
        if (context != null) {
            this.f365602a = new WeakReference<>(context);
        }
    }

    public boolean isLaunchMonitorEnabled() {
        return k("RMonitor_launch_monitor");
    }

    public boolean isLauncherSafe() {
        SharedPreferences i3 = i();
        if (i3 == null) {
            return false;
        }
        return i3.getBoolean(SPKey.KEY_LAUNCHER_IS_SAFE, false);
    }

    public boolean isProtectCheckEnabled() {
        return k("RMonitor_enable_protect");
    }

    public void setLaunchMonitorEnabled(boolean z16) {
        if (z16) {
            d("RMonitor_launch_monitor");
        } else {
            e("RMonitor_launch_monitor");
        }
    }

    public void setLauncherSafe(boolean z16) {
        SharedPreferences i3 = i();
        if (i3 != null) {
            i3.edit().putBoolean(SPKey.KEY_LAUNCHER_IS_SAFE, z16).commit();
        }
    }

    public void setProtectCheckEnabled(boolean z16) {
        if (z16) {
            d("RMonitor_enable_protect");
        } else {
            e("RMonitor_enable_protect");
        }
    }

    AppLaunchInstallerImpl() {
        this.f365602a = null;
    }
}
