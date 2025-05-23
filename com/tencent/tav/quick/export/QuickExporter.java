package com.tencent.tav.quick.export;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.ThreadPool;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.quick.export.SegmentCombiner;
import com.tencent.tav.quick.export.SegmentExport;
import com.tencent.tav.quick.export.muxer.QuickMuxerCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/* compiled from: P */
/* loaded from: classes26.dex */
public class QuickExporter {
    public static final int SEGMENT_COUNT_NEEDED_OPTIMIZE = 1;
    public static final String TAG = "QuickExporter";
    private AssetExportSession.ExportCallbackHandler mExportCallback;
    private ExportConfig mExportConfig;
    private AssetExportSession mExportSession;
    private String mInputPath;
    private String mOutputPath;
    private CountDownLatch mSegmentAllFinish;
    private SegmentCombiner mSegmentCombiner;
    private SegmentCombiner.VideoCombineListener mSegmentCombinerListener;
    private int mSegments;
    private List<SegmentExport> mSegmentExports = new ArrayList();
    private List<String> mSegmentOutputPaths = new ArrayList();
    private volatile boolean mExportFinished = false;
    private Semaphore mSegmentFirstFrameDecode = new Semaphore(0);
    private volatile boolean mIsCancelled = false;

    public QuickExporter(String str, @NonNull AssetExportSession assetExportSession, ExportConfig exportConfig, int i3, AssetExportSession.ExportCallbackHandler exportCallbackHandler) {
        this.mInputPath = str;
        this.mExportSession = assetExportSession;
        this.mOutputPath = assetExportSession.getOutputFilePath();
        this.mExportConfig = exportConfig;
        this.mSegments = i3;
        this.mExportCallback = exportCallbackHandler;
        this.mSegmentAllFinish = new CountDownLatch(this.mSegments);
        initSegmentExports();
    }

