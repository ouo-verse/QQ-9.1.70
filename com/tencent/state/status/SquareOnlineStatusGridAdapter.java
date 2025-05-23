package com.tencent.state.status;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.databinding.VasSquareOnlineStatusItemBinding;
import com.tencent.state.status.SquareOnlineStatusGridAdapter;
import com.tencent.state.view.SquareImageView;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/status/SquareOnlineStatusGridAdapter$OnlineStatusItemHolder;", "context", "Landroid/content/Context;", VideoTemplateParser.ITEM_LIST, "", "Lcom/tencent/state/status/StatusPanelData;", "(Landroid/content/Context;Ljava/util/List;)V", "statusClickListener", "Lcom/tencent/state/status/SquareOnlineStatusGridAdapter$OnlineStatusClickListener;", "bindView", "", "itemData", "holder", "getIndexData", "position", "", "getItemCount", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "setOnlineStatusClickListener", "OnlineStatusClickListener", "OnlineStatusItemHolder", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOnlineStatusGridAdapter extends RecyclerView.Adapter<OnlineStatusItemHolder> {
    private final Context context;
    private final List<StatusPanelData> itemList;
    private OnlineStatusClickListener statusClickListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusGridAdapter$OnlineStatusClickListener;", "", "onStatusChangeListener", "", "view", "Landroid/view/View;", "data", "Lcom/tencent/state/status/StatusPanelData;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface OnlineStatusClickListener {
        void onStatusChangeListener(View view, StatusPanelData data);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusGridAdapter$OnlineStatusItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/state/square/databinding/VasSquareOnlineStatusItemBinding;", "(Lcom/tencent/state/square/databinding/VasSquareOnlineStatusItemBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareOnlineStatusItemBinding;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class OnlineStatusItemHolder extends RecyclerView.ViewHolder {
        private final VasSquareOnlineStatusItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnlineStatusItemHolder(VasSquareOnlineStatusItemBinding binding) {
            super(binding.getMContainer());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final VasSquareOnlineStatusItemBinding getBinding() {
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
            iArr[PanelItemUpdateEvent.UPDATE_SELECT_ITEM.ordinal()] = 1;
            iArr[PanelItemUpdateEvent.CLICK_SELECT_ITEM.ordinal()] = 2;
            iArr[PanelItemUpdateEvent.UNLOCK_AVATAR_MOTION.ordinal()] = 3;
        }
    }

    public SquareOnlineStatusGridAdapter(Context context, List<StatusPanelData> itemList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        this.context = context;
        this.itemList = itemList;
    }

    private final void bindView(final StatusPanelData itemData, OnlineStatusItemHolder holder) {
        OnlineStatus status = itemData.getStatus();
        TextView textView = holder.getBinding().onlineStatusText;
        Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.onlineStatusText");
        textView.setText(status.getTitle());
        if (itemData.getCornerUrl().length() > 0) {
            holder.getBinding().redPoint.setImageDrawable(SquareOnlineStatusUtils.getUrlDrawable$default(SquareOnlineStatusUtils.INSTANCE, itemData.getCornerUrl(), null, null, false, 14, null));
            SquareImageView squareImageView = holder.getBinding().redPoint;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "holder.binding.redPoint");
            squareImageView.setVisibility(0);
        }
        SquareImageView squareImageView2 = holder.getBinding().lockStatusIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView2, "holder.binding.lockStatusIcon");
        squareImageView2.setVisibility(itemData.getTaskInfo().getPrizeStatus() == PanelStatusTaskPrizeStatus.PRIZE_PENDING ? 0 : 8);
        SquareImageView squareImageView3 = holder.getBinding().onlineStatusIcon;
        SquareOnlineStatusUtils squareOnlineStatusUtils = SquareOnlineStatusUtils.INSTANCE;
        squareImageView3.setImageDrawable(SquareOnlineStatusUtils.getUrlDrawable$default(squareOnlineStatusUtils, status.getPanelPreviewIcon(), null, null, false, 14, null));
        holder.getBinding().getMContainer().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.status.SquareOnlineStatusGridAdapter$bindView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                SquareOnlineStatusGridAdapter.OnlineStatusClickListener onlineStatusClickListener;
                onlineStatusClickListener = SquareOnlineStatusGridAdapter.this.statusClickListener;
                if (onlineStatusClickListener != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    onlineStatusClickListener.onStatusChangeListener(it, itemData);
                }
            }
        });
        if (itemData.isSelect()) {
            holder.getBinding().getMContainer().performClick();
        } else {
            FrameLayout mContainer = holder.getBinding().getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "holder.binding.root");
            mContainer.setSelected(false);
        }
        if (itemData.getShowTipsIcon()) {
            Drawable urlDrawable$default = SquareOnlineStatusUtils.getUrlDrawable$default(squareOnlineStatusUtils, itemData.getTipsUrl(), null, null, false, 14, null);
            holder.getBinding().onlineStatusTips.setImageDrawable(urlDrawable$default);
            SquareImageView squareImageView4 = holder.getBinding().onlineStatusTips;
            Intrinsics.checkNotNullExpressionValue(squareImageView4, "holder.binding.onlineStatusTips");
            squareImageView4.setVisibility(urlDrawable$default == null ? 8 : 0);
        }
    }

    public final StatusPanelData getIndexData(int position) {
        return this.itemList.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemList.size();
    }

    public final void setOnlineStatusClickListener(OnlineStatusClickListener statusClickListener) {
        Intrinsics.checkNotNullParameter(statusClickListener, "statusClickListener");
        this.statusClickListener = statusClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(OnlineStatusItemHolder onlineStatusItemHolder, int i3, List list) {
        onBindViewHolder2(onlineStatusItemHolder, i3, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OnlineStatusItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        VasSquareOnlineStatusItemBinding inflate = VasSquareOnlineStatusItemBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareOnlineStatusIte\u2026utInflater.from(context))");
        FrameLayout mContainer = inflate.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewExtensionsKt.dip(this.context, 81), ViewExtensionsKt.dip(this.context, 92));
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        mContainer.setLayoutParams(layoutParams);
        return new OnlineStatusItemHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OnlineStatusItemHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        bindView(this.itemList.get(position), holder);
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(OnlineStatusItemHolder holder, int position, List<Object> payloads) {
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
        StatusPanelData statusPanelData = this.itemList.get(position);
        int i3 = WhenMappings.$EnumSwitchMapping$0[panelItemUpdateEvent.ordinal()];
        if (i3 == 1) {
            FrameLayout mContainer = holder.getBinding().getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "holder.binding.root");
            mContainer.setSelected(statusPanelData.isSelect());
        } else if (i3 == 2) {
            holder.getBinding().getMContainer().performClick();
        } else {
            if (i3 != 3) {
                return;
            }
            SquareImageView squareImageView = holder.getBinding().lockStatusIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "holder.binding.lockStatusIcon");
            squareImageView.setVisibility(8);
        }
    }
}
