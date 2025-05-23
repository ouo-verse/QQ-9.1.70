package com.tencent.mobileqq.flock.publish.viewmodel;

import com.tencent.mobileqq.flock.utils.DateTimeUtils;
import com.tencent.mobileqq.flock.widget.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 <2\u00020\u0001:\u0001\u0015B\u001b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\b\u00109\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b:\u0010;J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\u0014\u0010\u0016\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\u0014\u0010\u0017\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\u0006\u0010\u0018\u001a\u00020\u0007R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R,\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010$R,\u0010'\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010*\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010)R,\u0010,\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010$R0\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b&\u0010/R\u0017\u00104\u001a\u0002018F\u00a2\u0006\f\n\u0004\b\u0017\u00102\u001a\u0004\b(\u00103R.\u00105\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$R0\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u0010.\u001a\u0004\b\u001b\u0010/R$\u00108\u001a\u0002012\u0006\u0010-\u001a\u0002018F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b7\u00102\u001a\u0004\b\u001f\u00103\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/a;", "", "", "Ljava/util/Date;", "startDays", "", "selectItems", "", "l", "daysSet", "", "initTimeMs", "d", "(Ljava/util/List;Ljava/lang/Long;)Ljava/util/List;", "day1", "day2", "", "g", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", tl.h.F, "a", "k", "j", "i", "Ljava/lang/Long;", "initStartTimeMs", "b", "Ljava/util/Calendar;", "timeCalculator", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "pickerDayFormat", "Lkotlin/Pair;", "", "Lkotlin/Pair;", "hoursSet", "e", "minutesSet", "f", "Ljava/util/Date;", "leftMostDay", "rightMostDay", "startDaysSet", "<set-?>", "Ljava/util/List;", "()Ljava/util/List;", "startSelectTimeItems", "Lcom/tencent/mobileqq/flock/widget/g$d;", "Lcom/tencent/mobileqq/flock/widget/g$d;", "()Lcom/tencent/mobileqq/flock/widget/g$d;", "startTimeData", "endDaysSet", "endSelectTimeItems", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "endTimeData", "initEndTimeMs", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", DomainData.DOMAIN_NAME, "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Long initStartTimeMs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Calendar timeCalculator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat pickerDayFormat;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Pair<List<Integer>, List<String>> hoursSet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Pair<List<Integer>, List<String>> minutesSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Date leftMostDay;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Date rightMostDay;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Pair<List<Date>, List<String>> startDaysSet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Integer> startSelectTimeItems;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g.d startTimeData;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Pair<? extends List<? extends Date>, ? extends List<String>> endDaysSet;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Integer> endSelectTimeItems;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private g.d endTimeData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/a$a;", "", "", "DAY_INDEX", "I", "HOUR_INDEX", "MIN_INDEX", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.viewmodel.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48410);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@Nullable Long l3, @Nullable Long l16) {
        List listOf;
        List listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) l3, (Object) l16);
            return;
        }
        this.initStartTimeMs = l3;
        Calendar h16 = h();
        Intrinsics.checkNotNullExpressionValue(h16, "nowCalendar()");
        this.timeCalculator = h16;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd E", Locale.CHINA);
        this.pickerDayFormat = simpleDateFormat;
        DateTimeUtils dateTimeUtils = DateTimeUtils.f210478a;
        Pair<List<Integer>, List<String>> c16 = DateTimeUtils.c(dateTimeUtils, 0, 0, 0, 7, null);
        this.hoursSet = c16;
        Pair<List<Integer>, List<String>> e16 = DateTimeUtils.e(dateTimeUtils, 0, 0, 0, 7, null);
        this.minutesSet = e16;
        Calendar h17 = h();
        if (l3 != null && ((l3 == null || l3.longValue() != 0) && l3.longValue() < h17.getTimeInMillis())) {
            h17.setTimeInMillis(l3.longValue());
        }
        Date time = h17.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        this.leftMostDay = time;
        h17.add(2, 6);
        Date time2 = h17.getTime();
        Intrinsics.checkNotNullExpressionValue(time2, "time");
        this.rightMostDay = time2;
        Pair<List<Date>, List<String>> a16 = dateTimeUtils.a(time, time2, 1, simpleDateFormat);
        this.startDaysSet = a16;
        this.startSelectTimeItems = d(a16.getFirst(), l3);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new List[]{a16.getSecond(), c16.getSecond(), e16.getSecond()});
        this.startTimeData = new g.d("\u8d77\u59cb\u65f6\u95f4", listOf, this.startSelectTimeItems);
        Pair<List<Date>, List<String>> a17 = dateTimeUtils.a(time, time2, 1, simpleDateFormat);
        this.endDaysSet = a17;
        this.endSelectTimeItems = d(a17.getFirst(), l16);
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new List[]{this.endDaysSet.getSecond(), c16.getSecond(), e16.getSecond()});
        this.endTimeData = new g.d("\u7ed3\u675f\u65f6\u95f4", listOf2, this.endSelectTimeItems);
    }

    private final List<Integer> a() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{0, 0, 0});
        return listOf;
    }

    private final List<Integer> d(List<? extends Date> daysSet, Long initTimeMs) {
        List<Integer> listOf;
        boolean z16;
        boolean z17;
        if (initTimeMs != null && initTimeMs.longValue() != 0) {
            this.timeCalculator.setTimeInMillis(initTimeMs.longValue());
            Date initDate = this.timeCalculator.getTime();
            Integer[] numArr = new Integer[3];
            Iterator<? extends Date> it = daysSet.iterator();
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (it.hasNext()) {
                    Date next = it.next();
                    Intrinsics.checkNotNullExpressionValue(initDate, "initDate");
                    if (g(next, initDate)) {
                        break;
                    }
                    i16++;
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 == -1) {
                i16 = 0;
            }
            numArr[0] = Integer.valueOf(i16);
            Iterator<Integer> it5 = this.hoursSet.getFirst().iterator();
            int i17 = 0;
            while (true) {
                if (it5.hasNext()) {
                    if (it5.next().intValue() == initDate.getHours()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                    i17++;
                } else {
                    i17 = -1;
                    break;
                }
            }
            if (i17 == -1) {
                i17 = 0;
            }
            numArr[1] = Integer.valueOf(i17);
            Iterator<Integer> it6 = this.minutesSet.getFirst().iterator();
            int i18 = 0;
            while (true) {
                if (it6.hasNext()) {
                    if (it6.next().intValue() == initDate.getMinutes()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i18++;
                } else {
                    i18 = -1;
                    break;
                }
            }
            if (i18 != -1) {
                i3 = i18;
            }
            numArr[2] = Integer.valueOf(i3);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) numArr);
            return listOf;
        }
        return a();
    }

    private final boolean g(Date day1, Date day2) {
        if (day1.getDay() == day2.getDay() && day1.getMonth() == day2.getMonth() && day1.getYear() == day2.getYear()) {
            return true;
        }
        return false;
    }

    private final Calendar h() {
        return Calendar.getInstance(Locale.CHINA);
    }

    private final void l(List<? extends Date> startDays, List<Integer> selectItems) {
        Calendar calendar = this.timeCalculator;
        calendar.setTime(startDays.get(selectItems.get(0).intValue()));
        calendar.set(11, this.hoursSet.getFirst().get(selectItems.get(1).intValue()).intValue());
        calendar.set(12, this.minutesSet.getFirst().get(selectItems.get(2).intValue()).intValue());
    }

    @NotNull
    public final List<Integer> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.endSelectTimeItems;
    }

    @NotNull
    public final g.d c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (g.d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return g.d.b(this.endTimeData, null, null, this.endSelectTimeItems, 3, null);
    }

    @NotNull
    public final List<Integer> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.startSelectTimeItems;
    }

    @NotNull
    public final g.d f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (g.d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return g.d.b(this.startTimeData, null, null, this.startSelectTimeItems, 3, null);
    }

    public final void i() {
        Object first;
        Object orNull;
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        List<Date> first2 = this.startDaysSet.getFirst();
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.startSelectTimeItems);
        orNull = CollectionsKt___CollectionsKt.getOrNull(first2, ((Number) first).intValue());
        Date date = (Date) orNull;
        if (date == null) {
            date = this.leftMostDay;
        }
        this.endDaysSet = DateTimeUtils.f210478a.a(date, this.rightMostDay, 1, this.pickerDayFormat);
        this.endSelectTimeItems = a();
        g.d c16 = c();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new List[]{this.endDaysSet.getSecond(), this.hoursSet.getSecond(), this.minutesSet.getSecond()});
        this.endTimeData = g.d.b(c16, null, listOf, this.endSelectTimeItems, 1, null);
    }

    @NotNull
    public final Date j(@NotNull List<Integer> selectItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Date) iPatchRedirector.redirect((short) 7, (Object) this, (Object) selectItems);
        }
        Intrinsics.checkNotNullParameter(selectItems, "selectItems");
        this.endSelectTimeItems = selectItems;
        l(this.endDaysSet.getFirst(), selectItems);
        Date time = this.timeCalculator.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "timeCalculator.time");
        return time;
    }

    @NotNull
    public final Date k(@NotNull List<Integer> selectItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Date) iPatchRedirector.redirect((short) 6, (Object) this, (Object) selectItems);
        }
        Intrinsics.checkNotNullParameter(selectItems, "selectItems");
        this.startSelectTimeItems = selectItems;
        l(this.startDaysSet.getFirst(), selectItems);
        Date time = this.timeCalculator.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "timeCalculator.time");
        return time;
    }
}
