package org.jf.dexlib2.iface.value;

import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.BasicAnnotation;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface AnnotationEncodedValue extends EncodedValue, BasicAnnotation {
    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ int compareTo(@Nonnull EncodedValue encodedValue);

    /* JADX WARN: Can't rename method to resolve collision */
    int compareTo(@Nonnull EncodedValue encodedValue);

    boolean equals(@Nullable Object obj);

    @Nonnull
    Set<? extends AnnotationElement> getElements();

    @Nonnull
    String getType();

    int hashCode();
}
