package com.tencent.state.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareDetailItemActionViewBinding;
import com.tencent.state.status.PanelItemUpdateEvent;
import com.tencent.state.view.StatusPanelTitleListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0010J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/view/TitleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/view/TitleAdapter$ActionHolder;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/state/view/TitleData;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "clickListener", "Lcom/tencent/state/view/StatusPanelTitleListView$ClickListener;", "bindView", "", "holder", "position", "", "fillData", "data", "", "getIndexData", "index", "getItemCount", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "updateSelectedStyle", "updateUnSelectedStyle", "ActionHolder", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class TitleAdapter extends RecyclerView.Adapter<ActionHolder> {
    private StatusPanelTitleListView.ClickListener clickListener;
    private final Context context;
    private final ArrayList<TitleData> dataList;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/view/TitleAdapter$ActionHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/state/square/databinding/VasSquareDetailItemActionViewBinding;", "(Lcom/tencent/state/square/databinding/VasSquareDetailItemActionViewBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareDetailItemActionViewBinding;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class ActionHolder extends RecyclerView.ViewHolder {
        private final VasSquareDetailItemActionViewBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionHolder(VasSquareDetailItemActionViewBinding binding) {
            super(binding.getMContainer());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final VasSquareDetailItemActionViewBinding getBinding() {
            return this.binding;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PanelItemUpdateEvent.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PanelItemUpdateEvent.UPDATE_TITLE_SELECT_ITEM.ordinal()] = 1;
        }
    }

    public /* synthetic */ TitleAdapter(Context context, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? new ArrayList() : arrayList);
    }

    private final void bindView(ActionHolder holder, final int position) {
        TitleData titleData = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(titleData, "dataList[position]");
        final TitleData titleData2 = titleData;
        TextView textView = holder.getBinding().titleText;
        Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.titleText");
        textView.setText(titleData2.getText());
        SquareImageView squareImageView = holder.getBinding().titleRedPoint;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "holder.binding.titleRedPoint");
        squareImageView.setVisibility(titleData2.getHasRed() ? 0 : 8);
        updateUnSelectedStyle(holder);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.TitleAdapter$bindView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatusPanelTitleListView.ClickListener clickListener;
                clickListener = TitleAdapter.this.clickListener;
                if (clickListener != null) {
                    clickListener.titleClick(position, titleData2, true);
                }
            }
        });
        if (titleData2.isSelect()) {
            updateSelectedStyle(holder);
            StatusPanelTitleListView.ClickListener clickListener = this.clickListener;
            if (clickListener != null) {
                clickListener.titleClick(position, titleData2, true);
            }
        }
    }

    private final void updateSelectedStyle(ActionHolder holder) {
        TextView textView = holder.getBinding().titleText;
        Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.titleText");
        textView.setTextSize(18.0f);
        holder.getBinding().titleText.setTextColor(-16777216);
        SquareImageView squareImageView = holder.getBinding().titleRedPoint;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "holder.binding.titleRedPoint");
        squareImageView.setVisibility(8);
    }

    private final void updateUnSelectedStyle(ActionHolder holder) {
        TextView textView = holder.getBinding().titleText;
        Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.titleText");
        textView.setTextSize(14.0f);
        holder.getBinding().titleText.setTextColor(Color.parseColor("#888888"));
    }

    public final void fillData(List<TitleData> data, StatusPanelTitleListView.ClickListener clickListener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        this.dataList.clear();
        List<TitleData> list = data;
        if (!list.isEmpty()) {
            this.dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final TitleData getIndexData(int index) {
        TitleData titleData = this.dataList.get(index);
        Intrinsics.checkNotNullExpressionValue(titleData, "dataList[index]");
        return titleData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    public TitleAdapter(Context context, ArrayList<TitleData> dataList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.context = context;
        this.dataList = dataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(ActionHolder actionHolder, int i3, List list) {
        onBindViewHolder2(actionHolder, i3, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ActionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        VasSquareDetailItemActionViewBinding inflate = VasSquareDetailItemActionViewBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareDetailItemActio\u2026utInflater.from(context))");
        LinearLayout mContainer = inflate.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        mContainer.setLayoutParams(new LinearLayout.LayoutParams(-2, ViewExtensionsKt.dip(this.context, 30)));
        return new ActionHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ActionHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        bindView(holder, position);
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(ActionHolder holder, int position, List<Object> payloads) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) payloads);
        if (!(firstOrNull instanceof PanelItemUpdateEvent)) {
            firstOrNull = null;
        }
        PanelItemUpdateEvent panelItemUpdateEvent = (PanelItemUpdateEvent) firstOrNull;
        if (panelItemUpdateEvent == null) {
            onBindViewHolder(holder, position);
            return;
        }
        TitleData titleData = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(titleData, "dataList[position]");
        TitleData titleData2 = titleData;
        if (WhenMappings.$EnumSwitchMapping$0[panelItemUpdateEvent.ordinal()] != 1) {
            return;
        }
        if (titleData2.isSelect()) {
            updateSelectedStyle(holder);
            StatusPanelTitleListView.ClickListener clickListener = this.clickListener;
            if (clickListener != null) {
                clickListener.titleClick(position, titleData2, false);
                return;
            }
            return;
        }
        updateUnSelectedStyle(holder);
    }
}
