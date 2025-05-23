package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/k;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", "msgSeq", "b", "msgRandom", "Lcom/tencent/qqnt/aio/essence/a;", "Lcom/tencent/qqnt/aio/essence/a;", "()Lcom/tencent/qqnt/aio/essence/a;", "essenceInfo", "<init>", "(JJLcom/tencent/qqnt/aio/essence/a;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class k implements com.tencent.mobileqq.aio.msglist.holder.external.f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long msgSeq;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long msgRandom;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.aio.essence.a essenceInfo;

    public k(long j3, long j16, @NotNull com.tencent.qqnt.aio.essence.a essenceInfo) {
        Intrinsics.checkNotNullParameter(essenceInfo, "essenceInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), essenceInfo);
            return;
        }
        this.msgSeq = j3;
        this.msgRandom = j16;
        this.essenceInfo = essenceInfo;
    }

    @NotNull
    public final com.tencent.qqnt.aio.essence.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.aio.essence.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.essenceInfo;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.msgRandom;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.msgSeq;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof k)) {
            return false;
        }
        k kVar = (k) other;
        if (this.msgSeq == kVar.msgSeq && this.msgRandom == kVar.msgRandom && Intrinsics.areEqual(this.essenceInfo, kVar.essenceInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((androidx.fragment.app.a.a(this.msgSeq) * 31) + androidx.fragment.app.a.a(this.msgRandom)) * 31) + this.essenceInfo.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "EssenceTailRefreshResponse(msgSeq=" + this.msgSeq + ", msgRandom=" + this.msgRandom + ", essenceInfo=" + this.essenceInfo + ")";
    }
}
