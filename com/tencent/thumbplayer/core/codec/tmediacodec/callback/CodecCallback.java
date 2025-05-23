package com.tencent.thumbplayer.core.codec.tmediacodec.callback;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface CodecCallback {
    void onCreate(Boolean bool);

    void onRealRelease();

    void onReuseCodecAPIException(String str, Throwable th5);

    void onStarted(Boolean bool, String str);

    void onTransToKeepPool();

    void onTransToRunningPool();
}
