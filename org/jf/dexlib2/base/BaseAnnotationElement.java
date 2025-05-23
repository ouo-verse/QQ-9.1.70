package org.jf.dexlib2.base;

import java.util.Comparator;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.AnnotationElement;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseAnnotationElement implements AnnotationElement {
    public static final Comparator<AnnotationElement> BY_NAME = new Comparator<AnnotationElement>() { // from class: org.jf.dexlib2.base.BaseAnnotationElement.1
        @Override // java.util.Comparator
        public int compare(@Nonnull AnnotationElement annotationElement, @Nonnull AnnotationElement annotationElement2) {
            return annotationElement.getName().compareTo(annotationElement2.getName());
        }
    };

    @Override // org.jf.dexlib2.iface.AnnotationElement
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AnnotationElement)) {
            return false;
        }
        AnnotationElement annotationElement = (AnnotationElement) obj;
        if (!getName().equals(annotationElement.getName()) || !getValue().equals(annotationElement.getValue())) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.AnnotationElement
    public int hashCode() {
        return (getName().hashCode() * 31) + getValue().hashCode();
    }

    @Override // org.jf.dexlib2.iface.AnnotationElement, java.lang.Comparable
    public int compareTo(AnnotationElement annotationElement) {
        int compareTo = getName().compareTo(annotationElement.getName());
        return compareTo != 0 ? compareTo : getValue().compareTo(annotationElement.getValue());
    }
}
