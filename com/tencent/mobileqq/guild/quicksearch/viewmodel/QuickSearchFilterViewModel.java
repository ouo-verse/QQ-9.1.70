package com.tencent.mobileqq.guild.quicksearch.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.guild.quicksearch.adapter.QuickSearchModuleInfo;
import com.tencent.mobileqq.guild.quicksearch.model.QuickSearchSortType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 N2\u00020\u0001:\u0001OB\u000f\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\bL\u0010MJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u001c\u0010\u0019\u001a\u00020\u00052\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0005R\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R%\u0010(\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\u00130\u00130\"8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R \u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010+R\"\u00102\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\f0\f0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010%R&\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u00160)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010+R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\f088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\f088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010:R\"\u0010?\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\f0\f0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010%R\u001d\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020@8F\u00a2\u0006\u0006\u001a\u0004\bA\u0010BR\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\f0@8F\u00a2\u0006\u0006\u001a\u0004\bD\u0010BR#\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u00160@8F\u00a2\u0006\u0006\u001a\u0004\bF\u0010BR\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\f0@8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010BR\u0017\u0010K\u001a\b\u0012\u0004\u0012\u00020\f0@8F\u00a2\u0006\u0006\u001a\u0004\bJ\u0010B\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "Lef1/b;", "", "Lcom/tencent/mobileqq/guild/quicksearch/adapter/d;", "f2", "", "v2", "e2", "", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchFeedGroupInfo;", "info", "", "selected", "z2", "c2", "x2", "y2", "w2", "Lcom/tencent/mobileqq/guild/quicksearch/model/QuickSearchSortType;", "selectedType", NowProxyConstants.AccountInfoKey.A2, "Lkotlin/Pair;", "", "timeRange", "t2", "u2", "d2", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "l2", "()Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "pageViewModel", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "D", "Landroidx/lifecycle/MutableLiveData;", ICustomDataEditor.NUMBER_PARAM_2, "()Landroidx/lifecycle/MutableLiveData;", "sortSelectType", "Landroidx/lifecycle/MediatorLiveData;", "E", "Landroidx/lifecycle/MediatorLiveData;", "m2", "()Landroidx/lifecycle/MediatorLiveData;", "sortSelectNeedHide", UserInfo.SEX_FEMALE, "_moduleList", "G", "_moduleFilterHasShow", "H", "_moduleSelectState", "I", "Ljava/util/List;", "preSelectedModuleList", "Lcom/tencent/mobileqq/guild/util/cn;", "J", "Lcom/tencent/mobileqq/guild/util/cn;", "_dateFilterInitEvent", "K", "_dateFilterCloseEvent", "L", "_dateFilterHasShow", "Landroidx/lifecycle/LiveData;", "j2", "()Landroidx/lifecycle/LiveData;", "moduleList", "i2", "moduleFilterHasShow", "k2", "moduleSelectState", SemanticAttributes.DbSystemValues.H2, "dateFilterInitEvent", "g2", "dateFilterCloseEvent", "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;)V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchFilterViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QuickSearchViewModel pageViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<QuickSearchSortType> sortSelectType;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Boolean> sortSelectNeedHide;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<List<QuickSearchModuleInfo>> _moduleList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _moduleFilterHasShow;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Pair<Boolean, Integer>> _moduleSelectState;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private List<QuickSearchModuleInfo> preSelectedModuleList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _dateFilterInitEvent;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> _dateFilterCloseEvent;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _dateFilterHasShow;

    public QuickSearchFilterViewModel(@NotNull QuickSearchViewModel pageViewModel) {
        Intrinsics.checkNotNullParameter(pageViewModel, "pageViewModel");
        this.pageViewModel = pageViewModel;
        this.sortSelectType = new MutableLiveData<>(QuickSearchSortType.SMART);
        final MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this.sortSelectNeedHide = mediatorLiveData;
        final MediatorLiveData<List<QuickSearchModuleInfo>> mediatorLiveData2 = new MediatorLiveData<>();
        this._moduleList = mediatorLiveData2;
        Boolean bool = Boolean.FALSE;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(bool);
        this._moduleFilterHasShow = mutableLiveData;
        final MediatorLiveData<Pair<Boolean, Integer>> mediatorLiveData3 = new MediatorLiveData<>();
        this._moduleSelectState = mediatorLiveData3;
        this._dateFilterInitEvent = new cn<>();
        this._dateFilterCloseEvent = new cn<>();
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(bool);
        this._dateFilterHasShow = mutableLiveData2;
        LiveData<List<IGProGuildSearchFeedGroupInfo>> c26 = pageViewModel.c2();
        final Function1<List<? extends IGProGuildSearchFeedGroupInfo>, Unit> function1 = new Function1<List<? extends IGProGuildSearchFeedGroupInfo>, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchFilterViewModel$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends IGProGuildSearchFeedGroupInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends IGProGuildSearchFeedGroupInfo> channelFilterList) {
                int collectionSizeOrDefault;
                MediatorLiveData<List<QuickSearchModuleInfo>> mediatorLiveData4 = mediatorLiveData2;
                Intrinsics.checkNotNullExpressionValue(channelFilterList, "channelFilterList");
                List<? extends IGProGuildSearchFeedGroupInfo> list = channelFilterList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new QuickSearchModuleInfo((IGProGuildSearchFeedGroupInfo) it.next(), false));
                }
                mediatorLiveData4.setValue(new ArrayList(arrayList));
            }
        };
        mediatorLiveData2.addSource(c26, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFilterViewModel.o2(Function1.this, obj);
            }
        });
        final Function1<List<? extends QuickSearchModuleInfo>, Unit> function12 = new Function1<List<? extends QuickSearchModuleInfo>, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchFilterViewModel$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends QuickSearchModuleInfo> list) {
                invoke2((List<QuickSearchModuleInfo>) list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<QuickSearchModuleInfo> list) {
                int i3;
                MediatorLiveData<Pair<Boolean, Integer>> mediatorLiveData4 = mediatorLiveData3;
                Boolean bool2 = (Boolean) this._moduleFilterHasShow.getValue();
                if (bool2 == null) {
                    bool2 = Boolean.FALSE;
                }
                List list2 = (List) this._moduleList.getValue();
                if (list2 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list2) {
                        if (((QuickSearchModuleInfo) obj).getIsSelected()) {
                            arrayList.add(obj);
                        }
                    }
                    i3 = arrayList.size();
                } else {
                    i3 = 0;
                }
                mediatorLiveData4.setValue(new Pair<>(bool2, Integer.valueOf(i3)));
            }
        };
        mediatorLiveData3.addSource(mediatorLiveData2, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFilterViewModel.p2(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchFilterViewModel$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2) {
                invoke2(bool2);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool2) {
                int i3;
                MediatorLiveData<Pair<Boolean, Integer>> mediatorLiveData4 = mediatorLiveData3;
                Boolean bool3 = (Boolean) this._moduleFilterHasShow.getValue();
                if (bool3 == null) {
                    bool3 = Boolean.FALSE;
                }
                List list = (List) this._moduleList.getValue();
                if (list != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (((QuickSearchModuleInfo) obj).getIsSelected()) {
                            arrayList.add(obj);
                        }
                    }
                    i3 = arrayList.size();
                } else {
                    i3 = 0;
                }
                mediatorLiveData4.setValue(new Pair<>(bool3, Integer.valueOf(i3)));
            }
        };
        mediatorLiveData3.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFilterViewModel.q2(Function1.this, obj);
            }
        });
        LiveData<QuickSearchSortType> a26 = pageViewModel.a2();
        final Function1<QuickSearchSortType, Unit> function14 = new Function1<QuickSearchSortType, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchFilterViewModel.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QuickSearchSortType quickSearchSortType) {
                invoke2(quickSearchSortType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QuickSearchSortType quickSearchSortType) {
                List emptyList;
                Logger.f235387a.d().i("QuickSearchFilterViewModel", 1, "initFilter");
                MediatorLiveData mediatorLiveData4 = QuickSearchFilterViewModel.this._moduleList;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                mediatorLiveData4.setValue(emptyList);
                MutableLiveData mutableLiveData3 = QuickSearchFilterViewModel.this._moduleFilterHasShow;
                Boolean bool2 = Boolean.FALSE;
                mutableLiveData3.setValue(bool2);
                QuickSearchFilterViewModel.this.preSelectedModuleList = null;
                QuickSearchFilterViewModel.this.n2().setValue(quickSearchSortType);
                cn cnVar = QuickSearchFilterViewModel.this._dateFilterInitEvent;
                Boolean bool3 = Boolean.TRUE;
                cnVar.setValue(bool3);
                QuickSearchFilterViewModel.this._dateFilterCloseEvent.setValue(bool3);
                QuickSearchFilterViewModel.this._dateFilterHasShow.setValue(bool2);
            }
        };
        a26.observeForever(new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFilterViewModel.T1(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchFilterViewModel$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2) {
                invoke2(bool2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool2) {
                MediatorLiveData<Boolean> mediatorLiveData4 = mediatorLiveData;
                T value = this._moduleFilterHasShow.getValue();
                Boolean bool3 = Boolean.TRUE;
                mediatorLiveData4.setValue(Boolean.valueOf(Intrinsics.areEqual(value, bool3) || Intrinsics.areEqual(this._dateFilterHasShow.getValue(), bool3)));
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFilterViewModel.r2(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchFilterViewModel$4$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2) {
                invoke2(bool2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool2) {
                MediatorLiveData<Boolean> mediatorLiveData4 = mediatorLiveData;
                T value = this._moduleFilterHasShow.getValue();
                Boolean bool3 = Boolean.TRUE;
                mediatorLiveData4.setValue(Boolean.valueOf(Intrinsics.areEqual(value, bool3) || Intrinsics.areEqual(this._dateFilterHasShow.getValue(), bool3)));
            }
        };
        mediatorLiveData.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.viewmodel.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFilterViewModel.s2(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final List<QuickSearchModuleInfo> f2() {
        List<QuickSearchModuleInfo> emptyList;
        List<QuickSearchModuleInfo> value = this._moduleList.getValue();
        if (value == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (((QuickSearchModuleInfo) obj).getIsSelected()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void A2(@NotNull QuickSearchSortType selectedType) {
        Intrinsics.checkNotNullParameter(selectedType, "selectedType");
        if (selectedType != this.sortSelectType.getValue()) {
            this.sortSelectType.setValue(selectedType);
            this.pageViewModel.r2(selectedType.getRankType());
        }
    }

    public final void c2() {
        int collectionSizeOrDefault;
        List<QuickSearchModuleInfo> value = this._moduleList.getValue();
        if (value == null) {
            return;
        }
        List<QuickSearchModuleInfo> list = value;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(QuickSearchModuleInfo.b((QuickSearchModuleInfo) it.next(), null, false, 1, null));
        }
        this._moduleList.setValue(new ArrayList(arrayList));
    }

    public final void d2() {
        this._dateFilterHasShow.setValue(Boolean.FALSE);
    }

    public final void e2() {
        this._moduleFilterHasShow.setValue(Boolean.FALSE);
    }

    @NotNull
    public final LiveData<Boolean> g2() {
        return this._dateFilterCloseEvent;
    }

    @NotNull
    public final LiveData<Boolean> h2() {
        return this._dateFilterInitEvent;
    }

    @NotNull
    public final LiveData<Boolean> i2() {
        return this._moduleFilterHasShow;
    }

    @NotNull
    public final LiveData<List<QuickSearchModuleInfo>> j2() {
        return this._moduleList;
    }

    @NotNull
    public final LiveData<Pair<Boolean, Integer>> k2() {
        return this._moduleSelectState;
    }

    @NotNull
    /* renamed from: l2, reason: from getter */
    public final QuickSearchViewModel getPageViewModel() {
        return this.pageViewModel;
    }

    @NotNull
    public final MediatorLiveData<Boolean> m2() {
        return this.sortSelectNeedHide;
    }

    @NotNull
    public final MutableLiveData<QuickSearchSortType> n2() {
        return this.sortSelectType;
    }

    public final void t2(@Nullable Pair<String, String> timeRange) {
        this.pageViewModel.q2(timeRange);
    }

    public final void u2() {
        Boolean value = this._moduleFilterHasShow.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            e2();
            x2();
        }
        this._dateFilterHasShow.setValue(bool);
    }

    public final void v2() {
        cn<Boolean> cnVar = this._dateFilterCloseEvent;
        Boolean bool = Boolean.TRUE;
        cnVar.setValue(bool);
        this._moduleFilterHasShow.setValue(bool);
        this.preSelectedModuleList = f2();
    }

    public final void w2() {
        Boolean value = this._moduleFilterHasShow.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            e2();
            x2();
        }
        this._dateFilterCloseEvent.setValue(bool);
    }

    public final void x2() {
        if (Intrinsics.areEqual(this.preSelectedModuleList, f2())) {
            return;
        }
        y2();
    }

    public final void y2() {
        List<Long> emptyList;
        int collectionSizeOrDefault;
        List<QuickSearchModuleInfo> value = this._moduleList.getValue();
        if (value == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (((QuickSearchModuleInfo) obj).getIsSelected()) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            emptyList = new ArrayList<>(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                emptyList.add(Long.valueOf(((QuickSearchModuleInfo) it.next()).getInfo().getChannelId()));
            }
        }
        this.pageViewModel.p2(emptyList);
    }

    public final void z2(int pos, @NotNull IGProGuildSearchFeedGroupInfo info, boolean selected) {
        ArrayList n3;
        Intrinsics.checkNotNullParameter(info, "info");
        List<QuickSearchModuleInfo> value = this._moduleList.getValue();
        if (value != null && (n3 = bg.f302144a.n(value)) != null) {
            boolean z16 = false;
            if (pos >= 0 && pos < n3.size()) {
                z16 = true;
            }
            if (z16) {
                n3.set(pos, new QuickSearchModuleInfo(info, selected));
            }
            this._moduleList.postValue(n3);
        }
    }
}
