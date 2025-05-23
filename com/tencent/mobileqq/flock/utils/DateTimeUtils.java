package com.tencent.mobileqq.flock.utils;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.repeat.FlockRepeatType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J@\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J<\u0010\u0010\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005J<\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005J]\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000b0\u0018J&\u0010%\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010$\u001a\u00020#J*\u0010(\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020#\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/flock/utils/DateTimeUtils;", "", "Ljava/util/Date;", "startDay", "endDay", "", "stepDays", "Ljava/text/SimpleDateFormat;", "format", "Lkotlin/Pair;", "", "", "a", "startHour", "endHour", "stepHours", "b", "startMinutes", "endMinutes", "stepMinutes", "d", "start", "end", "stepTime", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "time", "transform", h.F, "Lcom/tencent/mobileqq/flock/repeat/FlockRepeatType;", "repeatType", "", "activityStartTimeSecond", "repeatEndTimeSecond", "", "needRepeatWording", "f", "activityStartDate", "repeatEndDate", "g", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class DateTimeUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DateTimeUtils f210478a;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f210479a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49450);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FlockRepeatType.values().length];
            try {
                iArr[FlockRepeatType.WEEK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlockRepeatType.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f210479a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49458);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f210478a = new DateTimeUtils();
        }
    }

    DateTimeUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ Pair c(DateTimeUtils dateTimeUtils, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = 0;
        }
        if ((i18 & 2) != 0) {
            i16 = 23;
        }
        if ((i18 & 4) != 0) {
            i17 = 1;
        }
        return dateTimeUtils.b(i3, i16, i17);
    }

    public static /* synthetic */ Pair e(DateTimeUtils dateTimeUtils, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = 0;
        }
        if ((i18 & 2) != 0) {
            i16 = 55;
        }
        if ((i18 & 4) != 0) {
            i17 = 5;
        }
        return dateTimeUtils.d(i3, i16, i17);
    }

    @NotNull
    public final Pair<List<Date>, List<String>> a(@NotNull Date startDay, @NotNull Date endDay, int stepDays, @NotNull SimpleDateFormat format) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, this, startDay, endDay, Integer.valueOf(stepDays), format);
        }
        Intrinsics.checkNotNullParameter(startDay, "startDay");
        Intrinsics.checkNotNullParameter(endDay, "endDay");
        Intrinsics.checkNotNullParameter(format, "format");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Date date : com.tencent.mobileqq.flock.ktx.b.a(startDay, endDay).h(stepDays)) {
            arrayList.add(date);
            arrayList2.add(format.format(date));
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public final Pair<List<Integer>, List<String>> b(int startHour, int endHour, int stepHours) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(startHour), Integer.valueOf(endHour), Integer.valueOf(stepHours));
        }
        return h(startHour, endHour, stepHours, DateTimeUtils$genHoursSet$1.INSTANCE);
    }

    @NotNull
    public final Pair<List<Integer>, List<String>> d(int startMinutes, int endMinutes, int stepMinutes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(startMinutes), Integer.valueOf(endMinutes), Integer.valueOf(stepMinutes));
        }
        return h(startMinutes, endMinutes, stepMinutes, DateTimeUtils$genMinutesSet$1.INSTANCE);
    }

    @NotNull
    public final String f(@NotNull FlockRepeatType repeatType, long activityStartTimeSecond, long repeatEndTimeSecond, boolean needRepeatWording) {
        Date date;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, repeatType, Long.valueOf(activityStartTimeSecond), Long.valueOf(repeatEndTimeSecond), Boolean.valueOf(needRepeatWording));
        }
        Intrinsics.checkNotNullParameter(repeatType, "repeatType");
        Date date2 = null;
        if (activityStartTimeSecond != 0) {
            date = new Date(activityStartTimeSecond * 1000);
        } else {
            date = null;
        }
        if (repeatEndTimeSecond != 0) {
            date2 = new Date(repeatEndTimeSecond * 1000);
        }
        return g(repeatType, date, date2, needRepeatWording);
    }

    @NotNull
    public final String g(@NotNull FlockRepeatType repeatType, @Nullable Date activityStartDate, @Nullable Date repeatEndDate, boolean needRepeatWording) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, repeatType, activityStartDate, repeatEndDate, Boolean.valueOf(needRepeatWording));
        }
        Intrinsics.checkNotNullParameter(repeatType, "repeatType");
        String str2 = "";
        if (repeatType == FlockRepeatType.NONE || activityStartDate == null) {
            return "";
        }
        String content = repeatType.getContent();
        int i3 = a.f210479a[repeatType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                str = null;
            } else {
                str = "dd\u65e5";
            }
        } else {
            str = "E";
        }
        if (str != null) {
            str2 = new SimpleDateFormat(str, Locale.CHINA).format(activityStartDate);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append((Object) content);
        sb5.append((Object) str2);
        String sb6 = sb5.toString();
        if (needRepeatWording) {
            sb6 = ((Object) sb6) + MobileQQ.sMobileQQ.getString(R.string.f199194or);
        }
        if (repeatEndDate != null) {
            return ((Object) sb6) + "\uff0c" + new SimpleDateFormat("MM\u6708dd\u65e5", Locale.CHINA).format(repeatEndDate) + MobileQQ.sMobileQQ.getString(R.string.f199144om);
        }
        return sb6;
    }

    @NotNull
    public final Pair<List<Integer>, List<String>> h(int start, int end, int stepTime, @NotNull Function1<? super Integer, String> transform) {
        IntProgression step;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Pair) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(start), Integer.valueOf(end), Integer.valueOf(stepTime), transform);
        }
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        step = RangesKt___RangesKt.step(new IntRange(start, end), stepTime);
        Iterator<Integer> it = step.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(Integer.valueOf(nextInt));
            arrayList2.add(transform.invoke(Integer.valueOf(nextInt)));
        }
        return new Pair<>(arrayList, arrayList2);
    }
}
