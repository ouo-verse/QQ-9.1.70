package fl0;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007R*\u0010\b\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R&\u0010\n\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lfl0/b;", "", "Ljava/lang/Class;", "proxy", "b", "", "a", "Ljava/util/Map;", "proxyServicesMap", "", "activatedServices", "<init>", "()V", "d", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<Class<?>, Class<?>> proxyServicesMap = c.f399768a.a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<Class<?>, Object> activatedServices = new HashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final b f399764c = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lfl0/b$a;", "", "Lfl0/b;", "a", "", "TAG", "Ljava/lang/String;", "sInstance", "Lfl0/b;", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: fl0.b$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final b a() {
            return b.f399764c;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    b() {
    }

    @SuppressLint({"LongLogTag"})
    @Nullable
    public final Object b(@NotNull Class<?> proxy) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Map<Class<?>, Class<?>> map = this.proxyServicesMap;
        Intrinsics.checkNotNull(map);
        Class<?> cls = map.get(proxy);
        if (cls == null) {
            Log.w("[zplan-filament][ProxyServiceEngine]", "Can NOT find service class by proxy name: " + proxy);
            return null;
        }
        Object obj = this.activatedServices.get(cls);
        if (obj != null) {
            return obj;
        }
        synchronized (this) {
            try {
                obj = cls.newInstance();
                Log.i("[zplan-filament][ProxyServiceEngine]", "Create a new proxy instance of " + cls);
                this.activatedServices.put(cls, obj);
            } catch (Exception unused) {
                Log.e("[zplan-filament][ProxyServiceEngine]", "Failed to create instance of " + cls);
            }
            Unit unit = Unit.INSTANCE;
        }
        return obj;
    }
}
