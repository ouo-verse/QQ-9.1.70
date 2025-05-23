package com.tencent.mobileqq.guild.component.calendar;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\r\n\u0003B\t\b\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0011\u0010\u000f\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0003\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/d;", "", "", "c", "()J", "timeMs", "", "d", "()B", "type", "b", "id", "Ljava/util/Calendar;", "a", "()Ljava/util/Calendar;", "date", "<init>", "()V", "Lcom/tencent/mobileqq/guild/component/calendar/d$a;", "Lcom/tencent/mobileqq/guild/component/calendar/d$b;", "Lcom/tencent/mobileqq/guild/component/calendar/d$c;", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0005\n\u0002\b\t\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\u000bB'\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u001a8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0017\u0010\u001cR\u001a\u0010\u001f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/d$a;", "Lcom/tencent/mobileqq/guild/component/calendar/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", "timeMs", "b", "I", "getYear", "()I", "year", "getMonth", "month", "d", "e", "day", "", "B", "()B", "type", "f", "id", "<init>", "(JIII)V", "g", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.component.calendar.d$a, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class CalendarDay extends d {

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
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

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final byte type;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long id;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/d$a$a;", "", "Ljava/util/Calendar;", QQPermissionConstants.Permission.CALENDAR_GROUP, "Lcom/tencent/mobileqq/guild/component/calendar/d$a;", "a", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.component.calendar.d$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes12.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final CalendarDay a(@NotNull Calendar calendar) {
                Intrinsics.checkNotNullParameter(calendar, "calendar");
                return new CalendarDay(calendar.getTimeInMillis(), calendar.get(1), calendar.get(2) + 1, calendar.get(5));
            }

            Companion() {
            }
        }

        public CalendarDay(long j3, int i3, int i16, int i17) {
            super(null);
            this.timeMs = j3;
            this.year = i3;
            this.month = i16;
            this.day = i17;
            this.type = (byte) 2;
            this.id = getTimeMs();
        }

        @Override // com.tencent.mobileqq.guild.component.calendar.d
        /* renamed from: b, reason: from getter */
        public long getId() {
            return this.id;
        }

        @Override // com.tencent.mobileqq.guild.component.calendar.d
        /* renamed from: c, reason: from getter */
        public long getTimeMs() {
            return this.timeMs;
        }

        @Override // com.tencent.mobileqq.guild.component.calendar.d
        /* renamed from: d, reason: from getter */
        public byte getType() {
            return this.type;
        }

        /* renamed from: e, reason: from getter */
        public final int getDay() {
            return this.day;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CalendarDay)) {
                return false;
            }
            CalendarDay calendarDay = (CalendarDay) other;
            if (getTimeMs() == calendarDay.getTimeMs() && this.year == calendarDay.year && this.month == calendarDay.month && this.day == calendarDay.day) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((androidx.fragment.app.a.a(getTimeMs()) * 31) + this.year) * 31) + this.month) * 31) + this.day;
        }

        @NotNull
        public String toString() {
            return "CalendarDay(timeMs=" + getTimeMs() + ", year=" + this.year + ", month=" + this.month + ", day=" + this.day + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u001b\u001a\u00020\u00178\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/d$b;", "Lcom/tencent/mobileqq/guild/component/calendar/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", "timeMs", "b", "I", "getYear", "()I", "year", "e", "month", "", "d", "B", "()B", "type", "id", "<init>", "(JII)V", "f", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.component.calendar.d$b, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class CalendarMonth extends d {

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
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/d$b$a;", "", "Ljava/util/Calendar;", QQPermissionConstants.Permission.CALENDAR_GROUP, "Lcom/tencent/mobileqq/guild/component/calendar/d$b;", "a", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.component.calendar.d$b$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
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

        @Override // com.tencent.mobileqq.guild.component.calendar.d
        /* renamed from: b, reason: from getter */
        public long getId() {
            return this.id;
        }

        @Override // com.tencent.mobileqq.guild.component.calendar.d
        /* renamed from: c, reason: from getter */
        public long getTimeMs() {
            return this.timeMs;
        }

        @Override // com.tencent.mobileqq.guild.component.calendar.d
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

        public int hashCode() {
            return (((androidx.fragment.app.a.a(getTimeMs()) * 31) + this.year) * 31) + this.month;
        }

        @NotNull
        public String toString() {
            return "CalendarMonth(timeMs=" + getTimeMs() + ", year=" + this.year + ", month=" + this.month + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\b\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00158\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/d$c;", "Lcom/tencent/mobileqq/guild/component/calendar/d;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "e", "()I", "spanSize", "", "b", "J", "c", "()J", "timeMs", "", "B", "d", "()B", "type", "id", "<init>", "(IJ)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.component.calendar.d$c, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class PlaceHolder extends d {

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
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/d$c$a;", "", "Ljava/util/Calendar;", "firstDayOfMonth", "", "b", QQPermissionConstants.Permission.CALENDAR_GROUP, "Lcom/tencent/mobileqq/guild/component/calendar/d$c;", "a", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.component.calendar.d$c$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final int b(Calendar firstDayOfMonth) {
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
                int b16 = b(calendar);
                if (i3 == actualMaximum) {
                    int i16 = 6 - b16;
                    if (i16 == 0) {
                        return null;
                    }
                    return new PlaceHolder(i16, calendar.getTimeInMillis());
                }
                if (i3 != 1 || b16 == 0) {
                    return null;
                }
                return new PlaceHolder(b16, calendar.getTimeInMillis());
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

        @Override // com.tencent.mobileqq.guild.component.calendar.d
        /* renamed from: b, reason: from getter */
        public long getId() {
            return this.id;
        }

        @Override // com.tencent.mobileqq.guild.component.calendar.d
        /* renamed from: c, reason: from getter */
        public long getTimeMs() {
            return this.timeMs;
        }

        @Override // com.tencent.mobileqq.guild.component.calendar.d
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

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
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

    d() {
    }
}
