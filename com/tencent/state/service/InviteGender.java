package com.tencent.state.service;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/service/InviteGender;", "", "senderGender", "", "receiverGender", "(II)V", "getReceiverGender", "()I", "getSenderGender", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class InviteGender {
    private final int receiverGender;
    private final int senderGender;

    public InviteGender(int i3, int i16) {
        this.senderGender = i3;
        this.receiverGender = i16;
    }

    /* renamed from: component1, reason: from getter */
    public final int getSenderGender() {
        return this.senderGender;
    }

    /* renamed from: component2, reason: from getter */
    public final int getReceiverGender() {
        return this.receiverGender;
    }

    public final InviteGender copy(int senderGender, int receiverGender) {
        return new InviteGender(senderGender, receiverGender);
    }

    public final int getReceiverGender() {
        return this.receiverGender;
    }

    public final int getSenderGender() {
        return this.senderGender;
    }

    public int hashCode() {
        return (this.senderGender * 31) + this.receiverGender;
    }

    public String toString() {
        return "InviteGender(senderGender=" + this.senderGender + ", receiverGender=" + this.receiverGender + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteGender)) {
            return false;
        }
        InviteGender inviteGender = (InviteGender) other;
        return this.senderGender == inviteGender.senderGender && this.receiverGender == inviteGender.receiverGender;
    }

    public static /* synthetic */ InviteGender copy$default(InviteGender inviteGender, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = inviteGender.senderGender;
        }
        if ((i17 & 2) != 0) {
            i16 = inviteGender.receiverGender;
        }
        return inviteGender.copy(i3, i16);
    }
}
