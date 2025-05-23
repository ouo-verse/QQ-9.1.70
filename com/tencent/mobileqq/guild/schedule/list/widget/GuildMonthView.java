package com.tencent.mobileqq.guild.schedule.list.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMonthView extends View implements View.OnClickListener {
    private int C;
    private int D;
    private boolean E;
    private float F;
    private float G;
    private float H;
    private float I;
    private GuildScheduleCalendarHelper J;
    private py1.a[] K;
    private final RectF L;
    private final ColorStateList M;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f233325d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f233326e;

    /* renamed from: f, reason: collision with root package name */
    private int f233327f;

    /* renamed from: h, reason: collision with root package name */
    private int f233328h;

    /* renamed from: i, reason: collision with root package name */
    private int f233329i;

    /* renamed from: m, reason: collision with root package name */
    private int f233330m;

    public GuildMonthView(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        py1.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.E && this.K != null && this.J != null) {
            int paddingLeft = ((int) ((this.G - getPaddingLeft()) - (r1 / 2))) / (this.f233327f + this.f233329i);
            int paddingTop = ((int) ((this.H - getPaddingTop()) - (r2 / 2))) / (this.f233328h + this.f233329i);
            if ((paddingLeft >= 0 || paddingTop >= 0) && (i3 = (paddingTop * 7) + paddingLeft) >= 0) {
                py1.a[] aVarArr = this.K;
                if (i3 < aVarArr.length && (aVar = aVarArr[i3]) != null) {
                    int i16 = aVar.f428062a;
                    GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.J;
                    if (i16 >= guildScheduleCalendarHelper.f233280w && i16 <= guildScheduleCalendarHelper.f233281x) {
                        guildScheduleCalendarHelper.r(aVar);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        py1.a aVar;
        py1.a aVar2;
        int i3;
        int i16;
        int i17;
        int i18;
        super.onDraw(canvas);
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.J;
        if (guildScheduleCalendarHelper != null && this.K != null) {
            py1.a aVar3 = guildScheduleCalendarHelper.f233279v;
            py1.a aVar4 = guildScheduleCalendarHelper.f233278u;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            GuildScheduleCalendarHelper guildScheduleCalendarHelper2 = this.J;
            int i19 = guildScheduleCalendarHelper2.f233280w;
            int i26 = guildScheduleCalendarHelper2.f233281x;
            float f16 = this.I;
            int length = this.K.length;
            int i27 = 0;
            while (i27 < length) {
                py1.a aVar5 = this.K[i27];
                if (aVar5 != null && (i17 = aVar5.f428062a) >= i19 && i17 <= i26) {
                    boolean equals = aVar3.equals(aVar5);
                    boolean equals2 = aVar4.equals(aVar5);
                    aVar = aVar4;
                    int i28 = this.f233328h;
                    aVar2 = aVar3;
                    int i29 = this.f233329i;
                    int i36 = paddingTop + ((i28 + i29) * (i27 / 7));
                    int i37 = this.f233327f;
                    int i38 = paddingLeft + ((i37 + i29) * (i27 % 7)) + i29 + (i37 / 2);
                    int i39 = i36 + (i28 / 2);
                    if (equals) {
                        this.f233325d.setColor(this.M.getDefaultColor());
                        this.f233326e.setColor(this.J.f233270m);
                        int i46 = this.f233330m / 2;
                        i3 = paddingLeft;
                        i16 = paddingTop;
                        this.L.set(i38 - i46, i39 - i46, i38 + i46, i39 + i46);
                        canvas.drawRoundRect(this.L, 18.0f, 18.0f, this.f233326e);
                        this.f233326e.setColor(this.J.f233271n);
                        int i47 = i46 - 2;
                        this.L.set(i38 - i47, i39 - i47, i38 + i47, i47 + i39);
                        canvas.drawRoundRect(this.L, 18.0f, 18.0f, this.f233326e);
                    } else {
                        i3 = paddingLeft;
                        i16 = paddingTop;
                        if (equals2) {
                            this.f233325d.setColor(this.J.f233268k);
                        } else if (aVar5.f428063b == this.D) {
                            this.f233325d.setColor(this.J.f233267j);
                        } else {
                            this.f233325d.setColor(this.J.f233269l);
                        }
                    }
                    float f17 = i38;
                    canvas.drawText(Integer.toString(aVar5.f428064c), f17, i39 - f16, this.f233325d);
                    if (this.J.A.containsKey(aVar5)) {
                        if (this.J.A.get(aVar5).intValue() == 1) {
                            i18 = this.J.f233268k;
                        } else {
                            i18 = this.J.f233269l;
                        }
                        this.f233326e.setColor(i18);
                        canvas.drawCircle(f17, i36 + this.f233328h, 10.0f, this.f233326e);
                    }
                } else {
                    aVar = aVar4;
                    aVar2 = aVar3;
                    i3 = paddingLeft;
                    i16 = paddingTop;
                }
                i27++;
                aVar4 = aVar;
                aVar3 = aVar2;
                paddingLeft = i3;
                paddingTop = i16;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.f233327f = (getMeasuredWidth() - (((this.f233329i * 8) + getPaddingLeft()) + getPaddingRight())) / 7;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16 = false;
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && !this.E) {
                float x16 = motionEvent.getX() - this.G;
                float y16 = motionEvent.getY() - this.H;
                if (Math.sqrt((x16 * x16) + (y16 * y16)) > this.F) {
                    z16 = true;
                }
                this.E = z16;
            }
        } else {
            this.E = false;
            this.G = motionEvent.getX();
            this.H = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setAlpha(float f16) {
        super.setAlpha(1.0f);
    }

    public void setDate(int i3, int i16) {
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.J;
        if (guildScheduleCalendarHelper == null) {
            return;
        }
        if (this.C != i3 || this.D != i16 || this.K == null) {
            this.C = i3;
            this.D = i16;
            int n3 = guildScheduleCalendarHelper.n(i3, i16) * 7;
            py1.a[] aVarArr = this.K;
            if (aVarArr == null || aVarArr.length != n3) {
                this.K = new py1.a[n3];
            }
            this.J.d(this.K, i3, i16);
            requestLayout();
        }
        invalidate();
    }

    public void setHelper(GuildScheduleCalendarHelper guildScheduleCalendarHelper) {
        this.J = guildScheduleCalendarHelper;
        this.f233328h = guildScheduleCalendarHelper.f233276s;
        this.f233329i = guildScheduleCalendarHelper.f233277t;
        this.F = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f233325d.setAntiAlias(true);
        this.f233325d.setTextSize(guildScheduleCalendarHelper.f233273p);
        this.f233325d.setTextAlign(Paint.Align.CENTER);
        this.f233325d.setTypeface(guildScheduleCalendarHelper.f233272o);
        Paint.FontMetrics fontMetrics = this.f233325d.getFontMetrics();
        this.I = (fontMetrics.top + fontMetrics.bottom) / 2.0f;
        this.f233326e.setAntiAlias(true);
        this.f233330m = Utils.n(31.0f, getContext().getResources());
    }

    public GuildMonthView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildMonthView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f233325d = new Paint();
        this.f233326e = new Paint();
        this.L = new RectF();
        this.M = AppCompatResources.getColorStateList(getContext(), R.color.qui_button_text_primary_default);
        setOnClickListener(this);
    }
}
