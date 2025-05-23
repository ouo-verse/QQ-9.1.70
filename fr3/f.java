package fr3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lfr3/f;", "", "", "mode", "a", "Lcom/tencent/qmethod/monitor/config/c;", "b", "", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    public f(@NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.name = name;
    }

    @NotNull
    public final f a(int mode) {
        yr3.e.c().s(this.name, mode);
        return this;
    }

    @NotNull
    public final com.tencent.qmethod.monitor.config.c b() {
        return com.tencent.qmethod.monitor.a.f();
    }
}
