package com.tencent.mobileqq.aio.title.notifyservice;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/title/notifyservice/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "isVisible", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "nickName", "c", "getUid", "uid", "avatarPath", "e", QQWinkConstants.TAB_SUBTITLE, "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isVisible;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nickName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String uid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String avatarPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subTitle;

    public d() {
        this(false, null, null, null, null, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.avatarPath;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.nickName;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.subTitle;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isVisible;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (this.isVisible == dVar.isVisible && Intrinsics.areEqual(this.nickName, dVar.nickName) && Intrinsics.areEqual(this.uid, dVar.uid) && Intrinsics.areEqual(this.avatarPath, dVar.avatarPath) && Intrinsics.areEqual(this.subTitle, dVar.subTitle)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        boolean z16 = this.isVisible;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((r06 * 31) + this.nickName.hashCode()) * 31) + this.uid.hashCode()) * 31) + this.avatarPath.hashCode()) * 31) + this.subTitle.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "UpdateNotifyServiceParam(isVisible=" + this.isVisible + ", nickName=" + this.nickName + ", uid=" + this.uid + ", avatarPath=" + this.avatarPath + ", subTitle=" + this.subTitle + ")";
    }

    public d(boolean z16, @NotNull String nickName, @NotNull String uid, @NotNull String avatarPath, @NotNull String subTitle) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(avatarPath, "avatarPath");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), nickName, uid, avatarPath, subTitle);
            return;
        }
        this.isVisible = z16;
        this.nickName = nickName;
        this.uid = uid;
        this.avatarPath = avatarPath;
        this.subTitle = subTitle;
    }

    public /* synthetic */ d(boolean z16, String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, str3, str4, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
