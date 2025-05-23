package com.tencent.timi.game.api.cookie;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0016\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H&J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u000eH&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/timi/game/api/cookie/IQQLiveCookieApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSysCookie", "", "url", "getTbsCookie", "makeCookie", "Lcom/tencent/timi/game/api/cookie/QQLiveCookie;", "domain", "cookie", "Lkotlin/Pair;", "maxAge", "", "removeCookies", "", "cookieKeys", "", "setAcceptCookie", "accept", "", "setCookie", "sync", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface IQQLiveCookieApi extends QRouteApi {
    @Nullable
    String getSysCookie(@NotNull String url);

    @Nullable
    String getTbsCookie(@NotNull String url);

    @NotNull
    QQLiveCookie makeCookie(@NotNull String domain, @NotNull Pair<String, String> cookie, long maxAge);

    void removeCookies(@NotNull String domain, @NotNull List<String> cookieKeys);

    void setAcceptCookie(boolean accept);

    void setCookie(@NotNull String url, @NotNull String cookie);

    void sync();
}
