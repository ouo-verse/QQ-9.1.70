package com.tenpay.sdk.net.http.cookie;

import com.tenpay.sdk.net.core.cookie.PayCookieLogic;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/sdk/net/http/cookie/PayCookieJar;", "Lokhttp3/CookieJar;", "()V", "loadForRequest", "", "Lokhttp3/Cookie;", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "", "cookies", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayCookieJar implements CookieJar {
    @Override // okhttp3.CookieJar
    @NotNull
    public List<Cookie> loadForRequest(@NotNull HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return PayCookieLogic.INSTANCE.loadForRequest(url.host());
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(@NotNull HttpUrl url, @NotNull List<Cookie> cookies) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        PayCookieLogic.INSTANCE.saveFromResponse(url.host(), cookies);
    }
}
