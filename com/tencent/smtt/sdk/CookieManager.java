package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CookieManager {
    public static String LOGTAG = "CookieManager";

    /* renamed from: c, reason: collision with root package name */
    private static CookieManager f368944c;

    /* renamed from: a, reason: collision with root package name */
    CopyOnWriteArrayList<b> f368945a;

    /* renamed from: b, reason: collision with root package name */
    a f368946b = a.MODE_NONE;

    /* renamed from: d, reason: collision with root package name */
    private boolean f368947d = false;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f368952a;

        /* renamed from: b, reason: collision with root package name */
        String f368953b;

        /* renamed from: c, reason: collision with root package name */
        String f368954c;

        /* renamed from: d, reason: collision with root package name */
        ValueCallback<Boolean> f368955d;

        b() {
        }
    }

    CookieManager() {
    }

    public static boolean checkSysCoreNotExist() {
        SystemCoreProtector f16 = QbSdk.f();
        if (f16 != null) {
            try {
                android.webkit.CookieManager.getInstance();
                return false;
            } catch (Exception e16) {
                f16.onCookieManagerException(e16);
                return true;
            }
        }
        return false;
    }

    public static CookieManager getInstance() {
        if (f368944c == null) {
            synchronized (CookieManager.class) {
                if (f368944c == null) {
                    f368944c = new CookieManager();
                }
            }
            Log.i(LOGTAG, Log.getStackTraceString(new Throwable()));
        }
        return f368944c;
    }

    public static int getROMCookieDBVersion(Context context) {
        return context.getSharedPreferences("cookiedb_info", 4).getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i3) {
        SharedPreferences.Editor edit = context.getSharedPreferences("cookiedb_info", 4).edit();
        edit.putInt("db_version", i3);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f368945a;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            p a16 = p.a();
            if (a16 != null && a16.b()) {
                Iterator<b> it = this.f368945a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    int i3 = next.f368952a;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            setCookie(next.f368953b, next.f368954c);
                        }
                    } else {
                        setCookie(next.f368953b, next.f368954c, next.f368955d);
                    }
                }
            } else {
                Iterator<b> it5 = this.f368945a.iterator();
                while (it5.hasNext()) {
                    b next2 = it5.next();
                    int i16 = next2.f368952a;
                    if (i16 != 1) {
                        if (i16 == 2) {
                            if (checkSysCoreNotExist()) {
                                return;
                            } else {
                                android.webkit.CookieManager.getInstance().setCookie(next2.f368953b, next2.f368954c);
                            }
                        }
                    } else if (checkSysCoreNotExist()) {
                        return;
                    } else {
                        com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "setCookie", (Class<?>[]) new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, next2.f368953b, next2.f368954c, next2.f368955d);
                    }
                }
            }
            this.f368945a.clear();
        }
    }

    public boolean acceptCookie() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().d();
        }
        if (checkSysCoreNotExist()) {
            return false;
        }
        return android.webkit.CookieManager.getInstance().acceptCookie();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            Object invokeStaticMethod = a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            if (invokeStaticMethod == null) {
                return true;
            }
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        if (checkSysCoreNotExist()) {
            return false;
        }
        Object a17 = com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", (Class<?>[]) new Class[]{android.webkit.WebView.class}, webView.getView());
        if (a17 == null) {
            return false;
        }
        return ((Boolean) a17).booleanValue();
    }

    public void flush() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else {
            if (checkSysCoreNotExist()) {
                return;
            }
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), HippyQQPagView.FunctionName.FLUSH, (Class<?>[]) new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            Log.i(LOGTAG, "getX5cookie");
            return a16.c().a(str);
        }
        Log.i(LOGTAG, "getSyscookie");
        if (checkSysCoreNotExist()) {
            return null;
        }
        try {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public boolean hasCookies() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().h();
        }
        if (checkSysCoreNotExist()) {
            return false;
        }
        return android.webkit.CookieManager.getInstance().hasCookies();
    }

    @Deprecated
    public void removeAllCookie() {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f368945a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().e();
        } else {
            if (checkSysCoreNotExist()) {
                return;
            }
            android.webkit.CookieManager.getInstance().removeAllCookie();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f368945a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            if (checkSysCoreNotExist()) {
                return;
            }
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", (Class<?>[]) new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    @Deprecated
    public void removeExpiredCookie() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        } else {
            if (checkSysCoreNotExist()) {
                return;
            }
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        }
    }

    @Deprecated
    public void removeSessionCookie() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        } else {
            if (checkSysCoreNotExist()) {
                return;
            }
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            if (checkSysCoreNotExist()) {
                return;
            }
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", (Class<?>[]) new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public synchronized void setAcceptCookie(boolean z16) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        } else {
            try {
                if (checkSysCoreNotExist()) {
                } else {
                    android.webkit.CookieManager.getInstance().setAcceptCookie(z16);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z16) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z16));
        } else if (checkSysCoreNotExist()) {
        } else {
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", (Class<?>[]) new Class[]{android.webkit.WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z16));
        }
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    public void setCookies(Map<String, String[]> map) {
        boolean z16;
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            z16 = a16.c().a(map);
        } else {
            z16 = false;
        }
        if (!z16) {
            for (String str : map.keySet()) {
                for (String str2 : map.get(str)) {
                    setCookie(str, str2);
                }
            }
        }
    }

    public synchronized void setCookie(String str, String str2, boolean z16) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            q c16 = a16.c();
            if (c16 != null) {
                Log.i(LOGTAG, "setX5Cookie");
                c16.b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
            }
            if (WebView.hasCreatedSysWebViewInstance() || QbSdk.f368992b) {
                if (checkSysCoreNotExist()) {
                } else {
                    android.webkit.CookieManager.getInstance().setCookie(str, str2);
                }
            }
        } else {
            if (!p.a().d()) {
                b bVar = new b();
                bVar.f368952a = 2;
                bVar.f368953b = str;
                bVar.f368954c = str2;
                bVar.f368955d = null;
                if (this.f368945a == null) {
                    this.f368945a = new CopyOnWriteArrayList<>();
                }
                this.f368945a.add(bVar);
            }
            if (checkSysCoreNotExist()) {
            } else {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
        }
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
        } else {
            if (!a16.d()) {
                b bVar = new b();
                bVar.f368952a = 1;
                bVar.f368953b = str;
                bVar.f368954c = str2;
                bVar.f368955d = valueCallback;
                if (this.f368945a == null) {
                    this.f368945a = new CopyOnWriteArrayList<>();
                }
                this.f368945a.add(bVar);
            }
            if (checkSysCoreNotExist()) {
            } else {
                com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "setCookie", (Class<?>[]) new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
            }
        }
    }
}
