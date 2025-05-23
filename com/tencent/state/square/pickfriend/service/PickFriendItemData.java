package com.tencent.state.square.pickfriend.service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B<\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007\u00a2\u0006\u0002\u0010\fBB\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J$\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007H\u00c6\u0003JN\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/pickfriend/service/PickFriendItemData;", "", "data", "Lcom/tencent/state/square/pickfriend/service/FriendData;", "refSource", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "uin", "", "(Lcom/tencent/state/square/pickfriend/service/FriendData;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "nickName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "getNickName", "()Ljava/lang/String;", "getRefSource", "getUin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class PickFriendItemData {
    private final Function1<String, Unit> action;
    private final String nickName;
    private final String refSource;
    private final String uin;

    /* JADX WARN: Multi-variable type inference failed */
    public PickFriendItemData(String uin, String nickName, String str, Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(action, "action");
        this.uin = uin;
        this.nickName = nickName;
        this.refSource = str;
        this.action = action;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRefSource() {
        return this.refSource;
    }

    public final Function1<String, Unit> component4() {
        return this.action;
    }

    public final PickFriendItemData copy(String uin, String nickName, String refSource, Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(action, "action");
        return new PickFriendItemData(uin, nickName, refSource, action);
    }

    public final Function1<String, Unit> getAction() {
        return this.action;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getRefSource() {
        return this.refSource;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        String str = this.uin;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nickName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.refSource;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Function1<String, Unit> function1 = this.action;
        return hashCode3 + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        return "PickFriendItemData(uin=" + this.uin + ", nickName=" + this.nickName + ", refSource=" + this.refSource + ", action=" + this.action + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PickFriendItemData(FriendData data, String str, Function1<? super String, Unit> action) {
        this(data.getUin(), data.getNick(), str, action);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(action, "action");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickFriendItemData)) {
            return false;
        }
        PickFriendItemData pickFriendItemData = (PickFriendItemData) other;
        return Intrinsics.areEqual(this.uin, pickFriendItemData.uin) && Intrinsics.areEqual(this.nickName, pickFriendItemData.nickName) && Intrinsics.areEqual(this.refSource, pickFriendItemData.refSource) && Intrinsics.areEqual(this.action, pickFriendItemData.action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PickFriendItemData copy$default(PickFriendItemData pickFriendItemData, String str, String str2, String str3, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pickFriendItemData.uin;
        }
        if ((i3 & 2) != 0) {
            str2 = pickFriendItemData.nickName;
        }
        if ((i3 & 4) != 0) {
            str3 = pickFriendItemData.refSource;
        }
        if ((i3 & 8) != 0) {
            function1 = pickFriendItemData.action;
        }
        return pickFriendItemData.copy(str, str2, str3, function1);
    }
}
