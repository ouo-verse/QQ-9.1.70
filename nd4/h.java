package nd4;

import android.support.annotation.NonNull;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, i> f419996a = new ConcurrentHashMap<>();

    @NonNull
    public Map<String, String> a(ConcurrentHashMap<String, i> concurrentHashMap) {
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            String c16 = p.c(concurrentHashMap);
            concurrentHashMap2.put("monitor", c16 + ";");
            Log.d("TAB.TabMonitorGroup", d.b(c16));
            return concurrentHashMap2;
        }
        Log.d("TAB.TabMonitorGroup", "monitorGroup is null or content is empty!");
        return concurrentHashMap2;
    }

    @NonNull
    public ConcurrentHashMap<String, i> b() {
        return this.f419996a;
    }

    public String toString() {
        return "TabAggregateMonitorGroup{mMonitorGroup=" + this.f419996a.values() + '}';
    }
}
