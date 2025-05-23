package com.tencent.ams.dsdk.monitor.metric.core.inner;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.ams.dsdk.utility.DKCoreSetting;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.monitor.metric.j;
import com.tencent.ams.monitor.metric.l;
import com.tencent.ams.monitor.metric.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class MetricServiceConfig implements l {
    static IPatchRedirector $redirector_ = null;
    private static final int DSDK_BIZ_TYPE = 4;
    private j mLogAdapter;
    private ConcurrentHashMap<String, String> mTagSets;
    private m mThreadManagerAdapter;

    public MetricServiceConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTagSets = initCommonTagSets();
        this.mLogAdapter = new MetricLogAdapter();
        this.mThreadManagerAdapter = new MetricThreadManagerAdapter();
    }

    private String getAdSdkVersion() {
        String str;
        Map<String, String> completeGlobalParams = DynamicUtils.getCompleteGlobalParams();
        if (completeGlobalParams == null) {
            str = null;
        } else {
            str = completeGlobalParams.get("ad_sdk_version");
        }
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        return str;
    }

    private ConcurrentHashMap<String, String> initCommonTagSets() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(TagName.APP_PKG_NAME, replaceEmptyByUnknown(DynamicUtils.getPackageName()));
        concurrentHashMap.put("app_version", replaceEmptyByUnknown(DynamicUtils.getAppVersion()));
        concurrentHashMap.put("sdk_version", replaceEmptyByUnknown(getAdSdkVersion()));
        concurrentHashMap.put(TagName.DSDK_VERSION, DKCoreSetting.SDK_VERSION);
        concurrentHashMap.put("os", "2");
        concurrentHashMap.put("os_version", Build.VERSION.RELEASE);
        concurrentHashMap.put("brand", Build.BRAND);
        concurrentHashMap.put("chid", replaceEmptyByUnknown(DynamicUtils.getApp()));
        return concurrentHashMap;
    }

    private String replaceEmptyByUnknown(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        return str;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public l cloneDeeply() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (l) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        MetricServiceConfig metricServiceConfig = new MetricServiceConfig();
        metricServiceConfig.mTagSets = new ConcurrentHashMap<>(this.mTagSets);
        metricServiceConfig.mLogAdapter = this.mLogAdapter;
        metricServiceConfig.mThreadManagerAdapter = this.mThreadManagerAdapter;
        return metricServiceConfig;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 4;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public ConcurrentHashMap<String, String> getCommonTagSets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mTagSets;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public int getCountThreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return DKConfiguration.getMetricReportConfig().countThreshold;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public long getIntervalMillisThreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return DKConfiguration.getMetricReportConfig().intervalMillisThreshold;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public int getMaxCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return DKConfiguration.getMetricReportConfig().maxCount;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return DKConfiguration.getMetricReportConfig().url;
    }

    @Override // com.tencent.ams.monitor.metric.l
    public WeakReference<j> getWeakLogAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (WeakReference) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new WeakReference<>(this.mLogAdapter);
    }

    @Override // com.tencent.ams.monitor.metric.l
    public WeakReference<m> getWeakThreadManagerAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (WeakReference) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new WeakReference<>(this.mThreadManagerAdapter);
    }
}
