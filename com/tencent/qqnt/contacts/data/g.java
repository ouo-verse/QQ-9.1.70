package com.tencent.qqnt.contacts.data;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/contacts/data/g;", "Lcom/tencent/qqnt/contacts/data/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "c", "J", "f", "()J", "setGroupCode", "(J)V", "groupCode", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "groupName", "e", "getAvatarUrl", PhotoCategorySummaryInfo.AVATAR_URL, "()I", "itemViewType", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class g implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long groupCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String groupName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String avatarUrl;

    public g(long j3, @NotNull String groupName, @NotNull String avatarUrl) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), groupName, avatarUrl);
            return;
        }
        this.groupCode = j3;
        this.groupName = groupName;
        this.avatarUrl = avatarUrl;
    }

    @Override // com.tencent.qqnt.base.adapter.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 4;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (this.groupCode == gVar.groupCode && Intrinsics.areEqual(this.groupName, gVar.groupName) && Intrinsics.areEqual(this.avatarUrl, gVar.avatarUrl)) {
            return true;
        }
        return false;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.groupCode;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.groupName;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (((androidx.fragment.app.a.a(this.groupCode) * 31) + this.groupName.hashCode()) * 31) + this.avatarUrl.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "GroupContactsItem(groupCode=" + this.groupCode + ", groupName=" + this.groupName + ", avatarUrl=" + this.avatarUrl + ")";
    }
}
