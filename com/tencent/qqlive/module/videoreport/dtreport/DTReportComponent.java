package com.tencent.qqlive.module.videoreport.dtreport;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.IBizDataProcessor;
import com.tencent.qqlive.module.videoreport.ILogger;
import com.tencent.qqlive.module.videoreport.IVideoReportComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.IReporter;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsFlattenFormatter;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsNewsFlattenFormatter;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTAdditionalReportHandler;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTDebugChannel;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTReportAdapter;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.IDetectionInterceptor;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTReportComponent implements IVideoReportComponent {
    private static final String TAG = "DTReportComponent";
    private static final long VISIT_BACKGROUND_TIME = 900000;
    private Configuration mConfiguration;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Builder {
        private Configuration.Builder mConfigurationBuilder;
        private boolean mEnableDebug;
        private IFormatter mFormatter;
        private IDTParamProvider mParamProvider;
        private List<IReporter> mReports;
        private int mElementFormatMode = 1;
        private boolean mEnablePageLink = false;

        Builder(IDTParamProvider iDTParamProvider) {
            if (iDTParamProvider != null) {
                this.mParamProvider = iDTParamProvider;
                this.mConfigurationBuilder = new Configuration.Builder();
                this.mReports = new ArrayList();
                return;
            }
            throw new IllegalArgumentException("dtParamProvider\u4e0d\u53ef\u4e3a\u7a7a");
        }

        public Builder addReporter(IReporter iReporter) {
            this.mReports.add(iReporter);
            return this;
        }

        public Builder appTimeReportHeartBeatInterval(int i3) {
            this.mConfigurationBuilder.appTimeReportHeartBeatInterval(i3);
            return this;
        }

        public Builder appTimeReportTimePinInterval(int i3) {
            this.mConfigurationBuilder.appTimeReportTimePinInterval(i3);
            return this;
        }

        public Builder audioEventPolicy(int i3) {
            this.mConfigurationBuilder.audioEventPolicy(i3);
            return this;
        }

        public Builder audioTimePinInterval(int i3) {
            this.mConfigurationBuilder.audioTimePinInterval(i3);
            return this;
        }

        public Builder audioTimeReportHeartBeatInterval(int i3) {
            this.mConfigurationBuilder.audioTimeReportHeartBeatInterval(i3);
            return this;
        }

        public Builder bizDataProcessor(IBizDataProcessor iBizDataProcessor) {
            this.mConfigurationBuilder.bizDataProcessor(iBizDataProcessor);
            return this;
        }

        public DTReportComponent build() {
            return new DTReportComponent(this);
        }

        @Deprecated
        public Builder dtReport(IDTReport iDTReport) {
            return addReporter(new DTReportAdapter(iDTReport));
        }

        public Builder elementClickPolicy(ClickPolicy clickPolicy) {
            this.mConfigurationBuilder.elementClickPolicy(clickPolicy);
            return this;
        }

        public Builder elementEndExposePolicy(EndExposurePolicy endExposurePolicy) {
            this.mConfigurationBuilder.elementEndExposePolicy(endExposurePolicy);
            return this;
        }

        public Builder elementExposePolicy(ExposurePolicy exposurePolicy) {
            this.mConfigurationBuilder.elementExposePolicy(exposurePolicy);
            return this;
        }

        public Builder elementFormatMode(@DTConfigConstants.ElementFormatMode int i3) {
            this.mElementFormatMode = i3;
            return this;
        }

        public Builder elementScrollEndExposePolicy(EndExposurePolicy endExposurePolicy) {
            this.mConfigurationBuilder.elementScrollEndExposePolicy(endExposurePolicy);
            return this;
        }

        public Builder elementScrollExposePolicy(ExposurePolicy exposurePolicy) {
            this.mConfigurationBuilder.elementScrollExposePolicy(exposurePolicy);
            return this;
        }

        public Builder enableAndroidXRVCollect(boolean z16) {
            this.mConfigurationBuilder.enableAndroidXRVCollect(Boolean.valueOf(z16));
            return this;
        }

        public Builder enableDebug(boolean z16) {
            this.mEnableDebug = z16;
            return this;
        }

        public Builder enableElementDetect(boolean z16) {
            this.mConfigurationBuilder.elementDetectEnable(z16);
            return this;
        }

        public Builder enablePageLink(boolean z16) {
            this.mEnablePageLink = z16;
            return this;
        }

        public Builder enableRemoteConfig(boolean z16, RemoteConfig remoteConfig) {
            this.mConfigurationBuilder.enableRemoteConfig(z16, remoteConfig);
            return this;
        }

        public Builder enableRemoteSample(boolean z16, String str) {
            this.mConfigurationBuilder.enableRemoteSample(z16);
            this.mConfigurationBuilder.remoteSampleSceneId(str);
            return this;
        }

        public Builder enableToast(boolean z16) {
            this.mConfigurationBuilder.enableToast(z16);
            return this;
        }

        public Builder formatter(IFormatter iFormatter) {
            this.mFormatter = iFormatter;
            return this;
        }

        public Builder independentPageOut(boolean z16) {
            this.mConfigurationBuilder.independentPageOut(z16);
            return this;
        }

        public Builder lazyInitType(int i3) {
            this.mConfigurationBuilder.lazyInitType(i3);
            return this;
        }

        public Builder setDetectionInterceptor(IDetectionInterceptor iDetectionInterceptor) {
            VideoReportInner.getInstance().setDetectionInterceptor(iDetectionInterceptor);
            return this;
        }

        public Builder setLogger(ILogger iLogger) {
            this.mConfigurationBuilder.logger(iLogger);
            return this;
        }

        public Builder setVideoPageSwitch(int i3) {
            this.mConfigurationBuilder.setVideoPageSwitch(i3);
            return this;
        }

        public Builder videoHeartBeatInterval(int i3) {
            this.mConfigurationBuilder.videoHeartBeatInterval(i3);
            return this;
        }

        public Builder enableRemoteConfig(boolean z16) {
            this.mConfigurationBuilder.enableRemoteConfig(z16, null);
            return this;
        }
    }

    public static Builder builder(@NonNull IDTParamProvider iDTParamProvider) {
        return new Builder(iDTParamProvider);
    }

    private Configuration createDefaultConfiguration(Builder builder) {
        return builder.mConfigurationBuilder.visitBackgroundTime(900000L).formatter((IFormatter) BaseUtils.nullAs(builder.mFormatter, getFormatter(builder.mElementFormatMode))).enablePageLink(builder.mEnablePageLink).build();
    }

    private IFormatter getFormatter(@DTConfigConstants.ElementFormatMode int i3) {
        if (i3 != 2) {
            return new DTParamsFlattenFormatter();
        }
        return new DTParamsNewsFlattenFormatter();
    }

    private void initVideoReport(Builder builder) {
        VideoReport.setDebugMode(builder.mEnableDebug);
        if (builder.mEnableDebug) {
            VideoReportInner.getInstance().addReporter(new DTDebugChannel());
        }
        VideoReport.addReporters(builder.mReports);
        VideoReport.registerEventDynamicParams(DTEventDynamicParams.getInstance());
        VideoReport.setEventAdditionalReport(DTAdditionalReportHandler.getInstance());
    }

    String checkInputs() {
        Configuration configuration = this.mConfiguration;
        if (configuration == null) {
            return "config is null";
        }
        if (configuration.getAudioTimePinInterval() < 5) {
            return "AudioTimePinInterval value below 5s, may cause performance issues";
        }
        if (this.mConfiguration.getAudioReportHearBeatInterval() < this.mConfiguration.getAudioTimePinInterval()) {
            return "AudioReportHeartBeatInterval can not be less than audioTimePinInterval";
        }
        if (this.mConfiguration.getAppTimeReportTimePinInterval() < 5) {
            return "AppTimeReportTimePinInterval value below 5s, may cause performance issues";
        }
        if (this.mConfiguration.getAppTimeReportHeartBeatInterval() < this.mConfiguration.getAppTimeReportTimePinInterval()) {
            return "AppReportHeartBeatInterval can not be less than appTimePinInterval";
        }
        return "";
    }

    @Override // com.tencent.qqlive.module.videoreport.IVideoReportComponent
    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    DTReportComponent(Builder builder) {
        this.mConfiguration = createDefaultConfiguration(builder);
        initVideoReport(builder);
        DTHandleEventFormatFactory.setElementFormatMode(builder.mElementFormatMode);
        DTEventDynamicParams.getInstance().setDTCommonParams(builder.mParamProvider);
        if (VideoReportInner.getInstance().isDebugMode()) {
            String checkInputs = checkInputs();
            if (!TextUtils.isEmpty(checkInputs)) {
                throw new RuntimeException(checkInputs);
            }
        }
    }
}
