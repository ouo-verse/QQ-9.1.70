package com.tencent.gamematrix.gmcg.webrtc;

import androidx.core.app.NotificationCompat;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.tencwebrtc.DefaultVideoDecoderFactory;
import org.tencwebrtc.RTCStats;
import org.tencwebrtc.RTCStatsReport;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WebRTCStatsCollector {
    private static int REPORT_THRESHOLD = 30;
    private static boolean mCustomizeDecoder = false;
    private static boolean mSkipRender = false;
    private StatsRecord mFirstStatsRecord;
    private StatsRecord mLastStatsRecord;
    private ReportPerfValue markReportPerfValue;
    private ReportCallback reportCallback;
    private ReportPerfValue reportPerfValue;
    final int statCnt = 10;
    double[] freezesDuration = new double[10];
    private String mSelectedCandidatePair = "";
    private VideoCodecType mCodecType = VideoCodecType.UNKNOWN;
    private final HashMap<String, String> mCodecIdMap = new HashMap<>();
    private int curSamplingCnt = 0;
    public final PerfValue perfValue = new PerfValue();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface ReportCallback {
        void onReport(ReportPerfValue reportPerfValue);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class StatsRecord implements Cloneable {
        long audioBytesReceived;
        long audioMaxMediaSeq;
        long audioPacketsFec;
        int audioPacketsLost;
        long audioPacketsMedia;
        long audioPacketsReceived;
        long audioPacketsRecovered;
        long bytesReceived;
        long decodeTimeMs;
        long frameHeight;
        long frameWidth;
        long framesDecoded;
        long framesDropped;
        long framesReceived;
        long freezeCount;
        long maxMediaSeq;
        long nackCount;
        long nackPacketsRecovered;
        long packetsFec;
        int packetsLost;
        long packetsMedia;
        long packetsReceived;
        long packetsRecovered;
        double perfdogJankDuration;
        double perfdogPotentialJankDuration;
        double perfdogStutter;
        long pliCount;
        long realConcealmentEvents;
        long responsesReceived;
        long rtt;
        long timestamp;
        double totalFreezesDuration;
        double totalRoundTripTime;
        long videoBytesReceived;
        double videoJitter;

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public StatsRecord m111clone() {
            try {
                return (StatsRecord) super.clone();
            } catch (CloneNotSupportedException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    public static void customizeDecoder(boolean z16) {
        mCustomizeDecoder = z16;
    }

    public static boolean getSkipRender() {
        return mSkipRender;
    }

    public static void setFrequency(int i3, int i16) {
        REPORT_THRESHOLD = Math.max(1, i16 / i3);
    }

    public static void setSkipRender(boolean z16) {
        mSkipRender = z16;
    }

    private void updateReportPerfValue() {
        ReportPerfValue reportPerfValue = this.markReportPerfValue;
        if (reportPerfValue == null) {
            this.markReportPerfValue = new ReportPerfValue(this.perfValue);
            this.curSamplingCnt++;
            return;
        }
        reportPerfValue.updateBound(this.perfValue);
        int i3 = this.curSamplingCnt;
        if (i3 < REPORT_THRESHOLD - 1) {
            this.curSamplingCnt = i3 + 1;
            return;
        }
        this.markReportPerfValue.calculateDataRate(this.perfValue);
        this.markReportPerfValue.copy(this.perfValue);
        ReportPerfValue reportPerfValue2 = this.markReportPerfValue;
        this.reportPerfValue = reportPerfValue2;
        this.markReportPerfValue = null;
        this.curSamplingCnt = 0;
        ReportCallback reportCallback = this.reportCallback;
        if (reportCallback != null) {
            reportCallback.onReport(reportPerfValue2);
        }
    }

    public VideoCodecType getCodecType() {
        return this.mCodecType;
    }

    public ReportPerfValue getReportPerfValue() {
        return this.reportPerfValue;
    }

    public void onStatsDelivered(RTCStatsReport rTCStatsReport) {
        StatsRecord statsRecord;
        String str;
        Iterator<Map.Entry<String, RTCStats>> it;
        Map.Entry<String, RTCStats> entry;
        String str2;
        BigInteger bigInteger;
        String str3;
        WebRTCStatsCollector webRTCStatsCollector = this;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        StatsRecord statsRecord2 = webRTCStatsCollector.mLastStatsRecord;
        if (statsRecord2 != null) {
            statsRecord = statsRecord2.m111clone();
        } else {
            statsRecord = new StatsRecord();
        }
        statsRecord.timestamp = (long) rTCStatsReport.getTimestampUs();
        Map<String, RTCStats> statsMap = rTCStatsReport.getStatsMap();
        Iterator<Map.Entry<String, RTCStats>> it5 = statsMap.entrySet().iterator();
        while (true) {
            boolean hasNext = it5.hasNext();
            str = NotificationCompat.CATEGORY_TRANSPORT;
            if (!hasNext) {
                break;
            }
            Map.Entry<String, RTCStats> next = it5.next();
            Map<String, Object> members = next.getValue().getMembers();
            String type = next.getValue().getType();
            if (NotificationCompat.CATEGORY_TRANSPORT.equalsIgnoreCase(type) && "connected".equals(members.get("dtlsState"))) {
                webRTCStatsCollector.mSelectedCandidatePair = (String) members.get("selectedCandidatePairId");
                break;
            }
            if ("candidate-pair".equalsIgnoreCase(type)) {
                String id5 = next.getValue().getId();
                String str4 = (String) members.get("remoteCandidateId");
                String str5 = (String) members.get("localCandidateId");
                if (str4 != null) {
                    hashMap.put(id5, str4);
                }
                if (str5 != null) {
                    hashMap2.put(id5, str5);
                }
            }
            if ("local-candidate".equalsIgnoreCase(type)) {
                String id6 = next.getValue().getId();
                String str6 = (String) members.get("ip");
                if (str6 != null) {
                    hashMap4.put(id6, str6);
                }
            }
            if ("remote-candidate".equalsIgnoreCase(type)) {
                String id7 = next.getValue().getId();
                String str7 = (String) members.get("ip");
                if (str7 != null) {
                    hashMap3.put(id7, str7);
                }
            }
        }
        String str8 = (String) hashMap2.get(webRTCStatsCollector.mSelectedCandidatePair);
        if (str8 != null) {
            webRTCStatsCollector.perfValue.localIp = (String) hashMap4.get(str8);
        }
        String str9 = (String) hashMap.get(webRTCStatsCollector.mSelectedCandidatePair);
        if (str9 != null) {
            webRTCStatsCollector.perfValue.remoteIp = (String) hashMap3.get(str9);
        }
        if (webRTCStatsCollector.mCodecIdMap.size() == 0) {
            for (Map.Entry<String, RTCStats> entry2 : statsMap.entrySet()) {
                Map<String, Object> members2 = entry2.getValue().getMembers();
                if ("codec".equals(entry2.getValue().getType())) {
                    webRTCStatsCollector.mCodecIdMap.put(entry2.getValue().getId(), (String) members2.get("mimeType"));
                }
            }
        }
        Iterator<Map.Entry<String, RTCStats>> it6 = statsMap.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry<String, RTCStats> next2 = it6.next();
            Map<String, Object> members3 = next2.getValue().getMembers();
            String type2 = next2.getValue().getType();
            String str10 = (String) members3.get("kind");
            if ("inbound-rtp".equalsIgnoreCase(type2) && "video".equalsIgnoreCase(str10)) {
                Long l3 = (Long) members3.get("packetsReceived");
                it = it6;
                entry = next2;
                if (l3 != null) {
                    statsRecord.packetsReceived = l3.longValue();
                }
                Integer num = (Integer) members3.get("packetsLost");
                if (num != null) {
                    statsRecord.packetsLost = num.intValue();
                }
                BigInteger bigInteger2 = (BigInteger) members3.get("bytesReceived");
                if (bigInteger2 != null) {
                    statsRecord.videoBytesReceived = bigInteger2.longValue();
                }
                Long l16 = (Long) members3.get("nackCount");
                if (l16 != null) {
                    statsRecord.nackCount = l16.longValue();
                }
                Long l17 = (Long) members3.get("pliCount");
                if (l17 != null) {
                    statsRecord.pliCount = l17.longValue();
                }
                Double d16 = (Double) members3.get("jitter");
                if (d16 != null) {
                    statsRecord.videoJitter = d16.doubleValue();
                }
                if (webRTCStatsCollector.mCodecType == VideoCodecType.UNKNOWN && webRTCStatsCollector.mCodecIdMap.size() != 0 && (str3 = webRTCStatsCollector.mCodecIdMap.get((String) members3.get("codecId"))) != null) {
                    if (str3.contains("H264")) {
                        webRTCStatsCollector.mCodecType = VideoCodecType.H264;
                    } else if (str3.contains("H265")) {
                        webRTCStatsCollector.mCodecType = VideoCodecType.H265;
                    }
                }
            } else {
                it = it6;
                entry = next2;
            }
            if (str.equalsIgnoreCase(type2) && (bigInteger = (BigInteger) members3.get("bytesReceived")) != null) {
                statsRecord.bytesReceived = bigInteger.longValue();
            }
            if ("inbound-rtp".equalsIgnoreCase(type2) && "audio".equalsIgnoreCase(str10)) {
                Long l18 = (Long) members3.get("packetsReceived");
                str2 = str;
                if (l18 != null) {
                    statsRecord.audioPacketsReceived = l18.longValue();
                }
                Integer num2 = (Integer) members3.get("packetsLost");
                if (num2 != null) {
                    statsRecord.audioPacketsLost = num2.intValue();
                }
                BigInteger bigInteger3 = (BigInteger) members3.get("bytesReceived");
                if (bigInteger3 != null) {
                    statsRecord.audioBytesReceived = bigInteger3.longValue();
                }
            } else {
                str2 = str;
            }
            if ("track".equalsIgnoreCase(type2) && "video".equalsIgnoreCase(str10)) {
                Long l19 = (Long) members3.get("frameWidth");
                if (l19 != null) {
                    statsRecord.frameWidth = l19.longValue();
                }
                Long l26 = (Long) members3.get("frameHeight");
                if (l26 != null) {
                    statsRecord.frameHeight = l26.longValue();
                }
                Long l27 = (Long) members3.get("framesReceived");
                if (l27 != null) {
                    statsRecord.framesReceived = l27.longValue();
                }
                Long l28 = (Long) members3.get("framesDecoded");
                if (l28 != null) {
                    statsRecord.framesDecoded = l28.longValue();
                }
                Long l29 = (Long) members3.get("framesDropped");
                if (l29 != null) {
                    statsRecord.framesDropped = l29.longValue();
                }
                Long l36 = (Long) members3.get("decodeTimeMs");
                if (l36 != null) {
                    statsRecord.decodeTimeMs = l36.longValue();
                }
                Long l37 = (Long) members3.get("freezeCount");
                if (l37 != null) {
                    statsRecord.freezeCount = l37.longValue();
                }
                Double d17 = (Double) members3.get("totalFreezesDuration");
                if (d17 != null) {
                    statsRecord.totalFreezesDuration = d17.doubleValue();
                }
                Double d18 = (Double) members3.get("perfdogStutter");
                if (d18 != null) {
                    statsRecord.perfdogStutter = d18.doubleValue();
                }
                Double d19 = (Double) members3.get("perfdogJankDuration");
                if (d19 != null) {
                    statsRecord.perfdogJankDuration = d19.doubleValue();
                }
                Double d26 = (Double) members3.get("perfdogPotentialJankDuration");
                if (d26 != null) {
                    statsRecord.perfdogPotentialJankDuration = d26.doubleValue();
                }
                BigInteger bigInteger4 = (BigInteger) members3.get("videoPacketsFec");
                if (bigInteger4 != null) {
                    statsRecord.packetsFec = bigInteger4.longValue();
                }
                BigInteger bigInteger5 = (BigInteger) members3.get("videoPacketsRecovered");
                if (bigInteger5 != null) {
                    statsRecord.packetsRecovered = bigInteger5.longValue();
                }
                Long l38 = (Long) members3.get("videoNackPacketsRecovered");
                if (l38 != null) {
                    statsRecord.nackPacketsRecovered = l38.longValue();
                }
                BigInteger bigInteger6 = (BigInteger) members3.get("videoPacketsMedia");
                if (bigInteger6 != null) {
                    statsRecord.packetsMedia = bigInteger6.longValue();
                }
                BigInteger bigInteger7 = (BigInteger) members3.get("videoMaxMediaSeq");
                if (bigInteger7 != null) {
                    statsRecord.maxMediaSeq = bigInteger7.longValue();
                }
            }
            if ("track".equalsIgnoreCase(type2) && "audio".equalsIgnoreCase(str10)) {
                BigInteger bigInteger8 = (BigInteger) members3.get("audioPacketsFec");
                if (bigInteger8 != null) {
                    statsRecord.audioPacketsFec = bigInteger8.longValue();
                }
                BigInteger bigInteger9 = (BigInteger) members3.get("audioPacketsRecovered");
                if (bigInteger9 != null) {
                    statsRecord.audioPacketsRecovered = bigInteger9.longValue();
                }
                BigInteger bigInteger10 = (BigInteger) members3.get("audioPacketsMedia");
                if (bigInteger10 != null) {
                    statsRecord.audioPacketsMedia = bigInteger10.longValue();
                }
                BigInteger bigInteger11 = (BigInteger) members3.get("audioMaxMediaSeq");
                if (bigInteger11 != null) {
                    statsRecord.audioMaxMediaSeq = bigInteger11.longValue();
                }
                BigInteger bigInteger12 = (BigInteger) members3.get("realConcealmentEvents");
                if (bigInteger12 != null) {
                    statsRecord.realConcealmentEvents = bigInteger12.longValue();
                }
            }
            if ("candidate-pair".equalsIgnoreCase(type2) && entry.getKey().equals(webRTCStatsCollector.mSelectedCandidatePair)) {
                Double d27 = (Double) members3.get("currentRoundTripTime");
                if (d27 != null) {
                    statsRecord.rtt = (long) (d27.doubleValue() * 1000.0d);
                }
                Double d28 = (Double) members3.get("totalRoundTripTime");
                if (d28 != null) {
                    statsRecord.totalRoundTripTime = d28.doubleValue();
                }
                BigInteger bigInteger13 = (BigInteger) members3.get("responsesReceived");
                if (bigInteger13 != null) {
                    statsRecord.responsesReceived = bigInteger13.longValue();
                }
            }
            it6 = it;
            str = str2;
        }
        if (getSkipRender()) {
            if (!mCustomizeDecoder) {
                statsRecord.decodeTimeMs = DefaultVideoDecoderFactory.getDecodeTimeMs();
                statsRecord.frameWidth = DefaultVideoDecoderFactory.getFrameWidth();
                statsRecord.frameHeight = DefaultVideoDecoderFactory.getFrameHeight();
                long framesDecoded = DefaultVideoDecoderFactory.getFramesDecoded();
                statsRecord.framesDecoded = framesDecoded;
                statsRecord.framesDropped = statsRecord.framesReceived - framesDecoded;
            } else {
                statsRecord.decodeTimeMs = CustomizedVideoDecoderFactory.getDecodeTimeMs();
                statsRecord.frameWidth = CustomizedVideoDecoderFactory.getFrameWidth();
                statsRecord.frameHeight = CustomizedVideoDecoderFactory.getFrameHeight();
                long framesDecoded2 = CustomizedVideoDecoderFactory.getFramesDecoded();
                statsRecord.framesDecoded = framesDecoded2;
                statsRecord.framesDropped = statsRecord.framesReceived - framesDecoded2;
            }
        }
        if (webRTCStatsCollector.mFirstStatsRecord == null) {
            webRTCStatsCollector.mFirstStatsRecord = statsRecord;
        }
        StatsRecord statsRecord3 = webRTCStatsCollector.mLastStatsRecord;
        if (statsRecord3 != null) {
            PerfValue perfValue = webRTCStatsCollector.perfValue;
            perfValue.framesReceived = statsRecord.framesReceived;
            long j3 = statsRecord.framesDecoded;
            perfValue.framesDecoded = j3;
            perfValue.framesDropped = statsRecord.framesDropped;
            perfValue.packetsLost = statsRecord.packetsLost;
            perfValue.packetsReceived = statsRecord.packetsReceived;
            perfValue.audioPacketsLost = statsRecord.audioPacketsLost;
            perfValue.audioPacketsReceived = statsRecord.audioPacketsReceived;
            perfValue.frameWidth = statsRecord.frameWidth;
            perfValue.frameHeight = statsRecord.frameHeight;
            perfValue.pliCount = statsRecord.pliCount;
            long j16 = statsRecord.timestamp;
            long j17 = statsRecord3.timestamp;
            if (j16 != j17) {
                perfValue.decodeRate = ((j3 - statsRecord3.framesDecoded) * 1000000.0d) / (j16 - j17);
                perfValue.bitrate = (((statsRecord.bytesReceived - statsRecord3.bytesReceived) * 8) * 1000) / (j16 - j17);
                perfValue.videoBitrate = (((statsRecord.videoBytesReceived - statsRecord3.videoBytesReceived) * 8) * 1000) / (j16 - j17);
                perfValue.audioBitrate = (((statsRecord.audioBytesReceived - statsRecord3.audioBytesReceived) * 8) * 1000) / (j16 - j17);
            }
            long j18 = statsRecord3.framesDecoded;
            if (j3 != j18) {
                perfValue.decodeTimeMs = (int) ((statsRecord.decodeTimeMs - statsRecord3.decodeTimeMs) / (j3 - j18));
            }
            perfValue.rtt = statsRecord.rtt;
            if (j16 != j17) {
                long j19 = j16 - j17;
                perfValue.averageFrameRate = ((j3 - j18) * 1000000.0d) / j19;
                perfValue.averageBitRate = (((statsRecord.bytesReceived - statsRecord3.bytesReceived) * 8) * 1000) / j19;
            }
            long j26 = statsRecord.responsesReceived;
            if (j26 != 0) {
                perfValue.averageRtt = ((long) (statsRecord.totalRoundTripTime * 1000.0d)) / j26;
            }
            if (j3 != 0) {
                perfValue.averageDecodeTimeMs = statsRecord.decodeTimeMs / j3;
            }
            perfValue.bytesReceived = statsRecord.bytesReceived;
            perfValue.videoBytesReceived = statsRecord.videoBytesReceived;
            perfValue.playTime = ((j16 - webRTCStatsCollector.mFirstStatsRecord.timestamp) / 1000000) + 1;
            perfValue.freezeCount = statsRecord.freezeCount;
            double d29 = statsRecord.totalFreezesDuration;
            perfValue.totalFreezesDuration = d29;
            perfValue.freezeDuringLast10s = d29 - webRTCStatsCollector.freezesDuration[9];
            perfValue.perfdogStutter = statsRecord.perfdogStutter;
            perfValue.perfdogJankDuration = statsRecord.perfdogJankDuration;
            perfValue.perfdogPotentialJankDuration = statsRecord.perfdogPotentialJankDuration;
            for (int i3 = 9; i3 > 0; i3--) {
                double[] dArr = webRTCStatsCollector.freezesDuration;
                dArr[i3] = dArr[i3 - 1];
            }
            double[] dArr2 = webRTCStatsCollector.freezesDuration;
            PerfValue perfValue2 = webRTCStatsCollector.perfValue;
            dArr2[0] = perfValue2.totalFreezesDuration;
            int i16 = statsRecord.audioPacketsLost;
            StatsRecord statsRecord4 = webRTCStatsCollector.mLastStatsRecord;
            int i17 = statsRecord4.audioPacketsLost;
            long j27 = (i16 - i17) + (statsRecord.audioPacketsReceived - statsRecord4.audioPacketsReceived);
            if (j27 != 0) {
                perfValue2.audioPacketsLossPercentage = (int) (((i16 - i17) * 100) / j27);
            }
            if (statsRecord.packetsReceived > 0) {
                perfValue2.nackRate = (((float) (statsRecord.nackCount - statsRecord4.nackCount)) * 1.0f) / ((float) r6);
            }
            long j28 = statsRecord.packetsMedia - statsRecord4.packetsMedia;
            long j29 = statsRecord.maxMediaSeq - statsRecord4.maxMediaSeq;
            long j36 = statsRecord.packetsFec - statsRecord4.packetsFec;
            long j37 = statsRecord.packetsRecovered - statsRecord4.packetsRecovered;
            long j38 = j29 - j28;
            long j39 = j38 - j37;
            long j46 = j28 + j36;
            if (j46 > 0) {
                perfValue2.fecRate = j36 / j46;
            }
            if (j36 > 0) {
                perfValue2.fecEff = j37 / j36;
            }
            if (j38 > 0) {
                perfValue2.recoverRate = j37 / j38;
            }
            if (j29 > 0) {
                double d36 = j29;
                perfValue2.lostRateNet = j38 / d36;
                perfValue2.lostRateFinal = j39 / d36;
            }
            int i18 = (int) (perfValue2.accuPacketsLost + j38);
            perfValue2.accuPacketsLost = i18;
            long j47 = perfValue2.packetsRecoveryByFec + j37;
            perfValue2.packetsRecoveryByFec = j47;
            perfValue2.packetsRecoveryByNack = statsRecord.nackPacketsRecovered;
            if (i18 > 0) {
                perfValue2.recoverRateTotal = j47 / i18;
            }
            perfValue2.realConcealmentEvents = statsRecord.realConcealmentEvents - statsRecord4.realConcealmentEvents;
            long j48 = statsRecord.audioPacketsMedia - statsRecord4.audioPacketsMedia;
            perfValue2.audioPacketsMedia = j48;
            perfValue2.audioPacketsFec = statsRecord.audioPacketsFec - statsRecord4.audioPacketsFec;
            perfValue2.audioPacketsRecovered = statsRecord.audioPacketsRecovered - statsRecord4.audioPacketsRecovered;
            perfValue2.audioPacketsLost2 = (statsRecord.audioMaxMediaSeq - statsRecord4.audioMaxMediaSeq) - j48;
            perfValue2.timestamp = statsRecord.timestamp;
            webRTCStatsCollector = this;
            perfValue2.codecType = webRTCStatsCollector.mCodecType.mimeType();
        }
        webRTCStatsCollector.mLastStatsRecord = statsRecord;
        updateReportPerfValue();
    }

    public void onStatsStop() {
        this.markReportPerfValue.calculateDataRate(this.perfValue);
        this.markReportPerfValue.copy(this.perfValue);
        ReportPerfValue reportPerfValue = this.markReportPerfValue;
        this.reportPerfValue = reportPerfValue;
        this.markReportPerfValue = null;
        this.curSamplingCnt = 0;
        ReportCallback reportCallback = this.reportCallback;
        if (reportCallback != null) {
            reportCallback.onReport(reportPerfValue);
        }
    }

    public void setReportCallback(ReportCallback reportCallback) {
        this.reportCallback = reportCallback;
    }
}
