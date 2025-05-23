package com.tencent.mobileqq.emoticon;

/* loaded from: classes12.dex */
public interface IEPRecommendTask {
    public static final String PROMOTION_IMAGE_URL_PREFIX = "https://tianquan.gtimg.cn/";
    public static final String PROMOTION_PUSH_EMOTION = "3";
    public static final String PROMOTION_PUSH_EMOTION_URL = "https://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/xydata.json";

    void runTask();

    IEPRecommendTask setParam(String str, String str2);
}
