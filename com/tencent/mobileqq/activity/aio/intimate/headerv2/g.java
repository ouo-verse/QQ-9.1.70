package com.tencent.mobileqq.activity.aio.intimate.headerv2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\t\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u00020\b2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fH\u0016R&\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0013j\b\u0012\u0004\u0012\u00020\u0004`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/g;", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher$d;", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/g$a;", "", "", "data", "", "isFriendIntimateType", "", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "getItemCount", "holder", "position", "j0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mData", BdhLogUtil.LogTag.Tag_Conn, "Z", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g extends DownToUpViewSwitcher.d<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFriendIntimateType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<CharSequence> mData = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/g$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "tvTipsView", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/g;Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView tvTipsView;
        final /* synthetic */ g F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull g gVar, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.F = gVar;
            View findViewById = this.itemView.findViewById(R.id.xqf);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026ntimate_header_tips_view)");
            this.tvTipsView = (TextView) findViewById;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getTvTipsView() {
            return this.tvTipsView;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        ColorStateList colorStateList;
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getTvTipsView().setText(this.mData.get(position));
        Resources resources = holder.getTvTipsView().getResources();
        Context context = holder.getTvTipsView().getContext();
        if (context == null) {
            return;
        }
        if (this.isFriendIntimateType) {
            colorStateList = resources.getColorStateList(R.color.qui_common_text_allwhite_primary, context.getTheme());
        } else {
            colorStateList = resources.getColorStateList(R.color.qui_common_text_secondary, context.getTheme());
        }
        Intrinsics.checkNotNullExpressionValue(colorStateList, "if (isFriendIntimateType\u2026 context.theme)\n        }");
        holder.getTvTipsView().setTextColor(colorStateList);
    }

    @Override // com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher.d
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a i0(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dup, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(this, view);
    }

    public final void l0(@Nullable List<? extends CharSequence> data, boolean isFriendIntimateType) {
        if (data != null) {
            List<? extends CharSequence> list = data;
            if (!(!list.isEmpty())) {
                data = null;
            }
            if (data != null) {
                this.mData.clear();
                this.mData.addAll(list);
                this.isFriendIntimateType = isFriendIntimateType;
                notifyDataSetChanged();
            }
        }
    }
}
