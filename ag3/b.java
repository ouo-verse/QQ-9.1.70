package ag3;

import ag3.a;
import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u000f*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\fB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000b\u001a\u00020\nJ\u000f\u0010\f\u001a\u00028\u0000H$\u00a2\u0006\u0004\b\f\u0010\u0005R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0012j\b\u0012\u0004\u0012\u00028\u0000`\u00138\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lag3/b;", "Lag3/a;", "T", "", "e", "()Lag3/a;", "availableItem", "", "d", "(Lag3/a;)V", "", "b", "a", "Landroid/content/Context;", "Landroid/content/Context;", "c", "()Landroid/content/Context;", "context", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "getMAvailablePool", "()Ljava/util/HashSet;", "mAvailablePool", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public abstract class b<T extends a> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final HashSet<T> mAvailablePool;

    public b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mAvailablePool = new HashSet<>();
    }

    protected abstract T a();

    public final int b() {
        return this.mAvailablePool.size();
    }

    /* renamed from: c, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final void d(T availableItem) {
        Intrinsics.checkNotNullParameter(availableItem, "availableItem");
        this.mAvailablePool.add(availableItem);
    }

    public final T e() {
        Object elementAt;
        if (!this.mAvailablePool.isEmpty()) {
            elementAt = CollectionsKt___CollectionsKt.elementAt(this.mAvailablePool, 0);
            T t16 = (T) elementAt;
            this.mAvailablePool.remove(t16);
            return t16;
        }
        long currentTimeMillis = System.currentTimeMillis();
        T a16 = a();
        QLog.i("RecyclableItemCache_", 1, "createItem cost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms, instance: " + a16);
        return a16;
    }
}
