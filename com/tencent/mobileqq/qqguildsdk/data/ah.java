package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGameModesResult;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ah implements dq {

    /* renamed from: a, reason: collision with root package name */
    public final GProGameModesResult f265672a;

    public ah(GProGameModesResult gProGameModesResult) {
        this.f265672a = gProGameModesResult;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dq
    public String getId() {
        return this.f265672a.getId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dq
    public String getImage() {
        return this.f265672a.getImage();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dq
    public String getName() {
        return this.f265672a.getName();
    }
}
