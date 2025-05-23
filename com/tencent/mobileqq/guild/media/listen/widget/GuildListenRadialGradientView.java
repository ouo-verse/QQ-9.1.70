package com.tencent.mobileqq.guild.media.listen.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)B\u0019\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b(\u0010,J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0015J\b\u0010\n\u001a\u00020\u0005H\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/media/listen/widget/GuildListenRadialGradientView;", "Landroid/view/View;", "", "startColor", "endColor", "", "setColor", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", NodeProps.ON_ATTACHED_TO_WINDOW, "d", "I", "e", "", "f", UserInfo.SEX_FEMALE, NodeProps.BORDER_RADIUS, "Landroid/graphics/Paint;", h.F, "Landroid/graphics/Paint;", "paint", "i", "widthFloat", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "heightFloat", "Lcom/tencent/mobileqq/guild/media/listen/widget/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/listen/widget/a;", "clipOutlineProvider", "Landroid/graphics/RadialGradient;", "D", "Landroid/graphics/RadialGradient;", "backGradient", "", "E", "Z", "needSetColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildListenRadialGradientView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private a clipOutlineProvider;

    /* renamed from: D, reason: from kotlin metadata */
    private RadialGradient backGradient;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean needSetColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int startColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int endColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float borderRadius;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float widthFloat;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float heightFloat;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListenRadialGradientView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.startColor = -1;
        this.endColor = -1;
        this.paint = new Paint();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.clipOutlineProvider;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clipOutlineProvider");
            aVar = null;
        }
        setOutlineProvider(aVar);
        setClipToOutline(true);
        invalidateOutline();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.widthFloat = getWidth();
        this.heightFloat = getHeight();
        if (this.backGradient == null) {
            float f16 = 2;
            float f17 = this.widthFloat / f16;
            float f18 = this.heightFloat;
            this.backGradient = new RadialGradient(f17, f18 / f16, f18 / f16, this.startColor, this.endColor, Shader.TileMode.CLAMP);
        }
        if (this.needSetColor) {
            float f19 = 2;
            float f26 = this.widthFloat / f19;
            float f27 = this.heightFloat;
            this.backGradient = new RadialGradient(f26, f27 / f19, f27 / f19, this.startColor, this.endColor, Shader.TileMode.CLAMP);
            this.needSetColor = false;
        }
        Paint paint = this.paint;
        RadialGradient radialGradient = this.backGradient;
        if (radialGradient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backGradient");
            radialGradient = null;
        }
        paint.setShader(radialGradient);
        canvas.drawRect(0.0f, 0.0f, this.widthFloat, this.heightFloat, this.paint);
    }

    public final void setColor(int startColor, int endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
        this.needSetColor = true;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListenRadialGradientView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.startColor = -1;
        this.endColor = -1;
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, up1.a.D5);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026ildTopLinearGradientView)");
        this.startColor = obtainStyledAttributes.getColor(up1.a.G5, -1);
        this.endColor = obtainStyledAttributes.getColor(up1.a.F5, -1);
        this.borderRadius = obtainStyledAttributes.getColor(up1.a.E5, 0);
        this.clipOutlineProvider = new a(this.borderRadius);
        obtainStyledAttributes.recycle();
    }
}
