package kotlinx.coroutines;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BZ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J&\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J`\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\u001a\u0010\u001d\u001a\u00020\u000b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010\n\u001a\u00020\u0007J\t\u0010 \u001a\u00020!H\u00d6\u0001R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R-\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lkotlinx/coroutines/CompletedContinuation;", "", "result", "cancelHandler", "Lkotlinx/coroutines/CancelHandler;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "idempotentResume", "cancelCause", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelled", "", "getCancelled", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "invokeHandlers", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
final /* data */ class CompletedContinuation {

    @JvmField
    @Nullable
    public final Throwable cancelCause;

    @JvmField
    @Nullable
    public final CancelHandler cancelHandler;

    @JvmField
    @Nullable
    public final Object idempotentResume;

    @JvmField
    @Nullable
    public final Function1<Throwable, Unit> onCancellation;

    @JvmField
    @Nullable
    public final Object result;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedContinuation(@Nullable Object obj, @Nullable CancelHandler cancelHandler, @Nullable Function1<? super Throwable, Unit> function1, @Nullable Object obj2, @Nullable Throwable th5) {
        this.result = obj;
        this.cancelHandler = cancelHandler;
        this.onCancellation = function1;
        this.idempotentResume = obj2;
        this.cancelCause = th5;
    }

    public static /* synthetic */ CompletedContinuation copy$default(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th5, int i3, Object obj3) {
        if ((i3 & 1) != 0) {
            obj = completedContinuation.result;
        }
        if ((i3 & 2) != 0) {
            cancelHandler = completedContinuation.cancelHandler;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        if ((i3 & 4) != 0) {
            function1 = completedContinuation.onCancellation;
        }
        Function1 function12 = function1;
        if ((i3 & 8) != 0) {
            obj2 = completedContinuation.idempotentResume;
        }
        Object obj4 = obj2;
        if ((i3 & 16) != 0) {
            th5 = completedContinuation.cancelCause;
        }
        return completedContinuation.copy(obj, cancelHandler2, function12, obj4, th5);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Object getResult() {
        return this.result;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final CancelHandler getCancelHandler() {
        return this.cancelHandler;
    }

    @Nullable
    public final Function1<Throwable, Unit> component3() {
        return this.onCancellation;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Object getIdempotentResume() {
        return this.idempotentResume;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Throwable getCancelCause() {
        return this.cancelCause;
    }

    @NotNull
    public final CompletedContinuation copy(@Nullable Object result, @Nullable CancelHandler cancelHandler, @Nullable Function1<? super Throwable, Unit> onCancellation, @Nullable Object idempotentResume, @Nullable Throwable cancelCause) {
        return new CompletedContinuation(result, cancelHandler, onCancellation, idempotentResume, cancelCause);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) other;
        if (Intrinsics.areEqual(this.result, completedContinuation.result) && Intrinsics.areEqual(this.cancelHandler, completedContinuation.cancelHandler) && Intrinsics.areEqual(this.onCancellation, completedContinuation.onCancellation) && Intrinsics.areEqual(this.idempotentResume, completedContinuation.idempotentResume) && Intrinsics.areEqual(this.cancelCause, completedContinuation.cancelCause)) {
            return true;
        }
        return false;
    }

    public final boolean getCancelled() {
        if (this.cancelCause != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        Object obj = this.result;
        int i3 = 0;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i16 = hashCode * 31;
        CancelHandler cancelHandler = this.cancelHandler;
        if (cancelHandler == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = cancelHandler.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Function1<Throwable, Unit> function1 = this.onCancellation;
        if (function1 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = function1.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Object obj2 = this.idempotentResume;
        if (obj2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = obj2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Throwable th5 = this.cancelCause;
        if (th5 != null) {
            i3 = th5.hashCode();
        }
        return i19 + i3;
    }

    public final void invokeHandlers(@NotNull CancellableContinuationImpl<?> cont, @NotNull Throwable cause) {
        CancelHandler cancelHandler = this.cancelHandler;
        if (cancelHandler != null) {
            cont.callCancelHandler(cancelHandler, cause);
        }
        Function1<Throwable, Unit> function1 = this.onCancellation;
        if (function1 != null) {
            cont.callOnCancellation(function1, cause);
        }
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }

    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i3 & 2) != 0 ? null : cancelHandler, (i3 & 4) != 0 ? null : function1, (i3 & 8) != 0 ? null : obj2, (i3 & 16) != 0 ? null : th5);
    }
}
