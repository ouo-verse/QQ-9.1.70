package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010 \u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0000X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class HandlerContext extends HandlerDispatcher {

    @Nullable
    private volatile HandlerContext _immediate;

    @NotNull
    private final Handler handler;

    @NotNull
    private final HandlerContext immediate;
    private final boolean invokeImmediately;

    @Nullable
    private final String name;

    HandlerContext(Handler handler, String str, boolean z16) {
        super(null);
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z16;
        this._immediate = z16 ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
            Unit unit = Unit.INSTANCE;
        }
        this.immediate = handlerContext;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public void mo2047dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        this.handler.post(block);
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof HandlerContext) && ((HandlerContext) other).handler == this.handler) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull final Runnable block, @NotNull CoroutineContext context) {
        long coerceAtMost;
        Handler handler = this.handler;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(timeMillis, DurationKt.MAX_MILLIS);
        handler.postDelayed(block, coerceAtMost);
        return new DisposableHandle() { // from class: kotlinx.coroutines.android.HandlerContext$invokeOnTimeout$1
            @Override // kotlinx.coroutines.DisposableHandle
            public void dispose() {
                Handler handler2;
                handler2 = HandlerContext.this.handler;
                handler2.removeCallbacks(block);
            }
        };
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext context) {
        if (this.invokeImmediately && Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper())) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: scheduleResumeAfterDelay */
    public void mo2048scheduleResumeAfterDelay(long timeMillis, @NotNull final CancellableContinuation<? super Unit> continuation) {
        long coerceAtMost;
        final Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                CancellableContinuation.this.resumeUndispatched(this, Unit.INSTANCE);
            }
        };
        Handler handler = this.handler;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(timeMillis, DurationKt.MAX_MILLIS);
        handler.postDelayed(runnable, coerceAtMost);
        continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Handler handler2;
                handler2 = HandlerContext.this.handler;
                handler2.removeCallbacks(runnable);
            }
        });
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl == null) {
            String str = this.name;
            if (str == null) {
                str = this.handler.toString();
            }
            if (this.invokeImmediately) {
                return Intrinsics.stringPlus(str, ".immediate");
            }
            return str;
        }
        return stringInternalImpl;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.MainCoroutineDispatcher
    @NotNull
    public HandlerContext getImmediate() {
        return this.immediate;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i3 & 2) != 0 ? null : str);
    }

    public HandlerContext(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
