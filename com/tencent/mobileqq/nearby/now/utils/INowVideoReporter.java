package com.tencent.mobileqq.nearby.now.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INowVideoReporter extends QRouteApi {
    public static final String TAG = "dc02676";

    INowVideoReporter LvInd1();

    INowVideoReporter count(int i3);

    INowVideoReporter d1(String str);

    INowVideoReporter d2(String str);

    INowVideoReporter d3(String str);

    INowVideoReporter d4(String str);

    INowVideoReporter feed_type(String str);

    INowVideoReporter feedid(String str);

    INowVideoReporter genderInd1();

    String getAnchorUin();

    String getFeedId();

    String getFeedType();

    String getFrom();

    long getPlayTimeBegin();

    int getRePlayCount();

    INowVideoReporter networktype(String str);

    INowVideoReporter opIn(int i3);

    INowVideoReporter opName(String str);

    INowVideoReporter opResult(int i3);

    INowVideoReporter opType(String str);

    void report(AppInterface appInterface);

    void reportByVideo(AppInterface appInterface);

    void setAnchorUin(String str);

    void setFeedId(String str);

    void setFeedType(String str);

    void setFrom(String str);

    void setPlayTimeBegin(long j3);

    void setRePlayCount(int i3);

    INowVideoReporter source(String str);

    INowVideoReporter timelong(String str);

    INowVideoReporter toUin(String str);
}
