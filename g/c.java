package g;

import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mobileqq.qqbattery.feature.g;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f401009a;

    /* renamed from: b, reason: collision with root package name */
    public final String f401010b;

    /* renamed from: c, reason: collision with root package name */
    public final b f401011c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f401012d;

    /* renamed from: e, reason: collision with root package name */
    public IBinder f401013e;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final IBinder f401014a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f401015b;

        /* compiled from: P */
        /* renamed from: g.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C10344a implements InvocationHandler {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f401016a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f401017b;

            public C10344a(b bVar, Object obj) {
                this.f401016a = bVar;
                this.f401017b = obj;
            }

            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                b bVar = this.f401016a;
                if (bVar != null) {
                    bVar.a(method, objArr);
                    this.f401016a.a();
                }
                return method.invoke(this.f401017b, objArr);
            }
        }

        public a(String str, String str2, b bVar) {
            IBinder b16 = b(str);
            this.f401014a = b16;
            this.f401015b = c(str2, b16, bVar);
        }

        public static IBinder b(String str) {
            return (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, str);
        }

        public static Object c(String str, IBinder iBinder, b bVar) {
            Class<?> cls = Class.forName(str);
            Class<?> cls2 = Class.forName(str + "$Stub");
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader != null) {
                return Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class, IInterface.class, cls}, new C10344a(bVar, cls2.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder)));
            }
            throw new IllegalStateException("get service manager ClassLoader fail!");
        }

        public final IBinder a() {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                return (IBinder) Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class}, this);
            }
            StringBuilder a16 = g.a("Can not get ClassLoader of ");
            a16.append(cls.getName());
            throw new IllegalStateException(a16.toString());
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if ("queryLocalInterface".equals(method.getName())) {
                return this.f401015b;
            }
            return method.invoke(this.f401014a, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(Method method, Object[] objArr);
    }

    public c(String str, String str2, b bVar) {
        this.f401009a = str;
        this.f401010b = str2;
        this.f401011c = bVar;
    }

    public final boolean a() {
        com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", this.f401009a, this.f401010b);
        try {
            a aVar = new a(this.f401009a, this.f401010b, this.f401011c);
            IBinder a16 = aVar.a();
            Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.f401009a, a16);
            this.f401013e = a16;
            this.f401012d = aVar.f401014a;
            return true;
        } catch (Throwable th5) {
            StringBuilder a17 = g.a("#doHook exp: ");
            a17.append(th5.getLocalizedMessage());
            com.tencent.mobileqq.qqbattery.utils.a.b("QQBattery_SystemServiceBinderHooker", a17.toString(), new Object[0]);
            return false;
        }
    }
}
