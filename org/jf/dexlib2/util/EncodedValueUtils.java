package org.jf.dexlib2.util;

import java.io.IOException;
import java.io.Writer;
import org.jf.dexlib2.iface.AnnotationElement;
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
import org.jf.util.StringUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class EncodedValueUtils {
    EncodedValueUtils() {
    }

    public static boolean isDefaultValue(EncodedValue encodedValue) {
        int valueType = encodedValue.getValueType();
        if (valueType != 0) {
            if (valueType != 6) {
                if (valueType != 2) {
                    if (valueType != 3) {
                        if (valueType != 4) {
                            if (valueType != 16) {
                                if (valueType != 17) {
                                    if (valueType == 30) {
                                        return true;
                                    }
                                    if (valueType != 31) {
                                        return false;
                                    }
                                    return !((BooleanEncodedValue) encodedValue).getValue();
                                }
                                if (((DoubleEncodedValue) encodedValue).getValue() != 0.0d) {
                                    return false;
                                }
                                return true;
                            }
                            if (((FloatEncodedValue) encodedValue).getValue() != 0.0f) {
                                return false;
                            }
                            return true;
                        }
                        if (((IntEncodedValue) encodedValue).getValue() != 0) {
                            return false;
                        }
                        return true;
                    }
                    if (((CharEncodedValue) encodedValue).getValue() != 0) {
                        return false;
                    }
                    return true;
                }
                if (((ShortEncodedValue) encodedValue).getValue() != 0) {
                    return false;
                }
                return true;
            }
            if (((LongEncodedValue) encodedValue).getValue() != 0) {
                return false;
            }
            return true;
        }
        if (((ByteEncodedValue) encodedValue).getValue() != 0) {
            return false;
        }
        return true;
    }

    private static void writeAnnotation(Writer writer, AnnotationEncodedValue annotationEncodedValue) throws IOException {
        writer.write("Annotation[");
        writer.write(annotationEncodedValue.getType());
        for (AnnotationElement annotationElement : annotationEncodedValue.getElements()) {
            writer.write(", ");
            writer.write(annotationElement.getName());
            writer.write(61);
            writeEncodedValue(writer, annotationElement.getValue());
        }
        writer.write(93);
    }

    private static void writeArray(Writer writer, ArrayEncodedValue arrayEncodedValue) throws IOException {
        writer.write("Array[");
        boolean z16 = true;
        for (EncodedValue encodedValue : arrayEncodedValue.getValue()) {
            if (z16) {
                z16 = false;
            } else {
                writer.write(", ");
            }
            writeEncodedValue(writer, encodedValue);
        }
        writer.write(93);
    }

    @Deprecated
    public static void writeEncodedValue(Writer writer, EncodedValue encodedValue) throws IOException {
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
                                            ReferenceUtil.writeMethodProtoDescriptor(writer, ((MethodTypeEncodedValue) encodedValue).getValue());
                                            return;
                                        case 22:
                                            ReferenceUtil.writeMethodHandle(writer, ((MethodHandleEncodedValue) encodedValue).getValue());
                                            return;
                                        case 23:
                                            writer.write(34);
                                            StringUtils.writeEscapedString(writer, ((StringEncodedValue) encodedValue).getValue());
                                            writer.write(34);
                                            return;
                                        case 24:
                                            writer.write(((TypeEncodedValue) encodedValue).getValue());
                                            return;
                                        case 25:
                                            ReferenceUtil.writeFieldDescriptor(writer, ((FieldEncodedValue) encodedValue).getValue());
                                            return;
                                        case 26:
                                            ReferenceUtil.writeMethodDescriptor(writer, ((MethodEncodedValue) encodedValue).getValue());
                                            return;
                                        case 27:
                                            ReferenceUtil.writeFieldDescriptor(writer, ((EnumEncodedValue) encodedValue).getValue());
                                            return;
                                        case 28:
                                            writeArray(writer, (ArrayEncodedValue) encodedValue);
                                            return;
                                        case 29:
                                            writeAnnotation(writer, (AnnotationEncodedValue) encodedValue);
                                            return;
                                        case 30:
                                            writer.write("null");
                                            return;
                                        case 31:
                                            writer.write(Boolean.toString(((BooleanEncodedValue) encodedValue).getValue()));
                                            return;
                                        default:
                                            throw new IllegalArgumentException("Unknown encoded value type");
                                    }
                                }
                                writer.write(Double.toString(((DoubleEncodedValue) encodedValue).getValue()));
                                return;
                            }
                            writer.write(Float.toString(((FloatEncodedValue) encodedValue).getValue()));
                            return;
                        }
                        writer.write(Integer.toString(((IntEncodedValue) encodedValue).getValue()));
                        return;
                    }
                    writer.write(Integer.toString(((CharEncodedValue) encodedValue).getValue()));
                    return;
                }
                writer.write(Short.toString(((ShortEncodedValue) encodedValue).getValue()));
                return;
            }
            writer.write(Long.toString(((LongEncodedValue) encodedValue).getValue()));
            return;
        }
        writer.write(Byte.toString(((ByteEncodedValue) encodedValue).getValue()));
    }
}
