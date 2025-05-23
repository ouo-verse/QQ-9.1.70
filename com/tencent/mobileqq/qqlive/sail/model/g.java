package com.tencent.mobileqq.qqlive.sail.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.ui.room.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "selected", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/r;", "b", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/r;", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/r;", "switchInfo", "<init>", "(ZLcom/tencent/mobileqq/qqlive/sail/ui/room/r;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean selected;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final r switchInfo;

    public g(boolean z16, @NotNull r switchInfo) {
        Intrinsics.checkNotNullParameter(switchInfo, "switchInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), switchInfo);
        } else {
            this.selected = z16;
            this.switchInfo = switchInfo;
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.selected;
    }

    @NotNull
    public final r b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (r) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.switchInfo;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (this.selected == gVar.selected && Intrinsics.areEqual(this.switchInfo, gVar.switchInfo)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        boolean z16 = this.selected;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.switchInfo.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "RoomSelectInfo(selected=" + this.selected + ", switchInfo=" + this.switchInfo + ")";
    }
}
