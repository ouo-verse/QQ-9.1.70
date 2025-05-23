package org.jf.dexlib2.base.reference;

import com.google.common.collect.Ordering;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.util.CharSequenceUtils;
import org.jf.util.CollectionUtils;

/* loaded from: classes29.dex */
public abstract class BaseMethodProtoReference extends BaseReference implements MethodProtoReference {
    @Override // org.jf.dexlib2.iface.reference.MethodProtoReference
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof MethodProtoReference)) {
            return false;
        }
        MethodProtoReference methodProtoReference = (MethodProtoReference) obj;
        if (!getReturnType().equals(methodProtoReference.getReturnType()) || !CharSequenceUtils.listEquals(getParameterTypes(), methodProtoReference.getParameterTypes())) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodProtoReference
    public int hashCode() {
        return (getReturnType().hashCode() * 31) + getParameterTypes().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getMethodProtoDescriptor(this);
    }

    @Override // org.jf.dexlib2.iface.reference.MethodProtoReference, java.lang.Comparable
    public int compareTo(@Nonnull MethodProtoReference methodProtoReference) {
        int compareTo = getReturnType().compareTo(methodProtoReference.getReturnType());
        return compareTo != 0 ? compareTo : CollectionUtils.compareAsIterable(Ordering.usingToString(), getParameterTypes(), methodProtoReference.getParameterTypes());
    }
}
