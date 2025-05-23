package k74;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0002)*B\u0011\b\u0002\u0012\u0006\u0010%\u001a\u00020\b\u00a2\u0006\u0004\b&\u0010'J#\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u001d\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u0016J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R$\u0010\u001d\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\f0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR$\u0010\u001e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\f0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001cR$\u0010 \u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010#\u00a8\u0006+"}, d2 = {"Lk74/i;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "T", "Ljava/lang/Class;", "clazz", tl.h.F, "(Ljava/lang/Class;)Ljava/lang/Object;", "d", "", PushClientConstants.TAG_CLASS_NAME, "e", "(Ljava/lang/String;)Ljava/lang/Object;", "", "result", "Landroid/os/Bundle;", "data", "Lk74/e;", "methodToken", "", "c", "action", "params", "", "callbackId", "g", "Leipc/EIPCResult;", "onCall", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mServiceLocks", "mServlets", "f", "mProcessNames", "", "Lk74/h;", "Ljava/util/Map;", "mTypeTokens", "name", "<init>", "(Ljava/lang/String;)V", "i", "a", "b", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends QIPCModule {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Class<?>, Object> mServiceLocks;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Class<?>, Object> mServlets;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<Class<?>, String> mProcessNames;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Map<String, h> mTypeTokens;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lk74/i$a;", "", "T", "Ljava/lang/Class;", "clazz", "a", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lk74/i;", "b", "()Lk74/i;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: k74.i$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final <T> T a(Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return (T) b().d(clazz);
        }

        public final i b() {
            return b.f411839a.a();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lk74/i$b;", "", "Lk74/i;", "b", "Lk74/i;", "a", "()Lk74/i;", "setInstance", "(Lk74/i;)V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f411839a = new b();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static i instance = new i(IZPlanIPCHelper.MODULE_NAME, null);

        b() {
        }

        public final i a() {
            return instance;
        }
    }

    public /* synthetic */ i(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private final void c(Object result, Bundle data, e methodToken) {
        Class<?> type = l74.a.l(methodToken.g());
        g gVar = g.f411830a;
        Intrinsics.checkNotNullExpressionValue(type, "type");
        gVar.i(type, data, "ipc_ret_data", result, -100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> T d(Class<T> clazz) {
        T t16;
        if (this.mServlets.get(clazz) != null) {
            return (T) this.mServlets.get(clazz);
        }
        if (this.mServiceLocks.get(clazz) == null) {
            synchronized (this.mServiceLocks) {
                if (this.mServiceLocks.get(clazz) == null) {
                    this.mServiceLocks.put(clazz, new Object());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        Object obj = this.mServiceLocks.get(clazz);
        Intrinsics.checkNotNull(obj);
        synchronized (obj) {
            if (this.mServlets.get(clazz) != null) {
                return (T) this.mServlets.get(clazz);
            }
            String str = this.mProcessNames.get(clazz);
            if (TextUtils.isEmpty(str)) {
                ServletImpl servletImpl = (ServletImpl) clazz.getAnnotation(ServletImpl.class);
                if (servletImpl != null) {
                    str = servletImpl.process();
                }
                if (TextUtils.isEmpty(str)) {
                    str = MobileQQ.PACKAGE_NAME;
                }
                ConcurrentHashMap<Class<?>, String> concurrentHashMap = this.mProcessNames;
                Intrinsics.checkNotNull(str);
                concurrentHashMap.put(clazz, str);
            }
            if (t74.h.a(str)) {
                t16 = (T) h(clazz);
            } else {
                Intrinsics.checkNotNull(str);
                Object newProxyInstance = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new c(clazz, str));
                ConcurrentHashMap<Class<?>, Object> concurrentHashMap2 = this.mServlets;
                Intrinsics.checkNotNull(newProxyInstance, "null cannot be cast to non-null type kotlin.Any");
                concurrentHashMap2.put(clazz, newProxyInstance);
                t16 = (T) newProxyInstance;
            }
            return t16;
        }
    }

    private final <T> T e(String className) {
        try {
            ClassLoader classLoader = i.class.getClassLoader();
            Intrinsics.checkNotNull(classLoader);
            Class<?> loadClass = classLoader.loadClass(className);
            Intrinsics.checkNotNull(loadClass, "null cannot be cast to non-null type java.lang.Class<T of com.tencent.sqshow.ipc.ZPlanIPCModule.api>");
            return (T) d(loadClass);
        } catch (ClassNotFoundException e16) {
            throw new RuntimeException(e16.getMessage());
        }
    }

    @JvmStatic
    public static final <T> T f(Class<T> cls) {
        return (T) INSTANCE.a(cls);
    }

    private final <T> T h(Class<T> clazz) {
        ServletImpl servletImpl = (ServletImpl) clazz.getAnnotation(ServletImpl.class);
        try {
            Intrinsics.checkNotNull(servletImpl);
            T t16 = (T) servletImpl.impl().newInstance();
            Class<?>[] types = servletImpl.impl().getInterfaces();
            Intrinsics.checkNotNullExpressionValue(types, "types");
            int length = types.length;
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (Intrinsics.areEqual(clazz, types[i3])) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (z16) {
                Map<String, h> map = this.mTypeTokens;
                String name = clazz.getName();
                Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
                map.put(name, h.INSTANCE.a(clazz));
                ConcurrentHashMap<Class<?>, Object> concurrentHashMap = this.mServlets;
                Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type kotlin.Any");
                concurrentHashMap.put(clazz, t16);
                this.mProcessNames.put(clazz, servletImpl.process());
                return t16;
            }
            throw new RuntimeException("please check you implement setting !");
        } catch (IllegalAccessException e16) {
            throw new RuntimeException(e16.getMessage());
        } catch (InstantiationException e17) {
            throw new RuntimeException(e17.getMessage());
        }
    }

    public final Bundle g(String action, Bundle params, int callbackId) {
        List split$default;
        e c16;
        Intrinsics.checkNotNullParameter(action, "action");
        Bundle bundle = new Bundle();
        split$default = StringsKt__StringsKt.split$default((CharSequence) action, new String[]{";"}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length < 3) {
            return bundle;
        }
        String str = strArr[0];
        Object e16 = e(str);
        String str2 = strArr[1];
        String substring = action.substring(str.length() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        h hVar = this.mTypeTokens.get(str);
        if (hVar == null || (c16 = hVar.c(substring)) == null) {
            return bundle;
        }
        Intrinsics.checkNotNull(params);
        Object[] a16 = f.a(c16, params);
        if (c16.getCallback() != null) {
            try {
                ClassLoader classLoader = i.class.getClassLoader();
                Intrinsics.checkNotNull(classLoader);
                h callback = c16.getCallback();
                Intrinsics.checkNotNull(callback);
                Class<?> clazz = classLoader.loadClass(callback.getName());
                Intrinsics.checkNotNullExpressionValue(clazz, "clazz");
                a16[c16.getCallbackIndex()] = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new d(clazz, this, callbackId));
            } catch (ClassNotFoundException unused) {
            }
        }
        Object d16 = l74.a.g(e16).b(str2, Arrays.copyOf(a16, a16.length)).d();
        Intrinsics.checkNotNullExpressionValue(d16, "result.get()");
        c(d16, bundle, c16);
        return bundle;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String action, Bundle params, int callbackId) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        if (QLog.isColorLevel()) {
            QLog.i("[zplan]ZPlanIPCModule", 2, "onCall, action : " + action);
        }
        EIPCResult createSuccessResult = EIPCResult.createSuccessResult(g(action, params, callbackId));
        Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(result)");
        return createSuccessResult;
    }

    i(String str) {
        super(str);
        this.mServiceLocks = new ConcurrentHashMap<>();
        this.mServlets = new ConcurrentHashMap<>();
        this.mProcessNames = new ConcurrentHashMap<>();
        this.mTypeTokens = new HashMap();
    }
}
