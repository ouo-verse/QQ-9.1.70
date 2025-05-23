package d14;

import com.tencent.bugly.common.utils.RecyclablePool;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001d\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0007H\u0016R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b\u001f\u0010\u001eR*\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u0010\u0010$\"\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Ld14/b;", "Lcom/tencent/bugly/common/utils/RecyclablePool$Recyclable;", "", "frameIndex", "", "Ljava/lang/StackTraceElement;", "stackTrace", "", "e", "(I[Ljava/lang/StackTraceElement;)V", "fromStack", "", "f", "([Ljava/lang/StackTraceElement;)Z", "reset", "", "d", "J", "getStartTime", "()J", "setStartTime", "(J)V", "startTime", "getEndTime", "g", "endTime", "I", "c", "()I", "setFrameIndex", "(I)V", h.F, "b", "frameCount", "i", "[Ljava/lang/StackTraceElement;", "()[Ljava/lang/StackTraceElement;", "setStack", "([Ljava/lang/StackTraceElement;)V", "stack", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b extends RecyclablePool.Recyclable {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final a f392658m = new a(b.class, 50);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int frameIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int frameCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private StackTraceElement[] stack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Ld14/b$a;", "", "Ld14/b;", "a", "stackFrame", "", "b", "Ld14/a;", "poolProvider", "Ld14/a;", "<init>", "()V", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: d14.b$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final b a() {
            RecyclablePool c16 = b.f392658m.c();
            Intrinsics.checkExpressionValueIsNotNull(c16, "poolProvider.pool");
            RecyclablePool.Recyclable obtain = c16.obtain(b.class);
            if (obtain != null) {
                return (b) obtain;
            }
            return null;
        }

        public final void b(@NotNull b stackFrame) {
            Intrinsics.checkParameterIsNotNull(stackFrame, "stackFrame");
            RecyclablePool c16 = b.f392658m.c();
            Intrinsics.checkExpressionValueIsNotNull(c16, "poolProvider.pool");
            c16.recycle(stackFrame);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: b, reason: from getter */
    public final int getFrameCount() {
        return this.frameCount;
    }

    /* renamed from: c, reason: from getter */
    public final int getFrameIndex() {
        return this.frameIndex;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final StackTraceElement[] getStack() {
        return this.stack;
    }

    public final void e(int frameIndex, @NotNull StackTraceElement[] stackTrace) {
        Intrinsics.checkParameterIsNotNull(stackTrace, "stackTrace");
        this.frameIndex = frameIndex;
        long currentTimeMillis = System.currentTimeMillis();
        this.startTime = currentTimeMillis;
        this.endTime = currentTimeMillis;
        this.frameCount = 1;
        this.stack = stackTrace;
    }

    public final boolean f(@NotNull StackTraceElement[] fromStack) {
        Intrinsics.checkParameterIsNotNull(fromStack, "fromStack");
        StackTraceElement[] stackTraceElementArr = this.stack;
        if (stackTraceElementArr == null || stackTraceElementArr.length != fromStack.length) {
            return false;
        }
        int length = stackTraceElementArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (true ^ Intrinsics.areEqual(stackTraceElementArr[i3], fromStack[i3])) {
                return false;
            }
        }
        return true;
    }

    public final void g(long j3) {
        this.endTime = j3;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void h(int i3) {
        this.frameCount = i3;
    }

    @Override // com.tencent.bugly.common.utils.RecyclablePool.Recyclable
    public void reset() {
        this.startTime = 0L;
        this.endTime = 0L;
        this.frameCount = 0;
        this.frameIndex = 0;
        this.stack = null;
    }
}
