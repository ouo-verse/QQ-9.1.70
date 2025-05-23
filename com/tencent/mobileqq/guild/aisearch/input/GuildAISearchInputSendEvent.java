package com.tencent.mobileqq.guild.aisearch.input;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.config.GuildAISearchModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputSendEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "component1", "Lcom/tencent/mobileqq/guild/config/d;", "component2", "searchText", "modelInfo", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getSearchText", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/guild/config/d;", "getModelInfo", "()Lcom/tencent/mobileqq/guild/config/d;", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/config/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class GuildAISearchInputSendEvent extends SimpleBaseEvent {

    @NotNull
    private final GuildAISearchModel modelInfo;

    @NotNull
    private final String searchText;

    public GuildAISearchInputSendEvent(@NotNull String searchText, @NotNull GuildAISearchModel modelInfo) {
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        Intrinsics.checkNotNullParameter(modelInfo, "modelInfo");
        this.searchText = searchText;
        this.modelInfo = modelInfo;
    }

    public static /* synthetic */ GuildAISearchInputSendEvent copy$default(GuildAISearchInputSendEvent guildAISearchInputSendEvent, String str, GuildAISearchModel guildAISearchModel, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildAISearchInputSendEvent.searchText;
        }
        if ((i3 & 2) != 0) {
            guildAISearchModel = guildAISearchInputSendEvent.modelInfo;
        }
        return guildAISearchInputSendEvent.copy(str, guildAISearchModel);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSearchText() {
        return this.searchText;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final GuildAISearchModel getModelInfo() {
        return this.modelInfo;
    }

    @NotNull
    public final GuildAISearchInputSendEvent copy(@NotNull String searchText, @NotNull GuildAISearchModel modelInfo) {
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        Intrinsics.checkNotNullParameter(modelInfo, "modelInfo");
        return new GuildAISearchInputSendEvent(searchText, modelInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildAISearchInputSendEvent)) {
            return false;
        }
        GuildAISearchInputSendEvent guildAISearchInputSendEvent = (GuildAISearchInputSendEvent) other;
        if (Intrinsics.areEqual(this.searchText, guildAISearchInputSendEvent.searchText) && Intrinsics.areEqual(this.modelInfo, guildAISearchInputSendEvent.modelInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final GuildAISearchModel getModelInfo() {
        return this.modelInfo;
    }

    @NotNull
    public final String getSearchText() {
        return this.searchText;
    }

    public int hashCode() {
        return (this.searchText.hashCode() * 31) + this.modelInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildAISearchInputSendEvent(searchText=" + this.searchText + ", modelInfo=" + this.modelInfo + ")";
    }
}
