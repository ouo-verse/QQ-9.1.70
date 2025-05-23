package com.tencent.qcircle.tavcut.compressor;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.decoder.EncoderWriter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoCompressor {
    public static final int VIDEO_EXPORT_HEIGHT = 1280;
    public static final int VIDEO_EXPORT_WIDTH = 720;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface VideoCompressListener {
        void onCompressCanceled();

        void onCompressError(AssetExportSession assetExportSession);

        void onCompressFinish(String str);

        void onCompressStart();

        void onCompressing(float f16);
    }

    private EncoderWriter.OutputConfig getDefaultOutputConfig() {
        EncoderWriter.OutputConfig outputConfig = new EncoderWriter.OutputConfig();
        outputConfig.VIDEO_TARGET_WIDTH = 720;
        outputConfig.VIDEO_TARGET_HEIGHT = 1280;
        outputConfig.VIDEO_FRAME_RATE = 30;
        return outputConfig;
    }
}
