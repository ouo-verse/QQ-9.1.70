package com.tencent.luggage.wxa.ig;

import com.tencent.luggage.wxa.rc.p;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.BufferedReader;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a0 {
    public static int a(String... strArr) {
        int i3 = 0;
        for (String str : strArr) {
            if (str != null) {
                i3 += str.length();
            }
        }
        return i3;
    }

    public static String b(String str) {
        return a(new com.tencent.luggage.wxa.cp.v(com.tencent.luggage.wxa.tn.z.c().getCacheDir(), str));
    }

    public static String a(com.tencent.luggage.wxa.cp.v vVar) {
        BufferedReader bufferedReader;
        if (!vVar.e()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                bufferedReader = new BufferedReader(new com.tencent.luggage.wxa.cp.y(vVar));
                try {
                    char[] cArr = new char[1024];
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read != -1) {
                            stringBuffer.append(String.valueOf(cArr, 0, read));
                        } else {
                            bufferedReader.close();
                            return stringBuffer.toString();
                        }
                    }
                } catch (IOException e16) {
                    throw e16;
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (IOException e17) {
                throw e17;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
    }

    public static String b(p.a aVar) {
        return aVar == p.a.NONE ? FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS : aVar == p.a.QUOTA_REACHED ? "fail:quota reached" : "fail:internal error set DB data fail";
    }

    public static void a(String str, String... strArr) {
        Throwable th5;
        com.tencent.luggage.wxa.cp.z zVar;
        try {
            zVar = new com.tencent.luggage.wxa.cp.z(new com.tencent.luggage.wxa.cp.v(com.tencent.luggage.wxa.tn.z.c().getCacheDir(), str));
        } catch (Throwable th6) {
            th5 = th6;
            zVar = null;
        }
        try {
            for (String str2 : strArr) {
                zVar.write(str2);
            }
            try {
                zVar.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (zVar != null) {
                try {
                    zVar.close();
                } catch (IOException unused2) {
                }
            }
            throw th5;
        }
    }

    public static void a(String str) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiStorageHelper", "deleteTmpFile: " + str + ":" + new com.tencent.luggage.wxa.cp.v(com.tencent.luggage.wxa.tn.z.c().getCacheDir(), str).d());
    }

    public static com.tencent.luggage.wxa.af.c a(p.a aVar) {
        if (aVar == p.a.NONE) {
            return com.tencent.luggage.wxa.af.e.f121305a;
        }
        if (aVar == p.a.QUOTA_REACHED) {
            return com.tencent.luggage.wxa.af.k.f121389e;
        }
        return com.tencent.luggage.wxa.af.k.f121387c;
    }
}
