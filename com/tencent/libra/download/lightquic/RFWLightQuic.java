package com.tencent.libra.download.lightquic;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.libra.download.LibraDns;
import com.tencent.lightquic.api.IRequestCallback;
import com.tencent.lightquic.api.LightQUICEngine;
import com.tencent.lightquic.api.LightQUICRequest;
import com.tencent.lightquic.api.LightQUICSceneId;
import com.tencent.mobileqq.msfcore.MSFKernel;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.net.InetAddress;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0015\u0010\u0016J.\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016R\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/libra/download/lightquic/RFWLightQuic;", "Lcom/tencent/libra/download/lightquic/a;", "", "url", "Lcom/tencent/lightquic/api/IRequestCallback;", "callback", "", "headers", "Lcom/tencent/lightquic/api/LightQUICRequest;", "a", Const.BUNDLE_KEY_REQUEST, "", "b", "Lcom/tencent/lightquic/api/LightQUICEngine;", "Lkotlin/Lazy;", "c", "()Lcom/tencent/lightquic/api/LightQUICEngine;", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/libra/download/LibraDns;", "Lcom/tencent/libra/download/LibraDns;", "libraDns", "<init>", "(Lcom/tencent/libra/download/LibraDns;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class RFWLightQuic implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy engine;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LibraDns libraDns;

    public RFWLightQuic(@NotNull LibraDns libraDns) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(libraDns, "libraDns");
        this.libraDns = libraDns;
        System.loadLibrary(MSFKernel.LIGHT_QUIC_LIB);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LightQUICEngine>() { // from class: com.tencent.libra.download.lightquic.RFWLightQuic$engine$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LightQUICEngine invoke() {
                return LightQUICEngine.INSTANCE.getInstance(LightQUICSceneId.SCENE_ID_SHORT_VIDEO_PHOTO);
            }
        });
        this.engine = lazy;
    }

    private final LightQUICEngine c() {
        return (LightQUICEngine) this.engine.getValue();
    }

    @Override // com.tencent.libra.download.lightquic.a
    @Nullable
    public LightQUICRequest a(@NotNull String url, @NotNull IRequestCallback callback, @NotNull Map<String, String> headers) {
        Object m476constructorimpl;
        Object lastOrNull;
        String hostAddress;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (RFWApplication.isDebug()) {
            RFWLog.d(MSFKernel.LIGHT_QUIC_LIB, RFWLog.USR, "QUIC quic start download: " + url);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(new URL(url).getHost());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) == null) {
            String host = (String) m476constructorimpl;
            LibraDns libraDns = this.libraDns;
            Intrinsics.checkNotNullExpressionValue(host, "host");
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) libraDns.lookup(host));
            InetAddress inetAddress = (InetAddress) lastOrNull;
            if (inetAddress != null && (hostAddress = inetAddress.getHostAddress()) != null) {
                LightQUICRequest createQUICRequest$default = LightQUICEngine.createQUICRequest$default(c(), url, hostAddress, headers, callback, null, 16, null);
                if (RFWApplication.isDebug()) {
                    RFWLog.d(MSFKernel.LIGHT_QUIC_LIB, RFWLog.USR, "QUIC quic request created: " + url);
                }
                createQUICRequest$default.startRequest();
                return createQUICRequest$default;
            }
            RFWLog.e(MSFKernel.LIGHT_QUIC_LIB, RFWLog.USR, "cannot resolve host for " + host);
            return null;
        }
        RFWLog.e(MSFKernel.LIGHT_QUIC_LIB, RFWLog.USR, "url invalid: " + url);
        return null;
    }

    @Override // com.tencent.libra.download.lightquic.a
    public void b(@NotNull LightQUICRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        request.cancelRequest();
    }
}
