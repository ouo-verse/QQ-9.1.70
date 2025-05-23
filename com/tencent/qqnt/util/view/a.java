package com.tencent.qqnt.util.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/util/view/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "d", "", "listType", "c", "b", "a", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f362998a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38844);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f362998a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean c(RecentContactInfo info, int listType) {
        if (listType == 3 && info.chatType == 103 && ((int) info.unreadFlag) == 3) {
            return true;
        }
        return false;
    }

    private final boolean d(RecentContactInfo info) {
        int i3 = info.chatType;
        if (i3 != 118 && i3 != 201) {
            return false;
        }
        return true;
    }

    public final int a(@NotNull RecentContactInfo info, int listType) {
        GuildContactInfo guildContactInfo;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) info, listType)).intValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (b(info, listType) == 2) {
            if (info.chatType != 16 || (guildContactInfo = info.guildContactInfo) == null || (i3 = guildContactInfo.unreadCntInfo.showUnreadCnt.cnt) <= 0) {
                return (int) info.unreadCnt;
            }
            return i3;
        }
        return 0;
    }

    public final int b(@NotNull RecentContactInfo info, int listType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) info, listType)).intValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.chatType == 16) {
            if (info.guildContactInfo.unreadCntInfo.showUnreadCnt.type != 2) {
                return 2;
            }
            return 3;
        }
        if (((int) info.unreadFlag) != 0 && d(info)) {
            return (int) info.unreadFlag;
        }
        if (((int) info.unreadFlag) == 1) {
            return 1;
        }
        if (!info.isMsgDisturb) {
            long j3 = info.shieldFlag;
            if (((int) j3) != 2 && ((int) j3) != 4 && ((int) j3) != 3 && listType != 5 && !c(info, listType)) {
                return 2;
            }
        }
        return 3;
    }
}
