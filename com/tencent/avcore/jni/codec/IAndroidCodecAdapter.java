package com.tencent.avcore.jni.codec;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IAndroidCodecAdapter {
    AndroidCodecBase createDecCodec(String str);

    AndroidCodecBase createEncCodec(String str);

    boolean isSupportAsyncAPI();

    boolean isSupportHWDecLowLatency();

    boolean isSupportHWEncCBR();
}
