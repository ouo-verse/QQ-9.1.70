package com.tencent.mobileqq.guild.home.schedule.models;

import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\b8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleInfoItem;", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lpy1/a;", "b", "Lpy1/a;", "()Lpy1/a;", "date", "Lcom/tencent/mobileqq/qqguildsdk/data/GuildScheduleInfo;", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/GuildScheduleInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/GuildScheduleInfo;", "info", "d", "I", "getType", "()I", "type", "e", "Lkotlin/Lazy;", "a", "()Z", "isToday", "getText", "()Ljava/lang/String;", "text", "<init>", "(Lpy1/a;Lcom/tencent/mobileqq/qqguildsdk/data/GuildScheduleInfo;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class ScheduleInfoItem implements d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final py1.a date;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GuildScheduleInfo info;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isToday;

    public ScheduleInfoItem(@NotNull py1.a date, @NotNull GuildScheduleInfo info) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(info, "info");
        this.date = date;
        this.info = info;
        this.type = 1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.home.schedule.models.ScheduleInfoItem$isToday$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                CalendarEx calendarEx = CalendarEx.f214714a;
                return Boolean.valueOf(CalendarExKt.e(calendarEx.d(ScheduleInfoItem.this.getInfo().getDateMs()), calendarEx.e()));
            }
        });
        this.isToday = lazy;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    /* renamed from: a */
    public boolean getIsToday() {
        return ((Boolean) this.isToday.getValue()).booleanValue();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final py1.a getDate() {
        return this.date;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildScheduleInfo getInfo() {
        return this.info;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScheduleInfoItem)) {
            return false;
        }
        ScheduleInfoItem scheduleInfoItem = (ScheduleInfoItem) other;
        if (Intrinsics.areEqual(this.date, scheduleInfoItem.date) && Intrinsics.areEqual(this.info, scheduleInfoItem.info)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    @NotNull
    public String getText() {
        py1.a aVar = this.date;
        return aVar.f428062a + "/" + (aVar.f428063b + 1) + "/" + aVar.f428064c + "-" + this.info.getTitle() + "/" + this.info.getContent();
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.date.hashCode() * 31) + this.info.hashCode();
    }

    @NotNull
    public String toString() {
        return "ScheduleInfoItem(date=" + this.date + ", info=" + this.info + ")";
    }
}
