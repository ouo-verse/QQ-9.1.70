package a94;

import com.tencent.mobileqq.zootopia.api.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u00a8\u0006\t"}, d2 = {"La94/a;", "", "T", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zootopia/api/e;", "weakRef", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f25732a = new a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"a94/a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "result", "", "onResultSuccess", "(Ljava/lang/Object;)V", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: a94.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0022a<T> implements e<T> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<e<T>> f25733d;

        C0022a(WeakReference<e<T>> weakReference) {
            this.f25733d = weakReference;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            e<T> eVar = this.f25733d.get();
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultSuccess(T result) {
            e<T> eVar = this.f25733d.get();
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }
    }

    a() {
    }

    public final <T> e<T> a(WeakReference<e<T>> weakRef) {
        Intrinsics.checkNotNullParameter(weakRef, "weakRef");
        return new C0022a(weakRef);
    }
}
