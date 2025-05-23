package com.tencent.now.pkgame.pkgame.scorebar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/tencent/now/pkgame/pkgame/scorebar/view/RoundCornerImageView;", "Lcom/tencent/image/URLImageView;", "", "radius", "", "showRoundCorner", "c", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "Landroid/graphics/Path;", "d", "Landroid/graphics/Path;", "mPath", "e", "Z", "mTopLeft", "f", "mTopRight", h.F, "mBottomLeft", "i", "mBottomRight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class RoundCornerImageView extends URLImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path mPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mTopLeft;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mTopRight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mBottomLeft;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mBottomRight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundCornerImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final float c(float radius, boolean showRoundCorner) {
        if (!showRoundCorner) {
            return 0.0f;
        }
        return radius;
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mPath.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + width, getPaddingTop() + height);
        float f16 = (height / 2) * 1.0f;
        this.mPath.addRoundRect(rectF, new float[]{c(f16, this.mTopLeft), c(f16, this.mTopLeft), c(f16, this.mTopRight), c(f16, this.mTopRight), c(f16, this.mBottomRight), c(f16, this.mBottomRight), c(f16, this.mBottomLeft), c(f16, this.mBottomLeft)}, Path.Direction.CCW);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundCornerImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RoundCornerImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundCornerImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPath = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.now.pkgame.c.V4);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026ble.RoundCornerImageView)");
        this.mTopLeft = obtainStyledAttributes.getBoolean(com.tencent.now.pkgame.c.Y4, false);
        this.mTopRight = obtainStyledAttributes.getBoolean(com.tencent.now.pkgame.c.Z4, false);
        this.mBottomLeft = obtainStyledAttributes.getBoolean(com.tencent.now.pkgame.c.W4, false);
        this.mBottomRight = obtainStyledAttributes.getBoolean(com.tencent.now.pkgame.c.X4, false);
        obtainStyledAttributes.recycle();
        super.setLayerType(2, null);
    }
}
