package com.tencent.mobileqq.guild.home.schedule.models;

import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\u001d\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\t8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\u00048VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleEmptyPlaceholderItem;", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "Lpy1/a;", "date", "", "isAdmin", "b", "", "toString", "", "hashCode", "", "other", "equals", "Lpy1/a;", "d", "()Lpy1/a;", "c", "Z", "e", "()Z", "I", "getType", "()I", "type", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "f", "Lkotlin/Lazy;", "a", "isToday", "<init>", "(Lpy1/a;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class ScheduleEmptyPlaceholderItem implements d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final py1.a date;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAdmin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isToday;

    public ScheduleEmptyPlaceholderItem(@NotNull py1.a date, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(date, "date");
        this.date = date;
        this.isAdmin = z16;
        this.type = 5;
        this.text = "EmptyPlaceHolder(admin=" + z16 + ")";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.home.schedule.models.ScheduleEmptyPlaceholderItem$isToday$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                CalendarEx calendarEx = CalendarEx.f214714a;
                return Boolean.valueOf(CalendarExKt.e(calendarEx.d(ScheduleEmptyPlaceholderItem.this.getDate().d()), calendarEx.e()));
            }
        });
        this.isToday = lazy;
    }

    public static /* synthetic */ ScheduleEmptyPlaceholderItem c(ScheduleEmptyPlaceholderItem scheduleEmptyPlaceholderItem, py1.a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = scheduleEmptyPlaceholderItem.date;
        }
        if ((i3 & 2) != 0) {
            z16 = scheduleEmptyPlaceholderItem.isAdmin;
        }
        return scheduleEmptyPlaceholderItem.b(aVar, z16);
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    /* renamed from: a */
    public boolean getIsToday() {
        return ((Boolean) this.isToday.getValue()).booleanValue();
    }

    @NotNull
    public final ScheduleEmptyPlaceholderItem b(@NotNull py1.a date, boolean isAdmin) {
        Intrinsics.checkNotNullParameter(date, "date");
        return new ScheduleEmptyPlaceholderItem(date, isAdmin);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final py1.a getDate() {
        return this.date;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsAdmin() {
        return this.isAdmin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScheduleEmptyPlaceholderItem)) {
            return false;
        }
        ScheduleEmptyPlaceholderItem scheduleEmptyPlaceholderItem = (ScheduleEmptyPlaceholderItem) other;
        if (Intrinsics.areEqual(this.date, scheduleEmptyPlaceholderItem.date) && this.isAdmin == scheduleEmptyPlaceholderItem.isAdmin) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    @NotNull
    public String getText() {
        return this.text;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.date.hashCode() * 31;
        boolean z16 = this.isAdmin;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "ScheduleEmptyPlaceholderItem(date=" + this.date + ", isAdmin=" + this.isAdmin + ")";
    }
}
