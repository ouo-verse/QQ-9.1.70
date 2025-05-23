package jr;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Integer> f410861a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, Integer> f410862b;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f410861a = hashMap;
        hashMap.put("actLbsSendPoiListFailure", 100);
        f410861a.put("actLbsSendGetPidFailure", 100);
        f410861a.put("actLbsPayBridgeFailure", 100);
        f410861a.put("actLbsPoiListFailure", 10000);
        f410861a.put("actLbsPackListFailure", 1000);
        f410861a.put("actLbsGetPackFailure", 100);
        f410861a.put("actLbsCaiShenResourceFailure", 100);
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        f410862b = hashMap2;
        hashMap2.put("actLbsSendPoiListFailure", 10000);
        f410862b.put("actLbsSendGetPidFailure", 10000);
        f410862b.put("actLbsPayBridgeFailure", 10000);
        f410862b.put("actLbsPoiListFailure", 100000);
        f410862b.put("actLbsPackListFailure", 10000);
        f410862b.put("actLbsGetPackFailure", 10000);
        f410862b.put("actLbsCaiShenResourceFailure", 10000);
    }

    public static boolean a(String str) {
        Integer num = f410861a.get(str);
        return num != null && ((int) (Math.random() * ((double) num.intValue()))) == 1;
    }

    public static boolean b(String str) {
        Integer num = f410862b.get(str);
        return num != null && ((int) (Math.random() * ((double) num.intValue()))) == 1;
    }

    public static void c(String str, int i3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", String.valueOf(i3));
            String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
            if (TextUtils.isEmpty(account) || !a(str)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LbsPack", 2, "uploadFailure " + str + " " + i3);
            }
            StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(account, str, true, 0L, 0L, hashMap, null);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void d(String str) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
            if (TextUtils.isEmpty(account) || !b(str)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("LbsPack", 2, "uploadSuccess " + str);
            }
            StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(account, str, false, 0L, 0L, hashMap, null);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
