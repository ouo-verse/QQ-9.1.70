package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\b\u0010\u0012\u001a\u00020\bH\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDetailViewDestroyEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "<set-?>", "", "businessType", "getBusinessType", "()I", "", "channelExtensionInfo", "getChannelExtensionInfo", "()Ljava/lang/String;", "searchExtensionInfo", "getSearchExtensionInfo", "setBusinessType", "type", "setChannelExtensionInfo", "setSearchExtensionInfo", "toString", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedDetailViewDestroyEvent extends SimpleBaseEvent {
    private int businessType;

    @NotNull
    private String searchExtensionInfo = "";

    @NotNull
    private String channelExtensionInfo = "";

    public final int getBusinessType() {
        return this.businessType;
    }

    @NotNull
    public final String getChannelExtensionInfo() {
        return this.channelExtensionInfo;
    }

    @NotNull
    public final String getSearchExtensionInfo() {
        return this.searchExtensionInfo;
    }

    @NotNull
    public final GuildFeedDetailViewDestroyEvent setBusinessType(int type) {
        this.businessType = type;
        return this;
    }

    @NotNull
    public final GuildFeedDetailViewDestroyEvent setChannelExtensionInfo(@NotNull String channelExtensionInfo) {
        Intrinsics.checkNotNullParameter(channelExtensionInfo, "channelExtensionInfo");
        this.channelExtensionInfo = channelExtensionInfo;
        return this;
    }

    @NotNull
    public final GuildFeedDetailViewDestroyEvent setSearchExtensionInfo(@NotNull String searchExtensionInfo) {
        Intrinsics.checkNotNullParameter(searchExtensionInfo, "searchExtensionInfo");
        this.searchExtensionInfo = searchExtensionInfo;
        return this;
    }

    @NotNull
    public String toString() {
        return "GuildFeedDetailViewDestroyEvent(businessType=" + this.businessType + ", searchExtensionInfo='" + this.searchExtensionInfo + "', channelExtensionInfo='" + this.channelExtensionInfo + "')";
    }
}
