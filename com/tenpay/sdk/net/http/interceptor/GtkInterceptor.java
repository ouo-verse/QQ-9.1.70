package com.tenpay.sdk.net.http.interceptor;

import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.processor.PsKeyProcessor;
import com.tenpay.sdk.net.http.request.CgiBizData;
import com.tenpay.sdk.net.utils.PayNetUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/sdk/net/http/interceptor/GtkInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIntercept", "", "url", "", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class GtkInterceptor implements Interceptor {

    @NotNull
    public static final String TAG = "QWalletHttp-Gtk";

    private final boolean shouldIntercept(String url) {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "qpayment_trans_detail.cgi", false, 2, (Object) null);
        if (!contains$default) {
            return false;
        }
        return true;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Map<String, String> extraData;
        Intrinsics.checkNotNullParameter(chain, "chain");
        String url = chain.request().url().url().toString();
        Intrinsics.checkNotNullExpressionValue(url, "chain.request().url.toUrl().toString()");
        if (shouldIntercept(url)) {
            String menShenGtk = PayNetUtil.INSTANCE.getMenShenGtk(PsKeyProcessor.INSTANCE.getPsKey(url));
            CgiBizData cgiBizData = (CgiBizData) chain.request().tag(CgiBizData.class);
            if (cgiBizData != null && (extraData = cgiBizData.getExtraData()) != null) {
                extraData.put("g_tk", menShenGtk);
            }
            QLog.i(TAG, 1, "insert gtk: " + menShenGtk);
        }
        return chain.proceed(chain.request());
    }
}
