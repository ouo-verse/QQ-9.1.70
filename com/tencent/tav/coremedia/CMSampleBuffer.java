package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CMSampleBuffer {
    private ByteBuffer sampleByteBuffer;

    @NonNull
    private final CMSampleState state;
    private TextureInfo texture;

    public CMSampleBuffer(@NonNull CMSampleState cMSampleState) {
        Utils.checkNotNull(cMSampleState);
        this.state = cMSampleState;
        cMSampleState.setNewFrame(false);
        this.texture = null;
        this.sampleByteBuffer = null;
    }

    public ByteBuffer getSampleByteBuffer() {
        return this.sampleByteBuffer;
    }

    @NonNull
    public CMSampleState getState() {
        return this.state;
    }

    public TextureInfo getTextureInfo() {
        return this.texture;
    }

    @NonNull
    public CMTime getTime() {
        return this.state.getTime();
    }

    public boolean isNewFrame() {
        return this.state.isNewFrame();
    }

    public void setNewFrame(boolean z16) {
        this.state.setNewFrame(z16);
    }

    public void setSampleByteBuffer(ByteBuffer byteBuffer) {
        this.sampleByteBuffer = byteBuffer;
    }

    public String toString() {
        return "CMSampleBuffer{, state=" + this.state + ", texture=" + this.texture + ", sampleByteBuffer=" + this.sampleByteBuffer + '}';
    }

    public CMSampleBuffer(@NonNull CMSampleState cMSampleState, TextureInfo textureInfo) {
        Utils.checkNotNull(cMSampleState);
        this.state = cMSampleState;
        this.texture = textureInfo;
        this.sampleByteBuffer = null;
    }

    public CMSampleBuffer(@NonNull CMSampleState cMSampleState, TextureInfo textureInfo, boolean z16) {
        Utils.checkNotNull(cMSampleState);
        this.state = cMSampleState;
        cMSampleState.setNewFrame(z16);
        this.texture = textureInfo;
        this.sampleByteBuffer = null;
    }

    public CMSampleBuffer(@NonNull CMSampleState cMSampleState, ByteBuffer byteBuffer) {
        Utils.checkNotNull(cMSampleState);
        this.state = cMSampleState;
        this.sampleByteBuffer = byteBuffer;
        this.texture = null;
    }

    public CMSampleBuffer(@NonNull CMSampleState cMSampleState, ByteBuffer byteBuffer, boolean z16) {
        Utils.checkNotNull(cMSampleState);
        this.state = cMSampleState;
        cMSampleState.setNewFrame(z16);
        this.sampleByteBuffer = byteBuffer;
        this.texture = null;
    }

    public CMSampleBuffer(CMTime cMTime) {
        this(new CMSampleState(cMTime));
    }

    public CMSampleBuffer(CMTime cMTime, TextureInfo textureInfo) {
        this(new CMSampleState(cMTime), textureInfo);
    }

    public CMSampleBuffer(CMTime cMTime, TextureInfo textureInfo, boolean z16) {
        this(new CMSampleState(cMTime), textureInfo, z16);
    }

    public CMSampleBuffer(CMTime cMTime, ByteBuffer byteBuffer) {
        this(new CMSampleState(cMTime), byteBuffer);
    }

    public CMSampleBuffer(CMTime cMTime, ByteBuffer byteBuffer, boolean z16) {
        this(new CMSampleState(cMTime), byteBuffer, z16);
    }
}
