package f34;

import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import java.util.List;
import k64.b;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u54.c;
import w64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\u0006"}, d2 = {"Lf34/a;", "Lk64/b;", "", "d", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0000\u0003\b\n\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"f34/a$a", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "Lk64/a;", "f34/a$a$a", "c", "()Lf34/a$a$a;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: f34.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C10278a extends IStrategyFetcher<k64.a<?>> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J(\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00050\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"f34/a$a$a", "Lk64/a;", "Lw64/e;", "Lu54/c;", "context", "", "Lv64/b;", "Lb74/a;", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: f34.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C10279a implements k64.a<e<c>> {
            C10279a() {
            }

            @Override // k64.a
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public List<v64.b<List<b74.a>>> a(@NotNull e<c> context) {
                List<v64.b<List<b74.a>>> listOf;
                Intrinsics.checkNotNullParameter(context, "context");
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new v64.b[]{new x54.a(context), new d64.a(context)});
                return listOf;
            }
        }

        C10278a() {
        }

        @Override // com.tencent.mvi.runtime.strategy.IStrategyFetcher
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C10279a a() {
            return new C10279a();
        }
    }

    public a() {
        d();
    }

    private final void d() {
        c(k64.a.class, new C10278a());
    }
}
