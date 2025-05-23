package org.jf.dexlib2.base.reference;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.reference.StringReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseStringReference extends BaseReference implements StringReference {
    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        return getString().charAt(i3);
    }

    @Override // org.jf.dexlib2.iface.reference.StringReference
    public boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof StringReference)) {
            return getString().equals(((StringReference) obj).getString());
        }
        return false;
    }

    @Override // org.jf.dexlib2.iface.reference.StringReference
    public int hashCode() {
        return getString().hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return getString().length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i16) {
        return getString().subSequence(i3, i16);
    }

    @Override // java.lang.CharSequence
    @Nonnull
    public String toString() {
        return getString();
    }

    @Override // org.jf.dexlib2.iface.reference.StringReference, java.lang.Comparable
    public int compareTo(@Nonnull CharSequence charSequence) {
        return getString().compareTo(charSequence.toString());
    }
}
