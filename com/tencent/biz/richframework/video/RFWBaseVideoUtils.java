package com.tencent.biz.richframework.video;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.video.RFWPlayerVideoInfo;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import uq3.h;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWBaseVideoUtils {
    public static final ISPBandwidthPredictor BAND_WIDTH_PREDICTOR;
    public static final HashMap<Integer, String> PLAY_MSG_MAP;
    public static final boolean USE_VIDEO_URI;
    private static final String VIDEO_CACHE_FILE;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        PLAY_MSG_MAP = hashMap;
        BAND_WIDTH_PREDICTOR = SuperPlayerFactory.createBandwidthPredictor(RFWApplication.getApplication());
        USE_VIDEO_URI = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("USE_VIDEO_URI", true);
        VIDEO_CACHE_FILE = RFWApplication.getApplication().getExternalCacheDir() + "/superplayer/170303102";
        hashMap.put(0, "PLAYER_INFO_UNKNOW");
        hashMap.put(100, "PLAYER_INFO_FIRST_CLIP_OPENED");
        hashMap.put(101, "PLAYER_INFO_PACKET_READ");
        hashMap.put(102, "PLAYER_INFO_FIRST_AUDIO_DECODER_START");
        hashMap.put(104, "PLAYER_INFO_FIRST_AUDIO_FRAME_RENDERED");
        hashMap.put(105, "PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED");
        hashMap.put(106, "PLAYER_INFO_FIRST_PACKET_READ");
        hashMap.put(107, "PLAYER_INFO_CURRENT_LOOP_START");
        hashMap.put(108, "PLAYER_INFO_CURRENT_LOOP_END");
        hashMap.put(109, "PLAYER_INFO_CLIP_EOS");
        hashMap.put(110, "PLAYER_INFO_EOS");
        hashMap.put(111, "PLAYER_INFO_SWITCH_DEFINITION");
        hashMap.put(112, "PLAYER_INFO_BUFFERING_START");
        hashMap.put(113, "PLAYER_INFO_BUFFERING_END");
        hashMap.put(114, "PLAYER_INFO_AUDIO_DECODER_TYPE");
        hashMap.put(115, "PLAYER_INFO_VIDEO_DECODER_TYPE");
        hashMap.put(116, "PLAYER_INFO_AUDIO_SW_DECODING_SLOW");
        hashMap.put(117, "PLAYER_INFO_AUDIO_HW_DECODING_SLOW");
        hashMap.put(118, "PLAYER_INFO_VIDEO_SW_DECODING_SLOW");
        hashMap.put(119, "PLAYER_INFO_VIDEO_HW_DECODING_SLOW");
        hashMap.put(121, "PLAYER_INFO_NEED_TO_ROTATE_SURFACE");
        hashMap.put(122, "PLAYER_INFO_MEDIACODEC_VIDEO_CROP");
        hashMap.put(123, "PLAYER_INFO_PRIVATE_HLS_TAG");
        hashMap.put(124, "PLAYER_INFO_PLAYER_TYPE");
        hashMap.put(200, "PLAYER_INFO_RETRY_PLAYER");
        hashMap.put(201, "PLAYER_INFO_ALL_DOWNLOAD_FINISH");
        hashMap.put(203, "PLAYER_INFO_OBJECT_PLAY_CDN_URL_CHANGED");
        hashMap.put(204, "PLAYER_INFO_OBJECT_PLAY_CDN_INFO_UPDATE");
        hashMap.put(205, "PLAYER_INFO_PROTOCOL_UPDATE");
        hashMap.put(206, "PLAYER_INFO_DOWNLOAD_STATUS_UPDATE");
        hashMap.put(207, "TP_PLAYER_INFO_OBJECT_DOWNLOAD_PROGRESS_UPDATE");
        hashMap.put(208, "PLAYER_INFO_OBJECT_MEDIA_CODEC_INFO");
        hashMap.put(209, "PLAYER_INFO_VIDEO_FRAME_CHECK_INFO");
        hashMap.put(250, "TP_PLAYER_INFO_STRING_DOWNLOAD_QUIC_STATUS_UPDATE");
        hashMap.put(0, "PLAYER_INFO_UNKNOW");
    }

    public static boolean checkCacheExist(String str, String str2) {
        return new File(VIDEO_CACHE_FILE + String.format("/%s.mp4", getFileIdWithTapPosition(str, str2))).exists();
    }

    public static String convertWhatToString(int i3) {
        String str = PLAY_MSG_MAP.get(Integer.valueOf(i3));
        if (str == null) {
            return String.valueOf(i3);
        }
        return str;
    }

    public static SuperPlayerVideoInfo createSuperVideoInfo(RFWPlayerVideoInfo rFWPlayerVideoInfo) {
        SuperPlayerVideoInfo createVideoInfoForFileDescriptor;
        String str = rFWPlayerVideoInfo.mVid;
        String str2 = rFWPlayerVideoInfo.mUrl;
        List<String> list = rFWPlayerVideoInfo.mVecUrls;
        int i3 = rFWPlayerVideoInfo.mDurationInMs;
        if (!TextUtils.isEmpty(str) && str2 == null) {
            return SuperPlayerFactory.createVideoInfoForTVideo(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (RFWFileUtils.isUriPath(str2)) {
            try {
                if (USE_VIDEO_URI) {
                    createVideoInfoForFileDescriptor = SuperPlayerFactory.createVideoInfoForUri(Uri.parse(str2));
                } else {
                    createVideoInfoForFileDescriptor = SuperPlayerFactory.createVideoInfoForFileDescriptor(RFWApplication.getApplication().getContentResolver().openFileDescriptor(Uri.parse(str2), "r"));
                }
                return createVideoInfoForFileDescriptor;
            } catch (Exception e16) {
                RFWLog.e("RFWBaseVideoUtils", RFWLog.USR, e16);
                return null;
            }
        }
        String fileIdWithTapPosition = getFileIdWithTapPosition(str2, str);
        QLog.i("RFWBaseVideoUtils", 1, String.format("createSuperVideoInfo fileId:%s, url:%s", fileIdWithTapPosition, str2));
        return createVideoInfo(str2, fileIdWithTapPosition, list, i3);
    }

    public static SuperPlayerVideoInfo createVideoInfo(String str, String str2, List<String> list, int i3) {
        int i16;
        List<String> list2 = null;
        if (TextUtils.isEmpty(str)) {
            QLog.e("RFWBaseVideoUtils", 1, "createVideoInfo url: " + str);
            return null;
        }
        boolean isLocalPath = RFWFileUtils.isLocalPath(str);
        String urlHost = getUrlHost(str);
        if (!isLocalPath && TextUtils.isEmpty(urlHost)) {
            QLog.e("RFWBaseVideoUtils", 1, "createVideoInfo is not native Url and url host is empty");
            return null;
        }
        if (!isLocalPath) {
            list2 = getPlayUrlList(urlHost, str);
        }
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        list2.add(str);
        if (list != null && !list.isEmpty()) {
            list2.addAll(list);
        }
        if (str.contains("flv")) {
            i16 = 202;
        } else if (str.contains("rtmp")) {
            i16 = 103;
        } else if (!str.contains(".m3u8") && !str.contains(".ts")) {
            i16 = 101;
        } else {
            i16 = 102;
        }
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl((String[]) list2.toArray(new String[list2.size()]), i16, str2, "");
        createVideoInfoForUrl.setVideoDurationMs(i3);
        createVideoInfoForUrl.setUrlHostList(new ArrayList<>(Arrays.asList(urlHost)));
        QLog.d("RFWBaseVideoUtils", 1, "createVideoInfo videoUrl: " + createVideoInfoForUrl.getPlayUrl());
        return createVideoInfoForUrl;
    }

    private static String getFileIdWithTapPosition(String str, String str2) {
        try {
            String str3 = Uri.parse(str).getPathSegments().get(0);
            if (str3.contains(".mp4")) {
                return str3.substring(0, str3.indexOf(".mp4"));
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    @NonNull
    private static List<String> getPlayUrlList(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        List<String> ipList = RFWVideoDirectIPHelper.getInstance().getIpList(str, str2.startsWith("https"));
        if (ipList != null && !ipList.isEmpty()) {
            Iterator<String> it = ipList.iterator();
            while (it.hasNext()) {
                String a16 = h.a(str2, str, it.next());
                if (!TextUtils.isEmpty(a16)) {
                    arrayList.add(a16);
                }
            }
        }
        arrayList.add(str2);
        return arrayList;
    }

    public static String getSocialMinSeconds(int i3) {
        String valueOf;
        int i16 = i3 / 1000;
        int i17 = i16 / 60;
        int i18 = i16 % 60;
        if (i17 < 10) {
            valueOf = "0" + i17;
        } else {
            valueOf = String.valueOf(i17);
        }
        if (i18 < 10) {
            return String.format("%s:0%s", valueOf, Integer.valueOf(i18));
        }
        return String.format("%s:%s", valueOf, Integer.valueOf(i18));
    }

    public static int getSocialSeconds(int i3) {
        return i3 / 1000;
    }

    public static String getUrlHost(String str) {
        try {
            return Uri.parse(str).getHost();
        } catch (Exception e16) {
            QLog.e("RFWBaseVideoUtils", 1, "get host failed: " + str + ", error = " + e16.getMessage());
            return null;
        }
    }

    public static boolean shouldVideoYFullScreen(int i3, int i16) {
        float f16 = i16 / i3;
        float intValue = uq3.c.X0("qqcircle", "qqflash_show_vertical_video_max_ratio", 30).intValue() / 10.0f;
        QLog.d("RFWBaseVideoUtils", 1, "setSize origin size shouldFullScreen():" + i16 + "|" + i3 + "|" + f16 + "|" + intValue);
        if (f16 >= intValue) {
            return true;
        }
        return false;
    }
}
