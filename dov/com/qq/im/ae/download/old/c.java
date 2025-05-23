package dov.com.qq.im.ae.download.old;

import android.content.SharedPreferences;
import com.tencent.aelight.camera.download.old.api.IAEOldPath;
import com.tencent.aelight.camera.download.old.api.IAEOldResPendentVersion;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return FeatureManager.Features.LIGHT_SDK.isResourceReady();
    }

    public static String c() {
        String string = BaseApplicationImpl.getApplication().getSharedPreferences("portrait_short_video_mgr_sp", 4).getString("portrait_sv_md5_version_soname_key", "Portrait000_0");
        boolean checkSignatureVersionIsOK = ((IAEOldResPendentVersion) QRoute.api(IAEOldResPendentVersion.class)).checkSignatureVersionIsOK(string, 9);
        VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "getCurrentPendantUnzipPath success=" + checkSignatureVersionIsOK + ",md5Version=" + string, null);
        if (!checkSignatureVersionIsOK) {
            return "Portrait000_0";
        }
        return string;
    }

    public static String d() {
        return ((IAEOldPath) QRoute.api(IAEOldPath.class)).getPendantBasePath() + "portrait_res_cache" + File.separator;
    }

    private static boolean e(String str) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("portrait_short_video_mgr_sp", 4).edit();
        edit.putString("portrait_sv_md5_version_soname_key", str);
        boolean commit = edit.commit();
        VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "storeNewPendantUnzipPath commitValue=" + commit + ",pathName=" + str, null);
        return commit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized boolean f(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        synchronized (c.class) {
            String str3 = d() + str + File.separator;
            File file = new File(str3);
            boolean z16 = false;
            if (file.exists()) {
                if (c().equals(str) && ((IAEOldResPendentVersion) QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(str3, "portrait_config_file")) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "uncompressPortraitZip:[checkUnzipFileListSizeIsOK]success=true", null);
                    return false;
                }
                FileUtils.deleteDirectory(str3);
                VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "uncompressPortraitZip:[deleteDirectory|already exists]unzipPath=" + str3, null);
            }
            VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "uncompressPortraitZip:[exists]mkOK=" + file.mkdirs(), null);
            boolean z17 = true;
            try {
                FileUtils.uncompressZip(str2, str3, false);
                boolean checkConfigFileListIsOK = ((IAEOldResPendentVersion) QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(str3, "portrait_config_file");
                VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK success=" + checkConfigFileListIsOK, null);
                if (checkConfigFileListIsOK) {
                    boolean e16 = e(str);
                    VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK saveOK=" + e16, null);
                    if (!e16) {
                        boolean e17 = e(str);
                        VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK[two]saveOK=" + e17, null);
                        if (!e17) {
                            VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
                            VideoEnvironment.LogDownLoad("AEOldShortVideoPortraitResourceManager", "uncompressPortraitZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + e("Portrait000_0") + ",signature=" + str, null);
                            z16 = true;
                        }
                    }
                    b();
                    z17 = z16;
                }
            } catch (Exception e18) {
                e18.printStackTrace();
            }
            return z17;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(AppInterface appInterface, AEOldShortVideoResManager.SVConfigItem sVConfigItem) {
        return com.tencent.mobileqq.shortvideo.util.f.h();
    }

    public static void b() {
    }
}
