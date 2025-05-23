package com.tencent.tav.core;

import android.opengl.EGLContext;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.core.AssetWriterInput;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tav.report.ExportReportSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AssetWriter implements AssetWriterInput.StatusListener, IContextCreate {
    public static final int MAX_BIT_RATE = 8000000;
    private static final String TAG = "AssetWriter";
    private List<Integer> availableMediaTypes;
    private String directoryForTemporaryFiles;
    private ExportConfig encodeOption;
    private EncoderWriter encoderWriter;
    private int errCode;
    private List<MetadataItem> metadata;
    private String outputFileType;
    private RenderContext renderContext;
    private RenderContextParams renderContextParams;
    private ExportReportSession reportSession;
    private boolean shouldOptimizeForNetworkUse;
    private AssetWriterStatus status;
    private String videoOutputPath;
    private List<AssetWriterInput> inputs = new ArrayList();
    private HashMap<AssetWriterInput, AssetWriterStatus> inputStatusHashMap = new HashMap<>();
    CMTime startTime = new CMTime(0L);
    private CMTime endTime = new CMTime(Long.MAX_VALUE);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum AssetWriterStatus {
        AssetWriterStatusUnknown,
        AssetWriterStatusWriting,
        AssetWriterStatusCompleted,
        AssetWriterStatusFailed,
        AssetWriterStatusCancelled
    }

    public AssetWriter(String str, String str2) {
        this.videoOutputPath = str;
        this.outputFileType = str2;
    }

    private void updateAssetStatus() {
        boolean z16;
        Iterator<AssetWriterInput> it = this.inputs.iterator();
        boolean z17 = true;
        while (true) {
            boolean z18 = false;
            if (!it.hasNext()) {
                break;
            }
            if (this.inputStatusHashMap.get(it.next()) == AssetWriterStatus.AssetWriterStatusCompleted) {
                z18 = true;
            }
            z17 &= z18;
        }
        if (z17) {
            this.status = AssetWriterStatus.AssetWriterStatusCancelled;
            return;
        }
        boolean z19 = true;
        for (AssetWriterInput assetWriterInput : this.inputs) {
            if (this.inputStatusHashMap.get(assetWriterInput) != AssetWriterStatus.AssetWriterStatusWriting && this.inputStatusHashMap.get(assetWriterInput) != AssetWriterStatus.AssetWriterStatusCompleted) {
                z16 = false;
            } else {
                z16 = true;
            }
            z19 &= z16;
        }
        if (z19) {
            this.status = AssetWriterStatus.AssetWriterStatusWriting;
            return;
        }
        Iterator<AssetWriterInput> it5 = this.inputs.iterator();
        while (it5.hasNext()) {
            AssetWriterStatus assetWriterStatus = this.inputStatusHashMap.get(it5.next());
            AssetWriterStatus assetWriterStatus2 = AssetWriterStatus.AssetWriterStatusFailed;
            if (assetWriterStatus == assetWriterStatus2) {
                this.status = assetWriterStatus2;
                return;
            }
        }
        Iterator<AssetWriterInput> it6 = this.inputs.iterator();
        while (it6.hasNext()) {
            AssetWriterStatus assetWriterStatus3 = this.inputStatusHashMap.get(it6.next());
            AssetWriterStatus assetWriterStatus4 = AssetWriterStatus.AssetWriterStatusCancelled;
            if (assetWriterStatus3 == assetWriterStatus4) {
                this.status = assetWriterStatus4;
                return;
            }
        }
    }

    public void addInput(@NonNull AssetWriterInput assetWriterInput) {
        if (canAddInput(assetWriterInput)) {
            this.inputs.add(assetWriterInput);
            assetWriterInput.addStatusListener(this);
        }
    }

    public boolean canAddInput(@NonNull AssetWriterInput assetWriterInput) {
        Iterator<AssetWriterInput> it = this.inputs.iterator();
        while (it.hasNext()) {
            if (it.next().getMediaType() == assetWriterInput.getMediaType()) {
                return false;
            }
        }
        return true;
    }

    public void cancelWriting() {
        EncoderWriter encoderWriter = this.encoderWriter;
        if (encoderWriter != null) {
            encoderWriter.stop();
            this.encoderWriter = null;
        }
        Iterator<AssetWriterInput> it = this.inputs.iterator();
        while (it.hasNext()) {
            this.inputStatusHashMap.put(it.next(), AssetWriterStatus.AssetWriterStatusCancelled);
        }
        this.status = AssetWriterStatus.AssetWriterStatusCancelled;
    }

    public EncoderWriter encoderWriter() {
        return this.encoderWriter;
    }

    public void endSessionAtSourceTime(CMTime cMTime) {
        this.endTime = cMTime;
    }

    public boolean finishWriting() {
        EncoderWriter encoderWriter = this.encoderWriter;
        if (encoderWriter != null) {
            encoderWriter.stop();
            this.encoderWriter = null;
        }
        this.status = AssetWriterStatus.AssetWriterStatusCompleted;
        RenderContext renderContext = this.renderContext;
        if (renderContext != null) {
            renderContext.release();
            this.renderContext = null;
            return true;
        }
        return true;
    }

    public List<Integer> getAvailableMediaTypes() {
        return this.availableMediaTypes;
    }

    public String getDirectoryForTemporaryFiles() {
        return this.directoryForTemporaryFiles;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public List<AssetWriterInput> getInputs() {
        return this.inputs;
    }

    public List<MetadataItem> getMetadata() {
        return this.metadata;
    }

    public String getOutputFileType() {
        return this.outputFileType;
    }

    public RenderContextParams getRenderContextParams() {
        return this.renderContextParams;
    }

    public AssetWriterStatus getStatus() {
        return this.status;
    }

    public String getVideoOutputPath() {
        return this.videoOutputPath;
    }

    public boolean isShouldOptimizeForNetworkUse() {
        return this.shouldOptimizeForNetworkUse;
    }

    @Override // com.tencent.tav.core.IContextCreate
    @RequiresApi(api = 18)
    public RenderContext renderContext() {
        EGLContext eGLContext;
        if (this.renderContext == null && this.encoderWriter != null) {
            RenderContextParams renderContextParams = this.renderContextParams;
            if (renderContextParams != null && (renderContextParams.getParam("share_context") instanceof EGLContext)) {
                eGLContext = (EGLContext) this.renderContextParams.getParam("share_context");
            } else {
                eGLContext = null;
            }
            if (eGLContext != null) {
                EncoderWriter encoderWriter = this.encoderWriter;
                this.renderContext = encoderWriter.createRenderContext(encoderWriter.getOutWidth(), this.encoderWriter.getOutHeight(), eGLContext);
            } else {
                EncoderWriter encoderWriter2 = this.encoderWriter;
                this.renderContext = encoderWriter2.createRenderContext(encoderWriter2.getOutWidth(), this.encoderWriter.getOutHeight());
            }
            this.renderContext.setParams(this.renderContextParams);
        }
        return this.renderContext;
    }

    public void setDirectoryForTemporaryFiles(String str) {
        this.directoryForTemporaryFiles = str;
    }

    public void setEncodeOption(ExportConfig exportConfig) {
        this.encodeOption = exportConfig;
    }

    public void setMetadata(List<MetadataItem> list) {
        this.metadata = list;
    }

    public void setRenderContextParams(RenderContextParams renderContextParams) {
        this.renderContextParams = renderContextParams;
        RenderContext renderContext = this.renderContext;
        if (renderContext != null) {
            renderContext.setParams(renderContextParams);
        }
    }

    public void setReportSession(ExportReportSession exportReportSession) {
        this.reportSession = exportReportSession;
    }

    public void setShouldOptimizeForNetworkUse(boolean z16) {
        this.shouldOptimizeForNetworkUse = z16;
    }

    public void startSessionAtSourceTime(CMTime cMTime) {
        this.startTime = cMTime;
    }

    @RequiresApi(api = 18)
    public boolean startWriting(AssetWriterVideoEncoder assetWriterVideoEncoder, MediaMuxerFactory.MediaMuxerCreator mediaMuxerCreator) {
        if (this.videoOutputPath == null) {
            return false;
        }
        cancelWriting();
        try {
            EncoderWriter encoderWriter = new EncoderWriter(this.videoOutputPath, assetWriterVideoEncoder, mediaMuxerCreator);
            this.encoderWriter = encoderWriter;
            encoderWriter.setEncodeOption(this.encodeOption);
            this.encoderWriter.setReportSession(this.reportSession);
            Iterator<AssetWriterInput> it = this.inputs.iterator();
            while (it.hasNext()) {
                it.next().initConfig(this);
            }
            return true;
        } catch (Exception e16) {
            Logger.e(TAG, "startWriting: ", e16);
            this.inputStatusHashMap.clear();
            EncoderWriter encoderWriter2 = this.encoderWriter;
            if (encoderWriter2 != null) {
                encoderWriter2.stop();
                this.encoderWriter = null;
            }
            return false;
        }
    }

    @Override // com.tencent.tav.core.AssetWriterInput.StatusListener
    public void statusChanged(AssetWriterInput assetWriterInput, AssetWriterStatus assetWriterStatus) {
        this.inputStatusHashMap.put(assetWriterInput, assetWriterStatus);
        AssetWriterStatus assetWriterStatus2 = this.status;
        updateAssetStatus();
        AssetWriterStatus assetWriterStatus3 = this.status;
        if (assetWriterStatus2 != assetWriterStatus3 && assetWriterStatus3 == AssetWriterStatus.AssetWriterStatusWriting) {
            for (AssetWriterInput assetWriterInput2 : this.inputs) {
            }
        }
    }
}
