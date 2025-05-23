package j93;

import android.content.Intent;
import i93.d;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lj93/a;", "", "a", "b", "c", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, b> f409670b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lj93/a$a;", "", "Landroid/content/Intent;", "intent", "Lj93/b;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "", "ASSEMBLER_MAP", "Ljava/util/concurrent/ConcurrentHashMap;", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: j93.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a(@NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            j93.c cVar = new j93.c();
            c cVar2 = new c();
            for (Map.Entry entry : a.f409670b.entrySet()) {
                if (((b) entry.getValue()).d(intent)) {
                    Object value = entry.getValue();
                    cVar2.c(cVar2.getCount() + 1);
                    cVar2.a().add(new DebugAssemblerBean((String) entry.getKey()));
                    cVar2.getCount();
                    return (b) value;
                }
            }
            return cVar;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lj93/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getBusinessType", "()Ljava/lang/String;", "businessType", "<init>", "(Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: j93.a$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class DebugAssemblerBean {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String businessType;

        public DebugAssemblerBean(@NotNull String businessType) {
            Intrinsics.checkNotNullParameter(businessType, "businessType");
            this.businessType = businessType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof DebugAssemblerBean) && Intrinsics.areEqual(this.businessType, ((DebugAssemblerBean) other).businessType)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.businessType.hashCode();
        }

        @NotNull
        public String toString() {
            return "DebugAssemblerBean(businessType=" + this.businessType + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R'\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lj93/a$c;", "", "Ljava/util/ArrayList;", "Lj93/a$b;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "assemblers", "", "b", "I", "()I", "c", "(I)V", "count", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<DebugAssemblerBean> assemblers = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int count;

        @NotNull
        public final ArrayList<DebugAssemblerBean> a() {
            return this.assemblers;
        }

        /* renamed from: b, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final void c(int i3) {
            this.count = i3;
        }
    }

    static {
        ConcurrentHashMap<String, b> concurrentHashMap = new ConcurrentHashMap<>();
        f409670b = concurrentHashMap;
        concurrentHashMap.put("BUSINESS_SOURCE_TYPE", new i93.c());
        concurrentHashMap.put("PUBLISH_TASK", new d());
        concurrentHashMap.put("QCIRCLE_TYPE", new j93.c());
        concurrentHashMap.put("PUBLISH_COVER_FEED", new i93.a());
        concurrentHashMap.put("FRIEND_FIRST_PUBLISH", new i93.b());
    }
}
