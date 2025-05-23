package com.tencent.qqnt.contacts.data;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/contacts/data/j;", "Lcom/tencent/qqnt/contacts/data/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setMemberUid", "(Ljava/lang/String;)V", "memberUid", "d", "f", "memberNick", "e", "getAvatarUrl", PhotoCategorySummaryInfo.AVATAR_URL, "", "J", tl.h.F, "()J", "memberUin", "()I", "itemViewType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class j implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String memberUid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String memberNick;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String avatarUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long memberUin;

    public j(@NotNull String memberUid, @NotNull String memberNick, @NotNull String avatarUrl, long j3) {
        Intrinsics.checkNotNullParameter(memberUid, "memberUid");
        Intrinsics.checkNotNullParameter(memberNick, "memberNick");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, memberUid, memberNick, avatarUrl, Long.valueOf(j3));
            return;
        }
        this.memberUid = memberUid;
        this.memberNick = memberNick;
        this.avatarUrl = avatarUrl;
        this.memberUin = j3;
    }

    @Override // com.tencent.qqnt.base.adapter.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 5;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        if (Intrinsics.areEqual(this.memberUid, jVar.memberUid) && Intrinsics.areEqual(this.memberNick, jVar.memberNick) && Intrinsics.areEqual(this.avatarUrl, jVar.avatarUrl) && this.memberUin == jVar.memberUin) {
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
        return this.memberNick;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.memberUid;
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.memberUin;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return (((((this.memberUid.hashCode() * 31) + this.memberNick.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + androidx.fragment.app.a.a(this.memberUin);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "GroupMemberItem(memberUid=" + this.memberUid + ", memberNick=" + this.memberNick + ", avatarUrl=" + this.avatarUrl + ", memberUin=" + this.memberUin + ")";
    }
}
