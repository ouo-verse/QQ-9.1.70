package com.tencent.mobileqq.guild.live.livemanager.player;

import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.ITimiGameApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pf4.PlayTogetherGuildSettingModel;
import pf4.PlayTogetherSettingModel;
import pf4.PlayTogetherUserShowInfo;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\nR#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/player/GamePlayTogetherMgr;", "", "Lpf4/g;", "e", "Lpf4/a;", "f", "", "open", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/f;", "callback", "", "g", "c", "Lpf4/d;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "d", "()Lpf4/d;", "mPlayTogetherSvr", "b", "Lpf4/a;", "mPlayTogetherMgr", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GamePlayTogetherMgr {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static GamePlayTogetherMgr f226865d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mPlayTogetherSvr;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private pf4.a mPlayTogetherMgr;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/player/GamePlayTogetherMgr$a;", "", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GamePlayTogetherMgr;", "a", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/guild/live/livemanager/player/GamePlayTogetherMgr;", "b", "()Lcom/tencent/mobileqq/guild/live/livemanager/player/GamePlayTogetherMgr;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.livemanager.player.GamePlayTogetherMgr$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GamePlayTogetherMgr b() {
            if (GamePlayTogetherMgr.f226865d == null) {
                GamePlayTogetherMgr.f226865d = new GamePlayTogetherMgr();
            }
            return GamePlayTogetherMgr.f226865d;
        }

        @NotNull
        public final synchronized GamePlayTogetherMgr a() {
            GamePlayTogetherMgr b16;
            b16 = b();
            Intrinsics.checkNotNull(b16);
            return b16;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/live/livemanager/player/GamePlayTogetherMgr$b", "Lpf4/c;", "", "b", "", "errCode", "", "errMsg", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends pf4.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.live.livemanager.anchor.f f226868a;

        b(com.tencent.mobileqq.guild.live.livemanager.anchor.f fVar) {
            this.f226868a = fVar;
        }

        @Override // pf4.c
        public void a(int errCode, @Nullable String errMsg) {
            super.a(errCode, errMsg);
            com.tencent.mobileqq.guild.live.livemanager.anchor.f fVar = this.f226868a;
            if (fVar != null) {
                fVar.b(Integer.valueOf(errCode), errMsg);
            }
        }

        @Override // pf4.c
        public void b() {
            super.b();
            com.tencent.mobileqq.guild.live.livemanager.anchor.f fVar = this.f226868a;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/live/livemanager/player/GamePlayTogetherMgr$c", "Lpf4/c;", "", "b", "", "errCode", "", "errMsg", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends pf4.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.live.livemanager.anchor.f f226869a;

        c(com.tencent.mobileqq.guild.live.livemanager.anchor.f fVar) {
            this.f226869a = fVar;
        }

        @Override // pf4.c
        public void a(int errCode, @Nullable String errMsg) {
            super.a(errCode, errMsg);
            com.tencent.mobileqq.guild.live.livemanager.anchor.f fVar = this.f226869a;
            if (fVar != null) {
                fVar.b(Integer.valueOf(errCode), errMsg);
            }
        }

        @Override // pf4.c
        public void b() {
            super.b();
            com.tencent.mobileqq.guild.live.livemanager.anchor.f fVar = this.f226869a;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public GamePlayTogetherMgr() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<pf4.d>() { // from class: com.tencent.mobileqq.guild.live.livemanager.player.GamePlayTogetherMgr$mPlayTogetherSvr$2
            @Override // kotlin.jvm.functions.Function0
            public final pf4.d invoke() {
                return ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getTimiLiveApi().f();
            }
        });
        this.mPlayTogetherSvr = lazy;
    }

    private final pf4.d d() {
        return (pf4.d) this.mPlayTogetherSvr.getValue();
    }

    private final PlayTogetherSettingModel e() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        String guildId = gLiveChannelCore.s().getGuildId();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        String selfTinyId = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        String userAvatarUrl = QQGuildUIUtil.n(guildId, selfTinyId, appInterface);
        String nickName = ch.H(appInterface, guildId, selfTinyId);
        Intrinsics.checkNotNullExpressionValue(userAvatarUrl, "userAvatarUrl");
        Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
        return new PlayTogetherSettingModel(0, new PlayTogetherUserShowInfo(userAvatarUrl, nickName, 0), new PlayTogetherGuildSettingModel(new kf4.a(guildId, gLiveChannelCore.s().getChannelId())), 1, null);
    }

    public final void c() {
        pf4.a aVar = this.mPlayTogetherMgr;
        if (aVar != null) {
            aVar.destroy();
        }
        this.mPlayTogetherMgr = null;
    }

    @NotNull
    public final pf4.a f() {
        if (this.mPlayTogetherMgr == null) {
            this.mPlayTogetherMgr = d().a(e());
        }
        pf4.a aVar = this.mPlayTogetherMgr;
        Intrinsics.checkNotNull(aVar);
        return aVar;
    }

    public final void g(boolean open, @Nullable com.tencent.mobileqq.guild.live.livemanager.anchor.f callback) {
        if (open) {
            d().c(e(), new b(callback));
        } else {
            d().b(e(), new c(callback));
        }
    }
}
