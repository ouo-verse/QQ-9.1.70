package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/refresher/ba;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "getMsgId", "()J", "msgId", "b", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "c", "I", "getFaceId", "()I", "faceId", "Lcom/tencent/mobileqq/aio/msglist/holder/avatar/a;", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/avatar/a;", "getVasAvatarInfo", "()Lcom/tencent/mobileqq/aio/msglist/holder/avatar/a;", "vasAvatarInfo", "<init>", "(JLjava/lang/String;ILcom/tencent/mobileqq/aio/msglist/holder/avatar/a;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class ba implements com.tencent.mobileqq.aio.msglist.holder.external.f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int faceId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.msglist.holder.avatar.a vasAvatarInfo;

    public ba(long j3, @NotNull String uin, int i3, @NotNull com.tencent.mobileqq.aio.msglist.holder.avatar.a vasAvatarInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(vasAvatarInfo, "vasAvatarInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), uin, Integer.valueOf(i3), vasAvatarInfo);
            return;
        }
        this.msgId = j3;
        this.uin = uin;
        this.faceId = i3;
        this.vasAvatarInfo = vasAvatarInfo;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ba)) {
            return false;
        }
        ba baVar = (ba) other;
        if (this.msgId == baVar.msgId && Intrinsics.areEqual(this.uin, baVar.uin) && this.faceId == baVar.faceId && Intrinsics.areEqual(this.vasAvatarInfo, baVar.vasAvatarInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (((((androidx.fragment.app.a.a(this.msgId) * 31) + this.uin.hashCode()) * 31) + this.faceId) * 31) + this.vasAvatarInfo.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "VasAvatarRefreshResponse(msgId=" + this.msgId + ", uin=" + this.uin + ", faceId=" + this.faceId + ", vasAvatarInfo=" + this.vasAvatarInfo + ")";
    }
}
