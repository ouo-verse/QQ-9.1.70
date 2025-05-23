package com.tencent.widget.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.TokenResUtils;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SimpleMonthView extends View {
    static IPatchRedirector $redirector_;
    protected static int F0;
    protected static int G0;
    protected static int H0;
    protected static int I0;
    protected static int J0;
    protected static int K0;
    protected static int L0;
    protected static int M0;
    private int A0;
    private boolean B0;
    protected Paint C;
    private int C0;
    protected int D;
    private DateFormatSymbols D0;
    protected int E;
    private a E0;
    protected int F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    protected boolean K;
    protected boolean L;
    protected int M;
    protected int N;
    protected int P;
    protected int Q;
    protected int R;
    protected int S;
    protected int T;
    protected int U;
    protected int V;
    protected int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f384745a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f384746b0;

    /* renamed from: c0, reason: collision with root package name */
    protected Boolean f384747c0;

    /* renamed from: d, reason: collision with root package name */
    protected int f384748d;

    /* renamed from: d0, reason: collision with root package name */
    protected int f384749d0;

    /* renamed from: e, reason: collision with root package name */
    private String f384750e;

    /* renamed from: e0, reason: collision with root package name */
    protected int f384751e0;

    /* renamed from: f, reason: collision with root package name */
    private String f384752f;

    /* renamed from: f0, reason: collision with root package name */
    protected int f384753f0;

    /* renamed from: g0, reason: collision with root package name */
    protected ArrayList<MessageRecord> f384754g0;

    /* renamed from: h, reason: collision with root package name */
    protected Paint f384755h;

    /* renamed from: h0, reason: collision with root package name */
    final Time f384756h0;

    /* renamed from: i, reason: collision with root package name */
    protected Paint f384757i;

    /* renamed from: i0, reason: collision with root package name */
    private final Calendar f384758i0;

    /* renamed from: j0, reason: collision with root package name */
    private final Calendar f384759j0;

    /* renamed from: k0, reason: collision with root package name */
    private final Boolean f384760k0;

    /* renamed from: l0, reason: collision with root package name */
    private CalendarDay f384761l0;

    /* renamed from: m, reason: collision with root package name */
    protected Paint f384762m;

    /* renamed from: m0, reason: collision with root package name */
    private CalendarDay f384763m0;

    /* renamed from: n0, reason: collision with root package name */
    int f384764n0;

    /* renamed from: o0, reason: collision with root package name */
    int f384765o0;

    /* renamed from: p0, reason: collision with root package name */
    int f384766p0;

    /* renamed from: q0, reason: collision with root package name */
    int f384767q0;

    /* renamed from: r0, reason: collision with root package name */
    int f384768r0;

    /* renamed from: s0, reason: collision with root package name */
    int f384769s0;

    /* renamed from: t0, reason: collision with root package name */
    int f384770t0;

    /* renamed from: u0, reason: collision with root package name */
    int f384771u0;

    /* renamed from: v0, reason: collision with root package name */
    int f384772v0;

    /* renamed from: w0, reason: collision with root package name */
    int f384773w0;

    /* renamed from: x0, reason: collision with root package name */
    int f384774x0;

    /* renamed from: y0, reason: collision with root package name */
    int f384775y0;

    /* renamed from: z0, reason: collision with root package name */
    int f384776z0;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface a {
        void n(SimpleMonthView simpleMonthView, CalendarDay calendarDay, Object obj);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29556);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        F0 = 32;
        H0 = 1;
        J0 = 10;
    }

    public SimpleMonthView(Context context, TypedArray typedArray) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) typedArray);
            return;
        }
        this.f384748d = 0;
        this.K = false;
        this.L = false;
        this.M = -1;
        this.N = -1;
        this.P = -1;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = -1;
        this.U = 1;
        this.V = 7;
        this.W = 7;
        this.f384745a0 = 0;
        this.f384749d0 = F0;
        this.f384764n0 = getResources().getColor(R.color.qui_common_text_primary);
        this.f384765o0 = -15550475;
        this.f384766p0 = -1;
        this.f384767q0 = getResources().getColor(R.color.qui_common_text_secondary);
        this.f384768r0 = -394757;
        this.f384769s0 = 2131933173;
        this.A0 = 0;
        this.B0 = false;
        this.C0 = 6;
        this.D0 = new DateFormatSymbols();
        this.f384759j0 = Calendar.getInstance();
        this.f384758i0 = Calendar.getInstance();
        Time time = new Time(Time.getCurrentTimezone());
        this.f384756h0 = time;
        time.setToNow();
        this.f384750e = "sans-serif";
        this.f384752f = "sans-serif";
        d();
        if (QQTheme.isNowThemeIsNight()) {
            this.f384768r0 = -16115667;
        }
        this.D = typedArray.getColor(jj2.b.L0, this.f384764n0);
        this.E = typedArray.getColor(jj2.b.N0, this.f384765o0);
        this.F = typedArray.getColor(jj2.b.M0, this.f384764n0);
        this.G = typedArray.getColor(jj2.b.O0, this.f384764n0);
        this.I = typedArray.getColor(jj2.b.P0, this.f384764n0);
        this.J = typedArray.getColor(jj2.b.Q0, this.f384765o0);
        this.H = typedArray.getColor(jj2.b.R0, this.f384766p0);
        if (TokenResUtils.useTokenRes3()) {
            this.E = getResources().getColor(R.color.qui_common_brand_standard);
            this.J = getResources().getColor(R.color.qui_common_brand_standard);
        }
        this.f384770t0 = x.c(context, 16.0f);
        this.f384771u0 = x.c(context, 10.0f);
        this.f384772v0 = x.c(context, 50.0f);
        this.f384773w0 = x.c(context, 342.0f);
        this.f384774x0 = x.c(context, 12.5f);
        this.f384775y0 = x.c(context, 14.0f);
        this.f384776z0 = x.c(context, 17.5f);
        I0 = typedArray.getDimensionPixelSize(jj2.b.X0, this.f384770t0);
        M0 = typedArray.getDimensionPixelSize(jj2.b.Z0, this.f384770t0);
        K0 = typedArray.getDimensionPixelSize(jj2.b.Y0, this.f384771u0);
        L0 = typedArray.getDimensionPixelOffset(jj2.b.V0, this.f384772v0);
        G0 = typedArray.getDimensionPixelSize(jj2.b.W0, this.f384776z0);
        this.f384749d0 = (typedArray.getDimensionPixelSize(jj2.b.K0, this.f384773w0) - L0) / 6;
        this.f384760k0 = Boolean.valueOf(typedArray.getBoolean(jj2.b.U0, true));
        this.f384747c0 = Boolean.valueOf(typedArray.getBoolean(jj2.b.T0, false));
        h();
    }

    private int a() {
        int i3;
        int e16 = e();
        int i16 = this.W;
        int i17 = this.V;
        int i18 = (e16 + i16) / i17;
        if ((e16 + i16) % i17 > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return i18 + i3;
    }

    private void c(Canvas canvas) {
        int i3 = (((this.f384751e0 - (this.f384748d * 2)) / this.V) - K0) / 2;
        int i16 = M0 + this.f384775y0;
        float f16 = i3;
        canvas.drawText(g(), f16, i16, this.f384762m);
        int i17 = this.f384751e0 + (this.f384748d * 2);
        int i18 = i16 + this.f384774x0 + 6;
        this.f384757i.setColor(-2171170);
        float f17 = i18;
        canvas.drawLine(f16, f17, i17, f17, this.f384757i);
    }

    private void d() {
        i();
    }

    private int e() {
        int i3 = this.f384745a0;
        int i16 = this.U;
        if (i3 < i16) {
            i3 += this.V;
        }
        return i3 - i16;
    }

    private String g() {
        long timeInMillis = this.f384758i0.getTimeInMillis();
        return DateUtils.formatDateRange(getContext(), timeInMillis, timeInMillis, 52);
    }

    private void j(CalendarDay calendarDay) {
        MessageRecord messageRecord;
        if (this.E0 != null && this.f384754g0 != null) {
            if (!this.f384760k0.booleanValue()) {
                int i3 = calendarDay.month;
                Time time = this.f384756h0;
                if (i3 == time.month && calendarDay.year == time.year && calendarDay.day < time.monthDay) {
                    return;
                }
            }
            int i16 = 0;
            while (true) {
                if (i16 < this.f384754g0.size()) {
                    messageRecord = this.f384754g0.get(i16);
                    if (new CalendarDay(messageRecord.time * 1000).day == calendarDay.day) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    messageRecord = null;
                    break;
                }
            }
            this.E0.n(this, calendarDay, messageRecord);
        }
    }

    private boolean k(int i3, Time time) {
        int i16 = this.f384753f0;
        int i17 = time.year;
        if (i16 >= i17 && ((i16 != i17 || this.f384746b0 >= time.month) && (this.f384746b0 != time.month || i3 >= time.monthDay))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void b(Canvas canvas) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        int i28 = 2;
        int i29 = (((this.f384749d0 + I0) / 2) - H0) + L0;
        int i36 = (this.f384751e0 - (this.f384748d * 2)) / (this.V * 2);
        int e16 = e();
        int i37 = this.f384753f0;
        CalendarDay calendarDay = this.f384763m0;
        int i38 = 1;
        if (i37 == calendarDay.year && this.f384746b0 == calendarDay.month) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = calendarDay.day;
        } else {
            i3 = this.W;
        }
        int i39 = 1;
        while (i39 <= i3) {
            if (this.f384754g0 != null) {
                for (int i46 = 0; i46 < this.f384754g0.size(); i46++) {
                    MessageRecord messageRecord = this.f384754g0.get(i46);
                    if (new CalendarDay(messageRecord.time * 1000).day == i39) {
                        if (QLog.isColorLevel()) {
                            QLog.d("DatePickerView", i28, "hasMessage : " + this.f384753f0 + "-" + (this.f384746b0 + i38) + "-" + i39 + " , MessageRecord:" + messageRecord);
                        }
                        i16 = i38;
                        int i47 = (((e16 * 2) + i38) * i36) + this.f384748d;
                        if (this.A0 == i39) {
                            Paint paint = this.C;
                            if (this.B0) {
                                i27 = this.f384769s0;
                            } else {
                                i27 = this.f384768r0;
                            }
                            paint.setColor(i27);
                            canvas.drawCircle(i47, i29 - (I0 / 3), G0, this.C);
                        }
                        i17 = this.f384746b0;
                        if ((i17 != this.P && this.M == i39 && this.R == this.f384753f0) || (i17 == this.Q && this.N == i39 && this.S == this.f384753f0)) {
                            i18 = i38;
                        } else {
                            i18 = 0;
                        }
                        if (i18 != 0) {
                            Paint paint2 = this.C;
                            int i48 = this.J;
                            if (i16 == 0) {
                                i48 = (i48 & 16777215) | HWColorFormat.COLOR_FormatVendorStartUnused;
                            }
                            paint2.setColor(i48);
                            if (this.f384747c0.booleanValue()) {
                                int i49 = G0;
                                int i56 = I0;
                                canvas.drawRoundRect(new RectF(i47 - i49, (i29 - (i56 / 3)) - i49, i47 + i49, (i29 - (i56 / 3)) + i49), 10.0f, 10.0f, this.C);
                            } else {
                                canvas.drawCircle(i47, i29 - (I0 / 3), G0, this.C);
                            }
                        }
                        if (!this.K && this.T == i39) {
                            this.f384757i.setColor(this.D);
                            if (i18 != 0) {
                                i26 = this.J;
                                if (i16 == 0) {
                                    i26 = (i26 & 16777215) | HWColorFormat.COLOR_FormatVendorStartUnused;
                                }
                            } else if (i16 != 0) {
                                i26 = this.G;
                            } else {
                                i26 = this.f384767q0;
                            }
                            this.C.setColor(i26);
                            canvas.drawText(HardCodeUtil.qqStr(R.string.u5l), i47, G0 + i29 + (I0 / 2), this.C);
                        } else {
                            this.f384757i.setColor(this.G);
                        }
                        if (i18 == 0) {
                            this.f384757i.setColor(this.H);
                        } else if (i16 == 0) {
                            this.f384757i.setColor(this.f384767q0);
                        } else if (!this.f384760k0.booleanValue() && k(i39, this.f384756h0)) {
                            Time time = this.f384756h0;
                            if (time.month == this.f384746b0 && time.year == this.f384753f0) {
                                this.f384757i.setColor(this.I);
                                i19 = 2;
                                this.f384757i.setTypeface(Typeface.defaultFromStyle(2));
                                canvas.drawText(Integer.toString(i39), i47, i29, this.f384757i);
                                e16++;
                                if (e16 == this.V) {
                                    i29 += this.f384749d0;
                                    e16 = 0;
                                }
                                i39++;
                                i28 = i19;
                                i38 = 1;
                            }
                        }
                        i19 = 2;
                        canvas.drawText(Integer.toString(i39), i47, i29, this.f384757i);
                        e16++;
                        if (e16 == this.V) {
                        }
                        i39++;
                        i28 = i19;
                        i38 = 1;
                    }
                }
            }
            i16 = 0;
            int i472 = (((e16 * 2) + i38) * i36) + this.f384748d;
            if (this.A0 == i39) {
            }
            i17 = this.f384746b0;
            if (i17 != this.P) {
            }
            i18 = 0;
            if (i18 != 0) {
            }
            if (!this.K) {
            }
            this.f384757i.setColor(this.G);
            if (i18 == 0) {
            }
            i19 = 2;
            canvas.drawText(Integer.toString(i39), i472, i29, this.f384757i);
            e16++;
            if (e16 == this.V) {
            }
            i39++;
            i28 = i19;
            i38 = 1;
        }
    }

    public CalendarDay f(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CalendarDay) iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17));
        }
        float f18 = this.f384748d;
        if (f16 >= f18) {
            int i3 = this.f384751e0;
            if (f16 <= i3 - r0) {
                int e16 = (((int) (((f16 - f18) * this.V) / ((i3 - r0) - r0))) - e()) + 1 + ((((int) (f17 - L0)) / this.f384749d0) * this.V);
                int i16 = this.f384746b0;
                if (i16 <= 11 && i16 >= 0 && CalendarDay.getDaysInMonth(this.f384753f0, i16) >= e16 && e16 >= 1) {
                    return new CalendarDay(this.f384753f0, this.f384746b0, e16);
                }
            }
        }
        return null;
    }

    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Paint paint = new Paint();
        this.f384762m = paint;
        paint.setFakeBoldText(true);
        this.f384762m.setAntiAlias(true);
        this.f384762m.setTextSize(M0);
        this.f384762m.setColor(this.E);
        this.f384762m.setTextAlign(Paint.Align.LEFT);
        this.f384762m.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.C = paint2;
        paint2.setFakeBoldText(true);
        this.C.setAntiAlias(true);
        this.C.setColor(this.J);
        this.C.setTextAlign(Paint.Align.CENTER);
        this.C.setStyle(Paint.Style.FILL);
        this.C.setTextSize(this.f384774x0);
        Paint paint3 = new Paint();
        this.f384755h = paint3;
        paint3.setAntiAlias(true);
        this.f384755h.setTextSize(K0);
        this.f384755h.setColor(this.F);
        this.f384755h.setTypeface(Typeface.create(this.f384750e, 0));
        this.f384755h.setStyle(Paint.Style.FILL);
        this.f384755h.setTextAlign(Paint.Align.CENTER);
        this.f384755h.setFakeBoldText(true);
        Paint paint4 = new Paint();
        this.f384757i = paint4;
        paint4.setFakeBoldText(false);
        this.f384757i.setAntiAlias(true);
        this.f384757i.setTextSize(I0);
        this.f384757i.setStyle(Paint.Style.FILL);
        this.f384757i.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
        } else {
            c(canvas);
            b(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(i3), (this.f384749d0 * this.C0) + L0 + this.f384771u0);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f384751e0 = i3;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CalendarDay f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            CalendarDay f17 = f(motionEvent.getX(), motionEvent.getY());
            if (f17 != null) {
                this.B0 = true;
                this.A0 = f17.day;
                invalidate();
            }
        } else if (this.B0 && motionEvent.getAction() != 2) {
            this.B0 = false;
            invalidate();
        }
        if (motionEvent.getAction() == 1 && (f16 = f(motionEvent.getX(), motionEvent.getY())) != null) {
            j(f16);
        }
        return true;
    }

    public void setMessageRecords(ArrayList<MessageRecord> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
        } else {
            this.f384754g0 = arrayList;
        }
    }

    public void setMonthParams(HashMap<String, Integer> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hashMap);
            return;
        }
        if (!hashMap.containsKey("month") && !hashMap.containsKey("year")) {
            throw new InvalidParameterException("You must specify month and year for this view");
        }
        setTag(hashMap);
        if (hashMap.containsKey("height")) {
            int intValue = hashMap.get("height").intValue();
            this.f384749d0 = intValue;
            int i3 = J0;
            if (intValue < i3) {
                this.f384749d0 = i3;
            }
        }
        if (hashMap.containsKey("selected_begin_day")) {
            this.M = hashMap.get("selected_begin_day").intValue();
        }
        if (hashMap.containsKey("selected_last_day")) {
            this.N = hashMap.get("selected_last_day").intValue();
        }
        if (hashMap.containsKey("selected_begin_month")) {
            this.P = hashMap.get("selected_begin_month").intValue();
        }
        if (hashMap.containsKey("selected_last_month")) {
            this.Q = hashMap.get("selected_last_month").intValue();
        }
        if (hashMap.containsKey("selected_begin_year")) {
            this.R = hashMap.get("selected_begin_year").intValue();
        }
        if (hashMap.containsKey("selected_last_year")) {
            this.S = hashMap.get("selected_last_year").intValue();
        }
        this.f384746b0 = hashMap.get("month").intValue();
        this.f384753f0 = hashMap.get("year").intValue();
        int i16 = 0;
        this.K = false;
        this.T = -1;
        this.f384758i0.set(2, this.f384746b0);
        this.f384758i0.set(1, this.f384753f0);
        this.f384758i0.set(5, 1);
        this.f384745a0 = this.f384758i0.get(7);
        if (hashMap.containsKey("week_start")) {
            this.U = hashMap.get("week_start").intValue();
        } else {
            this.U = this.f384758i0.getFirstDayOfWeek();
        }
        int daysInMonth = CalendarDay.getDaysInMonth(this.f384753f0, this.f384746b0);
        while (i16 < daysInMonth) {
            i16++;
            int i17 = this.f384753f0;
            Time time = this.f384756h0;
            if (i17 == time.year && this.f384746b0 == time.month && i16 == time.monthDay) {
                this.K = true;
                this.T = i16;
            }
            this.L = k(i16, time);
        }
        if (this.K) {
            daysInMonth = this.T;
        }
        this.W = daysInMonth;
        this.C0 = a();
    }

    public void setOnDayClickListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar);
        } else {
            this.E0 = aVar;
        }
    }

    public void setStartAndEndDate(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) calendarDay, (Object) calendarDay2);
        } else {
            this.f384761l0 = calendarDay;
            this.f384763m0 = calendarDay2;
        }
    }

    @QAutoInitMethod
    private void i() {
    }
}
