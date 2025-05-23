package com.tencent.mobileqq.qqlive.reqlimit;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.ratelimit.RateLimitConfig;
import com.tencent.qqlive.common.ratelimit.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\rB\u0013\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/reqlimit/b;", "", "", "rateKey", "", "starTime", "Lcom/tencent/qqlive/common/ratelimit/a;", "callback", "", "d", "e", "b", "Lcom/tencent/qqlive/common/ratelimit/RateLimitConfig;", "a", "Lcom/tencent/qqlive/common/ratelimit/RateLimitConfig;", "getConfig", "()Lcom/tencent/qqlive/common/ratelimit/RateLimitConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "Lcom/tencent/qqlive/common/ratelimit/c;", "c", "Lcom/tencent/qqlive/common/ratelimit/c;", "mRateLimitController", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "<init>", "(Lcom/tencent/qqlive/common/ratelimit/RateLimitConfig;)V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final RateLimitConfig config;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mRateLimitController;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/reqlimit/b$a;", "", "", "KEY_CACHE_REQ_RATE_CONFIG_SWITCH", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.reqlimit.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43195);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@Nullable RateLimitConfig rateLimitConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rateLimitConfig);
            return;
        }
        this.config = rateLimitConfig;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.mRateLimitController = new c(rateLimitConfig);
        this.mHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0, String rateKey, long j3, com.tencent.qqlive.common.ratelimit.a callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rateKey, "$rateKey");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.d(rateKey, j3, callback);
    }

    private final void d(String rateKey, long starTime, com.tencent.qqlive.common.ratelimit.a callback) {
        boolean a16;
        synchronized (this.mRateLimitController) {
            a16 = this.mRateLimitController.a(rateKey);
            Unit unit = Unit.INSTANCE;
        }
        e(rateKey, starTime);
        callback.a(Boolean.valueOf(a16));
    }

    private final void e(String rateKey, long starTime) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - starTime;
        Intrinsics.checkNotNull(this.config);
        if (elapsedRealtime > r4.getMaxCheckInterval()) {
            this.mAegisLog.a("SsoRateLimitController", rateKey + " performCheckLimit \u65f6\u95f4\u8fc7\u957f\u544a\u8b66\uff0cgap=" + elapsedRealtime);
        }
    }

    public final void b(@NotNull final String rateKey, @NotNull final com.tencent.qqlive.common.ratelimit.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rateKey, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(rateKey, "rateKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.reqlimit.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(b.this, rateKey, elapsedRealtime, callback);
                }
            });
        } else {
            d(rateKey, elapsedRealtime, callback);
        }
    }
}
