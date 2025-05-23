package com.qzone.module.covercomponent.utils;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.module.covercomponent.manage.CoverCacheManager;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.adapter.ICoverResources;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.util.k;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.util.PlayerUtils;
import cooperation.qzone.model.CoverCacheData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverHelper {
    public static final boolean COVER_SUPPORT_GIF = false;
    public static final String GIF_URL_KEY = "custom_gif_url";
    public static final String JUMP_COVER_MALL_URL_DEFAULT = "https://h5.qzone.qq.com/bgstore/index?_wv=2098179&uin={uin}&from={from}&page={page}&qua={qua}&_bid=372&clicktime={clicktime}&hostUin={hostUin}&_proxy=1";
    public static final String JUMP_COVER_PREVIEW_URL = "https://h5.qzone.qq.com/bgstore/detail/{coverid}?_wv=2098179&from={from}&page={page}&qua={qua}&router=detail&coverid={coverid}&uin={uin}&hostUin={hostUin}";

    /* renamed from: a, reason: collision with root package name */
    private static String f48731a;

    /* renamed from: b, reason: collision with root package name */
    private static String f48732b;

    /* renamed from: c, reason: collision with root package name */
    private static String f48733c;
    public static ICoverResources sCoverRes;

    public static void changeTransparency(View view, int i3) {
        if (view.getBackground() != null) {
            view.getBackground().setAlpha(i3);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                changeTransparency(viewGroup.getChildAt(i16), i3);
            }
        }
    }

    public static String getDefaultCover() {
        if (f48731a == null) {
            f48731a = CoverEnv.getConfig("QZoneSetting", QzoneCoverConst.SECOND_KEY_QZONE_DEFAULT_COVER, QzoneCoverConst.DEFAULT_COVER);
        }
        if (f48732b == null) {
            f48732b = CoverEnv.getConfig("QZoneSetting", QzoneCoverConst.SECOND_KEY_QZONE_DEFAULT_COVER_NIGHT, QzoneCoverConst.DEFAULT_COVER_NIGHT);
        }
        if (k.f59549a.f()) {
            return f48732b;
        }
        return f48731a;
    }

    public static String getLimitPageCover() {
        if (f48733c == null) {
            f48733c = CoverEnv.getConfig("QZoneSetting", QzoneCoverConst.SECOND_KEY_QZONE_LIMIT_PAGE_COVER, QzoneCoverConst.LIMIT_PAGE_COVER);
        }
        return f48733c;
    }

    public static String getLocalDefaultCover(boolean z16) {
        int resId;
        if (CoverEnv.isInQQ()) {
            if (z16) {
                return getLimitPageCover();
            }
            return getDefaultCover();
        }
        ICoverResources iCoverResources = sCoverRes;
        if (iCoverResources == null || (resId = iCoverResources.getResId(7)) == 0) {
            return null;
        }
        return "file:///android_res/" + resId;
    }

    public static int getResId(int i3) {
        ICoverResources iCoverResources = sCoverRes;
        if (iCoverResources != null) {
            return iCoverResources.getResId(i3);
        }
        return 0;
    }

    public static boolean isWebviewLikeCover(int i3) {
        if (i3 != 6 && i3 != 8 && i3 != 10 && i3 != 17) {
            return false;
        }
        return true;
    }

    public static int parseResourceUrl(String str, int i3) {
        String substring;
        if (isResourceUrl(str) && (substring = str.substring(20)) != null) {
            try {
                return Integer.parseInt(substring);
            } catch (NumberFormatException unused) {
            }
        }
        return i3;
    }

    public static boolean isFullScreenCover(CoverCacheData coverCacheData) {
        return 7 == checkCoverType(coverCacheData);
    }

    private static String b(String str) {
        if (str != null && str.length() > 0) {
            return "video_cover_" + str.hashCode();
        }
        return "";
    }

    public static String getVideoUrl(VideoInfo videoInfo) {
        VideoUrl videoUrl;
        if (videoInfo == null || (videoUrl = videoInfo.videoUrl) == null) {
            return null;
        }
        return videoUrl.url;
    }

    public static boolean isLocalVideo(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.startsWith("/");
    }

    public static boolean isResourceUrl(String str) {
        return str != null && str.startsWith("file:///android_res/");
    }

    public static int parseInt(String str, int i3) {
        if (str == null || str.length() == 0) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return i3;
        }
    }

    public static String toPrintString(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                sb5.append((Object) key);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append((Object) value);
                sb5.append(" ; ");
            }
            return sb5.toString();
        }
        return "";
    }

    public static VideoInfo toVideoData(HashMap<String, String> hashMap) {
        int parseInt;
        int parseInt2;
        String str;
        String str2;
        int parseInt3;
        String str3;
        String b16;
        VideoInfo videoInfo = new VideoInfo();
        if (hashMap == null) {
            return null;
        }
        String str4 = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_STATUS);
        String str5 = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PATH);
        if ("1002".equals(str4)) {
            if (TextUtils.isEmpty(str5)) {
                videoInfo.videoUrl = new VideoUrl(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PLAY_URL));
                parseInt = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC_WIDTH), 0);
                parseInt2 = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC_HEIGHT), 0);
                str = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC);
                str2 = hashMap.get(QzoneCoverConst.KEY_VIDEO_ID);
            } else {
                videoInfo.videoUrl = new VideoUrl(str5);
                parseInt = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_WIDTH), 0);
                parseInt2 = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_HEIGHT), 0);
                str = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC);
                str2 = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_VIDEO_ID);
            }
        } else if ("1000".equals(str4)) {
            videoInfo.videoUrl = null;
            parseInt = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_WIDTH), 0);
            parseInt2 = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_HEIGHT), 0);
            str = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC);
            if (!isFileExist(str)) {
                str = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC);
            }
            str2 = "";
        } else {
            if ("1001".equals(str4)) {
                if (isFileExist(str5)) {
                    videoInfo.videoUrl = new VideoUrl(str5);
                } else {
                    videoInfo.videoUrl = null;
                }
                parseInt = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_WIDTH), 0);
                parseInt3 = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_HEIGHT), 0);
                str3 = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC);
                if (!isFileExist(str3)) {
                    str3 = "";
                }
                b16 = b(str5);
            } else if (isFileExist(str5)) {
                videoInfo.videoUrl = new VideoUrl(str5);
                String str6 = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC);
                if (!TextUtils.isEmpty(str6) && FeedVideoEnv.isNetworkAvailable(CoverEnv.getContext())) {
                    str3 = str6;
                    parseInt = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC_WIDTH), 0);
                    parseInt3 = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC_HEIGHT), 0);
                } else {
                    parseInt = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_WIDTH), 0);
                    parseInt3 = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_HEIGHT), 0);
                    str3 = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC);
                    if (!isFileExist(str3)) {
                        parseInt = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC_WIDTH), 0);
                        parseInt3 = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC_HEIGHT), 0);
                        str3 = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC);
                    }
                }
                b16 = b(str5);
            } else {
                videoInfo.videoUrl = new VideoUrl(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PLAY_URL));
                parseInt = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC_WIDTH), 0);
                parseInt2 = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC_HEIGHT), 0);
                str = hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_PIC);
                str2 = hashMap.get(QzoneCoverConst.KEY_VIDEO_ID);
            }
            String str7 = str3;
            str2 = b16;
            parseInt2 = parseInt3;
            str = str7;
        }
        if (str == null || str.length() == 0) {
            str = getDefaultCover();
        }
        videoInfo.videoId = str2;
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = str;
        pictureUrl.width = Math.min(parseInt, parseInt2);
        pictureUrl.height = Math.min(parseInt, parseInt2);
        videoInfo.coverUrl = pictureUrl;
        videoInfo.width = parseInt;
        videoInfo.height = parseInt2;
        long parseInt4 = parseInt(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_DURATION), 1);
        if (parseInt4 <= 0) {
            CoverLog.w("CoverHelper", "video time is " + parseInt4 + ", change to 1", null);
            parseInt4 = 1;
        }
        videoInfo.videoTime = parseInt4;
        videoInfo.videoStatus = 0;
        videoInfo.validVideoTime = parseInt4;
        videoInfo.validVideoTimeDesc = "";
        videoInfo.isCircle = true;
        videoInfo.isAutoPlay = true;
        videoInfo.playType = (byte) 3;
        videoInfo.processor = new QzoneCoverSquareImageProcessor(0);
        return videoInfo;
    }

    public static String getUrlMain(String str) {
        return (str == null || isLocalVideo(str)) ? str : PlayerUtils.parseVideoKey(str);
    }

    public static boolean isFileExist(String str) {
        if (str != null && str.length() > 0 && str.startsWith("/")) {
            try {
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    return file.canRead();
                }
                return false;
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return false;
    }

    public static int checkCoverType(CoverCacheData coverCacheData) {
        if (coverCacheData == null) {
            return 4;
        }
        if (!CoverEnv.isInQQ() && CoverEnv.isContentTypeFamousSpace(coverCacheData.uin)) {
            return 8;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_QZONE_SHOW_COVER.equals(coverCacheData.type)) {
            return 6;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_PHOTOWALL.equals(coverCacheData.type)) {
            ArrayList<Map<Integer, String>> arrayList = coverCacheData.photoWall;
            if (arrayList == null || arrayList.size() <= 0) {
                return 4;
            }
            return (coverCacheData.isJigsawOpen <= 0 || coverCacheData.photoWall.size() < 3) ? 1 : 2;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_GAME.equals(coverCacheData.type)) {
            return coverCacheData.gameCoverInfo != null ? 5 : 3;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN.equals(coverCacheData.type)) {
            return 7;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER.equals(coverCacheData.type)) {
            return 9;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_NEW_VIDEO_COVER.equals(coverCacheData.type)) {
            return 15;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM_DYNAMIC_ALBUM_COVER.equals(coverCacheData.type)) {
            return 10;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM_GIF_COVER.equals(coverCacheData.type)) {
            return 16;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_PANORAMA_COVER.equals(coverCacheData.type) || QzoneCoverConst.CoverStringType.COVER_TYPE_PANORAMA_COVER.equals(coverCacheData.type)) {
            return 18;
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_MUSIC_COVER.equals(coverCacheData.type)) {
            return 19;
        }
        if (!TextUtils.isEmpty(coverCacheData.type) && coverCacheData.type.startsWith(QzoneCoverConst.CoverStringType.COVER_TYPE_WEBVIEW_COVER_PREFIX)) {
            return 17;
        }
        if (!CoverEnv.isInQQ()) {
            if (QzoneCoverConst.CoverStringType.COVER_TYPE_WEATHER_COVER.equals(coverCacheData.type)) {
                return 13;
            }
            if (QzoneCoverConst.CoverStringType.COVER_TYPE_CARTOON_COVER.equals(coverCacheData.type)) {
                return 12;
            }
            if (QzoneCoverConst.CoverStringType.COVER_TYPE_COCOS2D_COVER.equals(coverCacheData.type)) {
                return 14;
            }
        }
        if (TextUtils.isEmpty(CoverCacheManager.getRightCoverUrl(coverCacheData))) {
            return "default".equals(coverCacheData.type) ? 3 : 4;
        }
        return 0;
    }

    public static CoverCacheData copyObject(CoverCacheData coverCacheData) {
        if (coverCacheData == null) {
            return null;
        }
        CoverCacheData coverCacheData2 = new CoverCacheData();
        coverCacheData2.uin = coverCacheData.uin;
        coverCacheData2.type = coverCacheData.type;
        coverCacheData2.coverId = coverCacheData.coverId;
        coverCacheData2.local_url = coverCacheData.local_url;
        coverCacheData2.isJigsawOpen = coverCacheData.isJigsawOpen;
        coverCacheData2.alian = coverCacheData.alian;
        HashMap<String, String> hashMap = coverCacheData.mapExtInfo;
        if (hashMap != null && !hashMap.isEmpty()) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            coverCacheData2.mapExtInfo = hashMap2;
            hashMap2.putAll(coverCacheData.mapExtInfo);
        }
        HashMap<String, String> hashMap3 = coverCacheData.backupMapExtInfo;
        if (hashMap3 != null && !hashMap3.isEmpty()) {
            HashMap<String, String> hashMap4 = new HashMap<>();
            coverCacheData2.backupMapExtInfo = hashMap4;
            hashMap4.putAll(coverCacheData.backupMapExtInfo);
        }
        if (coverCacheData.packageInfo != null) {
            CoverCacheData.PackageInfo packageInfo = new CoverCacheData.PackageInfo();
            coverCacheData2.packageInfo = packageInfo;
            CoverCacheData.PackageInfo packageInfo2 = coverCacheData.packageInfo;
            packageInfo.prePic = packageInfo2.prePic;
            packageInfo.PackageUrl = packageInfo2.PackageUrl;
            packageInfo.md5 = packageInfo2.md5;
            packageInfo.weather = packageInfo2.weather;
            packageInfo.daytime = packageInfo2.daytime;
            packageInfo.coverStyle = packageInfo2.coverStyle;
            packageInfo.degrade_pic = packageInfo2.degrade_pic;
        }
        if (coverCacheData.gameCoverInfo != null) {
            CoverCacheData.GameCoverInfo gameCoverInfo = new CoverCacheData.GameCoverInfo();
            coverCacheData2.gameCoverInfo = gameCoverInfo;
            CoverCacheData.GameCoverInfo gameCoverInfo2 = coverCacheData.gameCoverInfo;
            gameCoverInfo.xCoordLU = gameCoverInfo2.xCoordLU;
            gameCoverInfo.yCoordLU = gameCoverInfo2.yCoordLU;
            gameCoverInfo.xCoordRD = gameCoverInfo2.xCoordRD;
            gameCoverInfo.yCoordRD = gameCoverInfo2.yCoordRD;
            gameCoverInfo.jmpUrl = gameCoverInfo2.jmpUrl;
            gameCoverInfo.schema = gameCoverInfo2.schema;
            gameCoverInfo.jmpType = gameCoverInfo2.jmpType;
        }
        if (coverCacheData.urls != null) {
            HashMap<String, String> hashMap5 = new HashMap<>();
            coverCacheData2.urls = hashMap5;
            hashMap5.putAll(coverCacheData.urls);
        }
        if (coverCacheData.photoWall != null) {
            coverCacheData2.photoWall = new ArrayList<>();
            for (int i3 = 0; i3 < coverCacheData.photoWall.size(); i3++) {
                HashMap hashMap6 = new HashMap();
                hashMap6.putAll(coverCacheData.photoWall.get(i3));
                coverCacheData2.photoWall.add(hashMap6);
            }
        }
        return coverCacheData2;
    }

    public static boolean isVideoCoverHanding(CoverCacheData coverCacheData) {
        HashMap<String, String> hashMap;
        return coverCacheData != null && coverCacheData.isVideoCover() && (hashMap = coverCacheData.mapExtInfo) != null && "1".equals(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_STATUS));
    }

    public static boolean isCoverDataTheSame(CoverCacheData coverCacheData, CoverCacheData coverCacheData2) {
        if (coverCacheData == null || coverCacheData2 == null || coverCacheData.uin != coverCacheData2.uin || TextUtils.isEmpty(coverCacheData.type) || !coverCacheData.type.equals(coverCacheData2.type)) {
            return false;
        }
        String str = coverCacheData.type;
        if (!QzoneCoverConst.CoverStringType.COVER_TYPE_STATIC.equals(str) && !QzoneCoverConst.CoverStringType.COVER_TYPE_NEW_VIDEO_COVER.equals(str) && !QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM.equals(str) && !QzoneCoverConst.CoverStringType.COVER_TYPE_GAME.equals(str) && !QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN.equals(str)) {
            if (QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER.equals(str)) {
                if (!coverCacheData2.mapExtInfo.containsKey(QzoneCoverConst.KEY_VIDEO_COVER_PIC) && !coverCacheData2.mapExtInfo.containsKey(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC) && !coverCacheData2.mapExtInfo.containsKey(QzoneCoverConst.KEY_VIDEO_COVER_PLAY_URL) && !coverCacheData2.mapExtInfo.containsKey(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PATH)) {
                    return true;
                }
                if (!TextUtils.isEmpty(coverCacheData.coverId) && !TextUtils.isEmpty(coverCacheData2.coverId) && coverCacheData.coverId.equals(coverCacheData2.coverId) && isTheSameVideo(toVideoData(coverCacheData.mapExtInfo), toVideoData(coverCacheData2.mapExtInfo))) {
                    return true;
                }
            }
            return a(coverCacheData, coverCacheData2);
        }
        if (TextUtils.isEmpty(coverCacheData.coverId) || TextUtils.isEmpty(coverCacheData2.coverId)) {
            return a(coverCacheData, coverCacheData2);
        }
        return coverCacheData.coverId.equals(coverCacheData2.coverId);
    }

    public static String getFromPageName(int i3) {
        if (i3 == 1) {
            return "qzone";
        }
        if (i3 != 2) {
            return "";
        }
        return QzoneCoverConst.REFER_USERHOME;
    }

    public static boolean isTheSameVideo(VideoInfo videoInfo, VideoInfo videoInfo2) {
        PictureUrl pictureUrl;
        if (videoInfo != null && videoInfo2 != null) {
            String urlMain = getUrlMain(getVideoUrl(videoInfo));
            if (!TextUtils.isEmpty(urlMain) && urlMain.equals(getUrlMain(getVideoUrl(videoInfo2))) && (pictureUrl = videoInfo.coverUrl) != null && videoInfo2.coverUrl != null && !TextUtils.isEmpty(pictureUrl.url) && videoInfo.coverUrl.url.equals(videoInfo2.coverUrl.url)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(CoverCacheData coverCacheData, CoverCacheData coverCacheData2) {
        String str;
        String str2;
        HashMap<String, String> hashMap;
        HashMap<String, String> hashMap2;
        ArrayList<Map<Integer, String>> arrayList;
        if (coverCacheData == null || coverCacheData2 == null || (!((str = coverCacheData.local_url) == null && coverCacheData2.local_url == null) && (str == null || (str2 = coverCacheData2.local_url) == null || !str.equals(str2)))) {
            return false;
        }
        HashMap<String, String> hashMap3 = coverCacheData.urls;
        if (!(hashMap3 == null && coverCacheData2.urls == null) && (hashMap3 == null || (hashMap = coverCacheData2.urls) == null || !hashMap3.equals(hashMap))) {
            return false;
        }
        HashMap<String, String> hashMap4 = coverCacheData.mapExtInfo;
        if ((!(hashMap4 == null && coverCacheData2.mapExtInfo == null) && (hashMap4 == null || (hashMap2 = coverCacheData2.mapExtInfo) == null || !hashMap4.equals(hashMap2))) || coverCacheData.isJigsawOpen != coverCacheData2.isJigsawOpen) {
            return false;
        }
        ArrayList<Map<Integer, String>> arrayList2 = coverCacheData.photoWall;
        if (arrayList2 == null && coverCacheData2.photoWall == null) {
            return true;
        }
        return (arrayList2 == null || (arrayList = coverCacheData2.photoWall) == null || !arrayList2.equals(arrayList)) ? false : true;
    }
}
