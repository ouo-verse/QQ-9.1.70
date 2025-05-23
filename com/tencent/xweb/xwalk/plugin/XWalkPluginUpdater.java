package com.tencent.xweb.xwalk.plugin;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.luggage.wxa.ar.z0;
import com.tencent.luggage.wxa.yq.u;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class XWalkPluginUpdater implements u.b {
    public static final int UPDATE_BIZ_TYPE_PLUGIN_PACKAGE = 1;
    public static final int UPDATE_BIZ_TYPE_PLUGIN_PATCH = 2;

    /* renamed from: a, reason: collision with root package name */
    public String f385155a = "";

    /* renamed from: b, reason: collision with root package name */
    public XWalkPluginUpdateListener f385156b = null;

    /* renamed from: c, reason: collision with root package name */
    public XWalkPluginUpdaterChecker f385157c = null;

    public static boolean a() {
        for (XWalkPlugin xWalkPlugin : XWalkPluginManager.getAllPlugins()) {
            if (xWalkPlugin != null && XFileSchedulerFactory.getScheduler(xWalkPlugin.getPluginName()).isTimeToUpdate(false)) {
                return true;
            }
        }
        return false;
    }

    public static long getLastCheckPluginUpdateTime() {
        SharedPreferences n3 = y0.n();
        if (n3 == null) {
            x0.a("XWalkPluginUpdater", "get time sp is null");
            return 0L;
        }
        return n3.getLong("nLastFetchPluginConfigTime", 0L);
    }

    public static boolean isNeedCheckPluginUpdate() {
        if (a()) {
            x0.a("XWalkPluginUpdater", "has plugin need update, fetch plugin config first");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long lastCheckPluginUpdateTime = getLastCheckPluginUpdateTime();
        if (currentTimeMillis - lastCheckPluginUpdateTime >= z0.e() || currentTimeMillis < lastCheckPluginUpdateTime) {
            return true;
        }
        return false;
    }

    public static boolean isPluginUpdatingByOtherProcess() {
        int i3;
        List<ActivityManager.RunningAppProcessInfo> list;
        SharedPreferences n3 = y0.n();
        if (n3 == null || (i3 = n3.getInt("nUpdatingProcessId", -1)) < 0) {
            return false;
        }
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        if (i3 == myPid) {
            x0.a("XWalkPluginUpdater", "current process is updating plugin");
            return true;
        }
        try {
            list = SystemMethodProxy.getRunningAppProcesses((ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        } catch (Throwable th5) {
            x0.c("XWalkPluginUpdater", th5.getMessage());
            list = null;
        }
        if (list != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == i3) {
                    if (next.uid == myUid) {
                        x0.a("XWalkPluginUpdater", "other process is in updating plugin progress");
                        return true;
                    }
                }
            }
        }
        x0.a("XWalkPluginUpdater", "plugin update process pid invalid, clear");
        markPluginUpdateFinishedInProcess();
        return false;
    }

    public static void markPluginUpdateFinishedInProcess() {
        SharedPreferences n3 = y0.n();
        if (n3 == null) {
            return;
        }
        SharedPreferences.Editor edit = n3.edit();
        edit.remove("nUpdatingProcessId");
        edit.commit();
        x0.a("XWalkPluginUpdater", "plugin update progress finish");
    }

    public static void markPluginUpdateStartedInProcess() {
        SharedPreferences n3 = y0.n();
        if (n3 == null) {
            return;
        }
        int myPid = Process.myPid();
        SharedPreferences.Editor edit = n3.edit();
        edit.putInt("nUpdatingProcessId", myPid);
        edit.commit();
        x0.a("XWalkPluginUpdater", "plugin update progress start pid " + myPid);
    }

    public static void setLastCheckPluginUpdateTime(long j3) {
        SharedPreferences n3 = y0.n();
        if (n3 == null) {
            x0.a("XWalkPluginUpdater", "set time sp is null");
            return;
        }
        SharedPreferences.Editor edit = n3.edit();
        edit.putLong("nLastFetchPluginConfigTime", j3);
        edit.commit();
    }

    @Override // com.tencent.luggage.wxa.yq.u.b
    public void cancelPluginUpdate() {
        XWalkPluginUpdaterChecker xWalkPluginUpdaterChecker = this.f385157c;
        if (xWalkPluginUpdaterChecker != null) {
            xWalkPluginUpdaterChecker.tryCancelUpdate();
        }
    }

    @Override // com.tencent.luggage.wxa.yq.u.c
    public boolean isBusyUpdate() {
        XWalkPluginUpdaterChecker xWalkPluginUpdaterChecker = this.f385157c;
        if (xWalkPluginUpdaterChecker != null) {
            return xWalkPluginUpdaterChecker.isBusy();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.yq.u.c
    public boolean needCheckUpdate() {
        return isNeedCheckPluginUpdate();
    }

    @Override // com.tencent.luggage.wxa.yq.u.b
    public void setPluginOnlyOneToUpdate(String str, XWalkPluginUpdateListener xWalkPluginUpdateListener) {
        this.f385155a = str;
        this.f385156b = xWalkPluginUpdateListener;
    }

    @Override // com.tencent.luggage.wxa.yq.u.c
    public void startCheck(Context context, HashMap<String, String> hashMap) {
        synchronized (this) {
            XWalkPluginUpdaterChecker xWalkPluginUpdaterChecker = new XWalkPluginUpdaterChecker();
            this.f385157c = xWalkPluginUpdaterChecker;
            xWalkPluginUpdaterChecker.setParams(hashMap, this.f385155a, this.f385156b);
            this.f385157c.execute(new String[0]);
            this.f385155a = "";
            this.f385156b = null;
        }
    }
}
