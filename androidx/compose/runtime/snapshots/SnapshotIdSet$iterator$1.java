package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {295, 300, 307}, m = "invokeSuspend", n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes39.dex */
final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SnapshotIdSet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = snapshotIdSet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.this$0, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SnapshotIdSet$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00ca  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x00f1 -> B:7:0x00f5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00f4 -> B:7:0x00f5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x009c -> B:21:0x00b8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00b5 -> B:21:0x00b8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0079 -> B:33:0x007c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        SequenceScope sequenceScope;
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1;
        SequenceScope sequenceScope2;
        int length;
        int[] iArr;
        int i3;
        SequenceScope sequenceScope3;
        int i16;
        SequenceScope sequenceScope4;
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$12;
        int i17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i18 = this.label;
        if (i18 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            int[] iArr2 = this.this$0.belowBound;
            if (iArr2 != null) {
                snapshotIdSet$iterator$1 = this;
                sequenceScope2 = sequenceScope;
                length = iArr2.length;
                iArr = iArr2;
                i3 = 0;
                if (i3 < length) {
                }
            } else {
                snapshotIdSet$iterator$1 = this;
                if (snapshotIdSet$iterator$1.this$0.lowerSet != 0) {
                }
                if (snapshotIdSet$iterator$1.this$0.upperSet != 0) {
                }
                return Unit.INSTANCE;
            }
        } else if (i18 == 1) {
            length = this.I$1;
            i3 = this.I$0;
            iArr = (int[]) this.L$1;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            snapshotIdSet$iterator$1 = this;
            i3++;
            if (i3 < length) {
                Integer boxInt = Boxing.boxInt(iArr[i3]);
                snapshotIdSet$iterator$1.L$0 = sequenceScope2;
                snapshotIdSet$iterator$1.L$1 = iArr;
                snapshotIdSet$iterator$1.I$0 = i3;
                snapshotIdSet$iterator$1.I$1 = length;
                snapshotIdSet$iterator$1.label = 1;
                if (sequenceScope2.yield(boxInt, snapshotIdSet$iterator$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i3++;
                if (i3 < length) {
                    sequenceScope = sequenceScope2;
                    if (snapshotIdSet$iterator$1.this$0.lowerSet != 0) {
                        sequenceScope3 = sequenceScope;
                        i16 = 0;
                        if (i16 >= 64) {
                        }
                    }
                    if (snapshotIdSet$iterator$1.this$0.upperSet != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }
        } else {
            if (i18 != 2) {
                if (i18 == 3) {
                    int i19 = this.I$0;
                    sequenceScope4 = (SequenceScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i17 = i19;
                    snapshotIdSet$iterator$12 = this;
                    i17++;
                    if (i17 < 64) {
                        if ((snapshotIdSet$iterator$12.this$0.upperSet & (1 << i17)) != 0) {
                            Integer boxInt2 = Boxing.boxInt(i17 + 64 + snapshotIdSet$iterator$12.this$0.lowerBound);
                            snapshotIdSet$iterator$12.L$0 = sequenceScope4;
                            snapshotIdSet$iterator$12.L$1 = null;
                            snapshotIdSet$iterator$12.I$0 = i17;
                            snapshotIdSet$iterator$12.label = 3;
                            if (sequenceScope4.yield(boxInt2, snapshotIdSet$iterator$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        i17++;
                        if (i17 < 64) {
                        }
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i16 = this.I$0;
            sequenceScope3 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            snapshotIdSet$iterator$1 = this;
            i16++;
            if (i16 >= 64) {
                sequenceScope = sequenceScope3;
                if (snapshotIdSet$iterator$1.this$0.upperSet != 0) {
                    sequenceScope4 = sequenceScope;
                    snapshotIdSet$iterator$12 = snapshotIdSet$iterator$1;
                    i17 = 0;
                    if (i17 < 64) {
                    }
                }
                return Unit.INSTANCE;
            }
            if ((snapshotIdSet$iterator$1.this$0.lowerSet & (1 << i16)) != 0) {
                Integer boxInt3 = Boxing.boxInt(snapshotIdSet$iterator$1.this$0.lowerBound + i16);
                snapshotIdSet$iterator$1.L$0 = sequenceScope3;
                snapshotIdSet$iterator$1.L$1 = null;
                snapshotIdSet$iterator$1.I$0 = i16;
                snapshotIdSet$iterator$1.label = 2;
                if (sequenceScope3.yield(boxInt3, snapshotIdSet$iterator$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            i16++;
            if (i16 >= 64) {
            }
        }
    }
}
