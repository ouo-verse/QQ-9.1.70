package com.tencent.tav.report;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.MediaCodecManager;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes26.dex */
public class CodecPerfReportSession {
    private static final int FRAME_TIME_CONSUME_THRESHOLD = 100;
    private static final String TAG = "CodecPerfReportHelper";

    @Nullable
    private static IReporter reporter;
    private RenderContextParams renderContextParams;
    private final AverageCalculator averageCalculator = new AverageCalculator();
    private long frameDropCount = 0;
    private final LinkedHashSet<String> currentSessionCodecNames = new LinkedHashSet<>();
    private int softVideoDecoderCount = 0;
    private int maxCodecCount = 0;

    public CodecPerfReportSession() {
        MediaCodecManager.addCodecPerfReportSession(this);
    }

    private static synchronized void notifyReporter(RenderContextParams renderContextParams, HashMap<String, String> hashMap) {
        synchronized (CodecPerfReportSession.class) {
            IReporter iReporter = reporter;
            if (iReporter != null) {
                iReporter.onReport(renderContextParams, hashMap);
            }
        }
    }

    private synchronized void putCodecInfoToMap(HashMap<String, String> hashMap) {
        String str;
        hashMap.put("max_codec_count", String.valueOf(this.maxCodecCount));
        hashMap.put("codec_names", String.valueOf(this.currentSessionCodecNames));
        if (this.softVideoDecoderCount > 0) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("use_soft_video_decoder", str);
        hashMap.put("soft_video_decoder_count", String.valueOf(this.softVideoDecoderCount));
    }

    public static synchronized void setReporter(@Nullable IReporter iReporter) {
        synchronized (CodecPerfReportSession.class) {
            reporter = iReporter;
        }
    }

    public void flush() {
        MediaCodecManager.removeCodecPerfReportSession(this);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tav_player_avg_frame_time_cons_ms", String.valueOf(this.averageCalculator.getAvg()));
        hashMap.put("frame_drop_count", String.valueOf(this.frameDropCount));
        putCodecInfoToMap(hashMap);
        Logger.d(TAG, "flush: map = " + hashMap);
        notifyReporter(this.renderContextParams, hashMap);
    }

    public void onCodecCreated(List<String> list, MediaCodec mediaCodec) {
        if (list.size() > this.maxCodecCount) {
            this.maxCodecCount = list.size();
        }
        String name = mediaCodec.getName();
        this.currentSessionCodecNames.add(name);
        if (!CodecHelper.isHardwareByName(name) && CodecHelper.isVideoCodec(mediaCodec.getCodecInfo())) {
            Logger.i(TAG, "onCodecCreated: SoftVideoDecoder = " + name);
            this.softVideoDecoderCount = this.softVideoDecoderCount + 1;
        }
    }

    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.renderContextParams = renderContextParams;
    }

    public void tickFrameTimeConsume(long j3) {
        if (j3 > 100) {
            this.frameDropCount++;
        }
        this.averageCalculator.tick(j3);
    }
}
