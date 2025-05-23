package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.data.s;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/FeedEditorEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "(I)V", "getRequestId", "()I", "OnFeedEditorClosedEvent", "OnStartPublishFeedEvent", "Lcom/tencent/mobileqq/guild/feed/event/FeedEditorEvent$OnFeedEditorClosedEvent;", "Lcom/tencent/mobileqq/guild/feed/event/FeedEditorEvent$OnStartPublishFeedEvent;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public abstract class FeedEditorEvent extends SimpleBaseEvent {
    private final int requestId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/FeedEditorEvent$OnFeedEditorClosedEvent;", "Lcom/tencent/mobileqq/guild/feed/event/FeedEditorEvent;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "isTriggerPost", "", "(IZ)V", "()Z", "getRequestId", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class OnFeedEditorClosedEvent extends FeedEditorEvent {
        private final boolean isTriggerPost;
        private final int requestId;

        public OnFeedEditorClosedEvent(int i3, boolean z16) {
            super(i3, null);
            this.requestId = i3;
            this.isTriggerPost = z16;
        }

        public static /* synthetic */ OnFeedEditorClosedEvent copy$default(OnFeedEditorClosedEvent onFeedEditorClosedEvent, int i3, boolean z16, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = onFeedEditorClosedEvent.getRequestId();
            }
            if ((i16 & 2) != 0) {
                z16 = onFeedEditorClosedEvent.isTriggerPost;
            }
            return onFeedEditorClosedEvent.copy(i3, z16);
        }

        public final int component1() {
            return getRequestId();
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsTriggerPost() {
            return this.isTriggerPost;
        }

        @NotNull
        public final OnFeedEditorClosedEvent copy(int requestId, boolean isTriggerPost) {
            return new OnFeedEditorClosedEvent(requestId, isTriggerPost);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnFeedEditorClosedEvent)) {
                return false;
            }
            OnFeedEditorClosedEvent onFeedEditorClosedEvent = (OnFeedEditorClosedEvent) other;
            if (getRequestId() == onFeedEditorClosedEvent.getRequestId() && this.isTriggerPost == onFeedEditorClosedEvent.isTriggerPost) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.event.FeedEditorEvent
        public int getRequestId() {
            return this.requestId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int requestId = getRequestId() * 31;
            boolean z16 = this.isTriggerPost;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return requestId + i3;
        }

        public final boolean isTriggerPost() {
            return this.isTriggerPost;
        }

        @NotNull
        public String toString() {
            return "OnFeedEditorClosedEvent(requestId=" + getRequestId() + ", isTriggerPost=" + this.isTriggerPost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\n\u001a\u00020\u0006H\u00c6\u0003J;\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u0011\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\u001a\u0010\u000b\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\r\u0010\u001dR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u000f\u0010\u001dR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/FeedEditorEvent$OnStartPublishFeedEvent;", "Lcom/tencent/mobileqq/guild/feed/event/FeedEditorEvent;", "", "component1", "", "component2", "", "component3", "Lcom/tencent/mobileqq/guild/data/s;", "component4", "component5", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "mainTaskId", "isEdition", "contact", "isBeyondGuild", "copy", "toString", "hashCode", "", "other", "equals", "I", "getRequestId", "()I", "Ljava/lang/String;", "getMainTaskId", "()Ljava/lang/String;", "Z", "()Z", "Lcom/tencent/mobileqq/guild/data/s;", "getContact", "()Lcom/tencent/mobileqq/guild/data/s;", "", "", "topicIds", "Ljava/util/Collection;", "getTopicIds", "()Ljava/util/Collection;", "setTopicIds", "(Ljava/util/Collection;)V", "<init>", "(ILjava/lang/String;ZLcom/tencent/mobileqq/guild/data/s;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class OnStartPublishFeedEvent extends FeedEditorEvent {

        @NotNull
        private final s contact;
        private final boolean isBeyondGuild;
        private final boolean isEdition;

        @NotNull
        private final String mainTaskId;
        private final int requestId;

        @NotNull
        private Collection<Long> topicIds;

        public /* synthetic */ OnStartPublishFeedEvent(int i3, String str, boolean z16, s sVar, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, z16, sVar, (i16 & 16) != 0 ? false : z17);
        }

        public static /* synthetic */ OnStartPublishFeedEvent copy$default(OnStartPublishFeedEvent onStartPublishFeedEvent, int i3, String str, boolean z16, s sVar, boolean z17, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = onStartPublishFeedEvent.getRequestId();
            }
            if ((i16 & 2) != 0) {
                str = onStartPublishFeedEvent.mainTaskId;
            }
            String str2 = str;
            if ((i16 & 4) != 0) {
                z16 = onStartPublishFeedEvent.isEdition;
            }
            boolean z18 = z16;
            if ((i16 & 8) != 0) {
                sVar = onStartPublishFeedEvent.contact;
            }
            s sVar2 = sVar;
            if ((i16 & 16) != 0) {
                z17 = onStartPublishFeedEvent.isBeyondGuild;
            }
            return onStartPublishFeedEvent.copy(i3, str2, z18, sVar2, z17);
        }

        public final int component1() {
            return getRequestId();
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getMainTaskId() {
            return this.mainTaskId;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsEdition() {
            return this.isEdition;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final s getContact() {
            return this.contact;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsBeyondGuild() {
            return this.isBeyondGuild;
        }

        @NotNull
        public final OnStartPublishFeedEvent copy(int requestId, @NotNull String mainTaskId, boolean isEdition, @NotNull s contact, boolean isBeyondGuild) {
            Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
            Intrinsics.checkNotNullParameter(contact, "contact");
            return new OnStartPublishFeedEvent(requestId, mainTaskId, isEdition, contact, isBeyondGuild);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnStartPublishFeedEvent)) {
                return false;
            }
            OnStartPublishFeedEvent onStartPublishFeedEvent = (OnStartPublishFeedEvent) other;
            if (getRequestId() == onStartPublishFeedEvent.getRequestId() && Intrinsics.areEqual(this.mainTaskId, onStartPublishFeedEvent.mainTaskId) && this.isEdition == onStartPublishFeedEvent.isEdition && Intrinsics.areEqual(this.contact, onStartPublishFeedEvent.contact) && this.isBeyondGuild == onStartPublishFeedEvent.isBeyondGuild) {
                return true;
            }
            return false;
        }

        @NotNull
        public final s getContact() {
            return this.contact;
        }

        @NotNull
        public final String getMainTaskId() {
            return this.mainTaskId;
        }

        @Override // com.tencent.mobileqq.guild.feed.event.FeedEditorEvent
        public int getRequestId() {
            return this.requestId;
        }

        @NotNull
        public final Collection<Long> getTopicIds() {
            return this.topicIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int requestId = ((getRequestId() * 31) + this.mainTaskId.hashCode()) * 31;
            boolean z16 = this.isEdition;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int hashCode = (((requestId + i16) * 31) + this.contact.hashCode()) * 31;
            boolean z17 = this.isBeyondGuild;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return hashCode + i3;
        }

        public final boolean isBeyondGuild() {
            return this.isBeyondGuild;
        }

        public final boolean isEdition() {
            return this.isEdition;
        }

        public final void setTopicIds(@NotNull Collection<Long> collection) {
            Intrinsics.checkNotNullParameter(collection, "<set-?>");
            this.topicIds = collection;
        }

        @NotNull
        public String toString() {
            return "OnStartPublishFeedEvent(requestId=" + getRequestId() + ", mainTaskId=" + this.mainTaskId + ", isEdition=" + this.isEdition + ", contact=" + this.contact + ", isBeyondGuild=" + this.isBeyondGuild + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnStartPublishFeedEvent(int i3, @NotNull String mainTaskId, boolean z16, @NotNull s contact, boolean z17) {
            super(i3, null);
            Set emptySet;
            Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
            Intrinsics.checkNotNullParameter(contact, "contact");
            this.requestId = i3;
            this.mainTaskId = mainTaskId;
            this.isEdition = z16;
            this.contact = contact;
            this.isBeyondGuild = z17;
            emptySet = SetsKt__SetsKt.emptySet();
            this.topicIds = emptySet;
        }
    }

    public /* synthetic */ FeedEditorEvent(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }

    public int getRequestId() {
        return this.requestId;
    }

    FeedEditorEvent(int i3) {
        this.requestId = i3;
    }
}
