package cooperation.qzone.statistic.access;

import android.content.Context;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.statistic.access.concept.Collector;
import cooperation.qzone.statistic.access.concept.Condition;
import cooperation.qzone.statistic.access.concept.Global;
import cooperation.qzone.statistic.access.concept.Key;
import cooperation.qzone.statistic.access.concept.Sampler;
import cooperation.qzone.statistic.access.concept.Statistic;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WnsCollector extends Collector {
    private static Context context;
    public static WnsCollector instance = new WnsCollector();
    protected Statistic publicShareInfo = new Statistic(WnsKeys.PublicKeys);
    protected Random sampleRandom;

    public WnsCollector() {
        Condition wnsCondition = new WnsCondition(QZoneConfigHelper.I(), QZoneConfigHelper.H(), true);
        Sampler linearSampler = new LinearSampler(QZoneConfigHelper.J());
        HttpAssembler httpAssembler = new HttpAssembler();
        httpAssembler.setPublicField(this.publicShareInfo);
        WapProxyHttpDeliverer wapProxyHttpDeliverer = new WapProxyHttpDeliverer("https://wspeed.qq.com/w.cgi");
        wapProxyHttpDeliverer.setGZipEnabled(true);
        wapProxyHttpDeliverer.getServers().setOptionalEnabled(true);
        setCondition(wnsCondition);
        setSampler(linearSampler);
        setAssembler(httpAssembler);
        setDeliverer(wapProxyHttpDeliverer);
    }

    public static WnsCollector Instance() {
        if (instance == null) {
            instance = new WnsCollector();
        }
        return instance;
    }

    public Statistic createStatistic() {
        int frequency;
        Statistic statistic = new Statistic(WnsKeys.PrivateKeys);
        statistic.setValue(WnsKeys.DType, 0);
        statistic.setValue(WnsKeys.ODetails, "");
        statistic.setValue(WnsKeys.Timestamp, Long.valueOf(System.currentTimeMillis() / 1000));
        Key key = WnsKeys.Frequency;
        if (getSampler() == null) {
            frequency = 1;
        } else {
            frequency = getSampler().getFrequency();
        }
        statistic.setValue(key, Integer.valueOf(frequency));
        return statistic;
    }

    public Statistic getPublicShareInfo() {
        return this.publicShareInfo;
    }

    public void init(Context context2) {
        Global.setContext(context2);
    }

    public void setPublicShareInfo(String str, String str2, String str3) {
        this.publicShareInfo.setValue(WnsKeys.Device, str);
        this.publicShareInfo.setValue(WnsKeys.SDKVersion, str2);
        this.publicShareInfo.setValue(WnsKeys.DeviceInfo, str3);
    }
}
