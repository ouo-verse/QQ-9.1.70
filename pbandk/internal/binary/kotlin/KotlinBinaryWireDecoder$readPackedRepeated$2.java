package pbandk.internal.binary.kotlin;

import c45.b;
import e45.d;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [T] */
@DebugMetadata(c = "pbandk.internal.binary.kotlin.KotlinBinaryWireDecoder$readPackedRepeated$2", f = "KotlinBinaryWireDecoder.kt", i = {0, 0}, l = {275}, m = "invokeSuspend", n = {"$this$sequence", "oldLimit"}, s = {"L$0", "L$1"})
/* loaded from: classes34.dex */
public final class KotlinBinaryWireDecoder$readPackedRepeated$2<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ b $type;
    public /* synthetic */ Object L$0;
    public Integer L$1;
    public int label;
    public final /* synthetic */ KotlinBinaryWireDecoder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinBinaryWireDecoder$readPackedRepeated$2(KotlinBinaryWireDecoder kotlinBinaryWireDecoder, b bVar, Continuation<? super KotlinBinaryWireDecoder$readPackedRepeated$2> continuation) {
        super(2, continuation);
        this.this$0 = kotlinBinaryWireDecoder;
        this.$type = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KotlinBinaryWireDecoder$readPackedRepeated$2 kotlinBinaryWireDecoder$readPackedRepeated$2 = new KotlinBinaryWireDecoder$readPackedRepeated$2(this.this$0, this.$type, continuation);
        kotlinBinaryWireDecoder$readPackedRepeated$2.L$0 = obj;
        return kotlinBinaryWireDecoder$readPackedRepeated$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((KotlinBinaryWireDecoder$readPackedRepeated$2) create((SequenceScope) obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Integer o16;
        SequenceScope sequenceScope;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            KotlinBinaryWireDecoder kotlinBinaryWireDecoder = this.this$0;
            o16 = kotlinBinaryWireDecoder.o((int) kotlinBinaryWireDecoder.u());
            sequenceScope = sequenceScope2;
        } else if (i3 == 1) {
            o16 = this.L$1;
            SequenceScope sequenceScope3 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            sequenceScope = sequenceScope3;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (!this.this$0.n()) {
            Object b16 = d.b(this.$type, this.this$0);
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type T of pbandk.internal.binary.kotlin.KotlinBinaryWireDecoder.readPackedRepeated");
            this.L$0 = sequenceScope;
            this.L$1 = o16;
            this.label = 1;
            if (sequenceScope.yield(b16, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.f425881d = o16;
        return Unit.INSTANCE;
    }
}
