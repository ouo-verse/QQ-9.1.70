package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0007\u001a\u00020\b\"\u000e\b\u0000\u0010\t\u0018\u0001*\u00060\u0001j\u0002`\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\b0\fH\u0086\bJ\u0010\u0010\r\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\nH\u0014J\u0006\u0010\u000e\u001a\u00020\u0004J\r\u0010\u000f\u001a\u00020\bH\u0000\u00a2\u0006\u0002\b\u0010R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "isRemoved", "forEach", "", "T", "Lkotlinx/coroutines/internal/Node;", "block", "Lkotlin/Function1;", "nextIfRemoved", "remove", "validate", "validate$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public final /* synthetic */ void forEach(Function1 block) {
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                block.invoke(lockFreeLinkedListNode);
            }
        }
    }

    public final boolean isEmpty() {
        if (getNext() == this) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean isRemoved() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @Nullable
    protected LockFreeLinkedListNode nextIfRemoved() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final boolean remove() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    public final void validate$kotlinx_coroutines_core() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this;
        LockFreeLinkedListHead lockFreeLinkedListHead2 = (LockFreeLinkedListNode) getNext();
        while (!Intrinsics.areEqual(lockFreeLinkedListHead2, this)) {
            LockFreeLinkedListNode nextNode = lockFreeLinkedListHead2.getNextNode();
            lockFreeLinkedListHead2.validateNode$kotlinx_coroutines_core(lockFreeLinkedListHead, nextNode);
            lockFreeLinkedListHead = lockFreeLinkedListHead2;
            lockFreeLinkedListHead2 = nextNode;
        }
        validateNode$kotlinx_coroutines_core(lockFreeLinkedListHead, (LockFreeLinkedListNode) getNext());
    }
}
