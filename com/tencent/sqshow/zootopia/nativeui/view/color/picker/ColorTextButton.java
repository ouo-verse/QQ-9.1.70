package com.tencent.sqshow.zootopia.nativeui.view.color.picker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.ue.s;
import com.tencent.sqshow.zootopia.utils.i;
import da4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001\u0003B#\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010$\u001a\u00020\u0005\u00a2\u0006\u0004\b%\u0010&B\u001f\b\u0017\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b%\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0014J0\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/color/picker/ColorTextButton;", "Landroid/widget/TextView;", "", "a", "b", "", "color", "setColor", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "setChannel", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "d", "Landroid/widget/TextView;", "outlineTextView", "e", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ColorTextButton extends TextView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView outlineTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private j channel;

    public ColorTextButton(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    private final void a() {
        setForeground(ContextCompat.getDrawable(getContext(), R.drawable.iiu));
        setLayerType(1, getPaint());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i.e(99));
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(i.b(1), Color.parseColor("#1A000000"));
        setBackground(gradientDrawable);
        setTextSize(12.0f);
        setGravity(17);
    }

    private final void b() {
        TextView textView = new TextView(getContext());
        this.outlineTextView = textView;
        textView.setTextSize(12.0f);
        TextView textView2 = this.outlineTextView;
        TextPaint paint = textView2 != null ? textView2.getPaint() : null;
        if (paint != null) {
            paint.setStrokeWidth(i.e(1));
        }
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        TextView textView3 = this.outlineTextView;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#1A000000"));
        }
        TextView textView4 = this.outlineTextView;
        if (textView4 == null) {
            return;
        }
        textView4.setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        TextView textView = this.outlineTextView;
        if (textView != null) {
            textView.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        TextView textView = this.outlineTextView;
        if (textView != null) {
            textView.layout(left, top, right, bottom);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        TextView textView = this.outlineTextView;
        CharSequence text = textView != null ? textView.getText() : null;
        if (text == null || !Intrinsics.areEqual(text, getText())) {
            TextView textView2 = this.outlineTextView;
            if (textView2 != null) {
                textView2.setText(getText());
            }
            postInvalidate();
        }
        TextView textView3 = this.outlineTextView;
        if (textView3 != null) {
            textView3.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final void setChannel(j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        TextView textView = this.outlineTextView;
        if (textView == null) {
            return;
        }
        textView.setLayoutParams(params);
    }

    public ColorTextButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b();
        a();
    }

    public final void setColor(int color) {
        s avatarColorController;
        setForeground(null);
        a aVar = a.f393479a;
        String a16 = aVar.a(color);
        setText(a16);
        TextView textView = this.outlineTextView;
        if (textView != null) {
            textView.setText(a16);
        }
        QLog.i("ColorTextButton", 4, "color text == " + a16);
        Drawable background = getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(aVar.b(color));
        j jVar = this.channel;
        if (jVar == null || (avatarColorController = jVar.getAvatarColorController()) == null) {
            return;
        }
        avatarColorController.b(a16);
    }

    public ColorTextButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public /* synthetic */ ColorTextButton(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
