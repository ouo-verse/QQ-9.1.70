package com.tencent.icgame.api.cookie.impl;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0005R\u001c\u0010\u0011\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\u001c\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u001c\u0010\u0017\u001a\n \u000f*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/icgame/api/cookie/impl/b;", "", "", "url", "cookie", "", "e", "a", "b", "c", "", "accept", "d", "f", "Landroid/webkit/CookieManager;", "kotlin.jvm.PlatformType", "Landroid/webkit/CookieManager;", "sysCookieManager", "Landroid/webkit/CookieSyncManager;", "Landroid/webkit/CookieSyncManager;", "sycCookieSycManager", "Lcom/tencent/smtt/sdk/CookieManager;", "Lcom/tencent/smtt/sdk/CookieManager;", "tbsCookieManager", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f114807a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CookieManager sysCookieManager = CookieManager.getInstance();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CookieSyncManager sycCookieSycManager = CookieSyncManager.createInstance(MobileQQ.sMobileQQ);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.smtt.sdk.CookieManager tbsCookieManager = com.tencent.smtt.sdk.CookieManager.getInstance();

    b() {
    }

    @Nullable
    public final String a(@Nullable String url) {
        if (url != null) {
            return sysCookieManager.getCookie(url);
        }
        return "";
    }

    @Nullable
    public final String b(@Nullable String url) {
        if (url != null) {
            return tbsCookieManager.getCookie(url);
        }
        return "";
    }

    public final void c() {
        sysCookieManager.removeAllCookies(null);
    }

    public final void d(boolean accept) {
        sysCookieManager.setAcceptCookie(accept);
        tbsCookieManager.setAcceptCookie(accept);
    }

    public final void e(@Nullable String url, @Nullable String cookie) {
        if (url != null) {
            sysCookieManager.setCookie(url, cookie);
            tbsCookieManager.setCookie(url, cookie);
        }
    }

    public final void f() {
        sysCookieManager.flush();
        com.tencent.smtt.sdk.CookieSyncManager.createInstance(MobileQQ.sMobileQQ);
        com.tencent.smtt.sdk.CookieSyncManager.getInstance().sync();
    }
}
