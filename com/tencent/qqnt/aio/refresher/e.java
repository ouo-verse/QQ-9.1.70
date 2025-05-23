package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/refresher/e;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "", "b", "J", "getMsgId", "()J", "msgId", "c", "getPendentId", "pendentId", "Lcom/tencent/mobileqq/aio/msglist/holder/pendent/a;", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/pendent/a;", "getVasPendentInfo", "()Lcom/tencent/mobileqq/aio/msglist/holder/pendent/a;", "vasPendentInfo", "<init>", "(Ljava/lang/String;JJLcom/tencent/mobileqq/aio/msglist/holder/pendent/a;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class e implements com.tencent.mobileqq.aio.msglist.holder.external.f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long pendentId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.msglist.holder.pendent.a vasPendentInfo;

    public e(@NotNull String uin, long j3, long j16, @NotNull com.tencent.mobileqq.aio.msglist.holder.pendent.a vasPendentInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(vasPendentInfo, "vasPendentInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uin, Long.valueOf(j3), Long.valueOf(j16), vasPendentInfo);
            return;
        }
        this.uin = uin;
        this.msgId = j3;
        this.pendentId = j16;
        this.vasPendentInfo = vasPendentInfo;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.uin, eVar.uin) && this.msgId == eVar.msgId && this.pendentId == eVar.pendentId && Intrinsics.areEqual(this.vasPendentInfo, eVar.vasPendentInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (((((this.uin.hashCode() * 31) + androidx.fragment.app.a.a(this.msgId)) * 31) + androidx.fragment.app.a.a(this.pendentId)) * 31) + this.vasPendentInfo.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "AvatarVasPendentRefreshResponse(uin=" + this.uin + ", msgId=" + this.msgId + ", pendentId=" + this.pendentId + ", vasPendentInfo=" + this.vasPendentInfo + ")";
    }
}
