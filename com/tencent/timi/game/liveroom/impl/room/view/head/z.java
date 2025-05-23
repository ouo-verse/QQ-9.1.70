package com.tencent.timi.game.liveroom.impl.room.view.head;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002+,B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0016\u0010\u0018\u001a\u00020\n2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR*\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001fj\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001` 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/z;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/z$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "holder", "position", "j0", "getItemViewType", "Landroid/view/View$OnClickListener;", "itemClickListener", "m0", "getItemCount", "", "Landroid/text/SpannableStringBuilder;", "data", "setData", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "rankDataList", "D", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroid/view/View$OnClickListener;", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class z extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ArrayList<SpannableStringBuilder> rankDataList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener itemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/z$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "setUserCountText", "(Landroid/widget/TextView;)V", "userCountText", "", UserInfo.SEX_FEMALE, "I", "l", "()I", "type", "Landroid/view/View;", "itemView", "viewType", "<init>", "(Landroid/view/View;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private TextView userCountText;

        /* renamed from: F, reason: from kotlin metadata */
        private final int type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView, int i3) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.userCountText = (TextView) itemView.findViewById(R.id.f114896uk);
            this.type = i3;
        }

        /* renamed from: l, reason: from getter */
        public final int getType() {
            return this.type;
        }

        @Nullable
        /* renamed from: m, reason: from getter */
        public final TextView getUserCountText() {
            return this.userCountText;
        }
    }

    public z(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(z this$0, View view) {
        View.OnClickListener onClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (uk4.a.a() && (onClickListener = this$0.itemClickListener) != null) {
            Intrinsics.checkNotNull(onClickListener);
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<SpannableStringBuilder> arrayList = this.rankDataList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position != 1) {
            return 1;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        SpannableStringBuilder spannableStringBuilder;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ArrayList<SpannableStringBuilder> arrayList = this.rankDataList;
        if (arrayList != null && (spannableStringBuilder = arrayList.get(position)) != null && holder.getType() == 1) {
            TextView userCountText = holder.getUserCountText();
            if (userCountText != null) {
                userCountText.setText(spannableStringBuilder);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    z.k0(z.this, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View inflate;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            inflate = LayoutInflater.from(this.context).inflate(R.layout.hvb, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "{\n            LayoutInfl\u2026 parent, false)\n        }");
        } else {
            inflate = LayoutInflater.from(this.context).inflate(R.layout.hvc, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "{\n            LayoutInfl\u2026 parent, false)\n        }");
        }
        return new b(inflate, viewType);
    }

    public final void m0(@NotNull View.OnClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    public final void setData(@Nullable List<? extends SpannableStringBuilder> data) {
        ArrayList<SpannableStringBuilder> arrayList = new ArrayList<>();
        this.rankDataList = arrayList;
        if (data != null) {
            arrayList.addAll(data);
        }
        notifyDataSetChanged();
    }
}
