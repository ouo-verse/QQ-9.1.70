package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ytcommon.util.YTCommonInterface;
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
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f198544a = false;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f198545b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f198546c = false;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f198547d = false;

    public static byte a(String str) {
        String str2;
        f198544a = true;
        File file = new File(b());
        byte b16 = 2;
        if (file.exists()) {
            boolean c16 = com.tencent.mobileqq.filemanager.util.q.c(file);
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanModelsLoader", 2, "doOnDownloadSuccess delete oldUncompressedFile:" + c16);
            }
        }
        try {
            i(str, c());
            HashMap hashMap = new HashMap();
            SharedPreferences.Editor edit = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
            File file2 = new File(c() + "/face_models_config.xml");
            if (file2.exists()) {
                try {
                    str2 = FileUtils.readFileToString(file2);
                } catch (IOException e16) {
                    e16.printStackTrace();
                    str2 = null;
                }
                if (str2 != null && h(str2, hashMap)) {
                    synchronized (f198545b) {
                        Iterator it = hashMap.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                String str3 = c() + File.separator + ((String) entry.getKey());
                                File file3 = new File(str3);
                                if (file3.exists()) {
                                    if (!((String) entry.getValue()).equalsIgnoreCase(com.tencent.mobileqq.portal.o.e(str3))) {
                                        file3.delete();
                                        break;
                                    }
                                    edit.putString("face_models_" + ((String) entry.getKey()), (String) entry.getValue());
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
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("FaceScanModelsLoader", 2, "config data is not correct");
                    }
                    b16 = 4;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("FaceScanModelsLoader", 2, "config file is not exist");
                }
                b16 = 0;
            }
            f198544a = false;
            return b16;
        } catch (IOException e17) {
            f198544a = false;
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanModelsLoader", 2, "uncompressZip false: " + e17.getMessage());
            }
            FileUtils.delete(c(), false);
            return (byte) -1;
        }
    }

    public static String b() {
        return BaseApplicationImpl.sApplication.getFilesDir().getParent() + "/face_models";
    }

    public static String c() {
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("FaceScanModelsLoader", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        String str = filesDir + "/pddata/prd/face_scan_models";
        if (QLog.isColorLevel()) {
            QLog.i("FaceScanModelsLoader", 2, "getFaceModelsPath ,path = " + str);
        }
        return str;
    }

    public static boolean d(Context context) {
        boolean z16 = false;
        if (context == null) {
            return false;
        }
        if (f198546c) {
            return f198546c;
        }
        FaceCluster.getInstance();
        YTCommonInterface.initAuthForQQ(context);
        if (FaceCluster.getInstance().isLoadSoSuccess()) {
            z16 = g(context);
        } else {
            QLog.d("FaceScanModelsLoader", 1, "initModels loadSo failed");
        }
        f198546c = z16;
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanModelsLoader", 2, "initModels result = " + z16);
        }
        return z16;
    }

    public static boolean e() {
        if (f("fc_eval.rpdm") && f("rpn_fr_cluster_256_norelu.model")) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanModelsLoader", 2, "modules is not exist!");
            return false;
        }
        return false;
    }

    public static boolean f(String str) {
        String str2 = c() + File.separator + str;
        File file = new File(str2);
        boolean z16 = false;
        if (!f198544a && file.exists()) {
            synchronized (f198545b) {
                String string = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("face_models_" + str, null);
                if (string != null && !string.equalsIgnoreCase(com.tencent.mobileqq.portal.o.e(str2))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FaceScanModelsLoader", 2, "isModelFileExist: modelName= " + str + " check md5 false!");
                    }
                }
                z16 = true;
            }
        }
        return z16;
    }

    public static boolean g(Context context) {
        String c16 = c();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(c16);
        String str = File.separator;
        sb5.append(str);
        sb5.append("ufdmtcc.bin");
        if (FaceCluster.getInstance().init(sb5.toString(), c16 + str + "ufat.bin", c16 + str) == 0) {
            return true;
        }
        return false;
    }

    public static boolean h(String str, HashMap<String, String> hashMap) {
        XmlPullParser newPullParser = Xml.newPullParser();
        hashMap.clear();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("fc_eval.rpdm")) {
                        hashMap.put("fc_eval.rpdm", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("rpn_fr_cluster_256_norelu.model")) {
                        hashMap.put("rpn_fr_cluster_256_norelu.model", newPullParser.nextText());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("FaceScanModelsLoader", 2, "parseConfig success|config=" + hashMap);
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("FaceScanModelsLoader", 2, str, e16);
                return false;
            }
            return false;
        }
    }

    public static void i(String str, String str2) throws IOException {
        QZipFile qZipFile;
        InputStream inputStream;
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanModelsLoader", 2, "uncompressZip: path=" + str);
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

    public static void j() {
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanModelsLoader", 2, "uninitModels start hasFaceModelInit = " + f198546c);
        }
        f198547d = true;
        if (f198546c) {
            FaceCluster.getInstance().release();
            f198546c = false;
        }
        f198547d = false;
        if (QLog.isColorLevel()) {
            QLog.d("FaceScanModelsLoader", 2, "uninitModels finish");
        }
    }
}
