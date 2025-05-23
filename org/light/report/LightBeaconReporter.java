package org.light.report;

import android.content.Context;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconInitException;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import com.tencent.qimei.sdk.QimeiSDK;
import java.util.Map;
import org.light.LightEngine;
import org.light.device.LightDeviceUtils;
import org.light.utils.LightLogUtil;
import org.light.utils.ThreadUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightBeaconReporter implements LightReportInterface {
    private final String APPKEY;
    private final boolean REPORT_DEBUG;
    private final String channel;
    private final String version;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class SingletonHolder {
        private static LightBeaconReporter instance = new LightBeaconReporter();

        SingletonHolder() {
        }
    }

    public static LightBeaconReporter getInstance() {
        return SingletonHolder.instance;
    }

    public LightBeaconReporter init(final Context context) {
        ThreadUtils.executeTask(new Runnable() { // from class: org.light.report.LightBeaconReporter.1
            @Override // java.lang.Runnable
            public void run() {
                LightLogUtil.e("LightBeaconReporter", "qimeiSDK init complete = " + QimeiSDK.getInstance("0AND0WH9714UPYKY").setChannelID("10000000").setAppVersion("3.1.5.1").init(context));
                BeaconConfig build = BeaconConfig.builder().setNormalPollingTime(10000L).setRealtimePollingTime(10000L).setModel(LightDeviceUtils.getBuildModel()).build();
                BeaconReport beaconReport = BeaconReport.getInstance();
                beaconReport.setChannelID("0AND0WH9714UPYKY", "10000000");
                try {
                    beaconReport.start(context, "0AND0WH9714UPYKY", build);
                } catch (BeaconInitException e16) {
                    LightLogUtil.e("LightBeaconReporter", "[\u706f\u5854\u4e0a\u62a5]\u521d\u59cb\u5316\u5931\u8d25\uff1a" + e16.getMessage());
                }
            }
        });
        return getInstance();
    }

    @Override // org.light.report.LightReportInterface
    public void report(final String str, final Map<String, String> map) {
        ThreadUtils.executeTask(new Runnable() { // from class: org.light.report.LightBeaconReporter.2
            @Override // java.lang.Runnable
            public void run() {
                map.put("lightsdk_version", LightEngine.getSdkVersion());
                map.put("app_id", LightEngine.appID());
                map.put("entry", LightEngine.appEntry());
                BeaconReport.getInstance().report(BeaconEvent.builder().withCode(str).withType(EventType.NORMAL).withParams(map).withAppKey("0AND0WH9714UPYKY").build());
            }
        });
    }

    LightBeaconReporter() {
        this.APPKEY = "0AND0WH9714UPYKY";
        this.version = "0.1.1";
        this.channel = "10000000";
        this.REPORT_DEBUG = false;
    }
}
