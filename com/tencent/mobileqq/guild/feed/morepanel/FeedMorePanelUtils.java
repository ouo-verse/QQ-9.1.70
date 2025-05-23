package com.tencent.mobileqq.guild.feed.morepanel;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils;
import com.tencent.mobileqq.guild.feed.morepanel.handler.GuildFeedMorePanelHandlerUtils;
import com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.share.v;
import com.tencent.mobileqq.guild.feed.share.y;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002J\u0012\u0010\n\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002J\"\u0010\u0011\u001a\u00020\u0010*\u00020\u00072\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000eJ\n\u0010\u0012\u001a\u00020\u0005*\u00020\rJ\n\u0010\u0013\u001a\u00020\u0005*\u00020\rJ\n\u0010\u0014\u001a\u00020\u0005*\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0010J\u0016\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0002R\u001b\u0010\"\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/FeedMorePanelUtils;", "", "", "guildId", "channelId", "", "d", "Lcom/tencent/mobileqq/sharepanel/f;", "actionId", "b", "a", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "c", "i", "j", "g", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "sharePanel", "e", "", "action", "k", "shareChannel", "l", "Lkotlin/Lazy;", "f", "()Z", "useNewFeedShareArk", "<init>", "()V", "ShareArkInfoInitTask", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedMorePanelUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FeedMorePanelUtils f220193a = new FeedMorePanelUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy useNewFeedShareArk;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/FeedMorePanelUtils$ShareArkInfoInitTask;", "Ljava/lang/Runnable;", "Lcom/tencent/mobileqq/guild/feed/usecases/GuildFeedArkShareInfo;", "e", "", TencentLocation.RUN_MODE, "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "d", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "panelContext", "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ShareArkInfoInitTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PanelContext<Activity, vk1.b> panelContext;

        public ShareArkInfoInitTask(@NotNull PanelContext<Activity, vk1.b> panelContext) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            this.panelContext = panelContext;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(final ShareArkInfoInitTask this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            final GuildFeedArkShareInfo e16 = this$0.e();
            if (e16 != null) {
                if (FeedMorePanelUtils.f220193a.f()) {
                    ShareFeedActionHandler.INSTANCE.i(this$0.panelContext, e16, "preLoad", new ShareFeedActionHandler.Companion.ReqHandleArgs(false, false, false, 3, null), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils$ShareArkInfoInitTask$run$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            PanelContext panelContext;
                            panelContext = FeedMorePanelUtils.ShareArkInfoInitTask.this.panelContext;
                            panelContext.getExtra().putParcelable("guild_feed_ark_share_info_preload", e16);
                        }
                    });
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            FeedMorePanelUtils.ShareArkInfoInitTask.g(FeedMorePanelUtils.ShareArkInfoInitTask.this, e16);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(ShareArkInfoInitTask this$0, GuildFeedArkShareInfo this_apply) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            this$0.panelContext.getExtra().putParcelable("guild_feed_ark_share_info_preload", this_apply);
        }

        @Nullable
        public final GuildFeedArkShareInfo e() {
            boolean z16;
            String i3 = this.panelContext.j().i();
            if (i3.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = null;
            }
            if (i3 == null) {
                return null;
            }
            GuildFeedArkShareInfo s16 = v.s(i3);
            y yVar = y.f223454a;
            vk1.b j3 = this.panelContext.j();
            Intrinsics.checkNotNullExpressionValue(s16, "this");
            yVar.a(j3, s16);
            return s16;
        }

        @Override // java.lang.Runnable
        public void run() {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.c
                @Override // java.lang.Runnable
                public final void run() {
                    FeedMorePanelUtils.ShareArkInfoInitTask.f(FeedMorePanelUtils.ShareArkInfoInitTask.this);
                }
            }, 16, null, false);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelUtils$useNewFeedShareArk$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106193", false));
            }
        });
        useNewFeedShareArk = lazy;
    }

    FeedMorePanelUtils() {
    }

    private final boolean d(String guildId, String channelId) {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService == null) {
            return false;
        }
        if (!iGPSService.getGuildPermission(guildId).a(30002) && !iGPSService.getChannelPermission(guildId, channelId).a(30002)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final com.tencent.mobileqq.sharepanel.f a(@NotNull com.tencent.mobileqq.sharepanel.f fVar, @NotNull String actionId) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        return fVar.c0(actionId, false);
    }

    @NotNull
    public final com.tencent.mobileqq.sharepanel.f b(@NotNull com.tencent.mobileqq.sharepanel.f fVar, @NotNull String actionId) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        return fVar.c0(actionId, true);
    }

    public final void c(@NotNull com.tencent.mobileqq.sharepanel.f fVar, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        boolean z16;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        FeedMorePanelBusiImpl.OperationListProvider.e eVar = (FeedMorePanelBusiImpl.OperationListProvider.e) panelContext.getApiRouter().b(FeedMorePanelBusiImpl.OperationListProvider.e.class);
        boolean z17 = true;
        if (eVar != null && eVar.a("")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "uppin_homepage";
        } else {
            str = "pin_to_homepage";
        }
        b(fVar, str);
        if (panelContext.j().K()) {
            FeedMorePanelBusiImpl.OperationListProvider.e eVar2 = (FeedMorePanelBusiImpl.OperationListProvider.e) panelContext.getApiRouter().b(FeedMorePanelBusiImpl.OperationListProvider.e.class);
            if (eVar2 == null || !eVar2.a(String.valueOf(panelContext.j().getChannelId()))) {
                z17 = false;
            }
            if (z17) {
                str2 = "uppin_section";
            } else {
                str2 = "pin_to_section";
            }
            b(fVar, str2);
        }
    }

    public final void e(@NotNull k launchParam, @NotNull com.tencent.mobileqq.sharepanel.f sharePanel) {
        CoroutineScope d16;
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        Intrinsics.checkNotNullParameter(sharePanel, "sharePanel");
        Logger.f235387a.d().i("FeedMorePanelUtils", 1, "delayShowQRCode");
        Object n3 = launchParam.e().j().n();
        if (n3 != null && (d16 = GuildFeedMorePanelHandlerUtils.f220288a.d(launchParam.e())) != null) {
            CorountineFunKt.e(d16, "FeedMorePanelUtils ", null, null, null, new FeedMorePanelUtils$delayShowQRCode$2(n3, launchParam, sharePanel, null), 14, null);
        }
    }

    public final boolean f() {
        return ((Boolean) useNewFeedShareArk.getValue()).booleanValue();
    }

    public final boolean g(@NotNull vk1.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        return d(String.valueOf(bVar.getGuildId()), String.valueOf(bVar.getChannelId()));
    }

    public final void h() {
        if (((com.tencent.mobileqq.guild.feed.morepanel.cooperate.k) jj1.b.c().getData("GuildFeedTempDataStore", "entry_local_feeds_top_by_self")) == null) {
            com.tencent.mobileqq.guild.feed.morepanel.cooperate.k kVar = new com.tencent.mobileqq.guild.feed.morepanel.cooperate.k();
            jj1.b.c().addData("GuildFeedTempDataStore", kVar);
            kVar.b();
        }
    }

    public final boolean i(@NotNull vk1.b bVar) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        String r16 = bVar.r();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        }
        return Intrinsics.areEqual(r16, str);
    }

    public final boolean j(@NotNull vk1.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        return ch.m0(String.valueOf(bVar.getGuildId()));
    }

    public final boolean k(int action) {
        if (action != 2 && action != 73 && action != 72 && action != 26 && action != 171) {
            return false;
        }
        return true;
    }

    public final boolean l(@NotNull String shareChannel) {
        Intrinsics.checkNotNullParameter(shareChannel, "shareChannel");
        if (!Intrinsics.areEqual(shareChannel, "qqfriend") && !Intrinsics.areEqual(shareChannel, "qqchannel")) {
            return false;
        }
        return true;
    }
}
