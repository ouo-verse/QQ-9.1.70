package org.jf.dexlib2.iface;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface AnnotationElement extends Comparable<AnnotationElement> {
    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ int compareTo(AnnotationElement annotationElement);

    /* JADX WARN: Can't rename method to resolve collision */
    int compareTo(AnnotationElement annotationElement);

    boolean equals(@Nullable Object obj);

    @Nonnull
    String getName();

    @Nonnull
    EncodedValue getValue();

    int hashCode();
}
