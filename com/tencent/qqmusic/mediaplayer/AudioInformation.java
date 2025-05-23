package com.tencent.qqmusic.mediaplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqmusic.mediaplayer.AudioFormat;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AudioInformation implements Parcelable {
    public static final int CBR = 1;
    public static final int CORRECT = 1;
    public static final Parcelable.Creator<AudioInformation> CREATOR = new Parcelable.Creator<AudioInformation>() { // from class: com.tencent.qqmusic.mediaplayer.AudioInformation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioInformation createFromParcel(Parcel parcel) {
            return new AudioInformation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioInformation[] newArray(int i3) {
            return new AudioInformation[i3];
        }
    };
    public static final int INCORRECT = 2;
    public static final int VBR_VBRI = 3;
    public static final int VBR_XING = 2;
    private int bitrate;
    private int channels;
    private int mAudioTypeValue;
    private long sampleRate;
    private long duration = 0;
    private int bitDept = 0;
    private long mPlaySample = 0;
    private int isCbr = 0;
    private int durationIsCorrect = 2;

    public AudioInformation() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean durationIsCorrect() {
        if (this.durationIsCorrect == 1) {
            return true;
        }
        return false;
    }

    public AudioFormat.AudioType getAudioType() {
        return AudioFormat.getAudioType(this.mAudioTypeValue);
    }

    public int getBitDepth() {
        return this.bitDept;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getChannels() {
        return this.channels;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getPlaySample() {
        if (this.mPlaySample == 0) {
            this.mPlaySample = this.sampleRate;
        }
        return this.mPlaySample;
    }

    public long getSampleRate() {
        return this.sampleRate;
    }

    public int getVbrType() {
        return this.isCbr;
    }

    public boolean isCbr() {
        if (this.isCbr == 1) {
            return true;
        }
        return false;
    }

    public boolean isVbr() {
        int i3 = this.isCbr;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    public void readFromParcel(Parcel parcel) {
        this.sampleRate = parcel.readLong();
        this.channels = parcel.readInt();
        this.duration = parcel.readLong();
        this.bitrate = parcel.readInt();
        this.bitDept = parcel.readInt();
        this.mAudioTypeValue = parcel.readInt();
        this.mPlaySample = parcel.readLong();
        this.isCbr = parcel.readInt();
        this.durationIsCorrect = parcel.readInt();
    }

    public void setAudioType(AudioFormat.AudioType audioType) {
        this.mAudioTypeValue = audioType.getValue();
    }

    public void setBitDept(int i3) {
        this.bitDept = i3;
        if (i3 >= 3) {
            this.bitDept = 3;
        }
    }

    public void setBitrate(int i3) {
        this.bitrate = i3;
    }

    public void setCbr(int i3) {
        this.isCbr = i3;
    }

    public void setChannels(int i3) {
        this.channels = i3;
    }

    public void setDuration(long j3) {
        this.duration = j3;
    }

    public void setPlaySample(long j3) {
        this.mPlaySample = j3;
    }

    public void setSampleRate(long j3) {
        this.sampleRate = j3;
    }

    public String toString() {
        return "[ sampleRate = " + this.sampleRate + ",channels = " + this.channels + ",bitrate = " + this.bitrate + ",bitDept = " + this.bitDept + ",isCbr = " + this.isCbr + ",durationIsCorrect = " + this.durationIsCorrect + ",duration = " + this.duration + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.sampleRate);
        parcel.writeInt(this.channels);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.bitDept);
        parcel.writeInt(this.mAudioTypeValue);
        parcel.writeLong(this.mPlaySample);
        parcel.writeInt(this.isCbr);
        parcel.writeInt(this.durationIsCorrect);
    }

    public AudioInformation(Parcel parcel) {
        readFromParcel(parcel);
    }
}
