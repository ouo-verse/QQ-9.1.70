package com.tencent.state.square.message.box;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.view.CircleBoarderImageView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxBubbleAvatarInfo;", "", "()V", "iconView", "Lcom/tencent/state/view/CircleBoarderImageView;", "getIconView", "()Lcom/tencent/state/view/CircleBoarderImageView;", "setIconView", "(Lcom/tencent/state/view/CircleBoarderImageView;)V", AppConstants.Key.COLUMN_MSG_DATA, "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "getMsgData", "()Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "setMsgData", "(Lcom/tencent/state/square/api/SquareBaseMessageRecord;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxBubbleAvatarInfo {
    private CircleBoarderImageView iconView;
    private SquareBaseMessageRecord msgData;

    public final CircleBoarderImageView getIconView() {
        return this.iconView;
    }

    public final SquareBaseMessageRecord getMsgData() {
        return this.msgData;
    }

    public final void setIconView(CircleBoarderImageView circleBoarderImageView) {
        this.iconView = circleBoarderImageView;
    }

    public final void setMsgData(SquareBaseMessageRecord squareBaseMessageRecord) {
        this.msgData = squareBaseMessageRecord;
    }
}
