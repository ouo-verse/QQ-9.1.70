package kotlinx.coroutines.internal;

import com.google.common.util.concurrent.b;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@InternalCoroutinesApi
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\f\b\u0017\u0018\u00002\u00020C:\u0005JKLMNB\u0007\u00a2\u0006\u0004\b\u0001\u0010\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u000b\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00a2\u0006\u0004\b\u000b\u0010\fJ4\u0010\u000f\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\rH\u0086\b\u00a2\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0011\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\r2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u001a\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0082\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\f\b\u0000\u0010\u001c*\u00060\u0000j\u0002`\u00032\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00030 \u00a2\u0006\u0004\b!\u0010\"J \u0010$\u001a\u00060\u0000j\u0002`\u00032\n\u0010#\u001a\u00060\u0000j\u0002`\u0003H\u0082\u0010\u00a2\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00052\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0002\u00a2\u0006\u0004\b&\u0010\u0007J\r\u0010'\u001a\u00020\u0005\u00a2\u0006\u0004\b'\u0010\u0002J\u000f\u0010(\u001a\u00020\u0005H\u0001\u00a2\u0006\u0004\b(\u0010\u0002J,\u0010*\u001a\u00020)2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0081\b\u00a2\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0014\u00a2\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b.\u0010/J.\u00100\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001c\u0018\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\rH\u0086\b\u00a2\u0006\u0004\b0\u00101J\u0015\u00102\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003\u00a2\u0006\u0004\b2\u0010-J\u0017\u00103\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0001\u00a2\u0006\u0004\b3\u0010-J\u000f\u00105\u001a\u000204H\u0002\u00a2\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H\u0016\u00a2\u0006\u0004\b8\u00109J/\u0010<\u001a\u00020;2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00032\u0006\u0010:\u001a\u00020)H\u0001\u00a2\u0006\u0004\b<\u0010=J'\u0010A\u001a\u00020\u00052\n\u0010>\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0000\u00a2\u0006\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020\t8V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010/R\u0013\u0010\u0013\u001a\u00020C8F@\u0006\u00a2\u0006\u0006\u001a\u0004\bD\u0010ER\u0017\u0010G\u001a\u00060\u0000j\u0002`\u00038F@\u0006\u00a2\u0006\u0006\u001a\u0004\bF\u0010-R\u0017\u0010I\u001a\u00060\u0000j\u0002`\u00038F@\u0006\u00a2\u0006\u0006\u001a\u0004\bH\u0010-\u00a8\u0006O"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public class LockFreeLinkedListNode {
    static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
    static final /* synthetic */ AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");

    @NotNull
    volatile /* synthetic */ Object _next = this;

    @NotNull
    volatile /* synthetic */ Object _prev = this;

    @NotNull
    private volatile /* synthetic */ Object _removedRef = null;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020!B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\n\u0010\t\u001a\u00060\u0001j\u0002`\u0002H\u0014\u00a2\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\u00112\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\t\u001a\u00020\u0010H\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00102\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\n\u0010\t\u001a\u00060\u0001j\u0002`\u0002H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028D@\u0004X\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u00028\u00008\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u001a\u0010\u001f\u001a\u00060\u0001j\u0002`\u00028D@\u0004X\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\u0004\u001a\u00060\u0001j\u0002`\u00028\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001d\u00a8\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "T", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "node", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "next", "", "finishOnSuccess", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getOriginalNext", "originalNext", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");

        @NotNull
        private volatile /* synthetic */ Object _affectedNode = null;

        @JvmField
        @NotNull
        public final T node;

        @JvmField
        @NotNull
        public final LockFreeLinkedListNode queue;

        public AddLastDesc(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull T t16) {
            this.queue = lockFreeLinkedListNode;
            this.node = t16;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected void finishOnSuccess(@NotNull LockFreeLinkedListNode affected, @NotNull LockFreeLinkedListNode next) {
            this.node.finishAdd(this.queue);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(@NotNull PrepareOp prepareOp) {
            b.a(_affectedNode$FU, this, null, prepareOp.affected);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        protected final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @NotNull
        /* renamed from: getOriginalNext, reason: from getter */
        protected final LockFreeLinkedListNode getQueue() {
            return this.queue;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected boolean retry(@NotNull LockFreeLinkedListNode affected, @NotNull Object next) {
            if (next != this.queue) {
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        protected final LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor op5) {
            return this.queue.correctPrev(op5);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @NotNull
        public Object updatedNext(@NotNull LockFreeLinkedListNode affected, @NotNull LockFreeLinkedListNode next) {
            T t16 = this.node;
            b.a(LockFreeLinkedListNode._prev$FU, t16, t16, affected);
            T t17 = this.node;
            b.a(LockFreeLinkedListNode._next$FU, t17, t17, this.queue);
            return this.node;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @PublishedApi
    /* loaded from: classes28.dex */
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {

        @JvmField
        @NotNull
        public final LockFreeLinkedListNode newNode;

        @JvmField
        @Nullable
        public LockFreeLinkedListNode oldNext;

        public CondAddOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.newNode = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(@NotNull LockFreeLinkedListNode affected, @Nullable Object failure) {
            boolean z16 = failure == null;
            LockFreeLinkedListNode lockFreeLinkedListNode = z16 ? this.newNode : this.oldNext;
            if (lockFreeLinkedListNode != null && b.a(LockFreeLinkedListNode._next$FU, affected, this, lockFreeLinkedListNode) && z16) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.newNode;
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.oldNext;
                Intrinsics.checkNotNull(lockFreeLinkedListNode3);
                lockFreeLinkedListNode2.finishAdd(lockFreeLinkedListNode3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "next", "desc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "finishPrepare", "", "perform", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class PrepareOp extends OpDescriptor {

        @JvmField
        @NotNull
        public final LockFreeLinkedListNode affected;

        @JvmField
        @NotNull
        public final AbstractAtomicDesc desc;

        @JvmField
        @NotNull
        public final LockFreeLinkedListNode next;

        public PrepareOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2, @NotNull AbstractAtomicDesc abstractAtomicDesc) {
            this.affected = lockFreeLinkedListNode;
            this.next = lockFreeLinkedListNode2;
            this.desc = abstractAtomicDesc;
        }

        public final void finishPrepare() {
            this.desc.finishPrepare(this);
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @NotNull
        public AtomicOp<?> getAtomicOp() {
            return this.desc.getAtomicOp();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @Nullable
        public Object perform(@Nullable Object affected) {
            Object obj;
            Object obj2;
            if (affected != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) affected;
                Object onPrepare = this.desc.onPrepare(this);
                Object obj3 = LockFreeLinkedList_commonKt.REMOVE_PREPARED;
                if (onPrepare == obj3) {
                    LockFreeLinkedListNode lockFreeLinkedListNode2 = this.next;
                    if (b.a(LockFreeLinkedListNode._next$FU, lockFreeLinkedListNode, this, lockFreeLinkedListNode2.removed())) {
                        this.desc.onRemoved(lockFreeLinkedListNode);
                        lockFreeLinkedListNode2.correctPrev(null);
                    }
                    return obj3;
                }
                if (onPrepare != null) {
                    obj = getAtomicOp().decide(onPrepare);
                } else {
                    obj = getAtomicOp().get_consensus();
                }
                if (obj == AtomicKt.NO_DECISION) {
                    obj2 = getAtomicOp();
                } else if (obj == null) {
                    obj2 = this.desc.updatedNext(lockFreeLinkedListNode, this.next);
                } else {
                    obj2 = this.next;
                }
                b.a(LockFreeLinkedListNode._next$FU, lockFreeLinkedListNode, this, obj2);
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        @NotNull
        public String toString() {
            return "PrepareOp(op=" + getAtomicOp() + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (com.google.common.util.concurrent.b.a(kotlinx.coroutines.internal.LockFreeLinkedListNode._next$FU, r3, r2, ((kotlinx.coroutines.internal.Removed) r4).ref) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LockFreeLinkedListNode correctPrev(OpDescriptor op5) {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) this._prev;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            while (true) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = null;
                while (true) {
                    Object obj = lockFreeLinkedListNode2._next;
                    if (obj == this) {
                        if (lockFreeLinkedListNode == lockFreeLinkedListNode2) {
                            return lockFreeLinkedListNode2;
                        }
                        if (b.a(_prev$FU, this, lockFreeLinkedListNode, lockFreeLinkedListNode2)) {
                            return lockFreeLinkedListNode2;
                        }
                    } else {
                        if (isRemoved()) {
                            return null;
                        }
                        if (obj == op5) {
                            return lockFreeLinkedListNode2;
                        }
                        if (obj instanceof OpDescriptor) {
                            if (op5 != null && op5.isEarlierThan((OpDescriptor) obj)) {
                                return null;
                            }
                            ((OpDescriptor) obj).perform(lockFreeLinkedListNode2);
                        } else if (obj instanceof Removed) {
                            if (lockFreeLinkedListNode3 != null) {
                                break;
                            }
                            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) lockFreeLinkedListNode2._prev;
                        } else {
                            lockFreeLinkedListNode3 = lockFreeLinkedListNode2;
                            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) obj;
                        }
                    }
                }
                lockFreeLinkedListNode2 = lockFreeLinkedListNode3;
            }
        }
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode current) {
        while (current.isRemoved()) {
            current = (LockFreeLinkedListNode) current._prev;
        }
        return current;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishAdd(LockFreeLinkedListNode next) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) next._prev;
            if (getNext() != next) {
                return;
            }
        } while (!b.a(_prev$FU, next, lockFreeLinkedListNode, this));
        if (isRemoved()) {
            next.correctPrev(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Removed removed() {
        Removed removed = (Removed) this._removedRef;
        if (removed == null) {
            Removed removed2 = new Removed(this);
            _removedRef$FU.lazySet(this, removed2);
            return removed2;
        }
        return removed;
    }

    public final void addLast(@NotNull LockFreeLinkedListNode node) {
        do {
        } while (!getPrevNode().addNext(node, this));
    }

    public final boolean addLastIf(@NotNull LockFreeLinkedListNode node, @NotNull Function0<Boolean> condition) {
        int tryCondAddNext;
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(condition, node);
        do {
            tryCondAddNext = getPrevNode().tryCondAddNext(node, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    public final boolean addLastIfPrev(@NotNull LockFreeLinkedListNode node, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> predicate) {
        LockFreeLinkedListNode prevNode;
        do {
            prevNode = getPrevNode();
            if (!predicate.invoke(prevNode).booleanValue()) {
                return false;
            }
        } while (!prevNode.addNext(node, this));
        return true;
    }

    public final boolean addLastIfPrevAndIf(@NotNull LockFreeLinkedListNode node, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> predicate, @NotNull Function0<Boolean> condition) {
        int tryCondAddNext;
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(condition, node);
        do {
            LockFreeLinkedListNode prevNode = getPrevNode();
            if (!predicate.invoke(prevNode).booleanValue()) {
                return false;
            }
            tryCondAddNext = prevNode.tryCondAddNext(node, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    @PublishedApi
    public final boolean addNext(@NotNull LockFreeLinkedListNode node, @NotNull LockFreeLinkedListNode next) {
        _prev$FU.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(node, next);
        if (!b.a(atomicReferenceFieldUpdater, this, next, node)) {
            return false;
        }
        node.finishAdd(next);
        return true;
    }

    public final boolean addOneIfEmpty(@NotNull LockFreeLinkedListNode node) {
        _prev$FU.lazySet(node, this);
        _next$FU.lazySet(node, this);
        while (getNext() == this) {
            if (b.a(_next$FU, this, this, node)) {
                node.finishAdd(this);
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(@NotNull T node) {
        return new AddLastDesc<>(this, node);
    }

    @NotNull
    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc<>(this);
    }

    @NotNull
    public final Object getNext() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    @NotNull
    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    @NotNull
    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode correctPrev = correctPrev(null);
        if (correctPrev == null) {
            return findPrevNonRemoved((LockFreeLinkedListNode) this._prev);
        }
        return correctPrev;
    }

    public final void helpRemove() {
        ((Removed) getNext()).ref.correctPrev(null);
    }

    @PublishedApi
    public final void helpRemovePrev() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            Object next = lockFreeLinkedListNode.getNext();
            if (!(next instanceof Removed)) {
                lockFreeLinkedListNode.correctPrev(null);
                return;
            }
            lockFreeLinkedListNode = ((Removed) next).ref;
        }
    }

    public boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    @PublishedApi
    @NotNull
    public final CondAddOp makeCondAddOp(@NotNull LockFreeLinkedListNode node, @NotNull Function0<Boolean> condition) {
        return new LockFreeLinkedListNode$makeCondAddOp$1(condition, node);
    }

    @Nullable
    protected LockFreeLinkedListNode nextIfRemoved() {
        Removed removed;
        Object next = getNext();
        if (next instanceof Removed) {
            removed = (Removed) next;
        } else {
            removed = null;
        }
        if (removed == null) {
            return null;
        }
        return removed.ref;
    }

    public boolean remove() {
        if (removeOrNext() == null) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object removeFirstIfIsInstanceOfOrPeekIf(Function1 predicate) {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) getNext();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(lockFreeLinkedListNode instanceof Object)) {
                return null;
            }
            if (((Boolean) predicate.invoke(lockFreeLinkedListNode)).booleanValue() && !lockFreeLinkedListNode.isRemoved()) {
                return lockFreeLinkedListNode;
            }
            LockFreeLinkedListNode removeOrNext = lockFreeLinkedListNode.removeOrNext();
            if (removeOrNext == null) {
                return lockFreeLinkedListNode;
            }
            removeOrNext.helpRemovePrev();
        }
    }

    @Nullable
    public final LockFreeLinkedListNode removeFirstOrNull() {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) getNext();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.remove()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.helpRemove();
        }
    }

    @PublishedApi
    @Nullable
    public final LockFreeLinkedListNode removeOrNext() {
        Object next;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            next = getNext();
            if (next instanceof Removed) {
                return ((Removed) next).ref;
            }
            if (next == this) {
                return (LockFreeLinkedListNode) next;
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
        } while (!b.a(_next$FU, this, next, lockFreeLinkedListNode.removed()));
        lockFreeLinkedListNode.correctPrev(null);
        return null;
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append((Object) getClass().getSimpleName());
        sb5.append('@');
        sb5.append((Object) Integer.toHexString(System.identityHashCode(this)));
        return sb5.toString();
    }

    @PublishedApi
    public final int tryCondAddNext(@NotNull LockFreeLinkedListNode node, @NotNull LockFreeLinkedListNode next, @NotNull CondAddOp condAdd) {
        _prev$FU.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.oldNext = next;
        if (!b.a(atomicReferenceFieldUpdater, this, next, condAdd)) {
            return 0;
        }
        if (condAdd.perform(this) == null) {
            return 1;
        }
        return 2;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020(B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0014\u00a2\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\f2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\u00132\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038D@\u0004X\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038D@\u0004X\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0007X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010!R\u0019\u0010&\u001a\u00028\u00008F@\u0006\u00a2\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "", "failure", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getResult", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
        private static final /* synthetic */ AtomicReferenceFieldUpdater _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");

        @NotNull
        private volatile /* synthetic */ Object _affectedNode = null;

        @NotNull
        private volatile /* synthetic */ Object _originalNext = null;

        @JvmField
        @NotNull
        public final LockFreeLinkedListNode queue;

        public RemoveFirstDesc(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.queue = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        protected Object failure(@NotNull LockFreeLinkedListNode affected) {
            if (affected == this.queue) {
                return LockFreeLinkedListKt.getLIST_EMPTY();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final void finishOnSuccess(@NotNull LockFreeLinkedListNode affected, @NotNull LockFreeLinkedListNode next) {
            next.correctPrev(null);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(@NotNull PrepareOp prepareOp) {
            b.a(_affectedNode$FU, this, null, prepareOp.affected);
            b.a(_originalNext$FU, this, null, prepareOp.next);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        protected final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        /* renamed from: getOriginalNext */
        protected final LockFreeLinkedListNode getQueue() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        public final T getResult() {
            T t16 = (T) getAffectedNode();
            Intrinsics.checkNotNull(t16);
            return t16;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final boolean retry(@NotNull LockFreeLinkedListNode affected, @NotNull Object next) {
            if (!(next instanceof Removed)) {
                return false;
            }
            ((Removed) next).ref.helpRemovePrev();
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @Nullable
        protected final LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor op5) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
            while (true) {
                Object obj = lockFreeLinkedListNode._next;
                if (obj instanceof OpDescriptor) {
                    OpDescriptor opDescriptor = (OpDescriptor) obj;
                    if (op5.isEarlierThan(opDescriptor)) {
                        return null;
                    }
                    opDescriptor.perform(this.queue);
                } else {
                    return (LockFreeLinkedListNode) obj;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        @NotNull
        public final Object updatedNext(@NotNull LockFreeLinkedListNode affected, @NotNull LockFreeLinkedListNode next) {
            return next.removed();
        }

        public static /* synthetic */ void getResult$annotations() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u0005H\u0014J \u0010\u0011\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0012\u001a\u00060\u0004j\u0002`\u0005H$J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010\u0017\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\u001c\u0010\u0019\u001a\u00020\u001a2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0018\u0010\u001b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\f\u001a\u00020\u001cH\u0014J \u0010\u001d\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0012\u001a\u00060\u0004j\u0002`\u0005H&R\u001a\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "()V", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "", "affected", "finishOnSuccess", "next", "finishPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "onPrepare", "onRemoved", "prepare", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, "", "takeAffectedNode", "Lkotlinx/coroutines/internal/OpDescriptor;", "updatedNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void complete(@NotNull AtomicOp<?> op5, @Nullable Object failure) {
            boolean z16;
            LockFreeLinkedListNode queue;
            Object obj;
            if (failure == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            if (affectedNode == null || (queue = getQueue()) == null) {
                return;
            }
            if (z16) {
                obj = updatedNext(affectedNode, queue);
            } else {
                obj = queue;
            }
            if (b.a(LockFreeLinkedListNode._next$FU, affectedNode, op5, obj) && z16) {
                finishOnSuccess(affectedNode, queue);
            }
        }

        @Nullable
        protected Object failure(@NotNull LockFreeLinkedListNode affected) {
            return null;
        }

        protected abstract void finishOnSuccess(@NotNull LockFreeLinkedListNode affected, @NotNull LockFreeLinkedListNode next);

        public abstract void finishPrepare(@NotNull PrepareOp prepareOp);

        @Nullable
        protected abstract LockFreeLinkedListNode getAffectedNode();

        @Nullable
        /* renamed from: getOriginalNext */
        protected abstract LockFreeLinkedListNode getQueue();

        @Nullable
        public Object onPrepare(@NotNull PrepareOp prepareOp) {
            finishPrepare(prepareOp);
            return null;
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        @Nullable
        public final Object prepare(@NotNull AtomicOp<?> op5) {
            while (true) {
                LockFreeLinkedListNode takeAffectedNode = takeAffectedNode(op5);
                if (takeAffectedNode == null) {
                    return AtomicKt.RETRY_ATOMIC;
                }
                Object obj = takeAffectedNode._next;
                if (obj == op5 || op5.isDecided()) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    OpDescriptor opDescriptor = (OpDescriptor) obj;
                    if (op5.isEarlierThan(opDescriptor)) {
                        return AtomicKt.RETRY_ATOMIC;
                    }
                    opDescriptor.perform(takeAffectedNode);
                } else {
                    Object failure = failure(takeAffectedNode);
                    if (failure != null) {
                        return failure;
                    }
                    if (retry(takeAffectedNode, obj)) {
                        continue;
                    } else {
                        PrepareOp prepareOp = new PrepareOp(takeAffectedNode, (LockFreeLinkedListNode) obj, this);
                        if (b.a(LockFreeLinkedListNode._next$FU, takeAffectedNode, obj, prepareOp)) {
                            try {
                                if (prepareOp.perform(takeAffectedNode) != LockFreeLinkedList_commonKt.REMOVE_PREPARED) {
                                    return null;
                                }
                            } catch (Throwable th5) {
                                b.a(LockFreeLinkedListNode._next$FU, takeAffectedNode, prepareOp, obj);
                                throw th5;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        protected boolean retry(@NotNull LockFreeLinkedListNode affected, @NotNull Object next) {
            return false;
        }

        @Nullable
        protected LockFreeLinkedListNode takeAffectedNode(@NotNull OpDescriptor op5) {
            LockFreeLinkedListNode affectedNode = getAffectedNode();
            Intrinsics.checkNotNull(affectedNode);
            return affectedNode;
        }

        @NotNull
        public abstract Object updatedNext(@NotNull LockFreeLinkedListNode affected, @NotNull LockFreeLinkedListNode next);

        public void onRemoved(@NotNull LockFreeLinkedListNode affected) {
        }
    }

    public final void validateNode$kotlinx_coroutines_core(@NotNull LockFreeLinkedListNode prev, @NotNull LockFreeLinkedListNode next) {
    }
}
