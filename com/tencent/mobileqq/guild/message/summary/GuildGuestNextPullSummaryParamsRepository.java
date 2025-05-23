package com.tencent.mobileqq.guild.message.summary;

import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/message/summary/GuildGuestNextPullSummaryParamsRepository;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "channelId", "Lcom/tencent/mobileqq/guild/message/summary/a;", "nextPullMsgParams", "", "c", "a", "account", "onAccountChanged", "Ljava/util/concurrent/ConcurrentHashMap;", "e", "Lkotlin/Lazy;", "b", "()Ljava/util/concurrent/ConcurrentHashMap;", "channelNextPullMsgTimeMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGuestNextPullSummaryParamsRepository implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildGuestNextPullSummaryParamsRepository f230809d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy channelNextPullMsgTimeMap;

    static {
        Lazy lazy;
        GuildGuestNextPullSummaryParamsRepository guildGuestNextPullSummaryParamsRepository = new GuildGuestNextPullSummaryParamsRepository();
        f230809d = guildGuestNextPullSummaryParamsRepository;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, GuestNextPullSummaryMsgParams>>() { // from class: com.tencent.mobileqq.guild.message.summary.GuildGuestNextPullSummaryParamsRepository$channelNextPullMsgTimeMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConcurrentHashMap<String, GuestNextPullSummaryMsgParams> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        channelNextPullMsgTimeMap = lazy;
        AccountChangedNotifier.f214789d.a(guildGuestNextPullSummaryParamsRepository);
    }

    GuildGuestNextPullSummaryParamsRepository() {
    }

    private final ConcurrentHashMap<String, GuestNextPullSummaryMsgParams> b() {
        return (ConcurrentHashMap) channelNextPullMsgTimeMap.getValue();
    }

    public final void a() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuestChannelNextPullMsgTimeRepository", 2, QCircleLpReportDc05507.KEY_CLEAR);
        }
        b().clear();
    }

    public final void c(@NotNull String channelId, @NotNull GuestNextPullSummaryMsgParams nextPullMsgParams) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(nextPullMsgParams, "nextPullMsgParams");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuestChannelNextPullMsgTimeRepository", 2, "put channelId: " + channelId + ", nextPullMsgTime: " + nextPullMsgParams);
        }
        b().put(channelId, nextPullMsgParams);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        a();
    }
}
