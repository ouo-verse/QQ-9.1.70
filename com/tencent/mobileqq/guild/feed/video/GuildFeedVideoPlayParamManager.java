package com.tencent.mobileqq.guild.feed.video;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.discovery.common.model.GuildMineRefreshEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSetVideoCurrentTimeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSetVideoMuteStatusEvent;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0005\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\n\u001a\u00020\u0003J\u0018\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\fJ\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0014`\u0015H\u0016R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/video/GuildFeedVideoPlayParamManager;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "e", "f", "", "key", "", "d", "c", "playOffset", "", tl.h.F, "isMute", "g", "a", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "videoPlayOffsetMap", "Z", "videoPlayMuteStatus", "Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "kingCardManager", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedVideoPlayParamManager implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildFeedVideoPlayParamManager f223979d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Integer> videoPlayOffsetMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean videoPlayMuteStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy kingCardManager;

    static {
        Lazy lazy;
        GuildFeedVideoPlayParamManager guildFeedVideoPlayParamManager = new GuildFeedVideoPlayParamManager();
        f223979d = guildFeedVideoPlayParamManager;
        videoPlayOffsetMap = new ConcurrentHashMap<>();
        videoPlayMuteStatus = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IKingCardManager>() { // from class: com.tencent.mobileqq.guild.feed.video.GuildFeedVideoPlayParamManager$kingCardManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IKingCardManager invoke() {
                return ((IVasService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IVasService.class, "")).getKingCardManager();
            }
        });
        kingCardManager = lazy;
        SimpleEventBus.getInstance().registerReceiver(guildFeedVideoPlayParamManager);
    }

    GuildFeedVideoPlayParamManager() {
    }

    private final IKingCardManager b() {
        return (IKingCardManager) kingCardManager.getValue();
    }

    private final boolean e() {
        return b().isFreeFlow("GuildFeedVideoPlayParamManager");
    }

    public final void a() {
        QLog.d("GuildFeedVideoPlayParamManager", 2, "clearVideoPlayOffset");
        videoPlayOffsetMap.clear();
        videoPlayMuteStatus = true;
    }

    public final boolean c() {
        return videoPlayMuteStatus;
    }

    public final int d(@Nullable String key) {
        boolean z16;
        if (key != null && key.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("GuildFeedVideoPlayParamManager", 2, "getVideoPlayOffset| feedId is null");
            return 0;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = videoPlayOffsetMap;
        if (concurrentHashMap.get(key) != null) {
            QLog.d("GuildFeedVideoPlayParamManager", 1, "getVideoPlayOffset| value = " + concurrentHashMap.get(key));
            Integer num = concurrentHashMap.get(key);
            Intrinsics.checkNotNull(num);
            Intrinsics.checkNotNullExpressionValue(num, "{\n            QLog.d(TAG\u2026ffsetMap[key]!!\n        }");
            return num.intValue();
        }
        QLog.d("GuildFeedVideoPlayParamManager", 2, "getVideoPlayOffset| list is null, return 0");
        return 0;
    }

    public final boolean f() {
        if (!NetworkUtil.isWifiConnected(BaseApplication.getContext()) && !e()) {
            return false;
        }
        return true;
    }

    public final void g(boolean isMute) {
        QLog.d("GuildFeedVideoPlayParamManager", 2, "updateVideoMuteStatus| pageSource, isMute=" + isMute);
        videoPlayMuteStatus = isMute;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedSetVideoCurrentTimeEvent.class, GuildFeedSetVideoMuteStatusEvent.class, GuildMineRefreshEvent.class);
        return arrayListOf;
    }

    public final void h(@Nullable String key, int playOffset) {
        boolean z16;
        if (key != null && key.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && playOffset != 0) {
            videoPlayOffsetMap.put(key, Integer.valueOf(playOffset));
            return;
        }
        QLog.e("GuildFeedVideoPlayParamManager", 4, "updateVideoPlayOffset| fail for feedId=" + key + ", playOffset=" + playOffset);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildFeedSetVideoCurrentTimeEvent) {
            GuildFeedSetVideoCurrentTimeEvent guildFeedSetVideoCurrentTimeEvent = (GuildFeedSetVideoCurrentTimeEvent) event;
            h(guildFeedSetVideoCurrentTimeEvent.getVideoId(), guildFeedSetVideoCurrentTimeEvent.getCurrentTime());
        } else if (event instanceof GuildFeedSetVideoMuteStatusEvent) {
            g(((GuildFeedSetVideoMuteStatusEvent) event).getMuteStatus());
        } else if ((event instanceof GuildMineRefreshEvent) && ((GuildMineRefreshEvent) event).getRefreshing()) {
            g(true);
        }
    }
}
