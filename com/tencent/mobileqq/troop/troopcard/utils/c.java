package com.tencent.mobileqq.troop.troopcard.utils;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/utils/c;", "", "Ljava/util/Calendar;", "nowDay", "expectDay", "", "b", "c", "", "timeS", "", "a", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "format", "yearFormat", "d", "todayFormat", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f299954a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SimpleDateFormat format;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SimpleDateFormat yearFormat;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SimpleDateFormat todayFormat;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f299954a = new c();
        format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        yearFormat = new SimpleDateFormat("MM-dd");
        todayFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR);
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(Calendar nowDay, Calendar expectDay) {
        if (nowDay.get(1) == expectDay.get(1) && nowDay.get(2) == expectDay.get(2) && nowDay.get(5) == expectDay.get(5)) {
            return true;
        }
        return false;
    }

    private final boolean c(Calendar nowDay, Calendar expectDay) {
        if (nowDay.get(1) == expectDay.get(1)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String a(int timeS) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, timeS);
        }
        Calendar today = Calendar.getInstance();
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(timeS * 1000);
        Intrinsics.checkNotNullExpressionValue(time, "time");
        Intrinsics.checkNotNullExpressionValue(today, "today");
        if (b(time, today)) {
            String format2 = todayFormat.format(time.getTime());
            Intrinsics.checkNotNullExpressionValue(format2, "{\n            todayForma\u2026rmat(time.time)\n        }");
            return format2;
        }
        if (c(time, today)) {
            String format3 = yearFormat.format(time.getTime());
            Intrinsics.checkNotNullExpressionValue(format3, "{\n            yearFormat\u2026rmat(time.time)\n        }");
            return format3;
        }
        String format4 = format.format(time.getTime());
        Intrinsics.checkNotNullExpressionValue(format4, "{\n            format.format(time.time)\n        }");
        return format4;
    }
}
