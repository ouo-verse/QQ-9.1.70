package com.tencent.state.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.status.PanelItemUpdateEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u001c\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/view/StatusPanelTitleListView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", ParseCommon.CONTAINER, "Landroidx/recyclerview/widget/RecyclerView;", "titleAdapter", "Lcom/tencent/state/view/TitleAdapter;", "getIndexData", "Lcom/tencent/state/view/TitleData;", "index", "setData", "", "data", "", "clickListener", "Lcom/tencent/state/view/StatusPanelTitleListView$ClickListener;", "updateSelectView", "newIndex", "updateTitleStyle", "curIndex", "updateUnSelectView", "ClickListener", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class StatusPanelTitleListView extends FrameLayout {
    private final RecyclerView container;
    private final TitleAdapter titleAdapter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/view/StatusPanelTitleListView$ClickListener;", "", "titleClick", "", "index", "", "data", "Lcom/tencent/state/view/TitleData;", "isFromClick", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface ClickListener {
        void titleClick(int index, TitleData data, boolean isFromClick);
    }

    public StatusPanelTitleListView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void updateSelectView(int newIndex) {
        TitleData indexData = this.titleAdapter.getIndexData(newIndex);
        indexData.setSelect(true);
        indexData.setHasRed(false);
        if (this.container.getScrollState() != 0 || this.container.isComputingLayout()) {
            return;
        }
        this.titleAdapter.notifyItemChanged(newIndex, PanelItemUpdateEvent.UPDATE_TITLE_SELECT_ITEM);
    }

    private final void updateUnSelectView(int curIndex) {
        this.titleAdapter.getIndexData(curIndex).setSelect(false);
        if (this.container.getScrollState() != 0 || this.container.isComputingLayout()) {
            return;
        }
        this.titleAdapter.notifyItemChanged(curIndex, PanelItemUpdateEvent.UPDATE_TITLE_SELECT_ITEM);
    }

    public final TitleData getIndexData(int index) {
        return this.titleAdapter.getIndexData(index);
    }

    public final void setData(List<TitleData> data, ClickListener clickListener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.titleAdapter.fillData(data, clickListener);
    }

    public StatusPanelTitleListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ StatusPanelTitleListView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void updateTitleStyle(int curIndex, int newIndex) {
        if (curIndex != newIndex) {
            updateUnSelectView(curIndex);
        }
        updateSelectView(newIndex);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusPanelTitleListView(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        TitleAdapter titleAdapter = new TitleAdapter(context, null, 2, 0 == true ? 1 : 0);
        this.titleAdapter = titleAdapter;
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setAdapter(titleAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.tencent.state.view.StatusPanelTitleListView$$special$$inlined$apply$lambda$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                if ((parent.getLayoutManager() instanceof LinearLayoutManager) && parent.getChildAdapterPosition(view) == 0) {
                    outRect.left = ViewExtensionsKt.dip(context, 5);
                }
                outRect.right = ViewExtensionsKt.dip(context, 24);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.container = recyclerView;
        addView(recyclerView, new FrameLayout.LayoutParams(-1, -1));
    }
}
