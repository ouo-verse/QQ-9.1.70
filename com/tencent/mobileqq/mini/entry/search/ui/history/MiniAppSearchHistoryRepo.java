package com.tencent.mobileqq.mini.entry.search.ui.history;

import android.content.Context;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.search.ui.history.MiniAppSearchHistoryRepo;
import com.tencent.mobileqq.search.j;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.nativeinterface.IAddSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.ILoadSearchHistoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchHistoryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchHistoryType;
import com.tencent.qqnt.kernel.nativeinterface.SearchPhoneItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import yx3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=Bv\u0012!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\t\u00126\u0010'\u001a2\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00070%\u0012\b\b\u0002\u0010)\u001a\u00020\u0014\u0012\b\b\u0002\u0010+\u001a\u00020\u0014\u00a2\u0006\u0004\b;\u0010<J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0014\u0010\b\u001a\u00020\u0007*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J3\u0010\b\u001a\u00020\u0007*\u00020\u00052%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0002J\u001c\u0010\u0013\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J,\u0010\u0019\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cJ\u0012\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016R/\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$RD\u0010'\u001a2\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00070%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u001f0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00106\u001a\u0004\u0018\u0001038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u0010:\u001a\u0004\u0018\u0001078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/ui/history/MiniAppSearchHistoryRepo;", "Lyx3/a;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getApp", "", "Lcom/tencent/mobileqq/search/searchlocal/model/SearchHistory;", "getHistory", "", "delete", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "block", "Lcom/tencent/common/app/AppInterface;", "appInterface", "Landroid/content/Context;", "context", "init", "", "tabType", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/mobileqq/search/j;", "entity", "doSearchHistoryAction", "data", "deleteHistory", "", "keyword", "saveHistory", "Lyx3/a$a;", "callback", "asyncGetSearchHistoryData", "destroy", "onItemClick", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function2;", "searchable", "onItemDelete", "Lkotlin/jvm/functions/Function2;", "type", "I", "maxCount", "", "histories", "Ljava/util/List;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initFinish", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listeners", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "getKernelService", "()Lcom/tencent/qqnt/kernel/api/IKernelService;", "kernelService", "Lcom/tencent/qqnt/kernel/api/ae;", "getSearchService", "()Lcom/tencent/qqnt/kernel/api/ae;", "searchService", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;II)V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniAppSearchHistoryRepo implements yx3.a {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int MAX_SEARCH_HISTORY_COUNT = 6;

    @Deprecated
    public static final String TAG = "MiniAppSearchHistoryRepo";
    private final List<SearchHistory> histories;
    private final AtomicBoolean initFinish;
    private final List<a.InterfaceC11637a> listeners;
    private final int maxCount;
    private final Function1<String, Unit> onItemClick;
    private final Function2<Boolean, j, Unit> onItemDelete;
    private final int type;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nJ\n\u0010\u000b\u001a\u00020\f*\u00020\u0004J\f\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000fJ\n\u0010\u0010\u001a\u00020\u000f*\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/search/ui/history/MiniAppSearchHistoryRepo$Companion;", "", "()V", "MAX_SEARCH_HISTORY_COUNT", "", "TAG", "", "runOnUI", "", "block", "Lkotlin/Function0;", "success", "", "toHistory", "Lcom/tencent/mobileqq/search/searchlocal/model/SearchHistory;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHistoryItem;", "toItem", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void runOnUI$lambda$3(Function0 block) {
            Intrinsics.checkNotNullParameter(block, "$block");
            block.invoke();
        }

        public final void runOnUI(final Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                block.invoke();
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.search.ui.history.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppSearchHistoryRepo.Companion.runOnUI$lambda$3(Function0.this);
                    }
                });
            }
        }

        public final boolean success(int i3) {
            if (i3 == 0) {
                return true;
            }
            return false;
        }

        public final SearchHistory toHistory(SearchHistoryItem searchHistoryItem) {
            Intrinsics.checkNotNullParameter(searchHistoryItem, "<this>");
            if (searchHistoryItem.type != SearchHistoryType.KSEARCHHISTORYTYPEPHONE) {
                return null;
            }
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

        public final SearchHistoryItem toItem(SearchHistory searchHistory) {
            Intrinsics.checkNotNullParameter(searchHistory, "<this>");
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

        Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MiniAppSearchHistoryRepo(Function1<? super String, Unit> onItemClick, Function2<? super Boolean, ? super j, Unit> onItemDelete, int i3, int i16) {
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onItemDelete, "onItemDelete");
        this.onItemClick = onItemClick;
        this.onItemDelete = onItemDelete;
        this.type = i3;
        this.maxCount = i16;
        this.histories = new ArrayList();
        this.initFinish = new AtomicBoolean();
        this.listeners = new ArrayList();
    }

    private final void delete(List<? extends SearchHistory> list) {
        List<? extends SearchHistory> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            delete$default(this, (SearchHistory) it.next(), null, 1, null);
        }
    }

    private final QQAppInterface getApp() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SearchHistory> getHistory() {
        List sortedWith;
        List<SearchHistory> take;
        Set set;
        List<? extends SearchHistory> minus;
        synchronized (this.histories) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.histories, new Comparator() { // from class: com.tencent.mobileqq.mini.entry.search.ui.history.MiniAppSearchHistoryRepo$getHistory$lambda$20$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((SearchHistory) t17).time), Long.valueOf(((SearchHistory) t16).time));
                    return compareValues;
                }
            });
        }
        take = CollectionsKt___CollectionsKt.take(sortedWith, this.maxCount);
        List<SearchHistory> list = this.histories;
        set = CollectionsKt___CollectionsKt.toSet(take);
        minus = CollectionsKt___CollectionsKt.minus((Iterable) list, (Iterable) set);
        delete(minus);
        return take;
    }

    private final IKernelService getKernelService() {
        QQAppInterface app = getApp();
        if (app != null) {
            return (IKernelService) app.getRuntimeService(IKernelService.class, "");
        }
        return null;
    }

    private final ae getSearchService() {
        IKernelService kernelService = getKernelService();
        if (kernelService != null) {
            return kernelService.getSearchService();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$7(MiniAppSearchHistoryRepo this$0, int i3, String str, ArrayList items) {
        List sortedWith;
        List take;
        Set set;
        List<? extends SearchHistory> minus;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "load search history finish, result:" + i3 + ", errMsg:" + str);
        if (!Companion.success(i3)) {
            this$0.initFinish.getAndSet(true);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(items, "items");
        ArrayList<SearchHistoryItem> arrayList = new ArrayList();
        for (Object obj : items) {
            if (((SearchHistoryItem) obj).phoneItem.type == this$0.type) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (SearchHistoryItem it : arrayList) {
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            SearchHistory history = companion.toHistory(it);
            if (history != null) {
                arrayList2.add(history);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.tencent.mobileqq.mini.entry.search.ui.history.MiniAppSearchHistoryRepo$init$lambda$7$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((SearchHistory) t17).time), Long.valueOf(((SearchHistory) t16).time));
                return compareValues;
            }
        });
        take = CollectionsKt___CollectionsKt.take(sortedWith, this$0.maxCount);
        List list = take;
        set = CollectionsKt___CollectionsKt.toSet(list);
        minus = CollectionsKt___CollectionsKt.minus((Iterable) arrayList2, (Iterable) set);
        synchronized (this$0.histories) {
            this$0.histories.clear();
            this$0.histories.addAll(take);
        }
        this$0.initFinish.getAndSet(true);
        this$0.delete(minus);
        QQAppInterface app = this$0.getApp();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList3.add(new com.tencent.mobileqq.search.d(app, (SearchHistory) it5.next()));
        }
        synchronized (this$0.listeners) {
            Iterator<T> it6 = this$0.listeners.iterator();
            while (it6.hasNext()) {
                ((a.InterfaceC11637a) it6.next()).a(arrayList3);
            }
            this$0.listeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveHistory$lambda$15(SearchHistory history, MiniAppSearchHistoryRepo this$0, int i3, String str, int i16) {
        Intrinsics.checkNotNullParameter(history, "$history");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Companion.success(i3)) {
            history.setId(i16);
            synchronized (this$0.histories) {
                this$0.histories.add(history);
            }
        }
    }

    @Override // yx3.a
    public void asyncGetSearchHistoryData(final a.InterfaceC11637a callback) {
        if (this.initFinish.get()) {
            final QQAppInterface app = getApp();
            Companion.runOnUI(new Function0<Unit>() { // from class: com.tencent.mobileqq.mini.entry.search.ui.history.MiniAppSearchHistoryRepo$asyncGetSearchHistoryData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    List history;
                    int collectionSizeOrDefault;
                    a.InterfaceC11637a interfaceC11637a = a.InterfaceC11637a.this;
                    if (interfaceC11637a != null) {
                        history = this.getHistory();
                        List list = history;
                        QQAppInterface qQAppInterface = app;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new com.tencent.mobileqq.search.d(qQAppInterface, (SearchHistory) it.next()));
                        }
                        interfaceC11637a.a(arrayList);
                    }
                }
            });
        } else {
            if (callback == null) {
                return;
            }
            synchronized (this.listeners) {
                this.listeners.add(callback);
            }
        }
    }

    @Override // yx3.a
    public void destroy() {
        synchronized (this.histories) {
            this.histories.clear();
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.listeners) {
            this.listeners.clear();
        }
    }

    @Override // yx3.a
    public void init(AppInterface appInterface, Context context) {
        QLog.i(TAG, 1, "load search history start, type:" + this.type);
        ae searchService = getSearchService();
        if (searchService != null) {
            searchService.loadSearchHistory(new ILoadSearchHistoryCallback() { // from class: com.tencent.mobileqq.mini.entry.search.ui.history.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.ILoadSearchHistoryCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    MiniAppSearchHistoryRepo.init$lambda$7(MiniAppSearchHistoryRepo.this, i3, str, arrayList);
                }
            });
        }
    }

    public final void saveHistory(String keyword) {
        Object obj;
        SearchHistory searchHistory;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        String str = keyword + this.type;
        synchronized (this.histories) {
            Iterator<T> it = this.histories.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((SearchHistory) obj).key, str)) {
                        break;
                    }
                }
            }
            searchHistory = (SearchHistory) obj;
        }
        if (searchHistory != null) {
            searchHistory.time = System.currentTimeMillis();
            searchHistory.count++;
            ae searchService = getSearchService();
            if (searchService != null) {
                searchService.updateSearchHistory(Companion.toItem(searchHistory), null);
                return;
            }
            return;
        }
        final SearchHistory searchHistory2 = new SearchHistory();
        searchHistory2.key = str;
        searchHistory2.type = this.type;
        QQAppInterface app = getApp();
        searchHistory2.uin = app != null ? app.getCurrentAccountUin() : null;
        searchHistory2.displayName = keyword;
        searchHistory2.count = 1;
        searchHistory2.time = System.currentTimeMillis();
        ae searchService2 = getSearchService();
        if (searchService2 != null) {
            searchService2.addSearchHistory(Companion.toItem(searchHistory2), new IAddSearchHistoryCallback() { // from class: com.tencent.mobileqq.mini.entry.search.ui.history.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddSearchHistoryCallback
                public final void onResult(int i3, String str2, int i16) {
                    MiniAppSearchHistoryRepo.saveHistory$lambda$15(SearchHistory.this, this, i3, str2, i16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delete$lambda$22(Function1 function1, int i3, String str) {
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(Companion.success(i3)));
        }
    }

    @Override // yx3.a
    public void deleteHistory(final j data) {
        Object obj;
        SearchHistory searchHistory;
        if (data == null) {
            return;
        }
        String str = data.f() + this.type;
        synchronized (this.histories) {
            Iterator<T> it = this.histories.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((SearchHistory) obj).key, str)) {
                        break;
                    }
                }
            }
            searchHistory = (SearchHistory) obj;
        }
        if (searchHistory != null) {
            synchronized (this.histories) {
                this.histories.remove(searchHistory);
            }
            delete(searchHistory, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.mini.entry.search.ui.history.MiniAppSearchHistoryRepo$deleteHistory$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final boolean z16) {
                    MiniAppSearchHistoryRepo.Companion companion;
                    companion = MiniAppSearchHistoryRepo.Companion;
                    final MiniAppSearchHistoryRepo miniAppSearchHistoryRepo = MiniAppSearchHistoryRepo.this;
                    final j jVar = data;
                    companion.runOnUI(new Function0<Unit>() { // from class: com.tencent.mobileqq.mini.entry.search.ui.history.MiniAppSearchHistoryRepo$deleteHistory$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Function2 function2;
                            function2 = MiniAppSearchHistoryRepo.this.onItemDelete;
                            function2.invoke(Boolean.valueOf(z16), jVar);
                        }
                    });
                }
            });
        }
    }

    @Override // yx3.a
    public void doSearchHistoryAction(Context context, int tabType, int pos, j entity) {
        if (entity == null) {
            return;
        }
        final String f16 = entity.f();
        if (f16 == null || f16.length() == 0) {
            return;
        }
        Companion.runOnUI(new Function0<Unit>() { // from class: com.tencent.mobileqq.mini.entry.search.ui.history.MiniAppSearchHistoryRepo$doSearchHistoryAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function1 function1;
                function1 = MiniAppSearchHistoryRepo.this.onItemClick;
                String keyword = f16;
                Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
                function1.invoke(keyword);
            }
        });
    }

    private final void delete(SearchHistory searchHistory, final Function1<? super Boolean, Unit> function1) {
        ae searchService = getSearchService();
        if (searchService != null) {
            searchService.removeSearchHistory((int) searchHistory.getId(), new IOperateCallback() { // from class: com.tencent.mobileqq.mini.entry.search.ui.history.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    MiniAppSearchHistoryRepo.delete$lambda$22(Function1.this, i3, str);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void delete$default(MiniAppSearchHistoryRepo miniAppSearchHistoryRepo, SearchHistory searchHistory, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = null;
        }
        miniAppSearchHistoryRepo.delete(searchHistory, function1);
    }

    public /* synthetic */ MiniAppSearchHistoryRepo(Function1 function1, Function2 function2, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function2, (i17 & 4) != 0 ? 10028 : i3, (i17 & 8) != 0 ? 6 : i16);
    }
}
