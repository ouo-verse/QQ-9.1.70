package org.jf.dexlib2.base;

import java.util.Comparator;
import org.jf.dexlib2.iface.Annotation;
import org.jf.util.CollectionUtils;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseAnnotation implements Annotation {
    public static final Comparator<? super Annotation> BY_TYPE = new Comparator<Annotation>() { // from class: org.jf.dexlib2.base.BaseAnnotation.1
        @Override // java.util.Comparator
        public int compare(Annotation annotation, Annotation annotation2) {
            return annotation.getType().compareTo(annotation2.getType());
        }
    };

    @Override // org.jf.dexlib2.iface.Annotation
    public boolean equals(Object obj) {
        if (!(obj instanceof Annotation)) {
            return false;
        }
        Annotation annotation = (Annotation) obj;
        if (getVisibility() != annotation.getVisibility() || !getType().equals(annotation.getType()) || !getElements().equals(annotation.getElements())) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.Annotation
    public int hashCode() {
        return (((getVisibility() * 31) + getType().hashCode()) * 31) + getElements().hashCode();
    }

    @Override // org.jf.dexlib2.iface.Annotation, java.lang.Comparable
    public int compareTo(Annotation annotation) {
        int a16 = c.a(getVisibility(), annotation.getVisibility());
        if (a16 != 0) {
            return a16;
        }
        int compareTo = getType().compareTo(annotation.getType());
        return compareTo != 0 ? compareTo : CollectionUtils.compareAsSet(getElements(), annotation.getElements());
    }
}
