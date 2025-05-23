package org.jf.dexlib2.writer;

import java.util.Collection;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface AnnotationSection<StringKey, TypeKey, AnnotationKey, AnnotationElement, EncodedValue> extends OffsetSection<AnnotationKey> {
    @Nonnull
    StringKey getElementName(@Nonnull AnnotationElement annotationelement);

    @Nonnull
    EncodedValue getElementValue(@Nonnull AnnotationElement annotationelement);

    @Nonnull
    Collection<? extends AnnotationElement> getElements(@Nonnull AnnotationKey annotationkey);

    @Nonnull
    TypeKey getType(@Nonnull AnnotationKey annotationkey);

    int getVisibility(@Nonnull AnnotationKey annotationkey);
}
