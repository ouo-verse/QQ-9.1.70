package com.tencent.mobileqq.zplan.room.impl.constant;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/constant/ZPlanJoinRoomType;", "", "type", "", "desc", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getType", "()I", "CREATE", "JOIN", "RECOVER", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public enum ZPlanJoinRoomType {
    CREATE(0, "Create"),
    JOIN(1, "Join"),
    RECOVER(2, "Recover");

    private final String desc;
    private final int type;

    ZPlanJoinRoomType(int i3, String str) {
        this.type = i3;
        this.desc = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getType() {
        return this.type;
    }

    /* synthetic */ ZPlanJoinRoomType(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str);
    }
}
