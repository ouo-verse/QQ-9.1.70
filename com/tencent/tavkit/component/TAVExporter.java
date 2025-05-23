package com.tencent.tavkit.component;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.quick.export.QuickExporter;
import com.tencent.tav.quick.export.SegmentCombiner;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVExporter {
    private static final int VIDEO_EXPORT_HEIGHT = 1280;
    private static final int VIDEO_EXPORT_WIDTH = 720;
    private static final int VIDEO_FRAME_RATE = 30;
    private final ExportConfig defaultOutputConfig;
    private AssetExportSession.ErrorInterceptor errorInterceptor;
    private ExportListener exportListener;
    private AssetExportSession exportSession;
    private volatile boolean isCanceled;
    private volatile boolean isExporting;
    private int quickExportSegments;
    private final String mTAG = "GameTemplateExporter@" + Integer.toHexString(hashCode());
    private QuickExporter quickExporter = null;
    private AtomicInteger segmentProgressCount = new AtomicInteger(0);
    private float quickExportProgress = 100.0f;
    private float quickLastMaxProgress = -1.0f;
    private Object exportLock = new Object();
    private boolean videoRevertMode = false;
    private boolean audioRevertMode = false;
    private int audioRevertCacheSamples = 30;
    private int videoRevertCacheFrames = 60;

    /* compiled from: P */
    /* renamed from: com.tencent.tavkit.component.TAVExporter$2, reason: invalid class name */
    /* loaded from: classes26.dex */
    static /* synthetic */ class AnonymousClass2 {
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
    /* loaded from: classes26.dex */
    public interface ExportListener {
        void onExportCancel();

        void onExportCompleted(String str);

        void onExportError(AssetExportSession assetExportSession);

        void onExportStart();

        void onExporting(float f16, long j3, long j16, long j17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class MyExportCallbackHandler implements AssetExportSession.ExportCallbackHandler {
        private volatile boolean notifyStartFlag = false;
        private final String outputPath;

        public MyExportCallbackHandler(String str) {
            this.outputPath = str;
        }

        @Override // com.tencent.tav.core.AssetExportSession.ExportCallbackHandler
        public void handlerCallback(AssetExportSession assetExportSession) {
            if (TAVExporter.this.exportListener == null) {
                Logger.e(TAVExporter.this.mTAG, "handlerCallback exportListener is null");
                return;
            }
            int i3 = AnonymousClass2.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[assetExportSession.getStatus().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 4) {
                        if (i3 == 5) {
                            Logger.i(TAVExporter.this.mTAG, "export cancel");
                            if (TAVExporter.this.isCanceled) {
                                TAVExporter.this.isCanceled = false;
                                TAVExporter.this.exportListener.onExportCancel();
                            }
                            TAVExporter.this.isExporting = false;
                            return;
                        }
                        return;
                    }
                    Logger.i(TAVExporter.this.mTAG, "export error");
                    TAVExporter.this.exportListener.onExportError(assetExportSession);
                    TAVExporter.this.isExporting = false;
                    return;
                }
                Logger.i(TAVExporter.this.mTAG, "export progress finished");
                TAVExporter.this.exportListener.onExportCompleted(this.outputPath);
                TAVExporter.this.isExporting = false;
                return;
            }
            if (!this.notifyStartFlag) {
                TAVExporter.this.exportListener.onExportStart();
                this.notifyStartFlag = true;
            }
            TAVExporter.this.exportListener.onExporting(assetExportSession.getProgress(), assetExportSession.getVideoTime(), assetExportSession.getAudioTime(), assetExportSession.getTotalTime());
            TAVExporter.this.isExporting = true;
        }
    }

    public TAVExporter() {
        ExportConfig exportConfig = new ExportConfig(720, 1280);
        this.defaultOutputConfig = exportConfig;
        exportConfig.setVideoFrameRate(30);
    }

    private void createExportSession(TAVComposition tAVComposition, String str, ExportConfig exportConfig) {
        AssetExportSession assetExportSession = this.exportSession;
        if (assetExportSession != null) {
            assetExportSession.cancelExport();
            this.exportSession = null;
        }
        if (exportConfig == null) {
            exportConfig = this.defaultOutputConfig;
        }
        TAVSource buildSource = new TAVCompositionBuilder(tAVComposition).buildSource();
        Asset asset = buildSource.getAsset();
        AssetExportSession assetExportSession2 = new AssetExportSession(asset, exportConfig);
        this.exportSession = assetExportSession2;
        assetExportSession2.setVideoRevertMode(this.videoRevertMode);
        this.exportSession.setAudioRevertModel(this.audioRevertMode);
        this.exportSession.setAudioRevertCacheSamples(this.audioRevertCacheSamples);
        this.exportSession.setVideoRevertCacheFrames(this.videoRevertCacheFrames);
        this.exportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, asset.getDuration()));
        this.exportSession.setAudioMix(buildSource.getAudioMix());
        Logger.i(this.mTAG, "export composition duration: " + asset.getDuration());
        File newOutputFile = newOutputFile(str);
        this.exportSession.setErrorInterceptor(this.errorInterceptor);
        this.exportSession.setOutputFilePath(newOutputFile.getAbsolutePath());
        this.exportSession.setOutputFileType("mp4");
        this.exportSession.setVideoComposition(buildSource.getVideoComposition());
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
            Logger.e(this.mTAG, "export: ", e16);
            throw new RuntimeException("\u521b\u5efa\u8f93\u51fa\u6587\u4ef6\u5931\u8d25", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetQuickExport() {
        this.quickExportSegments = 0;
        this.segmentProgressCount.set(0);
        this.quickExportProgress = 100.0f;
        this.quickLastMaxProgress = -1.0f;
    }

    public void cancelExport() {
        synchronized (this.exportLock) {
            if (this.exportSession != null) {
                this.isCanceled = true;
                this.exportSession.cancelExport();
            }
            QuickExporter quickExporter = this.quickExporter;
            if (quickExporter != null) {
                quickExporter.cancelExport();
                this.quickExporter = null;
                resetQuickExport();
            } else {
                Logger.e(this.mTAG, "QuickExporter: cancelExport quickExporter is null");
            }
        }
        this.isExporting = false;
    }

    @Deprecated
    public void export(TAVComposition tAVComposition, String str, EncoderWriter.OutputConfig outputConfig) {
        export(tAVComposition, str, new ExportConfig(outputConfig));
    }

    public boolean isExporting() {
        return this.isExporting;
    }

    public void quickExport(String str, TAVComposition tAVComposition, String str2, ExportConfig exportConfig, int i3) {
        synchronized (this.exportLock) {
            if (tAVComposition != null) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    createExportSession(tAVComposition, str2, exportConfig);
                    final MyExportCallbackHandler myExportCallbackHandler = new MyExportCallbackHandler(str2);
                    this.quickExportSegments = i3;
                    this.quickExporter = new QuickExporter(str, this.exportSession, exportConfig, i3, myExportCallbackHandler);
                    Logger.i(this.mTAG, "QuickExporter create quickExporter");
                    this.quickExporter.setSegmentCombinerListener(new SegmentCombiner.VideoCombineListener() { // from class: com.tencent.tavkit.component.TAVExporter.1
                        @Override // com.tencent.tav.quick.export.SegmentCombiner.VideoCombineListener
                        public void onCombineFinished(boolean z16) {
                            String str3;
                            AssetExportSession.AssetExportSessionStatus assetExportSessionStatus;
                            String str4 = TAVExporter.this.mTAG;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("quick export result ");
                            if (z16) {
                                str3 = " suc";
                            } else {
                                str3 = " failed";
                            }
                            sb5.append(str3);
                            Logger.e(str4, sb5.toString());
                            TAVExporter.this.resetQuickExport();
                            AssetExportSession assetExportSession = TAVExporter.this.exportSession;
                            if (z16) {
                                assetExportSessionStatus = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted;
                            } else {
                                assetExportSessionStatus = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed;
                            }
                            assetExportSession.setStatus(assetExportSessionStatus);
                            AssetExportSession.ExportCallbackHandler exportCallbackHandler = myExportCallbackHandler;
                            if (exportCallbackHandler != null) {
                                exportCallbackHandler.handlerCallback(TAVExporter.this.exportSession);
                            } else {
                                Logger.e(TAVExporter.this.mTAG, "VideoCombineListener onCombineFinished callbackHandler is null");
                            }
                        }

                        @Override // com.tencent.tav.quick.export.SegmentCombiner.VideoCombineListener
                        public void onCombineProcessing(float f16) {
                            TAVExporter tAVExporter = TAVExporter.this;
                            tAVExporter.quickExportProgress = Math.min(tAVExporter.quickExportProgress, f16);
                            if (TAVExporter.this.segmentProgressCount.incrementAndGet() == TAVExporter.this.quickExportSegments) {
                                TAVExporter tAVExporter2 = TAVExporter.this;
                                tAVExporter2.quickExportProgress = tAVExporter2.quickExportProgress > TAVExporter.this.quickLastMaxProgress ? TAVExporter.this.quickExportProgress : TAVExporter.this.quickLastMaxProgress;
                                TAVExporter tAVExporter3 = TAVExporter.this;
                                tAVExporter3.quickLastMaxProgress = tAVExporter3.quickExportProgress;
                                TAVExporter.this.exportSession.setProgress(TAVExporter.this.quickExportProgress);
                                TAVExporter tAVExporter4 = TAVExporter.this;
                                if (f16 <= tAVExporter4.quickExportProgress) {
                                    f16 = TAVExporter.this.quickExportProgress;
                                }
                                tAVExporter4.quickExportProgress = f16;
                                TAVExporter.this.exportSession.setStatus(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting);
                                myExportCallbackHandler.handlerCallback(TAVExporter.this.exportSession);
                                TAVExporter.this.segmentProgressCount.set(0);
                            }
                        }

                        @Override // com.tencent.tav.quick.export.SegmentCombiner.VideoCombineListener
                        public void onCombineStart() {
                        }
                    });
                    this.quickExporter.startExport();
                    this.isExporting = true;
                }
            }
        }
    }

    public void setAudioRevertCacheSamples(int i3) {
        this.audioRevertCacheSamples = i3;
    }

    public void setAudioRevertMode(boolean z16) {
        this.audioRevertMode = z16;
    }

    public void setErrorInterceptor(AssetExportSession.ErrorInterceptor errorInterceptor) {
        this.errorInterceptor = errorInterceptor;
    }

    public void setExportListener(ExportListener exportListener) {
        this.exportListener = exportListener;
    }

    @Deprecated
    public void setRevertMode(boolean z16) {
        this.videoRevertMode = z16;
    }

    public void setVideoRevertCacheFrames(int i3) {
        this.videoRevertCacheFrames = i3;
    }

    public void setVideoRevertMode(boolean z16) {
        this.videoRevertMode = z16;
    }

    public void export(TAVComposition tAVComposition, String str, ExportConfig exportConfig) {
        synchronized (this.exportLock) {
            if (tAVComposition == null) {
                return;
            }
            createExportSession(tAVComposition, str, exportConfig);
            this.exportSession.exportAsynchronouslyWithCompletionHandler(new MyExportCallbackHandler(str));
            this.isExporting = true;
        }
    }

    public void export(TAVComposition tAVComposition, String str) {
        export(tAVComposition, str, this.defaultOutputConfig);
    }
}
