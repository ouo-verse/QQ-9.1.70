package androidx.compose.runtime.snapshots;

import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0013\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\r\u0010\u0016\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u001a\u001a\u00020\rH\u0002R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/snapshots/StateListIterator;", "T", "", "list", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "offset", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;I)V", "index", VasPerfReportUtils.WHILE_GET_LIST, "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "modification", "add", "", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "validateModification", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class StateListIterator<T> implements ListIterator<T>, KMutableListIterator {
    private int index;
    private final SnapshotStateList<T> list;
    private int modification;

    public StateListIterator(SnapshotStateList<T> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.index = i3 - 1;
        this.modification = list.getModification$runtime_release();
    }

    private final void validateModification() {
        if (this.list.getModification$runtime_release() != this.modification) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public void add(T element) {
        validateModification();
        this.list.add(this.index + 1, element);
        this.index++;
        this.modification = this.list.getModification$runtime_release();
    }

    public final SnapshotStateList<T> getList() {
        return this.list;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.index < this.list.size() - 1;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.index >= 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        validateModification();
        int i3 = this.index + 1;
        SnapshotStateListKt.validateRange(i3, this.list.size());
        T t16 = this.list.get(i3);
        this.index = i3;
        return t16;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index + 1;
    }

    @Override // java.util.ListIterator
    public T previous() {
        validateModification();
        SnapshotStateListKt.validateRange(this.index, this.list.size());
        this.index--;
        return this.list.get(this.index);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.index;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        validateModification();
        this.list.remove(this.index);
        this.index--;
        this.modification = this.list.getModification$runtime_release();
    }

    @Override // java.util.ListIterator
    public void set(T element) {
        validateModification();
        this.list.set(this.index, element);
        this.modification = this.list.getModification$runtime_release();
    }
}
