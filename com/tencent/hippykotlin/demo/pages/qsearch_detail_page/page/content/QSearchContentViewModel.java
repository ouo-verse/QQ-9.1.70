package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchNetResultTabsRsp;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.GroupSearchFilterConditionCustom;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.NetReqTabRsp;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchTabNetRepo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.ExpressionTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchGuildTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTroopTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchPagePerfReporter;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.pager.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.k;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.u;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchContentViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchContentViewModel.class, "tabTypeList", "getTabTypeList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchContentViewModel.class, "currentIndex", "getCurrentIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchContentViewModel.class, "isPagerScrolling", "isPagerScrolling()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchContentViewModel.class, "isPagerDragging", "isPagerDragging()Z", 0)};
    public static final Companion Companion = new Companion();
    public boolean hideTab;
    public int initTab;
    public final ReadWriteProperty isPagerDragging$delegate;
    public final ReadWriteProperty isPagerScrolling$delegate;
    public QSearchLBSPermissionHelper lbsPermissionHelper;
    public final g pageData;
    public final QSearchPagePerfReporter perfReporter;
    public final QSearchTabNetRepo repo;
    public final Map<String, QSearchTabContentViewModel> subPageViewModelMap;
    public GroupSearchFilterConditionCustom troopConditionFilter;
    public final boolean useOIDBReq;
    public final ReadWriteProperty tabTypeList$delegate = c.b();
    public final ReadWriteProperty currentIndex$delegate = c.a(0);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public static final boolean access$isSameTabInfos(Companion companion, List list, List list2) {
            companion.getClass();
            if (list.size() != list2.size()) {
                return false;
            }
            int size = list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    return true;
                }
                UnifySearchTabInfo unifySearchTabInfo = (UnifySearchTabInfo) list.get(i3);
                UnifySearchTabInfo unifySearchTabInfo2 = (UnifySearchTabInfo) list2.get(i3);
                if (!(unifySearchTabInfo.tabMask == unifySearchTabInfo2.tabMask && Intrinsics.areEqual(unifySearchTabInfo.tabName, unifySearchTabInfo2.tabName))) {
                    return false;
                }
                i3++;
            }
        }
    }

    public QSearchContentViewModel(QSearchTabNetRepo qSearchTabNetRepo, g gVar, QSearchPagePerfReporter qSearchPagePerfReporter, boolean z16) {
        this.repo = qSearchTabNetRepo;
        this.pageData = gVar;
        this.perfReporter = qSearchPagePerfReporter;
        this.useOIDBReq = z16;
        Boolean bool = Boolean.FALSE;
        this.isPagerScrolling$delegate = c.a(bool);
        this.isPagerDragging$delegate = c.a(bool);
        this.lbsPermissionHelper = new QSearchLBSPermissionHelper();
        this.troopConditionFilter = new GroupSearchFilterConditionCustom();
        this.subPageViewModelMap = new LinkedHashMap();
        this.initTab = gVar.n().k("tab_mask", 0);
        boolean z17 = gVar.n().k("hide_tab", 0) == 1;
        this.hideTab = z17;
        if (this.initTab > 0) {
            if (z17) {
                getTabTypeList().add(new UnifySearchTabInfo(this.initTab, 1));
            } else {
                NetworkUtils.INSTANCE.bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentViewModel.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QSearchContentViewModel.this.getTabTypeList();
                    }
                }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentViewModel.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        int size = QSearchContentViewModel.this.getTabTypeList().size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size) {
                                break;
                            }
                            int i16 = (int) QSearchContentViewModel.this.getTabTypeList().get(i3).tabMask;
                            QSearchContentViewModel qSearchContentViewModel = QSearchContentViewModel.this;
                            if (i16 == qSearchContentViewModel.initTab) {
                                qSearchContentViewModel.currentIndex$delegate.setValue(qSearchContentViewModel, QSearchContentViewModel.$$delegatedProperties[1], Integer.valueOf(i3));
                                break;
                            }
                            i3++;
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel>] */
    public static final void access$onUpdateTroopConditionFilter(QSearchContentViewModel qSearchContentViewModel) {
        for (QSearchTabContentViewModel qSearchTabContentViewModel : qSearchContentViewModel.subPageViewModelMap.values()) {
            if (qSearchTabContentViewModel instanceof QSearchTroopTabContentViewModel) {
                ((QSearchTroopTabContentViewModel) qSearchTabContentViewModel).updateConditions(qSearchContentViewModel.troopConditionFilter);
                return;
            }
        }
    }

    public final int getCurrentIndex() {
        return ((Number) this.currentIndex$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final UnifySearchTabInfo getCurrentTabInfo() {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(getTabTypeList(), getCurrentIndex());
        return (UnifySearchTabInfo) orNull;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel>] */
    public final QSearchTabContentViewModel getTabContentViewModel(int i3) {
        if (i3 < 0 || i3 >= getTabTypeList().size()) {
            return null;
        }
        return (QSearchTabContentViewModel) this.subPageViewModelMap.get(getTabTypeList().get(i3).tabName);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<UnifySearchTabInfo> getTabTypeList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tabTypeList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean isPagerScrolling() {
        return ((Boolean) this.isPagerScrolling$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final void fetchNetTabs(int i3, boolean z16) {
        if (z16) {
            this.repo.loadTabs(i3, true, new Function2<Boolean, NetReqTabRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentViewModel$fetchNetTabsByOIDB$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Boolean bool, NetReqTabRsp netReqTabRsp) {
                    k kVar;
                    b bVar;
                    NetReqTabRsp netReqTabRsp2 = netReqTabRsp;
                    if (bool.booleanValue() && netReqTabRsp2 != null && (kVar = netReqTabRsp2.oidbRsp) != null) {
                        QSearchContentViewModel qSearchContentViewModel = QSearchContentViewModel.this;
                        qSearchContentViewModel.troopConditionFilter.oidbFilter = kVar.f413217h;
                        QSearchContentViewModel.access$onUpdateTroopConditionFilter(qSearchContentViewModel);
                        int i16 = netReqTabRsp2.oidbRsp.f413218i;
                        if (i16 != 0) {
                            Utils.INSTANCE.cacheModule("").setInt("search_histories_max_count", Integer.valueOf(i16));
                        }
                        List<u> list = netReqTabRsp2.oidbRsp.f413216f;
                        ArrayList arrayList = new ArrayList();
                        for (u uVar : list) {
                            arrayList.add(new UnifySearchTabInfo(uVar.f413260d, uVar.f413261e));
                        }
                        QSearchContentViewModel qSearchContentViewModel2 = QSearchContentViewModel.this;
                        ArrayList arrayList2 = new ArrayList();
                        if (!Utils.INSTANCE.currentBridgeModule().canOpenMiniApp()) {
                            ArrayList arrayList3 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                Object next = it.next();
                                if (((int) ((UnifySearchTabInfo) next).tabMask) != 7) {
                                    arrayList3.add(next);
                                }
                            }
                            arrayList2.addAll(arrayList3);
                        } else {
                            arrayList2.addAll(arrayList);
                        }
                        if (!QSearchContentViewModel.Companion.access$isSameTabInfos(QSearchContentViewModel.Companion, qSearchContentViewModel2.getTabTypeList(), arrayList2)) {
                            try {
                                bVar = new b();
                                Iterator it5 = arrayList2.iterator();
                                while (it5.hasNext()) {
                                    bVar.t(((UnifySearchTabInfo) it5.next()).encode());
                                }
                            } catch (JSONException e16) {
                                Utils.INSTANCE.logToNative("QSearchStorageUtil #saveTabInfoList:" + e16);
                                bVar = null;
                            }
                            if (bVar != null) {
                                Utils.INSTANCE.cacheModule("").setItem("search_tab_infos", bVar.toString());
                            }
                            while (qSearchContentViewModel2.getTabTypeList().size() > 1) {
                                CollectionsKt__MutableCollectionsKt.removeLast(qSearchContentViewModel2.getTabTypeList());
                            }
                            if (arrayList.size() > 1) {
                                CollectionsKt__MutableCollectionsKt.removeFirst(arrayList2);
                                qSearchContentViewModel2.getTabTypeList().addAll(arrayList2);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        } else {
            this.repo.loadTabs(i3, false, new Function2<Boolean, NetReqTabRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.QSearchContentViewModel$fetchNetTabsByMsf$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Boolean bool, NetReqTabRsp netReqTabRsp) {
                    UnifySearchNetResultTabsRsp unifySearchNetResultTabsRsp;
                    b bVar;
                    NetReqTabRsp netReqTabRsp2 = netReqTabRsp;
                    if (bool.booleanValue() && netReqTabRsp2 != null && (unifySearchNetResultTabsRsp = netReqTabRsp2.msfRsp) != null) {
                        QSearchContentViewModel qSearchContentViewModel = QSearchContentViewModel.this;
                        qSearchContentViewModel.troopConditionFilter.msfFilter = unifySearchNetResultTabsRsp.groupFilterCondition;
                        QSearchContentViewModel.access$onUpdateTroopConditionFilter(qSearchContentViewModel);
                        int i16 = netReqTabRsp2.msfRsp.searchHistoryCount;
                        if (i16 != 0) {
                            Utils.INSTANCE.cacheModule("").setInt("search_histories_max_count", Integer.valueOf(i16));
                        }
                        List<UnifySearchTabInfo> list = netReqTabRsp2.msfRsp.tabs;
                        if (list != null) {
                            QSearchContentViewModel qSearchContentViewModel2 = QSearchContentViewModel.this;
                            ArrayList arrayList = new ArrayList();
                            if (!Utils.INSTANCE.currentBridgeModule().canOpenMiniApp()) {
                                ArrayList arrayList2 = new ArrayList();
                                for (Object obj : list) {
                                    if (((int) ((UnifySearchTabInfo) obj).tabMask) != 7) {
                                        arrayList2.add(obj);
                                    }
                                }
                                arrayList.addAll(arrayList2);
                            } else {
                                arrayList.addAll(list);
                            }
                            if (!QSearchContentViewModel.Companion.access$isSameTabInfos(QSearchContentViewModel.Companion, qSearchContentViewModel2.getTabTypeList(), arrayList)) {
                                try {
                                    bVar = new b();
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        bVar.t(((UnifySearchTabInfo) it.next()).encode());
                                    }
                                } catch (JSONException e16) {
                                    Utils.INSTANCE.logToNative("QSearchStorageUtil #saveTabInfoList:" + e16);
                                    bVar = null;
                                }
                                if (bVar != null) {
                                    Utils.INSTANCE.cacheModule("").setItem("search_tab_infos", bVar.toString());
                                }
                                while (qSearchContentViewModel2.getTabTypeList().size() > 1) {
                                    CollectionsKt__MutableCollectionsKt.removeLast(qSearchContentViewModel2.getTabTypeList());
                                }
                                if (list.size() > 1) {
                                    CollectionsKt__MutableCollectionsKt.removeFirst(arrayList);
                                    qSearchContentViewModel2.getTabTypeList().addAll(arrayList);
                                }
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel>] */
    public final QSearchTabContentViewModel getTabContentViewModel(UnifySearchTabInfo unifySearchTabInfo) {
        QSearchTabContentViewModel qSearchGuildTabContentViewModel;
        if (this.subPageViewModelMap.get(unifySearchTabInfo.tabName) == null) {
            Map<String, QSearchTabContentViewModel> map = this.subPageViewModelMap;
            String str = unifySearchTabInfo.tabName;
            GroupSearchFilterConditionCustom groupSearchFilterConditionCustom = this.troopConditionFilter;
            g gVar = this.pageData;
            QSearchPagePerfReporter qSearchPagePerfReporter = this.perfReporter;
            QSearchLBSPermissionHelper qSearchLBSPermissionHelper = this.lbsPermissionHelper;
            boolean z16 = this.useOIDBReq;
            int i3 = (int) unifySearchTabInfo.tabMask;
            if (i3 == 3) {
                qSearchGuildTabContentViewModel = new QSearchGuildTabContentViewModel(unifySearchTabInfo, gVar, qSearchPagePerfReporter, qSearchLBSPermissionHelper, z16);
            } else if (i3 == 4) {
                qSearchGuildTabContentViewModel = new ExpressionTabContentViewModel(unifySearchTabInfo, gVar, qSearchPagePerfReporter, qSearchLBSPermissionHelper, z16);
            } else if (i3 != 6) {
                qSearchGuildTabContentViewModel = new QSearchTabContentViewModel(unifySearchTabInfo, gVar, qSearchPagePerfReporter, qSearchLBSPermissionHelper, z16);
            } else {
                qSearchGuildTabContentViewModel = new QSearchTroopTabContentViewModel(unifySearchTabInfo, groupSearchFilterConditionCustom, gVar, qSearchPagePerfReporter, qSearchLBSPermissionHelper, z16);
            }
            map.put(str, qSearchGuildTabContentViewModel);
        }
        Object obj = this.subPageViewModelMap.get(unifySearchTabInfo.tabName);
        Intrinsics.checkNotNull(obj);
        return (QSearchTabContentViewModel) obj;
    }
}
