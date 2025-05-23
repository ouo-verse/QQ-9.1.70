package com.tencent.tav.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetExportSession {
    public static final String TAG = "AssetExportSession";
    Asset asset;
    AssetExtension assetExtension;

    @Nullable
    private AudioMix audioMix;
    private int audioRevertCacheSamples;
    private boolean audioRevertMode;
    long audioTime;

    @Nullable
    private ErrorInterceptor errorInterceptor;

    @NonNull
    private ExportConfig exportConfig;

    @Nullable
    ExportErrorStatus exportErrorStatus;
    private AssetExportThread exportThread;
    private List<MetadataItem> metadata;
    MediaMuxerFactory.MediaMuxerCreator muxerCreator;
    String outputFilePath;
    String outputFileType;
    private String presetName;
    float progress;
    private RenderContextParams renderContextParams;
    int retryIndex;
    AssetExportSessionStatus status;
    private List<String> supportedFileTypes;
    CMTimeRange timeRange;
    long totalTime;
    VideoCompositing videoCompositing;

    @Nullable
    VideoComposition videoComposition;
    AssetWriterVideoEncoder videoEncoder;
    private int videoRevertCacheFrames;
    private boolean videoRevertMode;
    long videoTime;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum AssetExportSessionStatus {
        AssetExportSessionStatusUnknown,
        AssetExportSessionStatusExporting,
        AssetExportSessionStatusCompleted,
        AssetExportSessionStatusFailed,
        AssetExportSessionStatusCancelled
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface ErrorInterceptor {
        boolean needRetry(AssetExportSession assetExportSession, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface ExportCallbackHandler {
        void handlerCallback(AssetExportSession assetExportSession);
    }

    @Deprecated
    public AssetExportSession(@NonNull Asset asset, EncoderWriter.OutputConfig outputConfig) {
        this(asset, new ExportConfig(outputConfig), new AssetExtension(AssetExtension.SCENE_EXPORT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void interceptHandlerCallback(AssetExportSession assetExportSession, ExportCallbackHandler exportCallbackHandler) {
        ErrorInterceptor errorInterceptor;
        if (assetExportSession.getStatus() == AssetExportSessionStatus.AssetExportSessionStatusFailed && (errorInterceptor = this.errorInterceptor) != null && errorInterceptor.needRetry(assetExportSession, this.retryIndex)) {
            this.retryIndex++;
            exportAsynchronouslyWithCompletionHandler(exportCallbackHandler);
        } else {
            exportCallbackHandler.handlerCallback(assetExportSession);
        }
    }

    public void cancelExport() {
        AssetExportThread assetExportThread = this.exportThread;
        if (assetExportThread != null) {
            assetExportThread.cancel();
        }
        this.errorInterceptor = null;
    }

    public void exportAsynchronouslyWithCompletionHandler(final ExportCallbackHandler exportCallbackHandler) {
        VideoComposition videoComposition = this.videoComposition;
        if (videoComposition != null) {
            this.videoCompositing = videoComposition.getCustomVideoCompositor();
        }
        AssetExportThread assetExportThread = this.exportThread;
        if (assetExportThread != null) {
            assetExportThread.removeCallback();
        }
        AssetExportThread assetExportThread2 = new AssetExportThread(this, new ExportCallbackHandler() { // from class: com.tencent.tav.core.AssetExportSession.1
            @Override // com.tencent.tav.core.AssetExportSession.ExportCallbackHandler
            public void handlerCallback(AssetExportSession assetExportSession) {
                AssetExportSession.this.interceptHandlerCallback(assetExportSession, exportCallbackHandler);
            }
        }, this.audioMix, this.exportConfig);
        this.exportThread = assetExportThread2;
        assetExportThread2.setRenderContextParams(this.renderContextParams);
        this.exportThread.startExport();
    }

    public Asset getAsset() {
        return this.asset;
    }

    @Nullable
    public AudioMix getAudioMix() {
        return this.audioMix;
    }

    public int getAudioRevertCacheSamples() {
        return this.audioRevertCacheSamples;
    }

    public long getAudioTime() {
        return this.audioTime;
    }

    public int getErrCode() {
        ExportErrorStatus exportErrorStatus = this.exportErrorStatus;
        if (exportErrorStatus != null) {
            return exportErrorStatus.code;
        }
        return 0;
    }

    @NonNull
    public ExportConfig getExportConfig() {
        return this.exportConfig;
    }

    @Nullable
    public ExportErrorStatus getExportErrorStatus() {
        return this.exportErrorStatus;
    }

    public List<MetadataItem> getMetadata() {
        return this.metadata;
    }

    public String getOutputFilePath() {
        return this.outputFilePath;
    }

    public String getOutputFileType() {
        return this.outputFileType;
    }

    public String getPresetName() {
        return this.presetName;
    }

    public float getProgress() {
        return this.progress;
    }

    public RenderContextParams getRenderContextParams() {
        return this.renderContextParams;
    }

    public int getRetryIndex() {
        return this.retryIndex;
    }

    public AssetExportSessionStatus getStatus() {
        return this.status;
    }

    public List<String> getSupportedFileTypes() {
        return this.supportedFileTypes;
    }

    public Throwable getThrowable() {
        ExportErrorStatus exportErrorStatus = this.exportErrorStatus;
        if (exportErrorStatus != null) {
            return exportErrorStatus.throwable;
        }
        return null;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    public AssetWriterVideoEncoder getVideoEncoder() {
        return this.videoEncoder;
    }

    public int getVideoRevertCacheFrames() {
        return this.videoRevertCacheFrames;
    }

    public long getVideoTime() {
        return this.videoTime;
    }

    public boolean isAudioRevertMode() {
        return this.audioRevertMode;
    }

    @Deprecated
    public boolean isRevertMode() {
        return this.videoRevertMode;
    }

    public boolean isVideoRevertMode() {
        return this.videoRevertMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        AudioMix audioMix = this.audioMix;
        if (audioMix != null) {
            audioMix.release();
            this.audioMix = null;
        }
    }

    public void setAudioMix(AudioMix audioMix) {
        this.audioMix = audioMix;
    }

    public void setAudioRevertCacheSamples(int i3) {
        this.audioRevertCacheSamples = i3;
    }

    public void setAudioRevertModel(boolean z16) {
        this.audioRevertMode = z16;
    }

    public void setErrorInterceptor(@Nullable ErrorInterceptor errorInterceptor) {
        this.errorInterceptor = errorInterceptor;
    }

    public void setExportConfig(@NonNull ExportConfig exportConfig) {
        this.exportConfig = exportConfig;
    }

    public void setMetadata(List<MetadataItem> list) {
        this.metadata = list;
    }

    public void setMuxerCreator(MediaMuxerFactory.MediaMuxerCreator mediaMuxerCreator) {
        this.muxerCreator = mediaMuxerCreator;
    }

    public void setOutputFilePath(String str) {
        this.outputFilePath = str;
    }

    public void setOutputFileType(String str) {
        this.outputFileType = str;
    }

    public void setProgress(float f16) {
        this.progress = f16;
    }

    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.renderContextParams = renderContextParams;
        AssetExportThread assetExportThread = this.exportThread;
        if (assetExportThread != null) {
            assetExportThread.setRenderContextParams(renderContextParams);
        }
    }

    @Deprecated
    public void setRevertMode(boolean z16) {
        this.videoRevertMode = z16;
    }

    public void setStatus(AssetExportSessionStatus assetExportSessionStatus) {
        this.status = assetExportSessionStatus;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public void setVideoComposition(@Nullable VideoComposition videoComposition) {
        this.videoComposition = videoComposition;
    }

    public void setVideoEncoder(AssetWriterVideoEncoder assetWriterVideoEncoder) {
        this.videoEncoder = assetWriterVideoEncoder;
    }

    public void setVideoRevertCacheFrames(int i3) {
        this.videoRevertCacheFrames = i3;
    }

    public void setVideoRevertMode(boolean z16) {
        this.videoRevertMode = z16;
    }

    public AssetExportSession(@NonNull Asset asset, ExportConfig exportConfig) {
        this(asset, exportConfig, new AssetExtension(AssetExtension.SCENE_EXPORT));
    }

    public AssetExportSession(@NonNull Asset asset, ExportConfig exportConfig, AssetExtension assetExtension) {
        this.outputFileType = "mp4";
        this.videoRevertMode = false;
        this.audioRevertMode = false;
        this.audioRevertCacheSamples = 30;
        this.videoRevertCacheFrames = 60;
        this.retryIndex = 0;
        this.asset = asset;
        this.assetExtension = assetExtension;
        if (exportConfig == null || !exportConfig.available()) {
            Logger.e(TAG, "AssetExportSession: encodeOption \u4e0d\u5408\u6cd5");
            exportConfig = new ExportConfig((int) asset.getNaturalSize().width, (int) asset.getNaturalSize().height);
        }
        this.exportConfig = exportConfig;
    }
}
