package cooperation.qzone.statistic;

import android.os.Build;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.statistic.access.WnsCollector;
import cooperation.qzone.statistic.access.concept.Statistic;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes28.dex */
public class StatisticCollector {
    private AtomicBoolean inited = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class H {
        private static final StatisticCollector instance = new StatisticCollector();

        H() {
        }
    }

    private String getDevice() {
        return DeviceInfoMonitor.getModel() + "(" + Build.VERSION.RELEASE + ")";
    }

    public static StatisticCollector getInstance() {
        if (!H.instance.inited.get()) {
            synchronized (StatisticCollector.class) {
                if (!H.instance.inited.get()) {
                    H.instance.init();
                }
            }
        }
        return H.instance;
    }

    private String getSDKVersion() {
        return Build.VERSION.SDK;
    }

    private void init() {
        if (this.inited.get()) {
            return;
        }
        WnsCollector.Instance().init(BaseApplication.getContext());
        WnsCollector.Instance().setPublicShareInfo(getDevice(), getSDKVersion(), ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getDeviceInfor());
        WnsCollector.Instance().startWork();
        this.inited.set(true);
    }

    public void forceReport() {
        WnsCollector.Instance().forceDeliver();
    }

    public int getAppid() {
        return 1000027;
    }

    public String getReleaseVersion() {
        return ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getVersionForHabo();
    }

    public Statistic getStatistic() {
        return WnsCollector.Instance().createStatistic();
    }

    public void put(Statistic statistic) {
        WnsCollector.Instance().collect(statistic);
    }

    public void reportImmediate() {
        WnsCollector.Instance().forceDeliver();
        WnsCollector.Instance().flush();
    }
}
