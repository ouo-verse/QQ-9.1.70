package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o;
import com.tencent.mobileqq.matchfriend.reborn.widget.QQKLAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014J0\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0014J(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0014R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u00100\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainTitleIconGroup;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/b;", "adapter", "", "setAdapter", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "d", "I", "overLap", "e", "innerPaddingLeft", "f", "innerPaddingRight", "Landroid/graphics/LinearGradient;", "Landroid/graphics/LinearGradient;", "linearShader", "Landroid/graphics/Paint;", "i", "Landroid/graphics/Paint;", "bgPaint", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "strokeBgPaint", "Lcom/tencent/mobileqq/matchfriend/reborn/widget/QQKLAvatarView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/matchfriend/reborn/widget/QQKLAvatarView;", "imageView1", "D", "imageView2", "E", "imageView3", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MainTitleIconGroup extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final QQKLAvatarView imageView1;

    /* renamed from: D, reason: from kotlin metadata */
    private final QQKLAvatarView imageView2;

    /* renamed from: E, reason: from kotlin metadata */
    private final QQKLAvatarView imageView3;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView textView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int overLap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int innerPaddingLeft;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int innerPaddingRight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearGradient linearShader;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Paint bgPaint;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Paint strokeBgPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainTitleIconGroup(Context context) {
        super(context);
        QQKLAvatarView b16;
        QQKLAvatarView b17;
        QQKLAvatarView b18;
        Intrinsics.checkNotNullParameter(context, "context");
        this.overLap = o.e(5);
        this.innerPaddingLeft = o.e(12);
        this.innerPaddingRight = o.e(12);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.bgPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(o.d(2.0f));
        paint2.setAntiAlias(true);
        this.strokeBgPaint = paint2;
        setWillNotDraw(false);
        b16 = e.b(context);
        addView(b16);
        this.imageView1 = b16;
        b17 = e.b(context);
        addView(b17);
        this.imageView2 = b17;
        b18 = e.b(context);
        addView(b18);
        this.imageView3 = b18;
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setTextSize(14.0f);
        textView.setTextColor(context.getColorStateList(R.color.qui_common_text_primary));
        textView.setText(HardCodeUtil.qqStr(R.string.wyo));
        addView(textView);
        this.textView = textView;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float d16 = o.d(1.0f);
        Paint paint = this.bgPaint;
        paint.setColor(getContext().getColor(R.color.qui_common_fill_light_primary));
        canvas.drawRoundRect(d16, d16, getMeasuredWidth() - d16, getMeasuredHeight() - d16, o.d(45.0f), o.d(45.0f), paint);
        Paint paint2 = this.strokeBgPaint;
        paint2.setStrokeWidth(d16);
        paint2.setShader(this.linearShader);
        canvas.drawRoundRect(d16, d16, getMeasuredWidth() - d16, getMeasuredHeight() - d16, o.d(45.0f), o.d(45.0f), paint2);
        paint2.setShader(null);
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((((o.e(16) + o.e(7)) + (o.e(20) * 3)) - (this.overLap << 1)) + this.textView.getMeasuredWidth() + this.innerPaddingRight, heightMeasureSpec);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.linearShader = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{Color.parseColor("#6F57FF"), Color.parseColor("#CB69FF"), Color.parseColor("#FF9254"), Color.parseColor("#FFD953")}, new float[]{0.0f, 0.45f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
    }

    public final void setAdapter(b adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        adapter.a(this.imageView1, this.imageView2, this.imageView3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            int measuredHeight = (getMeasuredHeight() - this.imageView1.getMeasuredHeight()) >> 1;
            QQKLAvatarView qQKLAvatarView = this.imageView1;
            int i3 = this.innerPaddingLeft;
            qQKLAvatarView.layout(i3, measuredHeight, qQKLAvatarView.getMeasuredWidth() + i3, this.imageView1.getMeasuredHeight() + measuredHeight);
            this.imageView2.layout(this.imageView1.getRight() - this.overLap, measuredHeight, (this.imageView1.getRight() - this.overLap) + this.imageView2.getMeasuredWidth(), this.imageView2.getMeasuredHeight() + measuredHeight);
            this.imageView3.layout(this.imageView2.getRight() - this.overLap, measuredHeight, (this.imageView2.getRight() - this.overLap) + this.imageView3.getMeasuredWidth(), this.imageView3.getMeasuredHeight() + measuredHeight);
            int measuredHeight2 = (getMeasuredHeight() - this.textView.getMeasuredHeight()) >> 1;
            this.textView.layout(this.imageView3.getRight() + o.e(7), measuredHeight2, this.imageView3.getRight() + o.e(7) + this.textView.getMeasuredWidth(), this.textView.getMeasuredHeight() + measuredHeight2);
        }
    }
}
