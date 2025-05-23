package com.tencent.qqnt.chats.biz.guild;

import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCnt;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/g;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "recentContactInfo", "", "c", "a", "d", "b", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f354280a = new g();

    g() {
    }

    public final int a(@NotNull RecentContactInfo recentContactInfo) {
        UnreadCntInfo unreadCntInfo;
        UnreadCnt unreadCnt;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(recentContactInfo, "recentContactInfo");
        if (ex3.a.e(recentContactInfo) != 5 && ex3.a.e(recentContactInfo) != 2 && (i3 = (unreadCnt = (unreadCntInfo = recentContactInfo.guildContactInfo.unreadCntInfo).allUnreadCnt).cnt) > 0) {
            int i17 = unreadCnt.type;
            if (i17 == 1) {
                return i3;
            }
            if (i17 == 2 && (i16 = unreadCntInfo.relatedToMeCnt) > 0) {
                return i16;
            }
        }
        return 0;
    }

    public final int b(@NotNull RecentContactInfo recentContactInfo) {
        Integer num;
        boolean z16;
        UnreadCntInfo unreadCntInfo;
        UnreadCnt unreadCnt;
        Intrinsics.checkNotNullParameter(recentContactInfo, "recentContactInfo");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null && (unreadCntInfo = guildContactInfo.unreadCntInfo) != null && (unreadCnt = unreadCntInfo.showUnreadCnt) != null) {
            num = Integer.valueOf(unreadCnt.type);
        } else {
            num = null;
        }
        if ((num != null && num.intValue() == 3) || (num != null && num.intValue() == 2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 3;
        }
        return 1;
    }

    public final int c(@NotNull RecentContactInfo recentContactInfo) {
        boolean z16;
        GuildContactInfo guildContactInfo;
        UnreadCntInfo unreadCntInfo;
        UnreadCnt unreadCnt;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(recentContactInfo, "recentContactInfo");
        boolean z17 = true;
        if (ex3.a.k(recentContactInfo) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        UnreadCnt unreadCnt2 = null;
        if (!z16) {
            recentContactInfo = null;
        }
        if (recentContactInfo == null || (guildContactInfo = recentContactInfo.guildContactInfo) == null || (unreadCntInfo = guildContactInfo.unreadCntInfo) == null || (unreadCnt = unreadCntInfo.showUnreadCnt) == null) {
            return 0;
        }
        if (unreadCnt.type == 4) {
            z17 = false;
        }
        if (z17) {
            unreadCnt2 = unreadCnt;
        }
        if (unreadCnt2 != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(unreadCnt2.cnt, 0);
            return coerceAtLeast;
        }
        return 0;
    }

    public final int d(@NotNull RecentContactInfo recentContactInfo) {
        Integer num;
        UnreadCntInfo unreadCntInfo;
        UnreadCnt unreadCnt;
        Intrinsics.checkNotNullParameter(recentContactInfo, "recentContactInfo");
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo != null && (unreadCntInfo = guildContactInfo.unreadCntInfo) != null && (unreadCnt = unreadCntInfo.showUnreadCnt) != null) {
            num = Integer.valueOf(unreadCnt.type);
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 3) {
            return 3;
        }
        if (num != null && num.intValue() == 2) {
            return 2;
        }
        return 1;
    }
}
