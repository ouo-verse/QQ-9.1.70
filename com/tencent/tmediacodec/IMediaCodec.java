package com.tencent.tmediacodec;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IMediaCodec {
    @TargetApi(26)
    void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, int i3, @Nullable MediaDescrambler mediaDescrambler);

    void configure(@NonNull MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i3);

    void release();

    @TargetApi(21)
    void releaseOutputBuffer(int i3, long j3);

    void releaseOutputBuffer(int i3, boolean z16);

    void reset();

    void setParameters(@Nullable Bundle bundle);

    void start();

    void stop();
}
