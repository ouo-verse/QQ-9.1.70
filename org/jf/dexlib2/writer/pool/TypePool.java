package org.jf.dexlib2.writer.pool;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.reference.TypeReference;
import org.jf.dexlib2.writer.TypeSection;

/* loaded from: classes29.dex */
public class TypePool extends StringTypeBasePool implements TypeSection<CharSequence, CharSequence, TypeReference> {
    public TypePool(@Nonnull DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.jf.dexlib2.writer.TypeSection
    public int getItemIndex(@Nonnull TypeReference typeReference) {
        return getItemIndex((CharSequence) typeReference.getType());
    }

    @Override // org.jf.dexlib2.writer.TypeSection
    @Nonnull
    public CharSequence getString(@Nonnull CharSequence charSequence) {
        return charSequence;
    }

    public void intern(@Nonnull CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        if (((Integer) this.internedItems.put(charSequence2, 0)) == null) {
            ((StringPool) this.dexPool.stringSection).intern(charSequence2);
        }
    }

    public void internNullable(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            intern(charSequence);
        }
    }
}
