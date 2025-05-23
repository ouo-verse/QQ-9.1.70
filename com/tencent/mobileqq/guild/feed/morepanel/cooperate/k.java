package com.tencent.mobileqq.guild.feed.morepanel.cooperate;

import androidx.collection.ArrayMap;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailTopUpdateEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b$\u0010%J\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0004\u0018\u0001`\t2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0012`\u0013H\u0016J\u0006\u0010\u0015\u001a\u00020\fR\u0099\u0001\u0010\u001a\u001a\u0086\u0001\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004\u0012.\u0012,\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b \u0017*\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0004\u0018\u0001`\t0\u0006j\u0002`\t \u0017*B\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00040\u0004\u0012.\u0012,\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b \u0017*\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0004\u0018\u0001`\t0\u0006j\u0002`\t\u0018\u00010\u00180\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/k;", "Lcom/tencent/mobileqq/guild/feed/data/datacenter/datastore/GuildFeedTempDataStore$b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedDetailTopUpdateEvent;", "", "recordId", "Lkotlin/Pair;", "", "", "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/LocalTopRecord;", "d", "feedId", "", "c", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "b", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Map;", "localTopFeedRecords", "e", "Z", "hasHookUpdateEvent", "getKey", "()Ljava/lang/String;", "key", "a", "()Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/k;", "value", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k implements GuildFeedTempDataStore.b<k>, SimpleEventReceiver<GuildFeedDetailTopUpdateEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Pair<Long, Boolean>> localTopFeedRecords = Collections.synchronizedMap(new ArrayMap());

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasHookUpdateEvent;

    public final void b() {
        if (this.hasHookUpdateEvent) {
            return;
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        this.hasHookUpdateEvent = true;
    }

    public final void c(@NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.localTopFeedRecords.remove(feedId);
    }

    @Nullable
    public final Pair<Long, Boolean> d(@NotNull String recordId) {
        Intrinsics.checkNotNullParameter(recordId, "recordId");
        return this.localTopFeedRecords.get(recordId);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildFeedDetailTopUpdateEvent>> getEventClass() {
        ArrayList<Class<GuildFeedDetailTopUpdateEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedDetailTopUpdateEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore.b
    @NotNull
    public String getKey() {
        return "entry_local_feeds_top_by_self";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (!(event instanceof GuildFeedDetailTopUpdateEvent)) {
            return;
        }
        GuildFeedDetailTopUpdateEvent guildFeedDetailTopUpdateEvent = (GuildFeedDetailTopUpdateEvent) event;
        if (guildFeedDetailTopUpdateEvent.isSectionFeedTop()) {
            String str = guildFeedDetailTopUpdateEvent.getChannelId() + "_" + guildFeedDetailTopUpdateEvent.getFeedId();
            Map<String, Pair<Long, Boolean>> localTopFeedRecords = this.localTopFeedRecords;
            Intrinsics.checkNotNullExpressionValue(localTopFeedRecords, "localTopFeedRecords");
            localTopFeedRecords.put(str, TuplesKt.to(Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(guildFeedDetailTopUpdateEvent.getIsFeedSetTop())));
        }
        if (guildFeedDetailTopUpdateEvent.isFeedTop()) {
            Map<String, Pair<Long, Boolean>> localTopFeedRecords2 = this.localTopFeedRecords;
            Intrinsics.checkNotNullExpressionValue(localTopFeedRecords2, "localTopFeedRecords");
            localTopFeedRecords2.put(guildFeedDetailTopUpdateEvent.getFeedId(), TuplesKt.to(Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(guildFeedDetailTopUpdateEvent.getIsFeedSetTop())));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore.b
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k getValue() {
        return this;
    }
}
