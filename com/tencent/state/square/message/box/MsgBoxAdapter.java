package com.tencent.state.square.message.box;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.common.ViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/square/message/box/MsgBoxBaseHolder;", "Lcom/tencent/state/square/message/box/IMsgBoxDataObserver;", "msgBoxContext", "Lcom/tencent/state/square/message/box/MsgBoxContext;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lcom/tencent/state/square/message/box/MsgBoxPanel;", TabPreloadItem.TAB_NAME_MESSAGE, "", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "(Lcom/tencent/state/square/message/box/MsgBoxContext;Lcom/tencent/state/square/message/box/MsgBoxPanel;Ljava/util/List;)V", "getItemCount", "", "getItemViewType", "position", "isEmpty", "", "onBindViewHolder", "", "holder", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "onDataInsert", "data", "index", "onDataRemove", "onDataSetChange", "onDataUpdate", "onNewMessageCome", "onTotalUnreadNumChange", "unreadNum", "onViewRecycled", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxAdapter extends RecyclerView.Adapter<MsgBoxBaseHolder> implements IMsgBoxDataObserver {
    private final MsgBoxContext msgBoxContext;
    private final List<SquareBaseMessageRecord> msgList;
    private final MsgBoxPanel panel;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageRecordType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MessageRecordType.RECORD_TYPE_NONE.ordinal()] = 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MsgBoxAdapter(MsgBoxContext msgBoxContext, MsgBoxPanel panel, List<? extends SquareBaseMessageRecord> msgList) {
        Intrinsics.checkNotNullParameter(msgBoxContext, "msgBoxContext");
        Intrinsics.checkNotNullParameter(panel, "panel");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        this.msgBoxContext = msgBoxContext;
        this.panel = panel;
        this.msgList = msgList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.msgList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (WhenMappings.$EnumSwitchMapping$0[this.msgList.get(position).getRecordType().ordinal()] != 1) {
            return 1;
        }
        return position == 0 ? 2 : 0;
    }

    public final boolean isEmpty() {
        return getNUM_BACKGOURND_ICON() <= 2;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataInsert(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        notifyItemInserted(index);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataRemove(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        notifyItemRemoved(index);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataSetChange() {
        notifyDataSetChanged();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataUpdate(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        notifyItemChanged(index);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onNewMessageCome(SquareBaseMessageRecord data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MsgBoxBaseHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindData(this.msgList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MsgBoxBaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            MsgBoxContext msgBoxContext = this.msgBoxContext;
            MsgBoxPanel msgBoxPanel = this.panel;
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.d6f, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(pare\u2026_box_tail, parent, false)");
            return new MsgBoxTailHolder(msgBoxContext, msgBoxPanel, inflate);
        }
        if (viewType != 2) {
            MsgBoxContext msgBoxContext2 = this.msgBoxContext;
            MsgBoxPanel msgBoxPanel2 = this.panel;
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.d6d, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "LayoutInflater.from(pare\u2026_box_item, parent, false)");
            return new MsgBoxItemHolder(msgBoxContext2, msgBoxPanel2, inflate2);
        }
        MsgBoxContext msgBoxContext3 = this.msgBoxContext;
        MsgBoxPanel msgBoxPanel3 = this.panel;
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, ViewExtensionsKt.dip(parent.getContext(), 1.0f)));
        Unit unit = Unit.INSTANCE;
        return new MsgBoxHeadHolder(msgBoxContext3, msgBoxPanel3, frameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(MsgBoxBaseHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onRecycled();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onTotalUnreadNumChange(int unreadNum) {
    }
}
