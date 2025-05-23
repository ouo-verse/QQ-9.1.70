package com.tencent.tavkit.component;

import androidx.annotation.NonNull;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVExportSession {
    private AssetExportSession.ExportCallbackHandler callbackHandler;
    private AssetExportSession exportSession;
    private final String mTAG = "TAVExporterSession@" + Integer.toHexString(hashCode());

    public TAVExportSession(TAVComposition tAVComposition, @NotNull ExportConfig exportConfig) {
        TAVSource buildSource = new TAVCompositionBuilder(tAVComposition).buildSource();
        AssetExportSession assetExportSession = new AssetExportSession(buildSource.getAsset(), exportConfig);
        this.exportSession = assetExportSession;
        assetExportSession.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, tAVComposition.getDuration()));
        this.exportSession.setAudioMix(buildSource.getAudioMix());
        this.exportSession.setVideoComposition(buildSource.getVideoComposition());
        this.exportSession.setOutputFilePath(newOutputFile(exportConfig.getOutputFilePath()).getAbsolutePath());
        this.exportSession.setOutputFileType("mp4");
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

    public void setCallbackHandler(AssetExportSession.ExportCallbackHandler exportCallbackHandler) {
        this.callbackHandler = exportCallbackHandler;
    }

    public void setErrorInterceptor(AssetExportSession.ErrorInterceptor errorInterceptor) {
        this.exportSession.setErrorInterceptor(errorInterceptor);
    }

    public void start() {
        if (this.exportSession.getStatus() != null) {
            return;
        }
        this.exportSession.exportAsynchronouslyWithCompletionHandler(this.callbackHandler);
    }
}
