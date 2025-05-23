package com.tencent.smtt.sdk;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class URLUtil {
    public static String composeSearchUrl(String str, String str2, String str3) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().a(str, str2, str3);
        }
        return android.webkit.URLUtil.composeSearchUrl(str, str2, str3);
    }

    public static byte[] decode(byte[] bArr) throws IllegalArgumentException {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().a(bArr);
        }
        return android.webkit.URLUtil.decode(bArr);
    }

    public static final String guessFileName(String str, String str2, String str3) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().b(str, str2, str3);
        }
        return android.webkit.URLUtil.guessFileName(str, str2, str3);
    }

    public static String guessUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().m(str);
        }
        return android.webkit.URLUtil.guessUrl(str);
    }

    public static boolean isAboutUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().q(str);
        }
        return android.webkit.URLUtil.isAboutUrl(str);
    }

    public static boolean isAssetUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().n(str);
        }
        return android.webkit.URLUtil.isAssetUrl(str);
    }

    public static boolean isContentUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().w(str);
        }
        return android.webkit.URLUtil.isContentUrl(str);
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().o(str);
        }
        return android.webkit.URLUtil.isCookielessProxyUrl(str);
    }

    public static boolean isDataUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().r(str);
        }
        return android.webkit.URLUtil.isDataUrl(str);
    }

    public static boolean isFileUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().p(str);
        }
        return android.webkit.URLUtil.isFileUrl(str);
    }

    public static boolean isHttpUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().t(str);
        }
        return android.webkit.URLUtil.isHttpUrl(str);
    }

    public static boolean isHttpsUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().u(str);
        }
        return android.webkit.URLUtil.isHttpsUrl(str);
    }

    public static boolean isJavaScriptUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().s(str);
        }
        return android.webkit.URLUtil.isJavaScriptUrl(str);
    }

    public static boolean isNetworkUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().v(str);
        }
        return android.webkit.URLUtil.isNetworkUrl(str);
    }

    public static boolean isValidUrl(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().x(str);
        }
        return android.webkit.URLUtil.isValidUrl(str);
    }

    public static String stripAnchor(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().y(str);
        }
        return android.webkit.URLUtil.stripAnchor(str);
    }
}
