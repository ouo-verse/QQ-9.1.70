package com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.HWClockInRole;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u0012\u0006\u0010\"\u001a\u00020\u001c\u0012\u0006\u0010(\u001a\u00020\u0002\u00a2\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\t\u0010\n\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010,\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010+R\u001c\u0010-\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/a;", "", "", h.F, "i", "", "b", "", "a", "c", "toString", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/troop/homework/clockin/HWClockInRole;", "Lcom/tencent/mobileqq/troop/homework/clockin/HWClockInRole;", "d", "()Lcom/tencent/mobileqq/troop/homework/clockin/HWClockInRole;", "setRole", "(Lcom/tencent/mobileqq/troop/homework/clockin/HWClockInRole;)V", "role", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/Status;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/Status;", "e", "()Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/Status;", "setStatus", "(Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/Status;)V", "status", "", "J", "f", "()J", "setTimeSeconds", "(J)V", "timeSeconds", "Z", "g", "()Z", "j", "(Z)V", "isSelected", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "Ljava/util/Calendar;", "time", "today", "<init>", "(Lcom/tencent/mobileqq/troop/homework/clockin/HWClockInRole;Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/Status;JZ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HWClockInRole role;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Status status;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long timeSeconds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isSelected;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Calendar time;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Calendar today;

    public a(@NotNull HWClockInRole role, @NotNull Status status, long j3, boolean z16) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(status, "status");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, role, status, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        this.role = role;
        this.status = status;
        this.timeSeconds = j3;
        this.isSelected = z16;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(this.timeSeconds * 1000));
        this.time = calendar;
        this.today = Calendar.getInstance();
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (h()) {
            return "\u4eca";
        }
        return String.valueOf(this.time.get(5));
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int i3 = this.time.get(7);
        if (i3 == 1) {
            return 6;
        }
        return i3 - 2;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return new String[]{"\u4e00\u6708", "\u4e8c\u6708", "\u4e09\u6708", "\u56db\u6708", "\u4e94\u6708", "\u516d\u6708", "\u4e03\u6708", "\u516b\u6708", "\u4e5d\u6708", "\u5341\u6708", "\u5341\u4e00\u6708", "\u5341\u4e8c\u6708"}[this.time.get(2)];
    }

    @NotNull
    public final HWClockInRole d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HWClockInRole) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.role;
    }

    @NotNull
    public final Status e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Status) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.status;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.role == aVar.role && this.status == aVar.status && this.timeSeconds == aVar.timeSeconds && this.isSelected == aVar.isSelected) {
            return true;
        }
        return false;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.timeSeconds;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isSelected;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.time.get(1) == this.today.get(1) && this.time.get(2) == this.today.get(2) && this.time.get(5) == this.today.get(5)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int hashCode = ((((this.role.hashCode() * 31) + this.status.hashCode()) * 31) + androidx.fragment.app.a.a(this.timeSeconds)) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.time.get(1) > this.today.get(1)) {
            return false;
        }
        if (this.time.get(1) == this.today.get(1)) {
            if (this.time.get(2) > this.today.get(2)) {
                return false;
            }
            if (this.time.get(2) == this.today.get(2) && this.time.get(5) > this.today.get(5)) {
                return false;
            }
        }
        return true;
    }

    public final void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.isSelected = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "HWDateInfo(role=" + this.role + ", status=" + this.status + ", timeSeconds=" + this.timeSeconds + ", isSelected=" + this.isSelected + ")";
    }
}
