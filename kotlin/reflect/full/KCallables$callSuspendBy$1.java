package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0, 0}, l = {74}, m = "callSuspendBy", n = {"$this$callSuspendBy", "args", "kCallable"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes28.dex */
public final class KCallables$callSuspendBy$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KCallables$callSuspendBy$1(Continuation<? super KCallables$callSuspendBy$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return KCallables.callSuspendBy(null, null, this);
    }
}
