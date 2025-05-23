package kotlin.reflect.jvm.internal.impl.protobuf;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;

/* compiled from: P */
/* loaded from: classes28.dex */
final class Utf8 {
    private static int incompleteStateFor(int i3) {
        if (i3 > -12) {
            return -1;
        }
        return i3;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return isValidUtf8(bArr, 0, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r7[r8] > (-65)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        if (r7[r8] > (-65)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
    
        if (r7[r6] > (-65)) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int partialIsValidUtf8(int i3, byte[] bArr, int i16, int i17) {
        byte b16;
        int i18;
        int i19;
        if (i3 != 0) {
            if (i16 >= i17) {
                return i3;
            }
            byte b17 = (byte) i3;
            if (b17 < -32) {
                if (b17 >= -62) {
                    i19 = i16 + 1;
                }
                return -1;
            }
            if (b17 < -16) {
                byte b18 = (byte) (~(i3 >> 8));
                if (b18 == 0) {
                    int i26 = i16 + 1;
                    byte b19 = bArr[i16];
                    if (i26 >= i17) {
                        return incompleteStateFor(b17, b19);
                    }
                    i16 = i26;
                    b18 = b19;
                }
                if (b18 <= -65 && ((b17 != -32 || b18 >= -96) && (b17 != -19 || b18 < -96))) {
                    i19 = i16 + 1;
                }
                return -1;
            }
            byte b26 = (byte) (~(i3 >> 8));
            if (b26 == 0) {
                i18 = i16 + 1;
                b26 = bArr[i16];
                if (i18 >= i17) {
                    return incompleteStateFor(b17, b26);
                }
                b16 = 0;
            } else {
                b16 = (byte) (i3 >> 16);
                i18 = i16;
            }
            if (b16 == 0) {
                int i27 = i18 + 1;
                byte b27 = bArr[i18];
                if (i27 >= i17) {
                    return incompleteStateFor(b17, b26, b27);
                }
                b16 = b27;
                i18 = i27;
            }
            if (b26 <= -65 && (((b17 << 28) + (b26 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) == 0 && b16 <= -65) {
                i16 = i18 + 1;
            }
            return -1;
            i16 = i19;
        }
        return partialIsValidUtf8(bArr, i16, i17);
    }

    private static int partialIsValidUtf8NonAscii(byte[] bArr, int i3, int i16) {
        while (i3 < i16) {
            int i17 = i3 + 1;
            byte b16 = bArr[i3];
            if (b16 < 0) {
                if (b16 < -32) {
                    if (i17 >= i16) {
                        return b16;
                    }
                    if (b16 >= -62) {
                        i3 = i17 + 1;
                        if (bArr[i17] > -65) {
                        }
                    }
                    return -1;
                }
                if (b16 < -16) {
                    if (i17 >= i16 - 1) {
                        return incompleteStateFor(bArr, i17, i16);
                    }
                    int i18 = i17 + 1;
                    byte b17 = bArr[i17];
                    if (b17 <= -65 && ((b16 != -32 || b17 >= -96) && (b16 != -19 || b17 < -96))) {
                        i3 = i18 + 1;
                        if (bArr[i18] > -65) {
                        }
                    }
                    return -1;
                }
                if (i17 >= i16 - 2) {
                    return incompleteStateFor(bArr, i17, i16);
                }
                int i19 = i17 + 1;
                byte b18 = bArr[i17];
                if (b18 <= -65 && (((b16 << 28) + (b18 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) == 0) {
                    int i26 = i19 + 1;
                    if (bArr[i19] <= -65) {
                        i17 = i26 + 1;
                        if (bArr[i26] > -65) {
                        }
                    }
                }
                return -1;
            }
            i3 = i17;
        }
        return 0;
    }

    private static int incompleteStateFor(int i3, int i16) {
        if (i3 > -12 || i16 > -65) {
            return -1;
        }
        return i3 ^ (i16 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i3, int i16) {
        return partialIsValidUtf8(bArr, i3, i16) == 0;
    }

    private static int incompleteStateFor(int i3, int i16, int i17) {
        if (i3 > -12 || i16 > -65 || i17 > -65) {
            return -1;
        }
        return (i3 ^ (i16 << 8)) ^ (i17 << 16);
    }

    private static int incompleteStateFor(byte[] bArr, int i3, int i16) {
        byte b16 = bArr[i3 - 1];
        int i17 = i16 - i3;
        if (i17 == 0) {
            return incompleteStateFor(b16);
        }
        if (i17 == 1) {
            return incompleteStateFor(b16, bArr[i3]);
        }
        if (i17 == 2) {
            return incompleteStateFor(b16, bArr[i3], bArr[i3 + 1]);
        }
        throw new AssertionError();
    }

    public static int partialIsValidUtf8(byte[] bArr, int i3, int i16) {
        while (i3 < i16 && bArr[i3] >= 0) {
            i3++;
        }
        if (i3 >= i16) {
            return 0;
        }
        return partialIsValidUtf8NonAscii(bArr, i3, i16);
    }
}
