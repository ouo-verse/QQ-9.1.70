package com.tencent.tav.core.audio;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioExportTask implements IAudioExportTask {
    private static final String TAG = "AudioExportTask";
    private IAudioSource<? extends IDecoderTrack> mAsset;
    private ExportCallback mCallback;
    private String mOutSavePath;
    private int mSegmentCount = 0;
    private String mSessionId = new Random().nextLong() + "";
    private CopyOnWriteArrayList<AudioExportRunner> mEncoderList = new CopyOnWriteArrayList<>();
    private HashMap<Integer, SegmentStatus> mProgressMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class SegmentStatus {
        private float mProgress;
        private int mStatus;
        private CMTimeRange mTimeRange;

        public SegmentStatus(int i3, float f16) {
            this.mStatus = i3;
            this.mProgress = f16;
        }

        public CMTimeRange getTimeRange() {
            return this.mTimeRange;
        }

        public void setTimeRange(CMTimeRange cMTimeRange) {
            this.mTimeRange = cMTimeRange;
        }
    }

    public AudioExportTask(IAudioSource<? extends IDecoderTrack> iAudioSource, String str) {
        this.mAsset = iAudioSource;
        this.mOutSavePath = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SegmentStatus createOrUpdateSegmentStatus(int i3, int i16, float f16) {
        Logger.d(TAG, "createOrUpdateSegmentStatus index = " + i3 + " mStatus = " + i16 + " mProgress = " + f16);
        if (this.mProgressMap.containsKey(Integer.valueOf(i3))) {
            SegmentStatus segmentStatus = this.mProgressMap.get(Integer.valueOf(i3));
            segmentStatus.mProgress = f16;
            segmentStatus.mStatus = i16;
            return segmentStatus;
        }
        SegmentStatus segmentStatus2 = new SegmentStatus(i16, f16);
        this.mProgressMap.put(Integer.valueOf(i3), segmentStatus2);
        return segmentStatus2;
    }

    private SegmentStatus createSegmentStatus(int i3, CMTimeRange cMTimeRange) {
        SegmentStatus segmentStatus = new SegmentStatus(0, 0.0f);
        segmentStatus.mTimeRange = cMTimeRange;
        this.mProgressMap.put(Integer.valueOf(i3), segmentStatus);
        return segmentStatus;
    }

    private void exportAudio(CMTimeRange cMTimeRange, final int i3) {
        Logger.d(TAG, "exportAudio timeRange = " + cMTimeRange + " index = " + i3);
        AudioExportRunner audioExportRunner = new AudioExportRunner(this.mAsset, cMTimeRange);
        audioExportRunner.setSavePath(EncoderUtils.getAudioOutSaveFilePath(this.mOutSavePath, i3, this.mSessionId));
        audioExportRunner.setCallback(new ExportCallback() { // from class: com.tencent.tav.core.audio.AudioExportTask.1
            @Override // com.tencent.tav.core.audio.ExportCallback
            public void onProgress(int i16, float f16) {
                synchronized (AudioExportTask.this) {
                    AudioExportTask.this.createOrUpdateSegmentStatus(i3, i16, f16);
                    AudioExportTask.this.notifyProgressAndStatusUpdate();
                }
            }
        });
        try {
            audioExportRunner.prepare();
            audioExportRunner.start();
            this.mEncoderList.add(audioExportRunner);
        } catch (IOException e16) {
            Logger.e(TAG, "exportAudio: ", e16);
        } catch (Exception e17) {
            Logger.e(TAG, "exportAudio: \u672a\u77e5\u5f02\u5e38\uff0c\u8bf7\u7559\u610f", e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyProgressAndStatusUpdate() {
        if (this.mProgressMap.size() == 0) {
            return;
        }
        float f16 = this.mSegmentCount;
        StringBuilder sb5 = new StringBuilder("[");
        float f17 = 0.0f;
        int i3 = 0;
        int i16 = 0;
        for (SegmentStatus segmentStatus : this.mProgressMap.values()) {
            f17 += segmentStatus.mProgress;
            i3 |= segmentStatus.mStatus;
            if (segmentStatus.mStatus == 1) {
                sb5.append("seg_");
                sb5.append(i16);
                sb5.append(",");
            }
            i16++;
        }
        int lastIndexOf = sb5.lastIndexOf(",");
        if (lastIndexOf >= 0) {
            sb5.deleteCharAt(lastIndexOf);
        }
        sb5.append("]");
        float f18 = f17 / f16;
        Logger.i(TAG, "notifyProgressAndStatusUpdate: mStatus = " + i3 + ", mProgress = " + f18 + ", runningTaskNames = " + ((Object) sb5));
        if (i3 == 255) {
            onProgress(255, f18);
            EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
            new File(this.mOutSavePath).delete();
            return;
        }
        if (i3 >= 4) {
            onProgress(4, f18);
            EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
            new File(this.mOutSavePath).delete();
        } else {
            if (i3 == 2) {
                if (EncoderUtils.mergeAllFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId)) {
                    onProgress(2, 1.0f);
                } else {
                    onProgress(255, 1.0f);
                }
                EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
                return;
            }
            if (i3 >= 1) {
                onProgress(1, f18);
            } else {
                onProgress(0, f18);
            }
        }
    }

    private void onProgress(int i3, float f16) {
        ExportCallback exportCallback = this.mCallback;
        if (exportCallback != null) {
            exportCallback.onProgress(i3, f16);
        }
    }

    @Override // com.tencent.tav.core.audio.IAudioExportTask
    public void cancel() {
        Iterator<AudioExportRunner> it = this.mEncoderList.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    protected CMTime getDuration() {
        IAudioSource<? extends IDecoderTrack> iAudioSource = this.mAsset;
        if (iAudioSource != null) {
            return iAudioSource.getDuration();
        }
        return CMTime.CMTimeZero;
    }

    @Override // com.tencent.tav.core.audio.IAudioExportTask
    public void setExportCallback(ExportCallback exportCallback) {
        this.mCallback = exportCallback;
    }

    @Override // com.tencent.tav.core.audio.IAudioExportTask
    public void start() {
        long j3;
        this.mProgressMap.clear();
        this.mEncoderList.clear();
        long timeUs = getDuration().getTimeUs();
        long j16 = AudioExportSession.SEGMENT_DURATION_US;
        int i3 = (int) (((timeUs + j16) - 1) / j16);
        this.mSegmentCount = i3;
        int i16 = AudioExportSession.MAX_THREAD_COUNT;
        if (i3 > i16) {
            this.mSegmentCount = i16;
            j16 = getDuration().getTimeUs() / this.mSegmentCount;
        }
        this.mSessionId = System.currentTimeMillis() + "";
        long j17 = 0;
        int i17 = 0;
        int i18 = 1;
        while (i17 < this.mSegmentCount) {
            long j18 = j17 + j16;
            if (j18 > timeUs) {
                j3 = timeUs - j17;
            } else {
                j3 = j16;
            }
            createSegmentStatus(i18, new CMTimeRange(CMTime.fromUs(j17), CMTime.fromUs(j3)));
            i18++;
            i17++;
            j17 = j18;
        }
        Iterator<Map.Entry<Integer, SegmentStatus>> it = this.mProgressMap.entrySet().iterator();
        int i19 = 1;
        while (it.hasNext()) {
            exportAudio(it.next().getValue().mTimeRange, i19);
            i19++;
        }
    }

    public AudioExportTask(String str) {
        this.mOutSavePath = str;
    }
}
