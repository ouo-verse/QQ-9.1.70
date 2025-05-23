package com.tencent.luggage.wxa.ar;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.luggage.wxa.ar.a0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.CommandCfgPlugin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i0 {
    public static final long DAY_MILLS = 86400000;
    public static final long DEFAULT_EXPIRE_TIME = 18000000;
    public static final long EXPIRE_TIME_AFTER_SCHEDULE = 3600000;
    public static final long FETCH_CONFIG_PERIOD = 21600000;
    public static final long HOUR_MILLS = 3600000;
    public static final long MAX_FAILED_COUNT = 3;
    public static final long MINUTE_MILLS = 60000;
    public static final long RE_SCHEDULER_APPEND_TIME = 7200000;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f121663d = false;

    /* renamed from: a, reason: collision with root package name */
    public String f121664a = getScheduleType() + "Scheduler";

    /* renamed from: b, reason: collision with root package name */
    public boolean f121665b = false;

    /* renamed from: c, reason: collision with root package name */
    public j0 f121666c;

    public static boolean a(long j3) {
        return j3 >= 1800000 && j3 < 259200000;
    }

    public static long getFetchConfigPeriod() {
        long cmdAsInt = CommandCfg.getInstance().getCmdAsInt("force_cmd_period", "tools", 0) * 60000;
        if (a(cmdAsInt)) {
            return cmdAsInt;
        }
        long a16 = z0.a();
        if (a(a16)) {
            return a16;
        }
        long cmdFetchConfigPeriodMills = CommandCfg.getInstance().getCmdFetchConfigPeriodMills();
        if (a(cmdFetchConfigPeriodMills)) {
            return cmdFetchConfigPeriodMills;
        }
        return 21600000L;
    }

    public static double getRandomTime(double d16, double d17, double d18) {
        if (d16 <= d18 && d18 >= d17) {
            if (d17 >= d16) {
                d16 = d17;
            }
            return d16 + (Math.random() * (d18 - d16));
        }
        x0.c("Scheduler", "getRandomTime, currentHour is bigger than endHour");
        return 0.0d;
    }

    public static long getUpdateTimeFromVersion(i iVar, String str) {
        if (!TextUtils.isEmpty(iVar.f121651g)) {
            long b16 = b(iVar, str);
            x0.a(str, "has scheduler, schedule after " + ((b16 / 60) / 1000) + " minutes to update");
            return System.currentTimeMillis() + b16;
        }
        if (iVar.f121654j > 0) {
            long a16 = a(iVar, str);
            x0.a(str, "has period, schedule after " + ((a16 / 60) / 1000) + " minutes to update");
            return System.currentTimeMillis() + a16;
        }
        x0.a(str, "no schedule time, return 100");
        return 100L;
    }

    public static double getValidEndTime(double d16, double d17) {
        if (d17 < d16 || d17 < 0.0d || d17 > 32.0d) {
            return 24.0d;
        }
        return d17;
    }

    public static double getValidStartTime(double d16) {
        if (d16 < 0.0d || d16 > 24.0d) {
            return 0.0d;
        }
        return d16;
    }

    public static boolean isValidUpdateTimeZone(double d16, double d17) {
        if (d16 < 0.0d || d16 > 24.0d || d17 < 0.0d || d17 > 24.0d || d17 < d16) {
            return false;
        }
        return true;
    }

    public static void setForceCheckUpdate(boolean z16) {
        f121663d = z16;
    }

    public abstract String a(boolean z16);

    public void abandonCurrentScheduler() {
        x0.a(this.f121664a, "abandon current scheduler");
        saveSchedulerConfig(null);
    }

    public String b() {
        return CommandCfg.getInstance().getCmd("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
    }

    public List c() {
        ArrayList arrayList = new ArrayList();
        String d16 = d();
        if (TextUtils.isEmpty(d16)) {
            return arrayList;
        }
        String[] split = d16.split(";");
        if (split != null && split.length != 0) {
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    a b16 = b(str);
                    if (b16 == null) {
                        this.f121665b = true;
                    } else {
                        arrayList.add(b16);
                    }
                }
            }
            return arrayList;
        }
        this.f121665b = true;
        return arrayList;
    }

    public synchronized boolean checkNeedFetchConfig() {
        try {
            if (!b.b().equalsIgnoreCase(getCurSchedulerConfig().f121675c) && !TextUtils.isEmpty(getCurSchedulerConfig().f121675c) && !"true".equalsIgnoreCase(CommandCfgPlugin.getInstance().getCmd("disable_abi_switch_reset_config_time", "tools"))) {
                x0.a(this.f121664a, "checkNeedFetchConfig, disable_abi_switch_reset_config_time is true");
                return true;
            }
        } catch (Throwable th5) {
            x0.a(this.f121664a, "checkNeedFetchConfig, identify abi switch error", th5);
        }
        if (isInFreeFetchConfigTimeZone()) {
            x0.a(this.f121664a, "checkNeedFetchConfig, in FreeFetchConfigTimeZone");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (a(currentTimeMillis, getCurSchedulerConfig().f121674b)) {
            long j3 = y0.c(getScheduleType()).getLong("nLastFetchConfigTime", 0L);
            getCurSchedulerConfig().f121674b = j3;
            if (a(currentTimeMillis, j3)) {
                x0.a(this.f121664a, "checkNeedFetchConfig, need fetch config");
                return true;
            }
        }
        return false;
    }

    public final String d() {
        if (!TextUtils.isEmpty(getCurSchedulerConfig().B)) {
            return getCurSchedulerConfig().B;
        }
        return a();
    }

    public String dumpSchedule() {
        String str;
        String str2;
        if (hasScheduler()) {
            Date date = new Date(getCurSchedulerConfig().f121683k);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f121664a);
            sb5.append(": has scheduler for ver = ");
            sb5.append(getCurSchedulerConfig().f121684l);
            sb5.append(" version id = ");
            sb5.append(getCurSchedulerConfig().f121693u);
            sb5.append(" update time in ");
            sb5.append(date);
            String str3 = "";
            if (TextUtils.isEmpty(getCurSchedulerConfig().f121698z)) {
                str = "";
            } else {
                str = " update speed config:" + getCurSchedulerConfig().f121698z;
            }
            sb5.append(str);
            if (TextUtils.isEmpty(getCurSchedulerConfig().A)) {
                str2 = "";
            } else {
                str2 = " update forward speed config:" + getCurSchedulerConfig().A;
            }
            sb5.append(str2);
            if (!TextUtils.isEmpty(getCurSchedulerConfig().B)) {
                str3 = " update time range config:" + getCurSchedulerConfig().B;
            }
            sb5.append(str3);
            return sb5.toString();
        }
        return this.f121664a + ": has no scheduler";
    }

    public boolean e() {
        return false;
    }

    public double getCurHourSpeed(String str) {
        return getCurHourSpeed(str, a0.a());
    }

    public final String getCurHourSpeedConfig(boolean z16) {
        if (z16 && !TextUtils.isEmpty(getCurSchedulerConfig().A)) {
            return getCurSchedulerConfig().A;
        }
        if (!z16 && !TextUtils.isEmpty(getCurSchedulerConfig().f121698z)) {
            return getCurSchedulerConfig().f121698z;
        }
        return a(z16);
    }

    public double getCurHourUpdateTimeGapForwardMillis() {
        this.f121665b = false;
        return getCurHourSpeed(getCurHourSpeedConfig(true)) * 3600000.0d;
    }

    public double getCurHourUpdateTimeGapMillis() {
        this.f121665b = false;
        return getCurHourSpeed(getCurHourSpeedConfig(false)) * 3600000.0d;
    }

    public synchronized j0 getCurSchedulerConfig() {
        j0 j0Var = this.f121666c;
        if (j0Var != null) {
            return j0Var;
        }
        j0 j0Var2 = new j0();
        this.f121666c = j0Var2;
        j0Var2.f121673a = getScheduleType();
        SharedPreferences c16 = y0.c(getScheduleType());
        this.f121666c.f121674b = c16.getLong("nLastFetchConfigTime", 0L);
        this.f121666c.f121675c = c16.getString("strLastFetchAbi", "");
        if (!c16.contains("strUrl")) {
            return this.f121666c;
        }
        this.f121666c.f121676d = c16.getString("strMd5", "");
        this.f121666c.f121693u = c16.getInt("versionId", 0);
        this.f121666c.f121694v = c16.getFloat("timeHourStart", -1.0f);
        this.f121666c.f121695w = c16.getFloat("timeHourEnd", -1.0f);
        this.f121666c.f121680h = c16.getString("strUrl", "");
        this.f121666c.f121682j = c16.getString("strFullPackageUrl", "");
        this.f121666c.f121677e = c16.getString("strConfigVer", "");
        this.f121666c.f121678f = c16.getBoolean("bIsPatchUpdate", false);
        this.f121666c.f121683k = c16.getLong("nTimeToUpdate", 0L);
        this.f121666c.f121684l = c16.getInt("version", 0);
        this.f121666c.f121687o = c16.getInt("nTryCnt", 0);
        this.f121666c.f121679g = c16.getInt("nPatchTargetVersion", 0);
        this.f121666c.f121688p = c16.getInt("nTryUseSharedCoreCount", 0);
        this.f121666c.f121685m = c16.getString("patchMd5", "");
        this.f121666c.f121686n = c16.getString("strVersionDetail", "");
        this.f121666c.f121689q = c16.getBoolean("bCanUseCellular", false);
        this.f121666c.f121690r = c16.getBoolean("bUseCdn", false);
        this.f121666c.f121691s = c16.getBoolean("bTryUseSharedCore", true);
        this.f121666c.f121696x = c16.getBoolean("skipSubFileMD5Check", true);
        this.f121666c.f121692t = c16.getString("strAbi", "");
        this.f121666c.f121697y = c16.getString("path", "");
        this.f121666c.f121698z = c16.getString("UPDATE_SPEED_CONFIG", "");
        this.f121666c.A = c16.getString("UPDATE_FORWARD_SPEED_CONFIG", "");
        this.f121666c.B = c16.getString("UPDATE_SCHEDULE_TIME_RANGE_BIND", "");
        this.f121666c.C = c16.getInt("nPatchType", 1);
        return this.f121666c;
    }

    public int getIdkeyOffsetFromDefault() {
        return 0;
    }

    public abstract String getScheduleType();

    public synchronized boolean hasScheduler() {
        boolean z16;
        if (getCurSchedulerConfig() != null && getCurSchedulerConfig().f121684l > 0) {
            if (!TextUtils.isEmpty(getCurSchedulerConfig().f121680h)) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    public boolean isInFreeFetchConfigTimeZone() {
        k0 a16;
        String[] a17 = a(b());
        if (a17 != null && a17.length != 0) {
            double a18 = a0.a();
            for (String str : a17) {
                if (!TextUtils.isEmpty(str) && (a16 = k0.a(str)) != null && a18 >= a16.f121704a && a18 <= a16.f121705b) {
                    if (v0.d() >= a16.f121706c * 10000.0d) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInFreeUpdateTimeZone() {
        String[] split;
        String cmd = CommandCfg.getInstance().getCmd("free_update_time_zone", "tools");
        if (TextUtils.isEmpty(cmd) || !cmd.contains("-") || (split = cmd.split("-")) == null || split.length != 2) {
            return false;
        }
        a0.a b16 = a0.b(split[0]);
        if (!b16.f121611a) {
            return false;
        }
        a0.a b17 = a0.b(split[1]);
        if (!b17.f121611a || !isValidUpdateTimeZone(b16.a(), b17.a())) {
            return false;
        }
        double a16 = a0.a();
        if (a16 < b16.a() || a16 > b17.a()) {
            return false;
        }
        return true;
    }

    public synchronized boolean isTimeToUpdate(boolean z16) {
        return isTimeToUpdate(z16, 0);
    }

    public void onStartFetchConfig() {
        getCurSchedulerConfig().f121674b = System.currentTimeMillis();
        getCurSchedulerConfig().f121675c = b.b();
        SharedPreferences.Editor edit = y0.c(getScheduleType()).edit();
        edit.putLong("nLastFetchConfigTime", getCurSchedulerConfig().f121674b);
        edit.putString("strLastFetchAbi", getCurSchedulerConfig().f121675c);
        edit.commit();
    }

    public void onUpdateFailed(int i3) {
        if (i3 == -10) {
            SharedPreferences c16 = y0.c(getScheduleType());
            int i16 = c16.getInt("nTryUseSharedCoreCount", 0);
            x0.a(this.f121664a, "onUpdateFailed, shared mode, current nTryUseSharedCoreCount:" + i16);
            int i17 = i16 + 1;
            getCurSchedulerConfig().f121688p = i17;
            SharedPreferences.Editor edit = c16.edit();
            edit.putInt("nTryUseSharedCoreCount", i17);
            a(edit, i17);
            edit.commit();
            return;
        }
        if (!z.a()) {
            x0.f(this.f121664a, "onUpdateFailed, network not available");
            return;
        }
        SharedPreferences c17 = y0.c(getScheduleType());
        int i18 = c17.getInt("nTryCnt", 0) + 1;
        if (i3 != -3 && i3 != -4) {
            if (i3 <= -2 && i3 >= -5) {
                i18 = (int) (i18 + 3);
            }
        } else {
            getCurSchedulerConfig().f121678f = false;
            getCurSchedulerConfig().f121680h = getCurSchedulerConfig().f121682j;
            getCurSchedulerConfig().f121689q = false;
            saveSchedulerConfig(getCurSchedulerConfig());
            x0.a(this.f121664a, "onUpdateFailed, switch to full package update");
        }
        if (i18 > 3) {
            x0.a(this.f121664a, "onUpdateFailed, failed too many times, abandon current scheduler");
            abandonCurrentScheduler();
            return;
        }
        getCurSchedulerConfig().f121687o = i18;
        SharedPreferences.Editor edit2 = c17.edit();
        edit2.putInt("nTryCnt", i18);
        a(edit2, i18);
        edit2.commit();
    }

    public j0 onUpdateScheduleConfig(j0 j0Var) {
        boolean z16;
        j0 curSchedulerConfig = getCurSchedulerConfig();
        if (j0Var == null) {
            x0.a(this.f121664a, "onUpdateScheduleConfig, got no schedule need download");
            if (hasScheduler()) {
                if (curSchedulerConfig != null) {
                    x0.a(this.f121664a, "onUpdateScheduleConfig, clear current scheduler, version:" + curSchedulerConfig.f121684l);
                }
                saveSchedulerConfig(null);
            }
            return null;
        }
        if (a(j0Var, curSchedulerConfig)) {
            boolean z17 = true;
            if (!a(j0Var.f121698z, curSchedulerConfig.f121698z)) {
                x0.a(this.f121664a, "onUpdateScheduleConfig, update UPDATE_SPEED_CONFIG");
                curSchedulerConfig.f121698z = j0Var.f121698z;
                z16 = true;
            } else {
                z16 = false;
            }
            if (!a(j0Var.A, curSchedulerConfig.A)) {
                x0.a(this.f121664a, "onUpdateScheduleConfig, update UPDATE_FORWARD_SPEED_CONFIG");
                curSchedulerConfig.A = j0Var.A;
                z16 = true;
            }
            if (!a(j0Var.B, curSchedulerConfig.B)) {
                x0.a(this.f121664a, "onUpdateScheduleConfig, update UPDATE_SCHEDULE_TIME_RANGE_BIND");
                curSchedulerConfig.B = j0Var.B;
            } else {
                z17 = z16;
            }
            if (z17) {
                saveSchedulerConfig(curSchedulerConfig);
            }
            x0.a(this.f121664a, "onUpdateScheduleConfig, got same scheduler, use current version");
            return curSchedulerConfig;
        }
        if (hasScheduler()) {
            n0.a(903L, 149L, 1L);
            x0.a(this.f121664a, "onUpdateScheduleConfig, got newer scheduler, version: " + j0Var.f121684l);
        }
        saveSchedulerConfig(j0Var);
        return j0Var;
    }

    public void rescheduleToNextDay() {
        long j3;
        double a16 = a0.a();
        if (a16 >= getCurSchedulerConfig().f121694v && a16 >= 6.0d) {
            j3 = a0.b();
        } else {
            x0.a(this.f121664a, "rescheduleToNextDay, currentHour:" + a16 + ", so still schedule in today");
            j3 = -((long) (a16 * 3600000.0d));
        }
        long randomTime = (long) (j3 + (getRandomTime(0.0d, getValidStartTime(getCurSchedulerConfig().f121694v), getValidEndTime(getCurSchedulerConfig().f121694v, getCurSchedulerConfig().f121695w)) * 3600000.0d));
        getCurSchedulerConfig().f121683k = System.currentTimeMillis() + randomTime;
        saveSchedulerConfig(getCurSchedulerConfig());
        x0.a(this.f121664a, "rescheduleToNextDay, " + (randomTime / 60000) + " minutes later");
    }

    public synchronized void resetLastFetchConfigTime() {
        SharedPreferences.Editor edit = y0.c(getScheduleType()).edit();
        edit.putLong("nLastFetchConfigTime", 0L);
        edit.commit();
        getCurSchedulerConfig().f121674b = 0L;
    }

    public synchronized void resetLastUpdateTime() {
        SharedPreferences.Editor edit = y0.c(getScheduleType()).edit();
        edit.putLong("nLastFetchConfigTime", 0L);
        edit.commit();
        getCurSchedulerConfig().f121674b = 0L;
        getCurSchedulerConfig().f121683k = 0L;
    }

    public synchronized void saveSchedulerConfig(j0 j0Var) {
        this.f121666c = j0Var;
        if (j0Var == null) {
            this.f121666c = new j0();
        }
        this.f121666c.f121673a = getScheduleType();
        SharedPreferences.Editor edit = y0.c(getScheduleType()).edit();
        edit.putString("strMd5", this.f121666c.f121676d);
        edit.putString("strUrl", this.f121666c.f121680h);
        edit.putString("strFullPackageUrl", this.f121666c.f121682j);
        edit.putString("strConfigVer", this.f121666c.f121677e);
        edit.putBoolean("bIsPatchUpdate", this.f121666c.f121678f);
        edit.putBoolean("bCanUseCellular", this.f121666c.f121689q);
        edit.putBoolean("bUseCdn", this.f121666c.f121690r);
        edit.putLong("nTimeToUpdate", this.f121666c.f121683k);
        edit.putInt("version", this.f121666c.f121684l);
        edit.putInt("nTryCnt", this.f121666c.f121687o);
        edit.putInt("nPatchTargetVersion", this.f121666c.f121679g);
        edit.putInt("nTryUseSharedCoreCount", this.f121666c.f121688p);
        edit.putString("patchMd5", this.f121666c.f121685m);
        edit.putString("strVersionDetail", this.f121666c.f121686n);
        edit.putBoolean("bTryUseSharedCore", this.f121666c.f121691s);
        edit.putBoolean("skipSubFileMD5Check", this.f121666c.f121696x);
        edit.putString("strAbi", this.f121666c.f121692t);
        edit.putString("path", this.f121666c.f121697y);
        edit.putInt("versionId", this.f121666c.f121693u);
        edit.putFloat("timeHourStart", this.f121666c.f121694v);
        edit.putFloat("timeHourEnd", this.f121666c.f121695w);
        edit.putString("UPDATE_SPEED_CONFIG", this.f121666c.f121698z);
        edit.putString("UPDATE_FORWARD_SPEED_CONFIG", this.f121666c.A);
        edit.putString("UPDATE_SCHEDULE_TIME_RANGE_BIND", this.f121666c.B);
        edit.putInt("nPatchType", this.f121666c.C);
        edit.commit();
    }

    public static a b(String str) {
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.trim().replace("=>", "_").split("_");
        if (split != null && split.length == 2) {
            k0 a16 = k0.a(split[0]);
            aVar.f121667a = a16;
            if (a16 == null) {
                x0.c("Scheduler", "parse rangeFrom failed");
                return null;
            }
            k0 a17 = k0.a(split[1]);
            aVar.f121668b = a17;
            if (a17 != null) {
                return aVar;
            }
            x0.c("Scheduler", "parse rangeTo failed");
            return null;
        }
        x0.c("Scheduler", "strRanges error");
        return null;
    }

    public final synchronized void a(SharedPreferences.Editor editor, int i3) {
        long j3 = i3 * 7200000;
        editor.putLong("nTimeToUpdate", System.currentTimeMillis() + j3);
        x0.a(this.f121664a, "resetNextUpdateTime, update after " + (j3 / 60000) + " minutes");
    }

    public double getCurHourSpeed(String str, double d16) {
        k0 a16;
        if (TextUtils.isEmpty(str)) {
            return 1.0d;
        }
        String[] a17 = a(str);
        if (a17 != null && a17.length != 0) {
            for (String str2 : a17) {
                if (!TextUtils.isEmpty(str2) && (a16 = k0.a(str2)) != null && d16 >= a16.f121704a && d16 <= a16.f121705b) {
                    return a16.a(d16);
                }
            }
            return 1.0d;
        }
        this.f121665b = true;
        return 1.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0104 A[Catch: all -> 0x020f, TryCatch #0 {, blocks: (B:6:0x0009, B:10:0x0013, B:12:0x0019, B:15:0x0023, B:17:0x002a, B:20:0x0030, B:22:0x003c, B:23:0x0052, B:25:0x005a, B:26:0x0072, B:32:0x0082, B:33:0x00ac, B:36:0x00e9, B:41:0x00f8, B:46:0x0104, B:48:0x015f, B:50:0x0165, B:53:0x017e, B:55:0x0184, B:59:0x01a3, B:61:0x01a9, B:65:0x01bc, B:67:0x01d1, B:70:0x01eb, B:72:0x010f, B:76:0x012e, B:80:0x0144, B:87:0x01f6), top: B:4:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0165 A[Catch: all -> 0x020f, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0009, B:10:0x0013, B:12:0x0019, B:15:0x0023, B:17:0x002a, B:20:0x0030, B:22:0x003c, B:23:0x0052, B:25:0x005a, B:26:0x0072, B:32:0x0082, B:33:0x00ac, B:36:0x00e9, B:41:0x00f8, B:46:0x0104, B:48:0x015f, B:50:0x0165, B:53:0x017e, B:55:0x0184, B:59:0x01a3, B:61:0x01a9, B:65:0x01bc, B:67:0x01d1, B:70:0x01eb, B:72:0x010f, B:76:0x012e, B:80:0x0144, B:87:0x01f6), top: B:4:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017e A[Catch: all -> 0x020f, TRY_ENTER, TryCatch #0 {, blocks: (B:6:0x0009, B:10:0x0013, B:12:0x0019, B:15:0x0023, B:17:0x002a, B:20:0x0030, B:22:0x003c, B:23:0x0052, B:25:0x005a, B:26:0x0072, B:32:0x0082, B:33:0x00ac, B:36:0x00e9, B:41:0x00f8, B:46:0x0104, B:48:0x015f, B:50:0x0165, B:53:0x017e, B:55:0x0184, B:59:0x01a3, B:61:0x01a9, B:65:0x01bc, B:67:0x01d1, B:70:0x01eb, B:72:0x010f, B:76:0x012e, B:80:0x0144, B:87:0x01f6), top: B:4:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isTimeToUpdate(boolean z16, int i3) {
        long j3;
        boolean z17;
        boolean z18;
        if (i3 > 2) {
            x0.a(this.f121664a, "isTimeToUpdate, abort because depth > 2");
            return false;
        }
        if (!hasScheduler()) {
            x0.a(this.f121664a, "isTimeToUpdate, abort because no scheduler");
            return false;
        }
        if (!e() && !f121663d) {
            long currentTimeMillis = System.currentTimeMillis();
            double curHourUpdateTimeGapMillis = getCurHourUpdateTimeGapMillis();
            if (this.f121665b) {
                x0.a(this.f121664a, "isTimeToUpdate, parse update speed failed");
                n0.a(903L, getIdkeyOffsetFromDefault() + 163, 1L);
            }
            double curHourUpdateTimeGapForwardMillis = getCurHourUpdateTimeGapForwardMillis();
            if (this.f121665b) {
                x0.a(this.f121664a, "isTimeToUpdate, parse update forward speed failed");
                n0.a(903L, getIdkeyOffsetFromDefault() + 163, 1L);
            }
            long j16 = getCurSchedulerConfig().f121683k;
            if (j16 > 1000) {
                j3 = j16;
                z17 = true;
            } else {
                if (!z16) {
                    return true;
                }
                long random = currentTimeMillis - ((long) (Math.random() * 3600000.0d));
                x0.a(this.f121664a, "no scheduled time, just random a time in one hour");
                n0.a(903L, getIdkeyOffsetFromDefault() + 155, 1L);
                j3 = random;
                z17 = false;
            }
            x0.a(this.f121664a, "scheduled time is after " + ((j3 - currentTimeMillis) / 60000) + " minutes later");
            long j17 = currentTimeMillis - j3;
            long b16 = a0.b();
            long j18 = b16 + currentTimeMillis;
            boolean z19 = j3 - 180000 < j18 - 86400000;
            boolean z26 = j3 + 180000 > j18;
            if (b16 >= 180000 && b16 + 180000 <= 86400000) {
                z18 = false;
                if (z17) {
                    x0.d(this.f121664a, "no scheduled time, ignore dangers time");
                } else {
                    if (z19) {
                        x0.a(this.f121664a, "isPastDaySchedule need reschedule to next day");
                        rescheduleToNextDay();
                        n0.a(903L, 146L, 1L);
                        return isTimeToUpdate(false, i3 + 1);
                    }
                    if (z26) {
                        x0.a(this.f121664a, "isFutureDaySchedule no need download now");
                        n0.a(903L, 147L, 1L);
                        return false;
                    }
                    if (z18) {
                        x0.a(this.f121664a, "dangerous time do not update");
                        n0.a(903L, 148L, 1L);
                        return false;
                    }
                }
                long j19 = j3;
                if (!a(curHourUpdateTimeGapMillis, curHourUpdateTimeGapForwardMillis, j17)) {
                    x0.a(this.f121664a, "time to update");
                    n0.a(903L, getIdkeyOffsetFromDefault() + 152, 1L);
                    return true;
                }
                if (isInFreeUpdateTimeZone()) {
                    x0.a(this.f121664a, "time to update because in free update time zone");
                    n0.a(903L, getIdkeyOffsetFromDefault() + 153, 1L);
                    return true;
                }
                if (a(j19, curHourUpdateTimeGapMillis / 1.8E7d)) {
                    n0.a(903L, getIdkeyOffsetFromDefault() + 162, 1L);
                    return true;
                }
                if (z17 && Math.abs(currentTimeMillis - getCurSchedulerConfig().f121683k) > 7776000000L) {
                    x0.a(this.f121664a, "has scheduler waiting for update, but time has passed");
                    rescheduleToNextDay();
                    n0.a(903L, getIdkeyOffsetFromDefault() + 156, 1L);
                } else {
                    x0.a(this.f121664a, "has scheduler waiting for update, but time is not up");
                }
                return false;
            }
            z18 = true;
            if (z17) {
            }
            long j192 = j3;
            if (!a(curHourUpdateTimeGapMillis, curHourUpdateTimeGapForwardMillis, j17)) {
            }
        }
        x0.a(this.f121664a, "isTimeToUpdate, force update");
        n0.a(903L, getIdkeyOffsetFromDefault() + 157, 1L);
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public k0 f121667a = new k0();

        /* renamed from: b, reason: collision with root package name */
        public k0 f121668b = new k0();

        public boolean a(double d16, double d17, double d18) {
            k0 k0Var = this.f121667a;
            if (d17 > k0Var.f121705b || d17 < k0Var.f121704a) {
                return false;
            }
            k0 k0Var2 = this.f121668b;
            return d16 <= k0Var2.f121705b && d16 >= k0Var2.f121704a && ((double) v0.a("DOWNLOAD_SCHEDULE")) <= (b(d16, d17) * 10000.0d) * d18;
        }

        public double b(double d16, double d17) {
            return this.f121667a.a(d17) * this.f121668b.a(d16);
        }

        public String a(double d16, double d17) {
            return "[ " + this.f121667a.f121704a + "," + this.f121667a.f121705b + "] => [" + this.f121668b.f121704a + "," + this.f121668b.f121705b + "], scale=" + b(d16, d17);
        }
    }

    public boolean a(j0 j0Var, j0 j0Var2) {
        if (j0Var.f121684l == j0Var2.f121684l && j0Var.f121689q == j0Var2.f121689q && j0Var.f121690r == j0Var2.f121690r && j0Var.f121678f == j0Var2.f121678f && j0Var.f121693u == j0Var2.f121693u && a(j0Var.f121676d, j0Var2.f121676d) && a(j0Var.f121682j, j0Var2.f121682j) && a(j0Var.f121692t, j0Var2.f121692t) && j0Var.C == j0Var2.C) {
            return !j0Var.f121678f || a(j0Var.f121685m, j0Var2.f121685m);
        }
        return false;
    }

    public final boolean a(double d16, double d17, long j3) {
        boolean z16;
        boolean z17 = true;
        boolean z18 = false;
        if (j3 < 0 || j3 > 3600000) {
            z16 = false;
        } else {
            n0.a(903L, getIdkeyOffsetFromDefault() + 154, 1L);
            z16 = true;
        }
        if (j3 >= 0 && j3 < d16) {
            z18 = true;
        }
        if (j3 >= 0 || (-j3) >= d17) {
            z17 = z18;
        } else {
            n0.a(903L, getIdkeyOffsetFromDefault() + 161, 1L);
        }
        if (z16 && !z17) {
            n0.a(903L, getIdkeyOffsetFromDefault() + 150, 1L);
        }
        if (!z16 && z17) {
            n0.a(903L, getIdkeyOffsetFromDefault() + 151, 1L);
        }
        x0.a(this.f121664a, "shouldUpdateDefault = " + z16 + ", shouldUpdateFromConfig = " + z17);
        return z17;
    }

    public static long b(i iVar, String str) {
        int[] a16 = iVar.a();
        if (a16 != null && a16.length != 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_8);
            Date date = new Date();
            try {
                if (!TextUtils.isEmpty(iVar.f121652h)) {
                    date = simpleDateFormat.parse(iVar.f121652h);
                }
            } catch (Throwable th5) {
                x0.a(str, "getUpdateTimeFromSchedules error", th5);
                n0.a(903L, 158L, 1L);
            }
            double time = (new Date().getTime() - date.getTime()) / 8.64E7d;
            int i3 = (int) time;
            if (time < 0.0d) {
                i3--;
            }
            int i16 = 0;
            if (Math.abs(time) > 365.0d) {
                i3 = 0;
            }
            l lVar = iVar.f121647c;
            int i17 = lVar.f121720m;
            int i18 = 10000;
            if (i17 <= 0 || i17 > 10000) {
                i17 = 0;
            }
            int i19 = lVar.f121721n;
            if (i19 > 0 && i19 <= 10000) {
                i18 = i19;
            }
            double b16 = ((v0.b() - i17) * 10000.0d) / ((i18 - i17) + 1);
            while (i16 < a16.length && b16 > a16[i16]) {
                i16++;
            }
            double a17 = a0.a();
            double validStartTime = getValidStartTime(iVar.f121649e);
            double validEndTime = getValidEndTime(iVar.f121649e, iVar.f121650f);
            int i26 = i16 - i3;
            x0.d(str, "getUpdateTimeFromSchedules, releaseDate:" + date + ", currentGrayValue:" + b16 + ", dayToUpdate:" + i26);
            if (i26 <= 0) {
                if (iVar.f121658n && a17 > validStartTime) {
                    x0.d(str, "low priority version, schedule to next day to update");
                } else if (a17 >= validEndTime) {
                    x0.d(str, "end hour passed, schedule to next day to update");
                } else {
                    double randomTime = getRandomTime(a17, validStartTime, validEndTime);
                    x0.d(str, "update today, schedule hour:" + randomTime);
                    return (long) ((randomTime - a17) * 3600000.0d);
                }
                i26 = 1;
            }
            double randomTime2 = getRandomTime(0.0d, validStartTime, validEndTime);
            x0.d(str, "getUpdateTimeFromSchedules, schedule hour:" + randomTime2);
            return (long) ((randomTime2 * 3600000.0d) + ((i26 - 1) * 86400000) + a0.b());
        }
        x0.d(str, "getUpdateTimeFromSchedules, invalid schedules");
        return 0L;
    }

    public static String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(";");
    }

    public boolean a(long j3, long j16) {
        long fetchConfigPeriod = getFetchConfigPeriod();
        if (j3 > j16 + fetchConfigPeriod || j3 + fetchConfigPeriod < j16) {
            return true;
        }
        x0.a(this.f121664a, "checkNeedFetchConfig, no need");
        return false;
    }

    public String a() {
        return CommandCfg.getInstance().getCmd("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
    }

    public boolean a(long j3, double d16) {
        return a(a0.a(), a0.a(j3), d16);
    }

    public boolean a(double d16, double d17, double d18) {
        this.f121665b = false;
        List<a> c16 = c();
        if (this.f121665b) {
            x0.a(this.f121664a, "isMatchTimeRangeBind, parse range schedule config failed");
            n0.a(903L, getIdkeyOffsetFromDefault() + 163, 1L);
        }
        for (a aVar : c16) {
            if (aVar.a(d16, d17, d18)) {
                x0.a(this.f121664a, "isMatchTimeRangeBind, matched time range zone, currentHour:" + d16 + " scheduleHour:" + d17 + ", timeRange:" + aVar.a(d16, d17));
                return true;
            }
        }
        return false;
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        if (str == null) {
            return str == str2;
        }
        return str.equals(str2);
    }

    public static long a(i iVar, String str) {
        if (0 == iVar.f121654j * 60 * 1000) {
            x0.f(str, "getUpdateTimeFromPeriod, invalid period");
            return 0L;
        }
        l lVar = iVar.f121647c;
        int i3 = lVar.f121720m;
        int i16 = 10000;
        if (i3 <= 0 || i3 > 10000) {
            i3 = 0;
        }
        int i17 = lVar.f121721n;
        if (i17 > 0 && i17 <= 10000) {
            i16 = i17;
        }
        int i18 = (i16 - i3) + 1;
        if (i18 <= 0) {
            i18 = 1;
        }
        double d16 = i18;
        double b16 = ((v0.b() - i3) * r0) / d16;
        return (long) (b16 + (Math.random() * (((r0 * ((v0.b() + 1) - i3)) / d16) - b16)));
    }
}
