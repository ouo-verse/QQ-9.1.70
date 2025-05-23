package com.tencent.mobileqq.guild.summary.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.message.draft.api.IGuildDraftService;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMessageService;
import com.tencent.mobileqq.guild.message.lastmsg.api.impl.GuildLastMsgAdapter;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.guild.summary.GuildGuestLastMessageRepository;
import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cy;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import yt1.DraftInfo;
import zt1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\b*\u0003(+.\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J(\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0012j\b\u0012\u0004\u0012\u00020\u0002`\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\tH\u0016R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00160$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl;", "Lcom/tencent/mobileqq/guild/summary/api/IGuildSummaryApi;", "", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/summary/a;", "getSummaryFromCache", "", "summaries", "", "onSummaryUpdate", "onGuestSummaryUpdate", "", "isDirect", "getSummary", "getGuestSummary", "batchFetchSummary", "clearGuestSummary", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "channelIds", "refreshGuestGuildSummary", "Lcom/tencent/mobileqq/guild/summary/d;", "callback", "registerGuestSummaryUpdateCallback", "unregisterGuestSummaryUpdateCallback", "removeSummary", "registerSummaryUpdateCallback", "unregisterSummaryUpdateCallback", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "summaryUpdateCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "guestSummaryUpdateCallbacks", "com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl$c", "lastMsgCallback", "Lcom/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl$c;", "com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl$e", "unreadInfoCallback", "Lcom/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl$e;", "com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl$b", "draftInfoCallback", "Lcom/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl$b;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSummaryApiImpl implements IGuildSummaryApi {

    @NotNull
    private static final String TAG = "Guild.GSC.GuildSummaryApiImpl";

    @NotNull
    private RuntimeServiceHolder serviceHolder = new RuntimeServiceHolder();

    @NotNull
    private CopyOnWriteArrayList<com.tencent.mobileqq.guild.summary.d> summaryUpdateCallbacks = new CopyOnWriteArrayList<>();

    @NotNull
    private CopyOnWriteArrayList<com.tencent.mobileqq.guild.summary.d> guestSummaryUpdateCallbacks = new CopyOnWriteArrayList<>();

    @NotNull
    private final c lastMsgCallback = new c();

    @NotNull
    private final e unreadInfoCallback = new e();

    @NotNull
    private final b draftInfoCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl$b", "Lzt1/a;", "Lyt1/a;", "draftInfo", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements a {
        b() {
        }

        @Override // zt1.a
        public void a(@NotNull DraftInfo draftInfo) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(draftInfo, "draftInfo");
            GuildSummaryApiImpl guildSummaryApiImpl = GuildSummaryApiImpl.this;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(guildSummaryApiImpl.getSummaryFromCache(draftInfo.getGuildId(), draftInfo.getChannelId()));
            guildSummaryApiImpl.onSummaryUpdate(arrayListOf);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl$c", "Lfu1/b;", "", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "lastMessages", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements fu1.b {
        c() {
        }

        @Override // fu1.b
        public void a(@NotNull List<LastMessage> lastMessages) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(lastMessages, "lastMessages");
            GuildSummaryApiImpl guildSummaryApiImpl = GuildSummaryApiImpl.this;
            List<LastMessage> list = lastMessages;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (LastMessage lastMessage : list) {
                arrayList.add(guildSummaryApiImpl.getSummaryFromCache(lastMessage.getGuildId(), lastMessage.getChannelId()));
            }
            guildSummaryApiImpl.onSummaryUpdate(arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl$d", "Lfu1/a;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "Lkotlin/collections/ArrayList;", "msgAbstracts", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements fu1.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f235203b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f235204c;

        d(String str, ArrayList<String> arrayList) {
            this.f235203b = str;
            this.f235204c = arrayList;
        }

        @Override // fu1.a
        public void onResult(int result, @NotNull String errMsg, @NotNull ArrayList<LastMessage> msgAbstracts) {
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(msgAbstracts, "msgAbstracts");
            TraceUtils traceUtils = TraceUtils.f235403a;
            GuildSummaryApiImpl guildSummaryApiImpl = GuildSummaryApiImpl.this;
            String str = this.f235203b;
            ArrayList<String> arrayList = this.f235204c;
            if (!TraceUtils.m()) {
                traceUtils.l();
                if (result != 0) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str2 = "fetchGuildSummary(" + str + ", " + arrayList + "):result = " + result + ", errMsg = " + errMsg + ")";
                    if (str2 instanceof String) {
                        bVar.a().add(str2);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e(GuildSummaryApiImpl.TAG, 1, (String) it.next(), null);
                    }
                }
                List<LastMessage> a16 = GuildGuestLastMessageRepository.f235190d.a(msgAbstracts);
                if (true ^ a16.isEmpty()) {
                    List<LastMessage> list = a16;
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                    for (LastMessage lastMessage : list) {
                        arrayList2.add(new GuildSummaryData(lastMessage.getGuildId(), lastMessage.getChannelId(), lastMessage, null, null));
                    }
                    guildSummaryApiImpl.onGuestSummaryUpdate(arrayList2);
                    return;
                }
                return;
            }
            try {
                cy.c("Guild.Misc.onLastMessageUpdate.#02");
                if (result != 0) {
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    String str3 = "fetchGuildSummary(" + str + ", " + arrayList + "):result = " + result + ", errMsg = " + errMsg + ")";
                    if (str3 instanceof String) {
                        bVar2.a().add(str3);
                    }
                    Iterator<T> it5 = bVar2.a().iterator();
                    while (it5.hasNext()) {
                        Logger.f235387a.d().e(GuildSummaryApiImpl.TAG, 1, (String) it5.next(), null);
                    }
                }
                List<LastMessage> a17 = GuildGuestLastMessageRepository.f235190d.a(msgAbstracts);
                if (true ^ a17.isEmpty()) {
                    List<LastMessage> list2 = a17;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                    for (LastMessage lastMessage2 : list2) {
                        arrayList3.add(new GuildSummaryData(lastMessage2.getGuildId(), lastMessage2.getChannelId(), lastMessage2, null, null));
                    }
                    guildSummaryApiImpl.onGuestSummaryUpdate(arrayList3);
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                cy.d();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/summary/api/impl/GuildSummaryApiImpl$e", "Lcom/tencent/mobileqq/guild/message/unread/api/b;", "", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "unreadInfos", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.message.unread.api.b {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.message.unread.api.b
        public void a(@NotNull List<UnreadInfo> unreadInfos) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(unreadInfos, "unreadInfos");
            GuildSummaryApiImpl guildSummaryApiImpl = GuildSummaryApiImpl.this;
            List<UnreadInfo> list = unreadInfos;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (UnreadInfo unreadInfo : list) {
                arrayList.add(guildSummaryApiImpl.getSummaryFromCache(unreadInfo.getGuildId(), unreadInfo.getChannelId()));
            }
            guildSummaryApiImpl.onSummaryUpdate(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildSummaryData getSummaryFromCache(String guildId, String channelId) {
        boolean z16;
        if (channelId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new GuildSummaryData(guildId, channelId, null, null, null);
        }
        return new GuildSummaryData(guildId, channelId, ((IGuildLastMessageService) this.serviceHolder.b("", IGuildLastMessageService.class)).getLastMessageFromCache(guildId, channelId), ((IGuildUnreadService) this.serviceHolder.b("", IGuildUnreadService.class)).getChannelUnreadInfoFromCache(guildId, channelId), ((IGuildDraftService) this.serviceHolder.b("", IGuildDraftService.class)).getDraftInfo(guildId, channelId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onGuestSummaryUpdate(List<GuildSummaryData> summaries) {
        Iterator<T> it = this.guestSummaryUpdateCallbacks.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.summary.d) it.next()).a(summaries);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSummaryUpdate(List<GuildSummaryData> summaries) {
        Iterator<T> it = this.summaryUpdateCallbacks.iterator();
        while (it.hasNext()) {
            try {
                ((com.tencent.mobileqq.guild.summary.d) it.next()).a(summaries);
            } catch (Exception e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "onSummaryUpdate exception " + e16;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it5 = bVar.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e(TAG, 1, (String) it5.next(), null);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi
    public void batchFetchSummary(@NotNull String guildId) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        List<IGProChannelInfo> channelList = ((IGPSService) ch.R0(IGPSService.class)).getChannelList(guildId);
        Intrinsics.checkNotNullExpressionValue(channelList, "runtimeService(IGPSServi\u2026).getChannelList(guildId)");
        if (channelList.isEmpty()) {
            return;
        }
        List<IGProChannelInfo> list = channelList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((IGProChannelInfo) it.next()).getChannelUin());
        }
        ((IGuildUnreadService) this.serviceHolder.b("", IGuildUnreadService.class)).batchFetchChannelUnreadInfo(guildId, arrayList);
        ((IGuildLastMessageService) this.serviceHolder.b("", IGuildLastMessageService.class)).batchFetchLastMessageInfo(guildId, arrayList);
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi
    public void clearGuestSummary() {
        GuildGuestLastMessageRepository.f235190d.b();
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi
    @NotNull
    public GuildSummaryData getGuestSummary(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return GuildGuestLastMessageRepository.f235190d.c(guildId, channelId);
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi
    @NotNull
    public GuildSummaryData getSummary(@NotNull String guildId, @NotNull String channelId, boolean isDirect) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (channelId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new GuildSummaryData(guildId, channelId, null, null, null);
        }
        return new GuildSummaryData(guildId, channelId, ((IGuildLastMessageService) this.serviceHolder.b("", IGuildLastMessageService.class)).getLastMessageInfo(guildId, channelId, isDirect), ((IGuildUnreadService) this.serviceHolder.b("", IGuildUnreadService.class)).getChannelUnreadInfo(guildId, channelId), ((IGuildDraftService) this.serviceHolder.b("", IGuildDraftService.class)).getDraftInfo(guildId, channelId));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        RuntimeServiceHolder runtimeServiceHolder = new RuntimeServiceHolder();
        this.serviceHolder = runtimeServiceHolder;
        ((IGuildUnreadService) runtimeServiceHolder.b("", IGuildUnreadService.class)).registerChannelUnreadCallback(this.unreadInfoCallback);
        ((IGuildLastMessageService) this.serviceHolder.b("", IGuildLastMessageService.class)).registerLastMessageCallback(this.lastMsgCallback);
        ((IGuildDraftService) this.serviceHolder.b("", IGuildDraftService.class)).registerChannelDraftCallback(this.draftInfoCallback);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        ((IGuildUnreadService) this.serviceHolder.b("", IGuildUnreadService.class)).unRegisterChannelUnreadCallback(this.unreadInfoCallback);
        ((IGuildLastMessageService) this.serviceHolder.b("", IGuildLastMessageService.class)).unRegisterLastMessageCallback(this.lastMsgCallback);
        ((IGuildDraftService) this.serviceHolder.b("", IGuildDraftService.class)).unRegisterChannelDraftCallback(this.draftInfoCallback);
        this.guestSummaryUpdateCallbacks.clear();
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi
    public void refreshGuestGuildSummary(@NotNull String guildId, @NotNull ArrayList<String> channelIds) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        if (channelIds.isEmpty()) {
            Logger.f235387a.d().i(TAG, 1, "fetchGuildSummary: channelIds is empty");
        }
        GuildLastMsgAdapter.f230618a.k(guildId, channelIds, new d(guildId, channelIds));
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi
    public void registerGuestSummaryUpdateCallback(@NotNull com.tencent.mobileqq.guild.summary.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.guestSummaryUpdateCallbacks.contains(callback)) {
            this.guestSummaryUpdateCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi
    public void registerSummaryUpdateCallback(@NotNull com.tencent.mobileqq.guild.summary.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.summaryUpdateCallbacks.contains(callback)) {
            Logger.f235387a.d().i(TAG, 1, "registerGuestSummaryUpdateCallback");
            this.summaryUpdateCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi
    public void removeSummary(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ((IGuildLastMessageService) this.serviceHolder.b("", IGuildLastMessageService.class)).removeLastMessageCache(guildId, channelId);
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi
    public void unregisterGuestSummaryUpdateCallback(@NotNull com.tencent.mobileqq.guild.summary.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.guestSummaryUpdateCallbacks.contains(callback)) {
            this.guestSummaryUpdateCallbacks.remove(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi
    public void unregisterSummaryUpdateCallback(@NotNull com.tencent.mobileqq.guild.summary.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.summaryUpdateCallbacks.contains(callback)) {
            Logger.f235387a.d().i(TAG, 1, "unregisterSummaryUpdateCallback");
            this.summaryUpdateCallbacks.remove(callback);
        }
    }
}
