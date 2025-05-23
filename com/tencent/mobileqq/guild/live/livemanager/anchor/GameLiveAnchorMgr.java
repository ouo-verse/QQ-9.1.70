package com.tencent.mobileqq.guild.live.livemanager.anchor;

import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.performance.report.l;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.api.IRuntimeService;
import nf4.j;
import nf4.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u001b\u0010\u0019\u001a\u00020\u00148VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0014\u0010#\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\"R\u0014\u0010%\u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/anchor/GameLiveAnchorMgr;", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/e;", "", "j", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getService", "Lof4/a;", "cb", "", "c", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/b;", "gameLiveStartParams", "Lnf4/a;", "Lnf4/j;", "Lef4/a;", "loadingCb", "b", "Lkf4/a;", "guildIDInfo", h.F, "Lnf4/h;", "a", "Lkotlin/Lazy;", "f", "()Lnf4/h;", "yesLiveApi", "Lof4/b;", "k", "()Lof4/b;", "yesLiveMainHandler", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "core", "", "()Ljava/lang/String;", "openLiveChannelSchema", "i", "openLiveChannelShareSchema", "<init>", "()V", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GameLiveAnchorMgr implements com.tencent.mobileqq.guild.live.livemanager.anchor.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy yesLiveApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy yesLiveMainHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GLiveChannelCore core;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/live/livemanager/anchor/GameLiveAnchorMgr$b", "Lof4/a;", "", "c", "b", "Lkf4/a;", "guildIdInfo", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements of4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ of4.a f226747a;

        b(of4.a aVar) {
            this.f226747a = aVar;
        }

        @Override // of4.a
        public void a(@Nullable kf4.a guildIdInfo) {
            HashMap hashMapOf;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("game_live_room_prepare_action", "doStopLive"));
            l.i("game_live_room_prepare_action_cb", hashMapOf, 0, null, 12, null);
            this.f226747a.a(guildIdInfo);
        }

        @Override // of4.a
        public void b() {
            HashMap hashMapOf;
            QLog.d("QGL.GameLiveAnchorMgr", 1, "[doJumpLiveMainPage] ");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("game_live_room_prepare_action", "doJumpLiveMainPage"));
            l.i("game_live_room_prepare_action_cb", hashMapOf, 0, null, 12, null);
            this.f226747a.b();
        }

        @Override // of4.a
        public void c() {
            HashMap hashMapOf;
            QLog.d("QGL.GameLiveAnchorMgr", 1, "[doClosePreparePage] ");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("game_live_room_prepare_action", "doClosePreparePage"));
            l.i("game_live_room_prepare_action_cb", hashMapOf, 0, null, 12, null);
            this.f226747a.c();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/live/livemanager/anchor/GameLiveAnchorMgr$c", "Lef4/a;", "", UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ef4.a {
        c() {
        }

        @Override // ef4.a
        public void hideLoading() {
            QLog.d("QGL.GameLiveAnchorMgr", 1, "[hideLoading] ");
        }

        @Override // ef4.a
        public void showLoading() {
            QLog.d("QGL.GameLiveAnchorMgr", 1, "[showLoading] ");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/live/livemanager/anchor/GameLiveAnchorMgr$d", "Lnf4/a;", "Lnf4/k;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements nf4.a<k> {
        d() {
        }

        @Override // nf4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable k result) {
            l.i("game_live_room_prepare_success", null, 0, null, 14, null);
        }

        @Override // nf4.a
        public void onError(int errorCode, @Nullable String errorMessage) {
            Map emptyMap;
            emptyMap = MapsKt__MapsKt.emptyMap();
            if (errorMessage == null) {
                errorMessage = "";
            }
            l.g("game_live_room_prepare_fail", emptyMap, errorCode, errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/live/livemanager/anchor/GameLiveAnchorMgr$e", "Lnf4/a;", "Lnf4/j;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements nf4.a<j> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ nf4.a<j> f226748a;

        e(nf4.a<j> aVar) {
            this.f226748a = aVar;
        }

        @Override // nf4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable j result) {
            QLog.d("QGL.GameLiveAnchorMgr", 1, "[GameCommonResultListener] suc " + result);
            l.i("game_live_room_start_live_success", null, 0, null, 14, null);
            this.f226748a.onSuccess(result);
        }

        @Override // nf4.a
        public void onError(int errorCode, @Nullable String errorMessage) {
            Map emptyMap;
            String str;
            QLog.d("QGL.GameLiveAnchorMgr", 1, "[GameCommonResultListener] err " + errorCode);
            emptyMap = MapsKt__MapsKt.emptyMap();
            if (errorMessage == null) {
                str = "";
            } else {
                str = errorMessage;
            }
            l.g("game_live_room_start_live_fail", emptyMap, errorCode, str);
            this.f226748a.onError(errorCode, errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/live/livemanager/anchor/GameLiveAnchorMgr$f", "Lef4/a;", "", UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements ef4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ef4.a f226749a;

        f(ef4.a aVar) {
            this.f226749a = aVar;
        }

        @Override // ef4.a
        public void hideLoading() {
            QLog.d("QGL.GameLiveAnchorMgr", 1, "start hideLoading");
            this.f226749a.hideLoading();
        }

        @Override // ef4.a
        public void showLoading() {
            QLog.d("QGL.GameLiveAnchorMgr", 1, "start showLoading");
            this.f226749a.showLoading();
        }
    }

    public GameLiveAnchorMgr() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<nf4.h>() { // from class: com.tencent.mobileqq.guild.live.livemanager.anchor.GameLiveAnchorMgr$yesLiveApi$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final nf4.h invoke() {
                return ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getTimiLiveApi();
            }
        });
        this.yesLiveApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<of4.b>() { // from class: com.tencent.mobileqq.guild.live.livemanager.anchor.GameLiveAnchorMgr$yesLiveMainHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final of4.b invoke() {
                return GameLiveAnchorMgr.this.f().g(1);
            }
        });
        this.yesLiveMainHandler = lazy2;
        this.core = GLiveChannelCore.f226698a;
    }

    private final long j() {
        return GLiveChannelCore.f226698a.p().c();
    }

    private final of4.b k() {
        return (of4.b) this.yesLiveMainHandler.getValue();
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.e
    @NotNull
    public String a() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("mqqapi://guild/open_live_channel?guildid=%s&channelid=%s&from=wz_game", Arrays.copyOf(new Object[]{this.core.s().getGuildId(), this.core.s().getChannelId()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.e
    public void b(@NotNull GameLiveStartParams gameLiveStartParams, @NotNull nf4.a<j> cb5, @NotNull ef4.a loadingCb) {
        Intrinsics.checkNotNullParameter(gameLiveStartParams, "gameLiveStartParams");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Intrinsics.checkNotNullParameter(loadingCb, "loadingCb");
        l.i("game_live_room_start_live_start", null, 0, null, 14, null);
        k().a(com.tencent.mobileqq.qqlive.business.a.f271158a, j(), gameLiveStartParams.getGuildIDInfo(), gameLiveStartParams.getLiveGameId(), gameLiveStartParams.getLiveTitle(), gameLiveStartParams.getCoverUrl(), gameLiveStartParams.getBackSchema(), gameLiveStartParams.getBackSchema(), gameLiveStartParams.getShareSchema(), new e(cb5), new f(loadingCb));
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.e
    public void c(@NotNull of4.a cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        l.i("game_live_room_prepare_start", null, 0, null, 14, null);
        of4.b k3 = k();
        String str = com.tencent.mobileqq.qqlive.business.a.f271158a;
        long j3 = j();
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        k3.b(str, j3, new kf4.a(gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId()), new b(cb5), new c(), new d());
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.d
    public /* synthetic */ void d() {
        com.tencent.mobileqq.guild.live.livemanager.anchor.c.a(this);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.d
    public /* synthetic */ void e(int i3, GLiveRoomInfo gLiveRoomInfo, int i16, com.tencent.mobileqq.guild.live.livemanager.anchor.f fVar) {
        com.tencent.mobileqq.guild.live.livemanager.anchor.c.c(this, i3, gLiveRoomInfo, i16, fVar);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.e
    @NotNull
    public nf4.h f() {
        return (nf4.h) this.yesLiveApi.getValue();
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.d
    public /* synthetic */ void g(int i3) {
        com.tencent.mobileqq.guild.live.livemanager.anchor.c.b(this, i3);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.d
    @NotNull
    public IGPSService getService() {
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        return (IGPSService) R0;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.e
    public void h(@NotNull kf4.a guildIDInfo) {
        Intrinsics.checkNotNullParameter(guildIDInfo, "guildIDInfo");
        f().c(guildIDInfo);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.e
    @NotNull
    public String i() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("mqqapi://guild/open_live_channel_share?guildid=%s&channelid=%s&from=wz_game", Arrays.copyOf(new Object[]{this.core.s().getGuildId(), this.core.s().getChannelId()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
