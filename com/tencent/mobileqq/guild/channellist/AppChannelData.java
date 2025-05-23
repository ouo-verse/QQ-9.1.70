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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0000J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0001H\u0016Jg\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001J\t\u0010\u001b\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u001f\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0013\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b\u0013\u0010*R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010!\u001a\u0004\b+\u0010#R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b-\u0010(R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010.\u001a\u0004\b/\u00100R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010&\u001a\u0004\b6\u0010(\"\u0004\b7\u00108\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/a;", "Lcom/tencent/mobileqq/guild/channellist/c;", "", DomainData.DOMAIN_NAME, "", "d", "Lcom/tencent/mobileqq/guild/summary/a;", "guildSummaryData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "newItem", "", tl.h.F, "channelUin", "guildId", "", "channelName", "", "isAdmin", "appId", "appChannelIconUrl", "index", "Lcom/tencent/mobileqq/guild/channellist/q;", AppConstants.Key.COLUMN_MSG_DATA, "channelTips", "f", "toString", "hashCode", "", "other", "equals", "b", "J", "k", "()J", "c", "l", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "Z", "()Z", "getAppId", "g", "getAppChannelIconUrl", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "Lcom/tencent/mobileqq/guild/channellist/q;", "o", "()Lcom/tencent/mobileqq/guild/channellist/q;", "setMsgData", "(Lcom/tencent/mobileqq/guild/channellist/q;)V", "j", "p", "(Ljava/lang/String;)V", "<init>", "(JJLjava/lang/String;ZJLjava/lang/String;ILcom/tencent/mobileqq/guild/channellist/q;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.channellist.a, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class AppChannelData extends c {

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
    private final long appId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String appChannelIconUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private MsgData msgData;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String channelTips;

    public /* synthetic */ AppChannelData(long j3, long j16, String str, boolean z16, long j17, String str2, int i3, MsgData msgData, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j16, str, z16, j17, str2, i3, (i16 & 128) != 0 ? new MsgData(0, null, 0L, 7, null) : msgData, (i16 & 256) != 0 ? null : str3);
    }

    public static /* synthetic */ AppChannelData g(AppChannelData appChannelData, long j3, long j16, String str, boolean z16, long j17, String str2, int i3, MsgData msgData, String str3, int i16, Object obj) {
        long j18;
        long j19;
        String str4;
        boolean z17;
        long j26;
        String str5;
        int i17;
        MsgData msgData2;
        String str6;
        if ((i16 & 1) != 0) {
            j18 = appChannelData.channelUin;
        } else {
            j18 = j3;
        }
        if ((i16 & 2) != 0) {
            j19 = appChannelData.guildId;
        } else {
            j19 = j16;
        }
        if ((i16 & 4) != 0) {
            str4 = appChannelData.channelName;
        } else {
            str4 = str;
        }
        if ((i16 & 8) != 0) {
            z17 = appChannelData.isAdmin;
        } else {
            z17 = z16;
        }
        if ((i16 & 16) != 0) {
            j26 = appChannelData.appId;
        } else {
            j26 = j17;
        }
        if ((i16 & 32) != 0) {
            str5 = appChannelData.appChannelIconUrl;
        } else {
            str5 = str2;
        }
        if ((i16 & 64) != 0) {
            i17 = appChannelData.index;
        } else {
            i17 = i3;
        }
        if ((i16 & 128) != 0) {
            msgData2 = appChannelData.msgData;
        } else {
            msgData2 = msgData;
        }
        if ((i16 & 256) != 0) {
            str6 = appChannelData.channelTips;
        } else {
            str6 = str3;
        }
        return appChannelData.f(j18, j19, str4, z17, j26, str5, i17, msgData2, str6);
    }

    @Override // com.tencent.mobileqq.guild.channellist.c
    public long d() {
        return Objects.hash(Integer.valueOf(n()), Long.valueOf(this.channelUin));
    }

    @NotNull
    public final AppChannelData e() {
        return g(this, 0L, 0L, null, false, 0L, null, 0, this.msgData.a(), null, 383, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppChannelData)) {
            return false;
        }
        AppChannelData appChannelData = (AppChannelData) other;
        if (this.channelUin == appChannelData.channelUin && this.guildId == appChannelData.guildId && Intrinsics.areEqual(this.channelName, appChannelData.channelName) && this.isAdmin == appChannelData.isAdmin && this.appId == appChannelData.appId && Intrinsics.areEqual(this.appChannelIconUrl, appChannelData.appChannelIconUrl) && this.index == appChannelData.index && Intrinsics.areEqual(this.msgData, appChannelData.msgData) && Intrinsics.areEqual(this.channelTips, appChannelData.channelTips)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final AppChannelData f(long channelUin, long guildId, @NotNull String channelName, boolean isAdmin, long appId, @Nullable String appChannelIconUrl, int index, @NotNull MsgData msgData, @Nullable String channelTips) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(msgData, "msgData");
        return new AppChannelData(channelUin, guildId, channelName, isAdmin, appId, appChannelIconUrl, index, msgData, channelTips);
    }

    @Override // com.tencent.mobileqq.guild.channellist.c
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public List<Integer> c(@NotNull c newItem) {
        List<Integer> emptyList;
        List<Integer> listOf;
        List<Integer> emptyList2;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof AppChannelData)) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        AppChannelData appChannelData = (AppChannelData) newItem;
        if (Intrinsics.areEqual(this.msgData, appChannelData.msgData) || !Intrinsics.areEqual(g(this, 0L, 0L, null, false, 0L, null, 0, new MsgData(0, null, 0L, 7, null), null, 383, null), g(appChannelData, 0L, 0L, null, false, 0L, null, 0, new MsgData(0, null, 0L, 7, null), null, 383, null))) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(1);
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int a16 = ((((androidx.fragment.app.a.a(this.channelUin) * 31) + androidx.fragment.app.a.a(this.guildId)) * 31) + this.channelName.hashCode()) * 31;
        boolean z16 = this.isAdmin;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int a17 = (((a16 + i3) * 31) + androidx.fragment.app.a.a(this.appId)) * 31;
        String str = this.appChannelIconUrl;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode2 = (((((a17 + hashCode) * 31) + this.index) * 31) + this.msgData.hashCode()) * 31;
        String str2 = this.channelTips;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return hashCode2 + i16;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getChannelTips() {
        return this.channelTips;
    }

    /* renamed from: k, reason: from getter */
    public final long getChannelUin() {
        return this.channelUin;
    }

    /* renamed from: l, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: m, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public int n() {
        return 5;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final MsgData getMsgData() {
        return this.msgData;
    }

    public final void p(@Nullable String str) {
        this.channelTips = str;
    }

    public final void q(@NotNull GuildSummaryData guildSummaryData) {
        Intrinsics.checkNotNullParameter(guildSummaryData, "guildSummaryData");
        this.msgData.j(guildSummaryData, this.appId);
    }

    @NotNull
    public String toString() {
        return "AppChannelData(channelUin=" + this.channelUin + ", guildId=" + this.guildId + ", channelName=" + this.channelName + ", isAdmin=" + this.isAdmin + ", appId=" + this.appId + ", appChannelIconUrl=" + this.appChannelIconUrl + ", index=" + this.index + ", msgData=" + this.msgData + ", channelTips=" + this.channelTips + ")";
    }

    public AppChannelData(long j3, long j16, @NotNull String channelName, boolean z16, long j17, @Nullable String str, int i3, @NotNull MsgData msgData, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(msgData, "msgData");
        this.channelUin = j3;
        this.guildId = j16;
        this.channelName = channelName;
        this.isAdmin = z16;
        this.appId = j17;
        this.appChannelIconUrl = str;
        this.index = i3;
        this.msgData = msgData;
        this.channelTips = str2;
    }
}
