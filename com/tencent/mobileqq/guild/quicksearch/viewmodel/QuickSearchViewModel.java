package com.tencent.mobileqq.guild.quicksearch.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.quicksearch.e;
import com.tencent.mobileqq.guild.quicksearch.event.GuildSearchKeyEvent;
import com.tencent.mobileqq.guild.quicksearch.model.GuildSearchActionSource;
import com.tencent.mobileqq.guild.quicksearch.model.QuickSearchSortType;
import com.tencent.mobileqq.guild.quicksearch.model.SearchData;
import com.tencent.mobileqq.guild.quicksearch.searchbox.SearchBarExtData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lw1.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 f2\u00020\u0001:\u0001gB\u000f\u0012\u0006\u0010\"\u001a\u00020\u0004\u00a2\u0006\u0004\be\u0010UJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\"\u0010\u0010\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0014\u0010\u0014\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u001c\u0010\u0017\u001a\u00020\u00022\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u001d\u001a\u00020\u0002H\u0014R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R%\u00107\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010101008\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R2\u0010?\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u000b\u0012\t\u0018\u00010\u0018\u00a2\u0006\u0002\b9\u0012\u0006\u0012\u0004\u0018\u00010:0\u0015088\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001f\u0010A\u001a\r\u0012\t\u0012\u00070\u0018\u00a2\u0006\u0002\b9008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u00104R\"\u0010B\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u00010:0:008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u00104R \u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00110C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010FR \u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0011088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010<R\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u0002010C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010FR\"\u0010V\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\u001f\u001a\u0004\bS\u0010!\"\u0004\bT\u0010UR\u001c\u0010Z\u001a\r\u0012\t\u0012\u00070\u0018\u00a2\u0006\u0002\b90W8F\u00a2\u0006\u0006\u001a\u0004\bX\u0010YR\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020:0W8F\u00a2\u0006\u0006\u001a\u0004\b[\u0010YR\u001d\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110W8F\u00a2\u0006\u0006\u001a\u0004\b]\u0010YR\u001d\u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00110W8F\u00a2\u0006\u0006\u001a\u0004\b_\u0010YR\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00070W8F\u00a2\u0006\u0006\u001a\u0004\ba\u0010YR\u0017\u0010d\u001a\b\u0012\u0004\u0012\u0002010W8F\u00a2\u0006\u0006\u001a\u0004\bc\u0010Y\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "Lef1/b;", "", "Z1", "", "searchKey", "X1", "Lcom/tencent/mobileqq/guild/quicksearch/model/QuickSearchSortType;", "sortType", "j2", "t2", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "searchExtInfo", "keyWord", "Lcom/tencent/mobileqq/guild/quicksearch/model/GuildSearchActionSource;", "source", ICustomDataEditor.STRING_PARAM_2, "", "", "selectedChannelList", "p2", "Lkotlin/Pair;", "timeRange", "q2", "", "rankType", "r2", FeedManager.LOAD_MORE, ICustomDataEditor.NUMBER_PARAM_2, "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/quicksearch/model/a;", "D", "Lcom/tencent/mobileqq/guild/quicksearch/model/a;", "f2", "()Lcom/tencent/mobileqq/guild/quicksearch/model/a;", "searchParam", "E", "I", "b2", "()I", "v2", "(I)V", "pageState", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "k2", "()Landroidx/lifecycle/MutableLiveData;", "isDateFilterNeedHide", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/mobileqq/guild/quicksearch/model/SearchState;", "Lcom/tencent/mobileqq/guild/quicksearch/model/d;", "G", "Landroidx/lifecycle/MediatorLiveData;", SemanticAttributes.DbSystemValues.H2, "()Landroidx/lifecycle/MediatorLiveData;", "stateAndResultLiveData", "H", "_searchState", "_searchData", "Lcom/tencent/mobileqq/guild/util/cn;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchFeedGroupInfo;", "J", "Lcom/tencent/mobileqq/guild/util/cn;", "_refreshChannelFilterList", "K", "_initFilter", "L", "_searchHistoryList", "Llw1/k;", "M", "Llw1/k;", "searchHistoryHelper", "N", "_switchToSearchResult", "P", "getCurPageId", "u2", "(Ljava/lang/String;)V", "curPageId", "Landroidx/lifecycle/LiveData;", "g2", "()Landroidx/lifecycle/LiveData;", "searchState", "d2", "searchData", "e2", "searchHistoryList", "c2", "refreshChannelFilterList", ICustomDataEditor.STRING_ARRAY_PARAM_2, "initFilter", "i2", "switchToSearchResult", "<init>", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.quicksearch.model.a searchParam;

    /* renamed from: E, reason: from kotlin metadata */
    private int pageState;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isDateFilterNeedHide;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Pair<Integer, SearchData>> stateAndResultLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _searchState;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<SearchData> _searchData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final cn<List<IGProGuildSearchFeedGroupInfo>> _refreshChannelFilterList;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final cn<QuickSearchSortType> _initFilter;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<List<String>> _searchHistoryList;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final k searchHistoryHelper;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _switchToSearchResult;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private String curPageId;

    public QuickSearchViewModel(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.searchParam = new com.tencent.mobileqq.guild.quicksearch.model.a(Long.valueOf(MiscKt.l(guildId)), null, null, null, null, null, 0, 126, null);
        this.isDateFilterNeedHide = new MutableLiveData<>(Boolean.FALSE);
        final MediatorLiveData<Pair<Integer, SearchData>> mediatorLiveData = new MediatorLiveData<>();
        this.stateAndResultLiveData = mediatorLiveData;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(0);
        this._searchState = mutableLiveData;
        MutableLiveData<SearchData> mutableLiveData2 = new MutableLiveData<>(new SearchData(null, null, null, false, 15, null));
        this._searchData = mutableLiveData2;
        this._refreshChannelFilterList = new cn<>();
        this._initFilter = new cn<>();
        MediatorLiveData<List<String>> mediatorLiveData2 = new MediatorLiveData<>();
        this._searchHistoryList = mediatorLiveData2;
        k kVar = new k(guildId);
        this.searchHistoryHelper = kVar;
        this._switchToSearchResult = new cn<>();
        this.curPageId = "pg_sgrp_search_all";
        LiveData d16 = kVar.d();
        final Function1<List<? extends String>, Unit> function1 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                QuickSearchViewModel.this._searchHistoryList.setValue(QuickSearchViewModel.this.searchHistoryHelper.d().getValue());
            }
        };
        mediatorLiveData2.addSource(d16, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchViewModel.R1(Function1.this, obj);
            }
        });
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchViewModel$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                MutableLiveData mutableLiveData3;
                MediatorLiveData<Pair<Integer, SearchData>> mediatorLiveData3 = mediatorLiveData;
                Integer value = this.g2().getValue();
                mutableLiveData3 = this._searchData;
                mediatorLiveData3.setValue(new Pair<>(value, mutableLiveData3.getValue()));
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchViewModel.l2(Function1.this, obj);
            }
        });
        final Function1<SearchData, Unit> function13 = new Function1<SearchData, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchViewModel$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchData searchData) {
                invoke2(searchData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SearchData searchData) {
                MutableLiveData mutableLiveData3;
                MediatorLiveData<Pair<Integer, SearchData>> mediatorLiveData3 = mediatorLiveData;
                Integer value = this.g2().getValue();
                mutableLiveData3 = this._searchData;
                mediatorLiveData3.setValue(new Pair<>(value, mutableLiveData3.getValue()));
            }
        };
        mediatorLiveData.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchViewModel.m2(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(QuickSearchViewModel this$0, GuildSearchActionSource source, int i3, String str, com.tencent.mobileqq.guild.quicksearch.model.c result) {
        List<zg1.a> d16;
        IGProGuildSearchAISearchInfo aiSearchInfo;
        List mutableList;
        List<zg1.a> emptyList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "$source");
        Intrinsics.checkNotNullParameter(result, "result");
        if (i3 != 0) {
            ch.d1(1, R.string.f1514417p);
            Integer value = this$0._searchState.getValue();
            if (value != null && value.intValue() == 1) {
                this$0._searchState.setValue(0);
                return;
            }
            if (value != null && value.intValue() == 3) {
                this$0._searchState.setValue(2);
                return;
            }
            Logger.f235387a.d().i("QQGuildInSearchTag.GuildQuickSearchViewModel", 1, "invalid state while load error: " + this$0._searchState.getValue());
            return;
        }
        this$0.searchParam.i(result.getFeedCookie());
        if (com.tencent.mobileqq.guild.quicksearch.model.b.a(source)) {
            this$0._refreshChannelFilterList.setValue(result.b());
        }
        Integer value2 = this$0._searchState.getValue();
        if (value2 != null && value2.intValue() == 3) {
            SearchData value3 = this$0._searchData.getValue();
            if (value3 == null || (emptyList = value3.b()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            d16 = CollectionsKt___CollectionsKt.plus((Collection) emptyList, (Iterable) result.d());
        } else {
            d16 = result.d();
        }
        Integer value4 = this$0._searchState.getValue();
        if (value4 != null && value4.intValue() == 3) {
            SearchData value5 = this$0._searchData.getValue();
            if (value5 != null) {
                aiSearchInfo = value5.getAiSearchInfo();
            } else {
                aiSearchInfo = null;
            }
        } else {
            aiSearchInfo = result.getAiSearchInfo();
        }
        MutableLiveData<SearchData> mutableLiveData = this$0._searchData;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) d16);
        mutableLiveData.setValue(new SearchData(aiSearchInfo, mutableList, source, result.getNoMoreFeed()));
        if (!result.getNoMoreFeed() && !d16.isEmpty()) {
            this$0._searchState.setValue(2);
        } else {
            this$0._searchState.setValue(4);
        }
    }

    public final void X1(@NotNull String searchKey) {
        Intrinsics.checkNotNullParameter(searchKey, "searchKey");
        this.searchHistoryHelper.a(searchKey);
    }

    public final void Z1() {
        this.searchHistoryHelper.b();
    }

    @NotNull
    public final LiveData<QuickSearchSortType> a2() {
        return this._initFilter;
    }

    /* renamed from: b2, reason: from getter */
    public final int getPageState() {
        return this.pageState;
    }

    @NotNull
    public final LiveData<List<IGProGuildSearchFeedGroupInfo>> c2() {
        return this._refreshChannelFilterList;
    }

    @NotNull
    public final LiveData<SearchData> d2() {
        return this._searchData;
    }

    @NotNull
    public final LiveData<List<String>> e2() {
        return this._searchHistoryList;
    }

    @NotNull
    /* renamed from: f2, reason: from getter */
    public final com.tencent.mobileqq.guild.quicksearch.model.a getSearchParam() {
        return this.searchParam;
    }

    @NotNull
    public final LiveData<Integer> g2() {
        return this._searchState;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final MediatorLiveData<Pair<Integer, SearchData>> h2() {
        return this.stateAndResultLiveData;
    }

    @NotNull
    public final LiveData<Boolean> i2() {
        return this._switchToSearchResult;
    }

    public final void j2(@NotNull QuickSearchSortType sortType) {
        Intrinsics.checkNotNullParameter(sortType, "sortType");
        this._initFilter.setValue(sortType);
    }

    @NotNull
    public final MutableLiveData<Boolean> k2() {
        return this.isDateFilterNeedHide;
    }

    public final void loadMore() {
        this._searchState.setValue(3);
        n2(GuildSearchActionSource.LOAD_MORE);
    }

    public final void n2(@NotNull final GuildSearchActionSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        com.tencent.mobileqq.guild.quicksearch.e.f231611a.k(com.tencent.mobileqq.guild.quicksearch.model.a.c(this.searchParam, null, null, null, null, null, null, 0, 127, null), source, new e.a() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.j
            @Override // com.tencent.mobileqq.guild.quicksearch.e.a
            public final void a(int i3, String str, Object obj) {
                QuickSearchViewModel.o2(QuickSearchViewModel.this, source, i3, str, (com.tencent.mobileqq.guild.quicksearch.model.c) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.searchHistoryHelper.f();
    }

    public final void p2(@NotNull List<Long> selectedChannelList) {
        Intrinsics.checkNotNullParameter(selectedChannelList, "selectedChannelList");
        this._searchState.setValue(1);
        MutableLiveData<SearchData> mutableLiveData = this._searchData;
        GuildSearchActionSource guildSearchActionSource = GuildSearchActionSource.FILTER_PANEL;
        mutableLiveData.setValue(new SearchData(null, null, guildSearchActionSource, false, 11, null));
        com.tencent.mobileqq.guild.quicksearch.model.a aVar = this.searchParam;
        aVar.h(bg.f302144a.n(selectedChannelList));
        aVar.i(null);
        n2(guildSearchActionSource);
    }

    public final void q2(@Nullable Pair<String, String> timeRange) {
        this._searchState.setValue(1);
        MutableLiveData<SearchData> mutableLiveData = this._searchData;
        GuildSearchActionSource guildSearchActionSource = GuildSearchActionSource.FILTER_PANEL;
        mutableLiveData.setValue(new SearchData(null, null, guildSearchActionSource, false, 11, null));
        com.tencent.mobileqq.guild.quicksearch.model.a aVar = this.searchParam;
        aVar.m(timeRange);
        aVar.i(null);
        n2(guildSearchActionSource);
    }

    public final void r2(int rankType) {
        this._searchState.setValue(1);
        MutableLiveData<SearchData> mutableLiveData = this._searchData;
        GuildSearchActionSource guildSearchActionSource = GuildSearchActionSource.FILTER_PANEL;
        mutableLiveData.setValue(new SearchData(null, null, guildSearchActionSource, false, 11, null));
        com.tencent.mobileqq.guild.quicksearch.model.a aVar = this.searchParam;
        aVar.k(rankType);
        aVar.i(null);
        n2(guildSearchActionSource);
    }

    public final void s2(@Nullable SearchBarExtData searchExtInfo, @Nullable String keyWord, @NotNull GuildSearchActionSource source) {
        QuickSearchSortType quickSearchSortType;
        boolean z16;
        Intrinsics.checkNotNullParameter(source, "source");
        if (searchExtInfo == null) {
            if (keyWord != null && keyWord.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildSearchKeyEvent(keyWord));
            }
        }
        this._searchState.setValue(1);
        this._searchData.setValue(new SearchData(null, null, source, false, 11, null));
        if (searchExtInfo != null) {
            quickSearchSortType = QuickSearchSortType.TIME;
        } else {
            quickSearchSortType = QuickSearchSortType.SMART;
        }
        j2(quickSearchSortType);
        this.isDateFilterNeedHide.setValue(Boolean.valueOf(searchExtInfo instanceof SearchBarExtData.DateExtData));
        com.tencent.mobileqq.guild.quicksearch.model.a aVar = this.searchParam;
        aVar.l(searchExtInfo);
        if (keyWord == null) {
            keyWord = "";
        }
        aVar.j(keyWord);
        aVar.i(null);
        aVar.d().clear();
        aVar.m(null);
        aVar.k(quickSearchSortType.getRankType());
        n2(source);
    }

    public final void t2() {
        this.pageState = 1;
        com.tencent.mobileqq.guild.quicksearch.model.a aVar = this.searchParam;
        aVar.l(null);
        aVar.j("");
        aVar.i(null);
        aVar.d().clear();
        aVar.m(null);
        aVar.k(QuickSearchSortType.SMART.getRankType());
        this._searchState.setValue(0);
        this._switchToSearchResult.setValue(Boolean.TRUE);
    }

    public final void u2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.curPageId = str;
    }

    public final void v2(int i3) {
        this.pageState = i3;
    }
}
