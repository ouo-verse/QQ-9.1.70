package fb0;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Long> f398126a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static Pair<String, Long> f398127b = null;

    public static boolean a(@NonNull String str) {
        Long l3;
        Pair<String, Long> pair = f398127b;
        if (pair != null && TextUtils.equals(str, (CharSequence) pair.first)) {
            l3 = (Long) f398127b.second;
        } else {
            l3 = null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (l3 != null && elapsedRealtime - l3.longValue() < 1000) {
            QLog.d("FastClickUtils", 4, "fast click ,tag  = " + str + ", intervalTime = " + (elapsedRealtime - l3.longValue()));
            return true;
        }
        f398127b = new Pair<>(str, Long.valueOf(elapsedRealtime));
        return false;
    }

    public static boolean b(@NonNull String str, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f398126a == null) {
            f398126a = new HashMap<>();
        }
        Long l3 = f398126a.get(str);
        if (l3 != null) {
            if (f398126a.size() > 10) {
                f398126a.clear();
            }
            f398126a.put(str, Long.valueOf(elapsedRealtime));
            QLog.d("FastClickUtils", 4, "fast click ,tag  = " + str + ", currentTime = " + elapsedRealtime + " lastTime = " + l3 + " intervalTime = " + (elapsedRealtime - l3.longValue()));
            if (elapsedRealtime - l3.longValue() >= j3) {
                return false;
            }
            return true;
        }
        f398126a.put(str, Long.valueOf(elapsedRealtime));
        return false;
    }
}
