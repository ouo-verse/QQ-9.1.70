package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AudioOutputConfig implements Parcelable {
    public static final Parcelable.Creator<AudioOutputConfig> CREATOR = new Parcelable.Creator<AudioOutputConfig>() { // from class: org.light.AudioOutputConfig.1
        @Override // android.os.Parcelable.Creator
        public AudioOutputConfig createFromParcel(Parcel parcel) {
            return new AudioOutputConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AudioOutputConfig[] newArray(int i3) {
            return new AudioOutputConfig[i3];
        }
    };
    public int channels;
    public int sampleCount;
    public int sampleRate;

    public AudioOutputConfig() {
        this.sampleRate = 44100;
        this.sampleCount = 1024;
        this.channels = 2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.sampleCount);
        parcel.writeInt(this.channels);
    }

    protected AudioOutputConfig(Parcel parcel) {
        this.sampleRate = 44100;
        this.sampleCount = 1024;
        this.channels = 2;
        this.sampleRate = parcel.readInt();
        this.sampleCount = parcel.readInt();
        this.channels = parcel.readInt();
    }
}
