package org.jf.dexlib2.iface;

import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Annotation extends BasicAnnotation, Comparable<Annotation> {
    /* bridge */ /* synthetic */ int compareTo(Object obj);

    int compareTo(Annotation annotation);

    boolean equals(@Nullable Object obj);

    @Override // org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    Set<? extends AnnotationElement> getElements();

    @Override // org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    String getType();

    int getVisibility();

    int hashCode();
}
