package com.tencent.mobileqq.shortvideo;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return true;
    }

    public static String b() {
        String string = BaseApplicationImpl.getApplication().getSharedPreferences("other_res_short_video_mgr_sp", 4).getString("other_res_sv_md5_version_soname_key", "other_res000_0");
        boolean b16 = e.b(string, 1);
        VideoEnvironment.LogDownLoad("ShortVideoOtherResourceMgr", "getCurrentPendantUnzipPath success=" + b16 + ",md5Version=" + string, null);
        if (!b16) {
            return "other_res000_0";
        }
        return string;
    }

    public static String c() {
        return com.tencent.mobileqq.shortvideo.util.f.e() + "other_res_cache" + File.separator;
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
            if (b().equals(str) && e.a(str3, "other_res_config_file")) {
                VideoEnvironment.LogDownLoad("ShortVideoOtherResourceMgr", "uncompressPendantZip:[checkUnzipFileListSizeIsOK]success=true", null);
                return false;
            }
            FileUtils.deleteDirectory(str3);
            VideoEnvironment.LogDownLoad("ShortVideoOtherResourceMgr", "uncompressPendantZip:[deleteDirectory|already exists]unzipPath=" + str3, null);
        }
        VideoEnvironment.LogDownLoad("ShortVideoOtherResourceMgr", "uncompressPendantZip:[exists]mkOK=" + file.mkdirs(), null);
        try {
            FileUtils.uncompressZip(str2, str3, false);
            boolean a16 = e.a(str3, "other_res_config_file");
            VideoEnvironment.LogDownLoad("ShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK success=" + a16, null);
            if (a16) {
                boolean d16 = d(str);
                VideoEnvironment.LogDownLoad("ShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK saveOK=" + d16, null);
                if (!d16) {
                    VideoEnvironment.LogDownLoad("ShortVideoOtherResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two]saveOK=" + d(str), null);
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
    public static boolean f(AppInterface appInterface, ShortVideoResourceManager.SVConfigItem sVConfigItem) {
        return false;
    }
}
