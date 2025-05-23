package d34;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u54.c;
import w64.d;
import w64.f;
import w64.i;
import w64.k;
import w64.l;
import w64.m;
import w64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0096\u0001J\t\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016\u00a8\u0006\u0015"}, d2 = {"Ld34/a;", "Lw64/n;", "Lu54/c;", "Lw64/f;", "c", "Lw64/k;", "a", "Lw64/i;", "d", "Lw64/l;", "e", "Lw64/m;", "b", "Lw64/d;", "f", "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lcom/tencent/robot/slash/businessapi/c;", "businessDelegate", "<init>", "(Lcom/tencent/mvi/api/runtime/b;Lcom/tencent/robot/slash/businessapi/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements n<c> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ u54.a f392766a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0005"}, d2 = {"d34/a$a", "Lw64/l;", "Lu54/c;", "Le34/a;", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: d34.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C10158a implements l<c> {
        C10158a() {
        }

        @Override // w64.l
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e34.a a() {
            return new e34.a();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"d34/a$b", "Lw64/m;", "Lcom/tencent/mvi/runtime/strategy/b;", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements m {
        b() {
        }

        @Override // w64.m
        @NotNull
        public com.tencent.mvi.runtime.strategy.b a() {
            return new f34.a();
        }
    }

    public a(@NotNull com.tencent.mvi.api.runtime.b mviContext, @NotNull com.tencent.robot.slash.businessapi.c businessDelegate) {
        Intrinsics.checkNotNullParameter(mviContext, "mviContext");
        Intrinsics.checkNotNullParameter(businessDelegate, "businessDelegate");
        this.f392766a = new u54.a(mviContext, businessDelegate);
    }

    @Override // w64.n
    @NotNull
    public k<c> a() {
        return this.f392766a.a();
    }

    @Override // w64.n
    @NotNull
    public m b() {
        return new b();
    }

    @Override // w64.n
    @NotNull
    public f c() {
        return this.f392766a.c();
    }

    @Override // w64.n
    @NotNull
    public i d() {
        return this.f392766a.d();
    }

    @Override // w64.n
    @NotNull
    public l<c> e() {
        return new C10158a();
    }

    @Override // w64.n
    @NotNull
    public d<c> f() {
        return new x64.i(null, 1, null);
    }
}
