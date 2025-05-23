package ev;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile C10267a f397180a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f397181b;

    /* compiled from: P */
    /* renamed from: ev.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    static class C10267a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private Object f397182a;

        C10267a() {
        }

        public Object a(Class<?> cls) {
            if (this.f397182a == null) {
                this.f397182a = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
            }
            return this.f397182a;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if (method.getName().equals("onChanged") && objArr != null && objArr.length >= 1) {
                    QLog.d("OlkApi", 1, "MyHandler onChanged " + objArr.length);
                    Bundle bundle = (Bundle) objArr[0];
                    String string = bundle.getString("function");
                    if (string.equals("network_score")) {
                        QLog.d("OlkApi", 1, "score:" + bundle.getInt(LocalPhotoFaceInfo.SCORE) + ",better" + bundle.getBoolean("better"));
                    } else if (string.equals("preload")) {
                        boolean z16 = bundle.getBoolean("enable");
                        int i3 = bundle.getInt("before_enter");
                        int i16 = bundle.getInt("before_exit");
                        QLog.d("OlkApi", 1, "preload return " + z16 + "," + i3 + "," + i16);
                        a.f397181b.a(z16, i3, i16);
                    } else {
                        QLog.d("OlkApi", 1, "unknown function " + string);
                    }
                } else {
                    if (method.getName().equals("equals") && objArr != null && objArr.length >= 1) {
                        if (objArr[0] == null) {
                            return Boolean.FALSE;
                        }
                        return Boolean.valueOf(objArr.hashCode() == objArr[0].hashCode());
                    }
                    if (method.getName().equals("hashCode")) {
                        return Integer.valueOf(hashCode());
                    }
                    if (String.class == method.getReturnType()) {
                        return "";
                    }
                    if (Integer.class != method.getReturnType() && Integer.TYPE != method.getReturnType()) {
                        if (Boolean.class == method.getReturnType()) {
                            return Boolean.FALSE;
                        }
                        if (Boolean.TYPE == method.getReturnType()) {
                            return Boolean.FALSE;
                        }
                    }
                    return 0;
                }
                return null;
            } catch (Exception e16) {
                QLog.d("OlkApi", 1, "exception:" + e16.getMessage());
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface b {
        void a(boolean z16, int i3, int i16);
    }

    public static int b(Context context, String str, String str2, int i3, int i16, int i17) {
        try {
            Class<?> cls = Class.forName("com.oplus.network.OlkManager");
            Method method = cls.getMethod("getInstance", Context.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, context);
            Method method2 = cls.getMethod(Const.BUNDLE_KEY_REQUEST, Bundle.class);
            method2.setAccessible(true);
            Bundle bundle = new Bundle();
            bundle.putString("function", "clearSocketPriority");
            bundle.putString("srcip", str);
            bundle.putString("dstip", str2);
            bundle.putInt("srcport", i3);
            bundle.putInt("dstport", i16);
            bundle.putInt(AudienceReportConst.PROTOCOL, i17);
            Bundle bundle2 = (Bundle) method2.invoke(invoke, bundle);
            if (bundle2 == null) {
                QLog.d("OlkApi", 1, "result is null");
                return -1;
            }
            QLog.d("OlkApi", 1, "clearSocketPriority result: " + bundle2.getInt("result"));
            return bundle2.getInt("result");
        } catch (Exception e16) {
            QLog.d("OlkApi", 1, "exception:" + e16.getMessage());
            return -1;
        }
    }

    public static Pair<Integer, Integer> c(Context context) {
        try {
            Class<?> cls = Class.forName("com.oplus.network.OlkManager");
            Method method = cls.getMethod("getInstance", Context.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, context);
            Method method2 = cls.getMethod(Const.BUNDLE_KEY_REQUEST, Bundle.class);
            method2.setAccessible(true);
            Bundle bundle = new Bundle();
            bundle.putString("function", "getSysCapabilities");
            Bundle bundle2 = (Bundle) method2.invoke(invoke, bundle);
            if (bundle2 == null) {
                QLog.d("OlkApi", 1, "result is null");
                return new Pair<>(-1, 0);
            }
            return new Pair<>(Integer.valueOf(bundle2.getInt("result", -1)), Integer.valueOf(bundle2.getInt("capabilities")));
        } catch (Exception e16) {
            QLog.d("OlkApi", 1, "exception:" + e16.getMessage());
            return new Pair<>(-1, 0);
        }
    }

    public static void d(Context context, b bVar) {
        try {
            f397181b = bVar;
            Class<?> cls = Class.forName("com.oplus.network.OlkManager");
            Class<?> cls2 = Class.forName("com.oplus.network.OlkManager$IOlkCallback");
            Method method = cls.getMethod("getInstance", Context.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, context);
            f397180a = new C10267a();
            Object a16 = f397180a.a(cls2);
            Method declaredMethod = cls.getDeclaredMethod("registerCallback", Integer.TYPE, cls2);
            declaredMethod.setAccessible(true);
            QLog.d("OlkApi", 1, "registerCb return " + ((Integer) declaredMethod.invoke(invoke, 3, a16)).intValue());
        } catch (Exception e16) {
            QLog.d("OlkApi", 1, "registerCb failed!" + e16.getMessage());
        }
    }

    public static int e(Context context, int i3, int i16) {
        try {
            Class<?> cls = Class.forName("com.oplus.network.OlkManager");
            Method method = cls.getMethod("getInstance", Context.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, context);
            Method method2 = cls.getMethod(Const.BUNDLE_KEY_REQUEST, Bundle.class);
            method2.setAccessible(true);
            Bundle bundle = new Bundle();
            bundle.putString("function", "setApBandwidth");
            bundle.putInt("rxBw", i3);
            bundle.putInt("txBw", i16);
            Bundle bundle2 = (Bundle) method2.invoke(invoke, bundle);
            if (bundle2 == null) {
                QLog.d("OlkApi", 1, "result is null");
                return -1;
            }
            QLog.d("OlkApi", 1, "setNeedBw result: " + bundle2.getInt("result"));
            return bundle2.getInt("result");
        } catch (Exception e16) {
            QLog.d("OlkApi", 1, "exception:" + e16.getMessage());
            return -1;
        }
    }

    public static int f(Context context, int i3) {
        try {
            Class<?> cls = Class.forName("com.oplus.network.OlkManager");
            Method method = cls.getMethod("getInstance", Context.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, context);
            Method method2 = cls.getMethod(Const.BUNDLE_KEY_REQUEST, Bundle.class);
            method2.setAccessible(true);
            Bundle bundle = new Bundle();
            bundle.putString("function", "setRealTimeEvent");
            bundle.putInt("event", i3);
            Bundle bundle2 = (Bundle) method2.invoke(invoke, bundle);
            if (bundle2 == null) {
                QLog.d("OlkApi", 1, "result is null");
                return -1;
            }
            QLog.d("OlkApi", 1, "setRealTimeEvent result: " + bundle2.getInt("result"));
            return bundle2.getInt("result");
        } catch (Exception e16) {
            QLog.d("OlkApi", 1, "exception:" + e16.getMessage());
            return -1;
        }
    }

    public static int g(Context context, String str, String str2, int i3, int i16, int i17) {
        try {
            Class<?> cls = Class.forName("com.oplus.network.OlkManager");
            Method method = cls.getMethod("getInstance", Context.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, context);
            Method method2 = cls.getMethod(Const.BUNDLE_KEY_REQUEST, Bundle.class);
            method2.setAccessible(true);
            Bundle bundle = new Bundle();
            bundle.putString("function", "setSocketPriority");
            bundle.putString("srcip", str);
            bundle.putString("dstip", str2);
            bundle.putInt("srcport", i3);
            bundle.putInt("dstport", i16);
            bundle.putInt(AudienceReportConst.PROTOCOL, i17);
            bundle.putInt("tag", 1);
            bundle.putInt("priority", 1);
            Bundle bundle2 = (Bundle) method2.invoke(invoke, bundle);
            if (bundle2 == null) {
                QLog.d("OlkApi", 1, "result is null");
                return -1;
            }
            QLog.d("OlkApi", 1, "setSocketPriority result: " + bundle2.getInt("result"));
            return bundle2.getInt("result");
        } catch (Exception e16) {
            QLog.d("OlkApi", 1, "exception:" + e16.getMessage());
            return -1;
        }
    }

    public static void h(Context context, b bVar) {
        try {
            f397181b = null;
            Class<?> cls = Class.forName("com.oplus.network.OlkManager");
            Class<?> cls2 = Class.forName("com.oplus.network.OlkManager$IOlkCallback");
            Method method = cls.getMethod("getInstance", Context.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, context);
            Object a16 = f397180a.a(cls2);
            Method declaredMethod = cls.getDeclaredMethod("unregisterCallback", cls2);
            declaredMethod.setAccessible(true);
            QLog.d("OlkApi", 1, "unregisterCb return " + ((Integer) declaredMethod.invoke(invoke, a16)).intValue());
        } catch (Exception e16) {
            QLog.d("OlkApi", 1, "unregisterCb failed!" + e16.getMessage());
        }
    }
}
