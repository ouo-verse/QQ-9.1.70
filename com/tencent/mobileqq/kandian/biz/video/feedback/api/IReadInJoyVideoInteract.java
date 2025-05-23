package com.tencent.mobileqq.kandian.biz.video.feedback.api;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoyVideoInteract extends QRouteApi {
    public static final String BUSINESS_CATEGORY_READINJOY_VIDEO_FEEDS = "readinjoy_video_feeds";
    public static final String INTENT_KEY_READINJOY_ARTICLE_ID = "banner_readinjoy_article_id";
    public static final String INTENT_KEY_READINJOY_IS_WEISHI_MODE = "banner_readinjoy_is_weishi_mode";
    public static final String INTENT_KEY_READINJOY_MD5 = "banner_readinjoy_md5";
    public static final String INTENT_KEY_READINJOY_PUIN = "banner_readinjoy_puin";
    public static final String INTENT_KEY_READINJOY_VID = "banner_readinjoy_vid";

    void handleReadinjoyVideoIntent(BaseQQAppInterface baseQQAppInterface, Intent intent, PendingIntent pendingIntent, String str, String str2);
}
