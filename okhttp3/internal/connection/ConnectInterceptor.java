package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lokhttp3/internal/connection/ConnectInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class ConnectInterceptor implements Interceptor {

    @NotNull
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    ConnectInterceptor() {
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        return RealInterceptorChain.copy$okhttp$default(realInterceptorChain, 0, realInterceptorChain.getCall().initExchange$okhttp(realInterceptorChain), null, 0, 0, 0, 61, null).proceed(realInterceptorChain.getRequest());
    }
}
