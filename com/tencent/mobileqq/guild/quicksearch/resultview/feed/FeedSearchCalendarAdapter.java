package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.component.calendar.CalendarExKt;
import com.tencent.mobileqq.guild.component.calendar.CalendarView;
import com.tencent.mobileqq.guild.component.calendar.d;
import com.tencent.mobileqq.guild.component.calendar.k;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.Calendar;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u001a\u001a\u00020\nR\u0014\u0010\u001d\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR(\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b \u0010!R(\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!RX\u0010-\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\n\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/FeedSearchCalendarAdapter;", "Lcom/tencent/mobileqq/guild/component/calendar/e;", "Ljava/util/Calendar;", "date", "", "s0", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/guild/component/calendar/d$a;", "calendarDay", "", "u0", "t0", "v0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "startDate", "endDate", "x0", "p0", "H", "I", "filterBoxReportType", "<set-?>", "Ljava/util/Calendar;", "r0", "()Ljava/util/Calendar;", "J", "q0", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "K", "Lkotlin/jvm/functions/Function2;", "getOnSelectionChanged", "()Lkotlin/jvm/functions/Function2;", "w0", "(Lkotlin/jvm/functions/Function2;)V", "onSelectionChanged", "L", "Z", "getSupportReselection", "()Z", "y0", "(Z)V", "supportReselection", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FeedSearchCalendarAdapter extends com.tencent.mobileqq.guild.component.calendar.e {

    /* renamed from: H, reason: from kotlin metadata */
    private final int filterBoxReportType = 3;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Calendar startDate;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Calendar endDate;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Function2<? super Calendar, ? super Calendar, Unit> onSelectionChanged;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean supportReselection;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/feed/FeedSearchCalendarAdapter$a", "Lcom/tencent/mobileqq/guild/component/calendar/k$a;", "Ljava/util/Calendar;", "date", "", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements k.a {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.component.calendar.k.a
        public boolean a(@NotNull Calendar date) {
            Intrinsics.checkNotNullParameter(date, "date");
            Calendar startDate = FeedSearchCalendarAdapter.this.getStartDate();
            Calendar endDate = FeedSearchCalendarAdapter.this.getEndDate();
            if (endDate == null) {
                endDate = startDate;
            }
            if (startDate == null || endDate == null) {
                return false;
            }
            if (!CalendarExKt.c(startDate, date) && !CalendarExKt.c(endDate, date) && (!date.after(startDate) || !date.before(endDate))) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.guild.component.calendar.k.a
        public boolean b(@NotNull Calendar date) {
            Intrinsics.checkNotNullParameter(date, "date");
            return FeedSearchCalendarAdapter.this.s0(date);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s0(Calendar date) {
        Calendar startMonthDate = getStartMonthDate();
        Calendar endMonthDate = getEndMonthDate();
        if (startMonthDate != null && endMonthDate != null) {
            if (!CalendarExKt.c(startMonthDate, date) && !CalendarExKt.c(endMonthDate, date) && (!date.after(startMonthDate) || !date.before(endMonthDate))) {
                return false;
            }
            return true;
        }
        if (startMonthDate == null && endMonthDate != null) {
            if (!date.before(endMonthDate) && !CalendarExKt.c(date, endMonthDate)) {
                return false;
            }
            return true;
        }
        if (startMonthDate == null) {
            return true;
        }
        if (!date.after(startMonthDate) && !CalendarExKt.c(date, startMonthDate)) {
            return false;
        }
        return true;
    }

    private final void t0() {
        Function2<? super Calendar, ? super Calendar, Unit> function2 = this.onSelectionChanged;
        if (function2 != null) {
            function2.invoke(this.startDate, this.endDate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(View view, d.CalendarDay calendarDay) {
        if (!s0(calendarDay.a())) {
            return;
        }
        v0(view, calendarDay);
        Calendar a16 = calendarDay.a();
        Calendar calendar = this.startDate;
        if (calendar == null) {
            this.startDate = a16;
            t0();
            return;
        }
        if (this.endDate != null) {
            if (this.supportReselection) {
                this.startDate = a16;
                this.endDate = null;
                t0();
                return;
            }
            return;
        }
        if (CalendarExKt.c(calendar, a16)) {
            return;
        }
        if (a16.before(calendar)) {
            this.endDate = this.startDate;
            this.startDate = a16;
            t0();
        } else {
            this.endDate = a16;
            t0();
        }
    }

    private final void v0(View view, d.CalendarDay calendarDay) {
        Map<String, ? extends Object> mapOf;
        bt btVar = bt.f235484a;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_filter_box_type", String.valueOf(this.filterBoxReportType)), TuplesKt.to("sgrp_tag_text", Integer.valueOf(calendarDay.getDay())));
        btVar.g(view, "em_sgrp_filter_box_second_tag", "clck", mapOf);
    }

    @Override // com.tencent.mobileqq.guild.component.calendar.e, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.guild.component.calendar.CalendarView");
        ((CalendarView) view).setOnPickDate(new FeedSearchCalendarAdapter$onBindViewHolder$1(this));
    }

    @Override // com.tencent.mobileqq.guild.component.calendar.e, androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecyclerView.ViewHolder onCreateViewHolder = super.onCreateViewHolder(parent, viewType);
        View view = onCreateViewHolder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.guild.component.calendar.CalendarView");
        CalendarView calendarView = (CalendarView) view;
        calendarView.addItemDecoration(new com.tencent.mobileqq.guild.component.calendar.j());
        calendarView.addItemDecoration(new com.tencent.mobileqq.guild.component.calendar.k(new a()));
        return onCreateViewHolder;
    }

    public final void p0() {
        this.startDate = null;
        this.endDate = null;
        t0();
    }

    @Nullable
    /* renamed from: q0, reason: from getter */
    public final Calendar getEndDate() {
        return this.endDate;
    }

    @Nullable
    /* renamed from: r0, reason: from getter */
    public final Calendar getStartDate() {
        return this.startDate;
    }

    public final void w0(@Nullable Function2<? super Calendar, ? super Calendar, Unit> function2) {
        this.onSelectionChanged = function2;
    }

    public final void x0(@Nullable Calendar startDate, @Nullable Calendar endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        t0();
    }

    public final void y0(boolean z16) {
        this.supportReselection = z16;
    }
}
