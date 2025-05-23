package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.z;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.util.notification.NotificationController;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShortVideoSoCompressUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f287718a = {"backup", "trim_process_pic", "trim_process_pie"};

    /* renamed from: b, reason: collision with root package name */
    private static final Object f287719b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static final String f287720c = "backup" + File.separatorChar;

    public static void a(String str) {
        b("ShortVideoSoCompressUtil", str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, str2, th5);
        }
    }

    private static boolean f(String str, int i3) {
        File file = new File(str + NotificationController.Constants.CONFIG_VERSION);
        if (!file.exists()) {
            return false;
        }
        String d16 = z.d(file);
        if (TextUtils.isEmpty(d16)) {
            return false;
        }
        String trim = d16.trim();
        String shortVideoSoLibName = VideoEnvironment.getShortVideoSoLibName();
        if (!TextUtils.isEmpty(shortVideoSoLibName) && shortVideoSoLibName.equalsIgnoreCase(trim)) {
            z.a c16 = z.c(shortVideoSoLibName);
            if (c16.a() != 0) {
                return false;
            }
            String trim2 = c16.f().trim();
            if (TextUtils.isEmpty(trim2)) {
                return false;
            }
            if (trim2.equalsIgnoreCase("" + i3)) {
                return VideoEnvironment.checkAndLoadAVCodec();
            }
        }
        return false;
    }

    private static void g() {
        String shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.getContext());
        String str = shortVideoSoPath + f287720c;
        File file = new File(str + "trim_process_pie");
        File file2 = new File(shortVideoSoPath + "trim_process_pie");
        boolean exists = file.exists();
        a("copyPieAndPicFile:[VIDEO_TRIM_PIE]unzipExists=" + exists);
        if (exists) {
            h(file, file2);
        }
        File file3 = new File(str + "trim_process_pic");
        File file4 = new File(shortVideoSoPath + "trim_process_pic");
        boolean exists2 = file3.exists();
        a("copyPieAndPicFile:[VIDEO_TRIM_PIC]unzipExists=" + exists2);
        if (exists2) {
            h(file3, file4);
        }
    }

    private static boolean h(File file, File file2) {
        if (!file.exists()) {
            a("copySoToFilesDir: fileSource not exist");
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        boolean exists = file2.exists();
        a("copySoToFilesDir: srcPath=" + absolutePath + " dstPath=" + absolutePath2 + " dstExists=" + exists);
        if (exists) {
            String a16 = z.a(absolutePath);
            a("copySoToFilesDir:[destFile exists] srcMd5=" + a16 + " srcPath=" + absolutePath);
            String a17 = z.a(absolutePath2);
            a("copySoToFilesDir:[destFile exists] dstMd5=" + a17 + " dstPath=" + absolutePath2);
            if (a16 != null && !"".equals(a16) && a16.equalsIgnoreCase(a17)) {
                return true;
            }
            file2.delete();
        }
        long length = file.length();
        FileUtils.renameFile(file, file2);
        long length2 = file2.length();
        a("copySoToFilesDir: soSize=" + length + " deSize=" + length2);
        if (length != length2) {
            return false;
        }
        return true;
    }

    private static void i() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.ShortVideoSoCompressUtil.1
            @Override // java.lang.Runnable
            public void run() {
                String shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.getContext());
                String e16 = z.e();
                File[] listFiles = new File(shortVideoSoPath).listFiles();
                int length = ShortVideoSoCompressUtil.f287718a.length + 3;
                if (listFiles != null && listFiles.length > length) {
                    String str = "unknown";
                    int i3 = Integer.MAX_VALUE;
                    int i16 = 0;
                    for (File file : listFiles) {
                        if (file != null) {
                            String name = file.getName();
                            if (!e16.equalsIgnoreCase(name) && !ShortVideoSoCompressUtil.k(name)) {
                                z.a c16 = z.c(name);
                                int a16 = c16.a();
                                if (a16 != 0) {
                                    ShortVideoSoCompressUtil.a("[executeClearHistorySOLibFile] errorCodec=" + a16 + "  filename=" + name);
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(shortVideoSoPath);
                                    sb5.append(name);
                                    File file2 = new File(sb5.toString());
                                    if (file2.exists() && file2.isFile()) {
                                        file2.delete();
                                    }
                                } else {
                                    String f16 = c16.f();
                                    try {
                                        int parseInt = Integer.parseInt(f16);
                                        if (parseInt < i3) {
                                            str = name;
                                            i3 = parseInt;
                                        }
                                        i16++;
                                    } catch (NumberFormatException e17) {
                                        ShortVideoSoCompressUtil.b("ShortVideoSoCompressUtil", "[executeClearHistorySOLibFile] filename=" + name + "  tempVersion=" + f16, e17);
                                    }
                                }
                            }
                        }
                    }
                    ShortVideoSoCompressUtil.a("[executeClearHistorySOLibFile] deleteName=" + str + "  validNumLibSo=" + i16 + " leastVersion=" + i3);
                    if (i16 >= 3) {
                        File file3 = new File(shortVideoSoPath + str);
                        if (file3.exists() && file3.isFile()) {
                            ShortVideoSoCompressUtil.a("[executeClearHistorySOLibFile] deletePath=" + file3.getAbsolutePath());
                            file3.delete();
                        }
                    }
                }
            }
        }, 64, null, false);
    }

    private static String j(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k(String str) {
        int i3 = 0;
        while (true) {
            String[] strArr = f287718a;
            if (i3 >= strArr.length) {
                return false;
            }
            if (str.equals(strArr[i3])) {
                return true;
            }
            i3++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean l(String str, String str2, String str3) {
        boolean z16;
        boolean g16 = z.g(str2);
        a(str + " saveSuccess=" + g16);
        if (!g16) {
            boolean g17 = z.g(str2);
            a(str + " saveSuccessTwo=" + g17);
            if (!g17) {
                a(str + "clearMemoryOK=" + z.g("d000_1") + ",signature=" + str2);
                z16 = true;
                if (!z16) {
                    ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(BaseApplication.context.getBaseContext(), str3);
                }
                return z16;
            }
        }
        z16 = false;
        if (!z16) {
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x01d6 A[Catch: all -> 0x02b5, TryCatch #0 {, blocks: (B:6:0x0031, B:8:0x003d, B:9:0x0060, B:11:0x0081, B:12:0x0099, B:14:0x00b9, B:16:0x00d6, B:18:0x00e4, B:20:0x0110, B:22:0x0158, B:25:0x0169, B:27:0x0192, B:28:0x0196, B:30:0x01d6, B:32:0x01dc, B:34:0x01e4, B:35:0x020a, B:36:0x022a, B:38:0x022b, B:39:0x024b, B:40:0x024c, B:41:0x0252, B:46:0x0255, B:47:0x0275, B:48:0x0276, B:49:0x02a2, B:50:0x02a3, B:51:0x02ab, B:52:0x02ac, B:53:0x02b4, B:54:0x0041, B:56:0x005e), top: B:5:0x0031, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m(String str, int i3) {
        boolean z16;
        boolean z17;
        String shortVideoSoPath = ShortVideoSoLoad.getShortVideoSoPath(VideoEnvironment.getContext());
        String str2 = shortVideoSoPath + f287720c;
        a("VideoEnvironment:[uncompressZipSo]destDir=" + str2);
        try {
            synchronized (f287719b) {
                File file = new File(str2);
                boolean z18 = false;
                if (!file.exists()) {
                    file.mkdirs();
                } else {
                    boolean f16 = f(str2, i3);
                    a("VideoEnvironment:[checkUncompressedResourceIsOK] checkOK=" + f16);
                    if (f16) {
                        return false;
                    }
                }
                String str3 = str2 + j("AVCodec");
                File file2 = new File(str3);
                if (file2.exists()) {
                    a("VideoEnvironment:[uncompressZipSo][has back file] path=" + str3);
                    file2.delete();
                }
                FileUtils.uncompressZip(str, str2, false);
                boolean exists = file2.exists();
                a("VideoEnvironment:[end uncompressZipSo] existsFile=" + exists);
                if (exists) {
                    File file3 = new File(str2 + NotificationController.Constants.CONFIG_VERSION);
                    if (file3.exists()) {
                        z.a c16 = z.c(z.d(file3));
                        int a16 = c16.a();
                        if (a16 == 0) {
                            String a17 = z.a(str3);
                            String d16 = c16.d();
                            a("VideoEnvironment:[uncompressZipSo][Md5] md5Cfg=" + d16 + " md5Cmp=" + a17);
                            if (d16.equalsIgnoreCase(a17)) {
                                long length = file2.length();
                                String trim = c16.f().trim();
                                String f17 = z.f(d16, trim);
                                a("VideoEnvironment:[uncompressZipSo][trim] versionValid=" + trim + " soNewName=" + f17);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(shortVideoSoPath);
                                sb5.append(f17);
                                String sb6 = sb5.toString();
                                File file4 = new File(sb6);
                                if (file4.exists()) {
                                    long length2 = file4.length();
                                    String a18 = z.a(sb6);
                                    if (!d16.equalsIgnoreCase(a18)) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    a("VideoEnvironment:[uncompressZipSo] md5NoEqualsAlready=" + z17 + " fileSize=" + length2 + " alreadySoMd5=" + a18);
                                    if (z17) {
                                        file4.delete();
                                    } else {
                                        a("VideoEnvironment:[uncompressZipSo] Restore SP md5NoEqualsAlready=" + z17 + " fileSize=" + length2 + " alreadySoMd5=" + a18 + ",md5Cfg=" + d16);
                                        z18 = l("VideoEnvironment:[uncompressZipSo Restore SP ]storeSoNewVersion", f17, sb6);
                                        z16 = false;
                                        if (z16) {
                                            if (file2.renameTo(file4)) {
                                                long length3 = file4.length();
                                                if (length == length3) {
                                                    a("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion loadLength=" + length3 + "  soNewName=" + f17);
                                                    z18 = l("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion", f17, sb6);
                                                } else {
                                                    throw new RuntimeException("[length error] destLength=" + length + " loadLength=" + length3);
                                                }
                                            } else {
                                                throw new RuntimeException("[renameTo error] destFilePath=" + str3 + "  loadFilePath=" + sb6);
                                            }
                                        }
                                        g();
                                        i();
                                        return z18;
                                    }
                                }
                                z16 = true;
                                if (z16) {
                                }
                                g();
                                i();
                                return z18;
                            }
                            throw new RuntimeException("[Md5 error] md5Cfg=" + d16 + " md5Cmp=" + a17);
                        }
                        a("VideoEnvironment:[uncompressZipSo][createParser] errorCodec=" + a16);
                        throw new RuntimeException("createParser err=" + a16);
                    }
                    throw new RuntimeException("After uncompressZip,config_version file not exist...");
                }
                throw new RuntimeException("After uncompressZip,AVCodec file not exist...");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            b("ShortVideoSoCompressUtil", "VideoEnvironment:exp=", e16);
            return true;
        }
    }
}
