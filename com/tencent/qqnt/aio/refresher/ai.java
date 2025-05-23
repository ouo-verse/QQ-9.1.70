package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/ai;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", "scid", "Lcom/tencent/qqnt/aio/nick/i;", "b", "Lcom/tencent/qqnt/aio/nick/i;", "()Lcom/tencent/qqnt/aio/nick/i;", "drawInfo", "Lcom/tencent/qqnt/aio/refresher/aj;", "Lcom/tencent/qqnt/aio/refresher/aj;", "()Lcom/tencent/qqnt/aio/refresher/aj;", "d", "(Lcom/tencent/qqnt/aio/refresher/aj;)V", "rsp", "<init>", "(JLcom/tencent/qqnt/aio/nick/i;Lcom/tencent/qqnt/aio/refresher/aj;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class ai implements com.tencent.mobileqq.aio.msglist.holder.external.h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long scid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.aio.nick.i drawInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private aj rsp;

    public ai(long j3, @NotNull com.tencent.qqnt.aio.nick.i drawInfo, @Nullable aj ajVar) {
        Intrinsics.checkNotNullParameter(drawInfo, "drawInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), drawInfo, ajVar);
            return;
        }
        this.scid = j3;
        this.drawInfo = drawInfo;
        this.rsp = ajVar;
    }

    @NotNull
    public final com.tencent.qqnt.aio.nick.i a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.aio.nick.i) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.drawInfo;
    }

    @Nullable
    public final aj b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (aj) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.rsp;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.scid;
    }

    public final void d(@Nullable aj ajVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) ajVar);
        } else {
            this.rsp = ajVar;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ai)) {
            return false;
        }
        ai aiVar = (ai) other;
        if (this.scid == aiVar.scid && Intrinsics.areEqual(this.drawInfo, aiVar.drawInfo) && Intrinsics.areEqual(this.rsp, aiVar.rsp)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        int a16 = ((androidx.fragment.app.a.a(this.scid) * 31) + this.drawInfo.hashCode()) * 31;
        aj ajVar = this.rsp;
        if (ajVar == null) {
            hashCode = 0;
        } else {
            hashCode = ajVar.hashCode();
        }
        return a16 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "NickBackgroundRequest(scid=" + this.scid + ", drawInfo=" + this.drawInfo + ", rsp=" + this.rsp + ")";
    }

    public /* synthetic */ ai(long j3, com.tencent.qqnt.aio.nick.i iVar, aj ajVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, iVar, (i3 & 4) != 0 ? null : ajVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), iVar, ajVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
