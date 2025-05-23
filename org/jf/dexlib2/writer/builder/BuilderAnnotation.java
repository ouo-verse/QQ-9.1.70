package org.jf.dexlib2.writer.builder;

import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.BaseAnnotation;

/* compiled from: P */
/* loaded from: classes29.dex */
class BuilderAnnotation extends BaseAnnotation {

    @Nonnull
    final Set<? extends BuilderAnnotationElement> elements;
    int offset = 0;

    @Nonnull
    final BuilderTypeReference type;
    int visibility;

    public BuilderAnnotation(int i3, @Nonnull BuilderTypeReference builderTypeReference, @Nonnull Set<? extends BuilderAnnotationElement> set) {
        this.visibility = i3;
        this.type = builderTypeReference;
        this.elements = set;
    }

    @Override // org.jf.dexlib2.iface.Annotation, org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    public Set<? extends BuilderAnnotationElement> getElements() {
        return this.elements;
    }

    @Override // org.jf.dexlib2.iface.Annotation, org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    public String getType() {
        return this.type.getType();
    }

    @Override // org.jf.dexlib2.iface.Annotation
    public int getVisibility() {
        return this.visibility;
    }
}
