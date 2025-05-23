package jp;

import android.content.Context;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import cooperation.qzone.util.QZLog;
import java.util.Calendar;
import jp.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements IphonePickerView.PickerViewAdapter {

    /* renamed from: c, reason: collision with root package name */
    private static final int f410759c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f410760d;

    /* renamed from: a, reason: collision with root package name */
    private Calendar f410761a = Calendar.getInstance();

    /* renamed from: b, reason: collision with root package name */
    private c.e f410762b;

    static {
        Calendar calendar = Calendar.getInstance();
        f410759c = calendar.getMaximum(1);
        f410760d = calendar.getMinimum(1);
    }

    public a() {
        QZLog.d("QzoneDateAdpater", 2, "MIN_YEAR:" + f410760d + ", MAX_YEAR:" + f410759c);
        this.f410762b = new C10603a();
    }

    public static c c(Context context) {
        a aVar = new a();
        c cVar = new c(context, aVar);
        cVar.o(aVar.f410762b);
        h(cVar);
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
            sb5.append(String.valueOf(i16 + f410760d));
            sb5.append("\u5e74");
        } else if (i3 == 1) {
            sb5.append(i16 + 1);
            sb5.append("\u6708");
        } else if (i3 == 2) {
            sb5.append(i16 + 1);
        }
        return sb5.toString();
    }

    public static int d(c cVar, int i3) {
        if (cVar == null || !(cVar.n() instanceof a)) {
            return -1;
        }
        return i3 + 1;
    }

    public static int e(c cVar, int i3) {
        if (cVar == null || !(cVar.n() instanceof a)) {
            return -1;
        }
        return i3;
    }

    public static long f(c cVar, int i3, int i16, int i17) {
        if (cVar != null && (cVar.n() instanceof a)) {
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(1, g(cVar, i3));
            calendar.set(2, e(cVar, i16));
            calendar.set(5, d(cVar, i17));
            return calendar.getTimeInMillis();
        }
        QZLog.w("QzoneDateAdpater", "getTimeStamp error:timePicker =null,or timePicker is not created by QzoneTimeAdpater");
        return 0L;
    }

    public static int g(c cVar, int i3) {
        if (cVar == null || !(cVar.n() instanceof a)) {
            return -1;
        }
        return i3 + f410760d;
    }

    public static void h(c cVar) {
        if (cVar != null) {
            Calendar calendar = Calendar.getInstance();
            cVar.r(0, calendar.get(1) - f410760d);
            cVar.r(1, calendar.get(2));
            cVar.r(2, calendar.get(5) - 1);
        }
    }

    /* compiled from: P */
    /* renamed from: jp.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10603a implements c.e {
        C10603a() {
        }

        @Override // jp.c.e
        public void onItemSelected(int i3, int i16) {
            if (i3 == 0) {
                a.this.f410761a.set(1, i16 + a.f410760d);
            } else {
                if (i3 != 1) {
                    return;
                }
                a.this.f410761a.set(2, i16);
            }
        }
    }

    @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
    public int getRowCount(int i3) {
        if (i3 == 0) {
            return (f410759c - f410760d) + 1;
        }
        if (i3 == 1) {
            return 12;
        }
        if (i3 != 2) {
            return 0;
        }
        return this.f410761a.getActualMaximum(5);
    }
}
