package com.tencent.mobileqq.search.searchlocal.repository.history;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.search.searchlocal.repository.history.a;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.nativeinterface.IAddSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.ILoadSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUpdateSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchHistoryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchHistoryType;
import com.tencent.qqnt.kernel.nativeinterface.SearchPhoneItem;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b&\u0010'J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u0010H\u0016J \u0010\u0015\u001a\u00020\r2\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0013\u0012\u0004\u0012\u00020\r0\u0012J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J0\u0010\u001a\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0013\u0012\u0004\u0012\u00020\r0\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\f\u0010\u001f\u001a\u0004\u0018\u00010\u0002*\u00020\u0003R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/search/searchlocal/repository/history/SearchHistoryNTDBHelper;", "Lcom/tencent/mobileqq/search/searchlocal/repository/history/a;", "Lcom/tencent/mobileqq/search/searchlocal/model/SearchHistory;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHistoryItem;", ReportConstant.COSTREPORT_PREFIX, "sh", HippyTKDListViewAdapter.X, "", "key", "w", "", "historyId", "v", "", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "y", "Lkotlin/Function1;", "", "cb", BdhLogUtil.LogTag.Tag_Conn, "", "t", "searchHistories", "callback", "H", "G", "f", "K", "e", "r", "", "a", "Ljava/util/List;", "historyList", "b", "synchronizedList", "<init>", "()V", "c", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchHistoryNTDBHelper implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SearchHistory> historyList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SearchHistory> synchronizedList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((SearchHistory) t17).time), Long.valueOf(((SearchHistory) t16).time));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((SearchHistory) t17).time), Long.valueOf(((SearchHistory) t16).time));
            return compareValues;
        }
    }

    public SearchHistoryNTDBHelper() {
        ArrayList arrayList = new ArrayList();
        this.historyList = arrayList;
        List<SearchHistory> synchronizedList = Collections.synchronizedList(arrayList);
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(historyList)");
        this.synchronizedList = synchronizedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(SearchHistoryItem converted, SearchHistory sh5, int i3, String str, int i16) {
        Intrinsics.checkNotNullParameter(converted, "$converted");
        Intrinsics.checkNotNullParameter(sh5, "$sh");
        if (i3 == 0) {
            converted.searchHistoryId = i16;
            sh5.setId(i16);
            return;
        }
        QLog.d("SearchHistoryNTDBHelper", 1, " save search failed " + i3 + ", " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(SearchHistoryNTDBHelper this$0, Function1 cb5, int i3, String str, ArrayList items) {
        List sortedWith;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.d("SearchHistoryNTDBHelper", 1, "asyncGetSearchHistoryData getSearchHistory: result=" + i3 + " errorMsg=" + str + ", item.size=" + items.size());
        if (n.e(i3)) {
            QLog.isColorLevel();
            ArrayList<SearchHistory> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Intrinsics.checkNotNullExpressionValue(items, "items");
            Iterator it = items.iterator();
            while (it.hasNext()) {
                SearchHistoryItem item = (SearchHistoryItem) it.next();
                Intrinsics.checkNotNullExpressionValue(item, "item");
                SearchHistory r16 = this$0.r(item);
                if (r16 != null) {
                    arrayList.add(r16);
                }
            }
            for (SearchHistory searchHistory : arrayList) {
                boolean q16 = this$0.q(searchHistory);
                if (this$0.p(searchHistory)) {
                    this$0.t(searchHistory);
                } else if (!q16) {
                    arrayList2.add(searchHistory);
                }
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new c());
            if (sortedWith.size() >= 20) {
                for (final SearchHistory searchHistory2 : sortedWith.subList(20, sortedWith.size())) {
                    ae b16 = n.b();
                    if (b16 != null) {
                        b16.removeSearchHistory((int) searchHistory2.getId(), new IOperateCallback() { // from class: com.tencent.mobileqq.search.searchlocal.repository.history.h
                            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                            public final void onResult(int i16, String str2) {
                                SearchHistoryNTDBHelper.E(SearchHistory.this, i16, str2);
                            }
                        });
                    }
                }
                sortedWith = sortedWith.subList(0, 20);
            }
            synchronized (this$0.synchronizedList) {
                this$0.synchronizedList.clear();
                this$0.synchronizedList.addAll(sortedWith);
            }
            cb5.invoke(this$0.synchronizedList);
            return;
        }
        QLog.e("SearchHistoryNTDBHelper", 1, "getSearchHistory: failed  " + i3 + "," + str + " ");
        cb5.invoke(this$0.synchronizedList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(SearchHistory deleteItem, int i3, String str) {
        Intrinsics.checkNotNullParameter(deleteItem, "$deleteItem");
        QLog.d("SearchHistoryNTDBHelper", 2, "RemoveSearchHistory id: " + deleteItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(int i3, String str) {
        QLog.d("SearchHistoryNTDBHelper", 1, "saveSearchHistory: cleared " + i3 + " " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(SearchHistoryNTDBHelper this$0, final Function1 callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.d("SearchHistoryNTDBHelper", 1, "batchAddSearchHistory finish " + i3 + ", " + str);
        this$0.C(new Function1<List<? extends SearchHistory>, Unit>() { // from class: com.tencent.mobileqq.search.searchlocal.repository.history.SearchHistoryNTDBHelper$saveSearchHistory$3$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends SearchHistory> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<? extends SearchHistory> ntHistoryList) {
                Intrinsics.checkNotNullParameter(ntHistoryList, "ntHistoryList");
                callback.invoke(ntHistoryList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(SearchHistoryItem converted, SearchHistory sh5, int i3, String str, int i16) {
        Intrinsics.checkNotNullParameter(converted, "$converted");
        Intrinsics.checkNotNullParameter(sh5, "$sh");
        if (i3 == 0) {
            QLog.d("SearchHistoryNTDBHelper", 1, "updateEntityByKey  save search success " + i3 + ", " + str + " " + i16);
            converted.searchHistoryId = i16;
            sh5.setId((long) i16);
            return;
        }
        QLog.d("SearchHistoryNTDBHelper", 1, "updateEntityByKey  save search failed " + i3 + ", " + str);
    }

    private final SearchHistoryItem s(SearchHistory searchHistory) {
        SearchHistoryItem searchHistoryItem = new SearchHistoryItem();
        searchHistoryItem.type = SearchHistoryType.KSEARCHHISTORYTYPEPHONE;
        SearchPhoneItem searchPhoneItem = new SearchPhoneItem();
        searchPhoneItem.type = searchHistory.type;
        searchPhoneItem.key = searchHistory.key;
        searchPhoneItem.uin = searchHistory.uin;
        searchPhoneItem.troopUin = searchHistory.troopUin;
        searchPhoneItem.displayName = searchHistory.displayName;
        searchPhoneItem.extraInfo = searchHistory.extralInfo;
        searchPhoneItem.count = searchHistory.count;
        searchPhoneItem.time = searchHistory.time;
        searchHistoryItem.phoneItem = searchPhoneItem;
        searchHistoryItem.searchHistoryId = (int) searchHistory.getId();
        return searchHistoryItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(SearchHistory searchHistory, int i3, String str) {
        QLog.d("SearchHistoryNTDBHelper", 1, "nt rsp deleteSearchHistory " + i3 + " _ " + str + ", id=" + searchHistory.getId());
    }

    private final SearchHistory v(long historyId) {
        Object obj;
        SearchHistory searchHistory;
        boolean z16;
        synchronized (this.synchronizedList) {
            Iterator<T> it = this.synchronizedList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((SearchHistory) obj).getId() == historyId) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            searchHistory = (SearchHistory) obj;
        }
        return searchHistory;
    }

    private final SearchHistory w(String key) {
        Object obj;
        SearchHistory searchHistory;
        synchronized (this.synchronizedList) {
            Iterator<T> it = this.synchronizedList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((SearchHistory) obj).key, key)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            searchHistory = (SearchHistory) obj;
        }
        return searchHistory;
    }

    private final SearchHistory x(SearchHistory sh5) {
        Object obj;
        SearchHistory searchHistory;
        boolean z16;
        String str = sh5.key;
        Intrinsics.checkNotNullExpressionValue(str, "sh.key");
        SearchHistory w3 = w(str);
        if (sh5.type == 10023 && w3 == null) {
            synchronized (this.synchronizedList) {
                Iterator<T> it = this.synchronizedList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        SearchHistory searchHistory2 = (SearchHistory) obj;
                        if (Intrinsics.areEqual(searchHistory2.troopUin, sh5.troopUin) && Intrinsics.areEqual(searchHistory2.displayName, sh5.displayName)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                searchHistory = (SearchHistory) obj;
            }
            return searchHistory;
        }
        return w3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(SearchHistory deleteItem, SearchHistoryNTDBHelper this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(deleteItem, "$deleteItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("SearchHistoryNTDBHelper", 2, "getSearchHistory remove " + i3 + ", " + str + ",id: " + deleteItem.getId() + " ," + this$0.synchronizedList.contains(deleteItem));
        boolean remove = this$0.synchronizedList.remove(deleteItem);
        long id5 = deleteItem.getId();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("removed from mem remove:");
        sb5.append(remove);
        sb5.append(",id:");
        sb5.append(id5);
        QLog.d("SearchHistoryNTDBHelper", 2, sb5.toString());
    }

    public boolean A(@NotNull SearchHistory searchHistory) {
        return a.C8548a.i(this, searchHistory);
    }

    public final void C(@NotNull final Function1<? super List<? extends SearchHistory>, Unit> cb5) {
        Unit unit;
        List emptyList;
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.d("SearchHistoryNTDBHelper", 1, "loadSearchHistory start: ");
        ae b16 = n.b();
        if (b16 != null) {
            b16.loadSearchHistory(new ILoadSearchHistoryCallback() { // from class: com.tencent.mobileqq.search.searchlocal.repository.history.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.ILoadSearchHistoryCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    SearchHistoryNTDBHelper.D(SearchHistoryNTDBHelper.this, cb5, i3, str, arrayList);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("SearchHistoryNTDBHelper", 1, "loadSearchHistory is null");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            cb5.invoke(emptyList);
        }
    }

    public void F() {
        this.synchronizedList.clear();
    }

    public void G(@NotNull SearchHistory sh5) {
        Intrinsics.checkNotNullParameter(sh5, "sh");
        if (A(sh5)) {
            QLog.d("SearchHistoryNTDBHelper", 1, "saveSearchHistoryNT: initSearchHistory is true ");
        } else {
            f(sh5);
            QLog.d("SearchHistoryNTDBHelper", 4, "saveSearchHistory", sh5.key, Integer.valueOf(sh5.type), sh5.troopUin);
        }
    }

    public void H(@NotNull List<? extends SearchHistory> searchHistories, @NotNull final Function1<? super List<? extends SearchHistory>, Unit> callback) {
        int collectionSizeOrDefault;
        Unit unit;
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(searchHistories, "searchHistories");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (searchHistories.isEmpty()) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            callback.invoke(emptyList2);
            return;
        }
        QLog.d("SearchHistoryNTDBHelper", 1, "start saveSearchHistory " + searchHistories.size());
        ae b16 = n.b();
        if (b16 != null) {
            b16.clearSearchHistory(new IOperateCallback() { // from class: com.tencent.mobileqq.search.searchlocal.repository.history.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    SearchHistoryNTDBHelper.I(i3, str);
                }
            });
        }
        List<? extends SearchHistory> list = searchHistories;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            SearchHistoryItem s16 = s((SearchHistory) it.next());
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("SearchHistoryNTDBHelper", 2, " save convert to NT Data: " + s16.getPhoneItem());
            }
            arrayList.add(s16);
        }
        ArrayList<SearchHistoryItem> arrayList2 = new ArrayList<>();
        arrayList2.addAll(arrayList);
        ae b17 = n.b();
        if (b17 != null) {
            b17.batchAddSearchHistory(arrayList2, new IOperateCallback() { // from class: com.tencent.mobileqq.search.searchlocal.repository.history.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    SearchHistoryNTDBHelper.J(SearchHistoryNTDBHelper.this, callback, i3, str);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("SearchHistoryNTDBHelper", 1, "saveSearchHistory: null  kernelSearchService");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callback.invoke(emptyList);
        }
        this.historyList.addAll(searchHistories);
        QLog.d("SearchHistoryNTDBHelper", 1, "end saveSearchHistory");
    }

    public void K(@NotNull final SearchHistory sh5, @NotNull String key) {
        Unit unit;
        Intrinsics.checkNotNullParameter(sh5, "sh");
        Intrinsics.checkNotNullParameter(key, "key");
        QLog.d("SearchHistoryNTDBHelper", 1, "updateEntityByKey " + cq.w(key, 5));
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("SearchHistoryNTDBHelper", 2, "new:" + sh5);
        }
        SearchHistory x16 = x(sh5);
        if (x16 != null) {
            synchronized (this.synchronizedList) {
                this.synchronizedList.remove(x16);
                sh5.setId(x16.getId());
                sh5.count = x16.count + 1;
                this.synchronizedList.add(sh5);
            }
            final SearchHistoryItem s16 = s(sh5);
            ae b16 = n.b();
            if (b16 != null) {
                b16.updateSearchHistory(s16, new IUpdateSearchHistoryCallback() { // from class: com.tencent.mobileqq.search.searchlocal.repository.history.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IUpdateSearchHistoryCallback
                    public final void onResult(int i3, String str, int i16) {
                        SearchHistoryNTDBHelper.L(SearchHistoryItem.this, sh5, i3, str, i16);
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                QLog.e("SearchHistoryNTDBHelper", 1, "updateEntityByKey: empty service");
                return;
            }
            return;
        }
        QLog.w("SearchHistoryNTDBHelper", 1, "oldItem is null for key=" + cq.w(key, 5));
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
            SearchHistory w3 = w(sh5.displayName + "10025");
            if (w3 != null) {
                t(w3);
            }
            return false;
        }
        if (i3 != 10025) {
            return false;
        }
        String str = sh5.displayName + "10024";
        SearchHistory w16 = w(str);
        if (w16 == null) {
            return false;
        }
        w16.time = System.currentTimeMillis();
        w16.count++;
        K(w16, str);
        return true;
    }

    @Override // com.tencent.mobileqq.search.searchlocal.repository.history.a
    public void f(@NotNull final SearchHistory sh5) {
        String str;
        Intrinsics.checkNotNullParameter(sh5, "sh");
        SearchHistory x16 = x(sh5);
        if (x16 != null) {
            String str2 = x16.key;
            Intrinsics.checkNotNullExpressionValue(str2, "oldItem.key");
            K(sh5, str2);
            return;
        }
        sh5.count = 1;
        synchronized (this.synchronizedList) {
            this.synchronizedList.add(sh5);
        }
        final SearchHistoryItem s16 = s(sh5);
        Unit unit = null;
        if (QLog.isColorLevel()) {
            QLog.d("SearchHistoryNTDBHelper", 1, "start add history " + s16);
        } else {
            int i3 = s16.searchHistoryId;
            SearchPhoneItem searchPhoneItem = s16.phoneItem;
            if (searchPhoneItem != null) {
                str = searchPhoneItem.key;
            } else {
                str = null;
            }
            QLog.d("SearchHistoryNTDBHelper", 1, "start add history " + i3 + ",key " + str + " ");
        }
        ae b16 = n.b();
        if (b16 != null) {
            b16.addSearchHistory(s16, new IAddSearchHistoryCallback() { // from class: com.tencent.mobileqq.search.searchlocal.repository.history.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddSearchHistoryCallback
                public final void onResult(int i16, String str3, int i17) {
                    SearchHistoryNTDBHelper.B(SearchHistoryItem.this, sh5, i16, str3, i17);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e("SearchHistoryNTDBHelper", 1, "saveSearchHistory: empty service");
        }
    }

    @Override // com.tencent.mobileqq.search.searchlocal.repository.history.a
    public boolean g(@NotNull SearchHistory searchHistory) {
        return a.C8548a.d(this, searchHistory);
    }

    public boolean p(@NotNull SearchHistory searchHistory) {
        return a.C8548a.f(this, searchHistory);
    }

    public boolean q(@NotNull SearchHistory searchHistory) {
        return a.C8548a.g(this, searchHistory);
    }

    @Nullable
    public final SearchHistory r(@NotNull SearchHistoryItem searchHistoryItem) {
        Intrinsics.checkNotNullParameter(searchHistoryItem, "<this>");
        if (searchHistoryItem.type == SearchHistoryType.KSEARCHHISTORYTYPEPHONE) {
            SearchPhoneItem searchPhoneItem = searchHistoryItem.phoneItem;
            SearchHistory searchHistory = new SearchHistory();
            searchHistory.type = searchPhoneItem.type;
            searchHistory.key = searchPhoneItem.key;
            searchHistory.uin = searchPhoneItem.uin;
            searchHistory.troopUin = searchPhoneItem.troopUin;
            searchHistory.displayName = searchPhoneItem.displayName;
            searchHistory.extralInfo = searchPhoneItem.extraInfo;
            searchHistory.count = searchPhoneItem.count;
            searchHistory.time = searchPhoneItem.time;
            searchHistory.setId(searchHistoryItem.searchHistoryId);
            return searchHistory;
        }
        return null;
    }

    public boolean t(@Nullable final SearchHistory sh5) {
        if (sh5 != null) {
            QLog.d("SearchHistoryNTDBHelper", 1, "start deleteSearchHistory " + cq.w(sh5.displayName, 5));
            SearchHistory v3 = v(sh5.getId());
            if (v3 != null) {
                synchronized (this.synchronizedList) {
                    this.synchronizedList.remove(v3);
                }
            }
            ae b16 = n.b();
            if (b16 != null) {
                b16.removeSearchHistory((int) sh5.getId(), new IOperateCallback() { // from class: com.tencent.mobileqq.search.searchlocal.repository.history.e
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        SearchHistoryNTDBHelper.u(SearchHistory.this, i3, str);
                    }
                });
            }
            return true;
        }
        return false;
    }

    @NotNull
    public ArrayList<SearchHistory> y() {
        List sortedWith;
        ArrayList<SearchHistory> arrayList = new ArrayList<>();
        synchronized (this.synchronizedList) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.synchronizedList, new b());
        }
        arrayList.addAll(sortedWith);
        if (arrayList.size() >= 20) {
            ArrayList<SearchHistory> arrayList2 = new ArrayList<>(arrayList.subList(0, 20));
            List<SearchHistory> subList = arrayList.subList(20, arrayList.size());
            Intrinsics.checkNotNullExpressionValue(subList, "list.subList(ISearchHist\u2026HISTORY_COUNT, list.size)");
            for (final SearchHistory searchHistory : subList) {
                ae b16 = n.b();
                if (b16 != null) {
                    b16.removeSearchHistory((int) searchHistory.getId(), new IOperateCallback() { // from class: com.tencent.mobileqq.search.searchlocal.repository.history.c
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            SearchHistoryNTDBHelper.z(SearchHistory.this, this, i3, str);
                        }
                    });
                }
            }
            return arrayList2;
        }
        return arrayList;
    }
}
