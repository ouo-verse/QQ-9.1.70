package org.jf.dexlib2.writer;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.Annotation;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface AnnotationSetSection<AnnotationKey extends Annotation, AnnotationSetKey> extends NullableOffsetSection<AnnotationSetKey> {
    @Nonnull
    Collection<? extends AnnotationKey> getAnnotations(@Nonnull AnnotationSetKey annotationsetkey);
}
