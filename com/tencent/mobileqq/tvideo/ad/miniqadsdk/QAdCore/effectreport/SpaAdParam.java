package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.effectreport;

import com.tencent.qqlive.ona.protocol.jce.AdReport;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes19.dex */
public class SpaAdParam implements Serializable {
    public static final int FROM_APP_CLIENT = 1;
    public static final int FROM_APP_DIRECT = 3;
    public static final int FROM_CONFIRM = 4;
    public static final int FROM_H5 = 2;
    public static final int FROM_H5_AUTO_DOWNLOAD = 7;
    public static final int FROM_LINKAGE = 5;
    public static final int FROM_PRE_AD_DOWNLOAD_GUIDE = 6;
    public String adId;
    public String adPos;
    public AdReport adReport;
    public String adReportKey;
    public String adReportParam;
    public String clickId;
    public int from;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface FROM {
    }
}
