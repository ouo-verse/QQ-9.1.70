package com.tencent.mobileqq.opr.helper.repair.model;

import com.tencent.mobileqq.opr.helper.sr.model.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\n\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/opr/helper/repair/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/opr/helper/repair/model/OprStatus;", "a", "Lcom/tencent/mobileqq/opr/helper/repair/model/OprStatus;", "e", "()Lcom/tencent/mobileqq/opr/helper/repair/model/OprStatus;", "status", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "resultPath", "repairTaskId", "Lcom/tencent/mobileqq/opr/helper/sr/model/e;", "d", "Lcom/tencent/mobileqq/opr/helper/sr/model/e;", "()Lcom/tencent/mobileqq/opr/helper/sr/model/e;", "statistics", "I", "()I", "photoSize", "<init>", "(Lcom/tencent/mobileqq/opr/helper/repair/model/OprStatus;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/opr/helper/sr/model/e;I)V", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OprStatus status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String resultPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String repairTaskId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final e statistics;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int photoSize;

    public a(@NotNull OprStatus status, @Nullable String str, @Nullable String str2, @Nullable e eVar, int i3) {
        Intrinsics.checkNotNullParameter(status, "status");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, status, str, str2, eVar, Integer.valueOf(i3));
            return;
        }
        this.status = status;
        this.resultPath = str;
        this.repairTaskId = str2;
        this.statistics = eVar;
        this.photoSize = i3;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.photoSize;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.repairTaskId;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.resultPath;
    }

    @Nullable
    public final e d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.statistics;
    }

    @NotNull
    public final OprStatus e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (OprStatus) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.status;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.status == aVar.status && Intrinsics.areEqual(this.resultPath, aVar.resultPath) && Intrinsics.areEqual(this.repairTaskId, aVar.repairTaskId) && Intrinsics.areEqual(this.statistics, aVar.statistics) && this.photoSize == aVar.photoSize) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        int hashCode3 = this.status.hashCode() * 31;
        String str = this.resultPath;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        String str2 = this.repairTaskId;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        e eVar = this.statistics;
        if (eVar != null) {
            i3 = eVar.hashCode();
        }
        return ((i17 + i3) * 31) + this.photoSize;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "OprResult(status=" + this.status + ", resultPath=" + ((Object) this.resultPath) + ", repairTaskId=" + ((Object) this.repairTaskId) + ", statistics=" + this.statistics + ", photoSize=" + this.photoSize + ')';
    }

    public /* synthetic */ a(OprStatus oprStatus, String str, String str2, e eVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(oprStatus, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : str2, (i16 & 8) != 0 ? null : eVar, (i16 & 16) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, oprStatus, str, str2, eVar, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
