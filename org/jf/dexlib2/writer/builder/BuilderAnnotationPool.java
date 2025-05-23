package org.jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.writer.AnnotationSection;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues;

/* loaded from: classes29.dex */
class BuilderAnnotationPool extends BaseBuilderPool implements AnnotationSection<BuilderStringReference, BuilderTypeReference, BuilderAnnotation, BuilderAnnotationElement, BuilderEncodedValues.BuilderEncodedValue> {

    @Nonnull
    private final ConcurrentMap<Annotation, BuilderAnnotation> internedItems;

    public BuilderAnnotationPool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
    }

    @Override // org.jf.dexlib2.writer.OffsetSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderAnnotation, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderAnnotation>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderAnnotationPool.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderAnnotation builderAnnotation) {
                return builderAnnotation.offset;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderAnnotation builderAnnotation, int i3) {
                int i16 = builderAnnotation.offset;
                builderAnnotation.offset = i3;
                return i16;
            }
        };
    }

    @Nonnull
    public BuilderAnnotation internAnnotation(@Nonnull Annotation annotation) {
        BuilderAnnotation builderAnnotation = this.internedItems.get(annotation);
        if (builderAnnotation != null) {
            return builderAnnotation;
        }
        BuilderAnnotation builderAnnotation2 = new BuilderAnnotation(annotation.getVisibility(), ((BuilderTypePool) this.dexBuilder.typeSection).internType(annotation.getType()), this.dexBuilder.internAnnotationElements(annotation.getElements()));
        BuilderAnnotation putIfAbsent = this.internedItems.putIfAbsent(builderAnnotation2, builderAnnotation2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return builderAnnotation2;
    }

    @Override // org.jf.dexlib2.writer.AnnotationSection
    @Nonnull
    public BuilderStringReference getElementName(@Nonnull BuilderAnnotationElement builderAnnotationElement) {
        return builderAnnotationElement.name;
    }

    @Override // org.jf.dexlib2.writer.AnnotationSection
    @Nonnull
    public BuilderEncodedValues.BuilderEncodedValue getElementValue(@Nonnull BuilderAnnotationElement builderAnnotationElement) {
        return builderAnnotationElement.value;
    }

    @Override // org.jf.dexlib2.writer.AnnotationSection
    @Nonnull
    public Collection<? extends BuilderAnnotationElement> getElements(@Nonnull BuilderAnnotation builderAnnotation) {
        return builderAnnotation.elements;
    }

    @Override // org.jf.dexlib2.writer.OffsetSection
    public int getItemOffset(@Nonnull BuilderAnnotation builderAnnotation) {
        return builderAnnotation.offset;
    }

    @Override // org.jf.dexlib2.writer.AnnotationSection
    @Nonnull
    public BuilderTypeReference getType(@Nonnull BuilderAnnotation builderAnnotation) {
        return builderAnnotation.type;
    }

    @Override // org.jf.dexlib2.writer.AnnotationSection
    public int getVisibility(@Nonnull BuilderAnnotation builderAnnotation) {
        return builderAnnotation.visibility;
    }
}
