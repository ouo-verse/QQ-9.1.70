package lx4;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ2\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H&J8\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H&J8\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H&\u00a8\u0006\r"}, d2 = {"Llx4/b;", "", "", com.heytap.mcssdk.a.a.f36102l, "eventCode", "", "params", "", "a", "pageCode", "modeCode", "c", "b", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f415746a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Llx4/b$a;", "", "", "", "a", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: lx4.b$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f415746a = new Companion();

        Companion() {
        }

        @NotNull
        public final String a(boolean z16) {
            if (z16) {
                return "1";
            }
            return "0";
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: lx4.b$b, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10752b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b bVar, String str, String str2, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = "0AND0YAG6R40RLM6";
                }
                if ((i3 & 4) != 0) {
                    map = null;
                }
                bVar.a(str, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
        }
    }

    void a(@NotNull String appKey, @NotNull String eventCode, @Nullable Map<String, String> params);

    void b(@NotNull String pageCode, @NotNull String modeCode, @NotNull String eventCode, @Nullable Map<String, String> params);

    void c(@NotNull String pageCode, @NotNull String modeCode, @NotNull String eventCode, @Nullable Map<String, String> params);
}
