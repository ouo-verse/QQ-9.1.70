package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes29.dex */
public class AudioPlaceHolder implements Parcelable {
    public static final Parcelable.Creator<AudioPlaceHolder> CREATOR = new Parcelable.Creator<AudioPlaceHolder>() { // from class: org.light.AudioPlaceHolder.1
        @Override // android.os.Parcelable.Creator
        public AudioPlaceHolder createFromParcel(Parcel parcel) {
            return new AudioPlaceHolder(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AudioPlaceHolder[] newArray(int i3) {
            return new AudioPlaceHolder[i3];
        }
    };
    public long duration;
    public long fadeInDuration;
    public long fadeOutDuration;
    public String key;
    public int loopCount;
    public String musicID;
    public String originLyricsPath;
    public String path;
    public long startOffset;
    public String translatedLyricsPath;
    public float volume;

    public AudioPlaceHolder(String str, String str2, String str3, String str4, long j3, long j16, float f16, String str5, long j17, long j18, int i3) {
        this.key = str;
        this.musicID = str2;
        this.originLyricsPath = str3;
        this.translatedLyricsPath = str4;
        this.fadeInDuration = j3;
        this.fadeOutDuration = j16;
        this.volume = f16;
        this.path = str5;
        this.startOffset = j17;
        this.duration = j18;
        this.loopCount = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.key);
        parcel.writeString(this.musicID);
        parcel.writeString(this.originLyricsPath);
        parcel.writeString(this.translatedLyricsPath);
        parcel.writeLong(this.fadeInDuration);
        parcel.writeLong(this.fadeOutDuration);
        parcel.writeFloat(this.volume);
        parcel.writeString(this.path);
        parcel.writeLong(this.startOffset);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.loopCount);
    }

    protected AudioPlaceHolder(Parcel parcel) {
        this.loopCount = 1;
        this.key = parcel.readString();
        this.musicID = parcel.readString();
        this.originLyricsPath = parcel.readString();
        this.translatedLyricsPath = parcel.readString();
        this.fadeInDuration = parcel.readLong();
        this.fadeOutDuration = parcel.readLong();
        this.volume = parcel.readFloat();
        this.path = parcel.readString();
        this.startOffset = parcel.readLong();
        this.duration = parcel.readLong();
        this.loopCount = parcel.readInt();
    }
}
