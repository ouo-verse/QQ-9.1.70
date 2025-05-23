package or1;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bw;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0002H\u0002R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lor1/c;", "", "", "e", "Lor1/c$a;", "listener", "", "b", "d", "c", "Ljava/lang/Boolean;", "showVisitorRedPoint", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "listeners", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean showVisitorRedPoint;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f423453a = new c();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<a> listeners = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lor1/c$a;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface a {
    }

    c() {
    }

    @JvmStatic
    public static final void b(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    private final boolean c() {
        return bw.L().decodeBool("MMKV_KEY_SHOW_VISITOR_REDPOINT", true);
    }

    @JvmStatic
    public static final void d(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    @JvmStatic
    public static final boolean e() {
        Boolean bool = showVisitorRedPoint;
        if (bool != null) {
            return bool.booleanValue();
        }
        showVisitorRedPoint = Boolean.valueOf(f423453a.c());
        Logger.f235387a.d().i("Guild.MF.Vst.VisitorRedPointManager", 1, "getShowRedFromMMKV showVisitorRedPoint=" + showVisitorRedPoint);
        Boolean bool2 = showVisitorRedPoint;
        Intrinsics.checkNotNull(bool2);
        return bool2.booleanValue();
    }
}
