package com.tencent.state.template.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/template/data/EnterRoomInfo;", "", "msgOffset", "", "room", "Lcom/tencent/state/template/data/CommonRoomInfo;", "isReconnect", "", "([BLcom/tencent/state/template/data/CommonRoomInfo;Z)V", "()Z", "isReenter", "setReenter", "(Z)V", "getMsgOffset", "()[B", "getRoom", "()Lcom/tencent/state/template/data/CommonRoomInfo;", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EnterRoomInfo {
    private final boolean isReconnect;
    private boolean isReenter;
    private final byte[] msgOffset;
    private final CommonRoomInfo room;

    public EnterRoomInfo(byte[] msgOffset, CommonRoomInfo commonRoomInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(msgOffset, "msgOffset");
        this.msgOffset = msgOffset;
        this.room = commonRoomInfo;
        this.isReconnect = z16;
    }

    public final byte[] getMsgOffset() {
        return this.msgOffset;
    }

    public final CommonRoomInfo getRoom() {
        return this.room;
    }

    /* renamed from: isReconnect, reason: from getter */
    public final boolean getIsReconnect() {
        return this.isReconnect;
    }

    /* renamed from: isReenter, reason: from getter */
    public final boolean getIsReenter() {
        return this.isReenter;
    }

    public final void setReenter(boolean z16) {
        this.isReenter = z16;
    }

    public String toString() {
        return "EnterRoomInfo(isReenter=" + this.isReenter + ", room=" + this.room + ')';
    }
}
