package com.tencent.now.pkgame.linkandpkobserver.audience;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\r\u0011B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/now/pkgame/linkandpkobserver/audience/PKLinkMicOffChecker;", "", "", "e", "d", "", "j", "Lgo3/a;", "linkMicBean", "k", "g", "i", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/PKLinkMicOffChecker$b;", "a", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/PKLinkMicOffChecker$b;", "linkMicOffListener", "Lrx/Subscription;", "b", "Lrx/Subscription;", "subscription", "c", "Z", "timerIsRunning", "", "J", "lastLinkMicTimestamp", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "checkLinkMicOffRunnable", "f", "Lgo3/a;", "<init>", "(Lcom/tencent/now/pkgame/linkandpkobserver/audience/PKLinkMicOffChecker$b;)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PKLinkMicOffChecker {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b linkMicOffListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Subscription subscription;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean timerIsRunning;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable checkLinkMicOffRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastLinkMicTimestamp = SystemClock.elapsedRealtime();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private go3.a linkMicBean = new go3.a(DebugKt.DEBUG_PROPERTY_VALUE_OFF);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/now/pkgame/linkandpkobserver/audience/PKLinkMicOffChecker$b;", "", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b {
        void a();
    }

    public PKLinkMicOffChecker(@Nullable b bVar) {
        this.linkMicOffListener = bVar;
    }

    private final void d() {
        if (SystemClock.elapsedRealtime() > this.linkMicBean.a() + 3000) {
            i();
            b bVar = this.linkMicOffListener;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void e() {
        if (this.checkLinkMicOffRunnable != null) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = this.checkLinkMicOffRunnable;
            Intrinsics.checkNotNull(runnable);
            uIHandlerV2.removeCallbacks(runnable);
        }
        this.checkLinkMicOffRunnable = new Runnable() { // from class: com.tencent.now.pkgame.linkandpkobserver.audience.d
            @Override // java.lang.Runnable
            public final void run() {
                PKLinkMicOffChecker.f(PKLinkMicOffChecker.this);
            }
        };
        Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
        Runnable runnable2 = this.checkLinkMicOffRunnable;
        Intrinsics.checkNotNull(runnable2);
        uIHandlerV22.post(runnable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PKLinkMicOffChecker this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void g() {
        AegisLogger.INSTANCE.i("PK_Biz|PKLinkMicOffChecker", "startTimer");
        Subscription subscription = this.subscription;
        if (subscription != null) {
            Intrinsics.checkNotNull(subscription);
            if (!subscription.isUnsubscribed()) {
                Subscription subscription2 = this.subscription;
                Intrinsics.checkNotNull(subscription2);
                subscription2.unsubscribe();
            }
        }
        this.timerIsRunning = true;
        Observable<Long> observeOn = Observable.interval(0L, 2L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.now.pkgame.linkandpkobserver.audience.PKLinkMicOffChecker$startTimer$1
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
                PKLinkMicOffChecker.this.e();
            }
        };
        this.subscription = observeOn.subscribe(new Action1() { // from class: com.tencent.now.pkgame.linkandpkobserver.audience.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PKLinkMicOffChecker.h(Function1.this, obj);
            }
        });
    }

    public final void i() {
        AegisLogger.INSTANCE.i("PK_Biz|PKLinkMicOffChecker", "stopTimer");
        this.timerIsRunning = false;
        Subscription subscription = this.subscription;
        if (subscription != null) {
            Intrinsics.checkNotNull(subscription);
            if (!subscription.isUnsubscribed()) {
                Subscription subscription2 = this.subscription;
                Intrinsics.checkNotNull(subscription2);
                subscription2.unsubscribe();
            }
        }
        if (this.checkLinkMicOffRunnable != null) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = this.checkLinkMicOffRunnable;
            Intrinsics.checkNotNull(runnable);
            uIHandlerV2.removeCallbacks(runnable);
        }
    }

    /* renamed from: j, reason: from getter */
    public final boolean getTimerIsRunning() {
        return this.timerIsRunning;
    }

    public final void k(@NotNull go3.a linkMicBean) {
        Intrinsics.checkNotNullParameter(linkMicBean, "linkMicBean");
        this.linkMicBean = linkMicBean;
    }
}
