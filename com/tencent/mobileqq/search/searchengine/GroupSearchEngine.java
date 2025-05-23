package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.contact.NtGroupLocalInfoSearchEngine;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchlocal.searchengine.MiniProgramSearchEngine;
import com.tencent.mobileqq.search.util.SearchEnginePerfReporter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.y;
import com.tencent.mobileqq.searchlocal.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import do2.p;
import do2.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import on2.d;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GroupSearchEngine implements on2.b, Observer {
    private static final Comparator<k> F = new a();
    private static final ThreadPoolExecutor G = new c(3, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new b());
    private String D;
    private int E;

    /* renamed from: e, reason: collision with root package name */
    private Future f284752e;

    /* renamed from: f, reason: collision with root package name */
    private SearchRunnable f284753f;

    /* renamed from: h, reason: collision with root package name */
    private ScheduledFuture f284754h;

    /* renamed from: i, reason: collision with root package name */
    private TroopMemberSearchRunnable f284755i;

    /* renamed from: m, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f284756m;

    /* renamed from: d, reason: collision with root package name */
    private long f284751d = -1;
    private ArrayList<k> C = t();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class SearchRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private pn2.a f284757d;

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        private volatile on2.d f284758e;

        /* renamed from: f, reason: collision with root package name */
        private volatile boolean f284759f;

        public SearchRunnable(pn2.a aVar, on2.d dVar) {
            this.f284757d = aVar;
            if (dVar == null) {
                this.f284758e = new d.a();
            } else {
                this.f284758e = dVar;
            }
        }

        private void e(List<v> list, FavoriteSearchEngine.c cVar) {
            StringBuilder sb5;
            if (cVar != null) {
                try {
                    try {
                        List<x> list2 = cVar.f390634a.get(10000L, TimeUnit.MILLISECONDS);
                        for (x xVar : list2) {
                            list.add(xVar);
                            QLog.i("GroupSearchEngine", 1, "favriteSearchEngine Future result: ..... " + xVar);
                        }
                        if (list2.size() > 0) {
                            QLog.d("GroupSearchEngine", 4, "size changed update list2");
                            this.f284758e.onUpdate(new ArrayList(list));
                        }
                        SearchEnginePerfReporter.m(GroupSearchEngine.this.D, cVar.f390635b);
                        sb5 = new StringBuilder();
                    } catch (InterruptedException e16) {
                        e = e16;
                        QLog.e("GroupSearchEngine", 1, "favriteSearchEngine Future result: ..... there is some error " + e);
                        SearchEnginePerfReporter.m(GroupSearchEngine.this.D, cVar.f390635b);
                        sb5 = new StringBuilder();
                    } catch (ExecutionException e17) {
                        e = e17;
                        QLog.e("GroupSearchEngine", 1, "favriteSearchEngine Future result: ..... there is some error " + e);
                        SearchEnginePerfReporter.m(GroupSearchEngine.this.D, cVar.f390635b);
                        sb5 = new StringBuilder();
                    } catch (TimeoutException e18) {
                        QLog.i("GroupSearchEngine", 1, "favriteSearchEngine Future result: ..... timeout " + e18);
                        SearchEnginePerfReporter.m(GroupSearchEngine.this.D, cVar.f390635b);
                        sb5 = new StringBuilder();
                    }
                    sb5.append("favriteSearchEngine Future finish cost: ..... ");
                    sb5.append(System.currentTimeMillis() - cVar.f390636c);
                    QLog.i("GroupSearchEngine", 1, sb5.toString());
                } catch (Throwable th5) {
                    SearchEnginePerfReporter.m(GroupSearchEngine.this.D, cVar.f390635b);
                    QLog.i("GroupSearchEngine", 1, "favriteSearchEngine Future finish cost: ..... " + (System.currentTimeMillis() - cVar.f390636c));
                    throw th5;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit f(ArrayList arrayList, AtomicInteger atomicInteger, List list, on2.d dVar, Integer num, List list2) {
            String str = (String) arrayList.get(num.intValue());
            SearchEnginePerfReporter.m(GroupSearchEngine.this.D, str);
            if (list2 == null) {
                QLog.e("GroupSearchEngine", 1, "engineName=" + str + " index=" + num + " [" + atomicInteger.getAndIncrement() + "] Future result: ....., there is some error! " + ((Object) null));
                return Unit.INSTANCE;
            }
            if (list2.isEmpty()) {
                QLog.i("GroupSearchEngine", 1, "engineName=" + str + " index=" + num + " [" + atomicInteger.getAndIncrement() + "] Future result : ..... empty");
            }
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                x xVar = (x) it.next();
                list.add(xVar);
                QLog.i("GroupSearchEngine", 1, "engineName=" + str + " index=" + num + " [" + atomicInteger.getAndIncrement() + "] Future result: ..... " + xVar);
            }
            if (!list2.isEmpty()) {
                QLog.d("GroupSearchEngine", 4, "size changed update list3");
                dVar.onUpdate(new ArrayList(list));
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:63:0x0266  */
        /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void g(final on2.d dVar) {
            boolean z16;
            String str;
            int i3;
            long j3;
            int i16;
            List<x> h16;
            char c16;
            ArrayList arrayList;
            final ArrayList arrayList2 = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("GroupSearchEngine", 2, "begin local search at :" + currentTimeMillis);
            }
            dVar.onUpdate(new ArrayList(arrayList2));
            ArrayList arrayList3 = new ArrayList();
            final ArrayList arrayList4 = new ArrayList();
            FavoriteSearchEngine.c cVar = null;
            int i17 = 0;
            int i18 = 0;
            while (i17 < GroupSearchEngine.this.C.size()) {
                k kVar = (k) GroupSearchEngine.this.C.get(i17);
                if (this.f284759f) {
                    return;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                String p16 = SearchEnginePerfReporter.p(kVar.f284787a);
                StringBuilder sb5 = new StringBuilder();
                long j16 = currentTimeMillis;
                sb5.append("[search_cost] begin local search : index = ");
                sb5.append(i17);
                sb5.append(" engineName=");
                sb5.append(p16);
                QLog.d("GroupSearchEngine", 2, sb5.toString());
                SearchEnginePerfReporter.v(GroupSearchEngine.this.D, p16);
                ArrayList arrayList5 = new ArrayList();
                boolean z17 = kVar instanceof j;
                if (z17) {
                    if (kVar.f284787a instanceof FavoriteSearchEngine) {
                        cVar = new FavoriteSearchEngine.c();
                        arrayList = arrayList5;
                        cVar.f390634a = ((j) kVar).k(this.f284757d);
                        cVar.f390635b = p16;
                        cVar.f390636c = currentTimeMillis2;
                    } else {
                        arrayList = arrayList5;
                        arrayList3.add(((j) kVar).k(this.f284757d));
                        arrayList4.add(p16);
                    }
                    h16 = arrayList;
                } else {
                    h16 = kVar.h(this.f284757d);
                    SearchEnginePerfReporter.m(GroupSearchEngine.this.D, p16);
                }
                if (h16 != null && !h16.isEmpty()) {
                    arrayList2.addAll(h16);
                    if (!(kVar.f284787a instanceof NetSearchEngine)) {
                        rn2.d.d(kVar.f284791e);
                    }
                }
                if (this.f284759f) {
                    return;
                }
                QLog.d("GroupSearchEngine", 2, "[search_cost] dispatch onupdate local search : index = " + i17 + " " + p16);
                if (arrayList2.size() > i18) {
                    i18 = arrayList2.size();
                    QLog.d("GroupSearchEngine", 4, "size changed update list");
                    dVar.onUpdate(new ArrayList(arrayList2));
                }
                if (!z17) {
                    c16 = 2;
                    QLog.d("GroupSearchEngine", 2, "[search_cost] finish local search : index = " + i17 + " " + p16 + " " + (System.currentTimeMillis() - currentTimeMillis2) + "ms");
                } else {
                    c16 = 2;
                }
                i17++;
                currentTimeMillis = j16;
            }
            long j17 = currentTimeMillis;
            if (this.f284759f) {
                QLog.i("GroupSearchEngine", 1, "search has canceled. req hashCode:" + this.f284757d.hashCode());
                return;
            }
            pn2.a aVar = this.f284757d;
            if (aVar.f426496b == null) {
                aVar.f426496b = new Bundle();
            }
            e(arrayList2, cVar);
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            a12.a.a(arrayList3, 180000L, new Function2() { // from class: com.tencent.mobileqq.search.searchengine.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f16;
                    f16 = GroupSearchEngine.SearchRunnable.this.f(arrayList4, atomicInteger, arrayList2, dVar, (Integer) obj, (List) obj2);
                    return f16;
                }
            });
            if (!y.b() && this.f284757d.f426496b.getBoolean("searchTroopMember")) {
                z16 = true;
            } else {
                z16 = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            if (!z16) {
                str = "GroupSearchEngine";
                i3 = 1;
                j3 = j17;
            } else {
                QLog.i("GroupSearchEngine", 1, "searchGroupMember: start....");
                SearchEnginePerfReporter.v(GroupSearchEngine.this.D, "troopMemberCost");
                if (GroupSearchEngine.this.f284756m == null) {
                    GroupSearchEngine.this.f284756m = (ScheduledThreadPoolExecutor) ProxyExecutors.newScheduledThreadPool(1);
                }
                ArrayList arrayList6 = (ArrayList) arrayList2.clone();
                GroupSearchEngine groupSearchEngine = GroupSearchEngine.this;
                str = "GroupSearchEngine";
                i3 = 1;
                j3 = j17;
                groupSearchEngine.f284755i = new TroopMemberSearchRunnable(this.f284757d, arrayList6, dVar, groupSearchEngine.D, countDownLatch, GroupSearchEngine.this);
                GroupSearchEngine groupSearchEngine2 = GroupSearchEngine.this;
                groupSearchEngine2.f284754h = groupSearchEngine2.f284756m.schedule(GroupSearchEngine.this.f284755i, 0L, TimeUnit.MILLISECONDS);
            }
            if (z16) {
                dVar.onFinish(arrayList2, i3);
                countDownLatch.countDown();
            } else if (this.f284757d.f426496b.getBoolean("hasLocalPeopleOrTroop", false)) {
                dVar.onFinish(arrayList2, 5);
            } else {
                i16 = 4;
                dVar.onFinish(arrayList2, 4);
                GroupSearchEngine.this.f284751d = System.currentTimeMillis() - j3;
                if (!QLog.isDevelopLevel()) {
                    QLog.d(str, i16, "search process cost:" + GroupSearchEngine.this.f284751d + " keyword:" + this.f284757d.f426495a);
                    return;
                }
                return;
            }
            i16 = 4;
            GroupSearchEngine.this.f284751d = System.currentTimeMillis() - j3;
            if (!QLog.isDevelopLevel()) {
            }
        }

        public void cancel() {
            this.f284759f = true;
            this.f284758e = new d.a();
            QLog.i("GroupSearchEngine", 1, "cancel SearchRunnable");
        }

        @Override // java.lang.Runnable
        public void run() {
            g(new on2.d() { // from class: com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchRunnable.1
                @Override // on2.d
                public /* synthetic */ void onCancelSearch() {
                    on2.c.a(this);
                }

                @Override // on2.d
                public void onFinish(final List list, final int i3) {
                    ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchRunnable.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SearchRunnable.this.f284759f) {
                                QLog.i("GroupSearchEngine", 1, "onFinish search has canceled. req hashCode:" + SearchRunnable.this.f284757d.hashCode());
                                return;
                            }
                            SearchRunnable.this.f284758e.onFinish(list, i3);
                        }
                    });
                }

                @Override // on2.d
                public void onUpdate(final List list) {
                    ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchRunnable.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SearchRunnable.this.f284759f) {
                                QLog.i("GroupSearchEngine", 1, "onUpdate search has canceled. req hashCode:" + SearchRunnable.this.f284757d.hashCode());
                                return;
                            }
                            SearchRunnable.this.f284758e.onUpdate(new ArrayList(list));
                        }
                    });
                }

                @Override // on2.d
                public void onFinish(final List list, final pn2.b bVar) {
                    ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchRunnable.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SearchRunnable.this.f284759f) {
                                QLog.i("GroupSearchEngine", 1, "onFinish search has canceled. req hashCode:" + SearchRunnable.this.f284757d.hashCode());
                                return;
                            }
                            SearchRunnable.this.f284758e.onFinish(list, bVar);
                        }
                    });
                }

                @Override // on2.d
                public void onUpdate(final List list, final boolean z16) {
                    ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchRunnable.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SearchRunnable.this.f284759f) {
                                QLog.i("GroupSearchEngine", 1, "onUpdate search has canceled. req hashCode:" + SearchRunnable.this.f284757d.hashCode());
                                return;
                            }
                            SearchRunnable.this.f284758e.onUpdate(list, z16);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class TroopMemberSearchRunnable implements Runnable {
        private WeakReference<GroupSearchEngine> C;

        /* renamed from: d, reason: collision with root package name */
        private on2.d f284772d;

        /* renamed from: e, reason: collision with root package name */
        private pn2.a f284773e;

        /* renamed from: f, reason: collision with root package name */
        private ArrayList<v> f284774f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f284775h;

        /* renamed from: i, reason: collision with root package name */
        private String f284776i;

        /* renamed from: m, reason: collision with root package name */
        private CountDownLatch f284777m;

        public TroopMemberSearchRunnable(pn2.a aVar, ArrayList<v> arrayList, on2.d dVar, String str, CountDownLatch countDownLatch, GroupSearchEngine groupSearchEngine) {
            this.f284773e = aVar;
            this.f284774f = arrayList;
            this.f284772d = dVar;
            this.f284776i = str;
            this.f284777m = countDownLatch;
            this.C = new WeakReference<>(groupSearchEngine);
        }

        public void cancel() {
            this.f284775h = true;
            this.f284772d = null;
            while (this.f284777m.getCount() > 0) {
                this.f284777m.countDown();
            }
        }

        public void e() {
            f(this.f284774f);
        }

        public void f(ArrayList<v> arrayList) {
            SearchEnginePerfReporter.m(this.f284776i, "troopMemberCost");
            try {
                this.f284777m.await();
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            if (this.f284775h || this.f284772d == null) {
                return;
            }
            if (this.f284773e.f426496b.getBoolean("hasLocalPeopleOrTroop", false)) {
                this.f284772d.onFinish(arrayList, 5);
            } else {
                this.f284772d.onFinish(arrayList, 4);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i3;
            boolean z16;
            boolean z17;
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, begin local search at :" + currentTimeMillis);
            }
            GroupSearchEngine groupSearchEngine = this.C.get();
            if (groupSearchEngine != null) {
                str = groupSearchEngine.D;
            } else {
                str = "";
            }
            if (groupSearchEngine != null) {
                i3 = groupSearchEngine.E;
            } else {
                i3 = 0;
            }
            if (groupSearchEngine != null && this.f284776i.equals(str)) {
                ArrayList arrayList = groupSearchEngine.C;
                ContactSearchEngine contactSearchEngine = null;
                for (int i16 = 0; i16 < arrayList.size(); i16++) {
                    if (((k) arrayList.get(i16)).f284787a instanceof ContactSearchEngine) {
                        contactSearchEngine = (ContactSearchEngine) ((k) arrayList.get(i16)).f284787a;
                        if (contactSearchEngine.v() != 64) {
                            break;
                        }
                    }
                }
                if (!this.f284775h && contactSearchEngine != null && this.f284774f != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, start search");
                    }
                    List<com.tencent.mobileqq.search.model.k> a16 = contactSearchEngine.a(this.f284773e);
                    if (!this.f284775h && a16 != null && !a16.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(a16);
                        if (!this.f284774f.isEmpty()) {
                            Iterator<v> it = this.f284774f.iterator();
                            int i17 = -1;
                            int i18 = -1;
                            while (true) {
                                if (it.hasNext()) {
                                    v next = it.next();
                                    i18++;
                                    if (next instanceof do2.h) {
                                        Iterator<com.tencent.mobileqq.search.model.y> it5 = ((do2.h) next).f394373h.iterator();
                                        while (it5.hasNext()) {
                                            arrayList2.add((com.tencent.mobileqq.search.model.k) it5.next());
                                        }
                                        z16 = true;
                                    }
                                } else {
                                    z16 = false;
                                    break;
                                }
                            }
                            if (z16) {
                                int i19 = i18 - 1;
                                this.f284774f.remove(i19);
                                this.f284774f.remove(i19);
                            }
                            if (SearchConfig.needSeparate) {
                                Iterator<v> it6 = this.f284774f.iterator();
                                while (true) {
                                    if (it6.hasNext()) {
                                        v next2 = it6.next();
                                        i17++;
                                        if (next2 instanceof com.tencent.mobileqq.search.model.j) {
                                            Iterator<com.tencent.mobileqq.search.model.y> it7 = ((com.tencent.mobileqq.search.model.j) next2).f283540h.iterator();
                                            while (it7.hasNext()) {
                                                arrayList2.add((com.tencent.mobileqq.search.model.k) it7.next());
                                            }
                                            z17 = true;
                                        }
                                    } else {
                                        z17 = false;
                                        break;
                                    }
                                }
                                if (z17) {
                                    int i26 = i17 - 1;
                                    this.f284774f.remove(i26);
                                    this.f284774f.remove(i26);
                                }
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        contactSearchEngine.l(arrayList2, arrayList3, null, str);
                        if (!this.f284775h && !arrayList3.isEmpty()) {
                            ArrayList<com.tencent.mobileqq.search.model.k> arrayList4 = new ArrayList();
                            int i27 = 0;
                            for (com.tencent.mobileqq.search.model.k kVar : arrayList3) {
                                if (kVar instanceof wn2.f) {
                                    i27++;
                                    if (i27 <= 200) {
                                        arrayList4.add(kVar);
                                    }
                                } else {
                                    arrayList4.add(kVar);
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable troopCount:" + i27);
                            }
                            ArrayList arrayList5 = new ArrayList(arrayList4.size());
                            ArrayList arrayList6 = new ArrayList(arrayList4.size());
                            if (SearchConfig.needSeparate) {
                                for (com.tencent.mobileqq.search.model.k kVar2 : arrayList4) {
                                    if (SearchUtils.M0(kVar2)) {
                                        arrayList6.add(kVar2);
                                    } else {
                                        arrayList5.add(kVar2);
                                    }
                                }
                            } else {
                                arrayList5.addAll(arrayList4);
                            }
                            ArrayList<v> arrayList7 = new ArrayList<>();
                            if (!arrayList5.isEmpty()) {
                                SearchUtil.c(new do2.h(arrayList5, str, i3), arrayList7);
                            }
                            if (SearchConfig.needSeparate && !arrayList6.isEmpty()) {
                                SearchUtil.c(new com.tencent.mobileqq.search.model.j(arrayList6, str, i3), arrayList7);
                            }
                            if (!this.f284774f.isEmpty()) {
                                arrayList7.addAll(this.f284774f);
                            }
                            if (!this.f284775h && this.f284776i.equals(str)) {
                                if (this.f284772d != null && !arrayList7.isEmpty()) {
                                    f(arrayList7);
                                }
                                GroupSearchEngine groupSearchEngine2 = this.C.get();
                                if (groupSearchEngine2 != null) {
                                    groupSearchEngine2.f284751d = System.currentTimeMillis() - currentTimeMillis;
                                    if (QLog.isColorLevel()) {
                                        QLog.d("GroupSearchEngine", 2, "TroopMemberSearchRunnable, end search, cost: " + groupSearchEngine2.f284751d);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            e();
                            return;
                        }
                        e();
                        return;
                    }
                    e();
                    return;
                }
                e();
                return;
            }
            e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Comparator<k> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(k kVar, k kVar2) {
            Integer num = SearchConfig.searchEngineOrder.get(kVar2.f284790d);
            Integer num2 = 0;
            if (num == null) {
                num = num2;
            }
            Integer num3 = SearchConfig.searchEngineOrder.get(kVar.f284790d);
            if (num3 != null) {
                num2 = num3;
            }
            return Integer.signum(num.intValue() - num2.intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f284778d = new AtomicInteger(1);

        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(runnable, "SearchTask #" + this.f284778d.getAndIncrement());
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c extends BaseThreadPoolExecutor {
        c(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
            super(i3, i16, j3, timeUnit, (BlockingQueue<Runnable>) blockingQueue, threadFactory);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th5) {
            if (runnable instanceof FutureTask) {
                try {
                    ((FutureTask) runnable).get();
                } catch (Error | Exception unused) {
                } catch (ExecutionException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("GroupSearchEngine", 2, "Exception happened", e16);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d extends k {
        d(on2.b bVar, String str, int i3) {
            super(bVar, str, i3);
        }

        @Override // com.tencent.mobileqq.search.searchengine.GroupSearchEngine.k
        public x e(List<com.tencent.mobileqq.search.model.y> list, String str) {
            return new p(list, str, GroupSearchEngine.this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends k {
        e(on2.b bVar, String str, int i3) {
            super(bVar, str, i3);
        }

        @Override // com.tencent.mobileqq.search.searchengine.GroupSearchEngine.k
        public x e(List<com.tencent.mobileqq.search.model.y> list, String str) {
            return null;
        }

        @Override // com.tencent.mobileqq.search.searchengine.GroupSearchEngine.k
        public List<x> h(pn2.a aVar) {
            this.f284788b = 0L;
            this.f284789c = -1;
            if (aVar.f426496b == null) {
                aVar.f426496b = new Bundle();
            }
            ArrayList arrayList = new ArrayList();
            a(new do2.k(aVar.f426495a, GroupSearchEngine.this.E), arrayList);
            rn2.d.d(0);
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f extends k {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f284781f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(on2.b bVar, String str, int i3, int i16) {
            super(bVar, str, i3);
            this.f284781f = i16;
        }

        @Override // com.tencent.mobileqq.search.searchengine.GroupSearchEngine.k
        protected x e(List<com.tencent.mobileqq.search.model.y> list, String str) {
            return new do2.j(list, str, this.f284781f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g extends k {
        g(on2.b bVar, String str, int i3) {
            super(bVar, str, i3);
        }

        @Override // com.tencent.mobileqq.search.searchengine.GroupSearchEngine.k
        public x d(List<x> list) {
            return new q(list);
        }

        @Override // com.tencent.mobileqq.search.searchengine.GroupSearchEngine.k
        public x e(List<com.tencent.mobileqq.search.model.y> list, String str) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h extends j {
        h(on2.b bVar, String str, int i3) {
            super(bVar, str, i3);
        }

        @Override // com.tencent.mobileqq.search.searchengine.GroupSearchEngine.k
        public x e(List<com.tencent.mobileqq.search.model.y> list, String str) {
            return new do2.d(list, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class i extends k {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f284785f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(on2.b bVar, String str, int i3, int i16) {
            super(bVar, str, i3);
            this.f284785f = i16;
        }

        @Override // com.tencent.mobileqq.search.searchengine.GroupSearchEngine.k
        public x e(List<com.tencent.mobileqq.search.model.y> list, String str) {
            return new do2.e(list, str, this.f284785f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static abstract class j extends k {
        public j(on2.b bVar, String str, int i3) {
            super(bVar, str, i3);
            if (bVar instanceof com.tencent.mobileqq.search.business.contact.a) {
            } else {
                throw new IllegalArgumentException();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ List j(pn2.a aVar, List list) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 0) {
                b(aVar, arrayList, list, e(list, aVar.f426495a));
                this.f284789c = list.size();
            }
            return arrayList;
        }

        public Future<List<x>> k(final pn2.a aVar) {
            return ((com.tencent.mobileqq.search.business.contact.a) this.f284787a).b(aVar, new Function1() { // from class: com.tencent.mobileqq.search.searchengine.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    List j3;
                    j3 = GroupSearchEngine.j.this.j(aVar, (List) obj);
                    return j3;
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static abstract class k {

        /* renamed from: a, reason: collision with root package name */
        public final on2.b f284787a;

        /* renamed from: b, reason: collision with root package name */
        public long f284788b;

        /* renamed from: c, reason: collision with root package name */
        public int f284789c;

        /* renamed from: d, reason: collision with root package name */
        public String f284790d;

        /* renamed from: e, reason: collision with root package name */
        public int f284791e;

        public k(on2.b bVar, String str, int i3) {
            this.f284787a = bVar;
            this.f284790d = str;
            this.f284791e = i3;
            TextUtils.isEmpty(str);
        }

        protected void a(x xVar, List<x> list) {
            int s16 = SearchUtil.s();
            com.tencent.mobileqq.search.model.i iVar = new com.tencent.mobileqq.search.model.i(xVar);
            iVar.j(s16);
            xVar.j(s16);
            list.add(iVar);
            list.add(xVar);
        }

        protected void b(pn2.a aVar, List<x> list, List<com.tencent.mobileqq.search.model.y> list2, x xVar) {
            com.tencent.mobileqq.search.model.i iVar;
            if ((xVar instanceof do2.h) && xVar.o() != null && xVar.o().size() > 0) {
                aVar.f426496b.putBoolean("hasLocalPeopleOrTroop", true);
            }
            if (xVar != null) {
                int s16 = SearchUtil.s();
                boolean z16 = false;
                if (xVar.o() != null && xVar.o().size() > xVar.n()) {
                    z16 = true;
                }
                if (xVar instanceof do2.d) {
                    iVar = null;
                } else if (xVar instanceof do2.e) {
                    iVar = new com.tencent.mobileqq.search.model.i(xVar, HardCodeUtil.qqStr(R.string.n5w), z16);
                } else if (vy2.b.d(MobileQQ.sMobileQQ.peekAppRuntime()) == 1) {
                    iVar = new com.tencent.mobileqq.search.model.i(xVar, xVar.l().toString() + " " + this.f284788b + "ms", z16);
                } else if (xVar instanceof p) {
                    iVar = new com.tencent.mobileqq.search.model.i(xVar, HardCodeUtil.qqStr(R.string.n5c), true);
                } else if (xVar instanceof do2.j) {
                    iVar = new com.tencent.mobileqq.search.model.i(xVar, xVar.l(), z16);
                } else if (xVar instanceof com.tencent.mobileqq.search.ftsmsg.a) {
                    iVar = new com.tencent.mobileqq.search.model.i(xVar, HardCodeUtil.qqStr(R.string.n5k), z16);
                } else {
                    iVar = new com.tencent.mobileqq.search.model.i(xVar);
                }
                if (iVar != null) {
                    iVar.j(s16);
                    list.add(iVar);
                }
                xVar.j(s16);
                list.add(xVar);
            }
            x c16 = c(list2, aVar.f426495a);
            if ((c16 instanceof do2.h) && c16.o() != null && c16.o().size() > 0) {
                aVar.f426496b.putBoolean("hasLocalPeopleOrTroop", true);
            }
            if (c16 != null) {
                a(c16, list);
            }
            x f16 = f(list2, aVar.f426495a);
            if ((f16 instanceof com.tencent.mobileqq.search.model.j) && f16.o() != null && f16.o().size() > 0) {
                aVar.f426496b.putBoolean("hasLocalPeopleOrTroop", true);
            }
            if (f16 != null) {
                a(f16, list);
            }
            x g16 = g(list2, aVar.f426495a);
            if (g16 != null) {
                list.add(new com.tencent.mobileqq.search.model.i(g16));
                list.add(g16);
            }
        }

        protected x c(List<com.tencent.mobileqq.search.model.y> list, String str) {
            return null;
        }

        protected x d(List<x> list) {
            return null;
        }

        protected abstract x e(List<com.tencent.mobileqq.search.model.y> list, String str);

        protected x f(List<com.tencent.mobileqq.search.model.y> list, String str) {
            return null;
        }

        protected x g(List<com.tencent.mobileqq.search.model.y> list, String str) {
            return null;
        }

        public List<x> h(pn2.a aVar) {
            QLog.d("GroupSearchEngine", 4, "search begin,  type " + this.f284790d);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar.f426496b == null) {
                aVar.f426496b = new Bundle();
            }
            aVar.f426496b.putBoolean("searchRequestFromHome", true);
            ArrayList arrayList = new ArrayList();
            List<com.tencent.mobileqq.search.model.y> arrayList2 = new ArrayList<>();
            List<x> arrayList3 = new ArrayList<>();
            on2.b bVar = this.f284787a;
            if (bVar instanceof NtGroupLocalInfoSearchEngine) {
                arrayList3 = bVar.a(aVar);
            } else {
                arrayList2 = bVar.a(aVar);
            }
            QLog.d("GroupSearchEngine", 4, "engine finish search,  type " + this.f284790d);
            this.f284788b = System.currentTimeMillis() - currentTimeMillis;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                b(aVar, arrayList, arrayList2, e(arrayList2, aVar.f426495a));
                this.f284789c = arrayList2.size();
            } else if (arrayList3 != null && !arrayList3.isEmpty()) {
                Iterator<x> it = ((q) d(arrayList3)).s().iterator();
                while (it.hasNext()) {
                    b(aVar, arrayList, arrayList2, it.next());
                }
                this.f284789c = arrayList3.size();
            } else {
                this.f284789c = 0;
            }
            QLog.d("GroupSearchEngine", 4, "search results Time-consuming,  type ", this.f284790d, "\uff0ccost:", Long.valueOf(this.f284788b));
            return arrayList;
        }
    }

    public GroupSearchEngine(AppInterface appInterface, int i3) {
        this.E = i3;
    }

    private void n(ArrayList<k> arrayList, AppInterface appInterface) {
        arrayList.add(new h(new FavoriteSearchEngine(appInterface), "favorite", 60));
    }

    private void o(ArrayList<k> arrayList, AppInterface appInterface, int i3) {
        arrayList.add(new i(new FileManagerSearchEngine(appInterface, i3), "file", 100, i3));
    }

    private void p(ArrayList<k> arrayList, AppInterface appInterface, int i3) {
        arrayList.add(new f(new MiniProgramSearchEngine(appInterface, i3), SearchConfig.ENGINE_MINIPROGRAM, 0, i3));
    }

    private void q(ArrayList<k> arrayList, int i3) {
        arrayList.add(new g(new NtGroupLocalInfoSearchEngine(i3), SearchConfig.ENGINE_LOCAL_INFO, 20));
    }

    private void s() {
        ae searchService = ((IKernelService) r().getRuntimeService(IKernelService.class, "")).getSearchService();
        if (searchService != null) {
            searchService.initTokenizeUtil();
        }
    }

    private ArrayList<k> t() {
        ArrayList<k> arrayList = new ArrayList<>();
        if (this.E == 12 && !StudyModeManager.w()) {
            arrayList.add(new d(new PublicAccountSearchEngine(r(), this.E), SearchConfig.ENGINE_PUBLIC_ACCOUNT, 50));
            arrayList.add(new e(new NetSearchEngine(r(), G, this.E), SearchConfig.ENGINE_NET_SEARCH, 0));
            Collections.sort(arrayList, F);
            return arrayList;
        }
        q(arrayList, this.E);
        if (!StudyModeManager.t()) {
            p(arrayList, r(), this.E);
        }
        n(arrayList, r());
        o(arrayList, r(), this.E);
        Collections.sort(arrayList, F);
        return arrayList;
    }

    private void u() {
        ae searchService = ((IKernelService) r().getRuntimeService(IKernelService.class, "")).getSearchService();
        if (searchService != null) {
            searchService.releaseTokenizeUtil();
        }
    }

    private void w() {
        QLog.i("GroupSearchEngine", 1, "stopTask");
        Future future = this.f284752e;
        if (future != null) {
            future.cancel(true);
            Future future2 = this.f284752e;
            if (future2 instanceof Runnable) {
                G.remove((Runnable) future2);
            }
        }
        SearchRunnable searchRunnable = this.f284753f;
        if (searchRunnable != null) {
            searchRunnable.cancel();
        }
        ScheduledFuture scheduledFuture = this.f284754h;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f284756m;
            if (scheduledThreadPoolExecutor != null) {
                ScheduledFuture scheduledFuture2 = this.f284754h;
                if (scheduledFuture2 instanceof Runnable) {
                    scheduledThreadPoolExecutor.remove((Runnable) scheduledFuture2);
                }
            }
        }
        TroopMemberSearchRunnable troopMemberSearchRunnable = this.f284755i;
        if (troopMemberSearchRunnable != null) {
            troopMemberSearchRunnable.cancel();
        }
    }

    @Override // on2.b
    public List<x> a(pn2.a aVar) {
        return null;
    }

    @Override // on2.b
    public void c(pn2.a aVar, on2.d<x> dVar) {
        this.D = aVar.f426495a;
        if (aVar.f426496b == null) {
            aVar.f426496b = new Bundle();
        }
        aVar.f426496b.putBoolean("bSearchNet", true);
        aVar.f426496b.putInt("iNumber", 11);
        aVar.f426496b.putBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", true);
        aVar.f426496b.putBoolean("searchTroopMember", false);
        w();
        SearchRunnable searchRunnable = new SearchRunnable(aVar, dVar);
        this.f284753f = searchRunnable;
        this.f284752e = G.submit(searchRunnable);
        SearchUtils.W0("all_result", "active_local", this.D);
    }

    @Override // on2.b
    public void cancel() {
        if (this.C == null) {
            return;
        }
        rn2.d.a();
        synchronized (this.C) {
            for (int i3 = 0; i3 < this.C.size(); i3++) {
                this.C.get(i3).f284787a.cancel();
            }
        }
        w();
    }

    @Override // on2.b
    public void destroy() {
        int i3;
        String num;
        synchronized (this.C) {
            for (int i16 = 0; i16 < this.C.size(); i16++) {
                this.C.get(i16).f284787a.destroy();
            }
        }
        u();
        if (this.f284751d != -1) {
            HashMap hashMap = new HashMap();
            synchronized (this.C) {
                for (i3 = 0; i3 < this.C.size(); i3++) {
                    hashMap.put(this.C.get(i3).f284790d, String.valueOf(this.C.get(i3).f284788b));
                    hashMap.put(this.C.get(i3).f284790d + "_size", String.valueOf(this.C.get(i3).f284789c));
                }
            }
            String str = this.D;
            if (str == null) {
                str = "";
            }
            hashMap.put("keyword", str);
            String str2 = this.D;
            if (str2 == null) {
                num = "0";
            } else {
                num = Integer.toString(str2.trim().split("\\s+").length);
            }
            hashMap.put("keyword_count", num);
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(r().getCurrentAccountUin(), "GroupSearchEngineSearch", true, this.f284751d, 0L, SearchUtils.a0(hashMap), "", false);
        }
    }

    @Override // on2.b
    public void init() {
        long currentTimeMillis = System.currentTimeMillis();
        SearchConfigManager.d(r());
        s();
        synchronized (this.C) {
            Collections.sort(this.C, F);
        }
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            this.C.get(i3).f284787a.init();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("GroupSearchEngine", 2, "GroupSearchEngine.init() cost time : " + (currentTimeMillis2 - currentTimeMillis));
        }
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(r().getCurrentAccountUin(), "GroupSearchEngineInit", true, currentTimeMillis2 - currentTimeMillis, 0L, SearchUtils.a0(null), "", false);
    }

    public void m() {
        synchronized (this.C) {
            for (int i3 = 0; i3 < this.C.size(); i3++) {
                on2.b bVar = this.C.get(i3).f284787a;
                if (bVar instanceof FTSMessageSearchEngine) {
                    ((FTSMessageSearchEngine) bVar).g();
                }
            }
        }
    }

    @Override // on2.b
    public void pause() {
        synchronized (this.C) {
            for (int i3 = 0; i3 < this.C.size(); i3++) {
                this.C.get(i3).f284787a.pause();
            }
        }
    }

    public /* synthetic */ AppInterface r() {
        return on2.a.a(this);
    }

    @Override // on2.b
    public void resume() {
        synchronized (this.C) {
            for (int i3 = 0; i3 < this.C.size(); i3++) {
                this.C.get(i3).f284787a.resume();
            }
        }
    }

    public void v() {
        synchronized (this.C) {
            for (int i3 = 0; i3 < this.C.size(); i3++) {
                on2.b bVar = this.C.get(i3).f284787a;
                if (bVar instanceof FTSMessageSearchEngine) {
                    ((FTSMessageSearchEngine) bVar).k();
                }
            }
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
    }
}
