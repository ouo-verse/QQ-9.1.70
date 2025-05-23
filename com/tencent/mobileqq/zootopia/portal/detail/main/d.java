package com.tencent.mobileqq.zootopia.portal.detail.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.view.ZootopiaUserView;
import com.tencent.sqshow.zootopia.data.ZootopiaMapComment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0014\u0010\u0018\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0014\u0010\u0019\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR$\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00160 j\b\u0012\u0004\u0012\u00020\u0016`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/main/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "getHeaderCount", "getFooterCount", "Landroid/view/ViewGroup;", "vg", "itemViewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemViewType", "Lcom/tencent/mobileqq/zootopia/portal/detail/main/ZootopiaDetailMainHeaderView;", "commentHeaderView", "k0", "Landroid/view/View;", "loadMoreFooter", "j0", "", "Lcom/tencent/sqshow/zootopia/data/l;", "list", "i0", "appendList", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "headerView", BdhLogUtil.LogTag.Tag_Conn, "footerView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "data", "<init>", "()V", "E", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String F = "ZootopiaDetailMainCommentAdapter";

    /* renamed from: C, reason: from kotlin metadata */
    private View footerView;

    /* renamed from: D, reason: from kotlin metadata */
    private final ArrayList<ZootopiaMapComment> data = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View headerView;

    private final int getFooterCount() {
        return this.footerView != null ? 1 : 0;
    }

    private final int getHeaderCount() {
        return this.headerView != null ? 1 : 0;
    }

    public final void appendList(List<ZootopiaMapComment> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (this.data.addAll(list)) {
            notifyItemRangeInserted((getItemCount() - getFooterCount()) - list.size(), list.size());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size() + getHeaderCount() + getFooterCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (getFooterCount() <= 0 || position < getItemCount() - getFooterCount()) {
            return position - getHeaderCount() < 0 ? 1 : 0;
        }
        return 2;
    }

    public final void i0(List<ZootopiaMapComment> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    public final void j0(View loadMoreFooter) {
        this.footerView = loadMoreFooter;
    }

    public final void k0(ZootopiaDetailMainHeaderView commentHeaderView) {
        this.headerView = commentHeaderView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int headerCount = position - getHeaderCount();
        ZootopiaMapComment zootopiaMapComment = (headerCount < 0 || headerCount >= this.data.size()) ? null : this.data.get(headerCount);
        if (zootopiaMapComment == null || !(holder instanceof a)) {
            return;
        }
        a aVar = (a) holder;
        TextView commentView = aVar.getCommentView();
        if (commentView != null) {
            commentView.setText(zootopiaMapComment.getComment());
        }
        ZootopiaUserView userView = aVar.getUserView();
        if (userView != null) {
            userView.a(zootopiaMapComment.getUserData());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup vg5, int itemViewType) {
        Intrinsics.checkNotNullParameter(vg5, "vg");
        if (itemViewType == 1) {
            View view = this.headerView;
            if (view == null) {
                view = new View(vg5.getContext());
            }
            return new c(view);
        }
        if (itemViewType != 2) {
            View itemView = LayoutInflater.from(vg5.getContext()).inflate(R.layout.f167423d82, vg5, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new a(itemView);
        }
        View view2 = this.footerView;
        if (view2 == null) {
            view2 = new View(vg5.getContext());
        }
        return new b(view2);
    }
}
