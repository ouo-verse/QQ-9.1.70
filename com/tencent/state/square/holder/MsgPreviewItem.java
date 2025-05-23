package com.tencent.state.square.holder;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.ISquareSummaryView;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareSummaryViewConfig;
import com.tencent.state.square.api.SummaryData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/holder/MsgPreviewItem;", "", "holder", "Lcom/tencent/state/square/holder/AvatarViewHolder;", ParseCommon.CONTAINER, "Landroid/widget/FrameLayout;", "textView", "Landroid/widget/TextView;", "summaryContainer", "(Lcom/tencent/state/square/holder/AvatarViewHolder;Landroid/widget/FrameLayout;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V", "getContainer", "()Landroid/widget/FrameLayout;", "getHolder", "()Lcom/tencent/state/square/holder/AvatarViewHolder;", "lastMsg", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "getLastMsg", "()Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "setLastMsg", "(Lcom/tencent/state/square/api/SquareBaseMessageRecord;)V", "getSummaryContainer", "summaryView", "Lcom/tencent/state/square/api/ISquareSummaryView;", "getSummaryView", "()Lcom/tencent/state/square/api/ISquareSummaryView;", "setSummaryView", "(Lcom/tencent/state/square/api/ISquareSummaryView;)V", "getTextView", "()Landroid/widget/TextView;", "bindMsg", "", "msg", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgPreviewItem {
    private final FrameLayout container;
    private final AvatarViewHolder holder;
    private SquareBaseMessageRecord lastMsg;
    private final FrameLayout summaryContainer;
    private ISquareSummaryView summaryView;
    private final TextView textView;

    public MsgPreviewItem(AvatarViewHolder holder, FrameLayout container, TextView textView, FrameLayout summaryContainer) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(summaryContainer, "summaryContainer");
        this.holder = holder;
        this.container = container;
        this.textView = textView;
        this.summaryContainer = summaryContainer;
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Context context = container.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        ISquareSummaryView summaryView = commonUtils.getSummaryView(context, new SquareSummaryViewConfig(12.0f, -16777216));
        this.summaryView = summaryView;
        if (summaryView != null) {
            summaryContainer.addView(summaryView.getView(), new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.summaryView != null) {
            textView.setVisibility(8);
            summaryContainer.setVisibility(0);
        } else {
            textView.setVisibility(0);
            summaryContainer.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bindMsg(SquareBaseMessageRecord msg2) {
        boolean z16;
        SummaryData summaryData;
        ISquareSummaryView iSquareSummaryView;
        boolean isBlank;
        this.lastMsg = msg2;
        if (msg2 == null) {
            return;
        }
        String msgText = msg2.getSummaryData().getMsgText();
        if (msgText != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(msgText);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    String lastMsg = msg2.getLastMsg();
                    if (lastMsg == null) {
                        lastMsg = "";
                    }
                    summaryData = new SummaryData(false, null, lastMsg, 0, 0, false, 59, null);
                } else {
                    summaryData = msg2.getSummaryData();
                }
                this.textView.setText(summaryData.getMsgText());
                iSquareSummaryView = this.summaryView;
                if (iSquareSummaryView == null) {
                    ISquareSummaryView.DefaultImpls.setSummaryData$default(iSquareSummaryView, summaryData, null, 2, null);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
        this.textView.setText(summaryData.getMsgText());
        iSquareSummaryView = this.summaryView;
        if (iSquareSummaryView == null) {
        }
    }

    public final FrameLayout getContainer() {
        return this.container;
    }

    public final AvatarViewHolder getHolder() {
        return this.holder;
    }

    public final SquareBaseMessageRecord getLastMsg() {
        return this.lastMsg;
    }

    public final FrameLayout getSummaryContainer() {
        return this.summaryContainer;
    }

    public final ISquareSummaryView getSummaryView() {
        return this.summaryView;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final void setLastMsg(SquareBaseMessageRecord squareBaseMessageRecord) {
        this.lastMsg = squareBaseMessageRecord;
    }

    public final void setSummaryView(ISquareSummaryView iSquareSummaryView) {
        this.summaryView = iSquareSummaryView;
    }
}
