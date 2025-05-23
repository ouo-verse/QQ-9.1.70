package cooperation.ilive.util;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Long> f390145a = new HashMap<>();

    public static void a(String str) {
        if (QLog.isColorLevel()) {
            f390145a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void b(String str) {
        if (QLog.isColorLevel() && f390145a.containsKey(str) && f390145a.get(str) != null) {
            long longValue = f390145a.get(str).longValue();
            f390145a.remove(str);
            QLog.d("ElapseStat", 2, str + " elpase:" + (System.currentTimeMillis() - longValue));
        }
    }
}
