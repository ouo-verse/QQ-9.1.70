package com.tencent.state.template.publicchat.action;

import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.MsgInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yr4.d;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/template/publicchat/action/ApplyCallGatherAction;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lcom/tencent/state/publicchat/data/MsgInfo;", "component1", "Lyr4/d;", "component2", "msg", "info", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/state/publicchat/data/MsgInfo;", "getMsg", "()Lcom/tencent/state/publicchat/data/MsgInfo;", "Lyr4/d;", "getInfo", "()Lyr4/d;", "<init>", "(Lcom/tencent/state/publicchat/data/MsgInfo;Lyr4/d;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class ApplyCallGatherAction extends MsgAction {
    private final d info;
    private final MsgInfo msg;

    public ApplyCallGatherAction(MsgInfo msg2, d info) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(info, "info");
        this.msg = msg2;
        this.info = info;
    }

    /* renamed from: component1, reason: from getter */
    public final MsgInfo getMsg() {
        return this.msg;
    }

    /* renamed from: component2, reason: from getter */
    public final d getInfo() {
        return this.info;
    }

    public final ApplyCallGatherAction copy(MsgInfo msg2, d info) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(info, "info");
        return new ApplyCallGatherAction(msg2, info);
    }

    public final d getInfo() {
        return this.info;
    }

    public final MsgInfo getMsg() {
        return this.msg;
    }

    public int hashCode() {
        MsgInfo msgInfo = this.msg;
        int hashCode = (msgInfo != null ? msgInfo.hashCode() : 0) * 31;
        d dVar = this.info;
        return hashCode + (dVar != null ? dVar.hashCode() : 0);
    }

    public String toString() {
        return "ApplyCallGatherAction(msg=" + this.msg + ", info=" + this.info + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplyCallGatherAction)) {
            return false;
        }
        ApplyCallGatherAction applyCallGatherAction = (ApplyCallGatherAction) other;
        return Intrinsics.areEqual(this.msg, applyCallGatherAction.msg) && Intrinsics.areEqual(this.info, applyCallGatherAction.info);
    }

    public static /* synthetic */ ApplyCallGatherAction copy$default(ApplyCallGatherAction applyCallGatherAction, MsgInfo msgInfo, d dVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            msgInfo = applyCallGatherAction.msg;
        }
        if ((i3 & 2) != 0) {
            dVar = applyCallGatherAction.info;
        }
        return applyCallGatherAction.copy(msgInfo, dVar);
    }
}
