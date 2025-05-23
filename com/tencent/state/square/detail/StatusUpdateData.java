package com.tencent.state.square.detail;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.state.square.data.AvatarAction;
import com.tencent.state.square.data.OnlineStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/detail/StatusUpdateData;", "", "action", "Lcom/tencent/state/square/data/AvatarAction;", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "(Lcom/tencent/state/square/data/AvatarAction;Lcom/tencent/state/square/data/OnlineStatus;)V", "getAction", "()Lcom/tencent/state/square/data/AvatarAction;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/state/square/data/OnlineStatus;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class StatusUpdateData {
    private final AvatarAction action;
    private final OnlineStatus status;

    public StatusUpdateData(AvatarAction avatarAction, OnlineStatus onlineStatus) {
        this.action = avatarAction;
        this.status = onlineStatus;
    }

    /* renamed from: component1, reason: from getter */
    public final AvatarAction getAction() {
        return this.action;
    }

    /* renamed from: component2, reason: from getter */
    public final OnlineStatus getStatus() {
        return this.status;
    }

    public final StatusUpdateData copy(AvatarAction action, OnlineStatus status) {
        return new StatusUpdateData(action, status);
    }

    public final AvatarAction getAction() {
        return this.action;
    }

    public final OnlineStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        AvatarAction avatarAction = this.action;
        int hashCode = (avatarAction != null ? avatarAction.hashCode() : 0) * 31;
        OnlineStatus onlineStatus = this.status;
        return hashCode + (onlineStatus != null ? onlineStatus.hashCode() : 0);
    }

    public String toString() {
        return "StatusUpdateData(action=" + this.action + ", status=" + this.status + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusUpdateData)) {
            return false;
        }
        StatusUpdateData statusUpdateData = (StatusUpdateData) other;
        return Intrinsics.areEqual(this.action, statusUpdateData.action) && Intrinsics.areEqual(this.status, statusUpdateData.status);
    }

    public static /* synthetic */ StatusUpdateData copy$default(StatusUpdateData statusUpdateData, AvatarAction avatarAction, OnlineStatus onlineStatus, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            avatarAction = statusUpdateData.action;
        }
        if ((i3 & 2) != 0) {
            onlineStatus = statusUpdateData.status;
        }
        return statusUpdateData.copy(avatarAction, onlineStatus);
    }
}
