package f81;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\"\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\t\"\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\r\u0010\t\u00a8\u0006\u000f"}, d2 = {"", "", "b", "d", "a", "c", "", "Ljava/util/List;", "getSupportedHbTypes", "()Ljava/util/List;", "supportedHbTypes", "getSupportedPaymentTypes", "supportedPaymentTypes", "getSupportFestivalTypes", "supportFestivalTypes", "aio_ext_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "WalletElementExt")
/* loaded from: classes11.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f398010a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f398011b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f398012c;

    static {
        List<Integer> listOf;
        List<Integer> listOf2;
        List<Integer> listOf3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 2, 6, 20, 13, 15, 7, 8, 11, 12});
        f398010a = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 16, 9, 10});
        f398011b = listOf2;
        listOf3 = CollectionsKt__CollectionsJVMKt.listOf(33);
        f398012c = listOf3;
    }

    public static final boolean a(int i3) {
        return f398012c.contains(Integer.valueOf(i3));
    }

    public static final boolean b(int i3) {
        return f398010a.contains(Integer.valueOf(i3));
    }

    public static final boolean c(int i3) {
        if (!f398010a.contains(Integer.valueOf(i3)) && !f398012c.contains(Integer.valueOf(i3))) {
            return false;
        }
        return true;
    }

    public static final boolean d(int i3) {
        return f398011b.contains(Integer.valueOf(i3));
    }
}
