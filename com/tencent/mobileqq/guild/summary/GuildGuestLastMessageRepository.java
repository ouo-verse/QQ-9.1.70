package com.tencent.mobileqq.guild.summary;

import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/summary/GuildGuestLastMessageRepository;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/summary/a;", "c", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "Lkotlin/collections/ArrayList;", "msgAbstracts", "", "a", "", "b", "account", "onAccountChanged", "Ljava/util/concurrent/ConcurrentHashMap;", "e", "Lkotlin/Lazy;", "d", "()Ljava/util/concurrent/ConcurrentHashMap;", "channelLastMessageMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGuestLastMessageRepository implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildGuestLastMessageRepository f235190d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy channelLastMessageMap;

    static {
        Lazy lazy;
        GuildGuestLastMessageRepository guildGuestLastMessageRepository = new GuildGuestLastMessageRepository();
        f235190d = guildGuestLastMessageRepository;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, LastMessage>>() { // from class: com.tencent.mobileqq.guild.summary.GuildGuestLastMessageRepository$channelLastMessageMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConcurrentHashMap<String, LastMessage> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        channelLastMessageMap = lazy;
        AccountChangedNotifier.f214789d.a(guildGuestLastMessageRepository);
    }

    GuildGuestLastMessageRepository() {
    }

    private final ConcurrentHashMap<String, LastMessage> d() {
        return (ConcurrentHashMap) channelLastMessageMap.getValue();
    }

    @NotNull
    public final List<LastMessage> a(@NotNull ArrayList<LastMessage> msgAbstracts) {
        long j3;
        LastMessage a16;
        Object firstOrNull;
        String str;
        Intrinsics.checkNotNullParameter(msgAbstracts, "msgAbstracts");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) msgAbstracts);
            LastMessage lastMessage = (LastMessage) firstOrNull;
            if (lastMessage != null) {
                str = lastMessage.getGuildId();
            } else {
                str = null;
            }
            d16.d("GuildGuestSummaryRepository", 2, "addOrUpdateLastMessages: guildId = " + str + " size = " + msgAbstracts.size());
        }
        ArrayList arrayList = new ArrayList();
        for (LastMessage lastMessage2 : msgAbstracts) {
            GuildGuestLastMessageRepository guildGuestLastMessageRepository = f235190d;
            LastMessage lastMessage3 = guildGuestLastMessageRepository.d().get(lastMessage2.getChannelId());
            if (lastMessage3 != null) {
                j3 = lastMessage3.getTime();
            } else {
                j3 = 0;
            }
            if (j3 < lastMessage2.getTime() || (j3 == lastMessage2.getTime() && !Intrinsics.areEqual(guildGuestLastMessageRepository.d().get(lastMessage2.getChannelId()), lastMessage2))) {
                a16 = lastMessage2.a((r24 & 1) != 0 ? lastMessage2.guildId : null, (r24 & 2) != 0 ? lastMessage2.channelId : null, (r24 & 4) != 0 ? lastMessage2.type : 0, (r24 & 8) != 0 ? lastMessage2.subType : null, (r24 & 16) != 0 ? lastMessage2.senderUin : null, (r24 & 32) != 0 ? lastMessage2.senderNickname : null, (r24 & 64) != 0 ? lastMessage2.content : null, (r24 & 128) != 0 ? lastMessage2.sendState : null, (r24 & 256) != 0 ? lastMessage2.time : 0L, (r24 & 512) != 0 ? lastMessage2.customData : null);
                guildGuestLastMessageRepository.d().put(lastMessage2.getChannelId(), a16);
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    public final void b() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildGuestSummaryRepository", 2, QCircleLpReportDc05507.KEY_CLEAR);
        }
        d().clear();
    }

    @NotNull
    public final GuildSummaryData c(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildGuestSummaryRepository", 2, "get channelId: " + channelId);
        }
        return new GuildSummaryData(guildId, channelId, d().get(channelId), null, null);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        b();
    }
}
