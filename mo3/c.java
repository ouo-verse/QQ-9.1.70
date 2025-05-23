package mo3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lmo3/c;", "", "Lmo3/d;", "viewModel", "", "a", "e", "Lcom/tencent/now/pkgame/pkgame/pklib/state/a;", "currentGameState", "d", "Ljo3/a;", "pkGameMsg", "g", "b", "c", "f", "", "Ljava/util/List;", "vmList", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> vmList = new ArrayList();

    public final void a(@NotNull d viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.vmList.add(viewModel);
    }

    public final void b() {
        Iterator<d> it = this.vmList.iterator();
        while (it.hasNext()) {
            it.next().L1();
        }
    }

    public final void c() {
        Iterator<d> it = this.vmList.iterator();
        while (it.hasNext()) {
            it.next().M1();
        }
    }

    public final void d(@NotNull com.tencent.now.pkgame.pkgame.pklib.state.a currentGameState) {
        Intrinsics.checkNotNullParameter(currentGameState, "currentGameState");
        Iterator<d> it = this.vmList.iterator();
        while (it.hasNext()) {
            it.next().N1(currentGameState);
        }
    }

    public final void e() {
        Iterator<d> it = this.vmList.iterator();
        while (it.hasNext()) {
            it.next().O1();
        }
    }

    public final void f() {
        this.vmList.clear();
    }

    public final void g(@NotNull jo3.a pkGameMsg) {
        Intrinsics.checkNotNullParameter(pkGameMsg, "pkGameMsg");
        Iterator<d> it = this.vmList.iterator();
        while (it.hasNext()) {
            it.next().P1(pkGameMsg);
        }
    }
}
