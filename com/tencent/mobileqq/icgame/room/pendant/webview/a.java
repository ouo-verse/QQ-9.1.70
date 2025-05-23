package com.tencent.mobileqq.icgame.room.pendant.webview;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/pendant/webview/a;", "", "", "accept", "", "a", "Landroid/webkit/CookieManager;", "kotlin.jvm.PlatformType", "b", "Landroid/webkit/CookieManager;", "sysCookieManager", "Landroid/webkit/CookieSyncManager;", "c", "Landroid/webkit/CookieSyncManager;", "sycCookieSycManager", "Lcom/tencent/smtt/sdk/CookieManager;", "d", "Lcom/tencent/smtt/sdk/CookieManager;", "tbsCookieManager", "Lcom/tencent/smtt/sdk/CookieSyncManager;", "e", "Lcom/tencent/smtt/sdk/CookieSyncManager;", "tbsCookieSycManager", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f237675a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CookieManager sysCookieManager = CookieManager.getInstance();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final CookieSyncManager sycCookieSycManager = CookieSyncManager.createInstance(MobileQQ.sMobileQQ);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.smtt.sdk.CookieManager tbsCookieManager = com.tencent.smtt.sdk.CookieManager.getInstance();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.smtt.sdk.CookieSyncManager tbsCookieSycManager = com.tencent.smtt.sdk.CookieSyncManager.createInstance(MobileQQ.sMobileQQ);

    a() {
    }

    public final void a(boolean accept) {
        sysCookieManager.setAcceptCookie(accept);
        tbsCookieManager.setAcceptCookie(accept);
    }
}
