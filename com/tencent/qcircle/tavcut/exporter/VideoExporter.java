package com.tencent.qcircle.tavcut.exporter;

import com.tencent.qcircle.tavcut.exporter.MovieExporter;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tavkit.composition.TAVComposition;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoExporter {
    private MovieExporter movieExporter;
    private TAVComposition tavComposition;
    private VideoExportConfig videoExportConfig;

    public void cancel() {
        MovieExporter movieExporter = this.movieExporter;
        if (movieExporter != null) {
            movieExporter.cancelExport();
            this.movieExporter = null;
        }
    }

    public void export(MovieExporter.ExportListener exportListener) {
        cancel();
        this.movieExporter = new MovieExporter();
        EncoderWriter.OutputConfig outputConfig = new EncoderWriter.OutputConfig();
        if (this.videoExportConfig.getWidth() != -1 && this.videoExportConfig.getHeight() != -1) {
            outputConfig.VIDEO_TARGET_WIDTH = this.videoExportConfig.getWidth();
            outputConfig.VIDEO_TARGET_HEIGHT = this.videoExportConfig.getHeight();
        }
        if (this.videoExportConfig.getBitRate() != -1) {
            outputConfig.VIDEO_BIT_RATE = this.videoExportConfig.getBitRate();
        }
        if (this.videoExportConfig.getFrameRate() != -1) {
            outputConfig.VIDEO_FRAME_RATE = this.videoExportConfig.getFrameRate();
        }
        this.movieExporter.setExportListener(exportListener);
        this.movieExporter.setErrorInterceptor(new AssetExportSession.ErrorInterceptor() { // from class: com.tencent.qcircle.tavcut.exporter.VideoExporter.1
            @Override // com.tencent.tav.core.AssetExportSession.ErrorInterceptor
            public boolean needRetry(AssetExportSession assetExportSession, int i3) {
                if (i3 > 0) {
                    return false;
                }
                com.tencent.tav.core.ExportConfig exportConfig = assetExportSession.getExportConfig();
                exportConfig.setAudioChannelCount(1);
                exportConfig.setHighProfile(false);
                exportConfig.reset();
                return true;
            }
        });
        this.movieExporter.export(this.tavComposition, this.videoExportConfig.getOutputPath(), outputConfig);
    }

    public MovieExporter getMovieExporter() {
        return this.movieExporter;
    }

    public void setMovieExporter(MovieExporter movieExporter) {
        this.movieExporter = movieExporter;
    }

    public void setTavComposition(TAVComposition tAVComposition) {
        this.tavComposition = tAVComposition;
    }

    public void setVideoExportConfig(VideoExportConfig videoExportConfig) {
        this.videoExportConfig = videoExportConfig;
    }
}
