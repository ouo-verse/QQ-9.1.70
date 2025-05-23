package com.tencent.mobileqq.guild.message.lastmsg.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMessageService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0002(+\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0019\u0010\f\u001a\u00020\u00042\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0082\bJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/message/lastmsg/api/impl/GuildLastMessageServiceImpl;", "Lcom/tencent/mobileqq/guild/message/lastmsg/api/IGuildLastMessageService;", "", "tinyId", "", "updateLastMessageWithTinyId", "", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "lastMessages", "onLastMessageUpdate", "Lkotlin/Function0;", "block", "executeOnWorkThread", "Lfu1/b;", "callback", "registerLastMessageCallback", "unRegisterLastMessageCallback", "guildId", "channelId", "removeLastMessageCache", "", "isDirect", "getLastMessageInfo", "getLastMessageFromCache", "channelIds", "batchFetchLastMessageInfo", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lgu1/a;", "lastMessageProcesses", "Ljava/util/concurrent/ConcurrentHashMap;", "", "lastMessageCallbacks", "Ljava/util/List;", "com/tencent/mobileqq/guild/message/lastmsg/api/impl/GuildLastMessageServiceImpl$b", "lastMsgCallback", "Lcom/tencent/mobileqq/guild/message/lastmsg/api/impl/GuildLastMessageServiceImpl$b;", "com/tencent/mobileqq/guild/message/lastmsg/api/impl/GuildLastMessageServiceImpl$c", "serviceObserver", "Lcom/tencent/mobileqq/guild/message/lastmsg/api/impl/GuildLastMessageServiceImpl$c;", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLastMessageServiceImpl implements IGuildLastMessageService {

    @NotNull
    private static final String TAG = "Guild.GSC.GuildLastMessageServiceImpl";
    private RuntimeServiceHolder serviceHolder;

    @NotNull
    private final ConcurrentHashMap<String, gu1.a> lastMessageProcesses = new ConcurrentHashMap<>();

    @NotNull
    private final List<fu1.b> lastMessageCallbacks = new ArrayList();

    @NotNull
    private final b lastMsgCallback = new b();

    @NotNull
    private final c serviceObserver = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/message/lastmsg/api/impl/GuildLastMessageServiceImpl$b", "Lfu1/a;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "Lkotlin/collections/ArrayList;", "msgAbstracts", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements fu1.a {
        b() {
        }

        @Override // fu1.a
        public void onResult(int result, @NotNull String errMsg, @NotNull ArrayList<LastMessage> msgAbstracts) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(msgAbstracts, "msgAbstracts");
            GuildLastMessageServiceImpl.this.onLastMessageUpdate(msgAbstracts);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/message/lastmsg/api/impl/GuildLastMessageServiceImpl$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "tinyId", "", "onUserDisplayNameUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            GuildLastMessageServiceImpl.this.updateLastMessageWithTinyId(tinyId);
        }
    }

    private final void executeOnWorkThread(final Function0<Unit> block) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.lastmsg.api.impl.GuildLastMessageServiceImpl$executeOnWorkThread$1
            @Override // java.lang.Runnable
            public final void run() {
                block.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLastMessageUpdate(List<LastMessage> lastMessages) {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        synchronized (this.lastMessageProcesses) {
            for (LastMessage lastMessage : lastMessages) {
                if (this.lastMessageProcesses.containsKey(lastMessage.getChannelId())) {
                    gu1.a aVar = this.lastMessageProcesses.get(lastMessage.getChannelId());
                    Intrinsics.checkNotNull(aVar);
                    if (aVar.d(lastMessage)) {
                        arrayList.add(lastMessage);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (!arrayList.isEmpty()) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                Logger.a d16 = logger.d();
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, new Function1<LastMessage, CharSequence>() { // from class: com.tencent.mobileqq.guild.message.lastmsg.api.impl.GuildLastMessageServiceImpl$onLastMessageUpdate$2$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(@NotNull LastMessage it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.l();
                    }
                }, 31, null);
                d16.d(TAG, 2, "LastMessage: " + joinToString$default);
            }
            Iterator<T> it = this.lastMessageCallbacks.iterator();
            while (it.hasNext()) {
                ((fu1.b) it.next()).a(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLastMessageWithTinyId(final String tinyId) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.lastmsg.api.impl.GuildLastMessageServiceImpl$updateLastMessageWithTinyId$$inlined$executeOnWorkThread$1
            @Override // java.lang.Runnable
            public final void run() {
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                concurrentHashMap = GuildLastMessageServiceImpl.this.lastMessageProcesses;
                synchronized (concurrentHashMap) {
                    concurrentHashMap2 = GuildLastMessageServiceImpl.this.lastMessageProcesses;
                    Collection values = concurrentHashMap2.values();
                    Intrinsics.checkNotNullExpressionValue(values, "lastMessageProcesses.values");
                    ArrayList<gu1.a> arrayList = new ArrayList();
                    for (Object obj : values) {
                        if (!((gu1.a) obj).getIsDirect()) {
                            arrayList.add(obj);
                        }
                    }
                    int i3 = 0;
                    for (gu1.a aVar : arrayList) {
                        LastMessage lastMessage = aVar.getLastMessage();
                        if (lastMessage != null && Intrinsics.areEqual(lastMessage.getSenderUin(), tinyId)) {
                            if (at.c()) {
                                String guildUserDisplayName = ((IGPSService) ch.R0(IGPSService.class)).getGuildUserDisplayName(lastMessage.getGuildId(), tinyId);
                                Intrinsics.checkNotNullExpressionValue(guildUserDisplayName, "runtimeService(IGPSServi\u2026tMessage.guildId, tinyId)");
                                if (Intrinsics.areEqual(guildUserDisplayName, lastMessage.getSenderNickname())) {
                                }
                            }
                            aVar.e();
                            i3++;
                        }
                    }
                    if (i3 > 0) {
                        Logger.f235387a.d().i("Guild.GSC.GuildLastMessageServiceImpl", 1, "updateLastMessageWithTinyId: " + tinyId + " - " + i3);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMessageService
    public void batchFetchLastMessageInfo(@NotNull String guildId, @NotNull List<String> channelIds) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (this.lastMessageProcesses) {
            for (String str : channelIds) {
                if (!this.lastMessageProcesses.containsKey(str)) {
                    this.lastMessageProcesses.put(str, new gu1.a(guildId, str, false));
                    arrayList.add(str);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (!arrayList.isEmpty()) {
            GuildLastMsgAdapter.f230618a.m(guildId, arrayList);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMessageService
    @Nullable
    public LastMessage getLastMessageFromCache(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        gu1.a aVar = this.lastMessageProcesses.get(channelId);
        if (aVar != null) {
            return aVar.getLastMessage();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMessageService
    @Nullable
    public LastMessage getLastMessageInfo(@NotNull String guildId, @NotNull String channelId, boolean isDirect) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (!this.lastMessageProcesses.containsKey(channelId)) {
            gu1.a aVar = new gu1.a(guildId, channelId, isDirect);
            aVar.e();
            synchronized (this.lastMessageProcesses) {
                if (!this.lastMessageProcesses.containsKey(channelId)) {
                    this.lastMessageProcesses.put(channelId, aVar);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        gu1.a aVar2 = this.lastMessageProcesses.get(channelId);
        if (aVar2 != null) {
            return aVar2.getLastMessage();
        }
        return null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.serviceHolder = new RuntimeServiceHolder();
        GuildLastMsgAdapter.f230618a.o(TAG, this.lastMsgCallback);
        RuntimeServiceHolder runtimeServiceHolder = this.serviceHolder;
        if (runtimeServiceHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            runtimeServiceHolder = null;
        }
        ((IGProGlobalService) runtimeServiceHolder.b("", IGProGlobalService.class)).addObserver(this.serviceObserver);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        GuildLastMsgAdapter.f230618a.p(TAG);
        RuntimeServiceHolder runtimeServiceHolder = this.serviceHolder;
        if (runtimeServiceHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            runtimeServiceHolder = null;
        }
        ((IGProGlobalService) runtimeServiceHolder.b("", IGProGlobalService.class)).deleteObserver(this.serviceObserver);
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMessageService
    public void registerLastMessageCallback(@NotNull fu1.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.lastMessageCallbacks.contains(callback)) {
            this.lastMessageCallbacks.add(callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMessageService
    public void removeLastMessageCache(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (this.lastMessageProcesses.containsKey(channelId)) {
            this.lastMessageProcesses.remove(channelId);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMessageService
    public void unRegisterLastMessageCallback(@NotNull fu1.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.lastMessageCallbacks.contains(callback)) {
            this.lastMessageCallbacks.remove(callback);
        }
    }
}
