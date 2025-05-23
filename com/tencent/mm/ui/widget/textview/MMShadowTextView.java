package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u00109\u001a\u000208\u00a2\u0006\u0004\b:\u0010;B\u0019\b\u0016\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b:\u0010<B!\b\u0016\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b:\u0010=J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0014J0\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0014J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00107\u001a\u00020,8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010.\u001a\u0004\b5\u00100\"\u0004\b6\u00102\u00a8\u0006>"}, d2 = {"Lcom/tencent/mm/ui/widget/textview/MMShadowTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyle", "", "initAttribute", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "", "text", "Landroid/widget/TextView$BufferType;", "type", IECSearchBar.METHOD_SET_TEXT, "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "a", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getShadowTextView", "()Landroid/widget/TextView;", "setShadowTextView", "(Landroid/widget/TextView;)V", "shadowTextView", "b", "I", "getShadowMaskColor", "()I", "setShadowMaskColor", "(I)V", "shadowMaskColor", "", "c", UserInfo.SEX_FEMALE, "getShadowMaskRadius", "()F", "setShadowMaskRadius", "(F)V", "shadowMaskRadius", "d", "getShadowMaskPadding", "setShadowMaskPadding", "shadowMaskPadding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public class MMShadowTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public TextView shadowTextView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int shadowMaskColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float shadowMaskRadius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float shadowMaskPadding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MMShadowTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.shadowMaskRadius = 16.0f;
        this.shadowMaskPadding = 16.0f;
        this.shadowTextView = new TextView(context);
    }

    public static /* synthetic */ void initAttribute$default(MMShadowTextView mMShadowTextView, AttributeSet attributeSet, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            mMShadowTextView.initAttribute(attributeSet, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initAttribute");
    }

    public final void a(Canvas canvas) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        Paint paint = new Paint();
        paint.setColor(this.shadowMaskColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setMaskFilter(new BlurMaskFilter(this.shadowMaskRadius, BlurMaskFilter.Blur.NORMAL));
        float f16 = this.shadowMaskPadding;
        float f17 = 2;
        RectF rectF = new RectF(f16 / f17, f16, getMeasuredWidth() - (this.shadowMaskPadding / f17), getMeasuredHeight() - this.shadowMaskPadding);
        float f18 = this.shadowMaskRadius;
        canvas.drawRoundRect(rectF, f18, f18, paint);
        TextView textView = this.shadowTextView;
        if (textView != null) {
            textView.setGravity(getGravity());
            textView.getPaint().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            textView.setTextSize(0, getTextSize());
            textView.draw(canvas);
            textView.getPaint().setXfermode(null);
        }
        canvas.restoreToCount(saveLayer);
    }

    public final int getShadowMaskColor() {
        return this.shadowMaskColor;
    }

    public final float getShadowMaskPadding() {
        return this.shadowMaskPadding;
    }

    public final float getShadowMaskRadius() {
        return this.shadowMaskRadius;
    }

    @Nullable
    public final TextView getShadowTextView() {
        return this.shadowTextView;
    }

    public void initAttribute(@NotNull AttributeSet attrs, int defStyle) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.MMShadowTextView, defStyle, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026dowTextView, defStyle, 0)");
        int i3 = R.styleable.MMShadowTextView_MMShadowRadius;
        this.shadowMaskRadius = obtainStyledAttributes.getFloat(i3, 16.0f);
        this.shadowMaskPadding = obtainStyledAttributes.getFloat(i3, 16.0f);
        this.shadowMaskColor = obtainStyledAttributes.getColor(R.styleable.MMShadowTextView_MMShadowColor, 637534208);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        a(canvas);
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        TextView textView = this.shadowTextView;
        if (textView != null) {
            textView.layout(left, top, right, bottom);
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        TextView textView = this.shadowTextView;
        if (textView != null) {
            textView.measure(widthMeasureSpec, heightMeasureSpec);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    public void setLayoutParams(@Nullable ViewGroup.LayoutParams params) {
        TextView textView = this.shadowTextView;
        if (textView != null) {
            textView.setLayoutParams(params);
        }
        super.setLayoutParams(params);
    }

    public final void setShadowMaskColor(int i3) {
        this.shadowMaskColor = i3;
    }

    public final void setShadowMaskPadding(float f16) {
        this.shadowMaskPadding = f16;
    }

    public final void setShadowMaskRadius(float f16) {
        this.shadowMaskRadius = f16;
    }

    public final void setShadowTextView(@Nullable TextView textView) {
        this.shadowTextView = textView;
    }

    @Override // android.widget.TextView
    public void setText(@Nullable CharSequence text, @Nullable TextView.BufferType type) {
        TextView textView = this.shadowTextView;
        if (textView != null) {
            textView.setText(text);
        }
        super.setText(text, type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MMShadowTextView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.shadowMaskRadius = 16.0f;
        this.shadowMaskPadding = 16.0f;
        this.shadowTextView = new TextView(context, attrs);
        initAttribute$default(this, attrs, 0, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MMShadowTextView(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.shadowMaskRadius = 16.0f;
        this.shadowMaskPadding = 16.0f;
        this.shadowTextView = new TextView(context, attrs, i3);
        initAttribute(attrs, i3);
    }
}
