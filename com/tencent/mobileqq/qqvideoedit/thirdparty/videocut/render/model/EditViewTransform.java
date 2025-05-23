package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.model;

import android.graphics.PointF;
import android.util.Size;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b)\u0010*JE\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b\u001e\u0010!\"\u0004\b'\u0010#R\"\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b(\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/model/a;", "", "Landroid/graphics/PointF;", "position", "Landroid/util/Size;", "size", "", "scale", BasicAnimation.KeyPath.ROTATION, "anchorX", "anchorY", "a", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/PointF;", "e", "()Landroid/graphics/PointF;", "k", "(Landroid/graphics/PointF;)V", "b", "Landroid/util/Size;", h.F, "()Landroid/util/Size;", DomainData.DOMAIN_NAME, "(Landroid/util/Size;)V", "c", UserInfo.SEX_FEMALE, "g", "()F", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(F)V", "d", "f", "l", "i", "j", "<init>", "(Landroid/graphics/PointF;Landroid/util/Size;FFFF)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.model.a, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class EditViewTransform {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private PointF position;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private Size size;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private float scale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private float rotation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private float anchorX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private float anchorY;

    public EditViewTransform() {
        this(null, null, 0.0f, 0.0f, 0.0f, 0.0f, 63, null);
    }

    public static /* synthetic */ EditViewTransform b(EditViewTransform editViewTransform, PointF pointF, Size size, float f16, float f17, float f18, float f19, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            pointF = editViewTransform.position;
        }
        if ((i3 & 2) != 0) {
            size = editViewTransform.size;
        }
        Size size2 = size;
        if ((i3 & 4) != 0) {
            f16 = editViewTransform.scale;
        }
        float f26 = f16;
        if ((i3 & 8) != 0) {
            f17 = editViewTransform.rotation;
        }
        float f27 = f17;
        if ((i3 & 16) != 0) {
            f18 = editViewTransform.anchorX;
        }
        float f28 = f18;
        if ((i3 & 32) != 0) {
            f19 = editViewTransform.anchorY;
        }
        return editViewTransform.a(pointF, size2, f26, f27, f28, f19);
    }

    @NotNull
    public final EditViewTransform a(@NotNull PointF position, @NotNull Size size, float scale, float rotation, float anchorX, float anchorY) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(size, "size");
        return new EditViewTransform(position, size, scale, rotation, anchorX, anchorY);
    }

    /* renamed from: c, reason: from getter */
    public final float getAnchorX() {
        return this.anchorX;
    }

    /* renamed from: d, reason: from getter */
    public final float getAnchorY() {
        return this.anchorY;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final PointF getPosition() {
        return this.position;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditViewTransform)) {
            return false;
        }
        EditViewTransform editViewTransform = (EditViewTransform) other;
        if (Intrinsics.areEqual(this.position, editViewTransform.position) && Intrinsics.areEqual(this.size, editViewTransform.size) && Float.compare(this.scale, editViewTransform.scale) == 0 && Float.compare(this.rotation, editViewTransform.rotation) == 0 && Float.compare(this.anchorX, editViewTransform.anchorX) == 0 && Float.compare(this.anchorY, editViewTransform.anchorY) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final float getRotation() {
        return this.rotation;
    }

    /* renamed from: g, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((((((((this.position.hashCode() * 31) + this.size.hashCode()) * 31) + Float.floatToIntBits(this.scale)) * 31) + Float.floatToIntBits(this.rotation)) * 31) + Float.floatToIntBits(this.anchorX)) * 31) + Float.floatToIntBits(this.anchorY);
    }

    public final void i(float f16) {
        this.anchorX = f16;
    }

    public final void j(float f16) {
        this.anchorY = f16;
    }

    public final void k(@NotNull PointF pointF) {
        Intrinsics.checkNotNullParameter(pointF, "<set-?>");
        this.position = pointF;
    }

    public final void l(float f16) {
        this.rotation = f16;
    }

    public final void m(float f16) {
        this.scale = f16;
    }

    public final void n(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.size = size;
    }

    @NotNull
    public String toString() {
        return "EditViewTransform(position=" + this.position + ", size=" + this.size + ", scale=" + this.scale + ", rotation=" + this.rotation + ", anchorX=" + this.anchorX + ", anchorY=" + this.anchorY + ")";
    }

    public EditViewTransform(@NotNull PointF position, @NotNull Size size, float f16, float f17, float f18, float f19) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(size, "size");
        this.position = position;
        this.size = size;
        this.scale = f16;
        this.rotation = f17;
        this.anchorX = f18;
        this.anchorY = f19;
    }

    public /* synthetic */ EditViewTransform(PointF pointF, Size size, float f16, float f17, float f18, float f19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new PointF() : pointF, (i3 & 2) != 0 ? new Size(0, 0) : size, (i3 & 4) != 0 ? 1.0f : f16, (i3 & 8) != 0 ? 0.0f : f17, (i3 & 16) != 0 ? 0.0f : f18, (i3 & 32) != 0 ? 0.0f : f19);
    }
}
