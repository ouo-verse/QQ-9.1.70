package com.qq.wx.voice.recognizer;

/* compiled from: P */
/* loaded from: classes3.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    byte[] f41036a;

    /* renamed from: b, reason: collision with root package name */
    InnerAudioState f41037b;

    /* renamed from: c, reason: collision with root package name */
    int f41038c = 16000;

    public a(byte[] bArr, InnerAudioState innerAudioState) {
        this.f41036a = null;
        this.f41037b = InnerAudioState.stop;
        this.f41036a = bArr != null ? (byte[]) bArr.clone() : null;
        this.f41037b = innerAudioState;
    }
}
