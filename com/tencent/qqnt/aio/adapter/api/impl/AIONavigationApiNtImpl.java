package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIONavigationApi;
import com.tencent.rlottie.AXrLottieDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIONavigationApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIONavigationApi;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/aio/adapter/api/IAIONavigationApi$b;", "callback", "", "loadSync", "", "path", "cacheName", "Lcom/tencent/rlottie/AXrLottieDrawable;", "loadLottieDrawable", "Lcom/tencent/qqnt/aio/adapter/api/IAIONavigationApi$a;", "getNavCache", "loadNavRes", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIONavigationApiNtImpl implements IAIONavigationApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "AIONavigationApiImpl";

    @Nullable
    private static IAIONavigationApi.a sCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIONavigationApiNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIONavigationApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30870);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIONavigationApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final AXrLottieDrawable loadLottieDrawable(Context context, String path, String cacheName) {
        return AXrLottieDrawable.T(context, path, cacheName).f(true).h(false).e(true).c(true).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadNavRes$lambda$0(AIONavigationApiNtImpl this$0, Context context, IAIONavigationApi.b callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.loadSync(context, callback);
    }

    private final void loadSync(Context context, final IAIONavigationApi.b callback) {
        final IAIONavigationApi.a aVar = sCache;
        if (aVar != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.r
                @Override // java.lang.Runnable
                public final void run() {
                    AIONavigationApiNtImpl.loadSync$lambda$1(IAIONavigationApi.b.this, aVar);
                }
            });
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            final IAIONavigationApi.a aVar2 = new IAIONavigationApi.a();
            com.tencent.rlottie.a.d(BaseApplication.getContext());
            aVar2.h(loadLottieDrawable(context, "images/lottie/qq_loading_white.json", "white"));
            aVar2.g(loadLottieDrawable(context, "images/lottie/qq_loading_black.json", "blue"));
            aVar2.f(context.getResources().getDrawable(R.drawable.j7x));
            aVar2.e(context.getResources().getDrawable(R.drawable.j7w));
            sCache = aVar2;
            QLog.d("AIONavigationApiImpl", 1, "loadNavRes cost=" + (System.currentTimeMillis() - currentTimeMillis));
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.s
                @Override // java.lang.Runnable
                public final void run() {
                    AIONavigationApiNtImpl.loadSync$lambda$2(IAIONavigationApi.b.this, aVar2);
                }
            });
        } catch (Throwable th5) {
            QLog.d("AIONavigationApiImpl", 1, "loadNavRes fail : ", th5);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.t
                @Override // java.lang.Runnable
                public final void run() {
                    AIONavigationApiNtImpl.loadSync$lambda$3(IAIONavigationApi.b.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadSync$lambda$1(IAIONavigationApi.b callback, IAIONavigationApi.a aVar) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadSync$lambda$2(IAIONavigationApi.b callback, IAIONavigationApi.a cache) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(cache, "$cache");
        callback.a(cache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadSync$lambda$3(IAIONavigationApi.b callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onFailed();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONavigationApi
    @Nullable
    public IAIONavigationApi.a getNavCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IAIONavigationApi.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sCache;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONavigationApi
    public void loadNavRes(@NotNull final Context context, @NotNull final IAIONavigationApi.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.u
            @Override // java.lang.Runnable
            public final void run() {
                AIONavigationApiNtImpl.loadNavRes$lambda$0(AIONavigationApiNtImpl.this, context, callback);
            }
        }, 64, null, true);
    }
}
