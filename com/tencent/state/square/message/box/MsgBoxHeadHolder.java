package com.tencent.state.square.message.box;

import android.view.View;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxHeadHolder;", "Lcom/tencent/state/square/message/box/MsgBoxBaseHolder;", "msgBoxContext", "Lcom/tencent/state/square/message/box/MsgBoxContext;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lcom/tencent/state/square/message/box/MsgBoxPanel;", "itemView", "Landroid/view/View;", "(Lcom/tencent/state/square/message/box/MsgBoxContext;Lcom/tencent/state/square/message/box/MsgBoxPanel;Landroid/view/View;)V", "onBindData", "", "data", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxHeadHolder extends MsgBoxBaseHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBoxHeadHolder(MsgBoxContext msgBoxContext, MsgBoxPanel panel, View itemView) {
        super(msgBoxContext, panel, 2, itemView);
        Intrinsics.checkNotNullParameter(msgBoxContext, "msgBoxContext");
        Intrinsics.checkNotNullParameter(panel, "panel");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    @Override // com.tencent.state.square.message.box.MsgBoxBaseHolder
    protected void onBindData(SquareBaseMessageRecord data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
