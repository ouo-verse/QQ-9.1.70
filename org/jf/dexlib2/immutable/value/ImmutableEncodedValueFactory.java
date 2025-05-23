package org.jf.dexlib2.immutable.value;

import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.value.AnnotationEncodedValue;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.BooleanEncodedValue;
import org.jf.dexlib2.iface.value.ByteEncodedValue;
import org.jf.dexlib2.iface.value.CharEncodedValue;
import org.jf.dexlib2.iface.value.DoubleEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.EnumEncodedValue;
import org.jf.dexlib2.iface.value.FieldEncodedValue;
import org.jf.dexlib2.iface.value.FloatEncodedValue;
import org.jf.dexlib2.iface.value.IntEncodedValue;
import org.jf.dexlib2.iface.value.LongEncodedValue;
import org.jf.dexlib2.iface.value.MethodEncodedValue;
import org.jf.dexlib2.iface.value.MethodHandleEncodedValue;
import org.jf.dexlib2.iface.value.MethodTypeEncodedValue;
import org.jf.dexlib2.iface.value.ShortEncodedValue;
import org.jf.dexlib2.iface.value.StringEncodedValue;
import org.jf.dexlib2.iface.value.TypeEncodedValue;
import org.jf.util.ExceptionWithContext;
import org.jf.util.ImmutableConverter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableEncodedValueFactory {
    private static final ImmutableConverter<ImmutableEncodedValue, EncodedValue> CONVERTER = new ImmutableConverter<ImmutableEncodedValue, EncodedValue>() { // from class: org.jf.dexlib2.immutable.value.ImmutableEncodedValueFactory.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull EncodedValue encodedValue) {
            return encodedValue instanceof ImmutableEncodedValue;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableEncodedValue makeImmutable(@Nonnull EncodedValue encodedValue) {
            return ImmutableEncodedValueFactory.of(encodedValue);
        }
    };

    @Nonnull
    public static EncodedValue defaultValueForType(String str) {
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
                                            return new ImmutableByteEncodedValue((byte) 0);
                                        case 'C':
                                            return new ImmutableCharEncodedValue((char) 0);
                                        case 'D':
                                            return new ImmutableDoubleEncodedValue(0.0d);
                                        default:
                                            throw new ExceptionWithContext("Unrecognized type: %s", str);
                                    }
                                }
                            } else {
                                return ImmutableBooleanEncodedValue.FALSE_VALUE;
                            }
                        } else {
                            return new ImmutableLongEncodedValue(0L);
                        }
                    } else {
                        return new ImmutableIntEncodedValue(0);
                    }
                } else {
                    return new ImmutableShortEncodedValue((short) 0);
                }
            }
            return ImmutableNullEncodedValue.INSTANCE;
        }
        return new ImmutableFloatEncodedValue(0.0f);
    }

    @Nonnull
    public static ImmutableList<ImmutableEncodedValue> immutableListOf(@Nullable Iterable<? extends EncodedValue> iterable) {
        return CONVERTER.toList(iterable);
    }

    @Nonnull
    public static ImmutableEncodedValue of(@Nonnull EncodedValue encodedValue) {
        int valueType = encodedValue.getValueType();
        if (valueType != 0) {
            if (valueType != 6) {
                if (valueType != 2) {
                    if (valueType != 3) {
                        if (valueType != 4) {
                            if (valueType != 16) {
                                if (valueType != 17) {
                                    switch (valueType) {
                                        case 21:
                                            return ImmutableMethodTypeEncodedValue.of((MethodTypeEncodedValue) encodedValue);
                                        case 22:
                                            return ImmutableMethodHandleEncodedValue.of((MethodHandleEncodedValue) encodedValue);
                                        case 23:
                                            return ImmutableStringEncodedValue.of((StringEncodedValue) encodedValue);
                                        case 24:
                                            return ImmutableTypeEncodedValue.of((TypeEncodedValue) encodedValue);
                                        case 25:
                                            return ImmutableFieldEncodedValue.of((FieldEncodedValue) encodedValue);
                                        case 26:
                                            return ImmutableMethodEncodedValue.of((MethodEncodedValue) encodedValue);
                                        case 27:
                                            return ImmutableEnumEncodedValue.of((EnumEncodedValue) encodedValue);
                                        case 28:
                                            return ImmutableArrayEncodedValue.of((ArrayEncodedValue) encodedValue);
                                        case 29:
                                            return ImmutableAnnotationEncodedValue.of((AnnotationEncodedValue) encodedValue);
                                        case 30:
                                            return ImmutableNullEncodedValue.INSTANCE;
                                        case 31:
                                            return ImmutableBooleanEncodedValue.of((BooleanEncodedValue) encodedValue);
                                        default:
                                            j.d(false);
                                            return null;
                                    }
                                }
                                return ImmutableDoubleEncodedValue.of((DoubleEncodedValue) encodedValue);
                            }
                            return ImmutableFloatEncodedValue.of((FloatEncodedValue) encodedValue);
                        }
                        return ImmutableIntEncodedValue.of((IntEncodedValue) encodedValue);
                    }
                    return ImmutableCharEncodedValue.of((CharEncodedValue) encodedValue);
                }
                return ImmutableShortEncodedValue.of((ShortEncodedValue) encodedValue);
            }
            return ImmutableLongEncodedValue.of((LongEncodedValue) encodedValue);
        }
        return ImmutableByteEncodedValue.of((ByteEncodedValue) encodedValue);
    }

    @Nullable
    public static ImmutableEncodedValue ofNullable(@Nullable EncodedValue encodedValue) {
        if (encodedValue == null) {
            return null;
        }
        return of(encodedValue);
    }
}
