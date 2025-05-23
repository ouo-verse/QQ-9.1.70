package com.tencent.qqnt.aio.assistedchat.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001c\u0010\u000e\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/config/b;", "", "", "toString", "other", "", "equals", "", "hashCode", "a", "I", "f", "()I", "l", "(I)V", "triggerMinWords", "b", "g", "autoTriggerTimes", "c", h.F, "guideDisplayTimesPerDay", "d", "i", "guideNoClickXConsecutiveDays", "e", "j", "guideNotAppearForYDays", "k", "guideNotAppearForZDays", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int triggerMinWords;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int autoTriggerTimes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int guideDisplayTimesPerDay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int guideNoClickXConsecutiveDays;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int guideNotAppearForYDays;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int guideNotAppearForZDays;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.triggerMinWords = 3;
        this.autoTriggerTimes = 5;
        this.guideDisplayTimesPerDay = 1;
        this.guideNoClickXConsecutiveDays = 3;
        this.guideNotAppearForYDays = 7;
        this.guideNotAppearForZDays = 14;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.autoTriggerTimes;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.guideDisplayTimesPerDay;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.guideNoClickXConsecutiveDays;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.guideNotAppearForYDays;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.guideNotAppearForZDays;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(b.class, cls) || !(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.triggerMinWords == bVar.triggerMinWords && this.autoTriggerTimes == bVar.autoTriggerTimes && this.guideDisplayTimesPerDay == bVar.guideDisplayTimesPerDay && this.guideNoClickXConsecutiveDays == bVar.guideNoClickXConsecutiveDays && this.guideNotAppearForYDays == bVar.guideNotAppearForYDays && this.guideNotAppearForZDays == bVar.guideNotAppearForZDays) {
            return true;
        }
        return false;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.triggerMinWords;
    }

    public final void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.autoTriggerTimes = i3;
        }
    }

    public final void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.guideDisplayTimesPerDay = i3;
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return (((((((((this.triggerMinWords * 31) + this.autoTriggerTimes) * 31) + this.guideDisplayTimesPerDay) * 31) + this.guideNoClickXConsecutiveDays) * 31) + this.guideNotAppearForYDays) * 31) + this.guideNotAppearForZDays;
    }

    public final void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.guideNoClickXConsecutiveDays = i3;
        }
    }

    public final void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.guideNotAppearForYDays = i3;
        }
    }

    public final void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.guideNotAppearForZDays = i3;
        }
    }

    public final void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.triggerMinWords = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "triggerMinWords=" + this.triggerMinWords + ", autoTriggerTimes=" + this.autoTriggerTimes + ", guideDisplayTimesPerDay=" + this.guideDisplayTimesPerDay + ", guideNoClickXConsecutiveDays=" + this.guideNoClickXConsecutiveDays + ",guideNotAppearForYDays=" + this.guideNotAppearForYDays + ", guideNotAppearForZDays=" + this.guideNotAppearForZDays;
    }
}
