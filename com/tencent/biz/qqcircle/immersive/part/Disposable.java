package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00000\rj\b\u0012\u0004\u0012\u00020\u0000`\u000e\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\u0006\u0010\u0005\u001a\u00020\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00000\rj\b\u0012\u0004\u0012\u00020\u0000`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/a;", "", "child", "", "a", "b", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", Node.CHILDREN_ATTR, "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnDispose", "()Lkotlin/jvm/functions/Function0;", "setOnDispose", "(Lkotlin/jvm/functions/Function0;)V", "onDispose", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "disposed", "<init>", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function0;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.part.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class Disposable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<Disposable> children;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private Function0<Unit> onDispose;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean disposed;

    public Disposable(@NotNull ArrayList<Disposable> children, @NotNull Function0<Unit> onDispose) {
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(onDispose, "onDispose");
        this.children = children;
        this.onDispose = onDispose;
        this.disposed = new AtomicBoolean(false);
    }

    public final void a(@NotNull Disposable child) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    public final void b() {
        if (this.disposed.compareAndSet(false, true)) {
            Iterator<T> it = this.children.iterator();
            while (it.hasNext()) {
                ((Disposable) it.next()).b();
            }
            this.onDispose.invoke();
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Disposable)) {
            return false;
        }
        Disposable disposable = (Disposable) other;
        if (Intrinsics.areEqual(this.children, disposable.children) && Intrinsics.areEqual(this.onDispose, disposable.onDispose)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.children.hashCode() * 31) + this.onDispose.hashCode();
    }

    @NotNull
    public String toString() {
        return "Disposable(children=" + this.children + ", onDispose=" + this.onDispose + ")";
    }

    public /* synthetic */ Disposable(ArrayList arrayList, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : arrayList, function0);
    }
}
