package com.tencent.tavcut.core.render.video;

import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.core.render.video.IReverseVideoProcessor;
import com.tencent.tavcut.core.utils.d;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.videocut.utils.VideoUtils;
import com.tencent.videocut.utils.g;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.TimeRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J*\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/tavcut/core/render/video/TavReverseVideoProcessor;", "Lcom/tencent/tavcut/core/render/video/IReverseVideoProcessor;", "()V", "createExportConfig", "Lcom/tencent/tav/core/ExportConfig;", "videoPath", "", "createReverseTavExporter", "Lcom/tencent/tavkit/component/TAVExporter;", "listener", "Lcom/tencent/tavcut/core/render/video/OnReverseVideoListener;", "createTavComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "timeRange", "Lorg/light/TimeRange;", "reverseVideoFromPath", "Lcom/tencent/tavcut/core/render/video/IReverseVideoProcessor$Canceler;", "outputPath", "Companion", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TavReverseVideoProcessor implements IReverseVideoProcessor {
    private static final int CHANNEL_COUNT = 1;
    private static final int DEFAULT_AUDIO_CACHE = 10;
    private static final int DEFAULT_VIDEO_CACHE = 30;
    public static final int ERR_CODE_CREATE_FILE_FAILED = -2;
    public static final int ERR_CODE_REVERSE_FAILED = -1;
    private static final int FRAME_RATE = 30;
    private static final int I_FRAME_INTERVAL_S = 1;
    private static final int MAX_PROGRESS = 100;
    private static final String TAG = "TavReverseVideoProcessor";

    private final ExportConfig createExportConfig(String videoPath) {
        VideoUtils videoUtils = VideoUtils.f384231a;
        Pair<Integer, Integer> c16 = videoUtils.c(videoPath);
        ExportConfig exportConfig = new ExportConfig(c16.getFirst().intValue(), c16.getSecond().intValue());
        exportConfig.setVideoBitRate(videoUtils.b(videoPath));
        exportConfig.setVideoFrameRate(30);
        exportConfig.setVideoIFrameInterval(1);
        exportConfig.setAudioChannelCount(1);
        return exportConfig;
    }

    private final TAVExporter createReverseTavExporter(final OnReverseVideoListener listener) {
        TAVExporter tAVExporter = new TAVExporter();
        tAVExporter.setVideoRevertMode(true);
        tAVExporter.setAudioRevertMode(true);
        tAVExporter.setAudioRevertCacheSamples(10);
        tAVExporter.setVideoRevertCacheFrames(30);
        tAVExporter.setExportListener(new TAVExporter.ExportListener() { // from class: com.tencent.tavcut.core.render.video.TavReverseVideoProcessor$createReverseTavExporter$$inlined$apply$lambda$1
            @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
            public void onExportCancel() {
                OnReverseVideoListener.this.onCancel();
            }

            @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
            public void onExportCompleted(@Nullable String str) {
                boolean z16;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    OnReverseVideoListener.this.onFailure(-1, "Reverse video failed");
                } else {
                    OnReverseVideoListener.this.onProgress(100);
                    OnReverseVideoListener.this.onSuccess(str);
                }
            }

            @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
            public void onExportError(@Nullable AssetExportSession assetExportSession) {
                ExportErrorStatus exportErrorStatus;
                int i3;
                String str;
                if (assetExportSession != null) {
                    exportErrorStatus = assetExportSession.getExportErrorStatus();
                } else {
                    exportErrorStatus = null;
                }
                if (exportErrorStatus != null) {
                    i3 = exportErrorStatus.code;
                } else {
                    i3 = -1;
                }
                OnReverseVideoListener onReverseVideoListener = OnReverseVideoListener.this;
                if (exportErrorStatus == null || (str = exportErrorStatus.f374239msg) == null) {
                    str = "Reverse video failed";
                }
                onReverseVideoListener.onFailure(i3, str);
            }

            @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
            public void onExporting(float f16, long j3, long j16, long j17) {
                OnReverseVideoListener.this.onProgress((int) (f16 * 100));
            }

            @Override // com.tencent.tavkit.component.TAVExporter.ExportListener
            public void onExportStart() {
            }
        });
        return tAVExporter;
    }

    private final TAVComposition createTavComposition(String videoPath, TimeRange timeRange) {
        List listOf;
        URLAsset a16 = d.a(videoPath);
        if (a16 != null) {
            TAVAssetTrackResource tAVAssetTrackResource = new TAVAssetTrackResource(a16);
            tAVAssetTrackResource.setSourceTimeRange(new CMTimeRange(CMTime.fromUs(timeRange.startTime), CMTime.fromUs(timeRange.duration)));
            tAVAssetTrackResource.setScaledDuration(CMTime.fromUs(timeRange.duration));
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new TAVClip(tAVAssetTrackResource));
            return new TAVComposition((List<TAVClip>) listOf);
        }
        return null;
    }

    @Override // com.tencent.tavcut.core.render.video.IReverseVideoProcessor
    @Nullable
    public IReverseVideoProcessor.Canceler reverseVideoFromPath(@NotNull String videoPath, @NotNull String outputPath, @NotNull TimeRange timeRange, @NotNull OnReverseVideoListener listener) {
        Intrinsics.checkParameterIsNotNull(videoPath, "videoPath");
        Intrinsics.checkParameterIsNotNull(outputPath, "outputPath");
        Intrinsics.checkParameterIsNotNull(timeRange, "timeRange");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        final TAVExporter createReverseTavExporter = createReverseTavExporter(listener);
        TAVComposition createTavComposition = createTavComposition(videoPath, timeRange);
        if (createTavComposition == null) {
            TavLogger.e(TAG, "createTavComposition failed");
            listener.onFailure(-2, "Create file failed");
            return null;
        }
        File d16 = g.f384239a.d(outputPath);
        if (d16 == null) {
            TavLogger.e(TAG, "Create file failed");
            listener.onFailure(-2, "Create file failed");
            return null;
        }
        createReverseTavExporter.export(createTavComposition, d16.getAbsolutePath(), createExportConfig(videoPath));
        return new IReverseVideoProcessor.Canceler() { // from class: com.tencent.tavcut.core.render.video.TavReverseVideoProcessor$reverseVideoFromPath$1
            @Override // com.tencent.tavcut.core.render.video.IReverseVideoProcessor.Canceler
            public void cancel() {
                TAVExporter.this.cancelExport();
            }
        };
    }
}
