package com.tencent.mobileqq.search.searchlocal.repository.history;

import android.database.Cursor;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.search.searchlocal.repository.history.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchlocal/repository/history/b;", "Lcom/tencent/mobileqq/search/searchlocal/repository/history/a;", "", "k", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/search/searchlocal/model/SearchHistory;", "Lkotlin/collections/ArrayList;", "j", "sh", "", "i", "", "key", "l", "e", "f", "Lcom/tencent/mobileqq/persistence/EntityManager;", "a", "Lcom/tencent/mobileqq/persistence/EntityManager;", "getEm", "()Lcom/tencent/mobileqq/persistence/EntityManager;", "em", "<init>", "(Lcom/tencent/mobileqq/persistence/EntityManager;)V", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EntityManager em;

    public b(@NotNull EntityManager em5) {
        Intrinsics.checkNotNullParameter(em5, "em");
        this.em = em5;
    }

    @Override // com.tencent.mobileqq.search.searchlocal.repository.history.a
    public boolean a(@NotNull SearchHistory searchHistory) {
        return a.C8548a.c(this, searchHistory);
    }

    @Override // com.tencent.mobileqq.search.searchlocal.repository.history.a
    public boolean b(@NotNull SearchHistory searchHistory) {
        return a.C8548a.b(this, searchHistory);
    }

    @Override // com.tencent.mobileqq.search.searchlocal.repository.history.a
    public boolean c(@NotNull SearchHistory searchHistory, @NotNull IPhoneContactService iPhoneContactService) {
        return a.C8548a.e(this, searchHistory, iPhoneContactService);
    }

    @Override // com.tencent.mobileqq.search.searchlocal.repository.history.a
    public void d(@Nullable String str, @Nullable hx3.b<String> bVar) {
        a.C8548a.h(this, str, bVar);
    }

    @Override // com.tencent.mobileqq.search.searchlocal.repository.history.a
    public boolean e(@NotNull SearchHistory sh5) {
        Intrinsics.checkNotNullParameter(sh5, "sh");
        int i3 = sh5.type;
        if (i3 == 10024) {
            Entity find = DBMethodProxy.find(this.em, (Class<? extends Entity>) SearchHistory.class, sh5.displayName + "10025");
            if (find != null) {
                this.em.remove(find);
            }
            return false;
        }
        if (i3 != 10025) {
            return false;
        }
        Entity find2 = DBMethodProxy.find(this.em, (Class<? extends Entity>) SearchHistory.class, sh5.displayName + "10024");
        if (!(find2 instanceof SearchHistory)) {
            return false;
        }
        SearchHistory searchHistory = (SearchHistory) find2;
        searchHistory.time = System.currentTimeMillis();
        searchHistory.count++;
        this.em.update(find2);
        return true;
    }

    @Override // com.tencent.mobileqq.search.searchlocal.repository.history.a
    public void f(@NotNull SearchHistory sh5) {
        Intrinsics.checkNotNullParameter(sh5, "sh");
        Entity find = DBMethodProxy.find(this.em, (Class<? extends Entity>) SearchHistory.class, sh5.key);
        if (find instanceof SearchHistory) {
            SearchHistory searchHistory = (SearchHistory) find;
            searchHistory.time = sh5.time;
            searchHistory.count++;
            int i3 = searchHistory.type;
            int i16 = sh5.type;
            if (i3 != i16) {
                searchHistory.extralInfo = sh5.extralInfo;
                searchHistory.type = i16;
                searchHistory.troopUin = sh5.troopUin;
                searchHistory.displayName = sh5.displayName;
            }
            this.em.update(find);
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = this.em.query(false, SearchHistory.class.getSimpleName(), (String[]) null, (String) null, (String[]) null, (String) null, (String) null, "time asc , count asc", (String) null);
                if (cursor != null && 20 <= cursor.getCount()) {
                    if (cursor.moveToFirst()) {
                        String key = cursor.getString(cursor.getColumnIndex("key"));
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        l(sh5, key);
                    }
                } else {
                    this.em.persist(sh5);
                }
                if (cursor == null) {
                    return;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (0 == 0) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.search.searchlocal.repository.history.a
    public boolean g(@NotNull SearchHistory searchHistory) {
        return a.C8548a.d(this, searchHistory);
    }

    public boolean h(@NotNull SearchHistory searchHistory) {
        return a.C8548a.f(this, searchHistory);
    }

    public boolean i(@Nullable SearchHistory sh5) {
        if (sh5 != null) {
            sh5.setStatus(1001);
            return this.em.remove(sh5);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e1, code lost:
    
        if (r2 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e3, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f1, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ee, code lost:
    
        if (r2 != null) goto L45;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<SearchHistory> j() {
        ArrayList<SearchHistory> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = this.em.query(false, SearchHistory.class.getSimpleName(), (String[]) null, (String) null, (String[]) null, (String) null, (String) null, "time desc", (String) null);
            if (cursor != null && cursor.moveToFirst()) {
                int i3 = 0;
                do {
                    SearchHistory searchHistory = new SearchHistory();
                    int columnIndex = cursor.getColumnIndex("key");
                    if (columnIndex >= 0) {
                        searchHistory.key = cursor.getString(columnIndex);
                    }
                    int columnIndex2 = cursor.getColumnIndex(CommonConstant.KEY_DISPLAY_NAME);
                    if (columnIndex2 >= 0) {
                        searchHistory.displayName = cursor.getString(columnIndex2);
                    }
                    int columnIndex3 = cursor.getColumnIndex("uin");
                    if (columnIndex3 >= 0) {
                        searchHistory.uin = cursor.getString(columnIndex3);
                    }
                    int columnIndex4 = cursor.getColumnIndex("troopUin");
                    if (columnIndex4 >= 0) {
                        searchHistory.troopUin = cursor.getString(columnIndex4);
                    }
                    int columnIndex5 = cursor.getColumnIndex("type");
                    if (columnIndex5 >= 0) {
                        searchHistory.type = cursor.getInt(columnIndex5);
                    }
                    int columnIndex6 = cursor.getColumnIndex("extralInfo");
                    if (columnIndex6 >= 0) {
                        searchHistory.extralInfo = cursor.getString(columnIndex6);
                    }
                    int columnIndex7 = cursor.getColumnIndex("count");
                    if (columnIndex7 >= 0) {
                        searchHistory.count = cursor.getInt(columnIndex7);
                    }
                    int columnIndex8 = cursor.getColumnIndex("time");
                    if (columnIndex8 >= 0) {
                        searchHistory.time = cursor.getLong(columnIndex8);
                    }
                    if (cursor.getColumnIndex("_id") >= 0) {
                        searchHistory.setId(cursor.getInt(r5));
                    }
                    boolean h16 = h(searchHistory);
                    if (i3 >= 20) {
                        h16 = true;
                    }
                    if (h16) {
                        Entity find = DBMethodProxy.find(this.em, (Class<? extends Entity>) SearchHistory.class, searchHistory.key);
                        Intrinsics.checkNotNull(find, "null cannot be cast to non-null type com.tencent.mobileqq.search.searchlocal.model.SearchHistory");
                        this.em.remove((SearchHistory) find);
                    } else if (i3 < 20) {
                        arrayList.add(searchHistory);
                    }
                    i3++;
                } while (cursor.moveToNext());
            }
        } catch (Exception unused) {
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    public void l(@NotNull SearchHistory sh5, @NotNull String key) {
        Intrinsics.checkNotNullParameter(sh5, "sh");
        Intrinsics.checkNotNullParameter(key, "key");
        Entity find = DBMethodProxy.find(this.em, (Class<? extends Entity>) SearchHistory.class, key);
        if (find instanceof SearchHistory) {
            SearchHistory searchHistory = (SearchHistory) find;
            searchHistory.key = sh5.key;
            searchHistory.uin = sh5.uin;
            searchHistory.troopUin = sh5.troopUin;
            searchHistory.time = sh5.time;
            searchHistory.displayName = sh5.displayName;
            searchHistory.type = sh5.type;
            searchHistory.count = sh5.count;
            searchHistory.extralInfo = sh5.extralInfo;
            this.em.update(find);
            return;
        }
        QLog.i("QQSearch.NetDetail.SearchHistoryEntityDBHelper", 1, "original == null");
    }

    public void k() {
    }
}
