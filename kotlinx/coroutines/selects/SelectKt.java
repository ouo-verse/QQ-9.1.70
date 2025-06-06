package kotlinx.coroutines.selects;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u001f\b\u0004\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u00a2\u0006\u0002\b\u0016H\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\u0017\u001aN\u0010\u0018\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u001c\u0010\u001b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001d\u0010\u001e\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u0016\u0010\t\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u000e8\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001f"}, d2 = {"ALREADY_SELECTED", "", "getALREADY_SELECTED$annotations", "()V", "getALREADY_SELECTED", "()Ljava/lang/Object;", "NOT_SELECTED", "getNOT_SELECTED$annotations", "getNOT_SELECTED", "RESUMED", "getRESUMED$annotations", "UNDECIDED", "getUNDECIDED$annotations", "selectOpSequenceNumber", "Lkotlinx/coroutines/selects/SeqNumber;", "getSelectOpSequenceNumber$annotations", "select", BdhLogUtil.LogTag.Tag_Req, "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTimeout", "timeout", "Lkotlin/time/Duration;", "block", "Lkotlin/coroutines/Continuation;", "onTimeout-8Mi8wO0", "(Lkotlinx/coroutines/selects/SelectBuilder;JLkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SelectKt {

    @NotNull
    private static final Object NOT_SELECTED = new Symbol("NOT_SELECTED");

    @NotNull
    private static final Object ALREADY_SELECTED = new Symbol("ALREADY_SELECTED");

    @NotNull
    private static final Object UNDECIDED = new Symbol("UNDECIDED");

    @NotNull
    private static final Object RESUMED = new Symbol("RESUMED");

    @NotNull
    private static final SeqNumber selectOpSequenceNumber = new SeqNumber();

    public static final /* synthetic */ Object access$getRESUMED$p() {
        return RESUMED;
    }

    public static final /* synthetic */ SeqNumber access$getSelectOpSequenceNumber$p() {
        return selectOpSequenceNumber;
    }

    public static final /* synthetic */ Object access$getUNDECIDED$p() {
        return UNDECIDED;
    }

    @NotNull
    public static final Object getALREADY_SELECTED() {
        return ALREADY_SELECTED;
    }

    @NotNull
    public static final Object getNOT_SELECTED() {
        return NOT_SELECTED;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ExperimentalTime
    @ExperimentalCoroutinesApi
    /* renamed from: onTimeout-8Mi8wO0 */
    public static final <R> void m2059onTimeout8Mi8wO0(@NotNull SelectBuilder<? super R> selectBuilder, long j3, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectBuilder.onTimeout(DelayKt.m1989toDelayMillisLRDsOJo(j3), function1);
    }

    @Nullable
    public static final <R> Object select(@NotNull Function1<? super SelectBuilder<? super R>, Unit> function1, @NotNull Continuation<? super R> continuation) {
        Object coroutine_suspended;
        SelectInstance selectInstance = new SelectInstance(continuation);
        try {
            function1.invoke(selectInstance);
        } catch (Throwable th5) {
            selectInstance.handleBuilderException(th5);
        }
        Object result = selectInstance.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private static final <R> Object select$$forInline(Function1<? super SelectBuilder<? super R>, Unit> function1, Continuation<? super R> continuation) {
        Object coroutine_suspended;
        InlineMarker.mark(0);
        SelectInstance selectInstance = new SelectInstance(continuation);
        try {
            function1.invoke(selectInstance);
        } catch (Throwable th5) {
            selectInstance.handleBuilderException(th5);
        }
        Object result = selectInstance.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static /* synthetic */ void getALREADY_SELECTED$annotations() {
    }

    public static /* synthetic */ void getNOT_SELECTED$annotations() {
    }

    private static /* synthetic */ void getRESUMED$annotations() {
    }

    private static /* synthetic */ void getSelectOpSequenceNumber$annotations() {
    }

    private static /* synthetic */ void getUNDECIDED$annotations() {
    }
}
