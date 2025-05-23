package com.tencent.qqnt.avatar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalVipNumberInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b\u000f\u0010 R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b\n\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/avatar/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", "pendantId", "b", "I", "c", "()I", "pendantDiyId", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "f", "()Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "vipNum", "Z", "g", "()Z", "vipNumIsLong", "e", "target", "Ljava/lang/String;", "()Ljava/lang/String;", "peerUin", "peerUid", "<init>", "(JILcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;ZILjava/lang/String;Ljava/lang/String;)V", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long pendantId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int pendantDiyId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final VASPersonalVipNumberInfo vipNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean vipNumIsLong;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int target;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    public j(long j3, int i3, @Nullable VASPersonalVipNumberInfo vASPersonalVipNumberInfo, boolean z16, int i16, @NotNull String peerUin, @NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), vASPersonalVipNumberInfo, Boolean.valueOf(z16), Integer.valueOf(i16), peerUin, peerUid);
            return;
        }
        this.pendantId = j3;
        this.pendantDiyId = i3;
        this.vipNum = vASPersonalVipNumberInfo;
        this.vipNumIsLong = z16;
        this.target = i16;
        this.peerUin = peerUin;
        this.peerUid = peerUid;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.peerUid;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.peerUin;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.pendantDiyId;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.pendantId;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.target;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        if (this.pendantId == jVar.pendantId && this.pendantDiyId == jVar.pendantDiyId && Intrinsics.areEqual(this.vipNum, jVar.vipNum) && this.vipNumIsLong == jVar.vipNumIsLong && this.target == jVar.target && Intrinsics.areEqual(this.peerUin, jVar.peerUin) && Intrinsics.areEqual(this.peerUid, jVar.peerUid)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final VASPersonalVipNumberInfo f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (VASPersonalVipNumberInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.vipNum;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.vipNumIsLong;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        int a16 = ((androidx.fragment.app.a.a(this.pendantId) * 31) + this.pendantDiyId) * 31;
        VASPersonalVipNumberInfo vASPersonalVipNumberInfo = this.vipNum;
        if (vASPersonalVipNumberInfo == null) {
            hashCode = 0;
        } else {
            hashCode = vASPersonalVipNumberInfo.hashCode();
        }
        int i3 = (a16 + hashCode) * 31;
        boolean z16 = this.vipNumIsLong;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((((((i3 + i16) * 31) + this.target) * 31) + this.peerUin.hashCode()) * 31) + this.peerUid.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "VasPendantData(pendantId=" + this.pendantId + ", pendantDiyId=" + this.pendantDiyId + ", vipNum=" + this.vipNum + ", vipNumIsLong=" + this.vipNumIsLong + ", target=" + this.target + ", peerUin=" + this.peerUin + ", peerUid=" + this.peerUid + ")";
    }
}
