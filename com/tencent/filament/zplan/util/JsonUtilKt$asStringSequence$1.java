package com.tencent.filament.zplan.util;

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.util.JsonUtilKt$asStringSequence$1", f = "JsonUtil.kt", i = {0}, l = {10}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class JsonUtilKt$asStringSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONArray $this_asStringSequence;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonUtilKt$asStringSequence$1(JSONArray jSONArray, Continuation continuation) {
        super(2, continuation);
        this.$this_asStringSequence = jSONArray;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        JsonUtilKt$asStringSequence$1 jsonUtilKt$asStringSequence$1 = new JsonUtilKt$asStringSequence$1(this.$this_asStringSequence, completion);
        jsonUtilKt$asStringSequence$1.L$0 = obj;
        return jsonUtilKt$asStringSequence$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super String> sequenceScope, Continuation<? super Unit> continuation) {
        return ((JsonUtilKt$asStringSequence$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0047 -> B:5:0x004a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0039 -> B:5:0x004a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int length;
        int i3;
        SequenceScope sequenceScope;
        JsonUtilKt$asStringSequence$1 jsonUtilKt$asStringSequence$1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                length = this.I$1;
                i3 = this.I$0;
                sequenceScope = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                jsonUtilKt$asStringSequence$1 = this;
                i3++;
                if (i3 < length) {
                    String optString = jsonUtilKt$asStringSequence$1.$this_asStringSequence.optString(i3);
                    if (optString != null) {
                        jsonUtilKt$asStringSequence$1.L$0 = sequenceScope;
                        jsonUtilKt$asStringSequence$1.I$0 = i3;
                        jsonUtilKt$asStringSequence$1.I$1 = length;
                        jsonUtilKt$asStringSequence$1.label = 1;
                        if (sequenceScope.yield(optString, jsonUtilKt$asStringSequence$1) == coroutine_suspended) {
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
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            length = this.$this_asStringSequence.length();
            i3 = 0;
            sequenceScope = sequenceScope2;
            jsonUtilKt$asStringSequence$1 = this;
            if (i3 < length) {
            }
        }
    }
}
