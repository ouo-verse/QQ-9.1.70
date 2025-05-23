package com.tencent.mobileqq.zplan.aigc.render;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\bH\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/ModelStyle;", "", "styleName", "", "editTextures", "", "Lcom/tencent/mobileqq/zplan/aigc/render/EditTexture;", "avatarRotation", "", "(Ljava/lang/String;Ljava/util/List;D)V", "getAvatarRotation", "()D", "getEditTextures", "()Ljava/util/List;", "getStyleName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ModelStyle {
    private final double avatarRotation;
    private final List<EditTexture> editTextures;
    private final String styleName;

    public ModelStyle(String styleName, List<EditTexture> editTextures, double d16) {
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        Intrinsics.checkNotNullParameter(editTextures, "editTextures");
        this.styleName = styleName;
        this.editTextures = editTextures;
        this.avatarRotation = d16;
    }

    /* renamed from: component1, reason: from getter */
    public final String getStyleName() {
        return this.styleName;
    }

    public final List<EditTexture> component2() {
        return this.editTextures;
    }

    /* renamed from: component3, reason: from getter */
    public final double getAvatarRotation() {
        return this.avatarRotation;
    }

    public final ModelStyle copy(String styleName, List<EditTexture> editTextures, double avatarRotation) {
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        Intrinsics.checkNotNullParameter(editTextures, "editTextures");
        return new ModelStyle(styleName, editTextures, avatarRotation);
    }

    public final double getAvatarRotation() {
        return this.avatarRotation;
    }

    public final List<EditTexture> getEditTextures() {
        return this.editTextures;
    }

    public final String getStyleName() {
        return this.styleName;
    }

    public int hashCode() {
        return (((this.styleName.hashCode() * 31) + this.editTextures.hashCode()) * 31) + com.tencent.mobileqq.zootopia.webview.f.a(this.avatarRotation);
    }

    public String toString() {
        return "ModelStyle(styleName=" + this.styleName + ", editTextures=" + this.editTextures + ", avatarRotation=" + this.avatarRotation + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelStyle copy$default(ModelStyle modelStyle, String str, List list, double d16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = modelStyle.styleName;
        }
        if ((i3 & 2) != 0) {
            list = modelStyle.editTextures;
        }
        if ((i3 & 4) != 0) {
            d16 = modelStyle.avatarRotation;
        }
        return modelStyle.copy(str, list, d16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStyle)) {
            return false;
        }
        ModelStyle modelStyle = (ModelStyle) other;
        return Intrinsics.areEqual(this.styleName, modelStyle.styleName) && Intrinsics.areEqual(this.editTextures, modelStyle.editTextures) && Double.compare(this.avatarRotation, modelStyle.avatarRotation) == 0;
    }
}