    private void initSegmentExports() {
        if (this.mSegments == 1) {
            this.mSegmentOutputPaths.add(this.mOutputPath);
            SegmentExport segmentExport = new SegmentExport(this.mInputPath, this.mOutputPath, this.mExportSession.getAsset(), this.mExportConfig);
            segmentExport.setMediaMuxerCreator(new QuickMuxerCreator());
            this.mSegmentExports.add(segmentExport);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        String str = this.mOutputPath;
        sb5.append(str.substring(0, str.lastIndexOf(46)));
        sb5.append("_seg_");
        String sb6 = sb5.toString();
        for (int i3 = 0; i3 < this.mSegments; i3++) {
            String str2 = sb6 + i3 + "." + this.mExportSession.getOutputFileType();
            this.mSegmentOutputPaths.add(str2);
            this.mSegmentExports.add(new SegmentExport(this.mInputPath, str2, this.mExportSession.getAsset(), this.mExportConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.mSegmentFirstFrameDecode.release();
        for (int i3 = 0; i3 < this.mSegments; i3++) {
            this.mSegmentAllFinish.countDown();
        }
        this.mExportFinished = true;
        Iterator<SegmentExport> it = this.mSegmentExports.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        SegmentCombiner segmentCombiner = this.mSegmentCombiner;
        if (segmentCombiner != null) {
            segmentCombiner.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startExportInner() throws InterruptedException {
        CMTimeRange fromUs;
        long currentTimeMillis = System.currentTimeMillis();
        long timeUs = this.mExportSession.getAsset().getDuration().getTimeUs();
        float f16 = (float) timeUs;
        int i3 = this.mSegments;
        float f17 = (1.0f * f16) / i3;
        final long[] jArr = new long[1];
        int i16 = i3 - 1;
        while (true) {
            if (i16 < 0) {
                break;
            }
            if (this.mExportFinished) {
                this.mSegmentFirstFrameDecode.release();
                break;
            }
            int i17 = this.mSegments;
            if (i16 == i17 - 1) {
                long j3 = f16 - f17;
                fromUs = CMTimeRange.fromUs(j3, timeUs - j3);
            } else if (i16 == 0 && i17 != 1) {
                fromUs = CMTimeRange.fromUs(0L, jArr[0]);
            } else {
                long j16 = jArr[0];
                long j17 = ((float) j16) - f17;
                fromUs = CMTimeRange.fromUs(j17, j16 - j17);
            }
            Logger.i(TAG, i16 + "  range begin " + fromUs.getStart().getTimeUs() + ", end " + fromUs.getEnd().getTimeUs() + ", segment step " + f17);
            this.mSegmentExports.get(i16).setSegmentExportListener(new SegmentExport.SegmentExportListener() { // from class: com.tencent.tav.quick.export.QuickExporter.2
                @Override // com.tencent.tav.quick.export.SegmentExport.SegmentExportListener
                public void onFirstFrameDecode(long j18) {
                    Logger.d(QuickExporter.TAG, "onFirstFrameDecode pts " + j18);
                    jArr[0] = j18;
                    QuickExporter.this.mSegmentFirstFrameDecode.release();
                }

                @Override // com.tencent.tav.quick.export.SegmentExport.SegmentExportListener
                public void onSegmentExportEnd() {
                    QuickExporter.this.mSegmentAllFinish.countDown();
                    Logger.d(QuickExporter.TAG, "pref time segment finish");
                }

                @Override // com.tencent.tav.quick.export.SegmentExport.SegmentExportListener
                public void onSegmentExportError(long j18) {
                    QuickExporter.this.release();
                    if (QuickExporter.this.mSegmentCombinerListener != null && !QuickExporter.this.mIsCancelled) {
                        Logger.e(QuickExporter.TAG, "onSegmentExportError errorCode " + j18);
                        QuickExporter.this.mSegmentCombinerListener.onCombineFinished(false);
                    }
                }

                @Override // com.tencent.tav.quick.export.SegmentExport.SegmentExportListener
                public void onSegmentExportProgress(float f18) {
                    if (QuickExporter.this.mSegmentCombinerListener != null && !QuickExporter.this.mIsCancelled) {
                        QuickExporter.this.mSegmentCombinerListener.onCombineProcessing(f18);
                    }
                }
            });
            this.mSegmentExports.get(i16).startExport(fromUs);
            this.mSegmentFirstFrameDecode.acquire();
            i16 += -1;
        }
        if (!this.mExportFinished) {
            SegmentCombiner segmentCombiner = new SegmentCombiner(this.mSegmentOutputPaths, this.mInputPath, this.mOutputPath, this.mSegmentCombinerListener, this.mSegmentAllFinish);
            this.mSegmentCombiner = segmentCombiner;
            segmentCombiner.setVideoFormat(this.mSegmentExports.get(this.mSegments - 1).getEncodeMediaFormat());
            if (this.mSegments == 1) {
                this.mSegmentCombiner.setSegmentMuxer(this.mSegmentExports.get(0).getSegmentMuxer());
            }
            this.mSegmentCombiner.combineVideo();
            if (this.mSegments == 1) {
                this.mSegmentAllFinish.await();
            }
            if (!this.mExportFinished && this.mSegmentCombinerListener != null && !this.mIsCancelled) {
                this.mSegmentCombinerListener.onCombineFinished(true);
            }
            Logger.e(TAG, "pref time segments Combiner , cost " + (System.currentTimeMillis() - currentTimeMillis));
        }
        release();
    }

    public void cancelExport() {
        AssetExportSession assetExportSession;
        Logger.i(TAG, "Quick exporter canceled");
        this.mIsCancelled = true;
        SegmentCombiner segmentCombiner = this.mSegmentCombiner;
        if (segmentCombiner != null) {
            segmentCombiner.cancel();
        }
        if (this.mExportCallback != null && (assetExportSession = this.mExportSession) != null) {
            assetExportSession.setStatus(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled);
            this.mExportCallback.handlerCallback(this.mExportSession);
        }
        release();
    }

    public void setSegmentCombinerListener(SegmentCombiner.VideoCombineListener videoCombineListener) {
        this.mSegmentCombinerListener = videoCombineListener;
    }

    public void startExport() {
        if (!TextUtils.isEmpty(this.mInputPath) && !TextUtils.isEmpty(this.mOutputPath)) {
            ThreadPool.execute(new Runnable() { // from class: com.tencent.tav.quick.export.QuickExporter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        QuickExporter.this.startExportInner();
                    } catch (InterruptedException e16) {
                        String str = QuickExporter.TAG;
                        Logger.e(str, "start export failed ", e16);
                        QuickExporter.this.release();
                        if (QuickExporter.this.mSegmentCombinerListener != null && !QuickExporter.this.mIsCancelled) {
                            Logger.e(str, "segment combiner startExportInner failed");
                            QuickExporter.this.mSegmentCombinerListener.onCombineFinished(false);
                        }
                    }
                }
            });
            return;
        }
        Logger.e(TAG, "input or output path error , input " + this.mInputPath + ", output " + this.mOutputPath);
        this.mExportSession.setStatus(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed);
        AssetExportSession.ExportCallbackHandler exportCallbackHandler = this.mExportCallback;
        if (exportCallbackHandler != null) {
            exportCallbackHandler.handlerCallback(this.mExportSession);
        }
    }
}
