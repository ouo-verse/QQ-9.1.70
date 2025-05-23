package org.jf.dexlib2.writer.builder;

import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseAnnotationEncodedValue;
import org.jf.dexlib2.base.value.BaseArrayEncodedValue;
import org.jf.dexlib2.base.value.BaseBooleanEncodedValue;
import org.jf.dexlib2.base.value.BaseEnumEncodedValue;
import org.jf.dexlib2.base.value.BaseFieldEncodedValue;
import org.jf.dexlib2.base.value.BaseMethodEncodedValue;
import org.jf.dexlib2.base.value.BaseMethodHandleEncodedValue;
import org.jf.dexlib2.base.value.BaseMethodTypeEncodedValue;
import org.jf.dexlib2.base.value.BaseNullEncodedValue;
import org.jf.dexlib2.base.value.BaseStringEncodedValue;
import org.jf.dexlib2.base.value.BaseTypeEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableByteEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableCharEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableDoubleEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableFloatEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableIntEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableLongEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableShortEncodedValue;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BuilderEncodedValues {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderAnnotationEncodedValue extends BaseAnnotationEncodedValue implements BuilderEncodedValue {

        @Nonnull
        final Set<? extends BuilderAnnotationElement> elements;

        @Nonnull
        final BuilderTypeReference typeReference;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BuilderAnnotationEncodedValue(@Nonnull BuilderTypeReference builderTypeReference, @Nonnull Set<? extends BuilderAnnotationElement> set) {
            this.typeReference = builderTypeReference;
            this.elements = set;
        }

        @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue, org.jf.dexlib2.iface.BasicAnnotation
        @Nonnull
        public Set<? extends BuilderAnnotationElement> getElements() {
            return this.elements;
        }

        @Override // org.jf.dexlib2.iface.value.AnnotationEncodedValue, org.jf.dexlib2.iface.BasicAnnotation
        @Nonnull
        public String getType() {
            return this.typeReference.getType();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderArrayEncodedValue extends BaseArrayEncodedValue implements BuilderEncodedValue {

        @Nonnull
        final List<? extends BuilderEncodedValue> elements;
        int offset = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BuilderArrayEncodedValue(@Nonnull List<? extends BuilderEncodedValue> list) {
            this.elements = list;
        }

        @Override // org.jf.dexlib2.iface.value.ArrayEncodedValue
        @Nonnull
        public List<? extends EncodedValue> getValue() {
            return this.elements;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderBooleanEncodedValue extends BaseBooleanEncodedValue implements BuilderEncodedValue {
        private final boolean value;
        public static final BuilderBooleanEncodedValue TRUE_VALUE = new BuilderBooleanEncodedValue(true);
        public static final BuilderBooleanEncodedValue FALSE_VALUE = new BuilderBooleanEncodedValue(false);

        BuilderBooleanEncodedValue(boolean z16) {
            this.value = z16;
        }

        @Override // org.jf.dexlib2.iface.value.BooleanEncodedValue
        public boolean getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderByteEncodedValue extends ImmutableByteEncodedValue implements BuilderEncodedValue {
        public BuilderByteEncodedValue(byte b16) {
            super(b16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderCharEncodedValue extends ImmutableCharEncodedValue implements BuilderEncodedValue {
        public BuilderCharEncodedValue(char c16) {
            super(c16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderDoubleEncodedValue extends ImmutableDoubleEncodedValue implements BuilderEncodedValue {
        public BuilderDoubleEncodedValue(double d16) {
            super(d16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface BuilderEncodedValue extends EncodedValue {
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderEnumEncodedValue extends BaseEnumEncodedValue implements BuilderEncodedValue {

        @Nonnull
        final BuilderFieldReference enumReference;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BuilderEnumEncodedValue(@Nonnull BuilderFieldReference builderFieldReference) {
            this.enumReference = builderFieldReference;
        }

        @Override // org.jf.dexlib2.iface.value.EnumEncodedValue
        @Nonnull
        public BuilderFieldReference getValue() {
            return this.enumReference;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderFieldEncodedValue extends BaseFieldEncodedValue implements BuilderEncodedValue {

        @Nonnull
        final BuilderFieldReference fieldReference;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BuilderFieldEncodedValue(@Nonnull BuilderFieldReference builderFieldReference) {
            this.fieldReference = builderFieldReference;
        }

        @Override // org.jf.dexlib2.iface.value.FieldEncodedValue
        @Nonnull
        public BuilderFieldReference getValue() {
            return this.fieldReference;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderFloatEncodedValue extends ImmutableFloatEncodedValue implements BuilderEncodedValue {
        public BuilderFloatEncodedValue(float f16) {
            super(f16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderIntEncodedValue extends ImmutableIntEncodedValue implements BuilderEncodedValue {
        public BuilderIntEncodedValue(int i3) {
            super(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderLongEncodedValue extends ImmutableLongEncodedValue implements BuilderEncodedValue {
        public BuilderLongEncodedValue(long j3) {
            super(j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderMethodEncodedValue extends BaseMethodEncodedValue implements BuilderEncodedValue {

        @Nonnull
        final BuilderMethodReference methodReference;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BuilderMethodEncodedValue(@Nonnull BuilderMethodReference builderMethodReference) {
            this.methodReference = builderMethodReference;
        }

        @Override // org.jf.dexlib2.iface.value.MethodEncodedValue
        public BuilderMethodReference getValue() {
            return this.methodReference;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderMethodHandleEncodedValue extends BaseMethodHandleEncodedValue implements BuilderEncodedValue {

        @Nonnull
        final BuilderMethodHandleReference methodHandleReference;

        public BuilderMethodHandleEncodedValue(@Nonnull BuilderMethodHandleReference builderMethodHandleReference) {
            this.methodHandleReference = builderMethodHandleReference;
        }

        @Override // org.jf.dexlib2.iface.value.MethodHandleEncodedValue
        @Nonnull
        public BuilderMethodHandleReference getValue() {
            return this.methodHandleReference;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderMethodTypeEncodedValue extends BaseMethodTypeEncodedValue implements BuilderEncodedValue {

        @Nonnull
        final BuilderMethodProtoReference methodProtoReference;

        public BuilderMethodTypeEncodedValue(@Nonnull BuilderMethodProtoReference builderMethodProtoReference) {
            this.methodProtoReference = builderMethodProtoReference;
        }

        @Override // org.jf.dexlib2.iface.value.MethodTypeEncodedValue
        @Nonnull
        public BuilderMethodProtoReference getValue() {
            return this.methodProtoReference;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderNullEncodedValue extends BaseNullEncodedValue implements BuilderEncodedValue {
        public static final BuilderNullEncodedValue INSTANCE = new BuilderNullEncodedValue();

        BuilderNullEncodedValue() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderShortEncodedValue extends ImmutableShortEncodedValue implements BuilderEncodedValue {
        public BuilderShortEncodedValue(short s16) {
            super(s16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderStringEncodedValue extends BaseStringEncodedValue implements BuilderEncodedValue {

        @Nonnull
        final BuilderStringReference stringReference;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BuilderStringEncodedValue(@Nonnull BuilderStringReference builderStringReference) {
            this.stringReference = builderStringReference;
        }

        @Override // org.jf.dexlib2.iface.value.StringEncodedValue
        @Nonnull
        public String getValue() {
            return this.stringReference.getString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class BuilderTypeEncodedValue extends BaseTypeEncodedValue implements BuilderEncodedValue {

        @Nonnull
        final BuilderTypeReference typeReference;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BuilderTypeEncodedValue(@Nonnull BuilderTypeReference builderTypeReference) {
            this.typeReference = builderTypeReference;
        }

        @Override // org.jf.dexlib2.iface.value.TypeEncodedValue
        @Nonnull
        public String getValue() {
            return this.typeReference.getType();
        }
    }

    @Nonnull
    public static BuilderEncodedValue defaultValueForType(String str) {
        char charAt = str.charAt(0);
        if (charAt != 'F') {
            if (charAt != 'L') {
                if (charAt != 'S') {
                    if (charAt != 'I') {
                        if (charAt != 'J') {
                            if (charAt != 'Z') {
                                if (charAt != '[') {
                                    switch (charAt) {
                                        case 'B':
                                            return new BuilderByteEncodedValue((byte) 0);
                                        case 'C':
                                            return new BuilderCharEncodedValue((char) 0);
                                        case 'D':
                                            return new BuilderDoubleEncodedValue(0.0d);
                                        default:
                                            throw new ExceptionWithContext("Unrecognized type: %s", str);
                                    }
                                }
                            } else {
                                return BuilderBooleanEncodedValue.FALSE_VALUE;
                            }
                        } else {
                            return new BuilderLongEncodedValue(0L);
                        }
                    } else {
                        return new BuilderIntEncodedValue(0);
                    }
                } else {
                    return new BuilderShortEncodedValue((short) 0);
                }
            }
            return BuilderNullEncodedValue.INSTANCE;
        }
        return new BuilderFloatEncodedValue(0.0f);
    }
}
