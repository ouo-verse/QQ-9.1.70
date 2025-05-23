package com.tencent.mobileqq.wink.publish.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B?\u00126\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00060\u0015\u00a2\u0006\u0004\b\"\u0010#J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J$\u0010\u000b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016RG\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00060\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/adapter/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/publish/adapter/e;", "", "Lcooperation/qzone/model/LabelInfo;", "newSet", "", "l0", "", "positionStart", "itemCount", "m0", "position", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "j0", "getItemCount", "holder", "i0", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "tagInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function2;", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "onItemClick", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "labelInfoSet", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "D", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends RecyclerView.Adapter<e> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<LabelInfo> labelInfoSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<Integer, LabelInfo, Unit> onItemClick;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Function2<? super Integer, ? super LabelInfo, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.onItemClick = onItemClick;
        this.labelInfoSet = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.labelInfoSet.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull e holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.m(this.labelInfoSet.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public e onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.g5d, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026ag_item_viewholder, null)");
        return new e(inflate, this.onItemClick);
    }

    public final void k0(int position) {
        try {
            this.labelInfoSet.remove(position);
            notifyItemRemoved(position);
        } catch (Exception e16) {
            com.tencent.xaction.log.b.c("PublishRecommendTagAdapter", 1, "[remove] position=" + position + ", ", e16);
        }
    }

    public final void l0(@NotNull List<? extends LabelInfo> newSet) {
        Intrinsics.checkNotNullParameter(newSet, "newSet");
        this.labelInfoSet.clear();
        this.labelInfoSet.addAll(newSet);
        notifyDataSetChanged();
    }

    public final void m0(@NotNull List<? extends LabelInfo> newSet, int positionStart, int itemCount) {
        Intrinsics.checkNotNullParameter(newSet, "newSet");
        this.labelInfoSet.clear();
        this.labelInfoSet.addAll(newSet);
        notifyItemRangeInserted(positionStart, itemCount);
    }
}
