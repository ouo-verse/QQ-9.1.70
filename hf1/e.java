package hf1;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.base.recyclerview.loadmore.LoadMoreStatus;
import com.tencent.mobileqq.guild.base.recyclerview.viewholder.BaseViewHolder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010!\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0002J\u0012\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0006H\u0007J\u0006\u0010\u0018\u001a\u00020\u0002J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u000f\u0010\u001c\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020(8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R$\u0010/\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b/\u00100R\"\u00107\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010<\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010&\u001a\u0004\b9\u00100\"\u0004\b:\u0010;R\"\u0010>\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010&\u001a\u0004\b>\u00100\"\u0004\b?\u0010;R\"\u0010@\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010&\u001a\u0004\b@\u00100\"\u0004\bA\u0010;R*\u0010G\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010\u0014R*\u0010I\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00068\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010&\u001a\u0004\bI\u00100\"\u0004\bJ\u0010;R\u0011\u0010K\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010E\u00a8\u0006N"}, d2 = {"Lhf1/e;", "", "", DomainData.DOMAIN_NAME, "Landroidx/recyclerview/widget/LinearLayoutManager;", "llm", "", "p", "", "numbers", "", "l", "Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "viewHolder", "B", "(Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;)V", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "position", "e", "(I)V", "f", "gone", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lgf1/f;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "()V", "Lcom/tencent/mobileqq/guild/base/recyclerview/adapter/e;", "a", "Lcom/tencent/mobileqq/guild/base/recyclerview/adapter/e;", "baseQuickAdapter", "b", "Lgf1/f;", "mLoadMoreListener", "c", "Z", "mNextLoadEnable", "Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/LoadMoreStatus;", "<set-?>", "d", "Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/LoadMoreStatus;", "i", "()Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/LoadMoreStatus;", "loadMoreStatus", "isLoadEndMoreGone", "()Z", "Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/a;", "Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/a;", "j", "()Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/a;", "y", "(Lcom/tencent/mobileqq/guild/base/recyclerview/loadmore/a;)V", "loadMoreView", "g", "getEnableLoadMoreEndClick", "setEnableLoadMoreEndClick", "(Z)V", "enableLoadMoreEndClick", h.F, "isAutoLoadMore", "w", "isEnableLoadMoreIfNotFullPage", "setEnableLoadMoreIfNotFullPage", "value", "I", "getPreLoadNumber", "()I", "setPreLoadNumber", "preLoadNumber", "k", "isEnableLoadMore", HippyTKDListViewAdapter.X, "loadMoreViewPosition", "<init>", "(Lcom/tencent/mobileqq/guild/base/recyclerview/adapter/e;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.base.recyclerview.adapter.e<?, ?> baseQuickAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private gf1.f mLoadMoreListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mNextLoadEnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LoadMoreStatus loadMoreStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadEndMoreGone;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.base.recyclerview.loadmore.a loadMoreView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean enableLoadMoreEndClick;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isAutoLoadMore;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableLoadMoreIfNotFullPage;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int preLoadNumber;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableLoadMore;

    public e(@NotNull com.tencent.mobileqq.guild.base.recyclerview.adapter.e<?, ?> baseQuickAdapter) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter;
        this.mNextLoadEnable = true;
        this.loadMoreStatus = LoadMoreStatus.Complete;
        this.loadMoreView = g.a();
        this.isAutoLoadMore = true;
        this.isEnableLoadMoreIfNotFullPage = true;
        this.preLoadNumber = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LoadMoreStatus loadMoreStatus = this$0.loadMoreStatus;
        if (loadMoreStatus == LoadMoreStatus.Fail) {
            this$0.u();
        } else if (loadMoreStatus == LoadMoreStatus.Complete) {
            this$0.u();
        } else if (this$0.enableLoadMoreEndClick && loadMoreStatus == LoadMoreStatus.End) {
            this$0.u();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e this$0, RecyclerView.LayoutManager manager) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(manager, "$manager");
        if (this$0.p((LinearLayoutManager) manager)) {
            this$0.mNextLoadEnable = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(RecyclerView.LayoutManager manager, e this$0) {
        Intrinsics.checkNotNullParameter(manager, "$manager");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) manager;
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(iArr);
        if (this$0.l(iArr) + 1 != this$0.baseQuickAdapter.getItemCount()) {
            this$0.mNextLoadEnable = true;
        }
    }

    private final int l(int[] numbers) {
        boolean z16;
        int i3 = -1;
        if (numbers != null) {
            if (numbers.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (int i16 : numbers) {
                    if (i16 > i3) {
                        i3 = i16;
                    }
                }
            }
        }
        return i3;
    }

    private final void n() {
        this.loadMoreStatus = LoadMoreStatus.Loading;
        RecyclerView recyclerViewOrNull = this.baseQuickAdapter.getRecyclerViewOrNull();
        if (recyclerViewOrNull != null) {
            recyclerViewOrNull.post(new Runnable() { // from class: hf1.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.o(e.this);
                }
            });
            return;
        }
        gf1.f fVar = this.mLoadMoreListener;
        if (fVar != null) {
            fVar.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gf1.f fVar = this$0.mLoadMoreListener;
        if (fVar != null) {
            fVar.s();
        }
    }

    private final boolean p(LinearLayoutManager llm) {
        if (llm.findLastCompletelyVisibleItemPosition() + 1 != this.baseQuickAdapter.getItemCount() || llm.findFirstCompletelyVisibleItemPosition() != 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void t(e eVar, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            eVar.s(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreEnd");
    }

    public final void B(@NotNull BaseViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: hf1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.A(e.this, view);
            }
        });
    }

    public final void e(int position) {
        LoadMoreStatus loadMoreStatus;
        if (!this.isAutoLoadMore || !m() || position < this.baseQuickAdapter.getItemCount() - this.preLoadNumber || (loadMoreStatus = this.loadMoreStatus) != LoadMoreStatus.Complete || loadMoreStatus == LoadMoreStatus.Loading || !this.mNextLoadEnable) {
            return;
        }
        n();
    }

    public final void f() {
        final RecyclerView.LayoutManager layoutManager;
        if (this.isEnableLoadMoreIfNotFullPage) {
            return;
        }
        this.mNextLoadEnable = false;
        RecyclerView recyclerViewOrNull = this.baseQuickAdapter.getRecyclerViewOrNull();
        if (recyclerViewOrNull == null || (layoutManager = recyclerViewOrNull.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            recyclerViewOrNull.postDelayed(new Runnable() { // from class: hf1.a
                @Override // java.lang.Runnable
                public final void run() {
                    e.g(e.this, layoutManager);
                }
            }, 50L);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            recyclerViewOrNull.postDelayed(new Runnable() { // from class: hf1.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.h(RecyclerView.LayoutManager.this, this);
                }
            }, 50L);
        }
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final LoadMoreStatus getLoadMoreStatus() {
        return this.loadMoreStatus;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final com.tencent.mobileqq.guild.base.recyclerview.loadmore.a getLoadMoreView() {
        return this.loadMoreView;
    }

    public final int k() {
        if (this.baseQuickAdapter.E0()) {
            return -1;
        }
        com.tencent.mobileqq.guild.base.recyclerview.adapter.e<?, ?> eVar = this.baseQuickAdapter;
        return eVar.u0() + eVar.getData().size() + eVar.s0();
    }

    public final boolean m() {
        if (this.mLoadMoreListener == null || !this.isEnableLoadMore) {
            return false;
        }
        if (this.loadMoreStatus == LoadMoreStatus.End && this.isLoadEndMoreGone) {
            return false;
        }
        return !this.baseQuickAdapter.getData().isEmpty();
    }

    public final void q() {
        if (!m()) {
            return;
        }
        this.loadMoreStatus = LoadMoreStatus.Complete;
        this.baseQuickAdapter.notifyDataSetChanged();
        f();
    }

    @JvmOverloads
    public final void r() {
        t(this, false, 1, null);
    }

    @JvmOverloads
    public final void s(boolean gone) {
        if (!m()) {
            return;
        }
        this.isLoadEndMoreGone = gone;
        this.loadMoreStatus = LoadMoreStatus.End;
        if (gone) {
            this.baseQuickAdapter.notifyItemRemoved(k());
        } else {
            this.baseQuickAdapter.notifyItemChanged(k());
        }
    }

    public final void u() {
        LoadMoreStatus loadMoreStatus = this.loadMoreStatus;
        LoadMoreStatus loadMoreStatus2 = LoadMoreStatus.Loading;
        if (loadMoreStatus == loadMoreStatus2) {
            return;
        }
        this.loadMoreStatus = loadMoreStatus2;
        this.baseQuickAdapter.notifyItemChanged(k());
        n();
    }

    public final void v() {
        if (this.mLoadMoreListener != null) {
            x(true);
            this.loadMoreStatus = LoadMoreStatus.Complete;
        }
    }

    public final void w(boolean z16) {
        this.isAutoLoadMore = z16;
    }

    public final void x(boolean z16) {
        boolean m3 = m();
        this.isEnableLoadMore = z16;
        boolean m16 = m();
        if (m3) {
            if (!m16) {
                this.baseQuickAdapter.notifyItemRemoved(k());
            }
        } else if (m16) {
            this.loadMoreStatus = LoadMoreStatus.Complete;
            this.baseQuickAdapter.notifyItemInserted(k());
        }
    }

    public final void y(@NotNull com.tencent.mobileqq.guild.base.recyclerview.loadmore.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.loadMoreView = aVar;
    }

    public void z(@Nullable gf1.f listener) {
        this.mLoadMoreListener = listener;
        x(true);
    }
}
