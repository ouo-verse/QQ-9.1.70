package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseAnnotationElement;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValueFactory;
import org.jf.util.ImmutableConverter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableAnnotationElement extends BaseAnnotationElement {
    private static final ImmutableConverter<ImmutableAnnotationElement, AnnotationElement> CONVERTER = new ImmutableConverter<ImmutableAnnotationElement, AnnotationElement>() { // from class: org.jf.dexlib2.immutable.ImmutableAnnotationElement.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull AnnotationElement annotationElement) {
            return annotationElement instanceof ImmutableAnnotationElement;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableAnnotationElement makeImmutable(@Nonnull AnnotationElement annotationElement) {
            return ImmutableAnnotationElement.of(annotationElement);
        }
    };

    @Nonnull
    protected final String name;

    @Nonnull
    protected final ImmutableEncodedValue value;

    public ImmutableAnnotationElement(@Nonnull String str, @Nonnull EncodedValue encodedValue) {
        this.name = str;
        this.value = ImmutableEncodedValueFactory.of(encodedValue);
    }

    @Nonnull
    public static ImmutableSet<ImmutableAnnotationElement> immutableSetOf(@Nullable Iterable<? extends AnnotationElement> iterable) {
        return CONVERTER.toSet(iterable);
    }

    public static ImmutableAnnotationElement of(AnnotationElement annotationElement) {
        if (annotationElement instanceof ImmutableAnnotationElement) {
            return (ImmutableAnnotationElement) annotationElement;
        }
        return new ImmutableAnnotationElement(annotationElement.getName(), annotationElement.getValue());
    }

    @Override // org.jf.dexlib2.iface.AnnotationElement
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override // org.jf.dexlib2.iface.AnnotationElement
    @Nonnull
    public EncodedValue getValue() {
        return this.value;
    }

    public ImmutableAnnotationElement(@Nonnull String str, @Nonnull ImmutableEncodedValue immutableEncodedValue) {
        this.name = str;
        this.value = immutableEncodedValue;
    }
}
