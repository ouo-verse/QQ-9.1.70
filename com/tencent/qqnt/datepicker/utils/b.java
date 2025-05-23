package com.tencent.qqnt.datepicker.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/datepicker/utils/b;", "", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/datepicker/utils/b$a;", "", "Ljava/util/Date;", "date", "", "abortDay", "a", "(Ljava/util/Date;Ljava/lang/Integer;)I", "Ljava/util/Locale;", "locale", "day", "", "useThreeLetterAbbreviation", "", "", "b", "(Ljava/util/Locale;IZ)[Ljava/lang/String;", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.datepicker.utils.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a(@NotNull Date date, @Nullable Integer abortDay) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) date, (Object) abortDay)).intValue();
            }
            Intrinsics.checkNotNullParameter(date, "date");
            int year = date.getYear() + 1900;
            int month = date.getMonth();
            Calendar calendar = Calendar.getInstance();
            calendar.set(2, month);
            calendar.set(1, year);
            int actualMaximum = calendar.getActualMaximum(5);
            calendar.set(5, 1);
            int actualMaximum2 = calendar.getActualMaximum(4);
            a aVar = a.f355927a;
            aVar.a("DateUtils", "weekNumberForMonth  " + actualMaximum2 + "  abortDay " + abortDay);
            if (abortDay != null) {
                int intValue = ((actualMaximum - abortDay.intValue()) + 1) / 7;
                aVar.a("DateUtils", "detail " + intValue);
                actualMaximum2 -= intValue;
            }
            aVar.a("DateUtils", "year=" + year + " month=" + month + " weekNum=" + actualMaximum2 + " monthDay " + actualMaximum);
            return actualMaximum2;
        }

        @NotNull
        public final String[] b(@NotNull Locale locale, int day, boolean useThreeLetterAbbreviation) {
            boolean z16;
            List listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String[]) iPatchRedirector.redirect((short) 3, this, locale, Integer.valueOf(day), Boolean.valueOf(useThreeLetterAbbreviation));
            }
            Intrinsics.checkNotNullParameter(locale, "locale");
            String[] shortWeekdays = new DateFormatSymbols(locale).getShortWeekdays();
            if (shortWeekdays != null) {
                if (shortWeekdays.length == 8) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    String[] strArr = new String[7];
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{shortWeekdays[1], shortWeekdays[2], shortWeekdays[3], shortWeekdays[4], shortWeekdays[5], shortWeekdays[6], shortWeekdays[7]});
                    int i3 = day - 1;
                    int i16 = 0;
                    while (i16 < 7) {
                        if (i3 >= 7) {
                            i3 = 0;
                        }
                        strArr[i16] = (String) listOf.get(i3);
                        i16++;
                        i3++;
                    }
                    if (!useThreeLetterAbbreviation) {
                        for (int i17 = 0; i17 < 7; i17++) {
                            String str = strArr[i17];
                            Intrinsics.checkNotNull(str);
                            String substring = str.substring(1);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            strArr[i17] = substring;
                        }
                    }
                    return strArr;
                }
                throw new IllegalStateException(("Expected weekday names from default locale to be of size 7 but: " + Arrays.toString(shortWeekdays) + " with size " + shortWeekdays.length + " was returned.").toString());
            }
            throw new IllegalStateException("Unable to determine weekday names from default locale");
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51882);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
