package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFaceAuthInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class n implements Cdo {

    /* renamed from: a, reason: collision with root package name */
    public final GProFaceAuthInfo f266730a;

    public n(GProFaceAuthInfo gProFaceAuthInfo) {
        this.f266730a = gProFaceAuthInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.Cdo
    public int a() {
        return this.f266730a.getFaceAuthStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.Cdo
    public String getVerifyUrl() {
        return this.f266730a.getVerifyUrl();
    }
}
