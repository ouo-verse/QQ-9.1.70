package com.qzone.widget.eventwidget;

import MOBILE_QZMALL_PROTOCOL.DescInfo;
import MOBILE_QZMALL_PROTOCOL.LocationInfo;
import MOBILE_QZMALL_PROTOCOL.VideoInfo;
import MOBILE_QZMALL_PROTOCOL.VideoSpec;
import MOBILE_QZMALL_PROTOCOL.VideoUrl;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b {
    public static boolean a(DescInfo descInfo, DescInfo descInfo2) {
        if (descInfo == descInfo2) {
            return true;
        }
        if (descInfo == null || descInfo2 == null) {
            return false;
        }
        return b(descInfo.stLocationInfo, descInfo2.stLocationInfo) && TextUtils.equals(descInfo.strFontColor, descInfo2.strFontColor) && descInfo.uiFontSize == descInfo2.uiFontSize && TextUtils.equals(descInfo.strDesc, descInfo2.strDesc);
    }

    public static boolean b(LocationInfo locationInfo, LocationInfo locationInfo2) {
        if (locationInfo == locationInfo2) {
            return true;
        }
        if (locationInfo == null || locationInfo2 == null) {
            return false;
        }
        return locationInfo.iLeft == locationInfo2.iLeft && locationInfo.iRight == locationInfo2.iRight && locationInfo.iTop == locationInfo2.iTop && locationInfo.iBottom == locationInfo2.iBottom;
    }

    public static boolean c(VideoInfo videoInfo, VideoInfo videoInfo2) {
        if (videoInfo == videoInfo2) {
            return true;
        }
        if (videoInfo == null || videoInfo2 == null) {
            return false;
        }
        return e(videoInfo.stVideoUrl, videoInfo2.stVideoUrl) && d(videoInfo.stVideoSpec, videoInfo2.stVideoSpec);
    }

    public static boolean d(VideoSpec videoSpec, VideoSpec videoSpec2) {
        if (videoSpec == videoSpec2) {
            return true;
        }
        if (videoSpec == null || videoSpec2 == null) {
            return false;
        }
        return videoSpec.uiDuration == videoSpec2.uiDuration && videoSpec.uiHeight == videoSpec2.uiHeight && videoSpec.uiSize == videoSpec2.uiSize && videoSpec.uiWidth == videoSpec2.uiWidth;
    }

    public static boolean e(VideoUrl videoUrl, VideoUrl videoUrl2) {
        if (videoUrl == videoUrl2) {
            return true;
        }
        if (videoUrl == null || videoUrl2 == null) {
            return false;
        }
        return TextUtils.equals(videoUrl.strContentUrl, videoUrl2.strContentUrl) && TextUtils.equals(videoUrl.strCoverUrl, videoUrl2.strCoverUrl);
    }
}
