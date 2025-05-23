package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.decoder;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface b {
    long a();

    c c();

    int e(byte[] bArr, int i3);

    int f();

    long getDurationMs();

    int open(@NonNull String str);

    void release();

    void seekTo(long j3);
}
