package com.tencent.mobileqq.search.searchdetail.tablist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.ag;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001#\u0018\u0000 )2\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0007J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u001b\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/tablist/b;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "info", "", "m0", "", "position", "Landroid/os/Bundle;", "parentBundle", "k0", "Landroidx/fragment/app/Fragment;", "l0", "", "list", "", "setItems", "", "getItems", "getItemCount", "itemId", "", "containsItem", "getItemId", "createFragment", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "parentFragment", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel;", "viewModel", "D", "Ljava/util/List;", "searchTabList", "com/tencent/mobileqq/search/searchdetail/tablist/b$b", "E", "Lcom/tencent/mobileqq/search/searchdetail/tablist/b$b;", "searchDetailContext", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel;)V", UserInfo.SEX_FEMALE, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends FragmentStateAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final SearchDetailTabListViewModel viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private List<SearchDetailTabListViewModel.TabInfo> searchTabList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final C8546b searchDetailContext;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment parentFragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/search/searchdetail/tablist/b$b", "Lcom/tencent/mobileqq/search/searchdetail/tablist/a;", "", "getKeyword", "getSugTraceId", "b", "", "d", "keyword", "", "a", "Lcom/tencent/mobileqq/search/tux/b;", "c", "getMiniAppSessionId", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.tablist.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8546b implements a {
        C8546b() {
        }

        @Override // com.tencent.mobileqq.search.searchdetail.tablist.a
        public void a(@NotNull String keyword) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Logger.f235387a.d().i("QQSearch.NetDetail.SearchDetailTabListAdapter", 1, "search succ " + ag.b(keyword, 0, 1, null));
            if (b.this.parentFragment instanceof SearchDetailFragment) {
                ((SearchDetailFragment) b.this.parentFragment).vh(keyword);
            }
        }

        @Override // com.tencent.mobileqq.search.searchdetail.tablist.a
        @NotNull
        public String b() {
            return b.this.viewModel.getPageParam().getWxSugSearchId();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.tablist.a
        @Nullable
        public com.tencent.mobileqq.search.tux.b c() {
            return b.this.viewModel.T1();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.tablist.a
        public boolean d() {
            return b.this.viewModel.getDisableCorrectionQuery();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.tablist.a
        @NotNull
        public String getKeyword() {
            return b.this.viewModel.getPageParam().getKeyword();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.tablist.a
        @NotNull
        public String getMiniAppSessionId() {
            return b.this.viewModel.O1();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.tablist.a
        @NotNull
        public String getSugTraceId() {
            return b.this.viewModel.getPageParam().getSugTraceId();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Fragment parentFragment, @NotNull SearchDetailTabListViewModel viewModel) {
        super(parentFragment);
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.parentFragment = parentFragment;
        this.viewModel = viewModel;
        this.searchTabList = new ArrayList();
        this.searchDetailContext = new C8546b();
    }

    private final Bundle k0(int position, Bundle parentBundle) {
        SearchDetailTabListViewModel.TabInfo tabInfo = this.searchTabList.get(position);
        Bundle bundle = new Bundle();
        SearchDetailFragment.Companion.NetSearchPageParam pageParam = this.viewModel.getPageParam();
        bundle.putString("keyword", pageParam.getKeyword());
        bundle.putString("hint", pageParam.getHint());
        bundle.putLong("tab_mask", pageParam.getTabMask());
        bundle.putInt(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, pageParam.getQuerySource());
        bundle.putInt("user_source", pageParam.getUserSource());
        bundle.putString("sessionId", pageParam.getSessionId());
        bundle.putLong("start_search_stamp", pageParam.getStartSearchTime());
        bundle.putString("func_payload", pageParam.getFunctionPayload());
        bundle.putInt("voice_ai_mode", pageParam.getPageMode());
        bundle.putString("wx_search_id", this.viewModel.getWxPreSearchId());
        bundle.putInt("wx_parent_type", this.viewModel.getParentType());
        bundle.putString("tabName", tabInfo.getTabName());
        bundle.putLong("tabMask", tabInfo.getTabMask());
        bundle.putBoolean("disableCorrect", this.viewModel.getDisableCorrectionQuery());
        bundle.putString("detailPageSessionId", this.viewModel.O1());
        return bundle;
    }

    private final Fragment l0() {
        SearchDetailTabContentFragment searchDetailTabContentFragment = new SearchDetailTabContentFragment();
        searchDetailTabContentFragment.xh(this.searchDetailContext);
        return searchDetailTabContentFragment;
    }

    private final long m0(SearchDetailTabListViewModel.TabInfo info) {
        return info.getTabMask();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long itemId) {
        Iterator<SearchDetailTabListViewModel.TabInfo> it = this.searchTabList.iterator();
        while (it.hasNext()) {
            if (itemId == m0(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        Bundle k06 = k0(position, this.parentFragment.getArguments());
        Fragment l06 = l0();
        l06.setArguments(k06);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.SearchDetailTabListAdapter", "createFragment fragment=" + l06.hashCode() + " arg=" + k06);
        }
        return l06;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.searchTabList.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        if (position >= this.searchTabList.size()) {
            return super.getItemId(position);
        }
        return m0(this.searchTabList.get(position));
    }

    @NotNull
    public final List<SearchDetailTabListViewModel.TabInfo> getItems() {
        return this.searchTabList;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setItems(@NotNull List<SearchDetailTabListViewModel.TabInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.searchTabList.clear();
        this.searchTabList.addAll(list);
        com.tencent.xaction.log.b.a("QQSearch.NetDetail.SearchDetailTabListAdapter", 1, "[pageView2] updateItems, size = " + this.searchTabList.size());
        notifyDataSetChanged();
    }
}
