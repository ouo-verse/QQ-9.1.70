package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArNativeSoLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f197388a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public static boolean f197389b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f197390c = false;

    public static byte a(String str) {
        String str2;
        byte b16 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArNativeSoLoader", 2, "doOnDownloadSuccess : " + str);
        }
        f197389b = true;
        try {
            i.i(str, b());
            HashMap hashMap = new HashMap();
            SharedPreferences.Editor edit = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
            File file = new File(b() + "/ar_native_config.xml");
            if (file.exists()) {
                try {
                    str2 = FileUtils.readFileToString(file);
                } catch (IOException e16) {
                    e16.printStackTrace();
                    str2 = null;
                }
                if (str2 != null && g(str2, hashMap)) {
                    synchronized (f197388a) {
                        Iterator it = hashMap.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                String str3 = b() + "/lib" + ((String) entry.getKey()) + ".so";
                                File file2 = new File(str3);
                                if (file2.exists()) {
                                    if (!((String) entry.getValue()).equalsIgnoreCase(com.tencent.mobileqq.portal.o.e(str3))) {
                                        file2.delete();
                                        break;
                                    }
                                    edit.putString("ar_native_" + ((String) entry.getKey()), (String) entry.getValue());
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
                        QLog.d("ArConfig_ArNativeSoLoader", 2, "config data is not correct");
                    }
                    b16 = 4;
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArNativeSoLoader", 2, "config file is not exist");
                }
                b16 = 0;
            }
            f197389b = false;
            return b16;
        } catch (IOException e17) {
            f197389b = false;
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArNativeSoLoader", 2, "uncompressZip false: " + e17.getMessage());
            }
            FileUtils.delete(b(), false);
            return (byte) -1;
        }
    }

    public static String b() {
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("ArConfig_ArNativeSoLoader", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        return filesDir.getParent() + "/ar";
    }

    public static boolean c(String str) {
        return d(str, true);
    }

    public static boolean d(String str, boolean z16) {
        String str2 = b() + "/lib" + str + ".so";
        File file = new File(str2);
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArNativeSoLoader", 2, "isSoFileExist libPath=" + str2 + ", exist=" + file.exists() + ", isUncompressZip=" + f197389b);
        }
        boolean z17 = false;
        if (!f197389b && file.exists()) {
            if (!z16) {
                return true;
            }
            synchronized (f197388a) {
                String string = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("ar_native_" + str, null);
                if (QLog.isColorLevel()) {
                    QLog.d("ArConfig_ArNativeSoLoader", 2, "isSoFileExist: md5= " + string);
                }
                if (string != null && !string.equalsIgnoreCase(com.tencent.mobileqq.portal.o.e(str2))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_ArNativeSoLoader", 2, "isSoFileExist: soName= " + str + " check md5 false!");
                    }
                }
                z17 = true;
            }
        }
        return z17;
    }

    public static boolean e(String str) {
        return new File(b() + "/lib" + str + ".so").exists();
    }

    public static byte f(String str) {
        byte b16;
        if (str == null) {
            return (byte) -1;
        }
        String str2 = b() + "/lib" + str + ".so";
        if (QLog.isColorLevel()) {
            QLog.i("ArConfig_ArNativeSoLoader", 2, "start arNativeSo: " + str2);
        }
        File file = new File(str2);
        if (!f197389b && file.exists()) {
            try {
                System.load(str2);
                if (QLog.isColorLevel()) {
                    QLog.i("ArConfig_ArNativeSoLoader", 2, "load " + str2 + " success!");
                }
                b16 = 0;
            } catch (UnsatisfiedLinkError e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("ArConfig_ArNativeSoLoader", 2, "load from ar dir failed.", e16);
                }
                b16 = -3;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("ArConfig_ArNativeSoLoader", 2, "no ar so in ar dir");
            }
            b16 = -2;
        }
        h(str, b16);
        return b16;
    }

    public static boolean g(String str, HashMap<String, String> hashMap) {
        XmlPullParser newPullParser = Xml.newPullParser();
        hashMap.clear();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2 && newPullParser.getName().equalsIgnoreCase("ArMapEngine800Arch64")) {
                    hashMap.put("ArMapEngine800Arch64", newPullParser.nextText());
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_ArNativeSoLoader", 2, "parseConfig success|config=" + hashMap);
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ArConfig_ArNativeSoLoader", 2, str, e16);
                return false;
            }
            return false;
        }
    }

    private static void h(final String str, final byte b16) {
        final SharedPreferences sharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
        int i3 = sharedPreferences.getInt("ar_native_so_load_result" + str, 0);
        if (!f197390c || i3 != b16) {
            f197390c = true;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ArNativeSoLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_soLoaderName", str);
                    hashMap.put("param_FailCode", String.valueOf((int) b16));
                    StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                    if (b16 == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    statisticCollector.collectPerformance(null, "AREnable", z16, 0L, 0L, hashMap, null);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putInt("ar_native_so_load_result" + str, b16);
                    ea.i(edit);
                }
            }, 5, null, true);
        }
    }
}
