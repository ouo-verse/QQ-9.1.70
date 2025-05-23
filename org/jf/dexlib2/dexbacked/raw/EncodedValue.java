package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import org.jf.dexlib2.ValueType;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.value.DexBackedEncodedValue;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EncodedValue {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void annotateEncodedAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull AnnotatedBytes annotatedBytes, @Nonnull DexReader dexReader) {
        annotatedBytes.annotateTo(dexReader.getOffset(), TypeIdItem.getReferenceAnnotation(dexBackedDexFile, dexReader.readSmallUleb128()), new Object[0]);
        int readSmallUleb128 = dexReader.readSmallUleb128();
        annotatedBytes.annotateTo(dexReader.getOffset(), "size: %d", Integer.valueOf(readSmallUleb128));
        for (int i3 = 0; i3 < readSmallUleb128; i3++) {
            annotatedBytes.annotate(0, "element[%d]", Integer.valueOf(i3));
            annotatedBytes.indent();
            annotatedBytes.annotateTo(dexReader.getOffset(), "name = %s", StringIdItem.getReferenceAnnotation(dexBackedDexFile, dexReader.readSmallUleb128()));
            annotateEncodedValue(dexBackedDexFile, annotatedBytes, dexReader);
            annotatedBytes.deindent();
        }
    }

    public static void annotateEncodedArray(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull AnnotatedBytes annotatedBytes, @Nonnull DexReader dexReader) {
        int readSmallUleb128 = dexReader.readSmallUleb128();
        annotatedBytes.annotateTo(dexReader.getOffset(), "size: %d", Integer.valueOf(readSmallUleb128));
        for (int i3 = 0; i3 < readSmallUleb128; i3++) {
            annotatedBytes.annotate(0, "element[%d]", Integer.valueOf(i3));
            annotatedBytes.indent();
            annotateEncodedValue(dexBackedDexFile, annotatedBytes, dexReader);
            annotatedBytes.deindent();
        }
    }

    public static void annotateEncodedValue(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull AnnotatedBytes annotatedBytes, @Nonnull DexReader dexReader) {
        int readUbyte = dexReader.readUbyte();
        int i3 = readUbyte >>> 5;
        int i16 = readUbyte & 31;
        boolean z16 = false;
        if (i16 != 0 && i16 != 6 && i16 != 2 && i16 != 3 && i16 != 4 && i16 != 16 && i16 != 17) {
            switch (i16) {
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                case 28:
                    annotatedBytes.annotate(1, "valueArg = %d, valueType = 0x%x: array", Integer.valueOf(i3), Integer.valueOf(i16));
                    annotateEncodedArray(dexBackedDexFile, annotatedBytes, dexReader);
                    return;
                case 29:
                    annotatedBytes.annotate(1, "valueArg = %d, valueType = 0x%x: annotation", Integer.valueOf(i3), Integer.valueOf(i16));
                    annotateEncodedAnnotation(dexBackedDexFile, annotatedBytes, dexReader);
                    return;
                case 30:
                    annotatedBytes.annotate(1, "valueArg = %d, valueType = 0x%x: null", Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                case 31:
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(i3);
                    objArr[1] = Integer.valueOf(i16);
                    if (i3 == 1) {
                        z16 = true;
                    }
                    objArr[2] = Boolean.valueOf(z16);
                    annotatedBytes.annotate(1, "valueArg = %d, valueType = 0x%x: boolean, value=%s", objArr);
                    return;
                default:
                    throw new IllegalArgumentException(String.format("Invalid encoded value type 0x%x at offset 0x%x", Integer.valueOf(i16), Integer.valueOf(dexReader.getOffset())));
            }
        }
        annotatedBytes.annotate(1, "valueArg = %d, valueType = 0x%x: %s", Integer.valueOf(i3), Integer.valueOf(i16), ValueType.getValueTypeName(i16));
        dexReader.setOffset(dexReader.getOffset() - 1);
        annotatedBytes.annotate(i3 + 1, "value = %s", asString(dexBackedDexFile, dexReader));
    }

    public static String asString(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader) {
        int readUbyte = dexReader.readUbyte();
        int i3 = readUbyte >>> 5;
        int i16 = readUbyte & 31;
        boolean z16 = false;
        if (i16 != 0) {
            if (i16 != 6) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 != 16) {
                                if (i16 != 17) {
                                    switch (i16) {
                                        case 21:
                                            return ProtoIdItem.getReferenceAnnotation(dexBackedDexFile, dexReader.readSizedSmallUint(i3 + 1));
                                        case 22:
                                        case 28:
                                        case 29:
                                            dexReader.setOffset(dexReader.getOffset() - 1);
                                            return DexBackedEncodedValue.readFrom(dexBackedDexFile, dexReader).toString();
                                        case 23:
                                            return StringIdItem.getReferenceAnnotation(dexBackedDexFile, dexReader.readSizedSmallUint(i3 + 1), true);
                                        case 24:
                                            return TypeIdItem.getReferenceAnnotation(dexBackedDexFile, dexReader.readSizedSmallUint(i3 + 1));
                                        case 25:
                                            return FieldIdItem.getReferenceAnnotation(dexBackedDexFile, dexReader.readSizedSmallUint(i3 + 1));
                                        case 26:
                                            return MethodIdItem.getReferenceAnnotation(dexBackedDexFile, dexReader.readSizedSmallUint(i3 + 1));
                                        case 27:
                                            return FieldIdItem.getReferenceAnnotation(dexBackedDexFile, dexReader.readSizedSmallUint(i3 + 1));
                                        case 30:
                                            return "null";
                                        case 31:
                                            if (i3 == 1) {
                                                z16 = true;
                                            }
                                            return Boolean.toString(z16);
                                        default:
                                            throw new IllegalArgumentException(String.format("Invalid encoded value type 0x%x at offset 0x%x", Integer.valueOf(i16), Integer.valueOf(dexReader.getOffset())));
                                    }
                                }
                                return String.format("%f", Double.valueOf(Double.longBitsToDouble(dexReader.readSizedRightExtendedLong(i3 + 1))));
                            }
                            return String.format("%f", Float.valueOf(Float.intBitsToFloat(dexReader.readSizedRightExtendedInt(i3 + 1))));
                        }
                        return String.format("0x%x", Integer.valueOf(dexReader.readSizedInt(i3 + 1)));
                    }
                    return String.format("0x%x", Integer.valueOf(dexReader.readSizedSmallUint(i3 + 1)));
                }
                return String.format("0x%x", Integer.valueOf(dexReader.readSizedInt(i3 + 1)));
            }
            return String.format("0x%x", Long.valueOf(dexReader.readSizedLong(i3 + 1)));
        }
        return String.format("0x%x", Integer.valueOf(dexReader.readByte()));
    }
}
