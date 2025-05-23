package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes11.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f198548a = false;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f198549b = new Object();

    public static byte a(String str) {
        String str2;
        f198548a = true;
        File file = new File(b());
        byte b16 = 2;
        if (file.exists()) {
            boolean c16 = com.tencent.mobileqq.filemanager.util.q.c(file);
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanNativeSoLoader", 2, "doOnDownloadSuccess delete oldUncompressedFile:" + c16);
            }
        }
        try {
            m(str, c());
            HashMap hashMap = new HashMap();
            byte b17 = 4;
            SharedPreferences.Editor edit = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).edit();
            File file2 = new File(c() + "/face_native_config.xml");
            if (file2.exists()) {
                try {
                    str2 = FileUtils.readFileToString(file2);
                } catch (IOException e16) {
                    e16.printStackTrace();
                    str2 = null;
                }
                if (str2 != null && l(str2, hashMap)) {
                    synchronized (f198549b) {
                        Iterator it = hashMap.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                String str3 = c() + "/lib" + ((String) entry.getKey()) + ".so";
                                File file3 = new File(str3);
                                if (file3.exists()) {
                                    if (!((String) entry.getValue()).equalsIgnoreCase(com.tencent.mobileqq.portal.o.e(str3))) {
                                        file3.delete();
                                        break;
                                    }
                                    edit.putString("face_native_" + ((String) entry.getKey()), (String) entry.getValue());
                                    if (QLog.isColorLevel()) {
                                        QLog.d("FaceScanNativeSoLoader", 2, "doOnDownloadSuccess save sp key =  face_native_" + ((String) entry.getKey()) + ",value = " + ((String) entry.getValue()));
                                    }
                                } else {
                                    b16 = 3;
                                    break;
                                }
                            } else {
                                b16 = 0;
                                break;
                            }
                        }
                        edit.commit();
                    }
                    b17 = b16;
                } else if (QLog.isColorLevel()) {
                    QLog.d("FaceScanNativeSoLoader", 2, "config data is not correct");
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("FaceScanNativeSoLoader", 2, "config file is not exist");
                }
                b17 = 0;
            }
            f198548a = false;
            return b17;
        } catch (IOException e17) {
            f198548a = false;
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanNativeSoLoader", 2, "uncompressZip false: " + e17.getMessage());
            }
            FileUtils.delete(c(), false);
            return (byte) -1;
        }
    }

    public static String b() {
        return BaseApplicationImpl.sApplication.getFilesDir().getParent() + "/face_scan";
    }

    public static String c() {
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("FaceScanNativeSoLoader", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        String str = filesDir + "/pddata/prd/face_scan_so_v795";
        if (QLog.isColorLevel()) {
            QLog.i("FaceScanNativeSoLoader", 2, "getFaceLibPath ,path = " + str);
        }
        return str;
    }

    public static String d(String str) {
        c();
        String string = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("face_native_" + str, null);
        if (QLog.isColorLevel()) {
            QLog.i("FaceScanNativeSoLoader", 2, "getFaceSoMd5 ,soName = " + str + ",md5 = " + string);
        }
        return string;
    }

    public static String e() {
        return "";
    }

    public static String f() {
        return "";
    }

    public static String g() {
        return "";
    }

    public static boolean h() {
        if (com.tencent.mobileqq.filemanager.util.q.p(g()) && com.tencent.mobileqq.filemanager.util.q.p(e()) && i("YTFaceCluster") && i("YTFaceExtFeature") && com.tencent.mobileqq.filemanager.util.q.p(f()) && i("YTFaceClusterJNI_V852")) {
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanNativeSoLoader", 2, "isAllSoFileReady true");
                return true;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoLoader", 2, "isAllSoFileReady native so is not exist!");
            return false;
        }
        return false;
    }

    public static boolean i(String str) {
        String str2 = c() + "/lib" + str + ".so";
        File file = new File(str2);
        boolean z16 = false;
        if (!f198548a && file.exists()) {
            synchronized (f198549b) {
                String string = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("face_native_" + str, null);
                String e16 = com.tencent.mobileqq.portal.o.e(str2);
                if (QLog.isColorLevel()) {
                    QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + str + " ,spmd5 = " + string + ",fileMD5 = " + e16);
                }
                if (string != null && !string.equalsIgnoreCase(e16)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + str + " check md5 false!");
                    }
                }
                z16 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + str + " ,result = " + z16 + ",isUncompressZip = " + f198548a);
        }
        return z16;
    }

    public static byte j(String str) {
        if (str == null) {
            return (byte) -1;
        }
        String str2 = c() + "/lib" + str + ".so";
        if (QLog.isColorLevel()) {
            QLog.i("FaceScanNativeSoLoader", 2, "loadFaceNativeSo start faceNativeSo: " + str2);
        }
        File file = new File(str2);
        byte b16 = 0;
        if (!f198548a && file.exists()) {
            try {
                System.load(str2);
                if (QLog.isColorLevel()) {
                    QLog.i("FaceScanNativeSoLoader", 2, "load " + str2 + " success!");
                }
            } catch (UnsatisfiedLinkError e16) {
                QLog.d("FaceScanNativeSoLoader", 1, "loadFaceNativeSo load from face dir failed, libName = " + str + "," + e16.getMessage());
                b16 = -2;
            }
        } else {
            if (f198548a && !file.exists()) {
                b16 = -3;
            }
            if (f198548a && file.exists()) {
                b16 = -4;
            }
            if (!f198548a && !file.exists()) {
                b16 = -5;
            }
            QLog.d("FaceScanNativeSoLoader", 1, "loadFaceNativeSo no face so in face dir,libName = " + str);
        }
        com.tencent.mobileqq.ar.arengine.w.g(str, b16);
        return b16;
    }

    public static byte k(String str) {
        byte b16;
        try {
            System.load(str);
            b16 = 0;
        } catch (UnsatisfiedLinkError e16) {
            if (QLog.isColorLevel()) {
                QLog.e("FaceScanNativeSoLoader", 2, "loadSoByPath error", e16);
            }
            b16 = -2;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoLoader", 2, "loadSoByPath ret = " + ((int) b16) + ",soPath = " + str);
        }
        return b16;
    }

    public static boolean l(String str, HashMap<String, String> hashMap) {
        XmlPullParser newPullParser = Xml.newPullParser();
        hashMap.clear();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("YTFaceCluster")) {
                        hashMap.put("YTFaceCluster", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("YTFaceExtFeature")) {
                        hashMap.put("YTFaceExtFeature", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("YTFaceClusterJNI_V852")) {
                        hashMap.put("YTFaceClusterJNI_V852", newPullParser.nextText());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanNativeSoLoader", 2, "parseConfig success|config=" + hashMap);
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("FaceScanNativeSoLoader", 2, str, e16);
                return false;
            }
            return false;
        }
    }

    public static void m(String str, String str2) throws IOException {
        QZipFile qZipFile;
        InputStream inputStream;
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoLoader", 2, "uncompressZip: path=" + str);
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
                                    file2.mkdir();
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
