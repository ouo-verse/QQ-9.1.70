package com.tencent.mobileqq.qroute;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.QPlugin;
import com.tencent.mobileqq.qroute.exception.QRoutePluginException;
import java.lang.annotation.Annotation;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Class<?>, Object> f276432a;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class<?>, Object> f276433b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7574);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276432a = new ConcurrentHashMap<>(9000);
            f276433b = new ConcurrentHashMap<>(9000);
        }
    }

    static com.tencent.mobileqq.qroute.module.a a(Class cls) {
        String str;
        Annotation annotation = cls.getAnnotation(QPlugin.class);
        if (annotation instanceof QPlugin) {
            str = ((QPlugin) annotation).name();
            if (QRoute.mConfig.isForceCheck() && TextUtils.isEmpty(str)) {
                StringBuilder sb5 = new StringBuilder(50);
                sb5.append(QRoute.TAG_QROUTE_API);
                sb5.append(cls.getSimpleName());
                sb5.append(" \u63a5\u53e3\u58f0\u660e\u7684QRoute\u4e0d\u80fd\u4e3a\u7a7a\uff0c\u5fc5\u987b\u58f0\u660e\u4e3a\u5bf9\u5e94\u7684\u6a21\u5757id ");
                sb5.append("  \n");
                throw new IllegalStateException(sb5.toString());
            }
        } else {
            str = null;
        }
        return QRoute.plugin(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <T> T b(Class<T> cls, String str, boolean z16) {
        if (cls != null && str != null && str.length() != 0) {
            try {
                T t16 = (T) c(cls, str, z16);
                if (t16 != null) {
                    return t16;
                }
                throw new IllegalStateException("getInstance null! @" + str);
            } catch (Exception e16) {
                com.tencent.mobileqq.qroute.utils.a.c();
                String str2 = "build API fatal:" + cls.getSimpleName() + " " + e16.toString();
                QRoute.logger.b("SingletonPool", str2, e16);
                throw new IllegalStateException(str2, e16);
            }
        }
        throw new IllegalStateException("args null! ");
    }

    @Nullable
    private static Object c(Class<?> cls, String str, boolean z16) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ConcurrentHashMap<Class<?>, Object> concurrentHashMap = f276432a;
        Object obj = concurrentHashMap.get(cls);
        if (obj == null) {
            ConcurrentHashMap<Class<?>, Object> concurrentHashMap2 = f276433b;
            if (concurrentHashMap2.get(cls) == null) {
                synchronized (concurrentHashMap2) {
                    if (concurrentHashMap2.get(cls) == null) {
                        concurrentHashMap2.put(cls, new Object());
                    }
                }
            }
            synchronized (concurrentHashMap2.get(cls)) {
                obj = concurrentHashMap.get(cls);
                if (obj == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (com.tencent.mobileqq.qroute.utils.a.b(str)) {
                        Object newInstance = e(cls, str, z16).newInstance();
                        if (newInstance != null) {
                            concurrentHashMap.put(cls, newInstance);
                        }
                        com.tencent.mobileqq.qroute.utils.a.a(str);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 10) {
                            QRoute.logger.a("SingletonPool", "create " + str + " cost:" + currentTimeMillis2);
                        }
                        obj = newInstance;
                    } else {
                        com.tencent.mobileqq.qroute.utils.a.c();
                        String str2 = "find cycle init from:" + str;
                        QRoute.logger.a("SingletonPool", str2);
                        throw new IllegalStateException(str2);
                    }
                }
            }
        }
        return obj;
    }

    private static Class d(Class cls, String str) throws QRoutePluginException {
        com.tencent.mobileqq.qroute.module.a a16 = a(cls);
        if (a16 != null) {
            if (a16.i()) {
                if (a16.b()) {
                    try {
                        Class c16 = a16.c(str);
                        if (c16 != null) {
                            return c16;
                        }
                        StringBuilder sb5 = new StringBuilder(50);
                        sb5.append(QRoute.TAG_QROUTE_API);
                        sb5.append(str);
                        sb5.append(" ClassNotFound in plugin=");
                        sb5.append(a16);
                        sb5.append(" \n");
                        throw new QRoutePluginException(sb5.toString());
                    } catch (Exception e16) {
                        throw new QRoutePluginException(e16);
                    }
                }
                StringBuilder sb6 = new StringBuilder(50);
                sb6.append(QRoute.TAG_QROUTE_API);
                sb6.append(cls.getSimpleName());
                sb6.append(" plugin not installed ");
                sb6.append(a16);
                sb6.append(" you may call QRoute.plugin(plugin).install() first before you call QRoute.apiFromPlugin) \n");
                throw new QRoutePluginException(sb6.toString());
            }
            QRoute.logger.a(QRoute.TAG, " plugin no exist: " + a16.h());
            StringBuilder sb7 = new StringBuilder(50);
            sb7.append(QRoute.TAG_QROUTE_API);
            sb7.append(cls.getSimpleName());
            sb7.append(" plugin no exist: ");
            sb7.append(a16.h());
            sb7.append(" you may create plugin \n");
            throw new QRoutePluginException(sb7.toString());
        }
        StringBuilder sb8 = new StringBuilder(50);
        sb8.append(QRoute.TAG_QROUTE_API);
        sb8.append(cls.getSimpleName());
        sb8.append(" your api class need @QPlugin(name='{pluginId}') ");
        sb8.append(a16.h());
        throw new QRoutePluginException(sb8.toString());
    }

    static Class e(Class cls, String str, boolean z16) throws ClassNotFoundException {
        if (z16) {
            return d(cls, str);
        }
        return Class.forName(str);
    }
}
