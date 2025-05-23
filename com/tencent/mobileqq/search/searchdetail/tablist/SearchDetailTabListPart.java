package com.tencent.mobileqq.search.searchdetail.tablist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.content.repo.RefreshType;
import com.tencent.mobileqq.search.searchdetail.eventbus.CancelCorrectionEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.ChangeTabEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.ModifyCorrectionWordEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.SearchWithNewQueryEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.StartSearchEvent;
import com.tencent.mobileqq.search.searchdetail.eventbus.UpdateParentTpEvent;
import com.tencent.mobileqq.search.searchdetail.r;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp2.KeyWordChangeEvent;
import tl.h;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 R2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002STB\u0007\u00a2\u0006\u0004\bP\u0010QJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0016\u0010\u001a\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0016\u0010\u001b\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0018H\u0002J\u001c\u0010\"\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010#\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001e\u0010)\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u001c\u0010*\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\u0012\u0010-\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030/0.H\u0016R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010M\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lrp2/b;", "it", "", "N9", "keywordFrom", "Lcom/tencent/mobileqq/search/searchdetail/content/repo/RefreshType;", "O9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "R9", "U9", "newTabIndex", "P9", "", "needReportClick", "V9", "Q9", "initViewModel", "", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "tabList", "W9", "Y9", "tabInfo", "M9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onInitView", "", "action", "", "args", "getMessage", "handleBroadcastMessage", "onBackEvent", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "d", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabBar", "Landroidx/viewpager2/widget/ViewPager2;", "e", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/tencent/mobileqq/search/searchdetail/tablist/b;", "f", "Lcom/tencent/mobileqq/search/searchdetail/tablist/b;", "contentAdapter", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel;", h.F, "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel;", "viewModel", "i", "Z", "needBindViewPager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "refTabInfo", BdhLogUtil.LogTag.Tag_Conn, "curTabInfo", "D", "I", "curPos", "E", "Landroid/view/View;", "containerView", UserInfo.SEX_FEMALE, "<init>", "()V", "G", "a", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchDetailTabListPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: D, reason: from kotlin metadata */
    private int curPos;

    /* renamed from: E, reason: from kotlin metadata */
    private View containerView;

    /* renamed from: F, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUIPageTabBar tabBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b contentAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SearchDetailTabListViewModel viewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needBindViewPager = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SearchDetailTabListViewModel.TabInfo refTabInfo = new SearchDetailTabListViewModel.TabInfo("\u5168\u90e8", 1);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private SearchDetailTabListViewModel.TabInfo curTabInfo = new SearchDetailTabListViewModel.TabInfo("\u5168\u90e8", 1);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListPart$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "keyword", "b", "I", "()I", "keywordFrom", "<init>", "(Ljava/lang/String;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListPart$b, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class StartSearchEntity {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String keyword;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int keywordFrom;

        public StartSearchEntity(@NotNull String keyword, int i3) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            this.keyword = keyword;
            this.keywordFrom = i3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getKeyword() {
            return this.keyword;
        }

        /* renamed from: b, reason: from getter */
        public final int getKeywordFrom() {
            return this.keywordFrom;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartSearchEntity)) {
                return false;
            }
            StartSearchEntity startSearchEntity = (StartSearchEntity) other;
            if (Intrinsics.areEqual(this.keyword, startSearchEntity.keyword) && this.keywordFrom == startSearchEntity.keywordFrom) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.keyword.hashCode() * 31) + this.keywordFrom;
        }

        @NotNull
        public String toString() {
            return "StartSearchEntity(keyword=" + this.keyword + ", keywordFrom=" + this.keywordFrom + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListPart$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            int i3;
            super.onPageSelected(position);
            b bVar = SearchDetailTabListPart.this.contentAdapter;
            SearchDetailTabListViewModel searchDetailTabListViewModel = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                bVar = null;
            }
            List<SearchDetailTabListViewModel.TabInfo> items = bVar.getItems();
            if (!items.isEmpty() && position <= items.size()) {
                SearchDetailTabListPart searchDetailTabListPart = SearchDetailTabListPart.this;
                searchDetailTabListPart.refTabInfo = searchDetailTabListPart.curTabInfo;
                SearchDetailTabListPart.this.curTabInfo = items.get(position);
                SearchDetailTabListPart.this.curPos = position;
                SearchDetailTabListViewModel searchDetailTabListViewModel2 = SearchDetailTabListPart.this.viewModel;
                if (searchDetailTabListViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    searchDetailTabListViewModel2 = null;
                }
                searchDetailTabListViewModel2.c2(10);
                SearchDetailTabListPart searchDetailTabListPart2 = SearchDetailTabListPart.this;
                searchDetailTabListPart2.broadcastMessage("tabChanged", searchDetailTabListPart2.curTabInfo);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                SearchDetailTabListViewModel.TabInfo tabInfo = SearchDetailTabListPart.this.curTabInfo;
                SearchDetailTabListViewModel searchDetailTabListViewModel3 = SearchDetailTabListPart.this.viewModel;
                if (searchDetailTabListViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    searchDetailTabListViewModel = searchDetailTabListViewModel3;
                }
                UpdateParentTpEvent updateParentTpEvent = new UpdateParentTpEvent(tabInfo, searchDetailTabListViewModel.getWxPreSearchId());
                Activity activity = SearchDetailTabListPart.this.getActivity();
                if (activity != null) {
                    i3 = activity.hashCode();
                } else {
                    i3 = 0;
                }
                updateParentTpEvent.mHashCode = i3;
                simpleEventBus.dispatchEvent(updateParentTpEvent);
                QLog.d("QQSearch.NetDetail.SearchDetailTabListPart", 1, "onPageSelected: curPos=" + position + " refTabInfo=" + SearchDetailTabListPart.this.refTabInfo + " curTabInfo=" + SearchDetailTabListPart.this.curTabInfo);
                SearchDetailTabListPart searchDetailTabListPart3 = SearchDetailTabListPart.this;
                searchDetailTabListPart3.P9(searchDetailTabListPart3.curPos);
            }
        }
    }

    private final void M9(SearchDetailTabListViewModel.TabInfo tabInfo) {
        SearchDetailTabListViewModel searchDetailTabListViewModel = this.viewModel;
        ViewPager2 viewPager2 = null;
        if (searchDetailTabListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel = null;
        }
        int M1 = searchDetailTabListViewModel.M1(tabInfo);
        if (M1 >= 0) {
            QUIPageTabBar qUIPageTabBar = this.tabBar;
            if (qUIPageTabBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                qUIPageTabBar = null;
            }
            qUIPageTabBar.setCurrentPosition(M1, true);
            ViewPager2 viewPager22 = this.viewPager;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager2 = viewPager22;
            }
            viewPager2.setCurrentItem(M1, false);
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabListPart", 1, "changeTab targetPos=" + M1 + " tabInfo=" + tabInfo);
        }
    }

    private final int N9(KeyWordChangeEvent it) {
        int keyWordFrom = it.getKeyWordFrom();
        if (keyWordFrom == 1) {
            return 2;
        }
        if (keyWordFrom != 2) {
            if (keyWordFrom == 3) {
                return 6;
            }
            if (keyWordFrom == 4) {
                return 2;
            }
            if (keyWordFrom != 6) {
                if (keyWordFrom != 21) {
                    if (keyWordFrom != 22) {
                        return 0;
                    }
                    return 34;
                }
                return com.tencent.mobileqq.search.searchdetail.e.f284431a.a();
            }
            return 12;
        }
        return 7;
    }

    private final RefreshType O9(int keywordFrom) {
        if (keywordFrom != 2) {
            if (keywordFrom != 3) {
                if (keywordFrom != 5) {
                    return RefreshType.TYPE_USER_INPUT_SEARCH;
                }
                return RefreshType.TYPE_CANCEL_CORRECT;
            }
            return RefreshType.TYPE_HISTORY_SEARCH;
        }
        return RefreshType.TYPE_SUGGESTION_SEARCH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(int newTabIndex) {
        V9(true);
    }

    private final void Q9() {
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        SearchDetailTabListViewModel searchDetailTabListViewModel = this.viewModel;
        if (searchDetailTabListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel = null;
        }
        this.contentAdapter = new b(hostFragment, searchDetailTabListViewModel);
    }

    private final void R9(View rootView) {
        View findViewById = rootView.findViewById(R.id.j_x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<QUIPageTabBar>(R.id.tabbar)");
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) findViewById;
        this.tabBar = qUIPageTabBar;
        if (qUIPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar = null;
        }
        qUIPageTabBar.setOnCurrentTabClickListener(new QUIPageTabBar.h() { // from class: com.tencent.mobileqq.search.searchdetail.tablist.d
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.h
            public final void k1(int i3) {
                SearchDetailTabListPart.S9(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void U9() {
        Q9();
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        b bVar = this.contentAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
            bVar = null;
        }
        viewPager2.setAdapter(bVar);
        if (r.f284572a.b()) {
            ViewPager2 viewPager23 = this.viewPager;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager23 = null;
            }
            viewPager23.setOffscreenPageLimit(1);
        }
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager24;
        }
        viewPager22.registerOnPageChangeCallback(new c());
    }

    private final void V9(boolean needReportClick) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        linkedHashMap.put("pageId", "pg_qq_network_search_result_level2_page");
        linkedHashMap.put("tab_name", this.curTabInfo.getTabName());
        linkedHashMap.put("tab_mask", String.valueOf(this.curTabInfo.getTabMask()));
        SearchDetailTabListViewModel searchDetailTabListViewModel = this.viewModel;
        SearchDetailTabListViewModel searchDetailTabListViewModel2 = null;
        if (searchDetailTabListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel = null;
        }
        linkedHashMap.put("query_source", String.valueOf(searchDetailTabListViewModel.getPageParam().getQuerySource()));
        SearchDetailTabListViewModel searchDetailTabListViewModel3 = this.viewModel;
        if (searchDetailTabListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel3 = null;
        }
        linkedHashMap.put("user_source", String.valueOf(searchDetailTabListViewModel3.getPageParam().getUserSource()));
        SearchDetailTabListViewModel searchDetailTabListViewModel4 = this.viewModel;
        if (searchDetailTabListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel4 = null;
        }
        linkedHashMap.put("search_query_text", searchDetailTabListViewModel4.getPageParam().getKeyword());
        SearchDetailTabListViewModel searchDetailTabListViewModel5 = this.viewModel;
        if (searchDetailTabListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            searchDetailTabListViewModel2 = searchDetailTabListViewModel5;
        }
        linkedHashMap.put("search_trace_id", searchDetailTabListViewModel2.getCurrentTraceId());
        linkedHashMap.put("xsj_custom_pgid", "pg_qq_network_search_result_level2_page");
        linkedHashMap.put("xsj_eid", "em_search_top_tab");
        linkedHashMap.put("eid", "em_search_top_tab");
        linkedHashMap.put("ref_tab_name", this.refTabInfo.getTabName());
        VideoReport.reportEvent("ev_xsj_abnormal_imp", linkedHashMap);
        if (needReportClick) {
            VideoReport.reportEvent("ev_xsj_abnormal_clck", linkedHashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(List<SearchDetailTabListViewModel.TabInfo> tabList) {
        if (!tabList.isEmpty()) {
            b bVar = this.contentAdapter;
            ViewPager2 viewPager2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                bVar = null;
            }
            bVar.setItems(tabList);
            ViewPager2 viewPager22 = this.viewPager;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager2 = viewPager22;
            }
            viewPager2.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.tablist.e
                @Override // java.lang.Runnable
                public final void run() {
                    SearchDetailTabListPart.X9(SearchDetailTabListPart.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(SearchDetailTabListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        VideoReport.traversePage(viewPager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9(List<SearchDetailTabListViewModel.TabInfo> tabList) {
        if (!tabList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (SearchDetailTabListViewModel.TabInfo tabInfo : tabList) {
                arrayList.add(tabInfo.getTabName());
                QLog.d("QQSearch.NetDetail.SearchDetailTabListPart", 1, "addTab, name:" + tabInfo.getTabName() + ", type:" + tabInfo.getTabMask());
            }
            QUIPageTabBar qUIPageTabBar = this.tabBar;
            ViewPager2 viewPager2 = null;
            if (qUIPageTabBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                qUIPageTabBar = null;
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            qUIPageTabBar.setTabData((String[]) array);
            if (this.needBindViewPager) {
                SearchDetailTabListViewModel searchDetailTabListViewModel = this.viewModel;
                if (searchDetailTabListViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    searchDetailTabListViewModel = null;
                }
                int M1 = searchDetailTabListViewModel.M1(this.curTabInfo);
                ViewPager2 viewPager22 = this.viewPager;
                if (viewPager22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager22 = null;
                }
                viewPager22.setCurrentItem(M1, false);
                QUIPageTabBar qUIPageTabBar2 = this.tabBar;
                if (qUIPageTabBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                    qUIPageTabBar2 = null;
                }
                ViewPager2 viewPager23 = this.viewPager;
                if (viewPager23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                } else {
                    viewPager2 = viewPager23;
                }
                qUIPageTabBar2.bindViewPager2(viewPager2);
                this.needBindViewPager = false;
                Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabListPart", 1, "setTabData list=" + tabList + " targetPos=" + M1 + " curTab=" + this.curTabInfo);
            }
        }
    }

    private final void initViewModel() {
        SearchDetailTabListViewModel searchDetailTabListViewModel = this.viewModel;
        QUIPageTabBar qUIPageTabBar = null;
        if (searchDetailTabListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel = null;
        }
        MutableLiveData<List<SearchDetailTabListViewModel.TabInfo>> Q1 = searchDetailTabListViewModel.Q1();
        Fragment hostFragment = getHostFragment();
        final Function1<List<? extends SearchDetailTabListViewModel.TabInfo>, Unit> function1 = new Function1<List<? extends SearchDetailTabListViewModel.TabInfo>, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends SearchDetailTabListViewModel.TabInfo> list) {
                invoke2((List<SearchDetailTabListViewModel.TabInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<SearchDetailTabListViewModel.TabInfo> it) {
                Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabListPart", 1, "tab list changed. " + it);
                SearchDetailTabListPart searchDetailTabListPart = SearchDetailTabListPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                searchDetailTabListPart.W9(it);
                SearchDetailTabListPart.this.Y9(it);
            }
        };
        Q1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.tablist.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchDetailTabListPart.T9(Function1.this, obj);
            }
        });
        SearchDetailTabListViewModel searchDetailTabListViewModel2 = this.viewModel;
        if (searchDetailTabListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel2 = null;
        }
        SearchDetailTabListViewModel searchDetailTabListViewModel3 = this.viewModel;
        if (searchDetailTabListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel3 = null;
        }
        searchDetailTabListViewModel2.Z1(searchDetailTabListViewModel3.getPageParam().getQuerySource());
        SearchDetailTabListViewModel searchDetailTabListViewModel4 = this.viewModel;
        if (searchDetailTabListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel4 = null;
        }
        if (searchDetailTabListViewModel4.getPageParam().getHideTab()) {
            QUIPageTabBar qUIPageTabBar2 = this.tabBar;
            if (qUIPageTabBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            } else {
                qUIPageTabBar = qUIPageTabBar2;
            }
            qUIPageTabBar.setVisibility(8);
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabListPart", 1, "hide tab");
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ChangeTabEvent.class, ModifyCorrectionWordEvent.class, CancelCorrectionEvent.class, SearchWithNewQueryEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (action != null) {
            SearchDetailTabListViewModel searchDetailTabListViewModel = null;
            switch (action.hashCode()) {
                case -1905852979:
                    if (action.equals("getQuerySource")) {
                        SearchDetailTabListViewModel searchDetailTabListViewModel2 = this.viewModel;
                        if (searchDetailTabListViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            searchDetailTabListViewModel = searchDetailTabListViewModel2;
                        }
                        return Integer.valueOf(searchDetailTabListViewModel.getPageParam().getQuerySource());
                    }
                    break;
                case -1816805664:
                    if (action.equals("getQueryInfo")) {
                        SearchDetailTabListViewModel searchDetailTabListViewModel3 = this.viewModel;
                        if (searchDetailTabListViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            searchDetailTabListViewModel3 = null;
                        }
                        String keyword = searchDetailTabListViewModel3.getPageParam().getKeyword();
                        SearchDetailTabListViewModel searchDetailTabListViewModel4 = this.viewModel;
                        if (searchDetailTabListViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            searchDetailTabListViewModel = searchDetailTabListViewModel4;
                        }
                        return new Pair(keyword, searchDetailTabListViewModel.getCurrentTraceId());
                    }
                    break;
                case -1357812152:
                    if (action.equals("getPageMode")) {
                        SearchDetailTabListViewModel searchDetailTabListViewModel5 = this.viewModel;
                        if (searchDetailTabListViewModel5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            searchDetailTabListViewModel = searchDetailTabListViewModel5;
                        }
                        return Integer.valueOf(searchDetailTabListViewModel.getPageParam().getPageMode());
                    }
                    break;
                case -517078611:
                    if (action.equals("getTabInfo")) {
                        return this.curTabInfo;
                    }
                    break;
                case -441702196:
                    if (action.equals("getPageSessionId")) {
                        SearchDetailTabListViewModel searchDetailTabListViewModel6 = this.viewModel;
                        if (searchDetailTabListViewModel6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            searchDetailTabListViewModel = searchDetailTabListViewModel6;
                        }
                        return searchDetailTabListViewModel.O1();
                    }
                    break;
            }
        }
        return super.getMessage(action, args);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        StartSearchEntity startSearchEntity;
        KeyWordChangeEvent keyWordChangeEvent;
        byte b16;
        boolean z16;
        boolean isBlank;
        if (action != null) {
            int i3 = 0;
            SearchDetailTabListViewModel searchDetailTabListViewModel = null;
            View view = null;
            SearchDetailTabListViewModel searchDetailTabListViewModel2 = null;
            switch (action.hashCode()) {
                case -1880505174:
                    if (action.equals("startSearch")) {
                        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabListPart", 1, "MESSAGE_START_SEARCH " + args);
                        View view2 = this.containerView;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("containerView");
                            view2 = null;
                        }
                        view2.setVisibility(0);
                        if (args instanceof StartSearchEntity) {
                            startSearchEntity = (StartSearchEntity) args;
                        } else {
                            startSearchEntity = null;
                        }
                        if (startSearchEntity != null) {
                            if (startSearchEntity.getKeywordFrom() == 21) {
                                SearchDetailTabListViewModel searchDetailTabListViewModel3 = this.viewModel;
                                if (searchDetailTabListViewModel3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    searchDetailTabListViewModel3 = null;
                                }
                                searchDetailTabListViewModel3.getPageParam().p(com.tencent.mobileqq.search.searchdetail.e.f284431a.a());
                            } else {
                                SearchDetailTabListViewModel searchDetailTabListViewModel4 = this.viewModel;
                                if (searchDetailTabListViewModel4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    searchDetailTabListViewModel4 = null;
                                }
                                searchDetailTabListViewModel4.getPageParam().p(2);
                            }
                            SearchDetailTabListViewModel searchDetailTabListViewModel5 = this.viewModel;
                            if (searchDetailTabListViewModel5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel5 = null;
                            }
                            searchDetailTabListViewModel5.getPageParam().n(startSearchEntity.getKeyword());
                            SearchDetailTabListViewModel searchDetailTabListViewModel6 = this.viewModel;
                            if (searchDetailTabListViewModel6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel6 = null;
                            }
                            searchDetailTabListViewModel6.getPageParam().q("");
                            SearchDetailTabListViewModel searchDetailTabListViewModel7 = this.viewModel;
                            if (searchDetailTabListViewModel7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel7 = null;
                            }
                            searchDetailTabListViewModel7.b2(false);
                            SearchDetailTabListViewModel searchDetailTabListViewModel8 = this.viewModel;
                            if (searchDetailTabListViewModel8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel8 = null;
                            }
                            com.tencent.mobileqq.search.searchdetail.content.wxminapp.c cVar = com.tencent.mobileqq.search.searchdetail.content.wxminapp.c.f284375a;
                            SearchDetailTabListViewModel searchDetailTabListViewModel9 = this.viewModel;
                            if (searchDetailTabListViewModel9 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel9 = null;
                            }
                            searchDetailTabListViewModel8.c2(com.tencent.mobileqq.search.searchdetail.content.wxminapp.c.b(cVar, searchDetailTabListViewModel9.getPageParam().getQuerySource(), null, 2, null));
                            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                            SearchDetailTabListViewModel searchDetailTabListViewModel10 = this.viewModel;
                            if (searchDetailTabListViewModel10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel10 = null;
                            }
                            String keyword = searchDetailTabListViewModel10.getPageParam().getKeyword();
                            SearchDetailTabListViewModel searchDetailTabListViewModel11 = this.viewModel;
                            if (searchDetailTabListViewModel11 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel11 = null;
                            }
                            int querySource = searchDetailTabListViewModel11.getPageParam().getQuerySource();
                            SearchDetailTabListViewModel searchDetailTabListViewModel12 = this.viewModel;
                            if (searchDetailTabListViewModel12 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel12 = null;
                            }
                            int pageMode = searchDetailTabListViewModel12.getPageParam().getPageMode();
                            RefreshType refreshType = RefreshType.TYPE_USER_INPUT_SEARCH;
                            SearchDetailTabListViewModel searchDetailTabListViewModel13 = this.viewModel;
                            if (searchDetailTabListViewModel13 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            } else {
                                searchDetailTabListViewModel = searchDetailTabListViewModel13;
                            }
                            simpleEventBus.dispatchEvent(new StartSearchEvent(keyword, pageMode, querySource, refreshType, "", "", searchDetailTabListViewModel.getParentType(), null, 128, null));
                            return;
                        }
                        return;
                    }
                    return;
                case -1617718368:
                    if (action.equals("MESSAGE_SHOW_SEARCH_FRAME")) {
                        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabListPart", 1, "MESSAGE_SHOW_SEARCH_FRAME");
                        return;
                    }
                    return;
                case 13893838:
                    if (action.equals("MESSAGE_UPDATETEXT")) {
                        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabListPart", 1, "MESSAGE_UPDATE_SEARCH_TEXT " + args);
                        View view3 = this.containerView;
                        if (view3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("containerView");
                            view3 = null;
                        }
                        view3.setVisibility(0);
                        if (args instanceof KeyWordChangeEvent) {
                            keyWordChangeEvent = (KeyWordChangeEvent) args;
                        } else {
                            keyWordChangeEvent = null;
                        }
                        if (keyWordChangeEvent != null) {
                            SearchDetailTabListViewModel searchDetailTabListViewModel14 = this.viewModel;
                            if (searchDetailTabListViewModel14 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel14 = null;
                            }
                            searchDetailTabListViewModel14.getPageParam().n(keyWordChangeEvent.getKeyword());
                            if (keyWordChangeEvent.getKeyWordFrom() == 22) {
                                SearchDetailTabListViewModel searchDetailTabListViewModel15 = this.viewModel;
                                if (searchDetailTabListViewModel15 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    searchDetailTabListViewModel15 = null;
                                }
                                searchDetailTabListViewModel15.getPageParam().o(SearchDetailFragment.Companion.PageMode.MODE_NORMAL_AI.getValue());
                                View view4 = this.rootView;
                                if (view4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                                    view4 = null;
                                }
                                SearchDetailTabListViewModel searchDetailTabListViewModel16 = this.viewModel;
                                if (searchDetailTabListViewModel16 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    searchDetailTabListViewModel16 = null;
                                }
                                VideoReport.setPageParams(view4, PictureConst.KEY_PAGE_MODE, Integer.valueOf(searchDetailTabListViewModel16.getPageParam().getPageMode()));
                            }
                            int N9 = N9(keyWordChangeEvent);
                            if (N9 > 0) {
                                SearchDetailTabListViewModel searchDetailTabListViewModel17 = this.viewModel;
                                if (searchDetailTabListViewModel17 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    searchDetailTabListViewModel17 = null;
                                }
                                searchDetailTabListViewModel17.getPageParam().p(N9);
                            }
                            if (keyWordChangeEvent.getSugTraceId().length() > 0) {
                                b16 = true;
                            } else {
                                b16 = false;
                            }
                            if (b16 != false) {
                                SearchDetailTabListViewModel searchDetailTabListViewModel18 = this.viewModel;
                                if (searchDetailTabListViewModel18 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    searchDetailTabListViewModel18 = null;
                                }
                                searchDetailTabListViewModel18.getPageParam().q(keyWordChangeEvent.getSugTraceId());
                            } else {
                                SearchDetailTabListViewModel searchDetailTabListViewModel19 = this.viewModel;
                                if (searchDetailTabListViewModel19 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    searchDetailTabListViewModel19 = null;
                                }
                                searchDetailTabListViewModel19.getPageParam().q("");
                            }
                            SearchDetailTabListViewModel searchDetailTabListViewModel20 = this.viewModel;
                            if (searchDetailTabListViewModel20 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel20 = null;
                            }
                            if (keyWordChangeEvent.getKeyWordFrom() == 5) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            searchDetailTabListViewModel20.b2(z16);
                            SearchDetailTabListViewModel searchDetailTabListViewModel21 = this.viewModel;
                            if (searchDetailTabListViewModel21 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel21 = null;
                            }
                            com.tencent.mobileqq.search.searchdetail.content.wxminapp.c cVar2 = com.tencent.mobileqq.search.searchdetail.content.wxminapp.c.f284375a;
                            SearchDetailTabListViewModel searchDetailTabListViewModel22 = this.viewModel;
                            if (searchDetailTabListViewModel22 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel22 = null;
                            }
                            searchDetailTabListViewModel21.c2(com.tencent.mobileqq.search.searchdetail.content.wxminapp.c.b(cVar2, searchDetailTabListViewModel22.getPageParam().getQuerySource(), null, 2, null));
                            KeyWordChangeEvent keyWordChangeEvent2 = (KeyWordChangeEvent) args;
                            isBlank = StringsKt__StringsJVMKt.isBlank(keyWordChangeEvent2.getSugWxSuggestionId());
                            if (!isBlank) {
                                SearchDetailTabListViewModel searchDetailTabListViewModel23 = this.viewModel;
                                if (searchDetailTabListViewModel23 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    searchDetailTabListViewModel23 = null;
                                }
                                searchDetailTabListViewModel23.e2(keyWordChangeEvent2.getSugWxSuggestionId());
                            }
                            SearchDetailTabListViewModel searchDetailTabListViewModel24 = this.viewModel;
                            if (searchDetailTabListViewModel24 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel24 = null;
                            }
                            String keyword2 = searchDetailTabListViewModel24.getPageParam().getKeyword();
                            SearchDetailTabListViewModel searchDetailTabListViewModel25 = this.viewModel;
                            if (searchDetailTabListViewModel25 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel25 = null;
                            }
                            int pageMode2 = searchDetailTabListViewModel25.getPageParam().getPageMode();
                            SearchDetailTabListViewModel searchDetailTabListViewModel26 = this.viewModel;
                            if (searchDetailTabListViewModel26 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel26 = null;
                            }
                            int querySource2 = searchDetailTabListViewModel26.getPageParam().getQuerySource();
                            RefreshType O9 = O9(keyWordChangeEvent.getKeyWordFrom());
                            SearchDetailTabListViewModel searchDetailTabListViewModel27 = this.viewModel;
                            if (searchDetailTabListViewModel27 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel27 = null;
                            }
                            String sugTraceId = searchDetailTabListViewModel27.getPageParam().getSugTraceId();
                            SearchDetailTabListViewModel searchDetailTabListViewModel28 = this.viewModel;
                            if (searchDetailTabListViewModel28 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                searchDetailTabListViewModel28 = null;
                            }
                            String wxPreSearchId = searchDetailTabListViewModel28.getWxPreSearchId();
                            SearchDetailTabListViewModel searchDetailTabListViewModel29 = this.viewModel;
                            if (searchDetailTabListViewModel29 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            } else {
                                searchDetailTabListViewModel2 = searchDetailTabListViewModel29;
                            }
                            StartSearchEvent startSearchEvent = new StartSearchEvent(keyword2, pageMode2, querySource2, O9, sugTraceId, wxPreSearchId, searchDetailTabListViewModel2.getParentType(), null, 128, null);
                            Activity activity = getActivity();
                            if (activity != null) {
                                i3 = activity.hashCode();
                            }
                            startSearchEvent.mHashCode = i3;
                            SimpleEventBus.getInstance().dispatchEvent(startSearchEvent);
                            return;
                        }
                        return;
                    }
                    return;
                case 1272129915:
                    if (action.equals("MESSAGE_HIDE_SEARCH_FRAME")) {
                        Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabListPart", 1, "MESSAGE_HIDE_SEARCH_FRAME");
                        View view5 = this.containerView;
                        if (view5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("containerView");
                        } else {
                            view = view5;
                        }
                        view.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.rootView = rootView;
        View findViewById = rootView.findViewById(R.id.b9w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content_layout)");
        this.containerView = findViewById;
        View findViewById2 = rootView.findViewById(R.id.f81254do);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.search_view_pager)");
        this.viewPager = (ViewPager2) findViewById2;
        ViewModel viewModel = getViewModel(SearchDetailTabListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(SearchDetai\u2026istViewModel::class.java)");
        SearchDetailTabListViewModel searchDetailTabListViewModel = (SearchDetailTabListViewModel) viewModel;
        this.viewModel = searchDetailTabListViewModel;
        SearchDetailTabListViewModel searchDetailTabListViewModel2 = null;
        if (searchDetailTabListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel = null;
        }
        searchDetailTabListViewModel.init(getHostFragment().getArguments());
        SearchDetailTabListViewModel searchDetailTabListViewModel3 = this.viewModel;
        if (searchDetailTabListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            searchDetailTabListViewModel3 = null;
        }
        if (searchDetailTabListViewModel3.getPageParam().getTabMask() != 1) {
            SearchDetailTabListViewModel searchDetailTabListViewModel4 = this.viewModel;
            if (searchDetailTabListViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                searchDetailTabListViewModel2 = searchDetailTabListViewModel4;
            }
            this.curTabInfo = new SearchDetailTabListViewModel.TabInfo("", searchDetailTabListViewModel2.getPageParam().getTabMask());
        }
        R9(rootView);
        U9();
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        String str;
        if (event instanceof ChangeTabEvent) {
            SearchDetailTabListViewModel searchDetailTabListViewModel = this.viewModel;
            SearchDetailTabListViewModel searchDetailTabListViewModel2 = null;
            if (searchDetailTabListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                searchDetailTabListViewModel = null;
            }
            searchDetailTabListViewModel.c2(10);
            ChangeTabEvent changeTabEvent = (ChangeTabEvent) event;
            Map<String, String> extensionMap = changeTabEvent.getExtensionMap();
            if (extensionMap == null || (str = extensionMap.get("wx_mini_app_search_id")) == null) {
                str = "";
            }
            SearchDetailTabListViewModel searchDetailTabListViewModel3 = this.viewModel;
            if (searchDetailTabListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                searchDetailTabListViewModel2 = searchDetailTabListViewModel3;
            }
            searchDetailTabListViewModel2.e2(str);
            M9(changeTabEvent.getTabInfo());
            return;
        }
        if (event instanceof ModifyCorrectionWordEvent) {
            broadcastMessage("MESSAGE_UPDATETEXT", new KeyWordChangeEvent(((ModifyCorrectionWordEvent) event).getChangedKeyword(), 4, null, null, 12, null));
        } else if (event instanceof CancelCorrectionEvent) {
            broadcastMessage("MESSAGE_UPDATETEXT", new KeyWordChangeEvent(((CancelCorrectionEvent) event).getOriginKeyword(), 5, null, null, 12, null));
        } else if (event instanceof SearchWithNewQueryEvent) {
            broadcastMessage("MESSAGE_UPDATETEXT", new KeyWordChangeEvent(((SearchWithNewQueryEvent) event).getChangedKeyword(), 6, null, null, 12, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(int i3) {
    }
}
