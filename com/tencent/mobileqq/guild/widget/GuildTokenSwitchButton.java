package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildTokenSwitchButton extends View implements View.OnClickListener, Checkable {
    private static final int L = ViewUtils.dpToPx(13.0f);
    private static final int M = ViewUtils.dpToPx(8.0f);
    private static final int N = Color.parseColor("#0099FF");
    private static final int P = Color.parseColor("#E5E5E5");
    private float C;
    private float D;
    private float E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private View.OnClickListener K;

    /* renamed from: d, reason: collision with root package name */
    private Paint f235984d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f235985e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f235986f;

    /* renamed from: h, reason: collision with root package name */
    private float f235987h;

    /* renamed from: i, reason: collision with root package name */
    private float f235988i;

    /* renamed from: m, reason: collision with root package name */
    private float f235989m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
    }

    public GuildTokenSwitchButton(Context context) {
        super(context);
        this.I = false;
        this.J = true;
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        int color = context.getResources().getColor(R.color.qui_common_brand_standard);
        int color2 = context.getResources().getColor(R.color.qui_common_fill_standard_secondary);
        int color3 = context.getResources().getColor(R.color.qui_common_on_brand_primary);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439708w5);
            this.F = obtainStyledAttributes.getColor(up1.a.f439747z5, color);
            this.G = obtainStyledAttributes.getColor(up1.a.B5, color2);
            this.H = obtainStyledAttributes.getColor(up1.a.f439721x5, color3);
            this.f235988i = obtainStyledAttributes.getDimension(up1.a.f439734y5, M);
            this.f235987h = obtainStyledAttributes.getDimension(up1.a.C5, L);
            this.I = obtainStyledAttributes.getBoolean(up1.a.A5, false);
            obtainStyledAttributes.recycle();
        } else {
            this.F = color;
            this.G = color2;
            this.H = color3;
            this.f235988i = M;
            this.f235987h = L;
            this.I = false;
        }
        Paint paint = new Paint();
        this.f235984d = paint;
        paint.setAntiAlias(true);
        this.f235984d.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f235985e = paint2;
        paint2.setAntiAlias(true);
        this.f235985e.setColor(this.H);
        this.f235985e.setStyle(Paint.Style.FILL);
        this.f235989m = this.f235987h;
        this.f235986f = new RectF();
        postInvalidate();
        super.setOnClickListener(this);
    }

    void c() {
        if (this.I) {
            this.f235989m = this.E;
            this.f235984d.setColor(this.F);
        } else {
            this.f235989m = this.D;
            this.f235984d.setColor(this.G);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.I;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.J) {
            QQGuildUIUtil.T(20L);
            toggle();
        } else {
            View.OnClickListener onClickListener = this.K;
            if (onClickListener != null) {
                onClickListener.onClick(this);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c();
        RectF rectF = this.f235986f;
        int i3 = L;
        canvas.drawRoundRect(rectF, i3, i3, this.f235984d);
        canvas.drawCircle(this.f235989m, this.C, this.f235988i, this.f235985e);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        float f16 = this.f235987h;
        this.D = f16;
        float f17 = size;
        this.E = f17 - f16;
        this.f235989m = f16;
        float f18 = size2;
        this.C = 0.5f * f18;
        RectF rectF = this.f235986f;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = f17;
        rectF.bottom = f18;
    }

    public void setCanClick(Boolean bool, View.OnClickListener onClickListener) {
        this.J = bool.booleanValue();
        this.K = onClickListener;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z16) {
        this.I = z16;
        postInvalidate();
        b();
    }

    public void setCheckedOnly(boolean z16) {
        this.I = z16;
        postInvalidate();
    }

    public void setColor(int i3, int i16) {
        this.F = i3;
        this.G = i16;
        c();
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.I = !this.I;
        postInvalidate();
        b();
    }

    public GuildTokenSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = false;
        this.J = true;
        a(context, attributeSet);
    }

    public GuildTokenSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.I = false;
        this.J = true;
        a(context, attributeSet);
    }

    private void b() {
    }

    public void setOnCheckedChangeListener(a aVar) {
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
    }
}
