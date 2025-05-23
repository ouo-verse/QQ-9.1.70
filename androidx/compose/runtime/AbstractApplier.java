package androidx.compose.runtime;

import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u000fH$J\b\u0010\u0013\u001a\u00020\u000fH\u0016J*\u0010\u0014\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0004J\"\u0010\u0019\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0004R&\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000@TX\u0096\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/AbstractApplier;", "T", "Landroidx/compose/runtime/Applier;", "root", "(Ljava/lang/Object;)V", "<set-?>", "current", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "Ljava/lang/Object;", "getRoot", "stack", "", QCircleLpReportDc05507.KEY_CLEAR, "", "down", "node", "onClear", "up", "move", "from", "", "to", "count", "remove", "index", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public abstract class AbstractApplier<T> implements Applier<T> {
    public static final int $stable = 8;
    private T current;
    private final T root;
    private final List<T> stack = new ArrayList();

    public AbstractApplier(T t16) {
        this.root = t16;
        this.current = t16;
    }

    @Override // androidx.compose.runtime.Applier
    public final void clear() {
        this.stack.clear();
        setCurrent(this.root);
        onClear();
    }

    @Override // androidx.compose.runtime.Applier
    public void down(T node) {
        this.stack.add(getCurrent());
        setCurrent(node);
    }

    @Override // androidx.compose.runtime.Applier
    public T getCurrent() {
        return this.current;
    }

    public final T getRoot() {
        return this.root;
    }

    protected final void move(List<T> list, int i3, int i16, int i17) {
        List mutableList;
        Intrinsics.checkNotNullParameter(list, "<this>");
        int i18 = i3 > i16 ? i16 : i16 - i17;
        if (i17 != 1) {
            List<T> subList = list.subList(i3, i17 + i3);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) subList);
            subList.clear();
            list.addAll(i18, mutableList);
            return;
        }
        if (i3 != i16 + 1 && i3 != i16 - 1) {
            list.add(i18, list.remove(i3));
        } else {
            list.set(i3, list.set(i16, list.get(i3)));
        }
    }

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onBeginChanges() {
        a.a(this);
    }

    protected abstract void onClear();

    @Override // androidx.compose.runtime.Applier
    public /* synthetic */ void onEndChanges() {
        a.b(this);
    }

    protected final void remove(List<T> list, int i3, int i16) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i16 == 1) {
            list.remove(i3);
        } else {
            list.subList(i3, i16 + i3).clear();
        }
    }

    protected void setCurrent(T t16) {
        this.current = t16;
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        if (!this.stack.isEmpty()) {
            setCurrent(this.stack.remove(r0.size() - 1));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
