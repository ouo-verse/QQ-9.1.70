package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Reporters {
    public static PerformanceTracer.Visitor detail(final AudioInformation audioInformation, final Map<String, String> map) {
        return new PerformanceTracer.Visitor() { // from class: com.tencent.qqmusic.mediaplayer.perf.Reporters.1
            @Override // com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.Visitor
            public void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> list, PerformanceTracer.OverallInfo overallInfo) {
                long round = Math.round(overallInfo.totalPcmToBePlayed / overallInfo.timeCostInMs);
                long playSample = AudioInformation.this.getPlaySample() * AudioInformation.this.getChannels();
                int i3 = 1;
                if (AudioInformation.this.getBitDepth() != 1) {
                    i3 = 2;
                }
                double d16 = (playSample * i3) / 1000.0d;
                StringBuilder sb5 = new StringBuilder("\n============== Info start ==============\n");
                sb5.append("\u5a92\u4f53\u6587\u4ef6\u4fe1\u606f:\n");
                sb5.append("\t\u64ad\u653e\u65f6\u95f4: ");
                sb5.append(new Date().toString());
                sb5.append("\n");
                sb5.append("\t\u97f3\u9891\u7c7b\u578b: ");
                sb5.append(AudioInformation.this.getAudioType().toString());
                sb5.append("\n");
                sb5.append("\t\u6587\u4ef6\u91c7\u6837\u7387: ");
                sb5.append(AudioInformation.this.getSampleRate());
                sb5.append("\n");
                sb5.append("\t\u64ad\u653e\u91c7\u6837\u7387: ");
                sb5.append(AudioInformation.this.getPlaySample());
                sb5.append("\n");
                sb5.append("\t\u4f4d\u6df1: ");
                sb5.append(AudioInformation.this.getBitDepth());
                sb5.append("\n");
                sb5.append("\t\u58f0\u9053\u6570: ");
                sb5.append(AudioInformation.this.getChannels());
                sb5.append("\n");
                sb5.append("\t\u65f6\u957f: ");
                sb5.append(AudioInformation.this.getDuration());
                sb5.append("\n");
                sb5.append("\n\u6574\u4f53\u6027\u80fd");
                sb5.append("\n");
                sb5.append("\t\u603b\u8017\u65f6 (ms): ");
                sb5.append(overallInfo.timeCostInMs);
                sb5.append("\n");
                sb5.append("\t\u64ad\u653ePCM\u6570\u636e\u91cf (byte): ");
                sb5.append(overallInfo.totalPcmToBePlayed);
                sb5.append("\n");
                sb5.append("\t\u603b\u901f\u5ea6 (byte/ms): ");
                sb5.append(round);
                sb5.append(" (");
                sb5.append(Math.round(round / d16));
                sb5.append(" \u500d\u4e8e\u6700\u4f4e\u8981\u6c42\u901f\u5ea6)");
                sb5.append("\n");
                sb5.append("\t\u6700\u4f4e\u8981\u6c42\u901f\u5ea6 (byte/ms): ");
                sb5.append(d16);
                sb5.append("\n");
                sb5.append("\n\u989d\u5916\u4fe1\u606f:");
                for (Map.Entry entry : map.entrySet()) {
                    sb5.append("\n\t");
                    sb5.append((String) entry.getKey());
                    sb5.append(MsgSummary.STR_COLON);
                    sb5.append((String) entry.getValue());
                }
                sb5.append("\n");
                Reporters.generateDetailedPerformance(list, sb5, overallInfo.timeCostInMs);
                sb5.append("============== Info end ==============");
                Logger.i("PERFORMANCE", sb5.toString());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void generateDetailedPerformance(List<PerformanceTracer.SpeedCheck> list, StringBuilder sb5, long j3) {
        sb5.append("\n\u8be6\u7ec6\u6027\u80fd\u6570\u636e:\n");
        int i3 = 5;
        sb5.append(String.format(Locale.getDefault(), "\t%15s%15s%15s%15s%15s", "\u540d\u79f0", "\u5e73\u5747\u901f\u5ea6(byte/ms)", "\u8017\u65f6(ms)", "\u6570\u636e\u91cf(byte)", "\u5360\u603b\u8017\u65f6\u6bd4"));
        for (PerformanceTracer.SpeedCheck speedCheck : list) {
            sb5.append("\n");
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[i3];
            objArr[0] = speedCheck.getName();
            objArr[1] = Double.valueOf(speedCheck.getAvg());
            objArr[2] = Long.valueOf(speedCheck.getTotalTimeMs());
            objArr[3] = Long.valueOf(speedCheck.getTotalBufferLength());
            objArr[4] = Double.valueOf(speedCheck.getTotalTimeMs() / j3);
            sb5.append(String.format(locale, "\t%15s%15.0f%15d%15d%13.2f", objArr));
            i3 = 5;
        }
        sb5.append("\n");
    }
}
