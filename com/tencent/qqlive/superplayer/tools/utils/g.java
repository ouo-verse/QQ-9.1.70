package com.tencent.qqlive.superplayer.tools.utils;

import android.text.TextUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.GZIPInputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace(";(", "  ").replace(")", "");
    }

    public static int b(String str, String str2) {
        int c16 = c(str);
        int c17 = c(str2);
        if (c16 > c17) {
            return 1;
        }
        if (c16 == c17) {
            return 0;
        }
        return -1;
    }

    public static int c(String str) {
        if (str == null) {
            return -1;
        }
        if (str.equals("msd")) {
            return 0;
        }
        if (str.equals("sd")) {
            return 1;
        }
        if (str.equals("hd")) {
            return 2;
        }
        if (str.equals("shd")) {
            return 3;
        }
        if (str.equals("fhd")) {
            return 4;
        }
        if (str.equals("uhd")) {
            return 5;
        }
        return 6;
    }

    public static String d(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb5 = new StringBuilder(40);
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if ((i3 >> 4) == 0) {
                    sb5.append("0");
                    sb5.append(Integer.toHexString(i3));
                } else {
                    sb5.append(Integer.toHexString(i3));
                }
            }
            return sb5.toString();
        } catch (Exception e16) {
            d.a("TVKUtils[TVKUtils.java]", e16.toString());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static byte[] e(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2;
        if (bArr != 0) {
            ?? length = bArr.length;
            try {
                if (length != 0) {
                    try {
                        length = new ByteArrayInputStream(bArr);
                        try {
                            bArr = new ByteArrayOutputStream();
                        } catch (EOFException unused) {
                            bArr = 0;
                            gZIPInputStream2 = null;
                        } catch (IOException unused2) {
                            bArr = 0;
                            gZIPInputStream2 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            bArr = 0;
                            gZIPInputStream = null;
                        }
                        try {
                            gZIPInputStream2 = new GZIPInputStream(length);
                        } catch (EOFException unused3) {
                            gZIPInputStream2 = null;
                        } catch (IOException unused4) {
                            gZIPInputStream2 = null;
                        } catch (Throwable th6) {
                            th = th6;
                            gZIPInputStream = null;
                            if (length != 0) {
                                try {
                                    length.close();
                                } catch (IOException unused5) {
                                    return null;
                                }
                            }
                            if (bArr != 0) {
                                bArr.close();
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            throw th;
                        }
                    } catch (EOFException unused6) {
                        bArr = 0;
                        length = 0;
                        gZIPInputStream2 = null;
                    } catch (IOException unused7) {
                        bArr = 0;
                        length = 0;
                        gZIPInputStream2 = null;
                    } catch (Throwable th7) {
                        th = th7;
                        bArr = 0;
                        length = 0;
                        gZIPInputStream = null;
                    }
                    try {
                        byte[] bArr2 = new byte[8192];
                        while (true) {
                            int read = gZIPInputStream2.read(bArr2, 0, 8192);
                            if (read != -1) {
                                bArr.write(bArr2, 0, read);
                            } else {
                                byte[] byteArray = bArr.toByteArray();
                                try {
                                    length.close();
                                    bArr.close();
                                    gZIPInputStream2.close();
                                    return byteArray;
                                } catch (IOException unused8) {
                                    return null;
                                }
                            }
                        }
                    } catch (EOFException unused9) {
                        byte[] byteArray2 = bArr.toByteArray();
                        if (length != 0) {
                            try {
                                length.close();
                            } catch (IOException unused10) {
                                return null;
                            }
                        }
                        bArr.close();
                        if (gZIPInputStream2 != null) {
                            gZIPInputStream2.close();
                        }
                        return byteArray2;
                    } catch (IOException unused11) {
                        if (length != 0) {
                            try {
                                length.close();
                            } catch (IOException unused12) {
                                return null;
                            }
                        }
                        if (bArr != 0) {
                            bArr.close();
                        }
                        if (gZIPInputStream2 != null) {
                            gZIPInputStream2.close();
                        }
                        return null;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }
        return null;
    }

    public static void f(Object obj, String str, Class<?> cls, Object obj2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String str2 = "set" + Character.toUpperCase(str.charAt(0));
            if (str.length() > 1) {
                str2 = str2 + str.substring(1);
            }
            obj.getClass().getDeclaredMethod(str2, cls).invoke(obj, obj2);
        } catch (Exception unused) {
        }
    }

    public static double g(String str, double d16) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e16) {
                d.b("TVKUtils[TVKUtils.java]", e16);
            }
        }
        return d16;
    }

    public static float h(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e16) {
                d.b("TVKUtils[TVKUtils.java]", e16);
            }
        }
        return i3;
    }

    public static int i(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e16) {
                d.b("TVKUtils[TVKUtils.java]", e16);
            }
        }
        return i3;
    }

    public static long j(String str, long j3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e16) {
                d.b("TVKUtils[TVKUtils.java]", e16);
            }
        }
        return j3;
    }
}
