package com.tencent.mobileqq.guild.summary.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.UiThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.api.IGuildUnreadEventApi;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.guild.message.unread.api.a;
import com.tencent.mobileqq.guild.nt.misc.api.IAppBadgeApi;
import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0004\u001a\u00020\u0003H\u0003J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020$0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#R,\u0010'\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120&0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010(\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010.R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\f0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010.R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010+R\u0014\u00109\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/summary/api/impl/GuildSummaryUnreadLimitServiceImpl;", "Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryUnreadLimitService;", "Landroid/os/Handler$Callback;", "", "delayCallback", "Lcom/tencent/mobileqq/guild/summary/d;", "callback", "registerSummaryUpdateCallback", "unregisterSummaryUpdateCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/a;", "registerCategoryUnreadCallback", "unRegisterCategoryUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/e;", "registerGuildUnreadCallback", "unRegisterGuildUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/d;", "registerGuildTabUnreadCallback", "unRegisterGuildTabUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "getGuildTabUnreadCount", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/os/Message;", "msg", "", "handleMessage", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/guild/summary/a;", "summaryCacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "categoryUnreadCacheMap", "Lkotlin/Pair;", "guildUnreadCacheMap", "hasGuildTabUnreadChanged", "Z", "guildTabUnreadCountCache", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "", "delaySummaryUpdateCallbacks", "Ljava/util/List;", "delayCategoryUnreadCallbacks", "delayGuildUnreadCallbacks", "delayGuildTabUnreadCallbacks", "", "lastNotifyTime", "J", "Lcom/tencent/util/WeakReferenceHandler;", "delayHandler", "Lcom/tencent/util/WeakReferenceHandler;", "lastGuildTabUnreadCount", "summaryUpdateCallback", "Lcom/tencent/mobileqq/guild/summary/d;", "categoryUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/a;", "guildUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/e;", "guildTabUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/d;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSummaryUnreadLimitServiceImpl implements IGuildSummaryUnreadLimitService, Handler.Callback {
    private static final long DELAY_TIMER = 500;
    private static final int MESSAGE_TYPE_NOTIFY = 100000;

    @NotNull
    private static final String TAG = "Guild.GSC.GuildSummaryUnreadLimitServiceImpl";
    private boolean hasGuildTabUnreadChanged;

    @Nullable
    private UnreadInfo.a lastGuildTabUnreadCount;
    private long lastNotifyTime;

    @NotNull
    private RuntimeServiceHolder serviceHolder = new RuntimeServiceHolder();

    @NotNull
    private final ConcurrentHashMap<String, GuildSummaryData> summaryCacheMap = new ConcurrentHashMap<>();

    @NotNull
    private final ConcurrentHashMap<String, UnreadInfo> categoryUnreadCacheMap = new ConcurrentHashMap<>();

    @NotNull
    private final ConcurrentHashMap<String, Pair<String, UnreadInfo.a>> guildUnreadCacheMap = new ConcurrentHashMap<>();

    @NotNull
    private UnreadInfo.a guildTabUnreadCountCache = new UnreadInfo.a(false, 0, 0, 7, null);

    @NotNull
    private final List<com.tencent.mobileqq.guild.summary.d> delaySummaryUpdateCallbacks = new ArrayList();

    @NotNull
    private final List<a> delayCategoryUnreadCallbacks = new ArrayList();

    @NotNull
    private final List<com.tencent.mobileqq.guild.message.unread.api.e> delayGuildUnreadCallbacks = new ArrayList();

    @NotNull
    private final List<com.tencent.mobileqq.guild.message.unread.api.d> delayGuildTabUnreadCallbacks = new ArrayList();

    @NotNull
    private final WeakReferenceHandler delayHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);

    @NotNull
    private final com.tencent.mobileqq.guild.summary.d summaryUpdateCallback = new e();

    @NotNull
    private final a categoryUnreadCallback = new b();

    @NotNull
    private final com.tencent.mobileqq.guild.message.unread.api.e guildUnreadCallback = new d();

    @NotNull
    private final com.tencent.mobileqq.guild.message.unread.api.d guildTabUnreadCallback = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryUnreadLimitServiceImpl$b", "Lcom/tencent/mobileqq/guild/message/unread/api/a;", "", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "unreadInfos", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.message.unread.api.a
        public void a(@NotNull List<UnreadInfo> unreadInfos) {
            Intrinsics.checkNotNullParameter(unreadInfos, "unreadInfos");
            if (unreadInfos.isEmpty()) {
                return;
            }
            GuildSummaryUnreadLimitServiceImpl guildSummaryUnreadLimitServiceImpl = GuildSummaryUnreadLimitServiceImpl.this;
            for (UnreadInfo unreadInfo : unreadInfos) {
                guildSummaryUnreadLimitServiceImpl.categoryUnreadCacheMap.put(unreadInfo.getChannelId(), unreadInfo);
            }
            GuildSummaryUnreadLimitServiceImpl.this.delayCallback();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryUnreadLimitServiceImpl$c", "Lcom/tencent/mobileqq/guild/message/unread/api/d;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "unreadCount", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.message.unread.api.d {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.message.unread.api.d
        public void a(@NotNull UnreadInfo.a unreadCount) {
            Intrinsics.checkNotNullParameter(unreadCount, "unreadCount");
            GuildSummaryUnreadLimitServiceImpl.this.guildTabUnreadCountCache = unreadCount;
            GuildSummaryUnreadLimitServiceImpl.this.hasGuildTabUnreadChanged = true;
            GuildSummaryUnreadLimitServiceImpl.this.delayCallback();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryUnreadLimitServiceImpl$d", "Lcom/tencent/mobileqq/guild/message/unread/api/e;", "", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "unreadCounts", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.message.unread.api.e {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.message.unread.api.e
        public void a(@NotNull List<Pair<String, UnreadInfo.a>> unreadCounts) {
            Intrinsics.checkNotNullParameter(unreadCounts, "unreadCounts");
            if (unreadCounts.isEmpty()) {
                return;
            }
            GuildSummaryUnreadLimitServiceImpl guildSummaryUnreadLimitServiceImpl = GuildSummaryUnreadLimitServiceImpl.this;
            Iterator<T> it = unreadCounts.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                guildSummaryUnreadLimitServiceImpl.guildUnreadCacheMap.put(pair.getFirst(), pair);
            }
            GuildSummaryUnreadLimitServiceImpl.this.delayCallback();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryUnreadLimitServiceImpl$e", "Lcom/tencent/mobileqq/guild/summary/d;", "", "Lcom/tencent/mobileqq/guild/summary/a;", "summaries", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.summary.d {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.summary.d
        public void a(@NotNull List<GuildSummaryData> summaries) {
            Intrinsics.checkNotNullParameter(summaries, "summaries");
            if (summaries.isEmpty()) {
                return;
            }
            GuildSummaryUnreadLimitServiceImpl guildSummaryUnreadLimitServiceImpl = GuildSummaryUnreadLimitServiceImpl.this;
            for (GuildSummaryData guildSummaryData : summaries) {
                guildSummaryUnreadLimitServiceImpl.summaryCacheMap.put(guildSummaryData.getChannelId(), guildSummaryData);
            }
            GuildSummaryUnreadLimitServiceImpl.this.delayCallback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void delayCallback() {
        if (this.delayHandler.hasMessages(100000)) {
            return;
        }
        long nanoTime = (System.nanoTime() / 1000000) - this.lastNotifyTime;
        if (nanoTime > 500) {
            this.delayHandler.sendEmptyMessage(100000);
        } else {
            this.delayHandler.sendEmptyMessageDelayed(100000, 500 - nanoTime);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService
    @NotNull
    public UnreadInfo.a getGuildTabUnreadCount() {
        return ((IGuildTotalUnreadService) this.serviceHolder.b("", IGuildTotalUnreadService.class)).getGuildTabUnreadCount();
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0149, code lost:
    
        if (r0 == false) goto L46;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(@NotNull Message msg2) {
        boolean z16;
        boolean z17;
        List<UnreadInfo> list;
        List<Pair<String, UnreadInfo.a>> list2;
        List<GuildSummaryData> list3;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what != 100000) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder("delayCallback ");
        if (!this.summaryCacheMap.isEmpty()) {
            for (com.tencent.mobileqq.guild.summary.d dVar : this.delaySummaryUpdateCallbacks) {
                Collection<GuildSummaryData> values = this.summaryCacheMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "summaryCacheMap.values");
                list3 = CollectionsKt___CollectionsKt.toList(values);
                dVar.a(list3);
            }
            sb5.append("summary size:");
            sb5.append(this.summaryCacheMap.size());
            this.summaryCacheMap.clear();
        }
        if (!this.guildUnreadCacheMap.isEmpty()) {
            for (com.tencent.mobileqq.guild.message.unread.api.e eVar : this.delayGuildUnreadCallbacks) {
                Collection<Pair<String, UnreadInfo.a>> values2 = this.guildUnreadCacheMap.values();
                Intrinsics.checkNotNullExpressionValue(values2, "guildUnreadCacheMap.values");
                list2 = CollectionsKt___CollectionsKt.toList(values2);
                eVar.a(list2);
            }
            sb5.append(", guildUnread size:");
            sb5.append(this.guildUnreadCacheMap.size());
            this.guildUnreadCacheMap.clear();
        }
        if (!this.categoryUnreadCacheMap.isEmpty()) {
            for (a aVar : this.delayCategoryUnreadCallbacks) {
                Collection<UnreadInfo> values3 = this.categoryUnreadCacheMap.values();
                Intrinsics.checkNotNullExpressionValue(values3, "categoryUnreadCacheMap.values");
                list = CollectionsKt___CollectionsKt.toList(values3);
                aVar.a(list);
            }
            sb5.append(", categoryUnread size:");
            sb5.append(this.guildUnreadCacheMap.size());
            this.categoryUnreadCacheMap.clear();
        }
        if (this.hasGuildTabUnreadChanged) {
            Iterator<T> it = this.delayGuildTabUnreadCallbacks.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.message.unread.api.d) it.next()).a(this.guildTabUnreadCountCache);
            }
            sb5.append(", guildTabUnread:");
            sb5.append(this.guildTabUnreadCountCache);
            ((IGuildUnreadEventApi) QRoute.api(IGuildUnreadEventApi.class)).notifyEvent();
            UnreadInfo.a aVar2 = this.lastGuildTabUnreadCount;
            if (aVar2 != null && aVar2.getIsStrongUnread() == this.guildTabUnreadCountCache.getIsStrongUnread()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                UnreadInfo.a aVar3 = this.lastGuildTabUnreadCount;
                if (aVar3 != null && aVar3.getCount() == this.guildTabUnreadCountCache.getCount()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            this.lastGuildTabUnreadCount = this.guildTabUnreadCountCache;
            ((IAppBadgeApi) QRoute.api(IAppBadgeApi.class)).refreshAppBadge(ch.l());
            this.hasGuildTabUnreadChanged = false;
        }
        this.lastNotifyTime = System.nanoTime() / 1000000;
        Logger.a d16 = Logger.f235387a.d();
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "callbackInfo.toString()");
        d16.d(TAG, 1, sb6);
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Logger.f235387a.d().i(TAG, 1, "onCreate");
        RuntimeServiceHolder runtimeServiceHolder = new RuntimeServiceHolder();
        this.serviceHolder = runtimeServiceHolder;
        ((IGuildSummaryApi) runtimeServiceHolder.b("", IGuildSummaryApi.class)).registerSummaryUpdateCallback(this.summaryUpdateCallback);
        ((IGuildUnreadService) this.serviceHolder.b("", IGuildUnreadService.class)).registerCategoryUnreadCallback(this.categoryUnreadCallback);
        ((IGuildUnreadService) this.serviceHolder.b("", IGuildUnreadService.class)).registerGuildUnreadCallback(this.guildUnreadCallback);
        ((IGuildTotalUnreadService) this.serviceHolder.b("", IGuildTotalUnreadService.class)).registerGuildTabUnreadCallback(this.guildTabUnreadCallback);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        Logger.f235387a.d().i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        if (this.delayHandler.hasMessages(100000)) {
            this.delayHandler.removeMessages(100000);
        }
        ((IGuildSummaryApi) this.serviceHolder.b("", IGuildSummaryApi.class)).unregisterSummaryUpdateCallback(this.summaryUpdateCallback);
        ((IGuildUnreadService) this.serviceHolder.b("", IGuildUnreadService.class)).unRegisterCategoryUnreadCallback(this.categoryUnreadCallback);
        ((IGuildUnreadService) this.serviceHolder.b("", IGuildUnreadService.class)).unRegisterGuildUnreadCallback(this.guildUnreadCallback);
        ((IGuildTotalUnreadService) this.serviceHolder.b("", IGuildTotalUnreadService.class)).unRegisterGuildTabUnreadCallback(this.guildTabUnreadCallback);
        this.delaySummaryUpdateCallbacks.clear();
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService
    public void registerCategoryUnreadCallback(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.delayCategoryUnreadCallbacks.contains(callback)) {
            this.delayCategoryUnreadCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService
    public void registerGuildTabUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.delayGuildTabUnreadCallbacks.contains(callback)) {
            this.delayGuildTabUnreadCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService
    public void registerGuildUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.delayGuildUnreadCallbacks.contains(callback)) {
            this.delayGuildUnreadCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService
    public void registerSummaryUpdateCallback(@NotNull com.tencent.mobileqq.guild.summary.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.delaySummaryUpdateCallbacks.contains(callback)) {
            this.delaySummaryUpdateCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService
    public void unRegisterCategoryUnreadCallback(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.delayCategoryUnreadCallbacks.contains(callback)) {
            this.delayCategoryUnreadCallbacks.remove(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService
    public void unRegisterGuildTabUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.delayGuildTabUnreadCallbacks.contains(callback)) {
            this.delayGuildTabUnreadCallbacks.remove(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService
    public void unRegisterGuildUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.delayGuildUnreadCallbacks.contains(callback)) {
            this.delayGuildUnreadCallbacks.remove(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryUnreadLimitService
    public void unregisterSummaryUpdateCallback(@NotNull com.tencent.mobileqq.guild.summary.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.delaySummaryUpdateCallbacks.contains(callback)) {
            this.delaySummaryUpdateCallbacks.remove(callback);
        }
    }
}
