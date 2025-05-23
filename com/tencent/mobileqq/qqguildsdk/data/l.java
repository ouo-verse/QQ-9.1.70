package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAuthControlStatus;

/* compiled from: P */
/* loaded from: classes17.dex */
public class l implements df {

    /* renamed from: a, reason: collision with root package name */
    private GProAuthControlStatus f266728a;

    public l(GProAuthControlStatus gProAuthControlStatus) {
        this.f266728a = gProAuthControlStatus;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.df
    public int getAuthControlKey() {
        return this.f266728a.getAuthControlKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.df
    public int getAuthControlValue() {
        return this.f266728a.getAuthControlValue();
    }
}
