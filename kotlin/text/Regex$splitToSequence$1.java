package kotlin.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {276, 284, 288}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes28.dex */
public final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $limit;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Regex this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$splitToSequence$1(Regex regex, CharSequence charSequence, int i3, Continuation<? super Regex$splitToSequence$1> continuation) {
        super(2, continuation);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$limit = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, continuation);
        regex$splitToSequence$1.L$0 = obj;
        return regex$splitToSequence$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009f A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0071 -> B:13:0x0074). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Pattern pattern;
        Regex$splitToSequence$1 regex$splitToSequence$1;
        SequenceScope sequenceScope;
        Matcher matcher;
        int i3;
        String obj2;
        String obj3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i3 = this.I$0;
                Matcher matcher2 = (Matcher) this.L$1;
                sequenceScope = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                regex$splitToSequence$1 = this;
                matcher = matcher2;
                r5 = matcher.end();
                i3++;
                if (i3 != regex$splitToSequence$1.$limit - 1 || !matcher.find()) {
                    CharSequence charSequence = regex$splitToSequence$1.$input;
                    obj3 = charSequence.subSequence(r5, charSequence.length()).toString();
                    regex$splitToSequence$1.L$0 = null;
                    regex$splitToSequence$1.L$1 = null;
                    regex$splitToSequence$1.label = 3;
                    if (sequenceScope.yield(obj3, regex$splitToSequence$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                obj2 = regex$splitToSequence$1.$input.subSequence(r5, matcher.start()).toString();
                regex$splitToSequence$1.L$0 = sequenceScope;
                regex$splitToSequence$1.L$1 = matcher;
                regex$splitToSequence$1.I$0 = i3;
                regex$splitToSequence$1.label = 2;
                if (sequenceScope.yield(obj2, regex$splitToSequence$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                r5 = matcher.end();
                i3++;
                if (i3 != regex$splitToSequence$1.$limit - 1) {
                }
                CharSequence charSequence2 = regex$splitToSequence$1.$input;
                obj3 = charSequence2.subSequence(r5, charSequence2.length()).toString();
                regex$splitToSequence$1.L$0 = null;
                regex$splitToSequence$1.L$1 = null;
                regex$splitToSequence$1.label = 3;
                if (sequenceScope.yield(obj3, regex$splitToSequence$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            pattern = this.this$0.nativePattern;
            Matcher matcher3 = pattern.matcher(this.$input);
            if (this.$limit != 1 && matcher3.find()) {
                int i17 = 0;
                regex$splitToSequence$1 = this;
                sequenceScope = sequenceScope2;
                matcher = matcher3;
                i3 = 0;
                obj2 = regex$splitToSequence$1.$input.subSequence(i17, matcher.start()).toString();
                regex$splitToSequence$1.L$0 = sequenceScope;
                regex$splitToSequence$1.L$1 = matcher;
                regex$splitToSequence$1.I$0 = i3;
                regex$splitToSequence$1.label = 2;
                if (sequenceScope.yield(obj2, regex$splitToSequence$1) == coroutine_suspended) {
                }
                i17 = matcher.end();
                i3++;
                if (i3 != regex$splitToSequence$1.$limit - 1) {
                }
                CharSequence charSequence22 = regex$splitToSequence$1.$input;
                obj3 = charSequence22.subSequence(i17, charSequence22.length()).toString();
                regex$splitToSequence$1.L$0 = null;
                regex$splitToSequence$1.L$1 = null;
                regex$splitToSequence$1.label = 3;
                if (sequenceScope.yield(obj3, regex$splitToSequence$1) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            String obj4 = this.$input.toString();
            this.label = 1;
            if (sequenceScope2.yield(obj4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super String> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Regex$splitToSequence$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
