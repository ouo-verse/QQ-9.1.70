package org.jf.dexlib2.writer.pool;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.writer.EncodedArraySection;

/* loaded from: classes29.dex */
public class EncodedArrayPool extends BaseOffsetPool<ArrayEncodedValue> implements EncodedArraySection<ArrayEncodedValue, EncodedValue> {
    public EncodedArrayPool(@Nonnull DexPool dexPool) {
        super(dexPool);
    }

    public void intern(@Nonnull ArrayEncodedValue arrayEncodedValue) {
        if (((Integer) this.internedItems.put(arrayEncodedValue, 0)) == null) {
            Iterator<? extends EncodedValue> it = arrayEncodedValue.getValue().iterator();
            while (it.hasNext()) {
                this.dexPool.internEncodedValue(it.next());
            }
        }
    }

    @Override // org.jf.dexlib2.writer.EncodedArraySection
    public List<? extends EncodedValue> getEncodedValueList(ArrayEncodedValue arrayEncodedValue) {
        return arrayEncodedValue.getValue();
    }
}
