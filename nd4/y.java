package nd4;

import android.support.annotation.NonNull;
import com.tencent.tab.tabmonitor.export.config.TabAggregateType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import nd4.w;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class y extends a {
    public y(@NonNull w wVar) {
        super(wVar);
        h(wVar);
    }

    private void h(@NonNull w wVar) {
        TabAggregateType tabAggregateType = TabAggregateType.SUM;
        ArrayList arrayList = new ArrayList(Arrays.asList(new z("NetSuccessKey", tabAggregateType), new z("NetTimeoutKey", tabAggregateType), new z("NetServerErrKey", tabAggregateType)));
        arrayList.addAll(wVar.c());
        this.f419973a = new w.b().h(wVar, arrayList);
    }

    private ConcurrentHashMap<String, Float> i(float f16, float f17, float f18) {
        ConcurrentHashMap<String, Float> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("NetSuccessKey", Float.valueOf(f16));
        concurrentHashMap.put("NetTimeoutKey", Float.valueOf(f17));
        concurrentHashMap.put("NetServerErrKey", Float.valueOf(f18));
        return concurrentHashMap;
    }

    @Override // nd4.a
    @NonNull
    protected String c() {
        return "TabNetMonitor";
    }

    public boolean j(Map<String, String> map, Map<String, Float> map2) {
        ConcurrentHashMap<String, Float> i3 = i(0.0f, 0.0f, 1.0f);
        i3.putAll(map2);
        return f(map, i3);
    }

    public boolean k(Map<String, String> map, Map<String, Float> map2) {
        ConcurrentHashMap<String, Float> i3 = i(1.0f, 0.0f, 0.0f);
        i3.putAll(map2);
        return f(map, i3);
    }

    public boolean l(Map<String, String> map, Map<String, Float> map2) {
        ConcurrentHashMap<String, Float> i3 = i(0.0f, 1.0f, 1.0f);
        i3.putAll(map2);
        return f(map, i3);
    }
}
