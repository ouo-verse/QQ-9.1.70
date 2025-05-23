package kz;

import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, mz.d> f413450a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<String>> f413451b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, Map<Integer, stDramaFeed>> f413452c = new HashMap();

    private nz.f f(int i3, int i16, String str) {
        nz.f fVar = new nz.f();
        fVar.d(str);
        fVar.e(str);
        int i17 = i16 + 1;
        fVar.f(i17);
        fVar.setChecked(i17 == i3);
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public nz.c b(String str) {
        stDramaInfo stdramainfo;
        int i3;
        List<String> e16 = e(str);
        mz.d c16 = c(str);
        if (c16 != null) {
            stdramainfo = c16.e().dramaInfo;
            i3 = stdramainfo.curWatchedFeedNum;
            a(stdramainfo, e16);
        } else {
            stdramainfo = null;
            i3 = 0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < e16.size(); i16++) {
            arrayList.add(f(i3, i16, e16.get(i16)));
        }
        if (i3 == 0 && arrayList.size() > 0) {
            ((nz.f) arrayList.get(0)).setChecked(true);
        }
        return new nz.c(arrayList, stdramainfo);
    }

    mz.d c(String str) {
        return this.f413450a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<Integer, stDramaFeed> d(String str) {
        Map<Integer, stDramaFeed> map = this.f413452c.get(str);
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        this.f413452c.put(str, hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> e(String str) {
        List<String> list = this.f413451b.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        this.f413451b.put(str, arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f413451b.clear();
        this.f413452c.clear();
        this.f413450a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(List<mz.d> list) {
        for (mz.d dVar : list) {
            String d16 = dVar.d();
            this.f413451b.put(d16, dVar.g());
            this.f413450a.put(d16, dVar);
            stDramaFeed h16 = dVar.h();
            if (h16 != null) {
                d(d16).put(Integer.valueOf(h16.num), h16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(List<stDramaFeed> list, String str) {
        Map<Integer, stDramaFeed> d16 = d(str);
        for (stDramaFeed stdramafeed : list) {
            d16.put(Integer.valueOf(stdramafeed.num), stdramafeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str, int i3) {
        mz.d c16 = c(str);
        if (c16 == null || c16.e() == null || c16.e().dramaInfo == null) {
            return;
        }
        c16.e().dramaInfo.curWatchedFeedNum = i3;
    }

    private void a(stDramaInfo stdramainfo, List<String> list) {
        if (stdramainfo == null || list.size() <= 0) {
            return;
        }
        if (stdramainfo.curWatchedFeedNum <= 0) {
            stdramainfo.curWatchedFeedNum = 1;
            stdramainfo.curWatchedFeedID = list.get(0);
        }
        int i3 = stdramainfo.curWatchedFeedNum;
        int i16 = stdramainfo.curPublishedFeedNum;
        if (i3 > i16) {
            stdramainfo.curWatchedFeedNum = i16;
            stdramainfo.curWatchedFeedID = list.get(list.size() - 1);
        }
    }
}
