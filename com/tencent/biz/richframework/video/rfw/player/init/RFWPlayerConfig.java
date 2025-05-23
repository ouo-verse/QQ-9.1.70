package com.tencent.biz.richframework.video.rfw.player.init;

import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWOptionsProcessCallback;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerFeedConverter;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerFieldIdToLocalPath;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerPreRenderCallBack;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerProcessOrder;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerReportCallback;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerVideoConverter;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerVideoHistoryPoiFetch;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWTVKPlayerOptionFetch;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import java.util.List;

/* loaded from: classes5.dex */
public class RFWPlayerConfig {
    private List<Class<IRFWPlayerOptionsProcess>> mBusinessProcess;
    private IRFWPlayerFeedConverter mFeedConvert;
    private IRFWPlayerFieldIdToLocalPath mFieldToLocalPath;
    private List<Class<RFWPlayerBaseInterceptor>> mInterceptor;
    private IRFWOptionsProcessCallback mPlayerOptionsProcessCallback;
    private IRFWPlayerPreRenderCallBack mPlayerRenderCallBack;
    private IRFWPlayerReportCallback mPlayerReportCallback;
    private IRFWPlayerProcessOrder mPreloaderOrder;
    private ISPBandwidthPredictor mSpBandPredictor;
    private IRFWTVKPlayerOptionFetch mTVKPlayerOptionFetch;
    private IRFWPlayerVideoConverter mVideoConvert;
    private IRFWPlayerVideoHistoryPoiFetch mVideoHistoryPoiFetch;

    /* loaded from: classes5.dex */
    public static class RFWPlayerInitBuilder {
        private List<Class<IRFWPlayerOptionsProcess>> mBusinessProcess;
        private IRFWPlayerFeedConverter mFeedConvert;
        private IRFWPlayerFieldIdToLocalPath mFieldToLocalPath;
        private List<Class<RFWPlayerBaseInterceptor>> mInterceptor;
        private IRFWOptionsProcessCallback mPlayerOptionsProcessCallback;
        private IRFWPlayerPreRenderCallBack mPlayerRenderCallBack;
        private IRFWPlayerReportCallback mPlayerReportCallback;
        private IRFWPlayerProcessOrder mProcessOrder;
        private ISPBandwidthPredictor mSpBandPredictor;
        private IRFWTVKPlayerOptionFetch mTVKPlayerOptionFetch;
        private IRFWPlayerVideoConverter mVideoConvert;
        private IRFWPlayerVideoHistoryPoiFetch mVideoHistoryPoiFetch;

        public RFWPlayerConfig build() {
            RFWPlayerConfig rFWPlayerConfig = new RFWPlayerConfig();
            rFWPlayerConfig.mInterceptor = this.mInterceptor;
            rFWPlayerConfig.mSpBandPredictor = this.mSpBandPredictor;
            rFWPlayerConfig.mBusinessProcess = this.mBusinessProcess;
            rFWPlayerConfig.mFieldToLocalPath = this.mFieldToLocalPath;
            rFWPlayerConfig.mVideoConvert = this.mVideoConvert;
            rFWPlayerConfig.mPreloaderOrder = this.mProcessOrder;
            rFWPlayerConfig.mFeedConvert = this.mFeedConvert;
            rFWPlayerConfig.mVideoHistoryPoiFetch = this.mVideoHistoryPoiFetch;
            rFWPlayerConfig.mTVKPlayerOptionFetch = this.mTVKPlayerOptionFetch;
            rFWPlayerConfig.mPlayerRenderCallBack = this.mPlayerRenderCallBack;
            rFWPlayerConfig.mPlayerOptionsProcessCallback = this.mPlayerOptionsProcessCallback;
            rFWPlayerConfig.mPlayerReportCallback = this.mPlayerReportCallback;
            return rFWPlayerConfig;
        }

        public RFWPlayerInitBuilder setBusinessUrlProcess(List<Class<IRFWPlayerOptionsProcess>> list) {
            this.mBusinessProcess = list;
            return this;
        }

        public RFWPlayerInitBuilder setFieldToLocalPathConfig(IRFWPlayerFieldIdToLocalPath iRFWPlayerFieldIdToLocalPath) {
            this.mFieldToLocalPath = iRFWPlayerFieldIdToLocalPath;
            return this;
        }

