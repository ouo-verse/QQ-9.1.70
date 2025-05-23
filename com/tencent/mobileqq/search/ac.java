package com.tencent.mobileqq.search;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.search.searchlocal.repository.history.SearchHistoryNTDBHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.manager.Manager;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ac implements Manager {
    public static boolean C = false;

    /* renamed from: d, reason: collision with root package name */
    public EntityManager f282631d;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.search.searchlocal.repository.history.b f282633f;

    /* renamed from: h, reason: collision with root package name */
    private AtomicBoolean f282634h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private final Object f282635i = new Object();

    /* renamed from: m, reason: collision with root package name */
    private final List<WeakReference<Function1<Boolean, Void>>> f282636m = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final SearchHistoryNTDBHelper f282632e = new SearchHistoryNTDBHelper();

    public ac(QQAppInterface qQAppInterface) {
        this.f282631d = qQAppInterface.getEntityManagerFactory().createEntityManager();
        this.f282633f = new com.tencent.mobileqq.search.searchlocal.repository.history.b(this.f282631d);
        l();
    }

    public static String f(AppInterface appInterface) {
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("search_keyword" + appInterface.getCurrentAccountUin(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void h(AtomicBoolean atomicBoolean, SearchHistory searchHistory, Boolean bool) {
        atomicBoolean.set(this.f282632e.t(searchHistory));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(ArrayList arrayList, long j3, List list) {
        QLog.d("SearchHistoryManager", 1, "moveEntityDBToNT listCount=", Integer.valueOf(arrayList.size()), "inserted Size", Integer.valueOf(list.size()), " cost=", Long.valueOf(System.currentTimeMillis() - j3));
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.f282633f.i((SearchHistory) arrayList.get(i3));
        }
        m();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit j(final long j3, List list) {
        if (list.isEmpty()) {
            final ArrayList<SearchHistory> j16 = this.f282633f.j();
            if (!j16.isEmpty()) {
                QLog.d("SearchHistoryManager", 1, "moveEntityDBToNT start save histories", Integer.valueOf(j16.size()));
                this.f282632e.H(j16, new Function1() { // from class: com.tencent.mobileqq.search.ab
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit i3;
                        i3 = ac.this.i(j16, j3, (List) obj);
                        return i3;
                    }
                });
                return null;
            }
            QLog.d("SearchHistoryManager", 1, "moveEntityDBToNT nothing because sqlite is null, cost=", Long.valueOf(System.currentTimeMillis() - j3));
            m();
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SearchHistoryManager", 1, "moveEntityDBToNT nothing \uff0csize=" + list.size() + " cost=", Long.valueOf(System.currentTimeMillis() - j3));
        }
        m();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void k(SearchHistory searchHistory, Boolean bool) {
        this.f282632e.G(searchHistory);
        return null;
    }

    private void l() {
        final long currentTimeMillis = System.currentTimeMillis();
        this.f282632e.C(new Function1() { // from class: com.tencent.mobileqq.search.aa
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j3;
                j3 = ac.this.j(currentTimeMillis, (List) obj);
                return j3;
            }
        });
    }

    private void m() {
        this.f282634h.set(true);
        synchronized (this.f282635i) {
            if (!this.f282636m.isEmpty()) {
                Iterator<WeakReference<Function1<Boolean, Void>>> it = this.f282636m.iterator();
                while (it.hasNext()) {
                    Function1<Boolean, Void> function1 = it.next().get();
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                    }
                }
                this.f282636m.clear();
            }
        }
    }

    public static void o(AppInterface appInterface, String str) {
        C = true;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putString("search_keyword" + appInterface.getCurrentAccountUin(), str);
        edit.commit();
    }

    public boolean e(final SearchHistory searchHistory) {
        QLog.d("SearchHistoryManager", 1, "SearchHistory, init load success?" + this.f282634h.get());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        n(new Function1() { // from class: com.tencent.mobileqq.search.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Void h16;
                h16 = ac.this.h(atomicBoolean, searchHistory, (Boolean) obj);
                return h16;
            }
        });
        return atomicBoolean.get();
    }

    public ArrayList<SearchHistory> g() {
        return this.f282632e.y();
    }

    public void n(Function1<Boolean, Void> function1) {
        if (function1 != null && this.f282634h.get()) {
            function1.invoke(Boolean.TRUE);
            return;
        }
        QLog.d("SearchHistoryManager", 1, "waiting for init ");
        synchronized (this.f282635i) {
            this.f282636m.add(new WeakReference<>(function1));
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f282632e.F();
        this.f282633f.k();
    }

    public void p(final SearchHistory searchHistory) {
        QLog.d("SearchHistoryManager", 1, "SearchHistory, init load success?" + this.f282634h.get());
        n(new Function1() { // from class: com.tencent.mobileqq.search.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Void k3;
                k3 = ac.this.k(searchHistory, (Boolean) obj);
                return k3;
            }
        });
    }
}
