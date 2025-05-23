package com.qq.taf.jce.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StructField extends JceField {
    private static final Comparator<JceField> tagComp = new Comparator<JceField>() { // from class: com.qq.taf.jce.dynamic.StructField.1
        @Override // java.util.Comparator
        public int compare(JceField jceField, JceField jceField2) {
            return jceField.getTag() - jceField2.getTag();
        }
    };
    private JceField[] data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StructField(JceField[] jceFieldArr, int i3) {
        super(i3);
        this.data = jceFieldArr;
    }

    public JceField[] get() {
        return this.data;
    }

    public JceField getFieldByTag(int i3) {
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i3), tagComp);
        if (binarySearch >= 0) {
            return this.data[binarySearch];
        }
        return null;
    }

    public boolean setByTag(int i3, JceField jceField) {
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i3), tagComp);
        if (binarySearch >= 0) {
            this.data[binarySearch] = jceField;
            return true;
        }
        int i16 = (-binarySearch) - 1;
        JceField[] jceFieldArr = new JceField[this.data.length + 1];
        for (int i17 = 0; i17 < i16; i17++) {
            jceFieldArr[i17] = this.data[i17];
        }
        jceFieldArr[i16] = jceField;
        while (true) {
            JceField[] jceFieldArr2 = this.data;
            if (i16 >= jceFieldArr2.length) {
                return false;
            }
            int i18 = i16 + 1;
            jceFieldArr[i18] = jceFieldArr2[i16];
            i16 = i18;
        }
    }
}
