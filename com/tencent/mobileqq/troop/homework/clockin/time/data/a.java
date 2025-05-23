package com.tencent.mobileqq.troop.homework.clockin.time.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0019\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\f\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "", "", "b", "c", "", "f", "", "toString", "hashCode", "other", "equals", "a", "I", "e", "()I", h.F, "(I)V", "timeLimitDays", "", "Ljava/util/List;", "()Ljava/util/List;", "setFrequencyDays", "(Ljava/util/List;)V", "frequencyDays", "", "J", "d", "()J", "g", "(J)V", "remindTime", "<init>", "(ILjava/util/List;J)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int timeLimitDays;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Integer> frequencyDays;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long remindTime;

    public a() {
        this(0, null, 0L, 7, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this);
    }

    @NotNull
    public final List<Integer> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.frequencyDays;
    }

    public final int b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        Iterator<Integer> it = this.frequencyDays.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue >= 0 && intValue < 7) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 |= 1 << intValue;
            }
        }
        return i3;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(this.remindTime));
        return (calendar.get(12) * 60) + (calendar.get(11) * 60 * 60);
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.remindTime;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.timeLimitDays;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.timeLimitDays == aVar.timeLimitDays && Intrinsics.areEqual(this.frequencyDays, aVar.frequencyDays) && this.remindTime == aVar.remindTime) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.timeLimitDays > 0 && (!this.frequencyDays.isEmpty()) && this.remindTime != 0) {
            return true;
        }
        return false;
    }

    public final void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.remindTime = j3;
        }
    }

    public final void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.timeLimitDays = i3;
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return (((this.timeLimitDays * 31) + this.frequencyDays.hashCode()) * 31) + androidx.fragment.app.a.a(this.remindTime);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "HWClockInTimeInfo(timeLimitDays=" + this.timeLimitDays + ", frequencyDays=" + this.frequencyDays + ", remindTime=" + this.remindTime + ")";
    }

    public a(int i3, @NotNull List<Integer> frequencyDays, long j3) {
        Intrinsics.checkNotNullParameter(frequencyDays, "frequencyDays");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), frequencyDays, Long.valueOf(j3));
            return;
        }
        this.timeLimitDays = i3;
        this.frequencyDays = frequencyDays;
        this.remindTime = j3;
        if (i3 == 0) {
            this.timeLimitDays = 30;
        }
        if (frequencyDays.isEmpty()) {
            for (int i16 = 0; i16 < 7; i16++) {
                this.frequencyDays.add(Integer.valueOf(i16));
            }
        }
    }

    public /* synthetic */ a(int i3, List list, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? new ArrayList() : list, (i16 & 4) != 0 ? 0L : j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), list, Long.valueOf(j3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
