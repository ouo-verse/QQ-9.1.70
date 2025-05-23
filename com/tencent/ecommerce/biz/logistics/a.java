package com.tencent.ecommerce.biz.logistics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\"\u0010(\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 \"\u0004\b\u0014\u0010'R\"\u0010+\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001e\u001a\u0004\b*\u0010 \"\u0004\b\u0010\u0010'R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/a;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "getIntrinsicWidth", "getIntrinsicHeight", "Landroid/graphics/Path;", "a", "Landroid/graphics/Path;", "path", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "paint", "", "c", UserInfo.SEX_FEMALE, "getRadius", "()F", "radius", "d", "I", "getArrowWidth", "()I", "arrowWidth", "e", "getArrowHeight", "arrowHeight", "f", "getStartColor", "(I)V", "startColor", "g", "getEndColor", "endColor", "Landroid/graphics/RectF;", tl.h.F, "Landroid/graphics/RectF;", CanvasView.ACTION_RECT, "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends Drawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Path path = new Path();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Paint paint = new Paint(1);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float radius = com.tencent.ecommerce.biz.util.e.c(8.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int arrowWidth = com.tencent.ecommerce.biz.util.e.c(11.0f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int arrowHeight = com.tencent.ecommerce.biz.util.e.c(3.0f);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int startColor = Color.parseColor("#FF46A0");

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int endColor = Color.parseColor("#FF3355");

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final RectF rect = new RectF();

    public final void a(int i3) {
        this.endColor = i3;
    }

    public final void b(int i3) {
        this.startColor = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float coerceAtMost;
        this.rect.set(getBounds());
        RectF rectF = this.rect;
        float f16 = rectF.right;
        float f17 = rectF.left;
        float f18 = ((f16 - f17) / 2) - (this.arrowWidth / 2);
        Path path = this.path;
        path.moveTo(f17 + this.radius, rectF.top);
        path.lineTo(this.rect.width() - this.radius, this.rect.top);
        RectF rectF2 = this.rect;
        float f19 = rectF2.right;
        float f26 = this.radius;
        float f27 = rectF2.top;
        path.arcTo(new RectF(f19 - f26, f27, f19, f26 + f27), 270.0f, 90.0f);
        RectF rectF3 = this.rect;
        path.lineTo(rectF3.right, (rectF3.bottom - this.arrowHeight) - this.radius);
        RectF rectF4 = this.rect;
        float f28 = rectF4.right;
        float f29 = this.radius;
        float f36 = rectF4.bottom;
        int i3 = this.arrowHeight;
        path.arcTo(new RectF(f28 - f29, (f36 - f29) - i3, f28, f36 - i3), 0.0f, 90.0f);
        RectF rectF5 = this.rect;
        path.lineTo(rectF5.left + this.arrowWidth + f18, rectF5.bottom - this.arrowHeight);
        Path path2 = this.path;
        RectF rectF6 = this.rect;
        path2.lineTo(rectF6.left + f18 + (this.arrowWidth / 2), rectF6.bottom);
        Path path3 = this.path;
        RectF rectF7 = this.rect;
        path3.lineTo(rectF7.left + f18, rectF7.bottom - this.arrowHeight);
        Path path4 = this.path;
        float f37 = this.rect.left;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.radius, f18);
        path4.lineTo(f37 + coerceAtMost, this.rect.bottom - this.arrowHeight);
        Path path5 = this.path;
        RectF rectF8 = this.rect;
        float f38 = rectF8.left;
        float f39 = rectF8.bottom;
        float f46 = this.radius;
        int i16 = this.arrowHeight;
        path5.arcTo(new RectF(f38, (f39 - f46) - i16, f46 + f38, f39 - i16), 90.0f, 90.0f);
        Path path6 = this.path;
        RectF rectF9 = this.rect;
        path6.lineTo(rectF9.left, rectF9.top + this.radius);
        Path path7 = this.path;
        RectF rectF10 = this.rect;
        float f47 = rectF10.left;
        float f48 = rectF10.top;
        float f49 = this.radius;
        path7.arcTo(new RectF(f47, f48, f49 + f47, f49 + f48), 180.0f, 90.0f);
        this.path.close();
        Paint paint = this.paint;
        RectF rectF11 = this.rect;
        paint.setShader(new LinearGradient(rectF11.left, rectF11.top, rectF11.right, rectF11.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
        canvas.drawPath(this.path, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.rect.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.rect.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
