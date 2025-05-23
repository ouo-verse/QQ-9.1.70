package com.tencent.aelight.camera.ae.camera.ui.panel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/ap;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;", "a", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;", "getPrimaryConfig", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;", "primaryConfig", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;", "b", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;", "secondaryConfig", "c", "I", "getIndex", "()I", "index", "<init>", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;I)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.aelight.camera.ae.camera.ui.panel.ap, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class BeautySecondarySelectedWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final b primaryConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final f secondaryConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    public BeautySecondarySelectedWrapper(b primaryConfig, f secondaryConfig, int i3) {
        Intrinsics.checkNotNullParameter(primaryConfig, "primaryConfig");
        Intrinsics.checkNotNullParameter(secondaryConfig, "secondaryConfig");
        this.primaryConfig = primaryConfig;
        this.secondaryConfig = secondaryConfig;
        this.index = i3;
    }

    /* renamed from: a, reason: from getter */
    public final f getSecondaryConfig() {
        return this.secondaryConfig;
    }

    public int hashCode() {
        return (((this.primaryConfig.hashCode() * 31) + this.secondaryConfig.hashCode()) * 31) + this.index;
    }

    public String toString() {
        return "BeautySecondarySelectedWrapper(primaryConfig=" + this.primaryConfig + ", secondaryConfig=" + this.secondaryConfig + ", index=" + this.index + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BeautySecondarySelectedWrapper)) {
            return false;
        }
        BeautySecondarySelectedWrapper beautySecondarySelectedWrapper = (BeautySecondarySelectedWrapper) other;
        return Intrinsics.areEqual(this.primaryConfig, beautySecondarySelectedWrapper.primaryConfig) && Intrinsics.areEqual(this.secondaryConfig, beautySecondarySelectedWrapper.secondaryConfig) && this.index == beautySecondarySelectedWrapper.index;
    }
}
