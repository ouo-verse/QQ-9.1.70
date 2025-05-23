package c.t.m.g;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class s3 {
    public static HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("https", "true");
        hashMap.put("up_apps", "true");
        hashMap.put("start_daemon", "false");
        hashMap.put("up_daemon_delay", "600000");
        hashMap.put("gps_kalman", "false");
        hashMap.put("min_wifi_scan_interval", "30000");
        hashMap.put("f_coll_item", "2");
        hashMap.put("f_coll_up_net", "w");
        return hashMap;
    }
}
