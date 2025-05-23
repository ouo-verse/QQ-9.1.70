package com.tencent.mobileqq.search;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ae extends AsyncTask<Void, Void, Void> {

    /* renamed from: j, reason: collision with root package name */
    private static final ThreadPoolExecutor f282700j = new BaseThreadPoolExecutor(0, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new a());

    /* renamed from: k, reason: collision with root package name */
    private static Comparator<l> f282701k = new c();

    /* renamed from: l, reason: collision with root package name */
    private static Comparator<l> f282702l = new d();

    /* renamed from: b, reason: collision with root package name */
    private String f282704b;

    /* renamed from: c, reason: collision with root package name */
    private String f282705c;

    /* renamed from: d, reason: collision with root package name */
    private List<? extends l> f282706d;

    /* renamed from: g, reason: collision with root package name */
    private e f282709g;

    /* renamed from: a, reason: collision with root package name */
    private final int f282703a = 300;

    /* renamed from: h, reason: collision with root package name */
    boolean f282710h = false;

    /* renamed from: i, reason: collision with root package name */
    private ExecutorService f282711i = ProxyExecutors.newFixedThreadPool(20);

    /* renamed from: e, reason: collision with root package name */
    private List<Future<List<l>>> f282707e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private List<l> f282708f = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f282712d = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(runnable, "SearchTask #" + this.f282712d.getAndIncrement());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements Callable<List<l>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f282713d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f282714e;

        b(int i3, int i16) {
            this.f282713d = i3;
            this.f282714e = i16;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<l> call() {
            List<l> subList = ae.this.f282706d.subList(this.f282713d, this.f282714e);
            ArrayList<l> arrayList = new ArrayList();
            if (subList != null) {
                for (l lVar : subList) {
                    if (ae.this.isCancelled()) {
                        break;
                    }
                    lVar.match(ae.this.f282704b);
                    if (lVar.b() != Long.MIN_VALUE) {
                        int indexOf = arrayList.indexOf(lVar);
                        if (-1 == indexOf) {
                            arrayList.add(lVar);
                        } else if (((l) arrayList.get(indexOf)).b() < lVar.b()) {
                            arrayList.set(indexOf, lVar);
                        }
                    }
                }
                if (!ae.this.f282704b.equals(ae.this.f282705c)) {
                    for (l lVar2 : arrayList) {
                        if (ae.this.isCancelled()) {
                            break;
                        }
                        long b16 = lVar2.b();
                        lVar2.match(ae.this.f282705c);
                        if (lVar2.b() == Long.MIN_VALUE) {
                            lVar2.a(b16);
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements Comparator<l> {
        c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(l lVar, l lVar2) {
            long b16 = lVar.b();
            long b17 = lVar2.b();
            if (b16 < b17) {
                return 1;
            }
            if (b16 > b17) {
                return -1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements Comparator<l> {
        d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(l lVar, l lVar2) {
            long b16 = lVar.b();
            long b17 = lVar2.b();
            if (b16 < b17) {
                return 1;
            }
            if (b16 > b17) {
                return -1;
            }
            long c16 = lVar.c();
            long c17 = lVar2.c();
            if (c16 < c17) {
                return 1;
            }
            if (c16 > c17) {
                return -1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        void b(int i3, List<? extends l> list);
    }

    public ae(String str, String str2, List<? extends l> list, e eVar) {
        this.f282704b = str;
        this.f282705c = str2;
        this.f282706d = list;
        this.f282709g = eVar;
    }

    private void f(List<l> list, String str) {
        int i3 = 20;
        if (list.size() <= 20) {
            i3 = list.size();
        }
        for (int i16 = 0; i16 < i3; i16++) {
            QLog.isColorLevel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        long currentTimeMillis;
        if (this.f282706d != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchTask", 2, "Start doInBackground , keyword = " + this.f282704b);
            }
            int size = this.f282706d.size();
            int i3 = (size / 300) + 1;
            for (int i16 = 0; i16 < i3; i16++) {
                int i17 = i16 * 300;
                int i18 = i17 + 300;
                if (i18 > size) {
                    i18 = size;
                }
                if (!isCancelled() && !this.f282711i.isShutdown()) {
                    this.f282707e.add(this.f282711i.submit(new b(i17, i18)));
                }
            }
            try {
                this.f282708f.clear();
                currentTimeMillis = System.currentTimeMillis();
                for (int i19 = 0; i19 < this.f282707e.size() && !isCancelled(); i19++) {
                    List<l> list = this.f282707e.get(i19).get();
                    if (i19 == 0) {
                        this.f282708f.addAll(list);
                    } else {
                        for (l lVar : list) {
                            if (isCancelled()) {
                                break;
                            }
                            int indexOf = this.f282708f.indexOf(lVar);
                            if (-1 == indexOf) {
                                this.f282708f.add(lVar);
                            } else if (this.f282708f.get(indexOf).b() < lVar.b()) {
                                this.f282708f.set(indexOf, lVar);
                            }
                        }
                    }
                    list.clear();
                }
                this.f282707e.clear();
            } catch (InterruptedException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("SearchTask", 2, "InterruptedException happens, keyword = " + this.f282704b + ProgressTracer.SEPARATOR);
                }
            } catch (ExecutionException e17) {
                e17.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("SearchTask", 2, "InterruptedException happens, keyword = " + this.f282704b + ProgressTracer.SEPARATOR);
                }
            }
            if (isCancelled()) {
                return null;
            }
            g(this.f282708f);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("SearchTask", 2, "SearchTask ======= doInBackground time = " + (currentTimeMillis2 - currentTimeMillis) + " , keyword = " + this.f282704b);
            }
            this.f282710h = false;
        } else {
            this.f282710h = true;
            if (QLog.isColorLevel()) {
                QLog.d("SearchTask", 2, "doInBackground:: inputSet is null.");
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r36) {
        if (isCancelled()) {
            this.f282708f.clear();
            this.f282711i.shutdown();
            if (QLog.isColorLevel()) {
                QLog.d("SearchTask", 2, "onPostExecute:: isCancelled.");
                return;
            }
            return;
        }
        e eVar = this.f282709g;
        if (eVar != null) {
            eVar.b(!this.f282710h ? 1 : 0, this.f282708f);
            this.f282711i.shutdown();
        }
    }

    protected void g(List<l> list) {
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("SearchTask", 2, "start sortResultSet(), keyword = " + this.f282704b);
        }
        Collections.sort(list, f282701k);
        int min = Math.min(list.size(), 30);
        List<l> subList = list.subList(0, min);
        Collections.sort(subList, f282702l);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(subList);
        arrayList.addAll(list.subList(min, list.size()));
        f(list, "after sort ");
        if (QLog.isColorLevel()) {
            QLog.d("SearchTask", 2, "sortResultSet() time = " + (System.currentTimeMillis() - currentTimeMillis) + " , keyword = " + this.f282704b);
        }
    }

    @TargetApi(11)
    public void h() {
        executeOnExecutor(f282700j, new Void[0]);
        if (QLog.isColorLevel()) {
            QLog.d("SearchTask", 2, "Start execute , keyword = " + this.f282704b);
        }
    }
}
