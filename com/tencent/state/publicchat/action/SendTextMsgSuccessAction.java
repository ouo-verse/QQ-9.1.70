package com.tencent.state.publicchat.action;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/publicchat/action/SendTextMsgSuccessAction;", "Lcom/tencent/state/publicchat/action/MsgAction;", "msgTxt", "", "(Ljava/lang/String;)V", "getMsgTxt", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SendTextMsgSuccessAction extends MsgAction {
    private final String msgTxt;

    public SendTextMsgSuccessAction(String msgTxt) {
        Intrinsics.checkNotNullParameter(msgTxt, "msgTxt");
        this.msgTxt = msgTxt;
    }

    /* renamed from: component1, reason: from getter */
    public final String getMsgTxt() {
        return this.msgTxt;
    }

    public final SendTextMsgSuccessAction copy(String msgTxt) {
        Intrinsics.checkNotNullParameter(msgTxt, "msgTxt");
        return new SendTextMsgSuccessAction(msgTxt);
    }

    public final String getMsgTxt() {
        return this.msgTxt;
    }

    public int hashCode() {
        String str = this.msgTxt;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SendTextMsgSuccessAction(msgTxt=" + this.msgTxt + ")";
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SendTextMsgSuccessAction) && Intrinsics.areEqual(this.msgTxt, ((SendTextMsgSuccessAction) other).msgTxt);
        }
        return true;
    }

    public static /* synthetic */ SendTextMsgSuccessAction copy$default(SendTextMsgSuccessAction sendTextMsgSuccessAction, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sendTextMsgSuccessAction.msgTxt;
        }
        return sendTextMsgSuccessAction.copy(str);
    }
}
