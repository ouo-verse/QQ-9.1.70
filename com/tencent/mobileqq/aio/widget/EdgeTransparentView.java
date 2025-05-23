package com.tencent.mobileqq.aio.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010?\u001a\u00020>\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010B\u001a\u00020\u0004\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J#\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u001a\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004J\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011J(\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010-\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u001b\u0010/\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b.\u0010)R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00101R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00101R\u0016\u0010=\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00101\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/EdgeTransparentView;", "Landroid/widget/FrameLayout;", "", "e", "", "position", "", "", "drawSize", "setPositionAndDrawSize", "(I[Ljava/lang/Float;)V", "", "gradientColors", "setGradientColors", "top", "bottom", "setTransparentSize", "Lkotlin/Pair;", "d", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/view/View;", "child", "", "drawingTime", "", "drawChild", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "[F", "gradientPosition", "Landroid/graphics/Paint;", "Lkotlin/Lazy;", "b", "()Landroid/graphics/Paint;", "paint", "f", "a", "bottomPaint", "c", "transparentPaint", "i", "I", "topTransparentSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bottomTransparentSize", BdhLogUtil.LogTag.Tag_Conn, "[I", "D", "E", "[Ljava/lang/Float;", UserInfo.SEX_FEMALE, "mWidth", "G", "mHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class EdgeTransparentView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private int[] gradientColors;

    /* renamed from: D, reason: from kotlin metadata */
    private int position;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Float[] drawSize;

    /* renamed from: F, reason: from kotlin metadata */
    private int mWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private int mHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] gradientPosition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bottomPaint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy transparentPaint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int topTransparentSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int bottomTransparentSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EdgeTransparentView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
    }

    private final Paint a() {
        return (Paint) this.bottomPaint.getValue();
    }

    private final Paint b() {
        return (Paint) this.paint.getValue();
    }

    private final Paint c() {
        return (Paint) this.transparentPaint.getValue();
    }

    private final void e() {
        if ((this.position & 1) != 0) {
            b().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.drawSize[1].floatValue(), this.gradientColors, this.gradientPosition, Shader.TileMode.CLAMP));
        }
        if ((this.position & 2) != 0) {
            a().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.drawSize[3].floatValue(), this.gradientColors, this.gradientPosition, Shader.TileMode.CLAMP));
        }
    }

    public static /* synthetic */ void setTransparentSize$default(EdgeTransparentView edgeTransparentView, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        edgeTransparentView.setTransparentSize(i3, i16);
    }

    @NotNull
    public final Pair<Integer, Integer> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Pair) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new Pair<>(Integer.valueOf(this.topTransparentSize), Integer.valueOf(this.bottomTransparentSize));
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(@NotNull Canvas canvas, @NotNull View child, long drawingTime) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, canvas, child, Long.valueOf(drawingTime))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.position == 0 && this.topTransparentSize == 0 && this.bottomTransparentSize == 0) {
            return super.drawChild(canvas, child, drawingTime);
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        boolean drawChild = super.drawChild(canvas, child, drawingTime);
        int i3 = this.topTransparentSize;
        if (i3 != 0) {
            canvas.drawRect(0.0f, 0.0f, this.mWidth, i3, c());
        }
        if (this.bottomTransparentSize != 0) {
            canvas.drawRect(0.0f, canvas.getHeight() - this.bottomTransparentSize, this.mWidth, canvas.getHeight(), c());
        }
        if ((this.position & 1) != 0) {
            int save = canvas.save();
            canvas.translate(0.0f, this.topTransparentSize);
            f16 = 0.0f;
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.drawSize[1].floatValue(), b());
            canvas.restoreToCount(save);
        } else {
            f16 = 0.0f;
        }
        if ((this.position & 2) != 0) {
            int save2 = canvas.save();
            canvas.rotate(180.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            canvas.translate(f16, this.bottomTransparentSize);
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.drawSize[3].floatValue(), a());
            canvas.restoreToCount(save2);
        }
        int i16 = (this.mHeight - this.mWidth) / 2;
        if ((this.position & 4) != 0) {
            int save3 = canvas.save();
            canvas.rotate(90.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            float f17 = i16;
            canvas.translate(f16, f17);
            canvas.drawRect(-f17, 0.0f, this.mWidth + i16, this.drawSize[0].floatValue(), b());
            canvas.restoreToCount(save3);
        }
        if ((this.position & 8) != 0) {
            int save4 = canvas.save();
            canvas.rotate(270.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            float f18 = i16;
            canvas.translate(f16, f18);
            canvas.drawRect(-f18, 0.0f, this.mWidth + i16, this.drawSize[2].floatValue(), b());
            canvas.restoreToCount(save4);
        }
        canvas.restoreToCount(saveLayer);
        return drawChild;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (ev5.getAction() == 0 && (ev5.getY() < this.topTransparentSize || ev5.getY() > this.mHeight - this.bottomTransparentSize)) {
            return true;
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        e();
        this.mWidth = getWidth();
        this.mHeight = getHeight();
    }

    public final void setGradientColors(@NotNull int[] gradientColors) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gradientColors);
        } else {
            Intrinsics.checkNotNullParameter(gradientColors, "gradientColors");
            this.gradientColors = gradientColors;
        }
    }

    public final void setPositionAndDrawSize(int position, @NotNull Float[] drawSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, position, (Object) drawSize);
            return;
        }
        Intrinsics.checkNotNullParameter(drawSize, "drawSize");
        this.position = position;
        this.drawSize = drawSize;
        if ((position & 1) != 0) {
            b().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, drawSize[1].floatValue(), this.gradientColors, this.gradientPosition, Shader.TileMode.CLAMP));
            invalidate();
        }
        if ((position & 2) != 0) {
            a().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, drawSize[3].floatValue(), this.gradientColors, this.gradientPosition, Shader.TileMode.CLAMP));
            invalidate();
        }
    }

    public final void setTransparentSize(int top, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(top), Integer.valueOf(bottom));
            return;
        }
        this.topTransparentSize = top;
        this.bottomTransparentSize = bottom;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EdgeTransparentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ EdgeTransparentView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EdgeTransparentView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.gradientPosition = new float[]{0.0f, 1.0f};
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) EdgeTransparentView$paint$2.INSTANCE);
        this.paint = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) EdgeTransparentView$bottomPaint$2.INSTANCE);
        this.bottomPaint = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) EdgeTransparentView$transparentPaint$2.INSTANCE);
        this.transparentPaint = lazy3;
        this.gradientColors = new int[]{-1, 0};
        Float[] fArr = new Float[4];
        for (int i16 = 0; i16 < 4; i16++) {
            fArr[i16] = Float.valueOf(0.0f);
        }
        this.drawSize = fArr;
    }
}
