package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientShowCfg;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class aa implements dk {

    /* renamed from: a, reason: collision with root package name */
    private final GProClientShowCfg f265655a;

    public aa(GProClientShowCfg gProClientShowCfg) {
        this.f265655a = gProClientShowCfg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dk
    public List<dn> a() {
        return com.tencent.mobileqq.qqguildsdk.util.g.A0(this.f265655a.getConfigItem());
    }

    @NotNull
    public String toString() {
        return "GProClientShowCfgInfo{clientShowCfg=" + this.f265655a + "}";
    }
}
