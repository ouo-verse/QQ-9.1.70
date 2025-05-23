package kotlinx.coroutines.internal;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u001a\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\t\u001a\u00020\u0001H\u0007\u001a9\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\u000b2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0010H\u0002\u00a2\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u001a1\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00192\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0010H\u0002\u00a2\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u001a+\u0010\u001f\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u00a2\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000\u00a2\u0006\u0002\u0010\"\u001a,\u0010!\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030#H\u0080\b\u00a2\u0006\u0002\u0010$\u001a \u0010%\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0080\b\u00a2\u0006\u0002\u0010\"\u001a\u001f\u0010&\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000\u00a2\u0006\u0002\u0010\"\u001a1\u0010'\u001a\u0018\u0012\u0004\u0012\u0002H\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00190(\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0002\u00a2\u0006\u0002\u0010)\u001a\u001c\u0010*\u001a\u00020+*\u00060\u0007j\u0002`\b2\n\u0010,\u001a\u00060\u0007j\u0002`\bH\u0002\u001a#\u0010-\u001a\u00020.*\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00192\u0006\u0010/\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u00100\u001a\u0014\u00101\u001a\u00020\u0017*\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000\u001a\u0010\u00102\u001a\u00020+*\u00060\u0007j\u0002`\bH\u0000\u001a\u001b\u00103\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0002\u00a2\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000*\f\b\u0000\u00104\"\u00020\u00142\u00020\u0014*\f\b\u0000\u00105\"\u00020\u00072\u00020\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00066"}, d2 = {"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "message", "createFinalException", "E", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class StackTraceRecoveryKt {

    @NotNull
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String baseContinuationImplClassName;

    @NotNull
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    private static final String stackTraceRecoveryClassName;

    static {
        Object m476constructorimpl;
        Object m476constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = baseContinuationImplClass;
        }
        baseContinuationImplClassName = (String) m476constructorimpl;
        try {
            m476constructorimpl2 = Result.m476constructorimpl(StackTraceRecoveryKt.class.getCanonicalName());
        } catch (Throwable th6) {
            Result.Companion companion3 = Result.INSTANCE;
            m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th6));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl2) != null) {
            m476constructorimpl2 = stackTraceRecoveryClass;
        }
        stackTraceRecoveryClassName = (String) m476constructorimpl2;
    }

    @InternalCoroutinesApi
    @NotNull
    public static final StackTraceElement artificialFrame(@NotNull String str) {
        return new StackTraceElement(Intrinsics.stringPlus("\b\b\b(", str), "\b", "\b", -1);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E e16) {
        boolean z16;
        Throwable cause = e16.getCause();
        if (cause != null && Intrinsics.areEqual(cause.getClass(), e16.getClass())) {
            StackTraceElement[] stackTrace = e16.getStackTrace();
            int length = stackTrace.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (isArtificial(stackTrace[i3])) {
                        z16 = true;
                        break;
                    }
                    i3++;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                return TuplesKt.to(cause, stackTrace);
            }
            return TuplesKt.to(e16, new StackTraceElement[0]);
        }
        return TuplesKt.to(e16, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E createFinalException(E e16, E e17, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(artificialFrame("Coroutine boundary"));
        StackTraceElement[] stackTrace = e16.getStackTrace();
        int frameIndex = frameIndex(stackTrace, baseContinuationImplClassName);
        int i3 = 0;
        if (frameIndex == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e17.setStackTrace((StackTraceElement[]) array);
                return e17;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + frameIndex];
        if (frameIndex > 0) {
            int i16 = 0;
            while (true) {
                int i17 = i16 + 1;
                stackTraceElementArr[i16] = stackTrace[i16];
                if (i17 >= frameIndex) {
                    break;
                }
                i16 = i17;
            }
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            stackTraceElementArr[i3 + frameIndex] = it.next();
            i3++;
        }
        e17.setStackTrace(stackTraceElementArr);
        return e17;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    private static final boolean elementWiseEquals(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.areEqual(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && Intrinsics.areEqual(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && Intrinsics.areEqual(stackTraceElement.getClassName(), stackTraceElement2.getClassName())) {
            return true;
        }
        return false;
    }

    private static final int frameIndex(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (Intrinsics.areEqual(str, stackTraceElementArr[i3].getClassName())) {
                return i3;
            }
        }
        return -1;
    }

    public static final void initCause(@NotNull Throwable th5, @NotNull Throwable th6) {
        th5.initCause(th6);
    }

    public static final boolean isArtificial(@NotNull StackTraceElement stackTraceElement) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
        return startsWith$default;
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (isArtificial(stackTraceElementArr[i3])) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        int i16 = i3 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i16 > length2) {
            return;
        }
        while (true) {
            int i17 = length2 - 1;
            if (elementWiseEquals(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 != i16) {
                length2 = i17;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> E recoverFromStackFrame(E e16, CoroutineStackFrame coroutineStackFrame) {
        Pair causeAndStacktrace = causeAndStacktrace(e16);
        Throwable th5 = (Throwable) causeAndStacktrace.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) causeAndStacktrace.component2();
        Throwable tryCopyException = ExceptionsConstuctorKt.tryCopyException(th5);
        if (tryCopyException == null) {
            return e16;
        }
        if (!Intrinsics.areEqual(tryCopyException.getMessage(), th5.getMessage())) {
            return e16;
        }
        ArrayDeque<StackTraceElement> createStackTrace = createStackTrace(coroutineStackFrame);
        if (createStackTrace.isEmpty()) {
            return e16;
        }
        if (th5 != e16) {
            mergeRecoveredTraces(stackTraceElementArr, createStackTrace);
        }
        return (E) createFinalException(th5, tryCopyException, createStackTrace);
    }

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E e16) {
        return e16;
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E e16) {
        int i3;
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e16.getStackTrace();
        int length = stackTrace.length;
        int frameIndex = frameIndex(stackTrace, stackTraceRecoveryClassName);
        int i16 = frameIndex + 1;
        int frameIndex2 = frameIndex(stackTrace, baseContinuationImplClassName);
        if (frameIndex2 == -1) {
            i3 = 0;
        } else {
            i3 = length - frameIndex2;
        }
        int i17 = (length - frameIndex) - i3;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i17];
        for (int i18 = 0; i18 < i17; i18++) {
            if (i18 == 0) {
                stackTraceElement = artificialFrame("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i16 + i18) - 1];
            }
            stackTraceElementArr[i18] = stackTraceElement;
        }
        e16.setStackTrace(stackTraceElementArr);
        return e16;
    }

    @NotNull
    public static final <E extends Throwable> E unwrapImpl(@NotNull E e16) {
        E e17 = (E) e16.getCause();
        if (e17 != null && Intrinsics.areEqual(e17.getClass(), e16.getClass())) {
            StackTraceElement[] stackTrace = e16.getStackTrace();
            int length = stackTrace.length;
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (isArtificial(stackTrace[i3])) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (z16) {
                return e17;
            }
        }
        return e16;
    }

    @NotNull
    public static final <E extends Throwable> E recoverStackTrace(@NotNull E e16, @NotNull Continuation<?> continuation) {
        return e16;
    }

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    @NotNull
    public static final <E extends Throwable> E unwrap(@NotNull E e16) {
        return e16;
    }

    @Nullable
    public static final Object recoverAndThrow(@NotNull Throwable th5, @NotNull Continuation<?> continuation) {
        throw th5;
    }

    private static final Object recoverAndThrow$$forInline(Throwable th5, Continuation<?> continuation) {
        throw th5;
    }
}
