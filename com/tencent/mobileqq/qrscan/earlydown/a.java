package com.tencent.mobileqq.qrscan.earlydown;

import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    public static byte a(int i3, String str) {
        String str2;
        String str3;
        String str4;
        l(i3, true);
        byte b16 = 2;
        try {
            m(str, b(i3));
            HashMap hashMap = new HashMap();
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            if (i3 == 0) {
                str2 = b(i3) + File.separator + "minicode/config.xml";
            } else if (i3 == 2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(b(i3));
                String str5 = File.separator;
                sb5.append(str5);
                sb5.append("qq.android.minidetect.model_v8.9.85");
                sb5.append(str5);
                sb5.append("/config.xml");
                str2 = sb5.toString();
            } else {
                str2 = b(i3) + "/config.xml";
            }
            File file = new File(str2);
            if (file.exists()) {
                try {
                    str3 = FileUtils.readFileToString(file);
                } catch (IOException e16) {
                    e16.printStackTrace();
                    str3 = null;
                }
                k(i3);
                if (str3 != null && j(i3, str3, hashMap)) {
                    synchronized (g(i3)) {
                        Iterator it = hashMap.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                String e17 = e(i3, (String) entry.getKey());
                                if (i3 == 0) {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(b(i3));
                                    String str6 = File.separator;
                                    sb6.append(str6);
                                    sb6.append("minicode");
                                    sb6.append(str6);
                                    sb6.append(e17);
                                    str4 = sb6.toString();
                                } else if (i3 == 2) {
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append(b(i3));
                                    String str7 = File.separator;
                                    sb7.append(str7);
                                    sb7.append("qq.android.minidetect.model_v8.9.85");
                                    sb7.append(str7);
                                    sb7.append(e17);
                                    str4 = sb7.toString();
                                } else {
                                    str4 = b(i3) + File.separator + e17;
                                }
                                File file2 = new File(str4);
                                if (file2.exists()) {
                                    String b17 = com.tencent.mobileqq.qrscan.utils.e.b(str4);
                                    if (!((String) entry.getValue()).equalsIgnoreCase(b17)) {
                                        file2.delete();
                                        if (QLog.isColorLevel()) {
                                            QLog.d("MiniRecog.BaseQRScanResLoader", 2, String.format("doOnDownloadSuccess md5 failed file=[%s] file.md5=[%s] cfg.md5=[%s]", e17, b17, entry.getValue()));
                                        }
                                    } else {
                                        from.encodeBool("qrscan_native_res_" + e17 + "_migrate_flag", true);
                                        StringBuilder sb8 = new StringBuilder();
                                        sb8.append("qrscan_native_res_");
                                        sb8.append(e17);
                                        from.encodeString(sb8.toString(), (String) entry.getValue());
                                        from.commitSync();
                                        if (QLog.isColorLevel()) {
                                            QLog.d("MiniRecog.BaseQRScanResLoader", 2, "doOnDownloadSuccess save sp key =  qrscan_native_res_" + e17 + ",value = " + ((String) entry.getValue()));
                                        }
                                    }
                                } else {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("MiniRecog.BaseQRScanResLoader", 2, "doOnDownloadSuccess file not exists = " + str4);
                                    }
                                    b16 = 3;
                                }
                            } else {
                                b16 = 0;
                                break;
                            }
                        }
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("MiniRecog.BaseQRScanResLoader", 2, "config data is not correct");
                    }
                    b16 = 4;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MiniRecog.BaseQRScanResLoader", 2, "config file is not exist");
                }
                b16 = 0;
            }
            l(i3, false);
            return b16;
        } catch (IOException e18) {
            l(i3, false);
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.BaseQRScanResLoader", 2, "uncompressZip false: " + e18.getMessage());
            }
            FileUtils.delete(b(i3), false);
            return (byte) -1;
        }
    }

    protected static String b(int i3) {
        if (i3 == 0) {
            return c.o();
        }
        if (i3 == 1) {
            return g.o();
        }
        if (i3 == 2) {
            return d.o();
        }
        if (i3 == 3) {
            return i.o();
        }
        return "";
    }

    public static String c(int i3, String str) {
        String decodeString;
        String d16 = d(i3, str);
        String str2 = "qrscan_native_res_" + d16;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (!from.decodeBool(str2 + "_migrate_flag", false)) {
            decodeString = MobileQQ.sMobileQQ.getSharedPreferences("mobileQQ", 4).getString(str2, null);
            from.encodeString(str2, decodeString);
            from.encodeBool(str2 + "_migrate_flag", true);
        } else {
            decodeString = from.decodeString(str2, null);
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.BaseQRScanResLoader", 2, "getFileMd5BySP ,resName = " + d16 + ",md5 = " + decodeString);
        }
        return decodeString;
    }

    public static String d(int i3, String str) {
        if (i3 == 0) {
            return c.p(str);
        }
        if (i3 == 1) {
            return g.p(str);
        }
        if (i3 == 2) {
            return d.p(str);
        }
        if (i3 == 3) {
            return i.p(str);
        }
        return "";
    }

    public static String e(int i3, String str) {
        if (i3 == 0) {
            return c.q(str);
        }
        if (i3 == 1) {
            return g.q(str);
        }
        if (i3 == 2) {
            return d.q(str);
        }
        if (i3 == 3) {
            return i.q(str);
        }
        return "";
    }

    private static String f(int i3, String str) {
        if (i3 == 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(b(i3));
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("minicode");
            sb5.append(str2);
            sb5.append(d(i3, str));
            return sb5.toString();
        }
        if (i3 == 2) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(b(i3));
            String str3 = File.separator;
            sb6.append(str3);
            sb6.append("qq.android.minidetect.model_v8.9.85");
            sb6.append(str3);
            sb6.append(d(i3, str));
            return sb6.toString();
        }
        return b(i3) + File.separator + d(i3, str);
    }

    public static Object g(int i3) {
        if (i3 == 0) {
            return c.r();
        }
        if (i3 == 1) {
            return g.r();
        }
        if (i3 == 2) {
            return d.r();
        }
        if (i3 == 3) {
            return i.r();
        }
        return null;
    }

    public static boolean h(int i3, boolean z16, String str) {
        String str2;
        Object g16;
        if (i3 == 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(b(i3));
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append("minicode");
            sb5.append(str3);
            sb5.append(d(i3, str));
            str2 = sb5.toString();
        } else if (i3 == 2) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(b(i3));
            String str4 = File.separator;
            sb6.append(str4);
            sb6.append("qq.android.minidetect.model_v8.9.85");
            sb6.append(str4);
            sb6.append(d(i3, str));
            str2 = sb6.toString();
        } else {
            str2 = b(i3) + File.separator + d(i3, str);
        }
        File file = new File(str2);
        boolean z17 = false;
        if (!z16 && file.exists() && (g16 = g(i3)) != null) {
            synchronized (g16) {
                String c16 = c(i3, str);
                String b16 = com.tencent.mobileqq.qrscan.utils.e.b(str2);
                if (QLog.isColorLevel()) {
                    QLog.d("MiniRecog.BaseQRScanResLoader", 2, "isSoFileExist: soName= " + str + " ,spmd5 = " + c16 + ",fileMD5 = " + b16);
                }
                if (c16 != null && !c16.equalsIgnoreCase(b16)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MiniRecog.BaseQRScanResLoader", 2, "isSoFileExist: soName= " + str + " check md5 false!");
                    }
                }
                z17 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.BaseQRScanResLoader", 2, "isSoFileExist: soName= " + str + " ,result = " + z17 + ",isUncompressZip = " + z16);
        }
        return z17;
    }

    public static byte i(int i3, boolean z16, String str) {
        if (str == null) {
            return (byte) -1;
        }
        String f16 = f(i3, str);
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.BaseQRScanResLoader", 2, "start loadMiniNativeSo: " + f16);
        }
        File file = new File(f16);
        byte b16 = 0;
        if (!z16 && file.exists()) {
            try {
                SoLoadUtilNew.loadSoByName(BaseApplication.getContext(), "c++_shared");
                System.load(f16);
                if (!QLog.isColorLevel()) {
                    return (byte) 0;
                }
                QLog.i("MiniRecog.BaseQRScanResLoader", 2, "load " + f16 + " success!");
                return (byte) 0;
            } catch (UnsatisfiedLinkError e16) {
                QLog.d("MiniRecog.BaseQRScanResLoader", 1, "load from mini dir failed, libName = " + str + "," + e16.getMessage());
                return (byte) -2;
            }
        }
        if (z16 && !file.exists()) {
            b16 = -3;
        }
        if (z16 && file.exists()) {
            b16 = -4;
        }
        if (!z16 && !file.exists()) {
            b16 = -5;
        }
        QLog.d("MiniRecog.BaseQRScanResLoader", 1, "no mini so in mini dir,libName = " + str);
        return b16;
    }

    public static boolean j(int i3, String str, HashMap<String, String> hashMap) {
        if (i3 == 0) {
            return c.v(str, hashMap);
        }
        if (i3 == 1) {
            return g.v(str, hashMap);
        }
        if (i3 == 2) {
            return d.v(str, hashMap);
        }
        if (i3 == 3) {
            return i.u(str, hashMap);
        }
        return false;
    }

    private static void k(int i3) {
        String str;
        if (i3 == 0) {
            str = f(i3, "minicode");
        } else if (i3 == 1) {
            str = f(i3, "QMCF_qr");
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(BaseApplication.getContext(), str);
        }
    }

    protected static void l(int i3, boolean z16) {
        if (i3 == 0) {
            c.w(z16);
            return;
        }
        if (i3 == 1) {
            g.w(z16);
        } else if (i3 == 2) {
            d.x(z16);
        } else if (i3 == 3) {
            i.v(z16);
        }
    }

    public static void m(String str, String str2) throws IOException {
        QZipFile qZipFile;
        InputStream inputStream;
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.BaseQRScanResLoader", 2, "uncompressZip: path=" + str);
        }
        FileOutputStream fileOutputStream = null;
        try {
            qZipFile = new QZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = qZipFile.entries();
                byte[] bArr = new byte[8192];
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name != null && !name.contains("../")) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str2);
                        String str3 = File.separator;
                        sb5.append(str3);
                        sb5.append(name);
                        String sb6 = sb5.toString();
                        if (nextElement.isDirectory()) {
                            File file = new File(sb6);
                            if (!file.exists()) {
                                file.mkdir();
                            }
                        } else {
                            int lastIndexOf = sb6.lastIndexOf(str3);
                            String substring = sb6.substring(0, lastIndexOf);
                            if (!sb6.substring(lastIndexOf + 1).startsWith(".")) {
                                File file2 = new File(substring);
                                if (!file2.exists()) {
                                    file2.mkdirs();
                                }
                                File file3 = new File(sb6 + ".tmp");
                                File file4 = new File(sb6);
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                                try {
                                    inputStream = qZipFile.getInputStream(nextElement);
                                    while (true) {
                                        try {
                                            int read = inputStream.read(bArr, 0, 8192);
                                            if (read == -1) {
                                                break;
                                            } else {
                                                fileOutputStream2.write(bArr, 0, read);
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            fileOutputStream = fileOutputStream2;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e16) {
                                                    e16.printStackTrace();
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (IOException e17) {
                                                    e17.printStackTrace();
                                                }
                                            }
                                            if (qZipFile != null) {
                                                try {
                                                    qZipFile.close();
                                                    throw th;
                                                } catch (IOException e18) {
                                                    e18.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                    fileOutputStream2.flush();
                                    fileOutputStream2.close();
                                    inputStream.close();
                                    if (!FileUtils.renameFile(file3, file4)) {
                                        FileUtils.copyFile(file3, file4);
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    inputStream = null;
                                }
                            }
                        }
                    }
                }
                try {
                    qZipFile.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            qZipFile = null;
            inputStream = null;
        }
    }
}
