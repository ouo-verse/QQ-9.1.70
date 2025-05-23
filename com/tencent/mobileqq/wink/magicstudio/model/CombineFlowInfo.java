package com.tencent.mobileqq.wink.magicstudio.model;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\n\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "a", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "c", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "b", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "()Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "generateInfo", "I", "()I", "count", "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lcom/tencent/mobileqq/wink/magicstudio/model/c;I)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicstudio.model.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class CombineFlowInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MetaMaterial material;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GenerateInfo generateInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int count;

    public CombineFlowInfo(@NotNull MetaMaterial material, @NotNull GenerateInfo generateInfo, int i3) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(generateInfo, "generateInfo");
        this.material = material;
        this.generateInfo = generateInfo;
        this.count = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final GenerateInfo getGenerateInfo() {
        return this.generateInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MetaMaterial getMaterial() {
        return this.material;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CombineFlowInfo)) {
            return false;
        }
        CombineFlowInfo combineFlowInfo = (CombineFlowInfo) other;
        if (Intrinsics.areEqual(this.material, combineFlowInfo.material) && Intrinsics.areEqual(this.generateInfo, combineFlowInfo.generateInfo) && this.count == combineFlowInfo.count) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.material.hashCode() * 31) + this.generateInfo.hashCode()) * 31) + this.count;
    }

    @NotNull
    public String toString() {
        return "CombineFlowInfo(material=" + this.material + ", generateInfo=" + this.generateInfo + ", count=" + this.count + ")";
    }
}
