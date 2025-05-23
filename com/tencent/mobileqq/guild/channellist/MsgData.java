package com.tencent.mobileqq.guild.channellist;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.guild.summary.GuildSummaryUIData;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010+J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/q;", "", "", "msgCnt", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "unreadInfo", "", tl.h.F, "a", "Lcom/tencent/mobileqq/guild/summary/a;", "guildSummaryData", "", "i", "appId", "j", "", "f", "msgShowType", "Lcom/tencent/mobileqq/guild/summary/b;", "summaryUIData", "b", "", "toString", "hashCode", "other", "equals", "I", "e", "()I", "setMsgShowType", "(I)V", "Lcom/tencent/mobileqq/guild/summary/b;", "g", "()Lcom/tencent/mobileqq/guild/summary/b;", "setSummaryUIData", "(Lcom/tencent/mobileqq/guild/summary/b;)V", "c", "J", "d", "()J", "setMsgCnt", "(J)V", "<init>", "(ILcom/tencent/mobileqq/guild/summary/b;J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.channellist.q, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class MsgData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int msgShowType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private GuildSummaryUIData summaryUIData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long msgCnt;

    public MsgData() {
        this(0, null, 0L, 7, null);
    }

    public static /* synthetic */ MsgData c(MsgData msgData, int i3, GuildSummaryUIData guildSummaryUIData, long j3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = msgData.msgShowType;
        }
        if ((i16 & 2) != 0) {
            guildSummaryUIData = msgData.summaryUIData;
        }
        if ((i16 & 4) != 0) {
            j3 = msgData.msgCnt;
        }
        return msgData.b(i3, guildSummaryUIData, j3);
    }

    private final boolean h(long msgCnt, UnreadInfo unreadInfo) {
        if (msgCnt > 0 && unreadInfo != null && unreadInfo.d().getUnreadType() > 2) {
            return true;
        }
        return false;
    }

    @NotNull
    public final MsgData a() {
        GuildSummaryUIData guildSummaryUIData;
        GuildSummaryUIData guildSummaryUIData2 = this.summaryUIData;
        if (guildSummaryUIData2 != null) {
            guildSummaryUIData = guildSummaryUIData2.a();
        } else {
            guildSummaryUIData = null;
        }
        return c(this, 0, guildSummaryUIData, 0L, 5, null);
    }

    @NotNull
    public final MsgData b(int msgShowType, @Nullable GuildSummaryUIData summaryUIData, long msgCnt) {
        return new MsgData(msgShowType, summaryUIData, msgCnt);
    }

    /* renamed from: d, reason: from getter */
    public final long getMsgCnt() {
        return this.msgCnt;
    }

    /* renamed from: e, reason: from getter */
    public final int getMsgShowType() {
        return this.msgShowType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgData)) {
            return false;
        }
        MsgData msgData = (MsgData) other;
        if (this.msgShowType == msgData.msgShowType && Intrinsics.areEqual(this.summaryUIData, msgData.summaryUIData) && this.msgCnt == msgData.msgCnt) {
            return true;
        }
        return false;
    }

    public final int f() {
        int i3 = this.msgShowType;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 4) {
                    return 2;
                }
                return 1;
            }
            return 3;
        }
        return 0;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final GuildSummaryUIData getSummaryUIData() {
        return this.summaryUIData;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.msgShowType * 31;
        GuildSummaryUIData guildSummaryUIData = this.summaryUIData;
        if (guildSummaryUIData == null) {
            hashCode = 0;
        } else {
            hashCode = guildSummaryUIData.hashCode();
        }
        return ((i3 + hashCode) * 31) + androidx.fragment.app.a.a(this.msgCnt);
    }

    public final void i(@NotNull GuildSummaryData guildSummaryData) {
        String str;
        Object valueOf;
        int unreadType;
        Intrinsics.checkNotNullParameter(guildSummaryData, "guildSummaryData");
        UnreadInfo unreadInfo = guildSummaryData.getUnreadInfo();
        if (unreadInfo != null) {
            long j3 = unreadInfo.j();
            this.msgCnt = j3;
            if (j3 == 0) {
                unreadType = 0;
            } else {
                unreadType = unreadInfo.d().getUnreadType();
            }
            this.msgShowType = unreadType;
        }
        if (h(this.msgCnt, unreadInfo)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f157461mz);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_summary_message)");
            Object[] objArr = new Object[1];
            long j16 = this.msgCnt;
            if (j16 > 99) {
                valueOf = "99+";
            } else {
                valueOf = Long.valueOf(j16);
            }
            objArr[0] = valueOf;
            str = String.format(qqStr, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        } else {
            str = "";
        }
        this.summaryUIData = com.tencent.mobileqq.guild.summary.c.a(guildSummaryData.getLastMessage(), guildSummaryData.getUnreadInfo(), guildSummaryData.getDraftInfo(), str);
    }

    public final void j(@NotNull GuildSummaryData guildSummaryData, long appId) {
        String str;
        Object valueOf;
        boolean z16;
        int j3;
        int unreadType;
        Intrinsics.checkNotNullParameter(guildSummaryData, "guildSummaryData");
        UnreadInfo unreadInfo = guildSummaryData.getUnreadInfo();
        if (unreadInfo != null) {
            if (appId == 1000050) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                j3 = unreadInfo.i();
            } else {
                j3 = unreadInfo.j();
            }
            long j16 = j3;
            this.msgCnt = j16;
            if (j16 == 0) {
                unreadType = 0;
            } else if (z16) {
                if (unreadInfo.k()) {
                    unreadType = 1;
                } else {
                    unreadType = 2;
                }
            } else {
                unreadType = unreadInfo.d().getUnreadType();
            }
            this.msgShowType = unreadType;
        }
        if (h(this.msgCnt, unreadInfo) && appId == 1000137) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f157461mz);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_summary_message)");
            Object[] objArr = new Object[1];
            long j17 = this.msgCnt;
            if (j17 > 99) {
                valueOf = "99+";
            } else {
                valueOf = Long.valueOf(j17);
            }
            objArr[0] = valueOf;
            str = String.format(qqStr, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        } else {
            str = "";
        }
        this.summaryUIData = com.tencent.mobileqq.guild.summary.c.a(guildSummaryData.getLastMessage(), guildSummaryData.getUnreadInfo(), guildSummaryData.getDraftInfo(), str);
    }

    @NotNull
    public String toString() {
        return "MsgData(msgShowType=" + this.msgShowType + ", summaryUIData=" + this.summaryUIData + ", msgCnt=" + this.msgCnt + ")";
    }

    public MsgData(int i3, @Nullable GuildSummaryUIData guildSummaryUIData, long j3) {
        this.msgShowType = i3;
        this.summaryUIData = guildSummaryUIData;
        this.msgCnt = j3;
    }

    public /* synthetic */ MsgData(int i3, GuildSummaryUIData guildSummaryUIData, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : guildSummaryUIData, (i16 & 4) != 0 ? 0L : j3);
    }
}
