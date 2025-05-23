package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildJoin;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cm implements fa {

    /* renamed from: a, reason: collision with root package name */
    private GProGuildJoin f265876a;

    public cm(GProGuildJoin gProGuildJoin) {
        this.f265876a = gProGuildJoin;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.fa
    public String getGuildID() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.f265876a.getGuildId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.fa
    public String getJoinSig() {
        return this.f265876a.getJoinSig();
    }
}
