package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProConfigItem;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ac implements dn {

    /* renamed from: a, reason: collision with root package name */
    private final GProConfigItem f265657a;

    public ac(GProConfigItem gProConfigItem) {
        this.f265657a = gProConfigItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dn
    public int a() {
        return this.f265657a.getConfigStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dn
    public int b() {
        return this.f265657a.getConfigID();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dn
    public String getDesc() {
        return this.f265657a.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dn
    public String getJumpUrl() {
        return this.f265657a.getJumpUrl();
    }

    @NotNull
    public String toString() {
        return "GProConfigItemInfo{configItem=" + this.f265657a + "}";
    }
}
