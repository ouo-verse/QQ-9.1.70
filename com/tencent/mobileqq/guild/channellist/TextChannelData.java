package com.tencent.mobileqq.guild.channellist;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0000J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0001H\u0016JO\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u00c6\u0001J\t\u0010\u0019\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u001d\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0013\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b\u0013\u0010(R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/t;", "Lcom/tencent/mobileqq/guild/channellist/c;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "d", "Lcom/tencent/mobileqq/guild/summary/a;", "guildSummaryData", "", "o", "e", "newItem", "", tl.h.F, "channelUin", "guildId", "", "channelName", "", "isAdmin", "subtypeId", "index", "Lcom/tencent/mobileqq/guild/channellist/q;", AppConstants.Key.COLUMN_MSG_DATA, "f", "toString", "hashCode", "", "other", "equals", "b", "J", "j", "()J", "c", "k", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "Z", "()Z", "I", "getSubtypeId", "()I", "g", "l", "Lcom/tencent/mobileqq/guild/channellist/q;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/guild/channellist/q;", "setMsgData", "(Lcom/tencent/mobileqq/guild/channellist/q;)V", "<init>", "(JJLjava/lang/String;ZIILcom/tencent/mobileqq/guild/channellist/q;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.channellist.t, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class TextChannelData extends c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long channelUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAdmin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int subtypeId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private MsgData msgData;

    public /* synthetic */ TextChannelData(long j3, long j16, String str, boolean z16, int i3, int i16, MsgData msgData, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j16, str, z16, i3, i16, (i17 & 64) != 0 ? new MsgData(0, null, 0L, 7, null) : msgData);
    }

    public static /* synthetic */ TextChannelData g(TextChannelData textChannelData, long j3, long j16, String str, boolean z16, int i3, int i16, MsgData msgData, int i17, Object obj) {
        long j17;
        long j18;
        String str2;
        boolean z17;
        int i18;
        int i19;
        MsgData msgData2;
        if ((i17 & 1) != 0) {
            j17 = textChannelData.channelUin;
        } else {
            j17 = j3;
        }
        if ((i17 & 2) != 0) {
            j18 = textChannelData.guildId;
        } else {
            j18 = j16;
        }
        if ((i17 & 4) != 0) {
            str2 = textChannelData.channelName;
        } else {
            str2 = str;
        }
        if ((i17 & 8) != 0) {
            z17 = textChannelData.isAdmin;
        } else {
            z17 = z16;
        }
        if ((i17 & 16) != 0) {
            i18 = textChannelData.subtypeId;
        } else {
            i18 = i3;
        }
        if ((i17 & 32) != 0) {
            i19 = textChannelData.index;
        } else {
            i19 = i16;
        }
        if ((i17 & 64) != 0) {
            msgData2 = textChannelData.msgData;
        } else {
            msgData2 = msgData;
        }
        return textChannelData.f(j17, j18, str2, z17, i18, i19, msgData2);
    }

    @Override // com.tencent.mobileqq.guild.channellist.c
    public long d() {
        return Objects.hash(Integer.valueOf(m()), Long.valueOf(this.channelUin));
    }

    @NotNull
    public final TextChannelData e() {
        return g(this, 0L, 0L, null, false, 0, 0, this.msgData.a(), 63, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextChannelData)) {
            return false;
        }
        TextChannelData textChannelData = (TextChannelData) other;
        if (this.channelUin == textChannelData.channelUin && this.guildId == textChannelData.guildId && Intrinsics.areEqual(this.channelName, textChannelData.channelName) && this.isAdmin == textChannelData.isAdmin && this.subtypeId == textChannelData.subtypeId && this.index == textChannelData.index && Intrinsics.areEqual(this.msgData, textChannelData.msgData)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final TextChannelData f(long channelUin, long guildId, @NotNull String channelName, boolean isAdmin, int subtypeId, int index, @NotNull MsgData msgData) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(msgData, "msgData");
        return new TextChannelData(channelUin, guildId, channelName, isAdmin, subtypeId, index, msgData);
    }

    @Override // com.tencent.mobileqq.guild.channellist.c
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public List<Integer> c(@NotNull c newItem) {
        List<Integer> emptyList;
        List<Integer> listOf;
        List<Integer> emptyList2;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof TextChannelData)) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        TextChannelData textChannelData = (TextChannelData) newItem;
        if (Intrinsics.areEqual(this.msgData, textChannelData.msgData) || !Intrinsics.areEqual(g(this, 0L, 0L, null, false, 0, 0, new MsgData(0, null, 0L, 7, null), 63, null), g(textChannelData, 0L, 0L, null, false, 0, 0, new MsgData(0, null, 0L, 7, null), 63, null))) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(1);
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((androidx.fragment.app.a.a(this.channelUin) * 31) + androidx.fragment.app.a.a(this.guildId)) * 31) + this.channelName.hashCode()) * 31;
        boolean z16 = this.isAdmin;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((a16 + i3) * 31) + this.subtypeId) * 31) + this.index) * 31) + this.msgData.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: j, reason: from getter */
    public final long getChannelUin() {
        return this.channelUin;
    }

    /* renamed from: k, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: l, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public int m() {
        return 4;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final MsgData getMsgData() {
        return this.msgData;
    }

    public final void o(@NotNull GuildSummaryData guildSummaryData) {
        Intrinsics.checkNotNullParameter(guildSummaryData, "guildSummaryData");
        this.msgData.i(guildSummaryData);
    }

    @NotNull
    public String toString() {
        return "TextChannelData(channelUin=" + this.channelUin + ", guildId=" + this.guildId + ", channelName=" + this.channelName + ", isAdmin=" + this.isAdmin + ", subtypeId=" + this.subtypeId + ", index=" + this.index + ", msgData=" + this.msgData + ")";
    }

    public TextChannelData(long j3, long j16, @NotNull String channelName, boolean z16, int i3, int i16, @NotNull MsgData msgData) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(msgData, "msgData");
        this.channelUin = j3;
        this.guildId = j16;
        this.channelName = channelName;
        this.isAdmin = z16;
        this.subtypeId = i3;
        this.index = i16;
        this.msgData = msgData;
    }
}
