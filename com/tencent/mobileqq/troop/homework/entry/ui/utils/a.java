package com.tencent.mobileqq.troop.homework.entry.ui.utils;

import android.content.Context;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements IphonePickerView.PickerViewAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final int f297034a;

    /* renamed from: b, reason: collision with root package name */
    private final int f297035b;

    /* renamed from: c, reason: collision with root package name */
    private Calendar f297036c;

    /* renamed from: d, reason: collision with root package name */
    private long f297037d;

    /* renamed from: e, reason: collision with root package name */
    private final int f297038e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        this.f297036c = calendar;
        this.f297034a = calendar.getMaximum(1);
        int minimum = this.f297036c.getMinimum(1);
        this.f297035b = minimum;
        this.f297036c.add(5, 1);
        this.f297036c.set(11, 8);
        this.f297036c.set(12, 0);
        this.f297036c.set(13, 0);
        this.f297036c.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1, minimum);
        calendar2.set(5, 0);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        this.f297037d = calendar2.getTimeInMillis();
        this.f297038e = (int) ((this.f297036c.getTimeInMillis() - this.f297037d) / 86400000);
    }

    public static b a(Context context) {
        a aVar = new a();
        b bVar = new b(context, aVar);
        g(bVar, aVar);
        return bVar;
    }

    public static Date b(b bVar, int i3) {
        if (bVar != null && (bVar.n() instanceof a)) {
            a aVar = (a) bVar.n();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(aVar.f297037d + (i3 * 86400000));
            return calendar.getTime();
        }
        return null;
    }

    public static long c() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        calendar.set(11, 8);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    public static long f(b bVar, int i3, int i16, int i17) {
        if (bVar != null && (bVar.n() instanceof a)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b(bVar, i3));
            calendar.set(11, d(bVar, i16));
            calendar.set(12, e(bVar, i17));
            return calendar.getTimeInMillis();
        }
        return 0L;
    }

    public static void g(b bVar, a aVar) {
        if (bVar != null && aVar != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, 1);
            calendar.set(11, 8);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            bVar.q(0, aVar.f297038e);
            bVar.q(1, calendar.get(11));
            bVar.q(2, calendar.get(12));
        }
    }

    @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
    public int getColumnCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
    public int getRowCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return 0;
                }
                return 60;
            }
            return 24;
        }
        return (this.f297034a - this.f297035b) + 1;
    }

    @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
    public String getText(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        StringBuilder sb5 = new StringBuilder();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    sb5.append(i16);
                    this.f297036c.set(12, i16);
                }
            } else {
                sb5.append(i16);
                this.f297036c.set(11, i16);
            }
        } else {
            this.f297036c.setTimeInMillis(this.f297037d + (i16 * 86400000));
            int i17 = this.f297036c.get(1);
            int i18 = this.f297036c.get(2);
            int i19 = this.f297036c.get(5);
            String valueOf = String.valueOf(i18 + 1);
            sb5.append(i17);
            sb5.append("\u5e74");
            sb5.append(valueOf);
            sb5.append("\u6708");
            sb5.append(i19);
            sb5.append("\u65e5");
        }
        return sb5.toString();
    }

    public static int d(b bVar, int i3) {
        return i3;
    }

    public static int e(b bVar, int i3) {
        return i3;
    }
}
