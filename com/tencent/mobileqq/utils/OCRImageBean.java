package com.tencent.mobileqq.utils;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/utils/bz;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Rect;", "a", "Landroid/graphics/Rect;", "b", "()Landroid/graphics/Rect;", "position", "Ljava/lang/String;", "()Ljava/lang/String;", "desc", "c", "Z", "()Z", "isSelected", "<init>", "(Landroid/graphics/Rect;Ljava/lang/String;Z)V", "qqocr-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.utils.bz, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class OCRImageBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Rect position;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSelected;

    public OCRImageBean(@NotNull Rect position, @NotNull String desc, boolean z16) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.position = position;
        this.desc = desc;
        this.isSelected = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Rect getPosition() {
        return this.position;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OCRImageBean)) {
            return false;
        }
        OCRImageBean oCRImageBean = (OCRImageBean) other;
        if (Intrinsics.areEqual(this.position, oCRImageBean.position) && Intrinsics.areEqual(this.desc, oCRImageBean.desc) && this.isSelected == oCRImageBean.isSelected) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.position.hashCode() * 31) + this.desc.hashCode()) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "OCRImageBean(position=" + this.position + ", desc=" + this.desc + ", isSelected=" + this.isSelected + ')';
    }
}
