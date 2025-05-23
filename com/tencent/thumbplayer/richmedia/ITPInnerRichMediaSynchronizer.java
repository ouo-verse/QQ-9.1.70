package com.tencent.thumbplayer.richmedia;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaData;

/* loaded from: classes26.dex */
public interface ITPInnerRichMediaSynchronizer extends ITPRichMediaSynchronizer {

    /* loaded from: classes26.dex */
    public interface ITPInnerRichMediaSynchronizerListener {
        long onGetCurrentPositionMs(ITPInnerRichMediaSynchronizer iTPInnerRichMediaSynchronizer);
    }

    @Nullable
    TPRichMediaData getRichMediaDataAtPositionMs(long j3, int[] iArr);

    void seek(long j3) throws IllegalStateException, IllegalArgumentException;

    void setInnerListener(ITPInnerRichMediaSynchronizerListener iTPInnerRichMediaSynchronizerListener);

    void setPlaybackRate(float f16) throws IllegalStateException, IllegalArgumentException;
}
