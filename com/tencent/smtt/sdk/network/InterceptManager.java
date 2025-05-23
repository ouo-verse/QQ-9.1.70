package com.tencent.smtt.sdk.network;

import android.text.TextUtils;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.smtt.sdk.config.FeatureConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Hashtable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class InterceptManager implements b {
    public static final String HTTP = "http";
    public static final String HTTPS = "https";

    /* renamed from: a, reason: collision with root package name */
    private static InterceptManager f369447a;

    /* renamed from: b, reason: collision with root package name */
    private a f369448b;

    /* renamed from: c, reason: collision with root package name */
    private URLStreamHandler f369449c = null;

    /* renamed from: d, reason: collision with root package name */
    private URLStreamHandler f369450d = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f369451e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f369452f = false;

    /* renamed from: g, reason: collision with root package name */
    private InterceptExternalClient f369453g = null;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements URLStreamHandlerFactory {
        a() {
        }

        @Override // java.net.URLStreamHandlerFactory
        public URLStreamHandler createURLStreamHandler(String str) {
            if (!str.equals("http") && !str.equals("https")) {
                return null;
            }
            return c.a(str, InterceptManager.this);
        }
    }

    InterceptManager() {
        this.f369448b = null;
        this.f369448b = new a();
    }

    private static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        if (obj == null) {
            f.b("invokeObjectMethod object is null.");
            return null;
        }
        try {
            Method a16 = a(obj.getClass(), str, clsArr);
            if (a16 != null) {
                a16.setAccessible(true);
                if (objArr.length == 0) {
                    return a16.invoke(obj, new Object[0]);
                }
                return a16.invoke(obj, objArr);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return null;
    }

    public static InterceptManager getInstance() {
        InterceptManager interceptManager = f369447a;
        if (interceptManager != null) {
            return interceptManager;
        }
        synchronized (InterceptManager.class) {
            if (f369447a == null) {
                f369447a = new InterceptManager();
            }
        }
        return f369447a;
    }

    public void addExcludeInterceptUrlPostfix(String str) {
        g.a().c(str);
    }

    public void addInterceptUrl(String str) {
        g.a().b(str);
    }

    public void excludeInterceptUrl(String str) {
        g.a().a(str);
    }

    public URLConnection intercept(URL url) throws IOException {
        if (this.f369452f) {
            f.b("intercept: already set URLStreamHandlerFactory, can't call this function. url:" + url.toString());
        } else if (isInInterceptList(url)) {
            f.a("intercept: url is intercept. url:" + url.toString());
            return new d(url);
        }
        f.a("intercept: url is not intercept. url:" + url.toString());
        return null;
    }

    public boolean isInExcludeInterceptList(URL url) {
        return g.a().e(url.toString());
    }

    public boolean isInInterceptList(URL url) {
        return g.a().d(url.toString());
    }

    @Override // com.tencent.smtt.sdk.network.b
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        URLStreamHandler uRLStreamHandler;
        Object obj;
        if (url == null) {
            f.b("openConnection url is null.");
            return null;
        }
        String protocol2 = url.getProtocol();
        if (protocol2.equals("http")) {
            uRLStreamHandler = this.f369449c;
        } else if (protocol2.equals("https")) {
            uRLStreamHandler = this.f369450d;
        } else {
            uRLStreamHandler = null;
        }
        if (uRLStreamHandler != null) {
            if (proxy == null) {
                obj = a(uRLStreamHandler, "openConnection", new Class[]{URL.class}, url);
            } else {
                obj = a(uRLStreamHandler, "openConnection", new Class[]{URL.class, Proxy.class}, url, proxy);
            }
        } else {
            obj = null;
        }
        if (obj == null || !(obj instanceof URLConnection)) {
            return null;
        }
        return (URLConnection) obj;
    }

    public void setInterceptExternalClient(InterceptExternalClient interceptExternalClient) {
        this.f369453g = interceptExternalClient;
    }

    public boolean setURLStreamHandler() {
        if (!FeatureConfig.isNetworkInterceptEnable()) {
            return false;
        }
        if (this.f369451e) {
            f.b("had setURLStreamHandler already.");
            return this.f369452f;
        }
        this.f369451e = true;
        try {
            URL url = new URL(VideoProxy.PROXY_SERVER);
            URL url2 = new URL("https://127.0.0.1");
            if (a(url) != null) {
                f.b("URLStreamHandlerFactory had set.");
                return false;
            }
            this.f369449c = a(url, "http");
            this.f369450d = a(url2, "https");
            URL.setURLStreamHandlerFactory(this.f369448b);
            if (this.f369449c != null && this.f369450d != null && this.f369448b == a(url)) {
                this.f369452f = true;
                f.a("setURLStreamHandler sucess");
            }
            return this.f369452f;
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.smtt.sdk.network.b
    public boolean shouldIntercept(URL url) {
        if (this.f369452f) {
            InterceptExternalClient interceptExternalClient = this.f369453g;
            if (interceptExternalClient != null) {
                return interceptExternalClient.shouldIntercept(url);
            }
            if (isInInterceptList(url)) {
                f.a("shouldIntercept:url is intercepted. url:" + url.toString());
                return true;
            }
            if (!isInExcludeInterceptList(url) && InterceptConfig.getInterceptAllForTest()) {
                f.a("shouldIntercept:url is intercepted by InterceptAllForTest flag. url:" + url.toString());
                return true;
            }
            f.a("shouldIntercept:not in Intercept list. url:" + url.toString());
            return false;
        }
        f.a("shouldIntercept:not set URLStreamHandlerFactory. url:" + url.toString());
        return false;
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            f.b("getMethodFromObject class is null.");
            return null;
        }
        while (cls != Object.class) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Throwable unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    private static URLStreamHandler a(URL url, String str) {
        if (url != null && !TextUtils.isEmpty(str)) {
            Hashtable hashtable = (Hashtable) a(url, (Class<?>) Hashtable.class);
            if (hashtable != null) {
                Object obj = hashtable.get(str);
                if (obj instanceof URLStreamHandler) {
                    return (URLStreamHandler) obj;
                }
                f.b("getURLStreamHandler: object:" + obj);
            } else {
                f.b("getURLStreamHandler:table is null");
            }
            return null;
        }
        f.b("protocol is empty.");
        return null;
    }

    private static URLStreamHandlerFactory a(URL url) {
        return (URLStreamHandlerFactory) a(url, (Class<?>) URLStreamHandlerFactory.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Object a(Object obj, Class<?> cls) {
        Field field;
        if (obj != null && cls != null) {
            try {
                Field[] declaredFields = obj.getClass().getDeclaredFields();
                if (declaredFields != null) {
                    field = null;
                    for (int i3 = 0; i3 < declaredFields.length; i3++) {
                        try {
                            declaredFields[i3].setAccessible(true);
                            f.a("getFiledObject: filed[" + i3 + "]:name:" + declaredFields[i3].getName() + ",class:" + declaredFields[i3].getClass());
                            if (cls.isInstance(declaredFields[i3].get(obj))) {
                                if (field != null) {
                                    f.b("find multi-" + cls.getName() + ", last-name:" + field.getName() + ", cur-name:" + declaredFields[i3].getName() + ", from:" + obj.getClass().getName());
                                    return null;
                                }
                                field = declaredFields[i3];
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            th.printStackTrace();
                            if (field != null) {
                            }
                            return null;
                        }
                    }
                } else {
                    field = null;
                }
            } catch (Throwable th6) {
                th = th6;
                field = null;
            }
            if (field != null) {
                field.setAccessible(true);
                try {
                    return field.get(obj);
                } catch (Throwable th7) {
                    th7.printStackTrace();
                }
            }
            return null;
        }
        f.b("objectToGetField or fieldClass is null.");
        return null;
    }
}
