package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientAccount;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class y implements di {

    /* renamed from: a, reason: collision with root package name */
    private final GProClientAccount f266753a;

    public y(GProClientAccount gProClientAccount) {
        this.f266753a = gProClientAccount;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.di
    public String a() {
        return this.f266753a.getAccountSecret();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.di
    public String b() {
        return this.f266753a.getAccountName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.di
    public int c() {
        return this.f266753a.clientSourceType;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.di
    public dk d() {
        return new aa(this.f266753a.getClientConfig());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.di
    public String e() {
        return this.f266753a.unbindUrl;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.di
    public String getClientId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.W0(this.f266753a.getClientId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.di
    public String getClientName() {
        return this.f266753a.getClientName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.di
    public String getIcon() {
        return this.f266753a.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.di
    public int getType() {
        return this.f266753a.type;
    }

    @NotNull
    public String toString() {
        return "GProClientAccountInfo{clientAccount=" + this.f266753a + "}";
    }
}
