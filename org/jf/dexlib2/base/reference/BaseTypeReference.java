package org.jf.dexlib2.base.reference;

import javax.annotation.Nonnull;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseTypeReference extends BaseReference implements TypeReference {
    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        return getType().charAt(i3);
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof TypeReference) {
                return getType().equals(((TypeReference) obj).getType());
            }
            if (obj instanceof CharSequence) {
                return getType().equals(obj.toString());
            }
            return false;
        }
        return false;
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference
    public int hashCode() {
        return getType().hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return getType().length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i16) {
        return getType().subSequence(i3, i16);
    }

    @Override // java.lang.CharSequence
    @Nonnull
    public String toString() {
        return DexFormatter.INSTANCE.getType(this);
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference, java.lang.Comparable
    public int compareTo(@Nonnull CharSequence charSequence) {
        return getType().compareTo(charSequence.toString());
    }
}
