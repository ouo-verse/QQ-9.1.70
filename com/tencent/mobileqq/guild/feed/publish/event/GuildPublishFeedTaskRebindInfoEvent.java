package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.data.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/event/GuildPublishFeedTaskRebindInfoEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "mainTaskId", "Ljava/lang/String;", "getMainTaskId", "()Ljava/lang/String;", "", "isPersonalGuildToBeCreated", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setPersonalGuildToBeCreated", "(Ljava/lang/Boolean;)V", "Lcom/tencent/mobileqq/guild/data/r;", "contact", "Lcom/tencent/mobileqq/guild/data/r;", "getContact", "()Lcom/tencent/mobileqq/guild/data/r;", "setContact", "(Lcom/tencent/mobileqq/guild/data/r;)V", "", "businessType", "I", "getBusinessType", "()I", "setBusinessType", "(I)V", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildPublishFeedTaskRebindInfoEvent extends SimpleBaseEvent {
    private int businessType;

    @Nullable
    private r contact;

    @Nullable
    private Boolean isPersonalGuildToBeCreated;

    @NotNull
    private final String mainTaskId;

    public GuildPublishFeedTaskRebindInfoEvent(@NotNull String mainTaskId) {
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        this.mainTaskId = mainTaskId;
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    @Nullable
    public final r getContact() {
        return this.contact;
    }

    @NotNull
    public final String getMainTaskId() {
        return this.mainTaskId;
    }

    @Nullable
    /* renamed from: isPersonalGuildToBeCreated, reason: from getter */
    public final Boolean getIsPersonalGuildToBeCreated() {
        return this.isPersonalGuildToBeCreated;
    }

    public final void setBusinessType(int i3) {
        this.businessType = i3;
    }

    public final void setContact(@Nullable r rVar) {
        this.contact = rVar;
    }

    public final void setPersonalGuildToBeCreated(@Nullable Boolean bool) {
        this.isPersonalGuildToBeCreated = bool;
    }
}
