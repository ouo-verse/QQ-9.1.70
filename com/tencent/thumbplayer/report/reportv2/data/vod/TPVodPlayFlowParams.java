package com.tencent.thumbplayer.report.reportv2.data.vod;

import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;

/* loaded from: classes26.dex */
public class TPVodPlayFlowParams extends TPCommonParams {

    @TPCommonParams.TPReportParam(key = "audiodecoderopenedtimems")
    private long mAudioDecoderOpenedTimeMs;

    @TPCommonParams.TPReportParam(key = "avgstreambitratekbps")
    private long mAvgStreamBitrateKbps;

    @TPCommonParams.TPReportParam(key = "avgvideodecodecosttimems")
    private long mAvgVideoDecodeCostTimeMs;

    @TPCommonParams.TPReportParam(key = "convertdatasourceetimems")
    private long mConvertDataSourceETimeMs;

    @TPCommonParams.TPReportParam(key = "coreapipreparetimems")
    private long mCoreApiPrepareTimeMs;

    @TPCommonParams.TPReportParam(key = "coreschedulingthreadonpreparedtimems")
    private long mCoreSchedulingThreadOnPreparedTimeMs;

    @TPCommonParams.TPReportParam(key = "coreschedulingthreadpreparetimems")
    private long mCoreSchedulingThreadPrepareTimeMs;

    @TPCommonParams.TPReportParam(key = "datatransportcreatetasktimems")
    private long mDTCreateTaskTimeMs;

    @TPCommonParams.TPReportParam(key = "datatransportdataenoughtimems")
    private long mDTDataEnoughTimeMs;

    @TPCommonParams.TPReportParam(key = "datatransportdatarequesttimems")
    private long mDTDataRequestTimeMs;

    @TPCommonParams.TPReportParam(key = "datatransportdataresponsetimems")
    private long mDTDataResponseTimeMs;

    @TPCommonParams.TPReportParam(key = "datatransportgetclipurltimems")
    private long mDTGetClipUrlTimeMs;

    @TPCommonParams.TPReportParam(key = "datatransportm3u8requesttimems")
    private long mDTM3u8RequestTimeMs;

    @TPCommonParams.TPReportParam(key = "datatransportm3u8responsetimems")
    private long mDTM3u8ResponseTimeMs;

    @TPCommonParams.TPReportParam(key = "datatransportsetclipinfotimems")
    private long mDTSetClipInfoTimeMs;

    @TPCommonParams.TPReportParam(key = "demuxeropenfileetimems")
    private long mDemuxerOpenFileEtimems;

    @TPCommonParams.TPReportParam(key = "demuxeropenfilestimems")
    private long mDemuxerOpenFileSTimeMs;

    @TPCommonParams.TPReportParam(key = "demuxerthreadonpreparedtimems")
    private long mDemuxerThreadOnPreparedTimeMs;

    @TPCommonParams.TPReportParam(key = "demuxerthreadpreparetimems")
    private long mDemuxerThreadPrepareTimeMs;

    @TPCommonParams.TPReportParam(key = "firstaudioframerenderetimems")
    private long mFirstAudioFrameRenderETimeMs;

    @TPCommonParams.TPReportParam(key = "firstaudiopacketreadetimems")
    private long mFirstAudioPacketReadETimeMs;

    @TPCommonParams.TPReportParam(key = "firstvideoframerenderetimems")
    private long mFirstVideoFrameRenderETimeMs;

    @TPCommonParams.TPReportParam(key = "firstvideopacketreadetimems")
    private long mFirstVideoPacketReadETimeMs;

    @TPCommonParams.TPReportParam(key = "initfirstclippositionetimems")
    private long mInitFirstClipPositionETimeMs;

    @TPCommonParams.TPReportParam(key = "maxstreambitratekbps")
    private long mMaxStreamBitrateKbps;

    @TPCommonParams.TPReportParam(key = "maxvideodecodecosttimems")
    private long mMaxVideoDecodeCostTimeMs;

    @TPCommonParams.TPReportParam(key = "minstreambitratekbps")
    private long mMinStreamBitrateKbps;

    @TPCommonParams.TPReportParam(key = "minvideodecodecosttimems")
    private long mMinVideoDecodeCostTimeMs;

    @TPCommonParams.TPReportParam(key = "tponpreparedtimems")
    private long mTPOnPreparedTimeMs;

    @TPCommonParams.TPReportParam(key = "tppreparetimems")
    private long mTPPrepareTimeMs;

