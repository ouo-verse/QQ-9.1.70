package com.tencent.mobileqq.guild.feed.event;

import android.os.Looper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.util.bh;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProReportTarget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J\u001b\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tH\u00c6\u0003JM\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003J\u0006\u0010\u001b\u001a\u00020\u0007J\t\u0010\u001c\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\u00020\u00078F@\u0006X\u0087\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShareChannelEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "guildId", "", "channelId", "feedId", "destPlat", "", "uinMap", "", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShareChannelEvent$UinType;", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "shareType", "getShareType$annotations", "()V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getShareCount", "hashCode", "toString", "Companion", "UinType", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedShareChannelEvent extends SimpleBaseEvent {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public final String channelId;

    @JvmField
    public int destPlat;

    @JvmField
    @NotNull
    public final String feedId;

    @JvmField
    @NotNull
    public final String guildId;

    @JvmField
    public int shareType;

    @JvmField
    @NotNull
    public final Map<UinType, List<Long>> uinMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u001c\u0010\u0012\u001a\u00020\u0011*\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rJ\"\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\r*\b\u0012\u0004\u0012\u00020\u00130\u000fR\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShareChannelEvent$Companion;", "", "", "actionId", "d", "", "shareChannelId", "e", "fromTag", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShareChannelEvent;", "event", "", "a", "", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShareChannelEvent$UinType;", "", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProReportTarget;", "c", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull final String fromTag, @NotNull final GuildFeedShareChannelEvent event) {
            Intrinsics.checkNotNullParameter(fromTag, "fromTag");
            Intrinsics.checkNotNullParameter(event, "event");
            ThreadUtils threadUtils = ThreadUtils.f235400a;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                SimpleEventBus.getInstance().dispatchEvent(event);
                Logger.f235387a.d().i("GuildFeedShareChannelEvent", 1, "dispatchFeedShareChannelEventOut fromTag:" + fromTag + " event:" + event);
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.event.GuildFeedShareChannelEvent$Companion$dispatchFeedShareChannelEventOut$$inlined$ensureUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    SimpleEventBus.getInstance().dispatchEvent(GuildFeedShareChannelEvent.this);
                    Logger.f235387a.d().i("GuildFeedShareChannelEvent", 1, "dispatchFeedShareChannelEventOut fromTag:" + fromTag + " event:" + GuildFeedShareChannelEvent.this);
                }
            });
        }

        @NotNull
        public final Map<UinType, List<Long>> b(@NotNull List<? extends ResultRecord> list) {
            UinType uinType;
            Intrinsics.checkNotNullParameter(list, "<this>");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (ResultRecord resultRecord : list) {
                int i3 = resultRecord.uinType;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 10027) {
                            uinType = UinType.FRIEND;
                        } else {
                            uinType = UinType.GUILD;
                        }
                    } else {
                        uinType = UinType.TROOP;
                    }
                } else {
                    uinType = UinType.FRIEND;
                }
                Object obj = linkedHashMap.get(uinType);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(uinType, obj);
                }
                ((List) obj).add(Long.valueOf(bh.b(resultRecord.uin, 0L)));
            }
            return linkedHashMap;
        }

        @NotNull
        public final GProReportTarget c(@NotNull Map<UinType, ? extends List<Long>> map) {
            Intrinsics.checkNotNullParameter(map, "<this>");
            if (map.isEmpty()) {
                return new GProReportTarget();
            }
            GProReportTarget gProReportTarget = new GProReportTarget();
            List<Long> list = map.get(UinType.FRIEND);
            if (list != null) {
                gProReportTarget.uin = bg.f302144a.n(list);
            }
            List<Long> list2 = map.get(UinType.TROOP);
            if (list2 != null) {
                gProReportTarget.groupId = bg.f302144a.n(list2);
            }
            List<Long> list3 = map.get(UinType.GUILD);
            if (list3 != null) {
                gProReportTarget.guildId = bg.f302144a.n(list3);
            }
            return gProReportTarget;
        }

        public final int d(int actionId) {
            if (actionId != 2) {
                if (actionId == 3) {
                    return 3;
                }
                if (actionId != 9) {
                    if (actionId != 10) {
                        if (actionId != 26) {
                            if (actionId == 171) {
                                return 2;
                            }
                            if (actionId != 218) {
                                if (actionId != 72 && actionId != 73) {
                                    return 0;
                                }
                            } else {
                                return 6;
                            }
                        }
                    } else {
                        return 5;
                    }
                } else {
                    return 4;
                }
            }
            return 1;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0056 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int e(@NotNull String shareChannelId) {
            Intrinsics.checkNotNullParameter(shareChannelId, "shareChannelId");
            switch (shareChannelId.hashCode()) {
                case -791575966:
                    if (shareChannelId.equals("weixin")) {
                        return 4;
                    }
                    return 0;
                case -393543490:
                    if (shareChannelId.equals("qqfriend")) {
                        return 1;
                    }
                    break;
                case -304161157:
                    if (shareChannelId.equals("qzoneshuoshuo")) {
                        return 3;
                    }
                    break;
                case 154627506:
                    if (shareChannelId.equals("weixincircle")) {
                        return 5;
                    }
                    break;
                case 1083130618:
                    if (shareChannelId.equals("redbook")) {
                        return 6;
                    }
                    break;
                case 2024098531:
                    if (shareChannelId.equals("qqchannel")) {
                        return 2;
                    }
                    break;
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShareChannelEvent$UinType;", "", "(Ljava/lang/String;I)V", "FRIEND", "TROOP", "GUILD", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum UinType {
        FRIEND,
        TROOP,
        GUILD
    }

    public /* synthetic */ GuildFeedShareChannelEvent(String str, String str2, String str3, int i3, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i3, (i16 & 16) != 0 ? new HashMap() : map);
    }

    public static /* synthetic */ GuildFeedShareChannelEvent copy$default(GuildFeedShareChannelEvent guildFeedShareChannelEvent, String str, String str2, String str3, int i3, Map map, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = guildFeedShareChannelEvent.guildId;
        }
        if ((i16 & 2) != 0) {
            str2 = guildFeedShareChannelEvent.channelId;
        }
        String str4 = str2;
        if ((i16 & 4) != 0) {
            str3 = guildFeedShareChannelEvent.feedId;
        }
        String str5 = str3;
        if ((i16 & 8) != 0) {
            i3 = guildFeedShareChannelEvent.destPlat;
        }
        int i17 = i3;
        if ((i16 & 16) != 0) {
            map = guildFeedShareChannelEvent.uinMap;
        }
        return guildFeedShareChannelEvent.copy(str, str4, str5, i17, map);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDestPlat() {
        return this.destPlat;
    }

    @NotNull
    public final Map<UinType, List<Long>> component5() {
        return this.uinMap;
    }

    @NotNull
    public final GuildFeedShareChannelEvent copy(@NotNull String guildId, @NotNull String channelId, @NotNull String feedId, int destPlat, @NotNull Map<UinType, ? extends List<Long>> uinMap) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(uinMap, "uinMap");
        return new GuildFeedShareChannelEvent(guildId, channelId, feedId, destPlat, uinMap);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedShareChannelEvent)) {
            return false;
        }
        GuildFeedShareChannelEvent guildFeedShareChannelEvent = (GuildFeedShareChannelEvent) other;
        if (Intrinsics.areEqual(this.guildId, guildFeedShareChannelEvent.guildId) && Intrinsics.areEqual(this.channelId, guildFeedShareChannelEvent.channelId) && Intrinsics.areEqual(this.feedId, guildFeedShareChannelEvent.feedId) && this.destPlat == guildFeedShareChannelEvent.destPlat && Intrinsics.areEqual(this.uinMap, guildFeedShareChannelEvent.uinMap)) {
            return true;
        }
        return false;
    }

    public final int getShareCount() {
        if (this.uinMap.isEmpty()) {
            return 1;
        }
        Iterator<Map.Entry<UinType, List<Long>>> it = this.uinMap.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().getValue().size();
        }
        return i3;
    }

    public int hashCode() {
        return (((((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.feedId.hashCode()) * 31) + this.destPlat) * 31) + this.uinMap.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildFeedShareChannelEvent(guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ", destPlat=" + this.destPlat + ", uinMap=" + this.uinMap + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildFeedShareChannelEvent(@NotNull String guildId, @NotNull String channelId, @NotNull String feedId, int i3, @NotNull Map<UinType, ? extends List<Long>> uinMap) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(uinMap, "uinMap");
        this.guildId = guildId;
        this.channelId = channelId;
        this.feedId = feedId;
        this.destPlat = i3;
        this.uinMap = uinMap;
        this.shareType = 1;
    }

    public static /* synthetic */ void getShareType$annotations() {
    }
}
