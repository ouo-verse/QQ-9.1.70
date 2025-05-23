package com.tencent.tav.core.compositing;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.ErrorMsg;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AsynchronousVideoCompositionRequest {
    private final AssetExtension assetExtension;
    private final Object authorComposition;
    private CMTime compositionTime;
    private volatile ErrorMsg error;
    private VideoCompositionRenderContext renderContext;
    private IVideoCompositionInstruction videoCompositionInstruction;
    private List<Integer> sourceTrackIDs = new ArrayList();
    private volatile CMSampleBuffer composedVideoFrame = null;

    @RequestStatus
    private volatile int status = Integer.MIN_VALUE;
    private SparseArray<CMSampleBuffer> sampleBuffers = new SparseArray<>();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public @interface RequestStatus {
        public static final int Cancel = 1;
        public static final int Error = -1;
        public static final int Success = 0;
        public static final int UnKnow = Integer.MIN_VALUE;
    }

    public AsynchronousVideoCompositionRequest(@Nullable Object obj, @NonNull AssetExtension assetExtension) {
        this.authorComposition = obj;
        this.assetExtension = assetExtension;
    }

    private void notifyFinish() {
        Object obj = this.authorComposition;
        if (obj != null) {
            synchronized (obj) {
                this.authorComposition.notifyAll();
            }
        }
    }

    public void appendCMSampleBuffer(CMSampleBuffer cMSampleBuffer, int i3) {
        this.sampleBuffers.put(i3, cMSampleBuffer);
        this.sourceTrackIDs.add(Integer.valueOf(i3));
    }

    public void finishCancelledRequest() {
        synchronized (this) {
            this.status = 1;
        }
        notifyFinish();
    }

    public void finishWithComposedVideoFrame(@NonNull CMSampleBuffer cMSampleBuffer) {
        synchronized (this) {
            this.composedVideoFrame = cMSampleBuffer;
            this.status = 0;
        }
        notifyFinish();
    }

    public void finishWithError(ErrorMsg errorMsg) {
        synchronized (this) {
            this.error = errorMsg;
            this.status = -1;
        }
        notifyFinish();
    }

    public AssetExtension getAssetExtension() {
        return this.assetExtension;
    }

    public synchronized CMSampleBuffer getComposedSampleBuffer() {
        return this.composedVideoFrame;
    }

    public CMTime getCompositionTime() {
        return this.compositionTime;
    }

    public VideoCompositionRenderContext getRenderContext() {
        return this.renderContext;
    }

    public List<Integer> getSourceTrackIDs() {
        return this.sourceTrackIDs;
    }

    @RequestStatus
    public synchronized int getStatus() {
        return this.status;
    }

    public IVideoCompositionInstruction getVideoCompositionInstruction() {
        return this.videoCompositionInstruction;
    }

    public void setCompositionTime(CMTime cMTime) {
        this.compositionTime = cMTime;
    }

    public void setRenderContext(VideoCompositionRenderContext videoCompositionRenderContext) {
        this.renderContext = videoCompositionRenderContext;
    }

    public void setVideoCompositionInstruction(IVideoCompositionInstruction iVideoCompositionInstruction) {
        this.videoCompositionInstruction = iVideoCompositionInstruction;
    }

    public CMSampleBuffer sourceFrameByTrackID(int i3) {
        SparseArray<CMSampleBuffer> sparseArray = this.sampleBuffers;
        if (sparseArray != null) {
            return sparseArray.get(i3);
        }
        return null;
    }

    public String toString() {
        return "AsynchronousVideoCompositionRequest{renderContext=" + this.renderContext + ", compositionTime=" + this.compositionTime + ", videoCompositionInstruction=" + this.videoCompositionInstruction + ", sampleBuffers=" + this.sampleBuffers + '}';
    }
}
