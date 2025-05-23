package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes18.dex */
public class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(QQAppInterface qQAppInterface, String str) {
        if (str.startsWith("new_qq_android_native_short_video_")) {
            return VideoEnvironment.checkAndLoadAVCodec();
        }
        if (str.startsWith("new_qq_android_native_art_filter_")) {
            return ShortVideoArtResourceMgr.a();
        }
        if (str.startsWith("new_qq_android_native_short_other_")) {
            return s.a();
        }
        if (str.startsWith("new_qq_android_native_portrait_filter_")) {
            return t.a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(ShortVideoResourceManager.SVConfigItem sVConfigItem) {
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:APPID=" + AppSetting.f() + " subVersion=" + AppSetting.f99551k + " buildnum=" + AppSetting.f99542b, null);
        if (sVConfigItem.name.startsWith("new_qq_android_native_short_video_")) {
            if (sVConfigItem.name.equalsIgnoreCase("new_qq_android_native_short_video_" + sVConfigItem.versionCode)) {
                if (!VideoEnvironment.needDownloadCurrentServerVersion(sVConfigItem.versionCode)) {
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + sVConfigItem.versionCode, null);
                    return -2;
                }
                return 0;
            }
            return -4;
        }
        if (sVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
            if (sVConfigItem.name.equalsIgnoreCase("new_qq_android_native_art_filter_" + sVConfigItem.versionCode)) {
                if (sVConfigItem.versionCode < 9) {
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + sVConfigItem.versionCode + " buildInArt=9", null);
                    return -2;
                }
                return 0;
            }
            return -4;
        }
        if (sVConfigItem.name.startsWith("new_qq_android_native_short_new_other_")) {
            if (sVConfigItem.name.equalsIgnoreCase("new_qq_android_native_short_new_other_" + sVConfigItem.versionCode)) {
                if (sVConfigItem.versionCode < 1) {
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + sVConfigItem.versionCode + " buildInOther=1", null);
                    return -2;
                }
                return 0;
            }
            return -4;
        }
        if (sVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
            if (sVConfigItem.name.equalsIgnoreCase("new_qq_android_native_short_other_" + sVConfigItem.versionCode)) {
                if (sVConfigItem.versionCode < 1) {
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + sVConfigItem.versionCode + " buildInOther=1", null);
                    return -2;
                }
                return 0;
            }
            return -4;
        }
        if (sVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
            if (sVConfigItem.name.equalsIgnoreCase("new_qq_android_native_portrait_filter_" + sVConfigItem.versionCode)) {
                if (sVConfigItem.versionCode < 9) {
                    VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:item.versionCode=" + sVConfigItem.versionCode + " buildInPortrait=9", null);
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
            return ShortVideoArtResourceMgr.f(qQAppInterface, str2, str3, i3);
        }
        if (str.startsWith("new_qq_android_native_short_other_")) {
            return s.e(qQAppInterface, str2, str3, i3);
        }
        if (!str.startsWith("new_qq_android_native_portrait_filter_")) {
            return false;
        }
        return t.h(qQAppInterface, str2, str3, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(AppInterface appInterface, ShortVideoResourceManager.SVConfigItem sVConfigItem) {
        boolean z16;
        if (sVConfigItem.name.startsWith("new_qq_android_native_short_video_")) {
            z16 = VideoEnvironment.needDownloadCurrentServerVersion(sVConfigItem.versionCode);
            VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload[Builtin Mode]:needDownload=" + z16 + ",itemConfig.name=" + sVConfigItem.name, null);
            if (z16) {
                z16 = VideoEnvironment.supportShortVideoRecordAndPlay();
            }
        } else if (sVConfigItem.name.startsWith("new_qq_android_native_art_filter_")) {
            z16 = ShortVideoArtResourceMgr.g(appInterface, sVConfigItem);
        } else if (sVConfigItem.name.startsWith("new_qq_android_native_short_other_")) {
            z16 = s.f(appInterface, sVConfigItem);
        } else if (sVConfigItem.name.startsWith("new_qq_android_native_portrait_filter_")) {
            z16 = t.i(appInterface, sVConfigItem);
        } else {
            z16 = true;
        }
        VideoEnvironment.LogDownLoad("ShortVideoResourceManager", "userCheckNeedDownload:needDownload=" + z16 + ",itemConfig.name=" + sVConfigItem.name, null);
        return z16;
    }
}