    @TPCommonParams.TPReportParam(key = "tpsetdatasourcetimems")
    private long mTPSetDataSourceTimeMs;

    @TPCommonParams.TPReportParam(key = "videodecodeframetotalcount")
    private int mVideoDecodeFrameTotalCount;

    @TPCommonParams.TPReportParam(key = "videodecoderopenedtimems")
    private long mVideoDecoderOpenedTimeMs;

    @TPCommonParams.TPReportParam(key = "videorenderframetotalcount")
    private int mVideoRenderFrameTotalCount;

    public long getAudioDecoderOpenedTimeMs() {
        return this.mAudioDecoderOpenedTimeMs;
    }

    public long getAvgStreamBitrateKbps() {
        return this.mAvgStreamBitrateKbps;
    }

    public long getAvgVideoDecodeCostTimeMs() {
        return this.mAvgVideoDecodeCostTimeMs;
    }

    public long getConvertDataSourceETimeMs() {
        return this.mConvertDataSourceETimeMs;
    }

    public long getCoreApiPrepareTimeMs() {
        return this.mCoreApiPrepareTimeMs;
    }

    public long getCoreSchedulingThreadOnPreparedTimeMs() {
        return this.mCoreSchedulingThreadOnPreparedTimeMs;
    }

    public long getCoreSchedulingThreadPrepareTimeMs() {
        return this.mCoreSchedulingThreadPrepareTimeMs;
    }

    public long getDTCreateTaskTimeMs() {
        return this.mDTCreateTaskTimeMs;
    }

    public long getDTDataEnoughTimeMs() {
        return this.mDTDataEnoughTimeMs;
    }

    public long getDTDataRequestTimeMs() {
        return this.mDTDataRequestTimeMs;
    }

    public long getDTDataResponseTimeMs() {
        return this.mDTDataResponseTimeMs;
    }

    public long getDTGetClipUrlTimeMs() {
        return this.mDTGetClipUrlTimeMs;
    }

    public long getDTM3u8RequestTimeMs() {
        return this.mDTM3u8RequestTimeMs;
    }

    public long getDTM3u8ResponseTimeMs() {
        return this.mDTM3u8ResponseTimeMs;
    }

    public long getDTSetClipInfoTimeMs() {
        return this.mDTSetClipInfoTimeMs;
    }

    public long getDemuxerOpenFileEtimems() {
        return this.mDemuxerOpenFileEtimems;
    }

    public long getDemuxerOpenFileSTimeMs() {
        return this.mDemuxerOpenFileSTimeMs;
    }

    public long getDemuxerThreadOnpreparedTimeMs() {
        return this.mDemuxerThreadOnPreparedTimeMs;
    }

    public long getDemuxerThreadPrepareTimeMs() {
        return this.mDemuxerThreadPrepareTimeMs;
    }

    public long getFirstAudioFrameRenderETimeMs() {
        return this.mFirstAudioFrameRenderETimeMs;
    }

    public long getFirstAudioPacketReadETimeMs() {
        return this.mFirstAudioPacketReadETimeMs;
    }

    public long getFirstVideoFrameRenderETimeMs() {
        return this.mFirstVideoFrameRenderETimeMs;
    }

    public long getFirstVideoPacketReadETimeMs() {
        return this.mFirstVideoPacketReadETimeMs;
    }

    public long getInitFirstClipPositionETimeMs() {
        return this.mInitFirstClipPositionETimeMs;
    }

    public long getMaxStreamBitrateKbps() {
        return this.mMaxStreamBitrateKbps;
    }

    public long getMaxVideoDecodeCostTimeMs() {
        return this.mMaxVideoDecodeCostTimeMs;
    }

    public long getMinStreamBitrateKbps() {
        return this.mMinStreamBitrateKbps;
    }

    public long getMinVideoDecodeCostTimeMs() {
        return this.mMinVideoDecodeCostTimeMs;
    }

    public long getTPOnPreparedTimeMs() {
        return this.mTPOnPreparedTimeMs;
    }

    public long getTPPrepareTimeMs() {
        return this.mTPPrepareTimeMs;
    }

    public long getTPSetDataSourceTimeMs() {
        return this.mTPSetDataSourceTimeMs;
    }

    public long getVideoDecodeFrameTotalCount() {
        return this.mVideoDecodeFrameTotalCount;
    }

    public long getVideoDecoderOpenedTimeMs() {
        return this.mVideoDecoderOpenedTimeMs;
    }

    public long getVideoRenderFrameTotalCount() {
        return this.mVideoRenderFrameTotalCount;
    }

