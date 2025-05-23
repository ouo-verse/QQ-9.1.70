package org.jf.util;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Hex {
    Hex() {
    }

    public static String dump(byte[] bArr, int i3, int i16, int i17, int i18, int i19) {
        String u16;
        int i26 = i3 + i16;
        if ((i3 | i16 | i26) >= 0 && i26 <= bArr.length) {
            if (i17 >= 0) {
                if (i16 == 0) {
                    return "";
                }
                StringBuffer stringBuffer = new StringBuffer((i16 * 4) + 6);
                int i27 = 0;
                while (i16 > 0) {
                    if (i27 == 0) {
                        if (i19 != 2) {
                            if (i19 != 4) {
                                if (i19 != 6) {
                                    u16 = u4(i17);
                                } else {
                                    u16 = u3(i17);
                                }
                            } else {
                                u16 = u2(i17);
                            }
                        } else {
                            u16 = u1(i17);
                        }
                        stringBuffer.append(u16);
                        stringBuffer.append(MsgSummary.STR_COLON);
                    } else if ((i27 & 1) == 0) {
                        stringBuffer.append(TokenParser.SP);
                    }
                    stringBuffer.append(u1(bArr[i3]));
                    i17++;
                    i3++;
                    i27++;
                    if (i27 == i18) {
                        stringBuffer.append('\n');
                        i27 = 0;
                    }
                    i16--;
                }
                if (i27 != 0) {
                    stringBuffer.append('\n');
                }
                return stringBuffer.toString();
            }
            throw new IllegalArgumentException("outOffset < 0");
        }
        throw new IndexOutOfBoundsException("arr.length " + bArr.length + "; " + i3 + "..!" + i26);
    }

    public static String s1(int i3) {
        char[] cArr = new char[3];
        if (i3 < 0) {
            cArr[0] = '-';
            i3 = -i3;
        } else {
            cArr[0] = '+';
        }
        for (int i16 = 0; i16 < 2; i16++) {
            cArr[2 - i16] = Character.forDigit(i3 & 15, 16);
            i3 >>= 4;
        }
        return new String(cArr);
    }

    public static String s2(int i3) {
        char[] cArr = new char[5];
        if (i3 < 0) {
            cArr[0] = '-';
            i3 = -i3;
        } else {
            cArr[0] = '+';
        }
        for (int i16 = 0; i16 < 4; i16++) {
            cArr[4 - i16] = Character.forDigit(i3 & 15, 16);
            i3 >>= 4;
        }
        return new String(cArr);
    }

    public static String s4(int i3) {
        char[] cArr = new char[9];
        if (i3 < 0) {
            cArr[0] = '-';
            i3 = -i3;
        } else {
            cArr[0] = '+';
        }
        for (int i16 = 0; i16 < 8; i16++) {
            cArr[8 - i16] = Character.forDigit(i3 & 15, 16);
            i3 >>= 4;
        }
        return new String(cArr);
    }

    public static String s8(long j3) {
        char[] cArr = new char[17];
        if (j3 < 0) {
            cArr[0] = '-';
            j3 = -j3;
        } else {
            cArr[0] = '+';
        }
        for (int i3 = 0; i3 < 16; i3++) {
            cArr[16 - i3] = Character.forDigit(((int) j3) & 15, 16);
            j3 >>= 4;
        }
        return new String(cArr);
    }

    public static String u1(int i3) {
        char[] cArr = new char[2];
        for (int i16 = 0; i16 < 2; i16++) {
            cArr[1 - i16] = Character.forDigit(i3 & 15, 16);
            i3 >>= 4;
        }
        return new String(cArr);
    }

    public static String u2(int i3) {
        char[] cArr = new char[4];
        for (int i16 = 0; i16 < 4; i16++) {
            cArr[3 - i16] = Character.forDigit(i3 & 15, 16);
            i3 >>= 4;
        }
        return new String(cArr);
    }

    public static String u2or4(int i3) {
        if (i3 == ((char) i3)) {
            return u2(i3);
        }
        return u4(i3);
    }

    public static String u3(int i3) {
        char[] cArr = new char[6];
        for (int i16 = 0; i16 < 6; i16++) {
            cArr[5 - i16] = Character.forDigit(i3 & 15, 16);
            i3 >>= 4;
        }
        return new String(cArr);
    }

    public static String u4(int i3) {
        char[] cArr = new char[8];
        for (int i16 = 0; i16 < 8; i16++) {
            cArr[7 - i16] = Character.forDigit(i3 & 15, 16);
            i3 >>= 4;
        }
        return new String(cArr);
    }

    public static String u8(long j3) {
        char[] cArr = new char[16];
        for (int i3 = 0; i3 < 16; i3++) {
            cArr[15 - i3] = Character.forDigit(((int) j3) & 15, 16);
            j3 >>= 4;
        }
        return new String(cArr);
    }

    public static String uNibble(int i3) {
        return new String(new char[]{Character.forDigit(i3 & 15, 16)});
    }
}
