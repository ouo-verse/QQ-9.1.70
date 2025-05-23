package hf0;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Long> f404819a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static Pair<String, Long> f404820b = null;

    public static boolean a(@NonNull String str) {
        Long l3;
        Pair<String, Long> pair = f404820b;
        if (pair != null && TextUtils.equals(str, (CharSequence) pair.first)) {
            l3 = (Long) f404820b.second;
        } else {
            l3 = null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (l3 != null && elapsedRealtime - l3.longValue() < 1000) {
            LogUtils.w("FastClickUtils", "fast click ,tag  = " + str + ", intervalTime = " + (elapsedRealtime - l3.longValue()));
            return true;
        }
        f404820b = new Pair<>(str, Long.valueOf(elapsedRealtime));
        return false;
    }

    public static boolean b(@NonNull String str, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f404819a == null) {
            f404819a = new HashMap<>();
        }
        Long l3 = f404819a.get(str);
        if (l3 != null) {
            if (f404819a.size() > 10) {
                f404819a.clear();
            }
            f404819a.put(str, Long.valueOf(elapsedRealtime));
            QLog.d("FastClickUtils", 4, "fast click ,tag  = " + str + ", currentTime = " + elapsedRealtime + " lastTime" + l3 + " intervalTime = " + (elapsedRealtime - l3.longValue()));
            if (elapsedRealtime - l3.longValue() >= j3) {
                return false;
            }
            return true;
        }
        f404819a.put(str, Long.valueOf(elapsedRealtime));
        return false;
    }
}
