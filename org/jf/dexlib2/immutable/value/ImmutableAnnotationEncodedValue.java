package org.jf.dexlib2.immutable.value;

import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.value.BaseAnnotationEncodedValue;
import org.jf.dexlib2.iface.AnnotationElement;
import org.jf.dexlib2.iface.value.AnnotationEncodedValue;
import org.jf.dexlib2.immutable.ImmutableAnnotationElement;
import org.jf.util.ImmutableUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableAnnotationEncodedValue extends BaseAnnotationEncodedValue implements ImmutableEncodedValue {

    @Nonnull
    protected final ImmutableSet<? extends ImmutableAnnotationElement> elements;

    @Nonnull
    protected final String type;

    public ImmutableAnnotationEncodedValue(@Nonnull String str, @Nullable Collection<? extends AnnotationElement> collection) {
        this.type = str;
        this.elements = ImmutableAnnotationElement.immutableSetOf(collection);
    }

    public static ImmutableAnnotationEncodedValue of(AnnotationEncodedValue annotationEncodedValue) {
        if (annotationEncodedValue instanceof ImmutableAnnotationEncodedValue) {
            return (ImmutableAnnotationEncodedValue) annotationEncodedValue;
        }
        return new ImmutableAnnotationEncodedValue(annotationEncodedValue.getType(), annotationEncodedValue.getElements());
    }

    @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue, org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    public String getType() {
        return this.type;
    }

    @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue, org.jf.dexlib2.iface.BasicAnnotation
    @Nonnull
    public ImmutableSet<? extends ImmutableAnnotationElement> getElements() {
        return this.elements;
    }

    public ImmutableAnnotationEncodedValue(@Nonnull String str, @Nullable ImmutableSet<? extends ImmutableAnnotationElement> immutableSet) {
        this.type = str;
        this.elements = ImmutableUtils.nullToEmptySet(immutableSet);
    }
}
