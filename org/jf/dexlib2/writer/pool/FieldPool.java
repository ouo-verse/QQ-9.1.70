package org.jf.dexlib2.writer.pool;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.writer.FieldSection;

/* loaded from: classes29.dex */
public class FieldPool extends BaseIndexPool<FieldReference> implements FieldSection<CharSequence, CharSequence, FieldReference, Field> {
    public FieldPool(@Nonnull DexPool dexPool) {
        super(dexPool);
    }

    public void intern(@Nonnull FieldReference fieldReference) {
        if (((Integer) this.internedItems.put(fieldReference, 0)) == null) {
            ((TypePool) this.dexPool.typeSection).intern(fieldReference.getDefiningClass());
            ((StringPool) this.dexPool.stringSection).intern(fieldReference.getName());
            ((TypePool) this.dexPool.typeSection).intern(fieldReference.getType());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.jf.dexlib2.writer.FieldSection
    @Nonnull
    public CharSequence getDefiningClass(@Nonnull FieldReference fieldReference) {
        return fieldReference.getDefiningClass();
    }

    @Override // org.jf.dexlib2.writer.FieldSection
    public int getFieldIndex(@Nonnull Field field) {
        return getItemIndex(field);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.jf.dexlib2.writer.FieldSection
    @Nonnull
    public CharSequence getFieldType(@Nonnull FieldReference fieldReference) {
        return fieldReference.getType();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.jf.dexlib2.writer.FieldSection
    @Nonnull
    public CharSequence getName(@Nonnull FieldReference fieldReference) {
        return fieldReference.getName();
    }
}
