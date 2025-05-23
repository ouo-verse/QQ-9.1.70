package com.tencent.biz.qqcircle.immersive.feed.live;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqcircle.immersive.feed.live.LiveRetryPlayerCtrl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qqlive.common.api.IAegisLogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001\u001d\u0018\u0000 \u00072\u00020\u0001:\u0002\n\u000eB\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/LiveRetryPlayerCtrl;", "", "", tl.h.F, "", "code", "g", "f", "i", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "a", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "log", "Lcom/tencent/biz/qqcircle/immersive/feed/live/LiveRetryPlayerCtrl$b;", "b", "Lcom/tencent/biz/qqcircle/immersive/feed/live/LiveRetryPlayerCtrl$b;", "e", "()Lcom/tencent/biz/qqcircle/immersive/feed/live/LiveRetryPlayerCtrl$b;", "j", "(Lcom/tencent/biz/qqcircle/immersive/feed/live/LiveRetryPlayerCtrl$b;)V", "retryCallback", "", "c", "Z", "shouldRetry", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "handler", "com/tencent/biz/qqcircle/immersive/feed/live/LiveRetryPlayerCtrl$retryRunnable$1", "Lcom/tencent/biz/qqcircle/immersive/feed/live/LiveRetryPlayerCtrl$retryRunnable$1;", "retryRunnable", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class LiveRetryPlayerCtrl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b retryCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean shouldRetry;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveRetryPlayerCtrl$retryRunnable$1 retryRunnable;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/LiveRetryPlayerCtrl$b;", "", "", "onRetry", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface b {
        void onRetry();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.biz.qqcircle.immersive.feed.live.LiveRetryPlayerCtrl$retryRunnable$1] */
    public LiveRetryPlayerCtrl() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        this.shouldRetry = true;
        this.handler = new Handler(Looper.getMainLooper());
        this.retryRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.LiveRetryPlayerCtrl$retryRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                IAegisLogApi iAegisLogApi;
                boolean z16;
                boolean z17;
                Handler handler;
                boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable();
                iAegisLogApi = LiveRetryPlayerCtrl.this.log;
                z16 = LiveRetryPlayerCtrl.this.shouldRetry;
                iAegisLogApi.i("LiveRetryPlayerCtrl", "retryRunnable, shouldRetry " + z16 + ", networkAvailable " + isNetworkAvailable);
                z17 = LiveRetryPlayerCtrl.this.shouldRetry;
                if (!z17) {
                    return;
                }
                if (!isNetworkAvailable) {
                    LiveRetryPlayerCtrl.this.h();
                    handler = LiveRetryPlayerCtrl.this.handler;
                    handler.postDelayed(this, 3000L);
                } else {
                    LiveRetryPlayerCtrl.b retryCallback = LiveRetryPlayerCtrl.this.getRetryCallback();
                    if (retryCallback != null) {
                        retryCallback.onRetry();
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        this.handler.removeCallbacks(this.retryRunnable);
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final b getRetryCallback() {
        return this.retryCallback;
    }

    public final void f() {
        this.log.i("LiveRetryPlayerCtrl", "onFirstFrame");
        this.shouldRetry = false;
        h();
    }

    public final void g(int code) {
        boolean isEnable = VasToggle.QQLIVE_ENABLE_QCIRCLE_RETRY_PLAYER.isEnable(true);
        this.log.i("LiveRetryPlayerCtrl", "onPlayerError " + code + ", enableRetry " + isEnable);
        this.shouldRetry = true;
        h();
        this.handler.postDelayed(this.retryRunnable, 3000L);
    }

    public final void i() {
        this.log.i("LiveRetryPlayerCtrl", "reset");
        this.shouldRetry = true;
        h();
    }

    public final void j(@Nullable b bVar) {
        this.retryCallback = bVar;
    }
}
