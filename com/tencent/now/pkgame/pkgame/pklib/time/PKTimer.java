package com.tencent.now.pkgame.pkgame.pklib.time;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.common.api.IAegisLogApi;
import g55.at;
import g55.av;
import g55.q;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/pklib/time/PKTimer;", "Lcom/tencent/now/pkgame/pkgame/pklib/time/a;", "Lg55/q;", "rsp", "", "t", "", "serverTs", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "it", DomainData.DOMAIN_NAME, "(Ljava/lang/Long;)V", "", "b", "Lrx/Observable;", "a", "release", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "J", "absolutePkTotalTime", "c", "totalTime", "d", IOnlineStatusService.REMAIN_TIME, "e", "I", "punishmentTimeSec", "Lrx/subjects/PublishSubject;", "f", "Lrx/subjects/PublishSubject;", "timeObservable", "Lrx/Subscription;", "g", "Lrx/Subscription;", "subscription", "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "publishRunnable", "Lcom/tencent/now/pkgame/pkgame/pklib/model/e;", "pkGameModel", "<init>", "(Lcom/tencent/now/pkgame/pkgame/pklib/model/e;)V", "i", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PKTimer implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long absolutePkTotalTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long totalTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long remainTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int punishmentTimeSec;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PublishSubject<Long> timeObservable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Subscription subscription;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable publishRunnable;

    public PKTimer(@NotNull com.tencent.now.pkgame.pkgame.pklib.model.e pkGameModel) {
        Intrinsics.checkNotNullParameter(pkGameModel, "pkGameModel");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        PublishSubject<Long> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Long>()");
        this.timeObservable = create;
        pkGameModel.b(new com.tencent.now.pkgame.pkgame.pklib.model.a() { // from class: com.tencent.now.pkgame.pkgame.pklib.time.c
            @Override // com.tencent.now.pkgame.pkgame.pklib.model.a
            public final void a(q qVar) {
                PKTimer.h(PKTimer.this, qVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(PKTimer this$0, q rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        this$0.t(rsp);
    }

    private final long m(long serverTs) {
        long ceil = (long) Math.ceil(((System.currentTimeMillis() - (serverTs * 1000)) * 1.0d) / 1000);
        if (Math.abs(ceil) < 10) {
            return ceil;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void n(final Long it) {
        Runnable runnable = this.publishRunnable;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tencent.now.pkgame.pkgame.pklib.time.b
            @Override // java.lang.Runnable
            public final void run() {
                PKTimer.o(PKTimer.this, it);
            }
        };
        ThreadManagerV2.getUIHandlerV2().post(runnable2);
        this.publishRunnable = runnable2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(PKTimer this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.timeObservable.onNext(l3);
    }

    private final void p() {
        this.aegisLog.i("PKTimer", 1, "startCountDown");
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<Long> observeOn = Observable.interval(0L, 1L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
        final Function1<Long, Long> function1 = new Function1<Long, Long>() { // from class: com.tencent.now.pkgame.pkgame.pklib.time.PKTimer$startCountDown$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(Long l3) {
                long j3;
                IAegisLogApi iAegisLogApi;
                j3 = PKTimer.this.totalTime;
                long longValue = j3 - (l3.longValue() * 1000);
                iAegisLogApi = PKTimer.this.aegisLog;
                iAegisLogApi.i("PKTimer", 1, "... remainTime=" + longValue);
                PKTimer.this.remainTime = longValue;
                return Long.valueOf(longValue);
            }
        };
        Observable<R> map = observeOn.map(new Func1() { // from class: com.tencent.now.pkgame.pkgame.pklib.time.d
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                Long q16;
                q16 = PKTimer.q(Function1.this, obj);
                return q16;
            }
        });
        final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: com.tencent.now.pkgame.pkgame.pklib.time.PKTimer$startCountDown$2
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
            public final void invoke2(Long l3) {
                PKTimer.this.n(l3);
            }
        };
        this.subscription = map.subscribe((Action1<? super R>) new Action1() { // from class: com.tencent.now.pkgame.pkgame.pklib.time.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PKTimer.r(Function1.this, obj);
            }
        }, new Action1() { // from class: com.tencent.now.pkgame.pkgame.pklib.time.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PKTimer.s(PKTimer.this, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long q(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Long) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(PKTimer this$0, Throwable th5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aegisLog.e("PKTimer", 1, "setIsInGetMatchInfoWaitingHandle");
    }

    private final void t(q rsp) {
        at atVar = rsp.f401379b;
        long m3 = m(atVar.f401335k);
        this.aegisLog.i("PKTimer", "timeDiffTs: " + m3);
        long j3 = atVar.f401330f;
        long j16 = (long) 1000;
        long j17 = ((j3 * j16) - (atVar.f401335k * j16)) - (m3 * j16);
        long j18 = (j3 * j16) - (atVar.f401329e * j16);
        av punishInfo = atVar.f401334j;
        if (punishInfo != null) {
            Intrinsics.checkNotNullExpressionValue(punishInfo, "punishInfo");
            this.punishmentTimeSec = (int) (punishInfo.f401343b - punishInfo.f401342a);
        }
        this.aegisLog.i("PKTimer", "endTime=" + atVar.f401330f + ",ts=" + atVar.f401335k + ",totalTime=" + j17 + ", punishmentTimeSec=" + this.punishmentTimeSec);
        if (j17 <= 0) {
            this.aegisLog.w("PKTimer", "PK has already end");
            this.totalTime = 0L;
            this.remainTime = 0L;
            this.absolutePkTotalTime = 0L;
            if ((this.punishmentTimeSec * 1000) + j17 > 0) {
                this.aegisLog.i("PKTimer", "PK has punish time, total:" + j17);
                this.totalTime = j17;
            }
        } else {
            this.totalTime = j17;
            this.remainTime = j17;
            this.absolutePkTotalTime = j18;
        }
        p();
    }

    @Override // com.tencent.now.pkgame.pkgame.pklib.time.a
    @NotNull
    public Observable<Long> a() {
        return this.timeObservable;
    }

    @Override // com.tencent.now.pkgame.pkgame.pklib.time.a
    /* renamed from: b, reason: from getter */
    public int getPunishmentTimeSec() {
        return this.punishmentTimeSec;
    }

    @Override // com.tencent.now.pkgame.pkgame.pklib.time.a
    public void release() {
        Subscription subscription;
        Subscription subscription2 = this.subscription;
        boolean z16 = false;
        if (subscription2 != null && !subscription2.isUnsubscribed()) {
            z16 = true;
        }
        if (z16 && (subscription = this.subscription) != null) {
            subscription.unsubscribe();
        }
        Runnable runnable = this.publishRunnable;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
    }
}
