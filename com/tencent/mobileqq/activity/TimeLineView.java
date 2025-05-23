package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.BitSet;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TimeLineView extends FrameLayout {
    static IPatchRedirector $redirector_;
    public int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private Context f177297d;

    /* renamed from: e, reason: collision with root package name */
    private int f177298e;

    /* renamed from: f, reason: collision with root package name */
    private Calendar f177299f;

    /* renamed from: h, reason: collision with root package name */
    private Calendar f177300h;

    /* renamed from: i, reason: collision with root package name */
    private BitSet f177301i;

    /* renamed from: m, reason: collision with root package name */
    private AutoFitScrollView f177302m;

    public TimeLineView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            b(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.activity.aio.l.u(10.0f, this.f177297d.getResources());
    }

    void b(Context context) {
        this.f177297d = context;
        this.f177298e = context.getResources().getDisplayMetrics().widthPixels;
        Calendar calendar = Calendar.getInstance();
        this.f177300h = calendar;
        this.f177299f = calendar;
        this.f177301i = new BitSet();
        this.D = getResources().getColor(R.color.skin_blue2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        StringBuilder sb5;
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        int u16 = com.tencent.mobileqq.activity.aio.l.u(8.0f, this.f177297d.getResources());
        int u17 = com.tencent.mobileqq.activity.aio.l.u(2.0f, this.f177297d.getResources());
        int u18 = com.tencent.mobileqq.activity.aio.l.u(15.0f, this.f177297d.getResources());
        int u19 = com.tencent.mobileqq.activity.aio.l.u(7.5f, this.f177297d.getResources());
        int i3 = 1;
        int i16 = (this.f177298e >> 1) - (u17 >> 1);
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        paint2.setTextSize(this.f177297d.getResources().getDisplayMetrics().density * 12.0f);
        paint2.setColor(-8355712);
        paint2.setDither(true);
        Calendar calendar = (Calendar) this.f177299f.clone();
        int i17 = 0;
        if (!this.f177301i.get(0)) {
            return;
        }
        while (true) {
            if (!calendar.before(this.f177300h) && !calendar.equals(this.f177300h)) {
                return;
            }
            int i18 = calendar.get(2) + i3;
            int i19 = calendar.get(5);
            Rect rect = new Rect();
            if (i3 != i19 && i19 != 15) {
                rect.left = i16;
                rect.top = getHeight() - u19;
                rect.right = rect.left + u17;
                rect.bottom = getHeight();
                c16 = 0;
            } else {
                rect.left = i16;
                rect.top = getHeight() - u18;
                rect.right = rect.left + u17;
                rect.bottom = getHeight();
                if (i19 == i3) {
                    sb5 = new StringBuilder();
                    sb5.append(i18);
                    sb5.append(HardCodeUtil.qqStr(R.string.u5o));
                } else {
                    sb5 = new StringBuilder();
                    sb5.append(i18);
                    sb5.append("-");
                    sb5.append(i19);
                }
                String sb6 = sb5.toString();
                c16 = 0;
                canvas.drawText(sb6, ((u17 / 2) + i16) - (paint2.measureText(sb6) / 2.0f), (getHeight() >> 1) - com.tencent.mobileqq.activity.aio.l.u(3.0f, this.f177297d.getResources()), paint2);
            }
            i16 += u16 + u17;
            if (this.f177301i.get(i17)) {
                paint.setColor(this.D);
            } else {
                paint.setColor(-3355444);
            }
            canvas.drawRect(rect, paint);
            i3 = 1;
            calendar.add(5, 1);
            i17++;
        }
    }

    public void setDate(QQAppInterface qQAppInterface, Calendar calendar, Calendar calendar2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, qQAppInterface, calendar, calendar2, Boolean.valueOf(z16));
            return;
        }
        if (calendar != null && calendar2 != null) {
            this.f177299f = (Calendar) calendar.clone();
            this.f177300h = (Calendar) calendar2.clone();
            StringBuilder sb5 = new StringBuilder("setDate date: ");
            if (QLog.isColorLevel()) {
                int i3 = this.f177299f.get(1);
                int i16 = this.f177299f.get(2) + 1;
                int i17 = this.f177299f.get(5);
                sb5.append(i3);
                sb5.append("-");
                sb5.append(i16);
                sb5.append("-");
                sb5.append(i17);
                sb5.append(" ~ ");
                int i18 = this.f177300h.get(1);
                int i19 = this.f177300h.get(2) + 1;
                int i26 = this.f177300h.get(5);
                sb5.append(i18);
                sb5.append("-");
                sb5.append(i19);
                sb5.append("-");
                sb5.append(i26);
                sb5.append(", isLoc: ");
                sb5.append(z16);
            }
            int timeInMillis = (int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000);
            this.C = timeInMillis;
            this.f177302m.setFitWidth((timeInMillis * a()) + this.f177298e, a());
            this.f177302m.b();
            if (QLog.isColorLevel()) {
                sb5.append(", mDataSize: ");
                sb5.append(this.C);
                sb5.append(", max scrollView Width: ");
                sb5.append(this.f177302m.f174998e);
                sb5.append(", item width: ");
                sb5.append(a());
                sb5.append(",displayWidth: ");
                sb5.append(this.f177298e);
                QLog.d("TimeLineView", 2, sb5.toString());
            }
            requestLayout();
            invalidate();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TimeLineView", 2, "setDate date is null");
        }
    }

    public TimeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            b(context);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public TimeLineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            b(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
