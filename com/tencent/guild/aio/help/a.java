package com.tencent.guild.aio.help;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.help.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u0019\u0018\u0000 \u00042\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/guild/aio/help/a;", "Lcom/tencent/aio/main/businesshelper/h;", "", "g", "i", tl.h.F, "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "", "e", "Z", "mShowQuitDialog", "f", "mWaitToFinish", "com/tencent/guild/aio/help/a$b", "Lcom/tencent/guild/aio/help/a$b;", "gpServiceObserver", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mShowQuitDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mWaitToFinish;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b gpServiceObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u001e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0014J(\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0014J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J2\u0010\"\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0014J\u0010\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0014J\u001c\u0010'\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006("}, d2 = {"com/tencent/guild/aio/help/a$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "g", "channelId", "f", "l", "k", "Lcom/tencent/mobileqq/guild/util/IQQGuildUIUtilApi$QuitReason;", "quitReason", "", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", tl.h.F, "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "", "channelIds", "onPushChannelDestroy", "oldVisibleType", "newVisibleType", "onChannelVisibleChanged", "onChannelListUpdated", AppConstants.Key.COLUMN_IS_VALID, "isBanned", "isFrozen", "", "guildBannedTimeLimit", "onBannedStatusChanged", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "onSecurityResult", "tinyId", "onGuildUserAvatarUrlUpdate", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        private final boolean f(String channelId) {
            if (!TextUtils.isEmpty(channelId)) {
                com.tencent.aio.main.businesshelper.b bVar = a.this.param;
                com.tencent.aio.main.businesshelper.b bVar2 = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar = null;
                }
                AIOParam g16 = bVar.a().g();
                Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
                if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.b(g16), channelId)) {
                    if (l() && k()) {
                        QLog.i("GPServiceObserverHelper", 1, "destoryChatPieByChannel isInvalidState.");
                        a.this.mWaitToFinish = true;
                    } else {
                        IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
                        com.tencent.aio.main.businesshelper.b bVar3 = a.this.param;
                        if (bVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("param");
                            bVar3 = null;
                        }
                        FragmentActivity activity = bVar3.a().c().getActivity();
                        com.tencent.aio.main.businesshelper.b bVar4 = a.this.param;
                        if (bVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("param");
                            bVar4 = null;
                        }
                        int ordinal = com.tencent.guild.aio.util.ex.a.c(bVar4.a()).ordinal();
                        com.tencent.aio.main.businesshelper.b bVar5 = a.this.param;
                        if (bVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("param");
                        } else {
                            bVar2 = bVar5;
                        }
                        iGuildMainFrameApi.exitGuildChatFragment(activity, ordinal, bVar2.a().g().n());
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        private final boolean g(String guildId) {
            if (!TextUtils.isEmpty(guildId)) {
                com.tencent.aio.main.businesshelper.b bVar = a.this.param;
                com.tencent.aio.main.businesshelper.b bVar2 = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar = null;
                }
                AIOParam g16 = bVar.a().g();
                Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
                if (Intrinsics.areEqual(guildId, com.tencent.guild.aio.util.a.g(g16))) {
                    if (l() && k()) {
                        QLog.i("GPServiceObserverHelper", 1, "destoryChatPieByGuild isInvalidState.");
                        a.this.mWaitToFinish = true;
                    } else {
                        IGuildMainFrameApi iGuildMainFrameApi = (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
                        com.tencent.aio.main.businesshelper.b bVar3 = a.this.param;
                        if (bVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("param");
                            bVar3 = null;
                        }
                        FragmentActivity activity = bVar3.a().c().getActivity();
                        com.tencent.aio.main.businesshelper.b bVar4 = a.this.param;
                        if (bVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("param");
                            bVar4 = null;
                        }
                        int ordinal = com.tencent.guild.aio.util.ex.a.c(bVar4.a()).ordinal();
                        com.tencent.aio.main.businesshelper.b bVar5 = a.this.param;
                        if (bVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("param");
                        } else {
                            bVar2 = bVar5;
                        }
                        iGuildMainFrameApi.exitGuildChatFragment(activity, ordinal, bVar2.a().g().n());
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        private final Activity h() {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity == null) {
                return Foreground.getTopActivity();
            }
            return qBaseActivity;
        }

        private final boolean k() {
            FragmentManager supportFragmentManager;
            com.tencent.aio.main.businesshelper.b bVar = a.this.param;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            FragmentActivity activity = bVar.a().c().getActivity();
            if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null || !supportFragmentManager.isStateSaved()) {
                return false;
            }
            return true;
        }

        private final boolean l() {
            com.tencent.aio.main.businesshelper.b bVar = a.this.param;
            com.tencent.aio.main.businesshelper.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            if (bVar.a().c().getActivity() != null) {
                IQQGuildUIUtilApi iQQGuildUIUtilApi = (IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class);
                com.tencent.aio.main.businesshelper.b bVar3 = a.this.param;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                } else {
                    bVar2 = bVar3;
                }
                if (iQQGuildUIUtilApi.isInSplitViewMode(bVar2.a().c().requireActivity())) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(b this$0, a this$1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.n(IQQGuildUIUtilApi.QuitReason.VISIBILITY_CHANGE);
            com.tencent.aio.main.businesshelper.b bVar = this$1.param;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            AIOParam g16 = bVar.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
            this$0.f(com.tencent.guild.aio.util.a.b(g16));
        }

        private final void n(final IQQGuildUIUtilApi.QuitReason quitReason) {
            boolean z16;
            IGuildTempApi iGuildTempApi = (IGuildTempApi) QRoute.api(IGuildTempApi.class);
            com.tencent.aio.main.businesshelper.b bVar = a.this.param;
            com.tencent.aio.main.businesshelper.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            if (iGuildTempApi.isSplashActivity(bVar.a().c().getActivity())) {
                if (l()) {
                    if (k()) {
                        z16 = false;
                    }
                } else {
                    z16 = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isAioFullyOpen();
                }
                if (!z16 && !a.this.mShowQuitDialog) {
                    QLog.d("GPServiceObserverHelper", 1, "showQuitDialog quitReason " + quitReason);
                    a.this.mShowQuitDialog = true;
                    if (((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isSplashActivityTop()) {
                        com.tencent.aio.main.businesshelper.b bVar3 = a.this.param;
                        if (bVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("param");
                            bVar3 = null;
                        }
                        Context context = bVar3.a().c().getContext();
                        if (context != null) {
                            a aVar = a.this;
                            IQQGuildUIUtilApi iQQGuildUIUtilApi = (IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class);
                            com.tencent.aio.main.businesshelper.b bVar4 = aVar.param;
                            if (bVar4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("param");
                            } else {
                                bVar2 = bVar4;
                            }
                            iQQGuildUIUtilApi.showQuitAioDialog(context, bVar2.a().g().n(), quitReason);
                            return;
                        }
                        return;
                    }
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final a aVar2 = a.this;
                    uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.help.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.b.o(a.b.this, aVar2, quitReason);
                        }
                    }, 700L);
                    return;
                }
            }
            z16 = true;
            if (!z16) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(b this$0, a this$1, IQQGuildUIUtilApi.QuitReason quitReason) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(quitReason, "$quitReason");
            try {
                Activity h16 = this$0.h();
                if (h16 != null) {
                    IQQGuildUIUtilApi iQQGuildUIUtilApi = (IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class);
                    com.tencent.aio.main.businesshelper.b bVar = this$1.param;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("param");
                        bVar = null;
                    }
                    iQQGuildUIUtilApi.showQuitAioDialog(h16, bVar.a().g().n(), quitReason);
                }
            } catch (Exception e16) {
                QLog.i("GPServiceObserverHelper", 1, "showQuitDialog exception: " + e16.getMessage());
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onBannedStatusChanged(@Nullable String guildId, boolean isValid, boolean isBanned, boolean isFrozen, long guildBannedTimeLimit) {
            com.tencent.aio.main.businesshelper.b bVar = a.this.param;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            AIOParam g16 = bVar.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
            if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId) && isBanned) {
                g(guildId);
                QLog.i("GPServiceObserverHelper", 1, "onBannedStatusChanged guildId:" + guildId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@NotNull String guildId, int black) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onBeKickFromGuild(guildId, black);
            if (!TextUtils.isEmpty(guildId)) {
                com.tencent.aio.main.businesshelper.b bVar = a.this.param;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    bVar = null;
                }
                AIOParam g16 = bVar.a().g();
                Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
                if (Intrinsics.areEqual(guildId, com.tencent.guild.aio.util.a.g(g16))) {
                    n(IQQGuildUIUtilApi.QuitReason.KICK_OUT);
                }
            }
            g(guildId);
            QLog.i("GPServiceObserverHelper", 1, "onBeKickFromGuild guildId:" + guildId + " black:" + black);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            AppRuntime peekAppRuntime;
            com.tencent.aio.main.businesshelper.b bVar = a.this.param;
            com.tencent.aio.main.businesshelper.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            AIOParam g16 = bVar.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
            if (!Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                return;
            }
            IGPSService iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "");
            com.tencent.aio.main.businesshelper.b bVar3 = a.this.param;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            } else {
                bVar2 = bVar3;
            }
            AIOParam g17 = bVar2.a().g();
            Intrinsics.checkNotNullExpressionValue(g17, "param.aioContext.aioParam");
            if (iGPSService.getChannelInfo(com.tencent.guild.aio.util.a.b(g17)) == null) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final a aVar = a.this;
                uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.help.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.b.m(a.b.this, aVar);
                    }
                }, 300L);
            }
            QLog.i("GPServiceObserverHelper", 1, "onChannelListUpdated guildId:" + guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelVisibleChanged(@NotNull String guildId, @NotNull String channelId, int oldVisibleType, int newVisibleType) {
            AppRuntime peekAppRuntime;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            com.tencent.aio.main.businesshelper.b bVar = a.this.param;
            com.tencent.aio.main.businesshelper.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            AIOParam g16 = bVar.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
            if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                com.tencent.aio.main.businesshelper.b bVar3 = a.this.param;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                } else {
                    bVar2 = bVar3;
                }
                AIOParam g17 = bVar2.a().g();
                Intrinsics.checkNotNullExpressionValue(g17, "param.aioContext.aioParam");
                if (!Intrinsics.areEqual(com.tencent.guild.aio.util.a.b(g17), channelId) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                    return;
                }
                if (((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(channelId) == null) {
                    n(IQQGuildUIUtilApi.QuitReason.VISIBILITY_CHANGE);
                    f(channelId);
                }
                QLog.i("GPServiceObserverHelper", 1, "onChannelVisibleChanged guildId:" + guildId + " channelId:" + channelId + " visibleType:" + newVisibleType);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onDeleteGuild(guildId);
            g(guildId);
            QLog.i("GPServiceObserverHelper", 1, "onDeleteGuild guildId:" + guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onDestoryGuild(guildId);
            g(guildId);
            QLog.i("GPServiceObserverHelper", 1, "onDestoryGuild guildId:" + guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildUserAvatarUrlUpdate(@Nullable String guildId, @Nullable String tinyId) {
            boolean z16;
            com.tencent.aio.main.businesshelper.b bVar = a.this.param;
            com.tencent.aio.main.businesshelper.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            AIOParam g16 = bVar.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
            if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                if (tinyId != null && tinyId.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    com.tencent.aio.main.businesshelper.b bVar3 = a.this.param;
                    if (bVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("param");
                    } else {
                        bVar2 = bVar3;
                    }
                    bVar2.a().e().h(new GuildMsgListIntent.GuildGiftHeadUpdateEvent(guildId, tinyId));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(@NotNull String guildId, @NotNull List<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            com.tencent.aio.main.businesshelper.b bVar = a.this.param;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            AIOParam g16 = bVar.a().g();
            Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
            if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                for (String str : channelIds) {
                    com.tencent.aio.main.businesshelper.b bVar2 = a.this.param;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("param");
                        bVar2 = null;
                    }
                    AIOParam g17 = bVar2.a().g();
                    Intrinsics.checkNotNullExpressionValue(g17, "param.aioContext.aioParam");
                    if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.b(g17), str)) {
                        n(IQQGuildUIUtilApi.QuitReason.CHANNEL_DESTROY);
                    }
                    if (f(str)) {
                        break;
                    }
                }
                QLog.i("GPServiceObserverHelper", 1, "onPushChannelDestroy guildId:" + guildId + " channelIds:" + channelIds);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            super.onRemoveGuild(guildId);
            g(guildId);
            QLog.i("GPServiceObserverHelper", 1, "onRemoveGuild guildId:" + guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onSecurityResult(@NotNull IGProSecurityResult securityResult) {
            Intrinsics.checkNotNullParameter(securityResult, "securityResult");
        }
    }

    private final void g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).addObserver(this.gpServiceObserver);
        this.mShowQuitDialog = false;
        this.mWaitToFinish = false;
    }

    private final void h() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).deleteObserver(this.gpServiceObserver);
    }

    private final void i() {
        if (this.mWaitToFinish) {
            QLog.i("GPServiceObserverHelper", 1, "doOnResume mWaitToFinish=true.");
            com.tencent.aio.main.businesshelper.b bVar = this.param;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            FragmentActivity activity = bVar.a().c().getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 5;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "GPServiceObserverHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state != 3) {
                if (state == 12) {
                    h();
                    return;
                }
                return;
            }
            i();
            return;
        }
        g();
    }
}
