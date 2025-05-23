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
public class k {
    public static synchronized int a(String str, String str2) {
        synchronized (k.class) {
            QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. soResFilename = " + str + ", soResMd5FromConfig = " + str2);
            l.f("arfeature", "v8.0.0", "arfeature", str2);
            try {
                i.i(str, l.b("arfeature", "v8.0.0", l.e("arfeature", "v8.0.0", "arfeature")));
                String str3 = l.b("arfeature", "v8.0.0", l.e("arfeature", "v8.0.0", "arfeature")) + File.separator + "md5_config.xml";
                File file = new File(str3);
                if (file.exists()) {
                    new HashMap();
                    try {
                        try {
                            HashMap<String, String> d16 = d(FileUtils.readFileToString(file));
                            if (d16.size() > 0) {
                                for (Map.Entry<String, String> entry : d16.entrySet()) {
                                    String str4 = "";
                                    if (entry.getKey().equalsIgnoreCase("libARFeature")) {
                                        str4 = l.b("arfeature", "v8.0.0", l.e("arfeature", "v8.0.0", "arfeature")) + File.separator + entry.getKey() + ".so";
                                        l.f("arfeature", "v8.0.0", "libARFeature", entry.getValue());
                                    }
                                    File file2 = new File(str4);
                                    QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. soFilename = " + str4);
                                    if (file2.exists()) {
                                        String e16 = com.tencent.mobileqq.portal.o.e(str4);
                                        String value = entry.getValue();
                                        if (!value.equalsIgnoreCase(e16)) {
                                            file2.delete();
                                            QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. check md5 failed. result = -3, filename = " + str4 + ", md5FromCalc = " + e16 + ", md5FromConfig = " + value);
                                            return -3;
                                        }
                                        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(BaseApplication.getContext(), file2);
                                    } else {
                                        QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = -2, filename = " + str4);
                                        return -2;
                                    }
                                }
                                QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. result = 0");
                                return 0;
                            }
                            QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = -1");
                            return -1;
                        } catch (OutOfMemoryError unused) {
                            QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = -5, soResFilename = " + str);
                            return -5;
                        }
                    } catch (IOException unused2) {
                        QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = -5, soResFilename = " + str);
                        return -5;
                    }
                }
                QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = -2, configFilename = " + str3);
                return -2;
            } catch (IOException unused3) {
                FileUtils.delete(l.b("arfeature", "v8.0.0", l.e("arfeature", "v8.0.0", "arfeature")), false);
                File file3 = new File(str);
                if (file3.exists()) {
                    file3.delete();
                }
                QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. unzip failed. result = -6, soResFilename = " + str);
                return -6;
            }
        }
    }

    public static boolean b() {
        if (!new File(l.b("arfeature", "v8.0.0", l.e("arfeature", "v8.0.0", "arfeature")) + File.separator + "libARFeature.so").exists()) {
            return false;
        }
        return true;
    }

    public static synchronized int c(String str) {
        int d16;
        synchronized (k.class) {
            d16 = l.d("arfeature", "v8.0.0", l.e("arfeature", "v8.0.0", "arfeature"), str);
        }
        return d16;
    }

    private static HashMap<String, String> d(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2 && newPullParser.getName().equalsIgnoreCase("libARFeature")) {
                    hashMap.put("libARFeature", newPullParser.nextText());
                }
            }
            QLog.d("AREngine_ArFeatureSwepNativeSoLoader", 2, "parseSoMd5FromXmlConfig successfully. soMd5List = " + hashMap);
        } catch (Exception e16) {
            QLog.e("AREngine_ArFeatureSwepNativeSoLoader", 2, "parseSoMd5FromXmlConfig failed. error = " + e16.getMessage() + ", xmlConfigContent = " + str);
        }
        return hashMap;
    }
}
