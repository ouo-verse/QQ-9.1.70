package com.tencent.gamematrix.gmcg.webrtc;

/* loaded from: classes6.dex */
public class ReportPerfValue extends PerfValue {
    public double maxDecodeRate;
    public long maxVideoBitrate;
    public long maxVideoJitter;
    public double minDecodeRate;
    public long minVideoBitrate;
    public long minVideoJitter;

    public ReportPerfValue(PerfValue perfValue) {
        copy(perfValue);
        double d16 = perfValue.decodeRate;
        this.minDecodeRate = d16;
        this.maxDecodeRate = d16;
        long j3 = perfValue.videoBitrate;
        this.minVideoBitrate = j3;
        this.maxVideoBitrate = j3;
    }

    public void calculateDataRate(PerfValue perfValue) {
        if (perfValue.timestamp - this.timestamp == 0) {
            this.decodeRate = perfValue.decodeRate;
            this.videoBitrate = perfValue.videoBitrate;
        } else {
            this.decodeRate = Math.abs(((perfValue.framesDecoded - this.framesDecoded) * 1000000.0d) / (r0 - r2));
            this.videoBitrate = Math.abs(((perfValue.videoBytesReceived - this.videoBytesReceived) * 8000) / (perfValue.timestamp - this.timestamp));
        }
    }

    public void copy(PerfValue perfValue) {
        this.firstFrameRenderDelay = perfValue.firstFrameRenderDelay;
        this.decodeTimeMs = perfValue.decodeTimeMs;
        this.decodeRate = perfValue.decodeRate;
        this.bitrate = perfValue.bitrate;
        this.videoBitrate = perfValue.videoBitrate;
        this.framesDecoded = perfValue.framesDecoded;
        this.framesDropped = perfValue.framesDropped;
        this.framesReceived = perfValue.framesReceived;
        this.packetsLost = perfValue.packetsLost;
        this.accuPacketsLost = perfValue.accuPacketsLost;
        this.packetsRecoveryByFec = perfValue.packetsRecoveryByFec;
        this.packetsRecoveryByNack = perfValue.packetsRecoveryByNack;
        this.packetsReceived = perfValue.packetsReceived;
        this.frameWidth = perfValue.frameWidth;
        this.frameHeight = perfValue.frameHeight;
        this.rtt = perfValue.rtt;
        this.webrtcNetworkBandwidth = perfValue.webrtcNetworkBandwidth;
        this.webrtcNetworkQuality = perfValue.webrtcNetworkQuality;
        this.perfdogStutter = perfValue.perfdogStutter;
        this.perfdogJankDuration = perfValue.perfdogJankDuration;
        this.perfdogPotentialJankDuration = perfValue.perfdogPotentialJankDuration;
        this.fecRate = perfValue.fecRate;
        this.recoverRate = perfValue.recoverRate;
        this.lostRateNet = perfValue.lostRateNet;
        this.lostRateFinal = perfValue.lostRateFinal;
        this.averageFrameRate = perfValue.averageFrameRate;
        this.averageDecodeTimeMs = perfValue.averageDecodeTimeMs;
        this.averageBitRate = perfValue.averageBitRate;
        this.averageRtt = perfValue.averageRtt;
        this.bytesReceived = perfValue.bytesReceived;
        this.playTime = perfValue.playTime;
        this.freezeCount = perfValue.freezeCount;
        this.totalFreezesDuration = perfValue.totalFreezesDuration;
        this.freezeDuringLast10s = perfValue.freezeDuringLast10s;
        this.timestamp = perfValue.timestamp;
        this.audioPacketsLost = perfValue.audioPacketsLost;
        this.audioPacketsReceived = perfValue.audioPacketsReceived;
        this.audioPacketsLossPercentage = perfValue.audioPacketsLossPercentage;
        this.audioBitrate = perfValue.audioBitrate;
        this.audioPacketsLost2 = perfValue.audioPacketsLost2;
        this.audioPacketsRecovered = perfValue.audioPacketsRecovered;
        this.audioPacketsFec = perfValue.audioPacketsFec;
        this.audioPacketsMedia = perfValue.audioPacketsMedia;
        this.realConcealmentEvents = perfValue.realConcealmentEvents;
        this.stutterLatency = perfValue.stutterLatency;
        this.tag = perfValue.tag;
        this.codecType = perfValue.codecType;
        this.localIp = perfValue.localIp;
        this.remoteIp = perfValue.remoteIp;
        this.roundTripLatency = perfValue.roundTripLatency;
        this.nackRate = perfValue.nackRate;
    }

    public void updateBound(PerfValue perfValue) {
        this.dataChannelRtt = perfValue.dataChannelRtt;
        this.minDecodeRate = Math.min(perfValue.decodeRate, this.minDecodeRate);
        this.maxDecodeRate = Math.max(perfValue.decodeRate, this.maxDecodeRate);
        this.minVideoBitrate = Math.min(perfValue.videoBitrate, this.minVideoBitrate);
        this.maxVideoBitrate = Math.max(perfValue.videoBitrate, this.maxVideoBitrate);
    }
}
