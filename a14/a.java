package a14;

import com.tencent.rmonitor.fd.data.FdCountable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a {

    /* compiled from: P */
    /* renamed from: a14.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    static class C0003a implements Comparator<FdCountable> {
        C0003a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FdCountable fdCountable, FdCountable fdCountable2) {
            return fdCountable2.getCount() - fdCountable.getCount();
        }
    }

    public static List<FdCountable> a(Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            for (String str : map.keySet()) {
                arrayList.add(new FdCountable(str, map.get(str).intValue()));
            }
            Collections.sort(arrayList, new C0003a());
        }
        return arrayList;
    }
}
