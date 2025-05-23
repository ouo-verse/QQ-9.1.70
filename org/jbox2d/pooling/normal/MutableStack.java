package org.jbox2d.pooling.normal;

import org.jbox2d.pooling.IDynamicStack;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class MutableStack<E> implements IDynamicStack<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int size;
    private Object[] stack = null;
    private int index = 0;

    public MutableStack(int i3) {
        extendStack(i3);
    }

    private void extendStack(int i3) {
        Object[] objArr = new Object[i3];
        Object[] objArr2 = this.stack;
        if (objArr2 != null) {
            System.arraycopy(objArr2, 0, objArr, 0, this.size);
        }
        for (int i16 = 0; i16 < i3; i16++) {
            objArr[i16] = newInstance();
        }
        this.stack = objArr;
        this.size = i3;
    }

    protected abstract E newInstance();

    @Override // org.jbox2d.pooling.IDynamicStack
    public final E pop() {
        int i3 = this.index;
        int i16 = this.size;
        if (i3 >= i16) {
            extendStack(i16 * 2);
        }
        Object[] objArr = this.stack;
        int i17 = this.index;
        this.index = i17 + 1;
        return (E) objArr[i17];
    }

    @Override // org.jbox2d.pooling.IDynamicStack
    public final void push(E e16) {
        Object[] objArr = this.stack;
        int i3 = this.index - 1;
        this.index = i3;
        objArr[i3] = e16;
    }
}
