package fn0;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lfn0/a;", "", "", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "sKeyIndex", "c", "I", "()I", "ENTER_FROM_FLOAT_WINDOW", "<init>", "()V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f399890a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicInteger sKeyIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int ENTER_FROM_FLOAT_WINDOW;

    static {
        a aVar = new a();
        f399890a = aVar;
        sKeyIndex = new AtomicInteger(0);
        ENTER_FROM_FLOAT_WINDOW = aVar.a();
    }

    a() {
    }

    private final int a() {
        return sKeyIndex.incrementAndGet();
    }

    public final int b() {
        return ENTER_FROM_FLOAT_WINDOW;
    }
}
