package org.jf.dexlib2.analysis;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Opcode;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OdexedFieldInstructionMapper {
    private static final int GET = 0;
    private static final int INSTANCE = 0;
    private static final int PRIMITIVE = 0;
    private static final int PUT = 1;
    private static final int REFERENCE = 2;
    private static final int STATIC = 1;
    private static final int WIDE = 1;
    private static final FieldOpcode[] artFieldOpcodes;
    private static final FieldOpcode[] dalvikFieldOpcodes;
    private final FieldOpcode[][][] opcodeMap = (FieldOpcode[][][]) Array.newInstance((Class<?>) FieldOpcode.class, 2, 2, 10);
    private final Map<Opcode, Integer> opcodeValueTypeMap = new HashMap(30);

    static {
        Opcode opcode = Opcode.IGET_BOOLEAN;
        Opcode opcode2 = Opcode.IGET_QUICK;
        Opcode opcode3 = Opcode.IGET_VOLATILE;
        Opcode opcode4 = Opcode.IGET_BYTE;
        Opcode opcode5 = Opcode.IGET_SHORT;
        Opcode opcode6 = Opcode.IGET_CHAR;
        Opcode opcode7 = Opcode.IGET;
        Opcode opcode8 = Opcode.IGET_WIDE;
        Opcode opcode9 = Opcode.IGET_WIDE_QUICK;
        Opcode opcode10 = Opcode.IGET_WIDE_VOLATILE;
        Opcode opcode11 = Opcode.IGET_OBJECT;
        Opcode opcode12 = Opcode.IGET_OBJECT_QUICK;
        Opcode opcode13 = Opcode.IGET_OBJECT_VOLATILE;
        Opcode opcode14 = Opcode.IPUT_BOOLEAN;
        Opcode opcode15 = Opcode.IPUT_QUICK;
        Opcode opcode16 = Opcode.IPUT_VOLATILE;
        Opcode opcode17 = Opcode.IPUT_BYTE;
        Opcode opcode18 = Opcode.IPUT_SHORT;
        Opcode opcode19 = Opcode.IPUT_CHAR;
        Opcode opcode20 = Opcode.IPUT;
        Opcode opcode21 = Opcode.IPUT_WIDE;
        Opcode opcode22 = Opcode.IPUT_WIDE_QUICK;
        Opcode opcode23 = Opcode.IPUT_WIDE_VOLATILE;
        Opcode opcode24 = Opcode.IPUT_OBJECT;
        Opcode opcode25 = Opcode.IPUT_OBJECT_QUICK;
        Opcode opcode26 = Opcode.IPUT_OBJECT_VOLATILE;
        Opcode opcode27 = Opcode.SPUT_BOOLEAN;
        Opcode opcode28 = Opcode.SPUT_VOLATILE;
        Opcode opcode29 = Opcode.SPUT;
        Opcode opcode30 = Opcode.SPUT_WIDE;
        Opcode opcode31 = Opcode.SPUT_WIDE_VOLATILE;
        Opcode opcode32 = Opcode.SPUT_OBJECT;
        Opcode opcode33 = Opcode.SPUT_OBJECT_VOLATILE;
        Opcode opcode34 = Opcode.SGET_BOOLEAN;
        Opcode opcode35 = Opcode.SGET_VOLATILE;
        Opcode opcode36 = Opcode.SGET;
        Opcode opcode37 = Opcode.SGET_WIDE;
        Opcode opcode38 = Opcode.SGET_WIDE_VOLATILE;
        Opcode opcode39 = Opcode.SGET_OBJECT;
        Opcode opcode40 = Opcode.SGET_OBJECT_VOLATILE;
        dalvikFieldOpcodes = new FieldOpcode[]{new FieldOpcode('Z', opcode, opcode2, opcode3), new FieldOpcode('B', opcode4, opcode2, opcode3), new FieldOpcode('S', opcode5, opcode2, opcode3), new FieldOpcode('C', opcode6, opcode2, opcode3), new FieldOpcode('I', opcode7, opcode2, opcode3), new FieldOpcode('F', opcode7, opcode2, opcode3), new FieldOpcode('J', opcode8, opcode9, opcode10), new FieldOpcode('D', opcode8, opcode9, opcode10), new FieldOpcode('L', opcode11, opcode12, opcode13), new FieldOpcode('[', opcode11, opcode12, opcode13), new FieldOpcode('Z', opcode14, opcode15, opcode16), new FieldOpcode('B', opcode17, opcode15, opcode16), new FieldOpcode('S', opcode18, opcode15, opcode16), new FieldOpcode('C', opcode19, opcode15, opcode16), new FieldOpcode('I', opcode20, opcode15, opcode16), new FieldOpcode('F', opcode20, opcode15, opcode16), new FieldOpcode('J', opcode21, opcode22, opcode23), new FieldOpcode('D', opcode21, opcode22, opcode23), new FieldOpcode('L', opcode24, opcode25, opcode26), new FieldOpcode('[', opcode24, opcode25, opcode26), new FieldOpcode('Z', true, opcode27, opcode28), new FieldOpcode('B', true, Opcode.SPUT_BYTE, opcode28), new FieldOpcode('S', true, Opcode.SPUT_SHORT, opcode28), new FieldOpcode('C', true, Opcode.SPUT_CHAR, opcode28), new FieldOpcode('I', true, opcode29, opcode28), new FieldOpcode('F', true, opcode29, opcode28), new FieldOpcode('J', true, opcode30, opcode31), new FieldOpcode('D', true, opcode30, opcode31), new FieldOpcode('L', true, opcode32, opcode33), new FieldOpcode('[', true, opcode32, opcode33), new FieldOpcode('Z', true, opcode34, opcode35), new FieldOpcode('B', true, Opcode.SGET_BYTE, opcode35), new FieldOpcode('S', true, Opcode.SGET_SHORT, opcode35), new FieldOpcode('C', true, Opcode.SGET_CHAR, opcode35), new FieldOpcode('I', true, opcode36, opcode35), new FieldOpcode('F', true, opcode36, opcode35), new FieldOpcode('J', true, opcode37, opcode38), new FieldOpcode('D', true, opcode37, opcode38), new FieldOpcode('L', true, opcode39, opcode40), new FieldOpcode('[', true, opcode39, opcode40)};
        artFieldOpcodes = new FieldOpcode[]{new FieldOpcode('Z', opcode, Opcode.IGET_BOOLEAN_QUICK), new FieldOpcode('B', opcode4, Opcode.IGET_BYTE_QUICK), new FieldOpcode('S', opcode5, Opcode.IGET_SHORT_QUICK), new FieldOpcode('C', opcode6, Opcode.IGET_CHAR_QUICK), new FieldOpcode('I', opcode7, opcode2), new FieldOpcode('F', opcode7, opcode2), new FieldOpcode('J', opcode8, opcode9), new FieldOpcode('D', opcode8, opcode9), new FieldOpcode('L', opcode11, opcode12), new FieldOpcode('[', opcode11, opcode12), new FieldOpcode('Z', opcode14, Opcode.IPUT_BOOLEAN_QUICK), new FieldOpcode('B', opcode17, Opcode.IPUT_BYTE_QUICK), new FieldOpcode('S', opcode18, Opcode.IPUT_SHORT_QUICK), new FieldOpcode('C', opcode19, Opcode.IPUT_CHAR_QUICK), new FieldOpcode('I', opcode20, opcode15), new FieldOpcode('F', opcode20, opcode15), new FieldOpcode('J', opcode21, opcode22), new FieldOpcode('D', opcode21, opcode22), new FieldOpcode('L', opcode24, opcode25), new FieldOpcode('[', opcode24, opcode25)};
    }

    public OdexedFieldInstructionMapper(boolean z16) {
        FieldOpcode[] fieldOpcodeArr;
        if (z16) {
            fieldOpcodeArr = artFieldOpcodes;
        } else {
            fieldOpcodeArr = dalvikFieldOpcodes;
        }
        for (FieldOpcode fieldOpcode : fieldOpcodeArr) {
            this.opcodeMap[!isGet(fieldOpcode.normalOpcode) ? 1 : 0][isStatic(fieldOpcode.normalOpcode) ? 1 : 0][getTypeIndex(fieldOpcode.type)] = fieldOpcode;
            Opcode opcode = fieldOpcode.quickOpcode;
            if (opcode != null) {
                this.opcodeValueTypeMap.put(opcode, Integer.valueOf(getValueType(fieldOpcode.type)));
            }
            Opcode opcode2 = fieldOpcode.volatileOpcode;
            if (opcode2 != null) {
                this.opcodeValueTypeMap.put(opcode2, Integer.valueOf(getValueType(fieldOpcode.type)));
            }
        }
    }

    private static int getTypeIndex(char c16) {
        if (c16 != 'F') {
            if (c16 != 'L') {
                if (c16 != 'S') {
                    if (c16 != 'I') {
                        if (c16 != 'J') {
                            if (c16 == 'Z') {
                                return 0;
                            }
                            if (c16 != '[') {
                                switch (c16) {
                                    case 'B':
                                        return 1;
                                    case 'C':
                                        return 3;
                                    case 'D':
                                        return 7;
                                    default:
                                        throw new RuntimeException(String.format("Unknown type %s: ", Character.valueOf(c16)));
                                }
                            }
                            return 9;
                        }
                        return 6;
                    }
                    return 4;
                }
                return 2;
            }
            return 8;
        }
        return 5;
    }

    private static int getValueType(char c16) {
        if (c16 != 'F') {
            if (c16 != 'L') {
                if (c16 != 'S' && c16 != 'I') {
                    if (c16 != 'J') {
                        if (c16 != 'Z') {
                            if (c16 != '[') {
                                switch (c16) {
                                    case 'B':
                                    case 'C':
                                        break;
                                    case 'D':
                                        break;
                                    default:
                                        throw new RuntimeException(String.format("Unknown type %s: ", Character.valueOf(c16)));
                                }
                            } else {
                                return 2;
                            }
                        }
                    }
                    return 1;
                }
            } else {
                return 2;
            }
        }
        return 0;
    }

    private boolean isCompatible(Opcode opcode, char c16) {
        Integer num = this.opcodeValueTypeMap.get(opcode);
        if (num != null) {
            if (num.intValue() == getValueType(c16)) {
                return true;
            }
            return false;
        }
        throw new RuntimeException("Unexpected opcode: " + opcode.name);
    }

    private static boolean isGet(@Nonnull Opcode opcode) {
        if ((opcode.flags & 16) != 0) {
            return true;
        }
        return false;
    }

    private static boolean isStatic(@Nonnull Opcode opcode) {
        if ((opcode.flags & 256) != 0) {
            return true;
        }
        return false;
    }

    @Nonnull
    public Opcode getAndCheckDeodexedOpcode(@Nonnull String str, @Nonnull Opcode opcode) {
        FieldOpcode fieldOpcode = this.opcodeMap[!isGet(opcode) ? 1 : 0][isStatic(opcode) ? 1 : 0][getTypeIndex(str.charAt(0))];
        if (isCompatible(opcode, fieldOpcode.type)) {
            return fieldOpcode.normalOpcode;
        }
        throw new AnalysisException(String.format("Incorrect field type \"%s\" for %s", str, opcode.name), new Object[0]);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class FieldOpcode {
        public final boolean isStatic;

        @Nonnull
        public final Opcode normalOpcode;

        @Nullable
        public final Opcode quickOpcode;
        public final char type;

        @Nullable
        public final Opcode volatileOpcode;

        public FieldOpcode(char c16, @Nonnull Opcode opcode, @Nullable Opcode opcode2, @Nullable Opcode opcode3) {
            this.type = c16;
            this.isStatic = false;
            this.normalOpcode = opcode;
            this.quickOpcode = opcode2;
            this.volatileOpcode = opcode3;
        }

        public FieldOpcode(char c16, boolean z16, @Nonnull Opcode opcode, @Nullable Opcode opcode2) {
            this.type = c16;
            this.isStatic = z16;
            this.normalOpcode = opcode;
            this.quickOpcode = null;
            this.volatileOpcode = opcode2;
        }

        public FieldOpcode(char c16, @Nonnull Opcode opcode, @Nullable Opcode opcode2) {
            this.type = c16;
            this.isStatic = false;
            this.normalOpcode = opcode;
            this.quickOpcode = opcode2;
            this.volatileOpcode = null;
        }
    }
}
