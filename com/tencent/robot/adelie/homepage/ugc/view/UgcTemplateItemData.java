package com.tencent.robot.adelie.homepage.ugc.view;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/z;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "a", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Z", "()Z", "c", "(Z)V", "hasReportImp", "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.ugc.view.z, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class UgcTemplateItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MetaMaterial material;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasReportImp;

    public UgcTemplateItemData() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasReportImp() {
        return this.hasReportImp;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final MetaMaterial getMaterial() {
        return this.material;
    }

    public final void c(boolean z16) {
        this.hasReportImp = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UgcTemplateItemData)) {
            return false;
        }
        UgcTemplateItemData ugcTemplateItemData = (UgcTemplateItemData) other;
        if (Intrinsics.areEqual(this.material, ugcTemplateItemData.material) && this.hasReportImp == ugcTemplateItemData.hasReportImp) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.material.hashCode() * 31;
        boolean z16 = this.hasReportImp;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "UgcTemplateItemData(material=" + this.material + ", hasReportImp=" + this.hasReportImp + ")";
    }

    public UgcTemplateItemData(@NotNull MetaMaterial material, boolean z16) {
        Intrinsics.checkNotNullParameter(material, "material");
        this.material = material;
        this.hasReportImp = z16;
    }

    public /* synthetic */ UgcTemplateItemData(MetaMaterial metaMaterial, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new MetaMaterial() : metaMaterial, (i3 & 2) != 0 ? false : z16);
    }
}
