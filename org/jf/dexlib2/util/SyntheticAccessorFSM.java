package org.jf.dexlib2.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import cooperation.qzone.QZoneHelper;
import java.util.List;
import javax.annotation.Nonnull;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.analysis.RegisterType;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.instruction.OneRegisterInstruction;
import org.jf.dexlib2.iface.instruction.WideLiteralInstruction;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SyntheticAccessorFSM {
    public static final int ADD = 7;
    public static final int AND = 12;
    public static final int DIV = 10;
    public static final int DOUBLE = 3;
    public static final int FLOAT = 2;
    public static final int INT = 0;
    public static final int LONG = 1;
    public static final int MUL = 9;
    public static final int NEGATIVE_ONE = -1;
    public static final int OR = 13;
    public static final int OTHER = 0;
    public static final int POSITIVE_ONE = 1;
    public static final int REM = 11;
    public static final int SHL = 15;
    public static final int SHR = 16;
    public static final int SUB = 8;
    static final int SyntheticAccessorFSM_en_main = 1;
    static final int SyntheticAccessorFSM_error = 0;
    static final int SyntheticAccessorFSM_first_final = 17;
    static final int SyntheticAccessorFSM_start = 1;
    public static final int USHR = 17;
    public static final int XOR = 14;

    @Nonnull
    private final Opcodes opcodes;
    private static final byte[] _SyntheticAccessorFSM_actions = init__SyntheticAccessorFSM_actions_0();
    private static final short[] _SyntheticAccessorFSM_key_offsets = init__SyntheticAccessorFSM_key_offsets_0();
    private static final short[] _SyntheticAccessorFSM_trans_keys = init__SyntheticAccessorFSM_trans_keys_0();
    private static final byte[] _SyntheticAccessorFSM_single_lengths = init__SyntheticAccessorFSM_single_lengths_0();
    private static final byte[] _SyntheticAccessorFSM_range_lengths = init__SyntheticAccessorFSM_range_lengths_0();
    private static final short[] _SyntheticAccessorFSM_index_offsets = init__SyntheticAccessorFSM_index_offsets_0();
    private static final byte[] _SyntheticAccessorFSM_indicies = init__SyntheticAccessorFSM_indicies_0();
    private static final byte[] _SyntheticAccessorFSM_trans_targs = init__SyntheticAccessorFSM_trans_targs_0();
    private static final byte[] _SyntheticAccessorFSM_trans_actions = init__SyntheticAccessorFSM_trans_actions_0();

    public SyntheticAccessorFSM(@Nonnull Opcodes opcodes) {
        this.opcodes = opcodes;
    }

    private static int getIncrementType(int i3, int i16, long j3, int i17, int i18) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (i17 == i18) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i16 != 0 && i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3) {
                    double longBitsToDouble = Double.longBitsToDouble(j3);
                    if (longBitsToDouble != 1.0d) {
                        if (longBitsToDouble != -1.0d) {
                            return -1;
                        }
                        z17 = true;
                    }
                }
                z17 = false;
            } else {
                float intBitsToFloat = Float.intBitsToFloat((int) j3);
                if (intBitsToFloat != 1.0f) {
                    if (intBitsToFloat != -1.0f) {
                        return -1;
                    }
                    z17 = true;
                }
                z17 = false;
            }
        } else {
            if (j3 != 1) {
                if (j3 != -1) {
                    return -1;
                }
                z17 = true;
            }
            z17 = false;
        }
        if ((i3 != 7 || z17) && (i3 != 8 || !z17)) {
            z18 = false;
        }
        if (z16) {
            if (z18) {
                return 4;
            }
            return 6;
        }
        if (z18) {
            return 3;
        }
        return 5;
    }

    private static byte[] init__SyntheticAccessorFSM_actions_0() {
        return new byte[]{0, 1, 0, 1, 1, 1, 2, 1, 13, 1, RegisterType.DOUBLE_LO, 1, RegisterType.DOUBLE_HI, 1, RegisterType.UNINIT_REF, 1, 17, 1, RegisterType.REFERENCE, 1, RegisterType.CONFLICTED, 1, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, 1, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 1, 25, 2, 3, 7, 2, 4, 7, 2, 5, 7, 2, 6, 7, 2, 8, 12, 2, 9, 12, 2, 10, 12, 2, 11, 12, 2, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 2, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 24, 2, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 25, 2, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 26, 2, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 27, 2, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 28};
    }

    private static short[] init__SyntheticAccessorFSM_index_offsets_0() {
        return new short[]{0, 0, 7, 73, 90, 93, 95, 156, 160, 162, 166, 169, 173, 175, 178, 180, 183, 185};
    }

    private static byte[] init__SyntheticAccessorFSM_indicies_0() {
        return new byte[]{0, 2, 0, 2, 3, 3, 1, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 9, 10, 11, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 9, 10, 11, 8, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 10, 11, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 10, 11, 24, 24, 4, 5, 6, 7, 9, 1, 25, 26, 27, 28, 29, 30, 31, 32, 25, 26, 27, 28, 29, 30, 31, 32, 1, 33, 33, 1, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 1, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 9, 10, 11, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 9, 10, 11, 8, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 10, 11, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 10, 11, 7, 9, 1, 35, 35, 36, 1, 37, 1, 35, 35, 38, 1, 35, 35, 1, 39, 39, 40, 1, 41, 1, 39, 39, 1, 42, 1, 44, 43, 1, MultipartStream.DASH, 1, 1, 0};
    }

    private static short[] init__SyntheticAccessorFSM_key_offsets_0() {
        return new short[]{0, 0, 12, 82, 98, 102, 104, 166, 172, 174, 180, 184, 190, 192, 196, 198, 201, 203};
    }

    private static byte[] init__SyntheticAccessorFSM_range_lengths_0() {
        return new byte[]{0, 6, 5, 0, 2, 1, 2, 3, 1, 3, 2, 3, 1, 2, 1, 1, 1, 0};
    }

    private static byte[] init__SyntheticAccessorFSM_single_lengths_0() {
        return new byte[]{0, 0, 60, RegisterType.UNINIT_REF, 0, 0, 58, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
    }

    private static byte[] init__SyntheticAccessorFSM_trans_actions_0() {
        return new byte[]{0, 0, 1, 0, 51, 3, 0, 27, 39, 7, 9, 11, 13, RegisterType.DOUBLE_HI, 17, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 23, 30, 42, 33, MultipartStream.DASH, 36, 48, 5, 27, 39, 30, 42, 33, MultipartStream.DASH, 36, 48, 1, 63, 1, 0, 66, 0, 1, 0, 60, 54, 0, 25, 57};
    }

    private static short[] init__SyntheticAccessorFSM_trans_keys_0() {
        return new short[]{82, 88, 89, 95, 96, 102, 103, 109, 110, 114, 116, 120, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 177, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 201, 202, 203, 204, 206, 207, 208, 216, 15, 17, 18, 25, 129, 143, 144, 176, 178, 205, 144, 145, 155, 156, 166, 167, 171, 172, 176, 177, 187, 188, 198, 199, 203, 204, 89, 95, 103, 109, 15, 17, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 177, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 201, 202, 203, 204, 206, 207, 144, 176, 178, 205, 89, 95, 103, 109, 129, 143, 15, 17, 89, 95, 103, 109, 129, 143, 89, 95, 103, 109, 89, 95, 103, 109, 129, 143, 15, 17, 89, 95, 103, 109, 15, 17, 14, 10, 12, 15, 17, 0};
    }

    private static byte[] init__SyntheticAccessorFSM_trans_targs_0() {
        return new byte[]{2, 0, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, 17, 3, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 11, 4, 4, 4, 4, 4, 4, 4, 4, 5, 17, 8, 9, 17, 10, 12, 13, 17, 17, RegisterType.UNINIT_REF, 17, 17};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x0122. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01da A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r16v3, types: [int] */
    /* JADX WARN: Type inference failed for: r16v4, types: [int] */
    /* JADX WARN: Type inference failed for: r16v6, types: [int] */
    /* JADX WARN: Type inference failed for: r16v8, types: [int] */
    /* JADX WARN: Type inference failed for: r16v9, types: [int] */
    /* JADX WARN: Type inference failed for: r18v2, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int test(List<? extends Instruction> list) {
        int i3;
        int i16;
        short s16;
        short s17;
        byte b16;
        int incrementType;
        short s18;
        int size = list.size();
        int i17 = -1;
        int i18 = 1;
        int i19 = -1;
        int i26 = -1;
        long j3 = 0;
        byte b17 = 1;
        int i27 = 0;
        int i28 = 0;
        int i29 = -1;
        int i36 = -1;
        while (true) {
            if (i27 != 0) {
                if (i27 != i18) {
                    if (i27 == 2) {
                        i3 = i18;
                        if (b17 != 0) {
                            i18 = i3;
                            i27 = 5;
                        } else {
                            i28++;
                            if (i28 != size) {
                                i18 = i3;
                                i27 = i18;
                            }
                        }
                    }
                }
            } else if (i28 == size) {
                i27 = 4;
            } else if (b17 == 0) {
                i27 = 5;
            }
            short s19 = _SyntheticAccessorFSM_key_offsets[b17];
            short s26 = _SyntheticAccessorFSM_index_offsets[b17];
            byte b18 = _SyntheticAccessorFSM_single_lengths[b17];
            if (b18 > 0) {
                ?? r18 = s19 + b18;
                int i37 = s19;
                int i38 = r18 - 1;
                while (i38 >= i37) {
                    int i39 = i37 + ((i38 - i37) >> 1);
                    i16 = i17;
                    short shortValue = this.opcodes.getOpcodeValue(list.get(i28).getOpcode()).shortValue();
                    short[] sArr = _SyntheticAccessorFSM_trans_keys;
                    int i46 = i37;
                    if (shortValue < sArr[i39]) {
                        i38 = i39 - 1;
                        i37 = i46;
                    } else if (this.opcodes.getOpcodeValue(list.get(i28).getOpcode()).shortValue() > sArr[i39]) {
                        i37 = i39 + 1;
                    } else {
                        s18 = s26 + (i39 - s19);
                        i3 = 1;
                        s17 = s18;
                        byte b19 = _SyntheticAccessorFSM_indicies[s17];
                        b17 = _SyntheticAccessorFSM_trans_targs[b19];
                        b16 = _SyntheticAccessorFSM_trans_actions[b19];
                        if (b16 != 0) {
                            int i47 = b16 + 1;
                            byte b26 = _SyntheticAccessorFSM_actions[b16];
                            int i48 = i19;
                            int i49 = i26;
                            long j16 = j3;
                            int i56 = i29;
                            int i57 = i36;
                            while (true) {
                                ?? r16 = b26 - 1;
                                if (b26 > 0) {
                                    int i58 = i47 + 1;
                                    switch (_SyntheticAccessorFSM_actions[i47]) {
                                        case 0:
                                            i48 = ((OneRegisterInstruction) list.get(i28)).getRegisterA();
                                            b26 = r16;
                                            i47 = i58;
                                        case 1:
                                            j16 = ((WideLiteralInstruction) list.get(i28)).getWideLiteral();
                                            b26 = r16;
                                            i47 = i58;
                                        case 2:
                                            j16 = ((WideLiteralInstruction) list.get(i28)).getWideLiteral();
                                            i56 = 7;
                                        case 3:
                                        case 8:
                                            i57 = 0;
                                            b26 = r16;
                                            i47 = i58;
                                        case 4:
                                        case 9:
                                            i57 = i3;
                                            b26 = r16;
                                            i47 = i58;
                                        case 5:
                                        case 10:
                                            i57 = 2;
                                            b26 = r16;
                                            i47 = i58;
                                        case 6:
                                        case 11:
                                            i57 = 3;
                                            b26 = r16;
                                            i47 = i58;
                                        case 7:
                                            i56 = 7;
                                            b26 = r16;
                                            i47 = i58;
                                        case 12:
                                            i56 = 8;
                                            b26 = r16;
                                            i47 = i58;
                                        case 13:
                                            i56 = 9;
                                            b26 = r16;
                                            i47 = i58;
                                        case 14:
                                            i56 = 10;
                                            b26 = r16;
                                            i47 = i58;
                                        case 15:
                                            i56 = 11;
                                            b26 = r16;
                                            i47 = i58;
                                        case 16:
                                            i56 = 12;
                                            b26 = r16;
                                            i47 = i58;
                                        case 17:
                                            i56 = 13;
                                            b26 = r16;
                                            i47 = i58;
                                        case 18:
                                            i56 = 14;
                                            b26 = r16;
                                            i47 = i58;
                                        case 19:
                                            i56 = 15;
                                            b26 = r16;
                                            i47 = i58;
                                        case 20:
                                            i56 = 16;
                                            b26 = r16;
                                            i47 = i58;
                                        case 21:
                                            i56 = 17;
                                            b26 = r16;
                                            i47 = i58;
                                        case 22:
                                            i49 = ((OneRegisterInstruction) list.get(i28)).getRegisterA();
                                            b26 = r16;
                                            i47 = i58;
                                        case 23:
                                            i28++;
                                            i29 = i56;
                                            i36 = i57;
                                            i19 = i48;
                                            i26 = i49;
                                            i17 = i3;
                                            i18 = i17;
                                            break;
                                        case 24:
                                            i28++;
                                            i29 = i56;
                                            i36 = i57;
                                            i19 = i48;
                                            i26 = i49;
                                            i18 = i3;
                                            j3 = j16;
                                            i17 = 2;
                                            break;
                                        case 25:
                                            i28++;
                                            i29 = i56;
                                            i36 = i57;
                                            i19 = i48;
                                            i26 = i49;
                                            i18 = i3;
                                            j3 = j16;
                                            i17 = 0;
                                            break;
                                        case 26:
                                            incrementType = getIncrementType(i56, i57, j16, i48, i49);
                                            i16 = incrementType;
                                            b26 = r16;
                                            i47 = i58;
                                        case 27:
                                            incrementType = getIncrementType(i56, i57, j16, i48, i49);
                                            i16 = incrementType;
                                            b26 = r16;
                                            i47 = i58;
                                        case 28:
                                            i28++;
                                            i17 = i56;
                                            i29 = i17;
                                            i36 = i57;
                                            i19 = i48;
                                            i26 = i49;
                                            i18 = i3;
                                            break;
                                        default:
                                            b26 = r16;
                                            i47 = i58;
                                    }
                                } else {
                                    i29 = i56;
                                    i36 = i57;
                                    i19 = i48;
                                    i26 = i49;
                                    j3 = j16;
                                }
                            }
                            j3 = j16;
                            i27 = 5;
                        }
                        i17 = i16;
                        if (b17 != 0) {
                        }
                    }
                    i17 = i16;
                }
                i16 = i17;
                s19 = r18;
                s16 = s26 + b18;
            } else {
                i16 = i17;
                s16 = s26;
            }
            byte b27 = _SyntheticAccessorFSM_range_lengths[b17];
            s18 = s16;
            if (b27 > 0) {
                int i59 = ((b27 << 1) + s19) - 2;
                int i65 = s19;
                while (i59 >= i65) {
                    int i66 = (((i59 - i65) >> 1) & (-2)) + i65;
                    byte b28 = b27;
                    short shortValue2 = this.opcodes.getOpcodeValue(list.get(i28).getOpcode()).shortValue();
                    short[] sArr2 = _SyntheticAccessorFSM_trans_keys;
                    int i67 = i59;
                    if (shortValue2 < sArr2[i66]) {
                        i59 = i66 - 2;
                    } else if (this.opcodes.getOpcodeValue(list.get(i28).getOpcode()).shortValue() > sArr2[i66 + 1]) {
                        i65 = i66 + 2;
                        i59 = i67;
                    } else {
                        i3 = 1;
                        s17 = s16 + ((i66 - s19) >> 1);
                        byte b192 = _SyntheticAccessorFSM_indicies[s17];
                        b17 = _SyntheticAccessorFSM_trans_targs[b192];
                        b16 = _SyntheticAccessorFSM_trans_actions[b192];
                        if (b16 != 0) {
                        }
                        i17 = i16;
                        if (b17 != 0) {
                        }
                    }
                    b27 = b28;
                }
                s18 = s16 + b27;
            }
            i3 = 1;
            s17 = s18;
            byte b1922 = _SyntheticAccessorFSM_indicies[s17];
            b17 = _SyntheticAccessorFSM_trans_targs[b1922];
            b16 = _SyntheticAccessorFSM_trans_actions[b1922];
            if (b16 != 0) {
            }
            i17 = i16;
            if (b17 != 0) {
            }
        }
        return i17;
    }
}
