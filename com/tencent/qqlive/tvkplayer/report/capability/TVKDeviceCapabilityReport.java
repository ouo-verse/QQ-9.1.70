package com.tencent.qqlive.tvkplayer.report.capability;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.report.api.ITVKDeviceCapabilityReport;
import com.tencent.qqlive.tvkplayer.report.api.TVKBeaconReport;
import com.tencent.qqlive.tvkplayer.report.capability.decode.TVKDeviceDecodeCapabilityReportGenerator;
import com.tencent.qqlive.tvkplayer.report.capability.hdr.TVKDeviceHdrCapabilityReportGenerator;
import com.tencent.qqlive.tvkplayer.report.capability.postprocess.TVKDevicePostProcessCapabilityReportGenerator;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportGenerator;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDeviceCapabilityReport implements ITVKDeviceCapabilityReport {
    private static final String CACHE_KEY_LAST_REPORT_TIMESTAMP = "TVKDeviceCapabilityReport_CACHE_KEY_LAST_REPORT_TIMESTAMP";
    private static final String EVENT_ID = "tvkplayer_device_capability_report";
    private static final String TAG = "TVKDeviceCapabilityReport";
    private HashMap<String, ITVKDeviceCapabilityReportGenerator> mDeviceCapabilityTypeToGeneratorMap = new HashMap<>();

    private void allocateDeviceCapabilityGeneratorMapByConfig() {
        this.mDeviceCapabilityTypeToGeneratorMap.clear();
        if (isEnableCapabilityReportByConfig("decoding")) {
            this.mDeviceCapabilityTypeToGeneratorMap.put("decoding", new TVKDeviceDecodeCapabilityReportGenerator());
        }
        if (isEnableCapabilityReportByConfig(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_HDR)) {
            this.mDeviceCapabilityTypeToGeneratorMap.put(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_HDR, new TVKDeviceHdrCapabilityReportGenerator());
        }
        if (isEnableCapabilityReportByConfig(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_SPATIAL_AUDIO)) {
            this.mDeviceCapabilityTypeToGeneratorMap.put(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_SPATIAL_AUDIO, new TVKDeviceSpatialAudioCapabilityReportGenerator());
        }
        if (isEnableCapabilityReportByConfig(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_POST_PROCESS)) {
            this.mDeviceCapabilityTypeToGeneratorMap.put(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_POST_PROCESS, new TVKDevicePostProcessCapabilityReportGenerator());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_device_capability_report) {
            return;
        }
        Context applicationContext = TVKCommParams.getApplicationContext();
        if (applicationContext == null) {
            TVKLogUtil.e(TAG, "[execute] give me a context");
            return;
        }
        LocalCache localCache = LocalCache.get(applicationContext);
        if (localCache == null) {
            TVKLogUtil.e(TAG, "[execute] cannot get local catch instance. There is nothing I can do");
            return;
        }
        try {
            Calendar calendar = (Calendar) localCache.getAsObject(CACHE_KEY_LAST_REPORT_TIMESTAMP);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            if (calendar != null && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1)) {
                TVKLogUtil.i(TAG, "[execute] ignore redundant report");
                return;
            }
            localCache.put(CACHE_KEY_LAST_REPORT_TIMESTAMP, calendar2);
            if (!TVKUtils.isHitting(TVKMediaPlayerConfig.PlayerConfig.device_capability_report_sample_rate)) {
                TVKLogUtil.e(TAG, "[execute] not hitting");
                return;
            }
            TVKProperties tVKProperties = new TVKProperties();
            tVKProperties.put(TVKDeviceCapabilityReportConstant.REPORT_PARAM_CPU_NAME, TVKVcSystemInfo.getCpuChipName());
            tVKProperties.put("device_model", TVKVcSystemInfo.getDeviceModel());
            tVKProperties.put("manufacturer", TVKVcSystemInfo.getManufacturer());
            tVKProperties.put("os_version", TVKVcSystemInfo.getOsVersion());
            tVKProperties.put(TVKDeviceCapabilityReportConstant.REPORT_PARAM_TVK_VERSION, TVKVersion.getPlayerVersion());
            tVKProperties.put("qimei36", TVKCommParams.getQimei36());
            tVKProperties.put("platform", TVKVersion.getPlatform());
            tVKProperties.put("testid", TVKCommParams.getTabPolicyId());
            tVKProperties.put(TVKDeviceCapabilityReportConstant.REPORT_PARAM_DEVICE_CAPABILITY, generateDeviceCapability());
            try {
                TVKBeaconReport.trackCustomKVEvent(EVENT_ID, tVKProperties.getProperties());
            } catch (Exception e16) {
                TVKLogUtil.e(TAG, e16, "[execute] exception while sending report: ");
            }
        } catch (ClassCastException e17) {
            TVKLogUtil.e(TAG, e17, "[execute] cannot get last report calendar: ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAsync() {
        TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.report.capability.TVKDeviceCapabilityReport.2
            @Override // java.lang.Runnable
            public void run() {
                TVKDeviceCapabilityReport.this.execute();
            }
        });
    }

    private void executeAsyncDelayed() {
        TVKThreadPool.getInstance().obtainScheduledExecutorService().schedule(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.report.capability.TVKDeviceCapabilityReport.1
            @Override // java.lang.Runnable
            public void run() {
                TVKDeviceCapabilityReport.this.executeAsync();
            }
        }, TVKMediaPlayerConfig.PlayerConfig.device_capability_report_delay_time_sec, TimeUnit.SECONDS);
    }

    private JSONObject generateDeviceCapability() {
        ITVKDeviceCapabilityReportGenerator value;
        JSONArray generateReportObject;
        JSONObject jSONObject = new JSONObject();
        try {
            allocateDeviceCapabilityGeneratorMapByConfig();
            for (Map.Entry<String, ITVKDeviceCapabilityReportGenerator> entry : this.mDeviceCapabilityTypeToGeneratorMap.entrySet()) {
                if (entry.getKey() != null && (value = entry.getValue()) != null && (generateReportObject = value.generateReportObject()) != null) {
                    jSONObject.put(entry.getKey(), generateReportObject);
                }
            }
        } catch (JSONException e16) {
            TVKLogUtil.e(TAG, e16, "[generateDeviceCapability] there is a exception: ");
        }
        return jSONObject;
    }

    private boolean isEnableCapabilityReportByConfig(String str) {
        return TVKMediaPlayerConfig.PlayerConfig.device_capability_report_sub_switches.contains(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.report.api.ITVKDeviceCapabilityReport
    public void onTVKInitialized() {
        executeAsyncDelayed();
    }
}
