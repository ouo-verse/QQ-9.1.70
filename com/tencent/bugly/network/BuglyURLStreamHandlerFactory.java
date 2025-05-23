package com.tencent.bugly.network;

import android.support.annotation.NonNull;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Hashtable;
import okhttp3.OkHttpClient;
import okhttp3.OkUrlFactory;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BuglyURLStreamHandlerFactory implements URLStreamHandlerFactory {
    private static final String TAG = "RMonitor_net_quality";
    private static Object old;
    private final OkUrlFactory urlFactory = new OkUrlFactory(new OkHttpClient.Builder().eventListenerFactory(BuglyListenerFactory.getInstance()).build());

    static Object getFactory() {
        String message;
        boolean z16;
        Object obj = null;
        try {
            Field declaredField = URL.class.getDeclaredField("factory");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            z16 = true;
            message = null;
            obj = obj2;
        } catch (IllegalAccessException e16) {
            message = e16.getMessage();
            z16 = false;
            Logger.f365497g.i(TAG, "getFactory, ret: " + z16 + ", factory: " + obj + ", errorMsg: " + message);
            return obj;
        } catch (NoSuchFieldException e17) {
            message = e17.getMessage();
            z16 = false;
            Logger.f365497g.i(TAG, "getFactory, ret: " + z16 + ", factory: " + obj + ", errorMsg: " + message);
            return obj;
        } catch (Throwable th5) {
            message = th5.getMessage();
            z16 = false;
            Logger.f365497g.i(TAG, "getFactory, ret: " + z16 + ", factory: " + obj + ", errorMsg: " + message);
            return obj;
        }
        Logger.f365497g.i(TAG, "getFactory, ret: " + z16 + ", factory: " + obj + ", errorMsg: " + message);
        return obj;
    }

    public static void init() {
        boolean updateHandlers;
        Object factory = getFactory();
        if (factory instanceof BuglyURLStreamHandlerFactory) {
            Logger.f365497g.i(TAG, "has inited before.");
            return;
        }
        old = factory;
        BuglyURLStreamHandlerFactory buglyURLStreamHandlerFactory = new BuglyURLStreamHandlerFactory();
        try {
            URL.setURLStreamHandlerFactory(buglyURLStreamHandlerFactory);
            Logger.f365497g.i(TAG, "setURLStreamHandlerFactory success.");
            updateHandlers = true;
        } catch (Throwable unused) {
            updateHandlers = updateHandlers(buglyURLStreamHandlerFactory);
        }
        Logger.f365497g.i(TAG, "init, " + updateHandlers);
    }

    public static void reset() {
        boolean resetFactory = resetFactory(old);
        old = null;
        Logger.f365497g.i(TAG, "reset, " + resetFactory);
    }

    static boolean resetFactory(Object obj) {
        String message;
        boolean z16;
        try {
            Field declaredField = URL.class.getDeclaredField("factory");
            declaredField.setAccessible(true);
            message = null;
            declaredField.set(null, obj);
            Field declaredField2 = URL.class.getDeclaredField("handlers");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(null);
            if (obj2 instanceof Hashtable) {
                ((Hashtable) obj2).clear();
            }
            z16 = true;
        } catch (IllegalAccessException e16) {
            message = e16.getMessage();
            z16 = false;
            Logger.f365497g.i(TAG, "resetFactory, ret: " + z16 + ", errorMsg: " + message);
            return z16;
        } catch (NoSuchFieldException e17) {
            message = e17.getMessage();
            z16 = false;
            Logger.f365497g.i(TAG, "resetFactory, ret: " + z16 + ", errorMsg: " + message);
            return z16;
        } catch (Throwable th5) {
            message = th5.getMessage();
            z16 = false;
            Logger.f365497g.i(TAG, "resetFactory, ret: " + z16 + ", errorMsg: " + message);
            return z16;
        }
        Logger.f365497g.i(TAG, "resetFactory, ret: " + z16 + ", errorMsg: " + message);
        return z16;
    }

    static boolean updateHandlers(@NonNull URLStreamHandlerFactory uRLStreamHandlerFactory) {
        String message;
        boolean z16;
        Object obj;
        try {
            Field declaredField = URL.class.getDeclaredField("handlers");
            declaredField.setAccessible(true);
            message = null;
            obj = declaredField.get(null);
        } catch (IllegalAccessException e16) {
            message = e16.getMessage();
        } catch (NoSuchFieldException e17) {
            message = e17.getMessage();
        } catch (Throwable th5) {
            message = th5.getMessage();
        }
        if (obj instanceof Hashtable) {
            Hashtable hashtable = (Hashtable) obj;
            hashtable.put("http", uRLStreamHandlerFactory.createURLStreamHandler("http"));
            hashtable.put("https", uRLStreamHandlerFactory.createURLStreamHandler("https"));
            z16 = true;
            Logger.f365497g.i(TAG, "updateHandlers, ret: " + z16 + ", errorMsg: " + message);
            return z16;
        }
        z16 = false;
        Logger.f365497g.i(TAG, "updateHandlers, ret: " + z16 + ", errorMsg: " + message);
        return z16;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String str) {
        return this.urlFactory.createURLStreamHandler(str);
    }
}
