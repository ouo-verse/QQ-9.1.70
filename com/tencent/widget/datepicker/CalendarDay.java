package com.tencent.widget.datepicker;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CalendarDay implements Serializable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: d, reason: collision with root package name */
    private static Calendar f384741d = null;
    private static final long serialVersionUID = -5456695978688356202L;
    private Calendar calendar;
    public int day;
    public int month;
    public int year;

    public CalendarDay(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance();
        }
        this.calendar.set(i3, i16, i17, 0, 0, 0);
        this.year = i3;
        this.month = i16;
        this.day = i17;
    }

    public static long dayToTimeMillis(int i3, int i16, int i17) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i3, i16, i17, 0, 0, 0);
        return calendar.getTimeInMillis();
    }

    public static synchronized int getDaysInMonth(int i3, int i16) {
        int actualMaximum;
        synchronized (CalendarDay.class) {
            if (f384741d == null) {
                f384741d = Calendar.getInstance();
            }
            f384741d.clear();
            f384741d.set(1, i3);
            f384741d.set(2, i16);
            actualMaximum = f384741d.getActualMaximum(5);
        }
        return actualMaximum;
    }

    public long getTimeInMillis() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        Calendar calendar = this.calendar;
        if (calendar != null) {
            return calendar.getTimeInMillis();
        }
        return 0L;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "{ year: " + this.year + ", month: " + this.month + ", day: " + this.day + " }";
    }

    public CalendarDay(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance();
        }
        this.calendar.setTimeInMillis(j3);
        this.month = this.calendar.get(2);
        this.year = this.calendar.get(1);
        this.day = this.calendar.get(5);
    }
}
