package org.jf.dexlib2.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.VerificationError;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;

/* loaded from: classes29.dex */
public class Preconditions {
    public static int check35cAnd45ccRegisterCount(int i3) {
        if (i3 >= 0 && i3 <= 5) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid register count: %d. Must be between 0 and 5, inclusive.", Integer.valueOf(i3)));
    }

    public static int checkArrayPayloadElementWidth(int i3) {
        if (i3 != 1 && i3 != 2 && i3 != 4 && i3 != 8) {
            throw new IllegalArgumentException(String.format("Not a valid element width: %d", Integer.valueOf(i3)));
        }
        return i3;
    }

    public static <L extends List<? extends Number>> L checkArrayPayloadElements(int i3, L l3) {
        long j3 = (1 << ((i3 * 8) - 1)) - 1;
        long j16 = (-j3) - 1;
        Iterator it = l3.iterator();
        while (it.hasNext()) {
            Number number = (Number) it.next();
            if (number.longValue() < j16 || number.longValue() > j3) {
                throw new IllegalArgumentException(String.format("%d does not fit into a %d-byte signed integer", Long.valueOf(number.longValue()), Integer.valueOf(i3)));
            }
        }
        return l3;
    }

    public static int checkByteCodeOffset(int i3) {
        if (i3 >= -128 && i3 <= 127) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid code offset: %d. Must be between -128 and 127, inclusive.", Integer.valueOf(i3)));
    }

    public static int checkByteLiteral(int i3) {
        if (i3 >= -128 && i3 <= 127) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid literal value: %d. Must be between -128 and 127, inclusive.", Integer.valueOf(i3)));
    }

    public static int checkByteRegister(int i3) {
        if ((i3 & (-256)) == 0) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid register: v%d. Must be between v0 and v255, inclusive.", Integer.valueOf(i3)));
    }

    public static int checkFieldOffset(int i3) {
        if (i3 >= 0 && i3 <= 65535) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid field offset: 0x%x. Must be between 0x0000 and 0xFFFF inclusive", Integer.valueOf(i3)));
    }

    public static void checkFormat(Opcode opcode, Format format) {
        if (opcode.format == format) {
        } else {
            throw new IllegalArgumentException(String.format("Invalid opcode %s for %s", opcode.name, format.name()));
        }
    }

    public static int checkInlineIndex(int i3) {
        if (i3 >= 0 && i3 <= 65535) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid inline index: %d. Must be between 0 and 65535, inclusive", Integer.valueOf(i3)));
    }

    public static int checkIntegerHatLiteral(int i3) {
        if ((65535 & i3) == 0) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid literal value: %d. Low 16 bits must be zeroed out.", Integer.valueOf(i3)));
    }

    public static long checkLongHatLiteral(long j3) {
        if ((281474976710655L & j3) == 0) {
            return j3;
        }
        throw new IllegalArgumentException(String.format("Invalid literal value: %d. Low 48 bits must be zeroed out.", Long.valueOf(j3)));
    }

    public static int checkNibbleLiteral(int i3) {
        if (i3 >= -8 && i3 <= 7) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid literal value: %d. Must be between -8 and 7, inclusive.", Integer.valueOf(i3)));
    }

    public static int checkNibbleRegister(int i3) {
        if ((i3 & (-16)) == 0) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid register: v%d. Must be between v0 and v15, inclusive.", Integer.valueOf(i3)));
    }

    public static <T extends Reference> T checkReference(int i3, T t16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (!(t16 instanceof MethodReference)) {
                            throw new IllegalArgumentException("Invalid reference type, expecting a method reference");
                        }
                    } else {
                        throw new IllegalArgumentException(String.format("Not a valid reference type: %d", Integer.valueOf(i3)));
                    }
                } else if (!(t16 instanceof FieldReference)) {
                    throw new IllegalArgumentException("Invalid reference type, expecting a field reference");
                }
            } else if (!(t16 instanceof TypeReference)) {
                throw new IllegalArgumentException("Invalid reference type, expecting a type reference");
            }
        } else if (!(t16 instanceof StringReference)) {
            throw new IllegalArgumentException("Invalid reference type, expecting a string reference");
        }
        return t16;
    }

    public static int checkRegisterRangeCount(int i3) {
        if ((i3 & (-256)) == 0) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid register count: %d. Must be between 0 and 255, inclusive.", Integer.valueOf(i3)));
    }

    public static <C extends Collection<? extends SwitchElement>> C checkSequentialOrderedKeys(C c16) {
        Iterator it = c16.iterator();
        Integer num = null;
        while (it.hasNext()) {
            int key = ((SwitchElement) it.next()).getKey();
            if (num != null && num.intValue() + 1 != key) {
                throw new IllegalArgumentException("SwitchElement set is not sequential and ordered");
            }
            num = Integer.valueOf(key);
        }
        return c16;
    }

    public static int checkShortCodeOffset(int i3) {
        if (i3 >= -32768 && i3 <= 32767) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid code offset: %d. Must be between -32768 and 32767, inclusive.", Integer.valueOf(i3)));
    }

    public static int checkShortLiteral(int i3) {
        if (i3 >= -32768 && i3 <= 32767) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid literal value: %d. Must be between -32768 and 32767, inclusive.", Integer.valueOf(i3)));
    }

    public static int checkShortRegister(int i3) {
        if (((-65536) & i3) == 0) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid register: v%d. Must be between v0 and v65535, inclusive.", Integer.valueOf(i3)));
    }

    public static void checkValueArg(int i3, int i16) {
        if (i3 > i16) {
            if (i16 == 0) {
                throw new IllegalArgumentException(String.format("Invalid value_arg value %d for an encoded_value. Expecting 0", Integer.valueOf(i3)));
            }
            throw new IllegalArgumentException(String.format("Invalid value_arg value %d for an encoded_value. Expecting 0..%d, inclusive", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    public static int checkVerificationError(int i3) {
        if (VerificationError.isValidVerificationError(i3)) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid verification error value: %d. Must be between 1 and 9, inclusive", Integer.valueOf(i3)));
    }

    public static int checkVtableIndex(int i3) {
        if (i3 >= 0 && i3 <= 65535) {
            return i3;
        }
        throw new IllegalArgumentException(String.format("Invalid vtable index: %d. Must be between 0 and 65535, inclusive", Integer.valueOf(i3)));
    }
}
