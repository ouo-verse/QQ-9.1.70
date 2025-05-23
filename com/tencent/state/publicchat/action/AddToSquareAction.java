package com.tencent.state.publicchat.action;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/publicchat/action/AddToSquareAction;", "Lcom/tencent/state/publicchat/action/MsgAction;", "uin", "", "relationType", "", "(Ljava/lang/String;I)V", "getRelationType", "()I", "getUin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class AddToSquareAction extends MsgAction {
    private final int relationType;
    private final String uin;

    public AddToSquareAction(String uin, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.relationType = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRelationType() {
        return this.relationType;
    }

    public final AddToSquareAction copy(String uin, int relationType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new AddToSquareAction(uin, relationType);
    }

    public final int getRelationType() {
        return this.relationType;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        String str = this.uin;
        return ((str != null ? str.hashCode() : 0) * 31) + this.relationType;
    }

    public String toString() {
        return "AddToSquareAction(uin=" + this.uin + ", relationType=" + this.relationType + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddToSquareAction)) {
            return false;
        }
        AddToSquareAction addToSquareAction = (AddToSquareAction) other;
        return Intrinsics.areEqual(this.uin, addToSquareAction.uin) && this.relationType == addToSquareAction.relationType;
    }

    public static /* synthetic */ AddToSquareAction copy$default(AddToSquareAction addToSquareAction, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = addToSquareAction.uin;
        }
        if ((i16 & 2) != 0) {
            i3 = addToSquareAction.relationType;
        }
        return addToSquareAction.copy(str, i3);
    }
}
