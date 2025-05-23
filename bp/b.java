package bp;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.NetworkState;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {
    private static StatisticCollector b(String str, int i3, String str2, int i16, int i17, String str3) {
        StatisticCollector statisticCollector = StatisticCollector.getInstance();
        Statistic statistic = statisticCollector.getStatistic();
        statistic.setValue(WnsKeys.AppId, Integer.valueOf(statisticCollector.getAppid()));
        statistic.setValue(WnsKeys.ReleaseVersion, statisticCollector.getReleaseVersion());
        statistic.setValue(WnsKeys.CommandId, str);
        statistic.setValue(WnsKeys.APN, NetworkState.getAPN());
        statistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(i3));
        try {
            statistic.setValue(WnsKeys.ToUIN, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        statistic.setValue(WnsKeys.Qua, QZoneHelper.getQUA());
        statistic.setValue(WnsKeys.Build, AppSetting.f99542b);
        if (str2 != null) {
            statistic.setValue(WnsKeys.Detail, str2);
        }
        if (i16 > 0) {
            statistic.setValue(WnsKeys.Frequency, Integer.valueOf(i16));
        }
        if (i17 > 0) {
            statistic.setValue(WnsKeys.DType, Integer.valueOf(i17));
            statistic.setValue(WnsKeys.ODetails, str3);
        }
        statisticCollector.put(statistic);
        if (i16 == 1) {
            statisticCollector.forceReport();
        }
        return statisticCollector;
    }

    public static void c(int i3) {
        String str;
        try {
            str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        a("qzonenewservice.maxvideo.record", i3, str, 1);
    }

    public static void d(int i3) {
        String str;
        try {
            str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        a("qzonenewservice.maxvideo.trimvideo", i3, str, 1);
    }

    private static StatisticCollector a(String str, int i3, String str2, int i16) {
        return b(str, i3, str2, i16, 0, null);
    }
}
