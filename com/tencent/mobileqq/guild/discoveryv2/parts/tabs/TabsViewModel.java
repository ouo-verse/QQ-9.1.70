package com.tencent.mobileqq.guild.discoveryv2.parts.tabs;

import androidx.annotation.MainThread;
import androidx.annotation.UiThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.base.preload.WebProcessPreloader;
import com.tencent.mobileqq.guild.discoveryv2.adapters.GuildSubTabFragmentAdapter;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\u0012\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0017\u001a\u00020\u0005H\u0014R'\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R \u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140+0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001d\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140+0\u00188F\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u001c\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabsViewModel;", "Lef1/b;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "tabs", "", "X1", "", "account", "onAccountChanged", "", "tabId", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabViewModel;", "creator", "S1", "Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter$SubTabData;", "initialTab", "P1", "U1", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/a;", "refreshResult", "W1", "onCleared", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "R1", "()Landroidx/lifecycle/LiveData;", "liveTabList", "Landroidx/lifecycle/MediatorLiveData;", "D", "Landroidx/lifecycle/MediatorLiveData;", "_liveTabList", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "E", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "map", "Landroidx/lifecycle/MutableLiveData;", "Lef1/a;", "G", "Landroidx/lifecycle/MutableLiveData;", "_liveEventGuildTabClick", "Q1", "liveEventGuildTabClick", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TabsViewModel extends ef1.b {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy liveTabList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<List<IGProNavigationTab>> _liveTabList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private IGPSService gpsService;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, TabViewModel> map;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ef1.a<TabClickData>> _liveEventGuildTabClick;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ(\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0003R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabsViewModel$a;", "", "Landroidx/lifecycle/LiveData;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "source", "c", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabsViewModel$a$a", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "currentValue", "", "a", "", "d", "Z", "getFirstTime", "()Z", "setFirstTime", "(Z)V", "firstTime", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7729a implements Observer<List<? extends IGProNavigationTab>> {

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private boolean firstTime = true;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ MediatorLiveData<List<IGProNavigationTab>> f217714e;

            C7729a(MediatorLiveData<List<IGProNavigationTab>> mediatorLiveData) {
                this.f217714e = mediatorLiveData;
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(@Nullable List<? extends IGProNavigationTab> currentValue) {
                List<IGProNavigationTab> value = this.f217714e.getValue();
                if (this.firstTime || !Companion.e(value, currentValue)) {
                    this.firstTime = false;
                    MutableLiveData mutableLiveData = this.f217714e;
                    if (currentValue == null) {
                        currentValue = CollectionsKt__CollectionsKt.emptyList();
                    }
                    mutableLiveData.setValue(currentValue);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @MainThread
        public final LiveData<List<IGProNavigationTab>> c(LiveData<List<IGProNavigationTab>> source) {
            MediatorLiveData mediatorLiveData = new MediatorLiveData();
            mediatorLiveData.addSource(source, new C7729a(mediatorLiveData));
            return mediatorLiveData;
        }

        private static final boolean d(IGProNavigationTab iGProNavigationTab, IGProNavigationTab iGProNavigationTab2) {
            if (iGProNavigationTab.getTabId() == iGProNavigationTab2.getTabId() && iGProNavigationTab.getTabType() == iGProNavigationTab2.getTabType() && iGProNavigationTab.getSubType() == iGProNavigationTab2.getSubType() && Intrinsics.areEqual(iGProNavigationTab.getName(), iGProNavigationTab2.getName())) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean e(List<? extends IGProNavigationTab> list, List<? extends IGProNavigationTab> list2) {
            List zip;
            boolean z16;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            if (list.size() == list2.size()) {
                zip = CollectionsKt___CollectionsKt.zip(list, list2);
                List<Pair> list3 = zip;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    for (Pair pair : list3) {
                        if (!d((IGProNavigationTab) pair.component1(), (IGProNavigationTab) pair.component2())) {
                            z16 = false;
                            break;
                        }
                    }
                }
                z16 = true;
                if (!z16) {
                    return false;
                }
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f217715a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0 f217716b;

        public b(ViewModelStoreOwner viewModelStoreOwner, Function0 function0) {
            this.f217715a = viewModelStoreOwner;
            this.f217716b = function0;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            TabViewModel tabViewModel;
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            Function0 function0 = this.f217716b;
            if (function0 == null || (tabViewModel = (TabViewModel) function0.invoke()) == null) {
                tabViewModel = new TabViewModel(null, 0, 0, 7, null);
            }
            TimedValue timedValue = new TimedValue(tabViewModel, TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public TabsViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LiveData<List<? extends IGProNavigationTab>>>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsViewModel$liveTabList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveData<List<? extends IGProNavigationTab>> invoke() {
                MediatorLiveData mediatorLiveData;
                LiveData<List<? extends IGProNavigationTab>> c16;
                TabsViewModel.Companion companion = TabsViewModel.INSTANCE;
                mediatorLiveData = TabsViewModel.this._liveTabList;
                c16 = companion.c(mediatorLiveData);
                return c16;
            }
        });
        this.liveTabList = lazy;
        this._liveTabList = new MediatorLiveData<>();
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        this.gpsService = (IGPSService) S0;
        this.map = new LinkedHashMap();
        this._liveEventGuildTabClick = new MutableLiveData<>();
        final List<IGProNavigationTab> d16 = TabsSnapshot.f217705a.d();
        d16 = d16 == null ? CollectionsKt__CollectionsKt.emptyList() : d16;
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsViewModel$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                MediatorLiveData mediatorLiveData;
                MediatorLiveData mediatorLiveData2;
                List<IGProNavigationTab> list = d16;
                boolean z16 = false;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((IGProNavigationTab) it.next()).getTabType() == 1) {
                            z16 = true;
                            break;
                        }
                    }
                }
                if (!z16) {
                    mediatorLiveData = this._liveTabList;
                    mediatorLiveData.setValue(TabViewModel.INSTANCE.a());
                    return;
                }
                Logger logger = Logger.f235387a;
                List<IGProNavigationTab> list2 = d16;
                logger.d().i("TabsViewModel", 1, "loadTabsSnapshot: tabList.size=" + list2.size());
                mediatorLiveData2 = this._liveTabList;
                mediatorLiveData2.setValue(d16);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabViewModel T1(TabsViewModel tabsViewModel, int i3, Function0 function0, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            function0 = null;
        }
        return tabsViewModel.S1(i3, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void X1(List<? extends IGProNavigationTab> tabs) {
        String joinToString$default;
        boolean z16;
        boolean z17;
        boolean z18;
        List<? extends IGProNavigationTab> list = tabs;
        ArrayList<IGProNavigationTab> arrayList = new ArrayList();
        for (Object obj : list) {
            IGProNavigationTab iGProNavigationTab = (IGProNavigationTab) obj;
            if (iGProNavigationTab.getSubType() != 1 && iGProNavigationTab.getSubType() != 2) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (IGProNavigationTab iGProNavigationTab2 : arrayList) {
            String name = iGProNavigationTab2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "tab.name");
            TabViewModel P1 = P1(new GuildSubTabFragmentAdapter.SubTabData(name, iGProNavigationTab2.getTabType(), iGProNavigationTab2.getSubType(), iGProNavigationTab2.getTabId()));
            if (P1.R1().getValue() != null) {
                P1 = null;
            }
            if (P1 != null) {
                arrayList2.add(P1);
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        Logger.a d16 = Logger.f235387a.d();
        int size = arrayList2.size();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, null, null, null, 0, null, new Function1<TabViewModel, CharSequence>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsViewModel$preloadConfigTabContent$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull TabViewModel it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getTabId() + "|" + it.getTabType();
            }
        }, 31, null);
        d16.i("SubTabViewModel", 1, "preloadConfigTabContent: config.size=" + size + " / " + joinToString$default);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((IGProNavigationTab) it.next()).getSubType() == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (z17) {
            WebProcessPreloader.f214762a.g();
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            ((TabViewModel) it5.next()).b2();
        }
    }

    @NotNull
    public final TabViewModel P1(@Nullable GuildSubTabFragmentAdapter.SubTabData initialTab) {
        int i3;
        int i16;
        String str;
        if (initialTab != null) {
            i3 = initialTab.getType();
        } else {
            i3 = 1;
        }
        if (initialTab != null) {
            i16 = initialTab.getTabId();
        } else {
            i16 = 0;
        }
        if (initialTab == null || (str = initialTab.getName()) == null) {
            str = "";
        }
        return S1(i16, new TabsViewModel$ensureSubViewModel$subViewModel$1(str, i16, i3, this));
    }

    @NotNull
    public final LiveData<ef1.a<TabClickData>> Q1() {
        return this._liveEventGuildTabClick;
    }

    @NotNull
    public final LiveData<List<IGProNavigationTab>> R1() {
        return (LiveData) this.liveTabList.getValue();
    }

    @NotNull
    public final TabViewModel S1(int tabId, @Nullable Function0<TabViewModel> creator) {
        TabViewModel tabViewModel = this.map.get(Integer.valueOf(tabId));
        if (tabViewModel == null) {
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(this, new b(this, creator)).get("VM-" + tabId, TabViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026).get(key, T::class.java)");
            TabViewModel tabViewModel2 = (TabViewModel) viewModel;
            this.map.put(Integer.valueOf(tabId), tabViewModel2);
            return tabViewModel2;
        }
        return tabViewModel;
    }

    public final void U1(@Nullable GuildSubTabFragmentAdapter.SubTabData initialTab) {
        int i3;
        Logger.f235387a.d().i("SubTabViewModel", 1, "loadSubTabData");
        if (initialTab != null) {
            i3 = initialTab.getType();
        } else {
            i3 = 1;
        }
        TabViewModel P1 = P1(initialTab);
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                Logger.b bVar = new Logger.b();
                String str = "loadSubTabData: unknown tabType=" + i3;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("SubTabViewModel", 1, (String) it.next(), null);
                }
                return;
            }
            P1.b2();
        }
    }

    public final void W1(@NotNull TabClickData refreshResult) {
        Intrinsics.checkNotNullParameter(refreshResult, "refreshResult");
        this._liveEventGuildTabClick.setValue(new ef1.a<>(refreshResult));
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        this.gpsService = (IGPSService) S0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Iterator<T> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            this._liveTabList.removeSource(((TabViewModel) ((Map.Entry) it.next()).getValue()).U1());
        }
        this.map.clear();
    }
}
