package com.tencent.mobileqq.wink.picker;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "a", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "c", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "templateLibraryMaterial", "b", "Z", "()Z", "needFaceDetection", "I", "d", "()I", "toReplacedMediaIndex", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "originalScriptParams", "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;ZI)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.picker.d, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class TemplateLibraryData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MetaMaterial templateLibraryMaterial;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needFaceDetection;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int toReplacedMediaIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String originalScriptParams;

    public TemplateLibraryData(@NotNull MetaMaterial templateLibraryMaterial, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(templateLibraryMaterial, "templateLibraryMaterial");
        this.templateLibraryMaterial = templateLibraryMaterial;
        this.needFaceDetection = z16;
        this.toReplacedMediaIndex = i3;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getNeedFaceDetection() {
        return this.needFaceDetection;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getOriginalScriptParams() {
        return this.originalScriptParams;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MetaMaterial getTemplateLibraryMaterial() {
        return this.templateLibraryMaterial;
    }

    /* renamed from: d, reason: from getter */
    public final int getToReplacedMediaIndex() {
        return this.toReplacedMediaIndex;
    }

    public final void e(@Nullable String str) {
        this.originalScriptParams = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateLibraryData)) {
            return false;
        }
        TemplateLibraryData templateLibraryData = (TemplateLibraryData) other;
        if (Intrinsics.areEqual(this.templateLibraryMaterial, templateLibraryData.templateLibraryMaterial) && this.needFaceDetection == templateLibraryData.needFaceDetection && this.toReplacedMediaIndex == templateLibraryData.toReplacedMediaIndex) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.templateLibraryMaterial.hashCode() * 31;
        boolean z16 = this.needFaceDetection;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.toReplacedMediaIndex;
    }

    @NotNull
    public String toString() {
        return "TemplateLibraryData(templateLibraryMaterial=" + this.templateLibraryMaterial + ", needFaceDetection=" + this.needFaceDetection + ", toReplacedMediaIndex=" + this.toReplacedMediaIndex + ")";
    }
}
