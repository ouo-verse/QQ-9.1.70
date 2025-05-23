package com.tencent.mobileqq.flock.ktx;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/flock/ktx/c;", "", "Ljava/util/Date;", "", "hasNext", "a", "d", "Ljava/util/Date;", "endDate", "", "e", "I", "stepDays", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "f", "Ljava/util/Calendar;", QQPermissionConstants.Permission.CALENDAR_GROUP, tl.h.F, "currentDate", "startDate", "<init>", "(Ljava/util/Date;Ljava/util/Date;I)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c implements Iterator<Date>, KMappedMarker {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Date endDate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int stepDays;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Calendar calendar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Date currentDate;

    public c(@NotNull Date startDate, @NotNull Date endDate, int i3) {
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, startDate, endDate, Integer.valueOf(i3));
            return;
        }
        this.endDate = endDate;
        this.stepDays = i3;
        this.calendar = Calendar.getInstance(Locale.getDefault());
        this.currentDate = startDate;
    }

    @Override // java.util.Iterator
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date next() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Date) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Date date = this.currentDate;
        this.calendar.setTime(date);
        this.calendar.add(5, this.stepDays);
        Date time = this.calendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        this.currentDate = time;
        return date;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.currentDate.compareTo(this.endDate) <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
