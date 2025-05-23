package com.tencent.mobileqq.guild.quicksearch.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.quicksearch.fragment.QuickSearchFeedFragment;
import com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedDateFilterPart;
import com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedEmptyPart;
import com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedFilterBarPart;
import com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedListPart;
import com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedLoadingPart;
import com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedModuleFilterPart;
import com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedSortFilterPart;
import com.tencent.mobileqq.guild.quicksearch.searchbox.SearchBarExtData;
import com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchFilterViewModel;
import com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/fragment/QuickSearchFeedFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initViewModel", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "childView", "rh", "initReport", "qh", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchViewModel;", "pageViewModel", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "D", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "viewModel", "E", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchFeedFragment extends QPublicBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private QuickSearchViewModel pageViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private QuickSearchFilterViewModel viewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private View rootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/fragment/QuickSearchFeedFragment$a;", "", "", "guildId", "Lcom/tencent/mobileqq/guild/quicksearch/fragment/QuickSearchFeedFragment;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.fragment.QuickSearchFeedFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QuickSearchFeedFragment a(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            QuickSearchFeedFragment quickSearchFeedFragment = new QuickSearchFeedFragment();
            Bundle bundle = new Bundle();
            bundle.putString("extra_guild_id", guildId);
            quickSearchFeedFragment.setArguments(bundle);
            return quickSearchFeedFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f231612a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f231613b;

        public b(ViewModelStoreOwner viewModelStoreOwner, String str) {
            this.f231612a = viewModelStoreOwner;
            this.f231613b = str;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new QuickSearchViewModel(this.f231613b), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    private final void initViewModel() {
        String str;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("extra_guild_id")) == null) {
            str = "";
        }
        c.Companion companion = c.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ViewModel viewModel = new ViewModelProvider(requireActivity, new b(requireActivity, str)).get(QuickSearchViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.pageViewModel = (QuickSearchViewModel) viewModel;
        QuickSearchViewModel quickSearchViewModel = this.pageViewModel;
        if (quickSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            quickSearchViewModel = null;
        }
        this.viewModel = new QuickSearchFilterViewModel(quickSearchViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(QuickSearchFeedFragment this$0, View childView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(childView, "$childView");
        this$0.rh(childView);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[7];
        QuickSearchViewModel quickSearchViewModel = this.pageViewModel;
        QuickSearchFilterViewModel quickSearchFilterViewModel = null;
        if (quickSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            quickSearchViewModel = null;
        }
        partArr[0] = new QuickSearchFeedLoadingPart(quickSearchViewModel);
        QuickSearchViewModel quickSearchViewModel2 = this.pageViewModel;
        if (quickSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            quickSearchViewModel2 = null;
        }
        partArr[1] = new QuickSearchFeedEmptyPart(quickSearchViewModel2);
        QuickSearchViewModel quickSearchViewModel3 = this.pageViewModel;
        if (quickSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            quickSearchViewModel3 = null;
        }
        partArr[2] = new QuickSearchFeedListPart(quickSearchViewModel3);
        QuickSearchViewModel quickSearchViewModel4 = this.pageViewModel;
        if (quickSearchViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            quickSearchViewModel4 = null;
        }
        partArr[3] = new QuickSearchFeedFilterBarPart(quickSearchViewModel4);
        QuickSearchFilterViewModel quickSearchFilterViewModel2 = this.viewModel;
        if (quickSearchFilterViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            quickSearchFilterViewModel2 = null;
        }
        partArr[4] = new QuickSearchFeedSortFilterPart(quickSearchFilterViewModel2);
        QuickSearchFilterViewModel quickSearchFilterViewModel3 = this.viewModel;
        if (quickSearchFilterViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            quickSearchFilterViewModel3 = null;
        }
        partArr[5] = new QuickSearchFeedModuleFilterPart(quickSearchFilterViewModel3);
        QuickSearchFilterViewModel quickSearchFilterViewModel4 = this.viewModel;
        if (quickSearchFilterViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            quickSearchFilterViewModel = quickSearchFilterViewModel4;
        }
        partArr[6] = new QuickSearchFeedDateFilterPart(quickSearchFilterViewModel);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    public final void initReport() {
        String str;
        Map<String, Object> mutableMapOf;
        String str2;
        View view = this.rootView;
        QuickSearchViewModel quickSearchViewModel = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.setPageId(view, "pg_sgrp_search_forum");
        QuickSearchViewModel quickSearchViewModel2 = this.pageViewModel;
        if (quickSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            quickSearchViewModel2 = null;
        }
        SearchBarExtData searchExtInfo = quickSearchViewModel2.getSearchParam().getSearchExtInfo();
        Pair[] pairArr = new Pair[2];
        QuickSearchViewModel quickSearchViewModel3 = this.pageViewModel;
        if (quickSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
            quickSearchViewModel3 = null;
        }
        pairArr[0] = TuplesKt.to(SearchGuildDaTongApiImpl.GUILD_SEARCH_ITEM_RECALL_QUERY, quickSearchViewModel3.getSearchParam().getKeyWord());
        if (searchExtInfo instanceof SearchBarExtData.GuildMemberExtData) {
            str = "1";
        } else {
            str = "0";
        }
        pairArr[1] = TuplesKt.to("sgrp_add_member_search", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (searchExtInfo instanceof SearchBarExtData.DateExtData) {
            str2 = ((SearchBarExtData.DateExtData) searchExtInfo).b();
        } else {
            str2 = "";
        }
        mutableMapOf.put("sgrp_search_date", str2);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        QuickSearchViewModel quickSearchViewModel4 = this.pageViewModel;
        if (quickSearchViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageViewModel");
        } else {
            quickSearchViewModel = quickSearchViewModel4;
        }
        iGuildDTReportApi.setGuildPageParams(view2, quickSearchViewModel.getGuildId(), mutableMapOf);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168154f34, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        this.rootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            inflate = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        initReport();
    }

    public final void qh() {
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.pageLogicDestroy(view);
        initReport();
    }

    public final void rh(@NotNull final View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        if (this.rootView != null && !isDetached()) {
            Logger.f235387a.d().i("QQGuildInSearchTag.QuickSearchFeedFragment", 1, "setLogicParent");
            View view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
            VideoReport.setLogicParent(childView, view);
            VideoReport.traversePage(childView);
            return;
        }
        Logger.f235387a.d().w("QQGuildInSearchTag.QuickSearchFeedFragment", 1, "setLogicParent invalid while rootView is not initialized");
        childView.post(new Runnable() { // from class: iw1.a
            @Override // java.lang.Runnable
            public final void run() {
                QuickSearchFeedFragment.sh(QuickSearchFeedFragment.this, childView);
            }
        });
    }
}
