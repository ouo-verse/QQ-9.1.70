package com.tencent.qne.delegate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qne.model.PreloadStatusCode;
import com.tencent.qne.util.Logger;
import com.tencent.rdelivery.reshub.api.ResHubParams;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.rdelivery.reshub.api.j;
import com.tencent.rdelivery.reshub.api.n;
import com.tencent.rdelivery.reshub.api.r;
import com.tencent.rdelivery.reshub.core.j;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\u001aB)\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\b\u0012\u0006\u0010(\u001a\u00020#\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002J'\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0013\u001a\u00020\u0012*\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\f*\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/qne/delegate/a;", "Lcom/tencent/qne/delegate/d;", "Landroid/content/Context;", "context", "", "d", "j", "Lcom/tencent/rdelivery/reshub/api/g;", "", "e", "Lcom/tencent/rdelivery/reshub/api/i;", "resId", "", "specificTaskId", "i", "(Lcom/tencent/rdelivery/reshub/api/i;Ljava/lang/String;Ljava/lang/Long;)Lcom/tencent/rdelivery/reshub/api/g;", "Lcom/tencent/rdelivery/reshub/api/h;", "callback", "", "k", "(Lcom/tencent/rdelivery/reshub/api/i;Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/rdelivery/reshub/api/h;)V", AdMetricTag.FALLBACK, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;Ljava/lang/Long;)J", "resourceId", "Lcom/tencent/qne/delegate/e;", "a", "(Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "appId", "b", "g", com.heytap.mcssdk.a.a.f36102l, "Lcom/tencent/rdelivery/reshub/api/s;", "c", "Lcom/tencent/rdelivery/reshub/api/s;", h.F, "()Lcom/tencent/rdelivery/reshub/api/s;", "params", "Z", "onlyDownloadOnWifi", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/rdelivery/reshub/api/s;Z)V", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ResHubParams params;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean onlyDownloadOnWifi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qne/delegate/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.qne.delegate.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qne/delegate/a$b", "Lcom/tencent/rdelivery/reshub/api/h;", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "", "onComplete", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes22.dex */
    public static final class b implements com.tencent.rdelivery.reshub.api.h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f344329a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Long f344330b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<e> f344331c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f344332d;

        b(String str, Long l3, CancellableContinuation<? super e> cancellableContinuation, a aVar) {
            this.f344329a = str;
            this.f344330b = l3;
            this.f344331c = cancellableContinuation;
            this.f344332d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, l3, cancellableContinuation, aVar);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        @Override // com.tencent.rdelivery.reshub.api.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onComplete(boolean isSuccess, @Nullable g result, @NotNull n error) {
            String str;
            String str2;
            String b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), result, error);
                return;
            }
            Intrinsics.checkNotNullParameter(error, "error");
            Logger.i("[qne]DefaultShiplyDelegate", "loadResource for " + this.f344329a + " specific:" + this.f344330b + " end");
            jz3.e eVar = (jz3.e) result;
            String str3 = null;
            if (eVar == null) {
                str = null;
            } else {
                str = eVar.H;
            }
            if (str == null) {
                if (result == null) {
                    str2 = null;
                    CancellableContinuation<e> cancellableContinuation = this.f344331c;
                    int b17 = error.b();
                    String message = error.message();
                    if (result != null) {
                        b16 = null;
                    } else {
                        b16 = result.b();
                    }
                    a aVar = this.f344332d;
                    if (eVar != null) {
                        str3 = eVar.f411279t;
                    }
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(new e(b17, message, b16, str2, aVar.m(str3, this.f344330b))));
                }
                str = result.e();
            }
            str2 = str;
            CancellableContinuation<e> cancellableContinuation2 = this.f344331c;
            int b172 = error.b();
            String message2 = error.message();
            if (result != null) {
            }
            a aVar2 = this.f344332d;
            if (eVar != null) {
            }
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(new e(b172, message2, b16, str2, aVar2.m(str3, this.f344330b))));
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            } else {
                h.a.a(this, f16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14557);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull String appId, @NotNull String appKey, @NotNull ResHubParams params, boolean z16) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(params, "params");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appId, appKey, params, Boolean.valueOf(z16));
            return;
        }
        this.appId = appId;
        this.appKey = appKey;
        this.params = params;
        this.onlyDownloadOnWifi = z16;
    }

    private final boolean d(Context context) {
        if (this.onlyDownloadOnWifi && !j(context)) {
            return false;
        }
        return true;
    }

    private final String e(g gVar) {
        return "[version:" + gVar.getVersion() + ", taskId:" + ((Object) gVar.getTaskId()) + ", md5:" + ((Object) gVar.a()) + ", size:" + com.tencent.qne.util.a.g(gVar.getSize()) + ']';
    }

    private final g i(i iVar, String str, Long l3) {
        if (l3 != null) {
            return i.a.c(iVar, str, l3.longValue(), false, 4, null);
        }
        return i.a.a(iVar, str, false, 2, null);
    }

    private final boolean j(Context context) {
        NetworkCapabilities networkCapabilities;
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return NetworkMonitor.hasTransport(networkCapabilities, 1);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(i iVar, String str, Long l3, com.tencent.rdelivery.reshub.api.h hVar) {
        if (l3 != null) {
            iVar.a(str, l3.longValue(), hVar);
        } else {
            iVar.e(str, hVar);
        }
    }

    static /* synthetic */ Object l(a aVar, String str, Long l3, Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        j jVar = j.L;
        if (!jVar.Q()) {
            e eVar = new e(PreloadStatusCode.DownloadOrCheckFail.getValue(), "resHub not initialized", null, null, 0L, 28, null);
            Logger.w("[qne]DefaultShiplyDelegate", "loadResource get " + str + ", specific:" + l3 + " failed, " + eVar);
            return eVar;
        }
        jVar.a0(true);
        r rVar = new r();
        rVar.c(aVar.h());
        i b16 = j.a.b(jVar, aVar.f(), aVar.g(), null, null, null, null, rVar, 60, null);
        g i3 = aVar.i(b16, str, l3);
        if (i3 != null) {
            if (aVar.d(jVar.d())) {
                aVar.k(b16, str, l3, null);
            }
            Logger.i("[qne]DefaultShiplyDelegate", "loadResource get " + str + " specific:" + l3 + " from cache:" + aVar.e(i3));
            jz3.e eVar2 = (jz3.e) i3;
            String str2 = eVar2.H;
            if (str2 == null) {
                str2 = eVar2.e();
            }
            return new e(PreloadStatusCode.NotNeedDownload.getValue(), "hit cache success", eVar2.f411266g, str2, aVar.m(eVar2.f411279t, l3));
        }
        if (aVar.d(jVar.d())) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            Logger.i("[qne]DefaultShiplyDelegate", "loadResource for " + str + " specific:" + l3 + " start");
            aVar.k(b16, str, l3, new b(str, l3, cancellableContinuationImpl, aVar));
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        e eVar3 = new e(PreloadStatusCode.CheckNetworkFail.getValue(), "check network failed", null, null, 0L, 28, null);
        Logger.w("[qne]DefaultShiplyDelegate", "loadResource get " + str + " specific:" + l3 + " failed, " + eVar3);
        return eVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long m(String str, Long l3) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        long j3 = 0;
        if (z16) {
            if (l3 == null) {
                return 0L;
            }
            return l3.longValue();
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            if (l3 != null) {
                j3 = l3.longValue();
            }
            return j3;
        }
    }

    @Override // com.tencent.qne.delegate.d
    @Nullable
    public Object a(@NotNull String str, @Nullable Long l3, @NotNull Continuation<? super e> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, str, l3, continuation);
        }
        return l(this, str, l3, continuation);
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appId;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.appKey;
    }

    @NotNull
    public final ResHubParams h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ResHubParams) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.params;
    }
}
