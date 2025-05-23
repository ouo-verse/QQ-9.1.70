package com.tencent.now.linkpkanchorplay.mainpage.view.anchortab;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/ColorTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "w", h.F, "oldw", "oldh", "", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/text/TextPaint;", "Landroid/text/TextPaint;", "textPaint", "Landroid/graphics/LinearGradient;", "i", "Landroid/graphics/LinearGradient;", NodeProps.LINEAR_GRADIENT, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[I", "colorArray", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ColorTextView extends AppCompatTextView {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextPaint textPaint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearGradient linearGradient;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] colorArray;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ColorTextView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        if (getMeasuredWidth() != 0) {
            TextPaint paint = getPaint();
            this.textPaint = paint;
            if (paint != null) {
                paint.setTypeface(Typeface.DEFAULT_BOLD);
            }
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight() * 1.0f, this.colorArray, (float[]) null, Shader.TileMode.CLAMP);
            this.linearGradient = linearGradient;
            TextPaint textPaint = this.textPaint;
            if (textPaint != null) {
                textPaint.setShader(linearGradient);
            }
        }
    }

    public /* synthetic */ ColorTextView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ColorTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.colorArray = new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#FFEE98")};
    }
}
