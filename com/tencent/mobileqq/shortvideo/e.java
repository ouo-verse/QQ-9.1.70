package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.z;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    public static boolean a(String str, String str2) {
        String str3 = str + str2;
        VideoEnvironment.LogDownLoad("PendantVersionManager", "checkUnzipFileListSizeIsOK configPath=" + str3, null);
        File file = new File(str3);
        if (!file.exists()) {
            VideoEnvironment.LogDownLoad("PendantVersionManager", "checkUnzipFileListSizeIsOK configPath=" + str3 + ",exists=false", null);
            return false;
        }
        ArrayList<String> c16 = c(file);
        if (c16.size() <= 0) {
            VideoEnvironment.LogDownLoad("PendantVersionManager", "checkUnzipFileListSizeIsOK configData.size()=" + c16.size(), null);
            return false;
        }
        for (int i3 = 0; i3 < c16.size(); i3++) {
            VideoEnvironment.LogDownLoad("PendantVersionManager", "checkUnzipFileListSizeIsOK itemLineValue=" + c16.get(i3), null);
            if (!TextUtils.isEmpty(c16.get(i3))) {
                String trim = c16.get(i3).trim();
                if (TextUtils.isEmpty(trim)) {
                    continue;
                } else {
                    VideoEnvironment.LogDownLoad("PendantVersionManager", "checkUnzipFileListSizeIsOK trimValue=" + trim, null);
                    z.a c17 = z.c(trim);
                    int b16 = c17.b(QbAddrData.DATA_SPLITER);
                    if (b16 == 0) {
                        String str4 = str + c17.c();
                        File file2 = new File(str4);
                        if (!file2.exists()) {
                            VideoEnvironment.LogDownLoad("PendantVersionManager", "checkUnzipFileListSizeIsOK[exists=false] fileName=" + str4, null);
                            return false;
                        }
                        int parseInt = Integer.parseInt(c17.e());
                        long length = file2.length();
                        if (parseInt != length) {
                            VideoEnvironment.LogDownLoad("PendantVersionManager", "checkUnzipFileListSizeIsOK sizeConfig=" + parseInt + ",fileSize=" + length, null);
                            return false;
                        }
                    } else {
                        VideoEnvironment.LogDownLoad("PendantVersionManager", "checkUnzipFileListSizeIsOK[CfgParser] errCode=" + b16 + ",trimValue=" + trim, null);
                        return false;
                    }
                }
            }
        }
        VideoEnvironment.LogDownLoad("PendantVersionManager", "checkUnzipFileListSizeIsOK[OK]", null);
        return true;
    }

    public static boolean b(String str, int i3) {
        String trim = str.trim();
        VideoEnvironment.LogDownLoad("PendantVersionManager", "checkSignatureVersionIsOK signature=" + str, null);
        z.a c16 = z.c(trim);
        int a16 = c16.a();
        VideoEnvironment.LogDownLoad("PendantVersionManager", "checkSignatureVersionIsOK errCode=" + a16 + ",trimSignature=" + trim, null);
        if (a16 == 0) {
            String trim2 = c16.f().trim();
            VideoEnvironment.LogDownLoad("PendantVersionManager", "checkSignatureVersionIsOK versionValid=" + trim2, null);
            int parseInt = Integer.parseInt(trim2);
            VideoEnvironment.LogDownLoad("PendantVersionManager", "checkSignatureVersionIsOK version=" + parseInt + ",limitVersion=" + i3, null);
            if (parseInt >= i3) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0058 -> B:14:0x005b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList<String> c(File file) {
        FileReader fileReader;
        Exception e16;
        BufferedReader bufferedReader;
        ArrayList<String> arrayList = new ArrayList<>(1);
        BufferedReader bufferedReader2 = null;
        try {
            try {
                fileReader = new FileReader(file);
            } catch (Exception e17) {
                fileReader = null;
                e16 = e17;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                fileReader = null;
            }
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Exception e18) {
                e16 = e18;
                bufferedReader = null;
            } catch (Throwable th6) {
                th = th6;
                if (bufferedReader2 != null) {
                }
                if (fileReader == null) {
                }
            }
            try {
                try {
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        arrayList.add(readLine);
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                    fileReader.close();
                } catch (Throwable th7) {
                    th = th7;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    if (fileReader == null) {
                        try {
                            fileReader.close();
                            throw th;
                        } catch (IOException e27) {
                            e27.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception e28) {
                e16 = e28;
                e16.printStackTrace();
                VideoEnvironment.LogDownLoad("PendantVersionManager", "getConfigFileLines exception:", e16);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                return arrayList;
            }
        } catch (IOException e36) {
            e36.printStackTrace();
        }
        return arrayList;
    }
}
