package lu3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Llu3/a;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Rect;", "b", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a extends Drawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Paint paint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Rect rect;

    public a() {
        Paint paint = new Paint();
        this.paint = paint;
        this.rect = new Rect();
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Rect bounds = getBounds();
        Intrinsics.checkExpressionValueIsNotNull(bounds, "bounds");
        Rect rect = this.rect;
        rect.left = bounds.left;
        rect.top = bounds.bottom - ViewUtils.dpToPx(1.5f);
        Rect rect2 = this.rect;
        rect2.right = bounds.right;
        rect2.bottom = bounds.bottom;
        canvas.drawRect(rect2, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.paint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
