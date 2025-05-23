package op3;

import com.tencent.smtt.sdk.CookieManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private CookieManager f423297a = CookieManager.getInstance();

    /* renamed from: b, reason: collision with root package name */
    private android.webkit.CookieManager f423298b = android.webkit.CookieManager.getInstance();

    public void a(boolean z16) {
        CookieManager cookieManager = this.f423297a;
        if (cookieManager != null) {
            cookieManager.setAcceptCookie(z16);
        }
        android.webkit.CookieManager cookieManager2 = this.f423298b;
        if (cookieManager2 != null) {
            cookieManager2.setAcceptCookie(z16);
        }
    }

    public void b(String str, String str2) {
        CookieManager cookieManager = this.f423297a;
        if (cookieManager != null) {
            cookieManager.setCookie(str, str2);
        }
        android.webkit.CookieManager cookieManager2 = this.f423298b;
        if (cookieManager2 != null) {
            cookieManager2.setCookie(str, str2);
        }
    }
}
