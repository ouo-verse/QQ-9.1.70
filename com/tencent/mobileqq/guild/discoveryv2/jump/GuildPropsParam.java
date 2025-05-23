package com.tencent.mobileqq.guild.discoveryv2.jump;

import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/jump/GuildPropsParam;", "", WadlProxyConsts.SCENE_ID, "", "bid", "", "bussiSource", "busiInfo", "(ILjava/lang/String;ILjava/lang/String;)V", "getBid", "()Ljava/lang/String;", "getBusiInfo", "setBusiInfo", "(Ljava/lang/String;)V", "getBussiSource", "()I", "getSceneId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildPropsParam {

    @NotNull
    private final String bid;

    @NotNull
    private String busiInfo;
    private final int bussiSource;
    private final int sceneId;

    public GuildPropsParam(int i3, @NotNull String bid, int i16, @NotNull String busiInfo) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(busiInfo, "busiInfo");
        this.sceneId = i3;
        this.bid = bid;
        this.bussiSource = i16;
        this.busiInfo = busiInfo;
    }

    public static /* synthetic */ GuildPropsParam copy$default(GuildPropsParam guildPropsParam, int i3, String str, int i16, String str2, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = guildPropsParam.sceneId;
        }
        if ((i17 & 2) != 0) {
            str = guildPropsParam.bid;
        }
        if ((i17 & 4) != 0) {
            i16 = guildPropsParam.bussiSource;
        }
        if ((i17 & 8) != 0) {
            str2 = guildPropsParam.busiInfo;
        }
        return guildPropsParam.copy(i3, str, i16, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSceneId() {
        return this.sceneId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getBid() {
        return this.bid;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBussiSource() {
        return this.bussiSource;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getBusiInfo() {
        return this.busiInfo;
    }

    @NotNull
    public final GuildPropsParam copy(int sceneId, @NotNull String bid, int bussiSource, @NotNull String busiInfo) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(busiInfo, "busiInfo");
        return new GuildPropsParam(sceneId, bid, bussiSource, busiInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildPropsParam)) {
            return false;
        }
        GuildPropsParam guildPropsParam = (GuildPropsParam) other;
        if (this.sceneId == guildPropsParam.sceneId && Intrinsics.areEqual(this.bid, guildPropsParam.bid) && this.bussiSource == guildPropsParam.bussiSource && Intrinsics.areEqual(this.busiInfo, guildPropsParam.busiInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getBid() {
        return this.bid;
    }

    @NotNull
    public final String getBusiInfo() {
        return this.busiInfo;
    }

    public final int getBussiSource() {
        return this.bussiSource;
    }

    public final int getSceneId() {
        return this.sceneId;
    }

    public int hashCode() {
        return (((((this.sceneId * 31) + this.bid.hashCode()) * 31) + this.bussiSource) * 31) + this.busiInfo.hashCode();
    }

    public final void setBusiInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.busiInfo = str;
    }

    @NotNull
    public String toString() {
        return "GuildPropsParam(sceneId=" + this.sceneId + ", bid=" + this.bid + ", bussiSource=" + this.bussiSource + ", busiInfo=" + this.busiInfo + ")";
    }

    public /* synthetic */ GuildPropsParam(int i3, String str, int i16, String str2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, i16, (i17 & 8) != 0 ? "" : str2);
    }
}
