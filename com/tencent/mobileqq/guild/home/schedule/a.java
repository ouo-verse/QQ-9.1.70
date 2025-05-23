package com.tencent.mobileqq.guild.home.schedule;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.home.schedule.delegates.datepicker.DayItemDelegate;
import com.tencent.mobileqq.guild.home.schedule.delegates.datepicker.MonthItemDelegate;
import com.tencent.mobileqq.guild.home.schedule.delegates.datepicker.PlaceHolderDelegate;
import com.tencent.mobileqq.guild.home.schedule.models.a;
import com.tencent.mobileqq.guild.widget.adapterdelegates.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B/\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u00038\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "Lkotlin/Function1;", "", "", "I", "Lkotlin/jvm/functions/Function1;", "getOnPickDate", "()Lkotlin/jvm/functions/Function1;", "onPickDate", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$b;", "J", "getOnReachMonth", "onReachMonth", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "K", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends d<com.tencent.mobileqq.guild.home.schedule.models.a> {

    @NotNull
    private static final C7792a L = new C7792a();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Function1<Long, Unit> onPickDate;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Function1<a.CalendarMonth, Unit> onReachMonth;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "p0", "p1", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7792a extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.home.schedule.models.a> {
        C7792a() {
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
    public a(@NotNull Function1<? super Long, Unit> onPickDate, @NotNull Function1<? super a.CalendarMonth, Unit> onReachMonth) {
        super(L);
        Intrinsics.checkNotNullParameter(onPickDate, "onPickDate");
        Intrinsics.checkNotNullParameter(onReachMonth, "onReachMonth");
        this.onPickDate = onPickDate;
        this.onReachMonth = onReachMonth;
        this.D = false;
        this.f236209m.a(0, new DayItemDelegate(onPickDate));
        this.f236209m.a(1, new MonthItemDelegate(onReachMonth));
        this.f236209m.a(2, new PlaceHolderDelegate());
    }
}
