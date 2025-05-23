package com.tencent.mobileqq.guild.home.views.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\b\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0014J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\bR\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/widget/GuildHomeHeaderGroupChatLayout;", "Landroid/widget/FrameLayout;", "", "a", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "type", "c", "d", "I", "Landroid/graphics/Rect;", "e", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "", "f", "[F", "radii", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "path", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderGroupChatLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect rect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] radii;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeHeaderGroupChatLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        if (this.type == 1) {
            this.paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.rect.bottom, ContextCompat.getColor(getContext(), R.color.f157142bp3), ContextCompat.getColor(getContext(), R.color.f157140bp1), Shader.TileMode.CLAMP));
            this.paint.setShadowLayer(c.b(10), 0.0f, 0.0f, 218103808);
        } else {
            this.paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.rect.bottom, ContextCompat.getColor(getContext(), R.color.f157141bp2), ContextCompat.getColor(getContext(), R.color.f157139bp0), Shader.TileMode.CLAMP));
            this.paint.setShadowLayer(c.b(15), 0.0f, 0.0f, 134217728);
        }
    }

    private final void b() {
        this.path.reset();
        this.path.addRoundRect(new RectF(this.rect), this.radii, Path.Direction.CW);
        this.path.close();
    }

    public final void c(int type) {
        this.type = type;
        a();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawPath(this.path, this.paint);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        this.rect.set(0, 0, w3, h16);
        b();
        a();
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeHeaderGroupChatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildHomeHeaderGroupChatLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildHomeHeaderGroupChatLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rect = new Rect();
        this.radii = new float[]{cw.d(12), cw.d(12), cw.d(12), cw.d(12), 0.0f, 0.0f, 0.0f, 0.0f};
        this.path = new Path();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.paint = paint;
    }
}
