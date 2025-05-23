package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/ChildJob;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1}, l = {952, 954}, m = "invokeSuspend", n = {"this_$iv", "cur$iv"}, s = {"L$1", "L$2"})
/* loaded from: classes28.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ChildJob>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0068  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x006a -> B:6:0x0080). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x007d -> B:6:0x0080). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        NodeList list;
        SequenceScope sequenceScope;
        JobSupport$children$1 jobSupport$children$1;
        LockFreeLinkedListHead lockFreeLinkedListHead;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) this.L$2;
                    lockFreeLinkedListHead = (LockFreeLinkedListHead) this.L$1;
                    sequenceScope = (SequenceScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    jobSupport$children$1 = this;
                    lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                    if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                        if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                            ChildJob childJob = ((ChildHandleNode) lockFreeLinkedListNode).childJob;
                            jobSupport$children$1.L$0 = sequenceScope;
                            jobSupport$children$1.L$1 = lockFreeLinkedListHead;
                            jobSupport$children$1.L$2 = lockFreeLinkedListNode;
                            jobSupport$children$1.label = 2;
                            if (sequenceScope.yield(childJob, jobSupport$children$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                        if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof ChildHandleNode) {
                ChildJob childJob2 = ((ChildHandleNode) state$kotlinx_coroutines_core).childJob;
                this.label = 1;
                if (sequenceScope2.yield(childJob2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && (list = ((Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                sequenceScope = sequenceScope2;
                jobSupport$children$1 = this;
                lockFreeLinkedListHead = list;
                lockFreeLinkedListNode = (LockFreeLinkedListNode) list.getNext();
                if (!Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead)) {
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super ChildJob> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((JobSupport$children$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
