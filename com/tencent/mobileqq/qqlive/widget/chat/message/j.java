package com.tencent.mobileqq.qqlive.widget.chat.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/message/j;", "", "", "a", "Ljava/lang/CharSequence;", "d", "()Ljava/lang/CharSequence;", "systemNotice", "", "b", "I", "c", "()I", "sysMsgType", "e", "txtColor", "", "Ljava/lang/String;", "()Ljava/lang/String;", "firstAnnounceLinkTxt", "firstAnnounceLink", "<init>", "(Ljava/lang/CharSequence;IILjava/lang/String;Ljava/lang/String;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence systemNotice;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int sysMsgType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int txtColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String firstAnnounceLinkTxt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String firstAnnounceLink;

    public j(@NotNull CharSequence systemNotice, int i3, int i16, @NotNull String firstAnnounceLinkTxt, @NotNull String firstAnnounceLink) {
        Intrinsics.checkNotNullParameter(systemNotice, "systemNotice");
        Intrinsics.checkNotNullParameter(firstAnnounceLinkTxt, "firstAnnounceLinkTxt");
        Intrinsics.checkNotNullParameter(firstAnnounceLink, "firstAnnounceLink");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, systemNotice, Integer.valueOf(i3), Integer.valueOf(i16), firstAnnounceLinkTxt, firstAnnounceLink);
            return;
        }
        this.systemNotice = systemNotice;
        this.sysMsgType = i3;
        this.txtColor = i16;
        this.firstAnnounceLinkTxt = firstAnnounceLinkTxt;
        this.firstAnnounceLink = firstAnnounceLink;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.firstAnnounceLink;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.firstAnnounceLinkTxt;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.sysMsgType;
    }

    @NotNull
    public final CharSequence d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.systemNotice;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.txtColor;
    }

    public /* synthetic */ j(CharSequence charSequence, int i3, int i16, String str, String str2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? "" : str, (i17 & 16) != 0 ? "" : str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
