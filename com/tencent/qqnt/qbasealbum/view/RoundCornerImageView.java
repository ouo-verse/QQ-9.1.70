package com.tencent.qqnt.qbasealbum.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0019\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/RoundCornerImageView;", "Lcom/tencent/image/URLImageView;", "", "px", "", "setCorner", "", "flag", "setBorder", "color", "setColor", NodeProps.BORDER_WIDTH, "setBorderWidth", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Landroid/graphics/Path;", "d", "Landroid/graphics/Path;", "mPath", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "mPaint", "f", "I", "mColor", h.F, "mBorderWidth", "i", "Z", "isDrawBorder", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "corner", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RoundCornerImageView extends URLImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Path mPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mBorderWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isDrawBorder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int corner;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundCornerImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mPath.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + width, getPaddingTop() + ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        int i3 = this.corner;
        if (i3 <= 0) {
            i3 = width / 30;
        }
        float f16 = i3;
        this.mPath.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
        if (this.isDrawBorder) {
            this.mPaint.setColor(this.mColor);
            int i16 = this.mBorderWidth;
            if (i16 != 0) {
                this.mPaint.setStrokeWidth(i16);
            }
            this.mPath.reset();
            this.mPath.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
            canvas.drawRoundRect(rectF, f16, f16, this.mPaint);
        }
    }

    public final void setBorder(boolean flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, flag);
        } else {
            this.isDrawBorder = flag;
        }
    }

    public final void setBorderWidth(int borderWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, borderWidth);
        } else {
            this.mBorderWidth = borderWidth;
        }
    }

    public final void setColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, color);
        } else {
            this.mColor = color;
        }
    }

    public final void setCorner(int px5) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, px5);
            return;
        }
        if (px5 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.corner = px5;
            return;
        }
        throw new IllegalArgumentException("should not be less than 0".toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundCornerImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ RoundCornerImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundCornerImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        int parseColor = Color.parseColor("#FFD5D5D5");
        this.mColor = parseColor;
        paint.setColor(parseColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        super.setLayerType(2, null);
    }
}
