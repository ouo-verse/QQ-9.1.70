package kotlinx.coroutines.selects;

import com.google.common.util.concurrent.b;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020Y2\b\u0012\u0004\u0012\u00028\u00000Z2\b\u0012\u0004\u0012\u00028\u00000[2\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060Bj\u0002`C:\u0004TUVWB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ.\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0082\b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u001d\u0010\fJ8\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020#H\u0016\u00a2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b(\u0010\u001cJ \u0010+\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016\u00a2\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016\u00a2\u0006\u0004\b1\u00102J\u001b\u00105\u001a\u0004\u0018\u00010\u000e2\b\u00104\u001a\u0004\u0018\u000103H\u0016\u00a2\u0006\u0004\b5\u00106J5\u00108\u001a\u00020\b*\u0002072\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u00109JG\u00108\u001a\u00020\b\"\u0004\b\u0001\u0010:*\b\u0012\u0004\u0012\u00028\u00010;2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0<H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u0010=J[\u00108\u001a\u00020\b\"\u0004\b\u0001\u0010>\"\u0004\b\u0002\u0010:*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020?2\u0006\u0010@\u001a\u00028\u00012\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0<H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u0010AR\u001e\u0010F\u001a\n\u0018\u00010Bj\u0004\u0018\u0001`C8V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010ER\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bK\u0010LR\u0016\u0010N\u001a\u0002008V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u00102R(\u0010R\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\nR\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010S\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006X"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "handle", "", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "doAfterSelect", "()V", "Lkotlin/Function0;", "", "value", "block", "doResume", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "e", "handleBuilderException", "(Ljava/lang/Throwable;)V", "initCancellability", "", "timeMillis", "Lkotlin/Function1;", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "exception", "resumeSelectWithException", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isSelected", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "parentHandle", "Lkotlin/coroutines/Continuation;", "AtomicSelectOp", "DisposeNode", "PairSelectOp", "SelectOnCancelling", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;"}, k = 1, mv = {1, 5, 1}, xi = 48)
@PublishedApi
/* renamed from: kotlinx.coroutines.selects.SelectBuilderImpl, reason: from toString */
/* loaded from: classes28.dex */
public final class SelectInstance<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, kotlinx.coroutines.selects.SelectInstance<R>, Continuation<R>, CoroutineStackFrame {

    @NotNull
    private final Continuation<R> uCont;
    static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectInstance.class, Object.class, "_state");
    static final /* synthetic */ AtomicReferenceFieldUpdater _result$FU = AtomicReferenceFieldUpdater.newUpdater(SelectInstance.class, Object.class, "_result");

    /* renamed from: _state, reason: from toString */
    @NotNull
    volatile /* synthetic */ Object state = SelectKt.getNOT_SELECTED();

    /* renamed from: _result, reason: from toString */
    @NotNull
    volatile /* synthetic */ Object result = SelectKt.access$getUNDECIDED$p();

    @NotNull
    private volatile /* synthetic */ Object _parentHandle = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "impl", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;)V", "opSequence", "", "getOpSequence", "()J", "complete", "", "affected", "failure", "completeSelect", "prepare", "prepareSelectOp", "toString", "", "undoPrepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: kotlinx.coroutines.selects.SelectBuilderImpl$AtomicSelectOp, reason: from toString */
    /* loaded from: classes28.dex */
    public static final class AtomicSelectOp extends AtomicOp<Object> {

        @JvmField
        @NotNull
        public final AtomicDesc desc;

        @JvmField
        @NotNull
        public final SelectInstance<?> impl;
        private final long opSequence = SelectKt.access$getSelectOpSequenceNumber$p().next();

        public AtomicSelectOp(@NotNull SelectInstance<?> selectInstance, @NotNull AtomicDesc atomicDesc) {
            this.impl = selectInstance;
            this.desc = atomicDesc;
            atomicDesc.setAtomicOp(this);
        }

        private final void completeSelect(Object failure) {
            boolean z16;
            Object not_selected;
            if (failure == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                not_selected = null;
            } else {
                not_selected = SelectKt.getNOT_SELECTED();
            }
            if (b.a(SelectInstance._state$FU, this.impl, this, not_selected) && z16) {
                this.impl.doAfterSelect();
            }
        }

        private final Object prepareSelectOp() {
            SelectInstance<?> selectInstance = this.impl;
            while (true) {
                Object obj = selectInstance.state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(this.impl);
                } else if (obj == SelectKt.getNOT_SELECTED()) {
                    if (b.a(SelectInstance._state$FU, this.impl, SelectKt.getNOT_SELECTED(), this)) {
                        return null;
                    }
                } else {
                    return SelectKt.getALREADY_SELECTED();
                }
            }
        }

        private final void undoPrepare() {
            b.a(SelectInstance._state$FU, this.impl, this, SelectKt.getNOT_SELECTED());
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(@Nullable Object affected, @Nullable Object failure) {
            completeSelect(failure);
            this.desc.complete(this, failure);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public long getOpSequence() {
            return this.opSequence;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        @Nullable
        public Object prepare(@Nullable Object affected) {
            Object prepareSelectOp;
            if (affected == null && (prepareSelectOp = prepareSelectOp()) != null) {
                return prepareSelectOp;
            }
            try {
                return this.desc.prepare(this);
            } catch (Throwable th5) {
                if (affected == null) {
                    undoPrepare();
                }
                throw th5;
            }
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @NotNull
        public String toString() {
            return "AtomicSelectOp(sequence=" + getOpSequence() + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: kotlinx.coroutines.selects.SelectBuilderImpl$DisposeNode */
    /* loaded from: classes28.dex */
    public static final class DisposeNode extends LockFreeLinkedListNode {

        @JvmField
        @NotNull
        public final DisposableHandle handle;

        public DisposeNode(@NotNull DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: kotlinx.coroutines.selects.SelectBuilderImpl$PairSelectOp */
    /* loaded from: classes28.dex */
    public static final class PairSelectOp extends OpDescriptor {

        @JvmField
        @NotNull
        public final LockFreeLinkedListNode.PrepareOp otherOp;

        public PairSelectOp(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.otherOp = prepareOp;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @NotNull
        public AtomicOp<?> getAtomicOp() {
            return this.otherOp.getAtomicOp();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @Nullable
        public Object perform(@Nullable Object affected) {
            Object not_selected;
            if (affected != null) {
                SelectInstance selectInstance = (SelectInstance) affected;
                this.otherOp.finishPrepare();
                Object decide = this.otherOp.getAtomicOp().decide(null);
                if (decide == null) {
                    not_selected = this.otherOp.desc;
                } else {
                    not_selected = SelectKt.getNOT_SELECTED();
                }
                b.a(SelectInstance._state$FU, selectInstance, this, not_selected);
                return decide;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;)V", "invoke", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: kotlinx.coroutines.selects.SelectBuilderImpl$SelectOnCancelling */
    /* loaded from: classes28.dex */
    public final class SelectOnCancelling extends JobCancellingNode {
        public SelectOnCancelling() {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
            invoke2(th5);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(@Nullable Throwable cause) {
            if (SelectInstance.this.trySelect()) {
                SelectInstance.this.resumeSelectWithException(getJob().getCancellationException());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectInstance(@NotNull Continuation<? super R> continuation) {
        this.uCont = continuation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAfterSelect() {
        DisposableHandle parentHandle = getParentHandle();
        if (parentHandle != null) {
            parentHandle.dispose();
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof DisposeNode) {
                ((DisposeNode) lockFreeLinkedListNode).handle.dispose();
            }
        }
    }

    private final void doResume(Function0<? extends Object> value, Function0<Unit> block) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        while (true) {
            Object obj = this.result;
            if (obj != SelectKt.access$getUNDECIDED$p()) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (b.a(atomicReferenceFieldUpdater, this, coroutine_suspended2, SelectKt.access$getRESUMED$p())) {
                        block.invoke();
                        return;
                    }
                } else {
                    throw new IllegalStateException("Already resumed");
                }
            } else {
                if (b.a(_result$FU, this, SelectKt.access$getUNDECIDED$p(), value.invoke())) {
                    return;
                }
            }
        }
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) this._parentHandle;
    }

    private final void initCancellability() {
        Job job = (Job) getContext().get(Job.INSTANCE);
        if (job == null) {
            return;
        }
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new SelectOnCancelling(), 2, null);
        setParentHandle(invokeOnCompletion$default);
        if (isSelected()) {
            invokeOnCompletion$default.dispose();
        }
    }

    private final void setParentHandle(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnSelect(@NotNull DisposableHandle handle) {
        DisposeNode disposeNode = new DisposeNode(handle);
        if (!isSelected()) {
            addLast(disposeNode);
            if (!isSelected()) {
                return;
            }
        }
        handle.dispose();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.uCont;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.uCont.getContext();
    }

    @PublishedApi
    @Nullable
    public final Object getResult() {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        if (!isSelected()) {
            initCancellability();
        }
        Object obj = this.result;
        if (obj == SelectKt.access$getUNDECIDED$p()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
            Object access$getUNDECIDED$p = SelectKt.access$getUNDECIDED$p();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (b.a(atomicReferenceFieldUpdater, this, access$getUNDECIDED$p, coroutine_suspended)) {
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended2;
            }
            obj = this.result;
        }
        if (obj != SelectKt.access$getRESUMED$p()) {
            if (!(obj instanceof CompletedExceptionally)) {
                return obj;
            }
            throw ((CompletedExceptionally) obj).cause;
        }
        throw new IllegalStateException("Already resumed");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @PublishedApi
    public final void handleBuilderException(@NotNull Throwable e16) {
        if (trySelect()) {
            Result.Companion companion = Result.INSTANCE;
            resumeWith(Result.m476constructorimpl(ResultKt.createFailure(e16)));
        } else if (!(e16 instanceof CancellationException)) {
            Object result = getResult();
            if (!(result instanceof CompletedExceptionally) || ((CompletedExceptionally) result).cause != e16) {
                CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), e16);
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean isSelected() {
        while (true) {
            Object obj = this.state;
            if (obj == SelectKt.getNOT_SELECTED()) {
                return false;
            }
            if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else {
                return true;
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long timeMillis, @NotNull final Function1<? super Continuation<? super R>, ? extends Object> block) {
        if (timeMillis <= 0) {
            if (trySelect()) {
                UndispatchedKt.startCoroutineUnintercepted(block, getCompletion());
            }
        } else {
            disposeOnSelect(DelayKt.getDelay(getContext()).invokeOnTimeout(timeMillis, new Runnable() { // from class: kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (SelectInstance.this.trySelect()) {
                        CancellableKt.startCoroutineCancellable(block, SelectInstance.this.getCompletion());
                    }
                }
            }, getContext()));
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @Nullable
    public Object performAtomicTrySelect(@NotNull AtomicDesc desc) {
        return new AtomicSelectOp(this, desc).perform(null);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void resumeSelectWithException(@NotNull Throwable exception) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Continuation intercepted;
        while (true) {
            Object obj = this.result;
            if (obj != SelectKt.access$getUNDECIDED$p()) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (b.a(atomicReferenceFieldUpdater, this, coroutine_suspended2, SelectKt.access$getRESUMED$p())) {
                        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.uCont);
                        Result.Companion companion = Result.INSTANCE;
                        intercepted.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(exception)));
                        return;
                    }
                } else {
                    throw new IllegalStateException("Already resumed");
                }
            } else {
                if (b.a(_result$FU, this, SelectKt.access$getUNDECIDED$p(), new CompletedExceptionally(exception, false, 2, null))) {
                    return;
                }
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object result) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        while (true) {
            Object obj = this.result;
            if (obj != SelectKt.access$getUNDECIDED$p()) {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (b.a(atomicReferenceFieldUpdater, this, coroutine_suspended2, SelectKt.access$getRESUMED$p())) {
                        if (Result.m482isFailureimpl(result)) {
                            Continuation<R> continuation = this.uCont;
                            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(result);
                            Intrinsics.checkNotNull(m479exceptionOrNullimpl);
                            continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(m479exceptionOrNullimpl)));
                            return;
                        }
                        this.uCont.resumeWith(result);
                        return;
                    }
                } else {
                    throw new IllegalStateException("Already resumed");
                }
            } else {
                if (b.a(_result$FU, this, SelectKt.access$getUNDECIDED$p(), CompletionStateKt.toState$default(result, null, 1, null))) {
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        return "SelectInstance(state=" + this.state + ", result=" + this.result + ')';
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect() {
        Object trySelectOther = trySelectOther(null);
        if (trySelectOther == CancellableContinuationImplKt.RESUME_TOKEN) {
            return true;
        }
        if (trySelectOther == null) {
            return false;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected trySelectIdempotent result ", trySelectOther).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0031, code lost:
    
        doAfterSelect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0036, code lost:
    
        return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
     */
    @Override // kotlinx.coroutines.selects.SelectInstance
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object trySelectOther(@Nullable LockFreeLinkedListNode.PrepareOp otherOp) {
        while (true) {
            Object obj = this.state;
            if (obj == SelectKt.getNOT_SELECTED()) {
                if (otherOp == null) {
                    if (b.a(_state$FU, this, SelectKt.getNOT_SELECTED(), null)) {
                        break;
                    }
                } else {
                    PairSelectOp pairSelectOp = new PairSelectOp(otherOp);
                    if (b.a(_state$FU, this, SelectKt.getNOT_SELECTED(), pairSelectOp)) {
                        Object perform = pairSelectOp.perform(this);
                        if (perform != null) {
                            return perform;
                        }
                    }
                }
            } else if (obj instanceof OpDescriptor) {
                if (otherOp != null) {
                    AtomicOp<?> atomicOp = otherOp.getAtomicOp();
                    if ((atomicOp instanceof AtomicSelectOp) && ((AtomicSelectOp) atomicOp).impl == this) {
                        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
                    }
                    if (atomicOp.isEarlierThan((OpDescriptor) obj)) {
                        return AtomicKt.RETRY_ATOMIC;
                    }
                }
                ((OpDescriptor) obj).perform(this);
            } else {
                if (otherOp == null || obj != otherOp.desc) {
                    return null;
                }
                return CancellableContinuationImplKt.RESUME_TOKEN;
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(@NotNull SelectClause0 selectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectClause0.registerSelectClause0(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.registerSelectClause1(this, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, P p16, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause2.registerSelectClause2(this, p16, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @NotNull
    public Continuation<R> getCompletion() {
        return this;
    }
}
