package com.tencent.mobileqq.qqlive.widget.chat.util.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001f\u0018\u00002\u00020\u0001BY\b\u0016\u0012\u0006\u00100\u001a\u00020\u0015\u0012\u0006\u00101\u001a\u00020\u0015\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010/\u001a\u00020\u000e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010'\u001a\u00020\u000e\u0012\u0006\u0010$\u001a\u00020\u0015\u00a2\u0006\u0004\b2\u00103J&\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0016R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001bR\u0016\u0010+\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001eR\u0018\u0010-\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010!R\u0016\u0010/\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010&\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/util/drawable/b;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Paint;", "", NodeProps.COLORS, "", "position", "Landroid/graphics/RectF;", "drawRectF", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "", UserInfo.SEX_FEMALE, "radiusF", "b", "multiRadiusF", "c", "Landroid/graphics/Paint;", "borderPaint", "d", "[I", "borderColors", "e", "[F", "borderPosition", "f", NodeProps.BORDER_WIDTH, "g", "I", "borderOrientation", h.F, "fillPaint", "i", "fillColors", "j", "fillPosition", "k", "fillOrientation", "radius", "multiRadius", "<init>", "(FF[I[FI[I[FIF)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float radiusF;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float multiRadiusF;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint borderPaint;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] borderColors;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private float[] borderPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float borderWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int borderOrientation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint fillPaint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] fillColors;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private float[] fillPosition;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int fillOrientation;

    public b(float f16, float f17, @Nullable int[] iArr, @Nullable float[] fArr, int i3, @Nullable int[] iArr2, @Nullable float[] fArr2, int i16, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), iArr, fArr, Integer.valueOf(i3), iArr2, fArr2, Integer.valueOf(i16), Float.valueOf(f18));
            return;
        }
        Paint paint = new Paint(5);
        this.borderPaint = paint;
        this.borderColors = new int[0];
        this.borderOrientation = GradientDrawable.Orientation.LEFT_RIGHT.ordinal();
        Paint paint2 = new Paint(5);
        this.fillPaint = paint2;
        this.fillColors = new int[0];
        this.fillOrientation = GradientDrawable.Orientation.LEFT_RIGHT.ordinal();
        this.radiusF = f16;
        this.multiRadiusF = f17;
        this.fillColors = iArr == null ? this.fillColors : iArr;
        this.fillPosition = fArr;
        this.fillOrientation = i3;
        this.borderColors = iArr2 == null ? this.borderColors : iArr2;
        this.borderPosition = fArr2;
        this.borderOrientation = i16;
        this.borderWidth = f18;
        paint.setStrokeWidth(f18);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
    }

    private final void a(Paint paint, int[] iArr, float[] fArr, RectF rectF) {
        int first;
        if (iArr.length == 1) {
            first = ArraysKt___ArraysKt.first(iArr);
            paint.setColor(first);
            paint.setShader(null);
        } else if (iArr.length > 1) {
            try {
                float height = rectF.height() / 2;
                paint.setShader(new LinearGradient(rectF.left, height, rectF.right, height, iArr, fArr, Shader.TileMode.CLAMP));
            } catch (Exception unused) {
                paint.setColor(-1);
                paint.setShader(null);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        boolean z16;
        float height;
        float height2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        boolean z17 = false;
        if (this.fillColors.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            float f16 = this.borderWidth;
            RectF rectF = new RectF(f16, f16, canvas.getWidth() - f16, canvas.getHeight() - f16);
            float f17 = 2;
            if (canvas.getHeight() > this.radiusF * f17) {
                height2 = this.multiRadiusF;
            } else {
                height2 = canvas.getHeight() / f17;
            }
            a(this.fillPaint, this.fillColors, this.fillPosition, rectF);
            canvas.drawRoundRect(rectF, height2, height2, this.fillPaint);
        }
        if (this.borderColors.length == 0) {
            z17 = true;
        }
        if (!z17) {
            float f18 = 2;
            float f19 = this.borderWidth / f18;
            RectF rectF2 = new RectF(f19, f19, canvas.getWidth() - f19, canvas.getHeight() - f19);
            if (canvas.getHeight() > this.radiusF * f18) {
                height = this.multiRadiusF;
            } else {
                height = canvas.getHeight() / f18;
            }
            a(this.borderPaint, this.borderColors, this.borderPosition, rectF2);
            canvas.drawRoundRect(rectF2, height, height, this.borderPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) colorFilter);
        }
    }
}
