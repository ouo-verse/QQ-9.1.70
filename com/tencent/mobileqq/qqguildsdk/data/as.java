package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelAdminInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class as implements dh {

    /* renamed from: a, reason: collision with root package name */
    private final GProChannelAdminInfo f265689a;

    public as(GProChannelAdminInfo gProChannelAdminInfo) {
        this.f265689a = gProChannelAdminInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dh
    public int a() {
        return (int) this.f265689a.getChannelAdminNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dh
    public String getChannelId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.f265689a.getChannelId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dh
    public String getChannelName() {
        return this.f265689a.getChannelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dh
    public int getChannelType() {
        return this.f265689a.getChannelType();
    }
}
