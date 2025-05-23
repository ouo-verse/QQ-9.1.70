package com.tencent.mobileqq.guild.quicksearch.calendar;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.home.schedule.delegates.datepicker.PlaceHolderDelegate;
import com.tencent.mobileqq.guild.home.schedule.models.a;
import com.tencent.mobileqq.guild.quicksearch.calendar.delegate.FeedSearchDayItemDelegate;
import com.tencent.mobileqq.guild.quicksearch.calendar.delegate.FeedSearchMonthItemDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u001b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u000b\u0010\fR#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/calendar/c;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", "", "I", "Lkotlin/jvm/functions/Function1;", "getOnPickDate", "()Lkotlin/jvm/functions/Function1;", "onPickDate", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "J", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<com.tencent.mobileqq.guild.home.schedule.models.a> {

    @NotNull
    private static final a K = new a();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Function1<a.CalendarDay, Unit> onPickDate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/calendar/c$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "p0", "p1", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.home.schedule.models.a> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.home.schedule.models.a p06, @NotNull com.tencent.mobileqq.guild.home.schedule.models.a p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.home.schedule.models.a p06, @NotNull com.tencent.mobileqq.guild.home.schedule.models.a p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            if (p06.getType() == p16.getType() && p06.getId() == p16.getId()) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Function1<? super a.CalendarDay, Unit> onPickDate) {
        super(K);
        Intrinsics.checkNotNullParameter(onPickDate, "onPickDate");
        this.onPickDate = onPickDate;
        this.D = false;
        this.f236209m.a(0, new FeedSearchDayItemDelegate(onPickDate));
        this.f236209m.a(1, new FeedSearchMonthItemDelegate());
        this.f236209m.a(2, new PlaceHolderDelegate());
    }
}
