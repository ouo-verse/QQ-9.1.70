package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.AnnotationEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.util.CollectionUtils;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseAnnotationEncodedValue implements AnnotationEncodedValue {
    @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof AnnotationEncodedValue)) {
            return false;
        }
        AnnotationEncodedValue annotationEncodedValue = (AnnotationEncodedValue) obj;
        if (!getType().equals(annotationEncodedValue.getType()) || !getElements().equals(annotationEncodedValue.getElements())) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 29;
    }

    @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue
    public int hashCode() {
        return (getType().hashCode() * 31) + getElements().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        if (a16 != 0) {
            return a16;
        }
        AnnotationEncodedValue annotationEncodedValue = (AnnotationEncodedValue) encodedValue;
        int compareTo = getType().compareTo(annotationEncodedValue.getType());
        return compareTo != 0 ? compareTo : CollectionUtils.compareAsSet(getElements(), annotationEncodedValue.getElements());
    }
}
