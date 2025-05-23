package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u0007H\u0016R$\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011R$\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDetailInteractiveEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "type", "setBusinessType", "interactiveType", "setInteractiveType", "", "searchExtensionInfo", "setSearchExtensionInfo", "channelExtensionInfo", "setChannelExtensionInfo", "toString", "<set-?>", "businessType", "I", "getBusinessType", "()I", "getInteractiveType", "Ljava/lang/String;", "getSearchExtensionInfo", "()Ljava/lang/String;", "getChannelExtensionInfo", "<init>", "()V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedDetailInteractiveEvent extends SimpleBaseEvent {
    public static final int INTERACTIVE_TYPE_LIKE = 1;
    public static final int INTERACTIVE_TYPE_SHARE = 2;
    private int businessType;
    private int interactiveType;

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

    public final int getInteractiveType() {
        return this.interactiveType;
    }

    @NotNull
    public final String getSearchExtensionInfo() {
        return this.searchExtensionInfo;
    }

    @NotNull
    public final GuildFeedDetailInteractiveEvent setBusinessType(int type) {
        this.businessType = type;
        return this;
    }

    @NotNull
    public final GuildFeedDetailInteractiveEvent setChannelExtensionInfo(@NotNull String channelExtensionInfo) {
        Intrinsics.checkNotNullParameter(channelExtensionInfo, "channelExtensionInfo");
        this.channelExtensionInfo = channelExtensionInfo;
        return this;
    }

    @NotNull
    public final GuildFeedDetailInteractiveEvent setInteractiveType(int interactiveType) {
        this.interactiveType = interactiveType;
        return this;
    }

    @NotNull
    public final GuildFeedDetailInteractiveEvent setSearchExtensionInfo(@NotNull String searchExtensionInfo) {
        Intrinsics.checkNotNullParameter(searchExtensionInfo, "searchExtensionInfo");
        this.searchExtensionInfo = searchExtensionInfo;
        return this;
    }

    @NotNull
    public String toString() {
        return "GuildFeedDetailInteractiveEvent(businessType=" + this.businessType + ", interactiveType=" + this.interactiveType + ", searchExtensionInfo='" + this.searchExtensionInfo + "', channelExtensionInfo='" + this.channelExtensionInfo + "')";
    }
}
