package lx4;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010JF\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH&JF\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u0011"}, d2 = {"Llx4/e;", "", "", "service", "method", "", "reqData", "", "extData", "Llx4/e$c;", "observer", "", "source", "", "b", "a", "c", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f415749b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Llx4/e$a;", "", "", "a", "I", "()I", "SOURCE_DEFAULT", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: lx4.e$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private static final int SOURCE_DEFAULT = 0;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ Companion f415749b = new Companion();

        Companion() {
        }

        public final int a() {
            return SOURCE_DEFAULT;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b {
        public static /* synthetic */ void a(e eVar, String str, String str2, byte[] bArr, Map map, c cVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 32) != 0) {
                    i3 = e.INSTANCE.a();
                }
                eVar.b(str, str2, bArr, map, cVar, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendZPlanProxyRequest");
        }

        public static /* synthetic */ void b(e eVar, String str, String str2, byte[] bArr, Map map, c cVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 32) != 0) {
                    i3 = e.INSTANCE.a();
                }
                eVar.a(str, str2, bArr, map, cVar, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendZPlanServerProxyRequest");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Llx4/e$c;", "", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public interface c {
        void a(@Nullable Integer errCode, @Nullable String errMsg);

        void onReceive(@Nullable byte[] data);
    }

    void a(@NotNull String service, @NotNull String method, @NotNull byte[] reqData, @NotNull Map<String, String> extData, @NotNull c observer, int source);

    void b(@NotNull String service, @NotNull String method, @NotNull byte[] reqData, @NotNull Map<String, String> extData, @NotNull c observer, int source);
}
