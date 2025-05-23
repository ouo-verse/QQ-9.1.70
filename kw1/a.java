package kw1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R,\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0007R(\u0010\u000e\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lkw1/a;", "", "", "a", "b", "Ljava/util/WeakHashMap;", "", "Ljava/util/WeakHashMap;", "traceProperties", "value", "c", "(Ljava/lang/Object;)Ljava/lang/String;", "d", "(Ljava/lang/Object;Ljava/lang/String;)V", "traceId", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f413327a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final WeakHashMap<Object, Map<String, String>> traceProperties = new WeakHashMap<>();

    a() {
    }

    private final String a() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String b() {
        String a16 = a();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return a16 + "_" + currentTimeMillis + "_" + (RandomKt.Random(currentTimeMillis).nextInt(90000) + 10000);
    }

    @NotNull
    public final String c(@NotNull Object obj) {
        String str;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Map<String, String> map = traceProperties.get(obj);
        if (map == null || (str = map.get("traceId")) == null) {
            return "";
        }
        return str;
    }

    public final void d(@NotNull Object obj, @NotNull String value) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        WeakHashMap<Object, Map<String, String>> weakHashMap = traceProperties;
        Map<String, String> map = weakHashMap.get(obj);
        if (map == null) {
            map = new LinkedHashMap<>();
            weakHashMap.put(obj, map);
        }
        map.put("traceId", value);
    }
}
