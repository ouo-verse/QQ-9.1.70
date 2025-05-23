package com.tencent.mobileqq.onlinestatus.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/u;", "", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "statusInfo", "Lcom/tencent/qqnt/chats/biz/bean/a;", "reveal", "", "a", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f256378a = new u();

    u() {
    }

    public final boolean a(@Nullable com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c statusInfo, @Nullable com.tencent.qqnt.chats.biz.bean.a reveal) {
        if (statusInfo == null || reveal == null || statusInfo.F() != reveal.a() || statusInfo.e0() == 0) {
            return false;
        }
        return true;
    }
}
