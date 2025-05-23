package com.tencent.mobileqq.widget.selectorview;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J$\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0013R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0013\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/widget/selectorview/e;", "Lcom/tencent/mobileqq/widget/selectorview/h;", "", "year", "month", "day", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "G", "E", BdhLogUtil.LogTag.Tag_Conn, "B", "J", "H", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "D", "g", "I", "dateMode", tl.h.F, "minYear", "i", "j", "k", "l", "yearIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "monthIndex", DomainData.DOMAIN_NAME, "dayIndex", "o", "currentYear", "p", "currentMonth", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "currentDay", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "r", "a", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e extends h {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int dateMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int minYear;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int year;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int month;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int day;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int yearIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int monthIndex;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int dayIndex;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int currentYear;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final int currentMonth;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final int currentDay;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/widget/selectorview/e$b", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "", "getColumnCount", "column", "getRowCount", "row", "", "getText", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements QPickerView.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            int i3 = e.this.dateMode;
            if (i3 == 0) {
                return 3;
            }
            if (i3 != 1 && i3 != 2) {
                return 3;
            }
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int column) {
            int i3;
            int E = e.this.E();
            int C = e.this.C();
            int B = e.this.B();
            if (column == E) {
                return (e.this.currentYear - e.this.minYear) + 1;
            }
            if (column == C) {
                if (e.this.yearIndex + e.this.minYear == e.this.currentYear) {
                    return e.this.currentMonth;
                }
                if (e.this.yearIndex != 0) {
                    return 12;
                }
                return (12 - e.this.currentMonth) + 1;
            }
            if (column == B) {
                if (e.this.yearIndex + e.this.minYear == e.this.currentYear && e.this.monthIndex + 1 == e.this.currentMonth) {
                    return e.this.currentDay;
                }
                Calendar calendar = Calendar.getInstance();
                calendar.set(1, e.this.yearIndex + e.this.minYear);
                if (e.this.yearIndex != 0) {
                    i3 = e.this.monthIndex;
                } else {
                    i3 = e.this.currentMonth - 1;
                }
                calendar.set(2, i3);
                calendar.set(5, 1);
                if (e.this.yearIndex == 0 && e.this.monthIndex == 0) {
                    return calendar.getActualMaximum(5) - e.this.currentDay;
                }
                return calendar.getActualMaximum(5);
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        @NotNull
        public String getText(int column, int row) {
            int E = e.this.E();
            int C = e.this.C();
            int B = e.this.B();
            if (column == E) {
                return (e.this.minYear + row) + HardCodeUtil.qqStr(R.string.f2039951p);
            }
            int i3 = 1;
            if (column == C) {
                StringBuilder sb5 = new StringBuilder();
                if (e.this.yearIndex == 0) {
                    i3 = e.this.currentMonth;
                }
                sb5.append(i3 + row);
                sb5.append(HardCodeUtil.qqStr(R.string.f2039751n));
                return sb5.toString();
            }
            if (column == B) {
                StringBuilder sb6 = new StringBuilder();
                if (e.this.yearIndex == 0 && e.this.monthIndex == 0) {
                    i3 = 1 + e.this.currentDay;
                }
                sb6.append(i3 + row);
                sb6.append(HardCodeUtil.qqStr(R.string.f2039651m));
                return sb6.toString();
            }
            return "";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.minYear = 1896;
        k(HardCodeUtil.qqStr(R.string.f2039851o));
        Calendar calendar = Calendar.getInstance();
        this.currentYear = calendar.get(1);
        this.currentMonth = calendar.get(2) + 1;
        this.currentDay = calendar.get(5);
    }

    private final int A(int year, int month, int day) {
        if (year > 0 && month > 0 && day > 0) {
            return 0;
        }
        if (year > 0 && month > 0) {
            return 1;
        }
        if (month <= 0 || day <= 0) {
            return 0;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int B() {
        int i3 = this.dateMode;
        if (i3 == 0) {
            return 2;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return 2;
            }
            return 1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int C() {
        int i3 = this.dateMode;
        if (i3 == 0 || i3 == 1 || i3 != 2) {
            return 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int E() {
        int i3 = this.dateMode;
        if (i3 == 0 || i3 == 1 || i3 != 2) {
            return 0;
        }
        return -1;
    }

    private final void G() {
        this.f317413c.j(new b());
    }

    private final void H() {
        QPickerView qPickerView = this.f317413c;
        if (qPickerView != null) {
            qPickerView.setPickListener(new QPickerView.f() { // from class: com.tencent.mobileqq.widget.selectorview.d
                @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.f
                public final void onItemSelected(int i3, int i16) {
                    e.I(e.this, i3, i16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(e this$0, int i3, int i16) {
        QPickerView qPickerView;
        QPickerView qPickerView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int E = this$0.E();
        int C = this$0.C();
        int B = this$0.B();
        if (i3 == E) {
            this$0.yearIndex = i16;
        } else if (i3 == C) {
            this$0.monthIndex = i16;
        } else if (i3 == B) {
            this$0.dayIndex = i16;
        }
        if (i3 == E || i3 == C) {
            if (C >= 0 && (qPickerView2 = this$0.f317413c) != null) {
                qPickerView2.m(C);
            }
            if (B >= 0 && (qPickerView = this$0.f317413c) != null) {
                qPickerView.m(B);
            }
        }
    }

    private final void J() {
        int E = E();
        int C = C();
        int B = B();
        if (E >= 0) {
            this.f317413c.setSelection(E, this.yearIndex);
            this.f317413c.m(E);
        }
        if (C >= 0) {
            this.f317413c.setSelection(C, this.monthIndex);
            this.f317413c.m(C);
        }
        if (B >= 0) {
            this.f317413c.setSelection(B, this.dayIndex);
            this.f317413c.m(B);
        }
    }

    public final long D() {
        int i3;
        int i16;
        int i17 = this.yearIndex;
        this.year = this.minYear + i17;
        int i18 = this.monthIndex;
        if (i17 == 0) {
            i3 = i18 + this.currentMonth;
        } else {
            i3 = i18 + 1;
        }
        this.month = i3;
        if (i17 == 0 && this.monthIndex == 0) {
            i16 = this.dayIndex + this.currentDay;
        } else {
            i16 = this.dayIndex;
        }
        this.day = i16 + 1;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.set(1, this.year);
        calendar.set(2, this.month - 1);
        calendar.set(5, this.day);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public final void F(int year, int month, int day) {
        int i3;
        this.year = year;
        this.month = month;
        this.day = day;
        int i16 = year - this.minYear;
        this.yearIndex = i16;
        int i17 = 0;
        if (i16 == 0) {
            i3 = 0;
        } else {
            i3 = month - 1;
        }
        this.monthIndex = i3;
        if (i16 != 0) {
            i17 = day - 1;
        }
        this.dayIndex = i17;
        this.dateMode = A(year, month, day);
        G();
        J();
        H();
    }

    public final int z() {
        int i3;
        int i16;
        int i17 = this.yearIndex;
        int i18 = this.minYear + i17;
        this.year = i18;
        int i19 = this.monthIndex;
        if (i17 == 0) {
            i3 = i19 + this.currentMonth;
        } else {
            i3 = i19 + 1;
        }
        this.month = i3;
        if (i17 == 0 && this.monthIndex == 0) {
            i16 = this.dayIndex + this.currentDay;
        } else {
            i16 = this.dayIndex;
        }
        int i26 = i16 + 1;
        this.day = i26;
        return i26 | (i18 << 16) | (i3 << 8);
    }
}
