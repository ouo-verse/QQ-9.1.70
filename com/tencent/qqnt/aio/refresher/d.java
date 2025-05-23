package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalVipNumberInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0019\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b\u0010\u0010 R\u0017\u0010$\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b\u0015\u0010#R$\u0010+\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b&\u0010*\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "uin", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsg", "", "c", "J", "e", "()J", "pendentId", "d", "I", "()I", "pendantDiyId", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "numberInfo", "Z", "()Z", "numberIsLong", "Lcom/tencent/qqnt/aio/refresher/e;", "g", "Lcom/tencent/qqnt/aio/refresher/e;", "getRsp", "()Lcom/tencent/qqnt/aio/refresher/e;", "(Lcom/tencent/qqnt/aio/refresher/e;)V", "rsp", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class d implements com.tencent.mobileqq.aio.msglist.holder.external.h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOMsgItem aioMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long pendentId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int pendantDiyId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final VASPersonalVipNumberInfo numberInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean numberIsLong;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e rsp;

    @NotNull
    public final AIOMsgItem a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.aioMsg;
    }

    @Nullable
    public final VASPersonalVipNumberInfo b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (VASPersonalVipNumberInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.numberInfo;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.numberIsLong;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.pendantDiyId;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.pendentId;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.uin, dVar.uin) && Intrinsics.areEqual(this.aioMsg, dVar.aioMsg) && this.pendentId == dVar.pendentId && this.pendantDiyId == dVar.pendantDiyId && Intrinsics.areEqual(this.numberInfo, dVar.numberInfo) && this.numberIsLong == dVar.numberIsLong && Intrinsics.areEqual(this.rsp, dVar.rsp)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uin;
    }

    public final void g(@Nullable e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) eVar);
        } else {
            this.rsp = eVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        int hashCode2 = ((((((this.uin.hashCode() * 31) + this.aioMsg.hashCode()) * 31) + androidx.fragment.app.a.a(this.pendentId)) * 31) + this.pendantDiyId) * 31;
        VASPersonalVipNumberInfo vASPersonalVipNumberInfo = this.numberInfo;
        int i3 = 0;
        if (vASPersonalVipNumberInfo == null) {
            hashCode = 0;
        } else {
            hashCode = vASPersonalVipNumberInfo.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        boolean z16 = this.numberIsLong;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        e eVar = this.rsp;
        if (eVar != null) {
            i3 = eVar.hashCode();
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "AvatarVasPendentRefreshRequest(uin=" + this.uin + ", aioMsg=" + this.aioMsg + ", pendentId=" + this.pendentId + ", pendantDiyId=" + this.pendantDiyId + ", numberInfo=" + this.numberInfo + ", numberIsLong=" + this.numberIsLong + ", rsp=" + this.rsp + ")";
    }
}
