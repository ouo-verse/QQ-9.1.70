package com.tencent.mobileqq.troop.troopjoin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\b\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u001a\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopjoin/a;", "", "", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "troopId", "b", "authSig", "", "c", "I", "e", "()I", "subSourceId", "", "d", "Z", "()Z", "setCheckSubTroop", "(Z)V", "checkSubTroop", "setDtReportSourceId", "(Ljava/lang/String;)V", "dtReportSourceId", "setJumpToAIO", "jumpToAIO", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Z)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String authSig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int subSourceId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean checkSubTroop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String dtReportSourceId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean jumpToAIO;

    public a(@NotNull String troopId, @NotNull String authSig, int i3, boolean z16, @NotNull String dtReportSourceId, boolean z17) {
        Intrinsics.checkNotNullParameter(troopId, "troopId");
        Intrinsics.checkNotNullParameter(authSig, "authSig");
        Intrinsics.checkNotNullParameter(dtReportSourceId, "dtReportSourceId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopId, authSig, Integer.valueOf(i3), Boolean.valueOf(z16), dtReportSourceId, Boolean.valueOf(z17));
            return;
        }
        this.troopId = troopId;
        this.authSig = authSig;
        this.subSourceId = i3;
        this.checkSubTroop = z16;
        this.dtReportSourceId = dtReportSourceId;
        this.jumpToAIO = z17;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.authSig;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.checkSubTroop;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.dtReportSourceId;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.jumpToAIO;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.subSourceId;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopId;
    }

    public /* synthetic */ a(String str, String str2, int i3, boolean z16, String str3, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, (i16 & 8) != 0 ? false : z16, (i16 & 16) != 0 ? "" : str3, (i16 & 32) != 0 ? false : z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Boolean.valueOf(z16), str3, Boolean.valueOf(z17), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
