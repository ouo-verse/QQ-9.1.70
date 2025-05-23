package com.tencent.qqlive.module.videoreport;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsNewsFlattenFormatter;
import com.tencent.qqlive.module.videoreport.inner.DefaultLogger;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Configuration {
    private static final String TAG = "sdk_init.Configuration";
    private static volatile Configuration sDefaultInstance;
    private int mAppTimeReportHeartBeatInterval;
    private int mAppTimeReportTimePinInterval;
    private int mAudioEventPolicy;
    private int mAudioReportHeartBeatInterval;
    private int mAudioTimePinInterval;
    private IBizDataProcessor mBizDataProcessor;
    private long mClickReportInterval;
    private Builder mConfigBuilder;
    private Builder mCurrentBuilder;
    private boolean mDefaultDataCollectEnable;
    private ClickPolicy mElementClickPolicy;
    private DTConstants.ClickEventSource mElementClickSource;
    private boolean mElementDetectEnable;
    private EndExposurePolicy mElementEndExposePolicy;
    private ExposurePolicy mElementExposePolicy;
    private double mElementExposureMinRate;
    private long mElementExposureMinTime;
    private DTConstants.ClickEventSource mElementLongClickSource;

    @Deprecated
    private ReportPolicy mElementReportPolicy;
    private EndExposurePolicy mElementScrollEndExposePolicy;
    private ExposurePolicy mElementScrollExposePolicy;
    private Boolean mEnableAndroidXRVCollect;
    private boolean mEnablePageLink;
    private boolean mEnableRemoteConfig;
    private boolean mEnableRemoteSample;
    private boolean mEnableToast;
    private IFormatter mFormatter;
    private boolean mIndependentPageOut;
    private ILogger mLogger;
    private double mPageExposureMinRate;
    private long mPageExposureMinTime;
    private RemoteConfig mRemoteConfig;
    private String mRemoteConfigSceneId;
    private int mVideoHeartBeatInterval;
    private int mVideoPageSwitch;
    private long mVisitBackgroundTime;
    private static final DefaultLogger DEFAULT_LOGGER = new DefaultLogger();
    private static final Builder DEFAULT_BUILDER = new Builder();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Builder {
        private int mAppTimeReportHeartBeatInterval;
        private int mAppTimeReportTimePinInterval;
        private int mAudioEventPolicy;
        private int mAudioTimePinInterval;
        private int mAudioTimeReportHeartBeatInterval;
        private IBizDataProcessor mBizDataProcessor;
        private DTConstants.ClickEventSource mElementClickSource;
        private boolean mElementDetectEnable;
        private EndExposurePolicy mElementEndExposePolicy;
        private ExposurePolicy mElementExposePolicy;
        private DTConstants.ClickEventSource mElementLongClickSource;
        private EndExposurePolicy mElementScrollEndExposePolicy;
        private ExposurePolicy mElementScrollExposePolicy;
        private Boolean mEnableAndroidXRVCollect;
        private boolean mEnablePageLink;
        private boolean mEnableRemoteConfig;
        private boolean mEnableRemoteSample;
        private boolean mEnableToast;
        private IFormatter mFormatter;
        private boolean mIndependentPageOut;
        private int mLazyInitType;
        private ILogger mLogger;
        private RemoteConfig mRemoteConfig;
        private String mRemoteSampleSceneId;
        private int mVideoHeartBeatInterval;
        private int mVideoPageSwitch;
        private boolean mDefaultDataCollectEnable = true;
        private long mVisitBackgroundTime = 900000;
        private long mPageExposureMinTime = 200;
        private double mPageExposureMinRate = 0.4d;
        private long mElementExposureMinTime = 200;
        private double mElementExposureMinRate = 0.01d;
        private long mClickReportInterval = 500;

        @Deprecated
        private ReportPolicy mElementReportPolicy = ReportPolicy.REPORT_POLICY_ALL;
        private ClickPolicy mElementClickPolicy = ClickPolicy.REPORT_ALL;

        public Builder() {
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_FIRST;
            this.mElementExposePolicy = exposurePolicy;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
            this.mElementEndExposePolicy = endExposurePolicy;
            this.mElementScrollExposePolicy = exposurePolicy;
            this.mElementScrollEndExposePolicy = endExposurePolicy;
            this.mLogger = Configuration.DEFAULT_LOGGER;
            this.mIndependentPageOut = false;
            this.mAppTimeReportHeartBeatInterval = 60;
            this.mAppTimeReportTimePinInterval = 5;
            this.mAudioTimeReportHeartBeatInterval = 60;
            this.mAudioTimePinInterval = 5;
            this.mVideoHeartBeatInterval = 300;
            this.mEnablePageLink = false;
            this.mVideoPageSwitch = 0;
            this.mElementDetectEnable = true;
            this.mAudioEventPolicy = 0;
            this.mLazyInitType = 0;
            DTConstants.ClickEventSource clickEventSource = DTConstants.ClickEventSource.METHOND_AFTER;
            this.mElementClickSource = clickEventSource;
            this.mElementLongClickSource = clickEventSource;
            this.mEnableAndroidXRVCollect = Boolean.TRUE;
            this.mRemoteSampleSceneId = "";
        }

        public Builder appTimeReportHeartBeatInterval(int i3) {
            this.mAppTimeReportHeartBeatInterval = i3;
            return this;
        }

        public Builder appTimeReportTimePinInterval(int i3) {
            this.mAppTimeReportTimePinInterval = i3;
            return this;
        }

        public Builder audioEventPolicy(int i3) {
            this.mAudioEventPolicy = i3;
            return this;
        }

        public Builder audioTimePinInterval(int i3) {
            this.mAudioTimePinInterval = i3;
            return this;
        }

        public Builder audioTimeReportHeartBeatInterval(int i3) {
            this.mAudioTimeReportHeartBeatInterval = i3;
            return this;
        }

        public Builder bizDataProcessor(IBizDataProcessor iBizDataProcessor) {
            this.mBizDataProcessor = iBizDataProcessor;
            return this;
        }

        public Configuration build() {
            Configuration configuration = new Configuration(this);
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.i(Configuration.TAG, "build(), buildConfiguration" + configuration);
            }
            return configuration;
        }

        public Builder clickReportInterval(long j3) {
            this.mClickReportInterval = j3;
            return this;
        }

        public Builder defaultDataCollectEnable(boolean z16) {
            this.mDefaultDataCollectEnable = z16;
            return this;
        }

        public Builder elementClickPolicy(ClickPolicy clickPolicy) {
            this.mElementClickPolicy = clickPolicy;
            return this;
        }

        public Builder elementDetectEnable(boolean z16) {
            this.mElementDetectEnable = z16;
            return this;
        }

        public Builder elementEndExposePolicy(EndExposurePolicy endExposurePolicy) {
            this.mElementEndExposePolicy = endExposurePolicy;
            return this;
        }

        public Builder elementExposePolicy(ExposurePolicy exposurePolicy) {
            this.mElementExposePolicy = exposurePolicy;
            return this;
        }

        public Builder elementExposureMinRate(double d16) {
            if (d16 > 1.0d) {
                this.mElementExposureMinRate = 1.0d;
            } else if (d16 < 0.0d) {
                this.mElementExposureMinRate = 0.0d;
            } else {
                this.mElementExposureMinRate = d16;
            }
            return this;
        }

        public Builder elementExposureMinTime(long j3) {
            if (j3 < 0) {
                this.mElementExposureMinTime = 0L;
            } else {
                this.mElementExposureMinTime = j3;
            }
            return this;
        }

        @Deprecated
        public Builder elementReportPolicy(ReportPolicy reportPolicy) {
            ClickPolicy clickPolicy;
            ExposurePolicy exposurePolicy;
            EndExposurePolicy endExposurePolicy;
            if (reportPolicy.reportClick) {
                clickPolicy = ClickPolicy.REPORT_ALL;
            } else {
                clickPolicy = ClickPolicy.REPORT_NONE;
            }
            elementClickPolicy(clickPolicy);
            if (reportPolicy.reportExposure) {
                exposurePolicy = ExposurePolicy.REPORT_ALL;
            } else {
                exposurePolicy = ExposurePolicy.REPORT_NONE;
            }
            elementExposePolicy(exposurePolicy);
            if (reportPolicy.reportExposure) {
                endExposurePolicy = EndExposurePolicy.REPORT_ALL;
            } else {
                endExposurePolicy = EndExposurePolicy.REPORT_NONE;
            }
            elementEndExposePolicy(endExposurePolicy);
            this.mElementReportPolicy = reportPolicy;
            return this;
        }

        public Builder elementScrollEndExposePolicy(EndExposurePolicy endExposurePolicy) {
            this.mElementScrollEndExposePolicy = endExposurePolicy;
            return this;
        }

        public Builder elementScrollExposePolicy(ExposurePolicy exposurePolicy) {
            this.mElementScrollExposePolicy = exposurePolicy;
            return this;
        }

        public Builder enableAndroidXRVCollect(Boolean bool) {
            this.mEnableAndroidXRVCollect = bool;
            return this;
        }

        public Builder enablePageLink(boolean z16) {
            this.mEnablePageLink = z16;
            return this;
        }

        public Builder enableRemoteConfig(boolean z16, RemoteConfig remoteConfig) {
            this.mEnableRemoteConfig = z16;
            this.mRemoteConfig = remoteConfig;
            return this;
        }

        public Builder enableRemoteSample(boolean z16) {
            this.mEnableRemoteSample = z16;
            return this;
        }

        public Builder enableToast(boolean z16) {
            this.mEnableToast = z16;
            return this;
        }

        public Builder formatter(IFormatter iFormatter) {
            this.mFormatter = iFormatter;
            return this;
        }

        public Builder independentPageOut(boolean z16) {
            this.mIndependentPageOut = z16;
            return this;
        }

        public Builder lazyInitType(int i3) {
            this.mLazyInitType = i3;
            return this;
        }

        public Builder logger(ILogger iLogger) {
            this.mLogger = iLogger;
            return this;
        }

        public Builder pageExposureMinRate(double d16) {
            if (d16 > 1.0d) {
                this.mPageExposureMinRate = 1.0d;
            } else if (d16 < 0.0d) {
                this.mPageExposureMinRate = 0.0d;
            } else {
                this.mPageExposureMinRate = d16;
            }
            return this;
        }

        public Builder pageExposureMinTime(long j3) {
            if (j3 < 0) {
                this.mPageExposureMinTime = 0L;
            } else {
                this.mPageExposureMinTime = j3;
            }
            return this;
        }

        public Builder remoteSampleSceneId(String str) {
            this.mRemoteSampleSceneId = str;
            return this;
        }

        public Builder setElementClickSource(DTConstants.ClickEventSource clickEventSource) {
            this.mElementClickSource = clickEventSource;
            return this;
        }

        public Builder setElementLongClickSource(DTConstants.ClickEventSource clickEventSource) {
            this.mElementLongClickSource = clickEventSource;
            return this;
        }

        public Builder setVideoPageSwitch(int i3) {
            this.mVideoPageSwitch = i3;
            return this;
        }

        public Builder videoHeartBeatInterval(int i3) {
            this.mVideoHeartBeatInterval = i3;
            return this;
        }

        public Builder visitBackgroundTime(long j3) {
            if (j3 < 0) {
                this.mVisitBackgroundTime = 0L;
            } else {
                this.mVisitBackgroundTime = j3;
            }
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Configuration getDefault() {
        if (sDefaultInstance == null) {
            synchronized (Configuration.class) {
                if (sDefaultInstance == null) {
                    sDefaultInstance = new Configuration();
                }
            }
        }
        return sDefaultInstance;
    }

    private void setConfig(Builder builder) {
        IFormatter dTParamsNewsFlattenFormatter;
        this.mConfigBuilder = builder;
        this.mDefaultDataCollectEnable = builder.mDefaultDataCollectEnable;
        this.mVisitBackgroundTime = builder.mVisitBackgroundTime;
        this.mPageExposureMinTime = builder.mPageExposureMinTime;
        this.mPageExposureMinRate = builder.mPageExposureMinRate;
        this.mElementExposureMinTime = builder.mElementExposureMinTime;
        this.mElementExposureMinRate = builder.mElementExposureMinRate;
        this.mClickReportInterval = builder.mClickReportInterval;
        this.mElementReportPolicy = builder.mElementReportPolicy;
        this.mElementClickPolicy = builder.mElementClickPolicy;
        this.mElementExposePolicy = builder.mElementExposePolicy;
        this.mElementScrollExposePolicy = builder.mElementScrollExposePolicy;
        this.mElementScrollEndExposePolicy = builder.mElementScrollEndExposePolicy;
        this.mElementEndExposePolicy = builder.mElementEndExposePolicy;
        this.mLogger = builder.mLogger;
        if (builder.mFormatter != null) {
            dTParamsNewsFlattenFormatter = builder.mFormatter;
        } else {
            dTParamsNewsFlattenFormatter = new DTParamsNewsFlattenFormatter();
        }
        this.mFormatter = dTParamsNewsFlattenFormatter;
        this.mIndependentPageOut = builder.mIndependentPageOut;
        this.mAppTimeReportHeartBeatInterval = builder.mAppTimeReportHeartBeatInterval;
        this.mAppTimeReportTimePinInterval = builder.mAppTimeReportTimePinInterval;
        this.mAudioReportHeartBeatInterval = builder.mAudioTimeReportHeartBeatInterval;
        this.mAudioTimePinInterval = builder.mAudioTimePinInterval;
        this.mAudioEventPolicy = builder.mAudioEventPolicy;
        this.mVideoHeartBeatInterval = builder.mVideoHeartBeatInterval;
        this.mEnablePageLink = builder.mEnablePageLink;
        this.mVideoPageSwitch = builder.mVideoPageSwitch;
        this.mEnableToast = builder.mEnableToast;
        this.mElementDetectEnable = builder.mElementDetectEnable;
        this.mElementClickSource = builder.mElementClickSource;
        this.mElementLongClickSource = builder.mElementLongClickSource;
        this.mEnableAndroidXRVCollect = builder.mEnableAndroidXRVCollect;
        this.mEnableRemoteConfig = builder.mEnableRemoteConfig;
        this.mRemoteConfigSceneId = builder.mRemoteSampleSceneId;
        this.mEnableRemoteSample = builder.mEnableRemoteSample;
        this.mRemoteConfig = builder.mRemoteConfig;
        this.mBizDataProcessor = builder.mBizDataProcessor;
        this.mCurrentBuilder = builder;
    }

    public boolean enableAndroidXTVCollect() {
        return this.mEnableAndroidXRVCollect.booleanValue();
    }

    public int getAppTimeReportHeartBeatInterval() {
        return this.mAppTimeReportHeartBeatInterval;
    }

    public int getAppTimeReportTimePinInterval() {
        return this.mAppTimeReportTimePinInterval;
    }

    public int getAudioEventPolicy() {
        return this.mAudioEventPolicy;
    }

    public int getAudioReportHearBeatInterval() {
        return this.mAudioReportHeartBeatInterval;
    }

    public int getAudioTimePinInterval() {
        return this.mAudioTimePinInterval;
    }

    public IBizDataProcessor getBizDataProcessor() {
        return this.mBizDataProcessor;
    }

    public long getClickReportInterval() {
        return this.mClickReportInterval;
    }

    public Builder getCurrentBuilder() {
        return this.mCurrentBuilder;
    }

    public ClickPolicy getElementClickPolicy() {
        return this.mElementClickPolicy;
    }

    public DTConstants.ClickEventSource getElementClickSource() {
        return this.mElementClickSource;
    }

    public EndExposurePolicy getElementEndExposePolicy() {
        return this.mElementEndExposePolicy;
    }

    public ExposurePolicy getElementExposePolicy() {
        return this.mElementExposePolicy;
    }

    public double getElementExposureMinRate() {
        return this.mElementExposureMinRate;
    }

    public long getElementExposureMinTime() {
        return this.mElementExposureMinTime;
    }

    public DTConstants.ClickEventSource getElementLongClickSource() {
        return this.mElementLongClickSource;
    }

    @Deprecated
    public ReportPolicy getElementReportPolicy() {
        return this.mElementReportPolicy;
    }

    public EndExposurePolicy getElementScrollEndExposePolicy() {
        return this.mElementScrollEndExposePolicy;
    }

    public ExposurePolicy getElementScrollExposePolicy() {
        return this.mElementScrollExposePolicy;
    }

    @NonNull
    public IFormatter getFormatter() {
        return this.mFormatter;
    }

    public int getLazyInitType() {
        return this.mConfigBuilder.mLazyInitType;
    }

    @NonNull
    public ILogger getLogger() {
        ILogger iLogger = this.mLogger;
        if (iLogger == null) {
            return DEFAULT_LOGGER;
        }
        return iLogger;
    }

    public double getPageExposureMinRate() {
        return this.mPageExposureMinRate;
    }

    public long getPageExposureMinTime() {
        return this.mPageExposureMinTime;
    }

    public int getVideoHeartBeatInterval() {
        return this.mVideoHeartBeatInterval;
    }

    public int getVideoPageSwitch() {
        return this.mVideoPageSwitch;
    }

    public long getVisitBackgroundTime() {
        return this.mVisitBackgroundTime;
    }

    public boolean isDefaultDataCollectEnable() {
        return this.mDefaultDataCollectEnable;
    }

    public boolean isElementDetectEnable() {
        return this.mElementDetectEnable;
    }

    public boolean isEnablePageLink() {
        return this.mEnablePageLink;
    }

    public boolean isEnableToast() {
        return this.mEnableToast;
    }

    public boolean isIndependentPageOut() {
        return this.mIndependentPageOut;
    }

    public RemoteConfig remoteConfig() {
        return this.mRemoteConfig;
    }

    public boolean remoteConfigEnabled() {
        return this.mEnableRemoteConfig;
    }

    public String remoteConfigSceneId() {
        return this.mRemoteConfigSceneId;
    }

    public boolean remoteSampleEnabled() {
        return this.mEnableRemoteSample;
    }

    public void setDefaultDataCollectEnable(boolean z16) {
        this.mDefaultDataCollectEnable = z16;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Configuration{, mDefaultDataCollectEnable=");
        sb5.append(this.mDefaultDataCollectEnable);
        sb5.append(", mVisitBackgroundTime=");
        sb5.append(this.mVisitBackgroundTime);
        sb5.append(", mPageExposureMinTime=");
        sb5.append(this.mPageExposureMinTime);
        sb5.append(", mPageExposureMinRate=");
        sb5.append(this.mPageExposureMinRate);
        sb5.append(", mElementExposureMinTime=");
        sb5.append(this.mElementExposureMinTime);
        sb5.append(", mElementExposureMinRate=");
        sb5.append(this.mElementExposureMinRate);
        sb5.append(", mElementReportPolicy=");
        sb5.append(this.mElementReportPolicy.name());
        sb5.append(", mElementClickPolicy=");
        sb5.append(this.mElementClickPolicy);
        sb5.append(", mElementExposePolicy=");
        sb5.append(this.mElementExposePolicy);
        sb5.append(", mElementEndExposePolicy=");
        sb5.append(this.mElementEndExposePolicy);
        sb5.append(", mLogger=");
        ILogger iLogger = this.mLogger;
        if (iLogger != null) {
            str = iLogger.getClass().getName();
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append(", mElementDetectEnable=");
        sb5.append(this.mElementDetectEnable);
        sb5.append('}');
        return sb5.toString();
    }

    public void update(@NonNull Configuration configuration) {
        setConfig(configuration.getCurrentBuilder());
    }

    Configuration() {
        this(DEFAULT_BUILDER);
    }

    Configuration(Builder builder) {
        this.mCurrentBuilder = DEFAULT_BUILDER;
        this.mVideoPageSwitch = 0;
        this.mEnableAndroidXRVCollect = Boolean.TRUE;
        this.mRemoteConfigSceneId = "";
        setConfig(builder);
    }
}
