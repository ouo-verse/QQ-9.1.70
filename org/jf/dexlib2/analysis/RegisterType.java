package org.jf.dexlib2.analysis;

import java.io.IOException;
import java.io.Writer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RegisterType {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final byte BOOLEAN = 4;
    public static final byte BYTE = 5;
    public static final byte CHAR = 9;
    public static final byte FLOAT = 11;
    public static final byte INTEGER = 10;
    public static final byte LONG_HI = 13;
    public static final byte LONG_LO = 12;
    public static final byte NULL = 2;
    public static final byte ONE = 3;
    public static final byte POS_BYTE = 6;
    public static final byte POS_SHORT = 8;
    public static final byte SHORT = 7;
    public static final byte UNINIT = 1;
    public static final byte UNINIT_THIS = 17;
    public static final byte UNKNOWN = 0;
    public final byte category;

    @Nullable
    public final TypeProto type;
    public static final String[] CATEGORY_NAMES = {"Unknown", "Uninit", "Null", "One", "Boolean", "Byte", "PosByte", "Short", "PosShort", "Char", "Integer", "Float", "LongLo", "LongHi", "DoubleLo", "DoubleHi", "UninitRef", "UninitThis", "Reference", "Conflicted"};
    public static final byte DOUBLE_LO = 14;
    public static final byte DOUBLE_HI = 15;
    public static final byte UNINIT_REF = 16;
    public static final byte REFERENCE = 18;
    public static final byte CONFLICTED = 19;
    protected static byte[][] mergeTable = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, DOUBLE_LO, DOUBLE_HI, UNINIT_REF, 17, REFERENCE, CONFLICTED}, new byte[]{1, 1, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{2, CONFLICTED, 2, 4, 4, 5, 6, 7, 8, 9, 10, 11, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, REFERENCE, CONFLICTED}, new byte[]{3, CONFLICTED, 4, 3, 4, 5, 6, 7, 8, 9, 10, 11, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{4, CONFLICTED, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{5, CONFLICTED, 5, 5, 5, 5, 5, 7, 7, 10, 10, 11, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{6, CONFLICTED, 6, 6, 6, 5, 6, 7, 8, 9, 10, 11, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{7, CONFLICTED, 7, 7, 7, 7, 7, 7, 7, 10, 10, 11, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{8, CONFLICTED, 8, 8, 8, 7, 8, 7, 8, 9, 10, 11, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{9, CONFLICTED, 9, 9, 9, 10, 9, 10, 9, 9, 10, 11, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{10, CONFLICTED, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{11, CONFLICTED, 11, 11, 11, 11, 11, 11, 11, 11, 10, 11, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{12, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, 12, CONFLICTED, 12, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{13, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, 13, CONFLICTED, 13, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{DOUBLE_LO, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, 12, CONFLICTED, DOUBLE_LO, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{DOUBLE_HI, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, 13, CONFLICTED, DOUBLE_HI, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{UNINIT_REF, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}, new byte[]{17, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, 17, CONFLICTED, CONFLICTED}, new byte[]{REFERENCE, CONFLICTED, REFERENCE, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, REFERENCE, CONFLICTED}, new byte[]{CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED, CONFLICTED}};
    public static final RegisterType UNKNOWN_TYPE = new RegisterType((byte) 0, null);
    public static final RegisterType UNINIT_TYPE = new RegisterType((byte) 1, null);
    public static final RegisterType NULL_TYPE = new RegisterType((byte) 2, null);
    public static final RegisterType ONE_TYPE = new RegisterType((byte) 3, null);
    public static final RegisterType BOOLEAN_TYPE = new RegisterType((byte) 4, null);
    public static final RegisterType BYTE_TYPE = new RegisterType((byte) 5, null);
    public static final RegisterType POS_BYTE_TYPE = new RegisterType((byte) 6, null);
    public static final RegisterType SHORT_TYPE = new RegisterType((byte) 7, null);
    public static final RegisterType POS_SHORT_TYPE = new RegisterType((byte) 8, null);
    public static final RegisterType CHAR_TYPE = new RegisterType((byte) 9, null);
    public static final RegisterType INTEGER_TYPE = new RegisterType((byte) 10, null);
    public static final RegisterType FLOAT_TYPE = new RegisterType((byte) 11, null);
    public static final RegisterType LONG_LO_TYPE = new RegisterType((byte) 12, null);
    public static final RegisterType LONG_HI_TYPE = new RegisterType((byte) 13, null);
    public static final RegisterType DOUBLE_LO_TYPE = new RegisterType(DOUBLE_LO, null);
    public static final RegisterType DOUBLE_HI_TYPE = new RegisterType(DOUBLE_HI, null);
    public static final RegisterType CONFLICTED_TYPE = new RegisterType(CONFLICTED, null);

    RegisterType(byte b16, @Nullable TypeProto typeProto) {
        this.category = b16;
        this.type = typeProto;
    }

    @Nonnull
    public static RegisterType getRegisterType(@Nonnull ClassPath classPath, @Nonnull CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        if (charAt != 'F') {
            if (charAt != 'L') {
                if (charAt == 'S') {
                    return SHORT_TYPE;
                }
                if (charAt == 'I') {
                    return INTEGER_TYPE;
                }
                if (charAt == 'J') {
                    return LONG_LO_TYPE;
                }
                if (charAt == 'Z') {
                    return BOOLEAN_TYPE;
                }
                if (charAt != '[') {
                    switch (charAt) {
                        case 'B':
                            return BYTE_TYPE;
                        case 'C':
                            return CHAR_TYPE;
                        case 'D':
                            return DOUBLE_LO_TYPE;
                        default:
                            throw new AnalysisException("Invalid type: " + ((Object) charSequence), new Object[0]);
                    }
                }
            }
            return getRegisterType(REFERENCE, classPath.getClass(charSequence));
        }
        return FLOAT_TYPE;
    }

    @Nonnull
    public static RegisterType getRegisterTypeForLiteral(int i3) {
        if (i3 < -32768) {
            return INTEGER_TYPE;
        }
        if (i3 < -128) {
            return SHORT_TYPE;
        }
        if (i3 < 0) {
            return BYTE_TYPE;
        }
        if (i3 == 0) {
            return NULL_TYPE;
        }
        if (i3 == 1) {
            return ONE_TYPE;
        }
        if (i3 < 128) {
            return POS_BYTE_TYPE;
        }
        if (i3 < 32768) {
            return POS_SHORT_TYPE;
        }
        if (i3 < 65536) {
            return CHAR_TYPE;
        }
        return INTEGER_TYPE;
    }

    @Nonnull
    public static RegisterType getWideRegisterType(@Nonnull CharSequence charSequence, boolean z16) {
        char charAt = charSequence.charAt(0);
        if (charAt != 'D') {
            if (charAt == 'J') {
                if (z16) {
                    return getRegisterType((byte) 12, (TypeProto) null);
                }
                return getRegisterType((byte) 13, (TypeProto) null);
            }
            throw new ExceptionWithContext("Cannot use this method for narrow register type: %s", charSequence);
        }
        if (z16) {
            return getRegisterType(DOUBLE_LO, (TypeProto) null);
        }
        return getRegisterType(DOUBLE_HI, (TypeProto) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            RegisterType registerType = (RegisterType) obj;
            byte b16 = this.category;
            if (b16 == registerType.category && b16 != 16 && b16 != 17) {
                TypeProto typeProto = this.type;
                TypeProto typeProto2 = registerType.type;
                if (typeProto != null) {
                    return typeProto.equals(typeProto2);
                }
                if (typeProto2 == null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.category * 31;
        TypeProto typeProto = this.type;
        if (typeProto != null) {
            i3 = typeProto.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @Nonnull
    public RegisterType merge(@Nonnull RegisterType registerType) {
        TypeProto typeProto;
        if (registerType.equals(this)) {
            return this;
        }
        byte[][] bArr = mergeTable;
        byte b16 = this.category;
        byte b17 = bArr[b16][registerType.category];
        if (b17 == 18) {
            typeProto = this.type;
            if (typeProto != null) {
                TypeProto typeProto2 = registerType.type;
                if (typeProto2 != null) {
                    typeProto = typeProto.getCommonSuperclass(typeProto2);
                }
            } else {
                typeProto = registerType.type;
            }
        } else if (b17 != 16 && b17 != 17) {
            typeProto = null;
        } else {
            if (b16 == 0) {
                return registerType;
            }
            return this;
        }
        if (typeProto != null) {
            if (typeProto.equals(this.type)) {
                return this;
            }
            if (typeProto.equals(registerType.type)) {
                return registerType;
            }
        }
        return getRegisterType(b17, typeProto);
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        sb5.append(CATEGORY_NAMES[this.category]);
        if (this.type == null) {
            str = "";
        } else {
            str = "," + this.type;
        }
        sb5.append(str);
        sb5.append(")");
        return sb5.toString();
    }

    public void writeTo(Writer writer) throws IOException {
        writer.write(40);
        writer.write(CATEGORY_NAMES[this.category]);
        if (this.type != null) {
            writer.write(44);
            writer.write(this.type.getType());
        }
        writer.write(41);
    }

    @Nonnull
    public static RegisterType getRegisterType(byte b16, @Nullable TypeProto typeProto) {
        if (b16 != 19) {
            switch (b16) {
                case 0:
                    return UNKNOWN_TYPE;
                case 1:
                    return UNINIT_TYPE;
                case 2:
                    return NULL_TYPE;
                case 3:
                    return ONE_TYPE;
                case 4:
                    return BOOLEAN_TYPE;
                case 5:
                    return BYTE_TYPE;
                case 6:
                    return POS_BYTE_TYPE;
                case 7:
                    return SHORT_TYPE;
                case 8:
                    return POS_SHORT_TYPE;
                case 9:
                    return CHAR_TYPE;
                case 10:
                    return INTEGER_TYPE;
                case 11:
                    return FLOAT_TYPE;
                case 12:
                    return LONG_LO_TYPE;
                case 13:
                    return LONG_HI_TYPE;
                case 14:
                    return DOUBLE_LO_TYPE;
                case 15:
                    return DOUBLE_HI_TYPE;
                default:
                    return new RegisterType(b16, typeProto);
            }
        }
        return CONFLICTED_TYPE;
    }
}
