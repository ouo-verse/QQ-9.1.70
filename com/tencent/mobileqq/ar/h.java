package com.tencent.mobileqq.ar;

import android.util.Xml;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h {
    public static synchronized int a(String str, String str2) {
        synchronized (h.class) {
            QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. soResFilename = " + str + ", soResMd5FromConfig = " + str2);
            l.f("arcloud", "v8.4.1.1", "arcloud", str2);
            String b16 = l.b("arcloud", "v8.4.1.1", str2);
            try {
                i.i(str, b16);
                String str3 = b16 + File.separator + "md5_config.xml";
                File file = new File(str3);
                if (file.exists()) {
                    new HashMap();
                    try {
                        HashMap<String, String> f16 = f(FileUtils.readFileToString(file));
                        if (f16.size() > 0) {
                            for (Map.Entry<String, String> entry : f16.entrySet()) {
                                String key = entry.getKey();
                                String str4 = b16 + File.separator + key + ".so";
                                l.f("arcloud", "v8.4.1.1", key, entry.getValue());
                                File file2 = new File(str4);
                                QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. soFilename = " + str4);
                                if (file2.exists()) {
                                    String e16 = com.tencent.mobileqq.portal.o.e(str4);
                                    String value = entry.getValue();
                                    if (!value.equalsIgnoreCase(e16)) {
                                        file2.delete();
                                        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. check md5 failed. result = -3, filename = " + str4 + ", md5FromCalc = " + e16 + ", md5FromConfig = " + value);
                                        return -3;
                                    }
                                    ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(BaseApplication.getContext(), file2);
                                } else {
                                    QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = -2, filename = " + str4);
                                    return -2;
                                }
                            }
                            QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. result = 0");
                            return 0;
                        }
                        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = -1");
                        return -1;
                    } catch (IOException unused) {
                        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = -5, soResFilename = " + str);
                        return -5;
                    } catch (OutOfMemoryError unused2) {
                        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = -5, soResFilename = " + str);
                        return -5;
                    }
                }
                QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = -2, configFilename = " + str3);
                return -2;
            } catch (IOException unused3) {
                FileUtils.delete(b16, false);
                File file3 = new File(str);
                if (file3.exists()) {
                    file3.delete();
                }
                QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. unzip failed. result = -6, soResFilename = " + str);
                return -6;
            }
        }
    }

    public static String b() {
        return "libARCloud_64";
    }

    public static boolean c() {
        if (!new File(l.b("arcloud", "v8.4.1.1", l.e("arcloud", "v8.4.1.1", "arcloud")) + File.separator + b() + ".so").exists()) {
            return false;
        }
        return true;
    }

    public static synchronized boolean d(String str) {
        boolean z16;
        synchronized (h.class) {
            String str2 = l.b("arcloud", "v8.4.1.1", l.e("arcloud", "v8.4.1.1", "arcloud")) + File.separator + str + ".so";
            File file = new File(str2);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ArCloudNativeSoLoader", 2, "isSoFileExist soFile=" + str2 + ", exist=" + file.exists());
            }
            z16 = false;
            if (file.exists()) {
                String e16 = l.e("arcloud", "v8.4.1.1", str);
                String e17 = com.tencent.mobileqq.portal.o.e(str2);
                if (e16.equalsIgnoreCase(e17)) {
                    z16 = true;
                } else {
                    QLog.i("AREngine_ArCloudNativeSoLoader", 2, "isSoFileExist. check md5 failed. soFilename = " + str2 + ", md5FromConfig = " + e16 + ", md5FromCalc = " + e17);
                }
            } else {
                QLog.i("AREngine_ArCloudNativeSoLoader", 2, "isSoFileExist. so not exist. soFilename = " + str2);
            }
        }
        return z16;
    }

    public static synchronized int e(String str) {
        int d16;
        synchronized (h.class) {
            d16 = l.d("arcloud", "v8.4.1.1", l.e("arcloud", "v8.4.1.1", "arcloud"), str);
        }
        return d16;
    }

    private static HashMap<String, String> f(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("libARCloud")) {
                        hashMap.put("libARCloud", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("libARCloud_64")) {
                        hashMap.put("libARCloud_64", newPullParser.nextText());
                    }
                }
            }
            QLog.d("AREngine_ArCloudNativeSoLoader", 2, "parseSoMd5FromXmlConfig successfully. soMd5List = " + hashMap);
        } catch (Exception e16) {
            QLog.e("AREngine_ArCloudNativeSoLoader", 2, "parseSoMd5FromXmlConfig failed. error = " + e16.getMessage() + ", xmlConfigContent = " + str);
        }
        return hashMap;
    }
}
