package com.tencent.tav.decoder.muxer;

import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMSampleBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IVideoEncoder {
    boolean prepare(ExportConfig exportConfig);

    void release();

    void setMediaMuxer(IMediaMuxer iMediaMuxer);

    boolean start();

    void stop();

    boolean writeSample(CMSampleBuffer cMSampleBuffer, boolean z16);
}
