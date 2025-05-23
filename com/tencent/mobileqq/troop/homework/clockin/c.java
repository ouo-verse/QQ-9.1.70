package com.tencent.mobileqq.troop.homework.clockin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.Status;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeCons$HWNoticeRoleType;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/c;", "", "", "dateInSeconds", h.F, "dateInSeconds1", "dateInSeconds2", "", "c", "d", "f", "", "weekdays", "g", "a", "weekdaysSetting", "", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/a;", "list", "", "e", "", "troopUin", "Lcom/tencent/mobileqq/troop/homework/clockin/HWClockInRole;", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f296281a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41436);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f296281a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long h(long dateInSeconds) {
        Calendar calendar = Calendar.getInstance();
        long j3 = 1000;
        calendar.setTime(new Date(dateInSeconds * j3));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() / j3;
    }

    public final int a(long dateInSeconds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, dateInSeconds)).intValue();
        }
        return (int) (Math.abs((System.currentTimeMillis() / 1000) - h(dateInSeconds)) / 86400);
    }

    @NotNull
    public final HWClockInRole b(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HWClockInRole) iPatchRedirector.redirect((short) 9, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (HWNoticeUtils.f297171a.f(troopUin) == HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_TEACHER) {
            return HWClockInRole.ROLE_TEACHER;
        }
        return HWClockInRole.ROLE_STUDENT_OR_PARENT;
    }

    public final boolean c(long dateInSeconds1, long dateInSeconds2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Long.valueOf(dateInSeconds1), Long.valueOf(dateInSeconds2))).booleanValue();
        }
        Calendar calendar = Calendar.getInstance();
        long j3 = 1000;
        calendar.setTime(new Date(dateInSeconds1 * j3));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(dateInSeconds2 * j3));
        if (calendar.get(1) != calendar2.get(1) || calendar.get(2) != calendar2.get(2) || calendar.get(5) != calendar2.get(5)) {
            return false;
        }
        return true;
    }

    public final boolean d(long dateInSeconds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, dateInSeconds)).booleanValue();
        }
        return c(dateInSeconds, System.currentTimeMillis() / 1000);
    }

    public final void e(int weekdaysSetting, @NotNull List<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, weekdaysSetting, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i3 = 0; i3 < 7; i3++) {
            if (((1 << i3) & weekdaysSetting) != 0) {
                linkedHashSet.add(Integer.valueOf(i3));
            }
        }
        if (linkedHashSet.size() != 7) {
            Iterator<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a> it = list.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a next = it.next();
                if (!next.h() && (next.e() == Status.STATUS_NEED_NOT_CLOCK_IN || !linkedHashSet.contains(Integer.valueOf(next.b())))) {
                    it.remove();
                }
            }
        }
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    public final boolean g(int weekdays) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, weekdays)).booleanValue();
        }
        int i16 = Calendar.getInstance().get(7);
        if (i16 == 1) {
            i3 = 6;
        } else {
            i3 = i16 - 2;
        }
        if ((weekdays & (1 << i3)) != 0) {
            return true;
        }
        return false;
    }
}
