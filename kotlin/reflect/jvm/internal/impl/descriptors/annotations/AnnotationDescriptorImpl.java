package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AnnotationDescriptorImpl implements AnnotationDescriptor {
    private final KotlinType annotationType;
    private final SourceElement source;
    private final Map<Name, ConstantValue<?>> valueArguments;

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 3 && i3 != 4 && i3 != 5) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 3 && i3 != 4 && i3 != 5) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4 && i3 != 5) {
                    objArr[0] = "annotationType";
                } else {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
                }
            } else {
                objArr[0] = "source";
            }
        } else {
            objArr[0] = "valueArguments";
        }
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
                } else {
                    objArr[1] = "getSource";
                }
            } else {
                objArr[1] = "getAllValueArguments";
            }
        } else {
            objArr[1] = "getType";
        }
        if (i3 != 3 && i3 != 4 && i3 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i3 == 3 || i3 == 4 || i3 == 5) {
            throw new IllegalStateException(format);
        }
    }

    public AnnotationDescriptorImpl(@NotNull KotlinType kotlinType, @NotNull Map<Name, ConstantValue<?>> map, @NotNull SourceElement sourceElement) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        if (map == null) {
            $$$reportNull$$$0(1);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(2);
        }
        this.annotationType = kotlinType;
        this.valueArguments = map;
        this.source = sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        Map<Name, ConstantValue<?>> map = this.valueArguments;
        if (map == null) {
            $$$reportNull$$$0(4);
        }
        return map;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @Nullable
    public FqName getFqName() {
        return AnnotationDescriptor.DefaultImpls.getFqName(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = this.source;
        if (sourceElement == null) {
            $$$reportNull$$$0(5);
        }
        return sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = this.annotationType;
        if (kotlinType == null) {
            $$$reportNull$$$0(3);
        }
        return kotlinType;
    }

    public String toString() {
        return DescriptorRenderer.FQ_NAMES_IN_TYPES.renderAnnotation(this, null);
    }
}
