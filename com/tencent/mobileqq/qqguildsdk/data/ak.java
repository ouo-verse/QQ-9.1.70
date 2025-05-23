package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProArea;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ak implements db {

    /* renamed from: a, reason: collision with root package name */
    private final GProArea f265679a;

    public ak(GProArea gProArea) {
        this.f265679a = gProArea;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.db
    public String getDesc() {
        return this.f265679a.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.db
    public String getId() {
        return this.f265679a.getAreaId();
    }
}
