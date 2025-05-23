package com.tencent.mobileqq.onlinestatus.model;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/model/d;", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "a", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "()Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", GuildMsgItem.NICK_FRIEND, "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "b", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "()Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "status", "<init>", "(Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;)V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.ntrelation.friendsinfo.bean.d friend;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c status;

    public d(@NotNull com.tencent.qqnt.ntrelation.friendsinfo.bean.d friend, @NotNull com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c status) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        Intrinsics.checkNotNullParameter(status, "status");
        this.friend = friend;
        this.status = status;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.qqnt.ntrelation.friendsinfo.bean.d getFriend() {
        return this.friend;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c getStatus() {
        return this.status;
    }
}
