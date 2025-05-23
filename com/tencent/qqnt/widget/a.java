package com.tencent.qqnt.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/widget/a;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "", "a", "[F", "cornerRadii", "", "b", "[I", "gradientColors", "c", "I", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", "path", "Landroid/graphics/Shader;", "f", "Landroid/graphics/Shader;", "shader", "Landroid/graphics/Region;", "g", "Landroid/graphics/Region;", "regionInner", h.F, "regionOut", "i", "diffRegion", "<init>", "([F[II)V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] cornerRadii;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] gradientColors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int defaultColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Shader shader;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Region regionInner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Region regionOut;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Region diffRegion;

    public a(@NotNull float[] cornerRadii, @NotNull int[] gradientColors, int i3) {
        Intrinsics.checkNotNullParameter(cornerRadii, "cornerRadii");
        Intrinsics.checkNotNullParameter(gradientColors, "gradientColors");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cornerRadii, gradientColors, Integer.valueOf(i3));
            return;
        }
        this.cornerRadii = cornerRadii;
        this.gradientColors = gradientColors;
        this.defaultColor = i3;
        this.paint = new Paint(1);
        this.path = new Path();
        this.regionInner = new Region();
        this.regionOut = new Region();
        this.diffRegion = new Region();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        RectF rectF = new RectF(bounds);
        int[] iArr = this.gradientColors;
        if (iArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.paint.setColor(0);
            this.paint.setShader(null);
        } else if (iArr.length == 1) {
            this.paint.setColor(iArr[0]);
            this.paint.setShader(null);
        } else {
            Shader shader = this.shader;
            if (shader == null) {
                shader = new LinearGradient(0.0f, 0.0f, 0.0f, rectF.bottom, this.gradientColors, (float[]) null, Shader.TileMode.CLAMP);
            }
            this.paint.setShader(shader);
        }
        this.path.reset();
        this.path.addRoundRect(rectF, this.cornerRadii, Path.Direction.CW);
        canvas.drawPath(this.path, this.paint);
        if (this.defaultColor != 0) {
            this.regionInner.set(0, 0, (int) rectF.width(), (int) rectF.height());
            this.regionOut.set(0, 0, (int) rectF.width(), (int) rectF.height());
            this.diffRegion.setPath(this.path, this.regionOut);
            this.regionInner.op(this.diffRegion, Region.Op.DIFFERENCE);
            this.paint.setShader(null);
            this.paint.setColor(this.defaultColor);
            canvas.drawPath(this.regionInner.getBoundaryPath(), this.paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, alpha);
        } else {
            this.paint.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) colorFilter);
        } else {
            this.paint.setColorFilter(colorFilter);
        }
    }
}
