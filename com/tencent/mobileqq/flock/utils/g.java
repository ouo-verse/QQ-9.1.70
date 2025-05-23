package com.tencent.mobileqq.flock.utils;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/flock/utils/g;", "", "", "seconds", "", "a", "c", "b", "firstTimeSeconds", "secondTimeSeconds", "", "d", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f210486a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49494);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f210486a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(long seconds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, seconds);
        }
        String format = new SimpleDateFormat("MM.dd HH:mm", Locale.getDefault()).format(new Date(seconds * 1000));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"MM.dd \u2026mat(Date(seconds * 1000))");
        return format;
    }

    @NotNull
    public final String b(long seconds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, seconds);
        }
        String format = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(new Date(seconds * 1000));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"yyyy.M\u2026mat(Date(seconds * 1000))");
        return format;
    }

    @NotNull
    public final String c(long seconds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, seconds);
        }
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, Locale.getDefault()).format(new Date(seconds * 1000));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"HH:mm\"\u2026mat(Date(seconds * 1000))");
        return format;
    }

    public final boolean d(long firstTimeSeconds, long secondTimeSeconds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Long.valueOf(firstTimeSeconds), Long.valueOf(secondTimeSeconds))).booleanValue();
        }
        Calendar calendar = Calendar.getInstance();
        long j3 = 1000;
        calendar.setTime(new Date(firstTimeSeconds * j3));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(secondTimeSeconds * j3));
        if (calendar.get(1) != calendar2.get(1) || calendar.get(6) != calendar2.get(6)) {
            return false;
        }
        return true;
    }
}
