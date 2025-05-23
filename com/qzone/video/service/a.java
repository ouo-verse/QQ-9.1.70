package com.qzone.video.service;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.common.config.AppSetting;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {
    public static void a(int i3, String str) {
        StatisticCollector statisticCollector = StatisticCollector.getInstance();
        Statistic statistic = statisticCollector.getStatistic();
        statistic.setValue(WnsKeys.CommandId, "qzoneh5.h5.qzonevideo.compress.get.so.info");
        if (!TextUtils.isEmpty(str)) {
            statistic.setValue(WnsKeys.Detail, str);
        }
        statistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(i3));
        statistic.setValue(WnsKeys.TimeCost, 1);
        statistic.setValue(WnsKeys.AppId, Integer.valueOf(statisticCollector.getAppid()));
        statistic.setValue(WnsKeys.ReleaseVersion, statisticCollector.getReleaseVersion());
        statistic.setValue(WnsKeys.ToUIN, Long.valueOf(LoginData.getInstance().getUin()));
        statistic.setValue(WnsKeys.Qua, QZoneHelper.getQUA());
        statistic.setValue(WnsKeys.Build, AppSetting.f99542b);
        statisticCollector.put(statistic);
        statisticCollector.forceReport();
    }
}
