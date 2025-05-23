package com.tencent.qqlive.module.videoreport.report;

import android.os.Build;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.IPublicParamInterface;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SystemUtils;
import com.tencent.qqlive.module.videoreport.visual.debug.VisualDebugManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
public class PublicParamImpl implements IPublicParamInterface {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static final PublicParamImpl INSTANCE = new PublicParamImpl();

        InstanceHolder() {
        }
    }

    public static PublicParamImpl getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void addNonRealtimeExternalParams(Map<String, Object> map) {
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setNonRealtimePublicDynamicParams(map);
        }
    }

    public void addNonRealtimeInnerParam(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        map.put("os", "1");
        map.put(ParamKey.REPORT_KEY_OS_VRSN, "Android " + Build.VERSION.RELEASE);
        map.put(ParamKey.REPORT_KEY_UI_VRSN, SystemUtils.getSystemUI());
    }

    public void addRealtimeExternalParams(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Map<String, Object> publicParam = VideoReportInner.getInstance().getPublicParam();
        if (publicParam != null) {
            map.putAll(publicParam);
        }
        IEventDynamicParams eventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
        if (eventDynamicParams != null) {
            eventDynamicParams.setRealtimePublicDynamicParams(map);
        }
    }

    public void addRealtimeInnerParam(Map<String, Object> map) {
        String str;
        if (map == null) {
            return;
        }
        map.put(ParamKey.REPORT_KEY_USID, AppEventReporter.getInstance().getUsId());
        map.put(ParamKey.REPORT_KEY_US_STMP, Long.valueOf(AppEventReporter.getInstance().getUsStamp()));
        map.put(ParamKey.REPORT_KEY_USSN, Long.valueOf(AppEventReporter.getInstance().getUssn()));
        if (AppEventReporter.getInstance().isColdStart()) {
            str = "1";
        } else {
            str = "0";
        }
        map.put(ParamKey.REPORT_KEY_COLD_START, str);
        map.put(ParamKey.REPORT_KEY_APP_VR, ReportUtils.getPackageVersionName());
        map.put(ParamKey.REPORT_KEY_APP_BLD, Integer.valueOf(ReportUtils.getPackageVersionCode()));
    }

    public void addStatisticsInnerParam(String str, String str2, Map<String, Object> map) {
        if (map == null) {
            return;
        }
        EventStatisticsManager.getInstance().addStatisticsInnerParam(str, str2, map);
    }

    public void addVisualDebugInnerParam(Object obj, Map<String, Object> map) {
        if (map == null) {
            return;
        }
        VisualDebugManager.getInstance().addVisualDebugParams(obj, map);
    }

    @Override // com.tencent.qqlive.module.videoreport.IPublicParamInterface
    public long getColdSessionStamp() {
        return AppEventReporter.getInstance().getColdUsStamp();
    }

    @Override // com.tencent.qqlive.module.videoreport.IPublicParamInterface
    public Map<String, Object> getPublicParams() {
        HashMap hashMap = new HashMap();
        addRealtimeInnerParam(hashMap);
        addNonRealtimeInnerParam(hashMap);
        addRealtimeExternalParams(hashMap);
        addNonRealtimeExternalParams(hashMap);
        return hashMap;
    }

    @Override // com.tencent.qqlive.module.videoreport.IPublicParamInterface
    public String getSessionId() {
        return AppEventReporter.getInstance().getUsId();
    }

    @Override // com.tencent.qqlive.module.videoreport.IPublicParamInterface
    public long getSessionStamp() {
        return AppEventReporter.getInstance().getUsStamp();
    }

    PublicParamImpl() {
    }
}
