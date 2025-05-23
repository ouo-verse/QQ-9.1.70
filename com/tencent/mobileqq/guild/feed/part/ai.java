package com.tencent.mobileqq.guild.feed.part;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0002\"\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/GuildFeedListContainer;", "", "c", "b", "Lrr1/a;", "a", "Lrr1/a;", "gestureListener", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ai {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private static rr1.a f222503a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/part/ai$a", "Lrr1/a;", "Lrr1/i;", "notifyData", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends rr1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildFeedListContainer f222504a;

        a(GuildFeedListContainer guildFeedListContainer) {
            this.f222504a = guildFeedListContainer;
        }

        @Override // rr1.a
        public void c(@NotNull rr1.i notifyData) {
            Intrinsics.checkNotNullParameter(notifyData, "notifyData");
            if (notifyData.f() == 3) {
                Logger.f235387a.d().d("GuildFeedListContainerKt", 1, "notifyLastUIState while anim end!");
                ai.b(this.f222504a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildFeedListContainer guildFeedListContainer) {
        if (f222503a == null) {
            return;
        }
        Logger.f235387a.d().d("GuildFeedListContainerKt", 1, "notifyLastUIState ");
        guildFeedListContainer.C.j().observe(guildFeedListContainer.getHostFragment(), guildFeedListContainer.F);
        com.tencent.mobileqq.guild.feed.util.u.c(f222503a);
        f222503a = null;
    }

    public static final void c(@NotNull GuildFeedListContainer guildFeedListContainer) {
        Intrinsics.checkNotNullParameter(guildFeedListContainer, "<this>");
        boolean isAioTranslationAnimRunning = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isAioTranslationAnimRunning();
        boolean isGuildTabSelected = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected();
        if ((guildFeedListContainer.getActivity() instanceof QBaseActivity) && isAioTranslationAnimRunning) {
            guildFeedListContainer.f222447i.S0(true);
            if (isGuildTabSelected) {
                a aVar = new a(guildFeedListContainer);
                f222503a = aVar;
                com.tencent.mobileqq.guild.feed.util.u.a(aVar);
            }
            guildFeedListContainer.C.j().removeObserver(guildFeedListContainer.F);
            guildFeedListContainer.la(true, guildFeedListContainer.H9(), false);
            return;
        }
        Logger.f235387a.d().d("GuildFeedListContainerKt", 1, "refreshOnActivityCreated stats invalid, isAioAnimRunning " + isAioTranslationAnimRunning + ", activity " + guildFeedListContainer.getActivity());
        guildFeedListContainer.la(true, guildFeedListContainer.H9(), false);
    }
}
