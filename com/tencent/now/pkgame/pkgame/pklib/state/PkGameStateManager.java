package com.tencent.now.pkgame.pkgame.pklib.state;

import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.now.pkgame.pkgame.pklib.model.e;
import com.tencent.now.pkgame.pkgame.pklib.state.a;
import com.tencent.qqlive.common.api.IAegisLogApi;
import g55.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import tl.h;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/pklib/state/PkGameStateManager;", "", "", IOnlineStatusService.REMAIN_TIME, "", "d", "Lcom/tencent/now/pkgame/pkgame/pklib/state/a;", "currentGameState", "e", "", "isExitRoom", h.F, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "a", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "Lho3/a;", "b", "Lho3/a;", "pkInfoMemo", "Lmo3/c;", "c", "Lmo3/c;", "dispatcher", "Lrx/Subscription;", "Lrx/Subscription;", "subscription", "Lcom/tencent/now/pkgame/pkgame/pklib/state/a;", "preGameState", "f", "curGameState", "Lcom/tencent/now/pkgame/pkgame/pklib/model/a;", "g", "Lcom/tencent/now/pkgame/pkgame/pklib/model/a;", "pkGameInfoRspReady", "Lcom/tencent/now/pkgame/pkgame/pklib/model/e;", "pkGameModel", "<init>", "(Lcom/tencent/now/pkgame/pkgame/pklib/model/e;Lho3/a;Lmo3/c;)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PkGameStateManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ho3.a pkInfoMemo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private mo3.c dispatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Subscription subscription;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a preGameState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a curGameState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.now.pkgame.pkgame.pklib.model.a pkGameInfoRspReady;

    public PkGameStateManager(@NotNull final e pkGameModel, @NotNull ho3.a pkInfoMemo, @NotNull mo3.c dispatcher) {
        Intrinsics.checkNotNullParameter(pkGameModel, "pkGameModel");
        Intrinsics.checkNotNullParameter(pkInfoMemo, "pkInfoMemo");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.pkInfoMemo = pkInfoMemo;
        this.dispatcher = dispatcher;
        this.preGameState = new a.f();
        this.curGameState = new a.f();
        com.tencent.now.pkgame.pkgame.pklib.model.a aVar = new com.tencent.now.pkgame.pkgame.pklib.model.a() { // from class: com.tencent.now.pkgame.pkgame.pklib.state.b
            @Override // com.tencent.now.pkgame.pkgame.pklib.model.a
            public final void a(q qVar) {
                PkGameStateManager.f(PkGameStateManager.this, pkGameModel, qVar);
            }
        };
        this.pkGameInfoRspReady = aVar;
        pkGameModel.b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(long remainTime) {
        boolean z16;
        boolean z17;
        a aVar = this.curGameState;
        this.preGameState = aVar;
        if (remainTime >= 64000) {
            if (aVar instanceof a.c) {
                return;
            }
            a.c cVar = new a.c();
            cVar.a(0L);
            this.curGameState = cVar;
        } else {
            boolean z18 = true;
            if (61000 <= remainTime && remainTime < 64001) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (aVar instanceof a.d) {
                    return;
                }
                a.d dVar = new a.d();
                dVar.a(remainTime - 63000);
                this.curGameState = dVar;
            } else {
                if (6000 <= remainTime && remainTime < 61001) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (aVar instanceof a.C9254a) {
                        return;
                    }
                    a.C9254a c9254a = new a.C9254a();
                    c9254a.a(remainTime - 60000);
                    this.curGameState = c9254a;
                } else {
                    if (1000 > remainTime || remainTime >= 6001) {
                        z18 = false;
                    }
                    if (z18) {
                        if (aVar instanceof a.b) {
                            return;
                        }
                        a.b bVar = new a.b();
                        bVar.a(remainTime - 5000);
                        this.curGameState = bVar;
                    } else if (remainTime <= 0) {
                        if (aVar instanceof a.e) {
                            return;
                        }
                        a.e eVar = new a.e();
                        eVar.a(0L);
                        this.curGameState = eVar;
                    }
                }
            }
        }
        if (!Intrinsics.areEqual(this.preGameState, this.curGameState)) {
            this.pkInfoMemo.c(this.curGameState);
            e(this.curGameState);
        }
    }

    private final void e(a currentGameState) {
        this.mAegisLog.i("PkGameStateManager", 2, "onStateChanged: " + currentGameState);
        this.dispatcher.d(currentGameState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final PkGameStateManager this$0, e pkGameModel, q qVar) {
        Subscription subscription;
        Observable<Long> a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pkGameModel, "$pkGameModel");
        com.tencent.now.pkgame.pkgame.pklib.time.a m3 = pkGameModel.m();
        if (m3 != null && (a16 = m3.a()) != null) {
            final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.now.pkgame.pkgame.pklib.state.PkGameStateManager$pkGameInfoRspReady$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long remainTime) {
                    PkGameStateManager pkGameStateManager = PkGameStateManager.this;
                    Intrinsics.checkNotNullExpressionValue(remainTime, "remainTime");
                    pkGameStateManager.d(remainTime.longValue());
                }
            };
            subscription = a16.subscribe(new Action1() { // from class: com.tencent.now.pkgame.pkgame.pklib.state.c
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    PkGameStateManager.g(Function1.this, obj);
                }
            });
        } else {
            subscription = null;
        }
        this$0.subscription = subscription;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void h(boolean isExitRoom) {
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.preGameState = new a.f();
        this.curGameState = new a.f();
    }
}
