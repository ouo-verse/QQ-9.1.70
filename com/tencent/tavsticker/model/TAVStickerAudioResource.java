package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTime;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerAudioResource extends TAVStickerResource {
    private CMTime audioStartTime;

    public TAVStickerAudioResource(TAVResourceType tAVResourceType, String str, ByteBuffer byteBuffer, CMTime cMTime) {
        super(tAVResourceType, str, byteBuffer);
        CMTime cMTime2 = CMTime.CMTimeZero;
        this.audioStartTime = cMTime;
    }

    public CMTime getAudioStartTime() {
        return this.audioStartTime;
    }
}
