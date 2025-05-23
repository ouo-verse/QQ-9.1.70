package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IDecoder;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IVideoDecoder extends IDecoder {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Params extends IDecoder.Params {
        public CGSize outputSize;
        public Surface outputSurface;
        public VideoTexture videoTexture;
    }

    TextureInfo getTextureInfo();

    boolean isLastFrameValid();

    Surface outputSurface();

    void release(boolean z16);

    void seekTo(CMTime cMTime, boolean z16);
}
