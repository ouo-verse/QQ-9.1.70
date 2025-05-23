package c.t.m.g;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class q2 {

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f29954a;

    static {
        ArrayList arrayList = new ArrayList();
        f29954a = arrayList;
        arrayList.add(DeviceType.DeviceCategory.MOBILE);
        arrayList.add("16wifi");
        arrayList.add("cmcc");
        arrayList.add("360wifi");
        arrayList.add("androidap");
        arrayList.add("htcphone");
        arrayList.add("xiaomi");
        arrayList.add(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_LENOVO);
        arrayList.add("macbook");
    }

    @SuppressLint({"NewApi"})
    public static void a(List<ScanResult> list) {
        HashSet hashSet = new HashSet();
        Iterator<ScanResult> it = list.iterator();
        while (it.hasNext()) {
            ScanResult next = it.next();
            String str = next.BSSID;
            if (str != null && !str.equals("000000000000") && !str.equals("00-00-00-00-00-00") && !str.equals("00:00:00:00:00:00") && next.level < 0) {
                if (hashSet.contains(str)) {
                    it.remove();
                } else {
                    hashSet.add(str);
                }
            } else {
                it.remove();
            }
        }
        o3.b("WifiBlackList", "after step1 filter : " + list.size());
        try {
            b(list);
        } catch (Throwable unused) {
            o3.a("WifiBlackList", "strict filter throw exception");
        }
        o3.b("WifiBlackList", "after step2 filter : " + list.size());
    }

    @SuppressLint({"NewApi"})
    public static void b(List<ScanResult> list) {
        Field field;
        if (list != null && list.size() != 0) {
            try {
                field = list.get(0).getClass().getField("wifiSsid");
                field.setAccessible(true);
            } catch (Throwable unused) {
                field = null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<ScanResult> it = list.iterator();
            while (it.hasNext()) {
                ScanResult next = it.next();
                if (field != null) {
                    try {
                        if (field.get(next) == null) {
                            it.remove();
                            arrayList.add(next);
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            arrayList.size();
        }
    }
}