    public void setAudioDecoderOpenedTimeMs(long j3) {
        this.mAudioDecoderOpenedTimeMs = j3;
    }

    public void setAvgStreamBitrateKbps(long j3) {
        this.mAvgStreamBitrateKbps = j3;
    }

    public void setAvgVideoDecodeCostTimeMs(long j3) {
        this.mAvgVideoDecodeCostTimeMs = j3;
    }

    public void setConvertDataSourceETimeMs(long j3) {
        this.mConvertDataSourceETimeMs = j3;
    }

    public void setCoreApiPrepareTimeMs(long j3) {
        this.mCoreApiPrepareTimeMs = j3;
    }

    public void setCoreSchedulingThreadOnPreparedTimeMs(long j3) {
        this.mCoreSchedulingThreadOnPreparedTimeMs = j3;
    }

    public void setCoreSchedulingThreadPrepareTimeMs(long j3) {
        this.mCoreSchedulingThreadPrepareTimeMs = j3;
    }

    public void setDTCreateTaskTimeMs(long j3) {
        this.mDTCreateTaskTimeMs = j3;
    }

    public void setDTDataEnoughTimeMs(long j3) {
        this.mDTDataEnoughTimeMs = j3;
    }

    public void setDTDataRequestTimeMs(long j3) {
        this.mDTDataRequestTimeMs = j3;
    }

    public void setDTDataResponseTimeMs(long j3) {
        this.mDTDataResponseTimeMs = j3;
    }

    public void setDTGetClipUrlTimeMs(long j3) {
        this.mDTGetClipUrlTimeMs = j3;
    }

    public void setDTM3u8RequestTimeMs(long j3) {
        this.mDTM3u8RequestTimeMs = j3;
    }

    public void setDTM3u8ResponseTimeMs(long j3) {
        this.mDTM3u8ResponseTimeMs = j3;
    }

    public void setDTSetClipInfoTimeMs(long j3) {
        this.mDTSetClipInfoTimeMs = j3;
    }

    public void setDemuxerOpenFileEtimems(long j3) {
        this.mDemuxerOpenFileEtimems = j3;
    }

    public void setDemuxerOpenFileSTimeMs(long j3) {
        this.mDemuxerOpenFileSTimeMs = j3;
    }

    public void setDemuxerThreadOnPreparedTimeMs(long j3) {
        this.mDemuxerThreadOnPreparedTimeMs = j3;
    }

    public void setDemuxerThreadPrepareTimeMs(long j3) {
        this.mDemuxerThreadPrepareTimeMs = j3;
    }

    public void setFirstAudioFrameRenderETimeMs(long j3) {
        this.mFirstAudioFrameRenderETimeMs = j3;
    }

    public void setFirstAudioPacketReadETimeMs(long j3) {
        this.mFirstAudioPacketReadETimeMs = j3;
    }

    public void setFirstVideoFrameRenderETimeMs(long j3) {
        this.mFirstVideoFrameRenderETimeMs = j3;
    }

    public void setFirstVideoPacketReadETimeMs(long j3) {
        this.mFirstVideoPacketReadETimeMs = j3;
    }

    public void setInitFirstClipPositionETimeMs(long j3) {
        this.mInitFirstClipPositionETimeMs = j3;
    }

    public void setMaxStreamBitrateKbps(long j3) {
        this.mMaxStreamBitrateKbps = j3;
    }

    public void setMaxVideoDecodeCostTimeMs(long j3) {
        this.mMaxVideoDecodeCostTimeMs = j3;
    }

    public void setMinStreamBitrateKbps(long j3) {
        this.mMinStreamBitrateKbps = j3;
    }

    public void setMinVideoDecodeCostTimeMs(long j3) {
        this.mMinVideoDecodeCostTimeMs = j3;
    }

    public void setTPOnPreparedTimeMs(long j3) {
        this.mTPOnPreparedTimeMs = j3;
    }

    public void setTPPrepareTimeMs(long j3) {
        this.mTPPrepareTimeMs = j3;
    }

    public void setTPSetDataSourceTimeMs(long j3) {
        this.mTPSetDataSourceTimeMs = j3;
    }

    public void setVideoDecodeFrameTotalCount(int i3) {
        this.mVideoDecodeFrameTotalCount = i3;
    }

    public void setVideoDecoderOpenedTimeMs(long j3) {
        this.mVideoDecoderOpenedTimeMs = j3;
    }

    public void setVideoRenderFrameTotalCount(int i3) {
        this.mVideoRenderFrameTotalCount = i3;
    }
}
