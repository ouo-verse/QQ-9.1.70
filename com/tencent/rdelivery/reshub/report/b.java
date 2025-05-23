package com.tencent.rdelivery.reshub.report;

import com.tencent.rdelivery.reshub.api.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\"\u0017\u0010\u0006\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0017\u0010\n\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/rdelivery/reshub/report/a;", "Lcom/tencent/rdelivery/reshub/api/n;", "b", "a", "Lcom/tencent/rdelivery/reshub/report/a;", "()Lcom/tencent/rdelivery/reshub/report/a;", "SuccessInfo", "Lcom/tencent/rdelivery/reshub/api/n;", "getLoadSuccess", "()Lcom/tencent/rdelivery/reshub/api/n;", "LoadSuccess", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final com.tencent.rdelivery.reshub.report.a f364566a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final n f364567b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/rdelivery/reshub/report/b$a", "Lcom/tencent/rdelivery/reshub/api/n;", "", "b", "", "message", "", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.rdelivery.reshub.report.a f364568a;

        a(com.tencent.rdelivery.reshub.report.a aVar) {
            this.f364568a = aVar;
        }

        @Override // com.tencent.rdelivery.reshub.api.n
        @Nullable
        public Throwable a() {
            return this.f364568a.getException();
        }

        @Override // com.tencent.rdelivery.reshub.api.n
        public int b() {
            return this.f364568a.getErrorCode();
        }

        @Override // com.tencent.rdelivery.reshub.api.n
        @NotNull
        public String message() {
            return c.a(this.f364568a);
        }
    }

    static {
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(0);
        f364566a = aVar;
        f364567b = b(aVar);
    }

    @NotNull
    public static final com.tencent.rdelivery.reshub.report.a a() {
        return f364566a;
    }

    @NotNull
    public static final n b(@NotNull com.tencent.rdelivery.reshub.report.a toLoadError) {
        Intrinsics.checkParameterIsNotNull(toLoadError, "$this$toLoadError");
        return new a(toLoadError);
    }
}
