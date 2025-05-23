package fe4;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\t\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002R#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lfe4/d;", "", "Ljava/lang/Class;", "Lfe4/a;", "clazz", "", "a", "Ljava/util/HashMap;", "", "", "Ljava/util/HashMap;", "b", "()Ljava/util/HashMap;", "defaultOrderConfig", "I", "index", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> defaultOrderConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int index;

    /* renamed from: c, reason: collision with root package name */
    public static final d f398411c;

    static {
        d dVar = new d();
        f398411c = dVar;
        defaultOrderConfig = new HashMap<>();
        dVar.a(c.class);
    }

    d() {
    }

    public final void a(@NotNull Class<? extends a> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        HashMap<String, Integer> hashMap = defaultOrderConfig;
        String simpleName = clazz.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "clazz.simpleName");
        int i3 = index;
        index = i3 + 1;
        hashMap.put(simpleName, Integer.valueOf(i3));
    }

    @NotNull
    public final HashMap<String, Integer> b() {
        return defaultOrderConfig;
    }
}
