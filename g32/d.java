package g32;

import g32.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B8\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00110\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR2\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00110\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lg32/d;", "Lg32/b;", "E", "Lg32/j;", "event", "", "a", "(Lg32/b;)Z", "Ljava/lang/Class;", "b", "Ljava/lang/Class;", "c", "()Ljava/lang/Class;", "clazz", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "Lkotlin/jvm/functions/Function1;", "d", "()Lkotlin/jvm/functions/Function1;", "invoke", "<init>", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class d<E extends b> extends j<E> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<E> clazz;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<E, Unit> invoke;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull Class<E> clazz, @NotNull Function1<? super E, Unit> invoke) {
        super(false, 1, null);
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        this.clazz = clazz;
        this.invoke = invoke;
    }

    @Override // g32.j
    public boolean a(@NotNull E event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.invoke.invoke(event);
        return false;
    }

    @NotNull
    public final Class<E> c() {
        return this.clazz;
    }

    @NotNull
    public final Function1<E, Unit> d() {
        return this.invoke;
    }
}
