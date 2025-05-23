package com.tencent.qqnt.troopmemberlist.merge;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.report.j;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020!\u0012\b\b\u0002\u0010)\u001a\u00020\u0007\u00a2\u0006\u0004\b*\u0010+J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0010\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b\n\u0010\u001fR\u0017\u0010$\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b\u0018\u0010#R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010%\u001a\u0004\b\u0015\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/merge/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "e", "()J", "troopUin", "", "b", "Ljava/util/List;", "g", "()Ljava/util/List;", SquareJSConst.Params.PARAMS_UIN_LIST, "c", "f", "uidList", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "from", h.F, "uniqueFrom", "I", "()I", "callbackId", "Lcom/tencent/qqnt/report/j;", "Lcom/tencent/qqnt/report/j;", "()Lcom/tencent/qqnt/report/j;", "report", "Z", "()Z", "i", "(Z)V", "needRequest", "<init>", "(JLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/qqnt/report/j;Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> uinList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> uidList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String from;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uniqueFrom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int callbackId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j report;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean needRequest;

    public b(long j3, @NotNull List<String> uinList, @NotNull List<String> uidList, @NotNull String from, @NotNull String uniqueFrom, int i3, @NotNull j report, boolean z16) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(uniqueFrom, "uniqueFrom");
        Intrinsics.checkNotNullParameter(report, "report");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), uinList, uidList, from, uniqueFrom, Integer.valueOf(i3), report, Boolean.valueOf(z16));
            return;
        }
        this.troopUin = j3;
        this.uinList = uinList;
        this.uidList = uidList;
        this.from = from;
        this.uniqueFrom = uniqueFrom;
        this.callbackId = i3;
        this.report = report;
        this.needRequest = z16;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.callbackId;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.from;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.needRequest;
    }

    @NotNull
    public final j d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (j) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.report;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.troopUin;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.troopUin == bVar.troopUin && Intrinsics.areEqual(this.uinList, bVar.uinList) && Intrinsics.areEqual(this.uidList, bVar.uidList) && Intrinsics.areEqual(this.from, bVar.from) && Intrinsics.areEqual(this.uniqueFrom, bVar.uniqueFrom) && this.callbackId == bVar.callbackId && Intrinsics.areEqual(this.report, bVar.report) && this.needRequest == bVar.needRequest) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<String> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uidList;
    }

    @NotNull
    public final List<String> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.uinList;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.uniqueFrom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        int a16 = ((((((((((((androidx.fragment.app.a.a(this.troopUin) * 31) + this.uinList.hashCode()) * 31) + this.uidList.hashCode()) * 31) + this.from.hashCode()) * 31) + this.uniqueFrom.hashCode()) * 31) + this.callbackId) * 31) + this.report.hashCode()) * 31;
        boolean z16 = this.needRequest;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return a16 + i3;
    }

    public final void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.needRequest = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "TroopMemberMergeTask(troopUin=" + this.troopUin + ", uinList=" + this.uinList + ", uidList=" + this.uidList + ", from=" + this.from + ", uniqueFrom=" + this.uniqueFrom + ", callbackId=" + this.callbackId + ", report=" + this.report + ", needRequest=" + this.needRequest + ")";
    }

    public /* synthetic */ b(long j3, List list, List list2, String str, String str2, int i3, j jVar, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, list, list2, str, str2, i3, jVar, (i16 & 128) != 0 ? true : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), list, list2, str, str2, Integer.valueOf(i3), jVar, Boolean.valueOf(z16), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
