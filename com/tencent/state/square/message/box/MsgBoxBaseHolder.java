package com.tencent.state.square.message.box;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H$J\u0006\u0010\u001b\u001a\u00020\u0018R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxBaseHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "msgBoxContext", "Lcom/tencent/state/square/message/box/MsgBoxContext;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lcom/tencent/state/square/message/box/MsgBoxPanel;", "itemType", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/state/square/message/box/MsgBoxContext;Lcom/tencent/state/square/message/box/MsgBoxPanel;ILandroid/view/View;)V", "getItemType", "()I", "getMsgBoxContext", "()Lcom/tencent/state/square/message/box/MsgBoxContext;", AppConstants.Key.COLUMN_MSG_DATA, "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "getMsgData", "()Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "setMsgData", "(Lcom/tencent/state/square/api/SquareBaseMessageRecord;)V", "getPanel", "()Lcom/tencent/state/square/message/box/MsgBoxPanel;", "bindData", "", "data", "onBindData", "onRecycled", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class MsgBoxBaseHolder extends RecyclerView.ViewHolder {
    public static final int ITEM_TYPE_HEAD = 2;
    public static final int ITEM_TYPE_NORMAL = 1;
    public static final int ITEM_TYPE_TAIL = 0;
    private final int itemType;
    private final MsgBoxContext msgBoxContext;
    private SquareBaseMessageRecord msgData;
    private final MsgBoxPanel panel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBoxBaseHolder(MsgBoxContext msgBoxContext, MsgBoxPanel panel, int i3, View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(msgBoxContext, "msgBoxContext");
        Intrinsics.checkNotNullParameter(panel, "panel");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.msgBoxContext = msgBoxContext;
        this.panel = panel;
        this.itemType = i3;
    }

    public final void bindData(SquareBaseMessageRecord data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.msgData = data;
        onBindData(data);
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final MsgBoxContext getMsgBoxContext() {
        return this.msgBoxContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SquareBaseMessageRecord getMsgData() {
        return this.msgData;
    }

    public final MsgBoxPanel getPanel() {
        return this.panel;
    }

    protected abstract void onBindData(SquareBaseMessageRecord data);

    protected final void setMsgData(SquareBaseMessageRecord squareBaseMessageRecord) {
        this.msgData = squareBaseMessageRecord;
    }

    public final void onRecycled() {
        this.msgData = null;
    }
}
