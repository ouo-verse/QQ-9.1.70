package com.tencent.mobileqq.qqlive.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/ODRoomShareParam;", "", "avatar", "", "hostName", "announcementTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnnouncementTitle", "()Ljava/lang/String;", "getAvatar", "getHostName", "qq-live-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class ODRoomShareParam {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String announcementTitle;

    @NotNull
    private final String avatar;

    @NotNull
    private final String hostName;

    public ODRoomShareParam(@NotNull String avatar, @NotNull String hostName, @NotNull String announcementTitle) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        Intrinsics.checkNotNullParameter(announcementTitle, "announcementTitle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, avatar, hostName, announcementTitle);
            return;
        }
        this.avatar = avatar;
        this.hostName = hostName;
        this.announcementTitle = announcementTitle;
    }

    @NotNull
    public final String getAnnouncementTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.announcementTitle;
    }

    @NotNull
    public final String getAvatar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.avatar;
    }

    @NotNull
    public final String getHostName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.hostName;
    }
}
