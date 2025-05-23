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
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return true;
    }

    public static String b() {
        String string = BaseApplicationImpl.getApplication().getSharedPreferences("other_res_short_video_mgr_sp", 4).getString("other_res_sv_md5_version_soname_key", "other_res000_0");
        boolean checkSignatureVersionIsOK = ((IAEOldResPendentVersion) QRoute.api(IAEOldResPendentVersion.class)).checkSignatureVersionIsOK(string, 1);
        VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "getCurrentPendantUnzipPath success=" + checkSignatureVersionIsOK + ",md5Version=" + string, null);
        if (!checkSignatureVersionIsOK) {
            return "other_res000_0";
        }
        return string;
    }

    public static String c() {
        return ((IAEOldPath) QRoute.api(IAEOldPath.class)).getPendantBasePath() + "other_res_cache" + File.separator;
    }

    private static boolean d(String str) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("other_res_short_video_mgr_sp", 4).edit();
        edit.putString("other_res_sv_md5_version_soname_key", str);
        return edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        String str3 = c() + str + File.separator;
        File file = new File(str3);
        boolean z16 = false;
        if (file.exists()) {
            if (b().equals(str) && ((IAEOldResPendentVersion) QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(str3, "other_res_config_file")) {
                VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:[checkUnzipFileListSizeIsOK]success=true", null);
                return false;
            }
            FileUtils.deleteDirectory(str3);
            VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:[deleteDirectory|already exists]unzipPath=" + str3, null);
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:[exists]mkOK=" + file.mkdirs(), null);
        try {
            FileUtils.uncompressZip(str2, str3, false);
            boolean checkConfigFileListIsOK = ((IAEOldResPendentVersion) QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(str3, "other_res_config_file");
            VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK success=" + checkConfigFileListIsOK, null);
            if (checkConfigFileListIsOK) {
                boolean d16 = d(str);
                VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK saveOK=" + d16, null);
                if (!d16) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two]saveOK=" + d(str), null);
                }
            } else {
                z16 = true;
            }
            return z16;
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(AppInterface appInterface, AEOldShortVideoResManager.SVConfigItem sVConfigItem) {
        return false;
    }
}
