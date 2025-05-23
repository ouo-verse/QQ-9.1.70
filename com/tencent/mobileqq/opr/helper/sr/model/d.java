package com.tencent.mobileqq.opr.helper.sr.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/opr/helper/sr/model/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/opr/helper/sr/model/SrStatus;", "a", "Lcom/tencent/mobileqq/opr/helper/sr/model/SrStatus;", "b", "()Lcom/tencent/mobileqq/opr/helper/sr/model/SrStatus;", "status", "Ljava/lang/String;", "()Ljava/lang/String;", "resultPath", "Lcom/tencent/mobileqq/opr/helper/sr/model/e;", "c", "Lcom/tencent/mobileqq/opr/helper/sr/model/e;", "getStatistics", "()Lcom/tencent/mobileqq/opr/helper/sr/model/e;", "statistics", "<init>", "(Lcom/tencent/mobileqq/opr/helper/sr/model/SrStatus;Ljava/lang/String;Lcom/tencent/mobileqq/opr/helper/sr/model/e;)V", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final /* data */ class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SrStatus status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String resultPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final e statistics;

    public d(@NotNull SrStatus status, @Nullable String str, @Nullable e eVar) {
        Intrinsics.checkNotNullParameter(status, "status");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, status, str, eVar);
            return;
        }
        this.status = status;
        this.resultPath = str;
        this.statistics = eVar;
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.resultPath;
    }

    @NotNull
    public final SrStatus b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SrStatus) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.status;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (this.status == dVar.status && Intrinsics.areEqual(this.resultPath, dVar.resultPath) && Intrinsics.areEqual(this.statistics, dVar.statistics)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int hashCode2 = this.status.hashCode() * 31;
        String str = this.resultPath;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        e eVar = this.statistics;
        if (eVar != null) {
            i3 = eVar.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "SrResult(status=" + this.status + ", resultPath=" + ((Object) this.resultPath) + ", statistics=" + this.statistics + ')';
    }

    public /* synthetic */ d(SrStatus srStatus, String str, e eVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(srStatus, (i3 & 2) != 0 ? null : str, (i3 & 4) == 0 ? eVar : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, srStatus, str, eVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
