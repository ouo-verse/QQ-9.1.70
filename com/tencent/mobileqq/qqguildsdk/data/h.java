package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientInfo;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class h implements da {

    /* renamed from: a, reason: collision with root package name */
    private final GProClientInfo f266702a;

    public h(GProClientInfo gProClientInfo) {
        this.f266702a = gProClientInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.da
    public du a() {
        return new ax(this.f266702a.getIdentityInstruction());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.da
    public String getClientId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.W0(this.f266702a.getClientId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.da
    public String getClientName() {
        return this.f266702a.getClientName();
    }

    @NotNull
    public String toString() {
        return "ClientIdInfo{clientInfo=" + this.f266702a + "}";
    }
}
