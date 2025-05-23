package com.tencent.luggage.wxa.yq;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Iterator;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f146134a = false;

    /* renamed from: b, reason: collision with root package name */
    public static long f146135b;

    public static synchronized void a() {
        synchronized (t.class) {
            if (!f146134a) {
                x0.a("XWebUpdateLocker", "updating progress not started");
                return;
            }
            f146134a = false;
            f146135b = System.currentTimeMillis();
            SharedPreferences.Editor edit = y0.i().edit();
            edit.remove("UpdatingProcessId");
            edit.commit();
            x0.a("XWebUpdateLocker", "finish updating progress");
        }
    }

    public static long b() {
        return f146135b;
    }

    public static synchronized boolean c() {
        synchronized (t.class) {
            if (f146134a) {
                x0.a("XWebUpdateLocker", "already in updating progress");
                return true;
            }
            SharedPreferences i3 = y0.i();
            int i16 = i3.getInt("UpdatingProcessId", -1);
            if (i16 == Process.myPid()) {
                x0.a("XWebUpdateLocker", "current process(" + i16 + ") is in updating progress");
                return true;
            }
            if (i16 < 0) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) XWalkEnvironment.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null && SystemMethodProxy.getRunningAppProcesses(activityManager) != null) {
                int myUid = Process.myUid();
                Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses(activityManager).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == i16) {
                        if (next.uid == myUid) {
                            x0.a("XWebUpdateLocker", "other process(" + i16 + ") is in updating progress");
                            return true;
                        }
                    }
                }
                SharedPreferences.Editor edit = i3.edit();
                edit.remove("UpdatingProcessId");
                edit.commit();
                return false;
            }
            return false;
        }
    }

    public static synchronized boolean d() {
        synchronized (t.class) {
            if (c()) {
                x0.a("XWebUpdateLocker", "already in updating progress");
                return false;
            }
            f146134a = true;
            int myPid = Process.myPid();
            SharedPreferences.Editor edit = y0.i().edit();
            edit.putInt("UpdatingProcessId", myPid);
            edit.putLong("Start_Time", System.currentTimeMillis());
            edit.commit();
            x0.a("XWebUpdateLocker", "start updating progress");
            return true;
        }
    }
}
