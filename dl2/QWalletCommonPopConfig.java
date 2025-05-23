package dl2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B%\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Ldl2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "timeoutMS", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "", "preloadBundles", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "(Ljava/lang/Long;Ljava/util/List;)V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: dl2.a, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class QWalletCommonPopConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final QWalletCommonPopConfig f394058b;

    @SerializedName("preload_bundles")
    @Nullable
    private final List<String> preloadBundles;

    @SerializedName("timeout")
    @Nullable
    private final Long timeoutMS;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Ldl2/a$a;", "", "Ldl2/a;", "DEFAULT", "Ldl2/a;", "a", "()Ldl2/a;", "", "DEFAULT_TIMEOUT", "J", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dl2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QWalletCommonPopConfig a() {
            return QWalletCommonPopConfig.f394058b;
        }

        Companion() {
        }
    }

    static {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("qwallet_home_popup");
        f394058b = new QWalletCommonPopConfig(3000L, listOf);
    }

    public QWalletCommonPopConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final List<String> b() {
        return this.preloadBundles;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Long getTimeoutMS() {
        return this.timeoutMS;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QWalletCommonPopConfig)) {
            return false;
        }
        QWalletCommonPopConfig qWalletCommonPopConfig = (QWalletCommonPopConfig) other;
        if (Intrinsics.areEqual(this.timeoutMS, qWalletCommonPopConfig.timeoutMS) && Intrinsics.areEqual(this.preloadBundles, qWalletCommonPopConfig.preloadBundles)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Long l3 = this.timeoutMS;
        int i3 = 0;
        if (l3 == null) {
            hashCode = 0;
        } else {
            hashCode = l3.hashCode();
        }
        int i16 = hashCode * 31;
        List<String> list = this.preloadBundles;
        if (list != null) {
            i3 = list.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "QWalletCommonPopConfig(timeoutMS=" + this.timeoutMS + ", preloadBundles=" + this.preloadBundles + ")";
    }

    public QWalletCommonPopConfig(@Nullable Long l3, @Nullable List<String> list) {
        this.timeoutMS = l3;
        this.preloadBundles = list;
    }

    public /* synthetic */ QWalletCommonPopConfig(Long l3, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : l3, (i3 & 2) != 0 ? null : list);
    }
}
