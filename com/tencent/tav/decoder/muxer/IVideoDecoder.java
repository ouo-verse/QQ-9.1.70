package com.tencent.tav.decoder.muxer;

import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IVideoDecoder {
    boolean prepare(String str);

    CMSampleState readSample(CMTime cMTime);

    void release();

    void seekTo(CMTime cMTime, boolean z16);

    boolean start(@Nullable CMTimeRange cMTimeRange);

    void stop();
}
