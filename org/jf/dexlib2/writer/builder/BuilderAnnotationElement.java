package org.jf.dexlib2.writer.builder;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.BaseAnnotationElement;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderAnnotationElement extends BaseAnnotationElement {

    @Nonnull
    final BuilderStringReference name;

    @Nonnull
    final BuilderEncodedValues.BuilderEncodedValue value;

    public BuilderAnnotationElement(@Nonnull BuilderStringReference builderStringReference, @Nonnull BuilderEncodedValues.BuilderEncodedValue builderEncodedValue) {
        this.name = builderStringReference;
        this.value = builderEncodedValue;
    }

    @Override // org.jf.dexlib2.iface.AnnotationElement
    @Nonnull
    public String getName() {
        return this.name.getString();
    }

    @Override // org.jf.dexlib2.iface.AnnotationElement
    @Nonnull
    public EncodedValue getValue() {
        return this.value;
    }
}
