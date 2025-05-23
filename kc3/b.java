package kc3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkc3/b;", "", "", "a", "d", "c", "b", "Lkc3/a;", "Lkc3/a;", "judgeParams", "Lpc3/a;", "Lpc3/a;", "mLoginTaskHandler", "<init>", "(Lkc3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final GameJudgeParams judgeParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final pc3.a mLoginTaskHandler;

    public b(GameJudgeParams judgeParams) {
        Intrinsics.checkNotNullParameter(judgeParams, "judgeParams");
        this.judgeParams = judgeParams;
        this.mLoginTaskHandler = new pc3.a(judgeParams);
    }

    private final void a() {
        nc3.b.f419923a.j();
    }

    private final void d() {
        nc3.b.f419923a.i(new nc3.a(this.judgeParams));
    }

    public final void b() {
        if (nc3.b.f419923a.g()) {
            a();
        }
    }

    public final void c() {
        d();
    }
}
