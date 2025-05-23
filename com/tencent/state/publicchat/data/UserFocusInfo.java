package com.tencent.state.publicchat.data;

import com.tencent.mobileqq.vas.banner.c;
import ft4.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u0013\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\u001e\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J;\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/publicchat/data/UserFocusInfo;", "", "", "component1", "component2", "component3", "component4", "", "component5", "uin", "roomId", "tableId", "focusId", "targetTagId", "copy", "toString", "", "hashCode", "other", "", "equals", "J", "getUin", "()J", "getRoomId", "getTableId", "getFocusId", "Ljava/lang/String;", "getTargetTagId", "()Ljava/lang/String;", "<init>", "(JJJJLjava/lang/String;)V", "Lft4/i;", "pb", "(Lft4/i;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class UserFocusInfo {
    private final long focusId;
    private final long roomId;
    private final long tableId;
    private final String targetTagId;
    private final long uin;

    public UserFocusInfo(long j3, long j16, long j17, long j18, String targetTagId) {
        Intrinsics.checkNotNullParameter(targetTagId, "targetTagId");
        this.uin = j3;
        this.roomId = j16;
        this.tableId = j17;
        this.focusId = j18;
        this.targetTagId = targetTagId;
    }

    /* renamed from: component1, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTableId() {
        return this.tableId;
    }

    /* renamed from: component4, reason: from getter */
    public final long getFocusId() {
        return this.focusId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTargetTagId() {
        return this.targetTagId;
    }

    public final UserFocusInfo copy(long uin, long roomId, long tableId, long focusId, String targetTagId) {
        Intrinsics.checkNotNullParameter(targetTagId, "targetTagId");
        return new UserFocusInfo(uin, roomId, tableId, focusId, targetTagId);
    }

    public final long getFocusId() {
        return this.focusId;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getTableId() {
        return this.tableId;
    }

    public final String getTargetTagId() {
        return this.targetTagId;
    }

    public final long getUin() {
        return this.uin;
    }

    public int hashCode() {
        int a16 = ((((((c.a(this.uin) * 31) + c.a(this.roomId)) * 31) + c.a(this.tableId)) * 31) + c.a(this.focusId)) * 31;
        String str = this.targetTagId;
        return a16 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UserFocusInfo(uin=" + this.uin + ", roomId=" + this.roomId + ", tableId=" + this.tableId + ", focusId=" + this.focusId + ", targetTagId=" + this.targetTagId + ")";
    }

    public UserFocusInfo(i iVar) {
        this(0L, 0L, 0L, 0L, "");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserFocusInfo)) {
            return false;
        }
        UserFocusInfo userFocusInfo = (UserFocusInfo) other;
        return this.uin == userFocusInfo.uin && this.roomId == userFocusInfo.roomId && this.tableId == userFocusInfo.tableId && this.focusId == userFocusInfo.focusId && Intrinsics.areEqual(this.targetTagId, userFocusInfo.targetTagId);
    }
}
