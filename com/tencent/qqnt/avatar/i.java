package com.tencent.qqnt.avatar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalVipNumberInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001c\u0010\u000bR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u0011\u0010\u001fR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\r\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/avatar/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "avatarId", "b", "e", "size", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "g", "()Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "vipNum", "d", "Z", tl.h.F, "()Z", "vipNumIsLong", "shopSource", "f", "useSource", "Ljava/lang/String;", "()Ljava/lang/String;", "peerUin", "peerUid", "<init>", "(IILcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;ZIILjava/lang/String;Ljava/lang/String;)V", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int avatarId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int size;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final VASPersonalVipNumberInfo vipNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean vipNumIsLong;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int shopSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int useSource;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    public i(int i3, int i16, @Nullable VASPersonalVipNumberInfo vASPersonalVipNumberInfo, boolean z16, int i17, int i18, @NotNull String peerUin, @NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), vASPersonalVipNumberInfo, Boolean.valueOf(z16), Integer.valueOf(i17), Integer.valueOf(i18), peerUin, peerUid);
            return;
        }
        this.avatarId = i3;
        this.size = i16;
        this.vipNum = vASPersonalVipNumberInfo;
        this.vipNumIsLong = z16;
        this.shopSource = i17;
        this.useSource = i18;
        this.peerUin = peerUin;
        this.peerUid = peerUid;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.avatarId;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.peerUid;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.peerUin;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.shopSource;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.size;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof i)) {
            return false;
        }
        i iVar = (i) other;
        if (this.avatarId == iVar.avatarId && this.size == iVar.size && Intrinsics.areEqual(this.vipNum, iVar.vipNum) && this.vipNumIsLong == iVar.vipNumIsLong && this.shopSource == iVar.shopSource && this.useSource == iVar.useSource && Intrinsics.areEqual(this.peerUin, iVar.peerUin) && Intrinsics.areEqual(this.peerUid, iVar.peerUid)) {
            return true;
        }
        return false;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.useSource;
    }

    @Nullable
    public final VASPersonalVipNumberInfo g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (VASPersonalVipNumberInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.vipNum;
    }

    public final boolean h() {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        int i3 = ((this.avatarId * 31) + this.size) * 31;
        VASPersonalVipNumberInfo vASPersonalVipNumberInfo = this.vipNum;
        if (vASPersonalVipNumberInfo == null) {
            hashCode = 0;
        } else {
            hashCode = vASPersonalVipNumberInfo.hashCode();
        }
        int i16 = (i3 + hashCode) * 31;
        boolean z16 = this.vipNumIsLong;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        return ((((((((i16 + i17) * 31) + this.shopSource) * 31) + this.useSource) * 31) + this.peerUin.hashCode()) * 31) + this.peerUid.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "VasAvatarData(avatarId=" + this.avatarId + ", size=" + this.size + ", vipNum=" + this.vipNum + ", vipNumIsLong=" + this.vipNumIsLong + ", shopSource=" + this.shopSource + ", useSource=" + this.useSource + ", peerUin=" + this.peerUin + ", peerUid=" + this.peerUid + ")";
    }
}
