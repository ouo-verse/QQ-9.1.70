package dov.com.qq.im.ae.download.old;

import android.content.SharedPreferences;
import com.tencent.aelight.camera.download.old.api.IAEOldPath;
import com.tencent.aelight.camera.download.old.api.IAEOldResPendentVersion;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfSwitchStrategy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import dov.com.qq.im.ae.download.old.f;
import java.io.File;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AEOldShortVideoArtResourceMgr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return com.tencent.mobileqq.shortvideo.util.f.g();
    }

    private static void b() {
        ThreadManagerV2.post(new Runnable() { // from class: dov.com.qq.im.ae.download.old.AEOldShortVideoArtResourceMgr.1
            @Override // java.lang.Runnable
            public void run() {
                String c16 = AEOldShortVideoArtResourceMgr.c();
                String d16 = AEOldShortVideoArtResourceMgr.d();
                File[] listFiles = new File(c16).listFiles();
                if (listFiles != null && listFiles.length > 2) {
                    String str = "unknown";
                    int i3 = Integer.MAX_VALUE;
                    int i16 = 0;
                    for (File file : listFiles) {
                        if (file != null) {
                            String name = file.getName();
                            if (!d16.equalsIgnoreCase(name)) {
                                f.a a16 = f.a(name);
                                int a17 = a16.a();
                                if (a17 != 0) {
                                    VideoEnvironment.LogDownLoad("[executeClearArtFilterSoCache] errorCodec=" + a17 + " filename=" + name, null);
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(c16);
                                    sb5.append(name);
                                    File file2 = new File(sb5.toString());
                                    if (file2.exists() && file2.isFile()) {
                                        file2.delete();
                                    }
                                } else {
                                    String e16 = a16.e();
                                    try {
                                        int parseInt = Integer.parseInt(e16);
                                        if (parseInt < i3) {
                                            str = name;
                                            i3 = parseInt;
                                        }
                                        i16++;
                                    } catch (NumberFormatException e17) {
                                        VideoEnvironment.LogDownLoad("[executeClearArtFilterSoCache] filename=" + name + "  tempVersion=" + e16, e17);
                                    }
                                }
                            }
                        }
                    }
                    VideoEnvironment.LogDownLoad("[executeClearArtFilterSoCache] deleteName=" + str + "  validNumPendantCache=" + i16 + " leastVersion=" + i3, null);
                    if (i16 >= 2) {
                        File file3 = new File(c16 + str);
                        if (file3.exists() && file3.isFile()) {
                            VideoEnvironment.LogDownLoad("[executeClearArtFilterSoCache] deletePath=" + file3.getAbsolutePath(), null);
                            file3.delete();
                        }
                    }
                }
                if (new File(((IVideoFilterTools) QRoute.api(IVideoFilterTools.class)).getCommonPrefix()).exists()) {
                    FileUtils.deleteDirectory(((IVideoFilterTools) QRoute.api(IVideoFilterTools.class)).getCommonPrefix());
                }
            }
        }, 5, null, false);
    }

    public static String c() {
        return ((IAEOldPath) QRoute.api(IAEOldPath.class)).getPendantBasePath() + "art_res_cache" + File.separator;
    }

    public static String d() {
        String string = BaseApplicationImpl.getApplication().getSharedPreferences(QmcfSwitchStrategy.SP_TAG, 4).getString("art_res_old_sv_md5_version_soname_key", "artfilter000_0");
        boolean checkSignatureVersionIsOK = ((IAEOldResPendentVersion) QRoute.api(IAEOldResPendentVersion.class)).checkSignatureVersionIsOK(string, 9);
        VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "getCurrentPendantUnzipPath success=" + checkSignatureVersionIsOK + ",md5Version=" + string, null);
        if (!checkSignatureVersionIsOK) {
            return "artfilter000_0";
        }
        return string;
    }

    private static boolean e(String str) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(QmcfSwitchStrategy.SP_TAG, 4).edit();
        edit.putString("art_res_old_sv_md5_version_soname_key", str);
        return edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        String str3 = c() + str + File.separator;
        File file = new File(str3);
        boolean z16 = false;
        if (file.exists()) {
            if (d().equals(str) && ((IAEOldResPendentVersion) QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(str3, "artfilter_config_file")) {
                VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:[checkConfigFileListIsOK]success=true", null);
                return false;
            }
            FileUtils.deleteDirectory(str3);
            VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:[deleteDirectory|already exists]unzipPath=" + str3, null);
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:[exists]mkOK=" + file.mkdirs(), null);
        try {
            FileUtils.uncompressZip(str2, str3, false);
            boolean checkConfigFileListIsOK = ((IAEOldResPendentVersion) QRoute.api(IAEOldResPendentVersion.class)).checkConfigFileListIsOK(str3, "artfilter_config_file");
            VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK success=" + checkConfigFileListIsOK, null);
            if (!checkConfigFileListIsOK) {
                return true;
            }
            boolean e16 = e(str);
            VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK saveOK=" + e16, null);
            if (!e16) {
                boolean e17 = e(str);
                VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkConfigFileListIsOK[two]saveOK=" + e17, null);
                if (!e17) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK[two] needRestore=true,saveOK=false", null);
                    VideoEnvironment.LogDownLoad("AEOldShortVideoArtResourceMgr", "uncompressPendantZip:checkUnzipFileListSizeIsOK clearMemoryOK=" + e("artfilter000_0") + ",signature=" + str, null);
                    z16 = true;
                }
            }
            b();
            return z16;
        } catch (Exception e18) {
            e18.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (r5 != 4) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(AppInterface appInterface, AEOldShortVideoResManager.SVConfigItem sVConfigItem) {
        if (!com.tencent.mobileqq.shortvideo.util.f.l()) {
            return false;
        }
        int b16 = cr2.a.b();
        QmcfManager.getInstance().setCurrFrameType(b16);
        if (QLog.isColorLevel()) {
            QLog.d("AEOldShortVideoArtResourceMgr", 2, String.format("supportFrameType[%s]", Integer.valueOf(b16)));
        }
        if (b16 != -2) {
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 != 2) {
                        if (b16 != 3) {
                        }
                    }
                } else {
                    sVConfigItem.armv7a_url = sVConfigItem.extend1;
                    sVConfigItem.armv7a_md5 = sVConfigItem.extend2;
                }
                sVConfigItem.armv7a_url = sVConfigItem.arm_url;
                sVConfigItem.armv7a_md5 = sVConfigItem.arm_md5;
                return true;
            }
            QmcfManager.getInstance().setQmcfMobileNotSupport(cr2.a.f391695d);
        }
        return false;
    }
}
