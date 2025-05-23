package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\n\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\rH\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/PreferentialItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "hasTriangleMark", "", "l0", "", "Lh23/c;", "dataList", "setDataList", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/vas/pay/page/PreferentialItemAdapter$a;", "k0", "getItemCount", "holder", "position", "onBindViewHolder", "Lh23/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lh23/b;", "payItemClick", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "D", "Z", "<init>", "(Lh23/b;)V", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class PreferentialItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private List<? extends h23.c> dataList;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasTriangleMark;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h23.b payItemClick;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/PreferentialItemAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/vas/pay/page/QVipPreferentialServiceInfoItem;", "view", "<init>", "(Lcom/tencent/mobileqq/vas/pay/page/QVipPreferentialServiceInfoItem;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull QVipPreferentialServiceInfoItem view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public PreferentialItemAdapter(@NotNull h23.b payItemClick) {
        Intrinsics.checkNotNullParameter(payItemClick, "payItemClick");
        this.payItemClick = payItemClick;
        this.hasTriangleMark = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends h23.c> list = this.dataList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = new QVipPreferentialServiceInfoItem(context);
        qVipPreferentialServiceInfoItem.setOnItemClickListener(new Function2<View, Integer, Unit>() { // from class: com.tencent.mobileqq.vas.pay.page.PreferentialItemAdapter$onCreateViewHolder$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                invoke(view, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view, int i3) {
                List list;
                h23.c cVar;
                h23.b bVar;
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                list = PreferentialItemAdapter.this.dataList;
                if (list == null || (cVar = (h23.c) list.get(i3)) == null) {
                    return;
                }
                bVar = PreferentialItemAdapter.this.payItemClick;
                bVar.b(cVar);
            }
        });
        return new a(qVipPreferentialServiceInfoItem);
    }

    public final void l0(boolean hasTriangleMark) {
        this.hasTriangleMark = hasTriangleMark;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        boolean z16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<? extends h23.c> list = this.dataList;
        if (list == null) {
            return;
        }
        h23.c cVar = list.get(position);
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.vas.pay.page.QVipPreferentialServiceInfoItem");
        QVipPreferentialServiceInfoItem qVipPreferentialServiceInfoItem = (QVipPreferentialServiceInfoItem) view;
        qVipPreferentialServiceInfoItem.setPosition(position);
        if (this.hasTriangleMark) {
            if (cVar.isSelected() && this.payItemClick.a()) {
                z16 = true;
            } else {
                z16 = false;
            }
            qVipPreferentialServiceInfoItem.setSmallTriangleMarkVisible(z16);
        }
        qVipPreferentialServiceInfoItem.setRedFlag(cVar.b());
        qVipPreferentialServiceInfoItem.setOriginalPrice(cVar.getOriginalPrice());
        qVipPreferentialServiceInfoItem.setInfoTitle(cVar.a(), cVar.isSelected());
        qVipPreferentialServiceInfoItem.setPreferentialPrice(cVar.d(), cVar.isSelected());
        qVipPreferentialServiceInfoItem.setItemBg(cVar.e());
    }

    public final void setDataList(@NotNull List<? extends h23.c> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
        notifyDataSetChanged();
    }
}
