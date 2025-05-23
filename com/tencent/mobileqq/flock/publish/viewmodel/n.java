package com.tencent.mobileqq.flock.publish.viewmodel;

import com.tencent.mobileqq.flock.utils.DateTimeUtils;
import com.tencent.mobileqq.flock.widget.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b#\u0010$J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rH\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002J\u0014\u0010\u0015\u001a\u00020\u00142\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019R,\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/n;", "", "", "Ljava/util/Date;", "daysSet", "", "initRepeatEndTimeMs", "", "c", "date1", "date2", "", "d", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "e", "Lcom/tencent/mobileqq/flock/widget/g$d;", "b", "selectItems", "a", "", "f", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "pickerDayFormat", "Ljava/util/Date;", "leftMostDay", "rightMostDay", "Lkotlin/Pair;", "", "Lkotlin/Pair;", "repeatEndDaysSet", "Lcom/tencent/mobileqq/flock/widget/g$d;", "pickerSheetData", "activityStartTimeMs", "<init>", "(JJ)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat pickerDayFormat;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Date leftMostDay;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Date rightMostDay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Pair<List<Date>, List<String>> repeatEndDaysSet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private g.d pickerSheetData;

    public n(long j3, long j16) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd E", Locale.CHINA);
        this.pickerDayFormat = simpleDateFormat;
        Calendar e16 = e();
        if (j3 != 0) {
            e16.setTimeInMillis(j3);
        }
        Date time = e16.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        this.leftMostDay = time;
        e16.add(2, 6);
        Date time2 = e16.getTime();
        Intrinsics.checkNotNullExpressionValue(time2, "time");
        this.rightMostDay = time2;
        Pair<List<Date>, List<String>> a16 = DateTimeUtils.f210478a.a(time, time2, 1, simpleDateFormat);
        this.repeatEndDaysSet = a16;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(a16.getSecond());
        this.pickerSheetData = new g.d("\u91cd\u590d\u7ed3\u675f\u65f6\u95f4", listOf, c(a16.getFirst(), j16));
    }

    private final List<Integer> c(List<? extends Date> daysSet, long initRepeatEndTimeMs) {
        List<Integer> listOf;
        List<Integer> listOf2;
        int i3 = 0;
        if (initRepeatEndTimeMs == 0) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(0);
            return listOf2;
        }
        Calendar e16 = e();
        e16.setTimeInMillis(initRepeatEndTimeMs);
        Date date = e16.getTime();
        Iterator<? extends Date> it = daysSet.iterator();
        int i16 = 0;
        while (true) {
            if (it.hasNext()) {
                Date next = it.next();
                Intrinsics.checkNotNullExpressionValue(date, "date");
                if (d(next, date)) {
                    break;
                }
                i16++;
            } else {
                i16 = -1;
                break;
            }
        }
        if (i16 != -1) {
            i3 = i16;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i3));
        return listOf;
    }

    private final boolean d(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return true;
        }
        return false;
    }

    private final Calendar e() {
        return Calendar.getInstance();
    }

    @Nullable
    public final Date a(@NotNull List<Integer> selectItems) {
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Date) iPatchRedirector.redirect((short) 4, (Object) this, (Object) selectItems);
        }
        Intrinsics.checkNotNullParameter(selectItems, "selectItems");
        if (selectItems.isEmpty() || (intValue = selectItems.get(0).intValue()) >= this.repeatEndDaysSet.getFirst().size()) {
            return null;
        }
        return this.repeatEndDaysSet.getFirst().get(intValue);
    }

    @NotNull
    public final g.d b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (g.d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.pickerSheetData;
    }

    public final void f(@NotNull List<Integer> selectItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) selectItems);
        } else {
            Intrinsics.checkNotNullParameter(selectItems, "selectItems");
            this.pickerSheetData.f(selectItems);
        }
    }
}
