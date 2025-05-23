package kotlinx.coroutines.intrinsics;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001a>\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001ay\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\b*\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2\u0006\u0010\u000e\u001a\u0002H\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u00032%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"runSafely", "", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function2;", "receiver", "onCancellation", "", "Lkotlin/ParameterName;", "name", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class CancellableKt {
    private static final void runSafely(Continuation<?> continuation, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Throwable th5) {
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
    }

    @InternalCoroutinesApi
    public static final <T> void startCoroutineCancellable(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Continuation createCoroutineUnintercepted;
        Continuation intercepted;
        try {
            createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function1, continuation);
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
            Result.Companion companion = Result.INSTANCE;
            DispatchedContinuationKt.resumeCancellableWith$default(intercepted, Result.m476constructorimpl(Unit.INSTANCE), null, 2, null);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
    }

    public static /* synthetic */ void startCoroutineCancellable$default(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        startCoroutineCancellable(function2, obj, continuation, function1);
    }

    public static final <R, T> void startCoroutineCancellable(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r16, @NotNull Continuation<? super T> continuation, @Nullable Function1<? super Throwable, Unit> function1) {
        Continuation createCoroutineUnintercepted;
        Continuation intercepted;
        try {
            createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r16, continuation);
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(createCoroutineUnintercepted);
            Result.Companion companion = Result.INSTANCE;
            DispatchedContinuationKt.resumeCancellableWith(intercepted, Result.m476constructorimpl(Unit.INSTANCE), function1);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
    }

    public static final void startCoroutineCancellable(@NotNull Continuation<? super Unit> continuation, @NotNull Continuation<?> continuation2) {
        Continuation intercepted;
        try {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            Result.Companion companion = Result.INSTANCE;
            DispatchedContinuationKt.resumeCancellableWith$default(intercepted, Result.m476constructorimpl(Unit.INSTANCE), null, 2, null);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
    }
}
