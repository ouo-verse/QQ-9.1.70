package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.t;
import g25.b;
import g25.g;
import g25.h;
import g25.j;
import g25.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieHomeCategoryViewModel {
    public final StateHolder<Category> _category;
    public final Map<String, PageDataWrapper> _pageDataMap;
    public final Lazy adelieKuiklyModule$delegate;
    public final StateHolder<AdelieHomePageBannerConfig> bannerInfo;
    public final h defaultCategory;
    public final MutableState shouldShowAgreement$delegate;
    public String superResolutionUinBlacklist;

    public AdelieHomeCategoryViewModel() {
        List listOf;
        MutableState mutableStateOf$default;
        Lazy lazy;
        e eVar = e.f117232d;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new h(null, null, 3, null));
        this._category = new StateHolder<>(new Category(1, listOf));
        this._pageDataMap = new LinkedHashMap();
        this.bannerInfo = new StateHolder<>(new AdelieHomePageBannerConfig(0L, null, 3, null));
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.shouldShowAgreement$delegate = mutableStateOf$default;
        this.defaultCategory = new h("0", "\u63a8\u8350");
        this.superResolutionUinBlacklist = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyBaseModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel$adelieKuiklyModule$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieKuiklyBaseModule invoke() {
                return (AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
            }
        });
        this.adelieKuiklyModule$delegate = lazy;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel$PageDataWrapper>] */
    public final synchronized PageDataWrapper getPageDataWrapper(h hVar) {
        Object obj;
        ?? r06 = this._pageDataMap;
        String str = hVar.f401163d;
        obj = r06.get(str);
        if (obj == null) {
            obj = new PageDataWrapper(hVar, new StateHolder(new RecommondPageData(PageDataType.NONE, new ArrayList())), new AdelieHomeCategoryViewModel$getPageDataWrapper$1$1(this));
            r06.put(str, obj);
        }
        return (PageDataWrapper) obj;
    }

    public final String parseSuperResolutionUinBlackList(String str) {
        try {
            return new com.tencent.kuikly.core.nvi.serialization.json.e(str).p("uinBlacklist");
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("parseSuperResolutionUinBlackList error, ", th5, KLog.INSTANCE, "AdelieHomeCategoryViewModel");
            return "";
        }
    }

    public final void requestLocalCachePageData(h hVar) {
        final PageDataWrapper pageDataWrapper = getPageDataWrapper(hVar);
        pageDataWrapper.recommondPageData._state.setValue(new RecommondPageData(PageDataType.LOADING, new ArrayList()));
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestLocalCachePageData start ");
        m3.append(pageDataWrapper.tabInfo.f401164e);
        kLog.i("AdelieHomeCategoryViewModel", m3.toString());
        Function1<byte[], Unit> function1 = new Function1<byte[], Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel$PageDataWrapper$requestLocalCachePageData$cacheHandler$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(byte[] bArr) {
                List<h> emptyList;
                byte[] bArr2 = bArr;
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestLocalCachePageData end ");
                m16.append(AdelieHomeCategoryViewModel.PageDataWrapper.this.tabInfo.f401164e);
                m16.append(" has value? ");
                AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(m16, bArr2 != null, kLog2, "AdelieHomeCategoryViewModel");
                if (bArr2 != null) {
                    if (!(bArr2.length == 0)) {
                        AdelieHomeCategoryViewModel.PageDataWrapper.this.hasLocalCache = true;
                        g25.c cVar = (g25.c) i.b(new g25.c(null, null, null, null, null, null, false, null, 0L, false, 1023, null), bArr2);
                        AdelieHomeCategoryViewModel.PageDataWrapper pageDataWrapper2 = AdelieHomeCategoryViewModel.PageDataWrapper.this;
                        if (!pageDataWrapper2.hasFetchServerData) {
                            Function2<List<h>, PageDataType, Unit> function2 = pageDataWrapper2.fillCategoryHooker;
                            j jVar = cVar.f401141e;
                            if (jVar == null || (emptyList = jVar.f401167d) == null) {
                                emptyList = CollectionsKt__CollectionsKt.emptyList();
                            }
                            PageDataType pageDataType = PageDataType.CACHE;
                            function2.invoke(emptyList, pageDataType);
                            List<b> list = cVar.f401142f;
                            h hVar2 = pageDataWrapper2.tabInfo;
                            pageDataWrapper2.recommondPageData._state.setValue(new RecommondPageData(pageDataType, pageDataWrapper2.processRobotRecommendCards(list, null, hVar2.f401164e, hVar2.f401163d, true, null)));
                            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("requestLocalCachePageData end ");
                            m17.append(pageDataWrapper2.tabInfo.f401164e);
                            m17.append(" setValue");
                            kLog2.i("AdelieHomeCategoryViewModel", m17.toString());
                            pageDataWrapper2.updateTurboDisplayIfNeeded();
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        AdelieKuiklyBaseModule adelieKuiklyModule = pageDataWrapper.getAdelieKuiklyModule();
        String str = pageDataWrapper.tabInfo.f401163d + util.base64_pad_url + PageDataExtKt.getUin(c.f117352a.g().getPageData());
        adelieKuiklyModule.getClass();
        function1.invoke(((com.tencent.kuikly.core.module.e) com.tencent.kuikly.core.pager.h.a().acquireModule("KRDiskCacheModule")).a(str));
        pageDataWrapper.refreshPageData();
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class PageDataWrapper {
        public final Lazy adelieKuiklyModule$delegate;
        public final Function2<List<h>, PageDataType, Unit> fillCategoryHooker;
        public boolean hasFetchServerData;
        public boolean hasLocalCache;
        public MutableState<Boolean> hasNextPage;
        public MutableState<Boolean> loadMoreing;
        public final StateHolder<RecommondPageData> recommondPageData;
        public MutableState<Boolean> refreshDone;
        public MutableState<Boolean> refreshing;
        public final h tabInfo;
        public final e requestScope = e.f117232d;
        public a pagingCookie = a.f30290b;
        public String dataVersion = "";

        /* JADX WARN: Multi-variable type inference failed */
        public PageDataWrapper(h hVar, StateHolder<RecommondPageData> stateHolder, Function2<? super List<h>, ? super PageDataType, Unit> function2) {
            MutableState<Boolean> mutableStateOf$default;
            MutableState<Boolean> mutableStateOf$default2;
            MutableState<Boolean> mutableStateOf$default3;
            MutableState<Boolean> mutableStateOf$default4;
            Lazy lazy;
            this.tabInfo = hVar;
            this.recommondPageData = stateHolder;
            this.fillCategoryHooker = function2;
            Boolean bool = Boolean.FALSE;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            this.loadMoreing = mutableStateOf$default;
            mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            this.hasNextPage = mutableStateOf$default2;
            mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            this.refreshing = mutableStateOf$default3;
            mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            this.refreshDone = mutableStateOf$default4;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyBaseModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel$PageDataWrapper$adelieKuiklyModule$2
                @Override // kotlin.jvm.functions.Function0
                public final AdelieKuiklyBaseModule invoke() {
                    return (AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
                }
            });
            this.adelieKuiklyModule$delegate = lazy;
        }

        public final AdelieKuiklyBaseModule getAdelieKuiklyModule() {
            return (AdelieKuiklyBaseModule) this.adelieKuiklyModule$delegate.getValue();
        }

        public final int hashCode() {
            return this.fillCategoryHooker.hashCode() + ((this.recommondPageData.hashCode() + (this.tabInfo.hashCode() * 31)) * 31);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
        
            if (r1 == null) goto L6;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void loadMorePageData(Function1<? super Boolean, Unit> function1) {
            List emptyList;
            T t16;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            RecommondPageData value = this.recommondPageData._state.getValue();
            if (value != null) {
                List<AbsDelegateData> list = value.data;
                t16 = list;
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            t16 = emptyList;
            objectRef.element = t16;
            if (this.refreshing.getValue().booleanValue()) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMorePageData refreshing tabInfo:");
                m3.append(this.tabInfo);
                kLog.e("AdelieHomeCategoryViewModel", m3.toString());
                return;
            }
            if (!this.refreshDone.getValue().booleanValue()) {
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMorePageData refresh not done tabInfo:");
                m16.append(this.tabInfo);
                kLog2.e("AdelieHomeCategoryViewModel", m16.toString());
                return;
            }
            if (this.loadMoreing.getValue().booleanValue()) {
                KLog kLog3 = KLog.INSTANCE;
                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMorePageData requesting tabInfo:");
                m17.append(this.tabInfo);
                kLog3.e("AdelieHomeCategoryViewModel", m17.toString());
                return;
            }
            if (!this.hasNextPage.getValue().booleanValue()) {
                KLog kLog4 = KLog.INSTANCE;
                StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMorePageData no next page tabInfo:");
                m18.append(this.tabInfo);
                kLog4.e("AdelieHomeCategoryViewModel", m18.toString());
                return;
            }
            this.loadMoreing.setValue(Boolean.TRUE);
            KLog kLog5 = KLog.INSTANCE;
            StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMorePageData start ");
            m19.append(this.tabInfo);
            kLog5.i("AdelieHomeCategoryViewModel", m19.toString());
            BuildersKt.e(this.requestScope, null, null, new AdelieHomeCategoryViewModel$PageDataWrapper$loadMorePageData$1(this, function1, objectRef, null), 3, null);
        }

        public final List<AbsDelegateData> processRobotRecommendCards(List<b> list, List<g> list2, String str, String str2, boolean z16, List<k> list3) {
            ArrayList arrayList = new ArrayList();
            if (z16) {
                AdelieKuiklyBaseModule adelieKuiklyModule = getAdelieKuiklyModule();
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ADELIE_GUIDE_HAS_SHOWN_ANIMATION_");
                m3.append(PageDataExtKt.getUin(c.f117352a.g().getPageData()));
                boolean booleanFromCache = adelieKuiklyModule.getBooleanFromCache(m3.toString());
                CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("hasShownAnimation:", booleanFromCache, KLog.INSTANCE, "AdelieHomeCategoryViewModel");
                arrayList.add(new BannerDelegateData(null, ((list2 == null || list2.isEmpty()) || booleanFromCache) ? null : list2.get(0)));
            }
            if (list3 != null) {
                list3.clear();
            }
            for (b bVar : list) {
                int i3 = bVar.f401138d;
                if (i3 == 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (g25.a aVar : bVar.f401139e) {
                        if (aVar != null) {
                            List<k> list4 = aVar.f401136i;
                            if (!(list4 == null || list4.isEmpty())) {
                                arrayList2.addAll(aVar.f401136i);
                            }
                        }
                    }
                    arrayList.add(new RegularDelegateData(arrayList2, str, str2));
                    if (list3 != null) {
                        list3.addAll(arrayList2);
                    }
                } else if (i3 == 1) {
                    arrayList.add(new HotDelegateData(bVar.f401139e));
                    for (g25.a aVar2 : bVar.f401139e) {
                        if (list3 != null) {
                            list3.addAll(aVar2.f401136i);
                        }
                    }
                } else if (i3 == 2) {
                    List<g25.a> list5 = bVar.f401139e;
                    if (!(list5 == null || list5.isEmpty())) {
                        for (g25.a aVar3 : bVar.f401139e) {
                            if (list3 != null) {
                                list3.addAll(aVar3.f401136i);
                            }
                        }
                        arrayList.add(new RoleDelegateData(bVar.f401139e.get(0)));
                    }
                } else if (i3 != 3) {
                    KLog.INSTANCE.e("AdelieHomeCategoryViewModel", "unknown type");
                } else {
                    List<g25.a> list6 = bVar.f401139e;
                    if (!(list6 == null || list6.isEmpty())) {
                        for (g25.a aVar4 : bVar.f401139e) {
                            if (list3 != null) {
                                list3.addAll(aVar4.f401136i);
                            }
                        }
                        arrayList.add(new ToolDelegateData(bVar.f401139e.get(0)));
                    }
                }
            }
            return arrayList;
        }

        public final void refreshPageData() {
            List<AbsDelegateData> emptyList;
            RecommondPageData value = this.recommondPageData._state.getValue();
            if (value == null || (emptyList = value.data) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            if (this.refreshing.getValue().booleanValue()) {
                return;
            }
            this.refreshing.setValue(Boolean.TRUE);
            this.dataVersion = "";
            this.pagingCookie = a.f30290b;
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("refreshPageData start "), this.tabInfo.f401164e, KLog.INSTANCE, "AdelieHomeCategoryViewModel");
            BuildersKt.e(this.requestScope, null, null, new AdelieHomeCategoryViewModel$PageDataWrapper$refreshPageData$1(this, emptyList, null), 3, null);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("PageDataWrapper(tabInfo=");
            m3.append(this.tabInfo);
            m3.append(", recommondPageData=");
            m3.append(this.recommondPageData);
            m3.append(", fillCategoryHooker=");
            m3.append(this.fillCategoryHooker);
            m3.append(')');
            return m3.toString();
        }

        public final void updateTurboDisplayIfNeeded() {
            if (Intrinsics.areEqual(this.tabInfo.f401163d, "0")) {
                t tVar = (t) c.f117352a.g().acquireModule("KRTurboDisplayModule");
                if (tVar.a()) {
                    KLog.INSTANCE.i("AdelieHomeCategoryViewModel", "update turbo display");
                    tVar.b();
                }
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageDataWrapper)) {
                return false;
            }
            PageDataWrapper pageDataWrapper = (PageDataWrapper) obj;
            return Intrinsics.areEqual(this.tabInfo, pageDataWrapper.tabInfo) && Intrinsics.areEqual(this.recommondPageData, pageDataWrapper.recommondPageData) && Intrinsics.areEqual(this.fillCategoryHooker, pageDataWrapper.fillCategoryHooker);
        }
    }
}
