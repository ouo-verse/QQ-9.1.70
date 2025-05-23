package com.tencent.state.square.message.box;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxTailHolder;", "Lcom/tencent/state/square/message/box/MsgBoxBaseHolder;", "msgBoxContext", "Lcom/tencent/state/square/message/box/MsgBoxContext;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lcom/tencent/state/square/message/box/MsgBoxPanel;", "itemView", "Landroid/view/View;", "(Lcom/tencent/state/square/message/box/MsgBoxContext;Lcom/tencent/state/square/message/box/MsgBoxPanel;Landroid/view/View;)V", "tailTextView", "Landroid/widget/TextView;", "getTailTextView", "()Landroid/widget/TextView;", "onBindData", "", "data", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxTailHolder extends MsgBoxBaseHolder {
    private final TextView tailTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBoxTailHolder(MsgBoxContext msgBoxContext, MsgBoxPanel panel, View itemView) {
        super(msgBoxContext, panel, 0, itemView);
        Intrinsics.checkNotNullParameter(msgBoxContext, "msgBoxContext");
        Intrinsics.checkNotNullParameter(panel, "panel");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.f163588qy1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.vas_square_msg_box_tail)");
        this.tailTextView = (TextView) findViewById;
    }

    public final TextView getTailTextView() {
        return this.tailTextView;
    }

    @Override // com.tencent.state.square.message.box.MsgBoxBaseHolder
    protected void onBindData(SquareBaseMessageRecord data) {
        Intrinsics.checkNotNullParameter(data, "data");
        long readedMsgValidDay = Square.INSTANCE.getConfig().getCommonUtils().getMsgBoxConfig().getReadedMsgValidDay();
        long j3 = 86400;
        this.tailTextView.setVisibility(readedMsgValidDay < j3 ? 4 : 0);
        this.tailTextView.setText(getMsgBoxContext().getActivity().getString(R.string.f169764xh1, Long.valueOf(readedMsgValidDay / j3)));
    }
}
