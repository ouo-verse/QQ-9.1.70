package com.qq.wx.voice.embedqqegg.recognizer;

/* compiled from: P */
/* loaded from: classes3.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    byte[] f40941a;

    /* renamed from: b, reason: collision with root package name */
    InnerAudioState f40942b;

    public b(byte[] bArr, InnerAudioState innerAudioState) {
        this.f40941a = null;
        this.f40942b = InnerAudioState.stop;
        this.f40941a = bArr != null ? (byte[]) bArr.clone() : null;
        this.f40942b = innerAudioState;
    }
}
