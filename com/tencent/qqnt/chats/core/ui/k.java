package com.tencent.qqnt.chats.core.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/k;", "", "Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper;", "dataLoadHelper", "", "c", "", "chatType", "", "peerUid", "guildId", "", "b", "a", "Lcom/tencent/qqnt/chats/core/ui/ChatsDataLoadHelper;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f354958a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ChatsDataLoadHelper dataLoadHelper;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47431);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f354958a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(int chatType, @NotNull String peerUid, @NotNull String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(chatType), peerUid, guildId);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        RecentContactInfo recentContactInfo = new RecentContactInfo();
        recentContactInfo.chatType = chatType;
        recentContactInfo.peerUid = peerUid;
        GuildContactInfo guildContactInfo = new GuildContactInfo();
        recentContactInfo.guildContactInfo = guildContactInfo;
        guildContactInfo.guildId = guildId;
        ChatsDataLoadHelper chatsDataLoadHelper = dataLoadHelper;
        if (chatsDataLoadHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLoadHelper");
            chatsDataLoadHelper = null;
        }
        chatsDataLoadHelper.r(recentContactInfo);
    }

    public final boolean b(int chatType, @NotNull String peerUid, @NotNull String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(chatType), peerUid, guildId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        RecentContactInfo recentContactInfo = new RecentContactInfo();
        recentContactInfo.chatType = chatType;
        recentContactInfo.peerUid = peerUid;
        GuildContactInfo guildContactInfo = new GuildContactInfo();
        recentContactInfo.guildContactInfo = guildContactInfo;
        guildContactInfo.guildId = guildId;
        ChatsDataLoadHelper chatsDataLoadHelper = dataLoadHelper;
        if (chatsDataLoadHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLoadHelper");
            chatsDataLoadHelper = null;
        }
        if (chatsDataLoadHelper.c(false, recentContactInfo) >= 0) {
            return true;
        }
        return false;
    }

    public final void c(@NotNull ChatsDataLoadHelper dataLoadHelper2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataLoadHelper2);
        } else {
            Intrinsics.checkNotNullParameter(dataLoadHelper2, "dataLoadHelper");
            dataLoadHelper = dataLoadHelper2;
        }
    }
}
