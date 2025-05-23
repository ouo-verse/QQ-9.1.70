package com.tencent.qqnt.aio.refresher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalVipNumberInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u0017\u0010 \u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0015\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b(\u0010)\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/az;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/aio/data/msglist/a;", "a", "Lcom/tencent/aio/data/msglist/a;", "b", "()Lcom/tencent/aio/data/msglist/a;", "msgItem", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "uin", "c", "I", "()I", "faceId", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "numberInfo", "e", "Z", "()Z", "numberIsLong", "Lcom/tencent/qqnt/aio/refresher/ba;", "Lcom/tencent/qqnt/aio/refresher/ba;", "getVasAvatarResponse", "()Lcom/tencent/qqnt/aio/refresher/ba;", "g", "(Lcom/tencent/qqnt/aio/refresher/ba;)V", "vasAvatarResponse", "setSpecialShapeMaskId", "(I)V", "specialShapeMaskId", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class az implements com.tencent.mobileqq.aio.msglist.holder.external.h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.data.msglist.a msgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int faceId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final VASPersonalVipNumberInfo numberInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean numberIsLong;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ba vasAvatarResponse;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int specialShapeMaskId;

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.faceId;
    }

    @NotNull
    public final com.tencent.aio.data.msglist.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgItem;
    }

    @Nullable
    public final VASPersonalVipNumberInfo c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (VASPersonalVipNumberInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.numberInfo;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.numberIsLong;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.specialShapeMaskId;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof az)) {
            return false;
        }
        az azVar = (az) other;
        if (Intrinsics.areEqual(this.msgItem, azVar.msgItem) && Intrinsics.areEqual(this.uin, azVar.uin) && this.faceId == azVar.faceId && Intrinsics.areEqual(this.numberInfo, azVar.numberInfo) && this.numberIsLong == azVar.numberIsLong && Intrinsics.areEqual(this.vasAvatarResponse, azVar.vasAvatarResponse) && this.specialShapeMaskId == azVar.specialShapeMaskId) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.uin;
    }

    public final void g(@Nullable ba baVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) baVar);
        } else {
            this.vasAvatarResponse = baVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int hashCode2 = ((((this.msgItem.hashCode() * 31) + this.uin.hashCode()) * 31) + this.faceId) * 31;
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
        ba baVar = this.vasAvatarResponse;
        if (baVar != null) {
            i3 = baVar.hashCode();
        }
        return ((i18 + i3) * 31) + this.specialShapeMaskId;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "VasAvatarRefreshRequest(msgItem=" + this.msgItem + ", uin=" + this.uin + ", faceId=" + this.faceId + ", numberInfo=" + this.numberInfo + ", numberIsLong=" + this.numberIsLong + ", vasAvatarResponse=" + this.vasAvatarResponse + ", specialShapeMaskId=" + this.specialShapeMaskId + ")";
    }
}
