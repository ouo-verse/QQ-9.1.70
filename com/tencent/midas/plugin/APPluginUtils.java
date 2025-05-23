package com.tencent.midas.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.pay.tool.APMidasTools;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IMidasSoCallback;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APMidasRSATools;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.jsbridge.APWebJSBridgeActivity;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.theme.SkinEngine;
import com.tencent.util.AbiUtil;
import cooperation.qzone.patch.QZonePatchService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes9.dex */
public class APPluginUtils {
    private static final int BUFFER_LENGTH = 8192;
    private static final String TAG = "PluginUtils";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
    static String installErrMsg = null;
    private static ArrayList<String> emptyResList = null;
    private static String[] fileList = null;
    private static Object copyFileObject = new Object();

    private static void callbackInMidasPluginWhenRunningInNewProcess(Context context, int i3, String str) {
        try {
            Intent intent = new Intent();
            intent.putExtra("EXTRA_CALLBACK_RESULT_CODE", i3);
            intent.putExtra("EXTRA_CALLBACK_RESULT_MSG", str);
            APPluginInterfaceManager.initPluginInterface(context, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_CALLBACK_FROM_MIDAS_PAY, new Object[]{context, intent});
        } catch (Exception e16) {
            APLog.e("PluginProxyActivity", "openPlugin error:" + e16.toString());
        }
    }

