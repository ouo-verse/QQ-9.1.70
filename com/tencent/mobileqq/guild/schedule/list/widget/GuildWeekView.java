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
public class GuildWeekView extends View implements View.OnClickListener {
    private int C;
    private final py1.a[] D;
    private boolean E;
    private float F;
    private float G;
    private float H;
    private float I;
    private GuildScheduleCalendarHelper J;
    private final RectF K;
    private final ColorStateList L;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f233331d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f233332e;

    /* renamed from: f, reason: collision with root package name */
    private int f233333f;

    /* renamed from: h, reason: collision with root package name */
    private int f233334h;

    /* renamed from: i, reason: collision with root package name */
    private int f233335i;

    /* renamed from: m, reason: collision with root package name */
    private int f233336m;

    public GuildWeekView(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        py1.a aVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.E && this.J != null) {
            int paddingLeft = ((int) ((this.G - getPaddingLeft()) - (r1 / 2))) / (this.f233333f + this.f233335i);
            if (paddingLeft >= 0) {
                py1.a[] aVarArr = this.D;
                if (paddingLeft < aVarArr.length && (aVar = aVarArr[paddingLeft]) != null) {
                    int i3 = aVar.f428062a;
                    GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.J;
                    if (i3 >= guildScheduleCalendarHelper.f233280w && i3 <= guildScheduleCalendarHelper.f233281x) {
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
        int i3;
        super.onDraw(canvas);
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.J;
        if (guildScheduleCalendarHelper == null) {
            return;
        }
        py1.a aVar2 = guildScheduleCalendarHelper.f233279v;
        py1.a aVar3 = guildScheduleCalendarHelper.f233278u;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop() + this.J.f233276s;
        float f16 = this.I;
        int i16 = 0;
        while (true) {
            py1.a[] aVarArr = this.D;
            if (i16 < aVarArr.length) {
                py1.a aVar4 = aVarArr[i16];
                if (aVar4 != null) {
                    int i17 = aVar4.f428062a;
                    GuildScheduleCalendarHelper guildScheduleCalendarHelper2 = this.J;
                    if (i17 >= guildScheduleCalendarHelper2.f233280w && i17 <= guildScheduleCalendarHelper2.f233281x) {
                        boolean equals = aVar2.equals(aVar4);
                        boolean equals2 = aVar3.equals(aVar4);
                        int i18 = this.f233333f;
                        int i19 = this.f233335i;
                        int i26 = ((i18 + i19) * i16) + paddingLeft + i19 + (i18 / 2);
                        int i27 = (this.f233334h / 2) + paddingTop;
                        if (equals) {
                            this.f233331d.setColor(this.L.getDefaultColor());
                            this.f233332e.setColor(this.J.f233270m);
                            int i28 = this.f233336m / 2;
                            aVar = aVar3;
                            this.K.set(i26 - i28, i27 - i28, i26 + i28, i27 + i28);
                            canvas.drawRoundRect(this.K, 18.0f, 18.0f, this.f233332e);
                            this.f233332e.setColor(this.J.f233271n);
                            int i29 = i28 - 2;
                            this.K.set(i26 - i29, i27 - i29, i26 + i29, i29 + i27);
                            canvas.drawRoundRect(this.K, 18.0f, 18.0f, this.f233332e);
                        } else {
                            aVar = aVar3;
                            if (equals2) {
                                this.f233331d.setColor(this.J.f233268k);
                            } else {
                                int i36 = aVar4.f428063b;
                                GuildScheduleCalendarHelper guildScheduleCalendarHelper3 = this.J;
                                if (i36 == guildScheduleCalendarHelper3.f233279v.f428063b) {
                                    this.f233331d.setColor(guildScheduleCalendarHelper3.f233267j);
                                } else {
                                    this.f233331d.setColor(guildScheduleCalendarHelper3.f233269l);
                                }
                            }
                        }
                        float f17 = i26;
                        canvas.drawText(Integer.toString(aVar4.f428064c), f17, i27 - f16, this.f233331d);
                        if (this.J.A.containsKey(aVar4)) {
                            if (this.J.A.get(aVar4).intValue() == 1) {
                                i3 = this.J.f233268k;
                            } else {
                                i3 = this.J.f233269l;
                            }
                            this.f233332e.setColor(i3);
                            canvas.drawCircle(f17, this.f233334h + paddingTop, 10.0f, this.f233332e);
                        }
                        i16++;
                        aVar3 = aVar;
                    }
                }
                aVar = aVar3;
                i16++;
                aVar3 = aVar;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.f233333f = (getMeasuredWidth() - (((this.f233335i * 8) + getPaddingLeft()) + getPaddingRight())) / 7;
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

    public void setHelper(GuildScheduleCalendarHelper guildScheduleCalendarHelper) {
        this.J = guildScheduleCalendarHelper;
        this.f233334h = guildScheduleCalendarHelper.f233276s;
        this.f233335i = guildScheduleCalendarHelper.f233277t;
        this.F = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f233331d.setAntiAlias(true);
        this.f233331d.setTextSize(guildScheduleCalendarHelper.f233273p);
        this.f233331d.setTextAlign(Paint.Align.CENTER);
        this.f233331d.setTypeface(guildScheduleCalendarHelper.f233272o);
        Paint.FontMetrics fontMetrics = this.f233331d.getFontMetrics();
        this.I = (fontMetrics.top + fontMetrics.bottom) / 2.0f;
        this.f233332e.setAntiAlias(true);
        this.f233336m = Utils.n(31.0f, getContext().getResources());
    }

    public void setIndex(int i3) {
        GuildScheduleCalendarHelper guildScheduleCalendarHelper;
        if (i3 != this.C && (guildScheduleCalendarHelper = this.J) != null) {
            guildScheduleCalendarHelper.f(this.D, i3);
        }
        this.C = i3;
        invalidate();
    }

    public GuildWeekView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildWeekView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f233331d = new Paint();
        this.f233332e = new Paint();
        this.C = -1;
        this.D = new py1.a[7];
        this.K = new RectF();
        this.L = AppCompatResources.getColorStateList(getContext(), R.color.qui_button_text_primary_default);
        setOnClickListener(this);
    }
}
