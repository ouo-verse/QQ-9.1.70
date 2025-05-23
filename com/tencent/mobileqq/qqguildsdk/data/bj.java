package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProPopupConfig;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bj implements dy {

    /* renamed from: a, reason: collision with root package name */
    private final GProPopupConfig f265760a;

    public bj(GProPopupConfig gProPopupConfig) {
        this.f265760a = gProPopupConfig;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dy
    public String a() {
        return this.f265760a.getWording1();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dy
    public String b() {
        return this.f265760a.getWording2();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dy
    public String getPicUrl() {
        return this.f265760a.getPicUrl();
    }

    @NotNull
    public String toString() {
        return "GProPopupConfigInfo{popupConfig : " + this.f265760a + "}";
    }
}
