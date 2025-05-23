package com.tencent.ttpic.logic.watermark;

import android.media.AudioRecord;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.util.AudioUtil;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DecibelDetector {
    private static final int DECIBEL_UPDATE_INTERVAL = 40;
    private static final int[] SAMPLE_RATE_IN_HZ = {32000, 16000};
    private static final String TAG = "DecibelDetector";
    private static DecibelDetector mInstance;
    private int BUFFER_SIZE;
    private short[] buffer;
    private AudioRecord mAudioRecorder;
    private int mDecibel;
    private int sampleRateInHZ;
    private Timer timer;
    private final Object lock = new Object();
    private FFTData mFFTDataResult = new FFTData();
    private boolean mIsAudioRecordPermission = true;

    DecibelDetector() {
        int i3 = 1;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int[] iArr = SAMPLE_RATE_IN_HZ;
            if (i16 >= iArr.length || i17 > 0) {
                break;
            }
            int i18 = iArr[i16];
            this.sampleRateInHZ = i18;
            i17 = AudioRecord.getMinBufferSize(i18, 1, 2);
            i16++;
        }
        if (i17 <= 0) {
            ReportUtil.report("DecibelDetector no support SampleRate");
        } else {
            i3 = i17;
        }
        this.BUFFER_SIZE = i3;
        this.buffer = new short[i3];
    }

    public static synchronized DecibelDetector getInstance() {
        DecibelDetector decibelDetector;
        synchronized (DecibelDetector.class) {
            if (mInstance == null) {
                mInstance = new DecibelDetector();
            }
            decibelDetector = mInstance;
        }
        return decibelDetector;
    }

    public void destroy() {
        stop();
        synchronized (this.lock) {
            try {
                AudioRecord audioRecord = this.mAudioRecorder;
                if (audioRecord != null) {
                    audioRecord.stop();
                    this.mAudioRecorder.release();
                    this.mAudioRecorder = null;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                AudioRecord audioRecord2 = this.mAudioRecorder;
                if (audioRecord2 != null) {
                    audioRecord2.release();
                    this.mAudioRecorder = null;
                }
            }
        }
    }

    public int getDecibel() {
        return this.mDecibel;
    }

    public FFTData getFFTResult() {
        return this.mFFTDataResult;
    }

    public void init() {
        if (this.mAudioRecorder == null && this.mIsAudioRecordPermission) {
            synchronized (this.lock) {
                startRecord();
            }
        }
    }

    public void resetPermission() {
        this.mIsAudioRecordPermission = true;
    }

    public void startRecord() {
        try {
            if (this.mAudioRecorder == null) {
                this.mAudioRecorder = new AudioRecord(1, this.sampleRateInHZ, 1, 2, this.BUFFER_SIZE);
            }
        } catch (IllegalArgumentException e16) {
            LogUtils.e(e16);
        }
        try {
            AudioMonitor.startRecording(this.mAudioRecorder);
            if (this.timer == null) {
                this.timer = new BaseTimer();
                this.timer.schedule(new TimerTask() { // from class: com.tencent.ttpic.logic.watermark.DecibelDetector.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        synchronized (DecibelDetector.this.lock) {
                            if (DecibelDetector.this.mAudioRecorder == null) {
                                return;
                            }
                            int read = DecibelDetector.this.mAudioRecorder.read(DecibelDetector.this.buffer, 0, DecibelDetector.this.BUFFER_SIZE);
                            if (read <= 1) {
                                return;
                            }
                            DecibelDetector decibelDetector = DecibelDetector.this;
                            decibelDetector.mDecibel = AudioUtil.getPcmDBFromShortBuffer(decibelDetector.buffer, read);
                            LogUtils.d(DecibelDetector.TAG, "[decibel] = " + DecibelDetector.this.mDecibel + ", capture size = " + read);
                            AudioUtil.getPcmFFTFromShortBuffer(DecibelDetector.this.buffer, read, DecibelDetector.this.mFFTDataResult);
                        }
                    }
                }, 0L, 40L);
            }
        } catch (IllegalStateException e17) {
            e17.printStackTrace();
            this.mAudioRecorder = null;
            this.mIsAudioRecordPermission = false;
        }
    }

    public void stop() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }
}
