package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ListField extends JceField {
    private JceField[] data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListField(JceField[] jceFieldArr, int i3) {
        super(i3);
        this.data = jceFieldArr;
    }

    public JceField[] get() {
        return this.data;
    }

    public void set(int i3, JceField jceField) {
        this.data[i3] = jceField;
    }

    public int size() {
        return this.data.length;
    }

    public JceField get(int i3) {
        return this.data[i3];
    }

    public void set(JceField[] jceFieldArr) {
        this.data = jceFieldArr;
    }
}
