package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0012\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/x;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "contentText", "b", "c", "leftBtnText", "e", "rightBtnText", "d", "h5Url", "miniAppUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String contentText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String leftBtnText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String rightBtnText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String h5Url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String miniAppUrl;

    public x(@NotNull String contentText, @NotNull String leftBtnText, @NotNull String rightBtnText, @NotNull String h5Url, @NotNull String miniAppUrl) {
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        Intrinsics.checkNotNullParameter(leftBtnText, "leftBtnText");
        Intrinsics.checkNotNullParameter(rightBtnText, "rightBtnText");
        Intrinsics.checkNotNullParameter(h5Url, "h5Url");
        Intrinsics.checkNotNullParameter(miniAppUrl, "miniAppUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, contentText, leftBtnText, rightBtnText, h5Url, miniAppUrl);
            return;
        }
        this.contentText = contentText;
        this.leftBtnText = leftBtnText;
        this.rightBtnText = rightBtnText;
        this.h5Url = h5Url;
        this.miniAppUrl = miniAppUrl;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.contentText;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.h5Url;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.leftBtnText;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.miniAppUrl;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.rightBtnText;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof x)) {
            return false;
        }
        x xVar = (x) other;
        if (Intrinsics.areEqual(this.contentText, xVar.contentText) && Intrinsics.areEqual(this.leftBtnText, xVar.leftBtnText) && Intrinsics.areEqual(this.rightBtnText, xVar.rightBtnText) && Intrinsics.areEqual(this.h5Url, xVar.h5Url) && Intrinsics.areEqual(this.miniAppUrl, xVar.miniAppUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return (((((((this.contentText.hashCode() * 31) + this.leftBtnText.hashCode()) * 31) + this.rightBtnText.hashCode()) * 31) + this.h5Url.hashCode()) * 31) + this.miniAppUrl.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "ShowErrorTipsParamsWithHandleAbility(contentText=" + this.contentText + ", leftBtnText=" + this.leftBtnText + ", rightBtnText=" + this.rightBtnText + ", h5Url=" + this.h5Url + ", miniAppUrl=" + this.miniAppUrl + ')';
    }
}
