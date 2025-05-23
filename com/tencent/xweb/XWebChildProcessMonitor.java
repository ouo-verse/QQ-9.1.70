package com.tencent.xweb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.luggage.wxa.wq.k;
import com.tencent.xweb.internal.ConstValue;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class XWebChildProcessMonitor {
    public static final String SP_KEY_CHILD_PROCESS_CRASH_COUNT_DAY = "SP_KEY_CHILD_PROCESS_CRASH_COUNT_";
    public static final String SP_KEY_CHILD_PROCESS_CRASH_KEY = "SP_KEY_CHILD_PROCESS_CRASH_KEY";
    public static final String SP_KEY_CHILD_PROCESS_CRASH_VERSION = "SP_KEY_CHILD_PROCESS_CRASH_VERSION_";
    public static final String SP_KEY_DISABLE_MULTI_PROCESS_STATE = "SP_KEY_DISABLE_MULTI_PROCESS_STATE";
    public static final String SP_KEY_LAST_DISABLE_START_TIME = "SP_KEY_LAST_DISABLE_START_TIME";
    public static final String SP_KEY_MAYBE_WXDK = "SP_KEY_MAYBE_WXDK";
    public static final String SP_KEY_SWITCH_TO_SYS = "SP_KEY_SWITCH_TO_SYS";

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f385020a;

    /* renamed from: b, reason: collision with root package name */
    public static String f385021b;

    public static void a() {
        Boolean bool = f385020a;
        if (bool == null || bool.booleanValue()) {
            return;
        }
        int e16 = e();
        int c16 = c();
        x0.d("XWebChildProcessMonitor", "checkSwitchToSysIfNeed, configCount:" + c16 + ", currentCount:" + e16);
        if (e16 > c16) {
            x0.f("XWebChildProcessMonitor", "checkSwitchToSysIfNeed, switch to sys");
            setShouldSwitchToSys(true, "DowngradeCrashCount");
        }
    }

    public static String b() {
        return SP_KEY_CHILD_PROCESS_CRASH_VERSION + XWalkEnvironment.getAvailableVersion();
    }

    public static int c() {
        return CommandCfg.getInstance().getCmdAsInt("child_process_crash_watch_count", "tools", 5);
    }

    public static synchronized boolean checkDisableMultiProcess() {
        Object valueOf;
        synchronized (XWebChildProcessMonitor.class) {
            if (f385020a != null) {
                x0.d("XWebChildProcessMonitor", "checkDisableMultiProcess, already checked:" + f385020a);
                return f385020a.booleanValue();
            }
            SharedPreferences m3 = y0.m();
            if (m3 != null) {
                if (m3.contains(SP_KEY_DISABLE_MULTI_PROCESS_STATE)) {
                    f385020a = Boolean.valueOf(m3.getBoolean(SP_KEY_DISABLE_MULTI_PROCESS_STATE, false));
                    x0.d("XWebChildProcessMonitor", "checkDisableMultiProcess, already checked in mm process:" + f385020a);
                    return f385020a.booleanValue();
                }
                if (maybeWxdk() && CommandCfg.getInstance().getWxdkDowngrade()) {
                    x0.f("XWebChildProcessMonitor", "checkDisableMultiProcess, maybe wxdk");
                    f385020a = Boolean.TRUE;
                    a(true);
                    return true;
                }
                if (h()) {
                    x0.f("XWebChildProcessMonitor", "checkDisableMultiProcess, has child process crash");
                    f385020a = Boolean.TRUE;
                    a(true);
                    return true;
                }
                int i3 = m3.getInt(f(), 0);
                long j3 = m3.getLong(SP_KEY_LAST_DISABLE_START_TIME, -1L);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("checkDisableMultiProcess, crash count:");
                sb5.append(i3);
                sb5.append(", lastDisableStartTime:");
                if (j3 > 0) {
                    valueOf = a(j3);
                } else {
                    valueOf = Long.valueOf(j3);
                }
                sb5.append(valueOf);
                x0.d("XWebChildProcessMonitor", sb5.toString());
                long currentTimeMillis = System.currentTimeMillis();
                if (j3 == -1) {
                    if (i3 > c()) {
                        x0.d("XWebChildProcessMonitor", "checkDisableMultiProcess, true for crash count:" + i3 + ", threshold crash count:" + c() + ", disable start time:" + a(currentTimeMillis));
                        m3.edit().putLong(SP_KEY_LAST_DISABLE_START_TIME, currentTimeMillis).apply();
                        f385020a = Boolean.TRUE;
                        a(true);
                        k.a(1, i3, c(), d(), "DowngradeCrashCount");
                        return true;
                    }
                } else {
                    if (currentTimeMillis - j3 > d()) {
                        x0.d("XWebChildProcessMonitor", "checkDisableMultiProcess, false for time out, threshold time:" + d());
                        m3.edit().remove(f()).apply();
                        m3.edit().remove(SP_KEY_LAST_DISABLE_START_TIME).apply();
                        f385020a = Boolean.FALSE;
                        a(false);
                        k.a(2, i3, c(), d(), "DowngradeCrashCount");
                        return false;
                    }
                    x0.d("XWebChildProcessMonitor", "checkDisableMultiProcess, true for time not up, threshold time:" + d());
                    f385020a = Boolean.TRUE;
                    a(true);
                    return true;
                }
            }
            x0.d("XWebChildProcessMonitor", "checkDisableMultiProcess, false");
            f385020a = Boolean.FALSE;
            a(false);
            return false;
        }
    }

    public static int d() {
        return CommandCfg.getInstance().getCmdAsInt("child_process_crash_watch_time", "tools", 1440) * 60 * 1000;
    }

    public static synchronized void decreaseCrashCount() {
        synchronized (XWebChildProcessMonitor.class) {
            SharedPreferences m3 = y0.m();
            if (m3 != null) {
                int max = Math.max(m3.getInt(f(), 0) - 1, 0);
                x0.d("XWebChildProcessMonitor", "decreaseCrashCount, new crash count:" + max);
                m3.edit().putInt(f(), max).apply();
            }
        }
    }

    public static int e() {
        SharedPreferences m3 = y0.m();
        if (m3 == null) {
            return 0;
        }
        return m3.getInt(f(), 0);
    }

    public static String f() {
        String str = f385021b;
        if (str != null) {
            return str;
        }
        f385021b = g();
        x0.d("XWebChildProcessMonitor", "getCrashCountKeyForToday, crashCountKeyForToday:" + f385021b);
        SharedPreferences m3 = y0.m();
        if (m3 != null) {
            for (String str2 : m3.getAll().keySet()) {
                if (str2.startsWith(SP_KEY_CHILD_PROCESS_CRASH_COUNT_DAY) && !f385021b.equals(str2)) {
                    m3.edit().remove(str2).apply();
                }
            }
        }
        return f385021b;
    }

    public static String g() {
        return SP_KEY_CHILD_PROCESS_CRASH_COUNT_DAY + new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
    }

    public static synchronized boolean getShouldSwitchToSys() {
        synchronized (XWebChildProcessMonitor.class) {
            SharedPreferences m3 = y0.m();
            if (!XWalkEnvironment.getPackageName().equalsIgnoreCase(XWalkEnvironment.getProcessName())) {
                return false;
            }
            return m3.getBoolean(SP_KEY_SWITCH_TO_SYS, false);
        }
    }

    public static boolean h() {
        SharedPreferences m3 = y0.m();
        if (m3 == null || !m3.contains(SP_KEY_CHILD_PROCESS_CRASH_KEY)) {
            return false;
        }
        String string = m3.getString(SP_KEY_CHILD_PROCESS_CRASH_KEY, "");
        String b16 = b();
        x0.f("XWebChildProcessMonitor", "hasChildProcessCrash, savedVersion:" + string + ", childProcessCrashVersion:" + b16);
        if (!string.equalsIgnoreCase(b16)) {
            return false;
        }
        return true;
    }

    public static synchronized void increaseCrashCount() {
        synchronized (XWebChildProcessMonitor.class) {
            SharedPreferences m3 = y0.m();
            if (m3 != null) {
                int i3 = m3.getInt(f(), 0) + 1;
                x0.d("XWebChildProcessMonitor", "increaseCrashCount, new crash count:" + i3);
                m3.edit().putInt(f(), i3).apply();
                a();
            }
        }
    }

    public static synchronized void init() {
        synchronized (XWebChildProcessMonitor.class) {
            SharedPreferences m3 = y0.m();
            if (m3 != null && p0.a()) {
                x0.d("XWebChildProcessMonitor", "init, remove disable multi process state & switch to sys flag");
                m3.edit().remove(SP_KEY_DISABLE_MULTI_PROCESS_STATE).apply();
                m3.edit().remove(SP_KEY_SWITCH_TO_SYS).apply();
            }
        }
    }

    public static boolean maybeWxdk() {
        SharedPreferences m3 = y0.m();
        if (m3 == null) {
            return false;
        }
        return m3.getBoolean(SP_KEY_MAYBE_WXDK, false);
    }

    public static void recordChildProcessCrash(String str) {
        SharedPreferences m3 = y0.m();
        if (m3 != null) {
            m3.edit().remove(SP_KEY_CHILD_PROCESS_CRASH_KEY).apply();
            String b16 = b();
            if (TextUtils.isEmpty(str)) {
                str = "DowngradeChildProcessCrash";
            }
            x0.f("XWebChildProcessMonitor", "recordChildProcessCrash, crashType:" + str + ", childProcessCrashVersion:" + b16);
            m3.edit().putString(SP_KEY_CHILD_PROCESS_CRASH_KEY, b16).apply();
            k.a(4, e(), c(), d(), str);
        }
    }

    public static synchronized void resetCrashCount() {
        synchronized (XWebChildProcessMonitor.class) {
            x0.d("XWebChildProcessMonitor", "resetCrashCount");
            SharedPreferences m3 = y0.m();
            if (m3 != null) {
                m3.edit().remove(f()).apply();
                m3.edit().remove(SP_KEY_LAST_DISABLE_START_TIME).apply();
                m3.edit().remove(SP_KEY_CHILD_PROCESS_CRASH_KEY).apply();
            }
        }
    }

    public static void setMaybeWxdk(boolean z16) {
        SharedPreferences m3 = y0.m();
        if (m3 != null) {
            x0.f("XWebChildProcessMonitor", "setMaybeWxdk, flag:" + z16);
            m3.edit().putBoolean(SP_KEY_MAYBE_WXDK, z16).apply();
            XWebSdk.appendAppInfo(ConstValue.APP_INFO_WXDK_USER);
        }
    }

    public static synchronized void setShouldSwitchToSys(boolean z16, String str) {
        synchronized (XWebChildProcessMonitor.class) {
            SharedPreferences m3 = y0.m();
            if (m3 != null) {
                m3.edit().putBoolean(SP_KEY_SWITCH_TO_SYS, z16).apply();
            }
            if (TextUtils.isEmpty(str)) {
                str = "DowngradeSys";
            }
            x0.f("XWebChildProcessMonitor", "setShouldSwitchToSys, flag:" + z16 + ", crashType:" + str);
            if (z16) {
                k.a(3, e(), c(), d(), str);
            }
        }
    }

    public static synchronized void a(boolean z16) {
        SharedPreferences m3;
        synchronized (XWebChildProcessMonitor.class) {
            if (XWalkEnvironment.getPackageName().equalsIgnoreCase(XWalkEnvironment.getProcessName()) && (m3 = y0.m()) != null) {
                x0.d("XWebChildProcessMonitor", "saveDisableMultiProcessStateIfNeed, value:" + z16);
                m3.edit().putBoolean(SP_KEY_DISABLE_MULTI_PROCESS_STATE, z16).apply();
            }
        }
    }

    public static String a(long j3) {
        return j3 <= 0 ? "0" : new Date(j3).toLocaleString();
    }
}
