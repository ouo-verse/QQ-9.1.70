package com.tencent.mobileqq.login;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u0014\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/login/ao;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "uin", "Landroid/os/Bundle;", "b", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/login/l;", "c", "Lcom/tencent/mobileqq/login/l;", "()Lcom/tencent/mobileqq/login/l;", "loginParams", "", "J", "()J", "successTime", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;Lcom/tencent/mobileqq/login/l;J)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class ao {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bundle bundle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final l loginParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long successTime;

    public ao(@NotNull String uin, @Nullable Bundle bundle, @Nullable l lVar, long j3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uin, bundle, lVar, Long.valueOf(j3));
            return;
        }
        this.uin = uin;
        this.bundle = bundle;
        this.loginParams = lVar;
        this.successTime = j3;
    }

    @Nullable
    public final Bundle a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.bundle;
    }

    @Nullable
    public final l b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (l) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.loginParams;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.successTime;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ao)) {
            return false;
        }
        ao aoVar = (ao) other;
        if (Intrinsics.areEqual(this.uin, aoVar.uin) && Intrinsics.areEqual(this.bundle, aoVar.bundle) && Intrinsics.areEqual(this.loginParams, aoVar.loginParams) && this.successTime == aoVar.successTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        int hashCode2 = this.uin.hashCode() * 31;
        Bundle bundle = this.bundle;
        int i3 = 0;
        if (bundle == null) {
            hashCode = 0;
        } else {
            hashCode = bundle.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        l lVar = this.loginParams;
        if (lVar != null) {
            i3 = lVar.hashCode();
        }
        return ((i16 + i3) * 31) + androidx.fragment.app.a.a(this.successTime);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "LoginSuccessSavedState(uin=" + this.uin + ", bundle=" + this.bundle + ", loginParams=" + this.loginParams + ", successTime=" + this.successTime + ")";
    }

    public /* synthetic */ ao(String str, Bundle bundle, l lVar, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : bundle, (i3 & 4) != 0 ? null : lVar, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, bundle, lVar, Long.valueOf(j3), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
