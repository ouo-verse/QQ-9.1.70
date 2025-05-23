package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/as;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "getMsgId", "()J", "msgId", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "uin", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/a;", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/a;", "()Lcom/tencent/mobileqq/aio/msglist/holder/skin/a;", "shootBubbleInfo", "<init>", "(JLjava/lang/String;Lcom/tencent/mobileqq/aio/msglist/holder/skin/a;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class as implements com.tencent.mobileqq.aio.msglist.holder.external.f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.msglist.holder.skin.a shootBubbleInfo;

    public as(long j3, @NotNull String uin, @NotNull com.tencent.mobileqq.aio.msglist.holder.skin.a shootBubbleInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(shootBubbleInfo, "shootBubbleInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), uin, shootBubbleInfo);
            return;
        }
        this.msgId = j3;
        this.uin = uin;
        this.shootBubbleInfo = shootBubbleInfo;
    }

    @NotNull
    public final com.tencent.mobileqq.aio.msglist.holder.skin.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.msglist.holder.skin.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.shootBubbleInfo;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof as)) {
            return false;
        }
        as asVar = (as) other;
        if (this.msgId == asVar.msgId && Intrinsics.areEqual(this.uin, asVar.uin) && Intrinsics.areEqual(this.shootBubbleInfo, asVar.shootBubbleInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((androidx.fragment.app.a.a(this.msgId) * 31) + this.uin.hashCode()) * 31) + this.shootBubbleInfo.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "ShootBubbleRefreshResponse(msgId=" + this.msgId + ", uin=" + this.uin + ", shootBubbleInfo=" + this.shootBubbleInfo + ")";
    }
}
