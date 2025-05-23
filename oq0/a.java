package oq0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qq0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Loq0/a;", "Lol3/a;", "Lqq0/b$d;", "a", "Lqq0/b$d;", "b", "()Lqq0/b$d;", "intent", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", "context", "<init>", "(Lqq0/b$d;Lcom/tencent/aio/api/runtime/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements ol3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b.d intent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a context;

    public a(@NotNull b.d intent, @NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(context, "context");
        this.intent = intent;
        this.context = context;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.aio.api.runtime.a getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final b.d getIntent() {
        return this.intent;
    }
}
