package com.tencent.qqnt.chathistory.ui.date.data.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/date/data/model/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/chathistory/ui/date/data/model/a;", "c", "Lcom/tencent/qqnt/chathistory/ui/date/data/model/a;", h.F, "()Lcom/tencent/qqnt/chathistory/ui/date/data/model/a;", "modelDate", "d", "f", "currentDate", "", "e", "Ljava/util/List;", "g", "()Ljava/util/List;", "days", "I", "()I", "itemViewType", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/date/data/model/a;Lcom/tencent/qqnt/chathistory/ui/date/data/model/a;Ljava/util/List;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class b implements com.tencent.qqnt.base.adapter.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a modelDate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a currentDate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Boolean> days;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int itemViewType;

    public b(@NotNull a modelDate, @NotNull a currentDate, @NotNull List<Boolean> days) {
        Intrinsics.checkNotNullParameter(modelDate, "modelDate");
        Intrinsics.checkNotNullParameter(currentDate, "currentDate");
        Intrinsics.checkNotNullParameter(days, "days");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, modelDate, currentDate, days);
            return;
        }
        this.modelDate = modelDate;
        this.currentDate = currentDate;
        this.days = days;
    }

    @Override // com.tencent.qqnt.base.adapter.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.itemViewType;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.modelDate, bVar.modelDate) && Intrinsics.areEqual(this.currentDate, bVar.currentDate) && Intrinsics.areEqual(this.days, bVar.days)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.currentDate;
    }

    @NotNull
    public final List<Boolean> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.days;
    }

    @NotNull
    public final a h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.modelDate;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return (((this.modelDate.hashCode() * 31) + this.currentDate.hashCode()) * 31) + this.days.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "SearchDateModel(modelDate=" + this.modelDate + ", currentDate=" + this.currentDate + ", days=" + this.days + ")";
    }
}
