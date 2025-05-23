package com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.model.TroopSearchWay;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0006\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/ui/c;", "", "", "a", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/model/TroopSearchWay;", "b", "isLoading", "option", "c", "", "toString", "", "hashCode", "other", "equals", "Z", "()Z", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/model/TroopSearchWay;", "e", "()Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/model/TroopSearchWay;", "<init>", "(ZLcom/tencent/mobileqq/troop/troopsetting/modules/searchway/model/TroopSearchWay;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isLoading;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopSearchWay option;

    public c(boolean z16, @NotNull TroopSearchWay option) {
        Intrinsics.checkNotNullParameter(option, "option");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), option);
        } else {
            this.isLoading = z16;
            this.option = option;
        }
    }

    public static /* synthetic */ c d(c cVar, boolean z16, TroopSearchWay troopSearchWay, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = cVar.isLoading;
        }
        if ((i3 & 2) != 0) {
            troopSearchWay = cVar.option;
        }
        return cVar.c(z16, troopSearchWay);
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isLoading;
    }

    @NotNull
    public final TroopSearchWay b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TroopSearchWay) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.option;
    }

    @NotNull
    public final c c(boolean isLoading, @NotNull TroopSearchWay option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (c) iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(isLoading), option);
        }
        Intrinsics.checkNotNullParameter(option, "option");
        return new c(isLoading, option);
    }

    @NotNull
    public final TroopSearchWay e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopSearchWay) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.option;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (this.isLoading == cVar.isLoading && this.option == cVar.option) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        boolean z16 = this.isLoading;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.option.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "TroopSettingSearchWayUIState(isLoading=" + this.isLoading + ", option=" + this.option + ")";
    }

    public /* synthetic */ c(boolean z16, TroopSearchWay troopSearchWay, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, troopSearchWay);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), troopSearchWay, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
