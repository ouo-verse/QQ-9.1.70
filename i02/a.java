package i02;

import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ca;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\tj\b\u0012\u0004\u0012\u00020\u0004`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Li02/a;", "", "", "b", "Li02/a$a;", "listener", "", "a", "c", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "listeners", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f406987a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<InterfaceC10498a> listeners = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Li02/a$a;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: i02.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC10498a {
    }

    a() {
    }

    @JvmStatic
    public static final void a(@NotNull InterfaceC10498a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    @JvmStatic
    public static final boolean b() {
        if (ca.a() && !bw.d0() && !d12.a.c()) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void c(@NotNull InterfaceC10498a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }
}
