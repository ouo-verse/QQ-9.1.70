package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes29.dex */
public class ClipPlaceHolder implements Parcelable {
    public static final Parcelable.Creator<ClipPlaceHolder> CREATOR = new Parcelable.Creator<ClipPlaceHolder>() { // from class: org.light.ClipPlaceHolder.1
        @Override // android.os.Parcelable.Creator
        public ClipPlaceHolder createFromParcel(Parcel parcel) {
            return new ClipPlaceHolder(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ClipPlaceHolder[] newArray(int i3) {
            return new ClipPlaceHolder[i3];
        }
    };
    public long contentDuration;
    public int fillMode;
    public int height;
    public float volume;
    public int width;

    public ClipPlaceHolder(long j3, int i3, int i16, int i17, float f16) {
        this.contentDuration = j3;
        this.fillMode = i3;
        this.width = i16;
        this.height = i17;
        this.volume = f16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.contentDuration);
        parcel.writeInt(this.fillMode);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.volume);
    }

    protected ClipPlaceHolder(Parcel parcel) {
        this.volume = 1.0f;
        this.contentDuration = parcel.readLong();
        this.fillMode = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.volume = parcel.readFloat();
    }
}
