package com.tencent.mobileqq.zplan.aio.couple;

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
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.filament.zplan.util.JsonUtilKt$asSequence$1", f = "JsonUtil.kt", i = {0}, l = {16}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
/* loaded from: classes35.dex */
public final class CoupleAvatarLayout$getBodyType$$inlined$asSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super JSONObject>, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONArray $this_asSequence;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarLayout$getBodyType$$inlined$asSequence$1(JSONArray jSONArray, Continuation continuation) {
        super(2, continuation);
        this.$this_asSequence = jSONArray;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        CoupleAvatarLayout$getBodyType$$inlined$asSequence$1 coupleAvatarLayout$getBodyType$$inlined$asSequence$1 = new CoupleAvatarLayout$getBodyType$$inlined$asSequence$1(this.$this_asSequence, completion);
        coupleAvatarLayout$getBodyType$$inlined$asSequence$1.L$0 = obj;
        return coupleAvatarLayout$getBodyType$$inlined$asSequence$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super JSONObject> sequenceScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarLayout$getBodyType$$inlined$asSequence$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x004a -> B:5:0x004d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x003b -> B:5:0x004d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int length;
        int i3;
        SequenceScope sequenceScope;
        CoupleAvatarLayout$getBodyType$$inlined$asSequence$1 coupleAvatarLayout$getBodyType$$inlined$asSequence$1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            length = this.$this_asSequence.length();
            i3 = 0;
            sequenceScope = sequenceScope2;
            coupleAvatarLayout$getBodyType$$inlined$asSequence$1 = this;
            if (i3 < length) {
            }
        } else if (i16 == 1) {
            length = this.I$1;
            i3 = this.I$0;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coupleAvatarLayout$getBodyType$$inlined$asSequence$1 = this;
            i3++;
            if (i3 < length) {
                JSONObject jSONObject = (JSONObject) coupleAvatarLayout$getBodyType$$inlined$asSequence$1.$this_asSequence.opt(i3);
                if (jSONObject != null) {
                    coupleAvatarLayout$getBodyType$$inlined$asSequence$1.L$0 = sequenceScope;
                    coupleAvatarLayout$getBodyType$$inlined$asSequence$1.I$0 = i3;
                    coupleAvatarLayout$getBodyType$$inlined$asSequence$1.I$1 = length;
                    coupleAvatarLayout$getBodyType$$inlined$asSequence$1.label = 1;
                    if (sequenceScope.yield(jSONObject, coupleAvatarLayout$getBodyType$$inlined$asSequence$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                i3++;
                if (i3 < length) {
                }
            } else {
                return Unit.INSTANCE;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
