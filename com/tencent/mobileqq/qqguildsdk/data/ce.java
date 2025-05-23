package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedal;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ce implements eu {

    /* renamed from: a, reason: collision with root package name */
    private final GProMedal f265812a;

    public ce(GProMedal gProMedal) {
        this.f265812a = gProMedal;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.eu
    public String getDesc() {
        return this.f265812a.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.eu
    public String getUrl() {
        return this.f265812a.getUrl();
    }

    @NotNull
    public String toString() {
        return "GProMedal{medal=" + this.f265812a + "}";
    }
}
