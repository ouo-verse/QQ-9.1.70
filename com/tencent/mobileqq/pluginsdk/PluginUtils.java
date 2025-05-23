package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@SuppressLint({"NewApi"})
/* loaded from: classes16.dex */
public class PluginUtils {
    static IPatchRedirector $redirector_ = null;
    private static final int BUFFER_LENGTH = 8192;
    public static final String CONFIG_FILE_EXTEND_NAME = ".cfg";
    private static final String SUFFIX_TMP = ".tmp";
    private static Map<String, File> sInstallPathMap;
    private static Map<String, PackageInfo> sPackageInfoMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class GetPackageInfoFailException extends Exception {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;

        public GetPackageInfoFailException(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }

        public GetPackageInfoFailException(String str, Throwable th5) {
            super(str, th5);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class PluginActivityNotFoundException extends Exception {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PluginActivityNotFoundException() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16164);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sInstallPathMap = new ConcurrentHashMap();
            sPackageInfoMap = new ConcurrentHashMap();
        }
    }

    public PluginUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x02ac: MOVE (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:685), block:B:201:0x02ac */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01f9 A[Catch: all -> 0x026e, IOException -> 0x0270, TryCatch #17 {IOException -> 0x0270, all -> 0x026e, blocks: (B:122:0x01f1, B:124:0x01f9, B:126:0x021c, B:127:0x0226, B:140:0x0234, B:142:0x023c, B:144:0x025f, B:145:0x0265, B:146:0x026d, B:150:0x0186, B:152:0x018e, B:154:0x01b2, B:155:0x01bc), top: B:121:0x01f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0230 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x023c A[Catch: all -> 0x026e, IOException -> 0x0270, TryCatch #17 {IOException -> 0x0270, all -> 0x026e, blocks: (B:122:0x01f1, B:124:0x01f9, B:126:0x021c, B:127:0x0226, B:140:0x0234, B:142:0x023c, B:144:0x025f, B:145:0x0265, B:146:0x026d, B:150:0x0186, B:152:0x018e, B:154:0x01b2, B:155:0x01bc), top: B:121:0x01f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String extractLibs(String str, String str2) {
        ZipFile zipFile;
        QZipFile qZipFile;
        ZipFile zipFile2;
        String str3;
        String exceptionInfo;
        QZipFile qZipFile2;
        QZipFile qZipFile3;
        String str4;
        String str5;
        byte[] bArr;
        boolean z16;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        String str6 = str2;
        String str7 = "..";
        String str8 = File.separator;
        if (!str6.endsWith(str8)) {
            str6 = str6 + str8;
        }
        String str9 = str6;
        try {
            try {
                qZipFile = new QZipFile(str);
            } catch (IOException e16) {
                e = e16;
                qZipFile = null;
            } catch (Throwable th5) {
                th = th5;
                zipFile = null;
                IOUtil.closeZipFile(zipFile);
                throw th;
            }
            try {
                Enumeration<? extends ZipEntry> entries = qZipFile.entries();
                str3 = null;
                while (entries.hasMoreElements()) {
                    try {
                        String name = entries.nextElement().getName();
                        if (!name.endsWith(File.separator) && !name.contains("..")) {
                            File file = new File(str9 + name);
                            while (true) {
                                if (file != null) {
                                    String name2 = file.getName();
                                    String str10 = Build.CPU_ABI;
                                    if (name2.equals(str10)) {
                                        str3 = str10;
                                        break;
                                    }
                                    String name3 = file.getName();
                                    String str11 = Build.CPU_ABI2;
                                    if (name3.equals(str11) && str3 == null) {
                                        str3 = str11;
                                    } else if (str10.equals(ResourceAttributes.HostArchValues.X86) && str3 == null && (file.getName().equals("armeabi") || file.getName().equals("armeabi-v7a"))) {
                                        str3 = file.getName();
                                    } else {
                                        file = file.getParentFile();
                                    }
                                }
                            }
                        }
                    } catch (IOException e17) {
                        e = e17;
                        e.printStackTrace();
                        exceptionInfo = getExceptionInfo(e);
                        IOUtil.closeZipFile(qZipFile);
                        if (exceptionInfo != null) {
                        }
                        qZipFile2 = null;
                        IOUtil.closeZipFile(qZipFile2);
                        return exceptionInfo;
                    }
                }
                IOUtil.closeZipFile(qZipFile);
                exceptionInfo = null;
            } catch (IOException e18) {
                e = e18;
                str3 = null;
                e.printStackTrace();
                exceptionInfo = getExceptionInfo(e);
                IOUtil.closeZipFile(qZipFile);
                if (exceptionInfo != null) {
                }
                qZipFile2 = null;
                IOUtil.closeZipFile(qZipFile2);
                return exceptionInfo;
            }
            if (exceptionInfo != null && str3 != null) {
                try {
                    QZipFile qZipFile4 = new QZipFile(str);
                    try {
                        byte[] bArr2 = new byte[4096];
                        Enumeration<? extends ZipEntry> entries2 = qZipFile4.entries();
                        String str12 = exceptionInfo;
                        while (true) {
                            if (entries2.hasMoreElements()) {
                                ZipEntry nextElement = entries2.nextElement();
                                String name4 = nextElement.getName();
                                String str13 = File.separator;
                                if (!name4.endsWith(str13) && !name4.contains(str7)) {
                                    str4 = str7;
                                    File file2 = new File(str9 + name4);
                                    int lastIndexOf = name4.lastIndexOf(str13);
                                    if (lastIndexOf != -1) {
                                        try {
                                            name4 = name4.substring(lastIndexOf + 1);
                                        } catch (IOException e19) {
                                            e = e19;
                                            qZipFile2 = qZipFile4;
                                            try {
                                                e.printStackTrace();
                                                exceptionInfo = getExceptionInfo(e);
                                                IOUtil.closeZipFile(qZipFile2);
                                                return exceptionInfo;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                IOUtil.closeZipFile(qZipFile2);
                                                throw th;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            qZipFile2 = qZipFile4;
                                            IOUtil.closeZipFile(qZipFile2);
                                            throw th;
                                        }
                                    }
                                    String str14 = name4;
                                    File file3 = new File(str9 + str14);
                                    while (true) {
                                        str5 = str9;
                                        if (file2 != null) {
                                            if (file2.getName().equals(str3)) {
                                                z16 = true;
                                                break;
                                            }
                                            file2 = file2.getParentFile();
                                            str9 = str5;
                                        } else {
                                            z16 = false;
                                            break;
                                        }
                                    }
                                    if (z16) {
                                        file3.getParentFile().mkdirs();
                                        try {
                                            inputStream = qZipFile4.getInputStream(nextElement);
                                        } catch (IOException e26) {
                                            e = e26;
                                            qZipFile3 = qZipFile4;
                                            bArr = bArr2;
                                            inputStream = null;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            qZipFile3 = qZipFile4;
                                            inputStream = null;
                                        }
                                        try {
                                            fileOutputStream = new FileOutputStream(file3);
                                            while (true) {
                                                try {
                                                    int read = inputStream.read(bArr2);
                                                    if (read <= 0) {
                                                        break;
                                                    }
                                                    qZipFile3 = qZipFile4;
                                                    try {
                                                        try {
                                                            fileOutputStream.write(bArr2, 0, read);
                                                            qZipFile4 = qZipFile3;
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                            IOUtil.closeStream(fileOutputStream);
                                                            IOUtil.closeStream(inputStream);
                                                            if (str12 == null) {
                                                                long cRC32Value = IOUtil.getCRC32Value(file3);
                                                                long crc = nextElement.getCrc();
                                                                StringBuilder sb5 = new StringBuilder();
                                                                sb5.append("extractLibs ");
                                                                sb5.append(str14);
                                                                sb5.append(" i:");
                                                                sb5.append(crc);
                                                                sb5.append(" o:");
                                                                sb5.append(cRC32Value);
                                                                if (crc != cRC32Value) {
                                                                    sb5.append(" notSame");
                                                                    file3.delete();
                                                                }
                                                                QLog.d("plugin_tag", 1, sb5.toString());
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (IOException e27) {
                                                        e = e27;
                                                        bArr = bArr2;
                                                        e.printStackTrace();
                                                        exceptionInfo = getExceptionInfo(e);
                                                        try {
                                                            IOUtil.closeStream(fileOutputStream);
                                                            IOUtil.closeStream(inputStream);
                                                            if (exceptionInfo == null) {
                                                                long cRC32Value2 = IOUtil.getCRC32Value(file3);
                                                                long crc2 = nextElement.getCrc();
                                                                StringBuilder sb6 = new StringBuilder();
                                                                sb6.append("extractLibs ");
                                                                sb6.append(str14);
                                                                sb6.append(" i:");
                                                                sb6.append(crc2);
                                                                sb6.append(" o:");
                                                                sb6.append(cRC32Value2);
                                                                if (crc2 != cRC32Value2) {
                                                                    sb6.append(" notSame");
                                                                    exceptionInfo = sb6.toString();
                                                                    file3.delete();
                                                                }
                                                                QLog.d("plugin_tag", 1, sb6.toString());
                                                            }
                                                            if (exceptionInfo != null) {
                                                            }
                                                        } catch (IOException e28) {
                                                            e = e28;
                                                            qZipFile2 = qZipFile3;
                                                            e.printStackTrace();
                                                            exceptionInfo = getExceptionInfo(e);
                                                            IOUtil.closeZipFile(qZipFile2);
                                                            return exceptionInfo;
                                                        } catch (Throwable th10) {
                                                            th = th10;
                                                            qZipFile2 = qZipFile3;
                                                            IOUtil.closeZipFile(qZipFile2);
                                                            throw th;
                                                        }
                                                    }
                                                } catch (IOException e29) {
                                                    e = e29;
                                                    qZipFile3 = qZipFile4;
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    qZipFile3 = qZipFile4;
                                                }
                                            }
                                            qZipFile3 = qZipFile4;
                                            fileOutputStream.flush();
                                            IOUtil.closeStream(fileOutputStream);
                                            IOUtil.closeStream(inputStream);
                                            if (str12 == null) {
                                                long cRC32Value3 = IOUtil.getCRC32Value(file3);
                                                bArr = bArr2;
                                                long crc3 = nextElement.getCrc();
                                                StringBuilder sb7 = new StringBuilder();
                                                sb7.append("extractLibs ");
                                                sb7.append(str14);
                                                sb7.append(" i:");
                                                sb7.append(crc3);
                                                sb7.append(" o:");
                                                sb7.append(cRC32Value3);
                                                if (crc3 != cRC32Value3) {
                                                    sb7.append(" notSame");
                                                    str12 = sb7.toString();
                                                    file3.delete();
                                                }
                                                QLog.d("plugin_tag", 1, sb7.toString());
                                            } else {
                                                bArr = bArr2;
                                            }
                                            exceptionInfo = str12;
                                        } catch (IOException e36) {
                                            e = e36;
                                            qZipFile3 = qZipFile4;
                                            bArr = bArr2;
                                            fileOutputStream = null;
                                            e.printStackTrace();
                                            exceptionInfo = getExceptionInfo(e);
                                            IOUtil.closeStream(fileOutputStream);
                                            IOUtil.closeStream(inputStream);
                                            if (exceptionInfo == null) {
                                            }
                                            if (exceptionInfo != null) {
                                            }
                                        } catch (Throwable th12) {
                                            th = th12;
                                            qZipFile3 = qZipFile4;
                                            fileOutputStream = null;
                                            IOUtil.closeStream(fileOutputStream);
                                            IOUtil.closeStream(inputStream);
                                            if (str12 == null) {
                                            }
                                            throw th;
                                        }
                                        if (exceptionInfo != null) {
                                            break;
                                        }
                                        str12 = exceptionInfo;
                                        bArr2 = bArr;
                                        str7 = str4;
                                        str9 = str5;
                                        qZipFile4 = qZipFile3;
                                    }
                                    qZipFile3 = qZipFile4;
                                    bArr = bArr2;
                                    bArr2 = bArr;
                                    str7 = str4;
                                    str9 = str5;
                                    qZipFile4 = qZipFile3;
                                }
                                str4 = str7;
                                str5 = str9;
                                qZipFile3 = qZipFile4;
                                bArr = bArr2;
                                bArr2 = bArr;
                                str7 = str4;
                                str9 = str5;
                                qZipFile4 = qZipFile3;
                            } else {
                                qZipFile3 = qZipFile4;
                                exceptionInfo = str12;
                                break;
                            }
                        }
                        qZipFile2 = qZipFile3;
                    } catch (IOException e37) {
                        e = e37;
                        qZipFile3 = qZipFile4;
                    } catch (Throwable th13) {
                        th = th13;
                        qZipFile3 = qZipFile4;
                    }
                } catch (IOException e38) {
                    e = e38;
                    qZipFile2 = null;
                } catch (Throwable th14) {
                    th = th14;
                    qZipFile2 = null;
                }
            } else {
                qZipFile2 = null;
            }
            IOUtil.closeZipFile(qZipFile2);
            return exceptionInfo;
        } catch (Throwable th15) {
            th = th15;
            zipFile = zipFile2;
            IOUtil.closeZipFile(zipFile);
            throw th;
        }
    }

    public static void extractPlugin(Context context, String str, File file) throws Exception {
        FileOutputStream fileOutputStream;
        boolean z16;
        String absolutePath = file.getAbsolutePath();
        DebugHelper.debug("extractPluginAndGetMd5Code" + absolutePath);
        String replaceFirst = str.replaceFirst("\\.apk$", ".jpg");
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(absolutePath + SUFFIX_TMP);
        if (file2.exists()) {
            file2.delete();
        }
        file2.createNewFile();
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open("plugins/" + replaceFirst);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    IOUtil.closeStream(open);
                    IOUtil.closeStream(fileOutputStream);
                    if (file.exists()) {
                        z16 = file.delete();
                    } else {
                        z16 = true;
                    }
                    QLog.d("plugin_tag", 1, "extractPluginAndGetMd5Code" + z16 + ", " + file2.renameTo(file));
                } catch (Exception e16) {
                    e = e16;
                    inputStream = open;
                    try {
                        throw new Exception("extractPluginAndGetMd5Code", e);
                    } catch (Throwable th5) {
                        th = th5;
                        IOUtil.closeStream(inputStream);
                        IOUtil.closeStream(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = open;
                    IOUtil.closeStream(inputStream);
                    IOUtil.closeStream(fileOutputStream);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
            }
        } catch (Exception e18) {
            e = e18;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    public static String extractPluginAndGetMd5Code(Context context, String str, File file) throws Exception {
        FileOutputStream fileOutputStream;
        boolean z16;
        String str2;
        String absolutePath = file.getAbsolutePath();
        DebugHelper.debug("extractPluginAndGetMd5Code" + absolutePath);
        String replaceFirst = str.replaceFirst("\\.apk$", ".jpg");
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(absolutePath + SUFFIX_TMP);
        if (file2.exists()) {
            file2.delete();
        }
        file2.createNewFile();
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open("plugins/" + replaceFirst);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    IOUtil.closeStream(open);
                    IOUtil.closeStream(fileOutputStream);
                    if (file.exists()) {
                        z16 = file.delete();
                    } else {
                        z16 = true;
                    }
                    boolean renameTo = file2.renameTo(file);
                    if (renameTo) {
                        str2 = PluginStatic.encodeFile(absolutePath);
                    } else {
                        str2 = "";
                    }
                    QLog.d("plugin_tag", 1, "extractPluginAndGetMd5Code" + z16 + ", " + renameTo);
                    return str2;
                } catch (Exception e16) {
                    e = e16;
                    inputStream = open;
                    try {
                        throw new Exception("extractPluginAndGetMd5Code", e);
                    } catch (Throwable th5) {
                        th = th5;
                        IOUtil.closeStream(inputStream);
                        IOUtil.closeStream(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = open;
                    IOUtil.closeStream(inputStream);
                    IOUtil.closeStream(fileOutputStream);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
            }
        } catch (Exception e18) {
            e = e18;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    public static String getExceptionInfo(Throwable th5) {
        while (th5.getCause() != null) {
            th5 = th5.getCause();
        }
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    @Deprecated
    private static File getInstallPluginPath(Context context, String str) {
        File file = sInstallPathMap.get(str);
        if (file == null) {
            File pluginInstallDir = getPluginInstallDir(context);
            if (pluginInstallDir == null) {
                return null;
            }
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1 && !str.substring(lastIndexOf).equalsIgnoreCase(".apk")) {
                str = str.substring(0, lastIndexOf) + ".apk";
            } else if (lastIndexOf == -1) {
                str = str + ".apk";
            }
            File file2 = new File(pluginInstallDir, str);
            sInstallPathMap.put(str, file2);
            return file2;
        }
        return file;
    }

    public static File getInstalledPluginPath(Context context, String str) {
        String str2;
        PluginBaseInfo createFromFile = PluginBaseInfoHelper.createFromFile(getPluginCfgFile(getPluginInstallDir(context), str), PluginBaseInfo.class);
        if (createFromFile != null && createFromFile.mState == 4 && (str2 = createFromFile.mInstalledPath) != null) {
            if (PluginStatic.isValidPluginPath(str2)) {
                return new File(createFromFile.mInstalledPath);
            }
            return null;
        }
        return getInstallPluginPath(context, str);
    }

    public static String getMultiDexName(String str, int i3) {
        return String.format("%s_%d.dex", str.substring(0, str.lastIndexOf(".")), Integer.valueOf(i3));
    }

    public static File getMultiDexSecondDex(Context context, String str) {
        return new File(getPluginInstallDir(context), getMultiDexName(str, 2));
    }

    public static File getOptimizedDexPath(Context context) {
        return context.getDir("odex", 0);
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = sPackageInfoMap.get(str);
        if (packageInfo == null) {
            DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo start");
            packageInfo = packageManager.getPackageArchiveInfo(str, 128);
            DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo end");
            if (packageInfo != null) {
                sPackageInfoMap.put(str, packageInfo);
            }
        }
        return packageInfo;
    }

    public static File getPluginCfgFile(File file, String str) {
        return new File(file, str + CONFIG_FILE_EXTEND_NAME);
    }

    public static File getPluginInstallDir(Context context) {
        return context.getDir("installed_plugin", 0);
    }

    public static File getPluginLibPath(Context context, String str) {
        if (str.endsWith(".apk")) {
            str = str.substring(0, str.length() - 4);
        }
        return new File(context.getDir(RFixConstants.SO_PATH, 0), str);
    }

    public static boolean isOsNeedReleaseDex() {
        return false;
    }
}
