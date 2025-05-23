package com.tencent.qcircle.tavcut.exporter;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MovieExporter {
    public static final int ERROR_VIDEO_EXPORT_FAILED_CODE = -10000;
    public static final String IS_VIDEO_EXPORT = "is_video_export";
    private static final String TAG = "MovieExporter";
    public static final int VIDEO_EXPORT_HEIGHT = 1280;
    public static final int VIDEO_EXPORT_WIDTH = 720;
    private AssetExportSession compressSession;
    private EncoderWriter.OutputConfig defaultOutputConfig;
    private AssetExportSession.ErrorInterceptor errorInterceptor;
    private ExportListener exportListener;
    private AssetExportSession exportSession;
    private volatile boolean isCanceled;
    private volatile boolean isCompressCanceled;
    private volatile boolean isCompressing;
    private volatile boolean isExporting;
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* renamed from: com.tencent.qcircle.tavcut.exporter.MovieExporter$3, reason: invalid class name */
    /* loaded from: classes22.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus;

        static {
            int[] iArr = new int[AssetExportSession.AssetExportSessionStatus.values().length];
            $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus = iArr;
            try {
                iArr[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusUnknown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface ExportListener {
        void onExportCancel();

        void onExportCompleted(String str);

        void onExportError(AssetExportSession assetExportSession);

        void onExportStart();

        void onExporting(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface VideoCompressListener {
        void onCompressCanceled();

        void onCompressError(AssetExportSession assetExportSession);

        void onCompressFinish(String str);

        void onCompressStart();

        void onCompressing(float f16);
    }

    public MovieExporter() {
        EncoderWriter.OutputConfig outputConfig = new EncoderWriter.OutputConfig();
        this.defaultOutputConfig = outputConfig;
        outputConfig.VIDEO_TARGET_WIDTH = 720;
        outputConfig.VIDEO_TARGET_HEIGHT = 1280;
        outputConfig.VIDEO_FRAME_RATE = 30;
    }

    private long getVideoDuration(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
    }

    @NonNull
    private File newCompressOutputFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        try {
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                throw new RuntimeException("\u521b\u5efa\u7236\u8def\u5f84\u5931\u8d25");
            }
            if (file.createNewFile()) {
                return file;
            }
            throw new RuntimeException("\u521b\u5efa\u8f93\u51fa\u6587\u4ef6\u5931\u8d25");
        } catch (IOException e16) {
            Logger.e("MovieExporter", "export: ", e16);
            throw new RuntimeException("\u521b\u5efa\u8f93\u51fa\u6587\u4ef6\u5931\u8d25", e16);
        }
    }

    @NonNull
    private File newOutputFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        try {
            if (file.createNewFile()) {
                return file;
            }
            throw new RuntimeException("\u521b\u5efa\u8f93\u51fa\u6587\u4ef6\u5931\u8d25");
        } catch (IOException e16) {
            Logger.e("MovieExporter", "export: ", e16);
            throw new RuntimeException("\u521b\u5efa\u8f93\u51fa\u6587\u4ef6\u5931\u8d25", e16);
        }
    }

    public void cancelCompress() {
        if (this.compressSession != null) {
            this.isCompressCanceled = true;
            this.compressSession.cancelExport();
        }
        this.isCompressing = false;
    }

    public void cancelExport() {
        if (this.exportSession != null) {
            this.isCanceled = true;
            this.exportSession.cancelExport();
        }
        this.isExporting = false;
    }

    public void compressVideo(String str, VideoCompressListener videoCompressListener) {
        if (str != null && str.length() > 0) {
            compressVideo(str, str.replace(".", "_compress."), null, videoCompressListener);
            return;
        }
        throw new RuntimeException("input path should not be empty");
    }

    public void export(TAVComposition tAVComposition, final String str, EncoderWriter.OutputConfig outputConfig) {
        if (tAVComposition == null) {
            return;
        }
        if (outputConfig == null) {
            outputConfig = this.defaultOutputConfig;
        }
        TAVSource buildSource = new TAVCompositionBuilder(tAVComposition).buildSource();
        Asset asset = buildSource.getAsset();
        AssetExportSession assetExportSession = new AssetExportSession(asset, outputConfig);
        this.exportSession = assetExportSession;
        assetExportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, tAVComposition.getDuration()));
        this.exportSession.setAudioMix(buildSource.getAudioMix());
        Logger.i("MovieExporter", "export composition duration: " + asset.getDuration());
        this.exportSession.setOutputFilePath(newOutputFile(str).getAbsolutePath());
        this.exportSession.setOutputFileType("mp4");
        this.exportSession.setVideoComposition(buildSource.getVideoComposition());
        this.exportSession.setErrorInterceptor(this.errorInterceptor);
        this.exportSession.exportAsynchronouslyWithCompletionHandler(new AssetExportSession.ExportCallbackHandler() { // from class: com.tencent.qcircle.tavcut.exporter.MovieExporter.2
            @Override // com.tencent.tav.core.AssetExportSession.ExportCallbackHandler
            public void handlerCallback(AssetExportSession assetExportSession2) {
                int i3 = AnonymousClass3.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[assetExportSession2.getStatus().ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3 && i3 != 4) {
                            if (i3 == 5) {
                                Logger.i("MovieExporter", "export cancel");
                                if (MovieExporter.this.exportListener != null && MovieExporter.this.isCanceled) {
                                    MovieExporter.this.isCanceled = false;
                                    MovieExporter.this.exportListener.onExportCancel();
                                }
                                MovieExporter.this.isExporting = false;
                                return;
                            }
                            return;
                        }
                        Logger.i("MovieExporter", "export error");
                        if (MovieExporter.this.exportListener != null) {
                            MovieExporter.this.exportListener.onExportError(assetExportSession2);
                        }
                        MovieExporter.this.isExporting = false;
                        return;
                    }
                    Logger.i("MovieExporter", "export progress finished");
                    if (MovieExporter.this.exportListener != null) {
                        MovieExporter.this.exportListener.onExportCompleted(str);
                    }
                    MovieExporter.this.isExporting = false;
                    return;
                }
                if (MovieExporter.this.exportListener != null) {
                    if (!MovieExporter.this.isExporting) {
                        MovieExporter.this.exportListener.onExportStart();
                    }
                    MovieExporter.this.exportListener.onExporting(assetExportSession2.getProgress());
                }
                MovieExporter.this.isExporting = true;
            }
        });
        RenderContextParams renderContextParams = new RenderContextParams();
        renderContextParams.putParam(IS_VIDEO_EXPORT, Boolean.TRUE);
        this.exportSession.setRenderContextParams(renderContextParams);
    }

    public boolean isExporting() {
        return this.isExporting;
    }

    public void setErrorInterceptor(AssetExportSession.ErrorInterceptor errorInterceptor) {
        this.errorInterceptor = errorInterceptor;
    }

    public void setExportListener(ExportListener exportListener) {
        this.exportListener = exportListener;
    }

    public void setOutputConfig(EncoderWriter.OutputConfig outputConfig) {
        this.defaultOutputConfig = outputConfig;
    }

    public void compressVideo(String str, String str2, VideoCompressListener videoCompressListener) {
        compressVideo(str, str2, null, videoCompressListener);
    }

    public void compressVideo(String str, final String str2, EncoderWriter.OutputConfig outputConfig, final VideoCompressListener videoCompressListener) {
        if (str != null && str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            TAVClip tAVClip = new TAVClip(new URLAsset(str));
            tAVClip.getResource().setSourceTimeRange(new CMTimeRange(new CMTime(0L), new CMTime(((float) getVideoDuration(str)) / 1000.0f)));
            arrayList.add(tAVClip);
            TAVComposition tAVComposition = new TAVComposition(arrayList);
            if (outputConfig == null) {
                outputConfig = this.defaultOutputConfig;
            }
            TAVSource buildSource = new TAVCompositionBuilder(tAVComposition).buildSource();
            Asset asset = buildSource.getAsset();
            AssetExportSession assetExportSession = new AssetExportSession(asset, outputConfig);
            this.compressSession = assetExportSession;
            assetExportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, tAVComposition.getDuration()));
            this.compressSession.setAudioMix(buildSource.getAudioMix());
            Logger.i("MovieExporter", "export composition duration: " + asset.getDuration());
            this.compressSession.setOutputFilePath(newCompressOutputFile(str2).getAbsolutePath());
            this.compressSession.setOutputFileType("mp4");
            this.compressSession.setVideoComposition(buildSource.getVideoComposition());
            this.compressSession.setErrorInterceptor(this.errorInterceptor);
            this.compressSession.exportAsynchronouslyWithCompletionHandler(new AssetExportSession.ExportCallbackHandler() { // from class: com.tencent.qcircle.tavcut.exporter.MovieExporter.1
                @Override // com.tencent.tav.core.AssetExportSession.ExportCallbackHandler
                public void handlerCallback(final AssetExportSession assetExportSession2) {
                    int i3 = AnonymousClass3.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[assetExportSession2.getStatus().ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3 && i3 != 4) {
                                if (i3 == 5) {
                                    MovieExporter.this.isCompressCanceled = false;
                                    MovieExporter.this.mainHandler.post(new Runnable() { // from class: com.tencent.qcircle.tavcut.exporter.MovieExporter.1.4
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            if (videoCompressListener != null && MovieExporter.this.isCompressCanceled) {
                                                videoCompressListener.onCompressCanceled();
                                            }
                                        }
                                    });
                                    MovieExporter.this.isCompressing = false;
                                    return;
                                }
                                return;
                            }
                            Logger.i("MovieExporter", "export error");
                            MovieExporter.this.mainHandler.post(new Runnable() { // from class: com.tencent.qcircle.tavcut.exporter.MovieExporter.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    VideoCompressListener videoCompressListener2 = videoCompressListener;
                                    if (videoCompressListener2 != null) {
                                        videoCompressListener2.onCompressError(assetExportSession2);
                                    }
                                }
                            });
                            MovieExporter.this.isCompressing = false;
                            return;
                        }
                        Logger.i("MovieExporter", "export progress finished");
                        MovieExporter.this.mainHandler.post(new Runnable() { // from class: com.tencent.qcircle.tavcut.exporter.MovieExporter.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                VideoCompressListener videoCompressListener2 = videoCompressListener;
                                if (videoCompressListener2 != null) {
                                    videoCompressListener2.onCompressFinish(str2);
                                }
                            }
                        });
                        MovieExporter.this.isCompressing = false;
                        return;
                    }
                    MovieExporter.this.mainHandler.post(new Runnable() { // from class: com.tencent.qcircle.tavcut.exporter.MovieExporter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (videoCompressListener != null) {
                                if (!MovieExporter.this.isCompressing) {
                                    videoCompressListener.onCompressStart();
                                }
                                videoCompressListener.onCompressing(assetExportSession2.getProgress());
                            }
                        }
                    });
                    MovieExporter.this.isCompressing = true;
                }
            });
            RenderContextParams renderContextParams = new RenderContextParams();
            renderContextParams.putParam(IS_VIDEO_EXPORT, Boolean.TRUE);
            this.compressSession.setRenderContextParams(renderContextParams);
            return;
        }
        throw new RuntimeException("input path should not be empty");
    }

    public void export(TAVComposition tAVComposition, String str) {
        export(tAVComposition, str, this.defaultOutputConfig);
    }
}
