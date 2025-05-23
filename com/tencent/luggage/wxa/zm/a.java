package com.tencent.luggage.wxa.zm;

import com.tencent.luggage.wxa.ba.b;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f146755a = b("ftyp");

    public static void a(String str, int[] iArr, int i3, int i16) {
        b bVar;
        try {
            bVar = new b();
        } catch (Throwable th5) {
            th = th5;
            bVar = null;
        }
        try {
            bVar.setDataSource(str);
            int a16 = w0.a(bVar.extractMetadata(18), 0);
            int a17 = w0.a(bVar.extractMetadata(19), 0);
            iArr[0] = a16;
            iArr[1] = a17;
            for (int i17 = 0; i17 < 3; i17++) {
                if (a16 % 2 == 0 && a17 % 2 == 0) {
                    if ((a16 >= a17 && (a16 <= i3 || a17 <= i16)) || (a16 <= a17 && (a16 <= i16 || a17 <= i3))) {
                        break;
                    }
                    a16 /= 2;
                    a17 /= 2;
                }
                try {
                    bVar.release();
                } catch (IOException unused) {
                }
                int i18 = iArr[0];
                if (i18 % 2 != 0) {
                    iArr[0] = i18 + 1;
                }
                int i19 = iArr[1];
                if (i19 % 2 != 0) {
                    iArr[1] = i19 + 1;
                    return;
                }
                return;
            }
            iArr[0] = a16;
            iArr[1] = a17;
            try {
                bVar.release();
            } catch (IOException unused2) {
            }
            int i26 = iArr[0];
            if (i26 % 2 != 0) {
                iArr[0] = i26 + 1;
            }
            int i27 = iArr[1];
            if (i27 % 2 != 0) {
                iArr[1] = i27 + 1;
            }
        } catch (Throwable th6) {
            th = th6;
            if (bVar != null) {
                try {
                    bVar.release();
                } catch (IOException unused3) {
                }
            }
            int i28 = iArr[0];
            if (i28 % 2 != 0) {
                iArr[0] = i28 + 1;
            }
            int i29 = iArr[1];
            if (i29 % 2 != 0) {
                iArr[1] = i29 + 1;
                throw th;
            }
            throw th;
        }
    }

    public static String b() {
        if (z.c() != null && z.c().getCacheDir() != null) {
            String str = a() + "/mux";
            v vVar = new v(str);
            if (!vVar.e()) {
                vVar.v();
                w.d("WMPF.ImportVideo", "path is not exists, mkdir path: %s", str);
            }
            w.a("WMPF.ImportVideo", "WechatSight ffmpegMuxerPath path is %s", str);
            return str;
        }
        w.b("WMPF.ImportVideo", "path is empty, MMApplicationContext.getContext() == null");
        return "";
    }

    public static int b(String str) {
        int length = str.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            i3 = (i3 << 8) | str.charAt(i16);
        }
        return i3;
    }

    public static boolean a(String str) {
        if (w0.c(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            try {
                inputStream = x.n(str);
                byte[] bArr = new byte[8];
                if (inputStream.read(bArr, 0, 8) < 8) {
                    try {
                        inputStream.close();
                    } catch (IOException e16) {
                        w.a("WMPF.ImportVideo", e16, "", new Object[0]);
                    }
                    return false;
                }
                int a16 = a(bArr, 0);
                if (a(bArr, 4) == f146755a && a16 > 0) {
                    try {
                        inputStream.close();
                        return true;
                    } catch (IOException e17) {
                        w.a("WMPF.ImportVideo", e17, "", new Object[0]);
                        return true;
                    }
                }
                try {
                    inputStream.close();
                } catch (IOException e18) {
                    w.a("WMPF.ImportVideo", e18, "", new Object[0]);
                }
                return false;
            } catch (Throwable th5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e19) {
                        w.a("WMPF.ImportVideo", e19, "", new Object[0]);
                    }
                }
                throw th5;
            }
        } catch (Exception e26) {
            w.a("WMPF.ImportVideo", e26, "", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e27) {
                    w.a("WMPF.ImportVideo", e27, "", new Object[0]);
                }
            }
            return false;
        }
    }

    public static int a(byte[] bArr, int i3) {
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i3] & 255) << 24) | ((bArr[i16] & 255) << 16);
        int i19 = i17 + 1;
        return (bArr[i19] & 255) | i18 | ((bArr[i17] & 255) << 8);
    }

    public static synchronized String a() {
        String str;
        synchronized (a.class) {
            str = com.tencent.luggage.wxa.db.a.e() + "video/";
        }
        return str;
    }
}
