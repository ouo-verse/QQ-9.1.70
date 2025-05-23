package com.tencent.component.media.animwebp;

import android.text.TextUtils;
import com.tencent.component.media.ImageManagerEnv;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes5.dex */
public class AnimWebPHelper {
    private static boolean loadSoSucc = false;

    /* JADX WARN: Removed duplicated region for block: B:37:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] bytesFromFile(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (str == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
        } catch (IOException e16) {
            e = e16;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                if (fileInputStream.read(bArr) <= 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    return null;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                return bArr;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e26) {
            e = e26;
            e.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
            }
            return null;
        }
    }

    public static boolean isAnimWebP(String str) {
        return AnimWebPNative.isAnimWebP(bytesFromFile(str));
    }

    public static boolean isAnimWebpUrl(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("bizpf=webp")) {
            return true;
        }
        return false;
    }

    public static boolean isReady() {
        if (!loadSoSucc) {
            loadWebpSo();
        }
        return loadSoSucc;
    }

    public static void loadWebpSo() {
        loadSoSucc = ImageManagerEnv.g().loadLibrary(QzoneModuleConst.QZONE_DECODE_ANIMATED_WEBP_KEY);
    }

    public static boolean isAnimWebP(byte[] bArr) {
        return AnimWebPNative.isAnimWebP(bArr);
    }
}
