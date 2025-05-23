package com.tencent.qqnt.contacts.data.item;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0010\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/contacts/data/item/b;", "Lcom/tencent/qqnt/contacts/widget/adapter/node/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setBuddyUid", "(Ljava/lang/String;)V", "buddyUid", "c", "d", "nickName", "getAvatarUrl", PhotoCategorySummaryInfo.AVATAR_URL, "e", "getSignature", "signature", "", "f", "J", "()J", "buddyUin", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class b extends com.tencent.qqnt.contacts.widget.adapter.node.b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String buddyUid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nickName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String avatarUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String signature;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long buddyUin;

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.buddyUid;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.buddyUin;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.nickName;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.buddyUid, bVar.buddyUid) && Intrinsics.areEqual(this.nickName, bVar.nickName) && Intrinsics.areEqual(this.avatarUrl, bVar.avatarUrl) && Intrinsics.areEqual(this.signature, bVar.signature) && this.buddyUin == bVar.buddyUin) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return (((((((this.buddyUid.hashCode() * 31) + this.nickName.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.signature.hashCode()) * 31) + androidx.fragment.app.a.a(this.buddyUin);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "BuddyItem(buddyUid=" + this.buddyUid + ", nickName=" + this.nickName + ", avatarUrl=" + this.avatarUrl + ", signature=" + this.signature + ", buddyUin=" + this.buddyUin + ")";
    }
}
