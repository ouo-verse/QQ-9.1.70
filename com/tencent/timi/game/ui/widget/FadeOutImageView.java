package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B'\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J(\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0007H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00061"}, d2 = {"Lcom/tencent/timi/game/ui/widget/FadeOutImageView;", "Landroid/view/View;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "imgDrawable", "", "setImageResource", "", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "p0", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "onLoadProgressed", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "e", "Lcom/tencent/image/URLDrawable;", "Landroid/graphics/Rect;", "f", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "Landroid/graphics/LinearGradient;", "Landroid/graphics/LinearGradient;", NodeProps.LINEAR_GRADIENT, "Landroid/graphics/PorterDuffXfermode;", "i", "Landroid/graphics/PorterDuffXfermode;", "dstInXfermode", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class FadeOutImageView extends View implements URLDrawable.URLDrawableListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private URLDrawable imgDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect rect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearGradient linearGradient;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PorterDuffXfermode dstInXfermode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FadeOutImageView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            this.rect.set(0, 0, getWidth(), getHeight());
            URLDrawable uRLDrawable = this.imgDrawable;
            if (uRLDrawable != null) {
                uRLDrawable.getBounds().set(0, 0, getWidth(), getHeight());
                uRLDrawable.draw(canvas);
            }
            this.paint.setShader(this.linearGradient);
            this.paint.setXfermode(this.dstInXfermode);
            canvas.drawRect(this.rect, this.paint);
            this.paint.setShader(null);
            this.paint.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(@Nullable URLDrawable p06) {
        com.tencent.timi.game.utils.l.e("FadeOutImageView", "onLoadCanceled");
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(@Nullable URLDrawable p06, @Nullable Throwable p16) {
        String str;
        if (p16 != null) {
            str = p16.getMessage();
        } else {
            str = null;
        }
        com.tencent.timi.game.utils.l.e("FadeOutImageView", "onLoadFialed " + str);
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(@Nullable URLDrawable p06, int p16) {
        com.tencent.timi.game.utils.l.e("FadeOutImageView", "onLoadProgressed");
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(@Nullable URLDrawable p06) {
        com.tencent.timi.game.utils.l.e("FadeOutImageView", "onLoadSuccessed");
        this.imgDrawable = p06;
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.linearGradient = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, Color.parseColor("#FFFFFF"), Color.parseColor("#00FFFFFF"), Shader.TileMode.CLAMP);
    }

    public final void setImageResource(@Nullable URLDrawable imgDrawable) {
        URLDrawable uRLDrawable = this.imgDrawable;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
        }
        if (imgDrawable != null) {
            imgDrawable.setURLDrawableListener(this);
        }
        this.imgDrawable = imgDrawable;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FadeOutImageView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ FadeOutImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FadeOutImageView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.paint = new Paint();
        this.rect = new Rect();
        this.dstInXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
}
