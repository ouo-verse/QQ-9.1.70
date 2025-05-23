package com.tencent.tav.core;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetWriterInput;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.ExportReportSession;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetExportThread extends BaseHandlerThread implements Handler.Callback {
    private static final String TAG = "AssetExportThread";
    private static final int msg_done_a = 2;
    private static final int msg_done_v = 1;
    private AssetReader assetReader;
    private AssetWriter assetWriter;
    private HandlerThread audioExportThread;
    private AudioInfo audioInfo;
    private AudioMix audioMix;
    private boolean audioReadFinish;
    private AssetReaderOutput audioReader;
    private long audioTime;
    private AssetWriterInput audioWriter;
    private volatile boolean audioWriterDone;

    @Nullable
    private AssetExportSession.ExportCallbackHandler callbackHandler;
    private volatile boolean cancel;
    private MediaSyncClock clock;
    private final ExportConfig encodeOption;
    private Handler exportHandler;
    private AssetExportSession exportSession;
    private boolean isFinishing;
    private long lastAudioBufferTime;
    private long lastAudioPts;
    private RenderContextParams renderContextParams;

    @NonNull
    private final ExportReportSession reportSession;
    private HandlerThread videoExportThread;
    private boolean videoReadFinish;
    private AssetReaderOutput videoReader;
    private long videoTime;
    private AssetWriterInput videoWriter;
    private volatile boolean videoWriterDone;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class AudioRequestMediaDataCallback implements Runnable {
        AudioRequestMediaDataCallback() {
        }

        private void onAudioRequestMediaData() {
            Logger.i(AssetExportThread.TAG, "onAudioRequestMediaData start");
            while (true) {
                if (AssetExportThread.this.audioWriterDone || AssetExportThread.this.isCancel()) {
                    break;
                }
                if (AssetExportThread.this.audioReader != null && AssetExportThread.this.audioWriter.isReadyForMoreMediaData()) {
                    AssetExportThread.this.audioReader.duration();
                    long currentTimeMillis = System.currentTimeMillis();
                    CMSampleBuffer copyNextSampleBuffer = AssetExportThread.this.audioReader.copyNextSampleBuffer();
                    Logger.d(AssetExportThread.TAG, "copyNextAudioSampleBuffer end, StateCode:" + copyNextSampleBuffer.getState().getStateCode() + ", cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    CMSampleState state = copyNextSampleBuffer.getState();
                    if (state.getStateCode() >= 0) {
                        AssetExportThread.this.clock.syncAudio(copyNextSampleBuffer.getTime());
                        ExportErrorStatus appendAudioSampleBuffer = AssetExportThread.this.audioWriter.appendAudioSampleBuffer(copyNextSampleBuffer);
                        if (appendAudioSampleBuffer != null) {
                            AssetExportThread.this.exportError(appendAudioSampleBuffer);
                        }
                        if (copyNextSampleBuffer.getTime().getTimeUs() >= AssetExportThread.this.exportSession.timeRange.getEnd().getTimeUs()) {
                            AssetExportThread.this.audioWriter.markAsFinished();
                            break;
                        }
                    } else if (state.getStateCode() == -1) {
                        AssetExportThread.this.audioWriter.markAsFinished();
                        break;
                    } else if (state.getStateCode() != -4) {
                        AssetExportThread.this.exportError(new ExportErrorStatus(state));
                        break;
                    }
                }
            }
            AssetExportThread.this.audioReader.stopPreDecode();
            AssetExportThread.this.audioReadFinish = !r0.isCancel();
            AssetExportThread.this.exportHandler.sendEmptyMessage(2);
            Logger.i(AssetExportThread.TAG, "onAudioRequestMediaData end");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                onAudioRequestMediaData();
            } catch (Throwable th5) {
                Logger.e(AssetExportThread.TAG, "AudioRequestMediaDateCallback run: ", th5);
                AssetExportThread.this.exportError(-15, th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class AudioWriterProgressListener implements AssetWriterInput.WriterProgressListener {
        AudioWriterProgressListener() {
        }

        @Override // com.tencent.tav.core.AssetWriterInput.WriterProgressListener
        public void onError(@NonNull ExportErrorStatus exportErrorStatus) {
            Logger.e(AssetExportThread.TAG, "AudioWriterProgressListener onError: ", exportErrorStatus.throwable);
            AssetExportThread.this.exportError(exportErrorStatus);
        }

        @Override // com.tencent.tav.core.AssetWriterInput.WriterProgressListener
        public void onProgressChanged(AssetWriterInput assetWriterInput, long j3) {
            Logger.i(AssetExportSession.TAG, "onProgressChanged: audioWriter " + j3 + "  / " + AssetExportThread.this.getDuration());
            if (j3 != -1) {
                AssetExportThread.this.audioTime = j3;
                AssetExportThread.this.notifyProgress();
                if ((AssetExportThread.this.audioTime > AssetExportThread.this.videoTime && AssetExportThread.this.videoWriterDone) || AssetExportThread.this.audioTime >= AssetExportThread.this.exportSession.timeRange.getEnd().getTimeUs()) {
                    AssetExportThread assetExportThread = AssetExportThread.this;
                    assetExportThread.audioTime = assetExportThread.exportSession.timeRange.getDuration().getTimeUs();
                    AssetExportThread.this.audioWriterDone = true;
                    AssetExportThread.this.exportHandler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            AssetExportThread assetExportThread2 = AssetExportThread.this;
            assetExportThread2.audioTime = assetExportThread2.exportSession.timeRange.getDuration().getTimeUs();
            AssetExportThread.this.audioWriterDone = true;
            AssetExportThread.this.exportHandler.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class VideoRequestMediaDataCallback implements Runnable {
        VideoRequestMediaDataCallback() {
        }

        @RequiresApi(api = 18)
        private void onRequestMediaData() {
            Logger.i(AssetExportThread.TAG, "onRequestVideoMediaData start");
            while (true) {
                if (AssetExportThread.this.videoWriterDone || AssetExportThread.this.isCancel()) {
                    break;
                }
                if (AssetExportThread.this.videoReader != null && AssetExportThread.this.videoWriter.isReadyForMoreMediaData()) {
                    CMSampleBuffer copyNextSampleBuffer = AssetExportThread.this.videoReader.copyNextSampleBuffer();
                    CMSampleState state = copyNextSampleBuffer.getState();
                    if (state.getStateCode() >= 0) {
                        AssetExportThread.this.clock.syncVideo(copyNextSampleBuffer.getTime());
                        ExportErrorStatus appendVideoSampleBuffer = AssetExportThread.this.videoWriter.appendVideoSampleBuffer(copyNextSampleBuffer);
                        if (appendVideoSampleBuffer != null) {
                            AssetExportThread.this.exportError(appendVideoSampleBuffer);
                        }
                        if (copyNextSampleBuffer.getTime().getTimeUs() >= AssetExportThread.this.exportSession.timeRange.getEnd().getTimeUs()) {
                            AssetExportThread.this.videoWriter.markAsFinished();
                            break;
                        }
                    } else if (state.stateMatchingTo(-1)) {
                        AssetExportThread.this.videoWriter.markAsFinished();
                        break;
                    } else if (state.getStateCode() != -4) {
                        AssetExportThread.this.exportError(new ExportErrorStatus(state));
                        break;
                    }
                }
            }
            Logger.i(AssetExportThread.TAG, "onRequestVideoMediaData end");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        @RequiresApi(api = 18)
        public void run() {
            try {
                onRequestMediaData();
            } catch (Throwable th5) {
                try {
                    Logger.e(AssetExportThread.TAG, "VideoRequestMediaDateCallback run: ", th5);
                    if (th5 instanceof ExportRuntimeException) {
                        try {
                            AssetExportThread.this.exportError(th5.getErrorStatus().code, th5);
                        } catch (Exception unused) {
                            AssetExportThread.this.exportError(-14, th5);
                        }
                    } else {
                        AssetExportThread.this.exportError(-14, th5);
                    }
                    AssetExportThread.this.clock.close();
                    AssetExportThread.this.videoWriter.matrixFilter.release();
                    AssetExportThread.this.videoWriter.writer.getVideoEncoder().onRenderRelease();
                    if (AssetExportThread.this.exportSession.videoCompositing != null) {
                        AssetExportThread.this.exportSession.videoCompositing.release();
                    }
                } finally {
                    AssetExportThread.this.clock.close();
                    AssetExportThread.this.videoWriter.matrixFilter.release();
                    AssetExportThread.this.videoWriter.writer.getVideoEncoder().onRenderRelease();
                    if (AssetExportThread.this.exportSession.videoCompositing != null) {
                        AssetExportThread.this.exportSession.videoCompositing.release();
                    }
                    AssetExportThread.this.videoReadFinish = !r4.isCancel();
                    AssetExportThread.this.exportHandler.sendEmptyMessage(1);
                    Logger.d(AssetExportThread.TAG, "onRequestVideoMediaData end");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class VideoWriterProgressListener implements AssetWriterInput.WriterProgressListener {
        VideoWriterProgressListener() {
        }

        @Override // com.tencent.tav.core.AssetWriterInput.WriterProgressListener
        public void onError(@NonNull ExportErrorStatus exportErrorStatus) {
            Logger.e(AssetExportThread.TAG, "VideoWriterProgressListener onError: ", exportErrorStatus.throwable);
            AssetExportThread.this.exportError(exportErrorStatus);
        }

        @Override // com.tencent.tav.core.AssetWriterInput.WriterProgressListener
        public void onProgressChanged(AssetWriterInput assetWriterInput, long j3) {
            Logger.i(AssetExportSession.TAG, "onProgressChanged: videoWriter " + j3 + "  / " + AssetExportThread.this.getDuration());
            if (j3 != -1) {
                AssetExportThread.this.videoTime = j3;
                AssetExportThread.this.notifyProgress();
            } else {
                AssetExportThread assetExportThread = AssetExportThread.this;
                assetExportThread.videoTime = assetExportThread.exportSession.timeRange.getDuration().getTimeUs();
                AssetExportThread.this.videoWriterDone = true;
                AssetExportThread.this.exportHandler.sendEmptyMessage(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AssetExportThread(AssetExportSession assetExportSession, AssetExportSession.ExportCallbackHandler exportCallbackHandler, AudioMix audioMix, ExportConfig exportConfig) {
        super("ExportThread-" + assetExportSession.retryIndex);
        this.videoWriterDone = false;
        this.audioWriterDone = false;
        this.videoReadFinish = false;
        this.audioReadFinish = false;
        this.videoTime = 0L;
        this.audioTime = 0L;
        this.cancel = false;
        this.lastAudioPts = 0L;
        this.lastAudioBufferTime = 0L;
        this.reportSession = new ExportReportSession();
        this.exportSession = assetExportSession;
        this.callbackHandler = exportCallbackHandler;
        this.audioMix = audioMix;
        this.audioInfo = new AudioInfo(exportConfig.getAudioSampleRateHz(), exportConfig.getAudioChannelCount(), 2, exportConfig.getAudioSampleCount());
        this.encodeOption = exportConfig;
        this.clock = new MediaSyncClock(exportConfig.enableAVSync);
    }

    private void appendErrorMsg(ExportErrorStatus exportErrorStatus) {
        exportErrorStatus.appendMsg("cancel:" + isCancel());
        exportErrorStatus.appendMsg("exportSession.status:" + this.exportSession.status);
        exportErrorStatus.appendMsg("videoWriterDone:" + this.videoWriterDone);
        exportErrorStatus.appendMsg("audioWriterDone:" + this.audioWriterDone);
        exportErrorStatus.appendMsg("videoReadFinish:" + this.videoReadFinish);
        exportErrorStatus.appendMsg("audioReadFinish:" + this.audioReadFinish);
    }

    private AssetReaderOutput createAudioTrackOutput() {
        ArrayList arrayList = (ArrayList) this.exportSession.asset.tracksWithMediaType(2);
        if (arrayList != null) {
            AssetReaderAudioMixOutput assetReaderAudioMixOutput = new AssetReaderAudioMixOutput(arrayList, null, this.exportSession.isAudioRevertMode(), this.exportSession.getAudioRevertCacheSamples());
            assetReaderAudioMixOutput.setAudioMix(this.audioMix);
            assetReaderAudioMixOutput.setAudioInfo(this.audioInfo);
            return assetReaderAudioMixOutput;
        }
        return new EmptyReaderOutput();
    }

    private AssetWriterInput createAudioWriterInput() {
        return new AssetWriterInput(2, this.encodeOption);
    }

    private AssetReaderOutput createVideoTrackOutput() {
        List<AssetTrack> tracksWithMediaType = this.exportSession.asset.tracksWithMediaType(1);
        if (tracksWithMediaType != null) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("frame-rate", Integer.valueOf(this.encodeOption.getVideoFrameRate()));
            AssetReaderVideoCompositionOutput assetReaderVideoCompositionOutput = new AssetReaderVideoCompositionOutput(tracksWithMediaType, hashMap, this.exportSession.assetExtension);
            assetReaderVideoCompositionOutput.setVideoComposition(this.exportSession.videoComposition);
            assetReaderVideoCompositionOutput.setVideoCompositing(this.exportSession.videoCompositing);
            assetReaderVideoCompositionOutput.setVideoRevertMode(this.exportSession.isVideoRevertMode());
            assetReaderVideoCompositionOutput.setRevertVideoMaxFrameCounts(this.exportSession.getVideoRevertCacheFrames());
            return assetReaderVideoCompositionOutput;
        }
        return new EmptyReaderOutput();
    }

    private AssetWriterInput createVideoWriterInput() {
        this.reportSession.setFramePerSecond(this.encodeOption.getVideoFrameRate());
        return new AssetWriterInput(1, this.encodeOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exportError(int i3, Throwable th5) {
        exportError(new ExportErrorStatus(i3, th5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exportSuccess() {
        synchronized (this) {
            AssetExportSession.AssetExportSessionStatus status = getStatus();
            AssetExportSession.AssetExportSessionStatus assetExportSessionStatus = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted;
            if (status == assetExportSessionStatus) {
                return;
            }
            this.exportSession.progress = 1.0f;
            setStatus(assetExportSessionStatus);
            this.reportSession.onExportSuccess();
            handlerCallback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 18)
    public void exporting() {
        if (isCancel()) {
            return;
        }
        initReaderAndWriter();
        if (isCancel()) {
            return;
        }
        setStatus(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting);
        this.videoExportThread = new BaseHandlerThread("VideoWriter");
        this.videoWriter.setWriterProgressListener(new VideoWriterProgressListener());
        this.videoWriter.requestMediaDataWhenReadyOnQueue(this.videoExportThread, new VideoRequestMediaDataCallback());
        if (this.audioWriter != null) {
            this.audioExportThread = new BaseHandlerThread("AudioWriter");
            if (EncoderWriter.PRE_DECODE_AUDIO) {
                this.audioReader.preDecode();
            }
            if (this.encodeOption.getAudioEncodeAsync()) {
                setCallback(new AudioWriterProgressListener());
                this.audioWriter.requestMediaDataWhenReadyOnQueue(this.audioExportThread, null);
                return;
            } else {
                this.audioWriter.setWriterProgressListener(new AudioWriterProgressListener());
                this.audioWriter.requestMediaDataWhenReadyOnQueue(this.audioExportThread, new AudioRequestMediaDataCallback());
                return;
            }
        }
        this.audioReadFinish = true;
        this.audioWriterDone = true;
    }

    private void finish() {
        if (this.videoExportThread == null) {
            return;
        }
        new Handler(this.videoExportThread.getLooper()).post(new Runnable() { // from class: com.tencent.tav.core.AssetExportThread.1
            @Override // java.lang.Runnable
            public void run() {
                if (AssetExportThread.this.videoExportThread != null) {
                    AssetExportThread.this.videoExportThread.quitSafely();
                    AssetExportThread.this.videoExportThread = null;
                }
                if (AssetExportThread.this.audioExportThread != null) {
                    AssetExportThread.this.audioExportThread.quitSafely();
                    AssetExportThread.this.audioExportThread = null;
                }
                if (AssetExportThread.this.assetReader != null) {
                    AssetExportThread.this.assetReader.cancelReading();
                    AssetExportThread.this.assetReader = null;
                }
                boolean z16 = false;
                if (AssetExportThread.this.assetWriter != null) {
                    try {
                        AssetExportThread.this.assetWriter.finishWriting();
                        z16 = true;
                    } catch (Exception e16) {
                        Logger.e(AssetExportSession.TAG, "code = -10 run: finishWriting error", e16);
                        if (e16 instanceof ExportRuntimeException) {
                            AssetExportThread.this.exportError(((ExportRuntimeException) e16).getErrorStatus());
                        } else {
                            AssetExportThread.this.exportError(-10, e16);
                        }
                    }
                    AssetExportThread.this.assetWriter = null;
                }
                if (AssetExportThread.this.videoWriter != null) {
                    AssetExportThread.this.videoWriter.close();
                }
                if (AssetExportThread.this.audioWriter != null) {
                    AssetExportThread.this.audioWriter.close();
                }
                if (AssetExportThread.this.videoWriterDone && AssetExportThread.this.audioWriterDone && z16 && !AssetExportThread.this.isCancel()) {
                    AssetExportThread.this.exportSuccess();
                }
                AssetExportThread.this.quitSafely();
                if (AssetExportThread.this.exportSession != null) {
                    AssetExportThread.this.exportSession.release();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDuration() {
        long j3;
        CMTimeRange cMTimeRange;
        AssetExportSession assetExportSession = this.exportSession;
        if (assetExportSession != null && (cMTimeRange = assetExportSession.timeRange) != null) {
            return cMTimeRange.getDuration().getTimeUs() * 2;
        }
        AssetReaderOutput assetReaderOutput = this.audioReader;
        long j16 = 0;
        if (assetReaderOutput != null) {
            j3 = assetReaderOutput.duration();
        } else {
            j3 = 0;
        }
        AssetReaderOutput assetReaderOutput2 = this.videoReader;
        if (assetReaderOutput2 != null) {
            j16 = assetReaderOutput2.duration();
        }
        return j3 + j16;
    }

    private synchronized AssetExportSession.AssetExportSessionStatus getStatus() {
        return this.exportSession.status;
    }

    private synchronized void handlerCallback() {
        AssetExportSession.ExportCallbackHandler exportCallbackHandler = this.callbackHandler;
        if (exportCallbackHandler != null) {
            exportCallbackHandler.handlerCallback(this.exportSession);
        }
    }

    @RequiresApi(api = 18)
    private void initReaderAndWriter() {
        AssetReader assetReader = new AssetReader(this.exportSession.asset);
        this.assetReader = assetReader;
        assetReader.setTimeRange(this.exportSession.timeRange);
        this.videoReader = createVideoTrackOutput();
        this.audioReader = createAudioTrackOutput();
        if (this.assetReader.canAddOutput(this.videoReader)) {
            this.assetReader.addOutput(this.videoReader);
        }
        if (this.assetReader.canAddOutput(this.audioReader)) {
            this.assetReader.addOutput(this.audioReader);
        }
        AssetExportSession assetExportSession = this.exportSession;
        AssetWriter assetWriter = new AssetWriter(assetExportSession.outputFilePath, assetExportSession.outputFileType);
        this.assetWriter = assetWriter;
        assetWriter.setRenderContextParams(this.renderContextParams);
        this.assetWriter.setReportSession(this.reportSession);
        CMTimeRange cMTimeRange = this.exportSession.timeRange;
        if (cMTimeRange != null) {
            this.assetWriter.startSessionAtSourceTime(cMTimeRange.getStart());
            this.assetWriter.endSessionAtSourceTime(this.exportSession.timeRange.getEnd());
            this.reportSession.setFileDurationUs(this.exportSession.timeRange.getDurationUs());
        }
        this.assetWriter.setEncodeOption(this.encodeOption);
        this.videoWriter = createVideoWriterInput();
        this.audioWriter = createAudioWriterInput();
        if (this.assetWriter.canAddInput(this.videoWriter)) {
            this.assetWriter.addInput(this.videoWriter);
        }
        if (this.assetWriter.canAddInput(this.audioWriter)) {
            this.assetWriter.addInput(this.audioWriter);
        }
        AssetWriter assetWriter2 = this.assetWriter;
        AssetExportSession assetExportSession2 = this.exportSession;
        assetWriter2.startWriting(assetExportSession2.videoEncoder, assetExportSession2.muxerCreator);
        this.assetReader.startReading(this.assetWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean isCancel() {
        return this.cancel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyProgress() {
        long duration = getDuration();
        if (duration != 0) {
            AssetExportSession assetExportSession = this.exportSession;
            long j3 = this.videoTime;
            long j16 = this.audioTime;
            assetExportSession.progress = (((float) (j3 + j16)) * 1.0f) / ((float) duration);
            assetExportSession.videoTime = j3;
            assetExportSession.audioTime = j16;
            assetExportSession.totalTime = duration;
        }
        if (getStatus() != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed && getStatus() != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled) {
            handlerCallback();
        }
    }

    @RequiresApi(api = 21)
    private void setCallback(final AssetWriterInput.WriterProgressListener writerProgressListener) {
        this.audioReadFinish = false;
        this.audioWriter.writer.callback = new MediaCodec.Callback() { // from class: com.tencent.tav.core.AssetExportThread.3
            @Override // android.media.MediaCodec.Callback
            public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
                Logger.e(AssetExportThread.TAG, "onError", codecException);
                AssetExportThread.this.exportError(new ExportErrorStatus(-105, codecException, "\u97f3\u9891\u5f02\u6b65\u6a21\u5f0f\u7f16\u7801\u5931\u8d25"));
            }

            @Override // android.media.MediaCodec.Callback
            public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3) {
                ByteBuffer inputBuffer;
                Logger.d(AssetExportThread.TAG, "onInputBufferAvailable, index:" + i3);
                try {
                    if (AssetExportThread.this.isCancel()) {
                        mediaCodec.queueInputBuffer(i3, 0, 0, 0L, 4);
                        AssetExportThread.this.audioReadFinish = true;
                    }
                    if (!AssetExportThread.this.audioWriterDone && !AssetExportThread.this.audioReadFinish && (inputBuffer = mediaCodec.getInputBuffer(i3)) != null) {
                        inputBuffer.clear();
                        Logger.d(AssetExportThread.TAG, "copyNextAudioSampleBuffer start");
                        long currentTimeMillis = System.currentTimeMillis();
                        CMSampleBuffer copyNextAudioSampleBuffer = AssetExportThread.this.audioReader.copyNextAudioSampleBuffer(inputBuffer, AssetExportThread.this.assetWriter.startTime, AssetExportThread.this.encodeOption);
                        Logger.d(AssetExportThread.TAG, "copyNextAudioSampleBuffer end, StateCode:" + copyNextAudioSampleBuffer.getState().getStateCode() + ", cost:" + (System.currentTimeMillis() - currentTimeMillis));
                        CMSampleState state = copyNextAudioSampleBuffer.getState();
                        if (state.getStateCode() >= 0) {
                            if (copyNextAudioSampleBuffer.getTime().getTimeUs() >= AssetExportThread.this.exportSession.timeRange.getEnd().getTimeUs()) {
                                Logger.i(AssetExportThread.TAG, "onInputBufferAvailable index:" + i3 + " time exceed");
                                mediaCodec.queueInputBuffer(i3, 0, 0, 0L, 4);
                                AssetExportThread.this.audioReadFinish = true;
                            } else {
                                AssetExportThread.this.clock.syncAudio(copyNextAudioSampleBuffer.getTime());
                                Logger.i(AssetExportThread.TAG, "onInputBufferAvailable: queueInputBuffer start, index:" + i3 + ", time:" + copyNextAudioSampleBuffer.getTime().getTimeUs() + " positon:" + inputBuffer.position() + " limit:" + inputBuffer.limit() + " duration:" + (copyNextAudioSampleBuffer.getTime().getTimeUs() - AssetExportThread.this.lastAudioBufferTime));
                                AssetExportThread.this.lastAudioBufferTime = copyNextAudioSampleBuffer.getTime().getTimeUs();
                                mediaCodec.queueInputBuffer(i3, 0, inputBuffer.limit(), copyNextAudioSampleBuffer.getTime().getTimeUs(), 0);
                                Logger.d(AssetExportThread.TAG, "onInputBufferAvailable: queueInputBuffer end");
                            }
                        } else if (state.getStateCode() == -1) {
                            Logger.i(AssetExportThread.TAG, "onInputBufferAvailable index:" + i3 + " SAMPLE_STATE_FINISH");
                            mediaCodec.queueInputBuffer(i3, 0, 0, 0L, 4);
                            AssetExportThread.this.audioReadFinish = true;
                        } else if (state.getStateCode() != -4) {
                            AssetExportThread.this.exportError(new ExportErrorStatus(state));
                        }
                    }
                    if (AssetExportThread.this.audioReadFinish) {
                        AssetExportThread.this.audioReader.stopPreDecode();
                    }
                } catch (Exception e16) {
                    Logger.e(AssetExportThread.TAG, "onInputBufferAvailable error", e16);
                    AssetExportThread.this.audioReadFinish = true;
                    AssetExportThread.this.audioReader.stopPreDecode();
                    AssetExportThread.this.exportError(new ExportErrorStatus(-105, e16, "\u97f3\u9891\u5f02\u6b65\u6a21\u5f0f\u7f16\u7801\u5931\u8d25"));
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo) {
                try {
                    if (AssetExportThread.this.isCancel()) {
                        Logger.d(AssetExportThread.TAG, "onOutputBufferAvailable isCancel");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    AssetExportThread.this.audioWriter.writer.outputAudioFrame(mediaCodec, i3, bufferInfo);
                    Logger.i(AssetExportThread.TAG, "onOutputBufferAvailable, index:" + i3 + ", flags:" + bufferInfo.flags + ", cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", time:" + bufferInfo.presentationTimeUs + ", duration:" + (bufferInfo.presentationTimeUs - AssetExportThread.this.lastAudioPts));
                    AssetExportThread.this.lastAudioPts = bufferInfo.presentationTimeUs;
                    if ((bufferInfo.flags & 4) == 1) {
                        AssetWriterInput.WriterProgressListener writerProgressListener2 = writerProgressListener;
                        if (writerProgressListener2 != null) {
                            writerProgressListener2.onProgressChanged(AssetExportThread.this.audioWriter, -1L);
                            return;
                        }
                        return;
                    }
                    AssetWriterInput.WriterProgressListener writerProgressListener3 = writerProgressListener;
                    if (writerProgressListener3 != null) {
                        writerProgressListener3.onProgressChanged(AssetExportThread.this.audioWriter, AssetExportThread.this.audioWriter.writer.getAudioPresentationTimeUs());
                    }
                } catch (Exception e16) {
                    Logger.e(AssetExportThread.TAG, "onOutputBufferAvailable error", e16);
                    AssetExportThread.this.exportError(new ExportErrorStatus(-105, e16, "\u97f3\u9891\u5f02\u6b65\u6a21\u5f0f\u7f16\u7801\u5931\u8d25"));
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
                Logger.e(AssetExportThread.TAG, "onOutputFormatChanged, format:" + mediaFormat);
                AssetExportThread.this.audioWriter.writer.setAudioOutputFromat(mediaFormat);
            }
        };
    }

    private synchronized void setCancel(boolean z16) {
        this.cancel = z16;
    }

    private synchronized void setStatus(AssetExportSession.AssetExportSessionStatus assetExportSessionStatus) {
        this.exportSession.status = assetExportSessionStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void cancel() {
        setStatus(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled);
        setCancel(true);
        this.clock.close();
        handlerCallback();
        this.callbackHandler = null;
        this.reportSession.reset();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if ((i3 == 1 || i3 == 2) && !this.isFinishing) {
            if (isCancel()) {
                this.isFinishing = true;
                finish();
            }
            if (this.videoWriterDone && this.audioWriterDone && this.audioReadFinish && this.videoReadFinish) {
                this.isFinishing = true;
                finish();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void removeCallback() {
        this.callbackHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.renderContextParams = renderContextParams;
        AssetWriter assetWriter = this.assetWriter;
        if (assetWriter != null) {
            assetWriter.setRenderContextParams(renderContextParams);
        }
        this.reportSession.setRenderContextParams(renderContextParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void startExport() {
        start();
        setCancel(false);
        this.reportSession.onExportStart(System.nanoTime());
        Handler handler = new Handler(getLooper(), this);
        this.exportHandler = handler;
        handler.post(new Runnable() { // from class: com.tencent.tav.core.AssetExportThread.2
            @Override // java.lang.Runnable
            @RequiresApi(api = 18)
            public void run() {
                AssetExportThread.this.exporting();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void exportError(ExportErrorStatus exportErrorStatus) {
        if (getStatus() == AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled) {
            return;
        }
        AssetExportSession.AssetExportSessionStatus status = getStatus();
        AssetExportSession.AssetExportSessionStatus assetExportSessionStatus = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed;
        if (status != assetExportSessionStatus) {
            appendErrorMsg(exportErrorStatus);
            setStatus(assetExportSessionStatus);
            setCancel(true);
            this.clock.close();
            this.exportSession.exportErrorStatus = exportErrorStatus;
            this.reportSession.onExportError(exportErrorStatus);
            handlerCallback();
        }
    }
}
