package org.jf.dexlib2.base.reference;

import com.google.common.collect.Ordering;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.util.CharSequenceUtils;
import org.jf.util.CollectionUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseMethodReference extends BaseReference implements MethodReference {
    @Override // org.jf.dexlib2.iface.reference.MethodReference
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof MethodReference)) {
            return false;
        }
        MethodReference methodReference = (MethodReference) obj;
        if (!getDefiningClass().equals(methodReference.getDefiningClass()) || !getName().equals(methodReference.getName()) || !getReturnType().equals(methodReference.getReturnType()) || !CharSequenceUtils.listEquals(getParameterTypes(), methodReference.getParameterTypes())) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference
    public int hashCode() {
        return (((((getDefiningClass().hashCode() * 31) + getName().hashCode()) * 31) + getReturnType().hashCode()) * 31) + getParameterTypes().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getMethodDescriptor(this);
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, java.lang.Comparable
    public int compareTo(@Nonnull MethodReference methodReference) {
        int compareTo = getDefiningClass().compareTo(methodReference.getDefiningClass());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = getName().compareTo(methodReference.getName());
        if (compareTo2 != 0) {
            return compareTo2;
        }
        int compareTo3 = getReturnType().compareTo(methodReference.getReturnType());
        return compareTo3 != 0 ? compareTo3 : CollectionUtils.compareAsIterable(Ordering.usingToString(), getParameterTypes(), methodReference.getParameterTypes());
    }
}
