package com.tencent.luggage.wxa.rg;

import com.tencent.oskplayer.proxy.VideoProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f139737a = new LinkedHashMap(8, 0.75f);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f139738a;

        public a(CountDownLatch countDownLatch) {
            this.f139738a = countDownLatch;
        }

        @Override // com.tencent.luggage.wxa.rg.m
        public void a(l lVar, int i3) {
        }

        @Override // com.tencent.luggage.wxa.rg.m
        public void a(l lVar) {
            this.f139738a.countDown();
        }

        @Override // com.tencent.luggage.wxa.rg.m
        public void b(l lVar) {
        }
    }

    public synchronized void a(String str, l lVar) {
        ArrayList arrayList = (ArrayList) this.f139737a.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f139737a.put(str, arrayList);
            com.tencent.luggage.wxa.tg.h.a(3, "RequestManager", "add videoRequest:" + lVar);
        }
        arrayList.add(lVar);
    }

    public void b(String str, l lVar) {
        ArrayList a16 = a(a(str));
        String str2 = VideoProxy.LOG_TAG_PREFIX + lVar.m() + "/RequestManager";
        com.tencent.luggage.wxa.tg.h.a(4, str2, "cancelPreloadRequestsSync, videoKey:" + str + ", count:" + a16.size());
        if (a16.size() > 0) {
            CountDownLatch countDownLatch = new CountDownLatch(a16.size());
            com.tencent.luggage.wxa.tg.h.a(5, str2, "start auto cancel preload requests, request count=" + countDownLatch.getCount());
            a aVar = new a(countDownLatch);
            Iterator it = a16.iterator();
            while (it.hasNext()) {
                ((l) it.next()).a(aVar);
            }
            try {
                countDownLatch.await(2000, TimeUnit.MILLISECONDS);
                if (a(str).size() == 0) {
                    com.tencent.luggage.wxa.tg.h.a(5, str2, "auto cancel preload requests success");
                } else {
                    com.tencent.luggage.wxa.tg.h.a(5, str2, "auto cancel preload requests timeout, max wait time is 2000 seconds");
                }
            } catch (InterruptedException e16) {
                com.tencent.luggage.wxa.tg.h.a(5, str2, "auto cancel preload requests interrupted " + e16.toString());
            }
        }
    }

    public synchronized String toString() {
        String str;
        str = super.toString() + "[";
        Iterator it = this.f139737a.entrySet().iterator();
        while (it.hasNext()) {
            Iterator it5 = ((ArrayList) ((Map.Entry) it.next()).getValue()).iterator();
            while (it5.hasNext()) {
                str = (str + ((l) it5.next()).toString()) + ",\n";
            }
        }
        return str + "]";
    }

    public synchronized void a(l lVar) {
        ArrayList arrayList = (ArrayList) this.f139737a.get(lVar.n());
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (lVar.equals((l) it.next())) {
                    if (com.tencent.luggage.wxa.og.a.a().n()) {
                        com.tencent.luggage.wxa.tg.h.a(3, "RequestManager", "remove videoRequest:" + lVar);
                    }
                    it.remove();
                }
            }
        }
    }

    public final ArrayList a(String str) {
        return a(str, 10);
    }

    public final ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            if (lVar.v()) {
                arrayList2.add(lVar);
            }
        }
        return arrayList2;
    }

    public synchronized ArrayList a(String str, int i3) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f139737a.entrySet().iterator();
        while (it.hasNext()) {
            ArrayList arrayList2 = (ArrayList) ((Map.Entry) it.next()).getValue();
            if (arrayList2.size() > 0) {
                l lVar = (l) arrayList2.get(0);
                if (str.equals(lVar.r())) {
                    if (i3 != -1) {
                        if (i3 == lVar.i()) {
                            arrayList.addAll(arrayList2);
                        }
                    } else {
                        arrayList.addAll(arrayList2);
                    }
                }
            }
        }
        return arrayList;
    }
}
