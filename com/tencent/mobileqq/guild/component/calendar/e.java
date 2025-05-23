package com.tencent.mobileqq.guild.component.calendar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0016R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\n \u0017*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u0019R\u0016\u0010&\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0015\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ljava/util/Calendar;", "date", "", "i0", "position", "j0", "startMonthDate", "endMonthDate", "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "getItemCount", "holder", "onBindViewHolder", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "itemCount", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Calendar;", "tempDay", "D", "l0", "()Ljava/util/Calendar;", "setStartMonthDate", "(Ljava/util/Calendar;)V", "E", "k0", "setEndMonthDate", UserInfo.SEX_FEMALE, "anchorDate", "G", "anchorDateIndex", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Calendar tempDay = Calendar.getInstance();

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Calendar startMonthDate;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Calendar endMonthDate;

    /* renamed from: F, reason: from kotlin metadata */
    private Calendar anchorDate;

    /* renamed from: G, reason: from kotlin metadata */
    private int anchorDateIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int itemCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/guild/component/calendar/e$a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder {
        a(CalendarView calendarView) {
            super(calendarView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemCount;
    }

    public final int i0(@NotNull Calendar date) {
        Intrinsics.checkNotNullParameter(date, "date");
        if (this.anchorDate == null) {
            m0(this.startMonthDate, this.endMonthDate);
        }
        int i3 = this.anchorDateIndex;
        Calendar calendar = this.anchorDate;
        if (calendar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorDate");
            calendar = null;
        }
        return i3 + CalendarExKt.d(date, calendar);
    }

    @NotNull
    public final Calendar j0(int position) {
        if (this.anchorDate == null) {
            m0(this.startMonthDate, this.endMonthDate);
        }
        Calendar calendar = this.tempDay;
        Calendar calendar2 = this.anchorDate;
        if (calendar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorDate");
            calendar2 = null;
        }
        calendar.setTimeInMillis(calendar2.getTimeInMillis());
        this.tempDay.add(2, position - this.anchorDateIndex);
        Calendar tempDay = this.tempDay;
        Intrinsics.checkNotNullExpressionValue(tempDay, "tempDay");
        return tempDay;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: k0, reason: from getter */
    public final Calendar getEndMonthDate() {
        return this.endMonthDate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: l0, reason: from getter */
    public final Calendar getStartMonthDate() {
        return this.startMonthDate;
    }

    public final void m0(@Nullable Calendar startMonthDate, @Nullable Calendar endMonthDate) {
        this.startMonthDate = startMonthDate;
        this.endMonthDate = endMonthDate;
        if (startMonthDate != null && endMonthDate != null) {
            this.itemCount = CalendarExKt.d(endMonthDate, startMonthDate) + 1;
            this.anchorDate = startMonthDate;
            this.anchorDateIndex = 0;
            return;
        }
        if (startMonthDate != null) {
            this.itemCount = Integer.MAX_VALUE;
            this.anchorDate = startMonthDate;
            this.anchorDateIndex = 0;
        } else if (endMonthDate != null) {
            this.itemCount = Integer.MAX_VALUE;
            this.anchorDate = endMonthDate;
            this.anchorDateIndex = 2147483646;
        } else {
            this.itemCount = Integer.MAX_VALUE;
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
            this.anchorDate = calendar;
            this.anchorDateIndex = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.guild.component.calendar.CalendarView");
        CalendarView calendarView = (CalendarView) view;
        Calendar calendar = this.tempDay;
        Calendar calendar2 = this.anchorDate;
        Calendar calendar3 = null;
        if (calendar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorDate");
            calendar2 = null;
        }
        int i3 = calendar2.get(1);
        Calendar calendar4 = this.anchorDate;
        if (calendar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorDate");
            calendar4 = null;
        }
        int i16 = calendar4.get(2);
        Calendar calendar5 = this.anchorDate;
        if (calendar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorDate");
        } else {
            calendar3 = calendar5;
        }
        calendar.set(i3, i16, calendar3.get(5));
        this.tempDay.add(2, position - this.anchorDateIndex);
        Calendar tempDay = this.tempDay;
        Intrinsics.checkNotNullExpressionValue(tempDay, "tempDay");
        calendarView.K(tempDay);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        CalendarView calendarView = new CalendarView(context, null, 2, 0 == true ? 1 : 0);
        calendarView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        return new a(calendarView);
    }
}
