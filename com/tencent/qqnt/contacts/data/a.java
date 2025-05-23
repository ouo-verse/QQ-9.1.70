package com.tencent.qqnt.contacts.data;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u001e\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/contacts/data/a;", "Lcom/tencent/qqnt/contacts/data/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setBuddyUid", "(Ljava/lang/String;)V", "buddyUid", "d", tl.h.F, "nickName", "e", "getAvatarUrl", PhotoCategorySummaryInfo.AVATAR_URL, "getSignature", "signature", "", "g", "J", "()J", "buddyUin", "()I", "itemViewType", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String buddyUid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nickName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String avatarUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String signature;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final long buddyUin;

    @Override // com.tencent.qqnt.base.adapter.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 1;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.buddyUid, aVar.buddyUid) && Intrinsics.areEqual(this.nickName, aVar.nickName) && Intrinsics.areEqual(this.avatarUrl, aVar.avatarUrl) && Intrinsics.areEqual(this.signature, aVar.signature) && this.buddyUin == aVar.buddyUin) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.buddyUid;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.buddyUin;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.nickName;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return (((((((this.buddyUid.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.signature.hashCode()) * 31) + androidx.fragment.app.a.a(this.buddyUin);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "BuddyContactsItem(buddyUid=" + this.buddyUid + ", nickName=" + this.nickName + ", avatarUrl=" + this.avatarUrl + ", signature=" + this.signature + ", buddyUin=" + this.buddyUin + ")";
    }
}
