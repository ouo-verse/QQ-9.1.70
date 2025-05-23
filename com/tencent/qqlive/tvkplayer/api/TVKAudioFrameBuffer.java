package com.tencent.qqlive.tvkplayer.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAudioFrameBuffer {
    public static final int EVENT_FLAG_EOS = 1;
    public static final int EVENT_FLAG_FLUSH = 2;
    private long mChannelLayout;
    private int mChannels;
    private byte[][] mData;
    private int[] mDataSize;
    private int mEventFlag;
    private int mFormat;
    private int mNbSamples;
    private long mPtsMs;
    private int mSampleRate;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface ChannelLayout {
        public static final long CH_LAYOUT_MONO = 4;
        public static final long CH_LAYOUT_STEREO = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface SampleFormat {
        public static final int SAMPLE_FORMAT_DBL = 4;
        public static final int SAMPLE_FORMAT_DBLP = 9;
        public static final int SAMPLE_FORMAT_FLT = 3;
        public static final int SAMPLE_FORMAT_FLTP = 8;
        public static final int SAMPLE_FORMAT_S16 = 1;
        public static final int SAMPLE_FORMAT_S16P = 6;
        public static final int SAMPLE_FORMAT_S32 = 2;
        public static final int SAMPLE_FORMAT_S32P = 7;
        public static final int SAMPLE_FORMAT_S64 = 10;
        public static final int SAMPLE_FORMAT_S64P = 11;
        public static final int SAMPLE_FORMAT_U8 = 0;
        public static final int SAMPLE_FORMAT_U8P = 5;
        public static final int SAMPLE_FORMAT_UNKNOWN = -1;
    }

    public long getChannelLayout() {
        return this.mChannelLayout;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public byte[][] getData() {
        return this.mData;
    }

    public int[] getDataSize() {
        return this.mDataSize;
    }

    public int getEventFlag() {
        return this.mEventFlag;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public int getNbSamples() {
        return this.mNbSamples;
    }

    public long getPtsMs() {
        return this.mPtsMs;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public void setChannelLayout(long j3) {
        this.mChannelLayout = j3;
    }

    public void setChannels(int i3) {
        this.mChannels = i3;
    }

    public void setData(byte[][] bArr) {
        this.mData = bArr;
    }

    public void setDataSize(int[] iArr) {
        this.mDataSize = iArr;
    }

    public void setEventFlag(int i3) {
        this.mEventFlag = i3;
    }

    public void setFormat(int i3) {
        this.mFormat = i3;
    }

    public void setNbSamples(int i3) {
        this.mNbSamples = i3;
    }

    public void setPtsMs(long j3) {
        this.mPtsMs = j3;
    }

    public void setSampleRate(int i3) {
        this.mSampleRate = i3;
    }
}
