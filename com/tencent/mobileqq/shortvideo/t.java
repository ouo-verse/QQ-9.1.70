package com.tencent.mobileqq.shortvideo;

import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static String f288215a = "Xiaomi;Redmi 4X;23|LGE;Nexus 5X;27|HUAWEI;CAM-UL00;23|Meizu;M2 E;23|vivo;vivo X9s Plus L;25";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return FeatureManager.isBasicFeaturesFunctionReady();
    }

    public static String c() {
        String string = BaseApplicationImpl.getApplication().getSharedPreferences("portrait_short_video_mgr_sp", 4).getString("portrait_sv_md5_version_soname_key", "Portrait000_0");
        boolean b16 = e.b(string, 9);
        VideoEnvironment.LogDownLoad("ShortVideoPortraitResourceManager", "getCurrentPendantUnzipPath success=" + b16 + ",md5Version=" + string, null);
        if (!b16) {
            return "Portrait000_0";
        }
        return string;
    }

    public static String d() {
        return com.tencent.mobileqq.shortvideo.util.f.e() + "portrait_res_cache" + File.separator;
    }

    private static boolean e(String str, String str2) {
        String[] split;
        boolean z16 = false;
        if (str2 == null || (split = str2.split("\\|")) == null) {
            return false;
        }
        int length = split.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (split[i3].equalsIgnoreCase(str)) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPortraitResourceManager", 2, "in black list:" + z16 + ", buildType:" + str);
        }
        return z16;
    }

    public static boolean f() {
        return e(Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel() + ";" + Build.VERSION.SDK_INT, f288215a);
    }

    private static boolean g(String str) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("portrait_short_video_mgr_sp", 4).edit();
        edit.putString("portrait_sv_md5_version_soname_key", str);
        boolean commit = edit.commit();
        VideoEnvironment.LogDownLoad("ShortVideoPortraitResourceManager", "storeNewPendantUnzipPath commitValue=" + commit + ",pathName=" + str, null);
        return commit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized boolean h(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        synchronized (t.class) {
            String str3 = d() + str + File.separator;
            File file = new File(str3);
            boolean z16 = false;
            if (file.exists()) {
                if (c().equals(str) && e.a(str3, "portrait_config_file")) {
                    VideoEnvironment.LogDownLoad("ShortVideoPortraitResourceManager", "uncompressPortraitZip:[checkUnzipFileListSizeIsOK]success=true", null);
                    return false;
                }
                FileUtils.deleteDirectory(str3);
                VideoEnvironment.LogDownLoad("ShortVideoPortraitResourceManager", "uncompressPortraitZip:[deleteDirectory|already exists]unzipPath=" + str3, null);
            }
            VideoEnvironment.LogDownLoad("ShortVideoPortraitResourceManager", "uncompressPortraitZip:[exists]mkOK=" + file.mkdirs(), null);
            boolean z17 = true;
            try {
                FileUtils.uncompressZip(str2, str3, false);
                boolean a16 = e.a(str3, "portrait_config_file");
                VideoEnvironment.LogDownLoad("ShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK success=" + a16, null);
                if (a16) {
                    boolean g16 = g(str);
                    VideoEnvironment.LogDownLoad("ShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK saveOK=" + g16, null);
                    if (!g16) {
                        boolean g17 = g(str);
                        VideoEnvironment.LogDownLoad("ShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK[two]saveOK=" + g17, null);
                        if (!g17) {
                            VideoEnvironment.LogDownLoad("ShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
                            VideoEnvironment.LogDownLoad("ShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + g("Portrait000_0") + ",signature=" + str, null);
                            z16 = true;
                        }
                    }
                    b();
                    z17 = z16;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return z17;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(AppInterface appInterface, ShortVideoResourceManager.SVConfigItem sVConfigItem) {
        return com.tencent.mobileqq.shortvideo.util.f.h();
    }

    public static void b() {
    }
}
