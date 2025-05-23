package com.qzone.misc.network.ttt;

import common.config.service.QzoneConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Integer> f48554a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f48555b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static String f48556c = "";

    private static String a() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.TTT_REPORT_SETTING, QzoneConfig.TTT_REALTIME_REPORT_LIST, f48556c);
    }

    public static boolean b(int i3, int i16, int i17) {
        return c(i3, i16, i17);
    }

    private static synchronized boolean c(int i3, int i16, int i17) {
        String[] split;
        synchronized (f.class) {
            if (f48554a == null) {
                f48554a = new ConcurrentHashMap();
                String a16 = a();
                if (!a16.equals("") && (split = a16.split(",")) != null) {
                    for (String str : split) {
                        f48554a.put(str, Integer.valueOf(f48555b));
                    }
                }
            }
            if (f48554a == null) {
                return false;
            }
            String str2 = i17 + "-" + i3 + "-" + i16;
            if (f48554a.get(str2) != null) {
                if (f48554a.get(str2).intValue() == f48555b) {
                    return true;
                }
            }
            return false;
        }
    }
}
