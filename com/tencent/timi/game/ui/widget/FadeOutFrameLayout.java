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
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u00a2\u0006\u0004\b'\u0010(J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J(\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010 \u00a8\u0006)"}, d2 = {"Lcom/tencent/timi/game/ui/widget/FadeOutFrameLayout;", "Landroid/widget/FrameLayout;", "", "offsetLeft", "offsetTop", "", "setFadeOffset", "", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Rect;", "e", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "Landroid/graphics/LinearGradient;", "f", "Landroid/graphics/LinearGradient;", NodeProps.LINEAR_GRADIENT, "Landroid/graphics/PorterDuffXfermode;", "Landroid/graphics/PorterDuffXfermode;", "dstInXfermode", "i", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class FadeOutFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect rect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearGradient linearGradient;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PorterDuffXfermode dstInXfermode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float offsetLeft;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float offsetTop;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FadeOutFrameLayout(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@Nullable Canvas canvas) {
        if (canvas != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
            super.dispatchDraw(canvas);
            this.rect.set(0, 0, getWidth(), getHeight());
            this.paint.setShader(this.linearGradient);
            this.paint.setXfermode(this.dstInXfermode);
            canvas.translate(this.offsetLeft, this.offsetTop);
            canvas.drawRect(this.rect, this.paint);
            this.paint.setShader(null);
            this.paint.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.linearGradient = new LinearGradient(0.0f, 0.0f, getWidth() - this.offsetLeft, 0.0f, Color.parseColor("#FFFFFF"), Color.parseColor("#00FFFFFF"), Shader.TileMode.CLAMP);
    }

    public final void setFadeOffset(float offsetLeft, float offsetTop) {
        this.offsetLeft = offsetLeft;
        this.offsetTop = offsetTop;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FadeOutFrameLayout(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ FadeOutFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FadeOutFrameLayout(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.paint = new Paint();
        this.rect = new Rect();
        this.dstInXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.offsetLeft = com.tencent.timi.game.utils.b.c(16);
        setWillNotDraw(false);
    }
}
