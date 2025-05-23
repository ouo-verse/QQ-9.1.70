package com.tencent.mobileqq.guild.discoveryv2.content.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import up1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\t\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0014J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0014\u0010!\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/view/DiscoveryV2RootView;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "b", "c", "d", "dispatchDraw", "", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "", "px", "setRadius", "e", "a", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "Landroid/graphics/Path;", "Landroid/graphics/Path;", "path", "f", UserInfo.SEX_FEMALE, "radiusPx", "", "Z", "drawShadowFlag", "i", "drawStrokeFlag", "Landroid/graphics/Paint;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Paint;", "strokePaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class DiscoveryV2RootView extends FrameLayout {
    private static final int D;

    @NotNull
    private static final Paint E;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect rect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path path;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float radiusPx;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean drawShadowFlag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean drawStrokeFlag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint strokePaint;

    static {
        int b16 = c.b(6);
        D = b16;
        Paint paint = new Paint(1);
        paint.setColor(0);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(b16);
        paint.setShadowLayer(c.b(15), 0.0f, 0.0f, 536870912);
        E = paint;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryV2RootView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.path, Region.Op.INTERSECT);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private final void c(Canvas canvas) {
        if (!this.drawShadowFlag) {
            return;
        }
        canvas.clipPath(this.path, Region.Op.DIFFERENCE);
        canvas.drawPath(this.path, E);
    }

    private final void d(Canvas canvas) {
        if (!this.drawStrokeFlag) {
            return;
        }
        canvas.clipPath(this.path, Region.Op.DIFFERENCE);
        canvas.drawPath(this.path, this.strokePaint);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.radiusPx <= 0.0f) {
            super.dispatchDraw(canvas);
        } else {
            b(canvas);
        }
        c(canvas);
        d(canvas);
    }

    public final void e() {
        this.path.reset();
        Path path = this.path;
        RectF rectF = new RectF(this.rect);
        float f16 = this.radiusPx;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        this.path.close();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        this.rect.set(0, 0, w3, h16);
        e();
        a();
    }

    public final void setRadius(float px5) {
        boolean z16;
        if (this.radiusPx == px5) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.radiusPx = px5;
        e();
        a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryV2RootView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DiscoveryV2RootView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DiscoveryV2RootView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rect = new Rect();
        this.path = new Path();
        boolean z16 = true;
        Paint paint = new Paint(1);
        paint.setColor(context.getColor(R.color.qui_common_border_standard));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(bi.a(0.5f));
        this.strokePaint = paint;
        setClipChildren(false);
        setBackground(getRootView().getContext().getDrawable(R.drawable.qui_common_fill_light_secondary_bg_corner_4));
        this.radiusPx = getRootView().getResources().getDimension(R.dimen.f158966ce1);
        boolean z17 = context.obtainStyledAttributes(attributeSet, a.R0).getBoolean(a.S0, false);
        this.drawStrokeFlag = z17;
        if (!z17) {
            if (Build.VERSION.SDK_INT < 28) {
                setElevation(c.b(2));
            }
            this.drawShadowFlag = z16;
        }
        z16 = false;
        this.drawShadowFlag = z16;
    }

    public final void a() {
    }
}
