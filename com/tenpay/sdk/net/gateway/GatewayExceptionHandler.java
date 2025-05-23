package com.tenpay.sdk.net.gateway;

import com.tenpay.sdk.net.core.exception.EcdhTlsRetryException;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;
import pl2.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/sdk/net/gateway/GatewayExceptionHandler;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lpl2/o;", "callback", "", "handeException", "", "TAG", "Ljava/lang/String;", "KEY_IS_TLS_RETRY", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class GatewayExceptionHandler {

    @NotNull
    public static final GatewayExceptionHandler INSTANCE = new GatewayExceptionHandler();

    @NotNull
    private static final String KEY_IS_TLS_RETRY = "TLS_RETRY";

    @NotNull
    private static final String TAG = "GatewayExceptionHandler";

    GatewayExceptionHandler() {
    }

    public final boolean handeException(@NotNull Exception exception, @Nullable o<?> callback) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (!(exception instanceof EcdhTlsRetryException) || !(callback instanceof q)) {
            return false;
        }
        ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, TAG, "handle EcdhTlsRetryException and retry request", null, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(KEY_IS_TLS_RETRY, "1");
        ((q) callback).retry(linkedHashMap);
        return true;
    }
}
