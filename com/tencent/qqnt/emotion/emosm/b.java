package com.tencent.qqnt.emotion.emosm;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.utils.m;
import java.io.File;
import java.io.IOException;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b extends com.tencent.qqnt.emotion.utils.a {
    public static String f(byte[] bArr, int i3) {
        if (bArr == null) {
            return null;
        }
        if (i3 == 2) {
            return new String(bArr);
        }
        return m.a(bArr).toLowerCase();
    }

    public static void g(Emoticon emoticon, String str) {
        int i3;
        if (emoticon == null) {
            QLog.e("EmosmUtils", 1, "checkDecryptAndThenEncryptEmoji error, emotion is null!");
            return;
        }
        if (!TextUtils.isEmpty(str) && FileUtils.fileExists(str)) {
            if (emoticon.jobType != 1) {
                try {
                    File file = new File(str);
                    byte[] fileToBytes = FileUtils.fileToBytes(file);
                    file.delete();
                    if (fileToBytes == null) {
                        QLog.e("EmosmUtils", 1, "task gif 2 fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId);
                        return;
                    }
                    int i16 = emoticon.jobType;
                    if (i16 != 3) {
                        i3 = s(fileToBytes, emoticon.encryptKey, str);
                    } else if (i16 == 3) {
                        i3 = r(fileToBytes, str);
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        QLog.e("EmosmUtils", 1, "task gif save fail :epid = " + emoticon.epId + ";eid = " + emoticon.eId + ";emosmCode = " + i3);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("EmosmUtils", 2, "onProgress| Emotiocon encode resource done.result=" + i3 + " time:" + System.currentTimeMillis());
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("EmosmUtils", 2, "onProgress Emotiocon encode resource fail .EXCEPTION:" + th5.toString() + " time:" + System.currentTimeMillis());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        QLog.e("EmosmUtils", 1, "checkDecryptAndThenEncryptEmoji error, emotion is not exists!");
    }

    public static int h(byte[] bArr, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 = (i16 << 8) | (bArr[i17] & 255);
        }
        return i16;
    }

    public static void i(byte[] bArr, int i3, int i16, long j3) {
        SecurityUtile.xorInLimit(bArr, i3, i16, j3, 200);
    }

    public static byte[] j(byte[] bArr, byte[] bArr2) {
        return new Cryptor().decrypt(bArr, bArr2);
    }

    public static byte[] k(String str, int i3) {
        if (i3 != 0 && i3 != 2 && i3 != 4) {
            if (i3 == 1) {
                return str.getBytes();
            }
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i16 = 0; i16 < length; i16++) {
            int i17 = i16 * 2;
            bArr[i16] = Integer.valueOf(str.substring(i17, i17 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static byte[] l(byte[] bArr) {
        return SecurityUtile.xorInLimit(bArr, 200);
    }

    public static int[] m(char[] cArr) {
        return new int[]{h(new byte[]{(byte) cArr[0], (byte) cArr[1]}, 2), cArr[2]};
    }

    public static IEmoticonManagerService n() {
        try {
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (appInterface != null) {
                return (IEmoticonManagerService) appInterface.getRuntimeService(IEmoticonManagerService.class, "");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return null;
    }

    public static char[] o(int i3, int i16, int i17) {
        char[] b16 = com.tencent.qqnt.emotion.utils.a.b(i3, i16);
        char[] cArr = {20, b16[3], b16[2], b16[1], b16[0]};
        if (i17 == 2) {
            cArr[1] = '\u01ff';
        }
        return cArr;
    }

    public static String p(String str, String str2) {
        return MsfSdkUtils.insertMtype(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
    
        com.tencent.qphone.base.util.QLog.e("EmosmUtils", 2, "isGifFile file close Exception:", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean q(String str) throws IOException {
        a aVar = null;
        boolean z16 = false;
        try {
            try {
                a aVar2 = new a(str, "r");
                try {
                    byte[] bArr = new byte[10];
                    aVar2.read(bArr);
                    if (bArr[0] == 71 && bArr[1] == 73) {
                        if (bArr[2] == 70) {
                            z16 = true;
                        }
                    }
                    try {
                        aVar2.close();
                    } catch (IOException e16) {
                        e = e16;
                        e.printStackTrace();
                    }
                } catch (IOException e17) {
                    e = e17;
                    aVar = aVar2;
                    e.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.e("EmosmUtils", 2, "isGifFile file read Exception:", e);
                    }
                    if (aVar != null) {
                        try {
                            aVar.close();
                        } catch (IOException e18) {
                            e = e18;
                            e.printStackTrace();
                        }
                    }
                    return z16;
                } catch (Throwable th5) {
                    th = th5;
                    aVar = aVar2;
                    if (aVar != null) {
                        try {
                            aVar.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.e("EmosmUtils", 2, "isGifFile file close Exception:", e19);
                            }
                        }
                    }
                    throw th;
                }
            } catch (IOException e26) {
                e = e26;
            }
            return z16;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static int r(byte[] bArr, String str) {
        if (bArr == null) {
            return 11017;
        }
        byte[] l3 = l(bArr);
        if (l3 == null) {
            return 11018;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "done. encryptFi,desData.len=" + l3.length + " file=" + str + " time=" + System.currentTimeMillis());
        }
        boolean pushData2File = FileUtils.pushData2File(str, l3, false);
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "done. write to file " + pushData2File + ",data.len=" + l3.length + " file=" + str + " time=" + System.currentTimeMillis());
        }
        if (pushData2File) {
            return 0;
        }
        return 11019;
    }

    public static int s(byte[] bArr, String str, String str2) {
        if (bArr == null) {
            return 11017;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "doing decryptTEA,srcData.len=" + bArr.length + " emoKey=" + str + " file=" + str2 + " time=" + System.currentTimeMillis());
        }
        byte[] j3 = j(bArr, str.getBytes());
        if (j3 == null) {
            return 11017;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "done. decryptTEA,clearData.len=" + j3.length + " emoKey=" + str + " file=" + str2 + " time=" + System.currentTimeMillis());
        }
        byte[] l3 = l(j3);
        if (l3 == null) {
            return 11018;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "done. encryptFi,desData.len=" + l3.length + " emoKey=" + str + " file=" + str2 + " time=" + System.currentTimeMillis());
        }
        boolean pushData2File = FileUtils.pushData2File(str2, l3, false);
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "done. write to file " + pushData2File + ",data.len=" + l3.length + " file=" + str2 + " time=" + System.currentTimeMillis());
        }
        if (pushData2File) {
            return 0;
        }
        return 11019;
    }
}
