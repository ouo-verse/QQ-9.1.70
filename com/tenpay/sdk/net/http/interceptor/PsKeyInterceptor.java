package com.tenpay.sdk.net.http.interceptor;

import com.tenpay.sdk.net.core.processor.PsKeyProcessor;
import com.tenpay.sdk.net.http.request.CgiBizData;
import com.tenpay.sdk.net.http.request.HttpRequest;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tenpay/sdk/net/http/interceptor/PsKeyInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PsKeyInterceptor implements Interceptor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "QWalletHttp-PsKey";

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/sdk/net/http/interceptor/PsKeyInterceptor$Companion;", "", "()V", "TAG", "", "isPsKeyEmpty", "", "httpRequest", "Lcom/tenpay/sdk/net/http/request/HttpRequest;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isPsKeyEmpty(@Nullable HttpRequest httpRequest) {
            Object obj;
            List<Object> tagList;
            String str = null;
            if (httpRequest != null && (tagList = httpRequest.getTagList()) != null) {
                Iterator<T> it = tagList.iterator();
                while (it.hasNext()) {
                    obj = it.next();
                    if (obj instanceof CgiBizData) {
                        break;
                    }
                }
            }
            obj = null;
            CgiBizData cgiBizData = (CgiBizData) obj;
            if (cgiBizData != null) {
                str = cgiBizData.getPsKey();
            }
            if (str != null && str.length() != 0) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        String url = chain.request().url().url().toString();
        Intrinsics.checkNotNullExpressionValue(url, "chain.request().url.toUrl().toString()");
        CgiBizData cgiBizData = (CgiBizData) chain.request().tag(CgiBizData.class);
        if (cgiBizData != null) {
            cgiBizData.setPsKey(PsKeyProcessor.INSTANCE.getPsKey(url));
        }
        return chain.proceed(chain.request());
    }
}
