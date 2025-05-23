package cooperation.qqfav.globalsearch;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.cl;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.search.model.x;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.k;
import cooperation.plugin.IPluginManager;
import cooperation.qqfav.QfavHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import mqq.app.api.ProcessConstant;
import on2.d;
import ua0.j;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FavoriteSearchEngine implements on2.b<cooperation.qqfav.globalsearch.b>, com.tencent.mobileqq.search.business.contact.a<cooperation.qqfav.globalsearch.b> {
    private static boolean G;
    private Thread D;
    private Thread E;

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f390616d;

    /* renamed from: e, reason: collision with root package name */
    private String f390617e;

    /* renamed from: f, reason: collision with root package name */
    private long f390618f;

    /* renamed from: h, reason: collision with root package name */
    private int f390619h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f390620i = false;

    /* renamed from: m, reason: collision with root package name */
    private List<cooperation.qqfav.globalsearch.b> f390621m = new ArrayList();
    private final QueryRunnable C = new QueryRunnable();
    private final SearchRunnable F = new SearchRunnable();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class QueryRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        protected String f390622d;

        /* renamed from: e, reason: collision with root package name */
        protected long f390623e;

        /* renamed from: f, reason: collision with root package name */
        protected int f390624f;

        /* renamed from: h, reason: collision with root package name */
        protected boolean f390625h;

        /* renamed from: i, reason: collision with root package name */
        protected pn2.a f390626i;

        QueryRunnable() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0203, code lost:
        
            if (r8 != null) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x021a, code lost:
        
            r0 = r13.this$0.C;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0220, code lost:
        
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x022b, code lost:
        
            if (r13.this$0.E != java.lang.Thread.currentThread()) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x022d, code lost:
        
            r13.this$0.f390620i = true;
            r13.this$0.C.notify();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x023b, code lost:
        
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x023c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0217, code lost:
        
            r8.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0215, code lost:
        
            if (0 == 0) goto L59;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z16;
            cooperation.qqfav.globalsearch.b bVar;
            boolean z17;
            Cursor cursor = null;
            try {
                try {
                    int i3 = 2;
                    cursor = ContactsMonitor.query(FavoriteSearchEngine.this.f390616d.getApplication().getContentResolver(), Uri.parse("content://qq.favorites/global_search/" + FavoriteSearchEngine.this.f390616d.getAccount()), null, null, new String[]{this.f390622d, "" + this.f390624f, "" + this.f390623e, "" + this.f390625h}, null);
                    if (cursor == null) {
                        FavoriteSearchEngine.this.f390619h = -1;
                    } else if (!cursor.moveToFirst()) {
                        FavoriteSearchEngine.this.f390619h = -1;
                    } else {
                        if (FavoriteSearchEngine.this.f390621m.size() < 5 && cursor.getCount() > 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (FavoriteSearchEngine.this.f390621m.size() > 0) {
                            FavoriteSearchEngine.this.f390621m.remove(FavoriteSearchEngine.this.f390621m.size() - 1);
                        }
                        do {
                            bVar = new cooperation.qqfav.globalsearch.b();
                            bVar.J = this.f390626i.f426495a;
                            bVar.G = cursor.getLong(0);
                            bVar.H = cursor.getLong(4);
                            bVar.I = cursor.getLong(5);
                            bVar.K = cursor.getString(1);
                            bVar.L = cursor.getString(2);
                            bVar.Q = cursor.getString(3);
                            bVar.T = cursor.getInt(6);
                            bVar.R = cursor.getInt(8);
                            bVar.S = cursor.getBlob(7);
                            bVar.U = cursor.getInt(9);
                            if (cursor.getInt(10) > 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            bVar.V = z17;
                            bVar.N = cursor.getInt(11);
                            bVar.P = cursor.getInt(12);
                            bVar.M = cursor.getInt(13);
                            bVar.W = cursor.getInt(14);
                            bVar.X = FavoriteSearchEngine.this.f390621m.size();
                            bVar.G();
                            FavoriteSearchEngine.this.f390621m.add(bVar);
                        } while (cursor.moveToNext());
                        long j3 = bVar.G;
                        if (j3 < 0) {
                            if (j3 == -2) {
                                FavoriteSearchEngine.this.f390618f = bVar.H;
                                FavoriteSearchEngine favoriteSearchEngine = FavoriteSearchEngine.this;
                                if (!this.f390625h) {
                                    i3 = 1;
                                }
                                favoriteSearchEngine.f390619h = i3;
                            } else {
                                if (cursor.getCount() <= 1 && this.f390623e <= bVar.H) {
                                    FavoriteSearchEngine.this.f390619h = -1;
                                }
                                FavoriteSearchEngine.this.f390618f = bVar.H;
                            }
                        }
                        if (z16) {
                            int min = Math.min(4, FavoriteSearchEngine.this.f390621m.size() - 1);
                            for (int i16 = 0; i16 < min - 1; i16++) {
                                int i17 = (min - i16) - 1;
                                for (int i18 = i17; i18 > 0; i18--) {
                                    int i19 = i17 - i18;
                                    cooperation.qqfav.globalsearch.b bVar2 = (cooperation.qqfav.globalsearch.b) FavoriteSearchEngine.this.f390621m.get(i19);
                                    int i26 = i19 + 1;
                                    if (bVar2.W > ((cooperation.qqfav.globalsearch.b) FavoriteSearchEngine.this.f390621m.get(i26)).W) {
                                        FavoriteSearchEngine.this.f390621m.set(i19, (cooperation.qqfav.globalsearch.b) FavoriteSearchEngine.this.f390621m.get(i26));
                                        FavoriteSearchEngine.this.f390621m.set(i26, bVar2);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e("FavoriteSearchEngine", 1, "FavoriteSearchEngine query run error", e16);
                }
            } catch (Throwable th5) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class SearchRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        pn2.a f390627d;

        /* renamed from: e, reason: collision with root package name */
        d<cooperation.qqfav.globalsearch.b> f390628e;

        SearchRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            pn2.a aVar;
            pn2.a aVar2 = this.f390627d;
            if (aVar2 == null) {
                return;
            }
            String str = aVar2.f426495a;
            List<cooperation.qqfav.globalsearch.b> a16 = FavoriteSearchEngine.this.a(aVar2);
            synchronized (this) {
                if (this.f390628e != null && aVar2 == (aVar = this.f390627d) && str.equals(aVar.f426495a)) {
                    this.f390628e.onFinish(a16, 1);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b implements d<cooperation.qqfav.globalsearch.b> {

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f390630d = new AtomicBoolean(false);

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f390631e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ cl f390632f;

        b(long j3, cl clVar) {
            this.f390631e = j3;
            this.f390632f = clVar;
        }

        @Override // on2.d
        public void onCancelSearch() {
            if (!this.f390630d.compareAndSet(false, true)) {
                return;
            }
            this.f390632f.complete(Collections.emptyList());
            QLog.d("FavoriteSearchEngine", 1, "onCancelSearch");
        }

        @Override // on2.d
        public /* synthetic */ void onFinish(List<cooperation.qqfav.globalsearch.b> list, pn2.b bVar) {
            on2.c.c(this, list, bVar);
        }

        @Override // on2.d
        public /* synthetic */ void onUpdate(List<cooperation.qqfav.globalsearch.b> list) {
            on2.c.d(this, list);
        }

        @Override // on2.d
        public void onFinish(List<cooperation.qqfav.globalsearch.b> list, int i3) {
            if (this.f390630d.compareAndSet(false, true)) {
                long currentTimeMillis = System.currentTimeMillis() - this.f390631e;
                if (list != null) {
                    this.f390632f.complete(list);
                    QLog.d("FavoriteSearchEngine", 1, "onFinish", Integer.valueOf(list.size()), " timeCost=", Long.valueOf(currentTimeMillis));
                } else {
                    this.f390632f.complete(Collections.emptyList());
                    QLog.d("FavoriteSearchEngine", 1, "onFinish empty result timeCost=", Long.valueOf(currentTimeMillis));
                }
                HashMap hashMap = new HashMap(3);
                hashMap.put("netType", p.l());
                hashMap.put("resultCount", "0");
                hashMap.put("duration", currentTimeMillis + "");
                j.d(true, hashMap);
            }
        }

        @Override // on2.d
        public /* synthetic */ void onUpdate(List<cooperation.qqfav.globalsearch.b> list, boolean z16) {
            on2.c.e(this, list, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Future<List<x>> f390634a = null;

        /* renamed from: b, reason: collision with root package name */
        public String f390635b = "";

        /* renamed from: c, reason: collision with root package name */
        public long f390636c = System.currentTimeMillis();
    }

    public FavoriteSearchEngine(AppInterface appInterface) {
        this.f390616d = appInterface;
    }

    public static void l(AppInterface appInterface) {
        QLog.d("FavoriteSearchEngine", 2, "startFavProcess");
        IPluginManager iPluginManager = (IPluginManager) appInterface.getManager(QQManagerFactory.MGR_PLUGIN);
        if (iPluginManager.isPlugininstalled("qqfav.apk")) {
            m(appInterface);
        } else {
            iPluginManager.installPlugin("qqfav.apk", new a(appInterface));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(AppInterface appInterface) {
        try {
            Cursor query = ContactsMonitor.query(appInterface.getApplication().getContentResolver(), Uri.parse("content://qq.favorites/global_search/" + appInterface.getAccount()), null, null, null, null);
            if (query != null) {
                query.close();
            }
        } catch (Exception e16) {
            QLog.i("FavoriteSearchEngine", 1, "preFav", e16);
        }
    }

    @Override // on2.b
    public synchronized List<cooperation.qqfav.globalsearch.b> a(pn2.a aVar) {
        boolean z16;
        boolean z17;
        long j3;
        int i3;
        ArrayList arrayList = null;
        if (aVar != null) {
            String str = aVar.f426495a;
            if (str != null && str.trim().length() != 0) {
                if (!G) {
                    G = QfavHelper.r(false);
                }
                this.F.f390627d = aVar;
                Bundle bundle = aVar.f426496b;
                if (bundle != null) {
                    i3 = bundle.getInt("iNumber", 1);
                    j3 = aVar.f426496b.getLong("lModifyTime", Long.MAX_VALUE);
                    z16 = aVar.f426496b.getBoolean("bMore", false);
                    z17 = aVar.f426496b.getBoolean("bSearchNet", false);
                } else {
                    z16 = false;
                    z17 = false;
                    j3 = Long.MAX_VALUE;
                    i3 = 1;
                }
                if (!aVar.f426495a.equals(this.f390617e) || (z17 && this.f390619h == 1)) {
                    this.f390617e = aVar.f426495a;
                    this.f390618f = Long.MAX_VALUE;
                    this.f390621m.clear();
                    this.f390619h = 0;
                }
                int i16 = this.f390619h;
                if (i16 != 2 && (z17 || i16 != 1)) {
                    if (z16 && this.f390621m.size() > 0) {
                        j3 = Math.min(j3, this.f390618f);
                    }
                    this.f390619h = 0;
                    this.D = Thread.currentThread();
                    QueryRunnable queryRunnable = this.C;
                    queryRunnable.f390622d = this.f390617e;
                    queryRunnable.f390624f = i3;
                    queryRunnable.f390623e = j3;
                    queryRunnable.f390625h = z17;
                    queryRunnable.f390626i = aVar;
                    synchronized (queryRunnable) {
                        BaseThread baseThread = new BaseThread(this.C);
                        this.E = baseThread;
                        baseThread.start();
                        while (!this.f390620i) {
                            try {
                                LockMethodProxy.wait(this.C);
                            } catch (InterruptedException unused) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(ProcessConstant.QQFAV, 2, "InterruptedException, search cancel.");
                                }
                            }
                        }
                        this.f390620i = false;
                    }
                    ArrayList arrayList2 = new ArrayList(this.f390621m);
                    if (this.f390619h == -1 && !arrayList2.isEmpty()) {
                        ((cooperation.qqfav.globalsearch.b) arrayList2.get(arrayList2.size() - 1)).G = -3L;
                    }
                    if (!z16) {
                        if (arrayList2.size() > 1) {
                            arrayList2.remove(arrayList2.size() - 1);
                        }
                        return arrayList;
                    }
                    arrayList = arrayList2;
                    return arrayList;
                }
                ArrayList arrayList3 = new ArrayList(this.f390621m);
                if (!z16) {
                    if (this.f390621m.size() > 1) {
                        arrayList3.remove(arrayList3.size() - 1);
                    }
                    return arrayList;
                }
                arrayList = arrayList3;
                return arrayList;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.search.business.contact.a
    @NonNull
    public <R> Future<R> b(@NonNull pn2.a aVar, @NonNull Function1<? super List<? extends cooperation.qqfav.globalsearch.b>, ? extends R> function1) {
        cl clVar = new cl(function1);
        QLog.d("FavoriteSearchEngine", 1, "start searchAsyncWithMapFunc", k.d(aVar.f426495a));
        c(aVar, new b(System.currentTimeMillis(), clVar));
        return clVar;
    }

    @Override // on2.b
    public void c(pn2.a aVar, d<cooperation.qqfav.globalsearch.b> dVar) {
        String str;
        if (aVar != null && (str = aVar.f426495a) != null && str.trim().length() != 0) {
            synchronized (this.F) {
                SearchRunnable searchRunnable = this.F;
                searchRunnable.f390627d = aVar;
                searchRunnable.f390628e = dVar;
                ThreadManagerV2.removeJobFromThreadPool(searchRunnable, 32);
                ThreadManagerV2.excute(this.F, 32, null, false);
            }
        }
    }

    @Override // on2.b
    public void cancel() {
        synchronized (this.F) {
            d<cooperation.qqfav.globalsearch.b> dVar = this.F.f390628e;
            if (dVar != null) {
                dVar.onCancelSearch();
            }
            SearchRunnable searchRunnable = this.F;
            searchRunnable.f390627d = null;
            searchRunnable.f390628e = null;
            ThreadManagerV2.removeJobFromThreadPool(searchRunnable, 32);
        }
        Thread thread = this.D;
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override // on2.b
    public void init() {
        if (!G) {
            G = QfavHelper.r(false);
        }
    }

    @Override // on2.b
    public void destroy() {
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends OnPluginInstallListener.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f390629d;

        a(AppInterface appInterface) {
            this.f390629d = appInterface;
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallBegin(String str) throws RemoteException {
            QLog.d("FavoriteSearchEngine", 2, "qfav plugin onInstallBegin...");
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallError(String str, int i3) throws RemoteException {
            QLog.d("FavoriteSearchEngine", 2, "qfav plugin onInstallError...");
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallFinish(String str) throws RemoteException {
            QLog.d("FavoriteSearchEngine", 2, "qfav plugin onInstallFinish...");
            FavoriteSearchEngine.m(this.f390629d);
        }

        @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
        public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
        }
    }
}
