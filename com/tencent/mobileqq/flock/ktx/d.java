package com.tencent.mobileqq.flock.ktx;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0015B!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0096\u0002J\u0011\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/flock/ktx/d;", "", "Ljava/util/Date;", "Lkotlin/ranges/ClosedRange;", "", "iterator", "", "days", tl.h.F, "d", "Ljava/util/Date;", "g", "()Ljava/util/Date;", "start", "e", "endInclusive", "f", "I", "stepDays", "<init>", "(Ljava/util/Date;Ljava/util/Date;I)V", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d implements Iterable<Date>, ClosedRange<Date>, KMappedMarker {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final d f210204i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Date start;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Date endInclusive;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int stepDays;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/flock/ktx/d$a;", "", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.ktx.d$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46498);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
            f210204i = new d(new Date(1L), new Date(0L), 0, 4, null);
        }
    }

    public d(@NotNull Date start, @NotNull Date endInclusive, int i3) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endInclusive, "endInclusive");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, start, endInclusive, Integer.valueOf(i3));
            return;
        }
        this.start = start;
        this.endInclusive = endInclusive;
        this.stepDays = i3;
    }

    @Override // kotlin.ranges.ClosedRange
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean contains(@NotNull Date date) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) date)).booleanValue();
        }
        return ClosedRange.DefaultImpls.contains(this, date);
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Date getEndInclusive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Date) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.endInclusive;
    }

    @Override // kotlin.ranges.ClosedRange
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Date getStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Date) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.start;
    }

    @NotNull
    public final d h(int days) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this, days);
        }
        return new d(getStart(), getEndInclusive(), days);
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Date> iterator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Iterator) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new c(getStart(), getEndInclusive(), this.stepDays);
    }

    public /* synthetic */ d(Date date, Date date2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(date, date2, (i16 & 4) != 0 ? 1 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, date, date2, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
