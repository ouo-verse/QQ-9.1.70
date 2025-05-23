package org.jf.dexlib2.dexbacked.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableBooleanEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableByteEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableCharEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableDoubleEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableFloatEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableIntEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableLongEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableNullEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableShortEncodedValue;
import org.jf.dexlib2.util.Preconditions;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class DexBackedEncodedValue {
    @Nonnull
    public static EncodedValue readFrom(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader) {
        boolean z16;
        int offset = dexReader.getOffset();
        try {
            int readUbyte = dexReader.readUbyte();
            int i3 = readUbyte & 31;
            int i16 = readUbyte >>> 5;
            if (i3 != 0) {
                if (i3 != 6) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 16) {
                                    if (i3 != 17) {
                                        switch (i3) {
                                            case 21:
                                                Preconditions.checkValueArg(i16, 3);
                                                return new DexBackedMethodTypeEncodedValue(dexBackedDexFile, dexReader, i16);
                                            case 22:
                                                Preconditions.checkValueArg(i16, 3);
                                                return new DexBackedMethodHandleEncodedValue(dexBackedDexFile, dexReader, i16);
                                            case 23:
                                                Preconditions.checkValueArg(i16, 3);
                                                return new DexBackedStringEncodedValue(dexBackedDexFile, dexReader, i16);
                                            case 24:
                                                Preconditions.checkValueArg(i16, 3);
                                                return new DexBackedTypeEncodedValue(dexBackedDexFile, dexReader, i16);
                                            case 25:
                                                Preconditions.checkValueArg(i16, 3);
                                                return new DexBackedFieldEncodedValue(dexBackedDexFile, dexReader, i16);
                                            case 26:
                                                Preconditions.checkValueArg(i16, 3);
                                                return new DexBackedMethodEncodedValue(dexBackedDexFile, dexReader, i16);
                                            case 27:
                                                Preconditions.checkValueArg(i16, 3);
                                                return new DexBackedEnumEncodedValue(dexBackedDexFile, dexReader, i16);
                                            case 28:
                                                Preconditions.checkValueArg(i16, 0);
                                                return new DexBackedArrayEncodedValue(dexBackedDexFile, dexReader);
                                            case 29:
                                                Preconditions.checkValueArg(i16, 0);
                                                return new DexBackedAnnotationEncodedValue(dexBackedDexFile, dexReader);
                                            case 30:
                                                Preconditions.checkValueArg(i16, 0);
                                                return ImmutableNullEncodedValue.INSTANCE;
                                            case 31:
                                                Preconditions.checkValueArg(i16, 1);
                                                if (i16 == 1) {
                                                    z16 = true;
                                                } else {
                                                    z16 = false;
                                                }
                                                return ImmutableBooleanEncodedValue.forBoolean(z16);
                                            default:
                                                throw new ExceptionWithContext("Invalid encoded_value type: 0x%x", Integer.valueOf(i3));
                                        }
                                    }
                                    Preconditions.checkValueArg(i16, 7);
                                    return new ImmutableDoubleEncodedValue(Double.longBitsToDouble(dexReader.readSizedRightExtendedLong(i16 + 1)));
                                }
                                Preconditions.checkValueArg(i16, 3);
                                return new ImmutableFloatEncodedValue(Float.intBitsToFloat(dexReader.readSizedRightExtendedInt(i16 + 1)));
                            }
                            Preconditions.checkValueArg(i16, 3);
                            return new ImmutableIntEncodedValue(dexReader.readSizedInt(i16 + 1));
                        }
                        Preconditions.checkValueArg(i16, 1);
                        return new ImmutableCharEncodedValue((char) dexReader.readSizedSmallUint(i16 + 1));
                    }
                    Preconditions.checkValueArg(i16, 1);
                    return new ImmutableShortEncodedValue((short) dexReader.readSizedInt(i16 + 1));
                }
                Preconditions.checkValueArg(i16, 7);
                return new ImmutableLongEncodedValue(dexReader.readSizedLong(i16 + 1));
            }
            Preconditions.checkValueArg(i16, 0);
            return new ImmutableByteEncodedValue((byte) dexReader.readByte());
        } catch (Exception e16) {
            throw ExceptionWithContext.withContext(e16, "Error while reading encoded value at offset 0x%x", Integer.valueOf(offset));
        }
    }

    public static void skipFrom(@Nonnull DexReader dexReader) {
        int offset = dexReader.getOffset();
        try {
            int readUbyte = dexReader.readUbyte();
            int i3 = readUbyte & 31;
            if (i3 != 0) {
                if (i3 != 6 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 16 && i3 != 17) {
                    switch (i3) {
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                            break;
                        case 28:
                            DexBackedArrayEncodedValue.skipFrom(dexReader);
                            return;
                        case 29:
                            DexBackedAnnotationEncodedValue.skipFrom(dexReader);
                            return;
                        case 30:
                        case 31:
                            return;
                        default:
                            throw new ExceptionWithContext("Invalid encoded_value type: 0x%x", Integer.valueOf(i3));
                    }
                }
                dexReader.moveRelative((readUbyte >>> 5) + 1);
                return;
            }
            dexReader.skipByte();
        } catch (Exception e16) {
            throw ExceptionWithContext.withContext(e16, "Error while skipping encoded value at offset 0x%x", Integer.valueOf(offset));
        }
    }
}
