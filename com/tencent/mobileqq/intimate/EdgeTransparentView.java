package com.tencent.mobileqq.intimate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\u0004\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001f\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ(\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0014J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0014R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010&R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/intimate/EdgeTransparentView;", "Landroid/widget/FrameLayout;", "", "b", "", "position", "", "drawSize", "setPositionAndDrawSize", "(Ljava/lang/Integer;F)V", "", "gradientColors", "setGradientColors", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/view/View;", "child", "", "drawingTime", "", "drawChild", "", "d", "[F", "gradientPosition", "Landroid/graphics/Paint;", "e", "Lkotlin/Lazy;", "a", "()Landroid/graphics/Paint;", "paint", "f", "[I", "Ljava/lang/Integer;", "i", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mWidth", BdhLogUtil.LogTag.Tag_Conn, "mHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class EdgeTransparentView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private int mHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final float[] gradientPosition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] gradientColors;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer position;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float drawSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EdgeTransparentView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
    }

    private final Paint a() {
        return (Paint) this.paint.getValue();
    }

    private final void b() {
        a().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.drawSize, this.gradientColors, this.gradientPosition, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(@NotNull Canvas canvas, @NotNull View child, long drawingTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, canvas, child, Long.valueOf(drawingTime))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.position == null) {
            return super.drawChild(canvas, child, drawingTime);
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        boolean drawChild = super.drawChild(canvas, child, drawingTime);
        Integer num = this.position;
        Intrinsics.checkNotNull(num);
        if ((num.intValue() & 1) != 0) {
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.drawSize, a());
        }
        Integer num2 = this.position;
        Intrinsics.checkNotNull(num2);
        if ((num2.intValue() & 2) != 0) {
            int save = canvas.save();
            canvas.rotate(180.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.drawSize, a());
            canvas.restoreToCount(save);
        }
        int i3 = (this.mHeight - this.mWidth) / 2;
        Integer num3 = this.position;
        Intrinsics.checkNotNull(num3);
        if ((num3.intValue() & 4) != 0) {
            int save2 = canvas.save();
            canvas.rotate(90.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            float f16 = i3;
            canvas.translate(0.0f, f16);
            canvas.drawRect(-f16, 0.0f, this.mWidth + i3, this.drawSize, a());
            canvas.restoreToCount(save2);
        }
        Integer num4 = this.position;
        Intrinsics.checkNotNull(num4);
        if ((num4.intValue() & 8) != 0) {
            int save3 = canvas.save();
            canvas.rotate(270.0f, this.mWidth / 2.0f, this.mHeight / 2.0f);
            float f17 = i3;
            canvas.translate(0.0f, f17);
            canvas.drawRect(-f17, 0.0f, this.mWidth + i3, this.drawSize, a());
            canvas.restoreToCount(save3);
        }
        canvas.restoreToCount(saveLayer);
        return drawChild;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        if (this.position == null) {
            return;
        }
        b();
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

    public final void setPositionAndDrawSize(@Nullable Integer position, float drawSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, position, Float.valueOf(drawSize));
        } else {
            this.position = position;
            this.drawSize = drawSize;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EdgeTransparentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) attributeSet);
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
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.gradientPosition = new float[]{0.0f, 1.0f};
        lazy = LazyKt__LazyJVMKt.lazy(EdgeTransparentView$paint$2.INSTANCE);
        this.paint = lazy;
        this.gradientColors = new int[]{-1, 0};
    }
}
