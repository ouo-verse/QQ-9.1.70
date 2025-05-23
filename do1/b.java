package do1;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cR$\u0010\t\u001a\u0004\u0018\u00018\u00008\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00018\u00018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u001a\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Ldo1/b;", "T", "LoadMoreState", "Ldo1/a;", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "d", "(Ljava/lang/Object;)V", "collection", "", "b", "Z", "()Z", "e", "(Z)V", "isFinished", "c", "f", "loadMoreState", "", "I", "getTotal", "()I", "g", "(I)V", "total", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b<T, LoadMoreState> implements a<T, LoadMoreState> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T collection;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isFinished;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LoadMoreState loadMoreState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int total;

    @Override // do1.a
    @Nullable
    public T a() {
        return this.collection;
    }

    @Override // do1.a
    /* renamed from: b, reason: from getter */
    public boolean getIsFinished() {
        return this.isFinished;
    }

    @Override // do1.a
    @Nullable
    public LoadMoreState c() {
        return this.loadMoreState;
    }

    public void d(@Nullable T t16) {
        this.collection = t16;
    }

    public void e(boolean z16) {
        this.isFinished = z16;
    }

    public void f(@Nullable LoadMoreState loadmorestate) {
        this.loadMoreState = loadmorestate;
    }

    public void g(int i3) {
        this.total = i3;
    }

    @Override // do1.a
    public int getTotal() {
        return this.total;
    }
}
