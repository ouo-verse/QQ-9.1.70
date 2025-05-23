package com.tencent.mobileqq.search.searchdetail.content.wxminapp.moredetail;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.SearchDetailMinGameViewModel;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.l;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchMiniAppConditonFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pp2.c;
import pp2.d;
import tl.h;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/wxminapp/moredetail/WXMinGameFilterPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "updateUI", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/SearchDetailMinGameViewModel;", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/SearchDetailMinGameViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "viewContainer", "Lpp2/c;", h.F, "Lpp2/c;", "filterTagsAdapter", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/SearchDetailMinGameViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "i", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class WXMinGameFilterPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SearchDetailMinGameViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView viewContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c filterTagsAdapter;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/wxminapp/moredetail/WXMinGameFilterPart$b", "Lpp2/c$d;", "", "position", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMiniAppConditonFilter;", "filter", "", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements c.d {
        b() {
        }

        @Override // pp2.c.d
        public void a(int position, @NotNull SearchMiniAppConditonFilter filter) {
            SearchDetailTabListViewModel.TabInfo tabInfo;
            Intrinsics.checkNotNullParameter(filter, "filter");
            if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.WXMinGameFilterPart", 500L)) {
                SearchDetailMinGameViewModel searchDetailMinGameViewModel = WXMinGameFilterPart.this.viewModel;
                Activity activity = WXMinGameFilterPart.this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                searchDetailMinGameViewModel.Y2(activity, filter);
                return;
            }
            Logger logger = Logger.f235387a;
            WXMinGameFilterPart wXMinGameFilterPart = WXMinGameFilterPart.this;
            Logger.a d16 = logger.d();
            SearchDetailTabContentFragment.PageData pageData = wXMinGameFilterPart.viewModel.getPageData();
            if (pageData != null) {
                tabInfo = pageData.getTabInfo();
            } else {
                tabInfo = null;
            }
            d16.i("QQSearch.NetDetail.WXMinGameFilterPart", 1, "tabinfo=" + tabInfo + " fast click!");
        }
    }

    public WXMinGameFilterPart(@NotNull SearchDetailMinGameViewModel viewModel, @NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
        this.filterTagsAdapter = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUI() {
        List<SearchMiniAppConditonFilter> W2 = this.viewModel.W2();
        Logger.f235387a.d().i("QQSearch.NetDetail.WXMinGameFilterPart", 1, "updateUI filters:" + W2);
        if (W2.isEmpty()) {
            RecyclerView recyclerView = this.viewContainer;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
                return;
            }
            return;
        }
        RecyclerView recyclerView2 = this.viewContainer;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        this.filterTagsAdapter.m0(W2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.viewContainer = (RecyclerView) rootView.findViewById(R.id.f80904cq);
        MutableLiveData<String> r26 = this.viewModel.r2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.moredetail.WXMinGameFilterPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Logger logger = Logger.f235387a;
                WXMinGameFilterPart wXMinGameFilterPart = WXMinGameFilterPart.this;
                Logger.a d16 = logger.d();
                SearchDetailTabContentFragment.PageData pageData = wXMinGameFilterPart.viewModel.getPageData();
                d16.d("QQSearch.NetDetail.WXMinGameFilterPart", 1, "tabinfo=" + (pageData != null ? pageData.getTabInfo() : null) + " state=" + str + " refresh filter");
                WXMinGameFilterPart.this.updateUI();
            }
        };
        r26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.moredetail.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WXMinGameFilterPart.B9(Function1.this, obj);
            }
        });
        RecyclerView recyclerView = this.viewContainer;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        this.filterTagsAdapter.n0(new b());
        RecyclerView recyclerView2 = this.viewContainer;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
            recyclerView2.setAdapter(this.filterTagsAdapter);
            recyclerView2.addItemDecoration(new d(l.d(8)));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        super.onPartPause(activity);
        Logger.a d16 = Logger.f235387a.d();
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        if (pageData != null) {
            tabInfo = pageData.getTabInfo();
        } else {
            tabInfo = null;
        }
        d16.d("QQSearch.NetDetail.WXMinGameFilterPart", 1, "onPartPause=" + tabInfo);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        super.onPartResume(activity);
        Logger.a d16 = Logger.f235387a.d();
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        if (pageData != null) {
            tabInfo = pageData.getTabInfo();
        } else {
            tabInfo = null;
        }
        d16.d("QQSearch.NetDetail.WXMinGameFilterPart", 1, "onPartResume=" + tabInfo);
    }
}
