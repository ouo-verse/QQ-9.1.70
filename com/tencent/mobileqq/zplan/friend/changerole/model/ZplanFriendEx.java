package com.tencent.mobileqq.zplan.friend.changerole.model;

import com.tencent.mobileqq.zplan.friend.FriendInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/changerole/model/b;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lcom/tencent/mobileqq/zplan/friend/c;", "a", "Lcom/tencent/mobileqq/zplan/friend/c;", "()Lcom/tencent/mobileqq/zplan/friend/c;", "friendInfo", "Lcom/tencent/mobileqq/zplan/friend/changerole/model/State;", "b", "Lcom/tencent/mobileqq/zplan/friend/changerole/model/State;", "()Lcom/tencent/mobileqq/zplan/friend/changerole/model/State;", "c", "(Lcom/tencent/mobileqq/zplan/friend/changerole/model/State;)V", "state", "<init>", "(Lcom/tencent/mobileqq/zplan/friend/c;Lcom/tencent/mobileqq/zplan/friend/changerole/model/State;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.friend.changerole.model.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZplanFriendEx {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final FriendInfo friendInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private State state;

    public ZplanFriendEx(FriendInfo friendInfo, State state) {
        Intrinsics.checkNotNullParameter(friendInfo, "friendInfo");
        Intrinsics.checkNotNullParameter(state, "state");
        this.friendInfo = friendInfo;
        this.state = state;
    }

    /* renamed from: a, reason: from getter */
    public final FriendInfo getFriendInfo() {
        return this.friendInfo;
    }

    /* renamed from: b, reason: from getter */
    public final State getState() {
        return this.state;
    }

    public final void c(State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.state = state;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ZplanFriendEx)) {
            return false;
        }
        ZplanFriendEx zplanFriendEx = (ZplanFriendEx) other;
        return this.state == zplanFriendEx.state && Intrinsics.areEqual(this.friendInfo, zplanFriendEx.friendInfo);
    }

    public int hashCode() {
        return (this.friendInfo.hashCode() * 31) + this.state.hashCode();
    }

    public String toString() {
        return "ZplanFriendEx(friendInfo=" + this.friendInfo + ", state=" + this.state + ")";
    }
}
