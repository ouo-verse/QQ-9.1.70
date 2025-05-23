package k32;

import androidx.lifecycle.ViewModel;
import g32.b;
import g32.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0006H&\u00a8\u0006\u0010"}, d2 = {"Lk32/a;", "Landroidx/lifecycle/ViewModel;", "Lg32/h;", "Lg32/b;", "E", "event", "", "w0", "(Lg32/b;)V", "M1", "()V", "L1", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class a extends ViewModel implements h {

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ f32.a f411512i;

    public a(@NotNull f32.a componentContext) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        this.f411512i = componentContext;
    }

    public abstract void L1();

    public final void M1() {
        L1();
    }

    public <E extends b> void w0(@NotNull E event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f411512i.w0(event);
    }
}
