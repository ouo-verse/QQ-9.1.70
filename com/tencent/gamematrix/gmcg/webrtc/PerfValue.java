package com.tencent.gamematrix.gmcg.webrtc;

/* loaded from: classes6.dex */
public class PerfValue implements Cloneable {
    public int accuPacketsLost;
    public long audioBitrate;
    public long audioPacketsFec;
    public int audioPacketsLossPercentage;
    public int audioPacketsLost;
    public long audioPacketsLost2;
    public long audioPacketsMedia;
    public long audioPacketsReceived;
    public long audioPacketsRecovered;
    public long averageBitRate;
    public long averageDecodeTimeMs;
    public double averageFrameRate;
    public long averageRtt;
    public long bitrate;
    public long bytesReceived;
    public String codecType;
    public long dataChannelRtt;
    public double decodeRate;
    public int decodeTimeMs;
    public long firstFrameRenderDelay;
    public long frameHeight;
    public long frameWidth;
    public long framesDecoded;
    public long framesDropped;
    public long framesReceived;
    public long freezeCount;
    public double freezeDuringLast10s;
    public String localIp;
    public double nackRate;
    public int packetsLost;
    public long packetsReceived;
    public long packetsRecoveryByFec;
    public long packetsRecoveryByNack;
    public double perfdogJankDuration;
    public double perfdogPotentialJankDuration;
    public long playTime;
    public long pliCount;
    public long realConcealmentEvents;
    public String remoteIp;
    public short roundTripLatency;
    public long rtt;
    public long stutterLatency;
    public int tag;
    public long timestamp;
    public double totalFreezesDuration;
    public long videoBitrate;
    public long videoBytesReceived;
    public int webrtcNetworkBandwidth = -1;
    public double webrtcNetworkQuality = 5.0d;
    public double perfdogStutter = 0.0d;
    public double fecRate = 0.0d;
    public double fecEff = 0.0d;
    public double recoverRate = 0.0d;
    public double recoverRateTotal = 0.0d;
    public double lostRateNet = 0.0d;
    public double lostRateFinal = 0.0d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PerfValue m110clone() {
        try {
            return (PerfValue) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