    public static void callbackInMidasPluginWithoutCaringAboutNewProcess(Context context, int i3, String str) {
        if (context == null) {
            APLog.e(TAG, "Call back in plugin without caring process fail, null context!");
            return;
        }
        APLog.d(TAG, "Call back in plugin without caring process, context ok!");
        if (APMidasPayHelper.isNewProcess(context)) {
            APLog.d(TAG, "Call back in plugin without caring process, is new process!");
            callbackInMidasPluginWhenRunningInNewProcess(context, i3, str);
            return;
        }
        APLog.d(TAG, "Call back in plugin without caring process, not new process!");
        APMidasResponse aPMidasResponse = new APMidasResponse();
        aPMidasResponse.resultCode = i3;
        aPMidasResponse.resultMsg = str;
        APMidasPayHelper.midasCallBack(aPMidasResponse);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkFileMD5(String str, String str2) {
        String str3;
        FileInputStream fileInputStream = null;
        try {
        } catch (Exception e16) {
            e = e16;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream2.close();
                str3 = toHexString(messageDigest.digest());
            } catch (Exception e17) {
                e = e17;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                e.printStackTrace();
                str3 = "";
                if (str3.equalsIgnoreCase(str2)) {
                }
            }
            if (str3.equalsIgnoreCase(str2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static void clearDirContent(File file) {
        if (file != null && (file.exists() & file.isDirectory())) {
            APLog.d(TAG, "About to clear dir, path = " + file.getAbsolutePath());
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                }
                return;
            }
            return;
        }
        APLog.e(TAG, "call clear dir content, but parameter error!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyDirect(Context context, File file, File file2) {
        File[] listFiles;
        if (file == null || file2 == null || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file3 : listFiles) {
            copyFile(file3.getAbsolutePath(), file2.getAbsolutePath(), file3.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyEmtpyResAPKFromAssets(Context context) {
        String[] assetFileList;
        if (!isHasBSL() || (assetFileList = getAssetFileList(context)) == null) {
            return;
        }
        for (String str : assetFileList) {
            if (str.startsWith("MidasEmptyRes") && str.endsWith(".apk")) {
                String str2 = APPluginConfig.getPluginEmptyResPath(context).getAbsolutePath() + File.separator + str;
                APLog.i("APPluginUtils", "copyEmtpyResAPKFromAssets meptyResPath:" + str2);
                try {
                    InputStream open = context.getAssets().open(str);
                    File file = new File(str2);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    open.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00d9 A[Catch: IOException -> 0x00d5, TRY_LEAVE, TryCatch #1 {IOException -> 0x00d5, blocks: (B:72:0x00d1, B:59:0x00d9), top: B:71:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void copyFile(String str, String str2, String str3, String str4) {
        FileOutputStream fileOutputStream;
        File file;
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        String str5 = "";
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                File file2 = new File(str2);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                file = new File(str2 + str3);
                try {
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = null;
                }
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
                file = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                file = null;
            }
        } catch (Exception e18) {
            e = e18;
            fileOutputStream = null;
            file = null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
            file = null;
        }
        if (file.exists()) {
            try {
                fileInputStream.close();
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            if ("".compareToIgnoreCase(str4) != 0) {
                file.delete();
                return;
            }
            return;
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                messageDigest.update(bArr, 0, read);
            }
            str5 = toHexString(messageDigest.digest());
            fileOutputStream.flush();
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e26) {
                e26.printStackTrace();
            }
            if (str5.compareToIgnoreCase(str4) == 0) {
                return;
            }
        } catch (Exception e27) {
            e = e27;
            fileInputStream2 = fileInputStream;
            try {
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                        if (str5.compareToIgnoreCase(str4) != 0 || file == null) {
                            return;
                        }
                        file.delete();
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (str5.compareToIgnoreCase(str4) != 0) {
                    return;
                } else {
                    return;
                }
            } catch (Throwable th8) {
                th = th8;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                        if (str5.compareToIgnoreCase(str4) == 0) {
                            throw th;
                        }
                        if (file != null) {
                            file.delete();
                            throw th;
                        }
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (str5.compareToIgnoreCase(str4) == 0) {
                }
            }
        } catch (Throwable th9) {
            th = th9;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
            if (str5.compareToIgnoreCase(str4) == 0) {
            }
        }
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void deleteBKPlugin(Context context) {
        APLog.i("APPluginUtils", "deleteUpdatePlugin");
        deleteFiles(APPluginConfig.getPluginBackUpPath(context));
    }

    public static void deleteDex(Context context) {
        APLog.i("APPluginUtils", "deleteDex");
        deleteFiles(APPluginConfig.getOptimizedDexPath(context));
    }

    public static void deleteFiles(File file) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    file2.delete();
                }
            }
            file.delete();
            return;
        }
        file.delete();
    }

    public static void deleteLibs(Context context) {
        APLog.i("APPluginUtils", "deleteLibs");
        deleteFiles(APPluginConfig.getLibPath(context));
    }

    public static void deletePlugin(Context context) {
        APLog.i("APPluginUtils", "deletePlugin");
        deleteFiles(APPluginConfig.getPluginPath(context));
    }

    public static void deletePluginOat(Context context) {
        File[] listFiles;
        APLog.i("APPluginUtils", "delete oat Plugin");
        File pluginDexOfOat = APPluginConfig.getPluginDexOfOat(context);
        if (pluginDexOfOat == null) {
            return;
        }
        try {
            if (!pluginDexOfOat.isDirectory() || (listFiles = pluginDexOfOat.listFiles()) == null) {
                return;
            }
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    File[] listFiles2 = file.listFiles();
                    if (listFiles2 == null) {
                        return;
                    }
                    for (File file2 : listFiles2) {
                        if (file2 != null && file2.exists()) {
                            APLog.i("APPluginUtils", "delete oat file=" + file2.getName());
                            file2.delete();
                        }
                    }
                    file.delete();
                }
            }
            pluginDexOfOat.delete();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void deleteUpdatePlugin(Context context) {
        APLog.d(TAG, "Calling into deleteUpdatePlugin " + Thread.currentThread().getStackTrace()[3].toString());
        deleteFiles(APPluginConfig.getPluginUpdatePath(context));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
    
        if (r0.startsWith(com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes.HostArchValues.X86) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01aa A[EDGE_INSN: B:59:0x01aa->B:60:0x01aa BREAK  A[LOOP:0: B:16:0x0076->B:64:0x0076], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0076 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int extractLibs(String str, String str2) {
        boolean z16;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        String str3 = Build.CPU_ABI;
        String str4 = "arm64-v8a";
        if (!str3.startsWith("arm64-v8a")) {
            if (!str3.startsWith(AbiUtil.ARM)) {
                str4 = "x86_64";
                if (!str3.startsWith("x86_64")) {
                    str4 = ResourceAttributes.HostArchValues.X86;
                }
            }
            str4 = "armeabi";
        }
        APLog.i("APPluginUtils", "extractLibs end to dirToExtract:" + str4 + " extractLibs ABI:" + str3);
        String str5 = File.separator;
        if (!str2.endsWith(str5)) {
            str2 = str2 + str5;
        }
        FileOutputStream fileOutputStream2 = null;
        installErrMsg = null;
        try {
            ZipFile zipFile = new ZipFile(str);
            byte[] bArr = new byte[4096];
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                String str6 = File.separator;
                if (!name.endsWith(str6) && !name.contains("../") && (name.contains(RFixConstants.SO_PATH) || name.endsWith(".so"))) {
                    APLog.i("APPluginUtils", "fileName:" + name);
                    File file = new File(str2 + name);
                    int lastIndexOf = name.lastIndexOf(str6);
                    if (lastIndexOf != -1) {
                        name = name.substring(lastIndexOf + 1);
                    }
                    File file2 = new File(str2 + name);
                    while (true) {
                        if (file != null) {
                            if (file.getName().equals(str4)) {
                                z16 = true;
                                break;
                            }
                            file = file.getParentFile();
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (z16) {
                        file2.getParentFile().mkdirs();
                        try {
                            inputStream = zipFile.getInputStream(nextElement);
                            try {
                                fileOutputStream = new FileOutputStream(file2);
                                while (true) {
                                    try {
                                        try {
                                            int read = inputStream.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        } catch (Throwable th5) {
                                            th = th5;
                                            fileOutputStream2 = fileOutputStream;
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (IOException e16) {
                                                    e16.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            IMidasSoCallback iMidasSoCallback = APMidasPayHelper.midasSoCallback;
                                            if (iMidasSoCallback != null) {
                                                iMidasSoCallback.onLoadPath(file2.getPath());
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e17) {
                                        e = e17;
                                        APLog.w("extra libs", "extra lbis error:" + e.toString());
                                        installErrMsg = getFullExceptionStacktrace(e);
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e18) {
                                                e = e18;
                                                e.printStackTrace();
                                                if (installErrMsg == null) {
                                                }
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        IMidasSoCallback iMidasSoCallback2 = APMidasPayHelper.midasSoCallback;
                                        if (iMidasSoCallback2 != null) {
                                            iMidasSoCallback2.onLoadPath(file2.getPath());
                                        }
                                        if (installErrMsg == null) {
                                        }
                                    }
                                }
                                fileOutputStream.flush();
                            } catch (IOException e19) {
                                e = e19;
                                fileOutputStream = null;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (IOException e26) {
                            e = e26;
                            inputStream = null;
                            fileOutputStream = null;
                        } catch (Throwable th7) {
                            th = th7;
                            inputStream = null;
                        }
                        try {
                            fileOutputStream.close();
                            inputStream.close();
                            IMidasSoCallback iMidasSoCallback3 = APMidasPayHelper.midasSoCallback;
                            if (iMidasSoCallback3 != null) {
                                iMidasSoCallback3.onLoadPath(file2.getPath());
                            }
                        } catch (IOException e27) {
                            e = e27;
                            e.printStackTrace();
                            if (installErrMsg == null) {
                            }
                        }
                        if (installErrMsg == null) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return 0;
        } catch (IOException e28) {
            e28.printStackTrace();
            installErrMsg = getFullExceptionStacktrace(e28);
            return -1;
        }
    }

    private static String[] getAssetFileList(Context context) {
        try {
            if (fileList == null) {
                long currentTimeMillis = System.currentTimeMillis();
                fileList = context.getAssets().list("");
                APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_GET_FILELIST_FROM_ASSETS, currentTimeMillis);
            }
        } catch (IOException e16) {
            APLog.w("APPLuginUtils", "getPluginNameFromAssets e:" + e16.getMessage());
        }
        return fileList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAssetsVersionCode(Context context) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open("MidasPay.zip");
                int zipVersionCodeWtihStream = getZipVersionCodeWtihStream(context, inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
                return zipVersionCodeWtihStream;
            } catch (Throwable th5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                throw th5;
            }
        } catch (Exception e18) {
            installErrMsg = getFullExceptionStacktrace(e18);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
            APLog.i("assets \u76ee\u5f55\u4e0b\u5185\u6838\u7248\u672c\u53f7\uff1a", "versionCode:0");
            return 0;
        }
    }

    public static File getDataZipFile(Context context) {
        String path = APMidasPayAPI.getPath();
        if (!TextUtils.isEmpty(path)) {
            APLog.i("APPluginUtils", "getDataZipFile sPath:" + path);
            File file = new File(path);
            if (file.getName().startsWith("MidasPay") && file.getName().endsWith(".zip")) {
                return file;
            }
            return null;
        }
        return null;
    }

    public static String getExceptionInfo(Throwable th5) {
        while (th5.getCause() != null) {
            th5 = th5.getCause();
        }
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static String getFullExceptionStacktrace(Throwable th5) {
        PrintWriter printWriter;
        StringWriter stringWriter = null;
        try {
            StringWriter stringWriter2 = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter2);
                try {
                    th5.printStackTrace(printWriter);
                    String stringWriter3 = stringWriter2.toString();
                    try {
                        stringWriter2.close();
                        printWriter.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return stringWriter3;
                } catch (Throwable th6) {
                    th = th6;
                    stringWriter = stringWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                            throw th;
                        }
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                printWriter = null;
            }
        } catch (Throwable th8) {
            th = th8;
            printWriter = null;
        }
    }

    public static String getInitErrorMsg() {
        return installErrMsg;
    }

    public static File getInstallPath(Context context, String str) {
        return APPluginInstallerAndUpdater.getInstallPath(context, str);
    }

    public static String getInstallPathString(Context context, String str) {
        return APPluginInstallerAndUpdater.getInstallPathString(context, str);
    }

    public static File getLibPath(Context context) {
        return APPluginConfig.getLibPath(context);
    }

    public static String getMD5FromPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(".apk");
        int lastIndexOf2 = str.lastIndexOf("_");
        if (lastIndexOf == -1 || lastIndexOf2 == -1) {
            return "";
        }
        try {
            return str.substring(lastIndexOf2 + 1, lastIndexOf);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        r0 = r3.getCanonicalPath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMidasCoreVersionName(Context context) {
        File pluginPath = APPluginConfig.getPluginPath(context);
        if (pluginPath != null) {
            File[] listFiles = pluginPath.listFiles();
            int i3 = 0;
            while (true) {
                if (i3 >= listFiles.length) {
                    break;
                }
                File file = listFiles[i3];
                if (file.getName().startsWith("MidasCore")) {
                    try {
                        break;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                } else {
                    i3++;
                }
            }
        }
        String str = "";
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo == null) {
            return "";
        }
        return packageInfo.versionName;
    }

    public static ArrayList<String> getMidasEmptyPaht(Context context) {
        if (emptyResList == null) {
            emptyResList = new ArrayList<>();
            File pluginEmptyResPath = APPluginConfig.getPluginEmptyResPath(context);
            if (pluginEmptyResPath != null) {
                for (File file : pluginEmptyResPath.listFiles()) {
                    if (file.getName().startsWith("MidasEmptyRes") && file.getName().endsWith(".apk")) {
                        try {
                            emptyResList.add(file.getCanonicalPath());
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
        }
        return emptyResList;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PackageInfo packageInfo = APPluginInstallerAndUpdater.sPackageInfoMap.get(str);
        if (packageInfo == null && (packageInfo = packageManager.getPackageArchiveInfo(str, 128)) != null) {
            APPluginInstallerAndUpdater.sPackageInfoMap.put(str, packageInfo);
        }
        return packageInfo;
    }

    public static String getProcessName(Context context) {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getZipVersionCodeWtihFileName(Context context, String str) {
        APLog.i("getAssetsVersionCodeWtihFileName", "sUnzipMidasPayFile:" + str);
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    int zipVersionCodeWtihStream = getZipVersionCodeWtihStream(context, fileInputStream2);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return zipVersionCodeWtihStream;
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    installErrMsg = getFullExceptionStacktrace(e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    APLog.i("special data direct", "versionCode:0");
                    return 0;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        r1 = java.lang.Integer.parseInt(r2.substring(0, r2.lastIndexOf(cooperation.qzone.patch.QZonePatchService.PATCH_SUFFIX)).split("_")[2]);
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0087 -> B:23:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int getZipVersionCodeWtihStream(Context context, InputStream inputStream) {
        int i3 = 0;
        ZipInputStream zipInputStream = null;
        zipInputStream = null;
        zipInputStream = null;
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
            zipInputStream = zipInputStream;
        }
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(inputStream);
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    String str = "zipEntry:" + nextEntry;
                    APLog.i("getAssetsVersionCodeWtihFileName", str);
                    while (true) {
                        if (nextEntry == null) {
                            break;
                        }
                        str = nextEntry.getName();
                        APLog.i("getAssetsVersionCodeWtihFileName", "fileName:" + str);
                        if (!nextEntry.isDirectory() && !str.contains("../")) {
                            if (str.startsWith("MidasCore") && str.endsWith(QZonePatchService.PATCH_SUFFIX)) {
                                break;
                            }
                            nextEntry = zipInputStream2.getNextEntry();
                        }
                        nextEntry = zipInputStream2.getNextEntry();
                    }
                    zipInputStream2.close();
                    zipInputStream = str;
                } catch (Exception e17) {
                    e = e17;
                    zipInputStream = zipInputStream2;
                    e.printStackTrace();
                    installErrMsg = getFullExceptionStacktrace(e);
                    if (zipInputStream != null) {
                        zipInputStream.close();
                        zipInputStream = zipInputStream;
                    }
                    APLog.i("special data direct", "versionCode:" + i3);
                    return i3;
                } catch (Throwable th5) {
                    th = th5;
                    zipInputStream = zipInputStream2;
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
            }
            APLog.i("special data direct", "versionCode:" + i3);
            return i3;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static boolean isHasBSL() {
        boolean z16;
        try {
            String str = SkinEngine.ACTION_THEME_INVALIDATE;
            SkinEngine.class.getMethod("getInstances", new Class[0]);
            z16 = true;
        } catch (Exception e16) {
            APLog.w("APPluginContext", " is not has com.tencent.theme.SkinEngine e:" + e16.toString());
            z16 = false;
        }
        if (!z16) {
            try {
                Class.forName("com.tencent.component.theme.SkinEngine").getMethod("getInstances", new Class[0]);
                return true;
            } catch (Exception e17) {
                APLog.w("APPluginContext", " is not has com.tencent.component.theme.SkinEngine e:" + e17.toString());
                return false;
            }
        }
        return z16;
    }

    public static boolean isInNewProcess(Context context) {
        String processName = getProcessName(context);
        String packageName = context.getApplicationContext().getPackageName();
        if (TextUtils.isEmpty(processName)) {
            return false;
        }
        if (!processName.startsWith(packageName + ":") && processName.equals(packageName)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void readSingInfo(HashMap<String, String> hashMap, File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getCanonicalPath()));
            APMidasRSATools aPMidasRSATools = new APMidasRSATools();
            for (String readLine = bufferedReader.readLine(); readLine != null && !TextUtils.isEmpty(readLine); readLine = bufferedReader.readLine()) {
                String[] split = readLine.split("\\:");
                hashMap.put(split[0].split("\\_")[0], aPMidasRSATools.deCodeKey(split[1]).substring(r1.length() - 32));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void readSingInfoItems(HashMap<String, APSignIniItem> hashMap, File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getCanonicalPath()));
            APMidasRSATools aPMidasRSATools = new APMidasRSATools();
            for (String readLine = bufferedReader.readLine(); readLine != null && !TextUtils.isEmpty(readLine); readLine = bufferedReader.readLine()) {
                String[] split = readLine.split("\\:");
                String str = split[0];
                String substring = aPMidasRSATools.deCodeKey(split[1]).substring(r4.length() - 32);
                String str2 = str.split("\\_")[0];
                APSignIniItem aPSignIniItem = new APSignIniItem();
                aPSignIniItem.name = str2;
                aPSignIniItem.md5 = substring;
                aPSignIniItem.fullName = split[0];
                hashMap.put(str2, aPSignIniItem);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    public static void release() {
        APPluginInstallerAndUpdater.sInstallPathMap.clear();
        APPluginInstallerAndUpdater.sPackageInfoMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void showLaunchPluginFail(Context context, String str, boolean z16) {
        APLog.d(TAG, "Calling into showLaunchPluginFail, needToPureH5Pay = " + z16 + " caller = " + Thread.currentThread().getStackTrace()[3].toString());
        if (!TextUtils.isEmpty(str)) {
            APPluginReportManager.getInstance().reportImmediatelyOneRecord(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_NAME_LAUNCH_ERROR, str);
        }
        if (!z16 || APWebJSBridgeActivity.startPureH5Pay(context, str, "showLaunchPluginFail")) {
            return;
        }
        if (str != null && (str.contains("\u7a7a\u95f4") || str.contains("Space"))) {
            Toast.makeText(context, "\u7cfb\u7edf\u53ef\u7528\u5185\u5b58\u4e0d\u8db3\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5", 0).show();
        } else if (!TextUtils.isEmpty(str) && (str.contains("webview") || str.contains(QzoneCoverConst.CoverStringType.COVER_TYPE_WEBVIEW_COVER_PREFIX))) {
            Toast.makeText(context, "\u7cfb\u7edf\u7ec4\u4ef6\u7f3a\u5931\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5", 0).show();
        } else {
            Toast.makeText(context, "\u7cfb\u7edf\u7e41\u5fd9\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5", 0).show();
        }
        callbackInMidasPluginWithoutCaringAboutNewProcess(context, 100, "Unexpected error!");
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            char[] cArr = HEX_DIGITS;
            sb5.append(cArr[(bArr[i3] & 240) >>> 4]);
            sb5.append(cArr[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public static void unInstallPlugin(Context context) {
        APLog.d(TAG, "unInstallPlugin " + Thread.currentThread().getStackTrace()[3].toString());
        APPluginInstallerAndUpdater.unInstallPlugin(context);
    }

    public static void updateLibExtendNum() {
        APPluginConfig.libExtend++;
        APLog.i("APPluginUtils", "updateLibExtendNum libExtend:" + APPluginConfig.libExtend);
    }

    public static HashMap<String, String> url2Map(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.split("\\?");
        if (split == null) {
            return null;
        }
        if (split.length == 1) {
            str = split[0];
        } else if (split.length == 2) {
            str = split[1];
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split2 = str.split("\\&");
                String str2 = "";
                String str3 = "";
                for (int i3 = 0; i3 < split2.length; i3++) {
                    try {
                        str2 = split2[i3].split("\\=")[0];
                        str3 = split2[i3].split("\\=")[1];
                    } catch (Exception unused) {
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put(str2, str3);
                    }
                }
            } else {
                APLog.i("url2Map", "url\u540e\u53c2\u6570\u4e3a\u7a7a");
            }
        } catch (Exception e16) {
            APLog.w("url2Map", e16.toString());
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x007e A[Catch: IOException -> 0x007a, TRY_LEAVE, TryCatch #0 {IOException -> 0x007a, blocks: (B:53:0x0076, B:46:0x007e), top: B:52:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyFile(String str, String str2, String str3) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = new File(str2, str3);
                if (file2.exists()) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return false;
                }
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            try {
                                fileInputStream2.close();
                                fileOutputStream.close();
                                return true;
                            } catch (IOException e17) {
                                e17.printStackTrace();
                                return true;
                            }
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                                return false;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e27) {
                e = e27;
                fileOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
            }
        } catch (Exception e28) {
            e = e28;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }
}
