package com.tencent.mobileqq.guild.home.schedule.models;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\r\n\u0003B\t\b\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0011\u0010\u000f\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0003\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "", "", "c", "()J", "timeMs", "", "d", "()B", "type", "b", "id", "Ljava/util/Calendar;", "a", "()Ljava/util/Calendar;", "date", "<init>", "()V", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$b;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$c;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0005\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0011B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b%\u0010&J;\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\f\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\"\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\u00020\u001f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001a\u0010\"R\u001a\u0010$\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "", "timeMs", "", "year", "month", "day", "state", "e", "", "toString", "hashCode", "", "other", "", "equals", "a", "J", "c", "()J", "b", "I", "getYear", "()I", "getMonth", "d", "g", h.F, "i", "(I)V", "", "f", "B", "()B", "type", "id", "<init>", "(JIIII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.models.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CalendarDay extends a {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long timeMs;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int year;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int month;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int day;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int state;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final byte type;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final long id;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/a$a$a;", "", "Ljava/util/Calendar;", QQPermissionConstants.Permission.CALENDAR_GROUP, "Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.home.schedule.models.a$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final CalendarDay a(@NotNull Calendar calendar) {
                Intrinsics.checkNotNullParameter(calendar, "calendar");
                return new CalendarDay(calendar.getTimeInMillis(), calendar.get(1), calendar.get(2) + 1, calendar.get(5), 0, 16, null);
            }

            Companion() {
            }
        }

        public /* synthetic */ CalendarDay(long j3, int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, i3, i16, i17, (i19 & 16) != 0 ? 0 : i18);
        }

        public static /* synthetic */ CalendarDay f(CalendarDay calendarDay, long j3, int i3, int i16, int i17, int i18, int i19, Object obj) {
            if ((i19 & 1) != 0) {
                j3 = calendarDay.getTimeMs();
            }
            long j16 = j3;
            if ((i19 & 2) != 0) {
                i3 = calendarDay.year;
            }
            int i26 = i3;
            if ((i19 & 4) != 0) {
                i16 = calendarDay.month;
            }
            int i27 = i16;
            if ((i19 & 8) != 0) {
                i17 = calendarDay.day;
            }
            int i28 = i17;
            if ((i19 & 16) != 0) {
                i18 = calendarDay.state;
            }
            return calendarDay.e(j16, i26, i27, i28, i18);
        }

        @Override // com.tencent.mobileqq.guild.home.schedule.models.a
        /* renamed from: b, reason: from getter */
        public long getId() {
            return this.id;
        }

        @Override // com.tencent.mobileqq.guild.home.schedule.models.a
        /* renamed from: c, reason: from getter */
        public long getTimeMs() {
            return this.timeMs;
        }

        @Override // com.tencent.mobileqq.guild.home.schedule.models.a
        /* renamed from: d, reason: from getter */
        public byte getType() {
            return this.type;
        }

        @NotNull
        public final CalendarDay e(long timeMs, int year, int month, int day, int state) {
            return new CalendarDay(timeMs, year, month, day, state);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CalendarDay)) {
                return false;
            }
            CalendarDay calendarDay = (CalendarDay) other;
            if (getTimeMs() == calendarDay.getTimeMs() && this.year == calendarDay.year && this.month == calendarDay.month && this.day == calendarDay.day && this.state == calendarDay.state) {
                return true;
            }
            return false;
        }

        /* renamed from: g, reason: from getter */
        public final int getDay() {
            return this.day;
        }

        /* renamed from: h, reason: from getter */
        public final int getState() {
            return this.state;
        }

        public int hashCode() {
            return (((((((androidx.fragment.app.a.a(getTimeMs()) * 31) + this.year) * 31) + this.month) * 31) + this.day) * 31) + this.state;
        }

        public final void i(int i3) {
            this.state = i3;
        }

        @NotNull
        public String toString() {
            return "CalendarDay(timeMs=" + getTimeMs() + ", year=" + this.year + ", month=" + this.month + ", day=" + this.day + ", state=" + this.state + ")";
        }

        public CalendarDay(long j3, int i3, int i16, int i17, int i18) {
            super(null);
            this.timeMs = j3;
            this.year = i3;
            this.month = i16;
            this.day = i17;
            this.state = i18;
            this.type = (byte) 2;
            this.id = getTimeMs();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u001b\u001a\u00020\u00178\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/a$b;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", "timeMs", "b", "I", "f", "()I", "year", "e", "month", "", "d", "B", "()B", "type", "id", "<init>", "(JII)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.models.a$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CalendarMonth extends a {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long timeMs;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int year;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int month;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final byte type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long id;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/a$b$a;", "", "Ljava/util/Calendar;", QQPermissionConstants.Permission.CALENDAR_GROUP, "Lcom/tencent/mobileqq/guild/home/schedule/models/a$b;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.home.schedule.models.a$b$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final CalendarMonth a(@NotNull Calendar calendar) {
                Intrinsics.checkNotNullParameter(calendar, "calendar");
                return new CalendarMonth(calendar.getTimeInMillis(), calendar.get(1), calendar.get(2) + 1);
            }

            Companion() {
            }
        }

        public CalendarMonth(long j3, int i3, int i16) {
            super(null);
            this.timeMs = j3;
            this.year = i3;
            this.month = i16;
            this.type = (byte) 1;
            this.id = getTimeMs();
        }

        @Override // com.tencent.mobileqq.guild.home.schedule.models.a
        /* renamed from: b, reason: from getter */
        public long getId() {
            return this.id;
        }

        @Override // com.tencent.mobileqq.guild.home.schedule.models.a
        /* renamed from: c, reason: from getter */
        public long getTimeMs() {
            return this.timeMs;
        }

        @Override // com.tencent.mobileqq.guild.home.schedule.models.a
        /* renamed from: d, reason: from getter */
        public byte getType() {
            return this.type;
        }

        /* renamed from: e, reason: from getter */
        public final int getMonth() {
            return this.month;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CalendarMonth)) {
                return false;
            }
            CalendarMonth calendarMonth = (CalendarMonth) other;
            if (getTimeMs() == calendarMonth.getTimeMs() && this.year == calendarMonth.year && this.month == calendarMonth.month) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getYear() {
            return this.year;
        }

        public int hashCode() {
            return (((androidx.fragment.app.a.a(getTimeMs()) * 31) + this.year) * 31) + this.month;
        }

        @NotNull
        public String toString() {
            return "CalendarMonth(timeMs=" + getTimeMs() + ", year=" + this.year + ", month=" + this.month + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\b\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00158\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/a$c;", "Lcom/tencent/mobileqq/guild/home/schedule/models/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "e", "()I", "spanSize", "", "b", "J", "c", "()J", "timeMs", "", "B", "d", "()B", "type", "id", "<init>", "(IJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.models.a$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class PlaceHolder extends a {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int spanSize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long timeMs;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final byte type;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long id;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/a$c$a;", "", "Ljava/util/Calendar;", "firstDayOfMonth", "", "c", QQPermissionConstants.Permission.CALENDAR_GROUP, "Lcom/tencent/mobileqq/guild/home/schedule/models/a$c;", "a", "", "isStart", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.home.schedule.models.a$c$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final int c(Calendar firstDayOfMonth) {
                int firstDayOfWeek = firstDayOfMonth.get(7) - firstDayOfMonth.getFirstDayOfWeek();
                if (firstDayOfWeek < 0) {
                    return firstDayOfWeek + 7;
                }
                return firstDayOfWeek;
            }

            @Nullable
            public final PlaceHolder a(@NotNull Calendar calendar) {
                Intrinsics.checkNotNullParameter(calendar, "calendar");
                int i3 = calendar.get(5);
                int actualMaximum = calendar.getActualMaximum(5);
                int c16 = c(calendar);
                if (i3 == actualMaximum) {
                    int i16 = 6 - c16;
                    if (i16 == 0) {
                        return null;
                    }
                    return new PlaceHolder(i16, calendar.getTimeInMillis());
                }
                if (i3 != 1 || c16 == 0) {
                    return null;
                }
                return new PlaceHolder(c16, calendar.getTimeInMillis());
            }

            @Nullable
            public final PlaceHolder b(@NotNull Calendar calendar, boolean isStart) {
                Intrinsics.checkNotNullParameter(calendar, "calendar");
                PlaceHolder a16 = a(calendar);
                if (a16 != null) {
                    return a16;
                }
                int c16 = c(calendar);
                if (isStart) {
                    if (c16 != 0) {
                        return new PlaceHolder(c16, calendar.getTimeInMillis());
                    }
                    return null;
                }
                int i3 = 6 - c16;
                if (i3 != 0) {
                    return new PlaceHolder(i3, calendar.getTimeInMillis());
                }
                return null;
            }

            Companion() {
            }
        }

        public PlaceHolder(int i3, long j3) {
            super(null);
            this.spanSize = i3;
            this.timeMs = j3;
            this.id = i3 + getTimeMs();
        }

        @Override // com.tencent.mobileqq.guild.home.schedule.models.a
        /* renamed from: b, reason: from getter */
        public long getId() {
            return this.id;
        }

        @Override // com.tencent.mobileqq.guild.home.schedule.models.a
        /* renamed from: c, reason: from getter */
        public long getTimeMs() {
            return this.timeMs;
        }

        @Override // com.tencent.mobileqq.guild.home.schedule.models.a
        /* renamed from: d, reason: from getter */
        public byte getType() {
            return this.type;
        }

        /* renamed from: e, reason: from getter */
        public final int getSpanSize() {
            return this.spanSize;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlaceHolder)) {
                return false;
            }
            PlaceHolder placeHolder = (PlaceHolder) other;
            if (this.spanSize == placeHolder.spanSize && getTimeMs() == placeHolder.getTimeMs()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.spanSize * 31) + androidx.fragment.app.a.a(getTimeMs());
        }

        @NotNull
        public String toString() {
            return "PlaceHolder(spanSize=" + this.spanSize + ", timeMs=" + getTimeMs() + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final Calendar a() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(1);
        calendar.setTimeInMillis(getTimeMs());
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  \u2026Millis = timeMs\n        }");
        return calendar;
    }

    /* renamed from: b */
    public abstract long getId();

    /* renamed from: c */
    public abstract long getTimeMs();

    /* renamed from: d */
    public abstract byte getType();

    a() {
    }
}
