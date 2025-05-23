package com.tencent.mobileqq.guild.homev2.misc.logics;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.heartbeatreport.impl.FacadeFragmentOnlineReportHelper;
import com.tencent.mobileqq.guild.home.utils.GuildFeedsHomeSubChannelPollingManager;
import com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager;
import com.tencent.mobileqq.guild.util.GuildSubscribePollingManager;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\t\u001a\u00020\b\"\f\b\u0000\u0010\u0004*\u00020\u0002*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ3\u0010\f\u001a\u00020\b\"\f\b\u0000\u0010\u0004*\u00020\u0002*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/logics/a;", "", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/mobileqq/guild/homev2/misc/d;", "T", "receiver", "", "pageId", "", "a", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;)V", "oldGuildId", "b", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f225907a = new a();

    a() {
    }

    public final <T extends LifecycleOwner & com.tencent.mobileqq.guild.homev2.misc.d> void a(@NotNull T receiver, @NotNull String pageId) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Logger.f235387a.d().i("GuildHomeLifecycleLogic", 1, "install pageId:" + pageId);
        GuildSubscribePollingManager.f235373a.a(receiver, pageId);
        GuildOpenRecordManager.f227480a.f(receiver, pageId);
        GuildFeedsHomeSubChannelPollingManager.f225330a.f(receiver, pageId);
        MiscKt.e(receiver, pageId);
        FacadeFragmentOnlineReportHelper.f224676a.f(receiver);
    }

    public final <T extends LifecycleOwner & com.tencent.mobileqq.guild.homev2.misc.d> void b(@NotNull T receiver, @NotNull String pageId, @NotNull String oldGuildId) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(oldGuildId, "oldGuildId");
        if (receiver.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            T t16 = receiver;
            Logger.f235387a.d().i("GuildHomeLifecycleLogic", 1, "notifyGuildIdChanged pageId:" + pageId + " oldGuildId:" + oldGuildId + " newGuildId:" + t16.getGuildId());
            GuildSubscribePollingManager.f235373a.b(receiver, pageId, oldGuildId, t16.getGuildId());
            GuildOpenRecordManager.f227480a.h(receiver, pageId, oldGuildId, t16.getGuildId());
            GuildFeedsHomeSubChannelPollingManager.f225330a.g(receiver, pageId, oldGuildId, t16.getGuildId());
            MiscKt.m(t16, oldGuildId, pageId);
            FacadeFragmentOnlineReportHelper.f224676a.g(receiver);
        }
    }
}
