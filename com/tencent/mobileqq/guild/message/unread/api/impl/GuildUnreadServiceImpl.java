package com.tencent.mobileqq.guild.message.unread.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.DataSource;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0002\u0002\u0005\u0018\u0000 N2\u00020\u0001:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001e\u0010\u0011\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001e\u0010\u0012\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001e\u0010\u0013\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001e\u0010\u0014\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J&\u0010&\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010%\u001a\u00020$H\u0016J\u001a\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0016J\u001a\u0010)\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0016J\u001e\u0010*\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0016J\u001a\u0010,\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020-2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u00020\nH\u0016R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u000209088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020<088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010;R \u0010?\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020>088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010;R \u0010A\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020@088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010;R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00150B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00190B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010DR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001f0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001c0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010DR\u0014\u0010H\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/api/impl/GuildUnreadServiceImpl;", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadService;", "com/tencent/mobileqq/guild/message/unread/api/impl/GuildUnreadServiceImpl$c", "createUnreadInfoCallback", "()Lcom/tencent/mobileqq/guild/message/unread/api/impl/GuildUnreadServiceImpl$c;", "com/tencent/mobileqq/guild/message/unread/api/impl/GuildUnreadServiceImpl$b", "createGpServiceObserver", "()Lcom/tencent/mobileqq/guild/message/unread/api/impl/GuildUnreadServiceImpl$b;", "", "guildId", "", "removeGuildAndChannelUnread", "", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "unreadInfos", "Lcom/tencent/mobileqq/guild/message/unread/api/DataSource;", "dataSource", "refreshAndNotifyChannelUnread", "refreshAndNotifyCategoryUnread", "refreshAndNotifyGuildUnread", "refreshAndNotifyGuildFeedsUnread", "Lcom/tencent/mobileqq/guild/message/unread/api/b;", "callback", "registerChannelUnreadCallback", "unRegisterChannelUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/a;", "registerCategoryUnreadCallback", "unRegisterCategoryUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/c;", "registerGuildFeedsUnreadCallback", "unRegisterGuildFeedUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/e;", "registerGuildUnreadCallback", "unRegisterGuildUnreadCallback", "setGuildRead", "channelIds", "", "isDirect", "setChannelRead", "channelId", "getChannelUnreadInfo", "getChannelUnreadInfoFromCache", "batchFetchChannelUnreadInfo", "categoryId", "getCategoryUnreadInfo", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "getGuildUnreadCount", "getGuildFeedsUnreadCount", "refreshGuildUnread", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lru1/b;", "channelUnreadProcesses", "Ljava/util/concurrent/ConcurrentHashMap;", "Lru1/a;", "categoryUnreadProcesses", "Lru1/d;", "guildUnreadProcesses", "Lru1/c;", "guildFeedsUnreadProcesses", "Ljava/util/concurrent/CopyOnWriteArrayList;", "channelUnreadCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "categoryUnreadCallbacks", "guildUnreadCallbacks", "guildFeedsUnreadCallbacks", "unreadInfoCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/impl/GuildUnreadServiceImpl$c;", "gpServiceObserver", "Lcom/tencent/mobileqq/guild/message/unread/api/impl/GuildUnreadServiceImpl$b;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildUnreadServiceImpl implements IGuildUnreadService {

    @NotNull
    private static final String TAG = "Guild.GSC.GuildUnreadServiceImpl";
    private RuntimeServiceHolder serviceHolder;

    @NotNull
    private final ConcurrentHashMap<String, ru1.b> channelUnreadProcesses = new ConcurrentHashMap<>();

    @NotNull
    private final ConcurrentHashMap<String, ru1.a> categoryUnreadProcesses = new ConcurrentHashMap<>();

    @NotNull
    private final ConcurrentHashMap<String, ru1.d> guildUnreadProcesses = new ConcurrentHashMap<>();

    @NotNull
    private final ConcurrentHashMap<String, ru1.c> guildFeedsUnreadProcesses = new ConcurrentHashMap<>();

    @NotNull
    private final CopyOnWriteArrayList<com.tencent.mobileqq.guild.message.unread.api.b> channelUnreadCallbacks = new CopyOnWriteArrayList<>();

    @NotNull
    private final CopyOnWriteArrayList<com.tencent.mobileqq.guild.message.unread.api.a> categoryUnreadCallbacks = new CopyOnWriteArrayList<>();

    @NotNull
    private final CopyOnWriteArrayList<com.tencent.mobileqq.guild.message.unread.api.e> guildUnreadCallbacks = new CopyOnWriteArrayList<>();

    @NotNull
    private final CopyOnWriteArrayList<com.tencent.mobileqq.guild.message.unread.api.c> guildFeedsUnreadCallbacks = new CopyOnWriteArrayList<>();

    @NotNull
    private final c unreadInfoCallback = createUnreadInfoCallback();

    @NotNull
    private final b gpServiceObserver = createGpServiceObserver();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/message/unread/api/impl/GuildUnreadServiceImpl$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onRemoveGuild", "", "black", "onBeKickFromGuild", "onDestoryGuild", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            GuildUnreadServiceImpl.this.removeGuildAndChannelUnread(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            GuildUnreadServiceImpl.this.removeGuildAndChannelUnread(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            GuildUnreadServiceImpl.this.removeGuildAndChannelUnread(guildId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/message/unread/api/impl/GuildUnreadServiceImpl$c", "Lcom/tencent/mobileqq/guild/message/unread/api/f;", "", "unreadCntUpType", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "Lkotlin/collections/ArrayList;", "unreadInfos", "Lcom/tencent/mobileqq/guild/message/unread/api/DataSource;", "dataSource", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.message.unread.api.f {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.message.unread.api.f
        public void a(int unreadCntUpType, @NotNull ArrayList<UnreadInfo> unreadInfos, @NotNull DataSource dataSource) {
            Intrinsics.checkNotNullParameter(unreadInfos, "unreadInfos");
            Intrinsics.checkNotNullParameter(dataSource, "dataSource");
            if (unreadCntUpType == 1) {
                GuildUnreadServiceImpl.this.refreshAndNotifyChannelUnread(unreadInfos, dataSource);
                return;
            }
            if (unreadCntUpType == 2) {
                GuildUnreadServiceImpl.this.refreshAndNotifyGuildUnread(unreadInfos, dataSource);
            } else if (unreadCntUpType == 5) {
                GuildUnreadServiceImpl.this.refreshAndNotifyCategoryUnread(unreadInfos, dataSource);
            } else if (unreadCntUpType == 6) {
                GuildUnreadServiceImpl.this.refreshAndNotifyGuildFeedsUnread(unreadInfos, dataSource);
            }
        }
    }

    private final b createGpServiceObserver() {
        return new b();
    }

    private final c createUnreadInfoCallback() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshAndNotifyCategoryUnread(List<UnreadInfo> unreadInfos, DataSource dataSource) {
        ArrayList arrayList = new ArrayList();
        for (UnreadInfo unreadInfo : unreadInfos) {
            if (this.categoryUnreadProcesses.containsKey(unreadInfo.getChannelId())) {
                ru1.a aVar = this.categoryUnreadProcesses.get(unreadInfo.getChannelId());
                Intrinsics.checkNotNull(aVar);
                if (aVar.b(unreadInfo)) {
                    arrayList.add(unreadInfo);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator<T> it = this.categoryUnreadCallbacks.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.message.unread.api.a) it.next()).a(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshAndNotifyChannelUnread(List<UnreadInfo> unreadInfos, DataSource dataSource) {
        ArrayList arrayList = new ArrayList();
        for (UnreadInfo unreadInfo : unreadInfos) {
            if (this.channelUnreadProcesses.containsKey(unreadInfo.getChannelId())) {
                ru1.b bVar = this.channelUnreadProcesses.get(unreadInfo.getChannelId());
                Intrinsics.checkNotNull(bVar);
                if (bVar.c(unreadInfo)) {
                    arrayList.add(unreadInfo);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator<T> it = this.channelUnreadCallbacks.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.message.unread.api.b) it.next()).a(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshAndNotifyGuildFeedsUnread(List<UnreadInfo> unreadInfos, DataSource dataSource) {
        ArrayList arrayList = new ArrayList();
        for (UnreadInfo unreadInfo : unreadInfos) {
            if (this.guildFeedsUnreadProcesses.containsKey(unreadInfo.getGuildId())) {
                ru1.c cVar = this.guildFeedsUnreadProcesses.get(unreadInfo.getGuildId());
                Intrinsics.checkNotNull(cVar);
                if (cVar.b(unreadInfo)) {
                    arrayList.add(new Pair(unreadInfo.getGuildId(), cVar.getUnreadCount()));
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Logger.f235387a.d().i(TAG, 1, "GuildFeedsUnread(" + dataSource + "): " + arrayList);
            Iterator<T> it = this.guildFeedsUnreadCallbacks.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.message.unread.api.c) it.next()).a(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshAndNotifyGuildUnread(List<UnreadInfo> unreadInfos, DataSource dataSource) {
        ArrayList arrayList = new ArrayList();
        for (UnreadInfo unreadInfo : unreadInfos) {
            if (!this.guildUnreadProcesses.containsKey(unreadInfo.getGuildId())) {
                this.guildUnreadProcesses.put(unreadInfo.getGuildId(), new ru1.d(unreadInfo.getGuildId()));
            }
            ru1.d dVar = this.guildUnreadProcesses.get(unreadInfo.getGuildId());
            Intrinsics.checkNotNull(dVar);
            if (dVar.b(unreadInfo)) {
                arrayList.add(new Pair(unreadInfo.getGuildId(), dVar.getUnreadCount()));
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator<T> it = this.guildUnreadCallbacks.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.message.unread.api.e) it.next()).a(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeGuildAndChannelUnread(String guildId) {
        boolean z16;
        if (guildId != null && guildId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Logger.f235387a.d().i(TAG, 1, "removeGuildAndChannelUnread guildId: " + guildId);
        synchronized (this.channelUnreadProcesses) {
            Iterator<Map.Entry<String, ru1.b>> it = this.channelUnreadProcesses.entrySet().iterator();
            while (it.hasNext()) {
                ru1.b value = it.next().getValue();
                Intrinsics.checkNotNullExpressionValue(value, "iterator.next().value");
                if (Intrinsics.areEqual(value.getGuildId(), guildId)) {
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.guildUnreadProcesses) {
            if (this.guildUnreadProcesses.containsKey(guildId)) {
                this.guildUnreadProcesses.remove(guildId);
            }
        }
        synchronized (this.guildFeedsUnreadProcesses) {
            if (this.guildFeedsUnreadProcesses.containsKey(guildId)) {
                this.guildFeedsUnreadProcesses.remove(guildId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setChannelRead$lambda$4(String guildId, String channelId, int i3, String str) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Logger.f235387a.d().i(TAG, 1, "setChannelRead(" + guildId + ", " + channelId + "): result = " + i3 + ", errMsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGuildRead$lambda$1(String guildId, int i3, String str) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Logger.f235387a.d().i(TAG, 1, "setGuildRead(" + guildId + "): result = " + i3 + ", errMsg = " + str);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void batchFetchChannelUnreadInfo(@NotNull String guildId, @NotNull List<String> channelIds) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        ArrayList arrayList = new ArrayList();
        synchronized (this.channelUnreadProcesses) {
            for (String str : channelIds) {
                if (!this.channelUnreadProcesses.containsKey(str)) {
                    this.channelUnreadProcesses.put(str, new ru1.b(guildId, str));
                    arrayList.add(str);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (!arrayList.isEmpty()) {
            GuildUnreadCntMsgAdapter.f230860a.h(guildId, arrayList);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    @Nullable
    public UnreadInfo getCategoryUnreadInfo(@NotNull String guildId, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        if (!this.categoryUnreadProcesses.containsKey(categoryId)) {
            ru1.a aVar = new ru1.a(guildId, categoryId);
            aVar.c();
            synchronized (this.categoryUnreadProcesses) {
                if (!this.categoryUnreadProcesses.containsKey(categoryId)) {
                    this.categoryUnreadProcesses.put(categoryId, aVar);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        ru1.a aVar2 = this.categoryUnreadProcesses.get(categoryId);
        Intrinsics.checkNotNull(aVar2);
        return aVar2.getUnreadInfo();
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    @Nullable
    public UnreadInfo getChannelUnreadInfo(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (!this.channelUnreadProcesses.containsKey(channelId)) {
            ru1.b bVar = new ru1.b(guildId, channelId);
            bVar.d();
            synchronized (this.channelUnreadProcesses) {
                if (!this.channelUnreadProcesses.containsKey(channelId)) {
                    this.channelUnreadProcesses.put(channelId, bVar);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        ru1.b bVar2 = this.channelUnreadProcesses.get(channelId);
        Intrinsics.checkNotNull(bVar2);
        return bVar2.getUnreadInfo();
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    @Nullable
    public UnreadInfo getChannelUnreadInfoFromCache(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ru1.b bVar = this.channelUnreadProcesses.get(channelId);
        if (bVar != null) {
            return bVar.getUnreadInfo();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    @NotNull
    public UnreadInfo.a getGuildFeedsUnreadCount(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (!this.guildFeedsUnreadProcesses.containsKey(guildId)) {
            ru1.c cVar = new ru1.c(guildId);
            cVar.c();
            synchronized (this.guildFeedsUnreadProcesses) {
                if (!this.guildFeedsUnreadProcesses.containsKey(guildId)) {
                    this.guildFeedsUnreadProcesses.put(guildId, cVar);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        Logger.a d16 = Logger.f235387a.d();
        Object obj = this.guildFeedsUnreadProcesses.get(guildId);
        Intrinsics.checkNotNull(obj);
        d16.i(TAG, 1, "getUnReadCntByFeedsGuildId guildId:" + guildId + ", " + ((ru1.c) obj).getUnreadCount());
        ru1.c cVar2 = this.guildFeedsUnreadProcesses.get(guildId);
        Intrinsics.checkNotNull(cVar2);
        return cVar2.getUnreadCount();
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    @NotNull
    public UnreadInfo.a getGuildUnreadCount(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (!this.guildUnreadProcesses.containsKey(guildId)) {
            ru1.d dVar = new ru1.d(guildId);
            dVar.c();
            synchronized (this.guildUnreadProcesses) {
                if (!this.guildUnreadProcesses.containsKey(guildId)) {
                    this.guildUnreadProcesses.put(guildId, dVar);
                }
                Unit unit = Unit.INSTANCE;
            }
            Logger.a d16 = Logger.f235387a.d();
            Object obj = this.guildUnreadProcesses.get(guildId);
            Intrinsics.checkNotNull(obj);
            d16.i(TAG, 1, "getGuildUnreadCount guildId:" + guildId + ", " + ((ru1.d) obj).getUnreadCount());
        }
        ru1.d dVar2 = this.guildUnreadProcesses.get(guildId);
        Intrinsics.checkNotNull(dVar2);
        return dVar2.getUnreadCount();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Logger.f235387a.d().i(TAG, 1, "onCreate");
        this.serviceHolder = new RuntimeServiceHolder();
        GuildUnreadCntMsgAdapter.f230860a.t(TAG, this.unreadInfoCallback);
        RuntimeServiceHolder runtimeServiceHolder = this.serviceHolder;
        if (runtimeServiceHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            runtimeServiceHolder = null;
        }
        ((IGProGlobalService) runtimeServiceHolder.b("", IGProGlobalService.class)).addObserver(this.gpServiceObserver);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        Logger.f235387a.d().i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        GuildUnreadCntMsgAdapter.f230860a.u(TAG);
        RuntimeServiceHolder runtimeServiceHolder = this.serviceHolder;
        if (runtimeServiceHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            runtimeServiceHolder = null;
        }
        ((IGProGlobalService) runtimeServiceHolder.b("", IGProGlobalService.class)).deleteObserver(this.gpServiceObserver);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void refreshGuildUnread(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Logger.f235387a.d().i(TAG, 1, "refreshGuildUnread guildId: " + guildId);
        GuildUnreadCntMsgAdapter.f230860a.r(guildId);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void registerCategoryUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.categoryUnreadCallbacks.contains(callback)) {
            this.categoryUnreadCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void registerChannelUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.channelUnreadCallbacks.contains(callback)) {
            this.channelUnreadCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void registerGuildFeedsUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.guildFeedsUnreadCallbacks.contains(callback)) {
            this.guildFeedsUnreadCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void registerGuildUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.guildUnreadCallbacks.contains(callback)) {
            this.guildUnreadCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void setChannelRead(@NotNull final String guildId, @NotNull List<String> channelIds, boolean isDirect) {
        int i3;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        if (isDirect) {
            i3 = 1;
        } else {
            i3 = 4;
        }
        List<String> list = channelIds;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new UnreadInfo(guildId, (String) it.next(), null, null, 0, 28, null));
        }
        refreshAndNotifyChannelUnread(arrayList, DataSource.SET_READ);
        for (final String str : channelIds) {
            uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
            if (gProGuildMsgService != null) {
                gProGuildMsgService.setGProMsgRead(new GProContact(i3, str, guildId), new IGuildOperateCallback() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.g
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                    public final void onResult(int i16, String str2) {
                        GuildUnreadServiceImpl.setChannelRead$lambda$4(guildId, str, i16, str2);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void setGuildRead(@NotNull final String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        RuntimeServiceHolder runtimeServiceHolder = this.serviceHolder;
        if (runtimeServiceHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            runtimeServiceHolder = null;
        }
        uh2.c gProGuildMsgService = ((IGProSession) runtimeServiceHolder.b("", IGProSession.class)).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.setGProGuildMsgRead(guildId, new IGuildOperateCallback() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.h
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    GuildUnreadServiceImpl.setGuildRead$lambda$1(guildId, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void unRegisterCategoryUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.categoryUnreadCallbacks.contains(callback)) {
            this.categoryUnreadCallbacks.remove(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void unRegisterChannelUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.channelUnreadCallbacks.contains(callback)) {
            this.channelUnreadCallbacks.remove(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void unRegisterGuildFeedUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.guildFeedsUnreadCallbacks.contains(callback)) {
            this.guildFeedsUnreadCallbacks.remove(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService
    public void unRegisterGuildUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.e callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.guildUnreadCallbacks.contains(callback)) {
            this.guildUnreadCallbacks.remove(callback);
        }
    }
}
