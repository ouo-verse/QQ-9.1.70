package ok1;

import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, a> a() {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        b(arrayList);
        for (a aVar : arrayList) {
            aVar.m();
            arrayMap.put(aVar.k(), aVar);
        }
        return arrayMap;
    }

    protected abstract void b(List<a> list);
}
