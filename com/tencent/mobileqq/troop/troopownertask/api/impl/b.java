package com.tencent.mobileqq.troop.troopownertask.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/api/impl/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "b", "I", "c", "()I", "newTaskNumber", "latestTaskTimeSec", "d", "jumUrl", "e", "totalTaskNum", "f", CacheTable.TABLE_NAME, "<init>", "(Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int newTaskNumber;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int latestTaskTimeSec;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String jumUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int totalTaskNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String reportInfo;

    public b(@NotNull String troopUin, int i3, int i16, @NotNull String jumUrl, int i17, @NotNull String reportInfo) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(jumUrl, "jumUrl");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, Integer.valueOf(i3), Integer.valueOf(i16), jumUrl, Integer.valueOf(i17), reportInfo);
            return;
        }
        this.troopUin = troopUin;
        this.newTaskNumber = i3;
        this.latestTaskTimeSec = i16;
        this.jumUrl = jumUrl;
        this.totalTaskNum = i17;
        this.reportInfo = reportInfo;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.jumUrl;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.latestTaskTimeSec;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.newTaskNumber;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.reportInfo;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.totalTaskNum;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.troopUin, bVar.troopUin) && this.newTaskNumber == bVar.newTaskNumber && this.latestTaskTimeSec == bVar.latestTaskTimeSec && Intrinsics.areEqual(this.jumUrl, bVar.jumUrl) && this.totalTaskNum == bVar.totalTaskNum && Intrinsics.areEqual(this.reportInfo, bVar.reportInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return (((((((((this.troopUin.hashCode() * 31) + this.newTaskNumber) * 31) + this.latestTaskTimeSec) * 31) + this.jumUrl.hashCode()) * 31) + this.totalTaskNum) * 31) + this.reportInfo.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "TroopOwnerTask(troopUin=" + this.troopUin + ", newTaskNumber=" + this.newTaskNumber + ", latestTaskTimeSec=" + this.latestTaskTimeSec + ", jumUrl=" + this.jumUrl + ", totalTaskNum=" + this.totalTaskNum + ", reportInfo=" + this.reportInfo + ")";
    }
}
