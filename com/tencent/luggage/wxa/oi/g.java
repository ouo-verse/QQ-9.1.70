package com.tencent.luggage.wxa.oi;

import android.util.Base64;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {
    public static boolean a() {
        return false;
    }

    public static String b(com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (w0.c(str)) {
            w.b("MicroMsg.Audio.WxaAudioUtils", "src is empty");
            return "";
        }
        if (str.startsWith("wxfile://")) {
            if (dVar.getFileSystem() == null) {
                w.b("MicroMsg.Audio.WxaAudioUtils", "getFileSystem() is null");
                return "";
            }
            v absoluteFile = dVar.getFileSystem().getAbsoluteFile(str);
            if (absoluteFile != null && absoluteFile.e()) {
                String g16 = absoluteFile.g();
                if (g16 != null && !g16.startsWith("file://")) {
                    g16 = "file://" + g16;
                }
                w.d("MicroMsg.Audio.WxaAudioUtils", "getRealSrc:src:%s", g16);
                return g16;
            }
            w.b("MicroMsg.Audio.WxaAudioUtils", "localFile is null");
            return "";
        }
        if (str.length() <= 250) {
            w.d("MicroMsg.Audio.WxaAudioUtils", "getRealSrc:src:%s", str);
        }
        return str;
    }

    public static String a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (w0.c(str)) {
            w.b("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
            return str;
        }
        if (dVar.getFileSystem() == null) {
            w.b("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
            return str;
        }
        v absoluteFile = dVar.getFileSystem().getAbsoluteFile(str);
        if (absoluteFile != null && absoluteFile.e()) {
            String g16 = absoluteFile.g();
            w.d("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", g16);
            return g16;
        }
        w.b("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
        return str;
    }

    public static String a(String str) {
        byte[] bArr;
        v vVar = new v(com.tencent.luggage.wxa.m9.a.a(), "base64" + str.hashCode());
        if (vVar.e()) {
            w.d("MicroMsg.Audio.WxaAudioUtils", "base64 file exist!");
            return vVar.g();
        }
        OutputStream outputStream = null;
        try {
            bArr = Base64.decode(str, 0);
        } catch (Exception e16) {
            w.a("", e16, "writeToFile", new Object[0]);
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            try {
                outputStream = x.b(vVar);
                outputStream.write(bArr);
                try {
                    outputStream.close();
                } catch (IOException unused) {
                }
                return vVar.g();
            } catch (Exception unused2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Throwable th5) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th5;
            }
        }
        return "";
    }
}
