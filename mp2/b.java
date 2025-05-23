package mp2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.biz.richframework.preload.recyclerview.RFWCountLoadMoreStrategy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.content.viewmodel.k;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0003!\"#B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bR\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lmp2/b;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "p1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "", "isLoading", "hasMore", "", "setLoadState", "onLoadMoreStart", "onLoadMoreEnd", "position", "getItemViewType", "hide", "show", "j0", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "i0", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "viewModel", "Lmp2/b$b;", BdhLogUtil.LogTag.Tag_Conn, "Lmp2/b$b;", "mViewHolder", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;)V", "D", "a", "b", "c", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends RFWAbsLoadMoreAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private C10799b mViewHolder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lmp2/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ProgressBar;", "E", "Landroid/widget/ProgressBar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ProgressBar;", "mProgressbar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "mProgressInfo", "Landroid/view/View;", "v", "<init>", "(Landroid/view/View;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mp2.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C10799b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ProgressBar mProgressbar;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView mProgressInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10799b(@NotNull View v3) {
            super(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            View findViewById = v3.findViewById(R.id.lz7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(com.tence\u2026uild.aio.R.id.pb_loading)");
            this.mProgressbar = (ProgressBar) findViewById;
            View findViewById2 = v3.findViewById(R.id.kbr);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById(com.tence\u2026bileqq.qqui.R.id.tv_tips)");
            this.mProgressInfo = (TextView) findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getMProgressInfo() {
            return this.mProgressInfo;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ProgressBar getMProgressbar() {
            return this.mProgressbar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"Lmp2/b$c;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWCountLoadMoreStrategy;", "", "getLinearPreloadCount", "<init>", "()V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends RFWCountLoadMoreStrategy {
        @Override // com.tencent.biz.richframework.preload.recyclerview.RFWCountLoadMoreStrategy
        /* renamed from: getLinearPreloadCount */
        protected int getPreloadCount() {
            return 15;
        }
    }

    public b(@NotNull k viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.mLoadMoreStrategy = new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD;
    }

    public final void hide() {
        View view;
        View view2;
        C10799b c10799b = this.mViewHolder;
        boolean z16 = false;
        if (c10799b != null && (view2 = c10799b.itemView) != null && view2.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            C10799b c10799b2 = this.mViewHolder;
            SearchDetailTabListViewModel.TabInfo tabInfo = null;
            if (c10799b2 != null) {
                view = c10799b2.itemView;
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(8);
            }
            Logger.a d16 = Logger.f235387a.d();
            SearchDetailTabContentFragment.PageData pageData = getViewModel().getPageData();
            if (pageData != null) {
                tabInfo = pageData.getTabInfo();
            }
            d16.i("QQSearch.NetDetail.NetSearchLoadMoreAdapter", 1, tabInfo + " hide");
        }
    }

    @NotNull
    /* renamed from: i0, reason: from getter */
    public final k getViewModel() {
        return this.viewModel;
    }

    public final void j0() {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        startLoadMore(0, Integer.MAX_VALUE, 1);
        Logger.a d16 = Logger.f235387a.d();
        SearchDetailTabContentFragment.PageData pageData = getViewModel().getPageData();
        if (pageData != null) {
            tabInfo = pageData.getTabInfo();
        } else {
            tabInfo = null;
        }
        d16.i("QQSearch.NetDetail.NetSearchLoadMoreAdapter", 1, tabInfo + " startLoadMoreByManu");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int p16) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f169066hn3, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026  false\n                )");
        C10799b c10799b = new C10799b(inflate);
        this.mViewHolder = c10799b;
        c10799b.itemView.setVisibility(8);
        return c10799b;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        ProgressBar progressBar;
        TextView mProgressInfo;
        TextView mProgressInfo2;
        C10799b c10799b = this.mViewHolder;
        SearchDetailTabListViewModel.TabInfo tabInfo = null;
        if (c10799b != null) {
            progressBar = c10799b.getMProgressbar();
        } else {
            progressBar = null;
        }
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (hasMore) {
            C10799b c10799b2 = this.mViewHolder;
            if (c10799b2 != null && (mProgressInfo2 = c10799b2.getMProgressInfo()) != null) {
                mProgressInfo2.setText(R.string.f213485qb);
                return;
            }
            return;
        }
        C10799b c10799b3 = this.mViewHolder;
        if (c10799b3 != null && (mProgressInfo = c10799b3.getMProgressInfo()) != null) {
            mProgressInfo.setText(R.string.f213505qd);
        }
        Logger.a d16 = Logger.f235387a.d();
        SearchDetailTabContentFragment.PageData pageData = getViewModel().getPageData();
        if (pageData != null) {
            tabInfo = pageData.getTabInfo();
        }
        d16.i("QQSearch.NetDetail.NetSearchLoadMoreAdapter", 1, "setLoadState " + tabInfo + " hasmore=" + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        ProgressBar progressBar;
        TextView mProgressInfo;
        C10799b c10799b = this.mViewHolder;
        if (c10799b != null) {
            progressBar = c10799b.getMProgressbar();
        } else {
            progressBar = null;
        }
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        C10799b c10799b2 = this.mViewHolder;
        if (c10799b2 != null && (mProgressInfo = c10799b2.getMProgressInfo()) != null) {
            mProgressInfo.setText(R.string.f213495qc);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter
    public void setLoadState(boolean isLoading, boolean hasMore) {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        super.setLoadState(isLoading, hasMore);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            SearchDetailTabContentFragment.PageData pageData = getViewModel().getPageData();
            if (pageData != null) {
                tabInfo = pageData.getTabInfo();
            } else {
                tabInfo = null;
            }
            Log.d("QQSearch.NetDetail.NetSearchLoadMoreAdapter", "setLoadState " + tabInfo + " isLoading=" + isLoading + " hasmore=" + hasMore);
        }
        if (!hasMore) {
            onLoadMoreEnd(false);
        }
    }

    public final void show() {
        boolean z16;
        View view;
        View view2;
        C10799b c10799b = this.mViewHolder;
        if (c10799b != null && (view2 = c10799b.itemView) != null && view2.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            C10799b c10799b2 = this.mViewHolder;
            SearchDetailTabListViewModel.TabInfo tabInfo = null;
            if (c10799b2 != null) {
                view = c10799b2.itemView;
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(0);
            }
            Logger.a d16 = Logger.f235387a.d();
            SearchDetailTabContentFragment.PageData pageData = getViewModel().getPageData();
            if (pageData != null) {
                tabInfo = pageData.getTabInfo();
            }
            d16.i("QQSearch.NetDetail.NetSearchLoadMoreAdapter", 1, tabInfo + " show");
        }
    }
}
