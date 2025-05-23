package com.tencent.tav.decoder;

import androidx.annotation.NonNull;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CacheSampleBuffer extends CMSampleBuffer {
    private VideoTexture texture;

    public CacheSampleBuffer(@NonNull CMSampleState cMSampleState) {
        super(cMSampleState);
    }

    public VideoTexture getTexture() {
        return this.texture;
    }

    public void setTexture(VideoTexture videoTexture) {
        this.texture = videoTexture;
    }

    public CacheSampleBuffer(@NonNull CMSampleState cMSampleState, TextureInfo textureInfo) {
        super(cMSampleState, textureInfo);
    }

    public CacheSampleBuffer(@NonNull CMSampleState cMSampleState, TextureInfo textureInfo, boolean z16) {
        super(cMSampleState, textureInfo, z16);
    }

    public CacheSampleBuffer(@NonNull CMSampleState cMSampleState, ByteBuffer byteBuffer) {
        super(cMSampleState, byteBuffer);
    }

    public CacheSampleBuffer(@NonNull CMSampleState cMSampleState, ByteBuffer byteBuffer, boolean z16) {
        super(cMSampleState, byteBuffer, z16);
    }

    public CacheSampleBuffer(CMTime cMTime) {
        super(cMTime);
    }

    public CacheSampleBuffer(CMTime cMTime, TextureInfo textureInfo) {
        super(cMTime, textureInfo);
    }

    public CacheSampleBuffer(CMTime cMTime, TextureInfo textureInfo, boolean z16) {
        super(cMTime, textureInfo, z16);
    }

    public CacheSampleBuffer(CMTime cMTime, ByteBuffer byteBuffer) {
        super(cMTime, byteBuffer);
    }

    public CacheSampleBuffer(CMTime cMTime, ByteBuffer byteBuffer, boolean z16) {
        super(cMTime, byteBuffer, z16);
    }
}
