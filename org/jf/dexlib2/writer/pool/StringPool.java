package org.jf.dexlib2.writer.pool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.writer.StringSection;
import org.jf.util.ExceptionWithContext;

/* loaded from: classes29.dex */
public class StringPool extends StringTypeBasePool implements StringSection<CharSequence, StringReference> {
    public StringPool(@Nonnull DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.jf.dexlib2.writer.StringSection
    public int getItemIndex(@Nonnull StringReference stringReference) {
        Integer num = (Integer) this.internedItems.get(stringReference.toString());
        if (num != null) {
            return num.intValue();
        }
        throw new ExceptionWithContext("Item not found.: %s", stringReference.toString());
    }

    @Override // org.jf.dexlib2.writer.StringSection
    public boolean hasJumboIndexes() {
        if (this.internedItems.size() > 65536) {
            return true;
        }
        return false;
    }

    public void intern(@Nonnull CharSequence charSequence) {
        this.internedItems.put(charSequence.toString(), 0);
    }

    public void internNullable(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            intern(charSequence);
        }
    }
}
