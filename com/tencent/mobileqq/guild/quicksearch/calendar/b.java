package com.tencent.mobileqq.guild.quicksearch.calendar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/calendar/b;", "Lcom/tencent/mobileqq/widget/selectorview/h;", "", "u", "y", "v", "Ljava/util/Calendar;", "currentCalendar", "minCalendar", "maxCalendar", HippyTKDListViewAdapter.X, "t", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "g", "Ljava/util/Calendar;", tl.h.F, "", "i", "I", "yearIndex", "j", "monthIndex", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "k", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends com.tencent.mobileqq.widget.selectorview.h {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Calendar minCalendar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Calendar maxCalendar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int yearIndex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int monthIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/calendar/b$b", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "", "getColumnCount", "column", "getRowCount", "row", "", "getText", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.calendar.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7867b implements QPickerView.e {
        C7867b() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int column) {
            int i3;
            if (column != 0) {
                if (column != 1) {
                    return 0;
                }
                if (b.this.minCalendar.get(1) == b.this.maxCalendar.get(1)) {
                    i3 = (b.this.maxCalendar.get(2) + 1) - (b.this.minCalendar.get(2) + 1);
                } else if (b.this.yearIndex + b.this.minCalendar.get(1) == b.this.maxCalendar.get(1)) {
                    i3 = b.this.maxCalendar.get(2);
                } else {
                    if (b.this.yearIndex != 0) {
                        return 12;
                    }
                    return (12 - (b.this.minCalendar.get(2) + 1)) + 1;
                }
                return i3 + 1;
            }
            return (b.this.maxCalendar.get(1) - b.this.minCalendar.get(1)) + 1;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        @NotNull
        public String getText(int column, int row) {
            int i3 = 1;
            if (column != 0) {
                if (column != 1) {
                    return "";
                }
                if (b.this.yearIndex == 0) {
                    i3 = 1 + b.this.minCalendar.get(2);
                }
                return (i3 + row) + HardCodeUtil.qqStr(R.string.f2039751n);
            }
            return (b.this.minCalendar.get(1) + row) + HardCodeUtil.qqStr(R.string.f2039951p);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        CalendarEx calendarEx = CalendarEx.f214714a;
        this.minCalendar = calendarEx.c(1900, 1, 1);
        this.maxCalendar = calendarEx.e();
        k("\u9009\u62e9\u65e5\u671f");
    }

    private final void u() {
        this.f317413c.j(new C7867b());
    }

    private final void v() {
        QPickerView qPickerView = this.f317413c;
        if (qPickerView != null) {
            qPickerView.setPickListener(new QPickerView.f() { // from class: com.tencent.mobileqq.guild.quicksearch.calendar.a
                @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.f
                public final void onItemSelected(int i3, int i16) {
                    b.w(b.this, i3, i16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(b this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.monthIndex = i16;
            }
        } else {
            this$0.yearIndex = i16;
        }
        if (i3 == 0) {
            this$0.monthIndex = 0;
            this$0.f317413c.setSelection(1, 0);
            QPickerView qPickerView = this$0.f317413c;
            if (qPickerView != null) {
                qPickerView.m(1);
            }
        }
    }

    private final void y() {
        this.f317413c.setSelection(0, this.yearIndex);
        this.f317413c.m(0);
        this.f317413c.setSelection(1, this.monthIndex);
        this.f317413c.m(1);
    }

    @NotNull
    public final View s() {
        ViewGroup b06 = this.f317412b.b0();
        Intrinsics.checkNotNullExpressionValue(b06, "actionSheet.containerView");
        return b06;
    }

    @NotNull
    public final Calendar t() {
        int i3;
        int i16 = this.yearIndex + this.minCalendar.get(1);
        if (this.yearIndex == 0) {
            i3 = this.monthIndex + this.minCalendar.get(2) + 1;
        } else {
            i3 = this.monthIndex + 1;
        }
        return CalendarEx.f214714a.c(i16, i3, 1);
    }

    public final void x(@NotNull Calendar currentCalendar, @NotNull Calendar minCalendar, @NotNull Calendar maxCalendar) {
        Intrinsics.checkNotNullParameter(currentCalendar, "currentCalendar");
        Intrinsics.checkNotNullParameter(minCalendar, "minCalendar");
        Intrinsics.checkNotNullParameter(maxCalendar, "maxCalendar");
        this.minCalendar = minCalendar;
        this.maxCalendar = maxCalendar;
        int i3 = currentCalendar.get(1) - minCalendar.get(1);
        this.yearIndex = i3;
        if (i3 == 0) {
            this.monthIndex = (currentCalendar.get(2) + 1) - (minCalendar.get(2) + 1);
        } else {
            this.monthIndex = (currentCalendar.get(2) + 1) - 1;
        }
        u();
        y();
        v();
    }
}
