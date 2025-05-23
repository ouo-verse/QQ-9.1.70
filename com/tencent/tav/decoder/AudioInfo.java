package com.tencent.tav.decoder;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AudioInfo implements Cloneable {
    public int channelCount;
    public int pcmEncoding;
    public int sampleCount;
    public int sampleRate;

    public AudioInfo() {
        this.sampleRate = 44100;
        this.channelCount = 1;
        this.pcmEncoding = 2;
        this.sampleCount = 2048;
    }

    public String toString() {
        return "AudioInfo{sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", pcmEncoding=" + this.pcmEncoding + ", sampleCount=" + this.sampleCount + '}';
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AudioInfo m262clone() {
        return new AudioInfo(this.sampleRate, this.channelCount, this.pcmEncoding, this.sampleCount);
    }

    public AudioInfo(int i3, int i16, int i17) {
        this.sampleCount = 2048;
        this.sampleRate = i3;
        this.channelCount = i16;
        this.pcmEncoding = i17;
    }

    public AudioInfo(int i3, int i16, int i17, int i18) {
        this.sampleRate = i3;
        this.channelCount = i16;
        this.pcmEncoding = i17;
        this.sampleCount = i18;
    }
}
