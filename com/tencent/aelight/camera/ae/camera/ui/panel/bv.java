package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/bv;", "", "", "a", "Z", "b", "()Z", "show", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "()Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "locateMaterial", "<init>", "(ZLcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class bv {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean show;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AEMaterialMetaData locateMaterial;

    public bv(boolean z16, AEMaterialMetaData aEMaterialMetaData) {
        this.show = z16;
        this.locateMaterial = aEMaterialMetaData;
    }

    /* renamed from: a, reason: from getter */
    public final AEMaterialMetaData getLocateMaterial() {
        return this.locateMaterial;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    public /* synthetic */ bv(boolean z16, AEMaterialMetaData aEMaterialMetaData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? null : aEMaterialMetaData);
    }
}
