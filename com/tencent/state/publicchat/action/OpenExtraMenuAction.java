package com.tencent.state.publicchat.action;

import com.tencent.state.publicchat.data.MsgInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/publicchat/action/OpenExtraMenuAction;", "Lcom/tencent/state/publicchat/action/MsgAction;", "uin", "", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "(Ljava/lang/String;Lcom/tencent/state/publicchat/data/MsgInfo;)V", "getMsg", "()Lcom/tencent/state/publicchat/data/MsgInfo;", "getUin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class OpenExtraMenuAction extends MsgAction {
    private final MsgInfo msg;
    private final String uin;

    public OpenExtraMenuAction(String uin, MsgInfo msgInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.msg = msgInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final MsgInfo getMsg() {
        return this.msg;
    }

    public final OpenExtraMenuAction copy(String uin, MsgInfo msg2) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new OpenExtraMenuAction(uin, msg2);
    }

    public final MsgInfo getMsg() {
        return this.msg;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        String str = this.uin;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        MsgInfo msgInfo = this.msg;
        return hashCode + (msgInfo != null ? msgInfo.hashCode() : 0);
    }

    public String toString() {
        return "OpenExtraMenuAction(uin=" + this.uin + ", msg=" + this.msg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenExtraMenuAction)) {
            return false;
        }
        OpenExtraMenuAction openExtraMenuAction = (OpenExtraMenuAction) other;
        return Intrinsics.areEqual(this.uin, openExtraMenuAction.uin) && Intrinsics.areEqual(this.msg, openExtraMenuAction.msg);
    }

    public static /* synthetic */ OpenExtraMenuAction copy$default(OpenExtraMenuAction openExtraMenuAction, String str, MsgInfo msgInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = openExtraMenuAction.uin;
        }
        if ((i3 & 2) != 0) {
            msgInfo = openExtraMenuAction.msg;
        }
        return openExtraMenuAction.copy(str, msgInfo);
    }
}
