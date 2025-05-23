package org.jbox2d.pooling.normal;

import org.jbox2d.pooling.IOrderedStack;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class CircleStack<E> implements IOrderedStack<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Object[] container;
    private int index;
    private final Object[] pool;
    private final int size;

    public CircleStack(int i3, int i16) {
        this.size = i3;
        this.pool = new Object[i3];
        for (int i17 = 0; i17 < i3; i17++) {
            this.pool[i17] = newInstance();
        }
        this.index = 0;
        this.container = new Object[i16];
    }

    protected abstract E newInstance();

    @Override // org.jbox2d.pooling.IOrderedStack
    public final E pop() {
        int i3 = this.index + 1;
        this.index = i3;
        if (i3 >= this.size) {
            this.index = 0;
        }
        return (E) this.pool[this.index];
    }

    @Override // org.jbox2d.pooling.IOrderedStack
    public final E[] pop(int i3) {
        int i16 = this.index;
        int i17 = i16 + i3;
        int i18 = this.size;
        if (i17 < i18) {
            System.arraycopy(this.pool, i16, this.container, 0, i3);
            this.index += i3;
        } else {
            int i19 = (i16 + i3) - i18;
            int i26 = i3 - i19;
            System.arraycopy(this.pool, i16, this.container, 0, i26);
            System.arraycopy(this.pool, 0, this.container, i26, i19);
            this.index = i19;
        }
        return (E[]) this.container;
    }

    @Override // org.jbox2d.pooling.IOrderedStack
    public void push(int i3) {
    }
}
