package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class MapField extends JceField {
    private JceField[] keys;
    private JceField[] values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapField(JceField[] jceFieldArr, JceField[] jceFieldArr2, int i3) {
        super(i3);
        this.keys = jceFieldArr;
        this.values = jceFieldArr2;
    }

    public JceField getKey(int i3) {
        return this.keys[i3];
    }

    public JceField[] getKeys() {
        return this.keys;
    }

    public JceField getValue(int i3) {
        return this.values[i3];
    }

    public JceField[] getValues() {
        return this.values;
    }

    public void setKey(int i3, JceField jceField) {
        this.keys[i3] = jceField;
    }

    public void setValue(int i3, JceField jceField) {
        this.values[i3] = jceField;
    }

    public int size() {
        return this.keys.length;
    }
}
