package mx4;

import android.annotation.SuppressLint;
import android.util.Log;
import com.tencent.zplan.common.utils.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\u0006\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lmx4/c;", "", "", "scopeClassName", "", "Ljava/lang/Class;", "b", "a", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f417753a = new c();

    c() {
    }

    private final Map<Class<?>, Class<?>> b(String scopeClassName) {
        Object b16 = g.f385293a.b(scopeClassName, "PROXY_SERVICES");
        if (b16 instanceof Map) {
            return (Map) b16;
        }
        return new HashMap();
    }

    @SuppressLint({"LongLogTag"})
    @NotNull
    public final Map<Class<?>, Class<?>> a() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(b("com.tencent.zplan.generated.PluginProxyServiceScope"));
        hashMap.putAll(b("com.tencent.zplan.demo.generated.DemoProxyServiceScope"));
        hashMap.putAll(b("com.tencent.mobileqq.zplan.generated.QQProxyServiceScope"));
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Log.d("[ZPlanCommon][ProxyServiceList]", "ProxyService: " + ((Map.Entry) it.next()));
        }
        return hashMap;
    }
}
