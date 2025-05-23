package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseAnnotation;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.util.ImmutableConverter;
import org.jf.util.ImmutableUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableAnnotation extends BaseAnnotation {
    private static final ImmutableConverter<ImmutableAnnotation, Annotation> CONVERTER = new ImmutableConverter<ImmutableAnnotation, Annotation>() { // from class: org.jf.dexlib2.immutable.ImmutableAnnotation.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull Annotation annotation) {
            return annotation instanceof ImmutableAnnotation;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableAnnotation makeImmutable(@Nonnull Annotation annotation) {
            return ImmutableAnnotation.of(annotation);
        }
    };

    @Nonnull
    protected final ImmutableSet<? extends ImmutableAnnotationElement> elements;

    @Nonnull
    protected final String type;
    protected final int visibility;

    public ImmutableAnnotation(int i3, @Nonnull String str, @Nullable Collection<? extends AnnotationElement> collection) {
        this.visibility = i3;
        this.type = str;
        this.elements = ImmutableAnnotationElement.immutableSetOf(collection);
    }

    @Nonnull
    public static ImmutableSet<ImmutableAnnotation> immutableSetOf(@Nullable Iterable<? extends Annotation> iterable) {
        return CONVERTER.toSet(iterable);
    }

    public static ImmutableAnnotation of(Annotation annotation) {
        if (annotation instanceof ImmutableAnnotation) {
            return (ImmutableAnnotation) annotation;
        }
        return new ImmutableAnnotation(annotation.getVisibility(), annotation.getType(), annotation.getElements());
    }

    @Override // org.jf.dexlib2.iface.Annotation, org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    public String getType() {
        return this.type;
    }

    @Override // org.jf.dexlib2.iface.Annotation
    public int getVisibility() {
        return this.visibility;
    }

    @Override // org.jf.dexlib2.iface.Annotation, org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    public ImmutableSet<? extends ImmutableAnnotationElement> getElements() {
        return this.elements;
    }

    public ImmutableAnnotation(int i3, @Nonnull String str, @Nullable ImmutableSet<? extends ImmutableAnnotationElement> immutableSet) {
        this.visibility = i3;
        this.type = str;
        this.elements = ImmutableUtils.nullToEmptySet(immutableSet);
    }
}
