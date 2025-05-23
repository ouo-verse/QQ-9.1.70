package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import javax.xml.parsers.DocumentBuilderFactory;
import oicq.wlogin_sdk.tools.MD5;
import org.w3c.dom.Document;

/* compiled from: P */
/* loaded from: classes11.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Code restructure failed: missing block: B:72:0x010f, code lost:
    
        com.tencent.qphone.base.util.QLog.d("DynamicSplashManager", 1, "!img.exists() result = false, return false");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x015f, code lost:
    
        r12 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(String str, String str2) {
        boolean z16;
        boolean z17 = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                if (!new File(str).exists()) {
                    QLog.d("DynamicSplashManager", 1, "md5File.exists() == false return");
                    return false;
                }
                File file = new File(str2);
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    for (File file2 : listFiles) {
                        QLog.d("DynamicSplashManager", 1, "checkUnzipFileMd5 unzipFolder.listFiles=" + file2.getName());
                    }
                    QLog.d("DynamicSplashManager", 1, "unzipFiles.length=" + listFiles.length);
                    if (listFiles.length <= 0) {
                        QLog.d("DynamicSplashManager", 1, "unzipFiles.length <= 0 return");
                        return false;
                    }
                    int length = listFiles.length - 1;
                    QLog.d("DynamicSplashManager", 1, "totalImgFilesCount = " + length);
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                    int i3 = 0;
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                QLog.d("DynamicSplashManager", 1, "dataLine = " + readLine);
                                if (readLine.length() < 5) {
                                    break;
                                }
                                String[] split = readLine.split("\\|");
                                if (split.length != 2) {
                                    break;
                                }
                                String str3 = str2 + "/" + split[0];
                                QLog.d("DynamicSplashManager", 1, "imgPath = " + str3);
                                File file3 = new File(str3);
                                if (!file3.exists()) {
                                    break;
                                }
                                String fileMD5 = MD5.getFileMD5(file3);
                                if (fileMD5 != null && fileMD5.length() != split[1].length()) {
                                    int length2 = fileMD5.length() - split[1].length();
                                    for (int i16 = 0; i16 < length2; i16++) {
                                        split[1] = "0" + split[1];
                                    }
                                }
                                if (fileMD5 == null || !fileMD5.equalsIgnoreCase(split[1])) {
                                    break;
                                }
                                i3++;
                            } catch (Exception e16) {
                                e = e16;
                                z16 = true;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    }
                    z16 = false;
                    if (i3 != length) {
                        try {
                            QLog.d("DynamicSplashManager", 1, "totalMd5Count != totalImgFilesCount, return false");
                        } catch (Exception e17) {
                            e = e17;
                            bufferedReader = bufferedReader2;
                            QLog.e("DynamicSplashManager", 1, "checkUnzipFileMd5() error exception= " + e.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return z16;
                        }
                    } else {
                        z17 = z16;
                    }
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused3) {
                        return z17;
                    }
                }
                QLog.d("DynamicSplashManager", 1, "unzipFolder.exists() == false || !unzipFolder.isDirectory() return");
                return false;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e18) {
            e = e18;
            z16 = true;
        }
    }

    private static boolean b(QQAppInterface qQAppInterface, String str, File file, String str2) {
        if (file != null && file.exists()) {
            String fileMD5 = MD5.getFileMD5(file);
            if (fileMD5 != null && fileMD5.equalsIgnoreCase(str2)) {
                return true;
            }
            file.delete();
        }
        boolean download = HttpDownloadUtil.download(qQAppInterface, str, file);
        if (file != null && file.exists()) {
            if (download) {
                String fileMD52 = MD5.getFileMD5(file);
                if (fileMD52 != null && fileMD52.equalsIgnoreCase(str2)) {
                    return true;
                }
            } else {
                file.delete();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(int i3) {
        int i16;
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (systemNetwork == 2) {
            if (QLog.isColorLevel()) {
                QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G2");
            }
        } else {
            if (systemNetwork == 3) {
                if (QLog.isColorLevel()) {
                    QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G3");
                }
                i16 = 10;
            } else if (systemNetwork == 4) {
                if (QLog.isColorLevel()) {
                    QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G4");
                }
                i16 = 20;
            } else if (systemNetwork == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.WIFI");
                }
                i16 = 100;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkValue == " + i16);
            }
            if (i16 < i3) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() user network NOT allow download, return");
            }
            return true;
        }
        i16 = 0;
        if (QLog.isColorLevel()) {
        }
        if (i16 < i3) {
        }
    }

    public static boolean d(QQAppInterface qQAppInterface, String str, int i3) {
        String str2;
        File[] listFiles;
        if (QLog.isColorLevel()) {
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() begin");
        }
        try {
            String str3 = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/dynamicSplash";
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                }
            }
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("utf-8")));
            if (parse.getElementsByTagName("splash").getLength() < 1) {
                return false;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nodeValue = parse.getElementsByTagName("img").item(0).getFirstChild().getNodeValue();
            String nodeValue2 = parse.getElementsByTagName("begin").item(0).getFirstChild().getNodeValue();
            String nodeValue3 = parse.getElementsByTagName("end").item(0).getFirstChild().getNodeValue();
            String nodeValue4 = parse.getElementsByTagName("md5").item(0).getFirstChild().getNodeValue();
            int intValue = Integer.valueOf(parse.getElementsByTagName("download_net").item(0).getFirstChild().getNodeValue()).intValue();
            int intValue2 = Integer.valueOf(parse.getElementsByTagName("play_times").item(0).getFirstChild().getNodeValue()).intValue();
            int intValue3 = Integer.valueOf(parse.getElementsByTagName("play_interval").item(0).getFirstChild().getNodeValue()).intValue();
            int intValue4 = Integer.valueOf(parse.getElementsByTagName("total_show_times").item(0).getFirstChild().getNodeValue()).intValue();
            StringBuilder sb5 = new StringBuilder();
            try {
                sb5.append(simpleDateFormat.parse(nodeValue2).getTime());
                sb5.append("|");
                sb5.append(simpleDateFormat.parse(nodeValue3).getTime());
                String sb6 = sb5.toString();
                if (c(intValue)) {
                    return false;
                }
                ea.S3(BaseApplication.getContext(), i3, intValue2, intValue3, intValue4, nodeValue4, sb6, nodeValue);
                if (QLog.isColorLevel()) {
                    str2 = "DynamicSplashManager";
                    try {
                        QLog.d(str2, 2, "parseDynamicSplashXMLConfig() SUCCESS record to SP");
                    } catch (Exception e16) {
                        e = e16;
                        if (QLog.isColorLevel()) {
                            QLog.e(str2, 2, "parseDynamicSplashXMLConfig() ERROR = " + e.getMessage());
                        }
                        return false;
                    }
                } else {
                    str2 = "DynamicSplashManager";
                }
                if (simpleDateFormat.parse(nodeValue3).getTime() < System.currentTimeMillis()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(str2, 2, "parseDynamicSplashXMLConfig() the config is out of date, return");
                    }
                    return true;
                }
                File file3 = new File(str3 + "/" + nodeValue4 + ".zip");
                if (!b(qQAppInterface, nodeValue, file3, nodeValue4)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(str2, 2, "parseDynamicSplashXMLConfig() downloadZipFile is filed, return");
                    }
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(str2, 2, "parseDynamicSplashXMLConfig() downloadZipFile is SUCCESS");
                }
                if (e(str3, nodeValue4, file3)) {
                    return false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(str2, 2, "parseDynamicSplashXMLConfig() the folder path of splash is" + str3);
                    QLog.d(str2, 2, "parseDynamicSplashXMLConfig() finish");
                }
                return true;
            } catch (Exception e17) {
                e = e17;
                str2 = "DynamicSplashManager";
            }
        } catch (Exception e18) {
            e = e18;
            str2 = "DynamicSplashManager";
        }
    }

    public static boolean e(String str, String str2, File file) {
        String str3 = str + "/" + str2;
        File file2 = new File(str3);
        if (!FileUtils.unzip(file, file2)) {
            if (file2.exists()) {
                file2.delete();
            }
            if (QLog.isColorLevel()) {
                QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is filed, return");
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is SUCCESS");
        }
        if (!a(str3 + "/md5.txt", str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is filed, return");
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is SUCCESS");
        }
        if (file2.isDirectory()) {
            long lastModified = file2.lastModified();
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
            edit.putLong(AppConstants.Preferences.DYNAMIC_SPLASH_CONFIG_FOLDER_MODIFY_TIME, lastModified);
            edit.commit();
            return false;
        }
        return false;
    }
}
