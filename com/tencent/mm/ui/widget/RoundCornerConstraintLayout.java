package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.luggage.wxa.lo.r;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001&B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\"\u0010#B\u001b\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\"\u0010$B#\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0019\u001a\u00020\f\u00a2\u0006\u0004\b\"\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J0\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0014J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\"\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mm/ui/widget/RoundCornerConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "radius", "", "setRadius", "topLeft", "topRight", "bottomLeft", "bottomRight", "", "changed", "", "left", "top", "right", "bottom", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "a", "Lcom/tencent/mm/ui/widget/RoundCornerConstraintLayout$CornerRadius;", "Lcom/tencent/mm/ui/widget/RoundCornerConstraintLayout$CornerRadius;", "cornerRadius", "Landroid/graphics/Path;", "b", "Landroid/graphics/Path;", "path", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CornerRadius", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class RoundCornerConstraintLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public CornerRadius cornerRadius;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Path path;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u0002\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mm/ui/widget/RoundCornerConstraintLayout$CornerRadius;", "", "", "a", UserInfo.SEX_FEMALE, "getTopLeft", "()F", "setTopLeft", "(F)V", "topLeft", "b", "getTopRight", "setTopRight", "topRight", "c", "getBottomLeft", "setBottomLeft", "bottomLeft", "d", "getBottomRight", "setBottomRight", "bottomRight", "<init>", "(FFFF)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class CornerRadius {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public float topLeft;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public float topRight;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public float bottomLeft;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public float bottomRight;

        public CornerRadius(float f16, float f17, float f18, float f19) {
            this.topLeft = f16;
            this.topRight = f17;
            this.bottomLeft = f18;
            this.bottomRight = f19;
        }

        public final float getBottomLeft() {
            return this.bottomLeft;
        }

        public final float getBottomRight() {
            return this.bottomRight;
        }

        public final float getTopLeft() {
            return this.topLeft;
        }

        public final float getTopRight() {
            return this.topRight;
        }

        public final void setBottomLeft(float f16) {
            this.bottomLeft = f16;
        }

        public final void setBottomRight(float f16) {
            this.bottomRight = f16;
        }

        public final void setTopLeft(float f16) {
            this.topLeft = f16;
        }

        public final void setTopRight(float f16) {
            this.topRight = f16;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerConstraintLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        a(context, null, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int defStyle) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomCorner, defStyle, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026ustomCorner, defStyle, 0)");
        float dimension = obtainStyledAttributes.getDimension(R.styleable.CustomCorner_cornerRadius, 0.0f);
        this.cornerRadius = new CornerRadius(dimension, dimension, dimension, dimension);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.path.isEmpty()) {
            a();
        }
        int save = canvas.save();
        canvas.clipPath(this.path);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        a();
    }

    public final void setRadius(float radius) {
        setRadius(radius, radius, radius, radius);
    }

    public final void setRadius(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        CornerRadius cornerRadius = this.cornerRadius;
        Intrinsics.checkNotNull(cornerRadius);
        cornerRadius.setTopLeft(topLeft);
        CornerRadius cornerRadius2 = this.cornerRadius;
        Intrinsics.checkNotNull(cornerRadius2);
        cornerRadius2.setTopRight(topRight);
        CornerRadius cornerRadius3 = this.cornerRadius;
        Intrinsics.checkNotNull(cornerRadius3);
        cornerRadius3.setBottomLeft(bottomLeft);
        CornerRadius cornerRadius4 = this.cornerRadius;
        Intrinsics.checkNotNull(cornerRadius4);
        cornerRadius4.setBottomRight(bottomRight);
        a();
        postInvalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        a(context, attributeSet, 0);
    }

    public final void a() {
        CornerRadius cornerRadius;
        if (getWidth() <= 0 || getHeight() <= 0 || (cornerRadius = this.cornerRadius) == null) {
            return;
        }
        this.path.reset();
        this.path.addPath(r.a(new RectF(0.0f, 0.0f, getWidth(), getHeight()), cornerRadius.getTopLeft(), cornerRadius.getTopRight(), cornerRadius.getBottomRight(), cornerRadius.getBottomLeft(), 0.6f));
        this.path.close();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundCornerConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        a(context, attributeSet, i3);
    }
}
