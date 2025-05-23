package jp;

import android.content.Context;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import cooperation.qzone.util.QZLog;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements IphonePickerView.PickerViewAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final int f410764a;

    /* renamed from: b, reason: collision with root package name */
    private final int f410765b;

    /* renamed from: c, reason: collision with root package name */
    private Calendar f410766c;

    /* renamed from: d, reason: collision with root package name */
    private long f410767d;

    /* renamed from: e, reason: collision with root package name */
    private final int f410768e;

    public b() {
        Calendar calendar = Calendar.getInstance();
        this.f410766c = calendar;
        int maximum = calendar.getMaximum(1);
        this.f410764a = maximum;
        int minimum = this.f410766c.getMinimum(1);
        this.f410765b = minimum;
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1, minimum);
        this.f410767d = calendar2.getTimeInMillis();
        this.f410768e = (int) ((this.f410766c.getTimeInMillis() - this.f410767d) / 86400000);
        QZLog.d("QzoneTimeAdpater", 2, "MIN_YEAR:" + minimum + ", MAX_YEAR:" + maximum);
    }

    public static c a(Context context) {
        b bVar = new b();
        c cVar = new c(context, bVar);
        f(cVar, bVar);
        return cVar;
    }

    @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
    public int getColumnCount() {
        return 3;
    }

    @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
    public String getText(int i3, int i16) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 0) {
            this.f410766c.setTimeInMillis(this.f410767d + (i16 * 86400000));
            int i17 = this.f410766c.get(1);
            int i18 = this.f410766c.get(2);
            int i19 = this.f410766c.get(5);
            String valueOf = String.valueOf(i18 + 1);
            sb5.append(i17);
            sb5.append("\u5e74");
            sb5.append(valueOf);
            sb5.append("\u6708");
            sb5.append(i19);
        } else if (i3 == 1) {
            sb5.append(i16);
            sb5.append("\u65f6");
            this.f410766c.set(11, i16);
        } else if (i3 == 2) {
            sb5.append(i16);
            this.f410766c.set(12, i16);
        }
        return sb5.toString();
    }

    public static Date b(c cVar, int i3) {
        if (cVar == null || !(cVar.n() instanceof b)) {
            return null;
        }
        b bVar = (b) cVar.n();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(bVar.f410767d + (i3 * 86400000));
        return calendar.getTime();
    }

    public static long e(c cVar, int i3, int i16, int i17) {
        if (cVar != null && (cVar.n() instanceof b)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(b(cVar, i3));
            calendar.set(11, c(cVar, i16));
            calendar.set(12, d(cVar, i17));
            return calendar.getTimeInMillis();
        }
        QZLog.w("QzoneTimeAdpater", "getTimeStamp error:timePicker =null,or timePicker is not created by QzoneTimeAdpater");
        return 0L;
    }

    public static void f(c cVar, b bVar) {
        if (cVar == null || bVar == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        cVar.r(0, bVar.f410768e);
        cVar.r(1, calendar.get(11));
        cVar.r(2, calendar.get(12));
    }

    @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
    public int getRowCount(int i3) {
        if (i3 == 0) {
            return (this.f410764a - this.f410765b) + 1;
        }
        if (i3 != 1) {
            return i3 != 2 ? 0 : 60;
        }
        return 24;
    }

    public static int c(c cVar, int i3) {
        return i3;
    }

    public static int d(c cVar, int i3) {
        return i3;
    }
}
