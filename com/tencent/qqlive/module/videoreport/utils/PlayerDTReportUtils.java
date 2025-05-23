package com.tencent.qqlive.module.videoreport.utils;

import android.support.annotation.NonNull;
import android.util.SparseIntArray;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;

/* loaded from: classes22.dex */
public class PlayerDTReportUtils {
    public static final int LIVE_PAY_STATUS_FALSE = 0;
    public static final int LIVE_PAY_STATUS_TRUE = 1;
    private static final int MODE_EXTRA_URL = 6;
    private static final int MODE_LIVE = 3;
    private static final int MODE_LOCAL = 4;
    private static final int MODE_LOOP_VOD = 7;
    private static final int MODE_OFFLINE = 2;
    private static final int MODE_UNKNOWN = 0;
    private static final int MODE_VOD = 1;
    private static final int MODE_XML_VOD = 9;
    private static final int PAY_TYPE_NO_DEFI = 9;
    private static final int PAY_TYPE_NO_NEED_PAY = 0;
    private static final int PAY_TYPE_PAYED = 2;
    private static final int PAY_TYPE_UNPAYED = 1;
    private static final int TVK_VIDEO_INFO_LIMIT_VALUE_0 = 0;
    private static final int TVK_VIDEO_INFO_LIMIT_VALUE_1 = 1;
    private static final int TVK_VIDEO_INFO_PAY_CH_VALUE_0 = 0;
    private static final int TVK_VIDEO_INFO_STATUS_VALUE_2 = 2;
    private static final int TVK_VIDEO_INFO_STATUS_VALUE_8 = 8;
    private static SparseIntArray sPlaySourceMapping;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sPlaySourceMapping = sparseIntArray;
        sparseIntArray.put(1, 3);
        sPlaySourceMapping.put(2, 1);
        sPlaySourceMapping.put(3, 2);
        sPlaySourceMapping.put(4, 4);
        sPlaySourceMapping.put(5, 6);
        sPlaySourceMapping.put(8, 7);
        sPlaySourceMapping.put(9, 9);
    }

    public static int getPayType(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo instanceof TVKVodVideoInfo) {
            return getPayTypeWithVodInfo((TVKVodVideoInfo) tVKNetVideoInfo);
        }
        if (tVKNetVideoInfo instanceof TVKLiveVideoInfo) {
            return getPayTypeWithLiveInfo((TVKLiveVideoInfo) tVKNetVideoInfo);
        }
        return 9;
    }

    private static int getPayTypeWithLiveInfo(TVKLiveVideoInfo tVKLiveVideoInfo) {
        int paymentStatus = tVKLiveVideoInfo.getPaymentStatus();
        int paymentType = tVKLiveVideoInfo.getPaymentType();
        if (paymentStatus == 0 && 1 == paymentType) {
            return 1;
        }
        if (1 == paymentStatus && 1 == paymentType) {
            return 2;
        }
        return 0;
    }

    private static int getPayTypeWithVodInfo(TVKVodVideoInfo tVKVodVideoInfo) {
        boolean z16;
        boolean z17;
        if (tVKVodVideoInfo.getPayCh() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (tVKVodVideoInfo.getPayCh() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        int st5 = tVKVodVideoInfo.getSt();
        if (8 == st5) {
            return 1;
        }
        if (z16 && 2 == st5) {
            return 2;
        }
        if (z17 && 2 == st5) {
            return 0;
        }
        return 9;
    }

    public static int getPlaySource(@NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        return sPlaySourceMapping.get(tVKPlayerVideoInfo.getPlayType(), 0);
    }
}
