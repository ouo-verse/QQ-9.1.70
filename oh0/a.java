package oh0;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Loh0/a;", "", "", "contentId", "", "c", "", "b", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "preloadSuccessMap", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f422682b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Boolean> preloadSuccessMap = new ConcurrentHashMap<>();

    a() {
    }

    public final void a() {
        preloadSuccessMap.clear();
    }

    public final boolean b(@NotNull String contentId) {
        Boolean bool = preloadSuccessMap.get(contentId);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void c(@NotNull String contentId) {
        preloadSuccessMap.put(contentId, Boolean.TRUE);
    }
}
