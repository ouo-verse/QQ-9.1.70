package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104B\u001b\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00106\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b3\u00107B#\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\u0006\u00108\u001a\u00020\u0002\u00a2\u0006\u0004\b3\u00109B+\b\u0016\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b3\u0010:J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010!\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010!\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010!R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010!\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadow;", "Landroid/widget/FrameLayout;", "", "color", "", "setShadowColor", "", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "Landroid/graphics/RectF;", "d", "Landroid/graphics/RectF;", "getMCacheRect", "()Landroid/graphics/RectF;", "setMCacheRect", "(Landroid/graphics/RectF;)V", "mCacheRect", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "paint", "f", "I", NodeProps.SHADOW_COLOR, tl.h.F, "getCorner", "()I", "setCorner", "(I)V", "corner", "i", "getBlur", "setBlur", "blur", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lastWidth", BdhLogUtil.LogTag.Tag_Conn, "lastHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;III)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class BoxShadow extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private int lastHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RectF mCacheRect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int shadowColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int corner;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int blur;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxShadow(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.paint = new Paint();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        RectF rectF = this.mCacheRect;
        if (rectF != null) {
            Intrinsics.checkNotNull(rectF);
            int i3 = this.corner;
            canvas.drawRoundRect(rectF, i3, i3, this.paint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            return;
        }
        super.onLayout(changed, left, top, right, bottom);
        if (this.mCacheRect == null || this.lastWidth != getMeasuredWidth() || this.lastHeight != getMeasuredHeight()) {
            float f16 = (int) (this.blur * 0.5f);
            this.mCacheRect = new RectF(f16, f16, getMeasuredWidth() - r5, getMeasuredHeight() - (1.15f * f16));
            this.lastWidth = getMeasuredWidth();
            this.lastHeight = getMeasuredHeight();
        }
    }

    public final void setBlur(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.blur = i3;
        }
    }

    public final void setCorner(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.corner = i3;
        }
    }

    public final void setMCacheRect(@Nullable RectF rectF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rectF);
        } else {
            this.mCacheRect = rectF;
        }
    }

    public final void setPaint(@NotNull Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) paint);
        } else {
            Intrinsics.checkNotNullParameter(paint, "<set-?>");
            this.paint = paint;
        }
    }

    public final void setShadowColor(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, color);
        } else if (this.shadowColor != color) {
            this.shadowColor = color;
            this.paint.setColor(color);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxShadow(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.paint = new Paint();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxShadow(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.paint = new Paint();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxShadow(@Nullable Context context, int i3, int i16, int i17) {
        super(context);
        Intrinsics.checkNotNull(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        Paint paint = new Paint();
        this.paint = paint;
        this.corner = i16;
        this.blur = i3;
        this.shadowColor = i17;
        paint.setColor(i17);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setMaskFilter(new BlurMaskFilter((int) (i3 * 0.5f), BlurMaskFilter.Blur.NORMAL));
        setLayerType(1, null);
    }
}
