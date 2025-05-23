package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00016B'\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u00a2\u0006\u0004\b4\u00105J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J0\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J(\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0014J\u0006\u0010\u001c\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0014J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010!R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010!R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010!\u00a8\u00067"}, d2 = {"Lcom/tencent/mm/ui/widget/textview/FadeEdgeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "gradientScope", "", "setGradientScope", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "unit", "", "size", "setTextSize", "setPadding", "color", "setTextColor", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "updateShader", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "a", "I", "mGradientScope", "Landroid/graphics/Shader;", "b", "Landroid/graphics/Shader;", "shader_horizontal", "c", "fixTopPadding", "d", "fixBottomPadding", "e", "userSetPaddingTop", "f", "userSetPaddingBottom", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class FadeEdgeTextView extends AppCompatTextView {

    @NotNull
    public static final String TAG = "FadeEdgeTextView";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int mGradientScope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Shader shader_horizontal;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int fixTopPadding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int fixBottomPadding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int userSetPaddingTop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int userSetPaddingBottom;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FadeEdgeTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(int left, int right) {
        super.setPadding(left, this.userSetPaddingTop - this.fixTopPadding, right, this.userSetPaddingBottom - this.fixBottomPadding);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getWidth() > 0 && getHeight() > 0) {
            getPaint().setShader(this.shader_horizontal);
            Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
            canvas.drawText(getText().toString(), 0.0f, (getMeasuredHeight() / 2) + ((-(fontMetrics.descent + fontMetrics.ascent)) / 2), getPaint());
            return;
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    public void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        updateShader();
    }

    public final void setGradientScope(int gradientScope) {
        this.mGradientScope = gradientScope;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        this.userSetPaddingTop = top;
        this.userSetPaddingBottom = bottom;
        a(left, right);
    }

    @Override // android.widget.TextView
    public void setTextColor(int color) {
        super.setTextColor(color);
        updateShader();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        Paint.FontMetricsInt fontMetricsInt = getPaint().getFontMetricsInt();
        int abs = Math.abs(fontMetricsInt.top);
        int abs2 = Math.abs(fontMetricsInt.ascent);
        int abs3 = Math.abs(fontMetricsInt.bottom);
        int abs4 = Math.abs(fontMetricsInt.descent);
        if (abs > abs2) {
            this.fixTopPadding = (abs - abs2) / 2;
        }
        if (abs3 > abs4) {
            this.fixBottomPadding = abs3 - abs4;
        }
        n.a(TAG, "fixTopPadding:" + this.fixTopPadding + " fixBottomPadding:" + this.fixBottomPadding + " font:" + fontMetricsInt, new Object[0]);
        a(getPaddingLeft(), getPaddingRight());
    }

    public final void updateShader() {
        int currentTextColor = getCurrentTextColor();
        if (getPaint().measureText(getText().toString()) > getMeasuredWidth()) {
            currentTextColor = 0;
        }
        int i3 = currentTextColor;
        if (getMeasuredWidth() > this.mGradientScope) {
            this.shader_horizontal = new LinearGradient(getMeasuredWidth() - this.mGradientScope, 0.0f, getMeasuredWidth(), 0.0f, getCurrentTextColor(), i3, Shader.TileMode.CLAMP);
        } else {
            this.shader_horizontal = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, getCurrentTextColor(), i3, Shader.TileMode.CLAMP);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FadeEdgeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FadeEdgeTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FadeEdgeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FadeEdgeTextView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026yleable.FadeEdgeTextView)");
            this.mGradientScope = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FadeEdgeTextView_fadeEdgeLength, 0);
            obtainStyledAttributes.recycle();
        }
        setSingleLine();
    }
}
