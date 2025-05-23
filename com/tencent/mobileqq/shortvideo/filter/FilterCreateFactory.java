package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes18.dex */
public final class FilterCreateFactory {
    private static final HashMap<Integer, String> sTag;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        sTag = hashMap;
        hashMap.put(90, "ART_FILTER");
        hashMap.put(70, "AV_FILTER");
        hashMap.put(20, "BEAUTY");
        hashMap.put(1000, "SCREEN");
        hashMap.put(80, "EFFTECT_FILTER");
        hashMap.put(10, "LOW_LIGHT");
        hashMap.put(100, "2D_MOVIE");
        hashMap.put(120, "DYNAMIC_STICKER");
        hashMap.put(110, "TRACKER_STICKER");
        hashMap.put(13, "IMG_FILTER");
        hashMap.put(160, "VIDEO_TRANSFER");
        hashMap.put(180, "MTV_EFFECT");
        hashMap.put(145, "PIC_GAUSSIAN");
        hashMap.put(150, "PIC_SCALE");
        hashMap.put(181, "TEXT_EJECTA");
        hashMap.put(170, "IMAGE_2_FRAME");
        hashMap.put(183, "GAME_PK");
        hashMap.put(999, "FACE_DETECT");
        hashMap.put(185, "EMOJI_RED_PACK");
    }

    FilterCreateFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static QQBaseFilter createFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        switch (i3) {
            case 10:
                return new QQLowLightFilter(qQFilterRenderManager);
            case 13:
                return new QQImgHazeRmoveFilter(13, qQFilterRenderManager);
            case 20:
                return new QQBeautyFilter(20, qQFilterRenderManager);
            case 70:
                return new QQAVFilter(70, qQFilterRenderManager);
            case 80:
                return new QQSpecialAVFilter(80, qQFilterRenderManager);
            case 90:
                return new QQSVArtFilterNew(90, qQFilterRenderManager);
            case 100:
                return new QQMovieFilter(qQFilterRenderManager);
            case 110:
                return new QQTrackerStickersFilter(110, qQFilterRenderManager);
            case 120:
                return new QQDynamicStickersFilter(120, qQFilterRenderManager);
            case 145:
                return new QQGaussianBlurFilter(145, qQFilterRenderManager);
            case 150:
                return new QQScaleFilter(150, qQFilterRenderManager);
            case 160:
                return new QQTransferFilter(qQFilterRenderManager);
            case 170:
                return new QQImage2FrameFilter(qQFilterRenderManager);
            case 180:
                return new QQMTVFilter(180, qQFilterRenderManager);
            case 181:
                return new QQTextEjectaFilter(181, qQFilterRenderManager);
            case 183:
                return new PKFilter(qQFilterRenderManager);
            case 184:
                return new QQPtColorFilter(qQFilterRenderManager);
            case 185:
                return new QQEmojiRedPackFilter(qQFilterRenderManager);
            case 999:
                return new QQFaceDetect(qQFilterRenderManager);
            case 1000:
                return new QQDrawScreenFilter(1000, qQFilterRenderManager);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getFilterTag(int i3) {
        return sTag.get(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getLogInfo(int[] iArr) {
        if (iArr == null) {
            return "space";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 : iArr) {
            sb5.append(sTag.get(Integer.valueOf(i3)));
            sb5.append(QbAddrData.DATA_SPLITER);
        }
        return sb5.substring(0, sb5.length() - 1);
    }
}
