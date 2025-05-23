package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProInviteInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cl implements ez {

    /* renamed from: a, reason: collision with root package name */
    private GProInviteInfo f265874a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.qqnt.kernelgpro.nativeinterface.GProBusinessData f265875b;

    public cl(GProInviteInfo gProInviteInfo) {
        this.f265874a = gProInviteInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ez
    public String E() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.f265874a.getChnId());
    }

    public byte[] a() {
        com.tencent.qqnt.kernelgpro.nativeinterface.GProBusinessData gProBusinessData = this.f265875b;
        if (gProBusinessData != null) {
            return gProBusinessData.getBusinessParam();
        }
        return null;
    }

    public int b() {
        com.tencent.qqnt.kernelgpro.nativeinterface.GProBusinessData gProBusinessData = this.f265875b;
        if (gProBusinessData != null) {
            return gProBusinessData.getBusinessType();
        }
        return 0;
    }

    public void c(com.tencent.qqnt.kernelgpro.nativeinterface.GProBusinessData gProBusinessData) {
        this.f265875b = gProBusinessData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ez
    public String getGuildID() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.f265874a.getGuildId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ez
    public String getGuildName() {
        return this.f265874a.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ez
    public String getJoinSig() {
        return this.f265874a.getJoinSig();
    }

    @NonNull
    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GuildInviteInfo{inviteInfo:");
        sb5.append(this.f265874a);
        sb5.append(" businessType:");
        sb5.append(b());
        sb5.append(" businessParam length:");
        if (a() == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(a().length);
        }
        sb5.append(valueOf);
        sb5.append("}");
        return sb5.toString();
    }
}
