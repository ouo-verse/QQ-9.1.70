package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.addcontact.g;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardBusiEntry$comm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import ip2.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import on2.c;
import on2.d;

/* compiled from: P */
/* loaded from: classes18.dex */
public class NetSearchEngine implements on2.b<x> {
    public static double C;

    /* renamed from: m, reason: collision with root package name */
    public static double f284800m;

    /* renamed from: d, reason: collision with root package name */
    g f284801d;

    /* renamed from: e, reason: collision with root package name */
    private ThreadPoolExecutor f284802e;

    /* renamed from: f, reason: collision with root package name */
    private int f284803f;

    /* renamed from: h, reason: collision with root package name */
    private Future f284804h;

    /* renamed from: i, reason: collision with root package name */
    private NetSearchRunnalbe f284805i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class NetSearchRunnalbe implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int[] f284806d;

        /* renamed from: e, reason: collision with root package name */
        private d f284807e;

        /* renamed from: f, reason: collision with root package name */
        private String f284808f;

        /* renamed from: h, reason: collision with root package name */
        private int f284809h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f284810i;
        ar C = new a();

        /* renamed from: m, reason: collision with root package name */
        public CountDownLatch f284811m = new CountDownLatch(1);

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a extends ar {
            a() {
            }

            @Override // com.tencent.mobileqq.app.ar
            protected void onSearchFriendResult(boolean z16, int i3, Object obj, int i16, String str, boolean z17, long j3, int i17, List<x> list) {
                NetSearchRunnalbe netSearchRunnalbe = NetSearchRunnalbe.this;
                if (netSearchRunnalbe.C != null) {
                    NetSearchEngine.this.f().removeObserver(NetSearchRunnalbe.this.C);
                }
                if (NetSearchRunnalbe.this.f284810i || i3 != 84 || z17) {
                    return;
                }
                if (z16) {
                    if (obj instanceof ArrayList) {
                        NetSearchRunnalbe netSearchRunnalbe2 = NetSearchRunnalbe.this;
                        ThreadManagerV2.post(new ParseTask(netSearchRunnalbe2.f284808f, (ArrayList) obj, NetSearchRunnalbe.this.f284807e), 10, null, true);
                        return;
                    }
                    return;
                }
                if (NetSearchRunnalbe.this.f284807e != null) {
                    NetSearchRunnalbe.this.f284807e.onFinish((List) null, 1);
                }
            }
        }

        public NetSearchRunnalbe(String str, int[] iArr, int i3, d dVar) {
            this.f284806d = iArr;
            this.f284807e = dVar;
            this.f284808f = str;
            this.f284809h = i3;
        }

        public void cancel() {
            this.f284810i = true;
            this.f284807e = null;
            NetSearchEngine.this.f().removeObserver(this.C);
            this.C = null;
            this.f284811m.countDown();
        }

