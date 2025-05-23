package org.light;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AudioAsset implements Parcelable {
    public static final Parcelable.Creator<AudioAsset> CREATOR = new Parcelable.Creator<AudioAsset>() { // from class: org.light.AudioAsset.1
        @Override // android.os.Parcelable.Creator
        public AudioAsset createFromParcel(Parcel parcel) {
            return new AudioAsset(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AudioAsset[] newArray(int i3) {
            return new AudioAsset[i3];
        }
    };
    public long duration;
    HashMap<String, long[]> events;
    public long fadeInDuration;
    public long fadeOutDuration;
    public int loopCount;
    public String musicID;
    public String path;
    public long startOffset;
    public float volume;

    public AudioAsset(String str, long j3, long j16, float f16, String str2, long j17, long j18, HashMap<String, long[]> hashMap, int i3) {
        HashMap<String, long[]> hashMap2 = new HashMap<>();
        this.events = hashMap2;
        this.loopCount = 1;
        this.musicID = str;
        this.fadeInDuration = j3;
        this.fadeOutDuration = j16;
        this.volume = f16;
        this.path = str2;
        this.startOffset = j17;
        this.duration = j18;
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        this.loopCount = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.musicID);
        parcel.writeLong(this.fadeInDuration);
        parcel.writeLong(this.fadeOutDuration);
        parcel.writeFloat(this.volume);
        parcel.writeString(this.path);
        parcel.writeLong(this.startOffset);
        parcel.writeLong(this.duration);
        parcel.writeSerializable(this.events);
        parcel.writeInt(this.loopCount);
    }

    protected AudioAsset(Parcel parcel) {
        this.events = new HashMap<>();
        this.loopCount = 1;
        this.musicID = parcel.readString();
        this.fadeInDuration = parcel.readLong();
        this.fadeOutDuration = parcel.readLong();
        this.volume = parcel.readFloat();
        this.path = parcel.readString();
        this.startOffset = parcel.readLong();
        this.duration = parcel.readLong();
        this.events = (HashMap) parcel.readSerializable();
        this.loopCount = parcel.readInt();
    }
}
