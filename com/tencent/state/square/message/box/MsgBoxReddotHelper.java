package com.tencent.state.square.message.box;

import android.view.View;
import android.widget.TextView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.resource.ISquareViewBridge;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\rH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxReddotHelper;", "Lcom/tencent/state/square/message/box/IMsgBoxDataObserver;", "Lcom/tencent/state/square/message/box/IMsgBoxLifeCycle;", "Landroid/view/View$OnClickListener;", "msgBoxContext", "Lcom/tencent/state/square/message/box/MsgBoxContext;", "(Lcom/tencent/state/square/message/box/MsgBoxContext;)V", "destroyed", "", "hasReportExposure", "reporter", "Lcom/tencent/state/square/IReporter;", "destroy", "", "getReportParams", "", "", "", "initViewIfNeeded", "isDestroy", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onDataInsert", "data", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "index", "", "onDataRemove", "onDataSetChange", "onDataUpdate", "onNewMessageCome", "onTotalUnreadNumChange", "unreadNum", "refreshUnreadNum", "reportExposure", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxReddotHelper implements IMsgBoxDataObserver, IMsgBoxLifeCycle, View.OnClickListener {
    private boolean destroyed;
    private boolean hasReportExposure;
    private final MsgBoxContext msgBoxContext;
    private final IReporter reporter;

    public MsgBoxReddotHelper(MsgBoxContext msgBoxContext) {
        Intrinsics.checkNotNullParameter(msgBoxContext, "msgBoxContext");
        this.msgBoxContext = msgBoxContext;
        this.reporter = Square.INSTANCE.getConfig().getReporter();
        msgBoxContext.getMsgBoxManager().addMsgBoxDataObserver(this);
        initViewIfNeeded();
    }

    private final Map<String, Object> getReportParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_MSG_BOX_HAS_BUBBLE, Integer.valueOf(this.msgBoxContext.getMsgBoxManager().isShowingMsgBubble() ? 1 : 0));
        int totalUnReadNum = this.msgBoxContext.getMsgBoxManager().getTotalUnReadNum();
        linkedHashMap.put(SquareReportConst.Key.KEY_HAS_UNREAD_MESSAGE, Integer.valueOf(totalUnReadNum > 0 ? 1 : 0));
        linkedHashMap.put("zplan_unread_message_number", Integer.valueOf(totalUnReadNum));
        return linkedHashMap;
    }

    private final void initViewIfNeeded() {
        View squareMsgBoxIcon;
        ISquareViewBridge viewBridge = this.msgBoxContext.getManagerProxy().getViewBridge();
        if (viewBridge == null || (squareMsgBoxIcon = viewBridge.getSquareMsgBoxIcon()) == null || squareMsgBoxIcon.hasOnClickListeners()) {
            return;
        }
        squareMsgBoxIcon.setOnClickListener(this);
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            iReporter.setElementInfo(squareMsgBoxIcon, SquareReportConst.ElementId.ELEMENT_ID_MSG_BOX_ICON, new LinkedHashMap(), false, false);
        }
    }

    private final void refreshUnreadNum(int unreadNum) {
        String valueOf;
        ISquareViewBridge viewBridge = this.msgBoxContext.getManagerProxy().getViewBridge();
        View sqaureMsgBoxReddot = viewBridge != null ? viewBridge.getSqaureMsgBoxReddot() : null;
        TextView textView = (TextView) (sqaureMsgBoxReddot instanceof TextView ? sqaureMsgBoxReddot : null);
        if (textView != null) {
            textView.setVisibility(unreadNum > 0 ? 0 : 8);
            if (unreadNum > 99) {
                valueOf = "99+";
            } else {
                valueOf = String.valueOf(unreadNum);
            }
            textView.setText(valueOf);
        }
    }

    private final void reportExposure() {
        View squareMsgBoxIcon;
        IReporter iReporter;
        if (this.hasReportExposure) {
            return;
        }
        initViewIfNeeded();
        ISquareViewBridge viewBridge = this.msgBoxContext.getManagerProxy().getViewBridge();
        if (viewBridge != null && (squareMsgBoxIcon = viewBridge.getSquareMsgBoxIcon()) != null && (iReporter = this.reporter) != null) {
            iReporter.reportEvent("imp", squareMsgBoxIcon, getReportParams());
        }
        this.hasReportExposure = true;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxLifeCycle
    /* renamed from: isDestroy, reason: from getter */
    public boolean getDestroyed() {
        return this.destroyed;
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataInsert(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataRemove(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataUpdate(SquareBaseMessageRecord data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onNewMessageCome(SquareBaseMessageRecord data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onTotalUnreadNumChange(int unreadNum) {
        if (getDestroyed()) {
            return;
        }
        refreshUnreadNum(unreadNum);
        reportExposure();
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxLifeCycle
    public void destroy() {
        this.destroyed = true;
        this.msgBoxContext.getMsgBoxManager().removeMsgBoxDataObserver(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        IReporter iReporter;
        if (v3 != null && (iReporter = this.reporter) != null) {
            iReporter.reportEvent("clck", v3, getReportParams());
        }
        this.msgBoxContext.getMsgBoxManager().showMsgListPanel(MsgBoxOperateFlag.CLICK_MSG_BOX_ICON);
    }

    @Override // com.tencent.state.square.message.box.IMsgBoxDataObserver
    public void onDataSetChange() {
    }
}
