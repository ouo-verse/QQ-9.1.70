package org.jbox2d.pooling.stacks;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DynamicIntStack {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int position = 0;
    private int size;
    private int[] stack;

    public DynamicIntStack(int i3) {
        this.stack = new int[i3];
        this.size = i3;
    }

    public int getCount() {
        return this.position;
    }

    public int pop() {
        int[] iArr = this.stack;
        int i3 = this.position - 1;
        this.position = i3;
        return iArr[i3];
    }

    public void push(int i3) {
        int i16 = this.position;
        int i17 = this.size;
        if (i16 == i17) {
            int[] iArr = this.stack;
            int[] iArr2 = new int[i17 * 2];
            this.stack = iArr2;
            this.size = iArr2.length;
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        }
        int[] iArr3 = this.stack;
        int i18 = this.position;
        this.position = i18 + 1;
        iArr3[i18] = i3;
    }

    public void reset() {
        this.position = 0;
    }
}