        @Override // java.lang.Runnable
        public void run() {
            NetSearchEngine.this.f().addObserver(this.C);
            NetSearchEngine.this.f284801d.o(this.f284809h);
            if (NetSearchEngine.this.f284803f == 12) {
                NetSearchEngine.this.f284801d.m(this.f284808f, this.f284806d, NetSearchEngine.C, NetSearchEngine.f284800m, false, 1);
            } else {
                NetSearchEngine.this.f284801d.m(this.f284808f, this.f284806d, NetSearchEngine.C, NetSearchEngine.f284800m, false, 0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class ParseTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<byte[]> f284813d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<d> f284814e;

        /* renamed from: f, reason: collision with root package name */
        private String f284815f;

        public ParseTask(String str, ArrayList<byte[]> arrayList, d dVar) {
            this.f284815f = str;
            this.f284813d = arrayList;
            if (dVar != null) {
                this.f284814e = new WeakReference<>(dVar);
            }
        }

        private List<x> a(String str, ArrayList<byte[]> arrayList) {
            int length;
            int i3;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList(12);
                StringBuilder sb5 = new StringBuilder(arrayList.size() * 64);
                int size = arrayList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    byte[] bArr = arrayList.get(i16);
                    if (bArr == null) {
                        length = 0;
                    } else {
                        length = bArr.length;
                    }
                    if (length > 10) {
                        int longData = (int) PkgTools.getLongData(bArr, 1);
                        int longData2 = (int) PkgTools.getLongData(bArr, 5);
                        if (longData > 0 && (i3 = 9 + longData) < length) {
                            byte[] bArr2 = new byte[longData];
                            PkgTools.copyData(bArr2, 0, bArr, 9, longData);
                            SummaryCardBusiEntry$comm summaryCardBusiEntry$comm = new SummaryCardBusiEntry$comm();
                            try {
                                summaryCardBusiEntry$comm.mergeFrom(bArr2);
                                int i17 = summaryCardBusiEntry$comm.result.get();
                                if (i17 == 0) {
                                    int i18 = summaryCardBusiEntry$comm.service.get();
                                    byte[] bArr3 = new byte[longData2];
                                    PkgTools.copyData(bArr3, 0, bArr, i3, longData2);
                                    List<x> e16 = NetSearchEngine.this.e(str, i18, summaryCardBusiEntry$comm, bArr3);
                                    if (e16 != null && e16.size() > 0) {
                                        arrayList2.addAll(e16);
                                    }
                                } else {
                                    sb5.append(" |busi entry, [");
                                    sb5.append(summaryCardBusiEntry$comm.service.get());
                                    sb5.append(",");
                                    sb5.append(i17);
                                    sb5.append(",");
                                    sb5.append(summaryCardBusiEntry$comm.err_msg.get());
                                }
                            } catch (Exception e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("Q.uniteSearch.NetSearchEngine", 2, e17.toString());
                                }
                            }
                        }
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("Q.uniteSearch.NetSearchEngine", 4, sb5.toString());
                }
                return arrayList2;
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            List<x> a16 = a(this.f284815f, this.f284813d);
            WeakReference<d> weakReference = this.f284814e;
            if (weakReference != null && (dVar = weakReference.get()) != null) {
                dVar.onFinish(a16, 1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f284816d;

        a(List list) {
            this.f284816d = list;
        }

        @Override // on2.d
        public /* synthetic */ void onCancelSearch() {
            c.a(this);
        }

        @Override // on2.d
        public void onFinish(List list, int i3) {
            if (list != null && !list.isEmpty()) {
                this.f284816d.addAll(list);
            }
            SearchUtils.b1();
            NetSearchEngine.this.f284805i.f284811m.countDown();
        }

        @Override // on2.d
        public void onUpdate(List list) {
        }

        @Override // on2.d
        public void onUpdate(List list, boolean z16) {
        }

        @Override // on2.d
        public void onFinish(List list, pn2.b bVar) {
            onFinish(list, bVar.f426500c);
        }
    }

    public NetSearchEngine(AppInterface appInterface, ThreadPoolExecutor threadPoolExecutor, int i3) {
        this.f284802e = threadPoolExecutor;
        this.f284803f = i3;
        if (threadPoolExecutor == null) {
            this.f284802e = new BaseThreadPoolExecutor(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
        }
        this.f284801d = new g(appInterface);
    }

    private int[] g(int i3) {
        if (i3 < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(5);
        if ((i3 & 2) >= 1) {
            arrayList.add(80000000);
        }
        if ((i3 & 4) >= 1) {
            arrayList.add(80000001);
        }
        if ((i3 & 8) >= 1) {
            arrayList.add(80000002);
        }
        if ((i3 & 16) >= 1) {
            arrayList.add(80000003);
        }
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        int[] iArr = new int[size];
        for (int i16 = 0; i16 < size; i16++) {
            iArr[i16] = ((Integer) arrayList.get(i16)).intValue();
        }
        return iArr;
    }

    @Override // on2.b
    public List<x> a(pn2.a aVar) {
        Bundle bundle = aVar.f426496b;
        int i3 = bundle.getInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1);
        int i16 = bundle.getInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
        int[] g16 = g(i3);
        if (g16 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        NetSearchRunnalbe netSearchRunnalbe = new NetSearchRunnalbe(aVar.f426495a, g16, i16, new a(arrayList));
        this.f284805i = netSearchRunnalbe;
        this.f284804h = this.f284802e.submit(netSearchRunnalbe);
        try {
            this.f284805i.f284811m.await();
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }

    @Override // on2.b
    public void c(pn2.a aVar, d<x> dVar) {
        Bundle bundle = aVar.f426496b;
        int i3 = bundle.getInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1);
        int i16 = bundle.getInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
        int[] g16 = g(i3);
        if (g16 == null) {
            return;
        }
        NetSearchRunnalbe netSearchRunnalbe = new NetSearchRunnalbe(aVar.f426495a, g16, i16, dVar);
        this.f284805i = netSearchRunnalbe;
        this.f284804h = this.f284802e.submit(netSearchRunnalbe);
    }

    @Override // on2.b
    public void cancel() {
        Future future = this.f284804h;
        if (future != null) {
            future.cancel(true);
            Future future2 = this.f284804h;
            if (future2 instanceof Runnable) {
                this.f284802e.remove((Runnable) future2);
            }
        }
        NetSearchRunnalbe netSearchRunnalbe = this.f284805i;
        if (netSearchRunnalbe != null) {
            netSearchRunnalbe.cancel();
        }
    }

    List<x> e(String str, int i3, SummaryCardBusiEntry$comm summaryCardBusiEntry$comm, byte[] bArr) {
        ip2.d a16 = f.a(i3);
        if (a16 != null) {
            return a16.a(summaryCardBusiEntry$comm, bArr, str);
        }
        return null;
    }

    public /* synthetic */ AppInterface f() {
        return on2.a.a(this);
    }

    @Override // on2.b
    public void destroy() {
    }

    @Override // on2.b
    public void init() {
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }
}
