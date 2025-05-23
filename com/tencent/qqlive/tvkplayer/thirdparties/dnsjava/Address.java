package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class Address {
    public static final int IPv4 = 1;
    public static final int IPv6 = 2;

    Address() {
    }

    public static int addressLength(int i3) {
        if (i3 == 1) {
            return 4;
        }
        if (i3 == 2) {
            return 16;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static int familyOf(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return 1;
        }
        if (inetAddress instanceof Inet6Address) {
            return 2;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static InetAddress getByAddress(String str) throws UnknownHostException {
        byte[] byteArray = toByteArray(str, 1);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        byte[] byteArray2 = toByteArray(str, 2);
        if (byteArray2 != null) {
            return InetAddress.getByAddress(str, byteArray2);
        }
        throw new UnknownHostException("Invalid address: " + str);
    }

    public static boolean isDottedQuad(String str) {
        if (toByteArray(str, 1) != null) {
            return true;
        }
        return false;
    }

    private static byte[] parseV4(String str) {
        byte[] bArr = new byte[4];
        int length = str.length();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < length; i18++) {
            char charAt = str.charAt(i18);
            if (charAt >= '0' && charAt <= '9') {
                if (i16 == 3) {
                    return null;
                }
                if (i16 > 0 && i17 == 0) {
                    return null;
                }
                i16++;
                i17 = (i17 * 10) + (charAt - '0');
                if (i17 > 255) {
                    return null;
                }
            } else {
                if (charAt != '.' || i3 == 3 || i16 == 0) {
                    return null;
                }
                bArr[i3] = (byte) i17;
                i17 = 0;
                i3++;
                i16 = 0;
            }
        }
        if (i3 != 3 || i16 == 0) {
            return null;
        }
        bArr[i3] = (byte) i17;
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bc, code lost:
    
        if (r8 >= 16) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00be, code lost:
    
        if (r3 >= 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c0, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c1, code lost:
    
        if (r3 < 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c3, code lost:
    
        r12 = (16 - r8) + r3;
        java.lang.System.arraycopy(r1, r3, r1, r12, r8 - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ca, code lost:
    
        if (r3 >= r12) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00cc, code lost:
    
        r1[r3] = 0;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d1, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] parseV6(String str) {
        int i3;
        byte[] byteArray;
        byte[] bArr = new byte[16];
        int i16 = -1;
        String[] split = str.split(":", -1);
        int length = split.length - 1;
        if (split[0].length() == 0) {
            if (length + 0 <= 0 || split[1].length() != 0) {
                return null;
            }
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (split[length].length() == 0) {
            if (length - i3 <= 0 || split[length - 1].length() != 0) {
                return null;
            }
            length--;
        }
        if ((length - i3) + 1 > 8) {
            return null;
        }
        int i17 = 0;
        while (true) {
            if (i3 > length) {
                break;
            }
            if (split[i3].length() == 0) {
                if (i16 >= 0) {
                    return null;
                }
                i16 = i17;
            } else if (split[i3].indexOf(46) >= 0) {
                if (i3 < length || i3 > 6 || (byteArray = toByteArray(split[i3], 1)) == null) {
                    return null;
                }
                int i18 = 0;
                while (i18 < 4) {
                    bArr[i17] = byteArray[i18];
                    i18++;
                    i17++;
                }
            } else {
                for (int i19 = 0; i19 < split[i3].length(); i19++) {
                    try {
                        if (Character.digit(split[i3].charAt(i19), 16) < 0) {
                            return null;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                int parseInt = Integer.parseInt(split[i3], 16);
                if (parseInt > 65535 || parseInt < 0) {
                    break;
                }
                int i26 = i17 + 1;
                bArr[i17] = (byte) (parseInt >>> 8);
                i17 = i26 + 1;
                bArr[i26] = (byte) (parseInt & 255);
            }
            i3++;
        }
        return null;
    }

    public static int[] toArray(String str, int i3) {
        byte[] byteArray = toByteArray(str, i3);
        if (byteArray == null) {
            return null;
        }
        int[] iArr = new int[byteArray.length];
        for (int i16 = 0; i16 < byteArray.length; i16++) {
            iArr[i16] = byteArray[i16] & 255;
        }
        return iArr;
    }

    public static byte[] toByteArray(String str, int i3) {
        if (i3 == 1) {
            return parseV4(str);
        }
        if (i3 == 2) {
            return parseV6(str);
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static String toDottedQuad(byte[] bArr) {
        return (bArr[0] & 255) + "." + (bArr[1] & 255) + "." + (bArr[2] & 255) + "." + (bArr[3] & 255);
    }

    public static InetAddress truncate(InetAddress inetAddress, int i3) {
        int i16;
        int addressLength = addressLength(familyOf(inetAddress)) * 8;
        if (i3 >= 0 && i3 <= addressLength) {
            if (i3 == addressLength) {
                return inetAddress;
            }
            byte[] address = inetAddress.getAddress();
            int i17 = i3 / 8;
            int i18 = i17 + 1;
            while (true) {
                if (i18 >= address.length) {
                    break;
                }
                address[i18] = 0;
                i18++;
            }
            int i19 = 0;
            for (i16 = 0; i16 < i3 % 8; i16++) {
                i19 |= 1 << (7 - i16);
            }
            address[i17] = (byte) (address[i17] & i19);
            try {
                return InetAddress.getByAddress(address);
            } catch (UnknownHostException unused) {
                throw new IllegalArgumentException("invalid address");
            }
        }
        throw new IllegalArgumentException("invalid mask length");
    }

    public static int[] toArray(String str) {
        return toArray(str, 1);
    }

    public static InetAddress getByAddress(String str, int i3) throws UnknownHostException {
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("unknown address family");
        }
        byte[] byteArray = toByteArray(str, i3);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        throw new UnknownHostException("Invalid address: " + str);
    }
}
