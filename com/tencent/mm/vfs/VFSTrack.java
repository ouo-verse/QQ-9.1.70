package com.tencent.mm.vfs;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VFSTrack {
    public static final String CONFIGURE_PUBLISH = "configure_publish";
    public static final String CONSTRUCTOR_TIME = "constructor_time";
    public static final String INIT_HANDTHREAD = "init_handle_thread";
    public static final String INIT_TIME = "init_time";
    public static final String LOAD_BUNDLE = "load_bundle";
    public static final String MIGRATE_CONFIGUE_TIME_1 = "migrate_configure_time_bundle";
    public static final String MIGRATE_CONFIGUE_TIME_2 = "migrate_configure_time_update";
    private static final String TAG = "VFSTrack_Time";
    private static boolean TRACE = true;
    private static ConcurrentHashMap<String, Long> sLogs = new ConcurrentHashMap<>(new HashMap(6));

    public static void debugger(boolean z16) {
        TRACE = z16;
    }

    public static void track(String str, String str2) {
        Long remove;
        if (TRACE) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (str != null && (remove = sLogs.remove(str)) != null) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, str + ", cost=" + (elapsedRealtime - remove.longValue()));
                } else {
                    Log.i(TAG, str + ", cost=" + (elapsedRealtime - remove.longValue()));
                }
            }
            if (str2 != null) {
                sLogs.put(str2, Long.valueOf(elapsedRealtime));
            }
        }
    }
}
