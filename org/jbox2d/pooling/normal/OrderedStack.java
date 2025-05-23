package org.jbox2d.pooling.normal;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class OrderedStack<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Object[] container;
    private int index;
    private final Object[] pool;
    private final int size;

    public OrderedStack(int i3, int i16) {
        this.size = i3;
        this.pool = new Object[i3];
        for (int i17 = 0; i17 < i3; i17++) {
            this.pool[i17] = newInstance();
        }
        this.index = 0;
        this.container = new Object[i16];
    }

    protected abstract E newInstance();

    public final E pop() {
        Object[] objArr = this.pool;
        int i3 = this.index;
        this.index = i3 + 1;
        return (E) objArr[i3];
    }

    public final void push(int i3) {
        this.index -= i3;
    }

    public final E[] pop(int i3) {
        System.arraycopy(this.pool, this.index, this.container, 0, i3);
        this.index += i3;
        return (E[]) this.container;
    }
}
