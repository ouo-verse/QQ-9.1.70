package d14;

import com.tencent.bugly.common.utils.RecyclablePool;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u001b\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u000b2\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0012\u0004\u0012\u00020\u000b0\u0010J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Ld14/c;", "Lcom/tencent/bugly/common/utils/RecyclablePool$Recyclable;", "", "sliceIndex", "", "Ljava/lang/StackTraceElement;", "stackTrace", "Ld14/b;", "d", "(I[Ljava/lang/StackTraceElement;)Ld14/b;", "stackFrame", "", "b", "f", "c", "([Ljava/lang/StackTraceElement;)V", "Lkotlin/Function1;", "", "callback", "e", "reset", "Ljava/util/List;", "stackFrameQueue", "Ld14/b;", "curStackFrame", "I", "<init>", "()V", "i", "a", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c extends RecyclablePool.Recyclable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<b> stackFrameQueue = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private b curStackFrame;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int sliceIndex;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final a f392664h = new a(c.class, 35);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Ld14/c$a;", "", "Ld14/c;", "a", "stackQueue", "", "b", "Ld14/a;", "poolProvider", "Ld14/a;", "<init>", "()V", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: d14.c$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final c a() {
            RecyclablePool c16 = c.f392664h.c();
            Intrinsics.checkExpressionValueIsNotNull(c16, "poolProvider.pool");
            RecyclablePool.Recyclable obtain = c16.obtain(c.class);
            if (obtain != null) {
                return (c) obtain;
            }
            return null;
        }

        public final void b(@NotNull c stackQueue) {
            Intrinsics.checkParameterIsNotNull(stackQueue, "stackQueue");
            RecyclablePool c16 = c.f392664h.c();
            Intrinsics.checkExpressionValueIsNotNull(c16, "poolProvider.pool");
            c16.recycle(stackQueue);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void b(b stackFrame) {
        if (stackFrame != null) {
            stackFrame.g(System.currentTimeMillis());
            this.stackFrameQueue.add(stackFrame);
        }
    }

    private final b d(int sliceIndex, StackTraceElement[] stackTrace) {
        b a16 = b.INSTANCE.a();
        if (a16 != null) {
            a16.e(sliceIndex, stackTrace);
        }
        return a16;
    }

    private final void f() {
        this.curStackFrame = null;
    }

    public final void c(@NotNull StackTraceElement[] stackTrace) {
        Intrinsics.checkParameterIsNotNull(stackTrace, "stackTrace");
        b bVar = this.curStackFrame;
        if (bVar == null) {
            this.curStackFrame = d(this.sliceIndex, stackTrace);
        } else if (bVar.f(stackTrace)) {
            bVar.h(bVar.getFrameCount() + 1);
        } else {
            b(bVar);
            this.curStackFrame = d(this.sliceIndex, stackTrace);
        }
        this.sliceIndex++;
    }

    public final void e(@NotNull Function1<? super List<b>, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        b(this.curStackFrame);
        f();
        callback.invoke(this.stackFrameQueue);
    }

    @Override // com.tencent.bugly.common.utils.RecyclablePool.Recyclable
    public void reset() {
        b bVar = this.curStackFrame;
        if (bVar != null) {
            b.INSTANCE.b(bVar);
        }
        f();
        int size = this.stackFrameQueue.size();
        for (int i3 = 0; i3 < size; i3++) {
            b.INSTANCE.b(this.stackFrameQueue.get(i3));
        }
        this.stackFrameQueue.clear();
        this.sliceIndex = 0;
    }
}
