package com.tencent.mobileqq.guild.live.livemanager;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IQQGuildVisitorApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveGuestHelper;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u0017\u0018\u0000 \u00032\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildLiveGuestHelper;", "", "", "e", "", "guildId", "channelId", "f", "i", tl.h.F, "g", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "a", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "j", "()Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "core", "Lcom/tencent/mobileqq/guild/api/IQQGuildVisitorApi$a;", "b", "Lcom/tencent/mobileqq/guild/api/IQQGuildVisitorApi$a;", "visitorTimer", "c", "Ljava/lang/String;", "com/tencent/mobileqq/guild/live/livemanager/QQGuildLiveGuestHelper$b", "d", "Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildLiveGuestHelper$b;", "gpServiceObserver", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildLiveGuestHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GLiveChannelCore core;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IQQGuildVisitorApi.a visitorTimer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b gpServiceObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/live/livemanager/QQGuildLiveGuestHelper$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "", "onAddGuildWithInfo", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            super.onAddGuildWithInfo(info, sourceType);
            if (info != null && !TextUtils.isEmpty(info.getGuildID()) && Intrinsics.areEqual(info.getGuildID(), QQGuildLiveGuestHelper.this.guildId)) {
                Logger logger = Logger.f235387a;
                QQGuildLiveGuestHelper qQGuildLiveGuestHelper = QQGuildLiveGuestHelper.this;
                logger.d().d("QQGuildLiveGuestHelper", 1, "[onAddGuildWithInfo] guildId(" + qQGuildLiveGuestHelper.guildId + ") success!");
                QQGuildLiveGuestHelper.this.e();
            }
        }
    }

    public QQGuildLiveGuestHelper(@NotNull GLiveChannelCore core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.gpServiceObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
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
            iGPSService.deleteObserver(this.gpServiceObserver);
        }
        IQQGuildVisitorApi.a aVar = this.visitorTimer;
        if (aVar != null) {
            aVar.a();
        }
        this.visitorTimer = null;
    }

    public final void f(@NotNull final String guildId, @NotNull final String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        GuildMainFrameUtils.k(guildId, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveGuestHelper$doOnCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                QQGuildLiveGuestHelper.b bVar;
                if (iGProGuildInfo == null) {
                    QLog.e("QQGuildLiveGuestHelper", 1, "tryFetchGuestGuildInfo is null!");
                    return;
                }
                boolean z16 = !iGProGuildInfo.isMember();
                Logger logger = Logger.f235387a;
                String str = guildId;
                logger.d().d("QQGuildLiveGuestHelper", 1, "[doOnCreate] guildId " + str + ", isGuest " + z16);
                if (z16) {
                    Bundle bundle = QQGuildLiveGuestHelper.this.getCore().s().getBundle();
                    if (bundle.containsKey(JumpGuildParam.KEY_JOIN_INFO_PARAM)) {
                        JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, channelId, (JumpGuildParam.JoinInfoParam) bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM));
                        QQGuildLiveGuestHelper qQGuildLiveGuestHelper = QQGuildLiveGuestHelper.this;
                        String simpleName = QQGuildLiveGuestHelper.this.getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
                        qQGuildLiveGuestHelper.visitorTimer = new or1.b(null, simpleName, jumpGuildParam);
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
                        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
                        if (iGPSService != null) {
                            bVar = QQGuildLiveGuestHelper.this.gpServiceObserver;
                            iGPSService.addObserver(bVar);
                            return;
                        }
                        return;
                    }
                    Logger.b bVar2 = new Logger.b();
                    bVar2.a().add("[doOnCreate] bundle not contain KEY_JOIN_INFO_PARAM!!! ");
                    Iterator<T> it = bVar2.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("QQGuildLiveGuestHelper", 1, (String) it.next(), null);
                    }
                }
            }
        });
    }

    public final void g() {
        Logger.f235387a.d().d("QQGuildLiveGuestHelper", 1, "[doOnDestroy]");
        e();
    }

    public final void h() {
        IQQGuildVisitorApi.a aVar = this.visitorTimer;
        if (aVar != null) {
            Logger.f235387a.d().d("QQGuildLiveGuestHelper", 1, "[doOnPause]");
            aVar.a();
        }
    }

    public final void i() {
        IQQGuildVisitorApi.a aVar = this.visitorTimer;
        if (aVar != null) {
            Logger.f235387a.d().d("QQGuildLiveGuestHelper", 1, "[doOnResume]");
            aVar.b();
        }
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final GLiveChannelCore getCore() {
        return this.core;
    }
}
