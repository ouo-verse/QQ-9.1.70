package com.tencent.mobileqq.guild.mainframe.util;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.helper.d;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService;
import com.tencent.mobileqq.guild.openentrance.eventbus.GuildJumpNextUnreadNodeEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/util/i;", "", "", "d", "", "e", "Lcom/tencent/mobileqq/guild/mainframe/helper/d$a;", "selItem", "", "Lcs1/b;", "originDataList", "b", "Lcom/tencent/mobileqq/guild/mainframe/util/i$a;", "c", "", "J", "lastClickTime", "lastHitDoubleClickTime", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f227718a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastClickTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastHitDoubleClickTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bB'\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0015\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/util/i$a;", "", "Lcom/tencent/mobileqq/guild/mainframe/helper/d$a;", "e", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "type", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "guildId", "", "c", "J", "()J", "msgCnt", "msgCntType", "<init>", "(ILjava/lang/String;JI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.util.i$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class GuildLeftNodeWithMsgCnt {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long msgCnt;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int msgCntType;

        public GuildLeftNodeWithMsgCnt(int i3, @NotNull String guildId, long j3, int i16) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.type = i3;
            this.guildId = guildId;
            this.msgCnt = j3;
            this.msgCntType = i16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        /* renamed from: b, reason: from getter */
        public final long getMsgCnt() {
            return this.msgCnt;
        }

        /* renamed from: c, reason: from getter */
        public final int getMsgCntType() {
            return this.msgCntType;
        }

        /* renamed from: d, reason: from getter */
        public final int getType() {
            return this.type;
        }

        @NotNull
        public final d.a e() {
            return new d.a(this.type, this.guildId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildLeftNodeWithMsgCnt)) {
                return false;
            }
            GuildLeftNodeWithMsgCnt guildLeftNodeWithMsgCnt = (GuildLeftNodeWithMsgCnt) other;
            if (this.type == guildLeftNodeWithMsgCnt.type && Intrinsics.areEqual(this.guildId, guildLeftNodeWithMsgCnt.guildId) && this.msgCnt == guildLeftNodeWithMsgCnt.msgCnt && this.msgCntType == guildLeftNodeWithMsgCnt.msgCntType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.type * 31) + this.guildId.hashCode()) * 31) + androidx.fragment.app.a.a(this.msgCnt)) * 31) + this.msgCntType;
        }

        @NotNull
        public String toString() {
            return "GuildLeftNodeWithMsgCnt(type=" + this.type + ", guildId=" + this.guildId + ", msgCnt=" + this.msgCnt + ", msgCntType=" + this.msgCntType + ")";
        }
    }

    i() {
    }

    @JvmStatic
    @Nullable
    public static final d.a b(@NotNull d.a selItem, @NotNull List<? extends cs1.b> originDataList) {
        Intrinsics.checkNotNullParameter(selItem, "selItem");
        Intrinsics.checkNotNullParameter(originDataList, "originDataList");
        GuildLeftNodeWithMsgCnt guildLeftNodeWithMsgCnt = null;
        GuildLeftNodeWithMsgCnt guildLeftNodeWithMsgCnt2 = null;
        GuildLeftNodeWithMsgCnt guildLeftNodeWithMsgCnt3 = null;
        GuildLeftNodeWithMsgCnt guildLeftNodeWithMsgCnt4 = null;
        boolean z16 = true;
        int i3 = 0;
        for (Object obj : f227718a.c(originDataList)) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GuildLeftNodeWithMsgCnt guildLeftNodeWithMsgCnt5 = (GuildLeftNodeWithMsgCnt) obj;
            if (guildLeftNodeWithMsgCnt5.getType() == selItem.f227428a && Intrinsics.areEqual(guildLeftNodeWithMsgCnt5.getGuildId(), selItem.f227429b)) {
                z16 = false;
                guildLeftNodeWithMsgCnt2 = guildLeftNodeWithMsgCnt5;
            } else if (!z16) {
                if (guildLeftNodeWithMsgCnt5.getMsgCnt() > 0 && guildLeftNodeWithMsgCnt5.getMsgCntType() == 1) {
                    return guildLeftNodeWithMsgCnt5.e();
                }
                if (guildLeftNodeWithMsgCnt3 == null && guildLeftNodeWithMsgCnt5.getMsgCnt() > 0 && guildLeftNodeWithMsgCnt5.getMsgCntType() == 2) {
                    guildLeftNodeWithMsgCnt3 = guildLeftNodeWithMsgCnt5;
                }
            } else if (guildLeftNodeWithMsgCnt == null) {
                if (guildLeftNodeWithMsgCnt5.getMsgCnt() > 0 && guildLeftNodeWithMsgCnt5.getMsgCntType() == 1) {
                    guildLeftNodeWithMsgCnt = guildLeftNodeWithMsgCnt5;
                } else if (guildLeftNodeWithMsgCnt4 == null && guildLeftNodeWithMsgCnt5.getMsgCnt() > 0 && guildLeftNodeWithMsgCnt5.getMsgCntType() == 2) {
                    guildLeftNodeWithMsgCnt4 = guildLeftNodeWithMsgCnt5;
                }
            }
            i3 = i16;
        }
        if (guildLeftNodeWithMsgCnt != null) {
            return guildLeftNodeWithMsgCnt.e();
        }
        if (guildLeftNodeWithMsgCnt2 != null && guildLeftNodeWithMsgCnt2.getMsgCnt() > 0 && guildLeftNodeWithMsgCnt2.getMsgCntType() == 1) {
            return null;
        }
        if (guildLeftNodeWithMsgCnt3 != null) {
            return guildLeftNodeWithMsgCnt3.e();
        }
        if (guildLeftNodeWithMsgCnt4 == null) {
            return null;
        }
        return guildLeftNodeWithMsgCnt4.e();
    }

    private final List<GuildLeftNodeWithMsgCnt> c(List<? extends cs1.b> originDataList) {
        int i3;
        int i16;
        int i17;
        ArrayList arrayList = new ArrayList();
        UnreadInfo.a mine = ((IGuildTotalUnreadService) ch.R0(IGuildTotalUnreadService.class)).getTotalCount().getMine();
        long count = mine.getCount();
        if (mine.getCount() <= 0) {
            i16 = 0;
        } else {
            if (mine.getIsStrongUnread()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            i16 = i3;
        }
        arrayList.add(new GuildLeftNodeWithMsgCnt(4, "", count, i16));
        for (cs1.b bVar : originDataList) {
            int h16 = bVar.h();
            String str = bVar.f391796e;
            Intrinsics.checkNotNullExpressionValue(str, "originNodeUIData.guildId");
            boolean z16 = bVar instanceof cs1.e;
            long j3 = 0;
            if (z16 && !bVar.f391797f) {
                j3 = ((cs1.e) bVar).E.f230840d;
            }
            if (z16 && !bVar.f391797f) {
                i17 = ((cs1.e) bVar).E.f230841e;
            } else {
                i17 = 0;
            }
            arrayList.add(new GuildLeftNodeWithMsgCnt(h16, str, j3, i17));
        }
        return arrayList;
    }

    @JvmStatic
    public static final boolean d() {
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Logger.f235387a.d().d("GuildTabDoubleClickUtils", 1, "double_jump isConsiderDoubleClick gap:" + (currentTimeMillis - lastClickTime) + " lastClickTime:" + lastClickTime + " currentTime:" + currentTimeMillis);
        if (currentTimeMillis - lastClickTime > 500) {
            lastClickTime = currentTimeMillis;
            return false;
        }
        if (currentTimeMillis - lastHitDoubleClickTime < 500) {
            lastClickTime = currentTimeMillis;
            return false;
        }
        if (((IGuildDelayInitializeService) ch.R0(IGuildDelayInitializeService.class)).getGuildTabUnreadCountSafely().getCount() <= 0) {
            lastClickTime = currentTimeMillis;
            return false;
        }
        lastClickTime = 0L;
        lastHitDoubleClickTime = currentTimeMillis;
        return true;
    }

    @JvmStatic
    public static final void e() {
        Logger.f235387a.d().d("GuildTabDoubleClickUtils", 1, "double_jump jumpForDoubleClick");
        SimpleEventBus.getInstance().dispatchEvent(new GuildJumpNextUnreadNodeEvent());
    }
}
