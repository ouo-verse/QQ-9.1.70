package com.tencent.securitysdk.utils;

import MAAccessClient.AcCode;
import android.content.Context;
import android.content.pm.Signature;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0083 A[LOOP:1: B:25:0x0081->B:26:0x0083, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int i3;
        int i16;
        byte[] bArr2;
        File file = new File(SoLoadCore.getAppWorkPath(context) + "/config/cs.dat");
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        r0 = null;
        AcCode acCode = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(128);
                try {
                    byte[] bArr3 = new byte[128];
                    for (int read = fileInputStream.read(bArr3); read > 0; read = fileInputStream.read(bArr3)) {
                        byteArrayOutputStream.write(bArr3, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    bArr = null;
                    String packageName = context.getPackageName();
                    int length = packageName.length();
                    i16 = 16 % length;
                    String str = "";
                    while (i3 > 0) {
                    }
                    if (i16 > 0) {
                    }
                    try {
                        bArr2 = new Cryptor().decrypt(bArr, str.getBytes());
                    } catch (Exception unused5) {
                        bArr2 = null;
                    }
                    if (bArr2 != null) {
                    }
                    int a16 = com.tencent.mobileqq.cooperation.a.a(BaseApplication.getContext());
                    return acCode != null ? false : false;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused6) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (Exception unused7) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused8) {
                byteArrayOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception unused9) {
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
        }
        try {
            fileInputStream.close();
        } catch (Exception unused10) {
            String packageName2 = context.getPackageName();
            int length2 = packageName2.length();
            i16 = 16 % length2;
            String str2 = "";
            for (i3 = 16 / length2; i3 > 0; i3--) {
                str2 = str2 + packageName2;
            }
            if (i16 > 0) {
                str2 = str2 + packageName2.substring(0, i16);
            }
            bArr2 = new Cryptor().decrypt(bArr, str2.getBytes());
            if (bArr2 != null) {
                try {
                    JceInputStream jceInputStream = new JceInputStream(bArr2);
                    AcCode acCode2 = new AcCode();
                    acCode2.readFrom(jceInputStream);
                    acCode = acCode2;
                } catch (Exception unused11) {
                }
            }
            int a162 = com.tencent.mobileqq.cooperation.a.a(BaseApplication.getContext());
            if (acCode != null || !String.valueOf(AppSetting.f()).equals(acCode.appid) || a162 != acCode.versionCode) {
                return false;
            }
            return true;
        }
    }

    public static boolean b(Context context, String str, int i3, String str2) {
        String str3;
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64).signatures;
            if (signatureArr.length >= 1) {
                str3 = c.b(signatureArr[signatureArr.length - 1].toCharsString());
            } else {
                str3 = "";
            }
            if (TextUtils.isEmpty(str3) || !str3.equals(str2)) {
                return false;
            }
            if (b.a(context, str) >= i3) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(Context context) {
        byte[] bArr;
        String z16 = ah.z();
        String str = "";
        if (z16 == null) {
            z16 = "";
        }
        byte[] byteArray = new AcCode(z16, String.valueOf(AppSetting.f()), String.valueOf(SystemClock.uptimeMillis()), com.tencent.mobileqq.cooperation.a.a(BaseApplication.getContext())).toByteArray();
        String packageName = context.getPackageName();
        int length = packageName.length();
        int i3 = 16 % length;
        for (int i16 = 16 / length; i16 > 0; i16--) {
            str = str + packageName;
        }
        if (i3 > 0) {
            str = str + packageName.substring(0, i3);
        }
        FileOutputStream fileOutputStream = null;
        try {
            bArr = new Cryptor().encrypt(byteArray, str.getBytes());
        } catch (Exception unused) {
            bArr = null;
        }
        if (bArr == null) {
            return false;
        }
        File file = new File(SoLoadCore.getAppWorkPath(context) + "/config/cs.dat");
        File parentFile = file.getParentFile();
        if (!parentFile.exists() || !parentFile.isDirectory()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                try {
                    fileOutputStream2.close();
                } catch (Exception unused2) {
                }
                return true;
            } catch (Exception unused3) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream == null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (Exception unused4) {
                    return false;
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
