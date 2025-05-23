package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = new MediaCodecSelector() { // from class: com.google.android.exoplayer2.mediacodec.MediaCodecSelector.1
        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
        public MediaCodecInfo getDecoderInfo(String str, boolean z16, boolean z17) throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getDecoderInfo(str, z16, z17);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
        public MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getPassthroughDecoderInfo();
        }
    };

    MediaCodecInfo getDecoderInfo(String str, boolean z16, boolean z17) throws MediaCodecUtil.DecoderQueryException;

    MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException;
}
