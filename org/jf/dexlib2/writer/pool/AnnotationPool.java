package org.jf.dexlib2.writer.pool;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.writer.AnnotationSection;

/* loaded from: classes29.dex */
public class AnnotationPool extends BaseOffsetPool<Annotation> implements AnnotationSection<CharSequence, CharSequence, Annotation, AnnotationElement, EncodedValue> {
    public AnnotationPool(@Nonnull DexPool dexPool) {
        super(dexPool);
    }

    public void intern(@Nonnull Annotation annotation) {
        if (((Integer) this.internedItems.put(annotation, 0)) == null) {
            ((TypePool) this.dexPool.typeSection).intern(annotation.getType());
            for (AnnotationElement annotationElement : annotation.getElements()) {
                ((StringPool) this.dexPool.stringSection).intern(annotationElement.getName());
                this.dexPool.internEncodedValue(annotationElement.getValue());
            }
        }
    }

    @Override // org.jf.dexlib2.writer.AnnotationSection
    @Nonnull
    public CharSequence getElementName(@Nonnull AnnotationElement annotationElement) {
        return annotationElement.getName();
    }

    @Override // org.jf.dexlib2.writer.AnnotationSection
    @Nonnull
    public EncodedValue getElementValue(@Nonnull AnnotationElement annotationElement) {
        return annotationElement.getValue();
    }

    @Override // org.jf.dexlib2.writer.AnnotationSection
    @Nonnull
    public Collection<? extends AnnotationElement> getElements(@Nonnull Annotation annotation) {
        return annotation.getElements();
    }

    @Override // org.jf.dexlib2.writer.AnnotationSection
    @Nonnull
    public CharSequence getType(@Nonnull Annotation annotation) {
        return annotation.getType();
    }

    @Override // org.jf.dexlib2.writer.AnnotationSection
    public int getVisibility(@Nonnull Annotation annotation) {
        return annotation.getVisibility();
    }
}
