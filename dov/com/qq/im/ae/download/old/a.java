package dov.com.qq.im.ae.download.old;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoSoCompressUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;

/* compiled from: P */
/* loaded from: classes28.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(QQAppInterface qQAppInterface, String str) {
        if (str.startsWith("new_qq_android_native_short_video_")) {
            return VideoEnvironment.checkAndLoadAVCodec();
        }
        if (str.startsWith("new_qq_android_native_art_filter_")) {
            return AEOldShortVideoArtResourceMgr.a();
        }
        if (str.startsWith("new_qq_android_native_short_other_")) {
            return b.a();
        }
        if (str.startsWith("new_qq_android_native_portrait_filter_")) {
            return c.a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(AEOldShortVideoResManager.SVConfigItem sVConfigItem) {
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:APPID=" + AppSetting.f() + " subVersion=" + AppSetting.f99551k + " buildnum=" + AppSetting.f99542b, null);
        if (sVConfigItem.name.startsWith("new_qq_android_native_short_video_")) {
            if (sVConfigItem.name.equalsIgnoreCase("new_qq_android_native_short_video_" + sVConfigItem.versionCode)) {
                if (!VideoEnvironment.needDownloadCurrentServerVersion(sVConfigItem.versionCode)) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:item.versionCode=" + sVConfigItem.versionCode, null);
                    return -2;
                }
                return 0;
            }
            return -4;
        }
        if (sVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
            if (sVConfigItem.name.equalsIgnoreCase("new_qq_android_native_art_filter_" + sVConfigItem.versionCode)) {
                if (sVConfigItem.versionCode < 9) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:item.versionCode=" + sVConfigItem.versionCode + " buildInArt=9", null);
                    return -2;
                }
                return 0;
            }
            return -4;
        }
        if (sVConfigItem.name.startsWith("new_qq_android_native_short_new_other_")) {
            if (sVConfigItem.name.equalsIgnoreCase("new_qq_android_native_short_new_other_" + sVConfigItem.versionCode)) {
                if (sVConfigItem.versionCode < 1) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:item.versionCode=" + sVConfigItem.versionCode + " buildInOther=1", null);
                    return -2;
                }
                return 0;
            }
            return -4;
        }
        if (sVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
            if (sVConfigItem.name.equalsIgnoreCase("new_qq_android_native_short_other_" + sVConfigItem.versionCode)) {
                if (sVConfigItem.versionCode < 1) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:item.versionCode=" + sVConfigItem.versionCode + " buildInOther=1", null);
                    return -2;
                }
                return 0;
            }
            return -4;
        }
        if (sVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
            if (sVConfigItem.name.equalsIgnoreCase("new_qq_android_native_portrait_filter_" + sVConfigItem.versionCode)) {
                if (sVConfigItem.versionCode < 9) {
                    VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:item.versionCode=" + sVConfigItem.versionCode + " buildInPortrait=9", null);
                    return -2;
                }
            }
            return -4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean c(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("new_qq_android_native_short_video_")) {
            return ShortVideoSoCompressUtil.m(str3, i3);
        }
        if (str.startsWith("new_qq_android_native_art_filter_")) {
            return AEOldShortVideoArtResourceMgr.f(qQAppInterface, str2, str3, i3);
        }
        if (str.startsWith("new_qq_android_native_short_other_")) {
            return b.e(qQAppInterface, str2, str3, i3);
        }
        if (!str.startsWith("new_qq_android_native_portrait_filter_")) {
            return false;
        }
        return c.f(qQAppInterface, str2, str3, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(AppInterface appInterface, AEOldShortVideoResManager.SVConfigItem sVConfigItem) {
        boolean z16;
        if (sVConfigItem.name.startsWith("new_qq_android_native_short_video_")) {
            z16 = VideoEnvironment.needDownloadCurrentServerVersion(sVConfigItem.versionCode);
            VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload[Builtin Mode]:needDownload=" + z16 + ",itemConfig.name=" + sVConfigItem.name, null);
            if (z16) {
                z16 = VideoEnvironment.supportShortVideoRecordAndPlay();
            }
        } else if (sVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
            z16 = AEOldShortVideoArtResourceMgr.g(appInterface, sVConfigItem);
        } else if (sVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
            z16 = b.f(appInterface, sVConfigItem);
        } else if (sVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
            z16 = c.g(appInterface, sVConfigItem);
        } else {
            z16 = true;
        }
        VideoEnvironment.LogDownLoad("AEOldShortVideoResManager", "userCheckNeedDownload:needDownload=" + z16 + ",itemConfig.name=" + sVConfigItem.name, null);
        return z16;
    }
}