        public RFWPlayerInitBuilder setIDataConvert(IRFWPlayerVideoConverter iRFWPlayerVideoConverter) {
            this.mVideoConvert = iRFWPlayerVideoConverter;
            return this;
        }

        public RFWPlayerInitBuilder setIFeedConvert(IRFWPlayerFeedConverter iRFWPlayerFeedConverter) {
            this.mFeedConvert = iRFWPlayerFeedConverter;
            return this;
        }

        public RFWPlayerInitBuilder setInterceptor(List<Class<RFWPlayerBaseInterceptor>> list) {
            this.mInterceptor = list;
            return this;
        }

        public RFWPlayerInitBuilder setPlayerOptionsProcessCallback(IRFWOptionsProcessCallback iRFWOptionsProcessCallback) {
            this.mPlayerOptionsProcessCallback = iRFWOptionsProcessCallback;
            return this;
        }

        public RFWPlayerInitBuilder setPlayerRenderCallBack(IRFWPlayerPreRenderCallBack iRFWPlayerPreRenderCallBack) {
            this.mPlayerRenderCallBack = iRFWPlayerPreRenderCallBack;
            return this;
        }

        public RFWPlayerInitBuilder setPlayerReportCallback(IRFWPlayerReportCallback iRFWPlayerReportCallback) {
            this.mPlayerReportCallback = iRFWPlayerReportCallback;
            return this;
        }

        public RFWPlayerInitBuilder setProcessOrder(IRFWPlayerProcessOrder iRFWPlayerProcessOrder) {
            this.mProcessOrder = iRFWPlayerProcessOrder;
            return this;
        }

        public RFWPlayerInitBuilder setSPBandwidthPredictor(ISPBandwidthPredictor iSPBandwidthPredictor) {
            this.mSpBandPredictor = iSPBandwidthPredictor;
            return this;
        }

        public RFWPlayerInitBuilder setTVKVideoPlayerOptionFetch(IRFWTVKPlayerOptionFetch iRFWTVKPlayerOptionFetch) {
            this.mTVKPlayerOptionFetch = iRFWTVKPlayerOptionFetch;
            return this;
        }

        public RFWPlayerInitBuilder setVideoHistoryPoiFetch(IRFWPlayerVideoHistoryPoiFetch iRFWPlayerVideoHistoryPoiFetch) {
            this.mVideoHistoryPoiFetch = iRFWPlayerVideoHistoryPoiFetch;
            return this;
        }
    }

    RFWPlayerConfig() {
    }

    public List<Class<IRFWPlayerOptionsProcess>> getBusinessProcess() {
        return this.mBusinessProcess;
    }

    public IRFWPlayerFeedConverter getFeedConvert() {
        return this.mFeedConvert;
    }

    public IRFWPlayerFieldIdToLocalPath getFieldToLocalPath() {
        return this.mFieldToLocalPath;
    }

    public List<Class<RFWPlayerBaseInterceptor>> getInterceptor() {
        return this.mInterceptor;
    }

    public IRFWPlayerPreRenderCallBack getPlayerPreRenderCallBack() {
        return this.mPlayerRenderCallBack;
    }

    public IRFWOptionsProcessCallback getPlayerProcessCallback() {
        return this.mPlayerOptionsProcessCallback;
    }

    public IRFWPlayerReportCallback getPlayerReportCallback() {
        return this.mPlayerReportCallback;
    }

    public IRFWPlayerProcessOrder getProcessOrder() {
        return this.mPreloaderOrder;
    }

    public ISPBandwidthPredictor getSpBandPredictor() {
        return this.mSpBandPredictor;
    }

    public IRFWTVKPlayerOptionFetch getTVKVideoPlayerOptionFetch() {
        return this.mTVKPlayerOptionFetch;
    }

    public IRFWPlayerVideoConverter getVideoConvert() {
        return this.mVideoConvert;
    }

    public IRFWPlayerVideoHistoryPoiFetch getVideoPoiFetch() {
        return this.mVideoHistoryPoiFetch;
    }
}
