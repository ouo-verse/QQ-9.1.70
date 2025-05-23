package com.tencent.mobileqq.shortvideo.pkvideo;

import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;

/* loaded from: classes18.dex */
public class PKManager {
    HWVideoDecoder leftDecoder;
    HWVideoDecoder rightDecoder;

    public PKManager(HWVideoDecoder hWVideoDecoder, HWVideoDecoder hWVideoDecoder2) {
        this.leftDecoder = hWVideoDecoder;
        hWVideoDecoder.setPKManager(this);
        if (hWVideoDecoder2 != null) {
            this.rightDecoder = hWVideoDecoder2;
            hWVideoDecoder2.setPKManager(this);
        }
    }

    public long getSyncDecodeTimeUs() {
        HWVideoDecoder hWVideoDecoder = this.rightDecoder;
        if (hWVideoDecoder == null) {
            return this.leftDecoder.getProgress();
        }
        return Math.min(hWVideoDecoder.getProgress(), this.leftDecoder.getProgress());
    }
}
