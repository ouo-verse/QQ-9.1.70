package ex3;

import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\t*\u00020\u0000\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "", "f", "b", "g", "c", "", "e", "d", "", "a", "i", h.F, "j", "k", "kernel_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    public static final long a(@NotNull RecentContactInfo recentContactInfo) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null) {
            return guildContactInfo.avatarSeq;
        }
        return 0L;
    }

    @NotNull
    public static final String b(@NotNull RecentContactInfo recentContactInfo) {
        String str;
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null) {
            str = guildContactInfo.channelId;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String c(@NotNull RecentContactInfo recentContactInfo) {
        String str;
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null) {
            str = guildContactInfo.channelName;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final int d(@NotNull RecentContactInfo recentContactInfo) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null) {
            return guildContactInfo.channelSubType;
        }
        return 0;
    }

    public static final int e(@NotNull RecentContactInfo recentContactInfo) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null) {
            return guildContactInfo.channelType;
        }
        return 0;
    }

    @NotNull
    public static final String f(@NotNull RecentContactInfo recentContactInfo) {
        String str;
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        int i3 = recentContactInfo.chatType;
        if (i3 != 16 && i3 != 62) {
            GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
            if (guildContactInfo != null) {
                str = guildContactInfo.guildId;
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        String peerUid = recentContactInfo.peerUid;
        Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
        return peerUid;
    }

    @NotNull
    public static final String g(@NotNull RecentContactInfo recentContactInfo) {
        String str;
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null) {
            str = guildContactInfo.guildName;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final long h(@NotNull RecentContactInfo recentContactInfo) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null) {
            return guildContactInfo.msgSeq;
        }
        return 0L;
    }

    public static final long i(@NotNull RecentContactInfo recentContactInfo) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null) {
            return guildContactInfo.msgType;
        }
        return 0L;
    }

    public static final int j(@NotNull RecentContactInfo recentContactInfo) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null) {
            return guildContactInfo.newPostUnreadCnt;
        }
        return 0;
    }

    public static final int k(@NotNull RecentContactInfo recentContactInfo) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "<this>");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null) {
            return guildContactInfo.unNotifyFlag;
        }
        return 0;
    }
}
