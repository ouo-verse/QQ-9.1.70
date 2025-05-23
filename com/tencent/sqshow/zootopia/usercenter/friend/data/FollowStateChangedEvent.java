package com.tencent.sqshow.zootopia.usercenter.friend.data;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import su4.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/friend/data/FollowStateChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lsu4/i;", "component1", "relationInfo", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lsu4/i;", "getRelationInfo", "()Lsu4/i;", "<init>", "(Lsu4/i;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class FollowStateChangedEvent extends SimpleBaseEvent {
    private final i relationInfo;

    public FollowStateChangedEvent(i relationInfo) {
        Intrinsics.checkNotNullParameter(relationInfo, "relationInfo");
        this.relationInfo = relationInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final i getRelationInfo() {
        return this.relationInfo;
    }

    public final FollowStateChangedEvent copy(i relationInfo) {
        Intrinsics.checkNotNullParameter(relationInfo, "relationInfo");
        return new FollowStateChangedEvent(relationInfo);
    }

    public final i getRelationInfo() {
        return this.relationInfo;
    }

    public int hashCode() {
        return this.relationInfo.hashCode();
    }

    public String toString() {
        return "FollowStateChangedEvent(relationInfo=" + this.relationInfo + ")";
    }

    public static /* synthetic */ FollowStateChangedEvent copy$default(FollowStateChangedEvent followStateChangedEvent, i iVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            iVar = followStateChangedEvent.relationInfo;
        }
        return followStateChangedEvent.copy(iVar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FollowStateChangedEvent) && Intrinsics.areEqual(this.relationInfo, ((FollowStateChangedEvent) other).relationInfo);
    }
}
