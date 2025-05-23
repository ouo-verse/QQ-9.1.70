package com.tencent.mobileqq.qzoneplayer.video;

import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.VideoUrlValidator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class t {
    public static boolean a(SegmentVideoInfo.StreamInfo streamInfo) {
        String str;
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        VideoUrlValidator videoUrlValidator = new VideoUrlValidator();
        if (streamInfo == null || (arrayList = streamInfo.segmentInfos) == null || arrayList.size() <= 0) {
            str = "";
        } else {
            str = c(streamInfo.segmentInfos.get(0).url);
        }
        boolean isIPV6 = PlayerUtils.isIPV6(str);
        PlayerUtils.log(3, "VideoUtils", "" + str + ", isFirstSegUrlIPv6" + isIPV6);
        if (isIPV6 || videoUrlValidator.isValid(streamInfo)) {
            return true;
        }
        PlayerUtils.log(6, "VideoUtils", "illegal video info " + streamInfo);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("detail_url", streamInfo.toString());
        FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_ILLEGAL_VIDEO_INFO, hashMap);
        if (!FeedVideoEnv.externalFunc.isDebugVersion()) {
            return true;
        }
        FeedVideoEnv.externalFunc.showToast("DEBUG: \u89c6\u9891\u64ad\u653e\u5931\u8d25\uff0cURL\u683c\u5f0f\u975e\u6cd5");
        return true;
    }

    public static String b() {
        String str;
        int networkType = FeedVideoEnv.externalFunc.getNetworkType(PlayerConfig.g().getAppContext());
        if (networkType == 0) {
            str = "UNKNOWN";
        } else if (networkType == 1) {
            str = Global.TRACKING_WIFI;
        } else if (networkType == 2) {
            str = "3G";
        } else if (networkType == 3) {
            str = "2G";
        } else if (networkType == 4) {
            str = "4G";
        } else {
            str = "\u5176\u5b83";
        }
        int iPStackType = PlayerConfig.g().getIPStackType();
        if (iPStackType == -1) {
            return str + ":\u672a\u77e5";
        }
        if (iPStackType == 0) {
            return str + ":\u65e0\u7f51\u7edc";
        }
        if (iPStackType == 1) {
            return str + ":IPv4";
        }
        if (iPStackType == 2) {
            return str + ":IPv6,";
        }
        if (iPStackType != 3) {
            return str + ":\u9ed8\u8ba4,";
        }
        return str + ":IPv6\u53cc\u6808";
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e16) {
            PlayerUtils.log(5, "VideoUtils", "getHost error", e16);
            return null;
        }
    }

    public static void d(View view, float f16) {
        if (view == null) {
            return;
        }
        view.setAlpha(f16);
    }
}
