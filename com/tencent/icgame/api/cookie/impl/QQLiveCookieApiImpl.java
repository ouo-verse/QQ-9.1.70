package com.tencent.icgame.api.cookie.impl;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.timi.game.api.cookie.IQQLiveCookieApi;
import com.tencent.timi.game.api.cookie.QQLiveCookie;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/icgame/api/cookie/impl/QQLiveCookieApiImpl;", "Lcom/tencent/timi/game/api/cookie/IQQLiveCookieApi;", "", "removeAllSysCookie", "", "domain", "Lkotlin/Pair;", "cookie", "", "maxAge", "makeCookieStr", "Lcom/tencent/timi/game/api/cookie/QQLiveCookie;", "makeCookie", "", "accept", "setAcceptCookie", "", "cookieKeys", "removeCookies", "url", "setCookie", "getSysCookie", "getTbsCookie", "sync", "Lcom/tencent/icgame/api/cookie/impl/b;", "cookieMgr$delegate", "Lkotlin/Lazy;", "getCookieMgr", "()Lcom/tencent/icgame/api/cookie/impl/b;", "cookieMgr", "<init>", "()V", "Companion", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class QQLiveCookieApiImpl implements IQQLiveCookieApi {

    @NotNull
    private static final String COOKIE_KEY_DOMAIN = "Domain";

    @NotNull
    private static final String COOKIE_KEY_EXPIRES = "Expires";

    @NotNull
    private static final String COOKIE_KEY_MAX_AGE = "Max-Age";

    @NotNull
    private static final String COOKIE_KEY_PATH = "Path";

    /* renamed from: cookieMgr$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy cookieMgr;

    public QQLiveCookieApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.icgame.api.cookie.impl.QQLiveCookieApiImpl$cookieMgr$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final b invoke() {
                return b.f114807a;
            }
        });
        this.cookieMgr = lazy;
    }

    private final b getCookieMgr() {
        return (b) this.cookieMgr.getValue();
    }

    private final String makeCookieStr(String domain, Pair<String, String> cookie, long maxAge) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(((Object) cookie.getFirst()) + ContainerUtils.KEY_VALUE_DELIMITER + ((Object) cookie.getSecond()) + ";");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Max-Age=");
        sb6.append(maxAge);
        sb6.append(";");
        sb5.append(sb6.toString());
        sb5.append("Domain=" + domain + ";");
        sb5.append("Path=/;");
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "result.toString()");
        return sb7;
    }

    private final void removeAllSysCookie() {
        b.f114807a.c();
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieApi
    @Nullable
    public String getSysCookie(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return b.f114807a.a(url);
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieApi
    @Nullable
    public String getTbsCookie(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return b.f114807a.b(url);
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieApi
    @NotNull
    public QQLiveCookie makeCookie(@NotNull String domain, @NotNull Pair<String, String> cookie, long maxAge) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return new QQLiveCookie(domain, makeCookieStr(domain, cookie, maxAge));
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieApi
    public void removeCookies(@NotNull String domain, @NotNull List<String> cookieKeys) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(cookieKeys, "cookieKeys");
        setAcceptCookie(true);
        Iterator<String> it = cookieKeys.iterator();
        while (it.hasNext()) {
            setCookie(domain, makeCookieStr(domain, TuplesKt.to(it.next(), ""), -1L));
        }
        sync();
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieApi
    public void setAcceptCookie(boolean accept) {
        b.f114807a.d(accept);
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieApi
    public void setCookie(@NotNull String url, @NotNull String cookie) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        b.f114807a.e(url, cookie);
    }

    @Override // com.tencent.timi.game.api.cookie.IQQLiveCookieApi
    public void sync() {
        b.f114807a.f();
    }
}
